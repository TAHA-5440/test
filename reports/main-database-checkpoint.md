# Technical checkpoint: main database still unresolved

**Updated priority:** the user needs full-size images, not the index or bundled
216×216 previews. They confirmed they only have the supplied archives/databases,
with no downloaded app data or device backup. The full-size image goal remains
unmet. See `image-recovery.md`; do not repeat the same device/backup questions.
Whether the locked main database contains embedded full-size media is unknown.

The usable delivered result is `eanatomy_images.recovered.db`, SHA-256
`d4f0c4b484d9ef30b59c1fdbb14054626448dac4903efc6b3ad80779c2648eb3`.
The main database is only outer-decoded. See `database-recovery.md` for the user
result and Drive download link. This checkpoint is not a decrypted main DB.

## Resume without asking for the same inputs again

The files already exist in the connected Drive. If local ignored directories
are absent in a restored sandbox, retrieve them again by filename and verify
against `tools/recovery/prepare_inputs.py`. Do not commit the datasets or keys.

The persisted `tools/recovery/run.py` workflow reproduces the entire validated
partial recovery in a fresh private directory. It was integration-tested, and
its image DB matches the delivered file byte for byte. Exit code 2 is intentional.
The work directory's `workspace/` contains private symlinks named `google_drive`
and `recovery-data` for the release-specific stage scripts.

## Established protection layers

- The x86-64 DexProtector loader contains an appended encrypted, LZ4-compressed
  native image. Its isolated key-material arithmetic and four segment checksums
  validate reconstruction. The memory image is not a standalone ELF library.
- The outer loader clears dynamic symbol/string metadata, RELA records, and RELR
  words before initialization. Reproducing this canonical data state matters for
  the native image-key unsealing check. An analysis ELF with a fabricated header
  must never replace the original memory image used in that integrity check.
- A normal startup instruction at native offset `0x1c0e4` updates one byte of the
  derivation salt. Reconstructing this working-memory state, using the actual
  signer block and actual DEX prefix, produces a root-material fingerprint that
  passes the native comparison. Failed fingerprints are not accepted as keys.
- Authenticated resource-directory metadata is at the end of `assets/assets.dat`.
  Its length is the final byte; the preceding 16 bytes are its authentication
  tag. The directory lists resource types 9, 5, 4, 1, 10, 8, and 6.
- Resource 9 is a small authenticated helper DEX. Its own SHA-1 and Adler-32 both
  match. Its generated arithmetic, the primary DEX's byte-substitution helper,
  and the native constant accessor supply an additional key fragment. The
  bounded interpreter executes 747 instructions with no Android/runtime calls.
- That fragment must be mixed into the root material before replaying the
  enabled module-domain key schedule. Deriving the asset key directly from the
  root material is wrong. The correct asset-module output yields the expected
  build tag `0xdbb10f25` for both original databases.
- The database wrappers use **ChaCha8**, not standard ChaCha20. The portable
  implementation matches native 64-byte control blocks for both input files.
  The compressed image DB then expands with raw deflate into a valid 2,850,816
  byte SQLite DB with 34,167 rows. The main wrapper yields 92,594,176 bytes that
  remain unreadable as ordinary SQLite.

## Optional deeper static analysis already investigated

`tools/recovery/inspect_protected_resources.py` can run in the generated private
`workspace/` using the same Python environment after the recovery workflow.
It is an investigator utility, not an app rebuild or a main-database decryptor.
It writes sensitive decoded app resources only under the ignored working state.

The authenticated directory's resource types have these validated sizes:

| Type | Encoded bytes | Observed decoding |
| --- | ---: | --- |
| 9 | 1,752 | Authenticated helper DEX; 1,736 bytes |
| 5 | 4,271,740 | Module-1 ChaCha8, then Zstandard; 11,419,924 bytes |
| 4 | 844,034 | Module-2 authenticated decoding, then Zstandard; 2,596,984 bytes |
| 1 | 482,925 | Module-3 authenticated decoding; 482,909 bytes |
| 10 | 242 | Module-4 authenticated decoding; 226 bytes |
| 8 | 23,644 | Not fully investigated |
| 6 | 4,923 | Not fully investigated |

Resource 5 begins with a protected DEX representation but does not have matching
ordinary DEX header/checksum fields: declared size 10,944,512 versus the expanded
11,419,924 bytes, and mismatching SHA-1/Adler-32. It must not be represented as a
validated, runnable recovered DEX. A parser-only in-memory view with its Adler-32
adjusted for investigation exposed 39 class definitions, but did not produce a
SQLCipher-opening callsite or the inner database key. That view was not exported
as an app and did not overwrite the original decoded resource.

The decoded metadata includes SQLCipher API descriptors, but direct byte-string
searches have not exposed the database filename or passphrase. The app's further
protected/virtualized database-opening logic is an unfinished investigation.

## Inner-key diagnostic, not a recovery claim

`tools/recovery/check_main_sqlcipher.py` implements the targeted read-only check
used here. The host SQLCipher package is separate from the supplied Android
library; supplied Android `.so` files are never loaded into the host process.
Eight already-derived artifact values were tested as binary passphrases and raw
keys with compatibility settings 3 and 4: 32 attempts, zero schema openings.
No password dictionary or remote account session was used. This does not prove
that the main data is damaged or unrecoverable, nor identify its actual key.

Preserve the originals and any working app/device state. A supported export from
an existing unmodified app instance or original database-opening source code may
provide another route; do not modify licensing/account checks or claim arbitrary
strong encryption can be reversed without the required key material.
