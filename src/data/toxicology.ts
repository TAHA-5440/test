import type { ToxicologyEntry } from '../types';

/**
 * Poisoning and antidote reference.
 *
 * Every entry names the antidote where one exists and the first-line
 * management steps where it does not. Toxicology is time-critical: the
 * decontamination window closes within hours, and the antidote for several of
 * these is useless once the signs are advanced.
 */
export const TOXICOLOGY: ToxicologyEntry[] = [
  {
    id: 'permethrin-cats',
    toxin: 'Permethrin (spot-on) poisoning in cats',
    aliases: ['Dog flea spot-on in a cat', 'Pyrethroid toxicity', 'Spot-on toxicity'],
    species: ['cat'],
    source: 'A dog permethrin spot-on applied to a cat, or a cat groomed by a recently treated dog',
    mechanism:
      'Cats lack the glucuronyl transferase needed to clear permethrin, and their sodium channels are more sensitive to it. The result is prolonged sodium channel opening and repetitive nerve firing.',
    signs: ['Muscle tremors and fasciculations', 'Hypersalivation', 'Ataxia and hyperaesthesia', 'Mydriasis', 'Seizures', 'Hyperthermia from tremor'],
    onset: 'Within 1–3 hours of application, and it can be delayed up to 72 hours',
    antidote:
      'No specific antidote. Intravenous lipid emulsion (ILE) 1.5 mL/kg over 1 minute then 0.25 mL/kg/min for 30–60 minutes is the treatment of choice for moderate to severe cases.',
    management: [
      'Wash the product off with lukewarm water and a mild detergent as soon as the cat is stable enough — do not stress a tremoring cat into a seizure',
      'IV lipid emulsion for tremor or seizures: repeat the bolus or extend the infusion to effect',
      'Control the seizures with a benzodiazepine, then phenobarbital if needed',
      'Methocarbamol (50–150 mg/kg IV slowly, to effect) for the muscle tremor — it is the most effective tremor control here',
      'IV fluids, temperature control, and airway protection',
      'Admit for at least 24 hours: the tremors can recur as the lipid effect wears off',
    ],
    pearls: [
      'Never apply a dog permethrin product to a cat. This is entirely preventable and it is the commonest feline poisoning in many practices.',
      'Separate the cat from a treated dog until the product has dried, and warn every owner who buys a dog spot-on that has a cat in the house.',
      'Lipid emulsion is not a last resort — it is the treatment, and it works fastest when it is given early.',
    ],
    sources: ['plumbs', 'merck'],
  },
  {
    id: 'chocolate',
    toxin: 'Chocolate / theobromine',
    aliases: ['Theobromine', 'Cocoa', 'Dark chocolate'],
    species: ['dog', 'cat'],
    source: 'Chocolate, cocoa powder, cocoa mulch, and chocolate-containing baked goods',
    mechanism:
      'Theobromine is a methylxanthine that antagonises adenosine receptors and inhibits phosphodiesterase, producing CNS stimulation, tachycardia and diuresis. Dogs clear it slowly — the half-life is around 17 hours.',
    signs: ['Vomiting and diarrhoea', 'Restlessness and hyperactivity', 'Polyuria', 'Tachycardia and arrhythmia', 'Muscle tremor', 'Seizures', 'Hyperthermia'],
    onset: '2–12 hours, and up to 24 hours for large ingestions',
    antidote: 'No specific antidote. Decontamination and supportive care.',
    management: [
      'Calculate the theobromine dose from the type and amount — dark chocolate and cocoa powder are 5–10 times stronger than milk chocolate',
      'Induce emesis if the ingestion was within 2 hours and the patient is asymptomatic (apomorphine 0.03 mg/kg IV in dogs)',
      'Activated charcoal 1–2 g/kg PO, repeated every 6–8 hours for the first 24 hours because of enterohepatic recirculation',
      'IV fluids at twice maintenance to promote urinary elimination',
      'Control the tremor with methocarbamol; a beta blocker for the tachyarrhythmia',
      'Empty the bladder regularly — theobromine is reabsorbed from the bladder',
      'Monitor the ECG and the temperature for 24 hours',
    ],
    pearls: [
      'Work out the theobromine dose before you reassure the owner: a small dog eating dark chocolate or cocoa powder is a different emergency from the same dog eating milk chocolate.',
      'Repeat the charcoal. The enterohepatic recirculation is why a single dose is not enough.',
      'Cats rarely eat chocolate — if a cat has eaten it, look for another cause for the signs.',
    ],
    sources: ['plumbs', 'merck'],
  },
  {
    id: 'xylitol',
    toxin: 'Xylitol',
    aliases: ['Sugar-free gum', 'Birch sugar', 'Artificial sweetener'],
    species: ['dog'],
    source: 'Sugar-free chewing gum, mints, baked goods, some peanut butters and toothpaste',
    mechanism:
      'Xylitol triggers a rapid, dose-dependent insulin release in dogs, producing profound hypoglycaemia within an hour. At higher doses it causes acute hepatic necrosis through a mechanism that is still not fully understood.',
    signs: ['Vomiting', 'Weakness and ataxia', 'Collapse and seizure from hypoglycaemia', 'Jaundice and petechiation 24–48 h later in the hepatotoxic form', 'Coagulopathy from hepatic failure'],
    onset: 'Hypoglycaemia within 30–60 minutes; hepatic injury at 12–72 hours',
    antidote:
      'No antidote. Dextrose for the hypoglycaemia, and hepatoprotective support (S-adenosylmethionine, silybin, N-acetylcysteine) for the hepatic form.',
    management: [
      'Do not induce emesis if the patient is already hypoglycaemic or obtunded — protect the airway instead',
      'Check the blood glucose immediately and every 2 hours for the first 12 hours',
      'IV dextrose supplementation, commonly 2.5–5% added to the maintenance fluids, titrated to the glucose',
      'Activated charcoal is of limited value: xylitol binds poorly, but it may help with a mixed ingestion',
      'Baseline liver enzymes, then repeat at 24 and 48 hours — the hepatic form can follow an apparently mild hypoglycaemia',
      'Monitor coagulation and treat the hepatic failure supportively, including plasma where there is a coagulopathy',
    ],
    pearls: [
      'A dog that looks fine after eating xylitol gum is not fine: the hypoglycaemia peaks at about an hour, and the liver injury appears days later.',
      'Ask about sugar-free gum and "diet" peanut butter by name — owners rarely volunteer it.',
      'Check the label for xylitol in any product a dog has raided, including toothpaste.',
    ],
    sources: ['plumbs', 'merck'],
  },
  {
    id: 'anticoagulant-rodenticide',
    toxin: 'Anticoagulant rodenticide',
    aliases: ['Rat poison', 'Warfarin', 'Brodifacoum', 'Bromadiolone'],
    species: ['dog', 'cat', 'cattle', 'pig'],
    source: 'Rodenticide baits — first-generation (warfarin) and, far more often, second-generation (brodifacoum, bromadiolone, difenacoum)',
    mechanism:
      'Inhibits vitamin K epoxide reductase, so the liver cannot regenerate the reduced vitamin K needed to gamma-carboxylate factors II, VII, IX and X. The clotting factors already in circulation are spent over 2–5 days, which produces the delay.',
    signs: [
      'Lethargy and pallor',
      'Dyspnoea from pleural or mediastinal haemorrhage',
      'Lameness or swelling from a haematoma',
      'Melaena, haematuria, epistaxis',
      'Sudden collapse from an internal haemorrhage',
    ],
    onset: '2–5 days after ingestion, sometimes longer',
    antidote: 'Vitamin K1 (phytomenadione) 2.5–5 mg/kg SC loading, then 1–2 mg/kg PO q12–24h for 3–4 weeks.',
    management: [
      'Start vitamin K1 immediately if the ingestion was within the last few days and the animal is clinically well — do not wait for the clotting to fail',
      'If the animal is bleeding, give fresh frozen plasma or whole blood now: vitamin K1 takes 12–24 hours to work',
      'Induce emesis or give activated charcoal if the ingestion was within 2 hours and the animal is asymptomatic',
      'Prothrombin time or INR at presentation, at 48–72 hours, and again 48 hours after the last dose',
      'Three to four weeks of vitamin K1 for a second-generation rodenticide — five days is not a course',
      'Find and remove the bait: repeat exposure is common, and other animals in the household are at risk',
    ],
    pearls: [
      'A month of treatment, not a week. Stopping early is the commonest cause of a relapse bleed.',
      'Recheck the PT 48 hours after the final dose. That one blood test tells you whether the course was long enough.',
      'The animal has not necessarily eaten the bait directly — rodent predation counts as exposure.',
    ],
    sources: ['plumbs', 'merck'],
  },
  {
    id: 'organophosphate',
    toxin: 'Organophosphate and carbamate',
    aliases: ['OP', 'Carbamate', 'Insecticide dip', 'Dichlorvos'],
    species: ['dog', 'cat', 'cattle', 'sheep', 'goat', 'pig', 'poultry'],
    source: 'Insecticidal dips, sprays, collars, agricultural sprays and malicious baits',
    mechanism:
      'Phosphorylates acetylcholinesterase so acetylcholine accumulates at muscarinic and nicotinic receptors. Carbamates carbamylate the same enzyme reversibly, which is why their signs are shorter-lived.',
    signs: [
      'SLUD: salivation, lacrimation, urination, defaecation',
      'Miosis',
      'Bronchorrhoea and dyspnoea',
      'Bradycardia',
      'Muscle tremor and fasciculation',
      'Seizures and respiratory failure',
    ],
    onset: 'Minutes to hours, depending on the route and the compound',
    antidote:
      'Atropine sulfate 0.2–0.5 mg/kg (a quarter IV, the rest IM or SC) titrated to dry the secretions, plus pralidoxime (2-PAM) 20–50 mg/kg IV slowly for organophosphates.',
    management: [
      'Decontaminate: bathe with a mild detergent and wear gloves — the handler is at risk too',
      'Atropine to effect: the endpoint is drying of the bronchial secretions, not the heart rate',
      'Pralidoxime within 24 hours for organophosphates; it reactivates the enzyme before the bond ages. It is not indicated for carbamates',
      'Control the seizures with a benzodiazepine, and support ventilation — the bronchial secretions and the muscle weakness both compromise the airway',
      'IV fluids and supportive care; the patient may need to be ventilated for 24–48 hours',
      'Do not use succinylcholine, and avoid phenothiazines and morphine',
    ],
    pearls: [
      'Atropine trial: if a bradycardic, salivating, miotic animal dries up dramatically, you have both the diagnosis and the treatment.',
      'Wear gloves during decontamination — organophosphates are absorbed through intact human skin.',
      'Pralidoxime is time-limited by the ageing of the enzyme bond. Give it within 24 hours or not at all.',
    ],
    sources: ['plumbs', 'merck'],
  },
  {
    id: 'ethylene-glycol',
    toxin: 'Ethylene glycol',
    aliases: ['Antifreeze', 'Coolant', 'Radiator fluid'],
    species: ['dog', 'cat'],
    source: 'Antifreeze, radiator coolant, de-icer and some screen washes',
    mechanism:
      'Ethylene glycol is metabolised by alcohol dehydrogenase to glycoaldehyde and then to oxalic acid. The parent compound causes the CNS signs; the metabolites cause the metabolic acidosis and the calcium oxalate renal tubular necrosis.',
    signs: [
      'Ataxia and a drunken gait within 30 minutes to a few hours',
      'Vomiting, polyuria and polydipsia',
      'Tachycardia and tachypnoea from the acidosis',
      'Oliguria and uraemia at 24–72 hours in dogs, 12–24 hours in cats',
      'Oral ulcers and abdominal pain in the renal phase',
    ],
    onset: '30 minutes to 12 hours for the neurological phase; 24–72 hours for the renal phase',
    antidote:
      'Fomepizole (4-methylpyrazole) is the specific antidote: 20 mg/kg IV loading, then 15 mg/kg at 12 and 24 hours, then 5 mg/kg at 36 hours. It is only effective in the first 8–12 hours (up to 36 hours in cats, where the course differs). Ethanol is an inferior second choice where fomepizole is unavailable.',
    management: [
      'Treat on suspicion, before the blood test comes back — the window for the antidote is hours, and renal failure is irreversible',
      'Fomepizole as soon as possible; there is no point waiting for the oxalate crystals',
      'Correct the metabolic acidosis and the fluid deficits with IV bicarbonate and crystalloids',
      'Monitor renal values, electrolytes, blood gases and urine output for at least 72 hours',
      'Haemodialysis or peritoneal dialysis for established renal failure',
      'Never delay for a "confirmation": a dog that drank from a puddle under a car is enough to start',
    ],
    pearls: [
      'The calcium oxalate crystals on the urinalysis confirm it, but they appear after the antidote window has closed. Treat on the history.',
      'Cats need a much lower ingested volume to be fatal, and they present with earlier renal failure.',
      'Ask specifically about sweet-tasting puddles, garages and a recent radiator top-up.',
    ],
    sources: ['plumbs', 'merck', 'ettinger'],
  },
  {
    id: 'paracetamol-cats',
    toxin: 'Paracetamol (acetaminophen)',
    aliases: ['Acetaminophen', 'Panadol', 'Calpol', 'Crocin'],
    species: ['cat', 'dog'],
    source: 'Human analgesic tablets, syrups and combination cold remedies',
    mechanism:
      'Cats cannot glucuronidate paracetamol, so it is shunted to a toxic pathway producing NAPQI, which depletes glutathione and oxidises haemoglobin to methaemoglobin. Heinz body anaemia, methaemoglobinaemia and hepatic necrosis follow.',
    signs: [
      'Brown or muddy cyanotic mucous membranes',
      'Facial and paw oedema',
      'Tachypnoea and dyspnoea',
      'Vomiting, hypersalivation and anorexia',
      'Lethargy and weakness',
      'Jaundice from hepatic necrosis at 24–48 hours',
    ],
    onset: '1–4 hours for methaemoglobinaemia; 24–48 hours for the hepatic injury',
    antidote:
      'N-acetylcysteine 140 mg/kg IV or PO loading, then 70 mg/kg q6h for 5–7 treatments. Ascorbic acid and sodium methylene blue support methaemoglobin reduction.',
    management: [
      'N-acetylcysteine as early as possible — it replenishes the glutathione the cat has run out of',
      'Induce emesis or give charcoal if the ingestion was within 2 hours and the patient is stable',
      'Oxygen therapy and cage rest; a methaemoglobinaemic cat cannot carry oxygen and cannot afford excitement',
      'Ascorbic acid 30 mg/kg PO or IV q6h, and methylene blue 1.5 mg/kg IV as a 1% solution where methaemoglobinaemia is severe (use with care — it can cause Heinz body anaemia in cats)',
      'IV fluids and hepatic support; monitor liver enzymes and the PCV daily',
      'Blood transfusion for a life-threatening anaemia',
      'Never use cimetidine — it inhibits the metabolism further',
    ],
    pearls: [
      'One 500 mg tablet can kill a cat. There is no safe dose and no "wait and see".',
      'Chocolate-brown membranes are methaemoglobin, not cyanosis — the diagnosis is visible before any blood test.',
      'Check every combination cold remedy an owner might have given; paracetamol hides in them.',
    ],
    sources: ['plumbs', 'merck'],
  },
  {
    id: 'grapes-raisins',
    toxin: 'Grapes and raisins',
    aliases: ['Vitis vinifera', 'Sultanas', 'Currants', 'Grape juice'],
    species: ['dog'],
    source: 'Fresh grapes, raisins, sultanas, currants, grape juice and foods containing them',
    mechanism:
      'The toxic principle is tartaric acid, which causes proximal renal tubular necrosis. The susceptibility is idiosyncratic: some dogs tolerate a large quantity and others develop acute kidney injury from a handful.',
    signs: ['Vomiting within a few hours', 'Diarrhoea', 'Lethargy and anorexia', 'Abdominal pain', 'Oliguria and uraemia at 24–72 hours'],
    onset: 'Vomiting within 6–12 hours; renal injury at 24–72 hours',
    antidote: 'No antidote. Decontamination and aggressive renal protection.',
    management: [
      'Induce emesis if the ingestion was within 2 hours, then activated charcoal 1–2 g/kg PO',
      'IV fluid diuresis at twice maintenance for 48–72 hours — this is the single most protective intervention',
      'Baseline renal values, then monitor creatinine, BUN, electrolytes and urine output at 24, 48 and 72 hours',
      'Antiemetics and gastroprotection for the vomiting',
      'Refer for dialysis if azotaemia and oliguria develop',
      'Treat every ingestion as potentially serious: there is no established toxic dose and no way to identify the susceptible dog',
    ],
    pearls: [
      'There is no safe number. Treat every grape or raisin ingestion as potentially nephrotoxic.',
      'The 48-hour fluid diuresis is the treatment — most of these dogs do well if they are hydrated through the insult.',
      'Ask about raisins in fruit cake, trail mix and breakfast cereal, not just the fruit bowl.',
    ],
    sources: ['plumbs', 'merck'],
  },
  {
    id: 'nsaid-overdose',
    toxin: 'NSAID overdose',
    aliases: ['Ibuprofen', 'Meloxicam overdose', 'Aspirin toxicosis', 'Carprofen overdose'],
    species: ['dog', 'cat'],
    source: 'Human NSAIDs, an incorrectly calculated veterinary dose, or two NSAIDs given together',
    mechanism:
      'Cyclo-oxygenase inhibition removes the prostaglandins that maintain gastric mucosal protection and renal perfusion. Above a threshold dose the result is gastrointestinal ulceration and acute renal papillary necrosis.',
    signs: ['Vomiting, sometimes with blood', 'Melaena', 'Anorexia and abdominal pain', 'Lethargy', 'Polyuria or oliguria', 'Icterus where hepatic injury supervenes'],
    onset: '2–6 hours for the gastrointestinal signs; 24–72 hours for the renal injury',
    antidote: 'No antidote. Decontamination, gastroprotection and renal protection.',
    management: [
      'Emesis or gastric lavage within 2 hours, then activated charcoal 1–2 g/kg PO; consider a repeat dose for a large ingestion',
      'Aggressive IV fluid therapy at 1.5–2× maintenance for 48–72 hours to protect renal perfusion',
      'Gastroprotection: omeprazole 1 mg/kg PO or IV q12h, sucralfate 0.5–1 g PO q6–8h, and misoprostol 2–5 µg/kg PO q8h for a known ulcerogen',
      'Monitor renal values, electrolytes, PCV and stool for melaena daily for 3–5 days',
      'Treat the acidosis and the electrolyte derangements, and refer for dialysis where anuria develops',
      'Stop every other NSAID and steroid, and review the whole prescription',
    ],
    pearls: [
      'The two questions that matter: how many mg/kg, and was anything else nephrotoxic on board?',
      'A dog that ate one ibuprofen is a different patient from a cat that was given a canine meloxicam dose for four days.',
      'Hydration is the intervention. Everything else is supportive.',
    ],
    sources: ['plumbs', 'merck'],
  },
  {
    id: 'ivermectin-toxicity',
    toxin: 'Ivermectin / macrocyclic lactone toxicity',
    aliases: ['MDR1', 'Collie ivermectin sensitivity', 'Avermectin toxicosis'],
    species: ['dog'],
    source: 'A macrocyclic dose in an MDR1 (ABCB1-1Δ) mutant dog, a large accidental overdose, or cattle product given undiluted',
    mechanism:
      'The MDR1 mutation removes P-glycoprotein efflux at the blood–brain barrier, so ivermectin reaches the CNS and potentiates GABA-gated chloride channels, producing profound CNS depression.',
    signs: ['Mydriasis and a vacant stare', 'Ataxia and hypersalivation', 'Tremor and recumbency', 'Blindness', 'Bradycardia and respiratory depression', 'Coma'],
    onset: '6–12 hours after a macrocyclic dose, sometimes up to 24 hours',
    antidote: 'No specific reversal. Intravenous lipid emulsion has been used with reported benefit in macrocyclic lactone toxicosis.',
    management: [
      'Decontaminate if the ingestion was recent: emesis, then activated charcoal 1–2 g/kg PO, repeated because of enterohepatic recirculation',
      'Supportive care: IV fluids, warmed bedding, airway protection, and ventilation where the respiratory drive is failing',
      'IV lipid emulsion 1.5 mL/kg bolus then 0.25 mL/kg/min for 30–60 minutes, repeated to effect',
      'Turn the patient every 4 hours and protect the eyes — these dogs can be recumbent for days',
      'Recovery takes days to weeks, and owners should be warned before they commit',
      'Genotype the dog and any littermates once the crisis is over',
    ],
    pearls: [
      'Genotype before you use a macrocyclic dose in a collie-type dog. The preventive dose is safe; the mange dose is not.',
      'Lipid emulsion helps, but the supportive nursing is what gets these dogs home.',
      'The blindness and the mydriasis resolve — warn the owner, so a day-three panic does not end in euthanasia.',
    ],
    sources: ['plumbs', 'papich'],
  },
  {
    id: 'urea-npn',
    toxin: 'Urea / non-protein nitrogen poisoning',
    aliases: ['NPN', 'Urea poisoning', 'Ammonia toxicosis'],
    species: ['cattle', 'sheep', 'goat', 'buffalo'],
    source: 'Urea in feed or lick blocks, accidental over-mixing, or access to fertiliser',
    mechanism:
      'Rumen urease splits urea into ammonia faster than the microbes can incorporate it. Ammonia is absorbed, overwhelms hepatic urea-cycle clearance and raises blood ammonia, producing rapid CNS signs.',
    signs: ['Muscle tremor and twitching', 'Hypersalivation and frothing', 'Ataxia and aggression', 'Bloat and rumen stasis', 'Convulsions', 'Rapid death from respiratory failure'],
    onset: '20–60 minutes after ingestion — this is one of the fastest toxicities in large animal practice',
    antidote: 'No specific antidote. Cold water and dilute acetic acid (vinegar) reduce rumen urease activity, and it must be given early.',
    management: [
      'Cold water by stomach tube in large volumes (20–40 L in an adult cow) to dilute the rumen contents and slow urease activity',
      'Dilute acetic acid (regular vinegar, 2–5 L in an adult cow) or 5% acetic acid to acidify the rumen',
      'Rumenotomy in the valuable animal where the source is a large amount of concentrate',
      'IV fluids and supportive care, and control the convulsions',
      'The window is minutes: animals found alive after 2 hours often die regardless of treatment',
      'Remove the feed and test the ration before the rest of the group is exposed',
    ],
    pearls: [
      'This is a feeding error, and the fix is in the mixer wagon, not the bottle.',
      'Cold water and vinegar, given in the first hour, genuinely saves animals.',
      'Check the urea inclusion rate and the mixing procedure for the whole group, not just the dead ones.',
    ],
    sources: ['merck-large', 'smith'],
  },
  {
    id: 'nitrate-nitrite',
    toxin: 'Nitrate / nitrite poisoning',
    aliases: ['Nitrate', 'Fertiliser poisoning', 'Oat hay toxicity'],
    species: ['cattle', 'sheep', 'goat', 'buffalo'],
    source: 'Nitrate-accumulating forages after drought or heavy nitrogen fertilising, contaminated water, or fertiliser access',
    mechanism:
      'Rumen microbes reduce nitrate to nitrite, which is absorbed and oxidises haemoglobin to methaemoglobin. Methaemoglobin cannot carry oxygen, so the animal asphyxiates with a normal PO2.',
    signs: ['Brown or chocolate-coloured mucous membranes', 'Tachypnoea and dyspnoea', 'Weakness and ataxia', 'Tachycardia', 'Recumbency and sudden death', 'Abortion in pregnant animals that survive'],
    onset: '1–4 hours after a nitrate-rich feed',
    antidote: 'Methylene blue 1–4 mg/kg IV as a 1–4% solution, which reduces methaemoglobin back to haemoglobin.',
    management: [
      'Methylene blue IV, repeated at a lower dose if the signs return',
      'Remove the suspect feed and water immediately, and test them',
      'Move the group off the source before treating the individuals — this is a group problem',
      'Oxygen and cage rest where available',
      'Ascorbic acid has been used as an adjunct',
      'Test the forage and the water before the next feed, and dilute a high-nitrate ration with a safe roughage',
    ],
    pearls: [
      'Brown membranes that do not pink up with oxygen: think methaemoglobin, not respiratory disease.',
      'Treat the group by removing the source. Treating one cow while the rest keep eating the hay is theatre.',
      'Pregnant animals that survive may abort weeks later — warn the owner.',
    ],
    sources: ['merck-large', 'smith'],
  },
  {
    id: 'copper-sheep',
    toxin: 'Copper poisoning',
    aliases: ['Chronic copper toxicosis', 'Hepatogenous copper'],
    species: ['sheep'],
    source: 'Cattle or pig rations fed to sheep, copper-supplemented mineral mixes, footbaths, or low-molybdenum pasture',
    mechanism:
      'Sheep store copper in the liver far more efficiently than other species. When hepatic storage capacity is exceeded, a haemolytic crisis releases copper into the circulation, producing massive intravascular haemolysis.',
    signs: ['Jaundice and haemoglobinuria', 'Dark port-wine coloured urine', 'Weakness and recumbency', 'Dyspnoea', 'Sudden death in the crisis phase', 'Anorexia before the crisis'],
    onset: 'Weeks to months of accumulation, then a sudden haemolytic crisis',
    antidote:
      'Ammonium tetrathiomolybdate 1.7–3.4 mg/kg SC or IV on alternate days for 3–6 treatments reduces the liver copper burden. Ammonium molybdate and sodium thiosulfate in the feed are alternatives.',
    management: [
      'Remove the source immediately and test the ration and the mineral mix',
      'Ammonium tetrathiomolybdate or ammonium molybdate plus sodium thiosulfate by mouth',
      'Supportive care: IV fluids, and a blood transfusion for the severe anaemia',
      'D-penicillamine as a chelator where molybdate is unavailable',
      'Treat the whole group: by the time one sheep is jaundiced, the rest of the mob is loaded',
      'Review the copper:molybdenum ratio in the diet — the ratio matters more than the copper level alone',
    ],
    pearls: [
      'Never feed a cattle or pig ration to sheep. That single rule prevents most of it.',
      'The jaundiced sheep is the visible case; the mob has been accumulating copper for months.',
      'Test the feed, the water and the mineral mix before you blame the pasture.',
    ],
    sources: ['merck-large', 'smith'],
  },
  {
    id: 'snail-bait',
    toxin: 'Metaldehyde (snail and slug bait)',
    aliases: ['Metaldehyde', 'Slug pellets', 'Snail bait'],
    species: ['dog', 'cat'],
    source: 'Snail and slug pellets, often in garden products and sometimes in solid fuel blocks',
    mechanism:
      'Metaldehyde lowers the seizure threshold through an effect on GABA, noradrenaline and serotonin in the CNS. It also produces a severe metabolic acidosis and hyperthermia from the muscle activity.',
    signs: ['Anxiety and restlessness', 'Muscle tremor and rigidity', 'Hypersalivation and nystagmus', 'Hyperthermia', 'Seizures', 'Tachypnoea and dyspnoea'],
    onset: '30 minutes to 3 hours — often very rapid',
    antidote: 'No specific antidote. Decontamination, seizure control and aggressive cooling.',
    management: [
      'Emesis if the ingestion was within 2 hours and the patient is not already tremoring; otherwise protect the airway',
      'Activated charcoal 1–2 g/kg PO after the emesis has settled',
      'Control the tremor and the seizures: a benzodiazepine first, then phenobarbital, and methocarbamol for the tremor',
      'Aggressive cooling — the hyperthermia from the tremor is a major part of the mortality',
      'IV fluids with sodium bicarbonate for the metabolic acidosis',
      'Monitor the temperature continuously and treat for 24–48 hours',
    ],
    pearls: [
      'The tremor is what kills: control it, and cool the patient.',
      'The signs can start within 30 minutes, so there is no observation window.',
      'Ask about slug pellets in the garden, the shed and the neighbours\' garden.',
    ],
    sources: ['plumbs', 'merck'],
  },
  {
    id: 'lead',
    toxin: 'Lead',
    aliases: ['Plumbism', 'Lead paint', 'Lead shot', 'Batteries'],
    species: ['dog', 'cat', 'cattle'],
    source: 'Old paint, lead shot and fishing weights, batteries, linoleum, leaded petrol residue and contaminated soil',
    mechanism:
      'Lead interferes with multiple enzymes, damages capillary endothelium and disrupts neurotransmitter release. The gastrointestinal and neurological signs dominate in dogs; cattle show blindness, bellowing and head-pressing.',
    signs: [
      'Vomiting, colic and diarrhoea',
      'Behaviour change, aggression and hysteria',
      'Seizures and blindness',
      'Ataxia and circling',
      'Anorexia and weight loss',
      'Megaoesophagus and recurrent regurgitation in chronic cases',
    ],
    onset: 'Days to weeks of exposure, with acute signs after a large ingestion',
    antidote:
      'Chelation: calcium EDTA 25 mg/kg SC q6h for 2–5 days (diluted to 10 mg/mL in 5% dextrose and divided across sites), or penicillamine 10–15 mg/kg PO q12h for 1–2 weeks. Combine EDTA with dimercaprol where encephalopathy is present.',
    management: [
      'Remove the source — chelation is pointless while the animal is still eating the paint',
      'Decontaminate the gut: emesis or lavage for a recent ingestion, and radiographs or ultrasound to find radiodense material',
      'Calcium EDTA for 2–5 days, then reassess; a second course may be needed after a 5-day rest as lead redistributes from bone',
      'Control the seizures with a benzodiazepine and manage the cerebral oedema with mannitol or hypertonic saline',
      'Supportive fluids, antiemetics and nutritional support',
      'Recheck the blood lead 2–4 weeks after the final course, because rebound is common',
    ],
    pearls: [
      'Chelation without removing the source is an expensive way to make no progress.',
      'The blood lead can rebound from bone stores after the first course — that is why you recheck.',
      'In cattle, look for the source in old batteries, engine oil and discarded machinery on the pasture.',
    ],
    sources: ['plumbs', 'merck'],
  },
];

export const TOXICOLOGY_MAP: Record<string, ToxicologyEntry> = TOXICOLOGY.reduce(
  (acc, t) => {
    acc[t.id] = t;
    return acc;
  },
  {} as Record<string, ToxicologyEntry>,
);

export function searchToxicology(query: string): ToxicologyEntry[] {
  const q = query.trim().toLowerCase();
  if (!q) return TOXICOLOGY;
  return TOXICOLOGY.filter((t) => {
    if (t.toxin.toLowerCase().includes(q)) return true;
    if (t.aliases.some((a) => a.toLowerCase().includes(q))) return true;
    return t.signs.some((s) => s.toLowerCase().includes(q));
  });
}
