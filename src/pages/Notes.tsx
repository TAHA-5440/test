import { useMemo, useState } from 'react';
import { Link } from 'react-router-dom';
import { NOTES, NOTE_CATEGORIES, searchNotes } from '../data/notes';
import { SPECIES_ICON } from '../data/species';
import { PageHeader, Chip, Badge, Empty, Callout, BackLink, PageFooter } from '../components/ui';

export default function Notes() {
  const [query, setQuery] = useState('');
  const [category, setCategory] = useState<string | null>(null);

  const results = useMemo(() => {
    const list = searchNotes(query);
    return category ? list.filter((n) => n.category === category) : list;
  }, [query, category]);

  return (
    <div className="container page">
      <BackLink to="/" />
      <PageHeader
        eyebrow="Reference"
        title="Clinical notes"
        lede="Short, sourced answers to the questions that come up at the consult table. Each note opens with the alerts that change management, then the detail — written to be read in ninety seconds."
      />

      <div className="card mb-4">
        <div className="field">
          <label className="label" htmlFor="note-search">
            Search notes
          </label>
          <input
            id="note-search"
            className="input"
            placeholder="e.g. dehydration, deworming, stewardship…"
            value={query}
            onChange={(e) => setQuery(e.target.value)}
            autoComplete="off"
          />
        </div>
        <div className="field mb-0">
          <span className="label">Category</span>
          <div className="chip-row">
            <Chip small selected={category === null} onClick={() => setCategory(null)}>
              All ({NOTES.length})
            </Chip>
            {NOTE_CATEGORIES.map((c) => {
              const n = NOTES.filter((x) => x.category === c).length;
              return n > 0 ? (
                <Chip key={c} small selected={category === c} onClick={() => setCategory(c)}>
                  {c} ({n})
                </Chip>
              ) : null;
            })}
          </div>
        </div>
      </div>

      {results.length === 0 ? (
        <Empty title="No note matches that search">Try a category chip, or search for a body system or a drug class.</Empty>
      ) : (
        <div className="grid grid-2">
          {results.map((n) => (
            <Link key={n.id} to={`/notes/${n.id}`} className="card card-tight" style={{ color: 'inherit', display: 'block' }}>
              <div className="row-between mb-2">
                <Badge tone="teal">{n.category}</Badge>
                <span className="tiny subtle">
                  {n.species.slice(0, 4).map((s) => SPECIES_ICON[s]).join(' ')}
                  {n.species.length > 4 ? ` +${n.species.length - 4}` : ''}
                </span>
              </div>
              <h3 className="mb-1">{n.title}</h3>
              <p className="small muted mb-3">{n.summary}</p>
              {n.alerts.length > 0 && (
                <Callout tone="warning" title="Alert">
                  <span className="small">{n.alerts[0]}</span>
                </Callout>
              )}
              <div className="row tiny subtle">
                <span>{n.sections.length} sections</span>
                <span>·</span>
                <span>Reviewed {n.lastReviewed}</span>
              </div>
            </Link>
          ))}
        </div>
      )}

      <Callout tone="plain" title="Written to be checked">
        Every note carries its sources at the bottom and a last-reviewed date. Where guidance differs between references, the
        note says which one it follows and why.
      </Callout>
          <PageFooter />
    </div>
  );
}
