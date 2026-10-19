# Pharmapedia browser port

A new React/TypeScript browser client now implements the recovered app's core
medicine-reference workflows. This is a manual web reimplementation—not a Java /
APK emulator, the original Android project, or recovered Firebase backend code.

## Implemented

- Responsive desktop/mobile navigation and a local-first workspace.
- Generic and brand catalogue browsing, pagination, sorting, text search, and
  company/form/source-status filters.
- Persistent generic/brand favourites using IndexedDB.
- Record-specific overview, indications, contraindications, forms/packing/prices,
  supplied dosage information, alternate records and a normalized JSON source view.
- Local JSON/JSON-lines/CSV/SQLite import with validation, review, replace/merge,
  missing-field notes and atomic persistence. Duplicate/missing IDs and empty or
  unrelated sources are refused; errors do not replace the current catalogue.
- JSON/CSV/filled SQLite export of actual loaded records. Additional source fields
  are preserved in JSON, including fields literally named extra. CSV has formula
  prefix protection. SQLite is a standalone data export, not a claimed original
  Android cache restoration; WAL sidecars are not read by the browser.
- Optional user-configured Firebase client access, normal Google sign-in and
  read-only paginated sync. Client configuration, authorisation acknowledgement,
  normal security rules and any App Check requirements are still necessary.
- Light/dark themes, compact/comfortable density, production service-worker app
  shell caching, and browser-dependent install/add-to-home-screen support.

## Data boundary

**No medicine catalogue has been recovered or bundled. The initial record count
is zero.** No vendor Firebase configuration or credentials are prefilled. The
user must import real authorised data or configure a normal permitted Firebase
source. No service-account/admin credentials are accepted, no cloud write/delete
API is implemented, and no attempt is made to bypass access denials.

No actual live Firebase project was supplied/configured during implementation.
Real backend availability, OAuth/domain setup and project permissions therefore
remain unverified. The local workflows do not require any backend and were tested
in an actual browser. Synthetic test fixtures are clearly labelled, non-clinical,
and are not imported by the production entrypoint or seeded into the app.

Clinical/source text is kept in stored records. Displayed HTML formatting is
sanitized, plain inequalities/unit markers are preserved, source keys retain
case, and raw normalized record JSON is accessible. No names, dosages, prices,
currency, freshness or treatment recommendations are generated. The UI explicitly
requires verification against the product label and a veterinarian.

## Storage and privacy

File imports run on the client and are not uploaded. Browser data uses IndexedDB;
this is not encryption or permanent backup. Clearing site data or losing a profile
can remove the local copy. Exports are local downloads. Catalogue/favourite removal
requires explicit confirmation. In-memory/IndexedDB transaction errors abort an
import rather than committing a partial clear/replacement. Original files and
cloud records are never deleted.

The app uses relative static asset URLs. No browser-facing localhost API is
required. The development server binds to 0.0.0.0 and accepts the preview host;
its filesystem allowlist excludes private recovery inputs. The production preview
serves only dist/. No external fonts or vendor requests are made on initial load.
A Firebase request only happens after explicit configured sign-in/sync.

## Verification performed

- `npm run typecheck`: passed.
- `npm test`: **40 unit/component tests passed**.
- `npm run build`: passed; static app, WebAssembly parser, self-hosted fonts,
  service worker and runtime/font notices generated.
- `PWA_TEST=1 npm run test:e2e`: **13 production browser tests passed**.
- Production offline reload with imported records and IndexedDB persistence:
  passed in Chromium.
- JSON and SQLite download/reimport, favourites across reload, search/filters,
  pagination, source variants, safe rendering, invalid-input preservation,
  mobile dialogs/navigation/overflow, and admin-config rejection: passed.
- Default-load network observation: no Firebase/vendor requests.
- `npm audit --audit-level=high`: **0 reported vulnerabilities** at verification.
  Firebase 12.10.0 is pinned for the Node 22 environment; the transitive
  @grpc/grpc-js override is pinned to patched 1.14.6 rather than retaining the
  advisory-affected older version.

The test browser and Linux support libraries are bundled in a pinned npm package;
no external browser-download host is needed. Browser web security/CORS is not
disabled. Test-container-only no-sandbox flags are not app/user browser settings.

## Run or host

```bash
npm ci
npm run dev
# or:
npm run build
npm run preview
```

Port 5173 is the live preview, bound to 0.0.0.0. The production build can also be
served by a static HTTPS host; it uses relative base paths and hash navigation.
No permanent public deployment or Firebase backend deployment is claimed. Browser
installation depends on device/browser support; only app-shell offline behavior,
not device-specific installation, was tested.

See [the full web guide](../docs/WEB_APP.md) for format, storage, clinical and
Firebase configuration limitations. Original native notifications, on-device ML
translation and Android-specific platform services were not reimplemented.
