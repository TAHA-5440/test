from pathlib import Path
import sys,struct,zipfile,json
from loguru import logger
logger.remove()
from androguard.core.dex import DEX
sys.path.insert(0,str(Path(__file__).resolve().parent))
from native_crypto_emulation import NativeCryptoImage

with zipfile.ZipFile('google_drive/base_no_db.zip') as z: primary=DEX(z.read('base_no_db/classes.dex'))
helper=DEX(Path('recovery-data/app/key-helper.authenticated.dex').read_bytes())
main_method=next(m for c in primary.get_classes() if c.get_name()=='Lcom/imaios/application/ProtectedVetAnatomyGoogleApplication;' for m in c.get_methods() if m.get_name()=='a' and m.get_descriptor()=='([B)[B')
helper_method=next(m for c in helper.get_classes() for m in c.get_methods() if m.get_descriptor()=='([I)V')
n=NativeCryptoImage()
for fn in struct.unpack_from('<5Q',n.raw,0xa4e10):n.call(fn)
native_bytes=n.read(0xada40,32)
steps=0

def i32(x):
    x&=0xffffffff
    return x-0x100000000 if x&0x80000000 else x

def run(method,arg):
    global steps
    code=method.get_code();reg=[0]*code.get_registers_size();reg[-1]=arg
    table={};off=0
    for ins in method.get_instructions():table[off]=ins;off+=ins.get_length()
    pc=0;last=None
    while True:
        steps+=1
        assert steps<20000,'Pure DEX arithmetic budget exceeded'
        ins=table[pc];name=ins.get_name();ops=ins.get_operands();nxt=pc+ins.get_length()
        registers=[o[1] for o in ops if o[0]==0]
        if name.startswith('const'):
            reg[registers[0]]=i32(ops[1][1])
        elif name=='new-array':reg[registers[0]]=[0]*reg[registers[1]]
        elif name=='fill-array-data':
            payload=table[pc+ops[-1][1]*2]
            data=payload.get_data();arr=reg[registers[0]]
            assert len(data)>=len(arr)
            arr[:]=list(data[:len(arr)])
        elif name in ('aget-byte','aget'):
            value=reg[registers[1]][reg[registers[2]]]
            reg[registers[0]]=((value&255)-256 if value&128 else value&255) if name=='aget-byte' else i32(value)
        elif name in ('aput-byte','aput'):
            value=reg[registers[0]]
            reg[registers[1]][reg[registers[2]]]=value&255 if name=='aput-byte' else i32(value)
        elif name=='if-ge':
            if reg[registers[0]]>=reg[registers[1]]:nxt=pc+ops[-1][1]*2
        elif name=='goto':nxt=pc+ops[-1][1]*2
        elif name=='move':reg[registers[0]]=reg[registers[1]]
        elif name=='move-result-object':reg[registers[0]]=last
        elif name=='invoke-static':
            target=ops[-1][2]
            if target=='Lcom/imaios/application/ProtectedVetAnatomyGoogleApplication$r;->a()[B':
                assert not registers;last=list(native_bytes)
            elif target=='Lcom/imaios/application/ProtectedVetAnatomyGoogleApplication;->a([B)[B':
                last=run(main_method,reg[registers[0]])
            else:raise RuntimeError('No external/runtime calls allowed in arithmetic helper: '+str(target))
        elif name in ('and-int/lit16','add-int/lit8','shl-int/lit8','ushr-int/lit8'):
            d,s=registers;v=reg[s];literal=ops[-1][1]
            if name.startswith('and'):result=v&literal
            elif name.startswith('add'):result=v+literal
            elif name.startswith('shl'):result=v<<(literal&31)
            else:result=(v&0xffffffff)>>(literal&31)
            reg[d]=i32(result)
        elif name in ('or-int/2addr','xor-int/2addr','add-int/2addr'):
            d,s=registers
            if name.startswith('or'):result=reg[d]|reg[s]
            elif name.startswith('xor'):result=reg[d]^reg[s]
            else:result=reg[d]+reg[s]
            reg[d]=i32(result)
        elif name=='or-int':
            d,a,b=registers;reg[d]=i32(reg[a]|reg[b])
        elif name=='return-object':return reg[registers[0]]
        elif name=='return-void':return None
        elif name=='nop':pass
        else:raise RuntimeError('Unsupported operation in isolated arithmetic helper: '+name)
        pc=nxt

result=[0]*8
run(helper_method,result)
fragment=struct.pack('<8I',*(x&0xffffffff for x in result))
Path('recovery-data/diagnostics/java-key-fragment.private.bin').write_bytes(fragment)
Path('recovery-data/diagnostics/java-helper-evaluation.json').write_text(json.dumps({'helper_authenticated':True,'method_signature':'([I)V','instructions_interpreted':steps,'allowed_external_calls':['fixed native byte-array accessor','pure primary-DEX byte substitution'],'android_runtime_started':False,'key_bytes_disclosed':False},indent=2)+'\n')
print('Authenticated helper evaluated in bounded arithmetic interpreter; steps:',steps,'output words:',len(result),'no Android runtime or OS calls.')
