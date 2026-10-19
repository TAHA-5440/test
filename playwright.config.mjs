import { defineConfig } from '@playwright/test';
import { browserLaunchOptions } from './tools/web/browser.mjs';

export default defineConfig({
  testDir: './web/e2e',
  fullyParallel: false,
  workers: 1,
  timeout: 30_000,
  reporter: 'list',
  outputDir: 'recovery-data/web/playwright-results',
  use: {
    baseURL: process.env.WEB_TEST_URL || 'http://127.0.0.1:5173',
    launchOptions: await browserLaunchOptions(),
    viewport: { width: 1440, height: 1000 },
    screenshot: 'only-on-failure',
    trace: 'retain-on-failure',
  },
});
