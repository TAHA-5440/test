# Reverse-engineering analysis: vetmasterji.com

**Method.** Public-surface HTTP analysis only. Every page, sitemap and JSON payload was fetched over
HTTPS and read as delivered. No authentication was attempted, no paywall was bypassed, no client-side
bundle was decompiled, and nothing was scraped beyond what the site itself publishes for crawlers.

**Evidence discipline.** Claims below are tagged:

| Tag | Meaning |
| --- | --- |
| **[O]** Observation — directly present in a fetched document |
| **[I]** Inference — reasoned from observations, not read off the site |
| **[U]** Unknown — the public surface does not settle it |

Where a number is quoted it comes from a specific fetched URL, listed in the sources at the end.

---

## 1. What the product is

VetMasterJi is a **veterinary clinical reference and calculation suite**, positioned at Indian and
South-Asian practice but written in English with Hindi and Spanish localisation. Its own title tag
reads *"VetMasterJi: Veterinary Drug Calculator, Cases & Clinic EMR"* **[O]**.

The value proposition is three things at once:

1. **Dose and fluid arithmetic** that works offline, per the `/drug-calculator` page's offline claim **[O]**.
2. **A large drug corpus** — `/drugs` states *"418 of 418 drugs"* **[O]**.
3. **A study and practice layer** — case simulator, daily MCQ challenge, streaks, "VetBands", leaderboard,
   and a clinician-facing EMR with vaccination scheduling **[O]** (`/`, `/for-clinicians`, `/for-students`).

### Audience split

The site is explicitly segmented. `/for-students` sells NAVLE/BCSE-style practice, streaks, VetBands and
an AI case simulator; `/for-clinicians` sells clinic setup, PDF prescriptions and a vaccination
scheduler **[O]**. A student/clinician toggle appears on the landing page **[O]**. This is a real
two-sided product, not one audience with two labels **[I]**.

---

## 2. Route map

`/sitemap.xml` is an index over four child sitemaps **[O]**:

| Sitemap | Content |
| --- | --- |
| `/sitemaps/pages.xml` | 10 marketing & legal pages |
| `/sitemaps/tools.xml` | 12 tool pages |
| `/sitemaps/diseases.xml` | 8 condition pages |
| `/sitemaps/drugs.xml` | 418 drug slugs, `lastmod 2026-10-09` |

Observed page routes **[O]**: `/`, `/drugs`, `/drugs/{slug}`, `/pricing`, `/notes`, `/cases`,
`/tools`, `/drug-calculator`, `/diagnose`, `/for-clinicians`, `/fluid-therapy`,
`/diseases/{slug}`, `/for-students`, `/reference-ranges`.

### Tool inventory (`/tools`) — 12 tools

Drug calculator · fluid therapy · differential diagnosis · interaction checker · reference ranges ·
toxicology/antidotes · drug database · vaccination schedules + clinic tracker · disease reference ·
daily MCQ challenge · flashcards (spaced repetition) **[O]**.

### Conditions

Only 8 condition pages are in the sitemap: canine parvoviral enteritis, distemper, panleukopenia,
mastitis, foot-and-mouth disease, ruminal tympany, bovine respiratory disease, ehrlichiosis **[O]**.
The drug corpus is deep; the condition corpus is shallow **[I]** — the differential tool therefore has
far less to rank against than the drug tool has to dose from.

---

## 3. The drug monograph: canonical structure

`/drugs/meloxicam` is the best-developed entry and defines the template **[O]**. Reading order:

1. **Quick-dose widget** — species selector with 16 species, including buffalo, chinchilla, rat,
   hedgehog, sugar glider and primate.
2. **At a glance.**
3. **Per-species dose tables**, each row carrying an indication, a dose, a route, a frequency, a
   duration, a **per-indication citation** and a **withdrawal column**.
4. Contraindications.
5. Species warnings.
6. Adverse effects.
7. Interactions.
8. Pregnancy & lactation.
9. Monitoring.
10. Toxicity.
11. Pearls.
12. Mechanism.
13. Formulations — Indian brands are named (Melonex, Inflavet, Serakind-Plus, Mloxvet, Mobic, Melocam).
14. Storage.
15. FAQs.
16. Sources.
17. *"Last reviewed 9 October 2026."*

**The per-indication citation and the withdrawal column are the distinguishing features.** A drug
database that prints a dose without saying where the dose came from is a lookup table; this one is
closer to a formulary **[I]**.

