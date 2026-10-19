import initSqlJs from 'sql.js';
import type { SqlJsStatic } from 'sql.js';
import wasmUrl from 'sql.js/dist/sql-wasm.wasm?url';
import type { ImportResult, Medicine } from './types';
import { COLUMNS } from './types';
import { normalizeCatalogue } from './catalogue';

let engine: Promise<SqlJsStatic> | undefined;
export function sqliteEngine() { return engine ??= initSqlJs({ locateFile: () => wasmUrl }); }

export async function importSqlite(data: ArrayBuffer): Promise<ImportResult> {
  const SQL = await sqliteEngine();
  let database;
  try { database = new SQL.Database(new Uint8Array(data)); }
  catch { throw new Error('This file could not be opened as ordinary SQLite. Encrypted files need an authorised plaintext export first.'); }
  try {
    database.run('PRAGMA trusted_schema=OFF; PRAGMA query_only=ON;');
    const integrity = database.exec('PRAGMA integrity_check');
    if (integrity[0]?.values[0]?.[0] !== 'ok') throw new Error('SQLite integrity check failed. Do not import a damaged or inconsistent snapshot.');
    const table = database.exec("SELECT name FROM sqlite_schema WHERE type='table' AND name='medicines_table'");
    if (!table[0]?.values.length) throw new Error('No medicines_table was found. An image index or schema-only file is not a medicine database.');
    const result = database.exec('SELECT * FROM medicines_table');
    if (!result[0]?.values.length) throw new Error('The medicines_table is empty. No records have been imported.');
    const parsed = normalizeCatalogue(result[0].values.map(row => Object.fromEntries(result[0].columns.map((key, i) => [key, row[i]]))));
    const bytes = new Uint8Array(data);
    if (bytes[18] === 2 || bytes[19] === 2) parsed.warnings.push('This database uses WAL mode. Browser import reads the main file only; use a consistent, checkpointed backup/export so recent WAL-only changes are not missed. Originals are never changed.');
    return parsed;
  } finally { database.close(); }
}

/** Standalone filled SQLite export, not a claim of original Android cache restoration. */
export async function exportSqlite(records: Medicine[]): Promise<Uint8Array> {
  if (!records.length) throw new Error('There are no medicine records to export.');
  const SQL = await sqliteEngine();
  const db = new SQL.Database();
  try {
    db.run('CREATE TABLE medicines_table (docId TEXT NOT NULL PRIMARY KEY, timeStamp INTEGER NOT NULL, saltName TEXT NOT NULL, brandName TEXT NOT NULL, contraIndications TEXT NOT NULL, overview TEXT NOT NULL, indications TEXT NOT NULL, companyName TEXT NOT NULL, countryName TEXT NOT NULL, isBrandFavourite INTEGER NOT NULL, isSaltFavourite INTEGER NOT NULL, block TEXT NOT NULL, availableForms TEXT NOT NULL, dosageDetail TEXT NOT NULL)');
    db.run('BEGIN');
    const statement = db.prepare(`INSERT INTO medicines_table VALUES (${COLUMNS.map(() => '?').join(',')})`);
    try {
      for (const record of records) statement.run(COLUMNS.map(key => key === 'availableForms' || key === 'dosageDetail' ? JSON.stringify(record[key]) : typeof record[key] === 'boolean' ? Number(record[key]) : record[key]));
    } finally { statement.free(); }
    db.run('COMMIT');
    if (db.exec('PRAGMA integrity_check')[0]?.values[0]?.[0] !== 'ok') throw new Error('Export integrity check failed.');
    return db.export();
  } finally { db.close(); }
}
