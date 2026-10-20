import type { Drug, DrugClass, SpeciesId } from '../types';
import { DRUG_MAP } from '../data/drugs';
import { SPECIES_MAP } from '../data/species';
import { rowsForSpecies } from './dosing';

/**
 * Prescription screening.
 *
 * Two layers:
 *  1. Class-level rules that catch duplicate therapy and the combinations that
 *     cause predictable harm (NSAID + steroid, aminoglycoside + loop diuretic).
 *  2. Pair rules drawn from each monograph's own interaction list, matched on
 *     the other drug's name or aliases.
 *  3. Species-level flags for food-producing animals: prohibited substances and
 *     uses for which no withdrawal period is established.
 *
 * A clean screen is not a safety guarantee: it only covers the pairs on file.
 */

export type Severity = 'contraindicated' | 'major' | 'moderate' | 'minor';

export interface InteractionFinding {
  severity: Severity;
  title: string;
  detail: string;
  action: string;
  drugs: string[];
  source: string;
}

interface ClassRule {
  classes: [DrugClass, DrugClass];
  severity: Severity;
  title: string;
  detail: string;
  action: string;
}

const CLASS_RULES: ClassRule[] = [
  {
    classes: ['Anti-inflammatory', 'Hormone & emergency'],
    severity: 'contraindicated',
    title: 'NSAID with a corticosteroid',
    detail:
      'The two suppress prostaglandins at different points and together produce synergistic gastrointestinal ulceration. This is the classic iatrogenic perforation combination.',
    action: 'Do not combine. Stop one, wash out, and add gastroprotection if the animal has already had both.',
  },
  {
    classes: ['Cardiovascular', 'Anti-inflammatory'],
    severity: 'major',
    title: 'NSAID with a diuretic',
    detail:
      'A reduced effective circulating volume plus prostaglandin inhibition compounds renal hypoperfusion. In a dehydrated or azotaemic patient this is how an acute kidney injury starts.',
    action: 'Correct hydration first, avoid the combination where possible, and monitor renal values.',
  },
  {
    classes: ['Gastrointestinal', 'Antibiotic'],
    severity: 'major',
    title: 'Oral chelating agent with an antibiotic',
    detail:
      'Sucralfate binds fluoroquinolones, tetracyclines and several other oral drugs in the gut, and it also needs an acidic pH to work — which a proton pump inhibitor removes.',
    action: 'Separate the doses by at least two hours, giving the sucralfate first, and never stop the antibiotic dose to make room.',
  },
  {
    classes: ['Sedative & anaesthetic', 'Analgesic'],
    severity: 'major',
    title: 'Sedative with an opioid',
    detail: 'Alpha-2 agonists, benzodiazepines and opioids produce additive central nervous and respiratory depression.',
    action: 'Reduce both doses, monitor ventilation, and have the reversal agent drawn up before you start.',
  },
  {
    classes: ['Sedative & anaesthetic', 'Sedative & anaesthetic'],
    severity: 'moderate',
    title: 'Two sedatives or anaesthetics',
    detail:
      'Combinations such as an alpha-2 plus ketamine are deliberate and useful, but the cardiovascular depression is additive and the inhalant requirement drops sharply.',
    action: 'This is usually intentional — reduce both doses and monitor heart rate, blood pressure and ventilation.',
  },
  {
    classes: ['Antibiotic', 'Antibiotic'],
    severity: 'minor',
    title: 'Two antimicrobials',
    detail:
      'Deliberate combinations exist (a beta-lactam plus an aminoglycoside for synergy; metronidazole plus a second agent for mixed anaerobic cover). Indiscriminate stacking does not broaden cover — it broadens the selection pressure.',
    action: 'Confirm that each agent has a culture-based or anatomical reason to be there, and that they are compatible in the same line.',
  },
  {
    classes: ['Antifungal', 'Gastrointestinal'],
    severity: 'major',
    title: 'Azole antifungal with an acid suppressant',
    detail:
      'Itraconazole capsules and ketoconazole need gastric acidity to dissolve. A proton pump inhibitor or an H2 antagonist can cut the absorption to a sub-therapeutic level.',
    action: 'Use the azole oral solution where available, separate the doses, and monitor the clinical response rather than assuming it is working.',
  },
  {
    classes: ['Antiemetic', 'Analgesic'],
    severity: 'moderate',
    title: '5-HT3 antiemetic with tramadol',
    detail: 'Ondansetron blunts the monoamine reuptake component of tramadol analgesia, and both carry a small serotonergic risk.',
    action: 'Use maropitant instead where an antiemetic is needed, or expect to escalate the analgesia.',
  },
];

const SEVERITY_ORDER: Record<Severity, number> = {
  contraindicated: 0,
  major: 1,
  moderate: 2,
  minor: 3,
};

