#!/bin/bash
set -euo pipefail
echo "=== REA Verification ==="
echo "Node: $(node -v) npm: $(npm -v)"
echo "rea: $(rea --version) at $(which rea)"
echo "rea-agents: $(npm list -g rea-agents 2>&1 | grep rea || true)"
echo
echo "--- rea doctor (summary) ---"
rea doctor 2>&1 | head -n 40
echo
echo "--- rea capabilities (first 40 lines) ---"
rea capabilities 2>&1 | head -n 40
echo
echo "=== OK ==="
