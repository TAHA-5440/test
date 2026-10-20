import { Link, useParams } from 'react-router-dom';
import { NOTE_MAP, NOTES } from '../data/notes';
import { SPECIES_ICON, speciesLabel } from '../data/species';
import type { SpeciesId } from '../types';
import { PageHeader, Callout, Badge, Empty, Sources, Disclaimer } from '../components/ui';

export default function NoteDetail() {
  const { id = '' } = useParams();
  const note = NOTE_MAP[id];

  if (!note) {
    return (
      <div className="container page">
        <Empty title="That note is not in the library">
          There are {NOTES.length} clinical notes. <Link to="/notes">Browse them all</Link>.
        </Empty>
      </div>
    );
  }

  const others = NOTES.filter((n) => n.id !== note.id && n.category === note.category).slice(0, 4);

  return (
    <div className="container page" style={{ maxWidth: '900px' }}>
      <nav className="small muted mb-3">
        <Link to="/notes">Clinical notes</Link> › <span>{note.category}</span>
      </nav>

      <PageHeader eyebrow={note.category} title={note.title} lede={note.summary} />

      <div className="row mb-4">
        {note.species.slice(0, 8).map((s) => (
          <Badge key={s} tone="neutral">
            {SPECIES_ICON[s as SpeciesId]} {speciesLabel(s as SpeciesId)}
          </Badge>
        ))}
        <Badge tone="teal">Reviewed {note.lastReviewed}</Badge>
      </div>

      {note.alerts.map((a) => (
        <Callout key={a} tone="warning" title="Alert">
          {a}
        </Callout>
      ))}

      <article>
        {note.sections.map((s) => (
          <section key={s.heading} className="section">
            <h2>{s.heading}</h2>
            {s.body.map((p, i) => (
              <p key={i}>{p}</p>
            ))}
            {s.table && (
              <div className="table-wrap">
                <table>
                  <thead>
                    <tr>
                      {s.table.head.map((h) => (
                        <th key={h}>{h}</th>
                      ))}
                    </tr>
                  </thead>
                  <tbody>
                    {s.table.rows.map((row, ri) => (
                      <tr key={ri}>
                        {row.map((cell, ci) => (
                          <td key={ci} className={ci > 0 ? 'mono' : undefined}>
                            {cell}
                          </td>
                        ))}
                      </tr>
                    ))}
                  </tbody>
                </table>
              </div>
            )}
          </section>
        ))}
      </article>

      <Sources ids={note.sources} />

      {others.length > 0 && (
        <section className="section">
          <h2>More in {note.category}</h2>
          <div className="stack-sm">
            {others.map((o) => (
              <Link key={o.id} to={`/notes/${o.id}`} className="btn btn-secondary btn-sm" style={{ justifyContent: 'flex-start' }}>
                {o.title}
              </Link>
            ))}
          </div>
        </section>
      )}

      <Disclaimer />
    </div>
  );
}
