import type { ClinicalNote } from '../types';

/**
 * Clinical notes: the distilled, searchable reference material.
 *
 * Each note carries its alerts up front — the things that change management —
 * and its citations at the bottom. Notes are written to be read on a phone
 * between a tailgate and a consultation.
 */
export const NOTES: ClinicalNote[] = [
  {
    id: 'note-dehydration',
    title: 'Assessing and replacing dehydration',
    category: 'Fluid therapy',
    species: ['dog', 'cat', 'cattle', 'sheep', 'goat', 'pig', 'horse'],
    summary:
      'How to grade dehydration on clinical signs, translate it into a fluid deficit, and phase the replacement plan so the deficit is corrected faster than maintenance.',
    alerts: [
      'Never start an NSAID or an aminoglycoside in a dehydrated patient — correct the perfusion deficit first.',
      'At 10% dehydration or more, consider a shock bolus and reassess before the replacement phase.',
      'Cats over-perfuse easily: watch the respiratory rate and auscultate for a gallop rhythm.',
    ],
    sections: [
      {
        heading: 'The clinical grading ladder',
        body: [
          'Dehydration is estimated from the physical examination and is always an approximation. Over-estimating is common in a thin animal with poor skin turgor; under-estimating is common in an obese one.',
          'Reassess every 4–6 hours. The examination findings, the body weight and the urine output tell you more than the first calculation does.',
        ],
        table: {
          head: ['Dehydration', 'Clinical signs'],
          rows: [
            ['0%', 'Euhydrated; normal skin turgor; moist mucous membranes'],
            ['5%', 'Slight; mildly tacky mucous membranes; minimal skin tent'],
            ['7%', 'Moderate; dry mucous membranes; skin tent 2–3 s; mildly sunken eyes; slight lethargy'],
            ['8%', 'Moderate–severe; skin tent 3–5 s; sunken eyes; tachycardia'],
            ['10%', 'Severe; very dry membranes; skin tent >5 s; sunken eyes; weak pulse'],
            ['12%', 'Hypovolaemic shock; cold extremities; CRT >3 s; altered mentation; collapsed veins'],
          ],
        },
      },
      {
        heading: 'The arithmetic',
        body: [
          'Deficit (mL) = body weight (kg) × dehydration (%) × 10.',
          'Maintenance (mL/day) = body weight (kg) × maintenance rate (mL/kg/day), commonly 50–70 in an adult dog, 50–65 in a cat and 60–100 in cattle.',
          'Total = deficit + maintenance for the period + ongoing losses.',
          'Rate (mL/h) = total ÷ hours. Drops per minute = mL/h × drop factor ÷ 60.',
        ],
      },
      {
        heading: 'Phasing the plan',
        body: [
          'The deficit is replaced faster than maintenance: roughly a quarter of the window, up to six hours, then the remainder runs at maintenance plus ongoing losses.',
          'A 20 kg dog at 8% dehydration over 24 hours has a 1600 mL deficit replaced over 6 hours at 267 mL/h, then 1200 mL of maintenance over 18 hours at 67 mL/h. The average rate of 117 mL/h hides both numbers.',
          'Ongoing losses — vomiting, diarrhoea, a drain — are measured and replaced on top, not absorbed into the estimate.',
        ],
      },
      {
        heading: 'Choosing the fluid',
        body: [
          'A balanced isotonic crystalloid (Lactated Ringer\'s, Plasma-Lyte 148) is the default. 0.9% NaCl is acceptable and is the right choice where there is a metabolic alkalosis or hypochloraemia.',
          'Hypertonic saline (4–5 mL/kg IV) buys rapid volume expansion in adult cattle and in a horse with colic while isotonic fluids are set up.',
          'Warm the fluids. A small or exotic patient cannot thermoregulate under a cold infusion.',
        ],
      },
    ],
    sources: ['merck', 'dibartola'],
    lastReviewed: '2026-10-01',
  },
  {
    id: 'note-nsaid-safety',
    title: 'NSAID safety: the rules that prevent disasters',
    category: 'Preventive medicine',
    species: ['dog', 'cat', 'cattle', 'goat', 'horse', 'pig'],
    summary:
      'The washout rules, the species contraindications and the monitoring plan that keep non-steroidal anti-inflammatories from causing the harm they are famous for.',
    alerts: [
      'Never combine two NSAIDs, and never combine an NSAID with a corticosteroid.',
      'Wash out for 5–7 days when switching between NSAIDs.',
      'Cats: a single peri-operative meloxicam dose is the USA label. Repeat dosing causes fatal acute kidney injury.',
      'Never dose a dehydrated, hypotensive or azotaemic patient.',
    ],
    sections: [
      {
        heading: 'Before the first dose',
        body: [
          'Correct the perfusion deficit. Most NSAID nephrotoxicity is a hydration failure wearing a drug label.',
          'Check the renal values and the liver enzymes in any animal going onto chronic therapy, and repeat at 2–4 weeks.',
          'Review the whole prescription for a corticosteroid, another NSAID, an ACE inhibitor, a diuretic or an aminoglycoside.',
          'Stop NSAIDs at least 5 days before elective surgery so COX activity recovers and intra-operative bleeding falls.',
        ],
      },
      {
        heading: 'The washout rule',
        body: [
          'Switching from one NSAID to another needs a 5–7 day gap. The combination produces additive GI ulceration and renal injury without any additional analgesia.',
          'Where an animal has already received both by mistake, stop one immediately, start gastroprotection and monitor renal values.',
        ],
        table: {
          head: ['Situation', 'Action'],
          rows: [
            ['Two NSAIDs given together', 'Stop one; gastroprotection; monitor renal values and stool'],
            ['NSAID plus a corticosteroid', 'Stop both; gastroprotection; never restart the combination'],
            ['NSAID plus an ACE inhibitor or diuretic', 'Additive renal risk — ensure hydration and monitor renal values'],
            ['NSAID before elective surgery', 'Stop at least 5 days before'],
          ],
        },
      },
      {
        heading: 'Species specifics',
        body: [
          'Cats: single peri-operative meloxicam only in the USA. Use buprenorphine or robenacoxib where ongoing analgesia is needed.',
          'Cattle: meloxicam 0.5 mg/kg SC as a single dose, with a 15-day meat and 120-hour milk withdrawal. Do not use in calves under 8 weeks.',
          'Goats and sheep: extra-label, so extend the cattle withdrawal conservatively and confirm with FARAD.',
          'Horses: phenylbutazone and flunixin are limited by right dorsal colitis. Use the lowest effective dose and duration.',
          'Birds: NSAID nephrotoxicity is the leading cause of death in raptor rehabilitation. Use the low end of the range with hydration support.',
        ],
      },
      {
        heading: 'When it goes wrong',
        body: [
          'Stop the drug at the first sign of vomiting, anorexia or melaena.',
          'Decontaminate within 2 hours of a large ingestion, then give activated charcoal.',
          'IV fluid diuresis at 1.5–2× maintenance for 48–72 hours to protect the kidneys.',
          'Gastroprotection: omeprazole 1 mg/kg q12h, sucralfate 0.5–1 g PO q6–8h, and misoprostol 2–5 µg/kg PO q8h.',
          'Monitor renal values, electrolytes and the PCV daily for 5 days.',
        ],
      },
    ],
    sources: ['plumbs', 'papich'],
    lastReviewed: '2026-10-01',
  },
  {
    id: 'note-deworming',
    title: 'Deworming and anthelmintic resistance',
    category: 'Deworming',
    species: ['dog', 'cat', 'cattle', 'sheep', 'goat', 'pig', 'poultry', 'horse'],
    summary:
      'Strategic deworming that works with the parasite lifecycle, and the faecal egg count reduction test that tells you whether your drench is still working.',
    alerts: [
      'Dose by weight with scales or a weigh tape. Underdosing is how resistant worms are manufactured.',
      'Goats metabolise anthelmintics faster than sheep and cattle — the cattle dose underdoses them.',
      'Never give ivermectin to a chelonian, and never give a macrocyclic dose to an MDR1-mutant dog.',
    ],
    sections: [
      {
        heading: 'The faecal egg count reduction test',
        body: [
          'Take a faecal egg count on the day of treatment, and again 10–14 days later.',
          'A reduction below 95% indicates resistance. Below 90% is serious, and it usually means the whole drench class is failing.',
          'Test the group, not the individual: 10–15 animals or a pooled sample gives a usable answer at farm or yard level.',
          'Treatment failure has three causes: the drug, the dose, and the diagnosis. The FECRT separates the first two from the third.',
        ],
      },
      {
        heading: 'Choosing an anthelmintic',
        body: [
          'Fenbendazole has the widest margin of safety and is the benzimidazole of choice in pregnancy.',
          'Albendazole covers adult liver fluke and tapeworm segments, but it is teratogenic and myelotoxic in dogs.',
          'Praziquantel is the cestocide of choice, and treating tapeworm without treating fleas guarantees a recurrence within three weeks.',
          'Ivermectin covers nematodes and most ectoparasites, but resistance in small ruminants is widespread and the goat dose is higher than the sheep dose.',
        ],
        table: {
          head: ['Species', 'Dose note'],
          rows: [
            ['Cattle', 'Ivermectin 0.2 mg/kg SC, 35-day meat withdrawal; fenbendazole 5–10 mg/kg PO, 8-day meat withdrawal'],
            ['Sheep', 'Ivermectin 0.2 mg/kg PO, 11-day meat withdrawal'],
            ['Goats', 'Ivermectin 0.3–0.4 mg/kg PO — higher than sheep, because goats clear it faster'],
            ['Pigs', 'Ivermectin 0.3 mg/kg SC, 18-day meat withdrawal'],
            ['Dogs', 'Fenbendazole 50 mg/kg PO daily for 3 days; heartworm prevention at 0.006 mg/kg monthly'],
            ['Cats', 'Fenbendazole 50 mg/kg PO daily for 3–5 days'],
          ],
        },
      },
      {
        heading: 'Strategic timing',
        body: [
          'Treat on the lifecycle, not on the calendar. In small ruminants, treat the periparturient rise and target the refugia by leaving a proportion of the group untreated.',
          'Quarantine and treat new arrivals with an effective combination, then hold them off the pasture until the eggs have cleared.',
          'Rotate drench classes between seasons, not within a course — and never stack two benzimidazoles.',
        ],
      },
    ],
    sources: ['merck-large', 'papich', 'carpenter'],
    lastReviewed: '2026-10-01',
  },
  {
    id: 'note-toxicology-first-hour',
    title: 'The first hour of a poisoning',
    category: 'Toxicology',
    species: ['dog', 'cat', 'cattle', 'sheep', 'goat', 'pig', 'horse'],
    summary:
      'What to do in the first sixty minutes, which antidotes are time-critical, and when decontamination does more harm than good.',
    alerts: [
      'Decontamination closes within hours: emesis is only useful in the first 2 hours.',
      'Never induce emesis in an obtunded, seizuring or caustic-ingestion patient — protect the airway instead.',
      'Fomepizole for ethylene glycol, N-acetylcysteine for paracetamol, vitamin K1 for rodenticide: give them before the laboratory confirms it.',
    ],
    sections: [
      {
        heading: 'The sequence',
        body: [
          'Stabilise first: airway, breathing, circulation, then the specific treatment. A convulsing animal cannot be made to vomit safely.',
          'Identify the agent, the amount and the time. The owner\'s photograph of the packet is worth more than a guess.',
          'Decontaminate if the window is open and the airway is protected.',
          'Give the antidote where one exists, and start the supportive care that carries the animal through anyway.',
        ],
        table: {
          head: ['Toxin', 'Antidote', 'Window'],
          rows: [
            ['Ethylene glycol', 'Fomepizole 20 mg/kg IV then 15 mg/kg at 12 and 24 h', 'Best within 8–12 h'],
            ['Paracetamol (cats)', 'N-acetylcysteine 140 mg/kg then 70 mg/kg q6h × 5–7', 'First 8–12 h'],
            ['Anticoagulant rodenticide', 'Vitamin K1 2.5–5 mg/kg SC, then PO for 3–4 weeks', 'Give before the clotting fails'],
            ['Organophosphate', 'Atropine to dry the secretions ± pralidoxime 20–50 mg/kg', 'Pralidoxime within 24 h'],
            ['Metaldehyde', 'No antidote — control the tremor and cool the patient', 'Supportive'],
            ['Permethrin (cats)', 'IV lipid emulsion 1.5 mL/kg then 0.25 mL/kg/min', 'Early'],
            ['Nitrate/nitrite', 'Methylene blue 1–4 mg/kg IV', 'Early'],
            ['Urea (ruminants)', 'Cold water + dilute acetic acid into the rumen', 'Within the first hour'],
          ],
        },
      },
      {
        heading: 'Activated charcoal',
        body: [
          'Dose 1–2 g/kg by mouth. It binds most organic toxins but not metals, alcohols, xylitol or lithium.',
          'Repeat every 6–8 hours for toxins with enterohepatic recirculation — theobromine, ivermectin, metaldehyde and many NSAIDs.',
          'Never give charcoal to a patient that cannot protect its airway, and never give it instead of an antidote that exists.',
        ],
      },
      {
        heading: 'What not to do',
        body: [
          'Do not induce emesis with a sharp or caustic material, or in a patient with a reduced conscious level.',
          'Do not use apomorphine in a cat — use an alpha-2 or a mechanical stimulus instead.',
          'Do not give milk, oil or salt: they do not help and several of them make the absorption worse.',
          'Do not treat the packet and forget the patient: supportive care is what gets most of these animals home.',
        ],
      },
    ],
    sources: ['plumbs', 'merck'],
    lastReviewed: '2026-10-01',
  },
  {
    id: 'note-breeding-cattle',
    title: 'Bovine reproductive timing and the calving-to-conception interval',
    category: 'Breeding',
    species: ['cattle', 'buffalo'],
    summary:
      'The oestrous cycle, the practical serving and pregnancy diagnosis windows, and the transition-cow management that determines whether the next lactation pays for itself.',
    alerts: [
      'A retained placenta is common after an induced or assisted calving, and it costs the next calving interval.',
      'Never give oxytocin before obstruction and cervical dilation have been excluded — a ruptured uterus follows.',
      'The 60-day calving-to-first-service interval, not the conception rate, is where most herds lose money.',
    ],
    sections: [
      {
        heading: 'The cycle in practice',
        body: [
          'The bovine oestrous cycle is 18–24 days, with standing heat lasting 8–18 hours and ovulation roughly 24–32 hours after the onset of standing heat.',
          'Serve on the a.m./p.m. rule: an animal seen in standing heat in the morning is served that afternoon, and vice versa.',
          'Heat detection is the single largest cause of poor fertility in most herds. A tail-paint or activity-monitoring system pays for itself in detection rate, not in conception rate.',
        ],
        table: {
          head: ['Event', 'Timing'],
          rows: [
            ['Oestrous cycle length', '18–24 days (mean 21)'],
            ['Standing heat duration', '8–18 hours'],
            ['Ovulation after standing heat', '24–32 hours'],
            ['Pregnancy diagnosis by ultrasound', 'From 28–30 days'],
            ['Pregnancy diagnosis per rectum', 'From 35–45 days'],
            ['Gestation length', 'Around 280 days (breed-dependent)'],
            ['Voluntary waiting period', 'Typically 40–60 days'],
          ],
        },
      },
      {
        heading: 'Calving and the postpartum period',
        body: [
          'Stage 2 lasts 0.5–4 hours in a heifer and up to 2 hours in a cow. Intervention is indicated when there is no progress after 30 minutes of active straining.',
          'Examine before you pull, and before you give oxytocin: position, posture and presentation first, then traction.',
          'A clean, warm, dry calving pen and 3 L of colostrum in the first 2 hours are worth more than any intrauterine therapy.',
          'Record every calving: the date, the assistance score, the calf, and whether the placenta was passed within 12 hours.',
        ],
      },
      {
        heading: 'The transition period',
        body: [
          'Body condition score at calving of roughly 3.0–3.25 (5-point scale), and no more than 0.5 of condition lost in the dry period.',
          'A close-up ration with a controlled calcium and an appropriate dietary cation–anion difference upregulates the cow\'s own calcium mobilisation.',
          'Screen fresh cows with a ketone test at 5–14 days in milk. Subclinical ketosis costs more than the clinical cases you notice.',
        ],
      },
    ],
    sources: ['merck-large', 'smith'],
    lastReviewed: '2026-10-01',
  },
  {
    id: 'note-anaesthesia-checklist',
    title: 'The safe anaesthetic: a working checklist',
    category: 'Anaesthesia',
    species: ['dog', 'cat', 'rabbit', 'bird', 'ferret'],
    summary:
      'Premedication, induction, monitoring and recovery — the sequence that prevents the predictable complications, and the drugs to have drawn up before you start.',
    alerts: [
      'Have the reversal agent drawn up before you give the drug, not after you need it.',
      'Xylazine-associated hypotension is never treated with epinephrine — it sensitises the myocardium to arrhythmia.',
      'Reversal removes analgesia as well as sedation. Plan the analgesia before you reverse.',
      'Wait 30–40 minutes after ketamine before reversing an alpha-2, or the recovery will be violent.',
    ],
    sections: [
      {
        heading: 'Before induction',
        body: [
          'History, examination, and the fasting status — 6–12 hours for an adult dog or cat, and far less for a neonate or a small exotic patient, which cannot afford the hypoglycaemia.',
          'Weigh the patient. Every drug in the protocol is calculated on the weight you measured today.',
          'Place the intravenous catheter, check the airway equipment and the breathing system, and set up the monitoring.',
          'Draw up the emergency drugs: atropine, a benzodiazepine, epinephrine and the reversal agents.',
        ],
      },
      {
        heading: 'A balanced protocol',
        body: [
          'Premedication with an opioid and a sedative reduces the induction and maintenance doses and improves the analgesia.',
          'Induce with propofol or alfaxalone to effect — the calculated dose is a plan and intubation is the endpoint.',
          'Maintain on an inhalant agent with oxygen, using the lowest vaporiser setting that keeps the patient still and the blood pressure adequate.',
          'Add a local or regional block wherever the surgery allows it. A testicular block, a dental block or a line block changes the whole recovery.',
        ],
        table: {
          head: ['Stage', 'Common choice', 'Note'],
          rows: [
            ['Premedication', 'An opioid plus an alpha-2 or an acepromazine', 'Reduce doses in a compromised patient'],
            ['Induction', 'Propofol 4–6 mg/kg IV to effect in dogs', 'Cats need more and recover more slowly'],
            ['Maintenance', 'Isoflurane or sevoflurane in oxygen', 'MAC falls sharply with premedication'],
            ['Analgesia', 'An NSAID plus an opioid, and a local block', 'Multimodal beats a higher dose of one drug'],
            ['Reversal', 'Atipamezole at 5× the medetomidine µg/kg', 'Equal volumes for medetomidine 1 mg/mL and atipamezole 5 mg/mL'],
          ],
        },
      },
      {
        heading: 'Monitoring and recovery',
        body: [
          'Record the heart rate, respiratory rate, blood pressure, oxygen saturation, capnography and temperature every 5 minutes.',
          'Treat hypotension with fluids first, then a reduction in the vaporiser, then a vasopressor — in that order.',
          'Keep the patient warm. Hypothermia slows the recovery and every drug clearance that depends on it.',
          'Recovery is a monitored phase: a padded cage, a quiet room, and a pain score before the patient goes home.',
        ],
      },
      {
        heading: 'Species cautions',
        body: [
          'Rabbits: difficult to intubate and prone to apnoea — pre-oxygenate and have the tube ready.',
          'Birds: lose heat rapidly; warm the fluids and keep the ambient temperature up.',
          'Reptiles: never anaesthetise a cold reptile — the drug clearance depends on the temperature.',
          'Brachycephalic dogs: the recovery is the dangerous part. Extubate late and watch them closely afterwards.',
        ],
      },
    ],
    sources: ['veterinary-anaesthesia', 'papich'],
    lastReviewed: '2026-10-01',
  },
  {
    id: 'note-mastitis-control',
    title: 'Mastitis control at herd level',
    category: 'Preventive medicine',
    species: ['cattle', 'buffalo', 'goat', 'sheep'],
    summary:
      'Subclinical mastitis costs more than the clinical cases you treat. This note covers the somatic cell count, the milking routine, and the dry-cow decisions that move the herd number.',
    alerts: [
      'Treat on culture, not on habit: a large proportion of clinical cases in low-cell-count herds are culture-negative and need no antibiotic.',
      'Never treat a food animal without recording the withdrawal date for both meat and milk.',
      'Chronic cows are a culling decision, not a treatment decision.',
    ],
    sections: [
      {
        heading: 'Reading the herd number',
        body: [
          'Somatic cell count is the herd\'s mastitis scoreboard. A bulk-tank count above roughly 200,000 cells/mL means around 6–8% of the milk is being lost.',
          'Individual cow cell counts identify the chronic shedders. A cow above 200,000 on two consecutive tests is the one infecting the rest.',
          'Clinical mastitis incidence is a separate metric: aim for under 20–25 cases per 100 cows per year in a well-managed herd.',
        ],
        table: {
          head: ['Metric', 'Target'],
          rows: [
            ['Bulk tank somatic cell count', 'Below 200,000 cells/mL'],
            ['Individual cow cell count (subclinical threshold)', 'Above 200,000 cells/mL'],
            ['Clinical mastitis incidence', 'Below 20–25 cases per 100 cows per year'],
            ['New infection rate over the dry period', 'Below 10% of quarters'],
            ['Proportion of the herd culled for mastitis', 'Below 3% per year'],
          ],
        },
      },
      {
        heading: 'The milking routine',
        body: [
          'Fore-strip, pre-dip, wipe dry with a single-use cloth, attach within 90 seconds of the first stimulation.',
          'Post-milking teat disinfection on every quarter, every milking — this is the single most effective control measure there is.',
          'Test the plant: vacuum level, pulsation and liner condition. A liner that is past its change interval undoes the whole routine.',
          'Milk the healthy cows first and the known high-cell-count and clinical cows last, or on a separate unit.',
        ],
      },
      {
        heading: 'Dry cow and culling decisions',
        body: [
          'Dry-cow therapy plus an internal teat sealant at drying off is the most effective way to prevent new dry-period infections.',
          'Selective dry-cow therapy is appropriate where the herd cell count is low and the individual cow records are good.',
          'Cull the chronically infected cow: she is a reservoir, she is expensive, and the economics rarely argue for a fourth lactation.',
        ],
      },
    ],
    sources: ['merck-large', 'smith'],
    lastReviewed: '2026-10-01',
  },
  {
    id: 'note-neonatal-care',
    title: 'Neonatal care: the first 24 hours',
    category: 'Neonatology',
    species: ['dog', 'cat', 'cattle', 'sheep', 'goat', 'pig'],
    summary:
      'Colostrum, warmth, glucose and hygiene — the four things that determine whether a neonate survives, in that order.',
    alerts: [
      'Colostrum: 3 L in the first 2 hours for a calf, and 10% of body weight in the first 12 hours.',
      'Never assume a weak neonate is cold — a septic neonate is often hypothermic, and both need treating.',
      'Hypoglycaemia kills quietly: check the glucose in any weak, quiet or fitting neonate.',
    ],
    sections: [
      {
        heading: 'Colostrum',
        body: [
          'Passive transfer closes progressively: gut absorption of immunoglobulin falls steeply after 6 hours and stops by roughly 24 hours.',
          'Feed clean, tested colostrum from the dam where possible, and frozen colostrum from a known high-quality donor where it is not.',
          'Measure the failure: a serum total protein below roughly 5.2 g/dL or a Brix refractometer reading below 8.4% indicates failure of passive transfer in a calf.',
          'A neonate that has failed passive transfer needs plasma within the first 24 hours, and a hard look at the colostrum protocol on the farm.',
        ],
      },
      {
        heading: 'Warmth and glucose',
        body: [
          'A wet, cold neonate cannot digest colostrum. Dry it, warm it, and then feed it.',
          'Neonates have almost no hepatic glycogen reserve: any stress, cold or missed feed produces hypoglycaemia within hours.',
          'Give dextrose for a documented hypoglycaemia — 0.5–1 g/kg diluted, slowly IV in a small animal, or by mouth in a stable neonate.',
          'Keep the environmental temperature in the thermoneutral zone: a chilled pup, kitten or piglet does not feed, does not digest, and dies.',
        ],
      },
      {
        heading: 'Hygiene and the navel',
        body: [
          'Dip the navel in 7% iodine or chlorhexidine within the first hour, and repeat at 6–12 hours.',
          'A clean, dry, draught-free bed with fresh bedding daily. Most neonatal scour is a housing problem with a pathogen attached.',
          'Watch the joints and the umbilicus: a swollen joint or a moist, painful navel in a neonate is septicaemia until proven otherwise.',
        ],
      },
    ],
    sources: ['merck-large', 'smith', 'merck'],
    lastReviewed: '2026-10-01',
  },
  {
    id: 'note-wound-management',
    title: 'Wound management and the golden period',
    category: 'Surgery',
    species: ['dog', 'cat', 'horse', 'cattle'],
    summary:
      'Lavage, debridement, the decision to close, and the timing rule that separates a primary closure from a delayed one.',
    alerts: [
      'The golden period is 6–8 hours: a fresh, clean wound can be closed primarily, an older or contaminated one usually cannot.',
      'Lavage with a large volume of a balanced isotonic solution — concentrated antiseptics damage the granulation tissue.',
      'A horse or a ruminant with a wound is a tetanus risk: check the vaccination status and boost it.',
    ],
    sections: [
      {
        heading: 'The first pass',
        body: [
          'Stabilise the patient before you look at the wound. A wound is almost never the thing that kills the animal in the first hour.',
          'Clip widely, cover the wound with a water-soluble gel while you prepare the surrounding skin, then lavage copiously.',
          'Debride conservatively at the first pass: tissue that looks marginal often declares itself over the next 48 hours.',
          'Culture a deep swab only after the lavage, and never from the surface of an open wound.',
        ],
      },
      {
        heading: 'To close or not to close',
        body: [
          'Close primarily when the wound is fresh, clean and can be closed without tension.',
          'Delay closure where the wound is contaminated, older than 6–8 hours, has dead space, or where there is crush or avascular tissue.',
          'Drain dead space. A seroma is a culture medium with a suture line over it.',
          'On the distal limb of a horse, expect to close late or to leave it to granulate and contract — the tension and the movement defeat most primary closures.',
        ],
        table: {
          head: ['Decision', 'Indication'],
          rows: [
            ['Primary closure', 'Fresh (<6–8 h), clean, tension-free, no dead space'],
            ['Delayed primary closure', 'Contaminated or marginal tissue — reassess at 3–5 days and close if it looks clean'],
            ['Second intention', 'Extensive tissue loss, heavy contamination, or a distal limb in a horse'],
            ['Reconstruction', 'A defect that cannot be closed without tension — a flap or a graft is kinder than a tight suture line'],
          ],
        },
      },
      {
        heading: 'Aftercare',
        body: [
          'Protect the wound from the patient: a collar is cheaper than a re-operation.',
          'Analgesia is not optional, and it is multimodal: an NSAID plus an opioid plus a local block where the site allows.',
          'Review at 48 hours, then every 2–3 days until the epithelialisation is complete.',
          'Antibiotics are for the contaminated or infected wound, not for every wound that gets sutured.',
        ],
      },
    ],
    sources: ['fossum', 'merck'],
    lastReviewed: '2026-10-01',
  },
  {
    id: 'note-antimicrobial-stewardship',
    title: 'Antimicrobial stewardship in practice',
    category: 'Preventive medicine',
    species: ['dog', 'cat', 'cattle', 'sheep', 'goat', 'pig', 'poultry', 'horse'],
    summary:
      'How to choose a narrow agent first, when to culture, what to record, and the specific drugs that are never appropriate in a food animal.',
    alerts: [
      'Fluoroquinolones and third-generation cephalosporins are WHO AWaRe Watch-group drugs: reserve them for culture-confirmed need.',
      'Metronidazole is prohibited in food animals in most jurisdictions. There is no withdrawal period that makes it legal.',
      'Phenylbutazone is prohibited in cattle in many jurisdictions because of the human residue risk.',
      'A three-day course of the right drug beats a ten-day course of the wrong one, and a seven-day course of the right one often beats three.',
    ],
    sections: [
      {
        heading: 'The decision sequence',
        body: [
          'Is there a bacterial infection at all? Cytology and culture exist for this, and most itchy skin and most diarrhoea is not bacterial.',
          'If yes, which narrow agent covers the likely organism? Cephalexin for canine pyoderma, amoxicillin-clavulanate for an abscess, and a potentiated sulfonamide for a susceptible UTI.',
          'Culture before you escalate. A culture taken after the first dose is a culture of the treated patient.',
          'De-escalate and shorten when the results return, and record the reason for every prescription in the notes.',
        ],
        table: {
          head: ['Group', 'Examples', 'Principle'],
          rows: [
            ['Access', 'Amoxicillin, ampicillin, cephalexin, oxytetracycline, TMS', 'First choice wherever susceptibility allows'],
            ['Watch', 'Enrofloxacin, marbofloxacin, ceftriaxone, cefovecin', 'Reserve for culture-confirmed need; higher resistance potential'],
            ['Reserve', 'Meropenem, imipenem, linezolid', 'Last resort, specialist-directed'],
            ['Prohibited in food animals', 'Metronidazole, phenylbutazone, chloramphenicol', 'No withdrawal period makes the use legal'],
          ],
        },
      },
      {
        heading: 'Getting the dose right',
        body: [
          'Weigh the animal. Underdosing selects for resistance and is the commonest dosing error in group treatments.',
          'Respect the interval. Beta-lactams are time-dependent: splitting the dose keeps the concentration above the MIC.',
          'Treat long enough and no longer. Superficial pyoderma needs 7 days past clinical cure; an uncomplicated UTI needs 7 days, not 3.',
          'Consider the route: a vomiting, hypoproteinaemic gut does not absorb oral drug reliably.',
        ],
      },
      {
        heading: 'In food animals',
        body: [
          'Use a product labelled for the species and the indication wherever one exists.',
          'Record the drug, the dose, the route, the date and the withdrawal date against the individual or the group.',
          'For an extra-label use, obtain an FARAD-derived withdrawal interval rather than an estimate from the cattle dose.',
          'Never use a Watch-group antimicrobial as a first-line empirical treatment in a herd or flock.',
        ],
      },
    ],
    sources: ['who-awares', 'papich', 'farad'],
    lastReviewed: '2026-10-01',
  },
  {
    id: 'note-diagnostics-approach',
    title: 'A structured approach to the undiagnosed case',
    category: 'Diagnostics',
    species: ['dog', 'cat', 'cattle', 'sheep', 'goat', 'horse'],
    summary:
      'A problem-oriented approach: localise the lesion, generate the differential list, run the tests that discriminate, and treat the most likely while you wait.',
    alerts: [
      'Treat the life-threatening problem before the diagnostic puzzle: perfusion, airway and the potassium come first.',
      'A test you cannot act on is not a test — it is a delay.',
      'Re-examine. The physical examination repeated at 4 and 12 hours finds more than the database does.',
    ],
    sections: [
      {
        heading: 'Localise, then list',
        body: [
          'Name the problem from the signs, not from the organ you suspect: "haemorrhagic diarrhoea" is a better problem statement than "a gut problem".',
          'Localise anatomically where you can: is this gastrointestinal, urinary, respiratory or systemic?',
          'Generate the differential list before the test results, and rank it. A test only means something against a prior probability.',
          'Use the mnemonic that fits the species — DAMNIT-V (degenerative, anomalous, metabolic, neoplastic, nutritional, inflammatory/infectious, traumatic, toxic, vascular) still works.',
        ],
      },
      {
        heading: 'Choose the tests that discriminate',
        body: [
          'Order the tests that separate the leading candidates, not the ones that are merely available.',
          'Minimum database first: PCV, total protein, glucose, urea or BUN, electrolytes and a urinalysis. It is cheap and it changes the plan more often than a panel does.',
          'Imaging answers "where" and cytology answers "what". Neither substitutes for the other.',
          'A therapeutic trial is a legitimate diagnostic test when the response is rapid, specific and monitored.',
        ],
        table: {
          head: ['Presentation', 'Highest-value first test'],
          rows: [
            ['Acute vomiting and diarrhoea in a pup', 'Faecal antigen ELISA, PCV, glucose, and imaging to exclude a foreign body'],
            ['Polyuria and polydipsia', 'Urinalysis with specific gravity, then biochemistry, then a fructosamine'],
            ['Anaemia', 'PCV and total protein, a blood smear, and a reticulocyte count'],
            ['Cough', 'Thoracic radiographs, then echocardiography or airway sampling as the films direct'],
            ['Downer cow', 'Calcium trial, then magnesium and phosphorus, then a full obstetric re-examination'],
            ['Flock or herd sudden death', 'A post-mortem on a fresh carcase before any other test'],
          ],
        },
      },
      {
        heading: 'Record and review',
        body: [
          'Write the problem list, the differential list and the plan in the notes, and date every entry.',
          'Set a review point before the animal leaves: a time, not a hope.',
          'When the case changes, rewrite the list. The diagnosis that is not working is usually the problem statement, not the drug.',
        ],
      },
    ],
    sources: ['ettinger', 'merck'],
    lastReviewed: '2026-10-01',
  },
];

export const NOTE_CATEGORIES = [
  'Toxicology',
  'Reference ranges',
  'Deworming',
  'Breeding',
  'Fluid therapy',
  'Anaesthesia',
  'Dermatology',
  'Surgery',
  'Neonatology',
  'Nutrition',
  'Preventive medicine',
  'Diagnostics',
];

export const NOTE_MAP: Record<string, ClinicalNote> = NOTES.reduce(
  (acc, n) => {
    acc[n.id] = n;
    return acc;
  },
  {} as Record<string, ClinicalNote>,
);

export function searchNotes(query: string): ClinicalNote[] {
  const q = query.trim().toLowerCase();
  if (!q) return NOTES;
  return NOTES.filter((n) => {
    if (n.title.toLowerCase().includes(q)) return true;
    if (n.category.toLowerCase().includes(q)) return true;
    if (n.summary.toLowerCase().includes(q)) return true;
    return n.sections.some((s) => s.heading.toLowerCase().includes(q) || s.body.join(' ').toLowerCase().includes(q));
  });
}
