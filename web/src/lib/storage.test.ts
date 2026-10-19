import { beforeEach, describe, expect, it } from 'vitest';
import { clearWorkspace, loadWorkspace, saveCatalogue, setFavourite } from './storage';
import { fixture } from '../test/fixtures';
import type { SourceInfo } from './types';
const source: SourceInfo = { kind: 'file', label: 'synthetic fixture', importedAt: '2026-01-01T00:00:00.000Z', recordCount: 1, warnings: [] };

beforeEach(async () => { await clearWorkspace(); });
describe('local IndexedDB workspace', () => {
  it('starts with no bundled or generated medicine data', async () => {
    expect(await loadWorkspace()).toEqual({ records: [], favourites: [], source: null });
  });
  it('persists actual rows and metadata', async () => {
    await saveCatalogue([fixture()], source, [], true);
    const saved = await loadWorkspace();
    expect(saved.records).toEqual([fixture()]); expect(saved.source).toEqual(source);
  });
  it('merges by ID and replaces only when requested', async () => {
    await saveCatalogue([fixture()], source, [], true);
    await saveCatalogue([fixture({ docId: 'fixture-2' })], { ...source, recordCount: 2 }, [], false);
    expect((await loadWorkspace()).records).toHaveLength(2);
    await saveCatalogue([fixture({ docId: 'fixture-3' })], source, [], true);
    expect((await loadWorkspace()).records.map(r => r.docId)).toEqual(['fixture-3']);
  });
  it('saves/removes a favourite independently and does not erase it on catalogue replacement', async () => {
    const f = { key: 'generic:fixture', kind: 'generic' as const, name: 'Fixture' };
    await setFavourite(f, true);
    await saveCatalogue([fixture()], source, [], true);
    expect((await loadWorkspace()).favourites).toEqual([f]);
    await setFavourite(f, false); expect((await loadWorkspace()).favourites).toEqual([]);
  });
  it('rolls back a replacement if a source value cannot be cloned', async () => {
    await saveCatalogue([fixture()], source, [], true);
    const invalid = fixture({ docId: 'invalid-fixture', extra: { notSerializable: () => undefined } });
    await expect(saveCatalogue([fixture({ docId: 'queued-before-error' }), invalid], source, [], true)).rejects.toThrow();
    expect((await loadWorkspace()).records).toEqual([fixture()]);
    expect((await loadWorkspace()).source).toEqual(source);
  });
  it('clears only the local workspace on explicit request', async () => {
    await saveCatalogue([fixture()], source, [], true); await clearWorkspace();
    expect(await loadWorkspace()).toEqual({ records: [], favourites: [], source: null });
  });
});
