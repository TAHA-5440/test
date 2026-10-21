import { useMemo, useState } from 'react';
import { Link } from 'react-router-dom';
import { DRUGS, DRUG_MAP } from '../data/drugs';
import { rowsForSpecies, computeDose, formatNumber, intervalsPerDay, dailyDoseTotal } from '../engine/dosing';
import { BackLink, PageFooter, Callout } from '../components/ui';
import type { SpeciesId } from '../types';

const COMMON = ['meloxicam', 'amoxicillin', 'ivermectin', 'enrofloxacin', 'oxytetracycline', 'ceftriaxone'];

/**
 * The calculator's species strip, following the reference site's order and
 * labels. `Hedgehogs`, `Sugar gliders` and `Primates` have no entry in this
 * build's species model, so they carry no id and return no dose rows rather
 * than silently borrowing another species' data.
 */
const CALC_SPECIES: { label: string; id: SpeciesId | null }[] = [
  { label: 'Dogs', id: 'dog' },
  { label: 'Cats', id: 'cat' },
  { label: 'Cattle', id: 'cattle' },
  { label: 'Horses', id: 'horse' },
  { label: 'Pigs', id: 'pig' },
  { label: 'Buffalo (as cattle)', id: 'buffalo' },
  { label: 'Birds', id: 'bird' },
  { label: 'Ferrets', id: 'ferret' },
  { label: 'Reptiles', id: 'reptile' },
  { label: 'Hedgehogs', id: null },
  { label: 'Sugar gliders', id: null },
  { label: 'Primates', id: null },
];

const SPECIES_COVERAGE: { species: string; count: string }[] = [
  { species: 'Dogs', count: '373' },
  { species: 'Cats', count: '349' },
  { species: 'Cattle', count: '167' },
  { species: 'Horses', count: '263' },
  { species: 'Goats', count: '102' },
  { species: 'Sheep', count: '117' },
  { species: 'Pigs', count: '107' },
  { species: 'Poultry', count: '14' },
  { species: 'Buffalo', count: '167' },
  { species: 'Birds', count: '85' },
];

const FREQUENT = [
  { slug: 'meloxicam', name: 'Meloxicam', tag: 'Anti-inflammatory' },
  { slug: 'amoxicillin', name: 'Amoxicillin', tag: 'Antibiotic' },
  { slug: 'ivermectin', name: 'Ivermectin', tag: 'Antiparasitic' },
  { slug: 'enrofloxacin', name: 'Enrofloxacin', tag: 'Antibiotic' },
  { slug: 'oxytetracycline', name: 'Oxytetracycline', tag: 'Antibiotic' },
  { slug: 'ceftriaxone', name: 'Ceftriaxone', tag: 'Antibiotic' },
  { slug: 'metronidazole', name: 'Metronidazole', tag: 'GI' },
  { slug: 'dexamethasone', name: 'Dexamethasone', tag: 'Anti-inflammatory' },
  { slug: 'xylazine', name: 'Xylazine', tag: 'Sedative' },
  { slug: 'ketamine', name: 'Ketamine HCl', tag: 'Sedative' },
  { slug: 'furosemide', name: 'Furosemide', tag: 'Diuretic' },
  { slug: 'maropitant', name: 'Maropitant', tag: 'Antiemetic' },
  { slug: 'doxycycline', name: 'Doxycycline', tag: 'Antibiotic' },
  { slug: 'gentamicin', name: 'Gentamicin', tag: 'Antibiotic' },
  { slug: 'albendazole', name: 'Albendazole', tag: 'Antiparasitic' },
  { slug: 'tramadol', name: 'Tramadol', tag: 'Analgesic' },
  { slug: 'prednisolone', name: 'Prednisolone', tag: 'Anti-inflammatory' },
  { slug: 'carprofen', name: 'Carprofen', tag: 'Anti-inflammatory' },
];

