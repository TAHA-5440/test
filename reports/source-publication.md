# Sanitized source-code publication

Prepared for the public `TAHA-5440/test` repository, on the fixed session branch
`arena/1d9ca4ef-test`. The default `main` branch is not the push destination.

## Included

- Reference client exports covering all 11,178 DEX classes: 11,178 Java
  approximations and 11,178 instruction listings in three source-only archives.
- 953 browsable Java exports, application bytecode listings, decoded XML and
  locale strings, data models, schema-only SQL, manifests, and available notices.
- REA setup/lockfile and the reproducible recovery/publication/audit tooling.
- High-level analysis reports with private Drive artifact URLs omitted.

The bulk code is archived to remain below the workspace file-count limits.
Source archive CRCs, SHA-256 values, and Java/instruction-listing counts were
checked. The publication-specific and earlier recovery tool suites passed all
28 tests. Python tooling syntax checks and `git diff --check` passed.

## Privacy review

Recognized client credentials were sanitized before publication, including the
app's client API configuration and a Base64-encoded SDK default key. Removed
values are not in the redaction report. An offline, archive-aware audit covered
all 22,359 entries inside the three source ZIPs as well as the loose source,
resource and documentation files. It reported zero unresolved findings after
review of eight exact noncredential SDK-label/message/test-fixture matches.
No remote credential validation was used. Scanner scope is explicit and is not
an absolute guarantee about every encoded constant.

Original APK/DEX/native binaries, medicine databases, media, recovered keys,
service-account keys, signing keystores, private inputs and private artifact URLs
remain outside Git. The original input/archive artifacts were not changed.

## Limits

These are decompiled reference exports, not the original Kotlin/Gradle project
or a build-verified application. Native C/C++ source and Firebase backend/server
source were not recovered. No original signing private keys or medicine records
are included. No licensing/account bypass or runtime app repair is claimed.

See `recovered-source/pharmapedia-1.0.13/README.md` and its source/security manifests
for the complete export index and limitations.
