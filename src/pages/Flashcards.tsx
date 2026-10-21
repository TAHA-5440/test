import { useMemo, useState } from 'react';
import { Link } from 'react-router-dom';
import { CHALLENGES } from '../data/challenges';
import { DRUGS } from '../data/drugs';
import { PageHeader, Callout, Badge, Chip, Empty, BackLink, PageFooter } from '../components/ui';

type Deck = 'questions' | 'drugs';

interface CardState {
  box: number;
  due: number;
}

const STORE_KEY = 'vetmasterji:flashcards:v1';

function readState(): Record<string, CardState> {
  try {
    const raw = window.localStorage.getItem(STORE_KEY);
    return raw ? (JSON.parse(raw) as Record<string, CardState>) : {};
  } catch {
    return {};
  }
}

function writeState(state: Record<string, CardState>): void {
  try {
    window.localStorage.setItem(STORE_KEY, JSON.stringify(state));
  } catch {
    /* storage unavailable — the deck still works for this session */
  }
}

/** Leitner intervals in days, by box. */
const INTERVAL_DAYS = [0, 1, 3, 7, 16, 35];

export default function Flashcards() {
  const [deck, setDeck] = useState<Deck>('questions');
  const [state, setState] = useState<Record<string, CardState>>(() => readState());
  const [index, setIndex] = useState(0);
  const [revealed, setRevealed] = useState(false);
  const [sessionStats, setSessionStats] = useState({ again: 0, good: 0, easy: 0 });

  const cards = useMemo(() => {
    if (deck === 'questions') {
      return CHALLENGES.map((q) => ({
        id: q.id,
        front: q.prompt,
        back: `${q.options[q.answerIndex]}\n\n${q.explanation}`,
        tag: q.topic,
        to: '/challenge',
      }));
    }
    return DRUGS.map((d) => ({
      id: `drug-${d.id}`,
      front: `${d.name} (${d.className}) — what is it used for, and what is the headline dose?`,
      back: d.doses
        .slice(0, 3)
        .map((r) => `${r.species}: ${r.indication} — ${r.doseLow ?? '—'}–${r.doseHigh ?? '—'} ${r.unit} ${r.route} ${r.frequency}`)
        .join('\n') + `\n\n${d.pearls[0] ?? d.summary}`,
      tag: d.className,
      to: `/drugs/${d.id}`,
    }));
  }, [deck]);

  const due = useMemo(() => {
    const now = Date.now();
    return cards.filter((c) => {
      const s = state[c.id];
      if (!s) return true;
      return s.due <= now;
    });
  }, [cards, state]);

  const card = due[index] ?? due[0];

  const grade = (result: 'again' | 'good' | 'easy') => {
    if (!card) return;
    const current = state[card.id]?.box ?? 0;
    const box = result === 'again' ? 0 : Math.min(current + (result === 'easy' ? 2 : 1), INTERVAL_DAYS.length - 1);
    const days = INTERVAL_DAYS[box];
    const next = { ...state, [card.id]: { box, due: Date.now() + days * 86_400_000 } };
    setState(next);
    writeState(next);
    setSessionStats((s) => ({ ...s, [result]: s[result] + 1 }));
    setRevealed(false);
    setIndex((i) => (i + 1) % Math.max(1, due.length));
  };

  const resetDeck = () => {
    setState({});
    writeState({});
    setIndex(0);
    setRevealed(false);
    setSessionStats({ again: 0, good: 0, easy: 0 });
  };

  const boxCounts = useMemo(() => {
    const counts = new Array(INTERVAL_DAYS.length).fill(0);
    for (const c of cards) counts[state[c.id]?.box ?? 0] += 1;
    return counts;
  }, [cards, state]);

  return (
    <div className="container page" style={{ maxWidth: '860px' }}>
      <BackLink to="/" />
      <PageHeader
        eyebrow="Study"
        title="Flashcards"
        lede="A Leitner box over the question bank and the drug library. Cards you keep getting right move to longer intervals; anything you miss goes back to tomorrow."
      />

      <div className="chip-row mb-4">
        <Chip selected={deck === 'questions'} onClick={() => { setDeck('questions'); setIndex(0); setRevealed(false); }}>
          Question bank ({CHALLENGES.length})
        </Chip>
        <Chip selected={deck === 'drugs'} onClick={() => { setDeck('drugs'); setIndex(0); setRevealed(false); }}>
          Drug library ({DRUGS.length})
        </Chip>
        <Chip onClick={resetDeck}>Reset progress</Chip>
      </div>

      <div className="row mb-4">
        <Badge tone="teal">{due.length} due now</Badge>
        <Badge tone="neutral">{cards.length - due.length} scheduled later</Badge>
        <Badge tone="green">{sessionStats.good + sessionStats.easy} kept</Badge>
        <Badge tone="amber">{sessionStats.again} back to box 1</Badge>
      </div>

      {!card ? (
        <Empty title="Nothing due in this deck">
          Every card is scheduled. Reset progress to bring them all back, or switch deck.
        </Empty>
      ) : (
        <section className="card mb-4">
          <div className="row-between mb-3">
            <Badge tone="neutral">{card.tag}</Badge>
            <span className="tiny subtle">
              box {(state[card.id]?.box ?? 0) + 1} of {INTERVAL_DAYS.length}
            </span>
          </div>

          <h2 className="mb-4">{card.front}</h2>

          {revealed ? (
            <>
              <div className="callout callout-info" style={{ whiteSpace: 'pre-wrap' }}>
                {card.back}
              </div>
              <div className="row">
                <button type="button" className="btn btn-danger" onClick={() => grade('again')}>
                  Again — tomorrow
                </button>
                <button type="button" className="btn btn-secondary" onClick={() => grade('good')}>
                  Good
                </button>
                <button type="button" className="btn btn-primary" onClick={() => grade('easy')}>
                  Easy — skip ahead
                </button>
              </div>
            </>
          ) : (
            <div className="row">
              <button type="button" className="btn btn-primary" onClick={() => setRevealed(true)}>
                Reveal answer
              </button>
              <Link to={card.to} className="btn btn-secondary">
                Open the source entry
              </Link>
            </div>
          )}
        </section>
      )}

      <section className="card mb-4">
        <h2 className="mb-3">Deck distribution</h2>
        <div className="stack-sm">
          {boxCounts.map((count, i) => (
            <div key={i} className="row" style={{ gap: 'var(--space-3)' }}>
              <div style={{ width: '110px', flexShrink: 0 }} className="small">
                Box {i + 1} · {INTERVAL_DAYS[i]} d
              </div>
              <div style={{ flex: 1, height: '8px', background: 'var(--bg-sunken)', borderRadius: '999px', overflow: 'hidden' }}>
                <div
                  style={{
                    width: `${cards.length ? (count / cards.length) * 100 : 0}%`,
                    height: '100%',
                    background: 'var(--teal-600)',
                  }}
                />
              </div>
              <span className="tiny mono subtle" style={{ width: '40px' }}>
                {count}
              </span>
            </div>
          ))}
        </div>
      </section>

      <Callout tone="plain" title="Progress stays on the device">
        Card scheduling is stored in your browser's local storage. Clearing site data resets the deck, and nothing is uploaded.
      </Callout>
          <PageFooter />
    </div>
  );
}
