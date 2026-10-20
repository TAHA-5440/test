# VetMasterJi — rebuilt

An offline-first veterinary clinical toolkit: dose and fluid calculators, a differential ranker, an
interaction screen, reference ranges, toxicology, a drug library, clinical notes, procedures, a scored
case simulator and a local-only patient record.

It is a **rebuild, not a copy**, of [vetmasterji.com](https://vetmasterji.com/). The full
reverse-engineering analysis is in [`ANALYSIS.md`](./ANALYSIS.md).

## The one rule

**Every number is traceable to a named reference, and where no reference exists the tool says so.**

That single constraint drives the design:

- Each dose row carries the citation it was taken from (Plumb's, Papich, BSAVA, Merck, FARAD…).
- Buffalo, which has little species-specific data, is dosed from cattle — and every carried-over row
  is **labelled as a carry-over** and badged extra-label at the point of use.
- Where no withdrawal interval is established, the entry says **"NOT established"**. Never a zero.
- Prohibited uses (phenylbutazone in cattle, metronidazole in food animals) are modelled as a dose row
  with a null rate plus a prohibition statement, and the interaction screen refuses them in any food
  species.
- The clinical assistant is **deterministic retrieval**, not generation. It cannot invent a dose; if
  nothing in the corpus matches, it reports a bounded negative search.

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
