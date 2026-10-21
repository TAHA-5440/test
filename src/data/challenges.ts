import type { ChallengeQuestion } from '../types';

/**
 * The daily challenge bank.
 *
 * Questions are drawn across small animal, large animal, pharmacology and
 * infectious disease, and every one carries a worked explanation and a
 * citation. Five a day, deterministic: the day of the year selects the set.
 */
export const CHALLENGES: ChallengeQuestion[] = [
  {
    id: 'q001',
    prompt: 'Which of these is severely toxic to cats and must never be applied to them?',
    options: ['Permethrin spot-on', 'Amoxicillin', 'Metronidazole', 'Maropitant'],
    answerIndex: 0,
    explanation:
      'Cats cannot glucuronidate permethrin, and a dog spot-on product is a dose far above the feline tolerance. The result is tremor, seizures and hyperthermia. Treat with intravenous lipid emulsion, methocarbamol and seizure control, and wash the product off once the cat is stable.',
    topic: 'Toxicology',
    species: 'cat',
    source: "Plumb's; Merck 11e",
  },
  {
    id: 'q002',
    prompt: 'A 4-month-old unvaccinated Labrador pup presents with acute vomiting, profuse haemorrhagic diarrhoea and lethargy. Which diagnostic test gives the fastest antemortem answer?',
    options: ['Faecal antigen ELISA', 'Abdominal radiography', 'Serum amylase and lipase', 'Coombs test'],
    answerIndex: 0,
    explanation:
      'Canine parvoviral enteritis is confirmed on a faecal antigen ELISA in minutes. Radiographs exclude a foreign body, canine pancreatic lipase tests for pancreatitis, and a Coombs test is for immune-mediated haemolysis — none is the first test here.',
    topic: 'Infectious disease',
    species: 'dog',
    source: "Greene's 5e; Merck 11e",
  },
  {
    id: 'q003',
    prompt: 'A 20 kg dog is 8% dehydrated. Using the standard formula, what is the fluid deficit?',
    options: ['800 mL', '1600 mL', '2000 mL', '3200 mL'],
    answerIndex: 1,
    explanation: 'Deficit (mL) = weight (kg) × dehydration (%) × 10 = 20 × 8 × 10 = 1600 mL.',
    topic: 'Fluid therapy',
    species: 'dog',
    source: "Merck 11e; DiBartola 4e",
  },
  {
    id: 'q004',
    prompt: 'Which NSAID statement about cats is correct?',
    options: [
      'Meloxicam may be repeated daily for chronic pain in cats in the USA',
      'A single peri-operative subcutaneous dose is the only labelled use in the USA',
      'Cats metabolise NSAIDs faster than dogs, so they need higher doses',
      'Paracetamol is a safe alternative at 10 mg/kg q12h',
    ],
    answerIndex: 1,
    explanation:
      'The US meloxicam label for cats permits a single subcutaneous peri-operative dose only: repeated dosing has caused acute renal failure and death, which is why the boxed warning exists. Paracetamol is never safe in a cat, and cats do not need higher NSAID doses.',
    topic: 'Pharmacology',
    species: 'cat',
    source: "Plumb's p.780 (Metacam label)",
  },
  {
    id: 'q005',
    prompt: 'A downer cow 12 hours after calving is recumbent, has cold ears and a tucked head, and does not rise after a slow IV calcium injection. What is the next step?',
    options: [
      'Repeat the calcium immediately at double the dose',
      'Check magnesium and phosphorus, and reassess for a calving injury or fracture',
      'Give intravenous dextrose and discharge',
      'Administer oxytocin and wait 24 hours',
    ],
    answerIndex: 1,
    explanation:
      'A non-responder is no longer a simple milk fever. Check magnesium and phosphorus, re-examine for a calving injury or a fracture, and reassess the hydration and perfusion. Repeated blind calcium dosing risks cardiotoxicity without addressing the real problem.',
    topic: 'Large animal medicine',
    species: 'cattle',
    source: "Smith's 4e; Merck (food animal)",
  },
  {
    id: 'q006',
    prompt: 'Which antimicrobial class should be reserved for culture-confirmed need under the WHO AWaRe categorisation?',
    options: ['Penicillins', 'Fluoroquinolones', 'Tetracyclines', 'Sulfonamides'],
    answerIndex: 1,
    explanation:
      'Fluoroquinolones and third-generation cephalosporins sit in the AWaRe "Watch" group: they are broad, they are critically important in human medicine, and their value is preserved by using a narrower agent first and de-escalating on culture results.',
    topic: 'Antimicrobial stewardship',
    species: 'all',
    source: 'WHO AWaRe guidance',
  },
  {
    id: 'q007',
    prompt: 'A dog on long-term trimethoprim-sulfonamide therapy is most at risk of which adverse effect?',
    options: ['Keratoconjunctivitis sicca', 'Hepatic necrosis', 'Tendon rupture', 'Retinal degeneration'],
    answerIndex: 0,
    explanation:
      'Sulfonamides are toxic to the lacrimal glands and cause keratoconjunctivitis sicca with chronic use. A Schirmer tear test belongs in the monitoring plan for any dog on a course longer than a few weeks.',
    topic: 'Pharmacology',
    species: 'dog',
    source: "Plumb's p.1354",
  },
  {
    id: 'q008',
    prompt: 'In a dog with suspected gastric dilatation-volvulus, which single measurement best predicts gastric necrosis and mortality?',
    options: ['Packed cell volume', 'Serum lactate', 'Alkaline phosphatase', 'Urine specific gravity'],
    answerIndex: 1,
    explanation:
      'A persistently high or rising lactate tracks the splanchnic ischaemia. Decompress and stabilise first, then operate — but the lactate tells you what the surgeon is likely to find and what to tell the owner.',
    topic: 'Emergency medicine',
    species: 'dog',
    source: "Fossum 5e; Merck 11e",
  },
  {
    id: 'q009',
    prompt: 'Which drug must never be given orally to a rabbit?',
    options: ['Meloxicam', 'Amoxicillin', 'Enrofloxacin', 'Ivermectin by injection'],
    answerIndex: 1,
    explanation:
      'Oral amoxicillin (and ampicillin, clindamycin, lincomycin and erythromycin) causes fatal enteric dysbiosis in rabbits and other hindgut fermenters. Meloxicam, enrofloxacin and parenteral ivermectin are all used in rabbits.',
    topic: 'Exotic species',
    species: 'rabbit',
    source: "Plumb's p.85; Carpenter 6e",
  },
  {
    id: 'q010',
    prompt: 'A cat presents with brown mucous membranes after a possible ingestion. What is the most likely mechanism?',
    options: ['Methaemoglobinaemia', 'Melaena from a gastric ulcer', 'Carbon monoxide exposure', 'Severe dehydration'],
    answerIndex: 0,
    explanation:
      'Brown or chocolate-coloured membranes that do not pink up with oxygen indicate methaemoglobin — classically paracetamol in a cat or nitrate/nitrite poisoning in a ruminant. It is a visible diagnosis before any blood test returns.',
    topic: 'Toxicology',
    species: 'cat',
    source: "Plumb's; Merck 11e",
  },
  {
    id: 'q011',
    prompt: 'What is the drip rate for a fluid plan running at 120 mL/h through a 20 drops/mL giving set?',
    options: ['20 drops/min', '30 drops/min', '40 drops/min', '60 drops/min'],
    answerIndex: 2,
    explanation: 'Drops per minute = mL/h × drop factor ÷ 60 = 120 × 20 ÷ 60 = 40 drops/min.',
    topic: 'Fluid therapy',
    species: 'all',
    source: "Merck 11e; DiBartola 4e",
  },
  {
    id: 'q012',
    prompt: 'Which of these is the appropriate reversal agent for medetomidine sedation in a dog?',
    options: ['Atipamezole', 'Naloxone', 'Flumazenil', 'Yohimbine is the only option'],
    answerIndex: 0,
    explanation:
      'Atipamezole is the specific alpha-2 antagonist. Because it is 5 mg/mL and medetomidine is 1 mg/mL, an equal volume reverses it — and it removes the analgesia as well as the sedation, so plan the analgesia before you reverse.',
    topic: 'Anaesthesia',
    species: 'dog',
    source: "Plumb's p.140 (Antisedan label)",
  },
  {
    id: 'q013',
    prompt: 'A ewe in late gestation with twins is dull, anorexic and recumbent. What is the most likely diagnosis?',
    options: ['Pregnancy toxaemia', 'Enterotoxaemia', 'Listeriosis', 'Footrot'],
    answerIndex: 0,
    explanation:
      'Pregnancy toxaemia follows a negative energy balance in late gestation, classically a thin ewe carrying twins. Enterotoxaemia is more acute and often presents as sudden death in well-grown lambs, and listeriosis produces focal neurological deficits.',
    topic: 'Large animal medicine',
    species: 'sheep',
    source: "Smith's 4e",
  },
  {
    id: 'q014',
    prompt: 'Which statement about ivermectin in MDR1-mutant dogs is correct?',
    options: [
      'All doses are unsafe and the drug is contraindicated at any dose',
      'Heartworm preventive doses are safe, but macrocyclic doses above roughly 0.2 mg/kg can be fatal',
      'Only injectable formulations are unsafe',
      'The mutation is restricted to Rough Collies',
    ],
    answerIndex: 1,
    explanation:
      'The MDR1 (ABCB1-1Δ) mutation removes P-glycoprotein efflux at the blood–brain barrier. Preventive doses do not reach the CNS, but mange and demodicosis dosing does. The mutation is found in collies, Australian shepherds, Shetland sheepdogs, long-haired whippets and others — genotype before macrocyclic dosing.',
    topic: 'Pharmacology',
    species: 'dog',
    source: "Plumb's p.700; Papich 5e",
  },
  {
    id: 'q015',
    prompt: 'What is the treatment of choice for anticoagulant rodenticide poisoning in a dog?',
    options: [
      'Vitamin K1 for 3–4 weeks',
      'Vitamin K1 for 5 days',
      'Fresh frozen plasma alone',
      'Protamine sulfate',
    ],
    answerIndex: 0,
    explanation:
      'Second-generation rodenticides persist in the liver for weeks. Vitamin K1 runs for 21–30 days, with a PT recheck 48 hours after the last dose. Plasma is for the bleeding patient, because vitamin K1 takes 12–24 hours to work — but plasma alone is not the treatment.',
    topic: 'Toxicology',
    species: 'dog',
    source: "Plumb's p.1460; Merck 11e",
  },
  {
    id: 'q016',
    prompt: 'Which clinical sign most reliably distinguishes a strangulating surgical colic from a medical colic in a horse at presentation?',
    options: [
      'A heart rate above 60 bpm with pain that does not respond to analgesia',
      'The presence of gut sounds on auscultation',
      'A normal packed cell volume',
      'Passing faeces normally',
    ],
    answerIndex: 0,
    explanation:
      'A tachycardia that persists after analgesia, together with nasogastric reflux and a serosanguinous peritoneal tap, marks the surgical colic. The heart rate is the most useful triage number and it is free.',
    topic: 'Equine medicine',
    species: 'horse',
    source: "Merck 11e; Smith's 4e",
  },
  {
    id: 'q017',
    prompt: 'Which species is most sensitive to xylazine on a mg/kg basis?',
    options: ['Goat', 'Dog', 'Pig', 'Horse'],
    answerIndex: 0,
    explanation:
      'Ruminants are roughly ten times more sensitive than dogs, and goats sit at the bottom of the range. Pigs need the highest mg/kg dose of the domestic species. Overdose a goat on a canine dose and you get profound respiratory depression and hypoxaemia.',
    topic: 'Pharmacology',
    species: 'goat',
    source: "Plumb's p.1477; Papich 5e",
  },
  {
    id: 'q018',
    prompt: 'A dog with immune-mediated haemolytic anaemia is most likely to die from which complication?',
    options: ['Thromboembolism', 'Hypoglycaemia', 'Corneal ulceration', 'Hypothyroidism'],
    answerIndex: 0,
    explanation:
      'Thromboembolic disease — pulmonary and otherwise — kills more IMHA patients than the anaemia itself. Thromboprophylaxis is part of the protocol, not an optional extra.',
    topic: 'Internal medicine',
    species: 'dog',
    source: "Ettinger's 8e; Merck 11e",
  },
  {
    id: 'q019',
    prompt: 'Which vaccination is core for a kitten and protects against panleukopenia?',
    options: ['FVRCP', 'FeLV', 'FIV', 'Rabies alone'],
    answerIndex: 0,
    explanation:
      'FVRCP covers feline herpesvirus, calicivirus and panleukopenia, and is a core vaccine from 6–8 weeks with boosters to 16 weeks. FeLV is core for at-risk cats but not for panleukopenia, and there is no widely used FIV vaccine in most regions.',
    topic: 'Preventive medicine',
    species: 'cat',
    source: "Greene's 5e; WSAVA guidelines",
  },
  {
    id: 'q020',
    prompt: 'Why is oral prednisolone preferred to prednisone in cats?',
    options: [
      'Cats convert prednisone to prednisolone inefficiently',
      'Prednisone is not absorbed in cats',
      'Prednisone is nephrotoxic in cats',
      'Prednisolone tastes better',
    ],
    answerIndex: 0,
    explanation:
      'Prednisone is a prodrug requiring hepatic conversion to prednisolone, and cats do this poorly — so prednisone effectively underdoses them. Use prednisolone, and remember that cats tolerate higher steroid doses than dogs.',
    topic: 'Pharmacology',
    species: 'cat',
    source: "Plumb's p.1094; Ettinger's 8e",
  },
  {
    id: 'q021',
    prompt: 'A milk fever cow is treated with 500 mL of calcium borogluconate. What is the greatest immediate risk during administration?',
    options: [
      'Cardiac arrhythmia or arrest if the injection is given too quickly',
      'Anaphylaxis from the calcium itself',
      'Hyperglycaemia',
      'Rumen acidosis',
    ],
    answerIndex: 0,
    explanation:
      'Give it slowly with a stethoscope on the chest: bradycardia or any arrhythmia during administration means slow down or stop. Perivascular leakage is the second risk — it sloughs tissue and leaves a lesion the cow carries for months.',
    topic: 'Large animal medicine',
    species: 'cattle',
    source: "Plumb's p.172; Smith's 4e",
  },
  {
    id: 'q022',
    prompt: 'Which monitoring parameter gives the best day-to-day guide to a dog\'s heart failure control at home?',
    options: [
      'Sleeping respiratory rate, recorded by the owner',
      'Weekly weight alone',
      'Monthly chest radiographs',
      'Daily serum creatinine',
    ],
    answerIndex: 0,
    explanation:
      'A sleeping respiratory rate above roughly 30–35 breaths per minute is the earliest sign of decompensation, and owners can measure it better than a clinic can. Weight and radiographs add information, but the resting rate is the daily signal.',
    topic: 'Cardiology',
    species: 'dog',
    source: "Ettinger's 8e",
  },
  {
    id: 'q023',
    prompt: 'Which drug interaction is the most consequential and should be avoided outright?',
    options: [
      'An NSAID with a corticosteroid',
      'Amoxicillin with clavulanate',
      'Maropitant with an intravenous fluid',
      'Furosemide with pimobendan',
    ],
    answerIndex: 0,
    explanation:
      'An NSAID plus a steroid produces synergistic GI ulceration and is the classic iatrogenic perforation combination. Amoxicillin plus clavulanate is a deliberate beneficial pairing, and furosemide plus pimobendan is standard heart-failure therapy.',
    topic: 'Pharmacology',
    species: 'all',
    source: "Plumb's; Papich 5e",
  },
  {
    id: 'q024',
    prompt: 'What is the first-line treatment for neonatal calf diarrhoea?',
    options: [
      'Oral rehydration with a balanced electrolyte solution, continued alongside milk feeding',
      'Withholding milk for 48 hours',
      'Broad-spectrum antibiotics alone',
      'Intravenous dextrose only',
    ],
    answerIndex: 0,
    explanation:
      'The calf dies of dehydration, acidosis and electrolyte loss rather than of the pathogen. Feed 2–4 L of a properly formulated oral rehydration solution containing glucose, sodium, potassium and an alkalinising agent, and keep feeding milk. Never withhold milk — the gut needs the energy.',
    topic: 'Large animal medicine',
    species: 'cattle',
    source: "Merck (food animal); Smith's 4e",
  },
  {
    id: 'q025',
    prompt: 'In a chicken flock with a sudden drop in egg production, green diarrhoea, torticollis and high mortality, which disease must be considered first?',
    options: ['Newcastle disease', 'Coccidiosis', 'Marek\'s disease', 'Fowl pox'],
    answerIndex: 0,
    explanation:
      'Velogenic Newcastle disease produces exactly that picture, and it is notifiable: the differential from avian influenza is a statutory question before it is a clinical one. Coccidiosis causes bloody enteritis without the neurological signs.',
    topic: 'Poultry medicine',
    species: 'poultry',
    source: 'Merck 11e; OIE guidance',
  },
  {
    id: 'q026',
    prompt: 'A dog is on long-term phenobarbital and develops a suspected infection. Which class is affected by enzyme induction?',
    options: [
      'Azole antifungals and doxycycline have reduced concentrations',
      'All antibiotics become more toxic',
      'Phenobarbital concentrations rise with any antibiotic',
      'There is no clinically relevant interaction',
    ],
    answerIndex: 0,
    explanation:
      'Phenobarbital induces hepatic enzymes and lowers the concentration of doxycycline, azole antifungals and several other drugs. The animal is then under-treated rather than over-treated — the opposite of what most people expect.',
    topic: 'Pharmacology',
    species: 'dog',
    source: "Plumb's; Papich 5e",
  },
  {
    id: 'q027',
    prompt: 'Which finding best supports primary immune-mediated haemolytic anaemia over babesiosis in a dog?',
    options: [
      'Spherocytes on the blood smear with a negative tick-borne PCR',
      'Thrombocytopenia alone',
      'A regenerative anaemia',
      'Hyperbilirubinaemia',
    ],
    answerIndex: 0,
    explanation:
      'Spherocytes are the hallmark of IMHA. Thrombocytopenia, regeneration and hyperbilirubinaemia appear in both, so they do not separate the two. Always run the tick-borne PCR before committing to immunosuppression.',
    topic: 'Internal medicine',
    species: 'dog',
    source: "Ettinger's 8e; Greene's 5e",
  },
  {
    id: 'q028',
    prompt: 'Which drug is contraindicated in a food-producing animal because no withdrawal period can make the use legal?',
    options: ['Metronidazole', 'Oxytetracycline', 'Meloxicam', 'Fenbendazole'],
    answerIndex: 0,
    explanation:
      'Metronidazole is prohibited in food-producing animals in the USA, the EU and most other jurisdictions because of the genotoxic residue concern. Oxytetracycline, meloxicam and fenbendazole all have labelled food-animal withdrawal periods.',
    topic: 'Pharmacology',
    species: 'cattle',
    source: "Plumb's p.816; FARAD",
  },
  {
    id: 'q029',
    prompt: 'A cat with urethral obstruction is presented 36 hours after the owner noticed straining. What kills first?',
    options: ['Hyperkalaemia', 'Uraemia', 'Metabolic acidosis', 'Dehydration'],
    answerIndex: 0,
    explanation:
      'Hyperkalaemia stops the heart. Check potassium and run an ECG before you do anything else, treat it if the trace is abnormal, and then relieve the obstruction. The uraemia and the acidosis resolve once the obstruction is relieved.',
    topic: 'Emergency medicine',
    species: 'cat',
    source: "Ettinger's 8e; Merck 11e",
  },
  {
    id: 'q030',
    prompt: 'Which is the most appropriate first-line empirical antibiotic for uncomplicated canine superficial pyoderma?',
    options: ['Cephalexin', 'Enrofloxacin', 'Ceftriaxone', 'Vancomycin'],
    answerIndex: 0,
    explanation:
      'Cephalexin is the right narrow-spectrum first choice for cytology-confirmed superficial pyoderma. A fluoroquinolone or a third-generation cephalosporin is a Watch-group drug that should be reserved for culture-confirmed need, and vancomycin has no place in veterinary first-line practice.',
    topic: 'Antimicrobial stewardship',
    species: 'dog',
    source: "Papich 5e; WHO AWaRe guidance",
  },
  {
    id: 'q031',
    prompt: 'A dog presents with polyuria, polydipsia, a pot belly and symmetrical truncal alopecia. Which test confirms the diagnosis?',
    options: [
      'Low-dose dexamethasone suppression test',
      'A single resting cortisol',
      'A urine cortisol:creatinine ratio alone',
      'A thyroid panel',
    ],
    answerIndex: 0,
    explanation:
      'A single cortisol is too variable to diagnose Cushing\'s, and the urine cortisol:creatinine ratio has a high sensitivity but a low specificity — a normal result excludes the disease, an abnormal one does not confirm it. The low-dose dexamethasone suppression test (or an ACTH stimulation test for monitoring) is the diagnostic step.',
    topic: 'Endocrinology',
    species: 'dog',
    source: "Ettinger's 8e; Merck 11e",
  },
  {
    id: 'q032',
    prompt: 'When must you never use an antiemetic?',
    options: [
      'Until a gastrointestinal obstruction has been excluded',
      'In any vomiting dog',
      'Alongside intravenous fluids',
      'In a cat with kidney disease',
    ],
    answerIndex: 0,
    explanation:
      'Maropitant or ondansetron will quieten the vomiting of a foreign body, and that is the sign that would have sent the dog to surgery. Rule out obstruction first — antiemetics suppress the sign, not the disease.',
    topic: 'Internal medicine',
    species: 'all',
    source: "Plumb's p.780; Merck 11e",
  },
  {
    id: 'q033',
    prompt: 'Which is true of enrofloxacin dosing in cats?',
    options: [
      'The daily dose must not exceed 5 mg/kg because of the risk of retinal degeneration',
      'Cats need higher doses than dogs because they clear it faster',
      'It is safe to use at any dose in kittens',
      'It is the first-line agent for feline cystitis',
    ],
    answerIndex: 0,
    explanation:
      'Fluoroquinolone retinal degeneration in cats is dose-dependent and irreversible. The 5 mg/kg/day ceiling is a hard limit rather than a starting point, and the class should be reserved for culture-confirmed need in any case.',
    topic: 'Pharmacology',
    species: 'cat',
    source: "Plumb's p.508; Papich 5e",
  },
  {
    id: 'q034',
    prompt: 'Which preventive measure most reduces periparturient hypocalcaemia in a dairy herd?',
    options: [
      'A low-calcium or anionic-salt ration in the close-up dry period',
      'Increasing dietary calcium in the dry period',
      'Injecting every cow with calcium at calving',
      'Delaying the first milking after calving',
    ],
    answerIndex: 0,
    explanation:
      'Feeding a low-calcium or acidogenic ration pre-calving upregulates parathyroid hormone and osteoclast activity, so the cow can mobilise calcium at the onset of lactation. High pre-calving dietary calcium does the opposite, and blanket calcium injection treats the cow you already failed.',
    topic: 'Herd health',
    species: 'cattle',
    source: "Smith's 4e; Merck (food animal)",
  },
  {
    id: 'q035',
    prompt: 'A foal scours at 10 days of age. Which pathogen is most likely if the farm has a Cryptosporidium problem?',
    options: ['Cryptosporidium parvum', 'E. coli K99', 'Salmonella', 'Coccidia'],
    answerIndex: 0,
    explanation:
      'The age narrows the list: enterotoxigenic E. coli in the first 4 days, rotavirus, coronavirus and Cryptosporidium at 5–14 days, and coccidiosis from about 3 weeks. Cryptosporidium is also zoonotic, so hygiene advice matters as much as the treatment.',
    topic: 'Large animal medicine',
    species: 'horse',
    source: "Smith's 4e; Merck (food animal)",
  },
  {
    id: 'q036',
    prompt: 'Which statement about tramadol in dogs is most accurate?',
    options: [
      'Its analgesic effect is limited because dogs produce relatively little of the active M1 metabolite',
      'It is the strongest opioid available for dogs',
      'It is contraindicated in cats',
      'It provides profound visceral analgesia on its own',
    ],
    answerIndex: 0,
    explanation:
      'Dogs convert little tramadol to O-desmethyltramadol, so efficacy is inconsistent and it is best treated as an adjunct to an NSAID. It is used in cats (where absorption is good) and it is not a substitute for a full mu agonist in severe pain.',
    topic: 'Analgesia',
    species: 'dog',
    source: "Plumb's p.1383; Papich 5e",
  },
  {
    id: 'q037',
    prompt: 'What is the single most important instruction when dispensing sucralfate alongside other oral medications?',
    options: [
      'Give sucralfate at least two hours apart from every other oral drug',
      'Give it with food to reduce nausea',
      'Crush it and mix it with milk',
      'Give it last in the sequence',
    ],
    answerIndex: 0,
    explanation:
      'Sucralfate binds fluoroquinolones, tetracyclines, levothyroxine and several other drugs, and it needs an acidic pH to activate. Give it first, wait two hours, then give everything else — and write that instruction on the label.',
    topic: 'Pharmacology',
    species: 'all',
    source: "Plumb's p.1294",
  },
  {
    id: 'q038',
    prompt: 'A dairy cow has a hot, painful quarter, watery milk with clots, and a temperature of 39.9 °C. What is the single most valuable test before starting therapy?',
    options: [
      'Milk culture and sensitivity',
      'A California Mastitis Test alone',
      'A blood culture',
      'A somatic cell count on the bulk tank',
    ],
    answerIndex: 0,
    explanation:
      'Culture and sensitivity turns the treatment from a guess into a decision, and it is the only way to know whether that quarter needs an antibiotic at all. The CMT detects subclinical disease at cow level; the bulk tank describes the herd, not this cow.',
    topic: 'Herd health',
    species: 'cattle',
    source: "Merck (food animal); Smith's 4e",
  },
  {
    id: 'q039',
    prompt: 'Which statement about rabies vaccination is correct?',
    options: [
      'It is a core vaccine and is legally required in most jurisdictions',
      'It can be skipped for indoor-only cats',
      'It provides lifelong immunity from a single dose',
      'It is only needed before international travel',
    ],
    answerIndex: 0,
    explanation:
      'Rabies is fatal and zoonotic, and the legal position overrides most other considerations. Indoor cats escape, outdoor cats fight, and a single dose does not confer lifelong immunity. Check the local interval and the local law.',
    topic: 'Preventive medicine',
    species: 'all',
    source: "Greene's 5e; WSAVA guidelines",
  },
  {
    id: 'q040',
    prompt: 'A cow that grunts on expiration when you pinch her withers most likely has which condition?',
    options: [
      'Traumatic reticuloperitonitis',
      'Simple indigestion',
      'Milk fever',
      'Ruminal acidosis without complications',
    ],
    answerIndex: 0,
    explanation:
      'A grunt on a withers pinch or a pole test is the classic response to the pain of hardware disease. Confirm with a metal detector or radiography, and treat with a magnet, antibiotics and an NSAID, or a rumenotomy where the object needs removing.',
    topic: 'Large animal medicine',
    species: 'cattle',
    source: "Smith's 4e; Merck (food animal)",
  },
];

/** Deterministic daily set: five questions keyed to the day of the year. */
export function dailyChallenge(date = new Date()): ChallengeQuestion[] {
  const start = Date.UTC(date.getUTCFullYear(), 0, 0);
  const dayOfYear = Math.floor((date.getTime() - start) / 86400000);
  const out: ChallengeQuestion[] = [];
  for (let i = 0; i < 5; i += 1) {
    out.push(CHALLENGES[(dayOfYear * 5 + i) % CHALLENGES.length]);
  }
  return out;
}

export function shuffledChallenges(seed: number, count = 10): ChallengeQuestion[] {
  const copy = [...CHALLENGES];
  let s = seed;
  const rand = () => {
    s = (s * 1664525 + 1013904223) % 4294967296;
    return s / 4294967296;
  };
  for (let i = copy.length - 1; i > 0; i -= 1) {
    const j = Math.floor(rand() * (i + 1));
    [copy[i], copy[j]] = [copy[j], copy[i]];
  }
  return copy.slice(0, count);
}
