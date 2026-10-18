# Image recovery — full-size images still unrecovered

## User's required outcome

The user clarified that **full-size image files**, not the SQLite image index or
small module previews, are the priority. They confirmed they currently have
**only the supplied APK/archive and database files**, with no downloaded app data
or device backup available. Do not repeatedly ask for the same missing device
backup, encryption information, or native libraries.

**This full-size-image goal has not been achieved.** The bundled assets below are
an ancillary partial result, not a substitute for the requested original images.
No preview was upscaled or AI-generated to pretend it was a recovered original.

## What was actually recovered

Download the bundled PNG assets, offline gallery, and labelled overview (private Drive link omitted from publication)

ZIP: `vetanatomy-bundled-image-assets.recovered.zip` — **8,547,106 bytes**.
SHA-256: `0fea0137ae805d130fecf2269e617be466dea5aab6699949c9a36a26bcc6656e`.
The uploaded Drive checksum matches the local deliverable.

| Actual source assets | File count | Original pixel dimensions |
| --- | ---: | --- |
| Module-preview PNGs | 45 | **216 × 216** |
| Orientation-diagram PNGs | 408 | 40 × 40 or 120 × 120 |
| Category-icon PNGs | 334 | 56 × 56 |
| Total source PNG files | **787** | Includes duplicates/density variants |

There are 749 distinct decoded file hashes. These are real PNG assets decrypted
from `base_no_db.zip`, not pictures extracted from the image-index database.
Each passed PNG chunk-integrity verification and full pixel decompression.
Original decoded PNG bytes were preserved without re-encoding, enlargement, or
watermark removal. The overview is only a labelled downscaled contact sheet.

The ZIP includes `index.html` for offline browsing after extraction, `README.txt`
with limitations, and `manifest.json` with source paths, dimensions, and hashes.
It contains no recovered keys, app binaries, or databases. No public sharing was
added to the Drive file, and originals were not changed.

## Evidence about the full image series

- The recovered `eanatomy_images.db` contains an `image` table with five index
  columns and **no image-pixel/BLOB column**. Its 34,167 rows cover 43 module codes.
- All 34,167 records in this **packaged** index have `downloaded = 0`. This is
  consistent with separate module downloads; it does not reveal the state of an
  unexamined live device or prove the contents of the locked main database.
- Comparing the retained package file manifest with the resource ZIP found only
  two missing signed asset entries: `assets/eanatomy.db` and
  `assets/eanatomy_images.db`. Both database files were separately supplied.
  The current resource ZIP is therefore not missing another image pack listed
  in that manifest. This is a package-consistency observation, not independent
  publisher authentication.
- The anatomical PNG assets found in that resource ZIP have only the dimensions
  listed above. Other resource images are app-interface graphics; they have not
  been represented as a full-resolution anatomical scan series.
- The supplied native libraries are code, not a recovered source of the full
  image series. Additional copies of those same libraries are not needed.

## What remains unknown

`eanatomy.db` has had its outer asset wrapper removed but still cannot be opened
as ordinary SQLite. Its remaining key has not been recovered. **Whether it
contains additional embedded image data is not yet established.** Do not claim
that full images are definitely present there, or definitely absent.

No validated full-size frames or image-series pack has been recovered from the
files inspected. An image index does not contain enough information to recreate
missing pixel data, and enlarging 216-pixel previews does not restore originals.

The remaining local investigation is the protected main database's contents/key.
A genuine downloaded image pack, device backup, or supported original-content
export would provide another source if one becomes available later. None is
currently supplied; do not promise that further decryption will necessarily find
full-size images.

## Reproducible implementation and checks

- `tools/recovery/recover_bundled_images.py` performs safe extraction, the known
  asset-wrapper decode, PNG validation, and gallery/ZIP creation.
- The full `tools/recovery/run.py` workflow now includes this stage and still
  returns **exit 2 for partial recovery**. Its result explicitly records
  `full_scan_series_recovered: false`.
- Eleven unit tests pass, including wrong-tag, incorrect-size, corrupted-PNG,
  stream-control, and counter-boundary checks.
- A fresh isolated workflow reproduced all 787 recovered PNGs byte for byte.
- Private input archives, original/decrypted images, native code, databases, and
  intermediate keys remain outside Git under ignored working directories.

See [the database recovery report](database-recovery.md) for the separate
image-index recovery and the unresolved main database.
