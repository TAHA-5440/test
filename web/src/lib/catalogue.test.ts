import { describe, it, expect } from 'vitest';
import { catalogueCsv, csvCell, displayName, favouritesFromRecords, favouriteKey, firestoreValue, isBlocked, normalizeCatalogue, parseImportFile, withFavourites } from './catalogue';
import { fixture } from '../test/fixtures';

describe('real-record catalogue normalization', () => {
  it('preserves supplied clinical text, maps, Unicode and additional fields', () => {
    const input = { ...fixture({ overview: 'اصل متن — original source text.' }), sourceRevision: 'fixture-revision' };
    const copy = JSON.stringify(input);
    const parsed = normalizeCatalogue([input]);
    expect(parsed.records[0]).toEqual({ ...fixture({ overview: input.overview }), extra: { sourceRevision: 'fixture-revision' } });
    expect(JSON.stringify(input)).toBe(copy);
    expect(parsed.warnings.length).toBeGreaterThan(0); // Additional fields retained in JSON.
  });
  it.each([[], { medicines: [] }, { records: [] }, { documents: [] }])('refuses empty sources rather than inventing records', input => {
    expect(() => normalizeCatalogue(input)).toThrow(/no medicine records/i);
  });
  it('preserves an external field literally named extra without flattening it', () => {
    const original = { ...fixture(), extra: { originalNested: 'Keep its original structure' } };
    const record = normalizeCatalogue([original]).records[0];
    expect(record.extra).toEqual({ extra: original.extra });
    const { extra, ...fields } = record;
    expect({ ...extra, ...fields }).toEqual(original);
  });
  it('does not generate document IDs', () => {
    expect(() => normalizeCatalogue([{ saltName: 'Fixture ingredient' }])).toThrow(/docId is required/);
  });
  it('rejects duplicate IDs without silently replacing a record', () => {
    expect(() => normalizeCatalogue([fixture(), fixture({ brandName: 'Another fixture' })])).toThrow(/duplicate document ID/i);
  });
  it('rejects unrelated resource/configuration data', () => {
    expect(() => normalizeCatalogue([{ docId: 'not-medicine', resource_name: 'screen-title', value: 'Fixture' }])).toThrow(/does not look like a medicine export/);
    expect(() => normalizeCatalogue({ type: 'service_account', private_key: 'not-a-real-key' })).toThrow(/credential/);
  });
  it('documents model defaults instead of adding clinical content', () => {
    const parsed = normalizeCatalogue([{ docId: 'fixture-minimal', saltName: 'Fixture' }]);
    expect(parsed.records[0].overview).toBe('');
    expect(parsed.records[0].dosageDetail).toEqual({});
    expect(parsed.records[0].block).toBe('No');
    expect(parsed.warnings[0]).toContain('model defaults');
  });
  it('accepts native JSON-encoded map columns and 0/1 flags', () => {
    const parsed = normalizeCatalogue([{ ...fixture(), availableForms: '{"Fixture form":{"packing":"As supplied"}}', dosageDetail: '{}', isBrandFavourite: 1, isSaltFavourite: '0', timeStamp: '120' }]);
    expect(parsed.records[0].availableForms).toEqual({ 'Fixture form': { packing: 'As supplied' } });
    expect(parsed.records[0].isBrandFavourite).toBe(true);
    expect(parsed.records[0].timeStamp).toBe(120);
  });
  it('rejects unexpected field types rather than rewriting text', () => {
    expect(() => normalizeCatalogue([{ ...fixture(), saltName: 17 }])).toThrow(/must be text/);
    expect(() => normalizeCatalogue([{ ...fixture(), timeStamp: 'not-an-integer' }])).toThrow(/timeStamp/);
    expect(() => normalizeCatalogue([{ ...fixture(), availableForms: 'not-json' }])).toThrow();
  });
  it('supports keyed Firestore exports', () => {
    const { docId: _id, ...record } = fixture();
    expect(normalizeCatalogue({ 'original-document-id': record }).records[0].docId).toBe('original-document-id');
  });
  it('uses document-map keys as IDs and accepts the explicit medicine collection wrapper', () => {
    const input = { NewMedicinesData: { 'original-key': fixture({ docId: 'stale-field-id' }) } };
    expect(normalizeCatalogue(input).records[0].docId).toBe('original-key');
  });
  it('supports typed REST documents and uses the document path ID', () => {
    const input = { documents: [{ name: 'projects/fixture-project/databases/(default)/documents/NewMedicinesData/original-id', fields: {
      docId: { stringValue: 'stale-field-id' }, saltName: { stringValue: 'Fixture ingredient' }, timeStamp: { integerValue: '900' },
      isSaltFavourite: { booleanValue: true }, dosageDetail: { mapValue: { fields: { note: { stringValue: 'Fixture only' } } } },
    } }] };
    const record = normalizeCatalogue(input).records[0];
    expect(record.docId).toBe('original-id'); expect(record.timeStamp).toBe(900);
    expect(record.dosageDetail).toEqual({ note: 'Fixture only' }); expect(record.isSaltFavourite).toBe(true);
  });
  it('does not round unsafe Firestore integers', () => {
    expect(() => firestoreValue({ integerValue: '999999999999999999999999' })).toThrow(/safe integer/);
  });
});

