import { Link } from 'react-router-dom';
import { DRUGS } from '../data/drugs';
import { SPECIES } from '../data/species';
import { REFERENCES } from '../data/references';
import { DISEASES } from '../data/diseases';
import { NOTES } from '../data/notes';
import { CASES } from '../data/cases';
import { TOXICOLOGY } from '../data/toxicology';
import { PROCEDURES } from '../data/procedures';
import { CHALLENGES, dailyChallenge } from '../data/challenges';
import { VACCINES } from '../data/vaccines';
import DoseCalculator from '../components/DoseCalculator';
import { ToolCard, Stat, SectionTitle, Callout } from '../components/ui';
import { usePreferences } from '../state/PreferencesContext';
import { useI18n } from '../i18n';

const TOOL_CARDS = [
  { to: '/drug-calculator', icon: '💊', title: 'Drug calculator', description: 'Weight × mg/kg, then straight to mL and tablets for named products.' },
  { to: '/fluid-therapy', icon: '💧', title: 'Fluid therapy', description: 'Deficit, maintenance, drip rate and a two-phase plan with shock bolus.' },
  { to: '/diagnose', icon: '🔍', title: 'Differential diagnosis', description: 'Rank conditions against the signs in front of you. Works offline.' },
  { to: '/interactions', icon: '⚠️', title: 'Interaction checker', description: 'Screen a whole prescription, not just a pair of drugs.' },
  { to: '/reference-ranges', icon: '📊', title: 'Reference ranges', description: 'Vitals, haematology and biochemistry for 15 species, with a value checker.' },
  { to: '/toxicology', icon: '☠️', title: 'Toxicology', description: 'Recognise the toxidrome, find the antidote, get the first hour right.' },
  { to: '/drugs', icon: '📚', title: 'Drug library', description: 'Monographs with per-indication citations and withdrawal intervals.' },
  { to: '/vaccinations', icon: '💉', title: 'Vaccination schedules', description: 'Core and non-core schedules by species, with reminder intervals.' },
  { to: '/diseases', icon: '🦠', title: 'Condition reference', description: 'Key signs, differentials, diagnosis, treatment outline and prognosis.' },
  { to: '/notes', icon: '📝', title: 'Clinical notes', description: 'Short, sourced answers to the questions asked at the consult table.' },
  { to: '/procedures', icon: '🩹', title: 'Procedure library', description: 'Step-by-step technique with the pitfalls that actually bite.' },
  { to: '/cases', icon: '🎮', title: 'Case simulator', description: 'Make the call at each decision point and see the score you earned.' },
];