function namesMatch(interactionWith: string, other: Drug): boolean {
  const needle = interactionWith.toLowerCase();
  if (needle.includes(other.name.toLowerCase())) return true;
  if (other.name.toLowerCase().includes(needle)) return true;
  return other.aliases.some((a) => {
    const alias = a.toLowerCase();
    return needle.includes(alias) || alias.includes(needle);
  });
}

function sameClassDuplicate(a: Drug, b: Drug): boolean {
  if (a.className !== b.className) return false;
  // Stacking two antimicrobials is deliberate often enough to warrant a softer
  // note; stacking two NSAIDs never is.
  return a.className === 'Anti-inflammatory';
}

export function screenPrescription(drugIds: string[], species?: SpeciesId): InteractionFinding[] {
  const drugs = drugIds.map((id) => DRUG_MAP[id]).filter((d): d is Drug => Boolean(d));
  const findings: InteractionFinding[] = [];

  for (let i = 0; i < drugs.length; i += 1) {
    for (let j = i + 1; j < drugs.length; j += 1) {
      const a = drugs[i];
      const b = drugs[j];

      if (sameClassDuplicate(a, b)) {
        findings.push({
          severity: 'contraindicated',
          title: `Duplicate therapy: two ${a.className.toLowerCase()}s`,
          detail: `${a.name} and ${b.name} are both ${a.className.toLowerCase()}s. Stacking them adds toxicity without adding analgesia, and they compete for the same COX inhibition.`,
          action: 'Choose one. If you are switching between them, wash out for 5–7 days first.',
          drugs: [a.name, b.name],
          source: 'Class rule — see both monographs',
        });
      }

      for (const rule of CLASS_RULES) {
        const [c1, c2] = rule.classes;
        const hit =
          (a.className === c1 && b.className === c2) || (a.className === c2 && b.className === c1);
        if (!hit) continue;
        if (rule.title.includes('Two antimicrobials') && a.className !== b.className) continue;
        findings.push({
          severity: rule.severity,
          title: rule.title,
          detail: rule.detail,
          action: rule.action,
          drugs: [a.name, b.name],
          source: 'Class rule',
        });
      }

      // Monograph pair rules, in both directions.
      for (const interaction of a.interactions) {
        if (namesMatch(interaction.with, b)) {
          findings.push({
            severity: interaction.severity,
            title: `${a.name} + ${b.name}`,
            detail: interaction.effect,
            action: interaction.action,
            drugs: [a.name, b.name],
            source: `${a.name} monograph`,
          });
        }
      }
      for (const interaction of b.interactions) {
        if (namesMatch(interaction.with, a)) {
          findings.push({
            severity: interaction.severity,
            title: `${b.name} + ${a.name}`,
            detail: interaction.effect,
            action: interaction.action,
            drugs: [a.name, b.name],
            source: `${b.name} monograph`,
          });
        }
      }
    }
  }

  // Species-level flags that are independent of any pair. These are derived
  // from the monograph data rather than a hard-coded list, so any drug whose
  // entry records a prohibition or an unknown withdrawal is caught.
  if (species) {
    const meta = SPECIES_MAP[species];
    for (const drug of drugs) {
      if (!meta?.isFoodAnimal) continue;

      const rows = rowsForSpecies(drug, species);
      const publishable = rows.filter((r) => r.row.doseLow !== null || r.row.doseHigh !== null);

      if (rows.length > 0 && publishable.length === 0) {
        findings.push({
          severity: 'contraindicated',
          title: `${drug.name} in a food-producing species`,
          detail: `Every ${species} row in this monograph records a prohibition rather than a dose. ${
            rows[0].row.indication
          }`,
          action: 'Choose an alternative with a labelled food-animal use. No withdrawal period makes this use lawful.',
          drugs: [drug.name],
          source: `${drug.name} monograph`,
        });
        continue;
      }

      const unknownWithdrawal = publishable.find((r) => r.row.withdrawalUnknown);
      if (unknownWithdrawal) {
        findings.push({
          severity: 'major',
          title: `${drug.name}: no withdrawal period established`,
          detail: `The reference states that no withdrawal period is established for ${unknownWithdrawal.row.indication.toLowerCase()} in this species, so the use is extra-label.`,
          action: 'Derive a withdrawal interval from FARAD or your national residue scheme, and record it on the prescription.',
          drugs: [drug.name],
          source: `${drug.name} monograph`,
        });
      }
    }
  }

  // De-duplicate identical findings.
  const seen = new Set<string>();
  const unique = findings.filter((f) => {
    const key = `${f.severity}|${f.title}|${f.drugs.slice().sort().join('+')}`;
    if (seen.has(key)) return false;
    seen.add(key);
    return true;
  });

  return unique.sort((a, b) => SEVERITY_ORDER[a.severity] - SEVERITY_ORDER[b.severity]);
}

export function severityLabel(severity: Severity): string {
  switch (severity) {
    case 'contraindicated':
      return 'Do not combine';
    case 'major':
      return 'Major';
    case 'moderate':
      return 'Moderate';
    default:
      return 'Minor';
  }
}
