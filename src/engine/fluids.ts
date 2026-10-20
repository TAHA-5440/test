import { DEHYDRATION_LADDER, SPECIES_MAP } from '../data/species';
import type { SpeciesId } from '../types';

/**
 * Fluid therapy arithmetic.
 *
 * Deficit (mL)      = weight (kg) × dehydration (%) × 10
 * Maintenance       = weight (kg) × maintenance rate (mL/kg/day)
 * Total             = deficit + maintenance + ongoing losses
 * Rate (mL/h)       = total ÷ hours
 * Drip rate (gtt/min) = mL/h × drop factor ÷ 60
 *
 * The plan is split into two phases because the deficit is replaced faster
 * than maintenance in practice.
 */

export interface FluidInput {
  species: SpeciesId;
  weightKg: number;
  dehydrationPct: number;
  maintenanceRate: number;
  ongoingLossesMl: number;
  hours: number;
  dropFactor: number;
  paediatric?: boolean;
}

export interface FluidPhase {
  label: string;
  hours: number;
  volumeMl: number;
  rateMlPerH: number;
  dropsPerMin: number;
}

export interface FluidResult {
  deficitMl: number;
  maintenancePerDayMl: number;
  maintenanceForPeriodMl: number;
  ongoingMl: number;
  totalMl: number;
  rateMlPerH: number;
  dropsPerMin: number;
  secondsPerDrop: number;
  phases: FluidPhase[];
  shockBolusMl: number | null;
  shockBolusNote: string | null;
  dehydrationNote: string;
  preferredFluids: string[];
  fluidNote: string;
  warnings: string[];
}

export function dehydrationEntry(pct: number) {
  let best = DEHYDRATION_LADDER[0];
  let bestDelta = Math.abs(best.percent - pct);
  for (const entry of DEHYDRATION_LADDER) {
    const delta = Math.abs(entry.percent - pct);
    if (delta < bestDelta) {
      best = entry;
      bestDelta = delta;
    }
  }
  return best;
}

export function calculateFluids(input: FluidInput): FluidResult {
  const { species, weightKg, dehydrationPct, maintenanceRate, ongoingLossesMl, hours, dropFactor } = input;

  const safeWeight = Math.max(0.01, weightKg);
  const safeHours = Math.max(1, hours);

  // Deficit (mL) = weight (kg) × dehydration (%) × 10
  const deficit = safeWeight * dehydrationPct * 10;

  const maintenancePerDay = safeWeight * maintenanceRate;
  // Scale maintenance to the chosen infusion window.
  const maintenanceForPeriod = (maintenancePerDay / 24) * safeHours;

  const total = deficit + maintenanceForPeriod + Math.max(0, ongoingLossesMl);
  const rate = total / safeHours;
  const dropsPerMin = (rate * dropFactor) / 60;
  const secondsPerDrop = dropsPerMin > 0 ? 60 / dropsPerMin : 0;

  // Phase 1: replace the deficit rapidly (up to 6 h, or a quarter of the window).
  const phase1Hours = Math.max(1, Math.min(6, safeHours / 4));
  const phase2Hours = Math.max(1, safeHours - phase1Hours);

  const phase1Volume = deficit;
  const phase2Volume = maintenanceForPeriod + Math.max(0, ongoingLossesMl);
  const phase1Rate = phase1Volume / phase1Hours;
  const phase2Rate = phase2Volume / phase2Hours;

  const phases: FluidPhase[] = [
    {
      label: 'Rapid replacement',
      hours: phase1Hours,
      volumeMl: phase1Volume,
      rateMlPerH: phase1Rate,
      dropsPerMin: (phase1Rate * dropFactor) / 60,
    },
    {
      label: 'Maintenance + ongoing losses',
      hours: phase2Hours,
      volumeMl: phase2Volume,
      rateMlPerH: phase2Rate,
      dropsPerMin: (phase2Rate * dropFactor) / 60,
    },
  ];

  const entry = dehydrationEntry(dehydrationPct);
  const meta = SPECIES_MAP[species];

  let shockBolusMl: number | null = null;
  let shockBolusNote: string | null = null;
  if (entry.shock) {
    shockBolusMl = safeWeight * 15;
    shockBolusNote =
      'At 10% dehydration or more, consider an initial shock bolus of 10–20 mL/kg over 15 minutes and reassess before starting the replacement phase.';
  }

  const warnings: string[] = [];
  if (entry.shock) {
    warnings.push('Hypovolaemic shock territory — reassess perfusion, and give the deficit faster than this plan if the patient is deteriorating.');
  }
  if (species === 'cat') {
    warnings.push('Cats are prone to fluid overload: watch the respiratory rate, auscultate for a gallop rhythm, and use a lower shock bolus rate than in dogs.');
  }
  if (species === 'horse' && total > 40000) {
    warnings.push('Large-volume equine fluid therapy — monitor PCV, total protein and lactate, and consider hypertonic saline while the isotonic fluids are set up.');
  }
  if (input.paediatric && meta?.maintenanceRateYoung) {
    warnings.push(`A young ${meta.label.toLowerCase()} needs roughly ${meta.maintenanceRateYoung} mL/kg/day — the adult rate under-maintains a neonate.`);
  }
  if (rate > 90 && species === 'dog') {
    warnings.push('A rate above 90 mL/kg/h is unusual in a dog — recheck the dehydration estimate and the weight.');
  }

  return {
    deficitMl: deficit,
    maintenancePerDayMl: maintenancePerDay,
    maintenanceForPeriodMl: maintenanceForPeriod,
    ongoingMl: Math.max(0, ongoingLossesMl),
    totalMl: total,
    rateMlPerH: rate,
    dropsPerMin,
    secondsPerDrop,
    phases,
    shockBolusMl,
    shockBolusNote,
    dehydrationNote: entry.signs,
    preferredFluids: meta?.preferredFluids ?? [],
    fluidNote: meta?.fluidNote ?? '',
    warnings,
  };
}

/** Inverse: the drip rate to deliver a set volume over a set time. */
export function dropsForRate(mlPerH: number, dropFactor: number): number {
  return (mlPerH * dropFactor) / 60;
}

export function rateForDrops(dropsPerMin: number, dropFactor: number): number {
  return (dropsPerMin * 60) / dropFactor;
}
