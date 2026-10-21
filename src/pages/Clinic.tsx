import { useMemo, useState } from 'react';
import { Link } from 'react-router-dom';
import type { PatientRecord, Visit, SpeciesId } from '../types';
import { SPECIES_ICON, speciesLabel, SPECIES } from '../data/species';
import { PageHeader, Callout, Badge, Empty, BackLink, PageFooter } from '../components/ui';

const STORE_KEY = 'vetmasterji:clinic:v1';

const SEED: PatientRecord[] = [
  {
    id: 'P-1001',
    name: 'Simba',
    species: 'dog',
    breed: 'Labrador Retriever',
    age: '4 months',
    sex: 'Male',
    weightKg: 9,
    owner: 'R. Sharma',
    phone: '+91 98xxx xxxx1',
    createdAt: '2026-10-02',
    vaccinations: [
      { id: 'v1', vaccine: 'DHPPiL (puppy 2/3)', given: '2026-09-28', due: '2026-10-19' },
      { id: 'v2', vaccine: 'Rabies', given: '2026-10-02', due: '2027-10-02' },
    ],
    dewormings: [{ id: 'd1', product: 'Fenbendazole 50 mg/kg × 3 d', given: '2026-09-20', due: '2026-10-20' }],
    visits: [
      {
        id: 'V-1',
        date: '2026-10-02',
        complaint: 'Vomiting and bloody diarrhoea for 24 hours; dull and off food.',
        findings: '8% dehydrated, CRT 2 s, T 39.1 °C, abdominal pain on palpation, PCV 52%.',
        diagnosis: 'Canine parvoviral enteritis (faecal antigen positive).',
        treatment:
          'IV crystalloid therapy, maropitant 1 mg/kg SC q24h, ceftriaxone 25 mg/kg IV q12h, nil per os until vomiting controlled.',
        notes: 'Isolated. Owner warned re: prognosis and contagiousness. Recheck in 48 h.',
        weightKg: 9,
      },
    ],
  },
  {
    id: 'P-1002',
    name: 'Gauri',
    species: 'cattle',
    breed: 'Murrah buffalo (dosed as cattle)',
    age: '5 years, 2nd lactation',
    sex: 'Female',
    weightKg: 520,
    owner: 'H. Singh',
    phone: '+91 98xxx xxxx2',
    createdAt: '2026-09-15',
    vaccinations: [{ id: 'v1', vaccine: 'FMD (annual)', given: '2026-04-10', due: '2027-04-10' }],
    dewormings: [{ id: 'd1', product: 'Ivermectin 0.2 mg/kg SC', given: '2026-06-01', due: '2026-12-01' }],
    visits: [
      {
        id: 'V-1',
        date: '2026-09-15',
        complaint: 'Drop in milk yield; off feed since yesterday.',
        findings: 'CMT positive in left fore quarter; flakes in milk; quarter warm, T 38.9 °C.',
        diagnosis: 'Clinical mastitis, left fore quarter.',
        treatment: 'Ceftiofur 2.2 mg/kg IM q24h × 5 d; intramammary; flunixin for 3 d.',
        notes: 'Milk withdrawal observed for 72 h after last treatment. Culture sent.',
        weightKg: 520,
      },
    ],
  },
];

function load(): PatientRecord[] {
  try {
    const raw = window.localStorage.getItem(STORE_KEY);
    if (raw) return JSON.parse(raw) as PatientRecord[];
  } catch {
    /* fall through to seed data */
  }
  return SEED;
}

function save(records: PatientRecord[]): void {
  try {
    window.localStorage.setItem(STORE_KEY, JSON.stringify(records));
  } catch {
    /* storage unavailable — records persist for the session only */
  }
}

