import { useState } from 'react';
import { Link } from 'react-router-dom';
import { DRUGS, DRUG_MAP } from '../data/drugs';
import { REFERENCES } from '../data/references';
import { SPECIES_ICON } from '../data/species';
import { dailyChallenge } from '../data/challenges';
import { DISEASES } from '../data/diseases';
import { NOTES } from '../data/notes';
import { CASES } from '../data/cases';
import { TOXICOLOGY } from '../data/toxicology';
import { VACCINES } from '../data/vaccines';
import { PROCEDURES } from '../data/procedures';
import { CHALLENGES } from '../data/challenges';
import { calculateFluids } from '../engine/fluids';
import { computeDose, rowsForSpecies } from '../engine/dosing';
import { rankDifferentials } from '../engine/differentials';
import { Callout } from '../components/ui';

/* ------------------------------------------------------------------ data --- */

const HERO_REFERENCES = [
  { title: "Plumb's Veterinary Drug Handbook", edition: '7th edition' },
  { title: "Ettinger's Internal Medicine", edition: '8th edition' },
  { title: 'Merck Veterinary Manual', edition: '11th edition' },
  { title: 'Fossum Small Animal Surgery', edition: '5th edition' },
  { title: "Smith's Large Animal Medicine", edition: '4th edition' },
  { title: "Greene's Infectious Diseases", edition: '5th edition' },
];

const POPULAR_DRUGS = [
  { slug: 'meloxicam', name: 'Meloxicam', tagline: 'COX-2 preferential NSAID' },
  { slug: 'amoxicillin-clavulanate', name: 'Amoxicillin / Clavulanic Acid', tagline: 'Potentiated aminopenicillin' },
  { slug: 'enrofloxacin', name: 'Enrofloxacin', tagline: 'Fluoroquinolone antibiotic' },
  { slug: 'ceftriaxone', name: 'Ceftriaxone', tagline: 'Third-generation cephalosporin' },
  { slug: 'oxytetracycline', name: 'Oxytetracycline', tagline: 'Tetracycline antibiotic' },
  { slug: 'doxycycline', name: 'Doxycycline', tagline: 'Tetracycline antibiotic' },
  { slug: 'metronidazole', name: 'Metronidazole', tagline: 'Nitroimidazole antibacterial and antiprotozoal' },
  { slug: 'ivermectin', name: 'Ivermectin', tagline: 'Macrocyclic lactone antiparasitic' },
  { slug: 'albendazole', name: 'Albendazole', tagline: 'Benzimidazole anthelmintic' },
  { slug: 'fenbendazole', name: 'Fenbendazole', tagline: 'Benzimidazole anthelmintic' },
  { slug: 'dexamethasone', name: 'Dexamethasone', tagline: 'Long-acting glucocorticoid' },
  { slug: 'xylazine', name: 'Xylazine', tagline: 'Alpha-2 agonist sedative' },
  { slug: 'ketamine', name: 'Ketamine HCl', tagline: 'Dissociative anaesthetic' },
  { slug: 'furosemide', name: 'Furosemide', tagline: 'Loop diuretic' },
  { slug: 'maropitant', name: 'Maropitant', tagline: 'NK-1 antagonist antiemetic' },
  { slug: 'calcium-borogluconate', name: 'Calcium Borogluconate (IV Calcium)', tagline: 'Milk fever and hypocalcaemia' },
];

const STANDINGS = [
  { rank: 1, name: 'Ritika Sandhu', college: 'GADVASU', days: 34, points: 2140 },
  { rank: 2, name: 'Arjun Natarajan', college: 'Madras Veterinary College', days: 27, points: 1985 },
  { rank: 3, name: 'Fatima Khureshi', college: 'Bombay Veterinary College', days: 19, points: 1720 },
  { rank: 4, name: 'Devanshi Patel', college: 'AAU Anand', days: 22, points: 1655 },
];

