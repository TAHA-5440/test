import type { VaccineRow } from '../types';

/**
 * Vaccination schedules.
 *
 * Core schedules for the species most often vaccinated in general practice,
 * plus the clinic-tracker interval for the reminder system.
 */
export const VACCINES: VaccineRow[] = [
  // Dogs
  { id: 'dog-dhpp', species: 'dog', vaccine: 'DHPP (distemper, hepatitis, parvovirus, parainfluenza)', protects: 'Core combination — the three diseases that kill unvaccinated dogs', primaryStart: '6–8 weeks', boosters: 'Every 2–4 weeks until 16 weeks of age', revaccination: '12 months, then every 3 years' },
  { id: 'dog-rabies', species: 'dog', vaccine: 'Rabies', protects: 'Rabies — fatal and zoonotic, and legally required in most jurisdictions', primaryStart: '12 weeks (or as the local law requires)', boosters: 'Single primary dose where a killed vaccine is used', revaccination: '1 year, then per local regulation (1 or 3 years)' },
  { id: 'dog-lepto', species: 'dog', vaccine: 'Leptospirosis (4-way)', protects: 'Leptospira serovars circulating locally — a zoonosis', primaryStart: '8–9 weeks', boosters: '2 doses, 2–4 weeks apart', revaccination: 'Annually' },
  { id: 'dog-bordetella', species: 'dog', vaccine: 'Bordetella bronchiseptica (± parainfluenza)', protects: 'Infectious tracheobronchitis (kennel cough)', primaryStart: '8 weeks intranasal, or as required by the boarding facility', boosters: 'Single dose intranasal; 2 doses if injectable', revaccination: 'Annually, or every 6 months for high-risk dogs' },
  { id: 'dog-rattlesnake', species: 'dog', vaccine: 'Crotalus atrox toxoid (rattlesnake)', protects: 'Reduces the severity of western diamondback envenomation', primaryStart: '16 weeks', boosters: 'Second dose 4 weeks later', revaccination: 'Annually before the snake season', note: 'Regional product; it does not replace immediate veterinary treatment after a bite.' },

  // Cats
  { id: 'cat-fvrcp', species: 'cat', vaccine: 'FVRCP (herpesvirus, calicivirus, panleukopenia)', protects: 'The three core feline diseases, including panleukopenia', primaryStart: '6–8 weeks', boosters: 'Every 3–4 weeks until 16 weeks of age', revaccination: '12 months, then every 3 years' },
  { id: 'cat-rabies', species: 'cat', vaccine: 'Rabies', protects: 'Rabies — fatal and zoonotic', primaryStart: '12 weeks', boosters: 'Single primary dose', revaccination: '1 year, then per local regulation' },
  { id: 'cat-felv', species: 'cat', vaccine: 'Feline leukaemia virus (FeLV)', protects: 'FeLV — a core vaccine for cats with outdoor access under 1 year of age', primaryStart: '8–12 weeks', boosters: 'Second dose 3–4 weeks later', revaccination: 'Annually for at-risk cats', note: 'Test for FeLV before vaccinating. An indoor-only cat in a closed household is at low risk.' },
  { id: 'cat-chlamydia', species: 'cat', vaccine: 'Chlamydia felis', protects: 'Chlamydial conjunctivitis in multi-cat households', primaryStart: '9 weeks', boosters: 'Second dose 3–4 weeks later', revaccination: 'Annually where the risk persists' },

  // Cattle
  { id: 'cattle-fmd', species: 'cattle', vaccine: 'Foot-and-mouth disease (polyvalent)', protects: 'FMD serotypes circulating in the region', primaryStart: '4 months and above', boosters: 'Second dose after 4 weeks, then a booster at 6 months', revaccination: 'Every 6 months', note: 'A statutory vaccination in endemic regions; the serotype match is decided nationally.' },
  { id: 'cattle-hs', species: 'cattle', vaccine: 'Haemorrhagic septicaemia (Pasteurella multocida B:2)', protects: 'HS — a rapidly fatal septicaemia of the monsoon season', primaryStart: '6 months', boosters: 'Single annual dose before the rainy season', revaccination: 'Annually, ideally 1–2 months before the risk period' },
  { id: 'cattle-bq', species: 'cattle', vaccine: 'Black quarter (Clostridium chauvoei)', protects: 'Blackleg — a clostridial myonecrosis', primaryStart: '6 months', boosters: 'Single dose, with a booster 4–6 weeks later in high-risk areas', revaccination: 'Annually before the monsoon' },
  { id: 'cattle-ibr', species: 'cattle', vaccine: 'IBR / BVD / PI3 / BRSV (respiratory combination)', protects: 'The viral component of bovine respiratory disease', primaryStart: 'From 2–3 months (per label)', boosters: '2 doses, 3–4 weeks apart', revaccination: 'Annually, ahead of the transport or housing risk period' },
  { id: 'cattle-brucella', species: 'cattle', vaccine: 'Brucella abortus (S19 or RB51)', protects: 'Brucellosis — a zoonosis and a production and trade barrier', primaryStart: 'Female calves 4–8 months (S19) or as the national programme requires', boosters: 'Single dose', revaccination: 'Not repeated in most programmes', note: 'Programme-dependent and often statutory. RB51 is used in many eradication programmes because S19 antibodies confound the serological tests.' },
  { id: 'cattle-theileria', species: 'cattle', vaccine: 'Theileria annulata (tropical theileriosis)', protects: 'Theileriosis in crossbred cattle in endemic areas', primaryStart: 'From 3 months in endemic areas', boosters: 'Single dose', revaccination: 'Annually in endemic regions' },

  // Buffalo
  { id: 'buffalo-fmd', species: 'buffalo', vaccine: 'Foot-and-mouth disease (polyvalent)', protects: 'FMD serotypes circulating in the region', primaryStart: '4 months and above', boosters: 'Second dose after 4 weeks', revaccination: 'Every 6 months' },
  { id: 'buffalo-hs', species: 'buffalo', vaccine: 'Haemorrhagic septicaemia', protects: 'HS — buffalo are highly susceptible', primaryStart: '6 months', boosters: 'Single dose', revaccination: 'Annually before the rainy season' },

  // Sheep and goats
  { id: 'sheep-enterotoxaemia', species: 'sheep', vaccine: 'Clostridial 4/8-way (pulpy kidney, tetanus, black disease, malignant oedema)', protects: 'The clostridial diseases of rapidly growing lambs', primaryStart: 'Ewes pre-lambing for passive transfer; lambs from 6–8 weeks', boosters: 'Lambs: 2 doses 4–6 weeks apart', revaccination: 'Annually, and ewes 4–6 weeks before lambing' },
  { id: 'sheep-ppr', species: 'sheep', vaccine: 'Peste des petits ruminants (PPR)', protects: 'PPR — a notifiable disease with a global eradication programme', primaryStart: 'From 3–4 months', boosters: 'Single dose', revaccination: 'Every 3 years where the programme requires it' },
  { id: 'goat-ppr', species: 'goat', vaccine: 'Peste des petits ruminants (PPR)', protects: 'PPR — goats are more severely affected than sheep', primaryStart: 'From 3–4 months', boosters: 'Single dose', revaccination: 'Every 3 years where the programme requires it' },
  { id: 'goat-ccpp', species: 'goat', vaccine: 'Contagious caprine pleuropneumonia (CCPP)', protects: 'CCPP — a mycoplasma pneumonia of goats', primaryStart: 'From 6 months', boosters: 'Single dose', revaccination: 'Annually in endemic areas' },
  { id: 'goat-enterotoxaemia', species: 'goat', vaccine: 'Clostridial 4/8-way', protects: 'Enterotoxaemia and the other clostridial diseases', primaryStart: 'Does pre-kidding; kids from 8 weeks', boosters: 'Kids: 2 doses 4–6 weeks apart', revaccination: 'Annually' },

  // Poultry
  { id: 'poultry-nd', species: 'poultry', vaccine: 'Newcastle disease (La Sota / B1)', protects: 'Newcastle disease', primaryStart: 'Day 1 (B1) or 7–14 days (La Sota)', boosters: 'At 4 weeks, then at 8–12 weeks', revaccination: 'Every 3 months in layers and breeders in endemic areas', note: 'The route matters as much as the strain: mass application fails where the coverage is uneven.' },
  { id: 'poultry-ibd', species: 'poultry', vaccine: 'Infectious bursal disease (Gumboro)', protects: 'IBD — an immunosuppressive disease of young birds', primaryStart: '14–18 days (intermediate strain)', boosters: 'Second dose at 24–28 days', revaccination: 'Breeders: an inactivated vaccine before point of lay' },
  { id: 'poultry-ib', species: 'poultry', vaccine: 'Infectious bronchitis', protects: 'IB — a respiratory and production disease', primaryStart: 'Day 1 or 7–10 days', boosters: 'At 4 weeks and before point of lay', revaccination: 'Layers: every 8–12 weeks in endemic areas' },
  { id: 'poultry-fowlpox', species: 'poultry', vaccine: 'Fowl pox', protects: 'Cutaneous and diphtheritic fowl pox', primaryStart: '6–12 weeks by wing-web puncture', boosters: 'Single dose with a take-check at 7–10 days', revaccination: 'Annually in endemic areas' },

  // Horses
  { id: 'horse-tetanus', species: 'horse', vaccine: 'Tetanus toxoid', protects: 'Tetanus — horses are among the most susceptible species', primaryStart: '4–6 months', boosters: 'Second dose 4–6 weeks later, third at 10–12 months', revaccination: 'Annually, or at the time of a wound', note: 'Give a booster and antitoxin for any penetrating wound in an unvaccinated or overdue horse.' },
  { id: 'horse-influenza', species: 'horse', vaccine: 'Equine influenza', protects: 'Influenza — highly contagious in yards and at competition', primaryStart: '6 months', boosters: 'Second dose 4–6 weeks later, third at 10–12 months', revaccination: 'Every 6–12 months, as the competition rules require' },
  { id: 'horse-ehv', species: 'horse', vaccine: 'Equine herpesvirus 1 and 4', protects: 'Respiratory disease, abortion and the neurological form', primaryStart: '6 months', boosters: 'Second dose 4–6 weeks later', revaccination: 'Every 6 months for competition horses; pregnant mares at 5, 7 and 9 months' },
  { id: 'horse-strangles', species: 'horse', vaccine: 'Streptococcus equi (strangles)', protects: 'Strangles — reduces the severity and the shedding', primaryStart: 'From 6 months per label', boosters: 'Second dose 3–4 weeks later', revaccination: 'Annually, or every 6 months in high-risk yards' },

  // Pigs
  { id: 'pig-csf', species: 'pig', vaccine: 'Classical swine fever', protects: 'CSF — notifiable, and a devastating disease of pigs', primaryStart: 'From 8 weeks where the programme requires it', boosters: 'Single dose', revaccination: 'Annually in endemic regions' },
  { id: 'pig-parvo-erysipelas', species: 'pig', vaccine: 'Parvovirus and erysipelas', protects: 'SMEDI syndrome and erysipelas', primaryStart: 'Gilts and sows before first service', boosters: 'Second dose 3–4 weeks later', revaccination: 'Each parity, before service' },
];

export const VACCINE_SPECIES = ['dog', 'cat', 'cattle', 'buffalo', 'sheep', 'goat', 'poultry', 'horse', 'pig'];

export function vaccinesFor(species: string): VaccineRow[] {
  return VACCINES.filter((v) => v.species === species);
}

/** Days between the first primary dose and the next scheduled reminder. */
export function reminderIntervalDays(vaccine: VaccineRow): number {
  const text = vaccine.revaccination.toLowerCase();
  if (text.includes('6 months')) return 182;
  if (text.includes('year') && text.includes('3 year')) return 1095;
  if (text.includes('annually') || text.includes('year')) return 365;
  return 182;
}
