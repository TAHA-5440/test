#!/usr/bin/env python3
"""Locate actual data-source references without manufacturing a medicine DB.

This command produces evidence, not medicine rows. It never contacts Firebase
or uses embedded client configuration as credentials.
"""
import argparse
import hashlib
import io
import json
from pathlib import Path
import re
import zipfile

from loguru import logger
from androguard.core.dex import DEX
from recover_xapk import EXPECTED_SHA256, PACKAGE, check_archive


def inspect_source(input_path):
    with input_path.open("rb") as stream:
        digest = hashlib.file_digest(stream, "sha256").hexdigest()
    if digest != EXPECTED_SHA256:
        raise ValueError("Input differs from the inspected XAPK")
    with zipfile.ZipFile(input_path) as outer:
        check_archive(outer)
        base = outer.read(PACKAGE + ".apk")
    sqlite_files, filename_candidates, schemas, references = [], [], [], []
    cache_seen = False
    collection_seen = False
    with zipfile.ZipFile(io.BytesIO(base)) as archive:
        check_archive(archive)
        for member in archive.infolist():
            if member.is_dir():
                continue
            if Path(member.filename).suffix.lower() in {".db", ".sqlite", ".sqlite3", ".realm"}:
                filename_candidates.append(member.filename)
            with archive.open(member) as stream:
                if stream.read(16) == b"SQLite format 3\0":
                    sqlite_files.append(member.filename)
        for filename in archive.namelist():
            if not re.fullmatch(r"classes\d*\.dex", filename):
                continue
            dex = DEX(archive.read(filename))
            schemas.extend(string for string in dex.get_strings()
                           if string.startswith("CREATE TABLE") and "`medicines_table`" in string)
            for cls in dex.get_classes():
                if cls.get_name() not in {"Lqc/e;", "Lwc/l;"}:
                    continue
                for method in cls.get_methods():
                    for instruction in method.get_instructions():
                        text = instruction.get_output()
                        literal_values = [operand[2] for operand in instruction.get_operands()
                                          if len(operand) >= 3 and isinstance(operand[2], str)]
                        relevant = False
                        if "medicines_DB" in literal_values:
                            cache_seen = True
                            relevant = True
                        if "NewMedicinesData" in literal_values:
                            collection_seen = True
                            relevant = True
                        if any(pattern in text for pattern in (
                                "Landroidx/room/g0;->b", "Lcom/google/firebase/firestore/FirebaseFirestore;->",
                                "Lcom/google/firebase/firestore/Query;->", "Lcom/google/firebase/firestore/Source;->SERVER")):
                            relevant = True
                        if relevant:
                            references.append({"dex": filename, "class": cls.get_name(),
                                               "method": method.get_name(), "signature": method.get_descriptor(),
                                               "opcode": instruction.get_name(), "reference": text})
    if not cache_seen or not collection_seen or not schemas:
        raise ValueError("Expected cache/collection/schema references were not confirmed")
    return {
        "status": "record_source_not_provided",
        "input_sha256": digest,
        "local_database_filename": "medicines_DB",
        "optional_cache_companions": ["medicines_DB-wal", "medicines_DB-shm"],
        "table": "medicines_table",
        "firestore_collection": "NewMedicinesData",
        "sqlite_header_files_in_base_apk": sqlite_files,
        "database_filename_candidates_in_base_apk": filename_candidates,
        "schema_definitions_only": sorted(set(schemas)),
        "bytecode_data_source_references": references,
        "medicine_records_recovered": 0,
        "remote_collection_row_count": None,
        "server_contacted": False,
        "client_config_used_as_credentials": False,
        "populated_database_returned": False,
        "required_record_source": "Existing app-created cache with its WAL companions, or an authorized collection data export",
    }


def main():
    logger.remove()
    repo = Path(__file__).resolve().parents[2]
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--input", type=Path, default=repo / "google_drive" / "Vet+Pharmapedia+Pakistan_1.0.13_APKPure.xapk")
    parser.add_argument("--evidence", type=Path, default=repo / "recovery-data" / "pharmapedia" / "medicine-data-source.json")
    args = parser.parse_args()
    evidence = inspect_source(args.input)
    args.evidence.parent.mkdir(parents=True, exist_ok=True)
    with args.evidence.open("x", encoding="utf-8") as stream:
        stream.write(json.dumps(evidence, indent=2) + "\n")
    print(json.dumps({key: evidence[key] for key in (
        "status", "local_database_filename", "optional_cache_companions", "table", "firestore_collection",
        "sqlite_header_files_in_base_apk", "medicine_records_recovered", "server_contacted", "populated_database_returned")}, indent=2))
    # Explicitly distinguish the evidence-only outcome from data recovery.
    raise SystemExit(2)


if __name__ == "__main__":
    main()
