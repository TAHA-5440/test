import FluidCalculator from '../components/FluidCalculator';
import { PageHeader, Callout, Disclaimer } from '../components/ui';
import { usePreferences } from '../state/PreferencesContext';
import { SPECIES, SPECIES_ICON } from '../data/species';

export default function FluidTherapy() {
  const { species, weightKg } = usePreferences();

  return (
    <div className="container page">
      <PageHeader
        eyebrow="Tool"
        title="Fluid therapy planner"
        lede="Deficit, maintenance and ongoing losses, converted into a drip rate you can set with a stopwatch. The plan is split into two phases because the deficit is replaced faster than maintenance is delivered, and it flags the patients who need a shock bolus before any of it."
      />

      <FluidCalculator initialSpecies={species} initialWeight={weightKg} />

      <section className="section">
        <h2>The four equations</h2>
        <div className="grid grid-2">
          <div className="card card-tight">
            <h4 className="mb-1">Deficit</h4>
            <p className="mono small muted mb-1">deficit (mL) = weight (kg) × dehydration (%) × 10</p>
            <p className="small muted mb-0">
              Ten mL per kg per percentage point of dehydration. An 8% dehydrated 12 kg dog has a 960 mL deficit.
            </p>
          </div>
          <div className="card card-tight">
            <h4 className="mb-1">Maintenance</h4>
            <p className="mono small muted mb-1">maintenance = weight (kg) × rate (mL/kg/day) × (hours ÷ 24)</p>
            <p className="small muted mb-0">
              Pro-rated to the replacement window. Neonates need substantially more per kg than adults, and the toggle changes
              the rate and warns you if you leave it too low.
            </p>
          </div>
          <div className="card card-tight">
            <h4 className="mb-1">Rate</h4>
            <p className="mono small muted mb-1">mL/h = total volume ÷ replacement hours</p>
            <p className="small muted mb-0">
              Total includes ongoing losses — vomit, diarrhoea, a draining wound. A number that is not measured is guessed, and
              the plan will be wrong by that much.
            </p>
          </div>
          <div className="card card-tight">
            <h4 className="mb-1">Drip rate</h4>
            <p className="mono small muted mb-1">gtt/min = mL/h × drop factor ÷ 60</p>
            <p className="small muted mb-0">
              The drop factor is a property of the giving set, not the patient. 15 and 20 gtt/mL are macro sets; 60 gtt/mL is a
              micro set. Picking the wrong one quarters or doubles your rate.
            </p>
          </div>
        </div>
      </section>

      <section className="section">
        <h2>Maintenance rates by species</h2>
        <div className="table-wrap">
          <table>
            <thead>
              <tr>
                <th>Species</th>
                <th className="num">Adult (mL/kg/day)</th>
                <th className="num">Young (mL/kg/day)</th>
                <th>Preferred fluids</th>
              </tr>
            </thead>
            <tbody>
              {SPECIES.map((s) => (
                <tr key={s.id}>
                  <td>
                    {SPECIES_ICON[s.id]} <strong>{s.label}</strong>
                  </td>
                  <td className="num mono">
                    {s.maintenanceRange[0]}–{s.maintenanceRange[1]}
                  </td>
                  <td className="num mono">{s.maintenanceRateYoung ? `${s.maintenanceRateYoung}–${s.maintenanceRateYoung + 40}` : '—'}</td>
                  <td className="small">{s.preferredFluids.join(', ')}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </section>

      <Callout tone="warning" title="Reassess, do not infuse blind">
        A fluid plan is a hypothesis. Recheck hydration, mucous membranes, heart rate and body weight every 4–6 hours; cats and
        small patients overload far faster than a deficit calculation suggests, and a rising respiratory rate is the earliest
        sign.
      </Callout>

      <Disclaimer />
    </div>
  );
}