const FAQ = [
  {
    q: 'How do you calculate a drug dose for a dog or cat?',
    a: 'Multiply the body weight in kilograms by the dose in mg/kg to get the total dose in mg, then divide by the product concentration in mg/mL to get the volume to give. For example, a 20 kg dog at 10 mg/kg needs 200 mg, which is 4 mL of a 50 mg/mL suspension.',
  },
  {
    q: 'How do I convert mg/kg to mL?',
    a: 'mL = (body weight in kg × dose in mg/kg) ÷ concentration in mg/mL. The calculator does this for every liquid product strength on file, and refuses to convert powders or dry vials whose reconstituted strength is not stated.',
  },
  {
    q: 'Does the calculator include withdrawal periods for food animals?',
    a: 'Yes. For cattle, buffalo, sheep, goats, pigs and poultry it shows the meat withdrawal in days and the milk withdrawal in hours. Where the references give no established period it says so explicitly rather than leaving the line blank, so a missing figure is never mistaken for "no withdrawal needed".',
  },
  {
    q: 'Which references are the doses taken from?',
    a: "Doses come from Plumb's Veterinary Drug Handbook and Papich's Handbook of Veterinary Drugs (5th edition), with exotic-species doses from Carpenter's Exotic Animal Formulary where those references are silent. Each dose row carries its citation; the database was re-audited row by row in September 2026, and its Plumb's citations were re-checked against the 10th edition on 1 October 2026.",
  },
  {
    q: 'Does the drug calculator work offline?',
    a: 'Yes. Once VetMasterJi is installed on your phone or computer, the drug, fluid and dose calculators run without an internet connection — useful on farm calls and in clinics with patchy signal.',
  },
  {
    q: 'Is the veterinary dose calculator free?',
    a: 'Yes. The drug, dosage and fluid therapy calculators are free forever with a VetMasterJi account.',
  },
];

const STEPS = [
  'Weigh the animal and record the weight in kilograms.',
  'Choose the reference dose (mg/kg) for that species and indication.',
  'Total dose (mg) = body weight (kg) × dose (mg/kg).',
  'Volume (mL) = total dose (mg) ÷ product concentration (mg/mL). For tablets, divide by the mg per tablet and round to a practical fraction.',
  'Check the route, the dosing interval, contraindications and — in food animals — the withdrawal period before giving it.',
];

const WHAT_IT_SHOWS = [
  'Dose in mg/kg for the selected species and indication, with the reference it comes from',
  'Total dose in mg, and the volume in mL or tablet count for each product strength on file',
  'Route, frequency and course duration',
  'Meat (days) and milk (hours) withdrawal periods for cattle, buffalo, sheep, goats, pigs and poultry — and an explicit warning where no withdrawal period is established',
  'Contraindications and species-specific warnings',
  'Pregnancy and lactation notes',
  'Doses that are not weight-based (per animal, per quarter, infusion rates) shown as written rather than forced into mg/kg',
];

function Faq() {
  const [open, setOpen] = useState<number | null>(0);
  return (
    <div className="faq">
      {FAQ.map((item, i) => (
        <div key={item.q} className="faq-item">
          <button type="button" className="faq-question" onClick={() => setOpen(open === i ? null : i)} aria-expanded={open === i}>
            <span>{item.q}</span>
            <span aria-hidden="true">{open === i ? '−' : '+'}</span>
          </button>
          {open === i && <p className="faq-answer">{item.a}</p>}
        </div>
      ))}
    </div>
  );
}

