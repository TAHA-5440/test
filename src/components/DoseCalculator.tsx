import { useMemo, useState } from 'react';
import { DRUGS, DRUG_MAP } from '../data/drugs';
import { speciesLabel } from '../data/species';
import type { SpeciesId } from '../types';
import {
  computeDose,
  rowsForSpecies,
  formatDoseRange,
  formatNumber,
  intervalsPerDay,
  dailyDoseTotal,
  courseTotal,
} from '../engine/dosing';
import { Callout, Badge, Sources } from './ui';
import SpeciesPicker, { WeightField } from './SpeciesPicker';

interface Props {
  initialDrugId?: string;
  initialSpecies?: SpeciesId;
  initialWeight?: number;
  onChange?: (drugId: string, species: SpeciesId, weight: number) => void;
}

export default function DoseCalculator({ initialDrugId = 'meloxicam', initialSpecies = 'dog', initialWeight = 18, onChange }: Props) {
  const [drugId, setDrugId] = useState(initialDrugId);
  const [species, setSpecies] = useState<SpeciesId>(initialSpecies);
  const [weight, setWeight] = useState(initialWeight);
  const [query, setQuery] = useState('');
  const [rowIndex, setRowIndex] = useState(0);
  const [useHigh, setUseHigh] = useState(false);
  const [courseDays, setCourseDays] = useState(5);
  const [showAll, setShowAll] = useState(false);

  const drug = DRUG_MAP[drugId] ?? DRUGS[0];

  const suggestions = useMemo(() => {
    if (query.trim().length < 1) return [];
    const q = query.toLowerCase();
    return DRUGS.filter((d) => d.name.toLowerCase().includes(q) || d.aliases.some((a) => a.toLowerCase().includes(q))).slice(0, 8);
  }, [query]);

  const rows = useMemo(() => rowsForSpecies(drug, species), [drug, species]);
  const row = rows[Math.min(rowIndex, rows.length - 1)];

  const result = useMemo(() => {
    if (!row) return null;
    return computeDose(drug, row.row, weight, useHigh ? 1 : 0);
  }, [drug, row, weight, useHigh]);

  const perDay = useMemo(() => {
    if (!row || !result) return null;
    const n = intervalsPerDay(row.row.frequency);
    return n ? { n, total: dailyDoseTotal(result, n) } : null;
  }, [row, result]);

  const course = useMemo(() => (result ? courseTotal(result, courseDays) : null), [result, courseDays]);
  const canGoHigh = Boolean(row?.row.doseHigh !== null && row?.row.doseHigh !== undefined);

  const notify = (nextDrug: string, nextSpecies: SpeciesId, nextWeight: number) => {
    onChange?.(nextDrug, nextSpecies, nextWeight);
  };

  return (
    <div className="split">
      <div className="card">
        <div className="field">
          <label className="label" htmlFor="drug-search">
            Drug
          </label>
          <input
            id="drug-search"
            className="input"
            placeholder="Start typing a drug name…"
            value={showAll ? query : drug.name}
            onChange={(e) => {
              setQuery(e.target.value);
              setShowAll(true);
            }}
            onFocus={() => setShowAll(true)}
            autoComplete="off"
          />
          {showAll && (
            <div className="stack-sm mt-2">
              <button type="button" className="btn btn-ghost btn-sm" onClick={() => setShowAll(false)}>
                Close suggestions
              </button>
              {suggestions.length === 0 && query.trim().length > 0 && <p className="tiny muted mb-0">No drug in the library matches “{query}”.</p>}
              {suggestions.map((d) => (
                <button
                  key={d.id}
                  type="button"
                  className="btn btn-secondary btn-sm"
                  style={{ justifyContent: 'space-between' }}
                  onClick={() => {
                    setDrugId(d.id);
                    setRowIndex(0);
                    setShowAll(false);
                    setQuery('');
                    notify(d.id, species, weight);
                  }}
                >
                  <span>{d.name}</span>
                  <span className="tiny subtle">{d.className}</span>
                </button>
              ))}
              {suggestions.length === 0 && query.trim().length === 0 && (
                <p className="tiny muted mb-0">
                  {DRUGS.length} monographs in the library.{' '}
                  <button type="button" className="btn btn-ghost btn-sm" onClick={() => setShowAll(false)}>
                    Keep the current drug
                  </button>
                </p>
              )}
            </div>
          )}
        </div>

        <div className="field">
          <span className="label">Species</span>
          <SpeciesPicker
            compact
            value={species}
            onChange={(s) => {
              setSpecies(s);
              setRowIndex(0);
              notify(drugId, s, weight);
            }}
          />
        </div>

        <WeightField
          value={weight}
          onChange={(w) => {
            setWeight(w);
            notify(drugId, species, w);
          }}
        />

        {rows.length > 0 ? (
          <div className="field">
            <label className="label" htmlFor="indication-select">
              Indication / dose row
            </label>
            <select
              id="indication-select"
              className="select"
              value={Math.min(rowIndex, rows.length - 1)}
              onChange={(e) => {
                setRowIndex(Number(e.target.value));
                setUseHigh(false);
              }}
            >
              {rows.map((r, i) => (
                <option key={`${r.row.indication}-${i}`} value={i}>
                  {r.row.indication} — {formatDoseRange(r.row)} {r.row.route} {r.row.frequency}
                </option>
              ))}
            </select>

          </div>
        ) : (
          <Callout tone="warning" title="No published dose for this species">
            The library holds no {speciesLabel(species).toLowerCase()} dose for <strong>{drug.name}</strong>. Do not extrapolate a
            rate from another species without a reference that supports doing so.
          </Callout>
        )}

        {row && (
          <div className="field">
            <div className="row">
              <label className="checkbox-row" style={{ flex: 1 }}>
                <input
                  type="checkbox"
                  checked={useHigh}
                  disabled={!canGoHigh}
                  onChange={(e) => setUseHigh(e.target.checked)}
                />
                <span>
                  Use the top of the range
                  {!canGoHigh && <span className="tiny subtle"> — this row publishes a single value</span>}
                </span>
              </label>
            </div>
          </div>
        )}

        <div className="field mb-0">
          <label className="label" htmlFor="course-days">
            Course length for the total-quantity figure: {courseDays} days
          </label>
          <input
            id="course-days"
            className="range"
            type="range"
            min={1}
            max={28}
            step={1}
            value={courseDays}
            onChange={(e) => setCourseDays(Number(e.target.value))}
          />
        </div>
      </div>

      <div>
        {result && row ? (
          <>
            <div className="dose-panel">
              <div className="tiny" style={{ fontWeight: 700, letterSpacing: '0.06em', textTransform: 'uppercase', color: 'var(--teal-700)' }}>
                Total per administration
              </div>
              <div className="dose-total mt-2">{result.totalDisplay}</div>
              <div className="mt-3">
                <Badge tone="teal">{formatDoseRange(row.row)}</Badge>{' '}
                <Badge tone="neutral">{row.row.route}</Badge>{' '}
                <Badge tone="neutral">{row.row.frequency}</Badge>{' '}

              </div>

              <div className="dose-working">
                {result.weightBased ? (
                  <>
                    {formatNumber(result.doseValue ?? 0)} {row.row.unit} × {formatNumber(weight)} kg ={' '}
                    {formatNumber(result.totalMg ?? 0)} mg
                    {result.totalMgHigh !== null && <> &nbsp;·&nbsp; range top {formatNumber(result.totalMgHigh)} mg</>}
                  </>
                ) : (
                  <>Published per-animal dose: {formatNumber(result.doseValue ?? 0)} {row.row.unit}</>
                )}
              </div>

              {result.amounts.length > 0 && (
                <>
                  <h4 className="mt-4 mb-2">Amount to draw up</h4>
                  <div className="table-wrap">
                    <table>
                      <thead>
                        <tr>
                          <th>Product</th>
                          <th>Strength</th>
                          <th className="num">Amount</th>
                        </tr>
                      </thead>
                      <tbody>
                        {result.amounts.map((a, i) => (
                          <tr key={`${a.product.name}-${i}`}>
                            <td>
                              <strong>{a.product.name}</strong>
                              {a.product.form ? <div className="tiny subtle">{a.product.form}</div> : null}
                            </td>
                            <td className="small">
                              {a.product.concentrationMgPerMl
                                ? `${a.product.concentrationMgPerMl} mg/mL`
                                : a.product.mgPerUnit
                                  ? `${a.product.mgPerUnit} mg per ${a.product.form}`
                                  : a.product.brand ?? '—'}
                            </td>
                            <td className="num mono">
                              <strong>{a.display}</strong>
                            </td>
                          </tr>
                        ))}
                      </tbody>
                    </table>
                  </div>
                </>
              )}

              <dl className="kv mt-3">
                <dt>Indication</dt>
                <dd>{row.row.indication}</dd>
                <dt>Route</dt>
                <dd>{row.row.route}</dd>
                <dt>Frequency</dt>
                <dd>
                  {row.row.frequency}
                  {perDay ? ` (${formatNumber(perDay.n, 1)}×/day)` : ''}
                </dd>
                {perDay?.total !== null && perDay?.total !== undefined && (
                  <>
                    <dt>Per day</dt>
                    <dd>{formatNumber(perDay.total)} mg/day</dd>
                  </>
                )}
                {row.row.duration && (
                  <>
                    <dt>Published duration</dt>
                    <dd>{row.row.duration}</dd>
                  </>
                )}
                {course !== null && (
                  <>
                    <dt>Total over {courseDays} d</dt>
                    <dd>{formatNumber(course)} mg</dd>
                  </>
                )}
                <dt>Withdrawal</dt>
                <dd>
                  <Badge
                    tone={
                      result.withdrawal.level === 'set'
                        ? 'amber'
                        : result.withdrawal.level === 'unknown'
                          ? 'red'
                          : result.withdrawal.level === 'na'
                            ? 'neutral'
                            : 'green'
                    }
                  >
                    {result.withdrawal.text}
                  </Badge>
                </dd>
              </dl>

              {row.row.note && (
                <Callout tone="info" title="Note on this dose">
                  {row.row.note}
                </Callout>
              )}
            </div>

            <p className="tiny subtle mt-3 mb-0">
              Citation for this row: {row.row.source}
            </p>
            <Sources ids={drug.sources} />
          </>
        ) : (
          <Callout tone="plain" title="Pick a row to see the dose">
            Choose an indication once a published dose exists for {speciesLabel(species).toLowerCase()}.
          </Callout>
        )}
      </div>
    </div>
  );
}
