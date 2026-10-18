from pathlib import Path
import json,struct
from elftools.elf.elffile import ELFFile
from unicorn import Uc,UC_ARCH_X86,UC_MODE_64,UC_HOOK_INSN
from unicorn.x86_const import *

BASE=0x1000000
STACK=0x2000000
OUT=0x4000000
STOP=0x5000000
p=Path('recovery-data/app/native/x86_64/libdexprotector.so')
u=Uc(UC_ARCH_X86,UC_MODE_64)
u.mem_map(BASE,0x100000)
with p.open('rb') as f:
    e=ELFFile(f)
    for s in e.iter_segments():
        if s['p_type']=='PT_LOAD': u.mem_write(BASE+s['p_vaddr'],s.data())
u.mem_map(STACK,0x200000)
u.mem_map(OUT,0x10000)
u.mem_map(STOP,0x1000)
u.mem_write(OUT+0x1010,struct.pack('<Q',OUT+0x2000))
u.mem_write(OUT+0x2000,b'\0')
u.mem_write(STACK+0x1ffff8,struct.pack('<Q',STOP))
u.reg_write(UC_X86_REG_RSP,STACK+0x1ffff8)
u.reg_write(UC_X86_REG_RDI,OUT)
u.reg_write(UC_X86_REG_RSI,OUT+0x1000)
def deny_syscalls(uc,data):
    raise RuntimeError('Unexpected syscall in pure key-material routine')
u.hook_add(UC_HOOK_INSN,deny_syscalls,None,1,0,UC_X86_INS_SYSCALL)
u.emu_start(BASE+0xbe0,STOP,timeout=10_000_000,count=50_000_000)
if u.reg_read(UC_X86_REG_RIP)!=STOP:
    print('Stopped RIP:',hex(u.reg_read(UC_X86_REG_RIP)),'VM pc:',hex(u.reg_read(UC_X86_REG_R15)),'stack ptr:',hex(u.reg_read(UC_X86_REG_RSP)))
    raise RuntimeError('Emulation did not return within expanded instruction budget')
basekey=bytes(u.mem_read(OUT,32))
print('Isolated key-material arithmetic emulation completed without syscalls.')

MASK=0xffffffff
def block(a,b,key):
    for j in range(32):
        mix=((a<<6)^(a>>8))&MASK
        t=(b+a+key[(2*j)&6]+mix+2*j)&MASK
        v=(b+key[(2*j)&6]+key[(2*j+1)&7]+mix)&MASK
        a=(v+((t<<6)^(t>>8))+2*a+4*j+1)&MASK
        b=t
    return struct.pack('<II',a,b)
def ctr(data,key,nonce):
    out=bytearray()
    for i in range(0,len(data),8):
        stream=block((nonce+(i//8>>32))&MASK,(i//8)&MASK,key)
        out.extend(x^y for x,y in zip(data[i:i+8],stream))
    return bytes(out)
blob=p.read_bytes()[0x40f8:]
nonce=struct.unpack('<I',blob[:4])[0]
hits=[]
for opcode in range(256):
    key=bytes([basekey[0]^opcode])+basekey[1:]
    plain=ctr(blob[4:40],struct.unpack('<8I',key),nonce)
    h=struct.unpack('<9I',plain)
    if h[7] in (4096,16384,65536) and 0<h[8]<=4 and 0<h[0]<128*1024*1024:
        hits.append({'environment_byte':opcode,'header_words':list(h)})
        Path('recovery-data/diagnostics/unpack-key.private.bin').write_bytes(key)
        Path('recovery-data/diagnostics/packed-image-header.bin').write_bytes(plain)
print('Structurally valid packed-image header candidates:',json.dumps(hits))
Path('recovery-data/diagnostics/unpack-stage-probe.json').write_text(json.dumps({'syscalls':0,'key_disclosed':False,'candidates':hits},indent=2)+'\n')
