import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';

// Config used only by `npm run verify` — bundles the verification harness for
// node so the routes and engines can be checked outside a browser.
export default defineConfig({
  plugins: [react()],
  build: {
    outDir: 'dist-verify',
    emptyOutDir: true,
    ssr: 'scripts/verify.tsx',
    minify: false,
  },
});
