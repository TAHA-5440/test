from pathlib import Path
import struct,json,hmac,hashlib
from unicorn import Uc,UC_ARCH_X86,UC_MODE_64,UC_HOOK_CODE,UC_HOOK_INSN
from unicorn.x86_const import *

class NativeCryptoImage:
    STACK=0x2000000
    HEAP=0x3000000
    SCRATCH=0x8000000
    STOP=0x9000000
    def __init__(self):
        self.uc=Uc(UC_ARCH_X86,UC_MODE_64)
        self.raw=Path('recovery-data/app/native/x86_64/libdexprotector.unpacked.memory.bin').read_bytes()
        self.uc.mem_map(0,0x100000)
        self.uc.mem_write(0,self.raw)
        self.uc.mem_map(self.STACK,0x200000)
        self.uc.mem_map(self.HEAP,0x4000000)
        self.uc.mem_map(self.SCRATCH,0x100000)
        self.uc.mem_map(self.STOP,0x1000)
        self.heap=self.HEAP
        self.allocations=[]
        self.calls=[]
        # Base-zero RELR addends are already valid. Resolve the one absolute
        # imported function-pointer relocation to its intercepted PLT stub.
        imports=json.loads(Path('recovery-data/diagnostics/unpacked-import-relocations.json').read_text())
        target,info,addend=struct.unpack_from('<QQq',self.raw,0x680)
        assert (info&0xffffffff)==1
        index=next(i for i,r in enumerate(imports) if r['symbol_index']==info>>32)
        self.uc.mem_write(target,struct.pack('<Q',0xa0c70+16*index+addend))
        # Reproduce the outer loader's metadata cleanup before constructors:
        # 0x1cc2 clears dynsym through dynstr, 0x1d68 clears each RELA,
        # and 0x1eae clears RELR words. This is the canonical post-loader
        # image that the native image-integrity routine actually hashes.
        for offset,length in ((0x200,0x67e-0x200),(0x680,0x18),(0x698,0x130),(0x7c8,0x270)):
            self.uc.mem_write(offset,bytes(length))
        self.uc.hook_add(UC_HOOK_INSN,self.deny_syscall,None,1,0,UC_X86_INS_SYSCALL)
        # PLT entries are sequential in this verified image.
        for index,record in enumerate(imports):
            address=0xa0c70+16*index
            self.uc.hook_add(UC_HOOK_CODE,self.import_call,record['name'],address,address)
    def read(self,p,n):return bytes(self.uc.mem_read(p,n))
    def write(self,p,b):self.uc.mem_write(p,b)
    def alloc(self,n):
        assert 0<=n<=16*1024*1024,n
        p=self.heap;self.heap+=(max(n,1)+15)&~15
        assert self.heap<self.HEAP+0x4000000
        self.allocations.append((p,n));return p
    def deny_syscall(self,uc,_):
        raise RuntimeError('Android/syscall execution is disabled; syscall '+str(uc.reg_read(UC_X86_REG_RAX)))
    def import_call(self,uc,address,size,name):
        a=uc.reg_read(UC_X86_REG_RDI);b=uc.reg_read(UC_X86_REG_RSI);c=uc.reg_read(UC_X86_REG_RDX)
        self.calls.append(name)
        if name=='malloc':value=self.alloc(a)
        elif name=='calloc':
            value=self.alloc(a*b)
            self.write(value,bytes(a*b))
        elif name=='free':value=0
        elif name in ('memcpy','memmove'):
            assert c<=16*1024*1024
            self.write(a,self.read(b,c));value=a
        elif name=='memset':
            assert c<=16*1024*1024
            self.write(a,bytes([b&255])*c);value=a
        else:raise RuntimeError('Unexpected external import in isolated routine: '+name)
        sp=uc.reg_read(UC_X86_REG_RSP)
        ret=struct.unpack('<Q',self.read(sp,8))[0]
        uc.reg_write(UC_X86_REG_RAX,value)
        uc.reg_write(UC_X86_REG_RSP,sp+8)
        uc.reg_write(UC_X86_REG_RIP,ret)
    def call(self,address,*args,count=100_000_000,timeout=10_000_000):
        regs=(UC_X86_REG_RDI,UC_X86_REG_RSI,UC_X86_REG_RDX,UC_X86_REG_RCX,UC_X86_REG_R8,UC_X86_REG_R9)
        sp=self.STACK+0x1ffff8
        self.write(sp,struct.pack('<Q',self.STOP))
        self.uc.reg_write(UC_X86_REG_RSP,sp)
        for r,a in zip(regs,args):self.uc.reg_write(r,a)
        try:self.uc.emu_start(address,self.STOP,timeout=timeout,count=count)
        except Exception:
            print('Stopped in isolated routine',hex(address),'at',hex(self.uc.reg_read(UC_X86_REG_RIP)))
            raise
        if self.uc.reg_read(UC_X86_REG_RIP)!=self.STOP:
            raise RuntimeError('Instruction budget reached at '+hex(self.uc.reg_read(UC_X86_REG_RIP)))
        return self.uc.reg_read(UC_X86_REG_RAX)

if __name__=='__main__':
    n=NativeCryptoImage()
    for fn in struct.unpack_from('<5Q',n.raw,0xa4e10):
        n.call(fn)
        print('Completed isolated static initializer:',hex(fn))
    key=n.SCRATCH;data=key+256;out=key+512
    n.write(key,bytes(range(32)));n.write(data,bytes(range(64)))
    r=n.call(0xa0700,key,32,data,64,out)
    result=n.read(out,64)
    algos=[algo for algo in ('sha256','sha384','sha512','sha3_256','sha3_512') if result[:hashlib.new(algo).digest_size]==hmac.new(bytes(range(32)),bytes(range(64)),algo).digest()]
    print('Native HMAC control matches:',algos,'return',r)
    Path('recovery-data/diagnostics/native-initialized.memory.bin').write_bytes(n.read(0,len(n.raw)))
    Path('recovery-data/diagnostics/native-initialized-allocations.private.json').write_text(json.dumps([{'address':p,'bytes':n.read(p,size).hex()} for p,size in n.allocations],indent=2)+'\n')
    Path('recovery-data/diagnostics/native-crypto-control.json').write_text(json.dumps({'initializers_completed':True,'native_hmac_matches':algos,'allowed_imports_used':sorted(set(n.calls)),'android_syscalls_executed':False},indent=2)+'\n')
