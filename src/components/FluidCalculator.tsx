import { useMemo, useState } from 'react';
import { DEHYDRATION_LADDER, GIVING_SETS, SPECIES_MAP, speciesLabel } from '../data/species';
import type { SpeciesId } from '../types';
import { calculateFluids, dehydrationEntry } from '../engine/fluids';
import { Callout, Badge, Chip } from './ui';
import SpeciesPicker, { WeightField } from './SpeciesPicker';

function ml(v: number): string {
  if (!Number.isFinite(v)) return '—';
  if (v >= 1000) return `${(v / 1000).toFixed(2)} L`;
  return `${Math.round(v)} mL`;
}

export default function FluidCalculator({ initialSpecies = 'dog', initialWeight = 12 }: { initialSpecies?: SpeciesId; initialWeight?: number }) {
  const [species, setSpecies] = useState<SpeciesId>(initialSpecies);
  const [weight, setWeight] = useState(initialWeight);
  const [dehydrationPct, setDehydrationPct] = useState(8);
  const [ongoing, setOngoing] = useState(0);
  const [hours, setHours] = useState(24);
  const [dropFactor, setDropFactor] = useState(20);
  const [paediatric, setPaediatric] = useState(false);
  const [manualRate, setManualRate] = useState(true);

  const meta = SPECIES_MAP[species];
  // Default to the low end of the published range: it is the conventional
  // planning figure and it reproduces the reference worked example. The slider
  // and the `Reset to reference` control both restore it.
  const referenceRate = paediatric && meta?.maintenanceRateYoung ? meta.maintenanceRateYoung : meta?.maintenanceRange[0] ?? meta?.maintenanceRate ?? 60;
  const defaultRate = referenceRate;
  const [maintenanceRate, setMaintenanceRate] = useState(defaultRate);

  const result = useMemo(
    () =>
      calculateFluids({
        species,
        weightKg: weight,
        dehydrationPct,
        maintenanceRate,
        ongoingLossesMl: ongoing,
        hours,
        dropFactor,
        paediatric,
      }),
    [species, weight, dehydrationPct, maintenanceRate, ongoing, hours, dropFactor, paediatric],
  );

  const applySpecies = (s: SpeciesId) => {
    setSpecies(s);
    const m = SPECIES_MAP[s];
    setMaintenanceRate(paediatric && m?.maintenanceRateYoung ? m.maintenanceRateYoung : m?.maintenanceRange[0] ?? m?.maintenanceRate ?? 60);
  };

  const entry = dehydrationEntry(dehydrationPct);

  return (
    <div className="split">
      <div className="card">
        <div className="field">
          <span className="label">Species</span>
          <SpeciesPicker compact showProxyNote={false} value={species} onChange={applySpecies} />
        </div>

        <WeightField value={weight} onChange={setWeight} />

        <div className="field">
          <div className="row-between">
            <label className="label" htmlFor="dehyd">
              Dehydration: {dehydrationPct}%
            </label>
            <span className={`badge ${entry.shock ? 'badge-red' : entry.percent >= 7 ? 'badge-amber' : 'badge-green'}`}>
              {entry.shock ? 'Shock' : entry.percent >= 7 ? 'Moderate–severe' : entry.percent > 0 ? 'Mild–moderate' : 'Normal'}
            </span>
          </div>
          <div className="chip-row mb-2">
            {DEHYDRATION_LADDER.map((d) => (
              <Chip key={d.percent} small selected={d.percent === dehydrationPct} onClick={() => setDehydrationPct(d.percent)}>
                {d.percent}%
              </Chip>
            ))}
          </div>
          <input
            id="dehyd"
            className="range"
            type="range"
            min={0}
            max={14}
            step={1}
            value={dehydrationPct}
            onChange={(e) => setDehydrationPct(Number(e.target.value))}
          />
          <p className="tiny subtle mt-2 mb-0">{entry.signs}</p>
        </div>

        <div className="field">
          <label className="label" htmlFor="maint">
            Maintenance rate: {maintenanceRate} mL/kg/day
          </label>
          <input
            id="maint"
            className="range"
            type="range"
            min={20}
            max={140}
            step={5}
            value={maintenanceRate}
            onChange={(e) => {
              setMaintenanceRate(Number(e.target.value));
              setManualRate(true);
            }}
          />
          <div className="row tiny subtle">
            <span>Adult reference for {speciesLabel(species).toLowerCase()}: {meta?.maintenanceRate} mL/kg/day</span>
            {meta?.maintenanceRateYoung && <span>· Young: {meta.maintenanceRateYoung} mL/kg/day</span>}
            <button
              type="button"
              className="btn btn-ghost btn-sm"
              onClick={() => {
                setMaintenanceRate(paediatric && meta?.maintenanceRateYoung ? meta.maintenanceRateYoung : meta?.maintenanceRange[0] ?? meta?.maintenanceRate ?? 60);
                setManualRate(false);
              }}
            >
              Reset to reference
            </button>
          </div>
          {manualRate && <p className="tiny subtle mt-1 mb-0">Using a manually adjusted rate.</p>}
        </div>

        <div className="grid grid-2">
          <div className="field">
            <label className="label" htmlFor="ongoing">
              Ongoing losses (mL over the period)
            </label>
            <input
              id="ongoing"
              className="input"
              type="number"
              inputMode="numeric"
              min={0}
              value={ongoing}
              onChange={(e) => setOngoing(Math.max(0, Number(e.target.value) || 0))}
            />
          </div>
          <div className="field">
            <label className="label" htmlFor="hours">
              Replacement window (hours)
            </label>
            <input
              id="hours"
              className="input"
              type="number"
              inputMode="numeric"
              min={1}
              max={72}
              value={hours}
              onChange={(e) => setHours(Math.max(1, Number(e.target.value) || 1))}
            />
          </div>
        </div>

        <div className="field">
          <span className="label">Giving set (drop factor)</span>
          <div className="chip-row">
            {GIVING_SETS.map((g) => (
              <Chip key={g} small selected={g === dropFactor} onClick={() => setDropFactor(g)}>
                {g} gtt/mL
              </Chip>
            ))}
          </div>
        </div>

        <label className="checkbox-row mb-0">
          <input type="checkbox" checked={paediatric} onChange={(e) => setPaediatric(e.target.checked)} />
          <span>
            Neonatal / paediatric patient
            <span className="tiny subtle"> — uses the higher young-animal maintenance rate</span>
          </span>
        </label>
      </div>

      <div>
        <div className="dose-panel">
          <div className="tiny" style={{ fontWeight: 700, letterSpacing: '0.06em', textTransform: 'uppercase', color: 'var(--teal-700)' }}>
            Fluid plan over {hours} h
          </div>
          <div className="dose-total mt-2">{ml(result.totalMl)}</div>
          <div className="mt-3 row">
            <Badge tone="teal">{Math.round(result.rateMlPerH)} mL/h</Badge>
            <Badge tone="amber">{result.dropsPerMin.toFixed(1)} gtt/min</Badge>
            <Badge tone="neutral">{result.secondsPerDrop.toFixed(1)} s/drop</Badge>
          </div>

          <div className="dose-working">
            Deficit = {weight} kg × {dehydrationPct}% × 10 = {ml(result.deficitMl)}<br />
            Maintenance = {weight} kg × {maintenanceRate} mL/kg/day × ({hours} h ÷ 24 h) = {ml(result.maintenanceForPeriodMl)}
            <br />
            {result.ongoingMl > 0 && <>Ongoing losses = {ml(result.ongoingMl)}<br /></>}
            Total = {ml(result.totalMl)} ÷ {hours} h = {result.rateMlPerH.toFixed(1)} mL/h
            <br />
            Drip rate = {result.rateMlPerH.toFixed(1)} × {dropFactor} ÷ 60 = <strong>{result.dropsPerMin.toFixed(1)} gtt/min</strong>
          </div>

          <h4 className="mt-4 mb-2">Suggested two-phase plan</h4>
          <div className="table-wrap">
            <table>
              <thead>
                <tr>
                  <th>Phase</th>
                  <th className="num">Volume</th>
                  <th className="num">Rate</th>
                  <th className="num">Drops</th>
                </tr>
              </thead>
              <tbody>
                {result.phases.map((p) => (
                  <tr key={p.label}>
                    <td>
                      <strong>{p.label}</strong>
                      <div className="tiny subtle">{p.hours} h</div>
                    </td>
                    <td className="num mono">{ml(p.volumeMl)}</td>
                    <td className="num mono">{p.rateMlPerH.toFixed(1)} mL/h</td>
                    <td className="num mono">{p.dropsPerMin.toFixed(1)}/min</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>

          {result.shockBolusMl !== null && (
            <Callout tone="danger" title="Shock bolus first">
              <strong>{ml(result.shockBolusMl)}</strong> (10–20 mL/kg) over 15 minutes, then reassess perfusion before starting
              the replacement phase. {result.shockBolusNote}
            </Callout>
          )}

          <h4 className="mb-2">Fluid choice</h4>
          <div className="chip-row mb-3">
            {result.preferredFluids.map((f) => (
              <Chip key={f}>{f}</Chip>
            ))}
          </div>
          {result.fluidNote && <p className="small muted mb-0">{result.fluidNote}</p>}
        </div>

        {result.warnings.map((w) => (
          <Callout key={w} tone="warning" title="Check">
            {w}
          </Callout>
        ))}

        <Callout tone="plain" title="How the numbers are derived">
          Deficit (mL) = weight × dehydration % × 10. Maintenance is pro-rated to the replacement window. Drip rate = mL/h × drop
          factor ÷ 60. A giving set is a physical object: 15 and 20 gtt/mL are macro sets, 60 gtt/mL is a micro set, and using the
          wrong one in this calculation doubles or quarters the drip rate.
        </Callout>
      </div>
    </div>
  );
}
