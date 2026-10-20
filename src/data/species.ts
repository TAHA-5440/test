import type { SpeciesMeta, SpeciesId } from '../types';

/**
 * Species model.
 *
 * Maintenance fluid rates and preferred fluids follow the published tables in
 * Merck Veterinary Manual (11th ed.) and DiBartola, *Fluid, Electrolyte, and
 * Acid-Base Disorders in Small Animal Practice* (4th ed.), as surfaced by the
 * fluid therapy tool on the reference site.
 */
export const SPECIES: SpeciesMeta[] = [
  {
    id: 'dog',
    label: 'Dog',
    labelPlural: 'Dogs',
    group: 'small-animal',
    isFoodAnimal: false,
    maintenanceRate: 60,
    maintenanceRange: [50, 70],
    maintenanceRateYoung: 100,
    preferredFluids: ["Lactated Ringer's solution", '0.9% NaCl', 'Plasma-Lyte 148'],
    fluidNote:
      'Adults commonly planned at 60 mL/kg/day. Replace the deficit over 6–24 h depending on severity and reassess hydration every 4–6 h.',
    typicalWeightKg: 18,
  },
  {
    id: 'cat',
    label: 'Cat',
    labelPlural: 'Cats',
    group: 'small-animal',
    isFoodAnimal: false,
    maintenanceRate: 57,
    maintenanceRange: [50, 65],
    maintenanceRateYoung: 90,
    preferredFluids: ["Lactated Ringer's solution", '0.9% NaCl', 'Plasma-Lyte 148'],
    fluidNote:
      'Cats are far more prone to fluid overload than dogs: watch the respiratory rate for tachypnoea, a gallop rhythm and pleural effusion, use a lower shock bolus rate, and always warm fluids.',
    typicalWeightKg: 4.5,
  },
  {
    id: 'cattle',
    label: 'Cattle',
    labelPlural: 'Cattle',
    group: 'large-animal',
    isFoodAnimal: true,
    maintenanceRate: 80,
    maintenanceRange: [60, 100],
    preferredFluids: ['Hypertonic saline 7.2% (4–5 mL/kg IV bolus)', "Lactated Ringer's solution", 'Isotonic NaCl'],
    fluidNote:
      'Hypertonic saline 4 mL/kg IV followed by oral or IV isotonic fluids is standard for adults. Calf scour fluids should contain glucose, sodium, potassium and an alkalinising agent (acetate or bicarbonate).',
    typicalWeightKg: 450,
  },
  {
    id: 'buffalo',
    label: 'Buffalo',
    labelPlural: 'Buffalo',
    group: 'large-animal',
    isFoodAnimal: true,
    maintenanceRate: 80,
    maintenanceRange: [60, 100],
    preferredFluids: ['Hypertonic saline 7.2%', "Lactated Ringer's solution", 'Isotonic NaCl'],
    fluidNote: 'No buffalo-specific fluid rates are published; buffalo are managed as cattle.',
    dosedAs: 'cattle',
    typicalWeightKg: 500,
  },
  {
    id: 'horse',
    label: 'Horse',
    labelPlural: 'Horses',
    group: 'large-animal',
    isFoodAnimal: false,
    maintenanceRate: 65,
    maintenanceRange: [50, 80],
    preferredFluids: ["Lactated Ringer's solution", 'Plasma-Lyte 148', '0.9% NaCl'],
    fluidNote:
      'An adult with colic or endotoxaemia can require 60–100+ L/day. Hypertonic saline 4 mL/kg IV buys time while isotonic fluids are set up. Monitor PCV, total protein and lactate.',
    typicalWeightKg: 500,
  },
  {
    id: 'sheep',
    label: 'Sheep',
    labelPlural: 'Sheep',
    group: 'large-animal',
    isFoodAnimal: true,
    maintenanceRate: 70,
    maintenanceRange: [60, 80],
    preferredFluids: ["Lactated Ringer's solution", 'Isotonic NaCl'],
    fluidNote:
      'Use the jugular for rapid IV access. Ewes with pregnancy toxaemia or hypocalcaemia also need dextrose and calcium supplementation.',
    typicalWeightKg: 60,
  },
  {
    id: 'goat',
    label: 'Goat',
    labelPlural: 'Goats',
    group: 'large-animal',
    isFoodAnimal: true,
    maintenanceRate: 70,
    maintenanceRange: [60, 80],
    preferredFluids: ["Lactated Ringer's solution", 'Isotonic NaCl', 'Oral electrolyte solution'],
    fluidNote:
      'Oral rehydration is first line for kid diarrhoea; go IV when there is systemic shock. Extra-label drug use is common — extend cattle withdrawal periods conservatively.',
    typicalWeightKg: 45,
  },
  {
    id: 'pig',
    label: 'Pig',
    labelPlural: 'Pigs',
    group: 'large-animal',
    isFoodAnimal: true,
    maintenanceRate: 65,
    maintenanceRange: [50, 80],
    preferredFluids: ["Lactated Ringer's solution", 'Isotonic NaCl', 'Oral electrolyte solution'],
    fluidNote:
      'IV access is usually the ear vein; piglet scour fluids are often given intraperitoneally when IV access is impossible.',
    typicalWeightKg: 90,
  },
  {
    id: 'poultry',
    label: 'Poultry',
    labelPlural: 'Poultry',
    group: 'avian',
    isFoodAnimal: true,
    maintenanceRate: 55,
    maintenanceRange: [50, 60],
    preferredFluids: ["Lactated Ringer's solution", '0.9% NaCl + 2.5% dextrose'],
    fluidNote: 'Warm all fluids. Oral electrolytes in drinking water are the practical flock-level route.',
    typicalWeightKg: 2,
  },
  {
    id: 'bird',
    label: 'Bird',
    labelPlural: 'Birds',
    group: 'avian',
    isFoodAnimal: false,
    maintenanceRate: 55,
    maintenanceRange: [50, 60],
    preferredFluids: ["Lactated Ringer's solution", '0.9% NaCl + 2.5% dextrose'],
    fluidNote:
      'SC into the inguinal or axillary fold is most common; use intraosseous (proximal tibiotarsus or distal ulna) for shock. Always warm fluids — birds are very susceptible to hypothermia.',
    typicalWeightKg: 0.35,
  },
  {
    id: 'rabbit',
    label: 'Rabbit',
    labelPlural: 'Rabbits',
    group: 'exotic',
    isFoodAnimal: false,
    maintenanceRate: 80,
    maintenanceRange: [70, 100],
    preferredFluids: ["Lactated Ringer's solution", '0.9% NaCl', '0.45% NaCl + 2.5% dextrose'],
    fluidNote: 'SC fluids over the shoulders are well tolerated; warm fluids and handle minimally to avoid stress.',
    typicalWeightKg: 2,
  },
  {
    id: 'ferret',
    label: 'Ferret',
    labelPlural: 'Ferrets',
    group: 'exotic',
    isFoodAnimal: false,
    maintenanceRate: 75,
    maintenanceRange: [60, 90],
    preferredFluids: ["Lactated Ringer's solution", '0.9% NaCl'],
    fluidNote: 'Small patients — use a micro-drip (60 drops/mL) set or a syringe pump and reassess frequently.',
    typicalWeightKg: 1.2,
  },
  {
    id: 'guinea-pig',
    label: 'Guinea pig',
    labelPlural: 'Guinea pigs',
    group: 'exotic',
    isFoodAnimal: false,
    maintenanceRate: 90,
    maintenanceRange: [80, 100],
    preferredFluids: ["Lactated Ringer's solution", '0.9% NaCl'],
    fluidNote: 'Gastrointestinal stasis makes hydration status critical; combine fluids with assisted feeding.',
    typicalWeightKg: 0.9,
  },
  {
    id: 'reptile',
    label: 'Reptile',
    labelPlural: 'Reptiles',
    group: 'exotic',
    isFoodAnimal: false,
    maintenanceRate: 25,
    maintenanceRange: [15, 30],
    preferredFluids: ["Lactated Ringer's solution (diluted 1:1 with water)", '0.9% NaCl'],
    fluidNote:
      'Reptiles are managed at 15–30 mL/kg/day and depend on the preferred optimal temperature zone for drug clearance — never dose a cold reptile.',
    typicalWeightKg: 1,
  },
  {
    id: 'camel',
    label: 'Camel',
    labelPlural: 'Camels',
    group: 'large-animal',
    isFoodAnimal: true,
    maintenanceRate: 60,
    maintenanceRange: [50, 70],
    preferredFluids: ["Lactated Ringer's solution", 'Isotonic NaCl'],
    fluidNote: 'Camels tolerate dehydration remarkably well; correct slowly and reassess renal values.',
    typicalWeightKg: 400,
  },
];

