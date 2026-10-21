import { useState } from 'react';
import { Link } from 'react-router-dom';
import { BackLink, PageFooter, Callout } from '../components/ui';

type Plan = 'student' | 'clinician';

const BILLING = [
  'Plans renew automatically at the end of each billing period, at the plan’s price at that time, until you cancel. One-time discounts (the extra 10% offer and single-use coupons) apply only to the first payment — those purchases are sold as a prepaid period and don’t renew.',
  'Cancel anytime from the Subscription page (Profile → Subscription). Cancelling stops the next renewal, and you keep Premium until the end of the period you’ve already paid for.',
  'Fees for a period that has already started aren’t refunded pro rata. Read the Refund & Cancellation Policy',
  'Prices in US dollars ($), paid through Stripe.',
];

const CLINICIAN_FEATURES = [
  'Complete Patient Record Management',
  'Unlimited Patient Records',
  'Digital Medical Records (EMR)',
  'My Clinic Dashboard',
  'Prescription PDF Generator',
  'Vaccination Management',
  'Deworming Management',
  'Referral Letters',
  'Discharge Summaries',
  'Billing & Invoice Management',
  'Clinic Analytics',
  'Withdrawal Period Calculator',
  'AI Clinical Assistant',
  'Secure Cloud Backup',
  'Future Clinician Features Included',
];

const PREMIUM_INCLUDES = [
  {
    title: 'Unlimited FREE AI Clinical Cases',
    body: 'Every specialty — small animal, large animal, medicine, surgery, gynecology — with no VetBands deducted, ever. On the free plan the first 5 are free, then 25 VetBands each.',
  },
  {
    title: '50% OFF AI Mentor — 25 VetBands instead of 50',
    body: 'Unlocked after you finish an AI Clinical Case: detailed clinical guidance, reasoning, decision-making and feedback — at half the free-plan price.',
  },
];

const SAVINGS = [
  { tag: '100% OFF', name: 'AI Clinical Cases', from: '25 VetBands', to: 'FREE' },
  { tag: 'SAVE 50%', name: 'AI Mentor', from: '50 VetBands', to: '25 VetBands' },
  { tag: '100% OFF', name: 'Professional Clinical Cases', from: '25 VetBands', to: 'FREE' },
  { tag: '100% OFF', name: 'Differential Diagnosis', from: '10 VetBands', to: 'FREE' },
  { tag: 'UNLIMITED', name: 'Clinical Notes', from: '20 VetBands/day', to: 'Unlimited' },
  { tag: 'UNLIMITED', name: 'Clinical Videos', from: '20 VetBands/day', to: 'Unlimited' },
];

const COMPARE: { feature: string; free: string; premium: string; note?: string }[] = [
  { feature: 'AI Clinical Cases', free: 'First 5 FREE, then 25 VetBands / Case', premium: 'Unlimited FREE' },
  { feature: 'AI Mentor', free: '50 VetBands', premium: '25 VetBands', note: '50% OFF' },
  { feature: 'Daily Quiz', free: 'Free', premium: 'Unlimited' },
  { feature: 'BCSE Quiz', free: 'Free', premium: 'Unlimited' },
  { feature: 'Drug Dose Calculator', free: 'Free', premium: 'Unlimited' },
  { feature: 'Fluid Therapy Calculator', free: 'Free', premium: 'Unlimited' },
  { feature: 'Differential Diagnosis', free: '10 VetBands / Use', premium: 'Unlimited FREE' },
  { feature: 'Clinical Notes', free: '20 VetBands / Day', premium: 'Unlimited' },
  { feature: 'Clinical Videos', free: '20 VetBands / Day', premium: 'Unlimited' },
  { feature: 'Professional Clinical Cases', free: '25 VetBands / Case', premium: 'Unlimited FREE' },
  { feature: 'AI Clinical Images', free: 'Included', premium: 'Included' },
  { feature: 'Priority AI Responses', free: '', premium: 'Included' },
  { feature: 'Ad-Free Experience', free: '', premium: 'Included' },
  { feature: 'Large Animal Support', free: 'Limited', premium: 'Full Access' },
  { feature: 'Premium Clinical Features', free: '', premium: 'Included' },
  { feature: 'Future Premium Features', free: '', premium: 'Included Automatically' },
];

