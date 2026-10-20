import { Route, Routes } from 'react-router-dom';
import Layout from './components/Layout';
import Home from './pages/Home';
import Tools from './pages/Tools';
import DrugCalculatorPage from './pages/DrugCalculatorPage';
import Drugs from './pages/Drugs';
import DrugDetail from './pages/DrugDetail';
import FluidTherapy from './pages/FluidTherapy';
import Diagnose from './pages/Diagnose';
import Interactions from './pages/Interactions';
import ReferenceRanges from './pages/ReferenceRanges';
import Toxicology from './pages/Toxicology';
import Vaccinations from './pages/Vaccinations';
import Diseases from './pages/Diseases';
import DiseaseDetail from './pages/DiseaseDetail';
import Notes from './pages/Notes';
import NoteDetail from './pages/NoteDetail';
import Procedures from './pages/Procedures';
import Cases from './pages/Cases';
import CasePlayer from './pages/CasePlayer';
import Assistant from './pages/Assistant';
import Challenge from './pages/Challenge';
import Flashcards from './pages/Flashcards';
import Clinic from './pages/Clinic';
import Pricing from './pages/Pricing';
import About from './pages/About';
import Disclaimer from './pages/Disclaimer';
import NotFound from './pages/NotFound';

export default function App() {
  return (
    <Routes>
      <Route element={<Layout />}>
        <Route index element={<Home />} />
        <Route path="tools" element={<Tools />} />

        <Route path="drug-calculator" element={<DrugCalculatorPage />} />
        <Route path="fluid-therapy" element={<FluidTherapy />} />
        <Route path="diagnose" element={<Diagnose />} />
        <Route path="interactions" element={<Interactions />} />
        <Route path="reference-ranges" element={<ReferenceRanges />} />
        <Route path="toxicology" element={<Toxicology />} />
        <Route path="vaccinations" element={<Vaccinations />} />

        <Route path="drugs" element={<Drugs />} />
        <Route path="drugs/:id" element={<DrugDetail />} />

        <Route path="diseases" element={<Diseases />} />
        <Route path="diseases/:id" element={<DiseaseDetail />} />

        <Route path="notes" element={<Notes />} />
        <Route path="notes/:id" element={<NoteDetail />} />

        <Route path="procedures" element={<Procedures />} />
        <Route path="cases" element={<Cases />} />
        <Route path="cases/:id" element={<CasePlayer />} />

        <Route path="assistant" element={<Assistant />} />
        <Route path="challenge" element={<Challenge />} />
        <Route path="flashcards" element={<Flashcards />} />
        <Route path="clinic" element={<Clinic />} />

        <Route path="pricing" element={<Pricing />} />
        <Route path="about" element={<About />} />
        <Route path="disclaimer" element={<Disclaimer />} />

        <Route path="*" element={<NotFound />} />
      </Route>
    </Routes>
  );
}
