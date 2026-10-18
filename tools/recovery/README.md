# Reproducible partial database recovery

**This workflow recovers the image index and small bundled PNG assets, NOT the
requested full-size scan images. It does not yet decrypt the inner layer of
`eanatomy.db`.** Exit status **2** means that partial result, not full success.
The main intermediate must not be described as a recovered plaintext DB, and
216×216 module previews must not be described as full-resolution image recovery.

The original databases, resource archive, and libraries are not included in Git.
These scripts contain no recovered secret keys or proprietary decrypted payloads.
They are specific to the exact file hashes in `prepare_inputs.py`; different
releases are deliberately rejected rather than processed with stale addresses.

## Requirements

- Linux x86-64, Python 3.11+, and a C compiler available as `cc`.
- The pinned Python packages in `requirements.txt`.
- A private input directory containing the original five files:
  - `eanatomy.db`
  - `eanatomy_images.db`
  - `base_no_db.zip`
  - `native_libs_x86_64_full.zip`
  - `split_config.arm64_v8a.apk`

The small signed ARM64 split provides signing metadata. Its native code is not
executed on this host. The additional ARM64 full library pack was inspected for
architecture/coherence, but is not required by this x86-64 analysis workflow.

## Run from the repository root

```bash
python3 -m venv .venv
.venv/bin/pip install -r tools/recovery/requirements.txt

.venv/bin/python tools/recovery/run.py \
  --inputs /absolute/path/to/original-files \
  --work-dir /absolute/path/to/a/new/private-work-directory
```

Use a **new** work directory. Existing outputs and source files are never
replaced. The workspace uses symlinks to the input directory; the original input
hashes are checked before and after processing. Private state is created with a
restrictive umask. Do not run with Python optimization (`-O`).

Outputs:

- `state/recovered/eanatomy_images.recovered.db`: an ordinary SQLite database.
  The supplied input yields 34,167 records in table `image`, containing image
  metadata/index information, not image pixels. Integrity checking must say `ok`.
- `state/recovered/eanatomy.outer-decoded.db`: a **still-protected** intermediate
  for further investigation. It is not currently readable as ordinary SQLite.
- `state/recovered/bundled-images.recovered.zip`: 787 validated PNG assets,
  including 45 module previews (216×216), 408 orientation variants (40×40 or
  120×120), and 334 category icons (56×56). Includes an offline `index.html`
  gallery and a labelled overview. These are not the full-resolution scan series.
- `recovery-summary.json`: explicit partial-recovery status and output checksums,
  with `full_scan_series_recovered: false`.
- `state/diagnostics/`: **sensitive** intermediate key material and diagnostics.
  Keep this directory private; never commit it or share it publicly.

The repository's own `google_drive/`, `recovery-data/`, and `.venv/` directories
are ignored. If choosing another work location, keep it out of Git as well.

## Validation and safety boundaries

The workflow checks input hashes, native segment lengths/checksums, authenticated
resource-directory/helper data, the helper DEX's own checksums, native root-key
fingerprint, code-integrity observation, and the database wrapper's build tag.
A tightly limited Dalvik arithmetic interpreter handles the small key helper.
Unicorn is used only for bounded local computations; Android syscalls and
unexpected native imports are rejected. **No supplied app `.so` is loaded into
the host process, and no Android app or account session is launched.**

The portable C decoder is authored here, independently tested in standard
20-round mode, and compared with the inspected native 8-round control blocks.
Recovered SQLite contents then undergo `PRAGMA integrity_check`. This is recovery
support for this artifact format, not a cryptography recommendation for new data.
No original app, subscription checks, or user account configuration is modified.

Unit tests require no app files or secret keys:

```bash
.venv/bin/python -m unittest discover -s tools/recovery -p 'test_*.py' -v
```

For analysis context and the actual delivered file, see
[`reports/database-recovery.md`](../../reports/database-recovery.md).