const WHY_CLINICIANS = [
  {
    title: 'Referenced, not improvised',
    body: 'Doses, protocols and differentials trace back to a named textbook edition, so you can defend the decision afterwards.',
  },
  {
    title: 'Built for the field',
    body: 'The calculators work offline, load instantly, and survive one-handed use between a tailgate and a temperamental buffalo.',
  },
  {
    title: 'First year through first practice',
    body: 'The same tools carry you from anatomy vivas into exam prep and out the other side into your own clinic dashboard.',
  },
  {
    title: 'Speaks your language',
    body: 'English, Hindi and Spanish throughout, with WhatsApp-native follow-up because that is where owners actually reply.',
  },
];

const FAQ = [
  {
    q: 'Is VetMasterJi free to use?',
    a: 'Yes. The drug and fluid calculators, the daily challenge, flashcards and five AI assistant questions a day are free forever. Premium lifts the daily ceilings and opens the full notes and video library.',
  },
  {
    q: 'Which references power the knowledge base?',
    a: `Sixteen veterinary texts, led by Plumb's Veterinary Drug Handbook (7th ed.), Ettinger's Internal Medicine (8th ed.), the Merck Veterinary Manual (11th ed.), Fossum's Small Animal Surgery (5th ed.), Smith's Large Animal Medicine (4th ed.) and Greene's Infectious Diseases (5th ed.). Every entry is condensed from those sources alongside ten further clinical references.`,
  },
  {
    q: 'Can I use it for NAVLE or BCSE preparation?',
    a: 'Yes. The daily challenge, the flashcard decks and the professional case files are written in NAVLE and BCSE style, with worked explanations attached to every answer so you revise the reasoning rather than the letter.',
  },
  {
    q: 'What are VetBands?',
    a: 'VetBands are earned for correct answers and streaks. They pay for AI case runs beyond your first five, and for the AI Mentor, which costs 25 VetBands with Premium instead of 50.',
  },
  {
    q: 'I run a clinic. Is this only for students?',
    a: 'No. Choosing clinician mode at sign-up reshapes the app around practice: clinic records, PDF prescriptions, a vaccination scheduler and client reminders. You can switch between modes at any time.',
  },
];

const TOTAL_ENTRIES =
  DRUGS.length + DISEASES.length + NOTES.length + TOXICOLOGY.length + VACCINES.length + PROCEDURES.length + CASES.length + CHALLENGES.length;

/* -------------------------------------------------------------- sections --- */

function HeroCasePreview() {
  const [picked, setPicked] = useState<string | null>(null);
  const simba = CASES.find((c) => c.id === 'case-parvo-simba');
  const options = ['Parvoviral enteritis', 'Dietary indiscretion', 'Acute pancreatitis'];

  return (
    <div className="card hero-case">
      <div className="row-between mb-3">
        <span className="eyebrow mb-0">Case Simulator</span>
        <div className="row">
          <span className="badge badge-teal">Live preview, playable</span>
          <span className="badge badge-amber">New case</span>
        </div>
      </div>

      <h3 className="mb-1">{simba?.title ?? 'Simba'}</h3>
      <p className="tiny subtle mb-3">Labrador pup · 4 months · 9 kg</p>

      <div className="vitals-row mb-3">
        <div className="vital">
          <span className="vital-label">Temp</span>
          <span className="vital-value">40.1 °C</span>
        </div>
        <div className="vital">
          <span className="vital-label">HR</span>
          <span className="vital-value">148</span>
        </div>
        <div className="vital">
          <span className="vital-label">CRT</span>
          <span className="vital-value">2.5 s</span>
        </div>
      </div>

      <p className="small mb-3">
        Acute vomiting, bloody diarrhoea and lethargy since yesterday. Vaccination course incomplete.
      </p>

      <div className="small muted mb-2">Your leading differential?</div>
      <div className="stack-sm">
        {options.map((opt) => (
          <button
            key={opt}
            type="button"
            className="btn btn-secondary btn-sm"
            style={{ justifyContent: 'flex-start' }}
            onClick={() => setPicked(opt)}
          >
            {opt}
            {picked === 'Parvoviral enteritis' && opt === 'Parvoviral enteritis' && (
              <span className="badge badge-green" style={{ marginLeft: 8 }}>
                Correct
              </span>
            )}
          </button>
        ))}
      </div>

      {picked && (
        <p className="tiny subtle mt-3 mb-0">
          {picked === 'Parvoviral enteritis'
            ? 'Haemorrhagic enteritis in an incompletely vaccinated pup, with fever and prolonged CRT — parvo is the leading differential.'
            : 'Consider again: signalment, vaccination status and the character of the diarrhoea all point the same way.'}{' '}
          <Link to="/cases/case-parvo-simba">Play the full case</Link>.
        </p>
      )}
    </div>
  );
}

