import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';
import App from './App';
import { PreferencesProvider } from './state/PreferencesContext';
import './styles/global.css';

const container = document.getElementById('root');
if (!container) throw new Error('Root element #root was not found in index.html');

createRoot(container).render(
  <StrictMode>
    <PreferencesProvider>
      <BrowserRouter>
        <App />
      </BrowserRouter>
    </PreferencesProvider>
  </StrictMode>,
);
