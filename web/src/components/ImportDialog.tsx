import { useRef, useState } from 'react';
import { AlertCircle, ArrowRight, Check, CheckCircle2, Database, FileJson2, FileSpreadsheet, FileUp, LoaderCircle, LockKeyhole, Upload, X } from 'lucide-react';
import { Modal } from './Modal';
import { parseImportFile } from '../lib/catalogue';
import type { ImportResult } from '../lib/types';
import { useWorkspace } from '../Workspace';

export function ImportDialog({ open, onClose }: { open: boolean; onClose: () => void }) {
  const { records, importRecords } = useWorkspace();
  const picker = useRef<HTMLInputElement>(null);
  const [file, setFile] = useState<File | null>(null);
  const [parsed, setParsed] = useState<ImportResult | null>(null);
  const [error, setError] = useState('');
  const [busy, setBusy] = useState(false);
  const [dragging, setDragging] = useState(false);
  const [mode, setMode] = useState<'replace' | 'merge'>('replace');
  const reset = () => { setFile(null); setParsed(null); setError(''); setMode('replace'); };
  const close = () => { if (!busy) { reset(); onClose(); } };
  async function read(candidate?: File) {
    if (!candidate || busy) return;
    setBusy(true); setError(''); setParsed(null); setFile(candidate);
    try { setParsed(await parseImportFile(candidate)); }
    catch (e) { setError(e instanceof Error ? e.message : 'The file could not be imported.'); }
    finally { setBusy(false); }
  }
  async function confirm() {
    if (!file || !parsed) return;
    setBusy(true); setError('');
    try { await importRecords(parsed, file.name, 'file', mode === 'replace'); reset(); onClose(); }
    catch { setError('Could not save to browser storage. Your current catalogue was not changed. Check site storage permissions or available space.'); }
    finally { setBusy(false); }
  }
  return <Modal open={open} onClose={close} title="Import your catalogue" description="Bring your actual medicine records into this browser workspace." wide>
    <div className="dialog-body">
      <input ref={picker} type="file" accept=".json,.jsonl,.ndjson,.csv,.db,.sqlite,.sqlite3,*/*" aria-label="Choose medicine data file" className="visually-hidden" onChange={e => { void read(e.target.files?.[0]); e.target.value = ''; }} />
      {!parsed && <button className={`dropzone ${dragging ? 'dragging' : ''}`} disabled={busy} onClick={() => picker.current?.click()}
        onDragOver={e => { e.preventDefault(); setDragging(true); }} onDragLeave={() => setDragging(false)} onDrop={e => { e.preventDefault(); setDragging(false); void read(e.dataTransfer.files[0]); }}>
        <span className="dropzone-icon">{busy ? <LoaderCircle size={26} className="spin" /> : <FileUp size={27} />}</span>
        <strong>{busy ? 'Checking your file…' : 'Choose a file or drop it here'}</strong>
        <span>JSON, CSV, or a checkpointed SQLite database · up to 100 MiB</span>
        {!busy && <span className="button button-small button-secondary"><Upload size={15} /> Browse files</span>}
      </button>}
      {parsed && file && <div className="import-preview">
        <div className="preview-title"><span className="success-icon"><CheckCircle2 size={24} /></span><div><strong>Ready to import</strong><span>{file.name}</span></div><button className="icon-button" aria-label="Choose a different file" onClick={reset} disabled={busy}><X size={17} /></button></div>
        <div className="import-metrics"><div><b>{parsed.records.length.toLocaleString()}</b><span>medicine records</span></div><div><b>{new Set(parsed.records.map(r => r.saltName).filter(Boolean)).size.toLocaleString()}</b><span>generic names</span></div><div><b>{new Set(parsed.records.map(r => r.brandName).filter(Boolean)).size.toLocaleString()}</b><span>brand names</span></div></div>
        <div className="import-examples"><span className="eyebrow">FIRST RECORDS IN YOUR FILE</span>{parsed.records.slice(0, 3).map(r => <div key={r.docId}><span>{r.brandName || r.saltName || 'Unnamed record'}</span><code>{r.docId}</code></div>)}</div>
        {parsed.warnings.length > 0 && <div className="notice notice-amber"><AlertCircle size={17} /><div><strong>Review data notes</strong>{parsed.warnings.map(note => <p key={note}>{note}</p>)}</div></div>}
        {records.length > 0 && <fieldset className="import-options"><legend>There are {records.length.toLocaleString()} records in your current catalogue.</legend>
          <label><input type="radio" name="import-mode" checked={mode === 'replace'} onChange={() => setMode('replace')} /><span><strong>Replace catalogue</strong><small>Use this file instead. Saved references are kept. Export your current data first if needed.</small></span></label>
          <label><input type="radio" name="import-mode" checked={mode === 'merge'} onChange={() => setMode('merge')} /><span><strong>Merge by document ID</strong><small>Keep other records; matching IDs are updated from this file.</small></span></label>
        </fieldset>}
      </div>}
      {error && <div className="notice notice-error" role="alert"><AlertCircle size={18} /><p>{error}</p></div>}
      {!parsed && <div className="import-format-grid"><div><FileJson2 size={19} /><strong>JSON / Firestore export</strong><p>An array, document-ID map, or <code>documents</code>/<code>medicines</code> export.</p></div><div><FileSpreadsheet size={19} /><strong>CSV</strong><p>Include <code>docId</code> and the recovered medicine fields.</p></div><div><Database size={19} /><strong>SQLite</strong><p>A consistent <code>medicines_DB</code> with a populated <code>medicines_table</code>.</p></div></div>}
      <div className="privacy-inline"><LockKeyhole size={15} /><span>Files are read on your device, not uploaded. APKs and empty schemas contain no catalogue records.</span></div>
    </div>
    <div className="dialog-actions"><button className="button button-secondary" onClick={close} disabled={busy}>Cancel</button>{parsed && <button className="button" onClick={() => void confirm()} disabled={busy}>{busy ? <LoaderCircle size={16} className="spin" /> : <Check size={16} />} Import {parsed.records.length.toLocaleString()} records <ArrowRight size={16} /></button>}</div>
  </Modal>;
}
