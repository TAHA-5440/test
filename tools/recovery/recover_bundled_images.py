"""Extract and validate real bundled image assets, not the downloaded scan series.

Original archive and key files are read only. No pictures are generated or
upscaled; overview.png is a labelled contact sheet of recovered preview files.
Only this repository's own C decoder is compiled/loaded into the host process.
"""
import argparse
import ctypes
import hashlib
import html
import io
import json
from pathlib import Path, PurePosixPath
import shutil
import struct
import subprocess
import tempfile
import textwrap
from urllib.parse import quote
import zipfile
import zlib

from PIL import Image, ImageDraw, ImageFont

ARCHIVE_SHA256 = "9994f9075c68a4b39c2261039118d9efd35bf7f0cdc9d6cfa16743607470bfee"
BUILD_TAG = 0xdbb10f25
GROUPS = {
    "icons": ("module-previews", "Bundled module previews — not full scan series"),
    "orientations": ("orientation-diagrams", "Anatomical orientation diagrams"),
    "cats": ("category-icons", "Category icons"),
}


class AssetDecoder:
    def __init__(self, library_path, key):
        if len(key) != 32:
            raise ValueError("Expected a 32-byte recovered asset key")
        self.key = key
        self.library = ctypes.CDLL(str(library_path))
        self.function = self.library.recovery_chacha_xor
        self.function.argtypes = [ctypes.c_void_p, ctypes.c_void_p, ctypes.c_size_t,
                                  ctypes.c_void_p, ctypes.c_void_p,
                                  ctypes.c_uint32, ctypes.c_uint]
        self.function.restype = ctypes.c_int

    def xor(self, data, nonce, counter=0):
        out = ctypes.create_string_buffer(len(data))
        if self.function(out, data, len(data), self.key, nonce, counter, 8) != 0:
            raise ValueError("Decoder rejected the input")
        return out.raw

    def decode(self, data):
        if data.startswith(b"\x89PNG\r\n\x1a\n"):
            plain, protected = data, False
        else:
            if len(data) < 16:
                raise ValueError("Truncated protected asset")
            a, b, c, d = struct.unpack_from("<4I", data)
            if b ^ d != BUILD_TAG:
                raise ValueError("Asset build tag does not match this release")
            kind = a ^ c
            offset = 16 if kind == 0x64787073 else 20
            if kind not in (0x64787073, 0x64787064) or len(data) < offset:
                raise ValueError("Unrecognized asset wrapper")
            plain = self.xor(data[offset:], struct.pack("<III", BUILD_TAG, a, b))
            if kind == 0x64787064:
                expected = struct.unpack_from("<I", data, 16)[0]
                if expected > 32 * 1024 * 1024:
                    raise ValueError("Image exceeds recovery size limit")
                stream = zlib.decompressobj(-15)
                plain = stream.decompress(plain, expected + 1)
                if (len(plain) != expected or not stream.eof or
                        stream.unused_data or stream.unconsumed_tail):
                    raise ValueError("Compressed image failed length/stream checks")
            protected = True
        # Validate both chunk checksums and actual pixel decompression.
        with Image.open(io.BytesIO(plain)) as image:
            if image.format != "PNG":
                raise ValueError("Expected an actual PNG, not a renamed payload")
            image.verify()
        with Image.open(io.BytesIO(plain)) as image:
            image.load()
            dimensions = image.size
        return plain, protected, dimensions


def compile_decoder(destination):
    compiler = shutil.which("cc")
    if compiler is None:
        raise RuntimeError("A C compiler is required")
    subprocess.run([
        compiler, "-O3", "-Wall", "-Wextra", "-Werror", "-std=c11", "-shared", "-fPIC",
        str(Path(__file__).with_name("chacha_codec.c")), "-o", str(destination),
    ], check=True, timeout=120)


