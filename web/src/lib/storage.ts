import { openDB } from 'idb';
import type { DBSchema, IDBPDatabase } from 'idb';
import type { Favourite, Medicine, SourceInfo, Workspace } from './types';

interface PharmaDB extends DBSchema {
  medicines: { key: string; value: Medicine };
  favourites: { key: string; value: Favourite };
  meta: { key: string; value: SourceInfo };
}
const DB_NAME = 'vet-pharmapedia-web';
let connection: Promise<IDBPDatabase<PharmaDB>> | undefined;
function db() {
  connection ??= openDB<PharmaDB>(DB_NAME, 1, {
    upgrade(database) {
      database.createObjectStore('medicines', { keyPath: 'docId' });
      database.createObjectStore('favourites', { keyPath: 'key' });
      database.createObjectStore('meta');
    },
    blocking() { void connection?.then(database => database.close()); connection = undefined; },
  });
  return connection;
}
export async function loadWorkspace(): Promise<Workspace> {
  const database = await db();
  const tx = database.transaction(['medicines', 'favourites', 'meta'], 'readonly');
  const [records, favourites, source] = await Promise.all([
    tx.objectStore('medicines').getAll(), tx.objectStore('favourites').getAll(), tx.objectStore('meta').get('source'),
  ]);
  await tx.done;
  return { records, favourites, source: source ?? null };
}
export async function saveCatalogue(records: Medicine[], source: SourceInfo, favourites: Favourite[], replace: boolean): Promise<void> {
  const database = await db();
  const tx = database.transaction(['medicines', 'favourites', 'meta'], 'readwrite');
  const completion = tx.done;
  void completion.catch(() => {});
  const writes: Promise<unknown>[] = [];
  try {
    if (replace) await tx.objectStore('medicines').clear();
    for (const record of records) writes.push(tx.objectStore('medicines').put(record));
    for (const favourite of favourites) writes.push(tx.objectStore('favourites').put(favourite));
    await Promise.all(writes);
    await tx.objectStore('meta').put(source, 'source');
    await completion;
  } catch (error) {
    // A synchronous clone/quota error after clear() must not commit a partial
    // replacement. Abort the complete transaction and retain the prior copy.
    try { tx.abort(); } catch { /* It may already have auto-aborted. */ }
    await Promise.allSettled(writes);
    await completion.catch(() => {});
    throw error;
  }
}
export async function setFavourite(favourite: Favourite, enabled: boolean) {
  const database = await db();
  if (enabled) await database.put('favourites', favourite);
  else await database.delete('favourites', favourite.key);
}
export async function clearWorkspace() {
  const database = await db();
  const tx = database.transaction(['medicines', 'favourites', 'meta'], 'readwrite');
  await Promise.all([tx.objectStore('medicines').clear(), tx.objectStore('favourites').clear(), tx.objectStore('meta').clear()]);
  await tx.done;
}
