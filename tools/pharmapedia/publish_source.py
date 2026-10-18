#!/usr/bin/env python3
"""Export credential-sanitized, reference-only APK code for source publication.

This does not recreate the original Android project or Firebase backend. Complete
instruction listings are included even when Java decompilation times out/fails.
Original APKs, media, databases, recovered keys and runtime credentials stay out.
"""
import argparse
import base64
from collections import Counter
import csv
import hashlib
import io
import json
from pathlib import Path
import re
import signal
import time
import zipfile

from loguru import logger
from androguard.core.dex import DEX
from androguard.core.analysis.analysis import Analysis
from androguard.decompiler.decompiler import DecompilerDAD
from recover_xapk import EXPECTED_SHA256, PACKAGE, check_archive, safe_relative

RULES = (
    ("private-key", re.compile(r"-----BEGIN (?:[A-Z0-9]+ )*PRIVATE KEY-----[\s\S]*?-----END (?:[A-Z0-9]+ )*PRIVATE KEY-----")),
    ("google-api-key", re.compile(r"AIza[0-9A-Za-z_-]{35}")),
    ("github-token", re.compile(r"(?:gh[pousr]_[A-Za-z0-9]{20,255}|github_pat_[A-Za-z0-9_]{30,255})")),
    ("slack-token", re.compile(r"xox[baprs]-[A-Za-z0-9-]{15,255}")),
    ("stripe-secret", re.compile(r"(?:sk|rk)_(?:live|test)_[A-Za-z0-9]{16,255}")),
    ("jwt", re.compile(r"eyJ[A-Za-z0-9_-]{12,}\.[A-Za-z0-9_-]{12,}\.[A-Za-z0-9_-]{16,}")),
    ("aws-access-id", re.compile(r"\b(?:AKIA|ASIA)[A-Z0-9]{16}\b")),
    ("bearer-token", re.compile(r"(?i)\bBearer[ \t]+[A-Za-z0-9._~+/=-]{20,}")),
    ("url-userinfo", re.compile(r"https?://[^/\s\"<>:@]+:[^@\s\"<>/]+@")),
)
SENSITIVE_NAME = r"(?:google_api_key|google_crash_reporting_api_key|api_key|apiKey|client_secret|clientSecret|access_token|accessToken|refresh_token|refreshToken|private_key|privateKey|firebase_secret|service_account_key)"
XML_SETTING = re.compile(r'(<string\b[^>]*\bname=[\"\'](' + SENSITIVE_NAME + r')[\"\'][^>]*>)[\s\S]*?(</string>)', re.I)
JSON_SETTING = re.compile(r'([\"\']' + SENSITIVE_NAME + r'[\"\']\s*:\s*[\"\'])(?:\\.|[^\"\'\\]){1,}([\"\'])', re.I)
JAVA_SETTING = re.compile(r'(^\s*(?:(?:(?:public|private|protected|static|final)\s+)*(?:String|java\.lang\.String)\s+|this\.)?' + SENSITIVE_NAME + r'\s*=\s*\")(?:(?:\\.)|[^\"\\])+(\")', re.I | re.M)
DRIVE_MARKDOWN = re.compile(r'\[([^\]]+)\]\(https://drive\.google\.com/[^)\s]+\)')
DRIVE_URL = re.compile(r'https://drive\.google\.com/(?:file/d/|drive/folders/|open\?)[^\s\"<>)]*')


