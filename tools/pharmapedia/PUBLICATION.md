# Source-code publication workflow

The user's requested destination is the existing `TAHA-5440/test` repository.
Publication is to the Arena session branch `arena/1d9ca4ef-test`, not `main`.
The repository is public, so publication exports are separate from private inputs.

## Prepare a fresh source export

```bash
.venv/bin/pip install -r tools/pharmapedia/requirements-publication.txt
.venv/bin/python tools/pharmapedia/publish_source.py \
  --input 'google_drive/Vet+Pharmapedia+Pakistan_1.0.13_APKPure.xapk' \
  --exports recovery-data/pharmapedia/returned/exports \
  --output recovered-source/pharmapedia-1.0.13
```

The output directory must not exist. The original contents-return workflow must
have produced the referenced private exports first. Input SHA-256 is verified;
original APK files are not changed or copied into the publication tree.

The publisher exports all 11,178 classes from all three DEX files, recording Java
approximations and instruction listings in three ZIPs. Large bulk library code
is archived rather than adding over 10,000 generated files to Git. The 953 client /
obfuscated / dependency classes from classes3.dex are also conveniently browsable
as individual Java files. A per-class/time budget protects against a stalled
Java decompiler; instruction listings are retained even if Java fails. This run
produced all 11,178 Java approximations as well as all instruction listings.

Decoded XML, locale strings, model definitions, schema-only SQL, and available
upstream notices are included. Native C/C++ source, original Gradle/Kotlin project,
Firebase server code, signing secrets, and medicine records are not recovered.
No original APK/DEX/native binaries, databases, media, or recovered keys are added.

## Credential and privacy controls

Recognized credential patterns and named configuration values are sanitized
before writing any publication archive, including recognized credentials wrapped
in Base64. Removed values are not stored in the redaction report. Rules include
private-key blocks, Google client API keys, recognizable provider tokens, JWTs,
URL userinfo, and credential-setting literals. Generic SDK label strings are not
treated as actual assignment credentials. A reviewed SDK default client API key
was also sanitized in both its Java and instruction-listing representations.

Private Drive URLs are omitted from public notes; original local note copies can
remain under ignored `recovery-data/publication/private-notes/`. Source APKs,
recovery intermediates and keys remain in ignored directories.

Run the archive-aware offline audit, which scans inside every source ZIP:

```bash
.venv/bin/python tools/pharmapedia/audit_publication.py \
  recovered-source/pharmapedia-1.0.13 tools reports README.md package.json \
  --report recovery-data/publication/final-audit.json
```

The auditor uses recognized credential detectors without remote verification or
network filters. Exact hashed exceptions in `publication-scan-exceptions.json`
cover reviewed noncredential SDK header/resource/JSON names, a validation message,
and a synthetic test fixture—not credential material. New or changed values do
not match those exceptions and must be reviewed. Do not publish while unexplained
findings remain. Entropy alone is not a useful credential verdict for generated code with public integrity
hashes and cryptographic constants. No scanner can guarantee that every encoded
constant has been classified, so the audit scope and redaction limitations are
explicit rather than a blanket promise about arbitrary hidden data.

Before committing, validate source-archive CRCs/hashes/class counts, run tool unit
tests, confirm private/binary inputs are ignored, inspect staged file names/sizes,
and verify that no private artifact links or credential files are staged. Use
regular git commits/pushes to the fixed session branch; never force-push or switch
to another branch to publish this session.

No new license is assigned to recovered third-party code. Available original
notices are retained, and the recovered-code NOTICE states the limitations.