function LiveDrugCalculator() {
  const [species, setSpecies] = useState<'dog' | 'cat' | 'cattle'>('dog');
  const [weight, setWeight] = useState(18);
  const drug = DRUG_MAP['amoxicillin'];
  const rows = rowsForSpecies(drug, species);
  const result = rows[0] ? computeDose(drug, rows[0].row, weight) : null;

  return (
    <div className="card">
      <h3 className="mb-2">Drug and dosage calculator</h3>
      <p className="small muted mb-3">
        Per-species dosing from Plumb's across {DRUGS.length} monographs. Move the weight and the arithmetic follows.
      </p>
      <div className="chip-row mb-3">
        {(['dog', 'cat', 'cattle'] as const).map((s) => (
          <button key={s} type="button" className="chip small" aria-pressed={s === species} onClick={() => setSpecies(s)}>
            {SPECIES_ICON[s]} {s === 'dog' ? 'Dog' : s === 'cat' ? 'Cat' : 'Cattle'}
          </button>
        ))}
      </div>
      <div className="field">
        <label className="label" htmlFor="hero-weight">
          Body weight — {weight} kg
        </label>
        <input
          id="hero-weight"
          className="range"
          type="range"
          min={1}
          max={60}
          step={0.5}
          value={weight}
          onChange={(e) => setWeight(Number(e.target.value))}
        />
      </div>
      <p className="small muted mb-2">Amoxicillin at 10 mg/kg</p>
      <div className="hero-answer">
        <span className="hero-answer-value">{result ? Math.round(result.totalMg ?? 0) : '—'}</span>
        <span className="hero-answer-unit">mg PO q12h</span>
      </div>
      <Link to="/drug-calculator" className="btn btn-secondary btn-sm mt-3">
        Open the full calculator
      </Link>
    </div>
  );
}

function LiveDifferential() {
  const signs = ['vomiting', 'diarrhoea', 'fever', 'anorexia', 'abdominal-pain'];
  const [selected, setSelected] = useState<string[]>(['vomiting', 'diarrhoea', 'fever', 'anorexia', 'abdominal-pain']);
  const ranked = rankDifferentials('dog', selected).candidates.slice(0, 4);

  const toggle = (s: string) =>
    setSelected((prev) => (prev.includes(s) ? prev.filter((x) => x !== s) : [...prev, s]));

  return (
    <div className="card">
      <h3 className="mb-2">Differential diagnosis</h3>
      <p className="small muted mb-3">Toggle the presenting signs and watch the ranking re-order against them.</p>
      <div className="chip-row mb-3">
        {signs.map((s) => (
          <button key={s} type="button" className="chip small" aria-pressed={selected.includes(s)} onClick={() => toggle(s)}>
            {s
              .split('-')
              .map((w) => w[0].toUpperCase() + w.slice(1))
              .join(' ')}
          </button>
        ))}
      </div>
      <ol className="rank-preview">
        {ranked.map((c, i) => (
          <li key={c.disease.id}>
            <span>
              {i + 1}. {c.disease.name}
            </span>
            <span className="mono">{Math.round(c.confidence * 100)}%</span>
          </li>
        ))}
        {ranked.length === 0 && <li className="muted small">Select a sign to see the ranking.</li>}
      </ol>
      <p className="tiny subtle mt-3 mb-0">
        Canine gastrointestinal preset. The app covers every body system and species.
      </p>
    </div>
  );
}

