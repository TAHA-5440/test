import { useEffect, useState } from 'react';
import { ArrowDownToLine, ArrowRight, BellOff, BookOpen, Bookmark, CheckCircle2, ChevronRight, CircleHelp, Cloud, Code2, Database, Download, ExternalLink, FileUp, HardDrive, HeartPulse, Info, LayoutGrid, Leaf, LoaderCircle, Menu, Moon, Pill, Search, Settings2, ShieldCheck, Sun, WifiOff, X } from 'lucide-react';
import { useRegisterSW } from 'virtual:pwa-register/react';
import type { Page } from './lib/types';
import { useWorkspace } from './Workspace';
import { CataloguePage } from './components/CataloguePage';
import { ImportDialog } from './components/ImportDialog';
import { Modal } from './components/Modal';
import { DataPage } from './components/DataPage';
import { AboutPage, FormatDialog, SettingsPage } from './components/InfoPages';

const pages: { id: Page; label: string; icon: typeof BookOpen; section: string }[] = [
  { id: 'library', label: 'Medicine library', icon: BookOpen, section: 'WORKSPACE' },
  { id: 'saved', label: 'Saved references', icon: Bookmark, section: 'WORKSPACE' },
  { id: 'data', label: 'Data & sync', icon: Database, section: 'WORKSPACE' },
  { id: 'settings', label: 'Preferences', icon: Settings2, section: 'PERSONALISE' },
  { id: 'about', label: 'About this edition', icon: CircleHelp, section: 'PERSONALISE' },
];
interface InstallEvent extends Event { prompt: () => Promise<void>; userChoice: Promise<{ outcome: string }> }
function initialPage(): Page { const id = window.location.hash.slice(1); return pages.some(p => p.id === id) ? id as Page : 'library'; }

