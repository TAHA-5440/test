import type { SpeciesId } from '../types';
import { DRUGS } from '../data/drugs';
import { DISEASES } from '../data/diseases';
import { NOTES } from '../data/notes';
import { TOXICOLOGY } from '../data/toxicology';
import { PROCEDURES } from '../data/procedures';
import { REFERENCE_RANGES } from '../data/referenceRanges';
import { REFERENCES, referenceTitle } from '../data/references';
import { speciesLabel } from '../data/species';
import { computeDose, rowsForSpecies, formatDoseRange } from './dosing';

/**
 * The clinical assistant.
 *
 * This is a deterministic retrieval engine over the curated corpus, not a
 * generative language model. It will not invent a dose, a diagnosis or a
 * citation: it either finds the entry and shows you the reference it came
 * from, or it tells you what it could not find.
 *
 * Every answer carries the source, because an unsourced clinical answer is
 * not usable in a consultation.
 */

export type Intent =
  | 'dose'
  | 'interaction'
  | 'toxicology'
  | 'disease'
  | 'differential'
  | 'procedure'
  | 'range'
  | 'general';

export interface Evidence {
  kind: 'drug' | 'disease' | 'note' | 'toxicology' | 'procedure' | 'range';
  id: string;
  title: string;
  snippet: string;
  href?: string;
}

export interface AssistantAnswer {
  question: string;
  intent: Intent;
  species?: SpeciesId;
  headline: string;
  paragraphs: string[];
  bullets: string[];
  evidence: Evidence[];
  sources: { id: string; title: string; edition: string }[];
  caveats: string[];
  followUps: string[];
}

const STOPWORDS = new Set([
  'the', 'a', 'an', 'of', 'for', 'in', 'on', 'to', 'and', 'or', 'is', 'are', 'was', 'be', 'what', 'which',
  'how', 'much', 'give', 'gives', 'given', 'can', 'could', 'i', 'my', 'with', 'at', 'it', 'this', 'that',
  'do', 'does', 'should', 'would', 'there', 'any', 'has', 'have', 'need', 'needs', 'about', 'from', 'by',
  'if', 'when', 'than', 'then', 'so', 'as', 'but', 'not', 'no', 'yes', 'please', 'tell', 'me',
]);

function tokenize(text: string): string[] {
  return text
    .toLowerCase()
    .replace(/[^a-z0-9\-\s]/g, ' ')
    .split(/\s+/)
    .filter((t) => t.length > 2 && !STOPWORDS.has(t));
}

function detectIntent(q: string): Intent {
  if (/\b(interact|interaction|combine|together|mix|stack)\b/.test(q)) return 'interaction';
  if (/\b(poison|toxic|toxicity|antidote|overdose|ingested|ate|eat)\b/.test(q)) return 'toxicology';
  if (/\b(withdrawal|withdraw|meat|milk discard|residue)\b/.test(q)) return 'dose';
  if (/\b(dose|dosing|dosage|mg\/kg|ml|how much|calculat)\b/.test(q)) return 'dose';
  if (/\b(differential|differentials|ddx|could be|causes? of|rank)\b/.test(q)) return 'differential';
  if (/\b(range|ranges|normal value|reference interval|reference)\b/.test(q)) return 'range';
  if (/\b(how to|technique|procedure|place|perform|pass|trim|catheter|tube|trimming)\b/.test(q)) return 'procedure';
  if (/\b(treat|treatment|therap|manage|management|protocol|signs|symptom|diagnos)\b/.test(q)) return 'disease';
  return 'general';
}

interface Scored<T> {
  item: T;
  score: number;
}

function scoreItem(haystacks: string[], tokens: string[], weights: number[]): number {
  let score = 0;
  tokens.forEach((token, i) => {
    haystacks.forEach((hay, idx) => {
      const h = hay.toLowerCase();
      if (!h.includes(token)) return;
      const weight = weights[idx] ?? 1;
      const positionBoost = i === 0 ? 1.5 : 1;
      score += weight * positionBoost;
      if (h.startsWith(token)) score += 0.5 * weight;
    });
  });
  return score;
}

function uniqueSources(ids: string[]): { id: string; title: string; edition: string }[] {
  const out: { id: string; title: string; edition: string }[] = [];
  const seen = new Set<string>();
  for (const id of ids) {
    if (seen.has(id)) continue;
    seen.add(id);
    const ref = REFERENCES.find((r) => r.id === id);
    if (ref) out.push({ id: ref.id, title: ref.title, edition: ref.edition });
  }
  return out;
}

