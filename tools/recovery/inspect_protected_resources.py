from pathlib import Path
import sys,zipfile,json,struct,ctypes,zlib,hashlib
import lz4.block
import zstandard
from Crypto.Cipher import ChaCha20_Poly1305
sys.path.insert(0,str(Path(__file__).resolve().parent))
from native_crypto_emulation import NativeCryptoImage
n=NativeCryptoImage()
for fn in struct.unpack_from('<5Q',n.raw,0xa4e10):n.call(fn)
key=n.SCRATCH;out=key+128
with zipfile.ZipFile('google_drive/base_no_db.zip') as z:assets=z.read('base_no_db/assets/assets.dat')
resources=json.loads(Path('recovery-data/diagnostics/protected-resource-directory.json').read_text())['entries']
lib=ctypes.CDLL(str(Path('recovery-data/tools/chacha_codec.so').resolve()))
fn=lib.recovery_chacha_xor
fn.argtypes=[ctypes.c_void_p,ctypes.c_void_p,ctypes.c_size_t,ctypes.c_void_p,ctypes.c_void_p,ctypes.c_uint32,ctypes.c_uint];fn.restype=ctypes.c_int
records=[]
for module,typ,length in (('module-1',5,44),('module-2',4,44),('module-3',1,66),('module-4',10,44)):
    path=Path('recovery-data/diagnostics',module+'.subkey.private.bin')
    if not path.exists():continue
    n.write(key,path.read_bytes())
    assert n.call(0xa0750,key,0,0,out,length)==0
    material=n.read(out,length)
    r=next(r for r in resources if r['type']==typ)
    data=assets[r['offset']:r['offset']+r['bytes']]
    if typ==5:
        output=ctypes.create_string_buffer(len(data))
        assert fn(output,data,len(data),material[:32],material[32:44],0,8)==0
        plain=output.raw;authenticated=False
    else:
        cipher=ChaCha20_Poly1305.new(key=material[:32],nonce=material[32:44])
        plain=cipher.decrypt_and_verify(data[:-16],data[-16:]);authenticated=True
    dest=Path(f'recovery-data/app/resource-{typ}.decoded.bin')
    dest.write_bytes(plain)
    record={'type':typ,'module':module,'decoded_bytes':len(plain),'authenticated':authenticated,'sha256':hashlib.sha256(plain).hexdigest()}
    if typ in (4,5):
        expected=struct.unpack_from('<I',plain)[0]
        assert expected<128*1024*1024
        if plain[4:8]==b'\x28\xb5\x2f\xfd':
            expanded=zstandard.ZstdDecompressor().decompress(plain[4:],max_output_size=expected)
            assert len(expanded)==expected
        elif typ==5:
            decoder=zlib.decompressobj(-15)
            expanded=decoder.decompress(plain[4:],expected+1)
            assert len(expanded)==expected and decoder.eof and not decoder.unused_data and not decoder.unconsumed_tail
        else:
            expanded=lz4.block.decompress(plain[4:],uncompressed_size=expected)
            assert len(expanded)==expected
        dest=Path(f'recovery-data/app/resource-{typ}.expanded.bin');dest.write_bytes(expanded)
        record['expanded_bytes']=len(expanded)
        record['expanded_magic']=expanded[:8].hex()
        record['expanded_sha256']=hashlib.sha256(expanded).hexdigest()
    records.append(record)
    print(record)
Path('recovery-data/diagnostics/decoded-resource-summary.json').write_text(json.dumps(records,indent=2)+'\n')
