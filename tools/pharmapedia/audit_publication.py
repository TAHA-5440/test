#!/usr/bin/env python3
"""Offline credential audit of published text, including every source ZIP entry.

No credential verification or network filters are enabled. Values are never
printed or written to reports; only detector/category, path, and hashes appear.
"""
import argparse
from collections import Counter
import hashlib
import json
from pathlib import Path
import re
import zipfile

from detect_secrets.core.scan import scan_line
from detect_secrets.settings import transient_settings
from publish_source import remaining_credentials

PLUGINS = [
    "ArtifactoryDetector", "AWSKeyDetector", "AzureStorageKeyDetector", "BasicAuthDetector",
    "CloudantDetector", "DiscordBotTokenDetector", "GitHubTokenDetector", "GitLabTokenDetector",
    "IbmCloudIamDetector", "IbmCosHmacDetector", "JwtTokenDetector", "MailchimpDetector",
    "NpmDetector", "OpenAIDetector", "PrivateKeyDetector", "PypiTokenDetector", "SendGridDetector", "KeywordDetector",
    "SlackDetector", "SoftlayerDetector", "SquareOAuthDetector", "StripeDetector",
    "TelegramBotTokenDetector", "TwilioKeyDetector",
]


def audit(paths, exceptions=()):
    findings = []
    reviewed = []
    files = archive_entries = 0
    format_markers = Counter()

    def inspect(label, raw):
        text = raw.decode("utf-8", errors="replace")
        direct = remaining_credentials(text)
        for kind, count in direct.items():
            findings.append({"file": label, "detector": "publication-regex:" + kind, "count": count})
        for secret in scan_line(text):
            value = secret.secret_value
            if value.startswith(("REDACTED_", "PRIVATE_DRIVE_LINK_OMITTED")):
                continue
            # Cryptography parsers include public PEM delimiter strings. A
            # delimiter with no encoded key body is a format marker, not a key.
            if re.fullmatch(r"-----BEGIN (?:[A-Z0-9]+ )*PRIVATE KEY-----", value.strip()):
                format_markers["private_key_format_delimiter_without_key_material"] += 1
                continue
            value_hash = hashlib.sha256(value.encode()).hexdigest()
            approved = next((item for item in exceptions
                             if label.endswith(item["file_suffix"]) and item["detector"] == secret.type
                             and item["value_sha256"] == value_hash), None)
            if approved:
                reviewed.append({"file": label, "detector": secret.type,
                                 "value_sha256": value_hash, "reason": approved["reason"]})
                continue
            findings.append({"file": label, "detector": secret.type, "value_sha256": value_hash})

    with transient_settings({"plugins_used": [{"name": name} for name in PLUGINS], "filters_used": []}):
        for root in paths:
            targets = [root] if root.is_file() else sorted(path for path in root.rglob("*") if path.is_file())
            for path in targets:
                if path.suffix in (".pyc", ".so") or "__pycache__" in path.parts:
                    continue
                if path.suffix == ".zip":
                    with zipfile.ZipFile(path) as archive:
                        if archive.testzip() is not None:
                            raise ValueError("Source archive CRC failure")
                        for member in archive.infolist():
                            if member.is_dir():
                                continue
                            inspect(str(path) + "!/" + member.filename, archive.read(member))
                            archive_entries += 1
                else:
                    inspect(str(path), path.read_bytes())
                    files += 1
    return {"network_verification_used": False, "plaintext_files_scanned": files,
            "source_archive_entries_scanned": archive_entries,
            "credential_findings": findings,
            "reviewed_noncredential_findings": reviewed,
            "noncredential_format_markers": dict(format_markers),
            "scope": "Recognized credential formats, not an exhaustive guarantee about encoded constants"}


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("paths", nargs="+", type=Path)
    parser.add_argument("--report", type=Path, required=True)
    parser.add_argument("--exceptions", type=Path, default=Path(__file__).with_name("publication-scan-exceptions.json"))
    args = parser.parse_args()
    exceptions = json.loads(args.exceptions.read_text())["exceptions"] if args.exceptions.is_file() else []
    result = audit(args.paths, exceptions)
    args.report.parent.mkdir(parents=True, exist_ok=True)
    args.report.write_text(json.dumps(result, indent=2) + "\n")
    print(json.dumps({"files": result["plaintext_files_scanned"],
                      "archive_entries": result["source_archive_entries_scanned"],
                      "findings": len(result["credential_findings"]),
                      "reviewed_noncredentials": len(result["reviewed_noncredential_findings"]),
                      "format_markers": result["noncredential_format_markers"]}, indent=2))
    raise SystemExit(1 if result["credential_findings"] else 0)


if __name__ == "__main__":
    main()
