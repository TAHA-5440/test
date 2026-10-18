from pathlib import Path
import ctypes,hashlib,json,sqlite3,struct,zlib
from Crypto.Cipher import ChaCha20

lib=ctypes.CDLL(str(Path('recovery-data/tools/chacha_codec.so').resolve()))
fn=lib.recovery_chacha_xor
fn.argtypes=[ctypes.c_void_p,ctypes.c_void_p,ctypes.c_size_t,ctypes.c_void_p,ctypes.c_void_p,ctypes.c_uint32,ctypes.c_uint]
fn.restype=ctypes.c_int

def xor(data,key,nonce,counter=0,rounds=8):
    output=ctypes.create_string_buffer(len(data))
    assert fn(output,data,len(data),key,nonce,counter,rounds)==0
    return output.raw

# Verify the implementation against an independent standard ChaCha20 and
# the exact 8-round block observed in the isolated app-native routine.
testkey=bytes(range(32));testnonce=bytes(range(12));testdata=bytes(range(256))*3
control=ChaCha20.new(key=testkey,nonce=testnonce);control.seek(64)
assert xor(testdata,testkey,testnonce,1,20)==control.encrypt(testdata)
key=Path('recovery-data/diagnostics/asset-key.private.bin').read_bytes()
summary=[]
for name in ('eanatomy.db','eanatomy_images.db'):
    src=Path('google_drive',name)
    with src.open('rb') as f:header=f.read(20)
    a,b,c,d=struct.unpack_from('<4I',header)
    kind=a^c;tag=b^d
    assert tag==0xdbb10f25 and kind in (0x64787073,0x64787064)
    nonce=struct.pack('<III',tag,a,b)
    stream=Path('recovery-data/diagnostics/'+name+'.native-stream.private.bin').read_bytes()
    assert xor(bytes(64),key,nonce)==stream
    destdir=Path('recovery-data/recovered');destdir.mkdir(parents=True,exist_ok=True)
    if kind==0x64787073:
        dest=destdir/'eanatomy.outer-decoded.db'
        if dest.exists():raise FileExistsError(dest)
        counter=0
        with src.open('rb') as f,dest.open('xb') as out:
            f.seek(16)
            while data:=f.read(1024*1024):
                out.write(xor(data,key,nonce,counter))
                counter+=(len(data)+63)//64
        print('Decoded outer main-database wrapper:',dest.stat().st_size,'bytes')
    else:
        expected_size=struct.unpack_from('<I',header,16)[0]
        assert expected_size<=64*1024*1024
        data=src.read_bytes()[20:]
        compressed=xor(data,key,nonce)
        decoder=zlib.decompressobj(-15)
        plain=decoder.decompress(compressed,expected_size+1)
        assert len(plain)==expected_size and decoder.eof and not decoder.unused_data and not decoder.unconsumed_tail
        dest=destdir/'eanatomy_images.recovered.db'
        with dest.open('xb') as out:out.write(plain)
        print('Decoded/decompressed image database:',len(plain),'bytes','SQLite header:',plain.startswith(b'SQLite format 3\0'))
    record={'input':name,'input_sha256':hashlib.sha256(src.read_bytes()).hexdigest(),'output':dest.name,'bytes':dest.stat().st_size,'sha256':hashlib.sha256(dest.read_bytes()).hexdigest(),'native_cipher_control_matched':True,'chacha_rounds':8}
    try:
        db=sqlite3.connect(dest.resolve().as_uri()+'?mode=ro&immutable=1',uri=True)
        db.execute('PRAGMA trusted_schema=OFF')
        record['sqlite_integrity_check']=[r[0] for r in db.execute('PRAGMA integrity_check')]
        record['tables']=[r[0] for r in db.execute("SELECT name FROM sqlite_schema WHERE type='table'")]
        print('Integrity:',record['sqlite_integrity_check'],'Tables:',record['tables'])
        db.close()
    except sqlite3.DatabaseError as e:
        record['sqlite_error']=str(e)
        print('SQLite status:',str(e))
    summary.append(record)
Path('recovery-data/diagnostics/outer-database-recovery.json').write_text(json.dumps(summary,indent=2)+'\n')
