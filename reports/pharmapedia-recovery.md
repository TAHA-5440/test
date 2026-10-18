# Vet. Pharmapedia Pakistan 1.0.13 — returned package contents

**Follow-up request: the actual medicine database remains unrecovered.** The user
confirmed they only have the XAPK. The exact cache is `medicines_DB` and the data
collection is `NewMedicinesData`; neither actual cache rows nor a server export
has been supplied. See [the database recovery status](pharmapedia-medicine-database.md).
The contents ZIP below must not be represented as a populated medicine database.

**Download the returned ZIP from Drive (private Drive link omitted from publication)**

File: `Vet-Pharmapedia-Pakistan_1.0.13_recovered_contents.zip`.
Size: **17,759,747 bytes**.
SHA-256: `19b7a32a8298d69e27586b68856abbc180611962e3fa2c7164f3d813138fce57`.
The uploaded file reports that same size and SHA-256.

Extract the ZIP and open **`index.html`** for an offline contents browser. The
original XAPK in Drive remains unchanged; the returned archive is a separate file.
No public-sharing permission was added.

## What was returned

| Contents | Result |
| --- | --- |
| Original APK components | **3**, byte-identical to the supplied XAPK |
| Original files copied out, including component copies | **1,018** |
| Original images/graphics/animation | **186**, source-byte verified and decoded |
| Default resource strings | **342**, XML and spreadsheet-safe CSV |
| Locale string XML exports | **145** |
| Decoded manifest/layout/resource XML | All packaged XML decoded; no fallback failures |
| Indexed classes across three DEX files | **11,178** |
| App-namespace bytecode listings | **43** |
| Decompiled Java approximations from `classes3.dex` | **953** |
| Medicine-table schema definitions | **1**, explicitly schema-only |
| Actual medicine records recovered | **0** — no populated database found in this package |

Every original APK entry is retained under `original-apk-contents/`. The original
base APK and two split APK files are in `app-components/`. The XAPK icon/manifest,
readable exports, REA observations, file-hash provenance, and usage notes are also
included. Java exports are approximations, not the original Kotlin/Android Studio
project or a build-tested reconstruction. Original DEX bytecode remains available.

The media are mainly original interface icons, language flags, splash animation,
and included contact artwork, **not a recovered medicine/product-photo catalogue**.
All returned media were matched back to actual source bytes. The splash GIF's
151 frames were decoded for checking and preserved as its original GIF. An
unrelated generated preview was excluded and removed; no generated picture is
part of the returned content.

## Important limitation: medicine data is downloaded later

No packaged file had a SQLite database header, and no populated medicine database
was identified in the XAPK. Static code inspection shows Firebase Realtime
Database/Firestore access and Room cache handling, including methods/classes named
`readLatestMedicinesDataFromFirebase` and `insertDataToRoomDB`. The recovered
`medicines_table` definition includes fields such as `docId`, `saltName`,
`brandName`, `contraIndications`, `overview`, `indications`, `availableForms`, and
`dosageDetail`, but **the definition is not the records**.

The return does not claim to recover a device-created cache, remote catalogue,
account data, or backend. No vendor/Firebase service was queried. No medicine rows,
clinical advice, prices, or empty replacement database were manufactured. Clinical
correctness and current information were not independently validated.

## Package integrity and installation scope

- Supplied file: `Vet+Pharmapedia+Pakistan_1.0.13_APKPure.xapk`, **15,118,799 bytes**.
- Input SHA-256: `6f9781939a3c8caf967aa7d0bbd9429c6f968af66140dcef0db1d426c2d1534c`.
- Outer XAPK ZIP CRC check and all three inner APK ZIP CRC checks passed.
- Package: `vet.pharmapedia.vetpharmapediapakistan`.
- Version: **1.0.13**, code **13**; minimum SDK **29** (Android 10), target SDK **36**.
- The bundle contains the base, `config.armeabi_v7a.apk`, and `config.hdpi.apk`.
- The parsed signer-certificate fingerprints match across the three components.
  This is not independent publisher authentication or complete APK signature
  verification.
- Component bytes, signing information, licensing/installer checks, and account
  behavior were not changed. No app was rebuilt or re-signed.

**No container corruption was found in this copy.** That does not establish a
successful Android installation, app launch, compatibility with a particular
phone, backend availability, or a security certification. The supplied native
split is `armeabi-v7a`; a compatible device/system is required. A base APK by
itself should not be treated as the complete split installation.

`INSTALLATION.txt` explains the unchanged component set and an optional ordinary
`adb install-multiple` command. It was not executed here. Do not uninstall an
existing app or clear its data merely to work around a conflict.

## REA and complementary static tools

REA **6.5.0** successfully inspected both the XAPK and base APK with
`inspect-artifact`:

- XAPK evidence: `ev_27fd0636cb34dc9a130c4b9ae3073b39a177e135afbba29d772a7458f4133240`.
- Base APK evidence: `ev_1662e8cf99db4ddcd8fe5e7138511e9df1084967821772ff4073aa595ec95519`.

The Android-specific REA operation was attempted but reported
`capability_unavailable`: it requires a caller-supplied `jadx-headless-mcp` 0.7.1
JAR. A verified upstream-release download could not complete through the allowed
network path. That operation was **not** represented as a successful decompilation.
Androguard **4.1.4** supplied complementary static manifest/resource/DEX inspection
and DAD Java approximations; Pillow **13.0.0** validated media. No supplied app
native library or app code was executed.

The returned `evidence/` directory preserves the actual REA observations, including
the unsupported-provider result. Source-derived content and provenance are kept
separate from explanatory exports. Resource text is HTML-escaped in the offline
viewer; CSV formula-like cells are escaped, with exact values retained in XML.

## Reproducibility and privacy

Reproducible source: [`tools/pharmapedia/`](../tools/pharmapedia/README.md).
The workflow checks the exact input hash, refuses path traversal/symlinks/duplicate
entries/size excesses, uses a fresh output directory, checks original hashes again,
and validates the returned ZIP. Source archives, APK files, decoded resources,
images, and original unsanitized app-source approximations stay under ignored
private directories. In a later explicit source-publication request, sanitized
reference exports were added separately under `recovered-source/pharmapedia-1.0.13/`;
raw APKs, private data and keys remain excluded. Private Drive links in this
publication copy of the report are intentionally omitted.

All three APK components and all 186 media files were checked against source
bytes. All 378 offline viewer image/file links resolve locally, with no external
resources. Eight safety unit tests passed. A fresh-workspace run reproduced all
1,018 original file copies and all 186 media files byte for byte. ZIP hashes can
differ between runs because evidence includes workspace paths and ZIP timestamps;
no byte-identical regenerated ZIP claim is made. No installation or runtime repair
is claimed.
