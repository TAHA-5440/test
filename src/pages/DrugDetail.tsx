import { useMemo, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import { DRUG_MAP, relatedDrugs, DRUGS } from '../data/drugs';
import { SPECIES_ICON, speciesLabel } from '../data/species';
import { referenceTitle } from '../data/references';
import type { SpeciesId } from '../types';
import { formatDoseRange, withdrawalFor, rowsForSpecies } from '../engine/dosing';
import DoseCalculator from '../components/DoseCalculator';
import { Callout, Badge, Sources, Empty, Disclaimer, BackLink, PageFooter } from '../components/ui';
import { usePreferences } from '../state/PreferencesContext';

const SEVERITY_TONE: Record<string, 'red' | 'amber' | 'blue' | 'neutral'> = {
  contraindicated: 'red',
  major: 'amber',
  moderate: 'blue',
  minor: 'neutral',
};

function Section({ id, title, children }: { id: string; title: string; children: React.ReactNode }) {
  return (
    <section id={id} className="section">
      <h2>{title}</h2>
      {children}
    </section>
  );
}

export default function DrugDetail() {
  const { id = '' } = useParams();
  const drug = DRUG_MAP[id];
  const { species, setSpecies, toggleBookmark, isBookmarked } = usePreferences();
  const [showAllSpecies, setShowAllSpecies] = useState(false);

  const speciesRows = useMemo(() => {
    if (!drug) return [];
    const bySpecies = new Map<SpeciesId, typeof drug.doses>();
    for (const row of drug.doses) {
      const list = bySpecies.get(row.species) ?? [];
      list.push(row);
      bySpecies.set(row.species, list);
    }
    return [...bySpecies.entries()].sort((a, b) => speciesLabel(a[0]).localeCompare(speciesLabel(b[0])));
  }, [drug]);

  if (!drug) {
    return (
      <div className="container page">
      <BackLink to="/drugs" />
        <Empty title="That monograph is not in the library">
          The library currently publishes {DRUGS.length} monographs. <Link to="/drugs">Browse the full list</Link>.
        </Empty>
      </div>
    );
  }

  const bookmarked = isBookmarked(drug.id);
  const related = relatedDrugs(drug, 6);
  const rowsForCurrent = rowsForSpecies(drug, species);
  const visibleSpecies = showAllSpecies ? speciesRows : speciesRows.filter(([s]) => s === species || rowsForSpecies(drug, s).length > 0);

  return (
    <div className="container page">
      <nav className="small muted mb-3">
        <Link to="/drugs">Drug library</Link> › <span>{drug.className}</span>
      </nav>

      <header className="page-header">
        <div className="row-between">
          <div>
            <div className="eyebrow">{drug.className}</div>
            <h1 className="mb-1">{drug.name}</h1>
            {drug.aliases.length > 0 && (
              <p className="muted small mb-0">
                Also: {drug.aliases.join(', ')}
                {drug.products[0]?.brand ? ` · ${drug.products.map((p) => p.brand).filter(Boolean).slice(0, 4).join(', ')}` : ''}
              </p>
            )}
          </div>
          <div className="row">
            <button
              type="button"
              className="btn btn-secondary btn-sm"
              onClick={() => toggleBookmark(drug.id)}
              aria-pressed={bookmarked}
            >
              {bookmarked ? '★ Saved' : '☆ Save'}
            </button>
            <button type="button" className="btn btn-secondary btn-sm no-print" onClick={() => window.print()}>
              Print
            </button>
          </div>
        </div>
        <p className="lede mt-3">{drug.summary}</p>
        <div className="row">
          {drug.prescriptionOnly && <Badge tone="amber">Prescription-only medicine</Badge>}
          <Badge tone="neutral">{drug.doses.length} dose rows</Badge>
          <Badge tone="neutral">{new Set(drug.doses.map((d) => d.species)).size} species</Badge>
          <Badge tone="neutral">Last reviewed {drug.lastReviewed}</Badge>
        </div>
      </header>

      <section className="card mb-4">
        <h2 className="mb-3">Quick dose</h2>
        <DoseCalculator initialDrugId={drug.id} initialSpecies={species} initialWeight={18} onChange={(_d, s) => setSpecies(s)} />
      </section>

      {rowsForCurrent.length === 0 && (
        <Callout tone="warning" title={`No published ${speciesLabel(species).toLowerCase()} dose`}>
          Nothing in this monograph supports dosing a {speciesLabel(species).toLowerCase()}. Change species in the calculator
          above, or check the class for an alternative.
        </Callout>
      )}

      <Section id="doses" title="Dose rates by species">
        <div className="row-between mb-3">
          <p className="small muted mb-0">
            Each row is the reference rate for that indication in that species. Withdrawal intervals are those published in the
            cited source — the product label in your jurisdiction may differ and takes precedence.
          </p>
          <button type="button" className="btn btn-ghost btn-sm" onClick={() => setShowAllSpecies((s) => !s)}>
            {showAllSpecies ? 'Show dosed species only' : 'Show every species row'}
          </button>
        </div>
        {visibleSpecies.map(([sp, rows]) => (
          <div key={sp} className="mb-4">
            <h3 className="mb-2">
              {SPECIES_ICON[sp]} {speciesLabel(sp)}
            </h3>
            <div className="table-wrap">
              <table>
                <thead>
                  <tr>
                    <th>Indication</th>
                    <th>Dose</th>
                    <th>Route</th>
                    <th>Frequency</th>
                    <th>Duration</th>
                    <th>Withdrawal</th>
                    <th>Source</th>
                  </tr>
                </thead>
                <tbody>
                  {rows.map((row, i) => {
                    const wd = withdrawalFor(row);
                    return (
                      <tr key={`${row.indication}-${i}`}>
                        <td>
                          <strong>{row.indication}</strong>
                          {row.note && <div className="tiny subtle mt-1">{row.note}</div>}
                        </td>
                        <td className="mono nowrap">{formatDoseRange(row)}</td>
                        <td>{row.route}</td>
                        <td className="nowrap">{row.frequency}</td>
                        <td className="small">{row.duration ?? '—'}</td>
                        <td className="small">
                          <Badge
                            tone={
                              wd.level === 'set' ? 'amber' : wd.level === 'unknown' ? 'red' : wd.level === 'na' ? 'neutral' : 'green'
                            }
                          >
                            {wd.text}
                          </Badge>
                        </td>
                        <td className="tiny subtle" style={{ maxWidth: '180px' }}>
                          {row.source}
                        </td>
                      </tr>
                    );
                  })}
                </tbody>
              </table>
            </div>
          </div>
        ))}
      </Section>

      <Section id="contraindications" title="Contraindications">
        <ul>
          {drug.contraindications.map((c) => (
            <li key={c}>{c}</li>
          ))}
        </ul>
      </Section>

      {drug.speciesWarnings.length > 0 && (
        <Section id="species-warnings" title="Species warnings">
          <div className="stack">
            {drug.speciesWarnings.map((w) => (
              <Callout key={`${w.species}-${w.text}`} tone="danger" title={`${SPECIES_ICON[w.species]} ${speciesLabel(w.species)}`}>
                {w.text}
              </Callout>
            ))}
          </div>
        </Section>
      )}

      <div className="split">
        <div>
          <Section id="adverse" title="Adverse effects">
            <ul>
              {drug.adverseEffects.map((a) => (
                <li key={a}>{a}</li>
              ))}
            </ul>
          </Section>

          <Section id="mechanism" title="Mechanism">
            <p>{drug.mechanism}</p>
          </Section>

          <Section id="monitoring" title="Monitoring">
            <ul>
              {drug.monitoring.map((m) => (
                <li key={m}>{m}</li>
              ))}
            </ul>
          </Section>
        </div>
        <div>
          <Section id="interactions" title="Interactions">
            {drug.interactions.length === 0 ? (
              <p className="muted">No interactions on file for this monograph.</p>
            ) : (
              <div className="stack">
                {drug.interactions.map((ix) => (
                  <div key={`${ix.with}-${ix.effect}`} className="rank-item">
                    <div className="row-between mb-2">
                      <strong>with {ix.with}</strong>
                      <Badge tone={SEVERITY_TONE[ix.severity] ?? 'neutral'}>{ix.severity}</Badge>
                    </div>
                    <p className="small mb-2">{ix.effect}</p>
                    <p className="small mb-0">
                      <strong>Action:</strong> {ix.action}
                    </p>
                  </div>
                ))}
              </div>
            )}
          </Section>

          <Section id="pregnancy" title="Pregnancy &amp; lactation">
            <p>{drug.pregnancyLactation}</p>
          </Section>

          <Section id="overdose" title="Overdose &amp; toxicity">
            <Callout tone="warning" title="If an overdose is suspected">
              {drug.overdose}
            </Callout>
          </Section>
        </div>
      </div>

      <Section id="pearls" title="Clinical pearls">
        <ul>
          {drug.pearls.map((p) => (
            <li key={p}>{p}</li>
          ))}
        </ul>
      </Section>

      <div className="split">
        <div>
          <Section id="products" title="Formulations">
            <div className="table-wrap">
              <table>
                <thead>
                  <tr>
                    <th>Product</th>
                    <th>Form</th>
                    <th>Strength</th>
                    <th>Note</th>
                  </tr>
                </thead>
                <tbody>
                  {drug.products.map((p, i) => (
                    <tr key={`${p.name}-${i}`}>
                      <td>
                        <strong>{p.name}</strong>
                        {p.brand && <div className="tiny subtle">{p.brand}</div>}
                      </td>
                      <td className="small">{p.form}</td>
                      <td className="mono small">
                        {p.concentrationMgPerMl ? `${p.concentrationMgPerMl} mg/mL` : p.mgPerUnit ? `${p.mgPerUnit} mg` : '—'}
                      </td>
                      <td className="tiny subtle">{p.note ?? '—'}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
            {drug.storage && (
              <p className="small muted">
                <strong>Storage:</strong> {drug.storage}
              </p>
            )}
          </Section>
        </div>
        <div>
          <Section id="sources" title="Sources">
            <ul>
              {[...new Set(drug.sources)].map((s) => (
                <li key={s}>{referenceTitle(s)}</li>
              ))}
            </ul>
            <p className="tiny subtle">
              Each dose row above cites the specific text it was taken from. Where two references disagree, the range is shown as
              published and the difference is noted against the row.
            </p>
          </Section>

          {related.length > 0 && (
            <Section id="related" title="Related drugs">
              <div className="stack-sm">
                {related.map((r) => (
                  <Link key={r.id} to={`/drugs/${r.id}`} className="btn btn-secondary btn-sm" style={{ justifyContent: 'space-between' }}>
                    <span>{r.name}</span>
                    <span className="tiny subtle">{r.doses.length} rows</span>
                  </Link>
                ))}
              </div>
            </Section>
          )}
        </div>
      </div>

      <Sources ids={drug.sources} />
      <Disclaimer />
          <PageFooter />
    </div>
  );
}
