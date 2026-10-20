/**
 * Shared domain types for the veterinary toolkit.
 *
 * The shape of these types was derived by reverse-engineering the public
 * VetMasterJi surface (drug monographs, disease pages, tool pages). See
 * docs/rea/vetmasterji-reverse-engineering.md for the evidence ledger.
 */

export type SpeciesId =
  | 'dog'
  | 'cat'
  | 'cattle'
  | 'buffalo'
  | 'horse'
  | 'sheep'
  | 'goat'
  | 'pig'
  | 'poultry'
  | 'bird'
  | 'rabbit'
  | 'ferret'
  | 'guinea-pig'
  | 'reptile'
  | 'camel';

export type DrugClass =
  | 'Antibiotic'
  | 'Antiparasitic'
  | 'Anti-inflammatory'
  | 'Analgesic'
  | 'Sedative & anaesthetic'
  | 'Cardiovascular'
  | 'Gastrointestinal'
  | 'Antiemetic'
  | 'Antifungal'
  | 'Diuretic'
  | 'Hormone & emergency'
  | 'Antiseptic & other';

export type Route = 'PO' | 'IV' | 'IM' | 'SC' | 'SQ' | 'IO' | 'IP' | 'Topical' | 'Intramammary' | 'Intrauterine' | 'Inhalation' | 'Ophthalmic' | 'Otic' | 'CRI' | 'Local';

export type DoseUnit =
  | 'mg/kg'
  | 'mcg/kg'
  | 'g/kg'
  | 'mL/kg'
  | 'mg/animal'
  | 'g/animal'
  | 'mL/animal'
  | 'IU/kg'
  | 'IU/animal'
  | 'mg/quarter'
  | 'mg/L'
  | 'mg/m2'
  | 'drops';

export interface Product {
  name: string;
  form: 'solution' | 'suspension' | 'tablet' | 'bolus' | 'injection' | 'paste' | 'spot-on' | 'powder' | 'ointment';
  /** mg of active per mL for liquids. */
  concentrationMgPerMl?: number;
  /** mg of active per tablet/bolus. */
  mgPerUnit?: number;
  brand?: string;
  note?: string;
}

export interface DoseRow {
  species: SpeciesId;
  indication: string;
  /** Low end of the published range (mg/kg unless `unit` says otherwise). */
  doseLow: number | null;
  /** High end of the published range; null when a single value is published. */
  doseHigh: number | null;
  unit: DoseUnit;
  route: Route;
  frequency: string;
  duration?: string;
  /** Meat withdrawal in days (food animals). */
  withdrawalMeatDays?: number | null;
  /** Milk withdrawal in hours (food animals). */
  withdrawalMilkHours?: number | null;
  /** Set when the reference states no withdrawal is established. */
  withdrawalUnknown?: boolean;
  /** True when the dose is extra-label in this species. */
  extraLabel?: boolean;
  note?: string;
  /** Citation string, exactly as shown to the user. */
  source: string;
}

export interface Interaction {
  with: string;
  effect: string;
  severity: 'contraindicated' | 'major' | 'moderate' | 'minor';
  action: string;
}

export interface Drug {
  id: string;
  name: string;
  className: DrugClass;
  aliases: string[];
  summary: string;
  mechanism: string;
  doses: DoseRow[];
  products: Product[];
  contraindications: string[];
  speciesWarnings: { species: SpeciesId; text: string }[];
  adverseEffects: string[];
  interactions: Interaction[];
  pregnancyLactation: string;
  monitoring: string[];
  overdose: string;
  pearls: string[];
  storage?: string;
  /** Controlled / prescription-only flag for the safety banner. */
  prescriptionOnly?: boolean;
  /** Species with no published dose that are dosed by proxy (e.g. buffalo as cattle). */
  dosedAs?: { species: SpeciesId; as: SpeciesId }[];
  sources: string[];
  lastReviewed: string;
}

export interface SpeciesMeta {
  id: SpeciesId;
  label: string;
  labelPlural: string;
  group: 'small-animal' | 'large-animal' | 'exotic' | 'avian';
  isFoodAnimal: boolean;
  /** Adult maintenance fluid rate mL/kg/day (midpoint of the published range). */
  maintenanceRate: number;
  maintenanceRange: [number, number];
  /** Young/juvenile maintenance rate where published. */
  maintenanceRateYoung?: number;
  preferredFluids: string[];
  fluidNote: string;
  /** Dosed by proxy when no species-specific monograph row exists. */
  dosedAs?: SpeciesId;
  /** Reference body weights used to seed calculator inputs. */
  typicalWeightKg: number;
}

