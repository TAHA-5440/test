import { Link, useParams } from 'react-router-dom';
import { DISEASE_MAP, DISEASES } from '../data/diseases';
import { signLabel } from '../data/signs';
import { SPECIES_ICON, speciesLabel } from '../data/species';
import { DRUG_MAP } from '../data/drugs';
import { PageHeader, Callout, Badge, Chip, Sources, Empty, Disclaimer, KeyValue, BackLink, PageFooter } from '../components/ui';
import type { SpeciesId } from '../types';

export default function DiseaseDetail() {
  const { id = '' } = useParams();
  const disease = DISEASE_MAP[id];

  if (!disease) {
    return (
      <div className="container page">
      <BackLink to="/diseases" />
        <Empty title="That condition is not in the reference">
          The library currently holds {DISEASES.length} conditions. <Link to="/diseases">Browse the full list</Link>.
        </Empty>
      </div>
    );
  }

  const related = DISEASES.filter((d) => d.id !== disease.id && d.system === disease.system).slice(0, 6);
  const maxWeight = Math.max(...disease.keySigns.map((k) => k.weight), 1);

  return (
    <div className="container page">
      <nav className="small muted mb-3">
        <Link to="/diseases">Conditions</Link> › <span>{disease.system}</span>
      </nav>

      <PageHeader
        eyebrow={disease.system}
        title={disease.name}
        lede={disease.aka.length > 0 ? disease.aka.join(' · ') : undefined}
      />

      <div className="row mb-4">
        {disease.species.map((s) => (
          <Badge key={s} tone="neutral">
            {SPECIES_ICON[s as SpeciesId]} {speciesLabel(s as SpeciesId)}
          </Badge>
        ))}
        <Badge tone="teal">{disease.keySigns.length} key signs</Badge>
        <Badge tone="neutral">Last reviewed {disease.lastReviewed}</Badge>
      </div>

      <div className="split">
        <div>
          <section className="card mb-4">
            <h2 className="mb-3">At a glance</h2>
            <p>{disease.summary}</p>
            <KeyValue
              items={[
                ['System', disease.system],
                ['Species', disease.species.map((s) => speciesLabel(s as SpeciesId)).join(', ')],
                ['Prognosis', disease.prognosis],
              ]}
            />
          </section>

          <section className="card mb-4">
            <h2 className="mb-3">Key signs</h2>
            <p className="small muted">
              Weighted by how characteristic each sign is for this condition. The weight is what the differential ranker uses.
            </p>
            <div className="stack-sm">
              {[...disease.keySigns]
                .sort((a, b) => b.weight - a.weight)
                .map((k) => (
                  <div key={k.sign} className="row" style={{ gap: 'var(--space-3)' }}>
                    <div style={{ width: '150px', flexShrink: 0 }}>
                      <strong className="small">{signLabel(k.sign)}</strong>
                    </div>
                    <div style={{ flex: 1, height: '8px', background: 'var(--bg-sunken)', borderRadius: '999px', overflow: 'hidden' }}>
                      <div
                        style={{
                          width: `${(k.weight / maxWeight) * 100}%`,
                          height: '100%',
                          background: k.weight >= 4 ? 'var(--danger)' : k.weight >= 3 ? 'var(--amber-500)' : 'var(--teal-500)',
                        }}
                      />
                    </div>
                    <span className="tiny mono subtle" style={{ width: '70px' }}>
                      weight {k.weight}
                    </span>
                  </div>
                ))}
            </div>
            {disease.otherSigns.length > 0 && (
              <>
                <h4 className="mt-4 mb-2">Also reported</h4>
                <div className="chip-row">
                  {disease.otherSigns.map((s) => (
                    <Chip key={s}>{signLabel(s)}</Chip>
                  ))}
                </div>
              </>
            )}
          </section>

          <section className="card mb-4">
            <h2 className="mb-3">Diagnosis</h2>
            <ul>
              {disease.diagnosis.map((d) => (
                <li key={d}>{d}</li>
              ))}
            </ul>
          </section>
        </div>

        <div>
          <section className="card mb-4">
            <h2 className="mb-3">Treatment outline</h2>
            <p>{disease.treatment}</p>
            {disease.drugRefs && disease.drugRefs.length > 0 && (
              <>
                <h4 className="mb-2">Drugs referenced</h4>
                <div className="stack-sm">
                  {disease.drugRefs.map((ref) => {
                    const drug = DRUG_MAP[ref];
                    if (!drug) return null;
                    return (
                      <Link key={ref} to={`/drugs/${ref}`} className="btn btn-secondary btn-sm" style={{ justifyContent: 'space-between' }}>
                        <span>{drug.name}</span>
                        <span className="tiny subtle">{drug.className}</span>
                      </Link>
                    );
                  })}
                </div>
              </>
            )}
          </section>

          <section className="card mb-4">
            <h2 className="mb-3">Differentials to rule out</h2>
            <div className="chip-row">
              {disease.differentials.map((d) => {
                const match = DISEASES.find((x) => x.name.toLowerCase() === d.toLowerCase());
                return match ? (
                  <Link key={d} to={`/diseases/${match.id}`} className="chip">
                    {d}
                  </Link>
                ) : (
                  <Chip key={d}>{d}</Chip>
                );
              })}
            </div>
          </section>

          <section className="card mb-4">
            <h2 className="mb-3">Prognosis</h2>
            <Callout tone={/guarded|poor|grave/i.test(disease.prognosis) ? 'warning' : 'success'} title="Expected course">
              {disease.prognosis}
            </Callout>
            {disease.prevention && (
              <>
                <h4 className="mb-2">Prevention</h4>
                <p className="small">{disease.prevention}</p>
              </>
            )}
          </section>

          {related.length > 0 && (
            <section className="card mb-4">
              <h2 className="mb-3">Related conditions</h2>
              <div className="stack-sm">
                {related.map((r) => (
                  <Link key={r.id} to={`/diseases/${r.id}`} className="btn btn-secondary btn-sm" style={{ justifyContent: 'flex-start' }}>
                    {r.name}
                  </Link>
                ))}
              </div>
            </section>
          )}
        </div>
      </div>

      <div className="row">
        <Link to="/diagnose" className="btn btn-primary">
          Rank this against presenting signs
        </Link>
      </div>

      <Sources ids={disease.sources} />
      <Disclaimer />
          <PageFooter />
    </div>
  );
}
