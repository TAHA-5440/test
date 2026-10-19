# Vet Pharmapedia browser app & recovery workspace

## Run the browser version

A new responsive **React/TypeScript web client** is implemented in [`web/`](web/README.md).
It runs as a normal website—no Android runtime or APK installation is required.

```bash
npm ci
npm run dev
```

Open the displayed local URL, or the Arena **Pharmapedia web app** live preview.
The server binds to `0.0.0.0:5173` and accepts the preview proxy host.

Implemented: generic/brand search, source filters, paginated browsing, source
medicine details/forms/dosages/alternatives, persistent favourites, JSON/CSV/SQLite
import/export, light/dark themes, local IndexedDB storage, production offline app
shell, and an optional authorised Firebase web connection.

**The medicine catalogue is still not recovered or bundled.** The web app starts
with zero records. Import actual authorised data or configure your own permitted
Firebase source; no vendor keys or fake medicine entries are preloaded. Backend
rules remain enforced, live-project access is unverified, and no clinical content
is independently validated.

```bash
npm test                 # data/storage/safe-text unit tests
npm run build            # static production build in ignored dist/
npm run preview          # serve production build
# In another terminal, with the production server running:
PWA_TEST=1 npm run test:e2e
```

[Web application guide](docs/WEB_APP.md) covers data formats, SQLite/WAL limitations,
privacy, Firebase setup, static hosting, native-feature differences and tests.
The recovered Java below remains reference material, not the source used to run
the web app or a buildable original Android Studio project.

## Recovery tooling and client reference exports

This repository contains project-local REA tooling, reproducible recovery scripts,
and a **credential-sanitized reference export** of the supplied Vet. Pharmapedia
Pakistan **1.0.13** Android client.

## Recovered application code

Start at **[recovered-source/pharmapedia-1.0.13/](recovered-source/pharmapedia-1.0.13/README.md)**.

- **11,178 Java approximations and 11,178 instruction listings** cover all three
  supplied DEX files in three source-only archives.
- **953 Java exports** are also unpacked for convenient browsing in GitHub.
- Decoded XML, locale strings, model definitions, class inventory, and the
  medicine-table definition are included.
- Recognized credential-like configuration is sanitized; original APKs, media,
  database files, recovered keys, and private Drive links are not published.

**These are decompiled approximations, not the original Kotlin/Android Studio
project or a verified buildable app.** Native C/C++ source, signing keys, and
Firebase backend/server code cannot be reconstructed from the supplied APK alone.
See the recovered-code README and NOTICE for the exact scope and limitations.

## Medicine database status

No populated medicine database was found in the supplied XAPK. The client creates
`medicines_DB` / `medicines_table` on a device and fetches records from Firestore
collection `NewMedicinesData`. **No actual medicine records have been recovered.**
The included SQL is a schema definition, not data. A real app-created cache or an
authorized collection data export would be needed to recover those records.

[Database investigation](reports/pharmapedia-medicine-database.md) ·
[Package analysis](reports/pharmapedia-recovery.md)

## Install REA

The official [`rea-agents`](https://github.com/morluto/rea) package is pinned to
**6.5.0** in `package.json` and the lockfile.

```bash
npm ci
npm run rea -- --version
npm run rea -- --help
```

General CLI requirements: Node.js 22.x >=22.19, 24.x >=24.11, or compatible 26+.
SQLite inspection specifically needs Node.js **24.15+** in the supported 24.x
line, or a compatible 26+ runtime, for `DatabaseSync.limits` support.

```bash
npm run --silent rea -- inspect-artifact /absolute/path/to/input --json
npm run --silent rea -- mcp doctor --json
npm run rea:doctor
```

`rea:doctor` can report missing optional providers. REA's Android-specific JADX
adapter requires a caller-supplied `jadx-headless-mcp` 0.7.1 JAR. It was unavailable
in the analysis environment; successful generic REA inspections and complementary
Androguard/DAD exports are distinguished in the reports. No unsupported operation
is represented as a successful REA decompilation.

For a stdio MCP client, launch Node with the absolute path to
`node_modules/rea-agents/scripts/rea.mjs` and argument `mcp`. Use `npm run --silent
rea:mcp` from a terminal to avoid npm banners on the protocol stream. Installation
alone does not register an agent. `npm run rea:setup` is an interactive opt-in setup
command; no automatic agent registration has been applied.

## Reproduce and test the tooling

- [Pharmapedia XAPK export tools](tools/pharmapedia/README.md)
- [Earlier VET-Anatomy partial recovery tooling](tools/recovery/README.md)

Private original files are required for reproduction and are deliberately absent
from this repository. Use a new private working/output directory for each run.

```bash
python3 -m venv .venv
.venv/bin/pip install -r tools/pharmapedia/requirements.txt
.venv/bin/python -m unittest discover -s tools/pharmapedia -p 'test_*.py' -v

# Optional dependencies for the older recovery workflow/tests:
.venv/bin/pip install -r tools/recovery/requirements.txt
.venv/bin/python -m unittest discover -s tools/recovery -p 'test_*.py' -v
```

Publication and archive-aware credential auditing are described in
[tools/pharmapedia/PUBLICATION.md](tools/pharmapedia/PUBLICATION.md).

## Privacy and publication boundaries

Do not commit real credentials, `.env` files, app signing keystores, original APKs,
user databases, or recovery-key/intermediate files. `google_drive/`,
`recovery-data/`, `.venv/`, dependency directories, and private credential/key file
patterns are ignored. Private deliverables remain outside Git; historical report
copies omit their Drive URLs in this public source publication.

Earlier image recovery produced only small bundled previews and an image index,
not full-size downloaded scan series. Those media/database artifacts are not in
this code repository and are not represented as complete data recovery.
