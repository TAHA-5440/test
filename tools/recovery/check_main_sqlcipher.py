from pathlib import Path
import ctypes,json
import sqlcipher3._sqlite3 as engine
api=ctypes.CDLL(engine.__file__)
api.sqlite3_open_v2.argtypes=[ctypes.c_char_p,ctypes.POINTER(ctypes.c_void_p),ctypes.c_int,ctypes.c_char_p];api.sqlite3_open_v2.restype=ctypes.c_int
api.sqlite3_key.argtypes=[ctypes.c_void_p,ctypes.c_void_p,ctypes.c_int];api.sqlite3_key.restype=ctypes.c_int
api.sqlite3_exec.argtypes=[ctypes.c_void_p,ctypes.c_char_p,ctypes.c_void_p,ctypes.c_void_p,ctypes.c_void_p];api.sqlite3_exec.restype=ctypes.c_int
api.sqlite3_close.argtypes=[ctypes.c_void_p];api.sqlite3_close.restype=ctypes.c_int
sources=['asset-master.private.bin','asset-key.private.bin','java-key-fragment.private.bin']
sources += [p.name for p in sorted(Path('recovery-data/diagnostics').glob('*.subkey.private.bin'))]
records=[];hits=[]
path=Path('recovery-data/recovered/eanatomy.outer-decoded.db').resolve()
for name in sources:
    key=Path('recovery-data/diagnostics',name).read_bytes()
    if len(key)!=32:continue
    for compat in (4,3):
        for form in ('binary-passphrase','raw-key'):
            db=ctypes.c_void_p()
            assert api.sqlite3_open_v2((path.as_uri()+'?mode=ro&immutable=1').encode(),ctypes.byref(db),1|0x40,None)==0
            try:
                if form=='binary-passphrase':
                    assert api.sqlite3_key(db,key,len(key))==0
                else:
                    sql=('PRAGMA key = "x\''+key.hex()+'\'";').encode()
                    assert api.sqlite3_exec(db,sql,None,None,None)==0
                assert api.sqlite3_exec(db,f'PRAGMA cipher_compatibility={compat}; PRAGMA query_only=ON; PRAGMA trusted_schema=OFF;'.encode(),None,None,None)==0
                rc=api.sqlite3_exec(db,b'SELECT count(*) FROM sqlite_master;',None,None,None)
                r={'source_label':name,'compatibility':compat,'interpretation':form,'schema_read_ok':rc==0}
                records.append(r)
                if rc==0:hits.append(r)
            finally:api.sqlite3_close(db)
print('Read-only SQLCipher checks using artifact-derived material:',len(records),'valid database openings:',len(hits))
print('No password dictionary, remote login, source-file write, or application launch was performed.')
Path('recovery-data/diagnostics/main-sqlcipher-derived-key-checks.json').write_text(json.dumps({'candidate_source_count':len(sources),'checks':records,'valid_openings':hits,'database_recovered':bool(hits)},indent=2)+'\n')
