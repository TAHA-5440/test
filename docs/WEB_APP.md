# Vet Pharmapedia browser edition

A new, responsive React/TypeScript web client implements the recovered
Pharmapedia 1.0.13 record model and its core reference workflows. It is not an
Android emulator, an automatic translation of the recovered Java, an official
publisher backend connection, or a reconstruction of missing medicine records.

**The app starts with zero medicines. No catalogue, drug prices, indications or
dosages are generated or bundled.** Synthetic software-test fixtures are kept in
test files only and are not part of the production application.

## Run

Use Node.js 22.19+ in the supported 22.x line, or a compatible supported newer
runtime, and npm. No Python/Android SDK is needed for the web application.

```bash
npm ci
npm run dev
```

The configured server listens on **0.0.0.0:5173**, accepts the Arena preview host,
and uses relative frontend asset URLs. There is no separate localhost API. The
dev server's filesystem allowlist excludes private recovery inputs and secrets.

```bash
npm run build
npm run preview
```

`dist/` is a static production build; `npm run preview` serves it on the same
port. It is not a production-grade internet hosting service. Deploy the contents
of `dist/` to an ordinary static **HTTPS** host. Relative Vite asset URLs and hash
navigation support subdirectory hosting. Do not open index.html directly as a
file URL: ES modules/service workers need HTTP(S).

The app shell, local fonts and SQLite WASM are precached in production. After a
complete first load and service-worker activation, imported catalogue browsing,
search and favourites work after an offline reload. Cloud downloads and initial
app loading still require connectivity. The development server intentionally does
not register a service worker. Installation/add-to-home-screen depends on the
browser, secure origin and device support.

## Implemented workflows

| Android feature/model | Browser implementation |
| --- | --- |
| Generic/salt and brand browsing | Grouped, paginated catalogue with search, sorting and company/form/source-status filters |
| Generic and brand favourites | Independent saved references persisted in IndexedDB |
| Overview / indications / contraindications | Source-provided text, safe formatting and a normalized JSON source view |
| Available forms / packing / price / strength | Structured source values; no currency/availability inference |
| Animal/source dosage details | Structured original data; no calculations or generated recommendations |
| Alternate brands | Other records with the exact same generic name, not an equivalence/prescription recommendation |
| Local Room medicine cache | Import an ordinary consistent SQLite export with medicines_table |
| Server catalogue download | Optional user-configured, authorised Firebase web client; no recovered vendor credentials prefilled |
| Themes/settings | Persistent light/dark theme and comfortable/compact table density |
| Data portability | JSON, CSV and standalone filled SQLite exports |

Native notifications, original app-store integration, on-device ML translation,
original advertising SDK flows and Android-specific services were not reimplemented.
All original licence/account checks in the private APKs remain untouched. This is
a separate client; normal backend authentication, rules and App Check policies
are not bypassed.

## Local data import

Use **Import catalogue** to validate a file, review its actual record counts and
notes, choose replace/merge, and confirm. Imports never upload files or modify
originals. A failure aborts the IndexedDB transaction, including synchronous
clone/quota failures after clear(), rather than committing a partial replacement.

Supported sources:

- A JSON array or `{ "medicines": [...] }` / `{ "records": [...] }` wrapper.
- A document-ID keyed collection export, optionally wrapped in NewMedicinesData.
- Standard Firestore REST `documents` / typed-value JSON or JSON-lines documents.
- CSV with docId and the recovered camelCase fields; nested maps may be JSON strings.
- Ordinary SQLite containing a populated **medicines_table**, usually exported
  from the Android **medicines_DB**. Encrypted SQLite is not unlocked by the web app.

Limits: 100 MiB per file and 100,000 records. Empty arrays, missing/duplicate IDs,
unrelated UI/schema data and service-account credential files are rejected.
Document map/path IDs are authoritative, matching the observed Android snapshot
handling. IDs and clinical text are not generated. Missing optional fields use
explicitly reported Android-model defaults: empty text/maps, false favourites,
timestamp 0, and block `No`. Additional source fields are preserved for JSON
backup; even an external field literally named extra keeps its original structure.

### SQLite/WAL caution

