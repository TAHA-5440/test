import type { Sign } from '../types';

/**
 * The clinical sign vocabulary used by the differential engine.
 *
 * Weights on a disease's key signs run 1–5: 5 is close to pathognomonic,
 * 1 is a non-specific finding that many conditions share.
 */
export const SIGNS: Sign[] = [
  // Systemic
  { id: 'fever', label: 'Fever / pyrexia', system: 'Systemic' },
  { id: 'hypothermia', label: 'Hypothermia', system: 'Systemic' },
  { id: 'anorexia', label: 'Anorexia / inappetence', system: 'Systemic' },
  { id: 'weight-loss', label: 'Weight loss', system: 'Systemic' },
  { id: 'lethargy', label: 'Lethargy / depression', system: 'Systemic' },
  { id: 'dehydration', label: 'Dehydration', system: 'Systemic' },
  { id: 'recumbency', label: 'Recumbency / collapse', system: 'Systemic' },
  { id: 'pale-mucous-membranes', label: 'Anaemia / pale mucous membranes', system: 'Haematological' },
  { id: 'petechiae', label: 'Petechiae / haemorrhage', system: 'Haematological' },
  { id: 'icterus', label: 'Icterus / jaundice', system: 'Systemic' },
  { id: 'lymphadenopathy', label: 'Lymphadenopathy', system: 'Systemic' },
  { id: 'oedema', label: 'Oedema / swollen limbs', system: 'Systemic' },
  { id: 'muffled-heart-sounds', label: 'Muffled heart sounds', system: 'Cardiovascular' },
  { id: 'haemoglobinuria', label: 'Haemoglobinuria (red urine)', system: 'Urinary' },

  // Gastrointestinal
  { id: 'vomiting', label: 'Vomiting', system: 'Gastrointestinal' },
  { id: 'diarrhoea', label: 'Diarrhoea', system: 'Gastrointestinal' },
  { id: 'haemorrhagic-diarrhoea', label: 'Haemorrhagic diarrhoea', system: 'Gastrointestinal' },
  { id: 'abdominal-pain', label: 'Abdominal pain', system: 'Gastrointestinal' },
  { id: 'distended-abdomen', label: 'Distended abdomen', system: 'Gastrointestinal' },
  { id: 'regurgitation', label: 'Regurgitation', system: 'Gastrointestinal' },
  { id: 'melaena', label: 'Melaena', system: 'Gastrointestinal' },
  { id: 'constipation', label: 'Constipation / tenesmus', system: 'Gastrointestinal' },
  { id: 'hypersalivation', label: 'Hypersalivation', system: 'Gastrointestinal' },
  { id: 'ruminal-tympany', label: 'Ruminal tympany / bloat', system: 'Gastrointestinal' },
  { id: 'ruminal-stasis', label: 'Rumen stasis / reduced motility', system: 'Gastrointestinal' },
  { id: 'oliguria-anuria', label: 'Oliguria / anuria', system: 'Urinary' },

  // Respiratory
  { id: 'cough', label: 'Cough', system: 'Respiratory' },
  { id: 'dyspnoea', label: 'Dyspnoea', system: 'Respiratory' },
  { id: 'nasal-discharge', label: 'Nasal discharge', system: 'Respiratory' },
  { id: 'ocular-discharge', label: 'Ocular discharge', system: 'Ophthalmic' },
  { id: 'sneezing', label: 'Sneezing', system: 'Respiratory' },
  { id: 'abdominal-effort', label: 'Abdominal effort on breathing', system: 'Respiratory' },

  // Neurological
  { id: 'seizures', label: 'Seizures', system: 'Neurological' },
  { id: 'ataxia', label: 'Ataxia', system: 'Neurological' },
  { id: 'paralysis', label: 'Paralysis / paresis', system: 'Neurological' },
  { id: 'head-tilt', label: 'Head tilt / circling', system: 'Neurological' },
  { id: 'tremors', label: 'Muscle tremors', system: 'Neurological' },
  { id: 'blindness', label: 'Blindness / visual deficit', system: 'Ophthalmic' },
  { id: 'behavioural-change', label: 'Behavioural change', system: 'Neurological' },

  // Cardiovascular
  { id: 'tachycardia', label: 'Tachycardia', system: 'Cardiovascular' },
  { id: 'bradycardia', label: 'Bradycardia', system: 'Cardiovascular' },
  { id: 'weak-pulse', label: 'Weak pulse', system: 'Cardiovascular' },
  { id: 'exercise-intolerance', label: 'Exercise intolerance', system: 'Cardiovascular' },
  { id: 'syncope', label: 'Syncope / fainting', system: 'Cardiovascular' },
  { id: 'murmur', label: 'Heart murmur', system: 'Cardiovascular' },
  { id: 'ascites', label: 'Abdominal effusion / ascites', system: 'Cardiovascular' },

  // Dermatological
  { id: 'pruritus', label: 'Pruritus', system: 'Dermatological' },
  { id: 'alopecia', label: 'Alopecia / hair loss', system: 'Dermatological' },
  { id: 'skin-lesions', label: 'Skin lesions / crusts', system: 'Dermatological' },
  { id: 'vesicles-mouth', label: 'Vesicles / ulcers in mouth', system: 'Dermatological' },
  { id: 'vesicles-feet', label: 'Vesicles / lesions on feet', system: 'Dermatological' },
  { id: 'skin-nodules', label: 'Skin nodules', system: 'Dermatological' },

  // Musculoskeletal
  { id: 'lameness', label: 'Lameness', system: 'Musculoskeletal' },
  { id: 'stiffness', label: 'Stiffness / reluctance to move', system: 'Musculoskeletal' },
  { id: 'joint-swelling', label: 'Swollen joints', system: 'Musculoskeletal' },
  { id: 'laminitic-stance', label: 'Laminitic stance / shifting weight', system: 'Musculoskeletal' },

  // Reproductive & mammary
  { id: 'abortion', label: 'Abortion', system: 'Reproductive' },
  { id: 'vaginal-discharge', label: 'Vaginal discharge', system: 'Reproductive' },
  { id: 'retained-placenta', label: 'Retained placenta', system: 'Reproductive' },
  { id: 'dystocia', label: 'Dystocia', system: 'Reproductive' },
  { id: 'infertility', label: 'Infertility / repeat breeding', system: 'Reproductive' },
  { id: 'mammary-swelling', label: 'Mammary swelling / abnormal milk', system: 'Mammary' },
  { id: 'decreased-milk', label: 'Sudden drop in milk yield', system: 'Mammary' },
  { id: 'udder-oedema', label: 'Hot, swollen, painful udder', system: 'Mammary' },

  // Urinary & endocrine
  { id: 'polyuria-polydipsia', label: 'Polyuria / polydipsia', system: 'Urinary' },
  { id: 'stranguria', label: 'Stranguria / dysuria', system: 'Urinary' },
  { id: 'haematuria', label: 'Haematuria', system: 'Urinary' },
  { id: 'urine-odour', label: 'Strong-smelling urine', system: 'Urinary' },

  // Avian
  { id: 'drop-in-egg-production', label: 'Drop in egg production', system: 'Reproductive' },
  { id: 'ruffled-feathers', label: 'Ruffled feathers / huddling', system: 'Systemic' },
  { id: 'sudden-death', label: 'Sudden death in the flock', system: 'Systemic' },
  { id: 'torticollis', label: 'Torticollis / twisted neck', system: 'Neurological' },
  { id: 'green-diarrhoea', label: 'Green / white diarrhoea', system: 'Gastrointestinal' },
];

export const SIGN_MAP: Record<string, Sign> = SIGNS.reduce(
  (acc, s) => {
    acc[s.id] = s;
    return acc;
  },
  {} as Record<string, Sign>,
);

export function signLabel(id: string): string {
  return SIGN_MAP[id]?.label ?? id;
}

export const SIGN_SYSTEMS: string[] = [...new Set(SIGNS.map((s) => s.system))].sort();

export function signsBySystem(): { system: string; signs: Sign[] }[] {
  return SIGN_SYSTEMS.map((system) => ({ system, signs: SIGNS.filter((s) => s.system === system) }));
}

/** A short, exam-room-friendly subset for the home page widget. */
export const COMMON_SIGN_IDS = [
  'vomiting',
  'diarrhoea',
  'haemorrhagic-diarrhoea',
  'fever',
  'anorexia',
  'lethargy',
  'dehydration',
  'abdominal-pain',
  'cough',
  'dyspnoea',
  'weight-loss',
  'polyuria-polydipsia',
  'lameness',
  'seizures',
  'ataxia',
  'pale-mucous-membranes',
  'icterus',
  'pruritus',
  'mammary-swelling',
  'abortion',
];
