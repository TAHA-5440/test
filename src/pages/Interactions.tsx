import { useMemo, useState } from 'react';
import { Link } from 'react-router-dom';
import { DRUGS, DRUG_MAP, searchDrugs } from '../data/drugs';
import { SPECIES_ICON, speciesLabel } from '../data/species';
import { screenPrescription, severityLabel } from '../engine/interactions';
import type { Severity } from '../engine/interactions';
import { PageHeader, Callout, Badge, Chip, Empty, Disclaimer, Sources, BackLink, PageFooter } from '../components/ui';
import type { SpeciesId } from '../types';
import { usePreferences } from '../state/PreferencesContext';

const TONE: Record<Severity, 'red' | 'amber' | 'blue' | 'neutral'> = {
  contraindicated: 'red',
  major: 'amber',
  moderate: 'blue',
  minor: 'neutral',
};

export default function Interactions() {
  const { species, setSpecies } = usePreferences();
  const [selected, setSelected] = useState<string[]>(['meloxicam', 'dexamethasone', 'furosemide']);
  const [query, setQuery] = useState('');

  const suggestions = useMemo(() => (query.trim() ? searchDrugs(query).slice(0, 8) : []), [query]);

  const findings = useMemo(() => screenPrescription(selected), [selected]);

  const add = (id: string) => {
    setSelected((prev) => (prev.includes(id) ? prev : [...prev, id]));
    setQuery('');
  };
  const remove = (id: string) => setSelected((prev) => prev.filter((s) => s !== id));

  const counts = useMemo(() => {
    const c: Record<string, number> = {};
    for (const f of findings) c[f.severity] = (c[f.severity] ?? 0) + 1;
    return c;
  }, [findings]);

  return (
    <div className="container page">
      <BackLink to="/tools" />
      <PageHeader
        eyebrow="Tool"
        title="Interaction checker"
        lede="Build the prescription you are about to write, then screen it in one pass. The checker applies class-level rules, monograph pairings and food-animal residue flags — because the dangerous combinations are rarely the ones you remember to look up."
      />

      <div className="split">
        <div className="card">
          <div className="field">
            <span className="label">Species</span>
            <div className="chip-row">
              {Object.entries(SPECIES_ICON).map(([s, icon]) => (
                <Chip key={s} small selected={s === species} onClick={() => setSpecies(s as SpeciesId)}>
                  {icon} {speciesLabel(s as SpeciesId)}
                </Chip>
              ))}
            </div>
          </div>

          <div className="field">
            <label className="label" htmlFor="rx-add">
              Add a drug to the prescription
            </label>
            <input
              id="rx-add"
              className="input"
              placeholder="Type a drug name…"
              value={query}
              onChange={(e) => setQuery(e.target.value)}
              autoComplete="off"
            />
            {suggestions.length > 0 && (
              <div className="stack-sm mt-2">
                {suggestions.map((d) => (
                  <button
                    key={d.id}
                    type="button"
                    className="btn btn-secondary btn-sm"
                    style={{ justifyContent: 'space-between' }}
                    onClick={() => add(d.id)}
                  >
                    <span>{d.name}</span>
                    <span className="tiny subtle">{d.className}</span>
                  </button>
                ))}
              </div>
            )}
          </div>

          <div className="field mb-0">
            <div className="row-between mb-2">
              <span className="label mb-0">Current prescription ({selected.length})</span>
              {selected.length > 0 && (
                <button type="button" className="btn btn-ghost btn-sm" onClick={() => setSelected([])}>
                  Clear
                </button>
              )}
            </div>
            {selected.length === 0 ? (
              <p className="small muted">No drugs added yet. Search above, or use a preset below.</p>
            ) : (
              <div className="stack-sm">
                {selected.map((id) => {
                  const d = DRUG_MAP[id];
                  if (!d) return null;
                  return (
                    <div key={id} className="row-between" style={{ border: '1px solid var(--border)', borderRadius: 'var(--radius)', padding: '8px 12px' }}>
                      <div>
                        <strong className="small">{d.name}</strong>
                        <div className="tiny subtle">{d.className}</div>
                      </div>
                      <div className="row">
                        <Link to={`/drugs/${id}`} className="btn btn-ghost btn-sm">
                          Open
                        </Link>
                        <button type="button" className="btn btn-ghost btn-sm" onClick={() => remove(id)} aria-label={`Remove ${d.name}`}>
                          ✕
                        </button>
                      </div>
                    </div>
                  );
                })}
              </div>
            )}
          </div>

          <div className="field mt-4 mb-0">
            <span className="label">Presets</span>
            <div className="stack-sm">
              {[
                { label: 'NSAID + steroid + diuretic', drugs: ['meloxicam', 'dexamethasone', 'furosemide'] },
                { label: 'Two NSAIDs together', drugs: ['meloxicam', 'flunixin-meglumine'] },
                { label: 'NSAID + aminoglycoside', drugs: ['meloxicam', 'gentamicin'] },
                { label: 'Sedation and reversal', drugs: ['medetomidine', 'ketamine', 'atipamezole'] },
                { label: 'Parvo protocol', drugs: ['maropitant', 'ceftriaxone', 'metronidazole'] },
                { label: 'Bovine mastitis', drugs: ['oxytetracycline', 'flunixin-meglumine'] },
              ].map((preset) => (
                <button
                  key={preset.label}
                  type="button"
                  className="btn btn-secondary btn-sm"
                  style={{ justifyContent: 'flex-start' }}
                  onClick={() => setSelected(preset.drugs.filter((d) => DRUG_MAP[d]))}
                >
                  {preset.label}
                </button>
              ))}
            </div>
          </div>
        </div>

        <div>
          {selected.length < 2 ? (
            <Empty title="Add at least two drugs">
              Interaction screening needs a prescription, not a single drug. Add a second drug or load a preset.
            </Empty>
          ) : (
            <>
              <div className="card mb-4">
                <div className="row-between">
                  <h3 className="mb-0">Screening {selected.length} drugs</h3>
                  <div className="row">
                    {counts.contraindicated ? <Badge tone="red">{counts.contraindicated} do not combine</Badge> : null}
                    {counts.major ? <Badge tone="amber">{counts.major} major</Badge> : null}
                    {counts.moderate ? <Badge tone="blue">{counts.moderate} moderate</Badge> : null}
                    {counts.minor ? <Badge tone="neutral">{counts.minor} minor</Badge> : null}
                    {findings.length === 0 && <Badge tone="green">No interactions found</Badge>}
                  </div>
                </div>
              </div>

              {findings.length === 0 ? (
                <Callout tone="success" title="Nothing flagged">
                  No class-level rule or monograph pairing fires for this combination in a {speciesLabel(species).toLowerCase()}.
                  Absence of a flag is not a guarantee of safety — it means nothing in the curated rule set applies.
                </Callout>
              ) : (
                <div className="stack">
                  {findings.map((f) => (
                    <article key={`${f.title}-${f.drugs.join('-')}`} className="rank-item">
                      <div className="row-between mb-2">
                        <h4 className="mb-0">{f.title}</h4>
                        <Badge tone={TONE[f.severity]}>{severityLabel(f.severity)}</Badge>
                      </div>
                      <div className="chip-row mb-2">
                        {f.drugs.map((d) => (
                          <Chip key={d} small>
                            {DRUG_MAP[d]?.name ?? d}
                          </Chip>
                        ))}
                      </div>
                      <p className="small mb-2">{f.detail}</p>
                      <p className="small mb-2">
                        <strong>Action:</strong> {f.action}
                      </p>
                      <p className="tiny subtle mb-0">Source: {f.source}</p>
                    </article>
                  ))}
                </div>
              )}
            </>
          )}
        </div>
      </div>

      <section className="section">
        <div className="split">
          <div>
            <h2>What the checker looks for</h2>
            <ul className="small muted">
              <li>
                <strong>Class-level rules</strong> — NSAID with corticosteroid, two NSAIDs together, NSAID with an
                aminoglycoside, ACE inhibitor with an NSAID, and the rest of the combinations that recur in practice.
              </li>
              <li>
                <strong>Monograph pairings</strong> — specific interactions recorded on the individual drug entries.
              </li>
              <li>
                <strong>Duplicate therapy</strong> — two drugs of the same class, which is the most common way a patient
                receives a double dose.
              </li>
            </ul>
          </div>
          <div>
            <h2>What it does not do</h2>
            <ul className="small muted">
              <li>It does not know the dose, the route or the interval you intend to use.</li>
              <li>It does not check for a species-specific contraindication recorded on the monograph — read the entry.</li>
              <li>It has no rule for every possible pair. The rule set is finite and published.</li>
            </ul>
            <Callout tone="plain" title="Read the monograph too">
              {DRUGS.length} monographs are searchable from here. The interaction checker is a screen, not a substitute for
              reading the drug you are prescribing.
            </Callout>
          </div>
        </div>
      </section>

      <Sources
        ids={selected.flatMap((id) => DRUG_MAP[id]?.sources ?? []).slice(0, 12)}
        label="Sources for the drugs on this prescription"
      />
      <Disclaimer />
          <PageFooter />
    </div>
  );
}
