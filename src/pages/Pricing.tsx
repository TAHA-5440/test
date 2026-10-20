import { Link } from 'react-router-dom';
import { PageHeader, Callout, Badge } from '../components/ui';
import { usePreferences } from '../state/PreferencesContext';

const PLANS = [
  {
    id: 'free',
    name: 'Free',
    price: '₹0',
    period: 'forever',
    blurb: 'Every clinical tool, the full drug library, offline.',
    features: [
      'Drug calculator with all published monographs',
      'Fluid therapy planner',
      'Differential diagnosis ranker',
      'Interaction checker',
      'Reference ranges for 15 species',
      'Toxicology and antidotes',
      'Vaccination schedules',
      'Clinical notes, conditions and procedures',
      'Daily challenge and flashcards',
      'Works fully offline',
    ],
    cta: 'Start using it',
    to: '/drug-calculator',
    featured: false,
  },
  {
    id: 'student',
    name: 'Student Premium',
    price: '₹299',
    period: 'per month',
    blurb: 'Revision structure, streaks and the full case library.',
    features: [
      'Everything in Free',
      'Full case simulator library with scoring breakdowns',
      'NAVLE / BCSE style question drill with unlimited sets',
      'Spaced-repetition sync across your devices',
      'Personalised weak-topic report',
      'VetBands and the leaderboard',
      'Ad-free',
    ],
    cta: 'Choose Student',
    to: '/challenge',
    featured: false,
  },
  {
    id: 'clinic',
    name: 'Clinic',
    price: '₹1,499',
    period: 'per month, per practice',
    blurb: 'The practice layer: records, prescriptions and reminders.',
    features: [
      'Everything in Student Premium',
      'Patient records with consultation history',
      'Printable prescription pads with dose and withdrawal',
      'Vaccination and deworming reminders with overdue list',
      'Multi-user practice accounts (up to 5)',
      'Client-facing discharge notes',
      'Priority support',
    ],
    cta: 'Choose Clinic',
    to: '/clinic',
    featured: true,
  },
];

export default function Pricing() {
  const { mode } = usePreferences();

  return (
    <div className="container page">
      <PageHeader
        eyebrow="Pricing"
        title="Everything clinical is free"
        lede="The calculators, the drug library and the condition reference are free, offline and always will be. The paid plans add revision structure for students and the practice layer for clinics — never a dose behind a paywall."
      />

      <Callout tone="info" title="No dose is ever behind a paywall">
        A calculator that hides the answer from the person holding the syringe is a liability. Every dose in this product is
        visible on the free plan.
      </Callout>

      <div className="grid grid-3">
        {PLANS.map((p) => (
          <div key={p.id} className={`price-card ${p.featured ? 'featured' : ''}`}>
            {p.featured && (
              <div className="row mb-2">
                <Badge tone="amber">Most chosen by practices</Badge>
              </div>
            )}
            <h3 className="mb-1">{p.name}</h3>
            <p className="small muted mb-3">{p.blurb}</p>
            <div className="price-amount">{p.price}</div>
            <div className="price-period mb-3">{p.period}</div>
            <ul className="feature-list">
              {p.features.map((f) => (
                <li key={f}>
                  <span className="tick" aria-hidden="true">
                    ✓
                  </span>
                  <span>{f}</span>
                </li>
              ))}
            </ul>
            <div style={{ marginTop: 'auto' }}>
              <Link to={p.to} className={`btn ${p.featured ? 'btn-primary' : 'btn-secondary'} btn-block`}>
                {p.cta}
              </Link>
            </div>
          </div>
        ))}
      </div>

      <section className="section">
        <h2>Frequently asked</h2>
        <div className="grid grid-2">
          <div className="card card-tight">
            <h4 className="mb-1">Does the free plan really include every drug?</h4>
            <p className="small muted mb-0">
              Yes. All published monographs, all species rows, all withdrawal intervals and all calculators. The free plan is
              capped on revision features and practice features, never on clinical content.
            </p>
          </div>
          <div className="card card-tight">
            <h4 className="mb-1">Is there a student discount on the Clinic plan?</h4>
            <p className="small muted mb-0">
              Students should use the Student Premium plan — it is priced for that. Clinics with interns can add student seats at
              no extra cost.
            </p>
          </div>
          <div className="card card-tight">
            <h4 className="mb-1">What happens if I stop paying?</h4>
            <p className="small muted mb-0">
              You drop back to the free plan. Every dose, calculator and reference entry stays available; your records and
              spaced-repetition history are retained for 12 months.
            </p>
          </div>
          <div className="card card-tight">
            <h4 className="mb-1">Do you take a cut of prescriptions?</h4>
            <p className="small muted mb-0">
              No. There is no pharmaceutical advertising in this product and no sponsored placement in the drug library. The
              monographs are ordered alphabetically, not commercially.
            </p>
          </div>
        </div>
      </section>

      <Callout tone="warning" title="Payments are not connected in this build">
        This is a working reference implementation of the product surface. No payment processor is wired up and no card details
        are collected — the plan buttons take you to the corresponding part of the app so you can evaluate the features first.
      </Callout>

      {mode === 'student' && (
        <Callout tone="plain" title="You are in student mode">
          Student mode surfaces the revision tools on the home page. Switch to clinician mode in the header to see the practice
          view.
        </Callout>
      )}
    </div>
  );
}
