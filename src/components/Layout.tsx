import { NavLink, Link, Outlet, useLocation } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { usePreferences } from '../state/PreferencesContext';
import { LANGUAGES, useI18n } from '../i18n';

const NAV = [
  { to: '/tools', key: 'nav.tools' },
  { to: '/drugs', key: 'nav.drugs' },
  { to: '/diseases', key: 'nav.diseases' },
  { to: '/notes', key: 'nav.notes' },
  { to: '/cases', key: 'nav.cases' },
  { to: '/procedures', key: 'nav.procedures' },
  { to: '/assistant', key: 'nav.assistant' },
  { to: '/pricing', key: 'nav.pricing' },
];

const FOOTER = [
  {
    title: 'Clinical tools',
    links: [
      { to: '/drug-calculator', label: 'Drug calculator' },
      { to: '/fluid-therapy', label: 'Fluid therapy' },
      { to: '/diagnose', label: 'Differential diagnosis' },
      { to: '/interactions', label: 'Interaction checker' },
      { to: '/reference-ranges', label: 'Reference ranges' },
      { to: '/toxicology', label: 'Toxicology' },
    ],
  },
  {
    title: 'Reference',
    links: [
      { to: '/drugs', label: 'Drug library' },
      { to: '/diseases', label: 'Conditions' },
      { to: '/notes', label: 'Clinical notes' },
      { to: '/procedures', label: 'Procedures' },
      { to: '/vaccinations', label: 'Vaccination schedules' },
      { to: '/about', label: 'Sources & method' },
    ],
  },
  {
    title: 'Learn',
    links: [
      { to: '/cases', label: 'Case simulator' },
      { to: '/challenge', label: 'Daily challenge' },
      { to: '/flashcards', label: 'Flashcards' },
      { to: '/assistant', label: 'Clinical assistant' },
      { to: '/clinic', label: 'Practice records' },
    ],
  },
  {
    title: 'Company',
    links: [
      { to: '/pricing', label: 'Pricing' },
      { to: '/disclaimer', label: 'Disclaimer' },
      { to: '/about', label: 'About' },
    ],
  },
];

export default function Layout() {
  const { theme, toggleTheme, language, setLanguage, mode, setMode, online, earnedBands } = usePreferences();
  const { t } = useI18n();
  const { pathname } = useLocation();
  const [langOpen, setLangOpen] = useState(false);

  useEffect(() => {
    window.scrollTo({ top: 0, behavior: 'auto' });
  }, [pathname]);

  useEffect(() => {
    setLangOpen(false);
  }, [pathname]);

  const topBand = earnedBands[earnedBands.length - 1];

  return (
    <div className="app-shell">
      <a href="#content" className="sr-only">
        Skip to content
      </a>
      <header className="site-header">
        <div className="container header-inner">
          <Link to="/" className="brand">
            <span className="brand-mark" aria-hidden="true">
              VM
            </span>
            <span>
              Vet<span style={{ color: 'var(--teal-600)' }}>Master</span>Ji
            </span>
          </Link>

          <nav className="nav" aria-label="Primary">
            {NAV.map((item) => (
              <NavLink
                key={item.to}
                to={item.to}
                className={({ isActive }) => (isActive ? 'nav-link active' : 'nav-link')}
              >
                {t(item.key)}
              </NavLink>
            ))}
          </nav>

          <div className="header-actions">
            {topBand && (
              <span className="bands-pill" title={`${topBand.label} VetBand — ${topBand.description}`}>
                <span aria-hidden="true">{topBand.icon}</span>
                <span className="hide-sm">{topBand.label}</span>
              </span>
            )}

            <div style={{ position: 'relative' }}>
              <button
                type="button"
                className="icon-button"
                onClick={() => setLangOpen((o) => !o)}
                aria-label="Change language"
                aria-expanded={langOpen}
              >
                {language.toUpperCase()}
              </button>
              {langOpen && (
                <div
                  className="card card-tight"
                  style={{ position: 'absolute', right: 0, top: '42px', minWidth: '150px', zIndex: 80, padding: 'var(--space-2)' }}
                >
                  {LANGUAGES.map((l) => (
                    <button
                      key={l.id}
                      type="button"
                      className="btn btn-ghost btn-sm btn-block"
                      style={{ justifyContent: 'flex-start', fontWeight: language === l.id ? 700 : 500 }}
                      onClick={() => {
                        setLanguage(l.id as 'en' | 'hi' | 'es');
                        setLangOpen(false);
                      }}
                    >
                      {l.native}
                    </button>
                  ))}
                </div>
              )}
            </div>

            <button
              type="button"
              className="icon-button"
              onClick={toggleTheme}
              aria-label={theme === 'dark' ? 'Switch to light theme' : 'Switch to dark theme'}
            >
              {theme === 'dark' ? '☀️' : '🌙'}
            </button>

            <div className="chip-row hide-sm" role="group" aria-label="Audience mode">
              <button
                type="button"
                className="chip small"
                aria-pressed={mode === 'student'}
                onClick={() => setMode('student')}
              >
                🎓 {t('common.student')}
              </button>
              <button
                type="button"
                className="chip small"
                aria-pressed={mode === 'clinician'}
                onClick={() => setMode('clinician')}
              >
                🩺 {t('common.clinician')}
              </button>
            </div>
          </div>
        </div>
        {!online && <div className="offline-banner">{t('common.offline')}</div>}
      </header>

      <main className="main" id="content">
        <Outlet />
      </main>

      <footer className="site-footer">
        <div className="container">
          <div className="footer-grid">
            {FOOTER.map((col) => (
              <div key={col.title}>
                <div className="footer-title">{col.title}</div>
                <ul className="footer-links">
                  {col.links.map((l) => (
                    <li key={l.to + l.label}>
                      <Link to={l.to}>{l.label}</Link>
                    </li>
                  ))}
                </ul>
              </div>
            ))}
          </div>
          <div className="footer-bottom">
            <span>{t('footer.disclaimer')}</span>
            <span>© {new Date().getFullYear()} VetMasterJi · Formatting and educational reference</span>
          </div>
        </div>
      </footer>
    </div>
  );
}