describe('file import and safe exports', () => {
  it('imports actual JSON records from a file', async () => {
    const file = new File([JSON.stringify({ medicines: [fixture()] })], 'fixture.json', { type: 'application/json' });
    expect((await parseImportFile(file)).records).toHaveLength(1);
  });
  it('round trips a normal CSV including nested map content', async () => {
    const record = fixture({ overview: 'Line one, with a comma.\nLine two.' });
    const file = new File([catalogueCsv([record])], 'fixture.csv', { type: 'text/csv' });
    const parsed = await parseImportFile(file);
    expect(parsed.records[0]).toEqual(record);
  });
  it('rejects APKs and WAL sidecars with a clear explanation', async () => {
    await expect(parseImportFile(new File(['fixture'], 'app.xapk'))).rejects.toThrow(/not an APK/);
    await expect(parseImportFile(new File(['fixture'], 'medicines_DB-wal'))).rejects.toThrow(/WAL sidecar/);
  });
  it('rejects schema/UI string CSV and malformed JSON', async () => {
    await expect(parseImportFile(new File(['resource_name,value\nfixture,fixture'], 'strings.csv'))).rejects.toThrow(/docId column/);
    await expect(parseImportFile(new File(['{bad'], 'bad.json'))).rejects.toThrow(/JSON is not valid/);
  });
  it('escapes spreadsheet formulas but keeps ordinary strings', () => {
    expect(csvCell('=1+1')).toBe("'=1+1"); expect(csvCell('  @SUM(A1)')).toBe("'  @SUM(A1)");
    expect(csvCell('\ttext')).toBe("'\ttext"); expect(csvCell('Original text')).toBe('Original text');
  });
});

describe('favourites and source status', () => {
  it('keeps generic and brand favourites separate, without changing original rows', () => {
    const record = fixture({ isSaltFavourite: true });
    const favourites = favouritesFromRecords([record]);
    expect(favourites).toHaveLength(1); expect(favourites[0].kind).toBe('generic');
    expect(favouriteKey('generic', 'Fixture')).toBe(favouriteKey('generic', 'FIXTURE'));
    expect(withFavourites([record], [])[0].isSaltFavourite).toBe(false);
    expect(record.isSaltFavourite).toBe(true);
  });
  it('marks a source block without generating availability information', () => {
    expect(isBlocked(fixture({ block: 'Yes' }))).toBe(true); expect(isBlocked(fixture())).toBe(false);
    expect(displayName(fixture(), 'brand')).toBe('Fixture product A');
  });
});
