import type { ProcedureCard } from '../types';

/**
 * Procedure library.
 *
 * The reference site lists "clinical videos"; this build replaces the video
 * shelf with structured, step-by-step technique cards that work offline, load
 * instantly and can be read on a phone at the chute side. Every card names the
 * equipment, the sequence and the pitfalls — because the pitfalls are what the
 * video would have shown you.
 */
export const PROCEDURES: ProcedureCard[] = [
  {
    id: 'proc-iv-catheter-dog',
    title: 'Intravenous catheter placement in a dog',
    system: 'Nursing',
    species: ['dog'],
    level: 'Core',
    duration: '5–10 minutes',
    summary:
      'Cephalic or saphenous catheter placement with a closed system, including the restraint, the asepsis and the securing technique that keeps it in for 72 hours.',
    equipment: [
      'Clippers and a chlorhexidine or alcohol prep',
      'Sterile gloves or a no-touch technique',
      'An over-the-needle catheter of the appropriate gauge (18–22 G for a medium to large dog)',
      'A primed T-port or injection cap with a saline flush',
      'A bandage: conforming, cohesive and a light splint for the cephalic',
      'A way to label it with the date and the gauge',
    ],
    steps: [
      'Position the patient in sternal or lateral recumbency with the limb extended and the vein occluded proximally by an assistant.',
      'Clip widely over the vein and prepare the skin aseptically with a two-stage prep.',
      'Palpate or visualise the vein; taping the foot or using a warm compress improves the distension.',
      'Insert the catheter through the skin at a 10–30° angle, and watch the flash chamber for blood.',
      'Advance the catheter off the stylet into the vessel while keeping the stylet still — advancing both together goes through the far wall.',
      'Occlude the vein proximally, remove the stylet, attach a primed T-port and flush with saline.',
      'Check for swelling at the site, secure with a sterile dressing and a bandage, and label with the date and the gauge.',
    ],
    pitfalls: [
      'Advancing the stylet and the catheter together, which penetrates the far wall.',
      'Palpating a nerve or a tendon and mistaking it for a vein — the medial saphenous is the classic trap in a cat and a small dog.',
      'A bandage tight enough to occlude the vein or the arterial supply; check the toes afterwards.',
      'Leaving a catheter in because "it still flushes" — review the site every 8 hours and remove it at the first sign of phlebitis.',
    ],
    sources: ['merck', 'fossum'],
  },
  {
    id: 'proc-catheterisation-feline-uo',
    title: 'Urethral catheterisation of a blocked male cat',
    system: 'Emergency',
    species: ['cat'],
    level: 'Advanced',
    duration: '20–40 minutes',
    summary:
      'The sequence for relieving a urethral obstruction safely, from the stabilisation and analgesia through to a closed collection system.',
    equipment: [
      'Sedation and analgesia — and a potassium result with an ECG before you start',
      'A 3.5 or 5 Fr open-ended tomcat catheter, or a silicone slotted catheter',
      'Sterile lubricant, sterile gloves and a prep solution',
      'A closed sterile collection system and a three-way tap',
      'Sterile saline for flushing and lavage',
      'Suture material or a suture strip to secure the catheter',
    ],
    steps: [
      'Stabilise first: check potassium and an ECG, treat the hyperkalaemia, and give analgesia before you handle the penis.',
      'Sedate and place an IV catheter; keep the patient warm and monitor the ECG throughout.',
      'Extrude the penis by retracting the prepuce dorsally and apply gentle dorsal traction.',
      'Pass the catheter gently along the dorsal urethral wall; never force it, and never use a rigid stylet.',
      'Flush with sterile saline to dislodge the plug while an assistant occludes the urethra proximally per rectum.',
      'Advance into the bladder, confirm urine flow, and empty the bladder completely.',
      'Lavage the bladder until the return is clear, then secure the catheter and connect a closed collection system.',
      'Leave the catheter in for 24–48 hours with IV fluids matched to the post-obstructive diuresis.',
    ],
    pitfalls: [
      'Catheterising before the hyperkalaemia is treated — the classic arrest on the table.',
      'Forcing the catheter, which tears the urethra and turns a reversible case into a stricture.',
      'Using a stylet inside the catheter during passage.',
      'Removing the catheter too early, during the period of urethral spasm and oedema.',
      'Not matching the post-obstructive diuresis, which produces the dehydration that follows a "successful" unblocking.',
    ],
    sources: ['ettinger', 'merck'],
  },
  {
    id: 'proc-calf-stomach-tube',
    title: 'Oral stomach tubing and feeding a calf',
    system: 'Large animal',
    species: ['cattle', 'buffalo'],
    level: 'Core',
    duration: '5–10 minutes',
    summary:
      'Passing a stomach tube correctly, confirming placement before pouring, and delivering oral rehydration solution or colostrum safely.',
    equipment: [
      'A calf stomach tube with a smooth end and an internal diameter matched to the calf',
      'A speculum or a mouth gag with a tube channel',
      'Lubricant',
      'Oral rehydration solution at body temperature, or colostrum',
      'A funnel or a dosing bag',
    ],
    steps: [
      'Restrain the calf in a standing position with the head held level — not extended upwards.',
      'Pass the speculum and then lubricate the tube and pass it over the tongue and down the oesophagus, allowing the calf to swallow.',
      'Confirm placement: palpate the tube in the left jugular groove, check for a negative pressure draw, and smell the rumen gas. Never pour before confirming.',
      'Raise the funnel and deliver the fluid by gravity, at body temperature.',
      'Rinse the tube with clean water and kink it before withdrawal so no fluid enters the airway.',
      'Record the volume, the time and what was given.',
    ],
    pitfalls: [
      'Pouring before confirming placement — an intratracheal feed is fatal, and it happens quickly.',
      'Holding the head extended upwards, which makes tracheal placement more likely.',
      'Cold fluid, which drops the core temperature of a calf that is already hypothermic.',
      'Giving oral fluid to a calf with a poor or absent suckle and no swallowing reflex — this calf needs a stomach tube only if it can protect its airway.',
    ],
    sources: ['merck-large', 'smith'],
  },
  {
    id: 'proc-intramammary-cow',
    title: 'Intramammary infusion in a cow',
    system: 'Large animal',
    species: ['cattle', 'buffalo', 'goat', 'sheep'],
    level: 'Core',
    duration: '10–15 minutes for all four quarters',
    summary:
      'The aseptic technique for infusing an intramammary tube, including the teat-end disinfection that stops the treatment causing the next infection.',
    equipment: [
      'The intramammary product at room temperature',
      'Teat wipes or cotton wool and surgical spirit or a teat dip',
      'Gloves',
      'A post-milking teat disinfectant',
      'The withdrawal record for the treated animal',
    ],
    steps: [
      'Restrain the cow and milk out the affected quarter completely, collecting the milk in a strip cup so you can see what is there.',
      'Clean the teat end, then disinfect it with spirit on a separate wipe and allow it to dry.',
      'Using a partial-insertion (short) cannula, insert the tip just into the teat canal without forcing it.',
      'Infuse the tube slowly and completely.',
      'Pinch the teat end and hold for a few seconds, then massage the product upwards into the gland.',
      'Dip the teat with an approved post-milking disinfectant.',
      'Record the quarter, the product, the batch, the date and the milk and meat withdrawal dates.',
    ],
    pitfalls: [
      'Full-insertion cannulas, which damage the teat canal and carry organisms into the gland.',
      'Treating on appearance rather than on culture, which treats a quarter that had no infection and misses the one that did.',
      'Not recording the withdrawal — the commonest cause of a violative milk residue.',
      'Reusing a partial tube, or touching the cannula to anything before insertion.',
    ],
    sources: ['merck-large', 'smith'],
  },
  {
    id: 'proc-nasogastric-horse',
    title: 'Nasogastric intubation of a horse',
    system: 'Emergency',
    species: ['horse'],
    level: 'Core',
    duration: '5–10 minutes',
    summary:
      'Passing a nasogastric tube to decompress a colicking horse or to administer fluids and medication, with the checks that confirm oesophageal placement.',
    equipment: [
      'A nasogastric tube of the correct diameter for the horse',
      'Lubricant',
      'A bucket of water and a syringe or pump for the fluid',
      'A twitch, and a handler',
      'A means of confirming placement: smell, a blow test, and reflux',
    ],
    steps: [
      'Restrain the horse with a twitch and a competent handler; stand to the left and keep a hand on the head.',
      'Lubricate the tube and pass it along the ventral meatus of the nose, directing it ventromedially.',
      'Advance with the horse swallowing; you will see the tube pass down the left jugular groove.',
      'Confirm placement: feel the tube in the jugular groove, smell the breath through the tube, or blow and feel the oesophagus distend.',
      'Siphon the gastric contents using a siphon or a pump, and measure the volume of the reflux.',
      'Administer the fluid or medication slowly, then kink the tube before withdrawal.',
      'Record the volume of the reflux and repeat the decompression as often as the case requires.',
    ],
    pitfalls: [
      'Passing the tube into the trachea — always confirm before pouring. There is no safe volume of fluid in a horse\'s airway.',
      'Using a tube that is too narrow, which blocks on the feed material.',
      'Not measuring the reflux, which is the number that tells you the obstruction is real.',
      'Not kinking the tube on withdrawal, so the residual fluid drips into the airway.',
    ],
    sources: ['merck', 'smith'],
  },
  {
    id: 'proc-wound-lavage',
    title: 'Wound lavage and debridement',
    system: 'Surgery',
    species: ['dog', 'cat', 'horse', 'cattle'],
    level: 'Core',
    duration: '15–30 minutes',
    summary:
      'Copious lavage with the right solution and the right pressure, and conservative debridement, which together prevent more infection than any antibiotic.',
    equipment: [
      'Clippers and a surgical prep solution',
      'Water-soluble gel to fill the wound during clipping',
      'A 1 L bag or a 60 mL syringe with an 18 G needle — enough to produce 7–8 psi',
      'Warmed balanced electrolyte solution or sterile saline',
      'Sterile gloves, instruments and a sterile dressing',
    ],
    steps: [
      'Stabilise the patient: the wound is almost never the thing that kills the animal in the first hour.',
      'Clip wide around the wound and fill the wound itself with a water-soluble gel so you do not push hair into it.',
      'Prepare the surrounding skin, then lavage the wound copiously — volume and pressure matter more than the solution.',
      'Debride conservatively at the first pass: remove obvious devitalised tissue only, and let the marginal tissue declare itself over 48 hours.',
      'Take a deep culture after the lavage, not from the surface.',
      'Decide on closure: primary only if the wound is fresh, clean and tension-free.',
      'Dress, protect from the patient, and review at 48 hours.',
    ],
    pitfalls: [
      'Using a concentrated antiseptic in the wound, which damages the granulation tissue it is meant to protect.',
      'Lavage at too low a pressure to displace the bacteria — a syringe through a splash shield is the classic error.',
      'Closing a contaminated or tension-filled wound primarily because it looks tidy.',
      'Prescribing an antibiotic instead of lavaging properly.',
    ],
    sources: ['fossum', 'merck'],
  },
  {
    id: 'proc-blood-collection-bird',
    title: 'Venepuncture in a bird',
    system: 'Exotic',
    species: ['bird', 'poultry'],
    level: 'Intermediate',
    duration: '5 minutes',
    summary:
      'Right jugular or medial metatarsal venepuncture in a bird, with the restraint and the handling that stop a small patient dying during a blood test.',
    equipment: [
      'A 25–27 G needle and a 1 mL syringe, or a heparinised capillary tube',
      'A towel or a soft restraint, and a handler',
      'Gauze and a means of applying pressure',
      'A warmed recovery box',
    ],
    steps: [
      'Assess whether the bird is stable enough to restrain at all — a dyspnoeic bird is sampled after it has been oxygenated, not before.',
      'Restrain with a towel, supporting the keel so the sternum can move.',
      'For the right jugular: the right vein is larger in most species. Part the feathers, moisten them with alcohol, and visualise the vein in the apteric area.',
      'Insert at a shallow angle and withdraw gently — apply digital pressure on the vein proximally to fill it.',
      'Withdraw no more than 1% of the body weight in a healthy bird, and less in a compromised one.',
      'Apply firm pressure to the site for at least 30–60 seconds; a bird haematoma is how a venepuncture becomes an emergency.',
      'Return the bird to a warmed, quiet box and watch it for 10 minutes.',
    ],
    pitfalls: [
      'Restraining a dyspnoeic bird for a routine sample — this is the commonest way a bird dies in a consultation room.',
      'Taking too large a volume: 1% of body weight is the ceiling, and 10% is fatal.',
      'Inadequate pressure afterwards, so a jugular haematoma forms under the skin.',
      'Using the left jugular by habit, when the right is the larger vein in most species.',
    ],
    sources: ['carpenter', 'merck'],
  },
  {
    id: 'proc-foal-plasma-transfusion',
    title: 'Checking failure of passive transfer in a foal',
    system: 'Neonatology',
    species: ['horse'],
    level: 'Core',
    duration: '10 minutes',
    summary:
      'Measuring IgG in a foal at 12–24 hours with the available in-clinic test, and the plasma transfusion decision that follows a failure.',
    equipment: [
      'An in-clinic IgG test (SNAP, stall-side ELISA, or a zinc sulfate turbidity test as a screen)',
      'A clipped and prepared jugular site',
      'A blood tube and a small syringe',
      'Plasma for transfusion where the result indicates a failure',
    ],
    steps: [
      'Test every foal at 12–24 hours of age. Failure of passive transfer is silent until it is a septic joint.',
      'Collect a blood sample into the appropriate tube for the test you are using.',
      'Run the test according to the manufacturer\'s timing — reading a SNAP early or late changes the result.',
      'Interpret: an IgG below roughly 400 mg/dL is a complete failure, 400–800 mg/dL is a partial failure.',
      'A complete failure needs plasma: 1–2 L for a 50 kg foal, given slowly with monitoring.',
      'Re-measure the IgG 12–24 hours after the transfusion.',
      'Investigate why: colostrum quality, the timing of the first suck, and the mare\'s management.',
    ],
    pitfalls: [
      'Waiting for the clinical signs — by then you are treating septicaemia, not preventing it.',
      'Reading the test outside the manufacturer\'s timing window.',
      'Running the plasma in too fast: warm it, filter it, and monitor the foal for a reaction throughout.',
      'Treating the foal and not the farm, so the next one happens the same way.',
    ],
    sources: ['smith', 'merck'],
  },
  {
    id: 'proc-rectal-cow',
    title: 'Rectal examination of a cow',
    system: 'Large animal',
    species: ['cattle', 'buffalo'],
    level: 'Intermediate',
    duration: '5–10 minutes',
    summary:
      'A systematic rectal examination covering the reproductive tract, the gastrointestinal tract and the urinary tract — and the safety that makes it survivable.',
    equipment: [
      'An obstetric sleeve and obstetric lubricant',
      'A crush with a head gate, and a tail restraint',
      'A way of recording the findings',
    ],
    steps: [
      'Restrain the cow in a crush with the head secured; tie the tail to one side and stand clear of the hind limbs.',
      'Put on the sleeve and lubricate generously; form the fingers into a cone.',
      'Introduce the hand with the fingers together, and wait for the rectum to relax rather than pushing against a contraction.',
      'Empty the rectum if there is faecal material, then work systematically: uterus and ovaries, then the rumen, then the left kidney, then the pelvic inlet.',
      'Feel for the fremitus of the uterine artery in a pregnant cow, and for the size and the tone of the uterus in a fresh cow.',
      'Check the rumen fill and consistency, the left kidney, and the caudal structures before withdrawing.',
      'Withdraw slowly and record the findings immediately.',
    ],
    pitfalls: [
      'Standing behind a cow that can kick — position yourself at the side, beside the hip.',
      'Pushing against a rectal contraction, which tears the rectum.',
      'Finding the interesting thing and stopping there — a systematic sequence is what catches the second problem.',
      'Not recording the findings, so the next examination cannot be compared.',
    ],
    sources: ['merck-large', 'smith'],
  },
  {
    id: 'proc-nail-trim-shear',
    title: 'Foot trimming and lameness examination in sheep',
    system: 'Large animal',
    species: ['sheep', 'goat'],
    level: 'Core',
    duration: '5 minutes per animal',
    summary:
      'The lameness scoring and foot-trimming sequence that separates footrot from a simple overgrowth, and the hygiene that stops the trim spreading the infection.',
    equipment: [
      'Foot shears or secateurs, and a hoof knife',
      'Foot spray or footbath solution',
      'Gloves — footrot is contagious, and orf is zoonotic',
      'A marking spray and a record of the affected animals',
      'A footbath with the correct concentration and a dry standing area afterwards',
    ],
    steps: [
      'Score the lameness by watching the sheep walk on level ground, before you catch any of them.',
      'Turn the sheep onto its rump and examine all four feet; catch the problem in both the front and the hind feet.',
      'Clean the foot first so you can see what you are trimming.',
      'Trim the wall back to the level of the sole, in thin slices, and stop before you reach pink tissue.',
      'Do not carve into the sole to make it look tidy — over-trimming causes more lameness than under-trimming.',
      'Identify footrot: a characteristic smell, under-running of the horn, and separation at the skin–horn junction.',
      'Spray or footbath, then turn the sheep out onto clean, dry ground. Treat the group, not the individual.',
    ],
    pitfalls: [
      'Over-trimming, which converts a lameness problem into a foot abscess problem.',
      'Treating the individual and ignoring the group: footrot is contagious and the rest of the mob is already exposed.',
      'Using a footbath without a dry standing area afterwards, so the feet are softened and then re-infected.',
      'Not wearing gloves — orf is a real zoonosis.',
    ],
    sources: ['merck-large', 'smith'],
  },
];

export const PROCEDURE_MAP: Record<string, ProcedureCard> = PROCEDURES.reduce(
  (acc, p) => {
    acc[p.id] = p;
    return acc;
  },
  {} as Record<string, ProcedureCard>,
);

export const PROCEDURE_SYSTEMS = [...new Set(PROCEDURES.map((p) => p.system))].sort();

export function searchProcedures(query: string): ProcedureCard[] {
  const q = query.trim().toLowerCase();
  if (!q) return PROCEDURES;
  return PROCEDURES.filter((p) => {
    if (p.title.toLowerCase().includes(q)) return true;
    if (p.system.toLowerCase().includes(q)) return true;
    return p.summary.toLowerCase().includes(q) || p.steps.some((s) => s.toLowerCase().includes(q));
  });
}
