from pathlib import Path
import sys,struct,json,hashlib,zipfile
sys.path.insert(0,str(Path(__file__).resolve().parent))
from native_crypto_emulation import NativeCryptoImage
from unicorn import UC_HOOK_CODE
from unicorn.x86_const import UC_X86_REG_RDI

n=NativeCryptoImage()
for fn in struct.unpack_from('<5Q',n.raw,0xa4e10):n.call(fn)
# The successful native startup inspection (0x1c0e4) updates one otherwise
# unused byte of the derivation salt before the observed HMAC block. Reproduce
# that instruction's data-state effect in the isolated working image, not in
# any supplied binary, and require the native fingerprint/build-tag checks.
n.uc.emu_start(0x1c0e4,0x1c0eb,count=1)
def failure(uc,address,size,data):
    raise RuntimeError('Native integrity/format error reported: '+hex(uc.reg_read(UC_X86_REG_RDI)))
n.uc.hook_add(UC_HOOK_CODE,failure,None,0x87200,0x87200)
master=n.SCRATCH+0x100
n.call(0xa0700,0xad6a0,32,0xad610,64,master)
print('Initial native root-key HMAC derivation completed.')
flags=n.read(0xad610,64)
results={'first_mix_required':bool(flags[0]&1),'second_mix_skipped':bool(flags[16]&1)}
if flags[0]&1:
    apk=Path('google_drive/split_config.arm64_v8a.apk').read_bytes()
    assert hashlib.sha256(apk).hexdigest()=='f757dd12dd5e9b1906bd77b2114f02501a2797efcc19e5e2a6c4e3bfe04abb35'
    end=apk.rfind(b'PK\x05\x06')
    cd=struct.unpack_from('<I',apk,end+16)[0]
    assert apk[cd-16:cd]==b'APK Sig Block 42'
    size=struct.unpack_from('<Q',apk,cd-24)[0]
    start=cd-size-8
    assert struct.unpack_from('<Q',apk,start)[0]==size
    signed_block=apk[start+8:cd]
    ptr=n.alloc(len(signed_block));n.write(ptr,signed_block)
    kinds=[];offset=0
    while offset<len(signed_block)-24:
        length=struct.unpack_from('<Q',signed_block,offset)[0]
        kind=struct.unpack_from('<I',signed_block,offset+8)[0]
        kinds.append(kind);offset+=8+length
    print('Real split APK signing-block IDs:',[hex(x) for x in kinds])
    # The v2 compatibility path does not need Android SDK state. The real
    # v2/v3 signer certificates were separately checked to be identical.
    selected=0x7109871a
    assert selected in kinds
    before=n.read(master,32)
    ok=n.call(0x50b10,master,ptr,size,selected)
    assert ok&255, 'Native signer parser did not accept the supplied signing block'
    results['native_signer_binding_success']=True
    results['native_v2_signer_mix_changed_key']=n.read(master,32)!=before
    print('Native v2 signer parser accepted the actual signing block; key mix applied:',n.read(master,32)!=before)
if not flags[16]&1:
    count=struct.unpack('<I',n.read(0xad654,4))[0]
    assert 1<=count<=50
    with zipfile.ZipFile('google_drive/base_no_db.zip') as archive:
        for index in range(1,count+1):
            name='classes.dex' if index==1 else f'classes{index}.dex'
            prefix=archive.read('base_no_db/'+name)[:1024]
            ptr=n.alloc(len(prefix));n.write(ptr,prefix)
            n.call(0xa07b0,master,ptr,len(prefix),master)
    results['actual_dex_prefixes_bound']=count
    print('Native key mix applied to actual DEX prefixes:',count)
# Validate the literal filename and the native code-hash guard as well.
filename=n.SCRATCH+0x500
n.call(0x77bb0,filename,0x5622,12)
print('Native DEX-binding filename:',n.read(filename,12).split(b'\0')[0].decode(errors='replace'))
hash_context=n.SCRATCH+0x600
n.write(hash_context,bytes(16))
current=n.call(0x2e950,0x12fc0,0xa0b30-0x12fc0,hash_context)
expected_hash=struct.unpack('<Q',n.read(0xae928,8))[0]
print('Native code-hash guard matches:',current==expected_hash)
assert current==expected_hash, 'Native code-hash guard failed; do not bypass it'
# Run native image-integrity/key-unsealing routine, never suppress errors.
n.call(0x9eb60,master)
results['native_image_key_unsealing_completed']=True
print('Native image-integrity/unsealing routine completed without an error report.')
# Validate the library\'s own four-byte key fingerprint.
info=n.SCRATCH+0x200;test=n.SCRATCH+0x300
n.write(info,struct.pack('<Q',0x91a4fb076b659459))
n.call(0xa0750,master,info,8,test,4)
expected=n.read(0xad650,4);actual=n.read(test,4)
results['native_master_fingerprint_matches']=actual==expected
print('Native master-key fingerprint matches:',actual==expected)

assert results['native_master_fingerprint_matches'], 'Native root-material fingerprint mismatch'
Path('recovery-data/diagnostics/asset-master.private.bin').write_bytes(n.read(master,32))
Path('recovery-data/diagnostics/asset-master-probe.json').write_text(json.dumps(results,indent=2)+'\n')
