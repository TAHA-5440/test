import type { Drug, DrugClass, SpeciesId } from '../../types';
import { ANTIBIOTICS } from './antibiotics';
import { ANTIPARASITICS } from './antiparasitics';
import { ANALGESIA } from './analgesia';
import { ANAESTHESIA } from './anaesthesia';
import { SUPPORTIVE } from './supportive';

export const DRUGS: Drug[] = [
  ...ANTIBIOTICS,
  ...ANTIPARASITICS,
  ...ANALGESIA,
  ...ANAESTHESIA,
  ...SUPPORTIVE,
].sort((a, b) => a.name.localeCompare(b.name));

export const DRUG_MAP: Record<string, Drug> = DRUGS.reduce(
  (acc, d) => {
    acc[d.id] = d;
    return acc;
  },
  {} as Record<string, Drug>,
);

export const DRUG_CLASSES: DrugClass[] = [
  'Antibiotic',
  'Antiparasitic',
  'Anti-inflammatory',
  'Analgesic',
  'Sedative & anaesthetic',
  'Cardiovascular',
  'Gastrointestinal',
  'Antiemetic',
  'Antifungal',
  'Diuretic',
  'Hormone & emergency',
  'Antiseptic & other',
];

export function drugsByClass(className: DrugClass): Drug[] {
  return DRUGS.filter((d) => d.className === className);
}

/** Species that have at least one published dose across the whole database. */
export function speciesWithDoses(): { species: SpeciesId; count: number }[] {
  const counts = new Map<SpeciesId, number>();
  for (const drug of DRUGS) {
    const seen = new Set<SpeciesId>();
    for (const row of drug.doses) {
      if (row.doseLow === null && row.doseHigh === null) continue;
      if (seen.has(row.species)) continue;
      seen.add(row.species);
      counts.set(row.species, (counts.get(row.species) ?? 0) + 1);
    }
  }
  return [...counts.entries()].map(([species, count]) => ({ species, count }));
}

export function searchDrugs(query: string): Drug[] {
  const q = query.trim().toLowerCase();
  if (!q) return DRUGS;
  return DRUGS.filter((d) => {
    if (d.name.toLowerCase().includes(q)) return true;
    if (d.className.toLowerCase().includes(q)) return true;
    if (d.aliases.some((a) => a.toLowerCase().includes(q))) return true;
    return d.doses.some((row) => row.indication.toLowerCase().includes(q));
  });
}

export function relatedDrugs(drug: Drug, limit = 6): Drug[] {
  return DRUGS.filter((d) => d.id !== drug.id && d.className === drug.className).slice(0, limit);
}