export default function DrugCalculatorPage() {
  const [drugId, setDrugId] = useState('amoxicillin');
  const [species, setSpecies] = useState<SpeciesId>('dog');
  const [rowIndex, setRowIndex] = useState(0);
  const [weight, setWeight] = useState(20);
  const [productIndex, setProductIndex] = useState(0);

  const drug = DRUG_MAP[drugId] ?? DRUGS[0];
  const rows = useMemo(() => rowsForSpecies(drug, species), [drug, species]);
  const row = rows[Math.min(rowIndex, Math.max(0, rows.length - 1))];
  const result = useMemo(() => (row ? computeDose(drug, row.row, weight) : null), [drug, row, weight]);

  const products = useMemo(() => [{ name: 'Dose in mg only' }, ...drug.products], [drug]);
  const product = products[Math.min(productIndex, products.length - 1)];
  const amount = useMemo(() => {
    if (productIndex === 0 || !result) return null;
    return result.amounts.find((a) => a.product.name === product.name) ?? null;
  }, [productIndex, result, product]);

  const perDay = useMemo(() => {
    if (!row || !result) return null;
    const n = intervalsPerDay(row.row.frequency);
    return n ? { n, total: dailyDoseTotal(result, n) } : null;
  }, [row, result]);

  const pickSpecies = (id: SpeciesId | null) => {
    if (!id) return;
    setSpecies(id);
    setRowIndex(0);
    setProductIndex(0);
  };

  return (
    <div className="container page">
      <BackLink to="/" />

      <header className="page-header">
        <h1 className="mb-2">Veterinary Drug Dose Calculator</h1>
        <p className="lede">Choose from 418 drugs</p>
      </header>

      <div className="card mb-4">
        <div className="filter-label">Common:</div>
        <div className="chip-row">
          {COMMON.map((slug) => (
            <button
              key={slug}
              type="button"
              className="chip small"
              aria-pressed={drugId === slug}
              onClick={() => {
                setDrugId(slug);
                setRowIndex(0);
                setProductIndex(0);
              }}
            >
              {DRUG_MAP[slug]?.name ?? slug}
            </button>
          ))}
        </div>
      </div>

      <div className="row-between mb-3">
        <h2 className="mb-0">{drug.name} quick dose</h2>
        <Link to={`/drugs/${drug.id}`} className="small">
          {drug.name} monograph
        </Link>
      </div>

      <p className="small muted mb-3">Species → indication → weight → product</p>
      <div className="row mb-4">
        <span className="badge badge-green">No sign-in</span>
        <span className="badge badge-neutral">Runs in your browser</span>
      </div>

      <div className="split">
        <div className="card">
          <div className="field">
            <span className="label">Species</span>
            <div className="chip-row">
              {CALC_SPECIES.map((s) => (
                <button
                  key={s.label}
                  type="button"
                  className="chip small"
                  aria-pressed={s.id !== null && s.id === species}
                  onClick={() => pickSpecies(s.id)}
                  title={s.id === null ? `No ${s.label.toLowerCase()} entries in this build` : undefined}
                  style={s.id === null ? { opacity: 0.55 } : undefined}
                >
                  {s.label}
                </button>
              ))}
            </div>
          </div>

          <div className="field">
            <label className="label" htmlFor="indication">
              Indication
            </label>
            <select
              id="indication"
              className="select"
              value={Math.min(rowIndex, Math.max(0, rows.length - 1))}
              onChange={(e) => {
                setRowIndex(Number(e.target.value));
                setProductIndex(0);
              }}
              disabled={rows.length === 0}
            >
              {rows.length === 0 && <option value={0}>No published dose for this species</option>}
              {rows.map((r, i) => (
                <option key={`${r.row.indication}-${i}`} value={i}>
                  {r.row.indication} · {r.row.doseLow ?? ''}
                  {r.row.doseHigh && r.row.doseHigh !== r.row.doseLow ? `–${r.row.doseHigh}` : ''} {r.row.unit} {r.row.route}
                </option>
              ))}
            </select>
          </div>

          <div className="field">
            <label className="label" htmlFor="calc-weight">
              Body weight
            </label>
            <div className="input-group">
              <input
                id="calc-weight"
                className="input"
                type="number"
                inputMode="decimal"
                min={0.01}
                step="0.1"
                value={weight}
                onChange={(e) => {
                  const v = Number.parseFloat(e.target.value);
                  setWeight(Number.isFinite(v) ? v : 0);
                }}
                style={{ maxWidth: '130px' }}
              />
              <span className="muted small">kg</span>
            </div>
            <input
              className="range"
              type="range"
              min={0.5}
              max={600}
              step={0.5}
              value={Math.min(weight, 600)}
              onChange={(e) => setWeight(Number(e.target.value))}
              aria-label="Body weight slider"
            />
          </div>

          <div className="field mb-0">
            <label className="label" htmlFor="product">
              Product (for volume or tablets)
            </label>
            <select
              id="product"
              className="select"
              value={Math.min(productIndex, products.length - 1)}
              onChange={(e) => setProductIndex(Number(e.target.value))}
            >
              {products.map((p, i) => (
                <option key={`${p.name}-${i}`} value={i}>
                  {p.name}
                </option>
              ))}
            </select>
          </div>
        </div>

        <div>
          <div className="card">
            <div className="filter-label">Total dose</div>
            <div className="hero-answer-value">{result ? formatNumber(result.totalMg ?? 0) : '—'}</div>
            <div className="hero-answer-unit">mg</div>
            <p className="mono small muted mt-2 mb-0">
              {formatNumber(weight)} kg × {formatNumber(result?.doseValue ?? 0)} {row?.row.unit ?? 'mg/kg'}
            </p>

            {amount && (
              <>
                <div className="filter-label mt-4">
                  Amount at {amount.product.concentrationMgPerMl ?? amount.product.mgPerUnit} mg/mL
                </div>
                <div className="hero-answer-value">{amount.display}</div>
                <p className="small muted mt-2 mb-0">{amount.product.name}</p>
              </>
            )}

            <div className="filter-label mt-4">Route · frequency</div>
            <p className="mb-0">
              <strong>
                {row?.row.route ?? '—'} · {row?.row.frequency ?? '—'}
              </strong>
              {perDay && <span className="muted small"> · {formatNumber(perDay.total ?? 0)} mg/day</span>}
            </p>

            {row && (
              <p className="tiny subtle mt-4 mb-0">{row.row.source}</p>
            )}
          </div>

          <p className="small muted mt-3">
            Reference doses for veterinary professionals. Confirm against the label and the patient before use.{' '}
            <Link to="/">Full calculator: daily totals, courses, prescriptions</Link>
          </p>
        </div>
      </div>

      <section className="section">
        <h2>How to calculate a veterinary drug dose</h2>
        <ol>
          {STEPS.map((s) => (
            <li key={s}>{s}</li>
          ))}
        </ol>
      </section>

      <section className="section">
        <div className="grid grid-3">
          <div className="card card-tight">
            <div className="filter-label">Total dose</div>
            <p className="mono small mb-0">body weight (kg) × dose (mg/kg)</p>
          </div>
          <div className="card card-tight">
            <div className="filter-label">Volume to draw up</div>
            <p className="mono small mb-0">total dose (mg) ÷ concentration (mg/mL)</p>
          </div>
          <div className="card card-tight">
            <div className="filter-label">Tablets</div>
            <p className="mono small mb-0">total dose (mg) ÷ mg per tablet</p>
          </div>
        </div>
      </section>

      <section className="section">
        <h2>Worked example: amoxicillin for a 20 kg dog</h2>
        <p>
          The reference dose for a susceptible urinary tract infection in dogs is 11–15 mg/kg PO q8–12h for 3–5 days. At the low
          end of the range:
        </p>
        <div className="grid grid-3">
          <div className="card card-tight">
            <div className="filter-label">Total dose</div>
            <p className="mb-0">20 kg × 11 mg/kg = 220 mg</p>
          </div>
          <div className="card card-tight">
            <div className="filter-label">Volume</div>
            <p className="mb-0">220 mg ÷ 50 mg/mL = 4.4 mL</p>
          </div>
          <div className="card card-tight">
            <div className="filter-label">Schedule</div>
            <p className="mb-0">4.4 mL PO q8–12h</p>
          </div>
        </div>
        <p className="mt-3">
          <Link to="/drugs/amoxicillin">Full amoxicillin monograph</Link>
        </p>
      </section>

      <section className="section">
        <h2>What the calculator shows</h2>
        <ul>
          {WHAT_IT_SHOWS.map((w) => (
            <li key={w}>{w}</li>
          ))}
        </ul>
      </section>

      <section className="section">
        <h2>Species covered</h2>
        <div className="table-wrap">
          <table>
            <thead>
              <tr>
                <th>Species</th>
                <th className="num">Drugs with a monograph entry</th>
              </tr>
            </thead>
            <tbody>
              {SPECIES_COVERAGE.map((s) => (
                <tr key={s.species}>
                  <td>{s.species}</td>
                  <td className="num mono">{s.count}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        <p className="small muted">
          Buffalo are dosed as cattle wherever a drug has no buffalo-specific entry. Rabbits, guinea pigs, ferrets, reptiles and
          other exotic pets have their own rows where the references give them.
        </p>
      </section>

      <section className="section">
        <h2>Frequently looked-up drugs</h2>
        <div className="grid grid-3">
          {FREQUENT.map((d) => (
            <Link key={d.slug} to={`/drugs/${d.slug}`} className="popular-drug">
              <strong>{d.name}</strong>
              <span className="tiny subtle">{d.tag}</span>
            </Link>
          ))}
        </div>
        <p className="mt-4">
          <Link to="/drugs">Browse all 418 drug monographs</Link>
        </p>
      </section>

      <section className="section">
        <h2>Safety</h2>
        <Callout tone="warning" title="Confirm before use">
          A reference for veterinary professionals. Confirm every dose against the product label, the patient and current
          guidance before use; the attending veterinarian remains responsible for the decision.
        </Callout>
      </section>

      <section className="section">
        <h2>Frequently asked questions</h2>
        <Faq />
      </section>

      <section className="section">
        <h2>Sources</h2>
        <ul>
          <li>Plumb's Veterinary Drug Handbook</li>
          <li>Papich, Papich Handbook of Veterinary Drugs, 5th edition</li>
          <li>Carpenter, Exotic Animal Formulary</li>
        </ul>
      </section>

      <PageFooter />
    </div>
  );
}
