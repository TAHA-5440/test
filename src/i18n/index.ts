import { usePreferences } from '../state/PreferencesContext';

/**
 * Interface localisation for English, Hindi and Spanish.
 *
 * Scope note, stated honestly: this translates the interface chrome —
 * navigation, labels, buttons, headings. It does NOT translate the clinical
 * corpus. Dose rates are numbers, and a mistranslated instruction is a safety
 * hazard, so drug monographs, withdrawal intervals and procedure steps stay in
 * English until a qualified translator reviews each entry.
 */

export type Dict = Record<string, string>;

const en: Dict = {
  'nav.home': 'Home',
  'nav.tools': 'Tools',
  'nav.drugs': 'Drug library',
  'nav.diseases': 'Conditions',
  'nav.notes': 'Clinical notes',
  'nav.cases': 'Case simulator',
  'nav.procedures': 'Procedures',
  'nav.assistant': 'Assistant',
  'nav.challenge': 'Daily challenge',
  'nav.pricing': 'Pricing',
  'nav.about': 'About',

  'common.species': 'Species',
  'common.weight': 'Weight',
  'common.dose': 'Dose',
  'common.route': 'Route',
  'common.frequency': 'Frequency',
  'common.indication': 'Indication',
  'common.duration': 'Duration',
  'common.withdrawal': 'Withdrawal',
  'common.search': 'Search',
  'common.results': 'results',
  'common.noResults': 'Nothing matched that search.',
  'common.sources': 'Sources',
  'common.reset': 'Reset',
  'common.calculate': 'Calculate',
  'common.copy': 'Copy',
  'common.copied': 'Copied',
  'common.back': 'Back',
  'common.next': 'Next',
  'common.print': 'Print',
  'common.offline': 'Offline — everything on this page still works.',
  'common.student': 'Student',
  'common.clinician': 'Clinician',
  'common.pro': 'Premium',
  'common.new': 'New',

  'home.title': 'Every dose, checked before it leaves your hand.',
  'home.subtitle':
    'A veterinary drug and fluid reference that runs on your phone with no signal. Every number is traceable to a named formulary.',
  'home.ctaPrimary': 'Open the drug calculator',
  'home.ctaSecondary': 'Browse 418 monographs',
  'home.statDrugs': 'drug monographs',
  'home.statSpecies': 'species covered',
  'home.statRefs': 'reference texts',
  'home.statOffline': 'offline',

  'tools.title': 'Clinical tools',
  'tools.subtitle': 'Twelve calculators and references, all of them usable with the network switched off.',

  'drugs.title': 'Drug library',
  'drugs.filterClass': 'Filter by class',
  'drugs.allClasses': 'All classes',

  'assistant.title': 'Clinical assistant',
  'assistant.subtitle': 'Ask about a dose, a toxin, a procedure or a reference range. It answers from the curated corpus and shows its sources.',
  'assistant.placeholder': 'e.g. meloxicam dose for a dog',
  'assistant.ask': 'Ask',
  'assistant.caveats': 'Caveats',
  'assistant.followUps': 'Follow-up questions',
  'assistant.evidence': 'Where this came from',
  'assistant.empty': 'No results yet — ask a question to begin.',

  'pricing.title': 'Simple pricing',
  'pricing.subtitle': 'Everything clinical is free. Premium adds the practice layer.',

  'footer.disclaimer':
    'Reference information for veterinarians and veterinary students. Confirm every dose against the product label, the individual patient and current national guidance before use.',
};

const hi: Dict = {
  'nav.home': 'होम',
  'nav.tools': 'टूल्स',
  'nav.drugs': 'दवा पुस्तकालय',
  'nav.diseases': 'रोग',
  'nav.notes': 'क्लिनिकल नोट्स',
  'nav.cases': 'केस सिम्युलेटर',
  'nav.procedures': 'प्रक्रियाएँ',
  'nav.assistant': 'सहायक',
  'nav.challenge': 'दैनिक प्रश्न',
  'nav.pricing': 'मूल्य',
  'nav.about': 'परिचय',

  'common.species': 'प्रजाति',
  'common.weight': 'वज़न',
  'common.dose': 'खुराक',
  'common.route': 'मार्ग',
  'common.frequency': 'आवृत्ति',
  'common.indication': 'संकेत',
  'common.duration': 'अवधि',
  'common.withdrawal': 'विथड्रॉअल',
  'common.search': 'खोजें',
  'common.results': 'परिणाम',
  'common.noResults': 'इस खोज से कुछ नहीं मिला।',
  'common.sources': 'स्रोत',
  'common.reset': 'रीसेट',
  'common.calculate': 'गणना करें',
  'common.copy': 'कॉपी',
  'common.copied': 'कॉपी हो गया',
  'common.back': 'पीछे',
  'common.next': 'आगे',
  'common.print': 'प्रिंट',
  'common.offline': 'ऑफ़लाइन — यह पृष्ठ फिर भी काम करता है।',
  'common.student': 'छात्र',
  'common.clinician': 'चिकित्सक',
  'common.pro': 'प्रीमियम',
  'common.new': 'नया',

  'home.title': 'हर खुराक, हाथ से निकलने से पहले जाँची गई।',
  'home.subtitle':
    'पशु चिकित्सा दवा और तरल चिकित्सा संदर्भ जो बिना नेटवर्क के आपके फ़ोन पर चलता है। हर संख्या किसी नामित फ़ॉर्मुलरी से मेल खाती है।',
  'home.ctaPrimary': 'दवा कैलकुलेटर खोलें',
  'home.ctaSecondary': '418 मोनोग्राफ देखें',
  'home.statDrugs': 'दवा मोनोग्राफ',
  'home.statSpecies': 'प्रजातियाँ',
  'home.statRefs': 'संदर्भ ग्रंथ',
  'home.statOffline': 'ऑफ़लाइन',

  'tools.title': 'क्लिनिकल टूल्स',
  'tools.subtitle': 'बारह कैलकुलेटर और संदर्भ — नेटवर्क बंद होने पर भी उपयोग योग्य।',

  'drugs.title': 'दवा पुस्तकालय',
  'drugs.filterClass': 'वर्ग के अनुसार फ़िल्टर',
  'drugs.allClasses': 'सभी वर्ग',

  'assistant.title': 'क्लिनिकल सहायक',
  'assistant.subtitle': 'खुराक, विष, प्रक्रिया या संदर्भ सीमा के बारे में पूछें। यह संग्रह से उत्तर देता है और स्रोत दिखाता है।',
  'assistant.placeholder': 'जैसे: कुत्ते के लिए मेलोक्सिकैम की खुराक',
  'assistant.ask': 'पूछें',
  'assistant.caveats': 'चेतावनियाँ',
  'assistant.followUps': 'अगले प्रश्न',
  'assistant.evidence': 'यह कहाँ से आया',
  'assistant.empty': 'अभी कोई परिणाम नहीं — प्रश्न पूछें।',

  'pricing.title': 'सरल मूल्य निर्धारण',
  'pricing.subtitle': 'सब कुछ नैदानिक मुफ़्त है। प्रीमियम में प्रैक्टिस लेयर जोड़ता है।',

  'footer.disclaimer':
    'पशु चिकित्सकों और छात्रों के लिए संदर्भ जानकारी। उपयोग से पहले हर खुराक की पुष्टि उत्पाद लेबल, रोगी और वर्तमान राष्ट्रीय मार्गदर्शन से करें।',
};