export interface ReferenceSource {
  id: string;
  title: string;
  edition: string;
  area: string;
  short: string;
}

export type SignId = string;

export interface Sign {
  id: SignId;
  label: string;
  system:
    | 'Systemic'
    | 'Gastrointestinal'
    | 'Respiratory'
    | 'Neurological'
    | 'Cardiovascular'
    | 'Dermatological'
    | 'Musculoskeletal'
    | 'Reproductive'
    | 'Urinary'
    | 'Ophthalmic'
    | 'Mammary'
    | 'Haematological';
}

export interface Disease {
  id: string;
  name: string;
  aka: string[];
  species: SpeciesId[];
  system: 'Gastrointestinal' | 'Respiratory' | 'Neurological' | 'Cardiovascular' | 'Dermatological' | 'Musculoskeletal' | 'Reproductive' | 'Urinary' | 'Infectious' | 'Metabolic' | 'Toxic' | 'Ophthalmic' | 'Mammary' | 'Haematological';
  /** Characteristic signs with their weight in the ranking engine (1 = minor, 5 = pathognomonic). */
  keySigns: { sign: SignId; weight: number }[];
  otherSigns: SignId[];
  summary: string;
  differentials: string[];
  diagnosis: string[];
  treatment: string;
  prognosis: string;
  prevention?: string;
  drugRefs?: string[];
  sources: string[];
  lastReviewed: string;
}

export interface RefRangeRow {
  param: string;
  low: number | null;
  high: number | null;
  unit: string;
  note?: string;
}

export interface RefRangeGroup {
  group: 'Vital signs' | 'Haematology' | 'Serum biochemistry';
  rows: RefRangeRow[];
}

export interface ToxicologyEntry {
  id: string;
  toxin: string;
  aliases: string[];
  species: SpeciesId[];
  source: string;
  mechanism: string;
  signs: string[];
  onset: string;
  antidote: string;
  management: string[];
  pearls: string[];
  sources: string[];
}

export interface VaccineRow {
  id: string;
  species: SpeciesId;
  vaccine: string;
  protects: string;
  primaryStart: string;
  boosters: string;
  revaccination: string;
  note?: string;
}

export interface ClinicalNote {
  id: string;
  title: string;
  category: 'Toxicology' | 'Reference ranges' | 'Deworming' | 'Breeding' | 'Fluid therapy' | 'Anaesthesia' | 'Dermatology' | 'Surgery' | 'Neonatology' | 'Nutrition' | 'Preventive medicine' | 'Diagnostics';
  species: SpeciesId[];
  summary: string;
  alerts: string[];
  sections: { heading: string; body: string[]; table?: { head: string[]; rows: string[][] } }[];
  sources: string[];
  lastReviewed: string;
}

export interface ChallengeQuestion {
  id: string;
  prompt: string;
  options: string[];
  answerIndex: number;
  explanation: string;
  topic: string;
  species: SpeciesId | 'all';
  source: string;
}

export interface CaseOption {
  label: string;
  correct?: boolean;
  feedback: string;
  /** Points awarded for this choice. */
  score: number;
}

export interface CaseStep {
  id: string;
  phase: 'History' | 'Examination' | 'Diagnostics' | 'Decision' | 'Treatment' | 'Outcome';
  prompt: string;
  detail: string;
  findings?: string[];
  options: CaseOption[];
}

export interface ClinicalCase {
  id: string;
  title: string;
  species: SpeciesId;
  system: string;
  difficulty: 'Foundation' | 'Intermediate' | 'Advanced';
  clinician: string;
  signalment: string;
  presenting: string;
  vitals: { label: string; value: string; flag?: 'normal' | 'high' | 'low' }[];
  steps: CaseStep[];
  takeaways: string[];
  sources: string[];
}

export interface ProcedureCard {
  id: string;
  title: string;
  system: string;
  species: SpeciesId[];
  level: 'Core' | 'Intermediate' | 'Advanced';
  duration: string;
  summary: string;
  equipment: string[];
  steps: string[];
  pitfalls: string[];
  sources: string[];
}

export interface PatientRecord {
  id: string;
  name: string;
  species: SpeciesId;
  breed: string;
  age: string;
  sex: 'Male' | 'Female' | 'Male neutered' | 'Female neutered';
  weightKg: number;
  owner: string;
  phone: string;
  createdAt: string;
  visits: Visit[];
  vaccinations: { id: string; vaccine: string; given: string; due: string }[];
  dewormings: { id: string; product: string; given: string; due: string }[];
}

export interface Visit {
  id: string;
  date: string;
  complaint: string;
  findings: string;
  diagnosis: string;
  treatment: string;
  notes: string;
  weightKg: number;
}
