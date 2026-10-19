import type { FirebaseConnection, ImportResult } from './types';
import { normalizeCatalogue, MAX_RECORDS } from './catalogue';
import type { FirebaseApp } from 'firebase/app';
import type { DocumentData, QueryDocumentSnapshot, Query, QuerySnapshot } from 'firebase/firestore';

let active: FirebaseApp | null = null;
export function parseConnection(text: string, collection: string): FirebaseConnection {
  let value: Record<string, unknown>;
  try { value = JSON.parse(text); } catch { throw new Error('Paste valid Firebase web-client configuration JSON.'); }
  if (!value || typeof value !== 'object' || Array.isArray(value)) throw new Error('Use a Firebase web-client configuration object.');
  if ('private_key' in value || value.type === 'service_account' || 'client_email' in value) throw new Error('Do not supply service-account keys or admin credentials. Only public Firebase web-client configuration belongs here.');
  if (typeof value.projectId !== 'string' || !/^[a-z][a-z0-9-]{3,62}$/.test(value.projectId)) throw new Error('A valid projectId is required.');
  if (typeof value.apiKey !== 'string' || value.apiKey.length < 16 || /YOUR|REDACTED|\.\.\./i.test(value.apiKey)) throw new Error('Supply your own project’s public web-client apiKey, not a placeholder.');
  if (!/^[A-Za-z0-9_-]{1,120}$/.test(collection)) throw new Error('Use a single collection name, such as NewMedicinesData.');
  const authDomain = typeof value.authDomain === 'string' ? value.authDomain : undefined;
  if (authDomain && (!/^[A-Za-z0-9.-]+$/.test(authDomain) || /localhost|127\.0\.0\.1/.test(authDomain))) throw new Error('authDomain must be a valid hosted domain, not a local/emulator address.');
  return { apiKey: value.apiKey, projectId: value.projectId, ...(authDomain ? { authDomain } : {}), ...(typeof value.appId === 'string' ? { appId: value.appId } : {}), collection };
}
async function app(config: FirebaseConnection) {
  const { initializeApp, deleteApp } = await import('firebase/app');
  if (active && (active.options.projectId !== config.projectId || active.options.apiKey !== config.apiKey)) { await deleteApp(active); active = null; }
  return active ??= initializeApp({ apiKey: config.apiKey, projectId: config.projectId, authDomain: config.authDomain, appId: config.appId }, 'pharmapedia-authorised-source');
}
export async function googleSignIn(config: FirebaseConnection): Promise<string> {
  const { getAuth, GoogleAuthProvider, signInWithPopup } = await import('firebase/auth');
  const result = await signInWithPopup(getAuth(await app(config)), new GoogleAuthProvider());
  return result.user.email || result.user.displayName || 'Authorised account';
}
export async function cloudAccount(): Promise<string> {
  if (!active) return '';
  const { getAuth } = await import('firebase/auth');
  const user = getAuth(active).currentUser;
  return user?.email || user?.displayName || '';
}
export async function disconnectCloud() {
  if (!active) return;
  const { getAuth, signOut } = await import('firebase/auth');
  const { deleteApp } = await import('firebase/app');
  await signOut(getAuth(active)); await deleteApp(active); active = null;
}
export async function syncCloud(config: FirebaseConnection, signal: AbortSignal, progress: (count: number) => void): Promise<ImportResult> {
  const { getFirestore, collection, query, orderBy, documentId, limit, startAfter, getDocsFromServer } = await import('firebase/firestore');
  const db = getFirestore(await app(config));
  const target = collection(db, config.collection);
  const records: Record<string, unknown>[] = [];
  let cursor: QueryDocumentSnapshot<DocumentData> | undefined;
  for (;;) {
    if (signal.aborted) throw new Error('Sync cancelled. The existing catalogue was not changed.');
    const request: Query<DocumentData> = cursor ? query(target, orderBy(documentId()), startAfter(cursor), limit(500)) : query(target, orderBy(documentId()), limit(500));
    const page: QuerySnapshot<DocumentData> = await getDocsFromServer(request);
    if (signal.aborted) throw new Error('Sync cancelled. The existing catalogue was not changed.');
    records.push(...page.docs.map(doc => ({ ...doc.data(), docId: doc.id })));
    progress(records.length);
    if (records.length > MAX_RECORDS) throw new Error(`Sync exceeds the ${MAX_RECORDS.toLocaleString()}-record browser limit. No partial catalogue was applied; use a smaller authorised export.`);
    if (page.size < 500) break;
    cursor = page.docs.at(-1);
  }
  return normalizeCatalogue(records);
}
export function cloudError(error: unknown): string {
  const code = typeof error === 'object' && error && 'code' in error ? String(error.code) : '';
  if (/unauthorized-domain|operation-not-allowed/.test(code)) return 'Enable the chosen sign-in provider and this site’s authorised domain in your own Firebase project, or use a local export.';
  if (/permission-denied|unauthorized/.test(code)) return 'Your project denied this read. Use an authorised account and normal Firestore rules, or import an owner-provided export. This app does not bypass access controls.';
  if (/popup/.test(code)) return 'Sign-in did not complete. Allow the normal Google popup or use a local data export.';
  return error instanceof Error ? error.message : 'The source could not be reached. Your existing catalogue was not changed.';
}
