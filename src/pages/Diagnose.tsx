import { useMemo, useState } from 'react';
import { Link } from 'react-router-dom';
import { SIGNS, SIGN_MAP, signLabel, signsBySystem, COMMON_SIGN_IDS } from '../data/signs';
import { SPECIES_ICON, speciesLabel } from '../data/species';
import type { SpeciesId } from '../types';
import { rankDifferentials, discriminatingSigns, confidenceBand, redFlags } from '../engine/differentials';
import { PageHeader, Callout, Chip, Badge, Empty, Disclaimer } from '../components/ui';
import SpeciesPicker from '../components/SpeciesPicker';
import { usePreferences } from '../state/PreferencesContext';

export default function Diagnose() {
  const { species, setSpecies } = usePreferences();
  const [selected, setSelected] = useState<string[]>(['vomiting', 'haemorrhagic-diarrhoea', 'lethargy', 'anorexia']);
  const [systemFilter, setSystemFilter] = useState<string | null>(null);

  const result = useMemo(() => rankDifferentials(species as SpeciesId, selected), [species, selected]);
  const toCheck = useMemo(() => discriminatingSigns(result.candidates), [result]);
  const flags = useMemo(() => redFlags(selected), [selected]);
  const grouped = useMemo(() => signsBySystem(), []);

  const toggle = (id: string) => {
    setSelected((prev) => (prev.includes(id) ? prev.filter((s) => s !== id) : [...prev, id]));
  };

  return (
    <div className="container page">
      <PageHeader
        eyebrow="Tool"
        title="Differential diagnosis"
        lede="Select the signs in front of you. Each condition is scored by the share of its characteristic sign-weight the patient actually shows, so a condition that explains every finding outranks one that explains two of them."
      />

      <div className="split">
        <div className="card">
          <div className="field">
            <span className="label">Species</span>
            <SpeciesPicker compact showProxyNote={false} value={species} onChange={setSpecies} />
          </div>

          <div className="field">
            <div className="row-between mb-2">
              <span className="label mb-0">Presenting signs ({selected.length})</span>
              {selected.length > 0 && (
                <button type="button" className="btn btn-ghost btn-sm" onClick={() => setSelected([])}>
                  Clear
                </button>
              )}
            </div>
            <div className="chip-row">
              {(COMMON_SIGN_IDS.filter((s) => SIGN_MAP[s]) as string[]).map((id) => (
                <Chip key={id} small selected={selected.includes(id)} onClick={() => toggle(id)}>
                  {signLabel(id)}
                </Chip>
              ))}
            </div>
          </div>

          <div className="field mb-0">
            <span className="label">All signs, by system</span>
            <div className="chip-row mb-3">
              <Chip small selected={systemFilter === null} onClick={() => setSystemFilter(null)}>
                All systems
              </Chip>
              {grouped.map((g) => (
                <Chip key={g.system} small selected={systemFilter === g.system} onClick={() => setSystemFilter(g.system)}>
                  {g.system}
                </Chip>
              ))}
            </div>
            <div className="chip-row">
              {SIGNS.filter((s) => !systemFilter || s.system === systemFilter).map((s) => (
                <Chip key={s.id} small selected={selected.includes(s.id)} onClick={() => toggle(s.id)}>
                  {s.label}
                </Chip>
              ))}
            </div>
          </div>
        </div>

        <div>
          {flags.map((f) => (
            <Callout key={f} tone="danger" title="Red flag">
              {f}
            </Callout>
          ))}

          {selected.length === 0 ? (
            <Empty title="Select at least one sign">
              The ranker needs findings to work with. Start with the common signs above, or pick from the full list by system.
            </Empty>
          ) : result.candidates.length === 0 ? (
            <Empty title={`No condition in the library matches those signs in a ${speciesLabel(species).toLowerCase()}`}>
              The library holds conditions for {speciesLabel(species).toLowerCase()} across {grouped.length} body systems. Try
              removing a sign, or switch species.
            </Empty>
          ) : (
            <>
              <div className="row-between mb-3">
                <h2 className="mb-0">Ranked differentials</h2>
                <span className="tiny subtle">
                  {result.candidates.length} of {result.speciesConsidered} {speciesLabel(species).toLowerCase()} conditions
                  matched
                </span>
              </div>

              <div className="rank-list">
                {result.candidates.map((c, i) => {
                  const band = confidenceBand(c.confidence);
                  return (
                    <article key={c.disease.id} className="rank-item">
                      <div className="rank-head">
                        <span className="rank-num">{i + 1}.</span>
                        <h3 className="mb-0">
                          <Link to={`/diseases/${c.disease.id}`}>{c.disease.name}</Link>
                        </h3>
                        <span className="rank-score">{(c.confidence * 100).toFixed(0)}%</span>
                      </div>
                      <div className="confidence-bar">
                        <div
                          className={`confidence-fill ${band.tone === 'high' ? '' : band.tone === 'medium' ? 'medium' : 'low'}`}
                          style={{ width: `${Math.max(4, c.confidence * 100)}%` }}
                        />
                      </div>
                      <div className="row mb-2">
                        <Badge tone={band.tone === 'high' ? 'green' : band.tone === 'medium' ? 'amber' : 'neutral'}>
                          {band.label} confidence
                        </Badge>
                        <Badge tone="neutral">{c.disease.system}</Badge>
                      </div>
                      <p className="small muted mb-2">{c.disease.summary}</p>
                      <p className="small mb-1">
                        <strong>Supported by:</strong>{' '}
                        {c.matched.map((m) => m.label).join(', ') || '—'}
                        {c.compatible.length > 0 && <> · also compatible with {c.compatible.join(', ')}</>}
                      </p>
                      <p className="small muted mb-0">
                        <strong>Would raise this:</strong>{' '}
                        {c.missing.slice(0, 5).map((m) => m.label).join(', ') || 'nothing further listed'}
                      </p>
                    </article>
                  );
                })}
              </div>

              {toCheck.length > 0 && (
                <Callout tone="info" title="Signs that would separate these">
                  <p className="mb-2">
                    Examine for these next — they carry the most discriminating weight across the leading candidates:
                  </p>
                  <div className="chip-row">
                    {toCheck.map((s) => (
                      <Chip key={s} small selected={selected.includes(s)} onClick={() => toggle(s)}>
                        {signLabel(s)}
                      </Chip>
                    ))}
                  </div>
                </Callout>
              )}
            </>
          )}
        </div>
      </div>

      <section className="section">
        <div className="split">
          <div>
            <h2>How the score is calculated</h2>
            <p className="mono small muted">confidence = Σ weight of matched key signs ÷ Σ weight of all key signs</p>
            <p className="small muted">
              Each condition lists its characteristic signs with a weight: 1 for a sign that is sometimes present, 5 for one
              that is close to pathognomonic. Finding a heavily weighted sign moves a condition up sharply; finding signs the
              condition cannot explain leaves it where it is.
            </p>
            <p className="small muted mb-0">
              This is a recall aid, not a diagnosis. It cannot see the patient, and it does not know prevalence in your area.
            </p>
          </div>
          <div>
            <h2>Switching species</h2>
            <p className="small muted">
              The ranker only considers conditions recorded for {SPECIES_ICON[species]} {speciesLabel(species).toLowerCase()}.
              Change species in the panel above and the list is recalculated against the {speciesLabel(species).toLowerCase()}-
              specific condition set — {result.speciesConsidered} conditions are in scope.
            </p>
            <Callout tone="warning" title="Absence of evidence">
              A condition that is missing from the library cannot be ranked. If your top differential is not here, that is a gap
              in the corpus, not evidence against your judgement.
            </Callout>
          </div>
        </div>
      </section>

      <Disclaimer />
    </div>
  );
}
