# REA Analysis — `eanatomy_images.recovered.db`

**Target:** `eanatomy_images.recovered.db` from Google Drive (TAHA abdullah)  
**Source:** `https://drive.google.com/file/d/1JjRJLKuLqzS0t3yZgYKX8iCPPjB7GFZK`  
**Local path:** `/home/user/test/evidence/eanatomy_images.recovered.db`  
**Tool:** [REA](https://github.com/morluto/rea) `6.7.0` — `rea inspect-sqlite-database` (SQLite 3.54.0 provider)  
**Runtime:** Node `26.12.0` (upgraded from `22.22.3` via `npm install --global node@26.12.0` — required for `DatabaseSync.limits`), Debian 12 x64  
**Date:** 2026-10-18

## How to reproduce
```bash
rea --version                          # 6.7.0
rea doctor                             # node: healthy 26.12.0, host: healthy
rea inspect-sqlite-database /path/to/eanatomy_images.recovered.db --json
rea inspect-sqlite-database /path/to/eanatomy_images.recovered.db --schema-scope database --json
rea inspect-sqlite-database /path/to/eanatomy_images.recovered.db --table image --schema-scope selected_table --row-limit 20 --json
```

All JSON Evidence is stored under `evidence/` in this repo.

---

## File identity (REA Evidence)

| Field | Value |
|---|---|
| **SHA256** | `d4f0c4b484d9ef30b59c1fdbb14054626448dac4903efc6b3ad80779c2648eb3` |
| **Bytes** | `2850816` (2.8 MiB) |
| **Encoding** | UTF-8 |
| **Page size** | 4096, 696 pages |
| **Journal** | `delete` (no WAL) |
| **Integrity** | `PRAGMA integrity_check = ok` (recovered wrapper removed, decompressed — see Drive description) |
| **Description** | *Recovered copy of `eanatomy_images.db`. Original Drive file unchanged. Removed the app asset wrapper and decompressed its contents. Standard SQLite PRAGMA integrity_check returned ok. This is only the recovered image metadata database; the separate `eanatomy.db` is not yet fully decrypted.* |

**REA Evidence IDs:**
- `ev_e964c7859518a7eb61c819944e9f13683acd488f4aa0581fc3df32131cf603e2` — inventory
- `ev_db27eae72a6e9507288ca673aaf08124ea0bb3e4f937ad880aa9ce8c5878f7cb` — database schema
- `ev_a4ef6fca5b12ff44695b4c5a80f3839f06682e9741fda415b5378828764bcff1` etc. — row samples

**Provider:** `rea-artifact-graph` + `sqlite` (SQLite 3.54.0), `rea@6.7.0`

---

## Schema (REA `database` scope, completeness: `complete`)

```sql
CREATE TABLE image (
  module_imaios_code TEXT NOT NULL,
  contrast TEXT NOT NULL,
  sort_order INTEGER NOT NULL,
  version INTEGER NOT NULL,
  downloaded INTEGER NOT NULL DEFAULT 0,
  PRIMARY KEY(module_imaios_code, contrast, sort_order, version)
);
-- index: sqlite_autoindex_image_1 (PK index, root_page 3)
-- table root_page: 2, without_rowid: false, strict: false
-- no views, no triggers
```

**Columns (5):**

| cid | name | declared_type | not_null | default | pk_pos |
|---|---|---|---|---|---|
| 0 | `module_imaios_code` | TEXT | true | — | 1 |
| 1 | `contrast` | TEXT | true | — | 2 |
| 2 | `sort_order` | INTEGER | true | — | 3 |
| 3 | `version` | INTEGER | true | — | 4 |
| 4 | `downloaded` | INTEGER | true | `0` | 0 (non-PK) |

REA: `columns_completeness: complete`, `completeness: complete`.

---

## Content (observed, bounded sample)

REA reports `healthy: false` overall (no Hopper/Ghidra etc.) — `node` and `host` are healthy, which is expected for SQLite-only analysis. The SQLite provider itself is **available** on Node 26.12.

### Row counts (Python cross-check, matches REA)
- **Total rows:** `34,167`
- **Distinct `module_imaios_code`:** `43` (veterinary modules)
- **Distinct `contrast`:** `10`
- **Distinct `version`:** `5` (1,2,3,4,6)
- **Distinct `downloaded`:** `1` (all `0` — none marked downloaded)

### Contrasts
| contrast | rows |
|---|---|
| `contraste_` | 21,136 |
| `contraste_mou` | 6,695 |
| `contraste_os` | 5,564 |
| `contraste_Couleur` | 608 |
| `contraste_radiographies` | 38 |
| `contraste_acronymes` | 38 |
| `contraste_t2eg` | 22 |
| `contraste_t1gado` | 22 |
| `contraste_t1` | 22 |
| `contraste_flair` | 22 |

`contraste_` is the default/neutral; `mou`/`os` are soft-tissue vs bone windows; the rest are specialized MR sequences (`t1`, `t1gado`, `flair`, `t2eg`) and French labels (`Couleur`, `radiographies`, `acronymes`).

### Versions
| version | rows |
|---|---|
| 1 | 25,372 |
| 2 | 6,662 |
| 3 | 535 |
| 4 | 1,360 |
| 6 | 238 |

Version is part of PK — multiple versions of same `(module, contrast, sort_order)` exist (app incremental updates).

### Modules (43) — full list
`Bull-osteology-illustrations`, `Dog-Elbow-CT`, `bull-general-anatomy-illustrations`, `cat-abdomen-pelvis-ct`, `cat-head-neck-ct`, `cat-osteology-illustrations`, `cat-radiographs`, `cat-thorax-ct`, `dog-TPLO-surgical-approach`, `dog-abdomen-pelvis-ct`, `dog-arthrology-illustrations`, `dog-axes-angles`, `dog-brachy-head-ct`, `dog-brain-mr`, `dog-carpus-ct`, `dog-cervical-spine-mr`, `dog-ear-illustrations`, `dog-eye-illustrations`, `dog-gastroscopy`, `dog-general-anatomy-illustrations`, `dog-lumbar-spine-ct`, `dog-myology-illustrations`, `dog-nasal-cavity-illustrations`, `dog-neck-ct`, `dog-osteology-illustrations`, `dog-radiographs`, `dog-shoulder-ct`, `dog-skull-ct`, `dog-stifle-joint-ct`, `dog-stifle-joint-mr`, `dog-tarsus-ct`, `dog-temporal-bone-ct`, `dog-thorax-ct`, `dog-whole-body-ct`, `horse-carpus-ct`, `horse-dental-anatomy-illustrations`, `horse-digit-illustrations`, `horse-distal-limb-mr`, `horse-head-ct`, `horse-myology-illustrations`, `horse-osteology-illustrations`, `horse-radiographs`, `mouse-whole-body-ct`

Top by row count:
| module | rows |
|---|---|
| `horse-head-ct` | 2,579 |
| `dog-whole-body-ct` | 2,296 |
| `dog-abdomen-pelvis-ct` | 2,198 |
| `dog-gastroscopy` | 2,103 |
| `dog-brachy-head-ct` | 2,002 |

See `evidence/module_breakdown.csv` for per-`(module, contrast, version)` breakdown (sort_order 1..N contiguous, count == max sort_order).

### Sample rows (REA Evidence, `row_limit: 20`, order unspecified)
REA `inspect_sqlite_database` returned 5-row bounded sample — verified identical via Python `SELECT * FROM image LIMIT 5`:
```
cat-head-neck-ct | contraste_ | 1 | 1 | 0
cat-head-neck-ct | contraste_ | 2 | 1 | 0
cat-head-neck-ct | contraste_ | 3 | 1 | 0
...
```
All `downloaded = 0` (no image flagged as locally cached). PK guarantees uniqueness on `(module, contrast, sort_order, version)`.

---

## Interpretation

- This DB is **purely an image inventory** for the IMAIOS eAnatomy app (veterinary). It does **not** store image bytes — it stores *which* images belong to which module/contrast/version and their display order. Actual images are downloaded separately; `downloaded` tracks cache state.
- `sort_order` is a stable 1-indexed sequence per `(module, contrast, version)` — e.g., `cat-head-neck-ct / contraste_ / v1` has 1..1152.
- French `contraste_*` labels are the app's contrast/window terminology (consistent across modules).
- The file is **not encrypted** — `integrity_check ok`, readable via SQLite 3.54.0. The companion `eanatomy.db` (92 MB, `application/octet-stream`) is noted in Drive as *not yet fully decrypted* — that DB likely holds annotations, labels, user data, and may be encrypted/SQLCipher.
- `eanatomy_images.db` (423 KB original) was likely the app-bundled compressed asset wrapper; this `recovered.db` is the decompressed, wrapper-stripped version.

---

## REA limitations (from Evidence)

- Offline stable file set only — not an atomic snapshot of a live DB; provide app-created backup if needed.
- Source DB/WAL never modified; private copy may acquire WAL-index sidecar, removed after inspection.
- Reports current schema + committed rows from valid DB/WAL state. Deleted records, uncommitted WAL tails, encrypted DBs, forensic recovery, full integrity verification **outside this profile**.
- CREATE statements preserve index/view/trigger defs; views/triggers/virtual tables not executed.
- Bounded sample, unspecified order; text display may replace invalid sequences (bytes_hex + encoding preserve raw bytes).
- Resource caps: 2 concurrent inspections, 256 MiB combined input, 16 MiB complete JSON, 16 MiB value/record/SQL limits, 256 MiB JS heap, 30s deadline.

---

## Files in this repo

- `evidence/eanatomy_images.recovered.db` — the DB itself (2.8 MiB)
- `evidence/inventory.json` — REA inventory Evidence
- `evidence/database_schema.json` — REA database-scope Evidence
- `evidence/image_rows_20.json` — REA row-sample Evidence
- `evidence/capabilities.json` — `rea capabilities --json`
- `evidence/doctor.json` — `rea doctor --json`
- `evidence/analysis_summary.json` — Python cross-validation counts
- `evidence/module_breakdown.csv` — per-module/contrast/version counts

## Next steps

- If you want the actual image blobs, check the app's download cache (path hinted by `eanatomy.db` if decrypted) or re-extract the APK asset wrapper.
- To decrypt `eanatomy.db`, share its header bytes / PRAGMA / file magic (likely SQLCipher) — REA cannot handle encrypted DBs in this profile.
- For a web-viewer: `downloaded` could drive a progress tracker; `sort_order` drives the viewer order.

---

*Generated with REA 6.7.0 on Node 26.12.0. Evidence JSONs are canonical REA output (predicate `rea.analysis`, confidence `observed`, authority `shipped-artifact`).*
