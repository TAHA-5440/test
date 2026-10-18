from pathlib import Path
import sys,struct,json
sys.path.insert(0,str(Path(__file__).resolve().parent))
from native_crypto_emulation import NativeCryptoImage
probe=json.loads(Path('recovery-data/diagnostics/asset-master-probe.json').read_text())
assert probe['native_master_fingerprint_matches'], 'Root key must validate first'
n=NativeCryptoImage()
for fn in struct.unpack_from('<5Q',n.raw,0xa4e10):n.call(fn)
root=n.SCRATCH;out=root+128;info=root+256;test=root+512
n.write(root,Path('recovery-data/diagnostics/asset-master.private.bin').read_bytes())
fragment=Path('recovery-data/diagnostics/java-key-fragment.private.bin').read_bytes()
fragment_ptr=n.alloc(len(fragment));n.write(fragment_ptr,fragment)
assert n.call(0xa07b0,root,fragment_ptr,len(fragment),root)==0
steps=[
    (0xad614,0x873552bc11e8ff0e,'module-1'),
    (0xad611,0xf9a939c6fcae9717,'module-2'),
    (0xad621,0xe196de1bc97ab57a,'module-3'),
    (None,0xbf7af9a0e99cdb51,'module-4'),
    (0xad625,0x2baa788a8b14d435,'module-5'),
    (0xad612,0xe5cada586d49689a,'asset-module'),
]
trace=[]
for flag,domain,name in steps:
    enabled=flag is None or bool(n.read(flag,1)[0]&1)
    trace.append({'module':name,'enabled':enabled})
    if not enabled:continue
    n.write(info,struct.pack('<Q',domain))
    result=n.call(0xa0840,root,out,info,8)
    assert result==0
    Path('recovery-data/diagnostics/'+name+'.subkey.private.bin').write_bytes(n.read(out,32))
    if name=='asset-module':
        n.call(0xa0750,out,0,0,test,36)
        material=n.read(test,36)
        tag=struct.unpack('<I',material[32:])[0]
        print('Native asset-module build-tag validation:',hex(tag),tag==0xdbb10f25)
        assert tag==0xdbb10f25,'Do not use an unverified asset key'
        key=material[:32]
        Path('recovery-data/diagnostics/asset-key.private.bin').write_bytes(key)
Path('recovery-data/diagnostics/asset-module-schedule.json').write_text(json.dumps({'root_fingerprint_verified':True,'modules':trace,'asset_tag_verified':True,'key_disclosed':False},indent=2)+'\n')
