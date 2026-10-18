#!/usr/bin/env python3
"""Read-only return/export workflow for the exact supplied Pharmapedia XAPK.

No app is executed, rebuilt, re-signed, or stripped of its original checks.
Server-side medicine records and a device-created database are not manufactured.
"""
import argparse
from collections import Counter
import csv
import hashlib
import html
import io
import json
import os
from pathlib import Path, PurePosixPath
import re
import shutil
import stat
import subprocess
import zipfile

from lxml import etree
from PIL import Image
from loguru import logger
from androguard.core.apk import APK
from androguard.core.axml import AXMLPrinter
from androguard.core.dex import DEX
from androguard.core.analysis.analysis import Analysis
from androguard.decompiler.decompiler import DecompilerDAD

EXPECTED_SHA256 = "6f9781939a3c8caf967aa7d0bbd9429c6f968af66140dcef0db1d426c2d1534c"
PACKAGE = "vet.pharmapedia.vetpharmapediapakistan"
APP_PREFIX = "Lvet/pharmapedia/"
MAX_MEMBER = 128 * 1024 * 1024
MAX_TOTAL = 256 * 1024 * 1024
RASTER_EXTENSIONS = {".png", ".webp", ".jpg", ".jpeg", ".gif", ".bmp"}


def sha256(path):
    with path.open("rb") as stream:
        return hashlib.file_digest(stream, "sha256").hexdigest()


def safe_relative(name):
    path = PurePosixPath(name)
    if path.is_absolute() or ".." in path.parts or "\\" in name or "\x00" in name or re.match(r"^[A-Za-z]:", name) or not path.parts:
        raise ValueError("Unsafe archive/output path")
    return Path(*path.parts)


def check_archive(archive):
    seen = set()
    total = 0
    for member in archive.infolist():
        safe_relative(member.filename)
        mode = member.external_attr >> 16
        if stat.S_ISLNK(mode):
            raise ValueError("Symlink archive entry rejected")
        if member.flag_bits & 1:
            raise ValueError("Password-encrypted archive member needs separate inspection")
        if member.file_size > MAX_MEMBER:
            raise ValueError("Archive member exceeds size limit")
        total += member.file_size
        if total > MAX_TOTAL:
            raise ValueError("Archive exceeds total extraction limit")
        if member.filename in seen:
            raise ValueError("Duplicate archive entry")
        seen.add(member.filename)
    if archive.testzip() is not None:
        raise ValueError("Archive CRC failure")


def spreadsheet_safe(value):
    text = str(value)
    if text.startswith(("\t", "\r", "\n")) or text.lstrip(" \t\r\n").startswith(("=", "+", "-", "@")):
        return "'" + text
    return text


def write_json(path, data):
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(json.dumps(data, indent=2, ensure_ascii=True) + "\n", encoding="utf-8")


def write_text(path, text):
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(text, encoding="utf-8", errors="backslashreplace")


def inspect_media(path, data):
    with Image.open(io.BytesIO(data)) as image:
        info = {"format": image.format, "width": image.width, "height": image.height,
                "frames": getattr(image, "n_frames", 1)}
        image.verify()
    if info["frames"] > 500:
        raise ValueError("Animation exceeds validation frame limit")
    with Image.open(io.BytesIO(data)) as image:
        for frame in range(info["frames"]):
            image.seek(frame)
            image.load()
    return info


def rea_observation(cli, artifact, operation, destination):
    result = subprocess.run([str(cli), operation, str(artifact), "--json"],
                            text=True, capture_output=True, timeout=120)
    destination.write_text(result.stdout, encoding="utf-8")
    if result.stderr:
        write_text(destination.with_suffix(".stderr.txt"), result.stderr)
    try:
        record = json.loads(result.stdout)
    except json.JSONDecodeError:
        record = {"code": "invalid_provider_output"}
    return {"operation": operation, "exit_code": result.returncode,
            "evidence_id": record.get("evidence_id"), "error_code": record.get("code"),
            "file": destination.name}


def csv_export(path, headers, rows, safe=False):
    path.parent.mkdir(parents=True, exist_ok=True)
    with path.open("x", encoding="utf-8-sig", newline="") as stream:
        writer = csv.writer(stream)
        writer.writerow(headers)
        for row in rows:
            writer.writerow([spreadsheet_safe(v) for v in row] if safe else row)


