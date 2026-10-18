# REA Installation Log

## Source
- Repository: https://github.com/morluto/rea
- Description: Reverse engineer anything with agents, from app behavior down to native binaries.
- License: MIT
- Stars: 313k+, Forks: 79k+
- Language: TypeScript

## Environment
- OS: Debian 12 (Linux e2b.local 6.1.158+)
- Node: 22.22.3
- npm: 10.9.8
- Architecture: x64
- Install method: `npm install --global rea-agents`

## Installed Version
```
rea@6.7.0
rea-agents@6.7.0
catalog: 153 CLI commands, 207 MCP tools, 6 prompts
```

Binary locations:
- /usr/local/bin/rea -> ../lib/node_modules/rea-agents/scripts/rea.mjs
- /usr/local/bin/rea-agents -> ../lib/node_modules/rea-agents/scripts/rea.mjs
- Package root: /usr/local/lib/node_modules/rea-agents

## Installation Steps Executed
```bash
node -v # 22.22.3
npm -v  # 10.9.8
npm install --global rea-agents
rea --version
rea doctor
rea capabilities --json | head
```

## Verification Output
```
healthy: false (expected - no analysis engines configured)
environment_healthy: false (same)
scope_checks:
  - node: healthy 22.22.3
  - host: healthy debian 12
  - hopper: missing_analysis_engine (Run rea setup to install Hopper)
  - ghidra: missing (Set GHIDRA_INSTALL_DIR)
  - ida: missing (Set REA_IDA_MCP_CONFIG)
  - jadx: missing (Set REA_JADX_MCP_JAR)
  - kuna: missing (Set REA_KUNA_COMMAND)
  - skill:identity: missing (Run rea setup)
```

Core functionality is healthy. Native analysis providers are optional and require separate installs:
- **Hopper:** `rea setup` can install with approval, or set `HOPPER_LAUNCHER_PATH`
- **Ghidra 12.1.x:** set `GHIDRA_INSTALL_DIR`
- **IDA:** set `REA_IDA_MCP_CONFIG` (see docs/ida-provider.md)
- **JADX:** set `REA_JADX_MCP_JAR` to jadx-headless-mcp 0.7.1
- **Kuna 1.833:** set `REA_KUNA_COMMAND`

Static JavaScript/Electron analysis works without native engines.

## Setup (interactive)
To register REA with your agent (Claude Code, Codex, Cursor, Gemini CLI, etc.):

```bash
npx rea-agents setup
# Choose agents, review plan, approve, restart agent
```

Dry-run preview:
```bash
rea setup --dry-run
rea setup --dry-run --json
```

## Useful Commands
```bash
rea --help
rea doctor --json
rea capabilities
rea setup --help
rea update            # update global install
npx rea-agents@latest setup --dry-run
```

## Official Install Script Alternative
```bash
curl -fsSL https://raw.githubusercontent.com/morluto/rea/main/install.sh | bash
# Linux: installs to $HOME/.local, ensure $HOME/.local/bin is in PATH
# Options: --no-setup, --dry-run, --verbose, --version VERSION
```

## Links
- Website: https://rea.tools/
- Guides: https://rea.tools/guides/
- Docs: https://github.com/morluto/rea/tree/main/docs
- Installation docs: docs/installation.md
- MCP contracts: docs/mcp-contracts.md
- Discord: https://discord.gg/GkcryMnJDM

## Notes
- This sandbox installed REA globally via npm. No `rea setup` was run interactively (requires terminal approval).
- Run `rea setup` manually when you have a terminal to configure agent MCP registrations and Hopper.
- Source cloned to /tmp/rea for inspection (depth 1).
