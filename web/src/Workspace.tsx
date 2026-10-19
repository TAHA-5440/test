import { createContext, useCallback, useContext, useEffect, useRef, useState } from 'react';
import type { ReactNode } from 'react';
import type { Favourite, ImportResult, Medicine, Preferences, SourceInfo, ViewMode, Workspace } from './lib/types';
import * as storage from './lib/storage';
import { catalogueCsv, favouriteKey, favouritesFromRecords, withFavourites } from './lib/catalogue';

interface Toast { id: number; text: string; tone: 'success' | 'error' | 'info' }
interface ContextValue extends Workspace {
  loading: boolean;
  storageError: string | null;
  preferences: Preferences;
  toasts: Toast[];
  notify: (text: string, tone?: Toast['tone']) => void;
  dismissToast: (id: number) => void;
  setPreferences: (values: Partial<Preferences>) => void;
  importRecords: (data: ImportResult, label: string, kind: SourceInfo['kind'], replace: boolean) => Promise<void>;
  toggleFavourite: (kind: ViewMode, name: string) => Promise<void>;
  exportCatalogue: (format: 'json' | 'csv' | 'sqlite') => Promise<void>;
  clearData: () => Promise<void>;
}
const Context = createContext<ContextValue | null>(null);
const empty: Workspace = { records: [], favourites: [], source: null };

export function downloadFile(name: string, data: BlobPart, type: string) {
  const url = URL.createObjectURL(new Blob([data], { type }));
  const link = document.createElement('a'); link.href = url; link.download = name;
  document.body.append(link); link.click(); link.remove();
  window.setTimeout(() => URL.revokeObjectURL(url), 10_000);
}
function initialPreferences(): Preferences {
  try {
    const p = JSON.parse(localStorage.getItem('vetpharma-preferences') || '{}');
    return { theme: p.theme === 'dark' ? 'dark' : 'light', density: p.density === 'compact' ? 'compact' : 'comfortable' };
  } catch { return { theme: 'light', density: 'comfortable' }; }
}
export function WorkspaceProvider({ children }: { children: ReactNode }) {
  const [workspace, setWorkspace] = useState<Workspace>(empty);
  const workspaceRef = useRef(workspace); workspaceRef.current = workspace;
  const [loading, setLoading] = useState(true);
  const [storageError, setStorageError] = useState<string | null>(null);
  const [preferences, updatePreferences] = useState<Preferences>(initialPreferences);
  const [toasts, setToasts] = useState<Toast[]>([]);
  const timers = useRef<ReturnType<typeof setTimeout>[]>([]);
  const dismissToast = useCallback((id: number) => setToasts(rows => rows.filter(row => row.id !== id)), []);
  const notify = useCallback((text: string, tone: Toast['tone'] = 'success') => {
    const id = Date.now() + Math.random();
    setToasts(rows => [...rows.slice(-2), { id, text, tone }]);
    timers.current.push(setTimeout(() => dismissToast(id), 6500));
  }, [dismissToast]);
  useEffect(() => {
    let current = true;
    storage.loadWorkspace().then(result => { if (current) setWorkspace(result); }).catch(() => {
      if (current) setStorageError('Local browser storage is unavailable. Allow site storage or use another browser profile before importing. Your source files have not changed.');
    }).finally(() => { if (current) setLoading(false); });
    return () => { current = false; timers.current.forEach(clearTimeout); };
  }, []);
  useEffect(() => {
    document.documentElement.dataset.theme = preferences.theme;
    document.documentElement.dataset.density = preferences.density;
    try { localStorage.setItem('vetpharma-preferences', JSON.stringify(preferences)); } catch { /* Appearance still works for this session. */ }
  }, [preferences]);
  const setPreferences = useCallback((values: Partial<Preferences>) => updatePreferences(p => ({ ...p, ...values })), []);
  const importRecords = useCallback(async (data: ImportResult, label: string, kind: SourceInfo['kind'], replace: boolean) => {
    const current = workspaceRef.current;
    const merged = new Map<string, Medicine>(replace ? [] : current.records.map(record => [record.docId, record]));
    data.records.forEach(record => merged.set(record.docId, record));
    const favourites = new Map<string, Favourite>(current.favourites.map(f => [f.key, f]));
    favouritesFromRecords(data.records).forEach(f => favourites.set(f.key, f));
    const records = [...merged.values()];
    const source: SourceInfo = { kind, label, importedAt: new Date().toISOString(), recordCount: records.length, warnings: data.warnings };
    await storage.saveCatalogue(data.records, source, [...favourites.values()], replace);
    const next = { records, favourites: [...favourites.values()], source };
    workspaceRef.current = next; setWorkspace(next);
    notify(`${data.records.length.toLocaleString()} records ${replace ? 'imported' : 'merged'}. Your catalogue is saved in this browser.`);
  }, [notify]);
  const toggleFavourite = useCallback(async (kind: ViewMode, name: string) => {
    if (!name.trim()) return;
    const key = favouriteKey(kind, name);
    const current = workspaceRef.current;
    const enabled = !current.favourites.some(f => f.key === key);
    const favourite: Favourite = { key, kind, name };
    try {
      await storage.setFavourite(favourite, enabled);
      const next = { ...workspaceRef.current, favourites: enabled ? [...workspaceRef.current.favourites.filter(f => f.key !== key), favourite] : workspaceRef.current.favourites.filter(f => f.key !== key) };
      workspaceRef.current = next; setWorkspace(next);
      notify(enabled ? 'Added to your saved references.' : 'Removed from saved references.');
    } catch { notify('Could not save this change. Check that browser storage is available.', 'error'); }
  }, [notify]);
  const exportCatalogue = useCallback(async (format: 'json' | 'csv' | 'sqlite') => {
    const current = workspaceRef.current;
    if (!current.records.length) throw new Error('Import a catalogue before exporting medicine records.');
    const records = withFavourites(current.records, current.favourites);
    const date = new Date().toISOString().slice(0, 10);
    if (format === 'json') {
      const medicines = records.map(({ extra, ...record }) => ({ ...extra, ...record }));
      downloadFile(`pharmapedia-catalogue-${date}.json`, JSON.stringify({ format: 'vet-pharmapedia-web/v1', exportedAt: new Date().toISOString(), source: current.source, medicineCount: records.length, medicines }, null, 2), 'application/json');
    } else if (format === 'csv') {
      downloadFile(`pharmapedia-catalogue-${date}.csv`, catalogueCsv(records), 'text/csv;charset=utf-8');
    } else {
      const { exportSqlite } = await import('./lib/sqlite');
      const bytes = await exportSqlite(records);
      downloadFile(`pharmapedia-catalogue-${date}.sqlite`, bytes.slice().buffer as ArrayBuffer, 'application/vnd.sqlite3');
    }
    notify(`${format.toUpperCase()} exported with ${records.length.toLocaleString()} records.`);
  }, [notify]);
  const clearData = useCallback(async () => {
    await storage.clearWorkspace(); workspaceRef.current = empty; setWorkspace(empty); notify('Local catalogue and favourites removed. Original files are unchanged.');
  }, [notify]);
  return <Context.Provider value={{ ...workspace, loading, storageError, preferences, toasts, notify, dismissToast, setPreferences, importRecords, toggleFavourite, exportCatalogue, clearData }}>{children}</Context.Provider>;
}
export function useWorkspace() {
  const context = useContext(Context);
  if (!context) throw new Error('WorkspaceProvider is required.');
  return context;
}
