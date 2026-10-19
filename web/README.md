# Pharmapedia browser client

This folder is the new React/TypeScript browser implementation. It does not run
the recovered Java or an Android APK. See [the web application guide](../docs/WEB_APP.md)
for features, import/export formats, local-storage safeguards, Firebase setup,
clinical limitations, build/hosting instructions and tests.

From the repository root:

```bash
npm ci
npm run dev
```

The app starts with an empty catalogue. No medicine records are bundled or
fabricated. Import real authorised medicine JSON/CSV/SQLite or configure a normal
permitted Firebase web connection. The original backend and medicine records were
not recovered from the APK.