export default function Pricing() {
  const [plan, setPlan] = useState<Plan>('student');

  return (
    <div className="container page">
      <BackLink to="/" />

      <div className="row-between mb-5">
        <div className="row">
          <span aria-hidden="true">🇺🇸</span>
          <strong className="small">United States</strong>
          <span className="small muted">$ USD</span>
          <button type="button" className="btn btn-ghost btn-sm">
            Change
          </button>
        </div>
      </div>

      <header className="page-header center">
        <h1>Invest in your clinical mastery</h1>
        <p className="lede" style={{ margin: '0 auto' }}>
          One plan. Every species. Unlimited learning — built for real veterinarians in the field.
        </p>
      </header>

      <div className="row mb-6" style={{ justifyContent: 'center' }}>
        <button type="button" className="chip" aria-pressed={plan === 'student'} onClick={() => setPlan('student')}>
          Student Premium
        </button>
        <button type="button" className="chip" aria-pressed={plan === 'clinician'} onClick={() => setPlan('clinician')}>
          Clinician Premium
        </button>
      </div>

      <section className="section">
        <h2>Billing, renewal &amp; cancellation</h2>
        <ul>
          {BILLING.map((b) => (
            <li key={b}>{b}</li>
          ))}
        </ul>
      </section>

      <section className="section alt">
        <div className="grid grid-2">
          <div>
            <div className="eyebrow">Complete Clinical Management System</div>
            <h2>🏥 Clinician Premium</h2>
            <p>
              Everything in Student Premium, <strong>plus a complete veterinary clinical management system</strong> — patient
              records, EMR, prescriptions, vaccinations, billing, and clinic analytics in one place.
            </p>
          </div>
          <div>
            <div className="eyebrow">Complete Patient Record Management</div>
            <ul className="feature-list">
              {CLINICIAN_FEATURES.map((f) => (
                <li key={f}>
                  <span className="tick">✓</span>
                  <span>{f}</span>
                </li>
              ))}
            </ul>
            <Link to="/clinic" className="btn btn-primary">
              See Clinician Premium plans →
            </Link>
          </div>
        </div>
      </section>

      <section className="section">
        <h2>Premium Includes</h2>
        <p className="lede">Two benefits that change how much you use the app, on top of everything below.</p>
        <div className="grid grid-2">
          {PREMIUM_INCLUDES.map((p) => (
            <div key={p.title} className="card">
              <h3 className="mb-2">{p.title}</h3>
              <p className="small muted mb-0">{p.body}</p>
            </div>
          ))}
        </div>
      </section>

      <section className="section alt">
        <h2>Premium pays for itself</h2>
        <p className="lede">What you stop paying for the moment you upgrade.</p>
        <div className="grid grid-3">
          {SAVINGS.map((s) => (
            <div key={s.name} className="card card-tight">
              <span className="badge badge-amber">{s.tag}</span>
              <h4 className="mt-2 mb-1">{s.name}</h4>
              <p className="small muted mb-0">
                <span style={{ textDecoration: 'line-through' }}>{s.from}</span> ➜ <strong>{s.to}</strong>
              </p>
            </div>
          ))}
        </div>
      </section>

      <section className="section">
        <h2>Compare plans</h2>
        <p className="lede">Everything in Free stays free. Premium removes every limit that slows you down.</p>
        <div className="table-wrap">
          <table>
            <thead>
              <tr>
                <th>Feature</th>
                <th>Free</th>
                <th>Premium</th>
              </tr>
            </thead>
            <tbody>
              {COMPARE.map((c) => (
                <tr key={c.feature}>
                  <td>
                    <strong>{c.feature}</strong>
                  </td>
                  <td className="small">{c.free || '—'}</td>
                  <td className="small">
                    <strong>{c.premium}</strong>
                    {c.note && (
                      <>
                        {' '}
                        <span className="badge badge-amber">{c.note}</span>
                      </>
                    )}
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        <p className="small muted">
          On the free plan, your first 5 AI Clinical Cases are free — then 25 VetBands each.
        </p>
        <p className="small muted">
          The 5 free cases are shared across every specialty, not 5 per specialty. Premium removes the charge entirely — AI
          Clinical Cases are unlimited and free, and the AI Mentor drops from 50 VetBands to half price.
        </p>
      </section>

      <section className="section">
        <div className="grid grid-3">
          <div className="card card-tight">
            <h4 className="mb-1">Instant Access</h4>
            <p className="small muted mb-0">Get started immediately after upgrading.</p>
          </div>
          <div className="card card-tight">
            <h4 className="mb-1">Secure Payments</h4>
            <p className="small muted mb-0">Your data is protected with industry standards.</p>
          </div>
          <div className="card card-tight">
            <h4 className="mb-1">Expert Content</h4>
            <p className="small muted mb-0">All cases verified by senior clinicians.</p>
          </div>
        </div>
      </section>

      <Callout tone="warning" title="Payments are not connected in this build">
        This is a working reference implementation of the product surface. No payment processor is wired up and no card details
        are collected.
      </Callout>

      <PageFooter />
    </div>
  );
}
