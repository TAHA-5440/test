from pathlib import Path
import hashlib,json,runpy,struct
import lz4.block

ns=runpy.run_path(str(Path(__file__).with_name('unpack_stage_probe.py')))
ctr=ns['ctr']
key=struct.unpack('<8I',Path('recovery-data/diagnostics/unpack-key.private.bin').read_bytes())
source=Path('recovery-data/app/native/x86_64/libdexprotector.so')
blob=source.read_bytes()[0x40f8:]
nonce=struct.unpack('<I',blob[:4])[0]
plain=ctr(blob[4:],key,nonce)
header=struct.unpack('<9I',plain[:36])
assert header[0]<8*1024*1024 and header[7]==16384 and header[8]==4
image=bytearray(header[0]); cursor=36
segments=[]
for index in range(header[8]):
    h=struct.unpack('<6I',plain[cursor:cursor+24]); cursor+=24
    va,memsz,unpacked_len,flags,expected_checksum,packed_len=h
    assert va+memsz<=len(image) and unpacked_len<=memsz
    block=plain[cursor:cursor+packed_len]; cursor+=packed_len
    unpacked=lz4.block.decompress(block,uncompressed_size=unpacked_len)
    assert len(unpacked)==unpacked_len
    checksum=0
    for b in unpacked:
        checksum=(((checksum>>1)|((checksum&1)<<15))+b)&0xffff
    assert checksum==expected_checksum,(index,checksum,expected_checksum)
    image[va:va+len(unpacked)]=unpacked
    segments.append({'vaddr':va,'memsz':memsz,'unpacked_bytes':unpacked_len,'packed_bytes':packed_len,'flags':flags,'checksum_verified':True})
print('Recovered memory-image prefix:',repr(image[:16]))
print('All four decoded segment lengths and checksums verified. ELF header is not present; this is not a standalone library file.')
path=Path('recovery-data/app/native/x86_64/libdexprotector.unpacked.memory.bin')
path.write_bytes(image)
summary={'status':'unpacked_native_image_not_database','source_sha256':hashlib.sha256(source.read_bytes()).hexdigest(),'image_bytes':len(image),'image_sha256':hashlib.sha256(image).hexdigest(),'header_words':list(header),'segments':segments,'compressed_payload_bytes_consumed':cursor+4,'app_installed_or_launched':False,'android_syscalls_executed':False}
Path('recovery-data/diagnostics/native-unpack-result.json').write_text(json.dumps(summary,indent=2)+'\n')
print(json.dumps(summary,indent=2))
