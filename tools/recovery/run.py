#!/usr/bin/env python3
"""Reproduce the validated partial recovery without overwriting originals.

Exit 2 means the image metadata DB and small bundled picture assets were
recovered, but the full-size scan series was NOT recovered and the main DB
remains protected. No app library is ever loaded into the host process.
"""
import argparse
import json
import os
from pathlib import Path
import shutil
import subprocess
import sys

from prepare_inputs import verify_inputs


STAGES = (
    "prepare_inputs.py",
    "unpack_native_image.py",
    "prepare_import_metadata.py",
    "recover_root_material.py",
    "decode_asset_metadata.py",
    "decode_key_helper.py",
    "derive_asset_schedule.py",
    "native_block_control.py",
    "recover_outer_databases.py",
    "recover_bundled_images.py",
)


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    repository = Path(__file__).resolve().parents[2]
    parser.add_argument("--inputs", type=Path, default=repository / "google_drive")
    parser.add_argument("--work-dir", type=Path,
                        default=repository / "recovery-data" / "offline-recovery")
    args = parser.parse_args()
    if not __debug__:
        parser.error("Do not run this validation workflow with Python -O")
    source = Path(__file__).resolve().parent
    inputs = args.inputs.resolve(strict=True)
    verify_inputs(inputs)
    compiler = shutil.which("cc")
    if compiler is None:
        parser.error("A C compiler (cc) is required for the portable cipher control")
    work = args.work_dir.resolve()
    if work.exists():
        parser.error("Work directory already exists. Choose a fresh --work-dir; nothing is overwritten.")
    os.umask(0o077)
    work.mkdir(parents=True, mode=0o700)
    workspace = work / "workspace"
    workspace.mkdir()
    state = work / "state"
    (state / "tools").mkdir(parents=True)
    (workspace / "google_drive").symlink_to(inputs, target_is_directory=True)
    (workspace / "recovery-data").symlink_to(state, target_is_directory=True)
    environment = os.environ.copy()
    environment.pop("PYTHONOPTIMIZE", None)
    subprocess.run([
        compiler, "-O3", "-Wall", "-Wextra", "-Werror", "-std=c11", "-shared", "-fPIC",
        str(source / "chacha_codec.c"), "-o", str(state / "tools" / "chacha_codec.so"),
    ], check=True, cwd=workspace, env=environment, timeout=120)
    for stage in STAGES:
        print(f"\n--- {stage} ---", flush=True)
        subprocess.run([sys.executable, str(source / stage)], cwd=workspace,
                       env=environment, check=True, timeout=180)
    verify_inputs(inputs)
    diagnostics = state / "diagnostics"
    outputs = json.loads((diagnostics / "outer-database-recovery.json").read_text())
    image = next(item for item in outputs if item["input"] == "eanatomy_images.db")
    if image.get("sqlite_integrity_check") != ["ok"]:
        raise RuntimeError("Recovered image database did not pass SQLite integrity checking")
    bundled = json.loads((state / "recovered" / "bundled-images" / "manifest.json").read_text())
    summary = {
        "status": "partial_recovery",
        "originals_unchanged": True,
        "images_database": {
            "path": str(state / "recovered" / image["output"]),
            "bytes": image["bytes"], "sha256": image["sha256"],
            "sqlite_integrity_check": "ok",
        },
        "main_database": {
            "status": "outer_wrapper_removed_inner_encryption_unresolved",
            "path": str(state / "recovered" / "eanatomy.outer-decoded.db"),
            "ordinary_sqlite_readable": False,
        },
        "bundled_image_assets": {
            "zip": str(state / "recovered" / "bundled-images.recovered.zip"),
            "validated_png_files": bundled["validated_images"],
            "groups": bundled["groups"],
            "full_scan_series_recovered": False,
        },
        "private_intermediate_material": str(diagnostics),
    }
    (work / "recovery-summary.json").write_text(json.dumps(summary, indent=2) + "\n")
    print("\n" + json.dumps(summary, indent=2))
    print("Partial recovery only: bundled previews/diagrams are recovered, NOT full scan series; the main database is still encrypted.")
    return 2


if __name__ == "__main__":
    raise SystemExit(main())