def render_viewer(output, summary, strings, media):
    from urllib.parse import quote
    visible = [(name, value) for name, value in strings
               if not re.search(r"(?:api[_-]?key|token|secret|password)", name, re.I)]
    table = "".join('<tr><td>' + html.escape(name) + '</td><td>' + html.escape(value) + '</td></tr>'
                    for name, value in visible)
    sorted_media = sorted(media, key=lambda item: ("flag_" in item["source"], -item["width"] * item["height"]))
    cards = []
    for item in sorted_media:
        url = quote(item["file"], safe="/")
        label = html.escape(Path(item["source"]).name)
        cards.append(f'<a class="card" href="{url}"><img loading="lazy" src="{url}" alt="{label}">'
                     f'<span>{label}</span><small>{item["width"]} × {item["height"]} · {item["format"]}</small></a>')
    apk_links = "".join(f'<li><a href="app-components/{quote(item["file"])}">{html.escape(item["file"])}</a></li>'
                        for item in summary["apk_components"])
    document = '''<!doctype html><html lang="en"><meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1"><title>Pharmapedia — returned package contents</title>
<style>body{margin:0;background:#f3f6fa;color:#172337;font:16px system-ui,sans-serif}main{max-width:1120px;margin:auto;padding:28px}header,section{background:white;border:1px solid #dce3eb;border-radius:14px;padding:22px;margin-bottom:22px}h1{margin:0 0 8px}p{line-height:1.6}.notice{background:#fff8df;border-left:4px solid #b17d00;padding:14px}.metrics{display:flex;flex-wrap:wrap;gap:12px}.metrics b{background:#e9f5f3;padding:12px;border-radius:9px}a{color:#14665f}input{padding:12px;width:calc(100% - 26px);font:inherit;border:1px solid #b7c4d1;border-radius:8px}table{width:100%;border-collapse:collapse;font-size:14px}td,th{text-align:left;vertical-align:top;border-bottom:1px solid #e4eaf0;padding:10px;overflow-wrap:anywhere}td:first-child{width:34%;font-family:monospace}.grid{display:grid;grid-template-columns:repeat(auto-fill,minmax(160px,1fr));gap:14px}.card{display:flex;flex-direction:column;gap:7px;border:1px solid #dce3eb;border-radius:9px;padding:12px;text-decoration:none;overflow-wrap:anywhere}.card img{width:100%;height:150px;object-fit:contain;background:#edf1f5}.card small{color:#68798b}.scroll{max-height:620px;overflow:auto}code{overflow-wrap:anywhere}</style>
<main><header><h1>Vet. Pharmapedia Pakistan</h1><p>Returned contents of the supplied 1.0.13 XAPK — offline package browser, not a replacement app.</p>
<p class="notice"><strong>No populated medicine database was bundled.</strong> The app code fetches medicine records from Firebase and creates/caches a Room database on a device. No remote records were downloaded or fabricated. App installation and backend availability were not tested.</p>
''' + f'<div class="metrics"><b>{len(summary["apk_components"])} original APK components</b><b>{len(media)} original media files</b><b>{len(strings)} default resource strings</b><b>{summary["java_approximations"]} Java approximations</b></div>' + '''</header>
<section><h2>Original app components</h2><p>Android 10+ and a device supporting the included armeabi-v7a split are required. Original signatures/checks remain. Read INSTALLATION.txt before using the APKs.</p><ul>''' + apk_links + '''</ul><p><a href="INSTALLATION.txt">Installation notes</a> · <a href="README_FIRST.txt">Contents and limitations</a> · <a href="exports/medicines-schema-only.sql">Medicine table schema — definition only</a></p></section>
<section><h2>Bundled pictures and graphics</h2><p>These are original app media, mostly interface graphics, icons, flags, and the included animation/contact artwork—not a recovered product-photo catalogue. No generated preview is included.</p><div class="grid">''' + "".join(cards) + '''</div></section>
<section><h2>Readable default resource strings</h2><p>These are interface/resource text, not medicine records. Technical entries with credential-like names are hidden in this browser; the original resource data remains in the supplied APK components and XML exports.</p><input id="search" aria-label="Filter resource strings" placeholder="Filter resource names or text"><div class="scroll"><table><thead><tr><th>Resource name</th><th>Original value</th></tr></thead><tbody id="strings">''' + table + '''</tbody></table></div></section>
<section><h2>Developer/reference exports</h2><p>See exports/ for decoded manifests/layout XML, locale string XML, a spreadsheet-safe CSV, medicine model definitions, class index, 43 app-class bytecode listings, and Java approximations from classes3.dex. These are not the original Kotlin/Android Studio project or a verified rebuild. Original bytecode is preserved in the APKs and raw extraction.</p><p>See evidence/ for REA observations and provenance.json for file hashes. No license/account checks were removed. No clinical information or pricing was independently validated.</p></section></main>
<script>document.getElementById('search').addEventListener('input',function(){const q=this.value.toLowerCase();document.querySelectorAll('#strings tr').forEach(function(row){row.hidden=!row.textContent.toLowerCase().includes(q);});});</script></html>'''
    write_text(output / "index.html", document)


