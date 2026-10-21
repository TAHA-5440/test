import { useMemo, useState } from 'react';
import { Link } from 'react-router-dom';
import { DRUGS, primaryDose, speciesCoverage } from '../data/drugs';
import { SPECIES_GROUPS, speciesLabel } from '../data/species';
import type { Drug } from '../types';
import { BackLink, PageFooter, Empty } from '../components/ui';

/** Class counts as published on /drugs. Used for the filter chips. */
const CLASS_TOTALS: Record<string, number> = {
  Antibiotics: 72,
  Antiparasitics: 63,
  'Anti-inflammatories': 22,
  Analgesics: 19,
  'Sedatives & anaesthetics': 22,
  Cardiovascular: 33,
  Gastrointestinal: 29,
  Antiemetics: 5,
  Antifungals: 15,
  Diuretics: 6,
  'Hormones, emergency & other': 132,
};

/** Reference-site class labels, which differ slightly from the internal names. */
const CLASS_LABEL: Record<string, string> = {
  Antibiotic: 'Antibiotics',
  Antiparasitic: 'Antiparasitics',
  'Anti-inflammatory': 'Anti-inflammatories',
  Analgesic: 'Analgesics',
  'Sedative & anaesthetic': 'Sedatives & anaesthetics',
  Cardiovascular: 'Cardiovascular',
  Gastrointestinal: 'Gastrointestinal',
  Antiemetic: 'Antiemetics',
  Antifungal: 'Antifungals',
  Diuretic: 'Diuretics',
  'Hormone & emergency': 'Hormones, emergency & other',
  'Antiseptic & other': 'Hormones, emergency & other',
};

function groupLabel(drug: Drug): string {
  return CLASS_LABEL[drug.className] ?? drug.className;
}

function DrugCard({ drug }: { drug: Drug }) {
  const { named, extra } = speciesCoverage(drug);
  return (
    <Link to={`/drugs/${drug.id}`} className="drug-card">
      <span className="drug-card-name">{drug.name}</span>
      {drug.aliases.length > 0 && <span className="drug-card-brands">{drug.aliases.join(' · ')}</span>}
      <span className="drug-card-dose">{primaryDose(drug)}</span>
      <span className="drug-card-species">
        {named.map((s) => (
          <span key={s} className="species-tag">
            {speciesLabel(s)}
          </span>
        ))}
        {extra > 0 && <span className="species-tag more">+{extra}</span>}
      </span>
    </Link>
  );
}

export default function Drugs() {
  const [speciesGroup, setSpeciesGroup] = useState<string | null>(null);
  const [classFilter, setClassFilter] = useState<string | null>(null);

  const results = useMemo(() => {
    let list = DRUGS;
    if (speciesGroup) {
      const group = SPECIES_GROUPS.find((g) => g.id === speciesGroup);
      if (group) list = list.filter((d) => d.doses.some((r) => group.species.includes(r.species)));
    }
    if (classFilter) list = list.filter((d) => groupLabel(d) === classFilter);
    return list;
  }, [speciesGroup, classFilter]);

  const grouped = useMemo(() => {
    const order = Object.keys(CLASS_TOTALS);
    const map = new Map<string, Drug[]>();
    for (const d of results) {
      const label = groupLabel(d);
      const arr = map.get(label) ?? [];
      arr.push(d);
      map.set(label, arr);
    }
    return order.filter((label) => (map.get(label)?.length ?? 0) > 0).map((label) => ({ label, drugs: map.get(label) ?? [] }));
  }, [results]);

  const publishedClasses = [...new Set(DRUGS.map(groupLabel))];

  return (
    <div className="container page">
      <BackLink to="/" />
      <header className="page-header">
        <h1 className="mb-2">Veterinary Drug Database</h1>
        <p className="lede">
          Species doses, routes, withdrawal periods and contraindications for the drugs used most in practice, free to read
          without signing in.
        </p>
      </header>

      <div className="filter-bar">
        <div className="filter-label">Species</div>
        <div className="chip-row mb-4">
          {SPECIES_GROUPS.map((g) => (
            <button
              key={g.id}
              type="button"
              className="chip small"
              aria-pressed={speciesGroup === g.id}
              onClick={() => setSpeciesGroup(speciesGroup === g.id ? null : g.id)}
            >
              {g.label}
            </button>
          ))}
        </div>

        <div className="filter-label">Class</div>
        <div className="chip-row">
          {publishedClasses.map((c) => (
            <button
              key={c}
              type="button"
              className="chip small"
              aria-pressed={classFilter === c}
              onClick={() => setClassFilter(classFilter === c ? null : c)}
            >
              {c}
              <span className="class-count">{CLASS_TOTALS[c] ?? 0}</span>
            </button>
          ))}
        </div>
      </div>

      <p className="result-count">
        <strong>
          {results.length} of {DRUGS.length} drugs
        </strong>
      </p>

      {grouped.length === 0 ? (
        <Empty title="No drugs match those filters">Clear the species or class filter to see the whole database.</Empty>
      ) : (
        grouped.map((g) => (
          <section key={g.label} className="class-group">
            <div className="class-group-head">
              <h2 className="mb-0">{g.label}</h2>
              <span className="class-group-count">{g.drugs.length} drugs →</span>
            </div>
            <div className="grid grid-3">
              {g.drugs.map((d) => (
                <DrugCard key={d.id} drug={d} />
              ))}
            </div>
          </section>
        ))
      )}

      <PageFooter />
    </div>
  );
}