### Class distribution (`/drugs`)

| Class | Count |
| --- | ---: |
| Antibiotics | 72 |
| Antiparasitics | 63 |
| Anti-inflammatories | 22 |
| Analgesics | 19 |
| Sedatives & anaesthetics | 22 |
| Cardiovascular | 33 |
| Gastrointestinal | 29 |
| Antiemetics | 5 |
| Antifungals | 15 |
| Diuretics | 6 |
| Hormones / emergency & other | 132 |
| **Total** | **418** |

The distribution is lumpy: "Hormones/emergency & other" is a 132-entry bucket, larger than the
next four classes combined **[O]**. That is a taxonomy signal, not a content signal — the bucket is
doing the work of several real classes **[I]**.

### Species coverage (`/drug-calculator`)

dogs 373 · cats 349 · cattle 167 · horses 263 · goats 102 · sheep 117 · pigs 107 · poultry 14 ·
buffalo 167 · birds 85 **[O]**.

Note buffalo = 167 = cattle = 167. **Buffalo coverage is cattle coverage** **[I]** — the numbers are
identical, which is what you would expect if buffalo rows are generated from cattle data rather than
independently sourced. This is the single most consequential thing on the site for Indian practice,
where buffalo are a primary production species.

---

## 4. Calculations

### Dose

```
total mg  = body weight (kg) × dose (mg/kg)
volume mL = total mg ÷ concentration (mg/mL)
tablets   = total mg ÷ mg per tablet
```
**[O]** (`/drug-calculator`). The landing page's worked example: 18 kg dog, amoxicillin 10 mg/kg →
180 mg PO q12h **[O]**.

### Fluid therapy

```
deficit (mL) = weight (kg) × dehydration (%) × 10
maintenance  = weight (kg) × rate (mL/kg/day)
total        = deficit + maintenance + ongoing losses
rate (mL/h)  = total ÷ hours
drops/min    = mL/h × drop factor ÷ 60
```
**[O]** (`/fluid-therapy`). Landing-page worked example: 12 kg dog, 8% dehydrated → deficit 1.0 L,
maintenance 600 mL, 16 gtt/min over 24 h on a 15 gtt/mL set **[O]**.

Published maintenance rates **[O]**: dog 50–70 (young 80–120) · cat 50–65 · cattle 60–100 ·
horse 50–80 · goat/sheep 60–80 · pig 50–80 · bird 50–60. Dehydration ladder: 0 / 5 / 7 / 10 / 12% **[O]**.
Giving sets: 15, 20, 60 gtt/mL **[O]**.

Note the worked example uses 50 mL/kg/day — the **bottom** of the dog range, not the midpoint **[I]**.

### Differential ranking

```
confidence = Σ weight of matched key signs ÷ Σ weight of all key signs for that condition
```
**[O]** (`/diagnose`). 31 selectable signs; offline quick-match for dog, cat and cattle **[O]**.
Landing example: parvoviral enteritis 88%, dietary gastroenteritis 75%, pancreatitis 60%,
GI foreign body 55%, with a "missing signs" panel **[O]**.

The formula rewards recall of the *characteristic* signs rather than the count of signs **[I]** —
a condition whose two pathognomonic findings are both present outranks one where five incidental
findings match.

---

## 5. Reference ranges

7 species × (vitals, haematology, biochemistry), with a value checker **[O]**.
Dog: T 37.9–39.9 °C, HR 70–120, PCV 37–55%, WBC 6–17 ×10⁹/L, creatinine 0.5–1.5 mg/dL,
ALT 10–100, ALP 20–156 **[O]**. Cat: T 38.1–39.2, HR 140–220, ALP 14–111 **[O]**.
Cattle: T 38–39.3, calcium 8.4–11, magnesium 1.8–2.3 with the note *"<1.5 → grass tetany"* **[O]**.

The magnesium note is the right instinct: an interval without its clinical consequence is a number
you still have to interpret **[I]**.

---

## 6. Technology

| Observation | Inference |
| --- | --- |
| Sitemap index + 4 child sitemaps **[O]** | Next.js-style app-router sitemap generation **[I]** |
| `/cases` returns no server-rendered content **[O]** | Client-rendered SPA; case state is client-side **[I]** |
| `/notes` is access-gated **[O]** | Notes are behind auth or a feature flag **[I]** |
| Stripe referenced on `/pricing` **[O]** | Stripe is the payment processor **[I]** |
| EN / HI / ES switcher **[O]** | i18n framework with three locales **[I]** |
| Offline claims on `/drug-calculator` and `/diagnose` **[O]** | Data shipped to the client; computation is local **[I]** |

