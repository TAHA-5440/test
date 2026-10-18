# Medicine database recovery — blocked by missing record data

**Actual medicine records recovered: 0. No populated database has been returned.**

The user requested the medicine database specifically and confirmed they have
**only the XAPK**, not an existing app-data database/backup or a Firebase export.
Do not repeatedly ask them the same source-availability question. Do not present
the previously exported schema as recovered record data.

## Exact data path confirmed

Static inspection of the original bytecode, corroborating the Java approximations,
confirmed:

| Item | Observed value |
| --- | --- |
| App package | `vet.pharmapedia.vetpharmapediapakistan` |
| Local Room database filename | **`medicines_DB`** — no `.db` suffix |
| App table | **`medicines_table`** |
| Optional SQLite sidecars | `medicines_DB-wal`, `medicines_DB-shm` |
| Firestore medicine collection | **`NewMedicinesData`** |
| Fetch behavior | Server query filtered by `timeStamp`, using `KEY_LAST_FETCHED` |

The Room builder in `qc/e` passes `medicines_DB` as the database name.
The home fragment implementation `wc/l` selects `NewMedicinesData` and requests
`Source.SERVER`. Its callbacks map Firestore documents to `MedicinesRoomDBModel`
and insert them into Room. This is a device-created/downloaded cache, not an
included database file. The progress-dialog value `80000` is a timing argument;
it must not be reported as a verified medicine-record count.

## Searches and checks performed

- The original XAPK hash still matches
  `6f9781939a3c8caf967aa7d0bbd9429c6f968af66140dcef0db1d426c2d1534c`.
- The base APK's members were rechecked for database filenames and SQLite file
  headers: **none found**.
- Actual Dalvik instructions confirmed the cache/collection literals and Room /
  Firestore references. Evidence is recorded privately at
  `recovery-data/pharmapedia/medicine-data-source.json`.
- A Drive filename search for medicine/cache/Firebase-related files returned only
  the known XAPK and returned-contents ZIP. A corresponding trashed-file search
  found no matches. This does not inspect Drive version history or prove that
  no differently named backup exists elsewhere.
- No Firebase/vendor endpoint was queried, no app or account session was run, and
  no embedded client configuration was treated as administrator credentials.
  Server availability, access permissions, and remote document count are unknown.
- No dummy medicine rows, invented dosages, or empty replacement database were
  created as a recovered deliverable. Original input files were not modified.

## What would allow actual record recovery

A real record source is required:

1. A consistent copy/export/backup of the app-created **`medicines_DB`**, including
   the matching `-wal` / `-shm` files if present. Uncheckpointed records can live in
   WAL, so an original must not be opened with settings that silently ignore it.
   Preserve the originals and process working copies.
2. An **authorized export** of the `NewMedicinesData` documents. Data exports are
   sufficient; do not ask for passwords, login tokens, or service-account keys.

If the original app can still perform its normal initial download, that may
recreate a populated cache, subject to normal access and backend availability.
A supported app-data export/backup could then supply records for validation and
SQLite/CSV export. This has not been performed or verified here. Do not recommend
uninstalling the app or clearing its data as a recovery step.

The XAPK's table definitions and default model values cannot reconstruct missing
medicine documents. More copies of the same APK or libraries do not provide those
records, and no populated-database recovery can currently be claimed from the
provided file alone.

## Reproducible evidence-only check

`tools/pharmapedia/locate_medicine_data.py` verifies the exact input, checks for
packaged SQLite files, and records the specific bytecode data-source references.
It makes no server requests and writes no database. It deliberately exits **2**
for `record_source_not_provided`; the JSON report is evidence, not a medicine data
export. It refuses to overwrite an existing evidence file.

See [the original contents-return report](pharmapedia-recovery.md) for the package,
resource, media, and code exports that were actually produced.
