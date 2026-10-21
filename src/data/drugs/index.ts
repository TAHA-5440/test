import type { Drug, DrugClass, SpeciesId } from '../../types';
import { SPECIES } from '../../data/species';
import { formatNumber } from '../../engine/dosing';
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

/** The headline dose shown on a drug card: "10–20 mg/kg PO". */
export function primaryDose(drug: Drug): string {
  const row = drug.doses.find((d) => d.doseLow !== null || d.doseHigh !== null) ?? drug.doses[0];
  if (!row) return '';
  const unit = row.unit.replace('/animal', ' per animal').replace('/quarter', ' per quarter').replace('/L', ' per litre');
  if (row.doseLow === null && row.doseHigh === null) return `${row.indication}`;
  if (row.doseHigh !== null && row.doseLow !== null && row.doseHigh !== row.doseLow) {
    return `${formatNumber(row.doseLow)}–${formatNumber(row.doseHigh)} ${unit} ${row.route}`;
  }
  return `${formatNumber(row.doseLow ?? row.doseHigh ?? 0)} ${unit} ${row.route}`;
}

/**
 * Ordered species coverage for a drug card: the first three are named on the
 * card itself and the remainder collapse into a "+N" chip, as on /drugs.
 */
export function speciesCoverage(drug: Drug): { named: SpeciesId[]; extra: number } {
  const seen = new Set<SpeciesId>();
  for (const row of drug.doses) {
    if (row.doseLow === null && row.doseHigh === null) continue;
    seen.add(row.species);
  }
  if (seen.size === 0) {
    for (const row of drug.doses) seen.add(row.species);
  }
  const ordered = SPECIES.filter((s) => seen.has(s.id)).map((s) => s.id);
  return { named: ordered.slice(0, 3), extra: Math.max(0, ordered.length - 3) };
}
