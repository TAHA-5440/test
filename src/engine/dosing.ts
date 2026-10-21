import type { DoseRow, DoseUnit, Drug, Product, SpeciesId } from '../types';
import { SPECIES_MAP } from '../data/species';

/**
 * Dose arithmetic.
 *
 * Total dose (mg) = body weight (kg) × dose (mg/kg)
 * Volume (mL)     = total dose (mg) ÷ concentration (mg/mL)
 * Tablets         = total dose (mg) ÷ mg per tablet
 *
 * Doses that are not weight-based (per animal, per quarter, IU/animal,
 * mg/L of drinking water) are reported exactly as the reference writes them
 * rather than being forced into a mg/kg calculation.
 */

export interface DoseAmount {
  product: Product;
  amount: number;
  unit: 'mL' | 'tablet' | 'bolus' | 'drop' | 'g';
  display: string;
}

export interface DoseResult {
  row: DoseRow;
  weightBased: boolean;
  /** Selected low dose in mg/kg (or the published value for non-weight-based units). */
  doseValue: number | null;
  doseHighValue: number | null;
  /** Total dose in mg for the whole animal. */
  totalMg: number | null;
  totalMgHigh: number | null;
  totalDisplay: string;
  doseDisplay: string;
  amounts: DoseAmount[];
  withdrawal: { text: string; level: 'none' | 'set' | 'unknown' | 'na' };
  extraLabel: boolean;
  proxiedFrom?: SpeciesId;
}

const WEIGHT_BASED_UNITS: DoseUnit[] = ['mg/kg', 'mcg/kg', 'g/kg', 'mL/kg', 'mg/m2'];

export function isWeightBased(unit: DoseUnit): boolean {
  return WEIGHT_BASED_UNITS.includes(unit);
}

/** Convert a published value in `unit` to a total mg dose for a given weight. */
function toTotalMg(value: number, unit: DoseUnit, weightKg: number): number | null {
  switch (unit) {
    case 'mg/kg':
      return value * weightKg;
    case 'mcg/kg':
      return (value / 1000) * weightKg;
    case 'g/kg':
      return value * 1000 * weightKg;
    case 'mL/kg':
      return null; // Volume-based: reported as written.
    case 'mg/m2':
      return null; // Surface-area dosing is out of scope for this calculator.
    default:
      return null;
  }
}

export function formatNumber(value: number, maxDecimals = 2): string {
  if (!Number.isFinite(value)) return '—';
  const abs = Math.abs(value);
  let decimals = maxDecimals;
  if (abs >= 100) decimals = 0;
  else if (abs >= 10) decimals = 1;
  else if (abs >= 1) decimals = 2;
  else if (abs >= 0.1) decimals = 3;
  else decimals = 4;

  const fixed = value.toFixed(decimals);
  // Strip trailing zeros ONLY after a decimal point. Stripping them from a whole
  // number turns 180 mg into 18 mg — a ten-fold dosing error — so integers and
  // any digits before the point are never touched.
  return fixed.includes('.') ? fixed.replace(/\.?0+$/, '') : fixed;
}

export function formatDoseRange(row: DoseRow): string {
  const { doseLow, doseHigh, unit } = row;
  if (doseLow === null && doseHigh === null) return 'See the reference note';
  if (doseHigh !== null && doseLow !== null && doseHigh !== doseLow) {
    return `${formatNumber(doseLow)}–${formatNumber(doseHigh)} ${unit}`;
  }
  return `${formatNumber(doseLow ?? doseHigh ?? 0)} ${unit}`;
}

export function withdrawalFor(row: DoseRow): DoseResult['withdrawal'] {
  if (row.withdrawalUnknown) {
    return { text: 'not established', level: 'unknown' };
  }
  const parts: string[] = [];
  if (row.withdrawalMeatDays !== undefined && row.withdrawalMeatDays !== null) {
    parts.push(row.withdrawalMeatDays === 0 ? 'no meat withdrawal' : `${row.withdrawalMeatDays}d slaughter`);
  }
  if (row.withdrawalMilkHours !== undefined && row.withdrawalMilkHours !== null) {
    parts.push(row.withdrawalMilkHours === 0 ? 'no milk discard' : `${row.withdrawalMilkHours}h milk`);
  }
  if (parts.length === 0) {
    return { text: 'No withdrawal period on file for this row', level: 'na' };
  }
  return { text: parts.join(' / '), level: parts.every((p) => p.startsWith('no ')) ? 'none' : 'set' };
}