def make_gallery(output, records):
    sections = []
    for group, title in GROUPS.values():
        images = [item for item in records if item["group"] == group]
        # The archive retains every density variant; show the largest one in
        # the orientation gallery rather than displaying duplicates twice.
        if group == "orientation-diagrams":
            best = {}
            for item in images:
                name = Path(item["file"]).name
                score = (item["width"] * item["height"], item["bytes"])
                previous = best.get(name)
                if previous is None or score > (previous["width"] * previous["height"], previous["bytes"]):
                    best[name] = item
            images = list(best.values())
        cards = []
        for item in sorted(images, key=lambda item: item["file"]):
            url = quote(item["file"], safe="/")
            label = html.escape(Path(item["file"]).stem)
            cards.append(
                f'<a class="card" href="{url}"><img loading="lazy" src="{url}" alt="{label}">'
                f'<span>{label}</span><small>{item["width"]} × {item["height"]} px</small></a>'
            )
        sections.append(f'<section><h2>{html.escape(title)}</h2><div class="grid">' + "".join(cards) + '</div></section>')
    document = '''<!doctype html><html lang="en"><meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Recovered bundled image assets</title>
<style>body{font:16px system-ui,sans-serif;background:#111827;color:#e5e7eb;margin:0;padding:28px}
main{max-width:1200px;margin:auto}h1{margin-bottom:8px}p{line-height:1.6}.notice{background:#253349;padding:16px;border-left:4px solid #fbbf24;border-radius:8px}
.grid{display:grid;grid-template-columns:repeat(auto-fill,minmax(180px,1fr));gap:16px}.card{display:flex;flex-direction:column;gap:8px;background:#1f2937;padding:14px;border-radius:10px;color:#f9fafb;text-decoration:none;overflow-wrap:anywhere}
.card img{width:100%;height:190px;object-fit:contain;background:#0b1220}.card small{color:#9ca3af}section{margin-top:32px}</style>
<main><h1>Recovered bundled image assets</h1>
<p class="notice"><strong>Partial image recovery.</strong> These are real PNG assets decoded from the supplied app archive. Module pictures are small previews, not the full-resolution CT/MRI image series. No pictures were generated or upscaled. Click a card for the original recovered PNG.</p>
<p>Open this file after extracting the ZIP. All images are local; no network, account, or external script is used. All density variants remain in the archive; the gallery shows the largest orientation variant.</p>
''' + "".join(sections) + '</main></html>'
    (output / "index.html").write_text(document, encoding="utf-8")


