import type { ReactNode } from 'react';
import { Link } from 'react-router-dom';
import { referenceTitle } from '../data/references';

export function Card({
  children,
  className = '',
  as: Tag = 'div',
}: {
  children: ReactNode;
  className?: string;
  as?: 'div' | 'section' | 'article' | 'aside';
}) {
  return <Tag className={`card ${className}`}>{children}</Tag>;
}

export type CalloutTone = 'info' | 'warning' | 'danger' | 'success' | 'plain';

export function Callout({
  tone = 'plain',
  title,
  children,
  icon,
}: {
  tone?: CalloutTone;
  title?: string;
  children: ReactNode;
  icon?: string;
}) {
  const cls = tone === 'plain' ? 'callout' : `callout callout-${tone}`;
  const defaultIcon = tone === 'danger' ? '⛔' : tone === 'warning' ? '⚠️' : tone === 'success' ? '✅' : tone === 'info' ? 'ℹ️' : undefined;
  return (
    <div className={cls}>
      {title && (
        <div className="callout-title">
          {icon ?? defaultIcon ? <span aria-hidden="true">{icon ?? defaultIcon}</span> : null}
          <span>{title}</span>
        </div>
      )}
      {children}
    </div>
  );
}

export type BadgeTone = 'neutral' | 'teal' | 'amber' | 'red' | 'green' | 'blue';

export function Badge({ tone = 'neutral', children }: { tone?: BadgeTone; children: ReactNode }) {
  return <span className={`badge badge-${tone}`}>{children}</span>;
}

export function Chip({
  children,
  selected = false,
  onClick,
  className = '',
  small = false,
  title,
}: {
  children: ReactNode;
  selected?: boolean;
  onClick?: () => void;
  className?: string;
  small?: boolean;
  title?: string;
}) {
  const cls = `chip ${small ? 'small ' : ''}${className}`;
  if (!onClick) {
    return (
      <span className={`${cls} static`} title={title}>
        {children}
      </span>
    );
  }
  return (
    <button type="button" className={cls} aria-pressed={selected} onClick={onClick} title={title}>
      {children}
    </button>
  );
}

export function SectionTitle({ eyebrow, title, action, children }: { eyebrow?: string; title: string; action?: ReactNode; children?: ReactNode }) {
  return (
    <div className="section-head">
      <div>
        {eyebrow && <div className="eyebrow">{eyebrow}</div>}
        <h2 className="mb-0">{title}</h2>
        {children && <p className="lede mt-2 mb-0">{children}</p>}
      </div>
      {action}
    </div>
  );
}

export function Sources({ ids, label = 'Sources' }: { ids: string[]; label?: string }) {
  if (ids.length === 0) return null;
  const unique = [...new Set(ids)];
  return (
    <div className="source-list">
      <strong>{label}:</strong>
      {unique.map((id) => (
        <span key={id} className="source-tag">
          {referenceTitle(id)}
        </span>
      ))}
    </div>
  );
}

export function Disclaimer({ children }: { children?: ReactNode }) {
  return (
    <p className="disclaimer">
      {children ?? (
        <>
          Reference information for veterinarians and veterinary students. Confirm every dose against the product label, the
          individual patient and current national guidance. The attending veterinarian remains responsible for the decision. See{' '}
          <Link to="/disclaimer">the full disclaimer</Link>.
        </>
      )}
    </p>
  );
}

export function Empty({ title, children }: { title: string; children?: ReactNode }) {
  return (
    <div className="card center" style={{ padding: 'var(--space-7) var(--space-5)' }}>
      <h3 className="mb-2">{title}</h3>
      {children && <p className="muted mb-0">{children}</p>}
    </div>
  );
}

export function PageHeader({ eyebrow, title, lede, children }: { eyebrow?: string; title: string; lede?: string; children?: ReactNode }) {
  return (
    <header className="page-header">
      {eyebrow && <div className="eyebrow">{eyebrow}</div>}
      <h1 className="mb-2">{title}</h1>
      {lede && <p className="lede mb-0">{lede}</p>}
      {children}
    </header>
  );
}

export function Stat({ value, label }: { value: string; label: string }) {
  return (
    <div className="stat">
      <div className="stat-value">{value}</div>
      <div className="stat-label">{label}</div>
    </div>
  );
}

export function KeyValue({ items }: { items: [string, ReactNode][] }) {
  return (
    <dl className="kv">
      {items.map(([k, v], i) => (
        <div key={`${k}-${i}`} style={{ display: 'contents' }}>
          <dt>{k}</dt>
          <dd>{v}</dd>
        </div>
      ))}
    </dl>
  );
}

export function ToolCard({
  to,
  icon,
  title,
  description,
  badge,
}: {
  to: string;
  icon: string;
  title: string;
  description: string;
  badge?: string;
}) {
  return (
    <Link to={to} className="card card-tight" style={{ display: 'block', color: 'inherit' }}>
      <div className="row" style={{ justifyContent: 'space-between' }}>
        <span style={{ fontSize: '1.5rem' }} aria-hidden="true">
          {icon}
        </span>
        {badge && <Badge tone="amber">{badge}</Badge>}
      </div>
      <h3 className="mt-2 mb-1">{title}</h3>
      <p className="muted small mb-0">{description}</p>
      <span style={{ textDecoration: 'none' }} />
    </Link>
  );
}

/**
 * Page footer used on reference and tool pages, matching the reference site's
 * "Last reviewed <date> · VetMasterJi" line.
 */
export function PageFooter({ lastReviewed = '1 October 2026' }: { lastReviewed?: string }) {
  return (
    <p className="page-footer">
      Last reviewed {lastReviewed} · VetMasterJi
    </p>
  );
}

/** The "Back" affordance that opens every inner page on the reference site. */
export function BackLink({ to = '/', label = 'Back' }: { to?: string; label?: string }) {
  return (
    <div className="back-link">
      <Link to={to}>← {label}</Link>
    </div>
  );
}
