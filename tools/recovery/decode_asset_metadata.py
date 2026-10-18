from pathlib import Path
import sys,struct,json,zipfile,hashlib,zlib
sys.path.insert(0,str(Path(__file__).resolve().parent))
from native_crypto_emulation import NativeCryptoImage
from Crypto.Cipher import ChaCha20_Poly1305

n=NativeCryptoImage()
for fn in struct.unpack_from('<5Q',n.raw,0xa4e10):n.call(fn)
root=n.SCRATCH;info=root+128;out=root+256
probe=json.loads(Path('recovery-data/diagnostics/asset-master-probe.json').read_text())
assert probe['native_master_fingerprint_matches']
n.write(root,Path('recovery-data/diagnostics/asset-master.private.bin').read_bytes())
def derive(domain,length=44):
    n.write(info,struct.pack('<Q',domain))
    assert n.call(0xa0750,root,info,8,out,length)==0
    return n.read(out,length)
with zipfile.ZipFile('google_drive/base_no_db.zip') as z:assets=z.read('base_no_db/assets/assets.dat')
material=derive(0x5d4e7ccff0335568)
length=assets[-1]
assert 0<length<=255
cipher=ChaCha20_Poly1305.new(key=material[:32],nonce=material[32:44])
cipher.update(assets[-1:])
meta=cipher.decrypt_and_verify(assets[-17-length:-17],assets[-17:-1])
print('Protected resource-directory authentication: PASS; metadata bytes:',len(meta))
def uleb(buf,offset):
    value=0
    for shift in range(0,35,7):
        b=buf[offset];offset+=1;value|=(b&127)<<shift
        if not b&128:return value,offset
    raise ValueError('Invalid ULEB128')
count,cursor=uleb(meta,0);offset=0;entries=[]
for i in range(count):
    typ=meta[cursor];cursor+=1
    size,cursor=uleb(meta,cursor)
    entries.append({'type':typ,'offset':offset,'bytes':size})
    offset+=size
assert offset<=len(assets)-17-length
print('Resource entries:',entries)
Path('recovery-data/diagnostics/protected-resource-directory.json').write_text(json.dumps({'authenticated':True,'entries':entries},indent=2)+'\n')
r=next(x for x in entries if x['type']==9)
data=assets[r['offset']:r['offset']+r['bytes']]
material=derive(0x3045c9c1c2460b68)
cipher=ChaCha20_Poly1305.new(key=material[:32],nonce=material[32:44])
plain=cipher.decrypt_and_verify(data[:-16],data[-16:])
assert plain.startswith(b'dex\n')
assert hashlib.sha1(plain[32:]).digest()==plain[12:32]
assert zlib.adler32(plain[12:])&0xffffffff==struct.unpack_from('<I',plain,8)[0]
Path('recovery-data/app/key-helper.authenticated.dex').write_bytes(plain)
print('Key-helper DEX authenticated; SHA-1/Adler-32 both match; bytes:',len(plain))
