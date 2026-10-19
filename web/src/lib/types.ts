export type JsonMap = Record<string, unknown>;

/** Mirrors the recovered Android Room model. No catalogue is bundled. */
export interface Medicine {
  docId: string;
  timeStamp: number;
  saltName: string;
  brandName: string;
  contraIndications: string;
  overview: string;
  indications: string;
  companyName: string;
  countryName: string;
  isBrandFavourite: boolean;
  isSaltFavourite: boolean;
  block: string;
  availableForms: JsonMap;
  dosageDetail: JsonMap;
  /** Preserve additional import fields for a lossless JSON backup. */
  extra?: JsonMap;
}

export const COLUMNS = [
  'docId', 'timeStamp', 'saltName', 'brandName', 'contraIndications', 'overview',
  'indications', 'companyName', 'countryName', 'isBrandFavourite', 'isSaltFavourite',
  'block', 'availableForms', 'dosageDetail',
] as const;
export type ViewMode = 'generic' | 'brand';
export type Page = 'library' | 'saved' | 'data' | 'settings' | 'about';
export interface Favourite { key: string; kind: ViewMode; name: string }
export interface SourceInfo {
  kind: 'file' | 'firebase';
  label: string;
  importedAt: string;
  recordCount: number;
  warnings: string[];
}
export interface Workspace {
  records: Medicine[];
  favourites: Favourite[];
  source: SourceInfo | null;
}
export interface ImportResult { records: Medicine[]; warnings: string[] }
export interface Preferences { theme: 'light' | 'dark'; density: 'comfortable' | 'compact' }
export interface FirebaseConnection {
  apiKey: string;
  projectId: string;
  authDomain?: string;
  appId?: string;
  collection: string;
}
