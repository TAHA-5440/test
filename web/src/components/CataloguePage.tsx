import { useDeferredValue, useEffect, useMemo, useRef, useState } from 'react';
import { ArrowDownAZ, ArrowRight, ArrowUpDown, BookOpen, Bookmark, Building2, ChevronDown, ChevronLeft, ChevronRight, Cloud, Database, FileUp, FlaskConical, FolderOpen, Layers3, ListFilter, Pill, Search, ShieldCheck, Sparkles, Star, Tag, X } from 'lucide-react';
import type { Medicine, ViewMode } from '../lib/types';
import { displayName, favouriteKey, formsOf, isBlocked } from '../lib/catalogue';
import { useWorkspace } from '../Workspace';
import { RecordDrawer } from './RecordDrawer';

interface Group { key: string; name: string; records: Medicine[] }
export function CataloguePage({ savedOnly, onImport, onConnect, onHowItWorks }: { savedOnly: boolean; onImport: () => void; onConnect: () => void; onHowItWorks: () => void }) {
  const { records, favourites, source, preferences, toggleFavourite, loading } = useWorkspace();
  const [mode, setMode] = useState<ViewMode>('generic');
  const [search, setSearch] = useState('');
  const deferred = useDeferredValue(search);
  const [company, setCompany] = useState('');
  const [form, setForm] = useState('');
  const [status, setStatus] = useState('');
  const [sort, setSort] = useState('asc');
  const [page, setPage] = useState(1);
  const [size, setSize] = useState(10);
  const [selection, setSelection] = useState<Medicine[]>([]);
  const [showFilters, setShowFilters] = useState(false);
  const searchInput = useRef<HTMLInputElement>(null);
  useEffect(() => {
    function keyboard(e: KeyboardEvent) {
      if (e.key === '/' && !(e.target instanceof HTMLElement && (['INPUT', 'TEXTAREA', 'SELECT'].includes(e.target.tagName) || e.target.isContentEditable)) && !document.querySelector('[role="dialog"]')) {
        e.preventDefault(); searchInput.current?.focus();
      }
    }
    window.addEventListener('keydown', keyboard); return () => window.removeEventListener('keydown', keyboard);
  }, []);
  useEffect(() => setPage(1), [deferred, mode, company, form, status, sort, size, savedOnly, records.length]);
  const favouriteKeys = useMemo(() => new Set(favourites.map(f => f.key)), [favourites]);
  const companies = useMemo(() => [...new Set(records.map(r => r.companyName).filter(Boolean))].sort((a, b) => a.localeCompare(b)), [records]);
  const forms = useMemo(() => [...new Set(records.flatMap(formsOf))].sort((a, b) => a.localeCompare(b)), [records]);
  const generics = useMemo(() => new Set(records.map(r => r.saltName).filter(Boolean)).size, [records]);
  const brands = useMemo(() => new Set(records.map(r => r.brandName).filter(Boolean)).size, [records]);
  const savedCount = useMemo(() => new Set(records.flatMap(r => [favouriteKey('generic', r.saltName), favouriteKey('brand', r.brandName)]).filter(key => favouriteKeys.has(key))).size, [records, favouriteKeys]);
  const groups = useMemo(() => {
    const q = deferred.trim().toLocaleLowerCase();
    const result = new Map<string, Group>();
    for (const record of records) {
      if (q && ![record.saltName, record.brandName, record.companyName, record.docId].some(s => s.toLocaleLowerCase().includes(q))) continue;
      if (company && record.companyName !== company) continue;
      if (form && !formsOf(record).includes(form)) continue;
      if (status === 'blocked' && !isBlocked(record) || status === 'active' && isBlocked(record)) continue;
      const name = mode === 'generic' ? record.saltName : record.brandName;
      if (savedOnly && (!name || !favouriteKeys.has(favouriteKey(mode, name)))) continue;
      const key = name ? favouriteKey(mode, name) : `record:${record.docId}`;
      const existing = result.get(key);
      if (existing) existing.records.push(record);
      else result.set(key, { key, name: displayName(record, mode), records: [record] });
    }
    return [...result.values()].sort((a, b) => (sort === 'desc' ? -1 : 1) * a.name.localeCompare(b.name));
  }, [records, deferred, company, form, status, mode, savedOnly, favouriteKeys, sort]);
  const pages = Math.max(1, Math.ceil(groups.length / size));
  const safePage = Math.min(page, pages);
  const shown = groups.slice((safePage - 1) * size, safePage * size);
  const filterCount = [company, form, status].filter(Boolean).length;
  const resetFilters = () => { setSearch(''); setCompany(''); setForm(''); setStatus(''); };
  const stats = [
    { label: 'Medicine records', count: records.length, icon: Pill, theme: 'green', note: source ? 'In your catalogue' : 'Awaiting your data' },
    { label: 'Generic names', count: generics, icon: FlaskConical, theme: 'blue', note: 'Browse active ingredients' },
    { label: 'Brand names', count: brands, icon: Tag, theme: 'violet', note: 'Explore source-listed brands' },
    { label: 'Saved references', count: savedCount, icon: Star, theme: 'amber', note: 'Your personal shortlist' },
  ];
  return <>
    <div className="page-heading"><div><div className="eyebrow">YOUR VETERINARY REFERENCE</div><h1>{savedOnly ? 'Saved references' : 'Medicine library'}<span className="heading-dot">.</span></h1><p>{savedOnly ? 'Keep the references you want to come back to, together.' : 'Find the right reference. Keep your information close.'}</p></div><button className="button" onClick={onImport}><FileUp size={17} /> Import catalogue</button></div>
    <div className="stats-grid">{stats.map(({ icon: Icon, ...stat }) => <div className="stat-card" key={stat.label}><div><span>{stat.label}</span><strong>{loading ? '—' : stat.count.toLocaleString()}</strong><small>{stat.note}</small></div><span className={`stat-icon ${stat.theme}`}><Icon size={20} strokeWidth={1.7} /></span></div>)}</div>
    {!savedOnly && !loading && !records.length && <div className="welcome-panel">
      <div className="welcome-copy"><div className="welcome-kicker"><span /><span>A FRESH START, IN YOUR BROWSER</span></div><h2>Your catalogue.<br />A little more accessible.</h2><p>Bring your authorised medicine data into a focused workspace. Search, compare references and save what matters—all from your browser.</p><div className="welcome-actions"><button className="button" onClick={onImport}><FileUp size={16} /> Import your data <ArrowRight size={16} /></button><button className="text-button" onClick={onConnect}><Cloud size={17} /> Connect Firebase</button></div><span className="welcome-privacy"><ShieldCheck size={14} /> Local-first. No catalogue data is uploaded by default.</span></div>
      <div className="welcome-visual" aria-hidden="true"><div className="orbit orbit-one" /><div className="orbit orbit-two" /><div className="visual-dot vd-one" /><div className="visual-dot vd-two" /><div className="medicine-card mc-back"><span className="mini-line" /><span className="mini-line short" /><span className="mini-pill" /></div><div className="medicine-card mc-front"><span className="visual-pill"><Pill size={40} strokeWidth={1.5} /></span><span className="visual-card-label">YOUR REFERENCE, ORGANISED</span><div className="mini-line" /><div className="mini-line short" /><div className="visual-card-bottom"><span><ShieldCheck size={13} /> On your device</span><Bookmark size={16} /></div></div><span className="floating-feature ff-top"><Search size={17} /><span>Find it faster</span></span><span className="floating-feature ff-bottom"><Star size={16} /><span>Keep it close</span></span></div>
    </div>}
    <section className="library-panel">
      <div className="library-title-row"><div className="library-section-title"><span className="section-icon">{savedOnly ? <Bookmark size={18} /> : <BookOpen size={18} />}</span><h2>{savedOnly ? 'Your shortlist' : 'Browse the catalogue'}</h2><span className="count-badge">{groups.length.toLocaleString()}</span></div><button className="subtle-link" onClick={onHowItWorks}>How data works <ArrowUpDown size={13} /></button></div>
      <div className="catalogue-controls"><div className="segmented" role="tablist" aria-label="Browse medicines by"><button role="tab" aria-selected={mode === 'generic'} className={mode === 'generic' ? 'active' : ''} onClick={() => setMode('generic')}><FlaskConical size={16} /> Generics</button><button role="tab" aria-selected={mode === 'brand'} className={mode === 'brand' ? 'active' : ''} onClick={() => setMode('brand')}><Pill size={16} /> Brands</button></div>
        <div className="search-box"><Search size={17} /><input ref={searchInput} value={search} onChange={e => setSearch(e.target.value)} placeholder="Search generic, brand or company…" aria-label="Search medicines" />{search ? <button aria-label="Clear search" onClick={() => setSearch('')}><X size={15} /></button> : <kbd>/</kbd>}</div>
        <button className={`button button-secondary filter-button ${showFilters || filterCount ? 'filter-active' : ''}`} onClick={() => setShowFilters(v => !v)} aria-expanded={showFilters}><ListFilter size={16} /> Filters{filterCount > 0 && <span>{filterCount}</span>}</button>
        <div className="select-wrap sort-select"><ArrowDownAZ size={16} /><select value={sort} aria-label="Sort medicines" onChange={e => setSort(e.target.value)}><option value="asc">Name A–Z</option><option value="desc">Name Z–A</option></select><ChevronDown size={13} /></div>
      </div>
      {showFilters && <div className="filter-tray"><label>Company<div className="select-wrap"><select aria-label="Filter by company" value={company} onChange={e => setCompany(e.target.value)}><option value="">All companies</option>{companies.map(c => <option key={c}>{c}</option>)}</select><ChevronDown size={14} /></div></label><label>Dosage form<div className="select-wrap"><select aria-label="Filter by dosage form" value={form} onChange={e => setForm(e.target.value)}><option value="">All supplied forms</option>{forms.map(f => <option key={f}>{f}</option>)}</select><ChevronDown size={14} /></div></label><label>Source status<div className="select-wrap"><select aria-label="Filter by source status" value={status} onChange={e => setStatus(e.target.value)}><option value="">All records</option><option value="active">Not marked blocked</option><option value="blocked">Marked blocked</option></select><ChevronDown size={14} /></div></label><button className="subtle-link" onClick={() => { setCompany(''); setForm(''); setStatus(''); }}>Reset filters</button></div>}
      <div className="table-scroll"><table className={`catalogue-table ${preferences.density}`}><thead><tr><th>{mode === 'generic' ? 'GENERIC NAME' : 'BRAND NAME'} <ChevronDown size={12} /></th><th>{mode === 'generic' ? 'AVAILABLE BRANDS' : 'GENERIC / SALT'}</th><th>DOSAGE FORMS</th><th>COMPANY</th><th className="save-col">SAVE</th></tr></thead><tbody>{shown.map(group => {
        const r = group.records[0];
        const forms = [...new Set(group.records.flatMap(formsOf))];
        const otherNames = [...new Set(group.records.map(item => mode === 'generic' ? item.brandName : item.saltName).filter(Boolean))];
        const companies = [...new Set(group.records.map(item => item.companyName).filter(Boolean))];
        const favouriteName = mode === 'generic' ? r.saltName : r.brandName;
        const saved = favouriteName && favouriteKeys.has(favouriteKey(mode, favouriteName));
        const blocked = group.records.some(isBlocked);
        return <tr key={group.key}><td><button className="medicine-name" onClick={() => setSelection(group.records)}><span className={`table-glyph ${mode}`}><Pill size={18} /></span><span><strong>{group.name}</strong><small>{group.records.length} source {group.records.length === 1 ? 'record' : 'records'}{blocked && <span className="blocked-label"> · includes blocked status</span>}</small></span></button></td><td><div className="cell-main">{otherNames.length ? otherNames[0] : <span className="muted">Not supplied</span>}</div>{otherNames.length > 1 && <small className="muted">+{otherNames.length - 1} more {mode === 'generic' ? 'brands' : 'generics'}</small>}</td><td><div className="form-tags">{forms.length ? <>{forms.slice(0, 2).map(f => <span key={f}>{f}</span>)}{forms.length > 2 && <span>+{forms.length - 2}</span>}</> : <span className="muted no-tag">Not supplied</span>}</div></td><td><div className="cell-main">{companies[0] || <span className="muted">Not supplied</span>}</div>{companies.length > 1 && <small className="muted">+{companies.length - 1} more companies</small>}</td><td className="save-col"><button disabled={!favouriteName} aria-label={`${saved ? 'Unsave' : 'Save'} ${group.name}`} className={`star-button ${saved ? 'saved' : ''}`} onClick={() => void toggleFavourite(mode, favouriteName)}><Star size={18} fill={saved ? 'currentColor' : 'none'} /></button></td></tr>;
      })}</tbody></table></div>
      {!groups.length && <div className="catalogue-empty">
        <div className="empty-glyph"><span>{savedOnly ? <Bookmark size={29} strokeWidth={1.4} /> : records.length ? <Search size={29} strokeWidth={1.4} /> : <FolderOpen size={31} strokeWidth={1.4} />}</span><i><Pill size={13} /></i></div>
        <h3>{savedOnly ? `No saved ${mode === 'generic' ? 'generic' : 'brand'} references yet` : records.length ? 'No matching records' : 'Your medicine library is ready for data'}</h3>
        <p>{savedOnly ? 'Use the star beside a generic or brand to keep it here. Your shortlist is saved in this browser.' : records.length ? 'Try a different search or clear your filters. Your catalogue has not changed.' : 'The Android package included the app structure—not the medicine records. Import a real catalogue or connect an authorised source to start browsing.'}</p>
        <div className="empty-actions">{savedOnly ? <button className="button button-secondary" onClick={onConnect}><Database size={15} /> Manage catalogue</button> : records.length ? <button className="button button-secondary" onClick={resetFilters}>Clear search & filters</button> : <><button className="button button-secondary" onClick={onImport}><UploadIcon /> Import catalogue</button><button className="subtle-link" onClick={onHowItWorks}>View supported formats <ArrowRight size={14} /></button></>}</div>
        {!records.length && <div className="format-pills"><span>JSON</span><span>CSV</span><span>SQLite</span></div>}
      </div>}
      <div className="table-footer"><span>{groups.length ? `Showing ${((safePage - 1) * size + 1).toLocaleString()}–${Math.min(safePage * size, groups.length).toLocaleString()} of ${groups.length.toLocaleString()} references` : '0 references · no records are bundled or generated'}<span className="footer-separator">·</span><select aria-label="References per page" value={size} onChange={e => setSize(Number(e.target.value))}>{[10, 25, 50].map(n => <option key={n} value={n}>{n} per page</option>)}</select></span><div className="pagination"><button aria-label="Previous page" disabled={safePage <= 1} onClick={() => setPage(p => p - 1)}><ChevronLeft size={15} /></button><span>{safePage}</span><small>of {pages}</small><button aria-label="Next page" disabled={safePage >= pages} onClick={() => setPage(p => p + 1)}><ChevronRight size={15} /></button></div></div>
    </section>
    <div className="library-bottom"><span><ShieldCheck size={14} /> {source ? `Last loaded from ${source.label}` : 'Your files stay on your device. Your catalogue stays yours.'}</span><span>Reference only. Verify before clinical use.</span></div>
    <RecordDrawer selection={selection} mode={mode} onClose={() => setSelection([])} onSelect={record => setSelection([record])} />
  </>;
}
function UploadIcon() { return <FileUp size={15} />; }