**Not determined [U]:** the exact framework version, whether the corpus is bundled or fetched on
demand, the API surface (if any), and how the AI case simulator is implemented. Answering these would
require decompiling the client bundle or authenticating — both out of scope for this analysis.

---

## 7. Failure modes the design invites

These are the criticisms that matter, stated plainly.

1. **Silent species extrapolation.** Buffalo is counted as cattle. If the UI does not say so at the
   point of dosing, a user reasonably believes a buffalo-specific dose exists. Extra-label use must be
   disclosed where the decision is made, not in a footnote.
2. **Withdrawal is a legal fact, not a display field.** Where no interval is established, printing
   "not established" is correct; printing nothing, or a zero, is a residue violation waiting to happen.
3. **Prohibited substances need a refusal, not an absence.** Phenylbutazone in cattle and metronidazole
   in food animals are prohibited in most jurisdictions. A monograph that simply has no cattle row
   looks like an incomplete entry rather than a legal prohibition.
4. **The condition corpus is too thin for the differential tool.** Eight condition pages cannot
   support a credible differential ranker. The tool is only as good as the 8-entry list behind it.
5. **A generative "AI" layer over a clinical corpus** — if the case simulator and assistant generate
   text rather than retrieve it, every answer needs a citation, and an uncited clinical sentence is
   worse than no sentence.
6. **Video as procedure documentation.** The `/tools` page references clinical videos. Video cannot
   be searched, cannot be read in a dark barn, and cannot carry a citation.
7. **Gating.** If any dose sits behind a paywall, the product has put a clinical safety feature behind
   a commercial one.

---

## 8. What this rebuild does differently

The rebuild in `/` is a separate implementation, not a copy. It keeps the parts of the reference
product that are genuinely good — the formulas, the per-indication citations, the withdrawal column,
the offline posture — and changes the seven things above.

| Reference behaviour | This build |
| --- | --- |
| Buffalo counted as cattle, silently | Buffalo rows are generated from cattle and **labelled as a carry-over at the point of dosing**, with an explicit extra-label badge and a warning in the species picker |
| Withdrawal shown where known | Withdrawal shown where published; **"NOT established — treat as extra-label"** where it is not; never a zero |
| Prohibited drugs have no row | Prohibited uses are modelled as a **dose row with a null rate plus a prohibition statement**, and are caught by the interaction screen in any food species |
| 8 condition pages | 36 conditions with weighted key signs, so the ranker has something to rank |
| Generative assistant | **Deterministic retrieval** over the curated corpus; if nothing matches it says so, and every answer lists its sources |
| Clinical videos | **Structured procedure cards**: equipment, sequence, pitfalls, citation — searchable, printable, instantaneous |
| Paid tiers | Calculators, monographs and reference entries are **free**; paid tiers cover revision structure and practice administration only |

### Verified against the reference's own worked examples

`npm run verify` renders all 27 routes and checks the engines against the numbers published on the
reference site:

- dog 18 kg, amoxicillin 10 mg/kg → **180 mg** ✓
- dog 12 kg, 8% dehydrated, 24 h, 15 gtt/mL → **deficit 960 mL, maintenance 600 mL, 65.0 mL/h, 16.3 gtt/min** ✓
- dog with vomiting + haemorrhagic diarrhoea + lethargy + anorexia → **parvoviral enteritis ranked first** ✓

The harness also guards the failure mode that matters most: it asserts that `formatNumber(180)` is
`"180"`. An earlier revision stripped trailing zeros from whole numbers and turned 180 mg into 18 mg —
a ten-fold overdose. That assertion exists so it cannot happen again.

---

## Sources

Fetched over HTTPS during the analysis:

`vetmasterji.com/` · `/drugs` · `/drugs/meloxicam` · `/pricing` · `/sitemap.xml` · `/notes` · `/cases` ·
`/sitemaps/pages.xml` · `/sitemaps/tools.xml` · `/sitemaps/diseases.xml` · `/tools` · `/drug-calculator` ·
`/diagnose` · `/for-clinicians` · `/fluid-therapy` · `/diseases/canine-parvoviral-enteritis` ·
`/for-students` · `/reference-ranges`

Reference skill: `github.com/morluto/rea` (REA — reverse engineering and analysis).
