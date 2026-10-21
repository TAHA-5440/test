import { useMemo, useState } from 'react';
import { Link } from 'react-router-dom';
import { BackLink, PageFooter, Empty } from '../components/ui';

interface ToolDef {
  to: string;
  kind: string;
  title: string;
  description: string;
}

const TOOLS: ToolDef[] = [
  {
    to: '/drug-calculator',
    kind: 'Interactive · free',
    title: 'Drug dose calculator',
    description: 'Species-specific doses for 418 drugs: mg, mL, tablets, withdrawal.',
  },
  {
    to: '/fluid-therapy',
    kind: 'Interactive · free',
    title: 'Fluid therapy calculator',
    description: 'Deficit, maintenance, total volume, mL/h and drip rate.',
  },
  {
    to: '/diagnose',
    kind: 'Interactive · free',
    title: 'Differential diagnosis',
    description: 'Rank conditions from the clinical signs you see.',
  },
  {
    to: '/interactions',
    kind: 'Interactive · free',
    title: 'Interaction checker',
    description: 'Screen a prescription for interactions and duplicate therapy.',
  },
  {
    to: '/reference-ranges',
    kind: 'Interactive · free',
    title: 'Reference ranges',
    description: 'Vitals, haematology and biochemistry for 7 species — with a value checker.',
  },
  {
    to: '/toxicology',
    kind: 'Interactive · free',
    title: 'Poisoning & antidotes',
    description: 'Signs, antidote doses and first-line management.',
  },
  {
    to: '/drugs',
    kind: 'Reference',
    title: 'Drug database',
    description: '418 monographs: doses, contraindications, withdrawal.',
  },
  {
    to: '/vaccinations',
    kind: 'Reference',
    title: 'Vaccination schedules',
    description: 'Dogs, cats, cattle and poultry — plus the clinic tracker.',
  },
  {
    to: '/diseases',
    kind: 'Reference',
    title: 'Disease reference',
    description: 'Signs, differentials, diagnostics and treatment outlines.',
  },
  {
    to: '/daily-challenge',
    kind: 'Free account',
    title: 'Daily MCQ challenge',
    description: 'Five clinical questions a day with explanations.',
  },
  {
    to: '/flashcards',
    kind: 'Free account',
    title: 'Flashcards',
    description: 'Spaced repetition, keyed to what you get wrong.',
  },
];

export default function Tools() {
  const [query, setQuery] = useState('');

  const results = useMemo(() => {
    const q = query.trim().toLowerCase();
    if (!q) return TOOLS;
    return TOOLS.filter(
      (t) => t.title.toLowerCase().includes(q) || t.description.toLowerCase().includes(q) || t.kind.toLowerCase().includes(q),
    );
  }, [query]);

  return (
    <div className="container page" style={{ maxWidth: '900px' }}>
      <BackLink to="/" />

      <header className="page-header">
        <h1 className="mb-2">Free Veterinary Calculators &amp; Clinical Tools</h1>
      </header>

      <div className="tool-search">
        <input
          className="input"
          placeholder="Search every drug, disease and tool…"
          value={query}
          onChange={(e) => setQuery(e.target.value)}
          aria-label="Search tools"
        />
        <span className="kbd-hint" aria-hidden="true">
          /
        </span>
      </div>

      {results.length === 0 ? (
        <Empty title="No tool matches that search">Try “dose”, “fluid”, “ranges” or “challenge”.</Empty>
      ) : (
        <div className="stack-sm">
          {results.map((t) => (
            <Link key={t.to} to={t.to} className="tool-row">
              <span className="tool-row-kind">{t.kind}</span>
              <span className="tool-row-body">
                <span className="tool-row-title">{t.title}</span>
                <span className="tool-row-desc">{t.description}</span>
              </span>
              <span className="tool-row-open">Open</span>
            </Link>
          ))}
        </div>
      )}

      <PageFooter />
    </div>
  );
}
