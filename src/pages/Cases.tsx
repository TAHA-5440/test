import { Link } from 'react-router-dom';
import { CASES, maxScoreForCase } from '../data/cases';
import { SPECIES_ICON, speciesLabel } from '../data/species';
import type { SpeciesId } from '../types';
import { PageHeader, Badge, Callout } from '../components/ui';
import { usePreferences } from '../state/PreferencesContext';

const DIFF_TONE: Record<string, 'green' | 'amber' | 'red'> = {
  Foundation: 'green',
  Intermediate: 'amber',
  Advanced: 'red',
};

export default function Cases() {
  const { streak, earnedBands } = usePreferences();

  return (
    <div className="container page">
      <PageHeader
        eyebrow="Study"
        title="Case simulator"
        lede="Work a case the way it arrives: signalment, history, examination, then decisions. Each choice is scored and explained, and the case keeps your total so you can see where you lost marks rather than just whether you passed."
      />

      <div className="row mb-4">
        <Badge tone="teal">{CASES.length} cases</Badge>
        <Badge tone="neutral">{streak.casesCompleted} completed</Badge>
        <Badge tone="amber">{streak.points} points</Badge>
        {earnedBands.length > 0 && (
          <Badge tone="green">
            {earnedBands[earnedBands.length - 1].icon} {earnedBands[earnedBands.length - 1].label} VetBand
          </Badge>
        )}
      </div>

      <div className="grid grid-2">
        {CASES.map((c) => {
          const max = maxScoreForCase(c);
          return (
            <Link key={c.id} to={`/cases/${c.id}`} className="card card-tight" style={{ color: 'inherit', display: 'block' }}>
              <div className="row-between mb-2">
                <Badge tone={DIFF_TONE[c.difficulty] ?? 'neutral'}>{c.difficulty}</Badge>
                <div className="row tiny subtle">
                  <span>
                    {SPECIES_ICON[c.species as SpeciesId]} {speciesLabel(c.species as SpeciesId)}
                  </span>
                  <span>·</span>
                  <span>{c.system}</span>
                </div>
              </div>
              <h3 className="mb-1">{c.title}</h3>
              <p className="small muted mb-2">{c.signalment}</p>
              <p className="small mb-3">{c.presenting}</p>
              <div className="row tiny subtle">
                <span>{c.steps.length} decision points</span>
                <span>·</span>
                <span>{max} points available</span>
                <span>·</span>
                <span>{c.clinician}</span>
              </div>
            </Link>
          );
        })}
      </div>

      <Callout tone="plain" title="How scoring works">
        Each option carries a score — the best answer earns full marks, a defensible but suboptimal one earns partial, and a
        harmful one scores zero and tells you why. Finishing a case adds 25 points to your total.
      </Callout>
    </div>
  );
}