def sanitize_text(text):
    counts = Counter()

    def encoded_credential(match):
        value = match.group(0)
        try:
            decoded = base64.b64decode(value + "=" * (-len(value) % 4), validate=True).decode("ascii")
        except (ValueError, UnicodeDecodeError):
            return value
        if any(pattern.search(decoded) for _, pattern in RULES):
            counts["base64-encoded-credential"] += 1
            return "REDACTED_BASE64_CREDENTIAL"
        return value

    text = re.sub(r"(?<![A-Za-z0-9+/=])[A-Za-z0-9+/]{48,4096}={0,2}(?![A-Za-z0-9+/=])", encoded_credential, text)
    for kind, pattern in RULES:
        text, count = pattern.subn("REDACTED_" + kind.upper().replace("-", "_"), text)
        if count:
            counts[kind] += count
    text, count = XML_SETTING.subn(lambda match: match[1] + "REDACTED_CLIENT_CONFIGURATION" + match[3], text)
    counts["named-xml-configuration"] += count
    for kind, pattern in (("named-json-configuration", JSON_SETTING), ("named-java-configuration", JAVA_SETTING)):
        text, count = pattern.subn(lambda match: match[1] + "REDACTED_CLIENT_CONFIGURATION" + match[2], text)
        counts[kind] += count
    text, count = DRIVE_MARKDOWN.subn(lambda match: match[1] + " (private Drive link omitted from publication)", text)
    counts["private-drive-link"] += count
    text, count = DRIVE_URL.subn("PRIVATE_DRIVE_LINK_OMITTED", text)
    counts["private-drive-link"] += count
    return text, {name: count for name, count in counts.items() if count}


def remaining_credentials(text):
    found = {kind: len(pattern.findall(text)) for kind, pattern in RULES if pattern.search(text)}
    for match in re.finditer(r"(?<![A-Za-z0-9+/=])[A-Za-z0-9+/]{48,4096}={0,2}(?![A-Za-z0-9+/=])", text):
        value = match.group(0)
        try:
            decoded = base64.b64decode(value + "=" * (-len(value) % 4), validate=True).decode("ascii")
        except (ValueError, UnicodeDecodeError):
            continue
        if any(pattern.search(decoded) for _, pattern in RULES):
            found["base64-encoded-credential"] = found.get("base64-encoded-credential", 0) + 1
    return found


def listing(cls):
    lines = ["# Instruction listing recovered from the supplied APK; not original source.",
             "CLASS " + cls.get_name(), "SUPER " + str(cls.get_superclassname())]
    for field in cls.get_fields():
        value = field.get_init_value()
        initial = repr(value.get_value()) if value is not None else "<not encoded>"
        lines.append("FIELD " + field.get_name() + " " + field.get_descriptor() + " = " + initial)
    for method in cls.get_methods():
        lines.append("\nMETHOD " + method.get_name() + method.get_descriptor())
        lines.append("FLAGS " + method.get_access_flags_string())
        code = method.get_code()
        if code is not None:
            lines.append("REGISTERS " + str(code.get_registers_size()))
            lines.append("INPUT_WORDS " + str(code.get_ins_size()))
            try:
                for item in code.get_tries():
                    lines.append(f"TRY start={item.get_start_addr()} count={item.get_insn_count()} handler_offset={item.get_handler_off()}")
                handlers = code.get_handlers()
                if handlers:
                    for handler in handlers.get_list():
                        lines.append("CATCH_SIZE " + str(handler.get_size()))
                        for pair in handler.get_handlers():
                            lines.append(f"CATCH type_index={pair.get_type_idx()} target={pair.get_addr()}")
                        if handler.get_size() <= 0:
                            lines.append("CATCH_ALL " + str(handler.get_catch_all_addr()))
            except (AttributeError, TypeError):
                lines.append("# Catch metadata not fully formatted; consult original bytecode in the private input.")
        offset = 0
        for instruction in method.get_instructions():
            lines.append(f"{offset:06x} {instruction.get_name()} {instruction.get_output()}")
            offset += instruction.get_length()
    return "\n".join(lines) + "\n"


class DecompileBudgetExceeded(Exception):
    pass


def alarm_handler(signum, frame):
    raise DecompileBudgetExceeded()


