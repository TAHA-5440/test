import { useMemo, useState } from 'react';
import { Link } from 'react-router-dom';
import { DRUGS, DRUG_CLASSES, searchDrugs } from '../data/drugs';
import { SPECIES, SPECIES_ICON, speciesLabel } from '../data/species';
import type { SpeciesId } from '../types';
import { PageHeader, Chip, Badge, Empty, Callout } from '../components/ui';
import { usePreferences } from '../state/PreferencesContext';
import { useI18n } from '../i18n';

export default function Drugs() {
  const { t } = useI18n();
  const { species, setSpecies } = usePreferences();
  const [query, setQuery] = useState('');
  const [classFilter, setClassFilter] = useState<string | null>(null);
  const [onlyWithDose, setOnlyWithDose] = useState(false);

  const results = useMemo(() => {
    let list = searchDrugs(query);
    if (classFilter) list = list.filter((d) => d.className === classFilter);
    if (onlyWithDose) {
      list = list.filter((d) => {
        const direct = d.doses.some((r) => r.species === species && (r.doseLow !== null || r.doseHigh !== null));
        if (direct) return true;
        const proxy = SPECIES.find((s) => s.id === species)?.dosedAs;
        return proxy ? d.doses.some((r) => r.species === proxy && (r.doseLow !== null || r.doseHigh !== null)) : false;
      });
    }
    return list;
  }, [query, classFilter, onlyWithDose, species]);

  const countsByClass = useMemo(() => {
    const counts = new Map<string, number>();
    for (const d of DRUGS) counts.set(d.className, (counts.get(d.className) ?? 0) + 1);
    return counts;
  }, []);

  return (
    <div className="container page">
      <PageHeader
        eyebrow="Drug library"
        title={`${DRUGS.length} drug monographs`}
        lede="Every monograph carries per-indication citations, species warnings, withdrawal intervals and the formulations you can actually buy. Filter by class, or restrict the list to drugs with a published dose for your species."
      />

      <div className="card mb-4">
        <div className="field">
          <label className="label" htmlFor="drug-library-search">
            {t('common.search')}
          </label>
          <input
            id="drug-library-search"
            className="input"
            placeholder="Drug name, brand, class or indication…"
            value={query}
            onChange={(e) => setQuery(e.target.value)}
            autoComplete="off"
          />
        </div>

        <div className="field">
          <span className="label">{t('drugs.filterClass')}</span>
          <div className="chip-row">
            <Chip selected={classFilter === null} onClick={() => setClassFilter(null)}>
              {t('drugs.allClasses')} ({DRUGS.length})
            </Chip>
            {DRUG_CLASSES.filter((c) => (countsByClass.get(c) ?? 0) > 0).map((c) => (
              <Chip key={c} selected={classFilter === c} onClick={() => setClassFilter(c)}>
                {c} ({countsByClass.get(c)})
              </Chip>
            ))}
          </div>
        </div>

        <div className="row-between">
          <label className="checkbox-row" style={{ maxWidth: '420px' }}>
            <input type="checkbox" checked={onlyWithDose} onChange={(e) => setOnlyWithDose(e.target.checked)} />
            <span>
              Only drugs with a published {speciesLabel(species).toLowerCase()} dose
              <span className="tiny subtle"> — includes doses carried over by proxy</span>
            </span>
          </label>
          <select
            className="select"
            style={{ maxWidth: '220px' }}
            value={species}
            onChange={(e) => setSpecies(e.target.value as SpeciesId)}
            aria-label="Species filter"
          >
            {SPECIES.map((s) => (
              <option key={s.id} value={s.id}>
                {SPECIES_ICON[s.id]} {s.label}
              </option>
            ))}
          </select>
        </div>
      </div>

      <p className="small muted mb-3">
        <strong>{results.length}</strong> {t('common.results')}
        {query && <> for “{query}”</>}
      </p>

      {results.length === 0 ? (
        <Empty title={t('common.noResults')}>
          Try a class name, an indication such as “mastitis”, or clear the filters.
        </Empty>
      ) : (
        <div className="grid grid-3">
          {results.map((d) => {
            const speciesCovered = new Set(d.doses.filter((r) => r.doseLow !== null || r.doseHigh !== null).map((r) => r.species));
            const hasThis = speciesCovered.has(species);
            return (
              <Link key={d.id} to={`/drugs/${d.id}`} className="card card-tight" style={{ color: 'inherit', display: 'block' }}>
                <div className="row-between mb-2">
                  <Badge tone="teal">{d.className}</Badge>
                  {!hasThis && <Badge tone="neutral">No {speciesLabel(species).toLowerCase()} dose</Badge>}
                </div>
                <h3 className="mb-1">{d.name}</h3>
                <p className="small muted mb-3">{d.summary}</p>
                <div className="row tiny subtle">
                  <span>{speciesCovered.size} species</span>
                  <span>·</span>
                  <span>{d.doses.length} dose rows</span>
                  {d.prescriptionOnly && (
                    <>
                      <span>·</span>
                      <span>POM</span>
                    </>
                  )}
                </div>
              </Link>
            );
          })}
        </div>
      )}

      <Callout tone="plain" title="About the corpus">
        Monographs are compiled from the reference texts listed on the{' '}
        <Link to="/about">sources &amp; method</Link> page. The reference product ships 418 monographs; this build publishes{' '}
        {DRUGS.length} fully-cited entries and is growing. A dose that is absent is deliberately absent — it is not a gap to be
        filled by guessing.
      </Callout>
    </div>
  );
}
