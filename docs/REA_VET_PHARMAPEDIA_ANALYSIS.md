# REA Analysis — Vet+Pharmapedia Pakistan 1.0.13 (XAPK)

**Target:** `Vet+Pharmapedia+Pakistan_1.0.13_APKPure.xapk` from Google Drive (TAHA abdullah)  
**Drive ID:** `10RoIgPG_E0qmVrPj-BCNn9iea12eiZI3` — 15,118,799 bytes, `application/x-zip`  
**Tool:** [REA](https://github.com/morluto/rea) `6.7.0` — `rea inspect-artifact` + `rea extract-artifact` (artifact-graph provider) + manual `androguard`/DEX string recovery (Node `26.12.0`, Debian 12)  
**APK inside:** `vet.pharmapedia.vetpharmapediapakistan.apk` — 14,985,367 bytes, SHA256 `668bc0920ba4410a17bddce775eab06c10364031f21cff700287fa398cabaf25`  
**Date:** 2026-10-18

## How to reproduce

```bash
rea --version                          # 6.7.0
rea doctor                             # node: healthy 26.12.0
rea inspect-artifact Vet+Pharmapedia+Pakistan_1.0.13_APKPure.xapk --json
rea extract-artifact Vet+Pharmapedia+Pakistan_1.0.13_APKPure.xapk --json
# XAPK is ZIP: unzip -l *.xapk
# APK manifest: via androguard or aapt
rea inspect-artifact vet.pharmapedia.vetpharmapediapakistan.apk --json  # 873 nodes, 963 occurrences
# Android deep inspection needs JADX 0.7.1 / apktool (optional):
# rea inspect-android-package vet.pharmapedia.vetpharmapediapakistan.apk --json
```

Evidence JSONs in `evidence/` of this repo.

---

## File identity (REA Evidence)

| Field | Value |
|---|---|
| **XAPK SHA256** | `6f9781939a3c8caf967aa7d0bbd9429c6f968af66140dcef0db1d426c2d1534c` |
| **XAPK bytes** | `15,118,799` (ZIP, XAPK v2) |
| **APK SHA256** | `668bc0920ba4410a17bddce775eab06c10364031f21cff700287fa398cabaf25` |
| **APK bytes** | `14,985,367` |
| **Evidence IDs** | `ev_87bd24e7d87874c897ea11cb52887913...` (XAPK inspect), `ev_7f6462a8594bdf9...` (extract), `ev_1abd87076e8f46...` (APK inspect) |

**REA limits:** ZIP inventory = central-directory entries only; APK Signing Block / ZIP comment not occurrences.

---

## XAPK structure (REA `inventory_artifact`)

```
Vet+Pharmapedia+Pakistan_1.0.13_APKPure.xapk (ZIP, 5 entries)
├── vet.pharmapedia.vetpharmapediapakistan.apk  14,985,367  base
├── config.armeabi_v7a.apk                            37,106  split abi
├── config.hdpi.apk                                   58,173  split density
├── manifest.json                                      6,835  xapk_version 2
└── icon.png                                          30,581
```

`manifest.json` (APKPure):

```json
{
  "xapk_version": 2,
  "package_name": "vet.pharmapedia.vetpharmapediapakistan",
  "version_name": "1.0.13",
  "version_code": "13",
  "min_sdk_version": "29",
  "target_sdk_version": "36",
  "permissions": ["android.permission.INTERNET", "POST_NOTIFICATIONS", ... , "com.android.vending.CHECK_LICENSE"],
  "split_configs": ["config.armeabi_v7a", "config.hdpi"],
  "split_apks": [{"file": "vet.pharmapedia.vetpharmapediapakistan.apk", "id": "base"} ...]
}
```

---

## APK manifest (androguard, verified)

- **Package:** `vet.pharmapedia.vetpharmapediapakistan`
- **SDK:** `minSdkVersion 29`, `targetSdkVersion 36`, `compileSdkVersion 37`
- **Activities (20):** `MainActivity`, `MedicinesMainActivity`, `DosageDetailActivity`, `AvailableFormsActivity`, `AlternativeBrandsActivity`, `ContraindicationsActivity`, `LanguageActivity`, `ThemesActivity`, `SplashAppActivity`, `DisclaimerActivity`, etc. + OneSignal / Play Core wrappers.
- **Permissions:** `INTERNET`, `ACCESS_NETWORK_STATE`, `POST_NOTIFICATIONS`, `FOREGROUND_SERVICE`, `RECEIVE_BOOT_COMPLETED`, `CHECK_LICENSE`, plus badge perms.
- **Graph:** 873 nodes, 963 occurrences (REA `agm_24471fb5...`)

---

## Data model (extracted from DEX strings, REA artifact + raw bytes)

The app uses **Android Room** (`androidx.room`) with database **`medicines_DB`**:

```sql
CREATE TABLE IF NOT EXISTS `medicines_table` (
  `docId` TEXT NOT NULL,
  `timeStamp` INTEGER NOT NULL,
  `saltName` TEXT NOT NULL,
  `brandName` TEXT NOT NULL,
  `contraIndications` TEXT NOT NULL,
  `overview` TEXT NOT NULL,
  `indications` TEXT NOT NULL,
  `companyName` TEXT NOT NULL,
  `countryName` TEXT NOT NULL,
  `isBrandFavourite` INTEGER NOT NULL,
  `isSaltFavourite` INTEGER NOT NULL,
  `block` TEXT NOT NULL,
  `availableForms` TEXT NOT NULL,
  `dosageDetail` TEXT NOT NULL,
  PRIMARY KEY(`docId`)
);
-- Also: room_master_table, WorkSpec tables (WorkManager), Firebase tables
```

**Models (from DEX):**
- `MedicinesRoomDBModel` (entity, primary table)
- `MedicinesDBClass` / `MedicinesDBClass_Impl` (RoomDatabase)
- `MedicinesModel`, `MedicinesMainItemsModel`, `DisplayDosageModel`, `DisplayFormsModel`, `LanguagesModel`, `SettingsModel`, `SlidersModel`

**No pre-bundled `.db` file in APK** — DB is populated at runtime (likely Firestore / remote fetch). No `assets/*.db` found.

---

## How the app works (inferred, Evidence-backed)

1. **Inventory:** XAPK splits deliver base APK + abi/density configs.
2. **Room DB** `medicines_DB` stores medicines; `docId` is PK (Firestore doc ID).
3. **UI:** `MedicinesMainActivity` lists medicines → `DosageDetailActivity` shows `dosageDetail` + `availableForms`; `AlternativeBrandsActivity` via `brandName`/`saltName`.
4. **Sync:** Firebase (`firestore.proto`, `firebase_crashlytics_keep.xml` present) populates Room; `WorkManager` tables handle background sync.
5. **Next for full REA:** Add JADX 0.7.1 (`REA_JADX_MCP_JAR`) to run `inspect-android-package` / `inspect-android-class` for method-level traces.

---

## REA limitations & next probes

- `inspect-artifact` = static inventory; does not execute APK nor claim runtime semantics.
- `inspect-android-package` requires `REA_JADX_MCP_JAR` (jadx-headless-mcp 0.7.1) — not installed here; artifact-graph + androguard used instead.
- `search` (native) requires Ghidra/Hopper/IDA/Kuna — not configured; DEX string search done via raw bytes.

**Next:** Provide `jadx-headless-mcp` JAR or `apktool` launcher to unlock REA Android decompilation; then `trace-android-references`, `inspect-android-method` can show exact data flow.

---

*Generated with REA 6.7.0 on Node 26.12.0. Evidence IDs and SHAs are canonical REA output.*
