import { useEffect, useState } from 'react';
import type { ReactNode } from 'react';
import DOMPurify from 'dompurify';
import { AlertTriangle, ArrowUpRight, Building2, CalendarClock, ChevronDown, FileText, FlaskConical, Globe2, Layers3, Pill, ShieldCheck, Star } from 'lucide-react';
import { Modal } from './Modal';
import type { JsonMap, Medicine, ViewMode } from '../lib/types';
import { displayName, favouriteKey, isBlocked } from '../lib/catalogue';
import { useWorkspace } from '../Workspace';

const tabs = ['Overview', 'Forms', 'Dosage', 'Alternatives', 'Source'] as const;
type Tab = typeof tabs[number];
export function SourceText({ text, fallback = 'No information supplied in this record.' }: { text: string; fallback?: string }) {
  if (!text.trim()) return <p className="muted empty-field">{fallback}</p>;
  if (!/<\/?(?:p|br|b|strong|em|i|ul|ol|li|sub|sup|table|thead|tbody|tr|th|td|h3|h4)(?:\s|>|\/)/i.test(text)) return <div className="source-text">{text}</div>;
  return <div className="source-text" dangerouslySetInnerHTML={{ __html: DOMPurify.sanitize(text, { ALLOWED_TAGS: ['p', 'br', 'b', 'strong', 'em', 'i', 'ul', 'ol', 'li', 'sub', 'sup', 'table', 'thead', 'tbody', 'tr', 'th', 'td', 'h3', 'h4'], ALLOWED_ATTR: ['colspan', 'rowspan'] }) }} />;
}
function label(value: string) { return value; } // Source keys may contain case-sensitive units; keep them verbatim.
function StructuredValue({ value }: { value: unknown }) {
  if (value === null || value === undefined || value === '') return <span className="muted">Not supplied</span>;
  if (Array.isArray(value)) return <div className="structured-list">{value.map((v, i) => <StructuredValue key={i} value={v} />)}</div>;
  if (typeof value === 'object') return <dl className="structured-map">{Object.entries(value as JsonMap).map(([key, v]) => <div key={key}><dt>{label(key)}</dt><dd><StructuredValue value={v} /></dd></div>)}</dl>;
  return typeof value === 'string' ? <SourceText text={value} /> : <span>{String(value)}</span>;
}
function MapSection({ data, empty, icon }: { data: JsonMap; empty: string; icon: ReactNode }) {
  if (!Object.keys(data).length) return <div className="detail-empty">{icon}<h3>No details supplied</h3><p>{empty}</p></div>;
  return <div className="map-sections">{Object.entries(data).map(([key, value]) => <section className="map-section" key={key}><h3>{key}</h3><StructuredValue value={value} /></section>)}</div>;
}
export function RecordDrawer({ selection, mode, onClose, onSelect }: { selection: Medicine[]; mode: ViewMode; onClose: () => void; onSelect: (record: Medicine) => void }) {
  const { records, favourites, source, toggleFavourite } = useWorkspace();
  const [tab, setTab] = useState<Tab>('Overview');
  const [id, setId] = useState('');
  useEffect(() => { setTab('Overview'); setId(selection[0]?.docId || ''); }, [selection]);
  const record = selection.find(r => r.docId === id) || selection[0];
  if (!record) return null;
  const name = mode === 'generic' ? record.saltName : record.brandName;
  const saved = Boolean(name) && favourites.some(f => f.key === favouriteKey(mode, name));
  const alternatives = records.filter(r => r.docId !== record.docId && record.saltName && r.saltName === record.saltName);
  return <Modal open={selection.length > 0} onClose={onClose} title={displayName(record, mode)} description={mode === 'brand' ? record.saltName || 'Generic name not supplied' : 'Source-provided medicine reference'} drawer>
    <div className="drawer-summary"><span className="record-glyph"><Pill size={25} /></span><div><span className="eyebrow">{mode === 'brand' ? 'BRAND REFERENCE' : 'GENERIC REFERENCE'}</span><strong>{record.brandName || 'Brand not supplied'}</strong><span>{record.companyName || 'Company not supplied'}</span></div><button className={`button button-secondary button-small ${saved ? 'is-saved' : ''}`} aria-label={saved ? 'Unsave reference' : 'Save reference'} disabled={!name} onClick={() => void toggleFavourite(mode, name)}><Star size={16} fill={saved ? 'currentColor' : 'none'} />{saved ? 'Saved' : 'Save'}</button></div>
    {selection.length > 1 && <div className="variant-picker"><label htmlFor="source-record">Choose a source record</label><div className="select-wrap"><select id="source-record" value={record.docId} onChange={e => setId(e.target.value)}>{selection.map(r => <option value={r.docId} key={r.docId}>{r.brandName || r.saltName || r.docId} · {r.companyName || r.docId}</option>)}</select><ChevronDown size={15} /></div><small>Descriptions and dosages below belong to the selected record, not every brand.</small></div>}
    {isBlocked(record) && <div className="notice notice-amber drawer-notice"><AlertTriangle size={18} /><p>The source marks this record as blocked. Do not interpret it as an available or recommended medicine.</p></div>}
    <div className="detail-tabs" role="tablist" aria-label="Medicine details">{tabs.map(value => <button role="tab" aria-selected={tab === value} key={value} onClick={() => setTab(value)}>{value}{value === 'Alternatives' && <span>{alternatives.length}</span>}</button>)}</div>
    <div className="drawer-content" role="tabpanel" aria-label={tab}>
      {tab === 'Overview' && <>
        <div className="record-facts"><span><Building2 size={15} />{record.companyName || 'No company supplied'}</span><span><Globe2 size={15} />{record.countryName || 'No country supplied'}</span></div>
        <section className="clinical-section"><h3><FileText size={17} /> Overview</h3><SourceText text={record.overview} /></section>
        <section className="clinical-section"><h3><FlaskConical size={17} /> Indications</h3><SourceText text={record.indications} /></section>
        <section className="clinical-section"><h3><ShieldCheck size={17} /> Contraindications</h3><SourceText text={record.contraIndications} /></section>
      </>}
      {tab === 'Forms' && <><p className="detail-intro">Form, strength, packing and prices are displayed exactly as supplied by your catalogue. Currency and current availability are not inferred.</p><MapSection data={record.availableForms} empty="This record has no availableForms data. No product details have been generated." icon={<Layers3 size={32} />} /></>}
      {tab === 'Dosage' && <><div className="notice notice-amber"><AlertTriangle size={17} /><p>Source information only—not a prescription. Confirm the product label and consult a veterinarian. No dose calculations or recommendations are generated here.</p></div><MapSection data={record.dosageDetail} empty="This record has no dosageDetail data. The app does not invent missing dosages." icon={<FileText size={32} />} /></>}
      {tab === 'Alternatives' && (alternatives.length ? <div className="alternative-list">{alternatives.map(r => <button key={r.docId} onClick={() => { onSelect(r); setTab('Overview'); }}><span className="small-glyph"><Pill size={17} /></span><div><strong>{r.brandName || r.saltName || 'Unnamed record'}</strong><span>{r.companyName || 'Company not supplied'}</span></div><ArrowUpRight size={17} /></button>)}</div> : <div className="detail-empty"><Pill size={32} /><h3>No alternate records</h3><p>No other record with this exact generic name is in your current catalogue.</p></div>)}
      {tab === 'Source' && <><dl className="source-facts"><div><dt>Document ID</dt><dd><code>{record.docId}</code></dd></div><div><dt>Last workspace import</dt><dd>{source?.label || 'Imported data'}</dd></div><div><dt>Loaded into this browser</dt><dd>{source ? new Date(source.importedAt).toLocaleString() : 'Not available'}</dd></div><div><dt>Original timeStamp value</dt><dd>{record.timeStamp}</dd></div><div><dt>Original block value</dt><dd>{record.block || '(empty)'}</dd></div></dl>{record.extra && <section className="clinical-section"><h3>Additional original fields</h3><StructuredValue value={record.extra} /></section>}<p className="detail-intro"><CalendarClock size={15} /> Load time is not proof that clinical information or prices are current. This is the last workspace import; a merged catalogue may also contain records from earlier sources.</p><details className="raw-record"><summary>View imported record JSON</summary><p>Normalized model fields and any original additional fields. Missing-field defaults are listed in the import notes; original files are unchanged.</p><pre>{JSON.stringify(record, null, 2)}</pre></details></>}
    </div>
    <div className="drawer-footer"><ShieldCheck size={15} /><span>Reference information from your source. Always verify before clinical use.</span></div>
  </Modal>;
}