function amountForProduct(product: Product, totalMg: number | null): DoseAmount | null {
  if (totalMg === null) return null;
  if (product.concentrationMgPerMl) {
    const ml = totalMg / product.concentrationMgPerMl;
    return { product, amount: ml, unit: 'mL', display: `${formatNumber(ml)} mL` };
  }
  if (product.mgPerUnit) {
    const count = totalMg / product.mgPerUnit;
    const unit = product.form === 'bolus' ? 'bolus' : 'tablet';
    return {
      product,
      amount: count,
      unit,
      display:
        count < 1
          ? `${formatNumber(count)} ${unit} (${formatNumber(count * 8)} eighths — use a practical fraction)`
          : `${formatNumber(count)} ${unit}${count === 1 ? '' : 's'}`,
    };
  }
  return null;
}

export function computeDose(
  drug: Drug,
  row: DoseRow,
  weightKg: number,
  preferred?: number,
): DoseResult {
  const weightBased = isWeightBased(row.unit);
  const value = row.doseLow ?? row.doseHigh;
  const high = row.doseHigh ?? null;

  const totalMg = value === null ? null : toTotalMg(value, row.unit, weightKg);
  const totalMgHigh = high === null ? null : toTotalMg(high, row.unit, weightKg);

  // For a range, default to the low end and let the caller pick the high end.
  const selectedMg = preferred === 1 && totalMgHigh !== null ? totalMgHigh : totalMg;

  const amounts = drug.products
    .map((p) => amountForProduct(p, selectedMg))
    .filter((a): a is DoseAmount => a !== null)
    .slice(0, 12);

  const totalDisplay = weightBased
    ? selectedMg === null
      ? '—'
      : `${formatNumber(selectedMg)} mg`
    : value === null
      ? 'See the reference note'
      : `${formatNumber(value)} ${row.unit.replace('/animal', ' per animal').replace('/quarter', ' per quarter').replace('/L', ' per litre')}`;

  return {
    row,
    weightBased,
    doseValue: value,
    doseHighValue: high,
    totalMg: selectedMg,
    totalMgHigh,
    totalDisplay,
    doseDisplay: formatDoseRange(row),
    amounts,
    withdrawal: withdrawalFor(row),
    extraLabel: Boolean(row.extraLabel),
  };
}

/**
 * Rows available for a species, including proxy dosing.
 * Buffalo falls back to cattle where no buffalo-specific row exists.
 */
export function rowsForSpecies(drug: Drug, species: SpeciesId): { row: DoseRow; proxiedFrom?: SpeciesId }[] {
  // Rows with no published rate in either field are records of a prohibition
  // rather than a dose, and are not returned as dosing options.
  const usable = (rows: typeof drug.doses) => rows.filter((d) => d.doseLow !== null || d.doseHigh !== null);

  const direct = usable(drug.doses.filter((d) => d.species === species));
  if (direct.length > 0) return direct.map((row) => ({ row }));

  const proxy = SPECIES_MAP[species]?.dosedAs;
  if (proxy) {
    const proxied = usable(drug.doses.filter((d) => d.species === proxy));
    if (proxied.length > 0) return proxied.map((row) => ({ row, proxiedFrom: proxy }));
  }
  return [];
}

export function foodAnimalWarning(species: SpeciesId): string | null {
  const meta = SPECIES_MAP[species];
  if (!meta?.isFoodAnimal) return null;
  return 'This is a food-producing species. Record the withdrawal date and follow the product label and national regulations.';
}

export function dailyDoseTotal(result: DoseResult, intervalsPerDay: number): number | null {
  if (result.totalMg === null) return null;
  return result.totalMg * intervalsPerDay;
}

/** Parse a frequency string such as "q12h" into doses per day. */
export function intervalsPerDay(frequency: string): number | null {
  const match = /q\s*(\d+)\s*h/i.exec(frequency);
  if (match) {
    const hours = Number(match[1]);
    if (!Number.isFinite(hours) || hours === 0) return null;
    return 24 / hours;
  }
  if (/q24h|sid|once daily/i.test(frequency)) return 1;
  if (/bid|twice daily/i.test(frequency)) return 2;
  if (/tid/i.test(frequency)) return 3;
  if (/qid/i.test(frequency)) return 4;
  return null;
}

export function courseTotal(result: DoseResult, days: number): number | null {
  const perDay = intervalsPerDay(result.row.frequency);
  const daily = dailyDoseTotal(result, perDay ?? 1);
  if (daily === null) return null;
  return daily * days;
}
