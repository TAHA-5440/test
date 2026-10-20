/* eslint-disable no-console */
/**
 * Verification harness.
 *
 * Renders every route and exercises the calculation engines, checking the
 * output against worked examples published on the reference site. Run it with:
 *
 *     npm run verify
 *
 * It exists because the two failure modes that matter here are silent: a route
 * that throws on render, and a number that is off by a factor of ten.
 */
import { renderToString } from 'react-dom/server';
import { StaticRouter } from 'react-router-dom/server';
import App from '../src/App';
import { PreferencesProvider } from '../src/state/PreferencesContext';

import { DRUG_MAP, DRUGS } from '../src/data/drugs';
import { rowsForSpecies, computeDose, formatDoseRange, formatNumber } from '../src/engine/dosing';
import { calculateFluids } from '../src/engine/fluids';
import { rankDifferentials } from '../src/engine/differentials';
import { screenPrescription } from '../src/engine/interactions';
import { ask } from '../src/engine/assistant';

let failures = 0;

function check(label: string, actual: unknown, expected: unknown): void {
  const ok = String(actual) === String(expected);
  if (!ok) failures += 1;
  console.log(`  ${ok ? 'PASS' : 'FAIL'}  ${label}: ${String(actual)}${ok ? '' : `  (expected ${String(expected)})`}`);
}

function assertTrue(label: string, condition: boolean, detail = ''): void {
  if (!condition) failures += 1;
  console.log(`  ${condition ? 'PASS' : 'FAIL'}  ${label}${condition ? '' : `  ${detail}`}`);
}

// ---------------------------------------------------------------- routes ----
console.log('\nROUTES');
const routes = [
  '/', '/tools', '/drug-calculator', '/fluid-therapy', '/diagnose', '/interactions',
  '/reference-ranges', '/toxicology', '/vaccinations', '/drugs', '/drugs/meloxicam',
  '/drugs/ivermectin', '/drugs/phenylbutazone', '/diseases',
  '/diseases/canine-parvoviral-enteritis', '/notes', '/notes/note-dehydration',
  '/procedures', '/cases', '/cases/case-parvo-simba', '/assistant', '/challenge',
  '/flashcards', '/clinic', '/pricing', '/about', '/disclaimer', '/no-such-page',
];
for (const route of routes) {
  try {
    const html = renderToString(
      <PreferencesProvider>
        <StaticRouter location={route}>
          <App />
        </StaticRouter>
      </PreferencesProvider>,
    );
    const suspicious = /NaN|undefinedundefined|\[object Object\]/.test(html);
    if (suspicious) failures += 1;
    console.log(`  ${suspicious ? 'FAIL' : 'PASS'}  ${route} renders (${html.length} bytes)`);
  } catch (err) {
    failures += 1;
    console.log(`  FAIL  ${route}: ${(err as Error).message}`);
  }
}

// ------------------------------------------------------- number formatting --
console.log('\nNUMBER FORMATTING — trailing-zero stripping must never touch integers');
check('formatNumber(180)', formatNumber(180), '180');
check('formatNumber(18)', formatNumber(18), '18');
check('formatNumber(600)', formatNumber(600), '600');
check('formatNumber(1000)', formatNumber(1000), '1000');
check('formatNumber(3.6)', formatNumber(3.6), '3.6');
check('formatNumber(0.72)', formatNumber(0.72), '0.72');
check('formatNumber(0.036)', formatNumber(0.036), '0.036');

// ------------------------------------------------------------------ dose ----
console.log('\nDOSE — reference worked example: dog 18 kg, amoxicillin 10 mg/kg → 180 mg');
const amox = DRUG_MAP['amoxicillin'];
const amoxRow = rowsForSpecies(amox, 'dog')[0];
const amoxResult = computeDose(amox, amoxRow.row, 18);
check('total dose', amoxResult.totalDisplay, '180 mg');
check('dose range string', formatDoseRange(amoxRow.row), '10–20 mg/kg');
const drop = amoxResult.amounts.find((a) => a.product.name.includes('Amoxi-Drop'));
check('volume from 50 mg/mL suspension', drop?.display, '3.6 mL');

console.log('\nDOSE — meloxicam dog 18 kg at 0.2 mg/kg → 3.6 mg');
const mel = DRUG_MAP['meloxicam'];
const melRow = rowsForSpecies(mel, 'dog')[0];
check('total dose', computeDose(mel, melRow.row, 18).totalDisplay, '3.6 mg');
check('top of range selected', computeDose(mel, melRow.row, 18, 1).totalDisplay, '3.6 mg');

