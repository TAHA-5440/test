import { useMemo, useState } from 'react';
import { REFERENCE_RANGES, checkValue, RANGE_SPECIES } from '../data/referenceRanges';
import { SPECIES_ICON, speciesLabel } from '../data/species';
import type { RefRangeRow, SpeciesId } from '../types';
import { PageHeader, Callout, Chip, Badge, Disclaimer, BackLink, PageFooter } from '../components/ui';
import { usePreferences } from '../state/PreferencesContext';

const VERDICT: Record<string, { tone: 'green' | 'red' | 'neutral'; label: string }> = {
  within: { tone: 'green', label: 'Within interval' },
  below: { tone: 'red', label: 'Below interval' },
  above: { tone: 'red', label: 'Above interval' },
};

export default function ReferenceRanges() {
  const { species, setSpecies } = usePreferences();
  const activeSpecies: SpeciesId = (RANGE_SPECIES.includes(species) ? species : 'dog') as SpeciesId;
  const groups = REFERENCE_RANGES[activeSpecies] ?? [];
  const [checkRow, setCheckRow] = useState<RefRangeRow | null>(null);
  const [checkValueInput, setCheckValueInput] = useState('');

  const flat = useMemo(
    () => groups.flatMap((g) => g.rows.map((r) => ({ ...r, group: g.group }))),
    [groups],
  );

  const verdict = useMemo(() => {
    if (!checkRow) return null;
    const v = Number.parseFloat(checkValueInput);
    if (!Number.isFinite(v)) return null;
    return checkValue(checkRow, v);
  }, [checkRow, checkValueInput]);

  return (
    <div className="container page">
      <BackLink to="/tools" />
      <PageHeader
        eyebrow="Tool"
        title="Reference ranges"
        lede="Adult reference intervals for fifteen species across vital signs, haematology and serum biochemistry — with a value checker that tells you where a result falls and the note that explains what to do about it."
      />

      <div className="card mb-4">
        <div className="field">
          <span className="label">Species</span>
          <div className="chip-row">
            {RANGE_SPECIES.map((s) => (
              <Chip key={s} small selected={s === activeSpecies} onClick={() => { setSpecies(s); setCheckRow(null); }}>
                {SPECIES_ICON[s]} {speciesLabel(s)}
              </Chip>
            ))}
          </div>
        </div>

        <div className="field mb-0">
          <span className="label">Check a value</span>
          <div className="row">
            <select
              className="select"
              style={{ maxWidth: '280px' }}
              value={checkRow?.param ?? ''}
              onChange={(e) => {
                const row = flat.find((r) => r.param === e.target.value) ?? null;
                setCheckRow(row);
              }}
              aria-label="Parameter to check"
            >
              <option value="">Select a parameter…</option>
              {flat.map((r) => (
                <option key={`${r.group}-${r.param}`} value={r.param}>
                  {r.group} — {r.param} ({r.unit})
                </option>
              ))}
            </select>
            <input
              className="input"
              style={{ maxWidth: '160px' }}
              type="number"
              inputMode="decimal"
              step="any"
              placeholder="Result"
              value={checkValueInput}
              onChange={(e) => setCheckValueInput(e.target.value)}
              aria-label="Result value"
            />
            {checkRow && (
              <span className="small muted">
                Reference: {checkRow.low ?? '—'}–{checkRow.high ?? '—'} {checkRow.unit}
              </span>
            )}
            {verdict && (
              <Badge tone={VERDICT[verdict]?.tone ?? 'neutral'}>
                {VERDICT[verdict]?.label ?? verdict}
              </Badge>
            )}
          </div>
          {checkRow?.note && <p className="small muted mt-2 mb-0">{checkRow.note}</p>}
        </div>
      </div>

      {groups.map((g) => (
        <section key={g.group} className="section">
          <h2>
            {SPECIES_ICON[activeSpecies]} {g.group} — {speciesLabel(activeSpecies)}
          </h2>
          <div className="table-wrap">
            <table>
              <thead>
                <tr>
                  <th>Parameter</th>
                  <th className="num">Low</th>
                  <th className="num">High</th>
                  <th>Unit</th>
                  <th>Note</th>
                </tr>
              </thead>
              <tbody>
                {g.rows.map((r) => (
                  <tr key={r.param}>
                    <td>
                      <button
                        type="button"
                        className="btn btn-ghost btn-sm"
                        style={{ padding: 0, fontWeight: 600, color: 'var(--text)' }}
                        onClick={() => setCheckRow(r)}
                      >
                        {r.param}
                      </button>
                    </td>
                    <td className="num mono">{r.low ?? '—'}</td>
                    <td className="num mono">{r.high ?? '—'}</td>
                    <td className="small muted">{r.unit}</td>
                    <td className="small muted">{r.note ?? '—'}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </section>
      ))}

      <Callout tone="info" title="Use the laboratory's own interval">
        Reference intervals vary between analysers, methods and populations. Where your laboratory reports its own interval on
        the printout, that one governs interpretation of that sample.
      </Callout>

      <Callout tone="warning" title="Adult intervals">
        These are adult intervals. Neonates, juveniles and geriatric patients differ systematically — a PCV that would be
        anaemic in an adult dog is normal in a three-week-old puppy.
      </Callout>

      <Disclaimer />
          <PageFooter />
    </div>
  );
}
