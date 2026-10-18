# Database recovery — partial success

**Current priority: the user needs full-size pictures, not the database index.**
Those full-size images remain unrecovered. See [the image recovery status](image-recovery.md)
for the actual bundled-image extraction and its resolution limits. The user has
only the APK/archive and database files, not downloaded app data or a device backup.

**`eanatomy_images.db` has been recovered and validated as ordinary SQLite.**

**`eanatomy.db` is not fully recovered.** Its outer app-asset wrapper has been
removed, but its remaining encryption has not been unlocked. Do not treat its
intermediate copy as a usable plaintext database.

The original Drive files were not replaced, renamed, deleted, or modified.
Original local input hashes were rechecked after processing. A new recovered
image database was uploaded as a separate Drive file; no public sharing was added.

## Usable recovered file

**Download eanatomy_images.recovered.db from Drive (private Drive link omitted from publication)**

| Check | Result |
| --- | --- |
| Output format | Standard SQLite 3 |
| Output size | 2,850,816 bytes |
| `PRAGMA integrity_check` | **`ok`** |
| Table | `image` |
| Row count | **34,167** |
| REA SQLite inspection | Passed |
| Uploaded Drive checksum | Matches the validated local output |
| Independent fresh-workspace reproduction | Byte-for-byte identical output |

Output SHA-256:

```text
d4f0c4b484d9ef30b59c1fdbb14054626448dac4903efc6b3ad80779c2648eb3
```

This database contains **image metadata/index records, not image pixels**. Its
columns are `module_imaios_code`, `contrast`, `sort_order`, `version`, and
`downloaded`. Open it with an ordinary SQLite viewer, such as DB Browser for
SQLite, and browse table `image`.

Local output: `recovery-data/recovered/eanatomy_images.recovered.db`.
REA evidence: `ev_4b5f3e6ac1431e7a249754dbe14cfdd166ead5b9ce16f9a76f62cd93896f6606`.

## Main database: unresolved inner layer

An outer-decoded working copy exists at:

```text
recovery-data/recovered/eanatomy.outer-decoded.db
```

- Size: **92,594,176 bytes**.
- SHA-256: `317277c6cfe14acd681e4041aaae9e54b2526ea262bb4d522384fbc88e98433e`.
- It still fails ordinary SQLite inspection with `file is not a database`.
- Its page-aligned size and the app's bundled SQLCipher engine are consistent
  with an additional SQLCipher layer. A valid inner key has not yet been found,
  so that identification remains provisional rather than a successful opening.
- Thirty-two read-only SQLCipher checks using eight artifact-derived values,
  binary-passphrase/raw-key interpretations, and compatibility modes 3/4 did
  **not** open its schema. This was not a password dictionary or account attack.
- No decrypted main database has been uploaded or represented as usable.

The recovered outer asset key is **not** automatically the main database's
SQLCipher password. Tracing the protected application's database-opening logic
remains unfinished. No additional library uploads are currently needed: both full
native packs and the original signed ARM64 split have now been obtained.

## What the supplied native packs established

Both full packs were downloaded and verified against Drive SHA-256 checksums.
All three files in each pack were confirmed to be the expected ELF architecture.
The ARM64 pack's libraries also match those in the separately supplied original
`split_config.arm64_v8a.apk`.

The app is `net.imaios.vetanatomy`, version 5.10.0, code 144. It uses native
libraries `libalice.so`, `libdexprotector.so`, and `libsqlcipher.so`. The bundled
SQLCipher library includes the version marker `4.9.0`; the host SQLCipher testing
library was 4.12.0 with explicit compatibility settings.

The retained package file manifest records hashes matching both supplied
original databases. The base resource archive and signed ARM64 split contain
matching signer-certificate fingerprints. These are consistency observations,
not a new trusted-publisher or full-APK signature-verification claim.

### Recovery method and controls

1. REA's GNU objdump adapter recorded native headers and disassembly without
   changing the supplied libraries.
2. A protected x86-64 native memory image was decoded into a working copy.
   All four native segment lengths and checksums were verified. The image has
   no standalone ELF header and was not presented as an installable library.
3. Bounded CPU emulation reproduced isolated initialization/crypto computations,
   using actual signing metadata and DEX bytes. The normal native initialization
   data-state update was reconstructed in working memory. Native code-integrity,
   key-unsealing, and root-material fingerprint checks passed. Original binaries
   and app account/subscription checks were not patched.
4. Authenticated resource-directory data and a small key-helper DEX were recovered.
   The helper's SHA-1 and Adler-32 checksums both passed. Its arithmetic was
   evaluated with a restricted interpreter, not an Android runtime.
5. The app's module key schedule was followed. Its derived asset build tag matches
   the tag in both database wrappers.
6. The outer wrappers were identified as the app's protected stream/compressed
   asset formats. A portable **8-round ChaCha** decoder was independently checked
   against isolated native control blocks. The image database also required raw
   deflate decompression and matched its declared uncompressed size exactly.
7. SQLite integrity checking and REA inspection validated the recovered image DB.
   Five decoder unit tests passed. The complete persisted-source workflow was
   rerun in a fresh private workspace and produced the identical image DB hash.

No supplied app shared library was loaded into the host process. No Android app
or account session was launched. Android syscalls and unexpected native imports
were rejected during isolated computations. The only shared library loaded by
the portable decoder was built from this repository's own C source; host
SQLCipher checks used the separately installed Python package.

## Reproducibility and privacy

The reproducible partial-recovery source is in
[`tools/recovery/`](../tools/recovery/README.md). It accepts only the exact
inspected input hashes, creates a fresh private workspace, checks the originals
again afterward, and explicitly exits **2 for partial recovery**.

- App archives, native binaries, decrypted app-code intermediates, database
  contents, and recovered key material are **not included in Git**.
- `google_drive/`, `recovery-data/`, `.venv/`, and Python caches are ignored.
- Sensitive intermediate material stays in private working directories and is not
  printed as key values, included in reports, or uploaded with the recovered DB.
- The delivered Drive database's size and SHA-256 were checked after upload.
- The remaining main-database limitation is explicit in both the CLI result and
  the report; an empty replacement DB or a fabricated recovered file was not made.

## Original database checksums

```text
eanatomy.db (92,594,192 bytes)
c8e361a5f1ecc54b51fad61552f43760bf8b83a91b8961f6c4b8c40fe44a103d

eanatomy_images.db (423,115 bytes)
81705036812b64032786a2b8fb6c0db6c39fbe36c386a91a6c661f4b721d4fb3
```

## Other recovery routes for the main database

A device on which the unmodified app still reads this content, an app-supported
export/backup, or original source/key-derivation code may provide a more direct
route for the remaining layer. Do not uninstall the original app, clear its data,
or delete keystores, configuration, or backups. Do not post passwords or secret
keys in chat. No Drive version-history recovery was performed.
