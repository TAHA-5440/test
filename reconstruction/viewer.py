#!/usr/bin/env python3
"""
eAnatomy Image Inventory Viewer — Evidence-backed reconstruction
Built from REA Evidence: eanatomy_images.recovered.db (sha256 d4f0c4b484d9ef30b59c1fdbb14054626448dac4903efc6b3ad80779c2648eb3)
REA provider: sqlite SQLite 3.54.0, operation inspect_sqlite_database
Evidence IDs: ev_e964c7859518..., ev_db27eae72a6e950..., ev_a4ef6fca5b12ff...

This reconstructs how eAnatomy resolves ordered image stacks per module/contrast/version.
Original app logic inferred from DB constraints:
- PK (module_imaios_code, contrast, sort_order, version) => ordered stack
- downloaded flag => cache state
- sort_order contiguous 1..N => viewer pagination
"""
import sqlite3, pathlib, argparse, json

DB = pathlib.Path(__file__).parent.parent / "evidence" / "eanatomy_images.recovered.db"

def list_modules():
    con = sqlite3.connect(DB)
    cur = con.cursor()
    cur.execute("SELECT DISTINCT module_imaios_code FROM image ORDER BY module_imaios_code")
    return [r[0] for r in cur.fetchall()]

def list_contrasts(module):
    con = sqlite3.connect(DB)
    cur = con.cursor()
    cur.execute("SELECT DISTINCT contrast FROM image WHERE module_imaios_code=? ORDER BY contrast", (module,))
    return [r[0] for r in cur.fetchall()]

def get_stack(module, contrast, version=1):
    con = sqlite3.connect(DB)
    cur = con.cursor()
    cur.execute("SELECT sort_order, downloaded FROM image WHERE module_imaios_code=? AND contrast=? AND version=? ORDER BY sort_order", (module, contrast, version))
    return cur.fetchall()

def trace_feature(module, contrast):
    """Trace a literal feature (module) through inventory — mirrors REA trace semantics"""
    con = sqlite3.connect(DB)
    cur = con.cursor()
    cur.execute("SELECT COUNT(*) FROM image WHERE module_imaios_code=? AND contrast=?", (module, contrast))
    count = cur.fetchone()[0]
    cur.execute("SELECT MIN(sort_order), MAX(sort_order) FROM image WHERE module_imaios_code=? AND contrast=?", (module, contrast))
    mn, mx = cur.fetchone()
    return {"module": module, "contrast": contrast, "count": count, "range": [mn, mx]}

if __name__ == "__main__":
    import sys
    if len(sys.argv) < 2:
        print("Usage: viewer.py <command> [args]")
        print("Commands: modules, contrasts <module>, stack <module> <contrast> [version], trace <module> <contrast>")
        sys.exit(1)
    cmd = sys.argv[1]
    if cmd == "modules":
        for m in list_modules():
            print(m)
    elif cmd == "contrasts":
        for c in list_contrasts(sys.argv[2]):
            print(c)
    elif cmd == "stack":
        mod, con = sys.argv[2], sys.argv[3]
        ver = int(sys.argv[4]) if len(sys.argv) > 4 else 1
        for sort_order, dl in get_stack(mod, con, ver):
            print(f"{sort_order:04d} downloaded={dl}")
    elif cmd == "trace":
        print(json.dumps(trace_feature(sys.argv[2], sys.argv[3]), indent=2))
    else:
        print(f"unknown {cmd}")
