import { useMemo, useState } from 'react';
import { PROCEDURES, PROCEDURE_SYSTEMS, searchProcedures } from '../data/procedures';
import { SPECIES_ICON, speciesLabel } from '../data/species';
import type { SpeciesId } from '../types';
import { PageHeader, Chip, Badge, Empty, Callout, Disclaimer } from '../components/ui';

const LEVEL_TONE: Record<string, 'green' | 'amber' | 'red'> = {
  Core: 'green',
  Intermediate: 'amber',
  Advanced: 'red',
};

export default function Procedures() {
  const [query, setQuery] = useState('');
  const [system, setSystem] = useState<string | null>(null);
  const [openId, setOpenId] = useState<string | null>(PROCEDURES[0]?.id ?? null);

  const results = useMemo(() => {
    const list = searchProcedures(query);
    return system ? list.filter((p) => p.system === system) : list;
  }, [query, system]);

  return (
    <div className="container page">
      <PageHeader
        eyebrow="Reference"
        title="Procedure library"
        lede="Technique written as a sequence: what you need, the order you do it in, and the pitfalls that actually bite. Structured rather than filmed, so it loads instantly, works offline and can be read with your hands occupied."
      />

      <div className="card mb-4">
        <div className="field">
          <label className="label" htmlFor="proc-search">
            Search procedures
          </label>
          <input
            id="proc-search"
            className="input"
            placeholder="e.g. catheter, stomach tube, lavage, foot trimming…"
            value={query}
            onChange={(e) => setQuery(e.target.value)}
            autoComplete="off"
          />
        </div>
        <div className="field mb-0">
          <span className="label">System</span>
          <div className="chip-row">
            <Chip small selected={system === null} onClick={() => setSystem(null)}>
              All ({PROCEDURES.length})
            </Chip>
            {PROCEDURE_SYSTEMS.map((s) => {
              const n = PROCEDURES.filter((p) => p.system === s).length;
              return (
                <Chip key={s} small selected={system === s} onClick={() => setSystem(s)}>
                  {s} ({n})
                </Chip>
              );
            })}
          </div>
        </div>
      </div>

      {results.length === 0 ? (
        <Empty title="No procedure matches that search">
          Try a verb — place, pass, trim, collect — or clear the system filter.
        </Empty>
      ) : (
        <div className="stack">
          {results.map((p) => {
            const open = openId === p.id;
            return (
              <article key={p.id} className="card">
                <button
                  type="button"
                  className="row-between"
                  onClick={() => setOpenId(open ? null : p.id)}
                  style={{ background: 'none', border: 'none', padding: 0, width: '100%', textAlign: 'left', cursor: 'pointer', color: 'inherit' }}
                  aria-expanded={open}
                >
                  <div>
                    <h3 className="mb-1">{p.title}</h3>
                    <p className="small muted mb-0">
                      {p.system} · {p.duration} · {p.steps.length} steps
                    </p>
                  </div>
                  <div className="row">
                    <Badge tone={LEVEL_TONE[p.level] ?? 'neutral'}>{p.level}</Badge>
                    <span className="chip-row">
                      {p.species.slice(0, 3).map((s) => (
                        <span key={s} className="chip static small">
                          {SPECIES_ICON[s]} {speciesLabel(s as SpeciesId)}
                        </span>
                      ))}
                    </span>
                    <span aria-hidden="true" className="muted">
                      {open ? '▴' : '▾'}
                    </span>
                  </div>
                </button>

                {open && (
                  <div className="mt-4">
                    <p>{p.summary}</p>
                    <div className="split">
                      <div>
                        <h4>Equipment</h4>
                        <ul className="small">
                          {p.equipment.map((e) => (
                            <li key={e}>{e}</li>
                          ))}
                        </ul>
                      </div>
                      <div>
                        <h4>Sequence</h4>
                        <ol className="small">
                          {p.steps.map((s, i) => (
                            <li key={i}>{s}</li>
                          ))}
                        </ol>
                      </div>
                    </div>
                    <Callout tone="danger" title="Pitfalls">
                      <ul className="small mb-0">
                        {p.pitfalls.map((x) => (
                          <li key={x}>{x}</li>
                        ))}
                      </ul>
                    </Callout>
                    <p className="tiny subtle mb-0">
                      Sources: {p.sources.join(', ')}
                    </p>
                  </div>
                )}
              </article>
            );
          })}
        </div>
      )}

      <Callout tone="info" title="Why text and not video">
        The reference product shelves clinical videos. This build deliberately replaces them with structured steps: a video
        cannot be searched, cannot be read in a dark barn, and cannot be checked against a citation. Where a step is
        anatomy-dependent, the pitfall list says so and points you at the reference.
      </Callout>

      <Disclaimer />
    </div>
  );
}
