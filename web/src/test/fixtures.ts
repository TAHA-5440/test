import type { Medicine } from '../lib/types';

/** Synthetic software-test fixtures, never loaded into the user-facing app. */
export function fixture(overrides: Partial<Medicine> = {}): Medicine {
  return {
    docId: 'fixture-1', timeStamp: 100,
    saltName: 'Fixture ingredient A', brandName: 'Fixture product A',
    overview: 'Synthetic interface fixture, not clinical information.',
    indications: '', contraIndications: '', companyName: 'Fixture company A', countryName: '',
    isBrandFavourite: false, isSaltFavourite: false, block: 'No',
    availableForms: { 'Fixture form': { packing: 'Fixture package', price: 'Not a real price', weight: 'Not a real strength' } },
    dosageDetail: { 'Fixture species': { note: 'Synthetic test note. No clinical dose is supplied.' } },
    ...overrides,
  };
}
