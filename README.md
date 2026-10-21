# VetMasterJi — rebuilt

An offline-first veterinary clinical toolkit: dose and fluid calculators, a differential ranker, an
interaction screen, reference ranges, toxicology, a drug library, clinical notes, procedures, a scored
case simulator and a local-only patient record.

It is a **rebuild, not a copy**, of [vetmasterji.com](https://vetmasterji.com/). The full
reverse-engineering analysis is in [`ANALYSIS.md`](./ANALYSIS.md).

## Fidelity to the original

This is an independent rebuild of the VetMasterJi interface and toolset. It follows the original's
landing-page structure and copy section by section, and reproduces its published worked examples.
It is not affiliated with vetmasterji.com.

| Surface | Original | This build |
| --- | ---: | ---: |
| Landing page sections | 12 | 12, same order, same copy |
| Drug monographs | 418 | 44 |
| Reference texts cited | 16 | 16 |
| Tools | 12 | 12 |
| Conditions | 8 | 36 |
| Species | 10 | 15 |

The full 418-slug list was captured from the original's sitemap and is committed at
`reference/drug-slugs.txt`. The sitemap carries URLs only — no dose data — so monograph content is
authored and cited rather than extracted.

Two behaviours match the original deliberately, and are worth knowing about before you use this on
a food-producing animal: buffalo is dosed from cattle without a label in the calculator, and
prohibited substances present as an absent dose row rather than an explicit refusal. The
prohibition is recorded in the monograph's contraindications. Under Indian and EU rules, extra-label
cascade use requires a justification and an extended withdrawal interval set by the prescriber.

## Quick start

```bash
npm install
npm run dev        # http://localhost:5173
npm run verify     # renders every route + checks the engines against published worked examples
npm run build
```

## Stack

React 18 · TypeScript (strict) · Vite 5 · React Router 6. **No backend.** All computation is
client-side, all data ships with the bundle, and the app works with the network switched off.

## Layout

```
src/
  types.ts              domain model (15 species, 12 drug classes, dose rows, cases, procedures…)
  data/
    species.ts          15 species: maintenance rates, preferred fluids, dehydration ladder
    references.ts       16 cited reference texts
    drugs/              drug monographs, split by class, plus a barrel with search helpers
    signs.ts            73 clinical signs, weighted per condition
    diseases.ts         36 conditions with weighted key signs
    referenceRanges.ts  vitals, haematology, biochemistry for 15 species
    toxicology.ts       15 toxins: toxidrome, antidote, first hour
    vaccines.ts         32 schedule rows
    notes.ts            10 clinical notes
    cases.ts            6 scored interactive cases
    procedures.ts       10 structured procedure cards
    challenges.ts       40 practice questions
  engine/
    dosing.ts           weight × mg/kg → total, then mL and tablets per product
    fluids.ts           deficit / maintenance / drip rate / two-phase plan
    differentials.ts    confidence = Σ matched key-sign weight ÷ Σ key-sign weight
    interactions.ts     whole-prescription screening
    assistant.ts        deterministic retrieval with citations
  pages/                27 routes
  components/           layout, design-system primitives, the two calculators
scripts/verify.tsx      route render + engine regression harness
```

## Verification

`npm run verify` bundles the app for node, renders all 27 routes to catch render-time crashes, and
checks the engines against worked examples published on the reference site:

- dog 18 kg, amoxicillin 10 mg/kg → **180 mg**
- dog 12 kg at 8% over 24 h on a 15 gtt/mL set → **960 mL deficit, 600 mL maintenance, 16.3 gtt/min**
- dog with vomiting + haemorrhagic diarrhoea + lethargy + anorexia → **parvoviral enteritis first**

It also asserts `formatNumber(180) === "180"`. A trailing-zero strip that reached integers once turned
180 mg into 18 mg; that assertion is the regression guard.

## Honest limitations

- **Corpus size.** The reference product ships 418 monographs; this build publishes 44 fully cited
  entries. A dose that is absent is deliberately absent — it is not a gap to fill by guessing.
- **Prohibited substances.** Where a drug is prohibited in a food-producing species, this build shows
  no dose row for that species, as the original does. The prohibition is recorded in the
  monograph's contraindications.
- **Interface localisation only.** The UI is available in English, Hindi and Spanish. Clinical content
  stays in English: a mistranslated dose instruction is a safety hazard, so translation waits for
  qualified review of each entry.
- **Jurisdiction.** Withdrawal intervals, prohibited substances and prescription status vary by
  country. The product label in your jurisdiction governs.
- **No server, by design.** Records, reminders and study progress live in your browser's local
  storage. That is what makes it work offline; it also means clearing site data erases them, and
  browser storage is not a practice system of record.

## Disclaimer

Reference information for qualified veterinarians and for students working under supervision. Confirm
every dose against the product label, the individual patient and current national guidance. The
attending veterinarian remains responsible for the decision. See `/disclaimer` in the app.
