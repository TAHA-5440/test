import type { ClinicalCase } from '../types';

/**
 * Professional cases: real-style cases logged decision by decision.
 *
 * Each step asks the clinician to commit to a decision before the next piece
 * of information arrives, and the feedback explains why the alternatives are
 * weaker. The score is a learning signal, not an exam mark.
 */
export const CASES: ClinicalCase[] = [
  {
    id: 'case-parvo-simba',
    title: 'Simba — the puppy with bloody diarrhoea',
    species: 'dog',
    system: 'Gastrointestinal',
    difficulty: 'Foundation',
    clinician: 'Dr Ananya Rao, small animal practice',
    signalment: 'Labrador Retriever pup, 4 months, 9 kg, male entire',
    presenting: 'Acute vomiting, bloody diarrhoea and lethargy since yesterday. Vaccination course incomplete.',
    vitals: [
      { label: 'Temperature', value: '40.1 °C', flag: 'high' },
      { label: 'Heart rate', value: '148 bpm', flag: 'high' },
      { label: 'CRT', value: '2.5 s', flag: 'high' },
      { label: 'Mucous membranes', value: 'Pale, tacky', flag: 'low' },
    ],
    steps: [
      {
        id: 's1',
        phase: 'History',
        prompt: 'What is the single most important question to ask first?',
        detail:
          'The vaccination and worming history, the diet, any access to rubbish or toxins, and whether the signs started before or after they began to vomit. Signalment and prevention status frame everything else.',
        findings: [
          'Two of three puppy vaccinations given; the last was at 10 weeks',
          'No worming since 8 weeks',
          'Acute onset, no previous episodes',
          'No toxin or foreign-body access reported, but the household bin is reachable',
        ],
        options: [
          { label: 'Vaccination and worming history', correct: true, feedback: 'Correct. An incompletely vaccinated pup with acute haemorrhagic gastroenteritis is parvoviral enteritis until proven otherwise, and it is the fastest test in the building.', score: 2 },
          { label: 'Dietary history in detail', feedback: 'Dietary indiscretion is common, but profuse haemorrhagic diarrhoea with depression in an unvaccinated pup is not a dietary picture. Ask the prevention questions first.', score: 0 },
          { label: 'Whether the vomiting came before the diarrhoea', feedback: 'The sequence is useful, but it rarely changes the first diagnostic step in this presentation.', score: 1 },
        ],
      },
      {
        id: 's2',
        phase: 'Examination',
        prompt: 'Examination finds 8% dehydration, abdominal pain and a temperature of 40.1 °C. What is the first intervention?',
        detail:
          'The pup is painful on abdominal palpation, the loops feel fluid-filled, and there is a pool of haemorrhagic faeces on the table. The mucous membranes are pale and tacky.',
        findings: [
          'Estimated dehydration 8%',
          'Tachycardia with a weak pulse',
          'Painful, fluid-distended intestinal loops',
          'Temperature 40.1 °C — fever, not hypothermia, which is prognostically better',
        ],
        options: [
          { label: 'Intravenous access and a balanced crystalloid fluid bolus', correct: true, feedback: 'Correct. Correcting the perfusion deficit comes before every other intervention, and it is also what makes the rest of the treatment work.', score: 2 },
          { label: 'A faecal antigen test before anything else', feedback: 'The test is important, but it takes minutes and can wait for the first few minutes of fluid therapy. Never let a test delay resuscitation.', score: 1 },
          { label: 'An NSAID for the fever', feedback: 'No. An NSAID in a dehydrated, hypovolaemic, possibly GI-ulcerating patient is how an acute kidney injury begins. Control the perfusion first.', score: 0 },
        ],
      },
      {
        id: 's3',
        phase: 'Diagnostics',
        prompt: 'The faecal antigen ELISA is positive. What does the minimum database add?',
        detail: 'The snap test is positive for CPV. You now need to know how sick this puppy actually is before you can plan the level of care.',
        findings: [
          'PCV 48% with a total protein of 42 g/L — haemoconcentration masking the real picture',
          'Glucose 3.1 mmol/L (56 mg/dL)',
          'White cell count 1.8 × 10⁹/L with a marked neutropenia',
          'Sodium 138, potassium 3.2 mmol/L',
        ],
        options: [
          { label: 'Severity, the electrolyte deficits, and the prognosis', correct: true, feedback: 'Correct. The leukopenia and the hypoglycaemia are the two findings that most change the management and the conversation with the owner.', score: 2 },
          { label: 'Confirmation of the diagnosis', feedback: 'The antigen test already confirmed it. The bloodwork is about severity, not confirmation.', score: 1 },
          { label: 'Nothing — the snap test is enough', feedback: 'A hypoglycaemic, neutropenic pup needs a different plan from one with normal values. The bloodwork is not optional.', score: 0 },
        ],
      },
      {
        id: 's4',
        phase: 'Decision',
        prompt: 'How do you cover the bacterial risk?',
        detail:
          'The gut barrier is breached, the neutrophil count is 1.8 × 10⁹/L, and the pup is bacteraemic until proven otherwise. You need parenteral cover against Gram-negatives and anaerobes.',
        findings: [
          'Marked neutropenia — the patient cannot defend itself',
          'Parenteral route essential: the gut will not absorb oral drug reliably',
          'The pup is over 8 weeks, so enrofloxacin is not absolutely excluded, but the MDR1 status of a Labrador is usually normal',
        ],
        options: [
          { label: 'IV ampicillin plus enrofloxacin, and reassess on the neutrophil count', correct: true, feedback: 'Correct. Broad parenteral cover against Gram-negatives and anaerobes, reserved further once the white cells recover.', score: 2 },
          { label: 'Oral metronidazole alone', feedback: 'Oral drug in a vomiting pup, and metronidazole alone does not cover the aerobic risk. The route and the spectrum are both wrong.', score: 0 },
          { label: 'Ceftriaxone as monotherapy', feedback: 'It covers the Gram-negative risk, but it is a third-generation Watch-group cephalosporin and it misses the anaerobic component. Ampicillin plus an aminoglycoside or a fluoroquinolone is the better empirical pair.', score: 1 },
        ],
      },
      {
        id: 's5',
        phase: 'Treatment',
        prompt: 'The vomiting is persistent. What is the analgesic and antiemetic plan?',
        detail: 'Maropitant is available, as is ondansetron. The pup is now rehydrated and the glucose has been corrected.',
        findings: [
          'Maropitant 1 mg/kg SC q24h is the label antiemetic',
          'Ondansetron is a reasonable second agent at 0.1–0.5 mg/kg IV q8–12h',
          'Pain on abdominal palpation persists',
          'Early enteral nutrition improves outcome once vomiting is controlled',
        ],
        options: [
          { label: 'Maropitant plus an opioid, and restart enteral feeding as soon as vomiting stops', correct: true, feedback: 'Correct. Maropitant acts at the emetic centre, an opioid covers the visceral pain, and early enteral nutrition shortens the hospital stay.', score: 2 },
          { label: 'Withhold all food for 48 hours', feedback: 'Outdated advice. The gut needs luminal nutrition to maintain the villi and the barrier, and starvation lengthens the hospitalisation.', score: 0 },
          { label: 'Metoclopramide as the sole agent', feedback: 'Metoclopramide is a poor antiemetic in this setting and it does nothing for the pain. Maropitant is the right first choice.', score: 1 },
        ],
      },
      {
        id: 's6',
        phase: 'Outcome',
        prompt: 'The neutrophil count recovers on day 4 and the pup is eating. What is the most important thing to tell the owner?',
        detail:
          'Simba goes home on day 5. The owner is relieved and wants to know when he can meet other dogs.',
        findings: [
          'Virus shedding continues for up to 10 days after clinical recovery',
          'The virus survives for months, and often years, in the environment',
          'Most household disinfectants do not inactivate parvovirus',
          'The vaccination course must be completed once the pup has recovered',
        ],
        options: [
          { label: 'Isolate him for at least 10 days, disinfect with a bleach-based product, and complete the vaccination course', correct: true, feedback: 'Correct. Shedding continues after recovery, the environment stays infectious for months, and the immunity gap that caused this needs closing.', score: 2 },
          { label: 'He is immune now, so the vaccination course can stop', feedback: 'Natural infection gives good immunity, but the course still needs completing on schedule for the other components and for the duration of protection.', score: 0 },
          { label: 'Return to the park as soon as he feels better', feedback: 'He is still shedding, and he is going into a park where other pups may be unvaccinated. Ten days of isolation is the standard advice.', score: 1 },
        ],
      },
    ],
    takeaways: [
      'An incompletely vaccinated pup with acute haemorrhagic gastroenteritis is parvoviral enteritis until the antigen test says otherwise.',
      'Resuscitation comes before diagnosis, and an NSAID has no place in a hypovolaemic vomiting patient.',
      'The leukopenia and the hypoglycaemia drive the management and the prognosis more than the virus does.',
      'Parenteral broad-spectrum cover, maropitant, opioid analgesia and early enteral nutrition are the four pillars.',
      'Isolation advice and environmental disinfection are part of the treatment, not an afterthought.',
    ],
    sources: ['merck', 'greene'],
  },
  {
    id: 'case-milk-fever',
    title: 'The fourth-lactation cow that will not rise',
    species: 'cattle',
    system: 'Metabolic',
    difficulty: 'Intermediate',
    clinician: 'Dr Harpreet Singh, dairy practice',
    signalment: 'Holstein-Friesian cow, fourth lactation, 12 hours post-calving, ~650 kg',
    presenting: 'Found in sternal recumbency in the calving pen, cold ears, head tucked into the flank, no interest in the calf.',
    vitals: [
      { label: 'Temperature', value: '37.4 °C', flag: 'low' },
      { label: 'Heart rate', value: '72 bpm', flag: 'normal' },
      { label: 'Respiratory rate', value: '28 /min', flag: 'normal' },
      { label: 'Rumen motility', value: 'Absent', flag: 'low' },
    ],
    steps: [
      {
        id: 's1',
        phase: 'History',
        prompt: 'Which part of the history is most useful?',
        detail:
          'A fourth-lactation dairy cow, 12 hours after an assisted calving for a large calf. The herd has had three milk fevers this season.',
        findings: [
          'Fourth lactation — peak risk for milk fever',
          'Assisted calving for a large calf',
          'Three other milk fevers in the herd this season',
          'Close-up ration not yet reviewed this year',
        ],
        options: [
          { label: 'Lactation number, stage post-calving, and the herd\'s transition history', correct: true, feedback: 'Correct. The signalment nearly diagnoses the case, and the herd pattern tells you this is a feeding problem rather than three unlucky cows.', score: 2 },
          { label: 'The calf\'s sex and birth weight', feedback: 'Useful for the calving records, but it does not change the immediate clinical decision.', score: 1 },
          { label: 'Whether she was vaccinated', feedback: 'Irrelevant to an acute metabolic recumbency at 12 hours post-calving.', score: 0 },
        ],
      },
      {
        id: 's2',
        phase: 'Examination',
        prompt: 'Examination confirms stage 2 milk fever. How do you give the calcium?',
        detail: 'She is sternal, has cold extremities, a tucked head and no rumen motility. You have 500 mL of 23% calcium borogluconate.',
        findings: [
          'Sternal recumbency with a head turned into the flank',
          'Cold ears and extremities',
          'Absent rumen motility',
          'No evidence of a calving injury on a quick vaginal check',
        ],
        options: [
          { label: 'Slowly, over 10–20 minutes, with the heart auscultated throughout', correct: true, feedback: 'Correct. The drug that saves her is the drug that kills her if it goes in fast. Monitor the heart for bradycardia and any arrhythmia.', score: 2 },
          { label: 'As a rapid IV bolus to correct the deficit quickly', feedback: 'No. A rapid calcium bolus causes bradycardia, arrhythmia and cardiac arrest. This is the classic iatrogenic death in a milk fever cow.', score: 0 },
          { label: 'Subcutaneously only, to avoid the cardiac risk', feedback: 'SC calcium is useful as a follow-up or for a standing cow, but this cow needs the intravenous dose now.', score: 1 },
        ],
      },
      {
        id: 's3',
        phase: 'Decision',
        prompt: 'She does not rise 15 minutes after the calcium. What next?',
        detail: 'The heart rate has improved, but she remains sternal. You have given what should have been an effective dose.',
        findings: [
          'Heart rate improved from 72 to 64 bpm',
          'Still sternal, still dull',
          'Mild improvement in the extremity temperature',
          'No attempt to rise',
        ],
        options: [
          { label: 'Check magnesium and phosphorus, and re-examine for a calving injury or a fracture', correct: true, feedback: 'Correct. A non-responder is no longer a simple milk fever. Hypomagnesaemia, hypophosphataemia and the obstetric damage from that assisted calving are all still on the list.', score: 2 },
          { label: 'Repeat the same calcium dose immediately', feedback: 'One careful repeat is reasonable after 15–20 minutes, but blind repetition without reassessing the diagnosis is how a cow ends up with a calcium-induced arrhythmia and no diagnosis.', score: 1 },
          { label: 'Give oxytocin and treat for a retained placenta', feedback: 'There is no evidence of a retained placenta, and oxytocin has no role in a recumbent cow that has just calved.', score: 0 },
        ],
      },
      {
        id: 's4',
        phase: 'Treatment',
        prompt: 'Magnesium is 0.5 mmol/L (low). What is the plan?',
        detail: 'Calcium alone has partly corrected the picture but magnesium is clearly low. She is now showing a mild muscle tremor.',
        findings: [
          'Magnesium 0.5 mmol/L — below the 0.8 mmol/L target',
          'Mild muscle tremor appearing',
          'Still sternal but more alert',
          'Phosphorus also low at 0.9 mmol/L',
        ],
        options: [
          { label: 'Magnesium sulfate or a combined calcium–magnesium–phosphorus preparation IV slowly, with cardiac monitoring', correct: true, feedback: 'Correct. A hypomagnesaemic cow will not rise on calcium alone, and the combined product addresses all three deficits under monitoring.', score: 2 },
          { label: 'More calcium, at a double dose', feedback: 'No. The deficit that is still limiting her is the magnesium, and doubling the calcium risks the heart without fixing the problem.', score: 0 },
          { label: 'Steroids and an NSAID, and recheck tomorrow', feedback: 'Symptomatic treatment without correcting the magnesium leaves a cow down overnight, which is when the pressure damage becomes irreversible.', score: 1 },
        ],
      },
      {
        id: 's5',
        phase: 'Outcome',
        prompt: 'She rises after the magnesium. What prevents this happening to the next three cows?',
        detail: 'She is standing and interested in feed by the afternoon. The herd has had three cases this season and you have the herd records in front of you.',
        findings: [
          'Three milk fevers in the herd this season',
          'Close-up dry cow ration not reviewed this year',
          'Body condition at calving averaging 3.75 on a 5-point scale',
          'No oral calcium protocol at calving',
        ],
        options: [
          { label: 'A transition-cow programme: control body condition, an anionic or low-calcium close-up ration, and oral calcium at calving', correct: true, feedback: 'Correct. Milk fever is a herd disease with an individual presentation. The ration and the body condition are the interventions; the bottle in the truck is the rescue.', score: 2 },
          { label: 'Treat every fresh cow with calcium at calving', feedback: 'Blanket treatment masks the problem and costs more than the feeding fix. Oral calcium at calving is part of the plan, not all of it.', score: 1 },
          { label: 'Cull the cow that went down', feedback: 'She has recovered and is a productive fourth-lactation animal. The herd programme, not the cull, is where the value is.', score: 0 },
        ],
      },
    ],
    takeaways: [
      'Milk fever is a herd feeding problem that presents in an individual cow.',
      'Slow intravenous calcium with cardiac monitoring: the drug that saves her is the drug that kills her if it goes in fast.',
      'A non-responder needs magnesium, phosphorus and an obstetric re-examination before another dose of calcium.',
      'Downer cow syndrome is a secondary injury — get her up, bed her deeply and roll her every few hours.',
      'The transition ration and the body condition score at calving prevent more milk fever than any treatment.',
    ],
    sources: ['merck-large', 'smith'],
  },
  {
    id: 'case-feline-uo',
    title: 'The blocked cat',
    species: 'cat',
    system: 'Urinary',
    difficulty: 'Foundation',
    clinician: 'Dr Meera Iyer, small animal practice',
    signalment: 'Domestic shorthair, 4 years, 5.2 kg, male neutered, indoor-outdoor',
    presenting: 'Straining in the litter tray for 36 hours, now hiding and vomiting. The owner found no urine in the tray.',
    vitals: [
      { label: 'Temperature', value: '37.2 °C', flag: 'low' },
      { label: 'Heart rate', value: '160 bpm', flag: 'low' },
      { label: 'Respiratory rate', value: '44 /min', flag: 'high' },
      { label: 'Mucous membranes', value: 'Pale, tacky', flag: 'low' },
    ],
    steps: [
      {
        id: 's1',
        phase: 'Examination',
        prompt: 'You palpate a large, firm, painful bladder. What is the first test?',
        detail: 'The cat is bradycardic, hypothermic and depressed. The bladder is the size of a small plum and cannot be expressed.',
        findings: [
          'Large, firm, non-expressible bladder',
          'Bradycardia at 160 bpm — not the tachycardia you would expect from pain',
          'Hypothermia and depression',
          '36 hours of straining',
        ],
        options: [
          { label: 'Potassium and an ECG, before any sedation or catheterisation', correct: true, feedback: 'Correct. Hyperkalaemia stops the heart, and this cat is bradycardic and depressed — the classic triad. Check potassium and look at the trace before you do anything else.', score: 2 },
          { label: 'Immediate general anaesthesia and catheterisation', feedback: 'An obstructed cat with an uncorrected hyperkalaemia can arrest under anaesthesia. Check the potassium and the ECG first, then relieve the obstruction.', score: 1 },
          { label: 'Intravenous fluids at maintenance and reassess in an hour', feedback: 'Fluids are needed, but the potassium is the immediate threat and an hour is a long time for an obstructed cat with 36 hours of history.', score: 0 },
        ],
      },
      {
        id: 's2',
        phase: 'Diagnostics',
        prompt: 'Potassium is 7.8 mmol/L. What is the immediate treatment?',
        detail: 'The ECG shows spiked T waves and a widened QRS. The cat is still bradycardic.',
        findings: [
          'Potassium 7.8 mmol/L',
          'Spiked T waves and a widened QRS complex',
          'Bradycardia with weak pulses',
          'Creatinine 320 µmol/L and urea 32 mmol/L',
        ],
        options: [
          { label: 'Calcium gluconate to protect the myocardium, plus dextrose and insulin to shift the potassium intracellularly', correct: true, feedback: 'Correct. Calcium gluconate does not lower the potassium — it stabilises the myocardium against it, which is what buys you time. Dextrose and insulin shift the potassium into the cells.', score: 2 },
          { label: 'Sodium bicarbonate alone', feedback: 'Bicarbonate shifts potassium, but it is slower and less reliable than dextrose and insulin, and it does not protect the myocardium.', score: 1 },
          { label: 'Fluids alone, to dilute the potassium', feedback: 'Fluids are part of the plan, but they do not act fast enough on a trace that already shows a widened QRS.', score: 0 },
        ],
      },
      {
        id: 's3',
        phase: 'Decision',
        prompt: 'The trace improves. How do you relieve the obstruction?',
        detail: 'You now need to catheterise and empty the bladder, and the cat needs analgesia and stabilisation at the same time.',
        findings: [
          'ECG improved after the calcium and the dextrose-insulin',
          'Bladder still large and firm',
          'Cat is depressed but responsive',
          'Analgesia is essential before you manipulate the urethra',
        ],
        options: [
          { label: 'Sedation and analgesia, then urethral catheterisation with a closed collection system', correct: true, feedback: 'Correct. Analgesia first, a gentle technique with a closed system, and a urinary catheter left in place for 24–48 hours with IV fluids to diurese.', score: 2 },
          { label: 'Cystocentesis to empty the bladder and wait', feedback: 'Cystocentesis decompresses the bladder but leaves the obstruction in place. It buys minutes, not a plan.', score: 1 },
          { label: 'Immediate perineal urethrostomy', feedback: 'A perineal urethrostomy is for the recurrent obstructor, not for the first presentation. Catheterise, unblock and stabilise first.', score: 0 },
        ],
      },
      {
        id: 's4',
        phase: 'Treatment',
        prompt: 'The obstruction is relieved. What happens next in hospital?',
        detail: 'The catheter is in place and draining. The post-obstructive diuresis is about to begin, and the cat has a 36-hour history of uraemia.',
        findings: [
          'Post-obstructive diuresis is expected — match the output with fluids',
          'Monitor electrolytes, particularly potassium, for the first 24–48 hours',
          'Analgesia and an antispasmodic are needed',
          'The bladder should be kept decompressed',
        ],
        options: [
          { label: 'IV fluids matched to urine output, electrolyte monitoring, analgesia, and the catheter left in for 24–48 hours', correct: true, feedback: 'Correct. Match the diuresis, monitor the potassium as it swings, keep the bladder decompressed, and treat the pain.', score: 2 },
          { label: 'Remove the catheter as soon as the bladder is empty', feedback: 'Removing it immediately misses the period of urethral spasm and oedema, which is exactly when he re-obstructs.', score: 0 },
          { label: 'Antibiotics routinely', feedback: 'Bacterial cystitis is uncommon in a young to middle-aged cat with sterile idiopathic cystitis. Antibiotics are for a positive culture, not for every blocked cat.', score: 1 },
        ],
      },
      {
        id: 's5',
        phase: 'Outcome',
        prompt: 'He goes home on day 3. What stops it happening again?',
        detail: 'The owner is motivated and wants to know what to change. This is the first episode.',
        findings: [
          'A first episode of sterile idiopathic cystitis with a urethral plug',
          'Indoor-outdoor, with a covered litter tray in a busy utility room',
          'Dry food only',
          'One other cat in the household',
        ],
        options: [
          { label: 'Multimodal environmental modification: more water, wet food, one tray per cat plus one, uncovered trays in quiet places, and enrichment', correct: true, feedback: 'Correct. Feline idiopathic cystitis is a stress and environment disease, and MEMO reduces recurrence more reliably than any drug.', score: 2 },
          { label: 'Lifelong prescription urinary diet only', feedback: 'A urinary diet helps, particularly for urolithiasis, but on its own it under-treats the environmental drivers of FIC.', score: 1 },
          { label: 'A long course of antibiotics', feedback: 'There is no infection to treat in a sterile cystitis, and the recurrence rate is unchanged.', score: 0 },
        ],
      },
    ],
    takeaways: [
      'A blocked cat is a hyperkalaemia case that happens to have a bladder problem. Check potassium and the ECG first.',
      'Calcium gluconate protects the myocardium; dextrose and insulin shift the potassium. They do different jobs.',
      'Post-obstructive diuresis is predictable — match the output and monitor the electrolytes.',
      'Leave the catheter in for 24–48 hours so the urethral spasm can settle.',
      'Multimodal environmental modification prevents recurrence better than any prescription.',
    ],
    sources: ['ettinger', 'merck'],
  },
  {
    id: 'case-brd-calf',
    title: 'The group of calves that stopped eating',
    species: 'cattle',
    system: 'Respiratory',
    difficulty: 'Intermediate',
    clinician: 'Dr Tom Whitworth, mixed practice',
    signalment: 'Group of 40 weaned beef calves, 8 months, ~250 kg, housed 3 weeks after transport and commingling',
    presenting: 'Six calves off feed, four with an obvious nasal discharge and an increased respiratory effort. The group was assembled from three sources.',
    vitals: [
      { label: 'Temperature (worst calf)', value: '40.8 °C', flag: 'high' },
      { label: 'Respiratory rate', value: '64 /min', flag: 'high' },
      { label: 'Heart rate', value: '96 bpm', flag: 'high' },
      { label: 'Rumen fill', value: 'Reduced', flag: 'low' },
    ],
    steps: [
      {
        id: 's1',
        phase: 'History',
        prompt: 'What is the most important piece of this history?',
        detail: 'The calves came from three sources three weeks ago, were transported, and were housed together in one airspace with a recently reduced ventilation rate.',
        findings: [
          'Commingling from three sources',
          'Transport three weeks ago',
          'Housed in one airspace',
          'Ventilation reduced in the last two weeks to keep the shed warmer',
          'Six of 40 affected so far',
        ],
        options: [
          { label: 'The commingling, transport and ventilation history — this is a group disease', correct: true, feedback: 'Correct. BRD is a management disease with a bacterial presentation. The three-source assembly, the transport and the reduced ventilation are the cause.', score: 2 },
          { label: 'The exact rectal temperature of the worst calf', feedback: 'Useful for the individual case definition, but it does not explain why six animals are affected.', score: 1 },
          { label: 'Whether they were vaccinated for clostridial disease', feedback: 'Relevant to the herd health plan, but it is not the BRD driver in this group.', score: 0 },
        ],
      },
      {
        id: 's2',
        phase: 'Diagnostics',
        prompt: 'How do you confirm and treat at the same time?',
        detail: 'You can treat the group or the individuals. You need a case definition that the stockperson can also use tomorrow morning.',
        findings: [
          'Six of 40 affected — a 15% attack rate',
          'A deep nasopharyngeal swab on the worst calf is possible',
          'The group is still moving through the case',
          'Treatment delay is the single biggest driver of chronic lung damage',
        ],
        options: [
          { label: 'A clinical case definition for the stockperson, immediate treatment of every case, and deep nasopharyngeal swabs from untreated animals for culture', correct: true, feedback: 'Correct. Treat the animal in front of you immediately, sample the untreated ones for the herd, and give the stockperson a case definition they can apply at feeding time.', score: 2 },
          { label: 'Wait for the culture results before treating any animal', feedback: 'Culture takes days. Treating early is the difference between a recovered calf and a chronic lung-damaged one that never finishes.', score: 0 },
          { label: 'Treat only the four with an obvious discharge', feedback: 'A calf with a fever and an increased respiratory effort but no discharge yet is the case you want to catch early.', score: 1 },
        ],
      },
      {
        id: 's3',
        phase: 'Decision',
        prompt: 'Which drug combination?',
        detail: 'You are choosing an antimicrobial and an anti-inflammatory for a group of weaned beef calves.',
        findings: [
          'No recent antimicrobial use in this group',
          'The herd has used oxytetracycline repeatedly in previous years',
          'A long-acting product suits a group that is difficult to handle twice daily',
          'The calves are 8 months old and will be finished at 18–20 months',
        ],
        options: [
          { label: 'A long-acting labelled BRD antimicrobial plus an NSAID, and reassess at 48 hours', correct: true, feedback: 'Correct. A labelled long-acting product with an NSAID gives the best combination of efficacy, handling and welfare, and the 48-hour reassessment is what defines treatment failure.', score: 2 },
          { label: 'Oxytetracycline again, because it is what the farm has', feedback: 'Repeated oxytetracycline use in previous years is exactly the history that predicts a poor response. Check the sensitivity and the records.', score: 0 },
          { label: 'A fluoroquinolone as first-line empirical therapy', feedback: 'Fluoroquinolones are Watch-group antimicrobials. Reserve them for culture-confirmed need rather than using them empirically in a group.', score: 1 },
        ],
      },
      {
        id: 's4',
        phase: 'Treatment',
        prompt: 'Two calves have not improved after 48 hours. What now?',
        detail: 'Four of the six are brighter and eating. Two are still febrile and dyspnoeic.',
        findings: [
          'Four of six responded within 48 hours',
          'Two remain febrile with an increased respiratory effort',
          'Ultrasound on the non-responders is available',
          'The remaining 34 animals are still at risk',
        ],
        options: [
          { label: 'Re-examine the non-responders with ultrasound, consider a change of class, and treat the group when the attack rate crosses the threshold', correct: true, feedback: 'Correct. Non-responders need reassessment rather than repeat dosing, lung consolidation changes the prognosis and the culling decision, and group metaphylaxis is justified once the attack rate crosses the threshold.', score: 2 },
          { label: 'Repeat the same antibiotic for another three days', feedback: 'Repeating a drug that has not worked for 48 hours without reassessing is how chronic carriers are created.', score: 0 },
          { label: 'Treat the whole group immediately with a different class', feedback: 'Group treatment is a threshold decision. Two non-responders out of 40 does not yet justify it, and over-using the second class costs you that drug later.', score: 1 },
        ],
      },
      {
        id: 's5',
        phase: 'Outcome',
        prompt: 'What is the plan for the next batch?',
        detail: 'The outbreak is contained. Six calves treated, four recovered, two with some lung damage. The farm buys from the same three sources every year.',
        findings: [
          'The same assembly pattern every year',
          'No preconditioning or pre-arrival vaccination',
          'Ventilation was reduced and has not been reviewed',
          'No weighing or growth-rate records on arrival',
        ],
        options: [
          { label: 'Preconditioning and vaccination before assembly, staged mixing, and a ventilation review', correct: true, feedback: 'Correct. Vaccinate 3–4 weeks before the risk period, assemble fewer sources, stage the mixing, and fix the air. The drug treats the case; the management prevents the outbreak.', score: 2 },
          { label: 'Keep a long-acting antibiotic on the farm for immediate use', feedback: 'Having the drug available is sensible, but it is the plan of a farm that expects an outbreak every year.', score: 1 },
          { label: 'Vaccinate on arrival at the yard', feedback: 'Vaccination on arrival is too late for a risk period that is already underway — immunity takes 2–3 weeks to develop.', score: 0 },
        ],
      },
    ],
    takeaways: [
      'BRD is a management disease with a bacterial presentation: commingling, transport and ventilation are the causes.',
      'Treat the individual immediately, sample the untreated for the herd, and give the stockperson a case definition.',
      'A calf that has not improved at 48 hours needs reassessment, not another dose of the same drug.',
      'Lung consolidation on ultrasound tells you the prognosis and whether to cull.',
      'Preconditioning and pre-arrival vaccination prevent far more than any treatment plan.',
    ],
    sources: ['merck-large', 'smith'],
  },
  {
    id: 'case-equine-colic',
    title: 'The colicking mare at 2 a.m.',
    species: 'horse',
    system: 'Gastrointestinal',
    difficulty: 'Advanced',
    clinician: 'Dr Sarah Okonkwo, equine practice',
    signalment: 'Thoroughbred-cross mare, 11 years, 520 kg, in work, stabled overnight',
    presenting: 'Restless, pawing, looking at the flank, no dung passed since the evening feed. Reflux obtained on nasogastric intubation.',
    vitals: [
      { label: 'Heart rate', value: '68 bpm', flag: 'high' },
      { label: 'Respiratory rate', value: '28 /min', flag: 'high' },
      { label: 'Mucous membranes', value: 'Injected, CRT 3 s', flag: 'high' },
      { label: 'Rectal temperature', value: '37.9 °C', flag: 'normal' },
    ],
    steps: [
      {
        id: 's1',
        phase: 'Examination',
        prompt: 'Reflux is obtained on nasogastric intubation. What does that mean?',
        detail: 'You pass the tube for analgesia and get 6 L of foul-smelling fluid back. The mare stops straining as soon as the stomach is decompressed.',
        findings: [
          '6 L of gastric reflux obtained',
          'The mare settles immediately after decompression',
          'Heart rate 68 bpm and rising',
          'Distended small intestine on rectal examination',
        ],
        options: [
          { label: 'There is a small intestinal obstruction, and this is a surgical colic until proven otherwise', correct: true, feedback: 'Correct. Reflux plus distended small intestine on rectal examination is a small intestinal obstruction. Decompress, refer, and do not wait.', score: 2 },
          { label: 'This is a spasmodic colic and she will settle with analgesia', feedback: 'Spasmodic colic does not produce 6 L of reflux. The improvement you see is the decompression, not a cure.', score: 0 },
          { label: 'It is a large colon impaction', feedback: 'An impaction gives reduced or absent faeces and a characteristic rectal finding, not 6 L of reflux.', score: 1 },
        ],
      },
      {
        id: 's2',
        phase: 'Diagnostics',
        prompt: 'What does the abdominocentesis add?',
        detail: 'You have the fluid in front of you. The mare is painful again despite flunixin.',
        findings: [
          'Serosanguinous peritoneal fluid',
          'Protein 35 g/L on the refractometer',
          'A lactate on the fluid that is higher than the peripheral lactate',
          'Heart rate now 74 bpm despite analgesia',
        ],
        options: [
          { label: 'Serosanguinous fluid with a high lactate indicates strangulation and the need for immediate surgery', correct: true, feedback: 'Correct. That combination is the single strongest indicator of a strangulating lesion, and it turns a "watch and wait" into a "load the horse now".', score: 2 },
          { label: 'It confirms the diagnosis but does not change the timing', feedback: 'It changes the timing decisively. A strangulating lesion has a window of hours, and the length of intestine that survives depends on how soon it is resected.', score: 1 },
          { label: 'A normal tap would rule out surgery', feedback: 'No tap rules out surgery in isolation — but this one is abnormal, and it points directly at strangulation.', score: 0 },
        ],
      },
      {
        id: 's3',
        phase: 'Decision',
        prompt: 'The owner asks whether she can wait until morning. What do you say?',
        detail: 'It is 2 a.m., the referral hospital is 90 minutes away, and the owner is worried about the cost and the journey.',
        findings: [
          'Heart rate 74 bpm and rising despite analgesia',
          'Serosanguinous fluid with a high lactate',
          '6 L of reflux obtained once',
          'The mare is painful again within 40 minutes',
        ],
        options: [
          { label: 'She should go now: the survival of the strangulated bowel is measured in hours, and the heart rate is already against her', correct: true, feedback: 'Correct. Every hour of strangulation costs intestine, and the heart rate and the fluid lactate both say the window is closing now.', score: 2 },
          { label: 'Wait until morning and reassess, since she settled after decompression', feedback: 'The settling was the decompression. The relapse within 40 minutes is the lesion talking, and waiting until morning is the decision that turns a survivable case into a fatal one.', score: 0 },
          { label: 'Treat medically overnight and refer if she is no better', feedback: 'Medical therapy does not relieve a strangulating obstruction. The only question is whether the surgery happens at 3 a.m. or at 8 a.m., and the earlier one is the better operation.', score: 1 },
        ],
      },
      {
        id: 's4',
        phase: 'Treatment',
        prompt: 'While she is loaded, what do you do?',
        detail: 'You have 90 minutes on the road, and the mare is painful and tachycardic.',
        findings: [
          'Ongoing gastric reflux during the journey',
          'Heart rate 78 bpm',
          'Analgesia wears off within an hour',
          'The mare is sweating and restless in the trailer',
        ],
        options: [
          { label: 'Repeat gastric decompression, keep the analgesia topped up, place an IV catheter and give fluids, and call ahead to the hospital', correct: true, feedback: 'Correct. Decompress repeatedly to protect the stomach and the diaphragm, keep her comfortable, start fluids, and give the surgical team a heads-up so the theatre is ready when she arrives.', score: 2 },
          { label: 'Give a full dose of flunixin and nothing else, so the surgeon gets an accurate picture', feedback: 'Pain relief is a welfare priority and the surgical decision has already been made. Withholding analgesia does not improve the assessment, it just makes the journey worse.', score: 0 },
          { label: 'Sedate heavily for the journey', feedback: 'Heavy sedation in a horse with a compromised cardiovascular system risks collapse in the trailer, and it obscures the pain that tells you how she is doing.', score: 1 },
        ],
      },
      {
        id: 's5',
        phase: 'Outcome',
        prompt: 'At surgery a 1.2 m strangulating pedunculated lipoma is resected. What drives the prognosis now?',
        detail: 'The surgery is successful. The mare recovers from anaesthesia and you are speaking to the owner at 6 a.m.',
        findings: [
          '1.2 m of small intestine resected',
          'The remaining intestine looks viable',
          'Post-operative ileus is a risk over the next 72 hours',
          'The mare is 11 years old and was in work',
        ],
        options: [
          { label: 'The length of the resection, the heart rate at presentation, and the post-operative ileus over the next 72 hours', correct: true, feedback: 'Correct. Those three determine whether she goes home: how much bowel was lost, how compromised she was on arrival, and whether the gut starts again.', score: 2 },
          { label: 'The anaesthetic risk alone', feedback: 'Anaesthesia matters, but the resection length and the post-operative ileus are what decide the outcome after a successful surgery.', score: 1 },
          { label: 'Her age', feedback: 'Eleven is not old for this surgery, and age is a minor factor compared with the resection length and the ileus risk.', score: 0 },
        ],
      },
    ],
    takeaways: [
      'Gastric reflux means a small intestinal obstruction until proven otherwise.',
      'Serosanguinous peritoneal fluid with a lactate above the peripheral value indicates strangulation.',
      'The heart rate is the most useful triage number and it is free: above 60 bpm with unrelenting pain is a surgical case.',
      'Decompress repeatedly during transport, keep the analgesia going, and call ahead.',
      'The prognosis after surgery turns on the resection length, the heart rate at presentation and the post-operative ileus.',
    ],
    sources: ['merck', 'smith'],
  },
  {
    id: 'case-pyometra',
    title: 'The entire bitch that has been drinking',
    species: 'dog',
    system: 'Reproductive',
    difficulty: 'Foundation',
    clinician: 'Dr Priya Menon, small animal practice',
    signalment: 'Golden Retriever, 7 years, 32 kg, female entire, last season 5 weeks ago',
    presenting: 'Increased thirst for four days, now lethargic and off her food, with a bloody vaginal discharge.',
    vitals: [
      { label: 'Temperature', value: '39.1 °C', flag: 'normal' },
      { label: 'Heart rate', value: '128 bpm', flag: 'high' },
      { label: 'Mucous membranes', value: 'Tacky', flag: 'low' },
      { label: 'CRT', value: '2.5 s', flag: 'high' },
    ],
    steps: [
      {
        id: 's1',
        phase: 'History',
        prompt: 'Which part of the history is decisive?',
        detail: 'An entire bitch, five weeks past oestrus, with polydipsia and now a bloody discharge and inappetence.',
        findings: [
          'Oestrus 5 weeks ago — the classic pyometra window',
          'Polydipsia for four days',
          'Bloody vaginal discharge',
          'Not spayed, never bred',
        ],
        options: [
          { label: 'The stage of the oestrous cycle — pyometra presents 2–8 weeks after oestrus', correct: true, feedback: 'Correct. Cystic endometrial hyperplasia with secondary infection follows progesterone priming, so the timing after oestrus is the single most useful historical fact.', score: 2 },
          { label: 'The colour of the discharge', feedback: 'Useful, but an open pyometra has a discharge and a closed one does not — the timing is what puts pyometra on the list in the first place.', score: 1 },
          { label: 'Whether she has been mated', feedback: 'Not directly relevant to the diagnosis, and it does not exclude pyometra.', score: 0 },
        ],
      },
      {
        id: 's2',
        phase: 'Diagnostics',
        prompt: 'How do you confirm it?',
        detail: 'You have ultrasound available, and the bloods are running now.',
        findings: [
          'Abdominal ultrasound shows a fluid-filled, thickened uterus',
          'CBC shows a marked neutrophilia with a left shift',
          'Urinalysis shows a specific gravity of 1.012 with no active sediment',
          'Biochemistry shows a mild azotaemia',
        ],
        options: [
          { label: 'Ultrasound finding a fluid-filled uterus, plus the leucogram and the dilute urine', correct: true, feedback: 'Correct. The ultrasound is the imaging test, the leucogram shows the sepsis, and the dilute urine explains the polydipsia as an endotoxin-mediated tubular effect rather than primary renal disease.', score: 2 },
          { label: 'Radiography alone', feedback: 'Radiography can show a tubular mass but it is less specific than ultrasound, and it will not tell you how sick she is.', score: 1 },
          { label: 'A vaginal cytology', feedback: 'Cytology describes the discharge, not the uterus. It cannot exclude pyometra.', score: 0 },
        ],
      },
      {
        id: 's3',
        phase: 'Decision',
        prompt: 'What is the order of the day?',
        detail: 'She is tacky, tachycardic and dull, but she is not in shock. The owner asks whether she can have antibiotics instead of surgery.',
        findings: [
          'Estimated dehydration 6%',
          'Heart rate 128 bpm',
          'Marked neutrophilia with a left shift',
          'The owner would prefer to avoid surgery',
        ],
        options: [
          { label: 'Stabilise with IV fluids and antibiotics first, then ovariohysterectomy once she is stable enough for anaesthesia', correct: true, feedback: 'Correct. The surgery is the treatment, but the stabilisation is what makes the surgery survivable. Fluids and antibiotics first, theatre as soon as she is ready.', score: 2 },
          { label: 'Straight to theatre, because the source must come out', feedback: 'The source does have to come out, but anaesthetising a dehydrated, septic patient without stabilisation first is how the case goes wrong.', score: 1 },
          { label: 'Antibiotics for 10 days and review', feedback: 'Medical management alone leaves the infected uterus in place. It has a limited role in a valuable breeding animal with an open cervix and no systemic illness — which this patient is not.', score: 0 },
        ],
      },
      {
        id: 's4',
        phase: 'Treatment',
        prompt: 'What is the antibiotic plan while she is stabilising?',
        detail: 'You need empirical cover against the organism most often cultured from a pyometra, and it needs to be parenteral.',
        findings: [
          'E. coli is the organism isolated in the great majority of cases',
          'Anaerobic cover is worth having',
          'She is vomiting intermittently',
          'Culture and sensitivity from the surgical specimen should be sent',
        ],
        options: [
          { label: 'Intravenous amoxicillin-clavulanate (or ampicillin plus enrofloxacin on sensitivity), with the uterine contents sent for culture', correct: true, feedback: 'Correct. Cover the Gram-negative and anaerobic risk parenterally, and send the specimen so the discharge medication is based on a result rather than a guess.', score: 2 },
          { label: 'Oral cephalexin', feedback: 'Oral drug in a vomiting septic patient, and the spectrum is wrong for the organisms involved.', score: 0 },
          { label: 'Metronidazole alone', feedback: 'Covers the anaerobes but not the E. coli, which is the organism you are treating.', score: 1 },
        ],
      },
      {
        id: 's5',
        phase: 'Outcome',
        prompt: 'She recovers well. What is the most important follow-up?',
        detail: 'She goes home 48 hours after surgery on oral amoxicillin-clavulanate, based on the culture and sensitivity.',
        findings: [
          'Culture confirmed E. coli sensitive to the prescribed agent',
          'She is eating and drinking normally',
          'The owner has another entire bitch at home',
          'The histopathology confirmed cystic endometrial hyperplasia with pyometra',
        ],
        options: [
          { label: 'Finish the culture-directed course, review the incision at 10 days, and discuss neutering the other entire bitch', correct: true, feedback: 'Correct. Finish the course on sensitivity, check the wound, and treat the second bitch as the same risk — the prevention conversation is part of the case.', score: 2 },
          { label: 'Stop the antibiotics as soon as she looks well', feedback: 'Stopping early risks a residual infection and a resistant relapse. Finish the course as directed by the sensitivity.', score: 0 },
          { label: 'No follow-up needed once she is eating', feedback: 'An incision check at 10 days is standard, and the second bitch at home is the next case waiting to happen.', score: 1 },
        ],
      },
    ],
    takeaways: [
      'Pyometra presents 2–8 weeks after oestrus in an entire bitch or queen.',
      'Polydipsia with dilute urine in a septic bitch is an endotoxin-mediated tubular effect, not primary kidney disease.',
      'Stabilise first, then operate: the surgery is the treatment and the fluids are what make it survivable.',
      'Send the uterine contents for culture and sensitivity and finish the course on the result.',
      'A closed cervix is a surgical emergency — the absence of a discharge is the more dangerous presentation.',
    ],
    sources: ['merck', 'fossum', 'ettinger'],
  },
];

export const CASE_MAP: Record<string, ClinicalCase> = CASES.reduce(
  (acc, c) => {
    acc[c.id] = c;
    return acc;
  },
  {} as Record<string, ClinicalCase>,
);

export function maxScoreForCase(studyCase: ClinicalCase): number {
  return studyCase.steps.reduce(
    (sum, step) => sum + Math.max(...step.options.map((o) => o.score)),
    0,
  );
}
