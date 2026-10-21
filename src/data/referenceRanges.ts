import type { RefRangeGroup, SpeciesId } from '../types';

/**
 * Reference ranges by species.
 *
 * These are adult reference intervals. Always prefer the performing
 * laboratory's own interval where it gives one — the note on the original
 * site's tool says exactly that, and it is the correct advice.
 */
export const REFERENCE_RANGES: Record<SpeciesId, RefRangeGroup[]> = {
  dog: [
    {
      group: 'Vital signs',
      rows: [
        { param: 'Temperature', low: 37.9, high: 39.9, unit: '°C' },
        { param: 'Heart rate', low: 70, high: 120, unit: 'bpm', note: 'Puppies and toy breeds up to 180' },
        { param: 'Respiratory rate', low: 18, high: 34, unit: '/min' },
        { param: 'CRT', low: 0, high: 2, unit: 's' },
      ],
    },
    {
      group: 'Haematology',
      rows: [
        { param: 'PCV', low: 37, high: 55, unit: '%' },
        { param: 'Haemoglobin', low: 12, high: 18, unit: 'g/dL' },
        { param: 'RBC', low: 5.5, high: 8.5, unit: '×10⁶/µL' },
        { param: 'TLC (WBC)', low: 6, high: 17, unit: '×10³/µL' },
        { param: 'Neutrophils', low: 3, high: 11.5, unit: '×10³/µL' },
        { param: 'Lymphocytes', low: 1, high: 4.8, unit: '×10³/µL' },
        { param: 'Platelets', low: 200, high: 500, unit: '×10³/µL' },
      ],
    },
    {
      group: 'Serum biochemistry',
      rows: [
        { param: 'BUN', low: 7, high: 27, unit: 'mg/dL' },
        { param: 'Creatinine', low: 0.5, high: 1.5, unit: 'mg/dL' },
        { param: 'ALT', low: 10, high: 100, unit: 'U/L' },
        { param: 'AST', low: 15, high: 66, unit: 'U/L' },
        { param: 'ALP', low: 20, high: 156, unit: 'U/L', note: 'Higher in growing pups and on steroid therapy' },
        { param: 'Total protein', low: 5.4, high: 7.5, unit: 'g/dL' },
        { param: 'Albumin', low: 2.5, high: 3.7, unit: 'g/dL' },
        { param: 'Glucose', low: 70, high: 120, unit: 'mg/dL' },
        { param: 'Calcium', low: 8.9, high: 11.4, unit: 'mg/dL' },
        { param: 'Phosphorus', low: 2.5, high: 6.2, unit: 'mg/dL' },
        { param: 'Total bilirubin', low: 0.1, high: 0.5, unit: 'mg/dL' },
      ],
    },
  ],
  cat: [
    {
      group: 'Vital signs',
      rows: [
        { param: 'Temperature', low: 38.1, high: 39.2, unit: '°C' },
        { param: 'Heart rate', low: 140, high: 220, unit: 'bpm' },
        { param: 'Respiratory rate', low: 20, high: 40, unit: '/min' },
        { param: 'CRT', low: 0, high: 2, unit: 's' },
      ],
    },
    {
      group: 'Haematology',
      rows: [
        { param: 'PCV', low: 30, high: 45, unit: '%' },
        { param: 'Haemoglobin', low: 8, high: 15, unit: 'g/dL' },
        { param: 'RBC', low: 5, high: 10, unit: '×10⁶/µL' },
        { param: 'TLC (WBC)', low: 5.5, high: 19.5, unit: '×10³/µL' },
        { param: 'Neutrophils', low: 2.5, high: 12.5, unit: '×10³/µL' },
        { param: 'Lymphocytes', low: 1.5, high: 7, unit: '×10³/µL' },
        { param: 'Platelets', low: 300, high: 800, unit: '×10³/µL' },
      ],
    },
    {
      group: 'Serum biochemistry',
      rows: [
        { param: 'BUN', low: 16, high: 36, unit: 'mg/dL' },
        { param: 'Creatinine', low: 0.8, high: 2.4, unit: 'mg/dL' },
        { param: 'ALT', low: 12, high: 130, unit: 'U/L' },
        { param: 'AST', low: 0, high: 48, unit: 'U/L' },
        { param: 'ALP', low: 14, high: 111, unit: 'U/L', note: 'Any rise is significant in cats' },
        { param: 'Total protein', low: 6, high: 7.9, unit: 'g/dL' },
        { param: 'Albumin', low: 2.1, high: 3.3, unit: 'g/dL' },
        { param: 'Glucose', low: 74, high: 159, unit: 'mg/dL', note: 'Stress hyperglycaemia is common' },
        { param: 'Calcium', low: 7.8, high: 11.3, unit: 'mg/dL' },
        { param: 'Phosphorus', low: 3.1, high: 7.5, unit: 'mg/dL' },
        { param: 'Total bilirubin', low: 0, high: 0.9, unit: 'mg/dL' },
      ],
    },
  ],
  cattle: [
    {
      group: 'Vital signs',
      rows: [
        { param: 'Temperature', low: 38, high: 39.3, unit: '°C' },
        { param: 'Heart rate', low: 48, high: 84, unit: 'bpm' },
        { param: 'Respiratory rate', low: 26, high: 50, unit: '/min' },
        { param: 'Rumen motility', low: 2, high: 4, unit: '/2 min' },
      ],
    },
    {
      group: 'Haematology',
      rows: [
        { param: 'PCV', low: 24, high: 46, unit: '%' },
        { param: 'Haemoglobin', low: 8, high: 15, unit: 'g/dL' },
        { param: 'RBC', low: 5, high: 10, unit: '×10⁶/µL' },
        { param: 'TLC (WBC)', low: 4, high: 12, unit: '×10³/µL' },
        { param: 'Neutrophils', low: 0.6, high: 4, unit: '×10³/µL' },
        { param: 'Lymphocytes', low: 2.5, high: 7.5, unit: '×10³/µL', note: 'Lymphocyte-dominant in ruminants' },
        { param: 'Platelets', low: 100, high: 800, unit: '×10³/µL' },
      ],
    },
    {
      group: 'Serum biochemistry',
      rows: [
        { param: 'BUN', low: 6, high: 27, unit: 'mg/dL' },
        { param: 'Creatinine', low: 1, high: 2, unit: 'mg/dL' },
        { param: 'AST', low: 78, high: 132, unit: 'U/L' },
        { param: 'GGT', low: 6, high: 17, unit: 'U/L' },
        { param: 'Total protein', low: 6.7, high: 7.5, unit: 'g/dL' },
        { param: 'Albumin', low: 3, high: 3.6, unit: 'g/dL' },
        { param: 'Glucose', low: 45, high: 75, unit: 'mg/dL' },
        { param: 'Calcium', low: 8.4, high: 11, unit: 'mg/dL', note: 'Below 7.5 in a fresh cow indicates milk fever risk' },
        { param: 'Phosphorus', low: 5.6, high: 6.5, unit: 'mg/dL' },
        { param: 'Magnesium', low: 1.8, high: 2.3, unit: 'mg/dL', note: 'Below 1.5 indicates grass tetany risk' },
      ],
    },
  ],
  buffalo: [
    {
      group: 'Vital signs',
      rows: [
        { param: 'Temperature', low: 38, high: 39.3, unit: '°C' },
        { param: 'Heart rate', low: 48, high: 84, unit: 'bpm' },
        { param: 'Respiratory rate', low: 20, high: 40, unit: '/min' },
        { param: 'Rumen motility', low: 2, high: 4, unit: '/2 min' },
      ],
    },
    {
      group: 'Serum biochemistry',
      rows: [
        { param: 'Total protein', low: 6.7, high: 7.8, unit: 'g/dL' },
        { param: 'Albumin', low: 3, high: 3.8, unit: 'g/dL' },
        { param: 'Glucose', low: 40, high: 75, unit: 'mg/dL' },
        { param: 'Calcium', low: 8.4, high: 11, unit: 'mg/dL' },
        { param: 'Magnesium', low: 1.8, high: 2.3, unit: 'mg/dL' },
      ],
    },
  ],
  goat: [
    {
      group: 'Vital signs',
      rows: [
        { param: 'Temperature', low: 38.5, high: 40, unit: '°C' },
        { param: 'Heart rate', low: 70, high: 110, unit: 'bpm' },
        { param: 'Respiratory rate', low: 15, high: 40, unit: '/min' },
        { param: 'Rumen motility', low: 2, high: 4, unit: '/2 min' },
      ],
    },
    {
      group: 'Haematology',
      rows: [
        { param: 'PCV', low: 22, high: 38, unit: '%' },
        { param: 'Haemoglobin', low: 8, high: 12, unit: 'g/dL' },
        { param: 'RBC', low: 8, high: 18, unit: '×10⁶/µL' },
        { param: 'TLC (WBC)', low: 4, high: 13, unit: '×10³/µL' },
        { param: 'Platelets', low: 300, high: 600, unit: '×10³/µL' },
      ],
    },
    {
      group: 'Serum biochemistry',
      rows: [
        { param: 'BUN', low: 10, high: 20, unit: 'mg/dL' },
        { param: 'Creatinine', low: 1, high: 1.8, unit: 'mg/dL' },
        { param: 'AST', low: 66, high: 230, unit: 'U/L' },
        { param: 'GGT', low: 20, high: 56, unit: 'U/L' },
        { param: 'Total protein', low: 6.4, high: 7, unit: 'g/dL' },
        { param: 'Albumin', low: 2.7, high: 3.9, unit: 'g/dL' },
        { param: 'Glucose', low: 50, high: 75, unit: 'mg/dL' },
        { param: 'Calcium', low: 8.9, high: 11.7, unit: 'mg/dL' },
      ],
    },
  ],
  sheep: [
    {
      group: 'Vital signs',
      rows: [
        { param: 'Temperature', low: 38.5, high: 39.9, unit: '°C' },
        { param: 'Heart rate', low: 70, high: 80, unit: 'bpm' },
        { param: 'Respiratory rate', low: 16, high: 34, unit: '/min' },
        { param: 'Rumen motility', low: 2, high: 4, unit: '/2 min' },
      ],
    },
    {
      group: 'Haematology',
      rows: [
        { param: 'PCV', low: 27, high: 45, unit: '%' },
        { param: 'Haemoglobin', low: 9, high: 15, unit: 'g/dL' },
        { param: 'RBC', low: 9, high: 15, unit: '×10⁶/µL' },
        { param: 'TLC (WBC)', low: 4, high: 12, unit: '×10³/µL' },
        { param: 'Platelets', low: 250, high: 750, unit: '×10³/µL' },
      ],
    },
    {
      group: 'Serum biochemistry',
      rows: [
        { param: 'BUN', low: 8, high: 20, unit: 'mg/dL' },
        { param: 'Creatinine', low: 1.2, high: 1.9, unit: 'mg/dL' },
        { param: 'AST', low: 60, high: 280, unit: 'U/L' },
        { param: 'GGT', low: 20, high: 52, unit: 'U/L' },
        { param: 'Total protein', low: 6, high: 7.9, unit: 'g/dL' },
        { param: 'Albumin', low: 2.4, high: 3, unit: 'g/dL' },
        { param: 'Glucose', low: 50, high: 80, unit: 'mg/dL' },
        { param: 'Calcium', low: 11.5, high: 12.8, unit: 'mg/dL', note: 'Hypocalcaemia is common in late-gestation ewes' },
      ],
    },
  ],
  horse: [
    {
      group: 'Vital signs',
      rows: [
        { param: 'Temperature', low: 37.2, high: 38.3, unit: '°C' },
        { param: 'Heart rate', low: 28, high: 44, unit: 'bpm' },
        { param: 'Respiratory rate', low: 8, high: 16, unit: '/min' },
        { param: 'CRT', low: 0, high: 2, unit: 's' },
      ],
    },
    {
      group: 'Haematology',
      rows: [
        { param: 'PCV', low: 32, high: 53, unit: '%' },
        { param: 'Haemoglobin', low: 11, high: 19, unit: 'g/dL' },
        { param: 'RBC', low: 6.8, high: 12.9, unit: '×10⁶/µL' },
        { param: 'TLC (WBC)', low: 5.4, high: 14.3, unit: '×10³/µL' },
        { param: 'Platelets', low: 100, high: 350, unit: '×10³/µL' },
      ],
    },
    {
      group: 'Serum biochemistry',
      rows: [
        { param: 'BUN', low: 10, high: 24, unit: 'mg/dL' },
        { param: 'Creatinine', low: 1.2, high: 1.9, unit: 'mg/dL' },
        { param: 'AST', low: 226, high: 366, unit: 'U/L' },
        { param: 'GGT', low: 12, high: 45, unit: 'U/L' },
        { param: 'Total protein', low: 5.2, high: 7.9, unit: 'g/dL' },
        { param: 'Albumin', low: 2.6, high: 3.7, unit: 'g/dL' },
        { param: 'Glucose', low: 75, high: 115, unit: 'mg/dL' },
        { param: 'Calcium', low: 11.2, high: 13.6, unit: 'mg/dL' },
      ],
    },
  ],
  pig: [
    {
      group: 'Vital signs',
      rows: [
        { param: 'Temperature', low: 38.7, high: 39.8, unit: '°C' },
        { param: 'Heart rate', low: 70, high: 120, unit: 'bpm' },
        { param: 'Respiratory rate', low: 32, high: 58, unit: '/min' },
      ],
    },
    {
      group: 'Haematology',
      rows: [
        { param: 'PCV', low: 32, high: 50, unit: '%' },
        { param: 'Haemoglobin', low: 10, high: 16, unit: 'g/dL' },
        { param: 'RBC', low: 5, high: 8, unit: '×10⁶/µL' },
        { param: 'TLC (WBC)', low: 11, high: 22, unit: '×10³/µL' },
        { param: 'Platelets', low: 220, high: 620, unit: '×10³/µL' },
      ],
    },
    {
      group: 'Serum biochemistry',
      rows: [
        { param: 'BUN', low: 10, high: 30, unit: 'mg/dL' },
        { param: 'Creatinine', low: 1, high: 2.7, unit: 'mg/dL' },
        { param: 'AST', low: 32, high: 84, unit: 'U/L' },
        { param: 'Total protein', low: 7, high: 8.9, unit: 'g/dL' },
        { param: 'Albumin', low: 1.9, high: 3.3, unit: 'g/dL' },
        { param: 'Glucose', low: 85, high: 150, unit: 'mg/dL' },
      ],
    },
  ],
  poultry: [
    {
      group: 'Vital signs',
      rows: [
        { param: 'Temperature', low: 40.6, high: 41.7, unit: '°C' },
        { param: 'Heart rate', low: 250, high: 300, unit: 'bpm' },
        { param: 'Respiratory rate', low: 15, high: 30, unit: '/min' },
      ],
    },
    {
      group: 'Haematology',
      rows: [
        { param: 'PCV', low: 28, high: 40, unit: '%' },
        { param: 'TLC (WBC)', low: 15, high: 30, unit: '×10³/µL' },
      ],
    },
  ],
  bird: [
    {
      group: 'Vital signs',
      rows: [
        { param: 'Temperature', low: 40, high: 42, unit: '°C', note: 'Higher in small passerines' },
        { param: 'Heart rate', low: 200, high: 600, unit: 'bpm', note: 'Inversely related to body size' },
        { param: 'Respiratory rate', low: 20, high: 60, unit: '/min' },
      ],
    },
    {
      group: 'Haematology',
      rows: [
        { param: 'PCV', low: 35, high: 55, unit: '%' },
        { param: 'TLC (WBC)', low: 5, high: 18, unit: '×10³/µL' },
      ],
    },
  ],
  rabbit: [
    {
      group: 'Vital signs',
      rows: [
        { param: 'Temperature', low: 38.5, high: 40, unit: '°C' },
        { param: 'Heart rate', low: 180, high: 250, unit: 'bpm' },
        { param: 'Respiratory rate', low: 32, high: 60, unit: '/min' },
      ],
    },
    {
      group: 'Haematology',
      rows: [
        { param: 'PCV', low: 33, high: 50, unit: '%' },
        { param: 'TLC (WBC)', low: 5, high: 12, unit: '×10³/µL' },
      ],
    },
    {
      group: 'Serum biochemistry',
      rows: [
        { param: 'BUN', low: 15, high: 50, unit: 'mg/dL' },
        { param: 'Creatinine', low: 0.5, high: 2.6, unit: 'mg/dL' },
        { param: 'Glucose', low: 75, high: 155, unit: 'mg/dL' },
        { param: 'Calcium', low: 5.5, high: 12.5, unit: 'mg/dL', note: 'Rabbits regulate calcium by absorption, not by PTH' },
      ],
    },
  ],
  ferret: [
    {
      group: 'Vital signs',
      rows: [
        { param: 'Temperature', low: 37.8, high: 40, unit: '°C' },
        { param: 'Heart rate', low: 200, high: 250, unit: 'bpm' },
        { param: 'Respiratory rate', low: 33, high: 36, unit: '/min' },
      ],
    },
    {
      group: 'Haematology',
      rows: [
        { param: 'PCV', low: 44, high: 64, unit: '%' },
        { param: 'TLC (WBC)', low: 3, high: 15, unit: '×10³/µL' },
      ],
    },
    {
      group: 'Serum biochemistry',
      rows: [
        { param: 'BUN', low: 12, high: 43, unit: 'mg/dL' },
        { param: 'Creatinine', low: 0.2, high: 0.6, unit: 'mg/dL' },
        { param: 'Glucose', low: 90, high: 125, unit: 'mg/dL', note: 'Below 70 with clinical signs suggests insulinoma' },
      ],
    },
  ],
  'guinea-pig': [
    {
      group: 'Vital signs',
      rows: [
        { param: 'Temperature', low: 37.2, high: 39.5, unit: '°C' },
        { param: 'Heart rate', low: 230, high: 380, unit: 'bpm' },
        { param: 'Respiratory rate', low: 42, high: 104, unit: '/min' },
      ],
    },
    {
      group: 'Haematology',
      rows: [
        { param: 'PCV', low: 35, high: 50, unit: '%' },
        { param: 'TLC (WBC)', low: 4, high: 13, unit: '×10³/µL' },
      ],
    },
  ],
  reptile: [
    {
      group: 'Vital signs',
      rows: [
        { param: 'Preferred optimal temperature zone', low: 24, high: 38, unit: '°C', note: 'Species-specific — a temperature, not a range to average' },
        { param: 'Heart rate', low: 20, high: 80, unit: 'bpm', note: 'Depends on temperature and species' },
      ],
    },
    {
      group: 'Haematology',
      rows: [
        { param: 'PCV', low: 20, high: 35, unit: '%' },
      ],
    },
  ],
  camel: [
    {
      group: 'Vital signs',
      rows: [
        { param: 'Temperature', low: 34.5, high: 40.7, unit: '°C', note: 'Camels have a wide diurnal range' },
        { param: 'Heart rate', low: 28, high: 48, unit: 'bpm' },
        { param: 'Respiratory rate', low: 5, high: 16, unit: '/min' },
      ],
    },
    {
      group: 'Serum biochemistry',
      rows: [
        { param: 'Total protein', low: 6, high: 7.9, unit: 'g/dL' },
        { param: 'Glucose', low: 90, high: 140, unit: 'mg/dL', note: 'Camels run higher than true ruminants' },
        { param: 'Calcium', low: 7.4, high: 11.4, unit: 'mg/dL' },
      ],
    },
  ],
};

export type RangeVerdict = 'below' | 'within' | 'above';

export function checkValue(row: { low: number | null; high: number | null }, value: number): RangeVerdict {
  if (row.low !== null && value < row.low) return 'below';
  if (row.high !== null && value > row.high) return 'above';
  return 'within';
}

export function allRowsFor(species: SpeciesId): { group: string; param: string; low: number | null; high: number | null; unit: string; note?: string }[] {
  return (REFERENCE_RANGES[species] ?? []).flatMap((g) =>
    g.rows.map((r) => ({ group: g.group, ...r })),
  );
}

export const RANGE_SPECIES: SpeciesId[] = Object.keys(REFERENCE_RANGES) as SpeciesId[];
