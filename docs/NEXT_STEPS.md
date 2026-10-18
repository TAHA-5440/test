# Next steps — completing eanatomy.db decryption with REA

You have 2 remaining Drive files:
- `eanatomy_images.db` (423 KB, Drive 1Vjy8tu43uHG...) — wrapper; `eanatomy_images.recovered.db` is its decompressed content
- `eanatomy.db` (92 MB, Drive 1Q1uHZ...) — main DB, described as "not yet fully decrypted"

## What to do next

1. **Pull both files to `evidence/`** (same flow as recovered.db):
   ```bash
   # via Drive connector or rclone
   # Then place as evidence/eanatomy_images.db and evidence/eanatomy.db
   ```

2. **REA wrapper inspection**:
   ```bash
   rea inspect-artifact evidence/eanatomy_images.db --json
   rea extract-artifact evidence/eanatomy_images.db --integrity-policy record-and-continue
   hexdump -C evidence/eanatomy_images.db | head
   ```

3. **Encrypted header check**:
   ```bash
   python3 -c "print(open('evidence/eanatomy.db','rb').read(32).hex())"
   rea inspect-sqlite-database evidence/eanatomy.db --json  # expect failure for encrypted
   ```

4. **Key recovery** (needs APK):
   - If you have the IMAIOS eAnatomy APK, drop it in `evidence/` and run:
     ```bash
     rea inspect-android-package evidence/eanatomy.apk --json
     rea search evidence/eanatomy.apk "sqlcipher" --kind strings
     rea search evidence/eanatomy.apk "PRAGMA key" --kind strings
     rea inspect-android-method # on class that opens DB
     ```
   - REA's Android provider (`jadx` via `REA_JADX_MCP_JAR`) can decompile the exact overload.

5. **Decrypt and re-inspect**:
   ```bash
   sqlcipher evidence/eanatomy.db "PRAGMA key='YOUR_KEY'; ATTACH DATABASE 'decrypted.db' AS plain KEY ''; SELECT sqlcipher_export('plain'); DETACH DATABASE plain;"
   rea inspect-sqlite-database decrypted.db --schema-scope database --json > evidence/eanatomy_decrypted.json
   ```

All steps are Evidence-backed (REA records sha256, limitations, authority). Share APK or wrapper bytes and REA will complete the chain in this repo.
