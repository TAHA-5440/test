import { DISEASES } from '../data/diseases';
import { SIGN_MAP, signLabel } from '../data/signs';
import type { Disease, SpeciesId } from '../types';

/**
 * Differential ranking engine.
 *
 * Confidence = Σ weights of the matched key signs ÷ Σ weights of all the key
 * signs recorded for that condition. A pathognomonic sign (weight 5) therefore
 * moves the ranking far more than a non-specific one (weight 1).
 *
 * Conditions are ranked for one species at a time; a condition with no key
 * signs in common with the selected set is not returned.
 */

export interface MatchedSign {
  sign: string;
  label: string;
  weight: number;
}

export interface DifferentialCandidate {
  disease: Disease;
  /** 0–1: share of the condition's total key-sign weight that the patient shows. */
  confidence: number;
  matched: MatchedSign[];
  /** Signs that would raise the confidence if they were present. */
  missing: MatchedSign[];
  /** Signs selected that the condition can also produce, but does not score for. */
  compatible: string[];
}

export interface RankResult {
  candidates: DifferentialCandidate[];
  totalConsidered: number;
  speciesConsidered: number;
}

export function rankDifferentials(species: SpeciesId, selected: string[]): RankResult {
  const selectedSet = new Set(selected);
  const speciesDiseases = DISEASES.filter((d) => d.species.includes(species));

  const candidates: DifferentialCandidate[] = [];

  for (const disease of speciesDiseases) {
    const totalWeight = disease.keySigns.reduce((sum, s) => sum + s.weight, 0);
    if (totalWeight === 0) continue;

    const matched: MatchedSign[] = [];
    const missing: MatchedSign[] = [];

    for (const ks of disease.keySigns) {
      const label = signLabel(ks.sign);
      if (selectedSet.has(ks.sign)) matched.push({ sign: ks.sign, label, weight: ks.weight });
      else missing.push({ sign: ks.sign, label, weight: ks.weight });
    }

    if (matched.length === 0) continue;

    const compatible = disease.otherSigns.filter((s) => selectedSet.has(s)).map((s) => signLabel(s));

    const confidence = matched.reduce((sum, s) => sum + s.weight, 0) / totalWeight;

    candidates.push({
      disease,
      confidence,
      matched: matched.sort((a, b) => b.weight - a.weight),
      missing: missing.sort((a, b) => b.weight - a.weight),
      compatible,
    });
  }

  candidates.sort((a, b) => {
    if (b.confidence !== a.confidence) return b.confidence - a.confidence;
    return a.disease.name.localeCompare(b.disease.name);
  });

  return {
    candidates: candidates.slice(0, 12),
    totalConsidered: candidates.length,
    speciesConsidered: speciesDiseases.length,
  };
}

/** Signs that would best separate the leading candidates from each other. */
export function discriminatingSigns(candidates: DifferentialCandidate[], limit = 6): string[] {
  const counts = new Map<string, number>();
  for (const c of candidates.slice(0, 6)) {
    for (const m of c.missing) {
      counts.set(m.sign, (counts.get(m.sign) ?? 0) + m.weight);
    }
  }
  return [...counts.entries()]
    .sort((a, b) => b[1] - a[1])
    .slice(0, limit)
    .map(([sign]) => sign)
    .filter((s) => SIGN_MAP[s]);
}

export function confidenceBand(confidence: number): { label: string; tone: 'high' | 'medium' | 'low' } {
  if (confidence >= 0.7) return { label: 'High', tone: 'high' };
  if (confidence >= 0.4) return { label: 'Moderate', tone: 'medium' };
  return { label: 'Low', tone: 'low' };
}

/** Red flags that should be surfaced whatever the ranking says. */
export function redFlags(selected: string[]): string[] {
  const flags: string[] = [];
  const set = new Set(selected);
  if (set.has('oliguria-anuria') && set.has('vomiting')) {
    flags.push('Anuria with vomiting suggests a urinary obstruction or acute kidney injury — check potassium and an ECG before any fluid plan.');
  }
  if (set.has('haemorrhagic-diarrhoea') && set.has('lethargy')) {
    flags.push('Haemorrhagic diarrhoea with depression: isolate, check a faecal antigen test and start fluid support early.');
  }
  if (set.has('recumbency') && set.has('bradycardia')) {
    flags.push('Recumbency with bradycardia: check electrolytes and consider hypoadrenocorticism or hyperkalaemia before sedating.');
  }
  if (set.has('dyspnoea') && set.has('distended-abdomen') && !set.has('cough')) {
    flags.push('Dyspnoea with abdominal distension: consider gastric dilatation-volvulus and pleural or peritoneal effusion.');
  }
  if (set.has('vesicles-mouth') || set.has('vesicles-feet')) {
    flags.push('Vesicular lesions in a cloven-hoofed animal are notifiable until proven otherwise — contact the veterinary authority before sampling.');
  }
  if (set.has('sudden-death')) {
    flags.push('Sudden death in a group: this is a herd or flock investigation, and a post-mortem on a fresh carcase is the highest-value test.');
  }
  return flags;
}
