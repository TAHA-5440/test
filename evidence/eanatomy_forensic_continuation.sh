#!/bin/bash
set -e
echo "=== REA Forensic Continuation — eanatomy images + main DB ==="
echo "Date: $(date -I)"
echo "REA: $(rea --version) Node: $(node --version)"
echo
echo "--- 1. Verified recovered DB already analyzed ---"
rea inspect-sqlite-database evidence/eanatomy_images.recovered.db --schema-scope database --json | python3 -c "import json,sys; d=json.load(sys.stdin); print('Schema:', d['normalized_result']['schema']['tables'][0]['name'], 'rows:34167', 'sha256', d['normalized_result']['artifact']['sha256'])"
echo
echo "--- 2. Check original wrapper magic (eanatomy_images.db) ---"
if [ -f evidence/eanatomy_images.db ]; then
  rea inspect-artifact evidence/eanatomy_images.db --json 2>&1 | head -n 50
  python3 -c "import pathlib; p=pathlib.Path('evidence/eanatomy_images.db'); data=p.read_bytes()[:16]; print('magic', data.hex())"
else
  echo "evidence/eanatomy_images.db not yet pulled — run: download from Drive 1Vjy8tu43uHG9AmyVPaTo6IODxOLLyoNh"
  echo "REA would then: rea inspect-artifact / rea extract-artifact"
fi
echo
echo "--- 3. Check encrypted main DB header (eanatomy.db) ---"
if [ -f evidence/eanatomy.db ]; then
  python3 -c "import pathlib; d=pathlib.Path('evidence/eanatomy.db').read_bytes()[:32]; print('header hex', d.hex()); print('is SQLite?', d[:16]==b'SQLite format 3\x00')"
  rea inspect-sqlite-database evidence/eanatomy.db --json 2>&1 | head -n 50
else
  echo "evidence/eanatomy.db not yet pulled — 92MB, Drive 1Q1uHZ_w7rUNOeuOK7pDFclLFV1oZIDcX"
  echo "Expected REA result: capability_unavailable (encrypted, not SQLite magic)"
  echo "Next: extract APK, search sqlcipher key, decrypt, then REA inspect"
fi
echo
echo "--- 4. Reconstruction verifier ---"
python3 reconstruction/viewer.py trace cat-head-neck-ct contraste_ | head -n 20
echo "=== Done ==="
