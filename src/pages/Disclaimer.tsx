import { Link } from 'react-router-dom';
import { PageHeader, Callout, BackLink, PageFooter } from '../components/ui';

export default function Disclaimer() {
  return (
    <div className="container page" style={{ maxWidth: '860px' }}>
      <BackLink to="/" />
      <PageHeader eyebrow="Legal" title="Disclaimer" />

      <section className="section">
        <h2>Professional use only</h2>
        <p>
          VetMasterJi is a reference tool for qualified veterinarians and for veterinary students working under supervision. It
          is not a substitute for clinical training, clinical judgement, or the examination of an individual patient. The
          attending veterinarian remains solely responsible for every diagnostic and therapeutic decision.
        </p>
      </section>

      <section className="section">
        <h2>Confirm against the label</h2>
        <p>
          Dose rates, indications, contraindications and withdrawal intervals vary between products, formulations and
          jurisdictions. Before administering any medicine, confirm the dose against the product label supplied with the medicine
          you are actually holding, and against current national guidance. Where this reference and the label disagree, the label
          governs.
        </p>
      </section>

      <section className="section">
        <h2>Extra-label use</h2>
        <p>
          Some entries describe extra-label use, including doses carried over from another species where no species-specific
          dose is published — buffalo dosed as cattle is the common case. Extra-label use is a regulated act in most
          jurisdictions. Where you rely on a carry-over row, record the decision, inform the owner, and derive a withdrawal
          interval from a competent authority such as FARAD or the national residue scheme. An interval that is not established
          is not an interval of zero.
        </p>
      </section>

      <section className="section">
        <h2>Food-producing animals</h2>
        <p>
          Withdrawal intervals shown here are those published in the cited reference. They are not a guarantee of residue
          avoidance. Prohibited substances are flagged where the reference states prohibition; absence of a flag is not
          confirmation that a substance is permitted. You are responsible for compliance with the residue regulations that apply
          where you practise.
        </p>
      </section>

      <section className="section">
        <h2>Calculations</h2>
        <p>
          Every calculation is shown with its working so it can be checked by eye. The working is shown precisely because you
          should check it. A calculator transfers the arithmetic; it does not transfer responsibility for the inputs, and a
          decimal point in the wrong place produces a ten-fold error that no disclaimer can catch.
        </p>
      </section>

      <section className="section">
        <h2>Corpus completeness</h2>
        <p>
          Absence of a drug, a dose, a condition or an interaction from this reference is not evidence that it does not exist.
          The corpus is curated and finite; entries are added only when they can be cited. Where the assistant finds no match, it
          reports that as a bounded negative search over the curated corpus.
        </p>
      </section>

      <section className="section">
        <h2>Data and privacy</h2>
        <p>
          There is no server behind the clinical tools. Patient records, vaccination reminders, study progress and preferences
          are stored in your browser's local storage on your device. Nothing is uploaded, and clearing site data erases it
          permanently. Records held only in a browser are not a practice system of record.
        </p>
      </section>

      <section className="section">
        <h2>Emergencies</h2>
        <p>
          This reference is not for use in an emergency where delay costs lives. If an animal has collapsed, is struggling to
          breathe, is seizuring, or has ingested an unknown substance, contact an emergency veterinary service or an animal
          poison control centre immediately.
        </p>
      </section>

      <Callout tone="warning" title="In one sentence">
        Everything here is a starting point for a decision made by a veterinarian, in front of a patient, with the label in hand.
      </Callout>

      <p className="small muted mt-4">
        See <Link to="/about">sources &amp; method</Link> for how the content is compiled and cited.
      </p>
          <PageFooter />
    </div>
  );
}
