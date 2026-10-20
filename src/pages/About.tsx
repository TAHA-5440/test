import { Link } from 'react-router-dom';
import { REFERENCES } from '../data/references';
import { DRUGS } from '../data/drugs';
import { DISEASES } from '../data/diseases';
import { SIGNS } from '../data/signs';
import { SPECIES } from '../data/species';
import { PageHeader, Callout, Badge } from '../components/ui';

export default function About() {
  return (
    <div className="container page">
      <PageHeader
        eyebrow="About"
        title="Sources &amp; method"
        lede="A veterinary drug and fluid reference built on one rule: every number is traceable to a named text. This page sets out where the content comes from, how the calculations work, and what this build does differently."
      />

      <section className="section">
        <h2>Reference library</h2>
        <p className="muted">
          Every dose row, condition entry and clinical note cites at least one of these. {DRUGS.length} monographs,{' '}
          {DISEASES.length} conditions and {SIGNS.length} signs are indexed against them.
        </p>
        <div className="table-wrap">
          <table>
            <thead>
              <tr>
                <th>Short</th>
                <th>Reference</th>
                <th>Edition</th>
                <th>Area</th>
              </tr>
            </thead>
            <tbody>
              {REFERENCES.map((r) => (
                <tr key={r.id}>
                  <td className="mono small">
                    <strong>{r.short}</strong>
                  </td>
                  <td>{r.title}</td>
                  <td className="small">{r.edition}</td>
                  <td className="small muted">{r.area}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </section>

      <section className="section">
        <h2>How the calculations work</h2>
        <div className="grid grid-2">
          <div className="card card-tight">
            <h4 className="mb-1">Dose</h4>
            <p className="mono small muted mb-1">mg = weight (kg) × dose (mg/kg)</p>
            <p className="mono small muted mb-1">mL = total mg ÷ concentration (mg/mL)</p>
            <p className="mono small muted mb-0">tablets = total mg ÷ mg per tablet</p>
          </div>
          <div className="card card-tight">
            <h4 className="mb-1">Fluids</h4>
            <p className="mono small muted mb-1">deficit (mL) = kg × dehydration % × 10</p>
            <p className="mono small muted mb-1">total = deficit + maintenance + ongoing losses</p>
            <p className="mono small muted mb-0">gtt/min = mL/h × drop factor ÷ 60</p>
          </div>
          <div className="card card-tight">
            <h4 className="mb-1">Differentials</h4>
            <p className="mono small muted mb-0">
              confidence = Σ weight of matched key signs ÷ Σ weight of all key signs
            </p>
          </div>
          <div className="card card-tight">
            <h4 className="mb-1">Withdrawal</h4>
            <p className="small muted mb-0">
              Taken from the cited reference and shown as meat (days) and milk (hours). Where no interval is established, the
              entry says so rather than printing a number.
            </p>
          </div>
        </div>
      </section>

      <section className="section">
        <h2>What this build changes</h2>
        <div className="grid grid-2">
          <div className="card card-tight">
            <Badge tone="teal">Improvement</Badge>
            <h4 className="mt-2 mb-1">Carry-over dosing is labelled</h4>
            <p className="small muted mb-0">
              Where no species-specific dose exists — buffalo is the common case — the row is carried over from the proxy species
              and marked as extra-label at the point of use, rather than silently presented as species data.
            </p>
          </div>
          <div className="card card-tight">
            <Badge tone="teal">Improvement</Badge>
            <h4 className="mt-2 mb-1">Refusals are explicit</h4>
            <p className="small muted mb-0">
              Prohibited-in-food-animal drugs are modelled as a dose row with a null rate and a prohibition statement. The
              assistant tells you when nothing in the corpus matches instead of generating a plausible answer.
            </p>
          </div>
          <div className="card card-tight">
            <Badge tone="teal">Improvement</Badge>
            <h4 className="mt-2 mb-1">Whole-prescription screening</h4>
            <p className="small muted mb-0">
              Interaction checking across an entire prescription at once, with class-level rules, monograph pairings and
              food-animal residue flags — not just pairwise lookups.
            </p>
          </div>
          <div className="card card-tight">
            <Badge tone="teal">Improvement</Badge>
            <h4 className="mt-2 mb-1">Structure over video</h4>
            <p className="small muted mb-0">
              The procedure library is written as searchable steps with pitfall lists. It loads instantly, works offline, can be
              read with your hands occupied, and carries a citation a video cannot.
            </p>
          </div>
          <div className="card card-tight">
            <Badge tone="teal">Improvement</Badge>
            <h4 className="mt-2 mb-1">Retrieval, not generation</h4>
            <p className="small muted mb-0">
              The clinical assistant is a deterministic search over the curated corpus with citations attached. It cannot invent
              a dose, which is the property that makes its answers usable.
            </p>
          </div>
          <div className="card card-tight">
            <Badge tone="teal">Improvement</Badge>
            <h4 className="mt-2 mb-1">Nothing clinical is gated</h4>
            <p className="small muted mb-0">
              Calculators, monographs and reference entries are free. The paid tier covers revision structure and practice
              administration only.
            </p>
          </div>
        </div>
      </section>

      <section className="section">
        <h2>Limitations, stated plainly</h2>
        <ul>
          <li>
            <strong>Corpus size.</strong> The reference product ships 418 monographs; this build publishes {DRUGS.length} fully
            cited entries. A dose that is absent is deliberately absent.
          </li>
          <li>
            <strong>Interface localisation only.</strong> The interface is available in English, Hindi and Spanish. Clinical
            content stays in English — a mistranslated dose instruction is a safety hazard, so translation waits for qualified
            review of each entry.
          </li>
          <li>
            <strong>Jurisdiction.</strong> Withdrawal intervals, prohibited substances and prescription status vary by country.
            The product label in your jurisdiction governs.
          </li>
          <li>
            <strong>No server by design.</strong> Records, reminders and study progress live in your browser. That is what makes
            it work offline; it also means clearing site data erases them.
          </li>
        </ul>
      </section>

      <Callout tone="warning" title="Not a substitute for clinical judgement">
        This is a reference for qualified veterinarians and for students working under supervision. It does not examine the
        patient, it does not know local prevalence, and it carries no responsibility for the decision. See the{' '}
        <Link to="/disclaimer">full disclaimer</Link>.
      </Callout>

      <section className="section">
        <h2>Coverage at a glance</h2>
        <div className="grid grid-4">
          {[
            { n: SPECIES.length, label: 'species' },
            { n: DRUGS.length, label: 'monographs' },
            { n: DISEASES.length, label: 'conditions' },
            { n: SIGNS.length, label: 'clinical signs' },
          ].map((s) => (
            <div key={s.label} className="card card-tight">
              <div className="stat-value">{s.n}</div>
              <div className="stat-label">{s.label}</div>
            </div>
          ))}
        </div>
      </section>
    </div>
  );
}