export default function Home() {
  const { t } = useI18n();
  const { streak, earnedBands, mode } = usePreferences();
  const today = dailyChallenge();

  return (
    <>
      <section className="hero">
        <div className="container hero-grid">
          <div>
            <div className="eyebrow">Veterinary drug &amp; fluid reference</div>
            <h1>{t('home.title')}</h1>
            <p className="lede">{t('home.subtitle')}</p>
            <div className="hero-actions">
              <Link to="/drug-calculator" className="btn btn-primary btn-lg">
                {t('home.ctaPrimary')}
              </Link>
              <Link to="/drugs" className="btn btn-secondary btn-lg">
                {t('home.ctaSecondary')}
              </Link>
            </div>
            <div className="stat-row">
              <Stat value={String(DRUGS.length)} label={t('home.statDrugs')} />
              <Stat value={String(SPECIES.length)} label={t('home.statSpecies')} />
              <Stat value={String(REFERENCES.length)} label={t('home.statRefs')} />
              <Stat value="100%" label={t('home.statOffline')} />
            </div>
          </div>
          <div className="card">
            <div className="card-title">
              <h3 className="mb-0">Try it — no sign-up</h3>
              <span className="badge badge-teal">Live</span>
            </div>
            <DoseCalculator initialDrugId="meloxicam" initialSpecies="dog" initialWeight={18} />
          </div>
        </div>
      </section>

      <section className="section">
        <div className="container">
          <SectionTitle
            eyebrow="Twelve tools"
            title={t('tools.title')}
            action={
              <Link to="/tools" className="btn btn-secondary btn-sm">
                All tools
              </Link>
            }
          >
            {t('tools.subtitle')}
          </SectionTitle>
          <div className="grid grid-3">
            {TOOL_CARDS.map((c) => (
              <ToolCard key={c.to} {...c} />
            ))}
          </div>
        </div>
      </section>

      {mode === 'student' && (
        <section className="section">
          <div className="container">
            <SectionTitle
              eyebrow="Study"
              title="Revision that keeps score"
              action={
                <Link to="/challenge" className="btn btn-primary btn-sm">
                  Today’s challenge
                </Link>
              }
            >
              {today.length} questions set for today, drawn from {CHALLENGES.length}. Your streak is {streak.streak} and you have
              earned {earnedBands.length} VetBand{earnedBands.length === 1 ? '' : 's'}.
            </SectionTitle>
            <div className="grid grid-3">
              <ToolCard to="/cases" icon="🎮" title="Case simulator" description={`${CASES.length} scored cases with feedback at every decision point.`} />
              <ToolCard to="/flashcards" icon="🗂️" title="Flashcards" description="Spaced repetition over the drug corpus you are actually using." />
              <ToolCard to="/challenge" icon="🏅" title="Daily challenge" description="Five questions a day, banded by the streak you keep." />
            </div>
          </div>
        </section>
      )}

      <section className="section">
        <div className="container">
          <div className="split">
            <div>
              <SectionTitle eyebrow="Why it is built this way" title="Every number has a citation">
                A dose calculator that gives you 180 mg is easy. One that tells you the reference the 180 mg came from, the
                withdrawal interval, and the species warning that changes the plan — that is the tool you can defend.
              </SectionTitle>
              <div className="stack">
                <div className="card card-tight">
                  <h4 className="mb-1">📖 Traceable, not generated</h4>
                  <p className="small muted mb-0">
                    Each dose row carries the reference it was taken from — Plumb’s, Papich, BSAVA, Merck, FARAD. No value is
                    interpolated by a model.
                  </p>
                </div>
                <div className="card card-tight">
                  <h4 className="mb-1">📴 Works with no signal</h4>
                  <p className="small muted mb-0">
                    The whole corpus ships with the app. A consult in a barn with one bar of signal works the same as one on
                    clinic Wi-Fi.
                  </p>
                </div>
                <div className="card card-tight">
                  <h4 className="mb-1">🚫 Says no when it should</h4>
                  <p className="small muted mb-0">
                    Where a drug is prohibited in a food species, or no withdrawal is established, the entry says so instead of
                    printing a number.
                  </p>
                </div>
                <div className="card card-tight">
                  <h4 className="mb-1">🐃 Knows what it does not know</h4>
                  <p className="small muted mb-0">
                    Buffalo doses are carried over from cattle and labelled as a carry-over. Extrapolation is visible, never
                    silent.
                  </p>
                </div>
              </div>
            </div>
            <div>
              <div className="card">
                <h3 className="mb-3">Where to start</h3>
                <div className="stack-sm">
                  <Link to="/drugs/meloxicam" className="btn btn-secondary btn-block" style={{ justifyContent: 'flex-start' }}>
                    📄 Read a full monograph — meloxicam
                  </Link>
                  <Link to="/notes/note-dehydration" className="btn btn-secondary btn-block" style={{ justifyContent: 'flex-start' }}>
                    📝 Dehydration assessment at a glance
                  </Link>
                  <Link to="/cases/case-parvo-simba" className="btn btn-secondary btn-block" style={{ justifyContent: 'flex-start' }}>
                    🎮 Run the parvo puppy case
                  </Link>
                  <Link to="/toxicology/permethrin-cats" className="btn btn-secondary btn-block" style={{ justifyContent: 'flex-start' }}>
                    ☠️ Permethrin poisoning in a cat
                  </Link>
                  <Link to="/procedures/proc-iv-catheter-dog" className="btn btn-secondary btn-block" style={{ justifyContent: 'flex-start' }}>
                    🩹 Place an IV catheter in a dog
                  </Link>
                </div>
              </div>
              <Callout tone="plain" title="Honest about scope">
                This is a reference for qualified veterinarians and students under supervision. It does not replace clinical
                judgement, and it is not a substitute for the product label or national medicines regulations.
              </Callout>
            </div>
          </div>
        </div>
      </section>

      <section className="section">
        <div className="container">
          <SectionTitle eyebrow="The corpus" title="What is in the library" />
          <div className="grid grid-4">
            {[
              { n: DRUGS.length, label: 'drug monographs', to: '/drugs' },
              { n: DISEASES.length, label: 'conditions', to: '/diseases' },
              { n: NOTES.length, label: 'clinical notes', to: '/notes' },
              { n: TOXICOLOGY.length, label: 'toxicology entries', to: '/toxicology' },
              { n: PROCEDURES.length, label: 'procedures', to: '/procedures' },
              { n: VACCINES.length, label: 'vaccine schedule rows', to: '/vaccinations' },
              { n: CASES.length, label: 'scored cases', to: '/cases' },
              { n: CHALLENGES.length, label: 'practice questions', to: '/challenge' },
            ].map((s) => (
              <Link key={s.label} to={s.to} className="card card-tight" style={{ color: 'inherit' }}>
                <div className="stat-value">{s.n}</div>
                <div className="stat-label">{s.label}</div>
              </Link>
            ))}
          </div>
        </div>
      </section>

      <section className="section">
        <div className="container">
          <div className="card" style={{ background: 'linear-gradient(135deg, var(--teal-800), var(--teal-600))', color: '#fff' }}>
            <div className="row-between">
              <div>
                <h2 className="mb-2" style={{ color: '#fff' }}>
                  Everything clinical is free.
                </h2>
                <p className="mb-0" style={{ maxWidth: '60ch', opacity: 0.95 }}>
                  The calculators, the drug library and the condition reference are free and offline. The practice layer — patient
                  records, prescription PDFs, vaccination reminders — is what the paid plan covers.
                </p>
              </div>
              <div className="row">
                <Link to="/pricing" className="btn btn-primary btn-lg">
                  See pricing
                </Link>
                <Link to="/drugs" className="btn btn-secondary btn-lg">
                  Start using it
                </Link>
              </div>
            </div>
          </div>
        </div>
      </section>
    </>
  );
}
