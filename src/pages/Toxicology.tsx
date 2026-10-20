import { useMemo, useState } from 'react';
import { Link } from 'react-router-dom';
import { TOXICOLOGY, searchToxicology } from '../data/toxicology';
import { SPECIES_ICON, speciesLabel } from '../data/species';
import { PageHeader, Callout, Badge, Empty, Sources, Disclaimer } from '../components/ui';

export default function Toxicology() {
  const [query, setQuery] = useState('');
  const [openId, setOpenId] = useState<string | null>(TOXICOLOGY[0]?.id ?? null);

  const results = useMemo(() => searchToxicology(query), [query]);

  return (
    <div className="container page">
      <PageHeader
        eyebrow="Tool"
        title="Toxicology &amp; antidotes"
        lede="Fifteen of the presentations that actually arrive: what the toxidrome looks like, how fast it comes on, whether an antidote exists, and what to do in the first hour. Arranged so you can find the entry while the owner is still on the phone."
      />

      <Callout tone="danger" title="The first hour decides most of these">
        Decontamination only works inside a window. If the ingestion was recent and the patient is asymptomatic, that is the
        moment emesis or activated charcoal changes the outcome — not after the signs appear.
      </Callout>

      <div className="field">
        <label className="label" htmlFor="tox-search">
          Search toxins
        </label>
        <input
          id="tox-search"
          className="input"
          placeholder="e.g. permethrin, chocolate, rodenticide, xylitol…"
          value={query}
          onChange={(e) => setQuery(e.target.value)}
          autoComplete="off"
        />
      </div>

      <p className="small muted mb-3">
        <strong>{results.length}</strong> entries
      </p>

      {results.length === 0 ? (
        <Empty title="No toxin matches that search">
          Try the active ingredient rather than the product name — most of these entries are indexed by both, but household
          brands are not all covered.
        </Empty>
      ) : (
        <div className="stack">
          {results.map((t) => {
            const open = openId === t.id;
            return (
              <article key={t.id} className="card">
                <button
                  type="button"
                  className="row-between"
                  onClick={() => setOpenId(open ? null : t.id)}
                  style={{ background: 'none', border: 'none', padding: 0, width: '100%', textAlign: 'left', cursor: 'pointer', color: 'inherit' }}
                  aria-expanded={open}
                >
                  <div>
                    <h3 className="mb-1">{t.toxin}</h3>
                    <p className="small muted mb-0">
                      {t.aliases.length > 0 && <span className="subtle">Also: {t.aliases.slice(0, 4).join(', ')} · </span>}
                      Onset: {t.onset}
                    </p>
                  </div>
                  <div className="row">
                    <div className="chip-row">
                      {t.species.slice(0, 4).map((s) => (
                        <span key={s} className="chip static small">
                          {SPECIES_ICON[s]} {speciesLabel(s)}
                        </span>
                      ))}
                    </div>
                    <span aria-hidden="true" className="muted">
                      {open ? '▴' : '▾'}
                    </span>
                  </div>
                </button>

                {open && (
                  <div className="mt-4">
                    <div className="grid grid-2">
                      <div>
                        <h4>Mechanism</h4>
                        <p className="small">{t.mechanism}</p>

                        <h4>Signs</h4>
                        <ul className="small">
                          {t.signs.map((s) => (
                            <li key={s}>{s}</li>
                          ))}
                        </ul>
                      </div>
                      <div>
                        <h4>Antidote</h4>
                        <Callout tone={/no specific|none/i.test(t.antidote) ? 'warning' : 'success'} title={/no specific|none/i.test(t.antidote) ? 'No specific antidote' : 'Specific antidote available'}>
                          {t.antidote}
                        </Callout>

                        <h4>Management</h4>
                        <ol className="small">
                          {t.management.map((m) => (
                            <li key={m}>{m}</li>
                          ))}
                        </ol>
                      </div>
                    </div>

                    <h4>Pearls</h4>
                    <ul className="small">
                      {t.pearls.map((p) => (
                        <li key={p}>{p}</li>
                      ))}
                    </ul>

                    <div className="row-between">
                      <Sources ids={t.sources} />
                      <Link to="/notes/note-toxicology-first-hour" className="btn btn-secondary btn-sm">
                        First-hour note
                      </Link>
                    </div>
                  </div>
                )}
              </article>
            );
          })}
        </div>
      )}

      <section className="section">
        <div className="split">
          <div>
            <h2>Call a poison line</h2>
            <p className="small muted">
              National animal poison control services hold product-specific formulation data that no general reference can. If
              the exposure involves a commercial product, a human medication, or an unknown substance, call with the packaging in
              hand before committing to a protocol.
            </p>
          </div>
          <div>
            <h2>Dose makes the poison</h2>
            <p className="small muted">
              Where an entry gives no minimum toxic dose, that is deliberate — the published thresholds vary widely with
              formulation, and a number quoted without its context causes more harm than no number at all.
            </p>
            <Badge tone="amber">Entries: {TOXICOLOGY.length}</Badge>
          </div>
        </div>
      </section>

      <Disclaimer />
    </div>
  );
}