def recover(input_path, output, rea_cli):
    if sha256(input_path) != EXPECTED_SHA256:
        raise ValueError("Input hash differs from the inspected XAPK")
    returned_zip = output.with_name(output.name + ".zip")
    if output.exists() or returned_zip.exists():
        raise FileExistsError("Choose a fresh output directory; no files are overwritten")
    os.umask(0o077)
    output.mkdir(parents=True, mode=0o700)
    evidence = output / "evidence"
    evidence.mkdir()
    raw_records, media, xml_errors, apk_records = [], [], [], []
    sqlite_files = []
    component_paths = []
    with zipfile.ZipFile(input_path) as outer:
        check_archive(outer)
        for member in outer.infolist():
            if member.is_dir():
                continue
            relative = safe_relative(member.filename)
            target = output / ("app-components" if relative.suffix.lower() == ".apk" else "xapk-metadata") / relative
            target.parent.mkdir(parents=True, exist_ok=True)
            data = outer.read(member)
            with target.open("xb") as stream:
                stream.write(data)
            raw_records.append({"file": target.relative_to(output).as_posix(), "source": member.filename,
                                "source_container": "input XAPK", "bytes": len(data),
                                "sha256": hashlib.sha256(data).hexdigest()})
            if relative.suffix.lower() == ".apk":
                component_paths.append(target)
            elif relative.suffix.lower() in RASTER_EXTENSIONS:
                info = inspect_media(target, data)
                media.append({**info, "file": target.relative_to(output).as_posix(),
                              "source": member.filename, "source_apk": None,
                              "sha256": hashlib.sha256(data).hexdigest(), "bytes": len(data)})
    default_strings = []
    source_classes, class_rows, schemas, models = [], [], set(), []
    java_count = 0
    network_proof = []
    locales_count = 0
    base_path = None
    for component in sorted(component_paths):
        app = APK(str(component))
        root = app.get_android_manifest_xml()
        split = root.get("split")
        if app.get_package() != PACKAGE or app.get_androidversion_code() != "13":
            raise ValueError("APK package/version mismatch")
        apk_records.append({"file": component.name, "bytes": component.stat().st_size,
                            "sha256": sha256(component), "package": app.get_package(),
                            "version_code": app.get_androidversion_code(), "split": split,
                            "signer_certificate_sha256": [hashlib.sha256(c).hexdigest()
                                                          for c in app.get_certificates_der_v2()]})
        write_text(output / "exports" / "manifests" / (component.stem + ".xml"),
                   etree.tostring(root, encoding="unicode", pretty_print=True))
        with zipfile.ZipFile(component) as archive:
            check_archive(archive)
            for member in archive.infolist():
                if member.is_dir():
                    continue
                relative = safe_relative(member.filename)
                target = output / "original-apk-contents" / component.stem / relative
                target.parent.mkdir(parents=True, exist_ok=True)
                data = archive.read(member)
                with target.open("xb") as stream:
                    stream.write(data)
                raw_records.append({"file": target.relative_to(output).as_posix(), "source": member.filename,
                                    "source_container": component.name, "bytes": len(data),
                                    "sha256": hashlib.sha256(data).hexdigest()})
                if data.startswith(b"SQLite format 3\0"):
                    sqlite_files.append({"apk": component.name, "file": member.filename})
                if relative.suffix.lower() in RASTER_EXTENSIONS:
                    try:
                        info = inspect_media(target, data)
                        media.append({**info, "file": target.relative_to(output).as_posix(),
                                      "source": member.filename, "source_apk": component.name,
                                      "sha256": hashlib.sha256(data).hexdigest(), "bytes": len(data)})
                    except (OSError, ValueError, SyntaxError, EOFError) as error:
                        raise ValueError("Bundled media validation failed: " + member.filename) from error
                if relative.suffix.lower() == ".xml":
                    try:
                        if data.lstrip().startswith(b"<"):
                            decoded = data.decode("utf-8")
                        else:
                            decoded = AXMLPrinter(data).get_xml().decode("utf-8")
                        write_text(output / "exports" / "decoded-xml" / component.stem / relative, decoded)
                    except Exception as error:
                        xml_errors.append({"apk": component.name, "file": member.filename,
                                           "status": "original_binary_preserved", "error": type(error).__name__})
            if split is None:
                base_path = component
                arsc = app.get_android_resources()
                for locale in arsc.get_locales(PACKAGE):
                    label = "default" if locale == "\x00\x00" else re.sub(r"[^A-Za-z0-9_-]", "_", locale)
                    xml = arsc.get_string_resources(PACKAGE, locale)
                    target = output / "exports" / "strings" / (label + ".xml")
                    target.parent.mkdir(parents=True, exist_ok=True)
                    target.write_bytes(xml)
                    locales_count += 1
                    if label == "default":
                        parsed = etree.fromstring(xml, parser=etree.XMLParser(resolve_entities=False, no_network=True))
                        default_strings = [(item.get("name", ""), "".join(item.itertext()))
                                           for item in parsed.findall("string")]
                for dex_name in (name for name in archive.namelist() if re.fullmatch(r"classes\d*\.dex", name)):
                    dex = DEX(archive.read(dex_name))
                    for text in dex.get_strings():
                        if re.match(r"CREATE\s+TABLE\b", text, re.I) and "medicines_table" in text:
                            schemas.add(text)
                    analysis = None
                    if dex_name == "classes3.dex":
                        analysis = Analysis(dex)
                        analysis.create_xref()
                        dex.set_decompiler(DecompilerDAD(dex, analysis))
                    for cls in dex.get_classes():
                        methods = list(cls.get_methods())
                        name = cls.get_name()
                        class_rows.append((dex_name, name, len(methods),
                                           sum(bool(m.get_access_flags() & 0x100) for m in methods),
                                           name.startswith(APP_PREFIX)))
                        if "/database/models/" in name and name.startswith(APP_PREFIX):
                            models.append({"class": name, "fields": [
                                {"name": field.get_name(), "descriptor": field.get_descriptor()}
                                for field in cls.get_fields()]})
                        if name.startswith(APP_PREFIX):
                            lines = ["CLASS " + name]
                            for method in methods:
                                lines.append("METHOD " + method.get_name() + method.get_descriptor())
                                offset = 0
                                for instruction in method.get_instructions():
                                    text = instruction.get_output()
                                    lines.append(f"{offset:04x} {instruction.get_name()} {text}")
                                    offset += instruction.get_length()
                                    if instruction.get_name().startswith("invoke") and any(pattern in text for pattern in (
                                            "Lcom/google/firebase/firestore/", "Lcom/google/firebase/database/", "Landroidx/room/")):
                                        network_proof.append({"class": name, "method": method.get_name(),
                                                              "signature": method.get_descriptor(), "call": text})
                            write_text(output / "exports" / "app-bytecode" / (name[1:-1] + ".txt"), "\n".join(lines) + "\n")
                        if analysis is not None:
                            entry = {"class": name, "dex": dex_name}
                            try:
                                text = cls.get_source()
                                if not text.strip():
                                    raise ValueError("Empty decompiler output")
                                relative = safe_relative(name[1:-1] + ".java")
                                write_text(output / "exports" / "java-approximations" / relative,
                                           "// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.\n" + text)
                                java_count += 1
                                entry["status"] = "java_approximation"
                            except Exception as error:
                                entry.update({"status": "original_bytecode_preserved", "error": type(error).__name__})
                            source_classes.append(entry)
    if base_path is None or len(apk_records) != 3:
        raise ValueError("Expected a base APK plus two supplied splits")
    certs = {tuple(record["signer_certificate_sha256"]) for record in apk_records}
    if len(certs) != 1:
        raise ValueError("APK signer-certificate identities differ")
    csv_export(output / "exports" / "resource-strings-default.csv", ("resource_name", "value"), default_strings, safe=True)
    csv_export(output / "exports" / "class-index.csv", ("dex", "class_name", "method_count", "native_method_count", "app_namespace"), class_rows)
    write_json(output / "exports" / "medicine-model-definitions.json", {"definitions_only_no_records": True, "models": models})
    write_json(output / "exports" / "code-data-source-observations.json", {"vendor_network_contacted": False, "calls": network_proof})
    write_json(output / "exports" / "decompiler-status.json", {"engine": "Androguard DAD 4.1.4", "not_original_project": True, "classes": source_classes})
    write_text(output / "exports" / "medicines-schema-only.sql",
               "-- Schema definition extracted from application bytecode.\n-- NO medicine records or populated database were recovered from this XAPK.\n\n" +
               "\n\n".join(statement.rstrip(";") + ";" for statement in sorted(schemas)) + "\n")
    rea_results = [
        rea_observation(rea_cli, input_path, "inspect-artifact", evidence / "xapk.rea-artifact.json"),
        rea_observation(rea_cli, base_path, "inspect-artifact", evidence / "base.rea-artifact.json"),
        rea_observation(rea_cli, base_path, "inspect-android-package", evidence / "base.rea-android.json"),
    ]
    summary = {
        "status": "bundled_contents_returned_not_a_runtime_repair",
        "input_sha256": EXPECTED_SHA256, "input_bytes": input_path.stat().st_size,
        "package": PACKAGE, "version_name": "1.0.13", "version_code": 13,
        "outer_and_component_zip_crc_checks": "ok", "originals_unchanged": True,
        "apk_components": apk_records, "minimum_android_sdk": 29,
        "native_split_architecture": "armeabi-v7a", "installation_tested_on_device": False,
        "signer_certificates_match": True, "full_apk_signature_verification_performed": False,
        "media_files_validated": len(media), "raw_files_returned": len(raw_records),
        "default_resource_strings": len(default_strings), "locale_string_exports": locales_count,
        "classes_indexed": len(class_rows), "java_approximations": java_count,
        "app_classes_disassembled": sum(row[4] for row in class_rows),
        "sqlite_header_files_found": sqlite_files, "populated_medicine_database_found": bool(sqlite_files),
        "medicine_records_recovered": 0, "medicine_schema_definitions": len(schemas),
        "vendor_network_contacted": False, "license_or_account_checks_modified": False,
        "original_source_project_reconstructed": False, "xml_decode_fallbacks": xml_errors,
        "rea": rea_results, "decompiler_engine": "Androguard DAD 4.1.4",
        "generated_graphics_included": False,
    }
    write_json(output / "package-summary.json", summary)
    write_json(output / "media-manifest.json", media)
    write_json(output / "provenance.json", {"input_sha256": EXPECTED_SHA256, "original_file_copies": raw_records})
    write_text(output / "README_FIRST.txt", """VET. PHARMAPEDIA PAKISTAN 1.0.13 — RETURNED PACKAGE CONTENTS

Extract this ZIP, then open index.html for an offline browser.

WHAT IS INCLUDED
- The three original APK components, preserved byte for byte.
- Every original file extracted from those APKs, plus the XAPK icon/manifest.
- Original media, decoded manifest/layout/resource XML, locale strings, and CSV.
- Medicine model definitions and the medicines_table CREATE statement (schema only).
- Bytecode listings for application-namespace classes and decompiled Java
  approximations from classes3.dex; not the original Kotlin/Android Studio project.
- REA observations and source/output hashes.

IMPORTANT LIMITS
The XAPK and its APKs passed ZIP CRC checks. No container corruption was detected.
That is not a security certification, full APK signature verification, or a
successful Android installation/runtime test. The package was not rebuilt or
re-signed. Original license, installer, account, and network checks remain.

No populated medicine database or downloaded medicine records were found inside
this package. App code reads records from Firebase and creates/caches a local
Room database on a device. Server content and device-created caches are not
included here. No remote service/account was accessed and no drug entries or
empty replacement database were manufactured. The schema file contains no rows.

Media files are genuine source-package images/graphics, mostly interface icons,
language flags, animation/contact artwork. They are not a product-photo catalogue.
No generated preview or fabricated pictures are included.

Java exports are approximations for inspection, not a verified rebuildable
project. Original bytecode and binary resources remain in the APKs/raw extraction.
CSV cells that could be interpreted as spreadsheet formulas are escaped; exact
resource values remain in the XML exports. Clinical correctness/current pricing
has not been independently validated.

Read INSTALLATION.txt for the unchanged split APKs. Do not uninstall an existing
app or clear its data merely to test these components.
""")
    write_text(output / "INSTALLATION.txt", """ORIGINAL SPLIT APK COMPONENTS — NOT A UNIVERSAL OR MODIFIED APK

This XAPK contains a base APK, an armeabi-v7a native split, and an hdpi resource
split. Minimum SDK 29 means Android 10 or newer. The supplied native architecture
requires a device/system that supports armeabi-v7a; a 64-bit-only device may not
accept it. Do not assume the base APK alone is a complete installation.

A trusted split-package installer can use the original XAPK. Alternatively,
advanced users with their own authorized Android device and Android platform
tools can run this command from app-components/:

adb install-multiple vet.pharmapedia.vetpharmapediapakistan.apk config.armeabi_v7a.apk config.hdpi.apk

This command has NOT been executed here. It does not intentionally uninstall an
existing app. If an app is already installed or a signature/version conflict is
reported, stop and preserve its data; do not clear data or uninstall to work
around the conflict. Obtain a compatible original package through the normal
source instead of changing security/license checks.

Original app signing bytes, license/installer checks, and account behavior are
unchanged. Network access may be needed for the normal catalogue download.
Backend availability and successful app launch were not tested.
""")
    render_viewer(output, summary, default_strings, media)
    delivered = []
    for path in sorted(output.rglob("*")):
        if path.is_file():
            delivered.append({"file": path.relative_to(output).as_posix(), "bytes": path.stat().st_size,
                              "sha256": sha256(path)})
    write_json(output / "output-manifest.json", {"files": delivered, "manifest_excludes_itself": True})
    with zipfile.ZipFile(returned_zip, "x", compression=zipfile.ZIP_DEFLATED) as archive:
        for path in sorted(output.rglob("*")):
            if path.is_file():
                archive.write(path, (Path("Pharmapedia-returned") / path.relative_to(output)).as_posix())
    returned_zip.chmod(0o600)
    with zipfile.ZipFile(returned_zip) as archive:
        if archive.testzip() is not None:
            raise ValueError("Returned ZIP CRC failure")
    if sha256(input_path) != EXPECTED_SHA256:
        raise RuntimeError("Original input changed unexpectedly")
    final = {"archive": str(returned_zip), "bytes": returned_zip.stat().st_size,
             "sha256": sha256(returned_zip), "media": len(media), "java_approximations": java_count,
             "default_resource_strings": len(default_strings), "medicine_records_recovered": 0,
             "original_input_unchanged": True, "app_runtime_repair_claimed": False}
    print(json.dumps(final, indent=2))
    return final


def main():
    logger.remove()
    parser = argparse.ArgumentParser(description=__doc__)
    repo = Path(__file__).resolve().parents[2]
    parser.add_argument("--input", type=Path, default=repo / "google_drive" / "Vet+Pharmapedia+Pakistan_1.0.13_APKPure.xapk")
    parser.add_argument("--output", type=Path, default=repo / "recovery-data" / "pharmapedia" / "returned")
    parser.add_argument("--rea-cli", type=Path, default=repo / "node_modules" / ".bin" / "rea")
    args = parser.parse_args()
    if not args.rea_cli.is_file():
        parser.error("Project-local REA is missing; run npm ci first")
    recover(args.input.resolve(strict=True), args.output.resolve(), args.rea_cli.resolve())


if __name__ == "__main__":
    main()
