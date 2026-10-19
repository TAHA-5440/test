import Papa from 'papaparse';
import type { Favourite, ImportResult, JsonMap, Medicine, ViewMode } from './types';
import { COLUMNS } from './types';

export const MAX_RECORDS = 100_000;
export const MAX_IMPORT_BYTES = 100 * 1024 * 1024;
const object = (value: unknown): value is JsonMap => Boolean(value) && typeof value === 'object' && !Array.isArray(value);
const known = new Set<string>(COLUMNS);

export function firestoreValue(value: unknown): unknown {
  if (!object(value)) return value;
  if ('nullValue' in value) return null;
  if ('stringValue' in value) return value.stringValue;
  if ('integerValue' in value) {
    const n = Number(value.integerValue);
    if (!Number.isSafeInteger(n)) throw new Error('A Firestore integer exceeds the safe integer range. Use a SQLite export instead.');
    return n;
  }
  if ('doubleValue' in value) return Number(value.doubleValue);
  if ('booleanValue' in value) return value.booleanValue;
  if ('timestampValue' in value) return Date.parse(String(value.timestampValue));
  if ('mapValue' in value) {
    const fields = object(value.mapValue) && object(value.mapValue.fields) ? value.mapValue.fields : {};
    return Object.fromEntries(Object.entries(fields).map(([key, v]) => [key, firestoreValue(v)]));
  }
  if ('arrayValue' in value) {
    const values = object(value.arrayValue) && Array.isArray(value.arrayValue.values) ? value.arrayValue.values : [];
    return values.map(firestoreValue);
  }
  return value;
}

function documentRecord(value: unknown): JsonMap {
  if (!object(value)) throw new Error('Every medicine must be a JSON object.');
  const doc = object(value.document) ? value.document : value;
  if (object(doc.fields) && typeof doc.name === 'string') {
    const result = Object.fromEntries(Object.entries(doc.fields).map(([key, v]) => [key, firestoreValue(v)]));
    const id = doc.name.split('/').at(-1);
    return { ...result, docId: id || result.docId };
  }
  return value;
}

function text(value: unknown, field: string): string {
  if (value === undefined || value === null) return '';
  if (typeof value !== 'string') throw new Error(`${field} must be text; values are not silently rewritten.`);
  return value;
}
function bool(value: unknown, field: string): boolean {
  if (value === undefined || value === null || value === '' || value === false || value === 0 || value === '0' || value === 'false') return false;
  if (value === true || value === 1 || value === '1' || value === 'true') return true;
  throw new Error(`${field} must be true/false or 1/0.`);
}
function map(value: unknown, field: string): JsonMap {
  if (value === undefined || value === null || value === '') return {};
  const parsed: unknown = typeof value === 'string' ? JSON.parse(value) : value;
  if (!object(parsed)) throw new Error(`${field} must be an object, or a JSON-encoded object.`);
  return parsed;
}

export function normalizeCatalogue(input: unknown): ImportResult {
  if (object(input) && ('private_key' in input || input.type === 'service_account')) {
    throw new Error('This is a service-account credential, not medicine data. Never import private keys.');
  }
  if (object(input) && object(input.NewMedicinesData)) input = input.NewMedicinesData;
  let rows: unknown[];
  if (Array.isArray(input)) rows = input;
  else if (object(input) && Array.isArray(input.medicines)) rows = input.medicines;
  else if (object(input) && Array.isArray(input.records)) rows = input.records;
  else if (object(input) && Array.isArray(input.documents)) rows = input.documents;
  else if (object(input) && Object.keys(input).length && Object.values(input).every(object)) {
    rows = Object.entries(input).map(([id, value]) => ({ ...(value as JsonMap), docId: id }));
  } else throw new Error('No medicine array found. Use an array, { medicines: [...] }, Firestore documents, or a document-ID keyed export.');
  if (!rows.length) throw new Error('This source contains no medicine records. A schema, blank template, or APK is not a catalogue.');
  if (rows.length > MAX_RECORDS) throw new Error(`The browser import limit is ${MAX_RECORDS.toLocaleString()} records.`);
  const seen = new Set<string>();
  let missingFields = 0;
  let unnamed = 0;
  let extras = 0;
  const records = rows.map((row, index): Medicine => {
    try {
      const r = documentRecord(row);
      if (typeof r.docId !== 'string' || !r.docId.trim()) throw new Error('docId is required; IDs are not generated.');
      if (seen.has(r.docId)) throw new Error(`Duplicate document ID: ${r.docId}. No records were imported.`);
      seen.add(r.docId);
      if (!('saltName' in r) && !('brandName' in r)) throw new Error('Expected saltName or brandName. This does not look like a medicine export.');
      const timeStamp = r.timeStamp === undefined || r.timeStamp === null || r.timeStamp === '' ? 0 : Number(r.timeStamp);
      if (!Number.isSafeInteger(timeStamp)) throw new Error('timeStamp must be a safe integer.');
      missingFields += COLUMNS.some(key => r[key] === undefined || r[key] === null) ? 1 : 0;
      const extra = Object.fromEntries(Object.entries(r).filter(([key]) => !known.has(key)));
      if (Object.keys(extra).length) extras++;
      const medicine: Medicine = {
        docId: r.docId, timeStamp,
        saltName: text(r.saltName, 'saltName'), brandName: text(r.brandName, 'brandName'),
        contraIndications: text(r.contraIndications, 'contraIndications'), overview: text(r.overview, 'overview'),
        indications: text(r.indications, 'indications'), companyName: text(r.companyName, 'companyName'),
        countryName: text(r.countryName, 'countryName'),
        isBrandFavourite: bool(r.isBrandFavourite, 'isBrandFavourite'), isSaltFavourite: bool(r.isSaltFavourite, 'isSaltFavourite'),
        block: r.block === undefined || r.block === null ? 'No' : text(r.block, 'block'),
        availableForms: map(r.availableForms, 'availableForms'), dosageDetail: map(r.dosageDetail, 'dosageDetail'),
        ...(Object.keys(extra).length ? { extra } : {}),
      };
      if (!medicine.saltName.trim() && !medicine.brandName.trim()) unnamed++;
      return medicine;
    } catch (error) {
      throw new Error(`Record ${index + 1}: ${error instanceof Error ? error.message : 'Invalid medicine data.'}`);
    }
  });
  const warnings: string[] = [];
  if (missingFields) warnings.push(`${missingFields.toLocaleString()} records have missing fields. Empty text/maps, false favourites, timestamp 0 and block “No” follow the recovered model defaults; no clinical text was supplied by this app.`);
  if (unnamed) warnings.push(`${unnamed.toLocaleString()} records have no supplied generic or brand name. They remain in the dataset as unnamed records.`);
  if (extras) warnings.push(`${extras.toLocaleString()} records contain additional source fields. They are preserved in JSON backups; CSV/SQLite use the 14 Android-model fields.`);
  return { records, warnings };
}