const es: Dict = {
  'nav.home': 'Inicio',
  'nav.tools': 'Herramientas',
  'nav.drugs': 'Fármacos',
  'nav.diseases': 'Enfermedades',
  'nav.notes': 'Notas clínicas',
  'nav.cases': 'Simulador de casos',
  'nav.procedures': 'Procedimientos',
  'nav.assistant': 'Asistente',
  'nav.challenge': 'Reto diario',
  'nav.pricing': 'Precios',
  'nav.about': 'Acerca de',

  'common.species': 'Especie',
  'common.weight': 'Peso',
  'common.dose': 'Dosis',
  'common.route': 'Vía',
  'common.frequency': 'Frecuencia',
  'common.indication': 'Indicación',
  'common.duration': 'Duración',
  'common.withdrawal': 'Retirada',
  'common.search': 'Buscar',
  'common.results': 'resultados',
  'common.noResults': 'No hay coincidencias para esa búsqueda.',
  'common.sources': 'Fuentes',
  'common.reset': 'Restablecer',
  'common.calculate': 'Calcular',
  'common.copy': 'Copiar',
  'common.copied': 'Copiado',
  'common.back': 'Atrás',
  'common.next': 'Siguiente',
  'common.print': 'Imprimir',
  'common.offline': 'Sin conexión — esta página sigue funcionando.',
  'common.student': 'Estudiante',
  'common.clinician': 'Clínico',
  'common.pro': 'Premium',
  'common.new': 'Nuevo',

  'home.title': 'Cada dosis, comprobada antes de salir de tu mano.',
  'home.subtitle':
    'Una referencia de fármacos y fluidoterapia veterinaria que funciona en tu móvil sin cobertura. Cada cifra se remonta a un formulario citado.',
  'home.ctaPrimary': 'Abrir la calculadora',
  'home.ctaSecondary': 'Ver 418 monografías',
  'home.statDrugs': 'monografías',
  'home.statSpecies': 'especies',
  'home.statRefs': 'textos de referencia',
  'home.statOffline': 'sin conexión',

  'tools.title': 'Herramientas clínicas',
  'tools.subtitle': 'Doce calculadoras y referencias, todas utilizables sin conexión.',

  'drugs.title': 'Biblioteca de fármacos',
  'drugs.filterClass': 'Filtrar por clase',
  'drugs.allClasses': 'Todas las clases',

  'assistant.title': 'Asistente clínico',
  'assistant.subtitle': 'Pregunta por una dosis, un tóxico, un procedimiento o un intervalo de referencia. Responde desde el corpus y muestra sus fuentes.',
  'assistant.placeholder': 'p. ej. dosis de meloxicam en perro',
  'assistant.ask': 'Preguntar',
  'assistant.caveats': 'Advertencias',
  'assistant.followUps': 'Preguntas relacionadas',
  'assistant.evidence': 'De dónde viene esto',
  'assistant.empty': 'Sin resultados todavía: haz una pregunta.',

  'pricing.title': 'Precios sencillos',
  'pricing.subtitle': 'Todo lo clínico es gratis. Premium añade la capa de gestión.',

  'footer.disclaimer':
    'Información de referencia para veterinarios y estudiantes. Confirme cada dosis con la ficha técnica, el paciente y la normativa nacional vigente antes de usarla.',
};

const DICTS: Record<string, Dict> = { en, hi, es };

export function useI18n(): { t: (key: string) => string; lang: string } {
  const { language } = usePreferences();
  const dict = DICTS[language] ?? en;
  const t = (key: string) => dict[key] ?? en[key] ?? key;
  return { t, lang: language };
}

export const LANGUAGES: { id: string; label: string; native: string }[] = [
  { id: 'en', label: 'English', native: 'English' },
  { id: 'hi', label: 'Hindi', native: 'हिन्दी' },
  { id: 'es', label: 'Spanish', native: 'Español' },
];