export function ask(question: string, species?: SpeciesId): AssistantAnswer {
  const tokens = tokenize(question);
  const intent = detectIntent(question.toLowerCase());

  const caveats: string[] = [];
  const paragraphs: string[] = [];
  const bullets: string[] = [];
  const evidence: Evidence[] = [];
  const sourceIds: string[] = [];

  // ---- Drugs -------------------------------------------------------------
  const drugScores: Scored<(typeof DRUGS)[number]>[] = DRUGS.map((d) => ({
    item: d,
    score: scoreItem(
      [d.name, d.aliases.join(' '), d.className, d.summary, d.doses.map((r) => r.indication).join(' ')],
      tokens,
      [6, 4, 2, 1, 2],
    ),
  }))
    .filter((s) => s.score > 0)
    .sort((a, b) => b.score - a.score);

  // ---- Diseases ----------------------------------------------------------
  const diseaseScores = DISEASES.map((d) => ({
    item: d,
    score: scoreItem(
      [d.name, d.aka.join(' '), d.system, d.summary, d.differentials.join(' ')],
      tokens,
      [6, 4, 1, 2, 1],
    ),
  }))
    .filter((s) => s.score > 0)
    .sort((a, b) => b.score - a.score);

  // ---- Notes, toxicology, procedures ------------------------------------
  const noteScores = NOTES.map((n) => ({
    item: n,
    score: scoreItem([n.title, n.category, n.summary, n.sections.map((s) => s.heading).join(' ')], tokens, [5, 2, 2, 1]),
  }))
    .filter((s) => s.score > 0)
    .sort((a, b) => b.score - a.score);

  const toxScores = TOXICOLOGY.map((t) => ({
    item: t,
    score: scoreItem([t.toxin, t.aliases.join(' '), t.signs.join(' '), t.antidote], tokens, [6, 4, 2, 2]),
  }))
    .filter((s) => s.score > 0)
    .sort((a, b) => b.score - a.score);

  const procScores = PROCEDURES.map((p) => ({
    item: p,
    score: scoreItem([p.title, p.system, p.summary, p.steps.join(' ')], tokens, [5, 2, 2, 1]),
  }))
    .filter((s) => s.score > 0)
    .sort((a, b) => b.score - a.score);

  // ---- Compose -----------------------------------------------------------
  let headline = '';

  if (intent === 'dose' && drugScores.length > 0) {
    const drug = drugScores[0].item;
    const targetSpecies = species ?? (drug.doses[0]?.species as SpeciesId);
    const rows = rowsForSpecies(drug, targetSpecies);
    headline = `${drug.name} for ${speciesLabel(targetSpecies).toLowerCase()} — ${rows.length} published ${rows.length === 1 ? 'dose' : 'doses'}`;

    if (rows.length === 0) {
      paragraphs.push(
        `No dose for ${drug.name} is published for ${speciesLabel(targetSpecies).toLowerCase()} in this database. Do not extrapolate from another species without a reference for doing so.`,
      );
      caveats.push('No published dose was found for this species in the curated corpus.');
    } else {
      const meta = SPECIES_TYPICAL_WEIGHT[targetSpecies] ?? 10;
      const top = rows[0];
      const result = computeDose(drug, top.row, meta);
      paragraphs.push(
        `For ${speciesLabel(targetSpecies).toLowerCase()}, the reference dose for ${top.row.indication.toLowerCase()} is ${formatDoseRange(top.row)} ${top.row.route} ${top.row.frequency}. At ${meta} kg that is ${result.totalDisplay}.`,
      );
      if (top.proxiedFrom) {
        paragraphs.push(
          `No ${speciesLabel(targetSpecies).toLowerCase()}-specific dose is published, so this row is carried over from ${speciesLabel(top.proxiedFrom).toLowerCase()} and is extra-label.`,
        );
        caveats.push('This dose is carried over from another species and is therefore extra-label.');
      }
      bullets.push(
        ...rows.slice(0, 5).map(
          (r) => `${r.row.indication}: ${formatDoseRange(r.row)} ${r.row.route} ${r.row.frequency}${r.row.duration ? ` — ${r.row.duration}` : ''}`,
        ),
      );
      const w = rows.find((r) => r.row.withdrawalMeatDays !== undefined || r.row.withdrawalMilkHours !== undefined || r.row.withdrawalUnknown);
      if (w) {
        const wd = w.row;
        if (wd.withdrawalUnknown) {
          caveats.push('No withdrawal period is established for this use — treat it as extra-label and derive an interval from FARAD.');
        } else {
          const parts: string[] = [];
          if (wd.withdrawalMeatDays !== null && wd.withdrawalMeatDays !== undefined) parts.push(`${wd.withdrawalMeatDays} days meat`);
          if (wd.withdrawalMilkHours !== null && wd.withdrawalMilkHours !== undefined) parts.push(`${wd.withdrawalMilkHours} h milk`);
          bullets.push(`Withdrawal: ${parts.join(' / ')} — follow the local product label.`);
        }
      }
      if (drug.speciesWarnings.length > 0) {
        const warn = drug.speciesWarnings.find((s) => s.species === targetSpecies);
        if (warn) bullets.push(`Species warning — ${warn.text}`);
      }
      bullets.push(`Contraindications: ${drug.contraindications.slice(0, 3).join('; ')}.`);
    }
    sourceIds.push(...drug.sources);
    evidence.push({
      kind: 'drug',
      id: drug.id,
      title: drug.name,
      snippet: drug.summary,
      href: `/drugs/${drug.id}`,
    });
  } else if (intent === 'toxicology' && toxScores.length > 0) {
    const tox = toxScores[0].item;
    headline = `${tox.toxin} — recognition and first-line management`;
    paragraphs.push(`${tox.toxin} (${tox.source}). ${tox.mechanism}`);
    paragraphs.push(`Onset: ${tox.onset}.`);
    bullets.push(`Signs: ${tox.signs.slice(0, 6).join(', ')}.`);
    bullets.push(`Antidote: ${tox.antidote}`);
    bullets.push(`First-line: ${tox.management.slice(0, 3).join(' ')}`);
    if (tox.pearls[0]) bullets.push(`Pearl: ${tox.pearls[0]}`);
    sourceIds.push(...tox.sources);
    evidence.push({ kind: 'toxicology', id: tox.id, title: tox.toxin, snippet: tox.signs.slice(0, 3).join('; '), href: '/toxicology' });
  } else if (intent === 'procedure' && procScores.length > 0) {
    const proc = procScores[0].item;
    headline = `${proc.title} (${proc.level.toLowerCase()}, ${proc.duration})`;
    paragraphs.push(proc.summary);
    bullets.push('Sequence: ' + proc.steps.slice(0, 6).join(' → '));
    bullets.push('Pitfalls: ' + proc.pitfalls.slice(0, 3).join(' '));
    sourceIds.push(...proc.sources);
    evidence.push({ kind: 'procedure', id: proc.id, title: proc.title, snippet: proc.summary, href: '/procedures' });
  } else if (intent === 'range' && species) {
    const groups = REFERENCE_RANGES[species] ?? [];
    const flat = groups.flatMap((g) => g.rows);
    const match = flat.find((r) => r.param.toLowerCase().includes(question.toLowerCase())) ??
      flat.find((r) => tokens.some((t) => r.param.toLowerCase().includes(t)));
    headline = match
      ? `${match.param} in ${speciesLabel(species).toLowerCase()}`
      : `Adult reference ranges for ${speciesLabel(species).toLowerCase()}`;
    if (match) {
      paragraphs.push(
        `The adult reference interval for ${match.param.toLowerCase()} in a ${speciesLabel(species).toLowerCase()} is ${match.low ?? '—'}–${match.high ?? '—'} ${match.unit}.${match.note ? ` ${match.note}.` : ''}`,
      );
    } else {
      paragraphs.push(
        `Adult reference intervals for ${speciesLabel(species).toLowerCase()} are listed by group below. Use the performing laboratory's own interval where it gives one.`,
      );
      bullets.push(...flat.slice(0, 10).map((r) => `${r.param}: ${r.low ?? '—'}–${r.high ?? '—'} ${r.unit}`));
    }
    sourceIds.push('merck');
    evidence.push({ kind: 'range', id: species, title: `${speciesLabel(species)} reference ranges`, snippet: headline, href: '/reference-ranges' });
  } else if (diseaseScores.length > 0) {
    const disease = diseaseScores[0].item;
    headline = disease.name;
    paragraphs.push(disease.summary);
    if (intent === 'differential' || /differential|rank|could be/.test(question.toLowerCase())) {
      bullets.push(`Differentials to rule out: ${disease.differentials.slice(0, 6).join(', ')}.`);
    } else {
      bullets.push(`Key signs: ${disease.keySigns.slice(0, 6).map((k) => k.sign.replace(/-/g, ' ')).join(', ')}.`);
      bullets.push(`Diagnosis: ${disease.diagnosis.slice(0, 4).join(' ')}`);
    }
    bullets.push(`Treatment outline: ${disease.treatment.slice(0, 320)}${disease.treatment.length > 320 ? '…' : ''}`);
    bullets.push(`Prognosis: ${disease.prognosis}`);
    sourceIds.push(...disease.sources);
    evidence.push({ kind: 'disease', id: disease.id, title: disease.name, snippet: disease.summary, href: `/diseases/${disease.id}` });
  } else if (noteScores.length > 0) {
    const note = noteScores[0].item;
    headline = note.title;
    paragraphs.push(note.summary);
    bullets.push(...note.alerts.slice(0, 3).map((a) => `Alert: ${a}`));
    const first = note.sections[0];
    if (first) bullets.push(`${first.heading}: ${first.body[0]}`);
    sourceIds.push(...note.sources);
    evidence.push({ kind: 'note', id: note.id, title: note.title, snippet: note.summary, href: `/notes/${note.id}` });
  } else if (drugScores.length > 0) {
    const drug = drugScores[0].item;
    headline = drug.name;
    paragraphs.push(drug.summary);
    paragraphs.push(drug.mechanism);
    bullets.push(`Class: ${drug.className}. Routes on file: ${[...new Set(drug.doses.map((d) => d.route))].join(', ')}.`);
    bullets.push(`Contraindications: ${drug.contraindications.slice(0, 3).join('; ')}.`);
    sourceIds.push(...drug.sources);
    evidence.push({ kind: 'drug', id: drug.id, title: drug.name, snippet: drug.summary, href: `/drugs/${drug.id}` });
  } else {
    headline = 'Nothing in the curated corpus matches that question closely';
    paragraphs.push(
      'This assistant is a deterministic retrieval engine, not a generative model. It searched the drug monographs, the condition reference, the clinical notes, the toxicology entries and the procedure library, and found no entry above the matching threshold.',
    );
    paragraphs.push(
      'Try naming a drug, a condition, a toxin or a procedure, or use the drug calculator, the differential tool or the notes library directly. Where this database has no answer, it will say so rather than improvise one.',
    );
    caveats.push('No matching entry — this is a bounded negative search over the curated corpus, not an absence of clinical knowledge.');
  }

  // Secondary evidence, so the answer is checkable.
  for (const s of drugScores.slice(intent === 'dose' ? 1 : 0, 3)) {
    evidence.push({ kind: 'drug', id: s.item.id, title: s.item.name, snippet: s.item.summary, href: `/drugs/${s.item.id}` });
    sourceIds.push(...s.item.sources);
  }
  for (const s of diseaseScores.slice(0, 2)) {
    evidence.push({ kind: 'disease', id: s.item.id, title: s.item.name, snippet: s.item.summary, href: `/diseases/${s.item.id}` });
    sourceIds.push(...s.item.sources);
  }
  for (const s of noteScores.slice(0, 2)) {
    evidence.push({ kind: 'note', id: s.item.id, title: s.item.title, snippet: s.item.summary, href: `/notes/${s.item.id}` });
    sourceIds.push(...s.item.sources);
  }

  caveats.push(
    'Reference information for veterinary professionals. Confirm every dose against the product label, the patient and current national guidance; the attending veterinarian remains responsible for the decision.',
  );

  const followUps: string[] = [];
  if (drugScores[0]) followUps.push(`What are the contraindications for ${drugScores[0].item.name}?`);
  if (diseaseScores[0]) followUps.push(`How is ${diseaseScores[0].item.name.toLowerCase()} diagnosed?`);
  if (toxScores[0]) followUps.push(`What is the antidote for ${toxScores[0].item.toxin.toLowerCase()}?`);
  followUps.push('Which drugs interact with this prescription?');
  followUps.push('What are the adult reference ranges for this species?');

  return {
    question,
    intent,
    species,
    headline: headline || 'Clinical answer',
    paragraphs,
    bullets: [...new Set(bullets)].slice(0, 8),
    evidence: evidence.slice(0, 8),
    sources: uniqueSources(sourceIds),
    caveats,
    followUps: [...new Set(followUps)].slice(0, 4),
  };
}

const SPECIES_TYPICAL_WEIGHT: Partial<Record<SpeciesId, number>> = {
  dog: 18,
  cat: 4.5,
  cattle: 450,
  buffalo: 500,
  horse: 500,
  sheep: 60,
  goat: 45,
  pig: 90,
  poultry: 2,
  bird: 0.35,
  rabbit: 2,
  ferret: 1.2,
  'guinea-pig': 0.9,
  reptile: 1,
  camel: 400,
};

export function referenceList(): { id: string; label: string; area: string }[] {
  return REFERENCES.map((r) => ({ id: r.id, label: referenceTitle(r.id), area: r.area }));
}