def export(input_path, recovered_exports, destination):
    digest = hashlib.sha256(input_path.read_bytes()).hexdigest()
    if digest != EXPECTED_SHA256:
        raise ValueError("Unexpected source XAPK hash")
    if destination.exists():
        raise FileExistsError("Choose a fresh publication directory")
    destination.mkdir(parents=True)
    (destination / "archives").mkdir()
    redactions = []
    classes_index = []
    archives = []

    def clean(text, label):
        text, counts = sanitize_text(text)
        if remaining_credentials(text):
            raise ValueError("Credential-like content remains after sanitization: " + label)
        if counts:
            redactions.append({"file": label, "counts": counts})
        return text

    def write(relative, text):
        path = destination / safe_relative(relative)
        path.parent.mkdir(parents=True, exist_ok=True)
        text = clean(text, relative)
        if relative.startswith("app-bytecode/"):
            # Remove formatter padding only on zero-operand instructions; do not
            # trim whitespace belonging to actual constant-string operands.
            text = re.sub(r"(?m)^([0-9a-f]+ (?:return-void|nop))[ \t]+$", r"\1", text)
        if relative.startswith("upstream-notices/") or relative.endswith(".xml"):
            text = text.rstrip() + "\n"
        path.write_text(text, encoding="utf-8", errors="backslashreplace")

    # Keep the existing readable client/R8 code and text resources browsable.
    mappings = (("java-approximations", "java"), ("app-bytecode", "app-bytecode"),
                ("decoded-xml", "resources/decoded-xml"), ("strings", "resources/strings"))
    for old, new in mappings:
        source = recovered_exports / old
        for path in sorted(source.rglob("*")):
            if path.is_file():
                relative = (Path(new) / path.relative_to(source)).as_posix()
                write(relative, path.read_text(encoding="utf-8", errors="backslashreplace"))
    for name in ("medicines-schema-only.sql", "medicine-model-definitions.json", "class-index.csv"):
        path = recovered_exports / name
        if path.is_file():
            write("metadata/" + name, path.read_text(encoding="utf-8", errors="backslashreplace"))

    # Use compressed source archives for the complete class set, avoiding >10k
    # generated files in the repository while retaining every instruction listing.
    with zipfile.ZipFile(input_path) as outer:
        check_archive(outer)
        base = outer.read(PACKAGE + ".apk")
    signal.signal(signal.SIGALRM, alarm_handler)
    started = time.monotonic()
    with zipfile.ZipFile(io.BytesIO(base)) as apk:
        check_archive(apk)
        for dex_name in sorted(name for name in apk.namelist() if re.fullmatch(r"classes\d*\.dex", name)):
            dex_bytes = apk.read(dex_name)
            dex = DEX(dex_bytes)
            analysis = Analysis(dex)
            analysis.create_xref()
            dex.set_decompiler(DecompilerDAD(dex, analysis))
            archive_path = destination / "archives" / (dex_name + "-source.zip")
            class_count = java_count = 0
            errors = Counter()
            with zipfile.ZipFile(archive_path, "x", compression=zipfile.ZIP_DEFLATED) as archive:
                archive.writestr("README.txt", "Credential-sanitized decompiled Java approximations and instruction listings.\nNot original Kotlin/Java source, a verified build, native C/C++ source, or Firebase backend code.\nEvery class has a bytecode listing; Java approximations are best-effort and may contain decompiler errors.\nNo original APK/DEX binaries or medicine records are included.\n")
                for cls in dex.get_classes():
                    name = cls.get_name()
                    relative = safe_relative(name[1:-1]).as_posix()
                    disassembly = listing(cls)
                    text = clean(disassembly, archive_path.name + "!/bytecode/" + relative + ".txt")
                    archive.writestr("bytecode/" + relative + ".txt", text.encode("utf-8", errors="backslashreplace"))
                    status = "bytecode_only"
                    error_name = None
                    if time.monotonic() - started < 300:
                        try:
                            signal.setitimer(signal.ITIMER_REAL, 2.0)
                            source = cls.get_source()
                            if not source.strip():
                                raise ValueError("Empty Java approximation")
                            text = clean("// Decompiled approximation; sanitized for publication, not original or verified buildable source.\n" + source,
                                         archive_path.name + "!/java/" + relative + ".java")
                            archive.writestr("java/" + relative + ".java", text.encode("utf-8", errors="backslashreplace"))
                            java_count += 1
                            status = "java_and_bytecode"
                        except Exception as error:
                            error_name = type(error).__name__
                            errors[error_name] += 1
                        finally:
                            signal.setitimer(signal.ITIMER_REAL, 0)
                    else:
                        error_name = "total_java_budget_exhausted"
                        errors[error_name] += 1
                    classes_index.append({"dex": dex_name, "class": name, "status": status,
                                          "java_fallback_reason": error_name})
                    class_count += 1
                    if class_count % 1000 == 0:
                        print(f"{dex_name}: {class_count} instruction listings, {java_count} Java approximations", flush=True)
            with zipfile.ZipFile(archive_path) as archive:
                if archive.testzip() is not None:
                    raise ValueError("Source archive CRC failure")
            archives.append({"dex": dex_name, "input_dex_sha256": hashlib.sha256(dex_bytes).hexdigest(),
                             "source_archive": "archives/" + archive_path.name,
                             "archive_bytes": archive_path.stat().st_size,
                             "archive_sha256": hashlib.sha256(archive_path.read_bytes()).hexdigest(),
                             "classes": class_count, "instruction_listings": class_count,
                             "java_approximations": java_count, "java_fallbacks": dict(errors)})
            print(f"Finished {dex_name}: {class_count} classes; {java_count} Java approximations", flush=True)
        for info in apk.infolist():
            name = info.filename
            if info.is_dir() or not re.search(r"(?:^|/)(?:LICENSE[^/]*|NOTICE[^/]*|DEPENDENCIES|README\.md)$", name, re.I):
                continue
            data = apk.read(info)
            try:
                text = data.decode("utf-8")
            except UnicodeDecodeError:
                continue
            write("upstream-notices/" + safe_relative(name).as_posix(), text)
    signal.setitimer(signal.ITIMER_REAL, 0)
    totals = {"classes": sum(item["classes"] for item in archives),
              "instruction_listings": sum(item["instruction_listings"] for item in archives),
              "java_approximations": sum(item["java_approximations"] for item in archives)}
    manifest = {"status": "sanitized_recovered_client_reference_code",
                "input_xapk_sha256": digest, "package": PACKAGE, "version": "1.0.13",
                "engine": "Androguard DAD 4.1.4", "totals": totals, "archives": archives,
                "original_source_project_recovered": False, "native_cpp_source_recovered": False,
                "firebase_backend_code_included": False, "medicine_records_included": False,
                "original_apks_databases_keys_and_media_excluded": True,
                "credential_redactions_applied": True}
    write("source-manifest.json", json.dumps(manifest, indent=2) + "\n")
    write("metadata/class-export-status.json", json.dumps(classes_index, indent=2) + "\n")
    write("redaction-report.json", json.dumps({"unredacted_recognized_credentials_included": False,
          "scope": "Recognized credential patterns and named client settings; not a guarantee against every encoded secret",
          "files": redactions}, indent=2) + "\n")
    if hashlib.sha256(input_path.read_bytes()).hexdigest() != digest:
        raise RuntimeError("Original input changed unexpectedly")
    print(json.dumps({"totals": totals, "source_archives": len(archives),
                      "redacted_file_occurrences": len(redactions), "output": str(destination)}, indent=2), flush=True)
    return manifest


def main():
    logger.remove()
    repo = Path(__file__).resolve().parents[2]
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--input", type=Path, default=repo / "google_drive" / "Vet+Pharmapedia+Pakistan_1.0.13_APKPure.xapk")
    parser.add_argument("--exports", type=Path, default=repo / "recovery-data" / "pharmapedia" / "returned" / "exports")
    parser.add_argument("--output", type=Path, default=repo / "recovered-source" / "pharmapedia-1.0.13")
    args = parser.parse_args()
    export(args.input.resolve(strict=True), args.exports.resolve(strict=True), args.output.resolve())


if __name__ == "__main__":
    main()
