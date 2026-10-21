import { useMemo, useState } from 'react';
import { Link } from 'react-router-dom';
import { DISEASES, searchDiseases, diseasesForSpecies } from '../data/diseases';
import { signLabel } from '../data/signs';
import { SPECIES_ICON, speciesLabel } from '../data/species';
import { PageHeader, Chip, Badge, Empty, Callout, BackLink, PageFooter } from '../components/ui';
import { usePreferences } from '../state/PreferencesContext';

export default function Diseases() {
  const { species } = usePreferences();
  const [query, setQuery] = useState('');
  const [onlyThisSpecies, setOnlyThisSpecies] = useState(true);

  const results = useMemo(() => {
    if (onlyThisSpecies) {
      const list = diseasesForSpecies(species);
      if (!query.trim()) return list;
      const q = query.trim().toLowerCase();
      return list.filter(
        (d) =>
          d.name.toLowerCase().includes(q) ||
          d.aka.some((a) => a.toLowerCase().includes(q)) ||
          d.summary.toLowerCase().includes(q) ||
          d.system.toLowerCase().includes(q),
      );
    }
    return searchDiseases(query);
  }, [query, onlyThisSpecies, species]);

  const systems = useMemo(() => [...new Set(DISEASES.map((d) => d.system))].sort(), []);
  const [systemFilter, setSystemFilter] = useState<string | null>(null);
  const shown = systemFilter ? results.filter((d) => d.system === systemFilter) : results;

  return (
    <div className="container page">
      <BackLink to="/" />
      <PageHeader
        eyebrow="Reference"
        title={`Condition reference`}
        lede={`${DISEASES.length} conditions with key signs, differentials, a diagnosis plan, a treatment outline and an honest prognosis. Every entry is weighted for the differential ranker, so what you read here is what the diagnose tool scores.`}
      />

      <div className="card mb-4">
        <div className="field">
          <label className="label" htmlFor="disease-search">
            Search conditions
          </label>
          <input
            id="disease-search"
            className="input"
            placeholder="Name, synonym, system or a sign…"
            value={query}
            onChange={(e) => setQuery(e.target.value)}
            autoComplete="off"
          />
        </div>
        <div className="field">
          <span className="label">Body system</span>
          <div className="chip-row">
            <Chip small selected={systemFilter === null} onClick={() => setSystemFilter(null)}>
              All systems
            </Chip>
            {systems.map((s) => (
              <Chip key={s} small selected={systemFilter === s} onClick={() => setSystemFilter(s)}>
                {s}
              </Chip>
            ))}
          </div>
        </div>
        <label className="checkbox-row mb-0">
          <input type="checkbox" checked={onlyThisSpecies} onChange={(e) => setOnlyThisSpecies(e.target.checked)} />
          <span>
            Only conditions recorded in {SPECIES_ICON[species]} {speciesLabel(species).toLowerCase()}
          </span>
        </label>
      </div>

      <p className="small muted mb-3">
        <strong>{shown.length}</strong> conditions
      </p>

      {shown.length === 0 ? (
        <Empty title="No condition matches those filters">
          <div className="stack-sm mt-3">
            <button type="button" className="btn btn-secondary btn-sm" onClick={() => { setQuery(''); setSystemFilter(null); setOnlyThisSpecies(false); }}>
              Clear all filters
            </button>
          </div>
        </Empty>
      ) : (
        <div className="grid grid-2">
          {shown.map((d) => (
            <Link key={d.id} to={`/diseases/${d.id}`} className="card card-tight" style={{ color: 'inherit', display: 'block' }}>
              <div className="row-between mb-2">
                <Badge tone="teal">{d.system}</Badge>
                <span className="tiny subtle">
                  {d.species.slice(0, 3).map((s) => SPECIES_ICON[s]).join(' ')}
                  {d.species.length > 3 ? ` +${d.species.length - 3}` : ''}
                </span>
              </div>
              <h3 className="mb-1">{d.name}</h3>
              {d.aka.length > 0 && <p className="tiny subtle mb-2">{d.aka.join(' · ')}</p>}
              <p className="small muted mb-3">{d.summary}</p>
              <div className="chip-row">
                {d.keySigns.slice(0, 5).map((k) => (
                  <span key={k.sign} className="chip static small">
                    {signLabel(k.sign)}
                  </span>
                ))}
                {d.keySigns.length > 5 && <span className="chip static small">+{d.keySigns.length - 5}</span>}
              </div>
            </Link>
          ))}
        </div>
      )}

      <Callout tone="plain" title="Sign weights are visible">
        Every condition lists its key signs with the weight the ranker assigns them. That makes the differential tool auditable:
        you can see why a condition scored what it scored rather than taking the percentage on trust.
      </Callout>
          <PageFooter />
    </div>
  );
}