export default function App() {
  const { records, favourites, source, loading, storageError, preferences, setPreferences, toasts, dismissToast } = useWorkspace();
  const [page, setPage] = useState<Page>(initialPage);
  const [importOpen, setImportOpen] = useState(false);
  const [formatOpen, setFormatOpen] = useState(false);
  const [mobileOpen, setMobileOpen] = useState(false);
  const [installOpen, setInstallOpen] = useState(false);
  const [installPrompt, setInstallPrompt] = useState<InstallEvent | null>(null);
  const [offline, setOffline] = useState(!navigator.onLine);
  const [pwaOfflineReady, setPwaOfflineReady] = useState(false);
  const sw = useRegisterSW({ onOfflineReady: () => setPwaOfflineReady(true) });
  useEffect(() => {
    const hash = () => { setPage(initialPage()); setMobileOpen(false); window.scrollTo({ top: 0 }); };
    const online = () => setOffline(!navigator.onLine);
    const install = (e: Event) => { e.preventDefault(); setInstallPrompt(e as InstallEvent); };
    window.addEventListener('hashchange', hash); window.addEventListener('online', online); window.addEventListener('offline', online); window.addEventListener('beforeinstallprompt', install);
    return () => { window.removeEventListener('hashchange', hash); window.removeEventListener('online', online); window.removeEventListener('offline', online); window.removeEventListener('beforeinstallprompt', install); };
  }, []);
  const navigate = (id: Page) => { window.location.hash = id; setPage(id); setMobileOpen(false); };
  async function install() {
    if (installPrompt) { await installPrompt.prompt(); await installPrompt.userChoice; setInstallPrompt(null); }
    else setInstallOpen(true);
  }
  const nav = <>
    <button className="brand" onClick={() => navigate('library')} aria-label="Vet Pharmapedia home"><span className="brand-mark"><Pill size={24} strokeWidth={1.8} /><i /></span><span><strong>Vet Pharmapedia</strong><small>PAKISTAN · WEB EDITION</small></span></button>
    <div className="sidebar-label">YOUR REFERENCE WORKSPACE</div>
    <nav aria-label="Main navigation">{pages.map((p, i) => <div key={p.id}>{(i === 0 || pages[i - 1].section !== p.section) && <span className="nav-section">{p.section}</span>}<button aria-label={p.label} aria-current={page === p.id ? 'page' : undefined} className={`nav-item ${page === p.id ? 'selected' : ''}`} onClick={() => navigate(p.id)}><p.icon size={18} strokeWidth={1.8} /><span>{p.label}</span>{p.id === 'saved' && favourites.length > 0 && <small>{favourites.length}</small>}{page === p.id && <i />}</button></div>)}</nav>
    <div className="sidebar-bottom"><div className="sidebar-help"><span><ShieldCheck size={19} /></span><h3>A workspace you control.</h3><p>Bring your catalogue.<br />Keep your data on your device.</p><button onClick={() => setFormatOpen(true)}>How data works <ArrowRight size={14} /></button></div><button className="install-sidebar" onClick={() => void install()}><span><Download size={17} /></span><div><strong>Take it with you</strong><small>Install the browser app</small></div><ChevronRight size={15} /></button><div className="sidebar-status"><span><i /> Browser edition 0.1</span><button aria-label={preferences.theme === 'light' ? 'Switch to dark theme' : 'Switch to light theme'} onClick={() => setPreferences({ theme: preferences.theme === 'light' ? 'dark' : 'light' })}>{preferences.theme === 'light' ? <Moon size={16} /> : <Sun size={16} />}</button></div></div>
  </>;
  return <div className="app-shell">
    <aside className="sidebar">{nav}</aside>
    <Modal open={mobileOpen} onClose={() => setMobileOpen(false)} title="Workspace navigation"><div className="mobile-navigation">{nav}</div></Modal>
    <div className="workspace-main">
      <header className="topbar"><div className="breadcrumbs"><button className="icon-button mobile-menu" onClick={() => setMobileOpen(true)} aria-label="Open navigation"><Menu size={22} /></button><LayoutGrid size={15} /><span>Workspace</span><ChevronRight size={13} /><strong>{pages.find(p => p.id === page)?.label}</strong></div><div className="topbar-right">{offline && <span className="offline-badge"><WifiOff size={13} /> Offline</span>}<span className="workspace-badge"><span /> Local workspace</span><button className="icon-button help-top" aria-label="Help and supported data formats" onClick={() => setFormatOpen(true)}><CircleHelp size={19} /></button><span className="avatar" title="Browser workspace — no account required">VP</span></div></header>
      <main className="main-content" id="main-content">
        {storageError && <div className="notice notice-error" role="alert"><Info size={18} /><p>{storageError}</p></div>}
        {offline && <div className="notice offline-notice"><WifiOff size={17} /><p>You’re offline. Imported catalogue browsing and favourites still work; cloud sync needs a connection.</p></div>}
        {page === 'library' || page === 'saved' ? <CataloguePage key={page} savedOnly={page === 'saved'} onImport={() => setImportOpen(true)} onConnect={() => navigate('data')} onHowItWorks={() => setFormatOpen(true)} /> : page === 'data' ? <DataPage onImport={() => setImportOpen(true)} onFormat={() => setFormatOpen(true)} /> : page === 'settings' ? <SettingsPage onData={() => navigate('data')} onExport={() => navigate('data')} onInstall={() => void install()} /> : <AboutPage onImport={() => setImportOpen(true)} onData={() => navigate('data')} />}
        <footer className="app-footer"><div className="footer-brand"><Leaf size={15} /><span>Made for a more accessible veterinary reference.</span></div><span>Browser client · Not a prescription or a recovered catalogue</span></footer>
      </main>
    </div>
    <ImportDialog open={importOpen} onClose={() => setImportOpen(false)} />
    <FormatDialog open={formatOpen} onClose={() => setFormatOpen(false)} onImport={() => setImportOpen(true)} />
    <Modal open={installOpen} onClose={() => setInstallOpen(false)} title="Keep the workspace close" description="Use your browser’s normal install or home-screen feature."><div className="dialog-body"><div className="install-illustration"><span className="brand-mark"><Pill size={29} /></span><Download size={22} /></div><p className="paragraph">In Chrome or Edge, open the browser menu and choose <strong>Install app</strong> when available. On iPhone/iPad, use Safari’s Share menu → <strong>Add to Home Screen</strong>.</p><p className="paragraph">Install support needs a secure origin and varies by browser. After the production app shell is cached, local catalogue browsing works offline. Firebase downloads do not.</p><div className="notice"><HardDrive size={17} /><p>Installing does not provide medicine records. Your data stays in this browser profile; keep a JSON export before clearing site data.</p></div></div><div className="dialog-actions"><button className="button" onClick={() => setInstallOpen(false)}>Got it <CheckCircle2 size={16} /></button></div></Modal>
    <div className="toast-stack" aria-live="polite" aria-atomic="false">{toasts.map(toast => <div className={`toast ${toast.tone}`} key={toast.id} role={toast.tone === 'error' ? 'alert' : 'status'}><span>{toast.tone === 'success' ? <CheckCircle2 size={19} /> : <Info size={19} />}</span><p>{toast.text}</p><button aria-label="Dismiss notification" onClick={() => dismissToast(toast.id)}><X size={15} /></button></div>)}</div>
    {sw.needRefresh[0] && <div className="update-banner"><span><Download size={17} /> A new app version is ready. Your saved catalogue will stay.</span><button onClick={() => void sw.updateServiceWorker(true)}>Refresh</button></div>}
    {loading && <div className="sr-status" role="status">Loading locally saved catalogue…</div>}
  </div>;
}
