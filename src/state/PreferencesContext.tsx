import { createContext, useCallback, useContext, useEffect, useMemo, useState } from 'react';
import type { ReactNode } from 'react';
import type { SpeciesId } from '../types';
import { isSpeciesId } from '../data/species';

export type Theme = 'light' | 'dark';
export type Language = 'en' | 'hi' | 'es';
export type Mode = 'student' | 'clinician';

export interface VetBand {
  id: string;
  label: string;
  icon: string;
  description: string;
  test: (s: StreakState) => boolean;
}

export interface StreakState {
  streak: number;
  challengesCompleted: number;
  casesCompleted: number;
  correct: number;
  points: number;
}

export const VET_BANDS: VetBand[] = [
  { id: 'bronze', label: 'Bronze', icon: '🥉', description: '3 correct answers', test: (s) => s.correct >= 3 },
  { id: 'silver', label: 'Silver', icon: '🥈', description: '10 correct answers', test: (s) => s.correct >= 10 },
  { id: 'gold', label: 'Gold', icon: '🥇', description: '25 correct answers', test: (s) => s.correct >= 25 },
  { id: 'platinum', label: 'Platinum', icon: '💎', description: '50 correct answers', test: (s) => s.correct >= 50 },
  { id: 'diamond', label: 'Diamond', icon: '🔷', description: '100 correct answers', test: (s) => s.correct >= 100 },
  { id: 'master', label: 'VetMaster', icon: '🏆', description: '200 correct answers', test: (s) => s.correct >= 200 },
];

interface PreferencesValue {
  theme: Theme;
  language: Language;
  mode: Mode;
  species: SpeciesId;
  weightKg: number;
  setTheme: (t: Theme) => void;
  setLanguage: (l: Language) => void;
  setMode: (m: Mode) => void;
  setSpecies: (s: SpeciesId) => void;
  setWeightKg: (w: number) => void;
  toggleTheme: () => void;

  streak: StreakState;
  recordChallenge: (correct: boolean) => void;
  recordCase: () => void;
  resetProgress: () => void;
  earnedBands: VetBand[];

  bookmarks: string[];
  toggleBookmark: (id: string) => void;
  isBookmarked: (id: string) => boolean;

  recent: string[];
  pushRecent: (id: string) => void;

  online: boolean;
}

const PreferencesContext = createContext<PreferencesValue | null>(null);
const STORE_KEY = 'vetmasterji:prefs:v1';
const PROGRESS_KEY = 'vetmasterji:progress:v1';

function read<T>(key: string, fallback: T): T {
  if (typeof window === 'undefined') return fallback;
  try {
    const raw = window.localStorage.getItem(key);
    if (!raw) return fallback;
    return { ...fallback, ...(JSON.parse(raw) as object) } as T;
  } catch {
    return fallback;
  }
}

function write(key: string, value: unknown): void {
  if (typeof window === 'undefined') return;
  try {
    window.localStorage.setItem(key, JSON.stringify(value));
  } catch {
    /* storage may be unavailable in private mode — the app still works, it just forgets */
  }
}