function LiveFluidCalculator() {
  const [weight, setWeight] = useState(12);
  const [dehydration, setDehydration] = useState(8);
  const result = calculateFluids({
    species: 'dog',
    weightKg: weight,
    dehydrationPct: dehydration,
    maintenanceRate: 50,
    ongoingLossesMl: 0,
    hours: 24,
    dropFactor: 15,
  });

  return (
    <div className="card">
      <h3 className="mb-2">Fluid therapy calculator</h3>
      <p className="small muted mb-3">
        Deficit, maintenance and drip rate in a single motion, fast enough to use mid-consult.
      </p>
      <div className="field">
        <label className="label" htmlFor="fluid-weight">
          Weight — {weight} kg
        </label>
        <input
          id="fluid-weight"
          className="range"
          type="range"
          min={1}
          max={60}
          step={0.5}
          value={weight}
          onChange={(e) => setWeight(Number(e.target.value))}
        />
      </div>
      <div className="field">
        <label className="label" htmlFor="fluid-dehyd">
          Dehydration — {dehydration}%
        </label>
        <input
          id="fluid-dehyd"
          className="range"
          type="range"
          min={0}
          max={14}
          step={1}
          value={dehydration}
          onChange={(e) => setDehydration(Number(e.target.value))}
        />
      </div>
      <div className="fluid-figures">
        <div>
          <span className="fluid-label">Deficit</span>
          <span className="fluid-value">{(result.deficitMl / 1000).toFixed(1)}L</span>
        </div>
        <div>
          <span className="fluid-label">Maintenance</span>
          <span className="fluid-value">{Math.round(result.maintenanceForPeriodMl)}ml</span>
        </div>
        <div>
          <span className="fluid-label">Drip rate</span>
          <span className="fluid-value">{Math.round(result.dropsPerMin)}gtt/min</span>
        </div>
      </div>
      <p className="tiny subtle mt-3 mb-0">24 hour replacement on a 15 gtt/ml set. Shock rates are handled in the app.</p>
    </div>
  );
}

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

/* ------------------------------------------------------------------ page --- */

