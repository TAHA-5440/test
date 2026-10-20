import { useMemo, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import { CASE_MAP, CASES, maxScoreForCase } from '../data/cases';
import { SPECIES_ICON, speciesLabel } from '../data/species';
import type { SpeciesId } from '../types';
import { PageHeader, Callout, Badge, Empty, Sources, Disclaimer } from '../components/ui';
import { usePreferences } from '../state/PreferencesContext';

interface Answer {
  stepId: string;
  optionIndex: number;
  score: number;
}

export default function CasePlayer() {
  const { id = '' } = useParams();
  const studyCase = CASE_MAP[id];
  const { recordCase } = usePreferences();

  const [stepIndex, setStepIndex] = useState(0);
  const [answers, setAnswers] = useState<Answer[]>([]);
  const [finished, setFinished] = useState(false);

  const max = useMemo(() => (studyCase ? maxScoreForCase(studyCase) : 0), [studyCase]);
  const scored = useMemo(() => answers.reduce((s, a) => s + a.score, 0), [answers]);

  if (!studyCase) {
    return (
      <div className="container page">
        <Empty title="That case does not exist">
          There are {CASES.length} cases available. <Link to="/cases">Choose one</Link>.
        </Empty>
      </div>
    );
  }

  const step = studyCase.steps[stepIndex];
  const isLast = stepIndex >= studyCase.steps.length - 1;
  const answered = answers.find((a) => a.stepId === step.id);
  const percent = max > 0 ? Math.round((scored / max) * 100) : 0;

  const choose = (index: number) => {
    if (answered) return;
    const option = step.options[index];
    const next = [...answers, { stepId: step.id, optionIndex: index, score: option.score }];
    setAnswers(next);
    if (isLast) {
      setFinished(true);
      recordCase();
    }
  };

  const reset = () => {
    setAnswers([]);
    setStepIndex(0);
    setFinished(false);
  };

  return (
    <div className="container page" style={{ maxWidth: '920px' }}>
      <nav className="small muted mb-3">
        <Link to="/cases">Cases</Link> › <span>{studyCase.system}</span>
      </nav>

      <PageHeader eyebrow={`${studyCase.difficulty} · ${studyCase.system}`} title={studyCase.title} />

      <div className="row mb-4">
        <Badge tone="neutral">
          {SPECIES_ICON[studyCase.species as SpeciesId]} {speciesLabel(studyCase.species as SpeciesId)}
        </Badge>
        <Badge tone="neutral">{studyCase.signalment}</Badge>
        <Badge tone="teal">
          {scored} / {max} points
        </Badge>
      </div>

      <section className="card mb-4">
        <h2 className="mb-3">Presenting complaint</h2>
        <p>{studyCase.presenting}</p>
        <p className="tiny subtle mb-0">Case prepared by {studyCase.clinician}.</p>
      </section>

      <section className="card mb-4">
        <h2 className="mb-3">Vitals on presentation</h2>
        <div className="grid grid-4">
          {studyCase.vitals.map((v) => (
            <div key={v.label} className="card card-tight" style={{ background: 'var(--surface-2)' }}>
              <div className="tiny subtle">{v.label}</div>
              <div style={{ fontWeight: 700, fontSize: '1.05rem' }}>{v.value}</div>
              {v.flag && v.flag !== 'normal' && (
                <Badge tone={v.flag === 'high' ? 'red' : 'blue'}>{v.flag === 'high' ? 'High' : 'Low'}</Badge>
              )}
            </div>
          ))}
        </div>
      </section>

      {!finished ? (
        <section className="card mb-4">
          <div className="row-between mb-3">
            <span className="badge badge-teal">
              Step {stepIndex + 1} of {studyCase.steps.length} · {step.phase}
            </span>
            <span className="tiny subtle">
              {answers.length} of {studyCase.steps.length} answered
            </span>
          </div>

          <h2 className="mb-2">{step.prompt}</h2>
          <p className="muted">{step.detail}</p>

          {answered && step.findings && step.findings.length > 0 && (
            <Callout tone="info" title="What you find">
              <ul className="mb-0">
                {step.findings.map((f) => (
                  <li key={f}>{f}</li>
                ))}
              </ul>
            </Callout>
          )}

          <div className="stack mt-3">
            {step.options.map((opt, i) => {
              const isChosen = answered?.optionIndex === i;
              const best = Math.max(...step.options.map((o) => o.score));
              const showResult = Boolean(answered);
              return (
                <button
                  key={opt.label}
                  type="button"
                  className="btn btn-secondary"
                  disabled={Boolean(answered)}
                  onClick={() => choose(i)}
                  style={{
                    justifyContent: 'flex-start',
                    textAlign: 'left',
                    height: 'auto',
                    padding: 'var(--space-4)',
                    borderColor: showResult && opt.score === best ? 'var(--success)' : showResult && isChosen ? 'var(--danger)' : undefined,
                    opacity: showResult && opt.score < best && !isChosen ? 0.6 : 1,
                  }}
                >
                  <span style={{ display: 'block', width: '100%' }}>
                    <strong>{opt.label}</strong>
                    {showResult && (
                      <>
                        <span className="badge badge-neutral ml-2" style={{ marginLeft: 8 }}>
                          {opt.score} / {best}
                        </span>
                        <div className="small muted mt-2 mb-0" style={{ whiteSpace: 'normal' }}>
                          {opt.feedback}
                        </div>
                      </>
                    )}
                  </span>
                </button>
              );
            })}
          </div>

          {answered && (
            <div className="row-between mt-4">
              <span className="small muted">
                {answered.score === Math.max(...step.options.map((o) => o.score))
                  ? 'Best available choice.'
                  : 'Review the feedback above before continuing.'}
              </span>
              {!isLast ? (
                <button type="button" className="btn btn-primary" onClick={() => setStepIndex((i) => i + 1)}>
                  Next step
                </button>
              ) : (
                <button type="button" className="btn btn-primary" onClick={() => { setFinished(true); recordCase(); }}>
                  See your result
                </button>
              )}
            </div>
          )}
        </section>
      ) : (
        <section className="card mb-4">
          <h2 className="mb-3">Result</h2>
          <div className="dose-panel mb-4">
            <div className="tiny" style={{ fontWeight: 700, letterSpacing: '0.06em', textTransform: 'uppercase', color: 'var(--teal-700)' }}>
              Score
            </div>
            <div className="dose-total">
              {percent}%<span style={{ fontSize: '1.1rem', fontWeight: 600, color: 'var(--text-muted)' }}> · {scored} of {max}</span>
            </div>
            <div className="confidence-bar mt-3" style={{ height: '10px' }}>
              <div
                className={`confidence-fill ${percent >= 70 ? '' : percent >= 40 ? 'medium' : 'low'}`}
                style={{ width: `${Math.max(4, percent)}%` }}
              />
            </div>
            <p className="small muted mt-3 mb-0">
              {percent >= 85
                ? 'Strong performance — you identified the discriminating findings and acted on them in order.'
                : percent >= 60
                  ? 'Sound management with gaps. Read the takeaways below and note which decision cost you the most.'
                  : 'Work through the takeaways and re-run the case. The order of intervention is usually where the marks are lost.'}
            </p>
          </div>

          <h3 className="mb-2">Takeaways</h3>
          <ul>
            {studyCase.takeaways.map((t) => (
              <li key={t}>{t}</li>
            ))}
          </ul>

          <h3 className="mb-2 mt-4">Your decisions</h3>
          <div className="stack-sm">
            {answers.map((a, i) => {
              const s = studyCase.steps[i];
              const opt = s?.options[a.optionIndex];
              const best = Math.max(...s.options.map((o) => o.score));
              if (!opt) return null;
              return (
                <div key={a.stepId} className="rank-item">
                  <div className="row-between mb-1">
                    <strong className="small">
                      {i + 1}. {s.prompt}
                    </strong>
                    <Badge tone={a.score === best ? 'green' : a.score === 0 ? 'red' : 'amber'}>
                      {a.score} / {best}
                    </Badge>
                  </div>
                  <p className="small muted mb-0">You chose: {opt.label}</p>
                </div>
              );
            })}
          </div>

          <div className="row mt-4">
            <button type="button" className="btn btn-primary" onClick={reset}>
              Run the case again
            </button>
            <Link to="/cases" className="btn btn-secondary">
              Another case
            </Link>
          </div>
        </section>
      )}

      <Sources ids={studyCase.sources} />
      <Disclaimer />
    </div>
  );
}