export async function parseImportFile(file: File): Promise<ImportResult> {
  if (file.size > MAX_IMPORT_BYTES) throw new Error('Choose a file smaller than 100 MiB.');
  if (/\.(apk|xapk|apkm|zip|wal|shm)$/i.test(file.name) || /-(wal|shm)$/i.test(file.name)) {
    throw new Error('Choose medicine JSON/CSV or a checkpointed SQLite medicines_DB, not an APK, ZIP, or WAL sidecar.');
  }
  const data = await file.arrayBuffer();
  const header = new TextDecoder().decode(new Uint8Array(data, 0, Math.min(data.byteLength, 16)));
  if (header === 'SQLite format 3\0') {
    const { importSqlite } = await import('./sqlite');
    return importSqlite(data);
  }
  const raw = new TextDecoder('utf-8', { fatal: true }).decode(data).replace(/^\uFEFF/, '');
  if (/\.(jsonl|ndjson)$/i.test(file.name)) {
    return normalizeCatalogue(raw.split(/\r?\n/).filter(line => line.trim()).map((line, i) => {
      try { return JSON.parse(line); } catch { throw new Error(`Invalid JSON on line ${i + 1}.`); }
    }));
  }
  if (raw.trim().startsWith('{') || raw.trim().startsWith('[')) {
    let input: unknown;
    try { input = JSON.parse(raw); } catch { throw new Error('This JSON is not valid. The existing catalogue was not changed.'); }
    return normalizeCatalogue(input);
  }
  const parsed = Papa.parse<JsonMap>(raw, { header: true, skipEmptyLines: 'greedy', transformHeader: h => h.trim() });
  if (parsed.errors.length) throw new Error(`CSV could not be read: ${parsed.errors[0].message}`);
  if (!parsed.meta.fields?.includes('docId')) throw new Error('The CSV needs a docId column and medicine fields. UI-string exports and SQL schemas contain no medicine records.');
  return normalizeCatalogue(parsed.data);
}

export function favouriteKey(kind: ViewMode, name: string): string { return `${kind}:${name.normalize('NFKC').toLocaleLowerCase()}`; }
export function favouritesFromRecords(records: Medicine[]): Favourite[] {
  const entries = new Map<string, Favourite>();
  for (const r of records) {
    for (const kind of ['generic', 'brand'] as const) {
      const name = kind === 'generic' ? r.saltName : r.brandName;
      if (name && (kind === 'generic' ? r.isSaltFavourite : r.isBrandFavourite)) {
        const key = favouriteKey(kind, name); entries.set(key, { key, kind, name });
      }
    }
  }
  return [...entries.values()];
}
export function withFavourites(records: Medicine[], favourites: Favourite[]): Medicine[] {
  const keys = new Set(favourites.map(f => f.key));
  return records.map(r => ({ ...r, isSaltFavourite: keys.has(favouriteKey('generic', r.saltName)), isBrandFavourite: keys.has(favouriteKey('brand', r.brandName)) }));
}
export function isBlocked(record: Medicine): boolean { return ['yes', 'true', '1', 'blocked'].includes(record.block.trim().toLowerCase()); }
export function formsOf(record: Medicine): string[] { return Object.keys(record.availableForms).filter(Boolean); }
export function displayName(record: Medicine, mode: ViewMode): string { const names = mode === 'generic' ? [record.saltName, record.brandName] : [record.brandName, record.saltName]; return names.find(name => name.trim()) || 'Unnamed record'; }
export function csvCell(value: unknown): string {
  const s = String(value ?? '');
  return /^[\t\r\n]/.test(s) || /^[ \t\r\n]*[=+\-@]/.test(s) ? `'${s}` : s;
}
export function catalogueCsv(records: Medicine[]): string {
  return '\uFEFF' + Papa.unparse({ fields: [...COLUMNS], data: records.map(r => COLUMNS.map(key => {
    const value = key === 'availableForms' || key === 'dosageDetail' ? JSON.stringify(r[key]) : typeof r[key] === 'boolean' ? Number(r[key]) : r[key];
    return typeof value === 'string' ? csvCell(value) : value;
  })) });
}
