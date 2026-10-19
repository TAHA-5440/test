// @vitest-environment node
import { describe, expect, it, vi } from 'vitest';
vi.mock('sql.js/dist/sql-wasm.wasm?url', () => ({ default: process.cwd() + '/node_modules/sql.js/dist/sql-wasm.wasm' }));
import { exportSqlite, importSqlite, sqliteEngine } from './sqlite';
import { fixture } from '../test/fixtures';

describe('browser SQLite processing', () => {
  it('exports actual rows and imports them without changing clinical text or nested data', async () => {
    const original = fixture({ overview: 'Original source text, not a generated medical claim.', isBrandFavourite: true });
    const bytes = await exportSqlite([original]);
    expect(new TextDecoder().decode(bytes.slice(0, 16))).toBe('SQLite format 3\0');
    const result = await importSqlite(bytes.slice().buffer as ArrayBuffer);
    expect(result.records[0]).toEqual(original);
  });
  it('never creates a fake empty recovered database', async () => {
    await expect(exportSqlite([])).rejects.toThrow(/no medicine records/);
  });
  it('rejects unrelated database tables', async () => {
    const SQL = await sqliteEngine(); const db = new SQL.Database();
    db.run('CREATE TABLE image (name TEXT)');
    const data = db.export(); db.close();
    await expect(importSqlite(data.slice().buffer as ArrayBuffer)).rejects.toThrow(/No medicines_table/);
  });
  it('refuses to treat a schema-only file as a populated medicine database', async () => {
    const SQL = await sqliteEngine(); const db = new SQL.Database();
    db.run('CREATE TABLE medicines_table (docId TEXT)');
    const data = db.export(); db.close();
    await expect(importSqlite(data.slice().buffer as ArrayBuffer)).rejects.toThrow(/empty/);
  });
});
