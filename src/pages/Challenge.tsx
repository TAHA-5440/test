import { useMemo, useState } from 'react';
import { Link } from 'react-router-dom';
import { CHALLENGES, dailyChallenge, shuffledChallenges } from '../data/challenges';
import { speciesLabel } from '../data/species';
import type { SpeciesId } from '../types';
import { PageHeader, Callout, Badge, Chip, BackLink, PageFooter } from '../components/ui';
import { usePreferences, VET_BANDS } from '../state/PreferencesContext';

type Mode = 'daily' | 'drill';

export default function Challenge() {
  const { streak, recordChallenge, earnedBands } = usePreferences();
  const [mode, setMode] = useState<Mode>('daily');
  const [index, setIndex] = useState(0);
  const [picked, setPicked] = useState<number | null>(null);
  const [session, setSession] = useState({ correct: 0, answered: 0 });
  const [seed] = useState(() => Math.floor(Math.random() * 1_000_000));

  const questions = useMemo(
    () => (mode === 'daily' ? dailyChallenge() : shuffledChallenges(seed, 10)),
    [mode, seed],
  );

  const q = questions[index];

  const answer = (i: number) => {
    if (picked !== null) return;
    setPicked(i);
    const correct = i === q.answerIndex;
    recordChallenge(correct);
    setSession((s) => ({ correct: s.correct + (correct ? 1 : 0), answered: s.answered + 1 }));
  };

  const next = () => {
    setPicked(null);
    setIndex((i) => Math.min(i + 1, questions.length - 1));
  };

  const restart = () => {
    setPicked(null);
    setIndex(0);
    setSession({ correct: 0, answered: 0 });
  };

  const complete = index >= questions.length - 1 && picked !== null;
  const nextBand = VET_BANDS.find((b) => !b.test(streak));

  return (
    <div className="container page" style={{ maxWidth: '860px' }}>
      <BackLink to="/" />
      <PageHeader
        eyebrow="Study"
        title="Daily challenge"
        lede="Five questions a day, drawn deterministically from the question bank so everyone gets the same set. A continuous streak earns VetBands — the streak resets on a wrong answer, which is the point."
      />

      <div className="row mb-4">
        <Badge tone="amber">🔥 Streak {streak.streak}</Badge>
        <Badge tone="green">{streak.correct} correct</Badge>
        <Badge tone="neutral">{streak.challengesCompleted} answered</Badge>
        <Badge tone="blue">{streak.points} points</Badge>
        {earnedBands.length > 0 && (
          <Badge tone="green">
            {earnedBands[earnedBands.length - 1].icon} {earnedBands[earnedBands.length - 1].label}
          </Badge>
        )}
      </div>

      <div className="chip-row mb-4">
        <Chip selected={mode === 'daily'} onClick={() => { setMode('daily'); restart(); }}>
          Today’s five
        </Chip>
        <Chip selected={mode === 'drill'} onClick={() => { setMode('drill'); restart(); }}>
          Random drill (10)
        </Chip>
        <Chip onClick={restart}>Restart</Chip>
      </div>

      {!q ? (
        <Callout tone="info" title="No questions available">The question bank is empty.</Callout>
      ) : (
        <>
          <div className="row-between mb-3">
            <span className="badge badge-teal">
              Question {index + 1} of {questions.length}
            </span>
            <span className="tiny subtle">
              {q.topic} · {q.species === 'all' ? 'All species' : speciesLabel(q.species as SpeciesId)} · session{' '}
              {session.correct}/{session.answered}
            </span>
          </div>

          <section className="card mb-4">
            <h2 className="mb-4">{q.prompt}</h2>
            <div className="stack">
              {q.options.map((opt, i) => {
                const isAnswer = i === q.answerIndex;
                const isPicked = picked === i;
                const revealed = picked !== null;
                return (
                  <button
                    key={opt}
                    type="button"
                    className="btn btn-secondary"
                    disabled={revealed}
                    onClick={() => answer(i)}
                    style={{
                      justifyContent: 'flex-start',
                      textAlign: 'left',
                      height: 'auto',
                      padding: 'var(--space-4)',
                      borderColor: revealed && isAnswer ? 'var(--success)' : revealed && isPicked ? 'var(--danger)' : undefined,
                      opacity: revealed && !isAnswer && !isPicked ? 0.6 : 1,
                    }}
                  >
                    <span>
                      <strong>
                        {String.fromCharCode(65 + i)}. {opt}
                      </strong>
                      {revealed && isPicked && (
                        <span className="badge badge-neutral" style={{ marginLeft: 8 }}>
                          your answer
                        </span>
                      )}
                    </span>
                  </button>
                );
              })}
            </div>

            {picked !== null && (
              <Callout tone={picked === q.answerIndex ? 'success' : 'danger'} title={picked === q.answerIndex ? 'Correct' : 'Not this time'}>
                <p>{q.explanation}</p>
                <p className="tiny subtle mb-0">Source: {q.source}</p>
              </Callout>
            )}

            <div className="row-between mt-4">
              <span className="small muted">
                {picked === null ? 'Choose an answer.' : complete ? 'Set complete.' : 'Continue to the next question.'}
              </span>
              {picked !== null && !complete && (
                <button type="button" className="btn btn-primary" onClick={next}>
                  Next question
                </button>
              )}
              {complete && (
                <button type="button" className="btn btn-primary" onClick={restart}>
                  Run another set
                </button>
              )}
            </div>
          </section>

          {complete && (
            <section className="card mb-4">
              <h2 className="mb-3">Set complete</h2>
              <div className="dose-total">
                {Math.round((session.correct / questions.length) * 100)}%
              </div>
              <p className="muted mt-2 mb-0">
                {session.correct} of {questions.length} correct in this set. Your running streak is {streak.streak}.
              </p>
            </section>
          )}
        </>
      )}

      <section className="card mb-4">
        <h2 className="mb-3">VetBands</h2>
        <p className="small muted">
          Bands are earned on total correct answers across all sessions. A wrong answer resets the streak but not the band.
        </p>
        <div className="grid grid-3">
          {VET_BANDS.map((b) => {
            const earned = earnedBands.some((e) => e.id === b.id);
            return (
              <div
                key={b.id}
                className="card card-tight"
                style={{ background: earned ? 'var(--success-bg)' : 'var(--surface-2)', borderColor: earned ? 'var(--success-border)' : undefined }}
              >
                <div style={{ fontSize: '1.4rem' }} aria-hidden="true">
                  {b.icon}
                </div>
                <strong className="small">{b.label}</strong>
                <div className="tiny subtle">{b.description}</div>
              </div>
            );
          })}
        </div>
        {nextBand && (
          <p className="small muted mt-3 mb-0">
            Next band: <strong>{nextBand.label}</strong> — {nextBand.description}. You have {streak.correct} correct answers.
          </p>
        )}
      </section>

      <Callout tone="plain" title="Where the questions come from">
        {CHALLENGES.length} questions, each with a cited explanation. The bank is deterministic: the daily set is selected by day
        of year, so a study group all working on the same day gets the same five questions. Other revision:{' '}
        <Link to="/flashcards">flashcards</Link> and the <Link to="/cases">case simulator</Link>.
      </Callout>
          <PageFooter />
    </div>
  );
}