export function PreferencesProvider({ children }: { children: ReactNode }) {
  const stored = useMemo(() => read(STORE_KEY, { theme: 'light', language: 'en', mode: 'clinician', species: 'dog', weightKg: 18, bookmarks: [] as string[], recent: [] as string[] }), []);

  const [theme, setThemeState] = useState<Theme>(() => (stored.theme === 'dark' ? 'dark' : 'light'));
  const [language, setLanguageState] = useState<Language>(() => (['en', 'hi', 'es'] as const).includes(stored.language as Language) ? (stored.language as Language) : 'en');
  const [mode, setModeState] = useState<Mode>(() => (stored.mode === 'student' ? 'student' : 'clinician'));
  const [species, setSpeciesState] = useState<SpeciesId>(() => (isSpeciesId(stored.species) ? stored.species : 'dog'));
  const [weightKg, setWeightState] = useState<number>(() => (Number.isFinite(stored.weightKg) && stored.weightKg > 0 ? stored.weightKg : 18));
  const [bookmarks, setBookmarks] = useState<string[]>(() => stored.bookmarks ?? []);
  const [recent, setRecent] = useState<string[]>(() => stored.recent ?? []);
  const [online, setOnline] = useState<boolean>(() => (typeof navigator === 'undefined' ? true : navigator.onLine));

  const [streak, setStreak] = useState<StreakState>(() =>
    read(PROGRESS_KEY, { streak: 0, challengesCompleted: 0, casesCompleted: 0, correct: 0, points: 0 }),
  );

  useEffect(() => {
    write(STORE_KEY, { theme, language, mode, species, weightKg, bookmarks, recent });
  }, [theme, language, mode, species, weightKg, bookmarks, recent]);

  useEffect(() => {
    write(PROGRESS_KEY, streak);
  }, [streak]);

  useEffect(() => {
    document.documentElement.setAttribute('data-theme', theme);
    document.documentElement.setAttribute('lang', language);
  }, [theme, language]);

  useEffect(() => {
    const goOnline = () => setOnline(true);
    const goOffline = () => setOnline(false);
    window.addEventListener('online', goOnline);
    window.addEventListener('offline', goOffline);
    return () => {
      window.removeEventListener('online', goOnline);
      window.removeEventListener('offline', goOffline);
    };
  }, []);

  const setTheme = useCallback((t: Theme) => setThemeState(t), []);
  const setLanguage = useCallback((l: Language) => setLanguageState(l), []);
  const setMode = useCallback((m: Mode) => setModeState(m), []);
  const setSpecies = useCallback((s: SpeciesId) => setSpeciesState(s), []);
  const setWeightKg = useCallback((w: number) => setWeightState(w), []);
  const toggleTheme = useCallback(() => setThemeState((t) => (t === 'dark' ? 'light' : 'dark')), []);

  const recordChallenge = useCallback((correct: boolean) => {
    setStreak((s) => ({
      streak: correct ? s.streak + 1 : 0,
      challengesCompleted: s.challengesCompleted + 1,
      casesCompleted: s.casesCompleted,
      correct: s.correct + (correct ? 1 : 0),
      points: s.points + (correct ? 10 : 0) + (correct ? Math.min(s.streak, 10) : 0),
    }));
  }, []);

  const recordCase = useCallback(() => {
    setStreak((s) => ({ ...s, casesCompleted: s.casesCompleted + 1, points: s.points + 25 }));
  }, []);

  const resetProgress = useCallback(() => {
    setStreak({ streak: 0, challengesCompleted: 0, casesCompleted: 0, correct: 0, points: 0 });
  }, []);

  const earnedBands = useMemo(() => VET_BANDS.filter((b) => b.test(streak)), [streak]);

  const toggleBookmark = useCallback((id: string) => {
    setBookmarks((prev) => (prev.includes(id) ? prev.filter((b) => b !== id) : [id, ...prev].slice(0, 200)));
  }, []);

  const isBookmarked = useCallback((id: string) => bookmarks.includes(id), [bookmarks]);

  const pushRecent = useCallback((id: string) => {
    setRecent((prev) => [id, ...prev.filter((r) => r !== id)].slice(0, 24));
  }, []);

  const value: PreferencesValue = {
    theme,
    language,
    mode,
    species,
    weightKg,
    setTheme,
    setLanguage,
    setMode,
    setSpecies,
    setWeightKg,
    toggleTheme,
    streak,
    recordChallenge,
    recordCase,
    resetProgress,
    earnedBands,
    bookmarks,
    toggleBookmark,
    isBookmarked,
    recent,
    pushRecent,
    online,
  };

  return <PreferencesContext.Provider value={value}>{children}</PreferencesContext.Provider>;
}

export function usePreferences(): PreferencesValue {
  const ctx = useContext(PreferencesContext);
  if (!ctx) throw new Error('usePreferences must be used inside PreferencesProvider');
  return ctx;
}
