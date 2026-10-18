# Vet. Pharmapedia Pakistan XAPK return/export

This workflow inspects and returns **bundled files from the exact supplied
1.0.13 XAPK**. It is not an Android runtime repair, license bypass, original-source
project restoration, or recovery of missing server-side medicine records.

## Requirements

- Project-local `rea-agents@6.5.0`: run `npm ci` if absent.
- Python 3.11+ and `pip install -r tools/pharmapedia/requirements.txt` in a private
  virtual environment.
- The original `Vet+Pharmapedia+Pakistan_1.0.13_APKPure.xapk`, SHA-256
  `6f9781939a3c8caf967aa7d0bbd9429c6f968af66140dcef0db1d426c2d1534c`.

```bash
.venv/bin/python tools/pharmapedia/recover_xapk.py \
  --input 'google_drive/Vet+Pharmapedia+Pakistan_1.0.13_APKPure.xapk' \
  --output recovery-data/pharmapedia/fresh-return
```

Choose a **fresh** output path. Existing files are never replaced. The command
creates that directory and a sibling ZIP. Original input hashes are checked
before/after. Private data/code exports belong under the ignored recovery-data
folder, not in Git.

## What is returned

- Three original APK components, byte-identical to the supplied bundle.
- All raw files from those APKs, plus original XAPK icon/manifest.
- Validated original media and an offline HTML browser.
- Decoded manifest/layout XML, locale string XML, spreadsheet-safe default
  strings CSV, class index, medicine model definitions, and **schema-only** SQL.
- App-namespace bytecode listings and Java approximations from classes3.dex.
  These are not the original Kotlin sources or a verified rebuildable project.
- REA observations, original-file provenance, and output checksums.

The observed app code reads medicine records from Firebase and caches them in a
Room database on a device. No populated medicine DB was found in this XAPK.
No empty replacement DB, invented drug records, generated images, or remote
backend dump is returned. Exact original image bytes are preserved, including
animation; no enlargement or watermark removal is performed.

## Boundaries and validation

Archive paths, symlinks, duplicate entries, encryption flags, and size limits are
checked before extraction. ZIP CRCs, APK package/version coherence, parsed signer
certificate identities, original byte hashes, and complete media decoding are
checked. Matching certificate identities are not independent publisher
verification or full APK signature verification.

REA's `inspect-artifact` succeeds on both the outer XAPK and base APK. The
Android-specific JADX provider requires a caller-supplied 0.7.1 JAR, unavailable
in this environment. That failure is recorded, not presented as a successful
REA decompilation. Androguard 4.1.4 provides the additional static manifest,
resource, bytecode, and DAD approximate-Java exports. The normal workflow does
not require Java or contact app/vendor servers.

No app or native app library is executed; no installation, app launch, backend
availability, login, or clinical correctness is verified. Original signing bytes
and license/account behavior are unchanged. Installation notes cover the
unmodified base + armeabi-v7a + hdpi split set and explicitly warn against deleting
existing app data to work around a conflict.

```bash
.venv/bin/python -m unittest discover -s tools/pharmapedia -p 'test_*.py' -v
```

## Medicine-record recovery status

The user subsequently requested actual medicine records and confirmed they have
only the XAPK. The evidence-only helper locates the exact cache/collection:

```bash
.venv/bin/python tools/pharmapedia/locate_medicine_data.py \
  --evidence recovery-data/pharmapedia/new-source-evidence.json
```

It confirms local filename `medicines_DB`, table `medicines_table`, and Firestore
collection `NewMedicinesData`. It does not contact the server or create a database,
refuses to overwrite existing evidence, and exits **2** to signal that actual
record data is still missing. Do not mistake its JSON/SQL definitions for a
populated database or infer drug records from empty model defaults.

An actual app-created cache (with WAL sidecars if present) or an authorized
collection data export is needed for record recovery. Do not ask for passwords,
service-account private keys, or repeat already-answered availability questions.

See [the contents-return report](../../reports/pharmapedia-recovery.md) and
[medicine database status](../../reports/pharmapedia-medicine-database.md).
