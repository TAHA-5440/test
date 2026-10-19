import { useEffect, useRef, useState } from 'react';
import { AlertCircle, ArrowDownToLine, ArrowRight, Check, CheckCircle2, ChevronDown, Cloud, Database, Download, ExternalLink, FileJson2, FileSpreadsheet, FileUp, Fingerprint, HardDrive, Info, Link2, LoaderCircle, LockKeyhole, LogIn, ShieldCheck, Unplug, Upload, X } from 'lucide-react';
import type { FirebaseConnection } from '../lib/types';
import { useWorkspace, downloadFile } from '../Workspace';
import { cloudAccount, cloudError, disconnectCloud, googleSignIn, parseConnection, syncCloud } from '../lib/cloud';
import { Modal } from './Modal';

const exampleConfig = JSON.stringify({ apiKey: 'YOUR_PUBLIC_WEB_API_KEY', projectId: 'your-project-id', authDomain: 'your-project-id.firebaseapp.com', appId: 'YOUR_WEB_APP_ID' }, null, 2);
function savedConfig() {
  try {
    const stored = localStorage.getItem('vetpharma-firebase');
    if (!stored) return { text: '', collection: 'NewMedicinesData' };
    const { collection, ...config } = JSON.parse(stored);
    return { text: JSON.stringify(config, null, 2), collection: String(collection || 'NewMedicinesData') };
  } catch { return { text: '', collection: 'NewMedicinesData' }; }
}
export function DataPage({ onImport, onFormat }: { onImport: () => void; onFormat: () => void }) {
  const { records, source, importRecords, exportCatalogue, notify } = useWorkspace();
  const [initial] = useState(savedConfig);
  const [configText, setConfigText] = useState(initial.text);
  const [collection, setCollection] = useState(initial.collection);
  const [authorised, setAuthorised] = useState(false);
  const [cloudMessage, setCloudMessage] = useState('');
  const [cloudFailure, setCloudFailure] = useState('');
  const [account, setAccount] = useState('');
  const [busy, setBusy] = useState<'sync' | 'signin' | ''>('');
  const [progress, setProgress] = useState(0);
  const [merge, setMerge] = useState(true);
  const [exportFormat, setExportFormat] = useState<'json' | 'csv' | 'sqlite' | null>(null);
  const [exporting, setExporting] = useState(false);
  const abort = useRef<AbortController | null>(null);
  useEffect(() => () => abort.current?.abort(), []);
  function configuration(): FirebaseConnection { return parseConnection(configText, collection); }
  function saveConfig() {
    setCloudFailure(''); setCloudMessage('');
    try {
      const config = configuration();
      localStorage.setItem('vetpharma-firebase', JSON.stringify(config));
      setCloudMessage('Configuration saved in this browser. Connection and access have not been verified.');
      notify('Public web-client configuration saved locally.', 'info');
    } catch (e) { setCloudFailure(cloudError(e)); }
  }
  async function signIn() {
    if (!authorised) return;
    setBusy('signin'); setCloudFailure(''); setCloudMessage('');
    try { setAccount(await googleSignIn(configuration())); notify('Google sign-in completed for your configured project.'); }
    catch (e) { setCloudFailure(cloudError(e)); }
    finally { setBusy(''); }
  }
  async function sync() {
    if (!authorised) return;
    setBusy('sync'); setProgress(0); setCloudFailure(''); setCloudMessage('');
    const controller = new AbortController(); abort.current = controller;
    try {
      const config = configuration();
      const data = await syncCloud(config, controller.signal, setProgress);
      if (!merge && !window.confirm(`Replace the current catalogue with ${data.records.length.toLocaleString()} synced records? Export a backup first if needed. Saved references will be kept.`)) {
        setCloudMessage('Download completed but the replacement was cancelled. Your catalogue is unchanged.'); return;
      }
      await importRecords(data, `${config.projectId} / ${config.collection}`, 'firebase', !merge);
      localStorage.setItem('vetpharma-firebase', JSON.stringify(config));
      setCloudMessage(`Sync complete: ${data.records.length.toLocaleString()} actual source records saved in this browser.`);
    } catch (e) { setCloudFailure(cloudError(e)); }
    finally { setBusy(''); abort.current = null; }
  }
  async function disconnect() {
    try { await disconnectCloud(); setAccount(''); setCloudMessage('Cloud session disconnected. Your local catalogue is still here.'); setCloudFailure(''); }
    catch (e) { setCloudFailure(cloudError(e)); }
  }
  async function doExport() {
    if (!exportFormat) return;
    setExporting(true);
    try { await exportCatalogue(exportFormat); setExportFormat(null); }
    catch (e) { notify(e instanceof Error ? e.message : 'Export failed.', 'error'); }
    finally { setExporting(false); }
  }
  return <>
    <div className="page-heading"><div><div className="eyebrow">YOUR DATA, YOUR WORKSPACE</div><h1>Data & sync<span className="heading-dot">.</span></h1><p>Bring in a catalogue you trust. Keep a copy you control.</p></div><span className="page-label"><LockKeyhole size={15} /> Local-first by default</span></div>
    <div className="notice data-honesty"><Info size={20} /><div><strong>The catalogue is not included in the app package.</strong><p>This browser version uses the recovered Android data model. It starts with zero medicine records and never manufactures missing names, indications, prices or dosages. Import actual data or connect a project you are authorised to read.</p></div></div>
    <div className="data-top-grid">
      <section className="panel data-card"><div className="section-heading"><span className="feature-icon green"><FileUp size={23} /></span><span className="tiny-badge">RECOMMENDED</span></div><h2>Import a local catalogue</h2><p>Load a JSON or CSV export, or a consistent SQLite <code>medicines_DB</code> containing actual medicine records.</p><div className="supported-file-types"><span><FileJson2 size={15} /> JSON</span><span><FileSpreadsheet size={15} /> CSV</span><span><Database size={15} /> SQLite</span></div><button className="button" onClick={onImport}><Upload size={16} /> Choose a data file <ArrowRight size={16} /></button><button className="subtle-link" onClick={onFormat}>View the import format</button><div className="card-footer-note"><ShieldCheck size={14} /> File contents never leave your browser.</div></section>
      <section className="panel data-card"><div className="section-heading"><span className="feature-icon blue"><HardDrive size={23} /></span><span className={`tiny-badge ${source ? 'good' : ''}`}>{source ? 'CATALOGUE LOADED' : 'NO DATA LOADED'}</span></div><h2>Your browser catalogue</h2><p>Your local copy is stored in this browser profile. Export it before clearing browsing data or switching devices.</p><dl className="workspace-facts"><div><dt>Medicine records</dt><dd>{records.length.toLocaleString()}</dd></div><div><dt>Last source</dt><dd title={source?.label}>{source?.label || 'Not connected'}</dd></div><div><dt>Last loaded</dt><dd>{source ? new Date(source.importedAt).toLocaleString() : 'Not yet'}</dd></div></dl><div className="export-quick-actions"><button className="button button-secondary button-small" disabled={!records.length} onClick={() => setExportFormat('json')}><Download size={15} /> Export JSON</button><button className="button button-secondary button-small" disabled={!records.length} onClick={() => setExportFormat('csv')}>CSV</button><button className="button button-secondary button-small" disabled={!records.length} onClick={() => setExportFormat('sqlite')}>SQLite</button></div><div className="card-footer-note"><Fingerprint size={14} /> No app-generated catalogue or hidden demo data.</div></section>
    </div>
    <section className="panel cloud-panel"><div className="cloud-heading"><span className="feature-icon violet"><Cloud size={23} /></span><div><h2>Connect your Firebase project</h2><p>Optional · normal client access only · read-only catalogue sync</p></div><span className="tiny-badge">YOUR AUTHORISED SOURCE</span></div>
      <div className="cloud-layout"><div className="cloud-explainer"><h3>A connection you configure.</h3><p>No recovered vendor credentials are prefilled, and no backend is contacted until you explicitly choose sign-in or sync.</p><ol className="numbered-steps"><li><span>1</span><div><strong>Use your web-client configuration</strong><p>From a Firebase project you are allowed to access. Never paste a service-account key.</p></div></li><li><span>2</span><div><strong>Confirm ordinary read access</strong><p>Firestore rules and any App Check requirements still apply. Google sign-in is available if configured in your project.</p></div></li><li><span>3</span><div><strong>Sync actual records</strong><p>Data is read in pages and applied only after the complete download validates. Normal Firebase read charges may apply.</p></div></li></ol><div className="soft-note"><Info size={16} /><p>If your project cannot authorise this browser, use a normal owner-provided JSON/CSV export instead. This is not an access-control bypass.</p></div></div>
      <div className="cloud-form"><label htmlFor="firebase-config">Firebase public web configuration <span>JSON</span></label><textarea id="firebase-config" spellCheck={false} rows={7} value={configText} onChange={e => { setConfigText(e.target.value); setCloudMessage(''); }} placeholder={exampleConfig} /><label htmlFor="collection">Medicine collection</label><input id="collection" value={collection} onChange={e => setCollection(e.target.value)} placeholder="NewMedicinesData" /><p className="field-hint">Uses the same record model as the Android client. A project ID/API key alone does not grant permission to read protected data.</p><label className="check-row"><input type="checkbox" checked={authorised} onChange={e => setAuthorised(e.target.checked)} /><span>I am authorised to read this project and understand that normal Firebase read charges may apply.</span></label><label className="check-row"><input type="checkbox" checked={merge} onChange={e => setMerge(e.target.checked)} /><span>Merge by document ID. Keep records from previous imports.</span></label>
        <div className="cloud-actions"><button className="button button-secondary button-small" onClick={saveConfig} disabled={Boolean(busy)}><Check size={15} /> Save config</button><button className="button button-secondary button-small" onClick={() => void signIn()} disabled={!authorised || Boolean(busy)}>{busy === 'signin' ? <LoaderCircle size={15} className="spin" /> : <LogIn size={15} />} Google sign-in</button><button className="button button-small" onClick={() => void sync()} disabled={!authorised || Boolean(busy)}>{busy === 'sync' ? <LoaderCircle size={15} className="spin" /> : <Cloud size={15} />} Sync catalogue</button>{busy === 'sync' && <button className="text-button danger-text" onClick={() => abort.current?.abort()}><X size={14} /> Cancel</button>}</div>
        {busy === 'sync' && <div className="sync-progress"><LoaderCircle className="spin" size={15} /> {progress.toLocaleString()} records received · current catalogue unchanged until validation completes</div>}
        {account && <div className="cloud-account"><CheckCircle2 size={15} /><span>{account}</span><button onClick={() => void disconnect()} disabled={Boolean(busy)}><Unplug size={14} /> Disconnect</button></div>}
        {cloudFailure && <div className="notice notice-error" role="alert"><AlertCircle size={17} /><p>{cloudFailure}</p></div>}
        {cloudMessage && <div className="notice notice-success" role="status"><CheckCircle2 size={17} /><p>{cloudMessage}</p></div>}
      </div></div>
    </section>
    {source && source.warnings.length > 0 && <section className="panel notes-panel"><h2><Info size={18} /> Last import notes</h2>{source.warnings.map(note => <p key={note}>{note}</p>)}</section>}
    <Modal open={Boolean(exportFormat)} onClose={() => { if (!exporting) setExportFormat(null); }} title={`Export ${exportFormat?.toUpperCase() || 'catalogue'}`} description="Download a copy of the actual records in your browser.">
      <div className="dialog-body"><div className="export-summary"><span className="feature-icon green"><ArrowDownToLine size={25} /></span><div><strong>{records.length.toLocaleString()} medicine records</strong><span>Saved flags for this catalogue are included.</span></div></div><p className="paragraph">{exportFormat === 'json' ? 'Recommended for a full catalogue backup. Additional source fields and nested objects are preserved along with the 14 Android model fields.' : exportFormat === 'csv' ? 'A spreadsheet-friendly export of the 14 Android-model columns. Potential formula prefixes are escaped for safety. Use JSON or SQLite to preserve exact original strings and additional fields.' : 'A standalone, filled SQLite database with medicines_table. This is an export of your loaded records, not a claim of restoring the original Android cache or its Room metadata.'}</p><div className="notice"><ShieldCheck size={17} /><p>This is a local browser download. No records are sent to a server. Keep your exported file private.</p></div></div><div className="dialog-actions"><button className="button button-secondary" onClick={() => setExportFormat(null)} disabled={exporting}>Cancel</button><button className="button" onClick={() => void doExport()} disabled={exporting}>{exporting ? <LoaderCircle className="spin" size={16} /> : <Download size={16} />} Download {exportFormat?.toUpperCase()}</button></div>
    </Modal>
  </>;
}

export function downloadTemplate() {
  downloadFile('pharmapedia-empty-import-template.json', JSON.stringify({ _note: 'Blank format template, not recovered medicine data. Add your actual authorised records to medicines. docId and saltName/brandName are expected. See the in-app format guide.', medicines: [] }, null, 2), 'application/json');
}
