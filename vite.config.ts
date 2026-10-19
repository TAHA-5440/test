import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';
import { VitePWA } from 'vite-plugin-pwa';
import { fileURLToPath } from 'node:url';

const directory = (path: string) => fileURLToPath(new URL(path, import.meta.url));

export default defineConfig({
  root: directory('./web'),
  base: './',
  plugins: [
    react(),
    VitePWA({
      registerType: 'prompt',
      includeAssets: ['brand.svg'],
      manifest: {
        name: 'Vet Pharmapedia · Browser workspace',
        short_name: 'VetPharma',
        description: 'A local-first veterinary medicine reference workspace. Bring your authorised catalogue.',
        theme_color: '#176b5b',
        background_color: '#f5f7f8',
        display: 'standalone',
        start_url: './',
        scope: './',
        icons: [{ src: 'brand.svg', sizes: 'any', type: 'image/svg+xml', purpose: 'any maskable' }],
      },
      workbox: {
        globPatterns: ['**/*.{js,css,html,svg,png,woff,woff2,wasm}'],
        maximumFileSizeToCacheInBytes: 5 * 1024 * 1024,
        cleanupOutdatedCaches: true,
        // Only the app shell is precached. User records stay in IndexedDB;
        // no Firebase/API responses are put in a service-worker cache.
        runtimeCaching: [],
      },
      devOptions: { enabled: false },
    }),
  ],
  server: {
    host: '0.0.0.0', port: 5173, strictPort: true, allowedHosts: true,
    fs: {
      allow: [directory('./web'), directory('./node_modules')],
      deny: ['**/.env*', '**/.git/**', '**/google_drive/**', '**/recovery-data/**', '**/.venv/**', '**/*.db', '**/*.private.*'],
    },
  },
  preview: { host: '0.0.0.0', port: 5173, strictPort: true, allowedHosts: true },
  build: { outDir: directory('./dist'), emptyOutDir: true, chunkSizeWarningLimit: 900 },
});