The browser reads the main SQLite file, not a separate WAL/SHM. Use a consistent,
checkpointed standalone backup/export. A WAL-mode header produces an import note
if readable, but the browser cannot verify or include external WAL-only changes.
Do not discard original WAL files, uninstall an app, or clear its data to obtain
an import. The separate forensic tools are not replaced by this browser importer.

## Exports and preservation

- **JSON:** recommended for catalogue backups. Known fields, nested objects,
  additional source fields, source metadata and saved flags for current records
  are preserved. Connection configuration/credentials are not exported.
- **CSV:** 14 recovered Android-model fields. Formula-like text prefixes are
  escaped for spreadsheet safety. Exact-string round trips should use JSON or
  SQLite, not a spreadsheet-modified CSV.
- **SQLite:** a filled, integrity-checked standalone medicines_table database.
  It is not advertised as the original Android Room cache or a device restoration;
  original Room metadata is not manufactured. Additional non-model fields are in
  JSON only. Zero-record SQLite exports are refused.

Merged catalogues may include several source files; the displayed source label
is explicitly the **last workspace import**, not proof of per-record provenance.
User changes to saved flags are reflected in exports. Catalogue replacement keeps
saved references; removal of the local catalogue/favourites requires typing REMOVE.
Original source files and cloud documents are never deleted.

IndexedDB is browser-profile/origin storage, **not encryption or a permanent
backup**. Clearing site data, an ephemeral/private profile or device loss may
remove it. Anyone with access to the browser profile may access the local copy.
Keep important exports. Appearance and optional public Firebase client configuration
are stored locally; no administrator keys or passwords should be pasted.

## Optional authorised Firebase connection

In **Data & sync**, supply only your own authorised project's **public web-client
configuration** (apiKey, projectId, optional authDomain/appId) and collection name.
The default collection name is NewMedicinesData; no project/API key is supplied.
Private service-account/admin credential objects are rejected. Saving configuration
is local and does not test or contact the project.

Sign-in and sync are explicit actions gated by an authorisation/read-cost notice.
Google sign-in uses the normal Firebase Auth popup, not an app password form.
Enable the provider and the deployed site's authorised domain in your own project
if using it. A public client API key alone does not grant Firestore permissions.
Normal authentication/security rules/App Check must permit the web client; use an
owner-provided data export if they do not. There is no attempt to forge credentials,
attestation, licence state, or bypass a denial.

Sync uses read-only paginated server reads, validates the entire response before
applying it, supports a 100,000-record safety cap, and keeps the prior catalogue
on failure. Normal read charges may apply. Cancellation prevents subsequent pages
and application of results; an in-flight SDK request may still complete. Leaving
the sync page cancels processing. No cloud write/delete API is implemented.

No live project was configured during development, so actual project availability,
OAuth configuration and permitted access have **not** been verified. Tests cover
configuration validation and denial handling without contacting Firebase.

## Clinical/data boundaries

Everything displayed must come from the user's imported/authorised source. Clinical
text is not rewritten into advice; common formatting is sanitized for browser
safety, plain-text inequalities/markers are kept, and an imported-record JSON view
is available. No doses, currency, prices, freshness or product equivalence are
inferred. Source-blocked records are marked and filterable. Verify the product label
and consult a veterinarian before clinical use. This is reference software, not a
prescription tool or a certification of the underlying source information.

## Verification

```bash
npm run typecheck
npm test
npm run build
npm run preview
# In another terminal, against the production server:
PWA_TEST=1 npm run test:e2e
npm audit --audit-level=high
```

Vitest covers data normalization, Firestore JSON, source-field preservation,
SQLite round trips, safe CSV, favourites, atomic IndexedDB storage and safe text.
Playwright covers the actual browser flows, imports/exports/WASM, persistence,
filters/pagination, responsive navigation, configuration rejection and offline
production reload. Its data are explicitly synthetic, non-clinical fixtures.

The Linux test browser and libraries are unpacked from a pinned npm package, so
this sandbox does not need a blocked browser-download host. Browser web security
is **not** disabled. Test-container-only no-sandbox flags are not app settings.
Builds and browser/test artifacts stay in ignored dist/ and recovery-data/ folders.
Runtime/font licence notices are included in production builds.
