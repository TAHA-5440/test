# test — REA Installed

This workspace has **REA (Reverse Engineer Anything)** installed from [morluto/rea](https://github.com/morluto/rea).

> Reverse engineer anything with agents, from app behavior down to native binaries.

- **Homepage:** https://rea.tools/
- **GitHub:** https://github.com/morluto/rea
- **npm:** https://www.npmjs.com/package/rea-agents
- **Version installed:** 6.7.0
- **Install date:** 2026-10-18
- **Node:** 22.22.3 (meets requirement ^22.19.0 || ^24.11.0 || >=26.0.0)

## Installation (verified on this sandbox)

```bash
# Official install via npm
npm install --global rea-agents

# Or via install.sh (Linux installs to $HOME/.local)
curl -fsSL https://raw.githubusercontent.com/morluto/rea/main/install.sh | bash -- --no-setup

# Or via npx (no global install)
npx -y rea-agents@latest --help
```

Verify:

```bash
rea --version        # 6.7.0
rea doctor           # check environment
rea capabilities     # list providers
rea --help           # 153 CLI commands
```

See [REA_INSTALL.md](./REA_INSTALL.md) for full details and provider setup.

## Quick start

After install, configure your agent:

```bash
npx rea-agents setup
```

Then ask your agent:

> Understand how search works in the Notes app, show me the evidence, and build a similar feature for my project.

Terminal example (static JS/Electron analysis, no native engine needed):

```bash
npx -y rea-agents@latest analyze-javascript-application /absolute/path/to/app --json
```

Full guide: https://rea.tools/guides/