// ---------------------------------------------------------------- fluids ----
console.log('\nFLUIDS — reference worked example: dog 12 kg, 8%, 24 h, 15 gtt/mL');
const f = calculateFluids({
  species: 'dog', weightKg: 12, dehydrationPct: 8, maintenanceRate: 50,
  ongoingLossesMl: 0, hours: 24, dropFactor: 15,
});
check('deficit', Math.round(f.deficitMl), 960);
check('maintenance', Math.round(f.maintenanceForPeriodMl), 600);
check('total', Math.round(f.totalMl), 1560);
check('rate mL/h', f.rateMlPerH.toFixed(1), '65.0');
check('drops/min', f.dropsPerMin.toFixed(1), '16.3');

console.log('\nFLUIDS — shock territory triggers a bolus');
const shock = calculateFluids({
  species: 'dog', weightKg: 12, dehydrationPct: 12, maintenanceRate: 50,
  ongoingLossesMl: 0, hours: 24, dropFactor: 20,
});
assertTrue('shock bolus present', shock.shockBolusMl !== null);
check('bolus volume', shock.shockBolusMl, 180);

// ----------------------------------------------------------- differentials --
console.log('\nDIFFERENTIALS — dog with vomiting, haemorrhagic diarrhoea, lethargy, anorexia');
const rank = rankDifferentials('dog', ['vomiting', 'haemorrhagic-diarrhoea', 'lethargy', 'anorexia']);
assertTrue('parvoviral enteritis ranks first', rank.candidates[0]?.disease.id === 'canine-parvoviral-enteritis', `got ${rank.candidates[0]?.disease.name}`);
assertTrue('confidence is ordered descending', rank.candidates.every((c, i) => i === 0 || rank.candidates[i - 1].confidence >= c.confidence));
assertTrue('confidence never exceeds 1', rank.candidates.every((c) => c.confidence <= 1));

// ------------------------------------------------------------ interactions --
console.log('\nINTERACTIONS — NSAID + steroid + diuretic in a dog');
const dogScreen = screenPrescription(['meloxicam', 'dexamethasone', 'furosemide'], 'dog');
assertTrue('flags an NSAID/steroid combination', dogScreen.some((x) => /steroid/i.test(x.title)));
assertTrue('severity order is descending', dogScreen.every((x, i) => i === 0 || ['contraindicated', 'major', 'moderate', 'minor'].indexOf(dogScreen[i - 1].severity) <= ['contraindicated', 'major', 'moderate', 'minor'].indexOf(x.severity)));

console.log('\nINTERACTIONS — food-animal flags');
const cattleScreen = screenPrescription(['phenylbutazone', 'metronidazole'], 'cattle');
check('two contraindications for cattle', cattleScreen.filter((x) => x.severity === 'contraindicated').length, 2);
check('none for a dog', screenPrescription(['phenylbutazone', 'metronidazole'], 'dog').length, 0);

// ---------------------------------------------------------------- assistant --
console.log('\nASSISTANT — retrieval is deterministic and sourced');
const a1 = ask('meloxicam dose for a dog', 'dog');
const a2 = ask('meloxicam dose for a dog', 'dog');
check('same question gives the same headline', a1.headline, a2.headline);
assertTrue('answer carries at least one source', a1.sources.length > 0);
const unknown = ask('zzzqqq nonexistent compound');
assertTrue('unknown query returns a bounded negative', /Nothing in the curated corpus matches/.test(unknown.headline), unknown.headline);

// ------------------------------------------------------------------ corpus --
console.log('\nCORPUS INTEGRITY');
assertTrue('every drug has at least one source', DRUGS.every((d) => d.sources.length > 0));
assertTrue('every drug has at least one dose row', DRUGS.every((d) => d.doses.length > 0));
assertTrue('every dose row is cited', DRUGS.every((d) => d.doses.every((r) => Boolean(r.source))));
assertTrue(
  'no dose row has a negative rate',
  DRUGS.every((d) => d.doses.every((r) => (r.doseLow === null || r.doseLow >= 0) && (r.doseHigh === null || r.doseHigh >= 0))),
);
console.log(`  INFO  ${DRUGS.length} monographs verified`);

console.log(failures === 0 ? '\n✓ ALL CHECKS PASSED\n' : `\n✗ ${failures} CHECK(S) FAILED\n`);
if (failures > 0) process.exitCode = 1;
