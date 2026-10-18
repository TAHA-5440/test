"""Verify release-specific inputs and extract only the three native libraries."""
from pathlib import Path, PurePosixPath
import hashlib
import json
import shutil
import zipfile
from elftools.elf.elffile import ELFFile

EXPECTED = {
    "base_no_db.zip": "9994f9075c68a4b39c2261039118d9efd35bf7f0cdc9d6cfa16743607470bfee",
    "eanatomy.db": "c8e361a5f1ecc54b51fad61552f43760bf8b83a91b8961f6c4b8c40fe44a103d",
    "eanatomy_images.db": "81705036812b64032786a2b8fb6c0db6c39fbe36c386a91a6c661f4b721d4fb3",
    "native_libs_x86_64_full.zip": "6c8c6ce6a30e395af68b847bfe800b26fd0aa15161bf5ea20c1913cdbd66762e",
    "split_config.arm64_v8a.apk": "f757dd12dd5e9b1906bd77b2114f02501a2797efcc19e5e2a6c4e3bfe04abb35",
}


def verify_inputs(directory):
    for name, expected in EXPECTED.items():
        path = directory / name
        with path.open("rb") as source:
            actual = hashlib.file_digest(source, "sha256").hexdigest()
        if actual != expected:
            raise ValueError(f"Input does not match the inspected release: {name}")


def main():
    verify_inputs(Path("google_drive"))
    Path("recovery-data/diagnostics").mkdir(parents=True, exist_ok=True)
    names = {"libalice.so", "libdexprotector.so", "libsqlcipher.so"}
    found = set()
    records = []
    with zipfile.ZipFile("google_drive/native_libs_x86_64_full.zip") as archive:
        for member in archive.infolist():
            relative = PurePosixPath(member.filename)
            if relative.is_absolute() or ".." in relative.parts:
                raise ValueError("Unsafe archive member")
            if relative.name not in names:
                continue
            if relative.name in found or member.file_size > 16 * 1024 * 1024:
                raise ValueError("Duplicate or oversized library")
            found.add(relative.name)
            destination = Path("recovery-data/app/native/x86_64", relative.name)
            destination.parent.mkdir(parents=True, exist_ok=True)
            with archive.open(member) as source, destination.open("xb") as output:
                shutil.copyfileobj(source, output)
            with destination.open("rb") as source:
                elf = ELFFile(source)
                if elf["e_machine"] != "EM_X86_64":
                    raise ValueError("Unexpected architecture")
            records.append({
                "name": relative.name,
                "bytes": destination.stat().st_size,
                "sha256": hashlib.sha256(destination.read_bytes()).hexdigest(),
            })
    if found != names:
        raise ValueError("Native pack is incomplete")
    Path("recovery-data/diagnostics/verified-inputs.json").write_text(
        json.dumps({"source_sha256": EXPECTED, "x86_64_libraries": records}, indent=2) + "\n"
    )
    print("All five inputs verified; extracted three x86-64 libraries without executing them.")


if __name__ == "__main__":
    main()
