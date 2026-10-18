# Reconstruction — eAnatomy Image Inventory Viewer

Evidence-backed reconstruction from REA `inspect_sqlite_database` on `eanatomy_images.recovered.db`.

**Evidence:** `evidence/inventory.json` (`ev_e964c785...`), `database_schema.json` (`ev_db27eae7...`), `image_rows_20.json` (`ev_8064eb59...`) — SHA256 `d4f0c4b484d9ef30b59c1fdbb14054626448dac4903efc6b3ad80779c2648eb3`, SQLite 3.54.0.

## What was reconstructed

The original app stores **inventory only** in `image` table — `PK(module_imaios_code, contrast, sort_order, version)` orders stacks. `downloaded` tracks cache (all 0 here). Viewer paginates 1..N contiguous per `(module, contrast, version)`. See `docs/REA_EANATOMY_ANALYSIS.md`.

## Usage

```bash
python reconstruction/viewer.py modules
python reconstruction/viewer.py contrasts cat-head-neck-ct
python reconstruction/viewer.py stack cat-head-neck-ct contraste_ 1 | head
python reconstruction/viewer.py trace cat-head-neck-ct contraste_
```

Open `reconstruction/index.html` in a browser (loads `evidence/module_breakdown.csv`).

## REA obligations

A full `build-reconstruction-obligation-ledger` requires Application Graph Evidence (`analyze-javascript-application`, `capture-*`). For this DB-only target, obligations are documented in `docs/REA_EANATOMY_ANALYSIS.md` with Evidence IDs, limitations, and verifier steps — conservative by REA design (static facts ≠ runtime proof).
