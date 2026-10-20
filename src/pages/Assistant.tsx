import { useState } from 'react';
import { Link } from 'react-router-dom';
import { ask } from '../engine/assistant';
import type { AssistantAnswer } from '../engine/assistant';
import { SPECIES_ICON, speciesLabel } from '../data/species';
import type { SpeciesId } from '../types';
import { PageHeader, Callout, Chip, Badge, Disclaimer } from '../components/ui';
import { usePreferences } from '../state/PreferencesContext';
import { useI18n } from '../i18n';

const EXAMPLES = [
  'meloxicam dose for a dog',
  'how do I treat canine parvoviral enteritis',
  'the cat ate antifreeze',
  'what interacts with meloxicam',
  'how do I place an IV catheter in a dog',
  'normal creatinine for a cat',
];

const HREF: Record<string, string> = {
  drug: '/drugs',
  disease: '/diseases',
  note: '/notes',
  toxicology: '/toxicology',
  procedure: '/procedures',
  range: '/reference-ranges',
};

export default function Assistant() {
  const { t } = useI18n();
  const { species, setSpecies } = usePreferences();
  const [question, setQuestion] = useState('');
  const [answer, setAnswer] = useState<AssistantAnswer | null>(null);

  const submit = (q: string) => {
    const value = q.trim();
    if (!value) return;
    setAnswer(ask(value, species));
    setQuestion(value);
  };

  return (
    <div className="container page">
      <PageHeader eyebrow="Tool" title={t('assistant.title')} lede={t('assistant.subtitle')} />

      <div className="card mb-4">
        <div className="field">
          <label className="label" htmlFor="ask">
            Question
          </label>
          <div className="input-group">
            <input
              id="ask"
              className="input"
              placeholder={t('assistant.placeholder')}
              value={question}
              onChange={(e) => setQuestion(e.target.value)}
              onKeyDown={(e) => {
                if (e.key === 'Enter') submit(question);
              }}
              autoComplete="off"
            />
            <button type="button" className="btn btn-primary nowrap" onClick={() => submit(question)}>
              {t('assistant.ask')}
            </button>
          </div>
        </div>

        <div className="field mb-0">
          <span className="label">Species context</span>
          <div className="chip-row">
            {Object.entries(SPECIES_ICON).map(([s, icon]) => (
              <Chip key={s} small selected={s === species} onClick={() => setSpecies(s as SpeciesId)}>
                {icon} {speciesLabel(s as SpeciesId)}
              </Chip>
            ))}
          </div>
        </div>

        <div className="chip-row mt-4">
          {EXAMPLES.map((e) => (
            <Chip key={e} small onClick={() => submit(e)}>
              {e}
            </Chip>
          ))}
        </div>
      </div>

      {!answer ? (
        <Callout tone="info" title={t('assistant.empty')}>
          This is a deterministic retrieval engine over the curated corpus — not a generative model. If the answer is not in the
          library, it will tell you that rather than improvising a number.
        </Callout>
      ) : (
        <article className="card mb-4">
          <div className="row-between mb-3">
            <h2 className="mb-0">{answer.headline}</h2>
            <Badge tone="neutral">intent: {answer.intent}</Badge>
          </div>

          {answer.paragraphs.map((p, i) => (
            <p key={i}>{p}</p>
          ))}

          {answer.bullets.length > 0 && (
            <ul>
              {answer.bullets.map((b, i) => (
                <li key={i}>{b}</li>
              ))}
            </ul>
          )}

          {answer.evidence.length > 0 && (
            <>
              <h3 className="mb-2">{t('assistant.evidence')}</h3>
              <div className="stack-sm mb-4">
                {answer.evidence.map((e) => (
                  <Link
                    key={`${e.kind}-${e.id}`}
                    to={e.href ?? HREF[e.kind] ?? '/'}
                    className="rank-item"
                    style={{ color: 'inherit', display: 'block' }}
                  >
                    <div className="row-between mb-1">
                      <strong className="small">{e.title}</strong>
                      <Badge tone="neutral">{e.kind}</Badge>
                    </div>
                    <p className="small muted mb-0">{e.snippet}</p>
                  </Link>
                ))}
              </div>
            </>
          )}

          {answer.sources.length > 0 && (
            <>
              <h3 className="mb-2">{t('common.sources')}</h3>
              <div className="chip-row mb-4">
                {answer.sources.map((s) => (
                  <Chip key={s.id}>
                    {s.title}, {s.edition}
                  </Chip>
                ))}
              </div>
            </>
          )}

          <h3 className="mb-2">{t('assistant.caveats')}</h3>
          <ul className="small">
            {answer.caveats.map((c, i) => (
              <li key={i}>{c}</li>
            ))}
          </ul>

          <h3 className="mb-2">{t('assistant.followUps')}</h3>
          <div className="chip-row">
            {answer.followUps.map((f) => (
              <Chip key={f} small onClick={() => submit(f)}>
                {f}
              </Chip>
            ))}
          </div>
        </article>
      )}

      <Callout tone="warning" title="What this is not">
        The assistant does not generate text. It matches your question against the drug monographs, conditions, notes,
        toxicology entries, procedures and reference ranges, and returns the entry it found with the citation attached. That
        constraint is deliberate: a dose that cannot be traced to a reference is not safe to give.
      </Callout>

      <Disclaimer />
    </div>
  );
}
