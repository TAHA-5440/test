import DoseCalculator from '../components/DoseCalculator';
import { PageHeader, Callout, Disclaimer } from '../components/ui';
import { usePreferences } from '../state/PreferencesContext';
import { DRUGS } from '../data/drugs';
import { speciesWithDoses } from '../data/drugs';
import { SPECIES_ICON, speciesLabel } from '../data/species';

export default function DrugCalculatorPage() {
  const { species, weightKg } = usePreferences();
  const coverage = speciesWithDoses().sort((a, b) => b.count - a.count);

  return (
    <div className="container page">
      <PageHeader
        eyebrow="Tool"
        title="Drug calculator"
        lede="Total dose = body weight × mg/kg. Volume = total dose ÷ concentration. Tablets = total dose ÷ mg per tablet. The calculator then shows the answer for each formulation on file, so you get a number you can draw up rather than one you have to convert."
      />

      <DoseCalculator initialSpecies={species} initialWeight={weightKg} initialDrugId="meloxicam" />

      <section className="section">
        <h2>How the arithmetic works</h2>
        <div className="grid grid-3">
          <div className="card card-tight">
            <h4 className="mb-1">1 · Total dose</h4>
            <p className="small muted mb-0 mono">mg = body weight (kg) × dose (mg/kg)</p>
            <p className="small muted mb-0 mt-2">
              A 18 kg dog at 10 mg/kg is 180 mg. The calculator shows the working so you can check it by eye before you draw up.
            </p>
          </div>
          <div className="card card-tight">
            <h4 className="mb-1">2 · Volume</h4>
            <p className="small muted mb-0 mono">mL = total dose (mg) ÷ concentration (mg/mL)</p>
            <p className="small muted mb-0 mt-2">
              180 mg from a 50 mg/mL suspension is 3.6 mL. Concentration is the single most common source of a ten-fold error,
              so the strength is printed next to the answer.
            </p>
          </div>
          <div className="card card-tight">
            <h4 className="mb-1">3 · Units</h4>
            <p className="small muted mb-0 mono">tablets = total dose (mg) ÷ mg per tablet</p>
            <p className="small muted mb-0 mt-2">
              Where a dose is published per animal, per quarter or per litre of drinking water, it is reported exactly as written
              rather than being forced into a mg/kg calculation.
            </p>
          </div>
        </div>
      </section>

      <section className="section">
        <h2>Coverage</h2>
        <p className="muted">
          Number of drugs in the library with at least one published dose for each species. Buffalo is counted separately from
          cattle but falls back to cattle data where no buffalo-specific dose exists — the calculator labels every carried-over
          row.
        </p>
        <div className="grid grid-4">
          {coverage.map((c) => (
            <div key={c.species} className="card card-tight">
              <div className="stat-value">{c.count}</div>
              <div className="stat-label">
                {SPECIES_ICON[c.species]} {speciesLabel(c.species)}
              </div>
            </div>
          ))}
        </div>
      </section>

      <Callout tone="info" title="Ranges, not single numbers">
        Most published doses are ranges. The calculator defaults to the low end and lets you switch to the top — reserving the
        top of the range for a case that needs it is better practice than defaulting there.
      </Callout>

      <Callout tone="warning" title="Withdrawal intervals">
        Where a withdrawal interval is published it is shown as meat (days) and milk (hours). Where the reference states that no
        interval is established, the calculator says so — it will not invent one. Follow your national residue scheme and the
        product label.
      </Callout>

      <p className="tiny subtle mt-4">{DRUGS.length} monographs available in the calculator.</p>
      <Disclaimer />
    </div>
  );
}
