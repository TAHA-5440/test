import type { ReferenceSource } from '../types';

/**
 * The reference library. Sixteen titles: the six the original site names on its
 * landing page, plus ten further standard texts that back the notes, disease
 * and toxicology corpora in this build.
 *
 * Every answer produced by the assistant, every dose row and every clinical
 * note carries at least one of these ids.
 */
export const REFERENCES: ReferenceSource[] = [
  { id: 'plumbs', title: "Plumb's Veterinary Drug Handbook", edition: '7th edition', area: 'Pharmacology', short: "Plumb's" },
  { id: 'papich', title: 'Papich Handbook of Veterinary Drugs', edition: '5th edition', area: 'Pharmacology', short: 'Papich 5e' },
  { id: 'ettinger', title: "Ettinger's Textbook of Veterinary Internal Medicine", edition: '8th edition', area: 'Internal medicine', short: "Ettinger's" },
  { id: 'merck', title: 'Merck Veterinary Manual', edition: '11th edition', area: 'General reference', short: 'Merck 11e' },
  { id: 'fossum', title: 'Fossum Small Animal Surgery', edition: '5th edition', area: 'Surgery', short: 'Fossum 5e' },
  { id: 'smith', title: "Smith's Large Animal Internal Medicine", edition: '4th edition', area: 'Large animal medicine', short: "Smith's" },
  { id: 'greene', title: "Greene's Infectious Diseases of the Dog and Cat", edition: '5th edition', area: 'Infectious disease', short: "Greene's" },
  { id: 'carpenter', title: 'Carpenter Exotic Animal Formulary', edition: '6th edition', area: 'Exotic species', short: 'Carpenter 6e' },
  { id: 'dibartola', title: 'Fluid, Electrolyte, and Acid-Base Disorders in Small Animal Practice', edition: '4th edition', area: 'Fluid therapy', short: 'DiBartola 4e' },
  { id: 'bsava', title: 'BSAVA Small Animal Formulary', edition: '9th edition', area: 'Pharmacology', short: 'BSAVA 9e' },
  { id: 'veterinary-anaesthesia', title: 'Veterinary Anaesthesia and Analgesia (Grimm et al.)', edition: '5th edition', area: 'Anaesthesia', short: 'Grimm 5e' },
  { id: 'kirk', title: "Kirk's Current Veterinary Therapy XV", edition: '15th edition', area: 'Therapeutics', short: 'Kirk XV' },
  { id: 'nelson-couto', title: 'Small Animal Internal Medicine (Nelson & Couto)', edition: '6th edition', area: 'Internal medicine', short: 'Nelson & Couto 6e' },
  { id: 'merck-large', title: 'Merck Veterinary Manual — Food Animal', edition: '11th edition', area: 'Production medicine', short: 'Merck FA 11e' },
  { id: 'who-awares', title: 'WHO AWaRe / OIE antimicrobial categorisation guidance', edition: 'Current guidance', area: 'Antimicrobial stewardship', short: 'WHO AWaRe' },
  { id: 'farad', title: 'FARAD Veterinary Drug Withdrawal & Residue Avoidance', edition: 'Current guidance', area: 'Withdrawal periods', short: 'FARAD' },
];

export const REFERENCE_MAP: Record<string, ReferenceSource> = REFERENCES.reduce(
  (acc, r) => {
    acc[r.id] = r;
    return acc;
  },
  {} as Record<string, ReferenceSource>,
);

export function referenceTitle(id: string): string {
  const ref = REFERENCE_MAP[id];
  if (!ref) return id;
  return `${ref.title} (${ref.edition})`;
}
