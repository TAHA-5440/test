
# REA Forensic Plan — eanatomy.db (92MB) and eanatomy_images.db (423KB wrapper)

## Current Evidence
- eanatomy_images.recovered.db: 2.8MB, SQLite 3.54.0, integrity ok, 34167 rows — REA Evidence generated
- eanatomy_images.db: 423KB, application/octet-stream — likely compressed wrapper (gzip/deflate) containing the recovered DB
- eanatomy.db: 92MB, application/octet-stream — noted as "not yet fully decrypted" — likely SQLCipher encrypted

## REA Workflow for Encrypted DB (from docs/eanatomy forensic guide)
1. **Identify wrapper format** (REA inspect-artifact, extract-artifact):
   ```
   rea inspect-artifact /path/to/eanatomy_images.db --json
   rea extract-artifact /path/to/eanatomy_images.db
   file eanatomy_images.db  # check magic bytes
   hexdump -C eanatomy_images.db | head
   ```

2. **Inspect encrypted DB header**:
   ```
   hexdump -C eanatomy.db | head -n 20
   # SQLite header is "SQLite format 3\0" — encrypted will NOT match
   # SQLCipher v3/v4 header starts with random salt (16 bytes), then HMAC
   # REA inspect-sqlite-database will return capability_unavailable for encrypted
   ```

3. **Recover key** (requires APK or runtime):
   - Extract APK, find `getDatabasePath` / `SQLiteDatabase.openOrCreateDatabase` / `net.sqlcipher` calls
   - Use REA Android providers if APK available:
     ```
     rea inspect-android-package /path/to/eanatomy.apk --json
     rea search /path/to/apk "sqlcipher" --kind strings
     rea search /path/to/apk "PRAGMA key" --kind strings
     ```

4. **Once key recovered**:
   ```
   sqlcipher eanatomy.db "PRAGMA key='...'; PRAGMA integrity_check;"
   rea inspect-sqlite-database ./eanatomy_decrypted.db --schema-scope database --json
   ```

## What REA returns for encrypted (expected failure)
- `code: capability_unavailable` or `operation: inspect_sqlite_database` with `category: unsupported_target`
- We have already proven REA works on decrypted variant (Node 26.12)

## Next step pending: APK or key
If you can share the APK (Imaios eAnatomy) or the runtime key from Drive folder, REA can complete the chain.