def make_overview(output, records):
    previews = sorted((item for item in records if item["group"] == "module-previews"),
                      key=lambda item: item["file"])
    if not previews:
        return
    columns, cell_width, cell_height, top = 5, 240, 235, 100
    rows = (len(previews) + columns - 1) // columns
    sheet = Image.new("RGB", (columns * cell_width, top + rows * cell_height), "#101827")
    draw = ImageDraw.Draw(sheet)
    font = ImageFont.load_default(size=15)
    draw.text((18, 18), "Actual recovered module previews — small originals, NOT full scan series", font=font, fill="white")
    draw.text((18, 48), f"{len(previews)} preview files from the supplied archive. Pictures were not generated or upscaled.", font=font, fill="#b9c4d5")
    for index, item in enumerate(previews):
        left, y = (index % columns) * cell_width, top + (index // columns) * cell_height
        with Image.open(output / item["file"]) as original:
            image = original.convert("RGBA")
            image.thumbnail((216, 174))
            sheet.paste(image, (left + (cell_width - image.width) // 2, y), image)
        label = Path(item["file"]).stem
        for line_index, line in enumerate(textwrap.wrap(label, 27)[:2]):
            draw.text((left + 10, y + 180 + line_index * 18), line, font=font, fill="white")
    sheet.save(output / "overview.png")


def recover(archive_path, key_path, output):
    with archive_path.open("rb") as source:
        digest = hashlib.file_digest(source, "sha256").hexdigest()
    if digest != ARCHIVE_SHA256:
        raise ValueError("Archive does not match the inspected release")
    zipped_output = output.with_name(output.name + ".recovered.zip")
    if output.exists() or zipped_output.exists():
        raise FileExistsError("Choose a fresh output path; nothing is overwritten")
    output.mkdir(parents=True, mode=0o700)
    records, errors = [], []
    with tempfile.TemporaryDirectory(prefix="image-recovery-codec-") as temporary:
        library = Path(temporary) / "own_decoder.so"
        compile_decoder(library)
        decoder = AssetDecoder(library, key_path.read_bytes())
        with zipfile.ZipFile(archive_path) as archive:
            for member in archive.infolist():
                source_path = PurePosixPath(member.filename)
                if source_path.is_absolute() or ".." in source_path.parts:
                    raise ValueError("Unsafe archive path")
                parts = source_path.parts
                if (len(parts) < 4 or parts[:2] != ("base_no_db", "assets") or
                        parts[2] not in GROUPS or source_path.suffix.lower() != ".png"):
                    continue
                try:
                    if member.file_size > 32 * 1024 * 1024:
                        raise ValueError("Oversized archive member")
                    data = archive.read(member)
                    plain, protected, (width, height) = decoder.decode(data)
                    group = GROUPS[parts[2]][0]
                    relative = Path(group, *parts[3:])
                    destination = output / relative
                    destination.parent.mkdir(parents=True, exist_ok=True)
                    with destination.open("xb") as stream:
                        stream.write(plain)
                    records.append({
                        "source": member.filename, "group": group,
                        "file": relative.as_posix(), "bytes": len(plain),
                        "width": width, "height": height, "protected_source": protected,
                        "sha256": hashlib.sha256(plain).hexdigest(),
                    })
                except (ValueError, OSError, zlib.error, struct.error, SyntaxError, EOFError, Image.DecompressionBombError) as error:
                    errors.append({"source": member.filename, "error": type(error).__name__ + ": " + str(error)})
    if not records:
        raise RuntimeError("No valid images recovered; do not deliver garbled or substitute pictures")
    counts = {group: sum(item["group"] == group for item in records) for group, _ in GROUPS.values()}
    manifest = {
        "status": "bundled_assets_only_full_scan_series_not_recovered",
        "source_archive_sha256": digest, "validated_images": len(records),
        "unique_image_hashes": len({item["sha256"] for item in records}),
        "groups": counts, "failed_images": errors, "images": records,
        "pixels_reencoded": False, "full_scan_series_recovered": False,
        "key_material_included": False,
    }
    (output / "manifest.json").write_text(json.dumps(manifest, indent=2) + "\n")
    (output / "README.txt").write_text(
        "RECOVERED BUNDLED IMAGE ASSETS — PARTIAL IMAGE RECOVERY\n\n"
        f"Validated PNG assets: {len(records)}\n"
        f"Small module previews: {counts['module-previews']}\n"
        f"Orientation diagrams (including density variants): {counts['orientation-diagrams']}\n"
        f"Category icons: {counts['category-icons']}\n\n"
        "The full-resolution downloaded CT/MRI/anatomy scan series has NOT been recovered.\n"
        "The recovered SQLite image database is an index and contains no image pixels.\n"
        "Every PNG here is a real asset from the provided ZIP. Each was checked for PNG\n"
        "chunk integrity and complete pixel decoding. Original decoded PNG bytes were\n"
        "preserved without re-encoding, upscaling, or watermark removal.\n\n"
        "Extract this ZIP and open index.html for an offline gallery. overview.png is\n"
        "only a labelled, downscaled contact sheet of the module-preview originals.\n"
        "Some diagrams have more than one density variant. manifest.json records the\n"
        "source paths, dimensions, hashes, and any failures. No keys are included.\n",
        encoding="utf-8",
    )
    make_gallery(output, records)
    make_overview(output, records)
    safe_files = [output / item["file"] for item in records]
    safe_files += [output / name for name in ("README.txt", "manifest.json", "index.html", "overview.png")]
    with zipfile.ZipFile(zipped_output, "x", compression=zipfile.ZIP_DEFLATED) as archive:
        for path in safe_files:
            if path.is_file():
                archive.write(path, (Path("bundled-images") / path.relative_to(output)).as_posix())
    zipped_output.chmod(0o600)
    with archive_path.open("rb") as source:
        if hashlib.file_digest(source, "sha256").hexdigest() != digest:
            raise RuntimeError("Source archive changed unexpectedly")
    print(json.dumps({"validated_images": len(records), "groups": counts, "failed_images": len(errors),
                      "zip": str(zipped_output), "zip_bytes": zipped_output.stat().st_size,
                      "full_scan_series_recovered": False}, indent=2))
    return 0 if not errors else 3


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--archive", type=Path, default=Path("google_drive/base_no_db.zip"))
    parser.add_argument("--key-file", type=Path, default=Path("recovery-data/diagnostics/asset-key.private.bin"))
    parser.add_argument("--output", type=Path, default=Path("recovery-data/recovered/bundled-images"))
    args = parser.parse_args()
    return recover(args.archive, args.key_file, args.output)


if __name__ == "__main__":
    raise SystemExit(main())