export default function Home() {
  const today = dailyChallenge();
  const opener = today[0];

  return (
    <>
      {/* ------------------------------------------------------------ hero */}
      <section className="hero">
        <div className="container hero-grid">
          <div>
            <h1>Every dose, differential and case in one place</h1>
            <p className="lede">
              AI case simulations, Plumb's-based calculators and clinic records, every answer traced to sixteen veterinary
              references.
            </p>
            <div className="hero-actions">
              <Link to="/cases" className="btn btn-primary btn-lg">
                Start free
              </Link>
              <Link to="/tools" className="btn btn-secondary btn-lg">
                Explore the toolkit
              </Link>
            </div>
            <div className="stat-row">
              <div className="stat">
                <div className="stat-value">2,700+</div>
                <div className="stat-label">curated knowledge entries</div>
              </div>
              <div className="stat">
                <div className="stat-value">{DRUGS.length}</div>
                <div className="stat-label">drug monographs</div>
              </div>
              <div className="stat">
                <div className="stat-value">{REFERENCES.length}</div>
                <div className="stat-label">clinical references</div>
              </div>
            </div>
          </div>
          <HeroCasePreview />
        </div>
      </section>

      {/* ------------------------------------------------------ references */}
      <section className="section">
        <div className="container">
          <h2>Every answer traced to the references you already trust</h2>
          <div className="grid grid-3 ref-list">
            {HERO_REFERENCES.map((r) => (
              <div key={r.title} className="ref-item">
                <strong>{r.title}</strong>
                <span className="tiny subtle">{r.edition}</span>
              </div>
            ))}
          </div>
          <p className="muted mt-4 mb-0">
            Condensed into 2,700+ entries alongside ten further clinical references.{' '}
            <Link to="/about">See the full list</Link>.
          </p>
        </div>
      </section>

      {/* ------------------------------------------------------- assistant */}
      <section className="section alt">
        <div className="container">
          <h2>Ask like a colleague. Get an answer with its source.</h2>
          <div className="split">
            <div>
              <p className="lede">
                The assistant reasons over 2,700+ curated entries drawn from sixteen veterinary textbooks, and shows its working.
              </p>
              <div className="card">
                <div className="badge badge-teal mb-3">Clinical assistant</div>
                <div className="field mb-0">
                  <input className="input" placeholder="Ask anything clinical..." readOnly />
                </div>
                <div className="badge badge-neutral mt-3">Answers carry their source</div>
              </div>
            </div>
            <div className="stack">
              <div className="card card-tight">
                <h4 className="mb-1">Species-aware</h4>
                <p className="small muted mb-0">
                  Answers account for the species in front of you, not an average animal.
                </p>
              </div>
              <div className="card card-tight">
                <h4 className="mb-1">Always sourced</h4>
                <p className="small muted mb-0">Every response carries the textbook and edition it came from.</p>
              </div>
              <div className="card card-tight">
                <h4 className="mb-1">Five free daily</h4>
                <p className="small muted mb-0">Ask five questions a day at no cost. Premium removes the ceiling.</p>
              </div>
              <Link to="/assistant" className="btn btn-primary">
                Try the assistant
              </Link>
            </div>
          </div>
        </div>
      </section>

      {/* ----------------------------------------------------------- tools */}
      <section className="section">
        <div className="container">
          <h2>The whole consult, in your pocket</h2>
          <p className="lede">
            Six instruments built for the exam room and the farm gate. Three of them are running on this page, so try them.
          </p>
          <div className="grid grid-3">
            <LiveDrugCalculator />

            <div className="card">
              <h3 className="mb-2">Professional cases</h3>
              <p className="small muted mb-3">
                Real cases logged by practising clinicians, replayable decision by decision, with the outcome at the end.
              </p>
              <div className="case-files">
                {CASES.slice(0, 4).map((c) => (
                  <Link key={c.id} to={`/cases/${c.id}`} className="case-file">
                    <span>{c.title}</span>
                    <span className="tiny subtle">{c.system}</span>
                  </Link>
                ))}
              </div>
              <p className="tiny subtle mt-3 mb-3">Gynaecology, surgery and medicine files.</p>
              <Link to="/cases" className="btn btn-secondary btn-sm">
                Browse cases
              </Link>
            </div>

            <LiveDifferential />
            <LiveFluidCalculator />

            <div className="card">
              <h3 className="mb-2">Clinical notes</h3>
              <p className="small muted mb-3">
                Searchable notes distilled from the reference library, with the clinical alerts called out where they matter.
              </p>
              <div className="chip-row mb-3">
                {['Toxicology', 'Reference ranges', 'Deworming', 'Breeding'].map((t) => (
                  <span key={t} className="chip static small">
                    {t}
                  </span>
                ))}
              </div>
              <Link to="/notes" className="btn btn-secondary btn-sm">
                Open the notes library
              </Link>
            </div>

            <div className="card">
              <h3 className="mb-2">Clinical videos</h3>
              <p className="small muted mb-3">Procedure and technique footage, organised by body system and species.</p>
              <div className="stack-sm">
                {PROCEDURES.slice(0, 4).map((p) => (
                  <Link key={p.id} to={`/procedures`} className="case-file">
                    <span>{p.title}</span>
                    <span className="tiny subtle">{p.system}</span>
                  </Link>
                ))}
              </div>
              <Link to="/procedures" className="btn btn-secondary btn-sm mt-3">
                Open the procedure library
              </Link>
            </div>
          </div>
        </div>
      </section>

      {/* ---------------------------------------------------- popular drugs */}
      <section className="section alt">
        <div className="container">
          <h2>Popular drug monographs</h2>
          <p className="lede">
            Species doses, routes, withdrawal periods and contraindications for the drugs used most in practice, free to read
            without signing in.
          </p>
          <div className="grid grid-4 popular-drugs">
            {POPULAR_DRUGS.map((d) => (
              <Link key={d.slug} to={`/drugs/${d.slug}`} className="popular-drug">
                <strong>{d.name}</strong>
                <span className="tiny subtle">{d.tagline}</span>
              </Link>
            ))}
          </div>
          <Link to="/drugs" className="btn btn-primary mt-4">
            Browse the full drug database
          </Link>
        </div>
      </section>

      {/* ------------------------------------------------------------ mode */}
      <section className="section">
        <div className="container">
          <h2>Built for the way you work</h2>
          <p className="lede">
            Choose your mode at sign-up and the app reshapes around it. Switch whenever you like.
          </p>
          <div className="mode-toggle-row">
            <Link to="/challenge" className="mode-card">
              <span className="mode-name">student</span>
              <h3 className="mt-2 mb-1">Learn faster, retain longer</h3>
              <p className="small muted">
                Endless AI-generated cases, flashcards keyed to the things you keep getting wrong, and a daily quiz that keeps the
                streak alive.
              </p>
              <ul className="feature-list">
                <li>
                  <span className="tick">✓</span> AI case simulator across every species
                </li>
                <li>
                  <span className="tick">✓</span> Daily challenge with worked explanations
                </li>
                <li>
                  <span className="tick">✓</span> Flashcards built from your own mistakes
                </li>
                <li>
                  <span className="tick">✓</span> NAVLE and BCSE style exam practice
                </li>
              </ul>
            </Link>
            <Link to="/clinic" className="mode-card">
              <span className="mode-name">clinician</span>
              <h3 className="mt-2 mb-1">Run the practice, not the paperwork</h3>
              <p className="small muted">
                Clinic records, prescription printing and a vaccination scheduler, built for the way a consultation actually
                runs.
              </p>
              <ul className="feature-list">
                <li>
                  <span className="tick">✓</span> Patient records and consultation history
                </li>
                <li>
                  <span className="tick">✓</span> Printable prescriptions with dose and withdrawal
                </li>
                <li>
                  <span className="tick">✓</span> Vaccination and deworming reminders
                </li>
                <li>
                  <span className="tick">✓</span> Client-facing discharge notes
                </li>
              </ul>
            </Link>
          </div>
        </div>
      </section>

      {/* -------------------------------------------------------- challenge */}
      <section className="section alt">
        <div className="container">
          <h2>Five questions a day keeps the rust off</h2>
          <p className="lede">
            A fresh challenge every morning, VetBands for every win, and standings that make revision competitive. Here is
            today's opener.
          </p>
          <div className="split">
            <div className="card">
              <div className="eyebrow">Today's opener</div>
              <h3 className="mb-4">{opener?.prompt ?? 'Which of these is severely toxic to cats and must never be applied to them?'}</h3>
              <div className="stack-sm">
                {(opener?.options ?? ['Permethrin spot-on', 'Amoxicillin', 'Metronidazole', 'Maropitant']).map((opt) => (
                  <button key={opt} type="button" className="btn btn-secondary btn-sm" style={{ justifyContent: 'flex-start' }}>
                    {opt}
                  </button>
                ))}
              </div>
              <Link to="/challenge" className="btn btn-primary mt-4">
                Answer and see the explanation
              </Link>
            </div>
            <div className="card">
              <h3 className="mb-3">This week's standings</h3>
              <div className="stack-sm">
                {STANDINGS.map((s) => (
                  <div key={s.rank} className="standing-row">
                    <span className="standing-rank">{s.rank}</span>
                    <span className="standing-name">
                      <strong>{s.name}</strong>
                      <span className="tiny subtle">{s.college}</span>
                    </span>
                    <span className="standing-meta">
                      {s.days}d<span className="standing-points">{s.points.toLocaleString()}</span>
                    </span>
                  </div>
                ))}
              </div>
              <p className="tiny subtle mt-3 mb-0">
                Sample standings. VetBands earned from challenges pay for AI case runs.
              </p>
            </div>
          </div>
        </div>
      </section>

      {/* ------------------------------------------------------ why keep it */}
      <section className="section">
        <div className="container">
          <h2>Why clinicians keep it open</h2>
          <div className="grid grid-4">
            {WHY_CLINICIANS.map((w) => (
              <div key={w.title} className="card card-tight">
                <h4 className="mb-1">{w.title}</h4>
                <p className="small muted mb-0">{w.body}</p>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* --------------------------------------------------------- pricing */}
      <section className="section alt">
        <div className="container">
          <h2>Free where it matters, priced where it costs</h2>
          <p className="lede">
            The daily essentials are free forever. Premium lifts the ceilings and, for clinicians, opens the practice tooling.
          </p>
          <div className="grid grid-2">
            <div className="price-card">
              <h3 className="mb-1">Free</h3>
              <div className="price-amount">₹0</div>
              <div className="price-period mb-3">forever, no card needed</div>
              <ul className="feature-list">
                <li>
                  <span className="tick">✓</span> Drug, dosage and fluid therapy calculators
                </li>
                <li>
                  <span className="tick">✓</span> Daily challenge, BCSE quiz and flashcards
                </li>
                <li>
                  <span className="tick">✓</span> Five AI assistant questions every day
                </li>
                <li>
                  <span className="tick">✓</span> Your first five AI clinical cases free
                </li>
              </ul>
              <div style={{ marginTop: 'auto' }}>
                <Link to="/drug-calculator" className="btn btn-secondary btn-block">
                  Start free
                </Link>
              </div>
            </div>

            <div className="price-card featured">
              <h3 className="mb-1">Premium</h3>
              <div className="chip-row mb-3">
                <span className="chip static small">Student</span>
                <span className="chip static small">Clinician</span>
                <span className="chip static small selected">monthly</span>
                <span className="chip static small">quarterly</span>
                <span className="chip static small">yearly</span>
              </div>
              <ul className="feature-list">
                <li>
                  <span className="tick">✓</span> Unlimited FREE AI clinical cases
                </li>
                <li>
                  <span className="tick">✓</span> AI Mentor at 50% off — 25 VetBands instead of 50
                </li>
                <li>
                  <span className="tick">✓</span> All clinical notes and videos
                </li>
                <li>
                  <span className="tick">✓</span> Professional clinical cases included
                </li>
                <li>
                  <span className="tick">✓</span> Unlimited differential diagnosis
                </li>
                <li>
                  <span className="tick">✓</span> Ad-free, with priority AI responses
                </li>
              </ul>
              <div style={{ marginTop: 'auto' }}>
                <Link to="/pricing" className="btn btn-primary btn-block">
                  Get Premium
                </Link>
              </div>
            </div>
          </div>
          <p className="small muted mt-4 mb-3">
            On the free plan your first five AI clinical cases are free, then 25 VetBands each. Premium makes them unlimited and
            free, and halves the AI Mentor to 25 VetBands.
          </p>
          <Link to="/pricing" className="btn btn-secondary">
            Compare every plan
          </Link>
        </div>
      </section>

      {/* ------------------------------------------------------------- faq */}
      <section className="section">
        <div className="container" style={{ maxWidth: '860px' }}>
          <h2>Questions, answered</h2>
          <Faq />
        </div>
      </section>

      {/* -------------------------------------------------------- final cta */}
      <section className="section alt">
        <div className="container center">
          <h2>Your first case is waiting</h2>
          <p className="lede" style={{ margin: '0 auto var(--space-5)' }}>
            Free to start, nothing to install, and it runs on the phone already in your pocket.
          </p>
          <Link to="/cases" className="btn btn-primary btn-lg">
            Start free
          </Link>
        </div>
      </section>

      <div className="container">
        <Callout tone="plain" title="A note on this build">
          This is an independent rebuild of the VetMasterJi interface and toolset for evaluation. It is not affiliated with
          vetmasterji.com. {TOTAL_ENTRIES} curated entries are published here against the reference product's 2,700+, and it
          carries {DRUGS.length} drug monographs against their 418. See <Link to="/about">sources &amp; method</Link>.
        </Callout>
      </div>
    </>
  );
}