export const SPECIES_MAP: Record<SpeciesId, SpeciesMeta> = SPECIES.reduce(
  (acc, s) => {
    acc[s.id] = s;
    return acc;
  },
  {} as Record<SpeciesId, SpeciesMeta>,
);

export function speciesLabel(id: SpeciesId): string {
  return SPECIES_MAP[id]?.label ?? id;
}

export function foodAnimalSpecies(): SpeciesId[] {
  return SPECIES.filter((s) => s.isFoodAnimal).map((s) => s.id);
}

/** Dehydration ladder used by the fluid calculator and the exam-room estimator. */
export const DEHYDRATION_LADDER: { percent: number; label: string; signs: string; shock: boolean }[] = [
  { percent: 0, label: 'Euhydrated', signs: 'Normal skin turgor; moist mucous membranes.', shock: false },
  { percent: 5, label: 'Slight', signs: 'Mildly tacky mucous membranes; minimal skin tent.', shock: false },
  { percent: 7, label: 'Moderate', signs: 'Dry mucous membranes; skin tent 2–3 s; mildly sunken eyes; slight lethargy.', shock: false },
  { percent: 8, label: 'Moderate–severe', signs: 'Dry mucous membranes; skin tent 3–5 s; sunken eyes; tachycardia.', shock: false },
  {
    percent: 10,
    label: 'Severe',
    signs: 'Very dry mucous membranes; skin tent >5 s; sunken eyes; tachycardia; weak pulse.',
    shock: true,
  },
  {
    percent: 12,
    label: 'Hypovolaemic shock',
    signs: 'Cold extremities; CRT >3 s; altered mentation; collapsed veins; imminent collapse.',
    shock: true,
  },
];

export const GIVING_SETS = [15, 20, 60];

export function isSpeciesId(value: string): value is SpeciesId {
  return Object.prototype.hasOwnProperty.call(SPECIES_MAP, value);
}

/** Small emoji markers used only in the UI; the clinical data never depends on them. */
export const SPECIES_ICON: Record<SpeciesId, string> = {
  dog: '🐕',
  cat: '🐈',
  cattle: '🐄',
  buffalo: '🐃',
  horse: '🐎',
  sheep: '🐑',
  goat: '🐐',
  pig: '🐖',
  poultry: '🐔',
  bird: '🦜',
  rabbit: '🐇',
  ferret: '🦦',
  'guinea-pig': '🐹',
  reptile: '🦎',
  camel: '🐪',
};
