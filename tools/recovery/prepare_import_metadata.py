"""Recover import metadata for bounded CPU emulation; no executable is produced."""
from pathlib import Path
import json
import struct

raw = Path("recovery-data/app/native/x86_64/libdexprotector.unpacked.memory.bin").read_bytes()
metadata = json.loads(Path("recovery-data/diagnostics/native-unpack-result.json").read_text())
dynamic = metadata["header_words"][4]
tags = {}
for offset in range(dynamic, min(len(raw), dynamic + 4096), 16):
    tag, value = struct.unpack_from("<QQ", raw, offset)
    if tag == 0:
        break
    tags[tag] = value
else:
    raise ValueError("Unterminated dynamic table")
strings = raw[tags[5]:tags[5] + tags[10]]
imports = []
for offset in range(tags[23], tags[23] + tags[2], 24):
    target, info, _ = struct.unpack_from("<QQq", raw, offset)
    index = info >> 32
    name_offset = struct.unpack_from("<I", raw, tags[6] + 24 * index)[0]
    name = strings[name_offset:].split(b"\0")[0].decode("ascii")
    imports.append({"got": target, "name": name, "symbol_index": index})
Path("recovery-data/diagnostics/unpacked-import-relocations.json").write_text(
    json.dumps(imports, indent=2) + "\n"
)
print("Recovered import metadata for isolated arithmetic routines.")