export default function Clinic() {
  const [records, setRecords] = useState<PatientRecord[]>(() => load());
  const [selectedId, setSelectedId] = useState<string | null>(() => load()[0]?.id ?? null);
  const [adding, setAdding] = useState(false);
  const [visitOpen, setVisitOpen] = useState(false);
  const [search, setSearch] = useState('');

  const [draft, setDraft] = useState({ name: '', species: 'dog' as SpeciesId, breed: '', age: '', sex: 'Male' as PatientRecord['sex'], weightKg: 10, owner: '', phone: '' });
  const [visit, setVisit] = useState<Omit<Visit, 'id'>>({ date: new Date().toISOString().slice(0, 10), complaint: '', findings: '', diagnosis: '', treatment: '', notes: '', weightKg: 10 });

  const selected = records.find((r) => r.id === selectedId) ?? null;

  const filtered = useMemo(() => {
    if (!search.trim()) return records;
    const q = search.toLowerCase();
    return records.filter(
      (r) => r.name.toLowerCase().includes(q) || r.owner.toLowerCase().includes(q) || r.breed.toLowerCase().includes(q) || r.id.toLowerCase().includes(q),
    );
  }, [records, search]);

  const today = new Date().toISOString().slice(0, 10);
  const reminders = useMemo(() => {
    const out: { patientId: string; patientName: string; label: string; due: string; overdue: boolean }[] = [];
    for (const r of records) {
      for (const v of r.vaccinations) out.push({ patientId: r.id, patientName: r.name, label: v.vaccine, due: v.due, overdue: v.due < today });
      for (const d of r.dewormings) out.push({ patientId: r.id, patientName: r.name, label: d.product, due: d.due, overdue: d.due < today });
    }
    return out.sort((a, b) => a.due.localeCompare(b.due));
  }, [records, today]);

  const persist = (next: PatientRecord[]) => {
    setRecords(next);
    save(next);
  };

  const addPatient = () => {
    if (!draft.name.trim()) return;
    const record: PatientRecord = {
      id: `P-${1000 + records.length + 1}`,
      name: draft.name.trim(),
      species: draft.species,
      breed: draft.breed.trim() || 'Unknown',
      age: draft.age.trim() || 'Unknown',
      sex: draft.sex,
      weightKg: draft.weightKg,
      owner: draft.owner.trim() || '—',
      phone: draft.phone.trim() || '—',
      createdAt: today,
      visits: [],
      vaccinations: [],
      dewormings: [],
    };
    persist([record, ...records]);
    setSelectedId(record.id);
    setAdding(false);
    setDraft({ name: '', species: 'dog', breed: '', age: '', sex: 'Male', weightKg: 10, owner: '', phone: '' });
  };

  const addVisit = () => {
    if (!selected) return;
    const newVisit: Visit = { ...visit, id: `V-${selected.visits.length + 1}` };
    const next = records.map((r) => (r.id === selected.id ? { ...r, weightKg: visit.weightKg, visits: [newVisit, ...r.visits] } : r));
    persist(next);
    setVisitOpen(false);
    setVisit({ date: today, complaint: '', findings: '', diagnosis: '', treatment: '', notes: '', weightKg: selected.weightKg });
  };

  return (
    <div className="container page">
      <BackLink to="/" />
      <PageHeader
        eyebrow="Practice"
        title="Patient records"
        lede="A minimal electronic medical record that lives in your browser: patient list, consultations, vaccination and deworming reminders. Nothing is uploaded — clearing site data erases it, so export before you rely on it."
      />

      <Callout tone="warning" title="Local-only storage">
        Records are stored in this browser only. There is no server, no sync and no backup. Use it for a consultation list, not
        as the practice system of record.
      </Callout>

      {reminders.some((r) => r.overdue) && (
        <Callout tone="danger" title={`${reminders.filter((r) => r.overdue).length} overdue reminders`}>
          {reminders
            .filter((r) => r.overdue)
            .slice(0, 5)
            .map((r) => `${r.patientName}: ${r.label} (due ${r.due})`)
            .join(' · ')}
        </Callout>
      )}

      <div className="split">
        <div>
          <div className="row-between mb-3">
            <h2 className="mb-0">Patients ({records.length})</h2>
            <button type="button" className="btn btn-primary btn-sm" onClick={() => setAdding((a) => !a)}>
              {adding ? 'Cancel' : '+ New patient'}
            </button>
          </div>

          {adding && (
            <div className="card mb-4">
              <div className="grid grid-2">
                <div className="field">
                  <label className="label" htmlFor="p-name">Name</label>
                  <input id="p-name" className="input" value={draft.name} onChange={(e) => setDraft({ ...draft, name: e.target.value })} />
                </div>
                <div className="field">
                  <label className="label" htmlFor="p-species">Species</label>
                  <select id="p-species" className="select" value={draft.species} onChange={(e) => setDraft({ ...draft, species: e.target.value as SpeciesId })}>
                    {SPECIES.map((s) => (
                      <option key={s.id} value={s.id}>{s.label}</option>
                    ))}
                  </select>
                </div>
                <div className="field">
                  <label className="label" htmlFor="p-breed">Breed</label>
                  <input id="p-breed" className="input" value={draft.breed} onChange={(e) => setDraft({ ...draft, breed: e.target.value })} />
                </div>
                <div className="field">
                  <label className="label" htmlFor="p-age">Age</label>
                  <input id="p-age" className="input" value={draft.age} onChange={(e) => setDraft({ ...draft, age: e.target.value })} />
                </div>
                <div className="field">
                  <label className="label" htmlFor="p-sex">Sex</label>
                  <select id="p-sex" className="select" value={draft.sex} onChange={(e) => setDraft({ ...draft, sex: e.target.value as PatientRecord['sex'] })}>
                    <option>Male</option>
                    <option>Female</option>
                    <option>Male neutered</option>
                    <option>Female neutered</option>
                  </select>
                </div>
                <div className="field">
                  <label className="label" htmlFor="p-weight">Weight (kg)</label>
                  <input id="p-weight" className="input" type="number" step="0.1" value={draft.weightKg} onChange={(e) => setDraft({ ...draft, weightKg: Number(e.target.value) })} />
                </div>
                <div className="field">
                  <label className="label" htmlFor="p-owner">Owner</label>
                  <input id="p-owner" className="input" value={draft.owner} onChange={(e) => setDraft({ ...draft, owner: e.target.value })} />
                </div>
                <div className="field">
                  <label className="label" htmlFor="p-phone">Phone</label>
                  <input id="p-phone" className="input" value={draft.phone} onChange={(e) => setDraft({ ...draft, phone: e.target.value })} />
                </div>
              </div>
              <button type="button" className="btn btn-primary" onClick={addPatient} disabled={!draft.name.trim()}>
                Save patient
              </button>
            </div>
          )}

          <div className="field">
            <input className="input" placeholder="Search by patient, owner or ID…" value={search} onChange={(e) => setSearch(e.target.value)} />
          </div>

          <div className="stack-sm">
            {filtered.map((r) => (
              <button
                key={r.id}
                type="button"
                className="card card-tight"
                onClick={() => setSelectedId(r.id)}
                style={{
                  textAlign: 'left',
                  cursor: 'pointer',
                  borderColor: r.id === selectedId ? 'var(--teal-600)' : undefined,
                  background: r.id === selectedId ? 'var(--teal-50)' : undefined,
                }}
              >
                <div className="row-between">
                  <strong>
                    {SPECIES_ICON[r.species]} {r.name}
                  </strong>
                  <span className="tiny subtle">{r.id}</span>
                </div>
                <div className="small muted">
                  {speciesLabel(r.species)} · {r.breed} · {r.age} · {r.weightKg} kg
                </div>
                <div className="tiny subtle">
                  {r.owner} · {r.visits.length} visit{r.visits.length === 1 ? '' : 's'}
                </div>
              </button>
            ))}
            {filtered.length === 0 && <Empty title="No patients match that search" />}
          </div>
        </div>

        <div>
          {!selected ? (
            <Empty title="Select a patient">Choose a patient from the list to see the record.</Empty>
          ) : (
            <>
              <div className="card mb-4">
                <div className="row-between mb-3">
                  <div>
                    <h2 className="mb-1">
                      {SPECIES_ICON[selected.species]} {selected.name}
                    </h2>
                    <p className="small muted mb-0">
                      {selected.id} · {speciesLabel(selected.species)} · {selected.breed} · {selected.age} · {selected.sex} ·{' '}
                      {selected.weightKg} kg
                    </p>
                    <p className="small muted mb-0">
                      Owner {selected.owner} · {selected.phone}
                    </p>
                  </div>
                  <div className="stack-sm">
                    <Link to={`/drug-calculator`} className="btn btn-secondary btn-sm">
                      Calculate a dose
                    </Link>
                    <button type="button" className="btn btn-primary btn-sm" onClick={() => { setVisit({ ...visit, weightKg: selected.weightKg }); setVisitOpen((v) => !v); }}>
                      {visitOpen ? 'Cancel' : '+ Record visit'}
                    </button>
                  </div>
                </div>

                {visitOpen && (
                  <div className="card mb-4" style={{ background: 'var(--surface-2)' }}>
                    <div className="grid grid-2">
                      <div className="field">
                        <label className="label" htmlFor="v-date">Date</label>
                        <input id="v-date" className="input" type="date" value={visit.date} onChange={(e) => setVisit({ ...visit, date: e.target.value })} />
                      </div>
                      <div className="field">
                        <label className="label" htmlFor="v-weight">Weight at visit (kg)</label>
                        <input id="v-weight" className="input" type="number" step="0.1" value={visit.weightKg} onChange={(e) => setVisit({ ...visit, weightKg: Number(e.target.value) })} />
                      </div>
                    </div>
                    <div className="field">
                      <label className="label" htmlFor="v-complaint">Presenting complaint</label>
                      <textarea id="v-complaint" className="textarea" value={visit.complaint} onChange={(e) => setVisit({ ...visit, complaint: e.target.value })} />
                    </div>
                    <div className="field">
                      <label className="label" htmlFor="v-findings">Examination findings</label>
                      <textarea id="v-findings" className="textarea" value={visit.findings} onChange={(e) => setVisit({ ...visit, findings: e.target.value })} />
                    </div>
                    <div className="field">
                      <label className="label" htmlFor="v-diagnosis">Diagnosis</label>
                      <input id="v-diagnosis" className="input" value={visit.diagnosis} onChange={(e) => setVisit({ ...visit, diagnosis: e.target.value })} />
                    </div>
                    <div className="field">
                      <label className="label" htmlFor="v-treatment">Treatment given</label>
                      <textarea id="v-treatment" className="textarea" value={visit.treatment} onChange={(e) => setVisit({ ...visit, treatment: e.target.value })} />
                    </div>
                    <div className="field">
                      <label className="label" htmlFor="v-notes">Notes</label>
                      <textarea id="v-notes" className="textarea" value={visit.notes} onChange={(e) => setVisit({ ...visit, notes: e.target.value })} />
                    </div>
                    <button type="button" className="btn btn-primary" onClick={addVisit}>
                      Save visit
                    </button>
                  </div>
                )}

                <h3 className="mb-2">Vaccinations</h3>
                {selected.vaccinations.length === 0 ? (
                  <p className="small muted">No vaccinations recorded.</p>
                ) : (
                  <div className="table-wrap">
                    <table>
                      <thead>
                        <tr>
                          <th>Vaccine</th>
                          <th>Given</th>
                          <th>Due</th>
                        </tr>
                      </thead>
                      <tbody>
                        {selected.vaccinations.map((v) => (
                          <tr key={v.id}>
                            <td>{v.vaccine}</td>
                            <td className="small">{v.given}</td>
                            <td className="small">
                              <Badge tone={v.due < today ? 'red' : 'green'}>{v.due}</Badge>
                            </td>
                          </tr>
                        ))}
                      </tbody>
                    </table>
                  </div>
                )}

                <h3 className="mb-2 mt-4">Deworming</h3>
                {selected.dewormings.length === 0 ? (
                  <p className="small muted">No deworming recorded.</p>
                ) : (
                  <div className="table-wrap">
                    <table>
                      <thead>
                        <tr>
                          <th>Product</th>
                          <th>Given</th>
                          <th>Due</th>
                        </tr>
                      </thead>
                      <tbody>
                        {selected.dewormings.map((d) => (
                          <tr key={d.id}>
                            <td>{d.product}</td>
                            <td className="small">{d.given}</td>
                            <td className="small">
                              <Badge tone={d.due < today ? 'red' : 'green'}>{d.due}</Badge>
                            </td>
                          </tr>
                        ))}
                      </tbody>
                    </table>
                  </div>
                )}
              </div>

              <h3 className="mb-2">Consultation history</h3>
              {selected.visits.length === 0 ? (
                <Empty title="No visits recorded">Record the first consultation for {selected.name}.</Empty>
              ) : (
                <div className="stack">
                  {selected.visits.map((v) => (
                    <article key={v.id} className="card card-tight">
                      <div className="row-between mb-2">
                        <strong>{v.date}</strong>
                        <span className="tiny subtle">
                          {v.weightKg} kg · {v.id}
                        </span>
                      </div>
                      {v.complaint && (
                        <>
                          <div className="tiny subtle">Complaint</div>
                          <p className="small mb-2">{v.complaint}</p>
                        </>
                      )}
                      {v.findings && (
                        <>
                          <div className="tiny subtle">Findings</div>
                          <p className="small mb-2">{v.findings}</p>
                        </>
                      )}
                      {v.diagnosis && (
                        <>
                          <div className="tiny subtle">Diagnosis</div>
                          <p className="small mb-2">
                            <strong>{v.diagnosis}</strong>
                          </p>
                        </>
                      )}
                      {v.treatment && (
                        <>
                          <div className="tiny subtle">Treatment</div>
                          <p className="small mb-2">{v.treatment}</p>
                        </>
                      )}
                      {v.notes && (
                        <>
                          <div className="tiny subtle">Notes</div>
                          <p className="small mb-0">{v.notes}</p>
                        </>
                      )}
                    </article>
                  ))}
                </div>
              )}
            </>
          )}
        </div>
      </div>
          <PageFooter />
    </div>
  );
}
