import { useMemo, useState } from 'react';
import { VACCINES, VACCINE_SPECIES, vaccinesFor, reminderIntervalDays } from '../data/vaccines';
import { SPECIES_ICON, speciesLabel } from '../data/species';
import type { SpeciesId } from '../types';
import { PageHeader, Callout, Chip, Badge, Disclaimer } from '../components/ui';
import { usePreferences } from '../state/PreferencesContext';

function addDays(days: number): string {
  const d = new Date();
  d.setDate(d.getDate() + days);
  return d.toISOString().slice(0, 10);
}

export default function Vaccinations() {
  const { species, setSpecies } = usePreferences();
  const active: SpeciesId = (VACCINE_SPECIES as string[]).includes(species) ? species : 'dog';
  const [vaccinatedOn, setVaccinatedOn] = useState<string>(new Date().toISOString().slice(0, 10));

  const rows = useMemo(() => vaccinesFor(active), [active]);

  return (
    <div className="container page">
      <PageHeader
        eyebrow="Reference"
        title="Vaccination schedules"
        lede="Core and non-core schedules by species, with the primary course, booster timing and revaccination interval. The reminder calculator turns any row into a date you can put in the practice diary."
      />

      <div className="card mb-4">
        <div className="field">
          <span className="label">Species</span>
          <div className="chip-row">
            {VACCINE_SPECIES.map((s) => (
              <Chip key={s} small selected={s === active} onClick={() => setSpecies(s as SpeciesId)}>
                {SPECIES_ICON[s as SpeciesId]} {speciesLabel(s as SpeciesId)}
              </Chip>
            ))}
          </div>
        </div>
        <div className="field mb-0">
          <label className="label" htmlFor="vacc-date">
            Reminder calculator — date of this vaccination
          </label>
          <input
            id="vacc-date"
            className="input"
            type="date"
            style={{ maxWidth: '220px' }}
            value={vaccinatedOn}
            onChange={(e) => setVaccinatedOn(e.target.value)}
          />
          <p className="tiny subtle mt-2 mb-0">
            Reminder dates below are calculated from this date plus the standard revaccination interval parsed from the schedule.
            They are a diary prompt, not a clinical instruction.
          </p>
        </div>
      </div>

      <div className="table-wrap">
        <table>
          <thead>
            <tr>
              <th>Vaccine</th>
              <th>Protects against</th>
              <th>Primary course</th>
              <th>Boosters</th>
              <th>Revaccination</th>
              <th className="nowrap">Next reminder</th>
            </tr>
          </thead>
          <tbody>
            {rows.map((v) => {
              const interval = reminderIntervalDays(v);
              const base = new Date(vaccinatedOn);
              const next = Number.isFinite(base.getTime()) ? addDays(interval) : '—';
              return (
                <tr key={v.id}>
                  <td>
                    <strong>{v.vaccine}</strong>
                    {v.note && <div className="tiny subtle mt-1">{v.note}</div>}
                  </td>
                  <td className="small">{v.protects}</td>
                  <td className="small">{v.primaryStart}</td>
                  <td className="small">{v.boosters}</td>
                  <td className="small">{v.revaccination}</td>
                  <td className="small nowrap">
                    <Badge tone={interval >= 365 ? 'neutral' : 'amber'}>{next}</Badge>
                    <div className="tiny subtle">+{interval} d</div>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>

      <Callout tone="info" title="Schedules differ by region">
        These rows follow widely used international schedules. Endemic disease, vaccine availability and national regulation
        change what is core — a schedule that is correct in one country is not automatically correct in another.
      </Callout>

      <Callout tone="warning" title="Maternal antibody">
        The primary course is a series, not a single injection, because maternal antibody interferes unpredictably. A puppy or
        calf vaccinated once before its maternal antibody has waned is not protected, whatever the owner believes.
      </Callout>

      <p className="tiny subtle mt-4">{VACCINES.length} schedule rows across {VACCINE_SPECIES.length} species.</p>
      <Disclaimer />
    </div>
  );
}
