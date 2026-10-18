"""Capture independent native cipher control blocks in a syscall-denying emulator."""
from pathlib import Path
import struct
from native_crypto_emulation import NativeCryptoImage

image = NativeCryptoImage()
for address in struct.unpack_from("<5Q", image.raw, 0xa4e10):
    image.call(address)
key = Path("recovery-data/diagnostics/asset-key.private.bin").read_bytes()
key_pointer = image.SCRATCH
nonce_pointer = key_pointer + 128
source = key_pointer + 256
output = key_pointer + 512
image.write(key_pointer, key)
image.write(source, bytes(64))
for name in ("eanatomy.db", "eanatomy_images.db"):
    with Path("google_drive", name).open("rb") as stream:
        a, b, c, d = struct.unpack("<4I", stream.read(16))
    image.write(nonce_pointer, struct.pack("<III", b ^ d, a, b))
    image.call(0x1e370, key_pointer, nonce_pointer, 0, 64, source, output)
    Path("recovery-data/diagnostics", name + ".native-stream.private.bin").write_bytes(
        image.read(output, 64)
    )
print("Captured two native cipher control blocks; no keys printed or host app library loaded.")
