# Recovered Pharmapedia client code — reference export

Package: `vet.pharmapedia.vetpharmapediapakistan`, version **1.0.13**.

**This is recovered/decompiled client code, not the original Kotlin/Android
Studio project and not a verified buildable application.** Optimization, R8
renaming, compiler-generated classes, and decompiler limitations remain.

## Complete available DEX code

All **11,178 class definitions** from the three supplied DEX files have both a
Java approximation and an instruction listing in these source-only ZIPs:

| Source archive | Classes | Contents |
| --- | ---: | --- |
| [classes.dex-source.zip](archives/classes.dex-source.zip) | 10,189 | Java approximations + instruction listings |
| [classes2.dex-source.zip](archives/classes2.dex-source.zip) | 36 | Java approximations + instruction listings |
| [classes3.dex-source.zip](archives/classes3.dex-source.zip) | 953 | Java approximations + instruction listings |

Extract an archive to browse its `java/` and `bytecode/` directories. Bulk library
code is archived to avoid adding more than 10,000 generated files to the Git tree.
For convenient online browsing, the 953 classes from `classes3.dex` also appear
in [java/](java/). They include application code, obfuscated client classes, and
some dependencies. The full archives also contain third-party library code.

## Other readable exports

- [app-bytecode/](app-bytecode/): instruction listings for 43 application-namespace classes.
- [resources/decoded-xml/](resources/decoded-xml/): decoded manifests/layout/resource XML.
- [resources/strings/](resources/strings/): 145 locale string XML exports.
- [metadata/class-index.csv](metadata/class-index.csv): full class inventory.
- [metadata/class-export-status.json](metadata/class-export-status.json): per-class export status.
- [metadata/medicine-model-definitions.json](metadata/medicine-model-definitions.json): data structures, not records.
- [metadata/medicines-schema-only.sql](metadata/medicines-schema-only.sql): table definition only.
- [source-manifest.json](source-manifest.json): input fingerprint and archive checksums.
- [redaction-report.json](redaction-report.json): recognized credential/configuration redactions, without values.
- [upstream-notices/](upstream-notices/): notices available in the supplied package.

## What is not included or recovered

- The original Android Studio/Gradle project, original Kotlin, comments, complete
  original symbol names, or a tested rebuild.
- Original native C/C++ source. The app's native binary is not source code and is
  not committed here.
- Firebase backend/server source, security rules, administrator credentials,
  service-account keys, signing private keys, or a populated medicine database.
- Original APK/DEX binaries, pictures, app-created caches, personal data files,
  or other private recovery inputs/intermediates.

The app creates a local `medicines_DB` cache from Firestore collection
`NewMedicinesData`. Those downloaded records were not included in the XAPK and
have not been recovered. The SQL file above is **not** a recovered medicine DB.

## Publication hygiene

Recognized client API-key/token/private-key patterns and named credential-like
settings were sanitized before publication. Client configuration must be supplied
from the appropriate authorized project if doing further development. The
redaction report does not contain removed values. Scanning is not a guarantee
that every encoded constant can be classified as secret/non-secret.

The original supplied APK bytes were not modified, rebuilt, re-signed, or
runtime-tested. These public text exports are intentionally not byte-identical
original application files because of decompilation and configuration redaction.
No licensing/account checks were removed as a recovery measure.

See [NOTICE.md](NOTICE.md) for ownership and licensing limitations. The export does
not grant or replace rights in application/third-party code.
