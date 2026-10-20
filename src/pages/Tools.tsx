import { PageHeader, ToolCard, Callout } from '../components/ui';
import { useI18n } from '../i18n';

export default function Tools() {
  const { t } = useI18n();
  const groups = [
    {
      title: 'Bedside calculators',
      tools: [
        { to: '/drug-calculator', icon: '💊', title: 'Drug calculator', description: 'Weight × mg/kg → total mg, then mL per product and tablets, with the withdrawal interval.' },
        { to: '/fluid-therapy', icon: '💧', title: 'Fluid therapy', description: 'Deficit, maintenance, ongoing losses, drip rate and a two-phase plan.' },
        { to: '/interactions', icon: '⚠️', title: 'Interaction checker', description: 'Screen an entire prescription at once, including food-animal residue rules.' },
      ],
    },
    {
      title: 'Decision support',
      tools: [
        { to: '/diagnose', icon: '🔍', title: 'Differential diagnosis', description: 'Rank conditions by the signs present and see which signs would discriminate.' },
        { to: '/assistant', icon: '🤖', title: 'Clinical assistant', description: 'Ask a question in plain language; get a sourced answer from the curated corpus.' },
        { to: '/toxicology', icon: '☠️', title: 'Toxicology', description: 'Toxidrome, antidote, decontamination window and the first hour of management.' },
      ],
    },
    {
      title: 'Reference',
      tools: [
        { to: '/reference-ranges', icon: '📊', title: 'Reference ranges', description: 'Vitals, haematology and biochemistry for 15 species, with a value checker.' },
        { to: '/drugs', icon: '📚', title: 'Drug library', description: 'Monographs with per-indication citations, species warnings and formulations.' },
        { to: '/diseases', icon: '🦠', title: 'Condition reference', description: 'Key signs, differentials, diagnosis, treatment outline and prognosis.' },
        { to: '/notes', icon: '📝', title: 'Clinical notes', description: 'Short, sourced answers to the questions asked at the consult table.' },
        { to: '/procedures', icon: '🩹', title: 'Procedure library', description: 'Equipment, sequence and pitfalls for the procedures you perform standing up.' },
        { to: '/vaccinations', icon: '💉', title: 'Vaccination schedules', description: 'Core and non-core schedules by species with reminder intervals.' },
      ],
    },
    {
      title: 'Learn',
      tools: [
        { to: '/cases', icon: '🎮', title: 'Case simulator', description: 'Make the call at each decision point and see the score you earned.' },
        { to: '/challenge', icon: '🏅', title: 'Daily challenge', description: 'Five questions a day, with streaks and VetBands.' },
        { to: '/flashcards', icon: '🗂️', title: 'Flashcards', description: 'Spaced repetition over the drug and condition corpus.' },
      ],
    },
  ];

  return (
    <div className="container page">
      <PageHeader eyebrow="Twelve tools" title={t('tools.title')} lede={t('tools.subtitle')} />
      {groups.map((g) => (
        <section key={g.title} className="section">
          <h2>{g.title}</h2>
          <div className="grid grid-3">
            {g.tools.map((tool) => (
              <ToolCard key={tool.to} {...tool} />
            ))}
          </div>
        </section>
      ))}
      <Callout tone="info" title="Why everything is on-device">
        Every one of these tools runs entirely in your browser. There is no API call behind a dose calculation, which is why they
        still work in a barn with no signal — and why your patient data never leaves the device.
      </Callout>
    </div>
  );
}
