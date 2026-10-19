import { test, expect } from '@playwright/test';
import type { Page } from '@playwright/test';
import { readFile } from 'node:fs/promises';
import { fixture } from '../src/test/fixtures';

const rows = [
  fixture({ docId: 'fixture-alpha', saltName: 'Fixture ingredient Alpha', brandName: 'Fixture product Alpha', companyName: 'Fixture company A', overview: '<p>Original fixture overview.</p><script>window.__fixtureInjected=true</script><img src="https://invalid.example/never-load">' }),
  fixture({ docId: 'fixture-beta', saltName: 'Fixture ingredient Alpha', brandName: 'Fixture product Beta', companyName: 'Fixture company B', availableForms: { 'Second fixture form': { packing: 'Original fixture packing' } } }),
  fixture({ docId: 'fixture-gamma', saltName: 'Fixture ingredient Gamma', brandName: 'Fixture product Gamma', block: 'Yes' }),
];
async function nav(page: Page, label: string) {
  await page.locator('.sidebar').getByRole('button', { name: label, exact: true }).click();
}
async function importRows(page: Page, data: unknown = { medicines: rows }, count = 3) {
  await page.getByRole('button', { name: 'Import catalogue', exact: true }).first().click();
  await page.getByLabel('Choose medicine data file').setInputFiles({ name: 'synthetic-ui-fixtures.json', mimeType: 'application/json', buffer: Buffer.from(JSON.stringify(data)) });
  await expect(page.getByText('Ready to import', { exact: true })).toBeVisible();
  await page.getByRole('button', { name: `Import ${count} records`, exact: true }).click();
  await expect(page.getByRole('dialog')).toHaveCount(0);
  await expect(page.locator('.stat-card').first().locator('strong')).toHaveText(String(count));
}
async function removeData(page: Page) {
  await nav(page, 'Preferences');
  await page.getByRole('button', { name: 'Remove data', exact: true }).click();
  await page.getByLabel('Type REMOVE to confirm').fill('REMOVE');
  await page.getByRole('button', { name: 'Remove local data', exact: true }).click();
  await expect(page.getByRole('dialog')).toHaveCount(0);
}

test.beforeEach(async ({ page }) => { await page.goto('/'); });

test('starts honestly empty and makes no default backend requests', async ({ page }) => {
  const requests: string[] = [];
  page.on('request', request => { if (/googleapis\.com|firebaseio\.com|firebaseapp\.com/.test(request.url())) requests.push(request.url()); });
  await page.reload();
  await expect(page.getByRole('heading', { name: 'Medicine library.' })).toBeVisible();
  await expect(page.getByText('Your medicine library is ready for data')).toBeVisible();
  await expect(page.locator('.stat-card strong')).toHaveText(['0', '0', '0', '0']);
  await nav(page, 'Data & sync');
  await expect(page.getByRole('button', { name: 'Export JSON', exact: true })).toBeDisabled();
  await expect(page.getByRole('button', { name: 'Sync catalogue', exact: true })).toBeDisabled();
  expect(requests).toEqual([]);
});

test('imports actual supplied rows, groups generics and persists across reload', async ({ page }) => {
  await importRows(page);
  await expect(page.locator('.catalogue-table tbody tr')).toHaveCount(2);
  await expect(page.locator('.stat-card strong')).toHaveText(['3', '2', '3', '0']);
  await page.reload();
  await expect(page.locator('.stat-card').first().locator('strong')).toHaveText('3');
  await expect(page.locator('.catalogue-table tbody tr')).toHaveCount(2);
});

test('brand search, real company/form filters, clearing and sort work', async ({ page }) => {
  await importRows(page);
  await page.getByRole('tab', { name: 'Brands', exact: true }).click();
  await expect(page.locator('.catalogue-table tbody tr')).toHaveCount(3);
  await page.getByLabel('Search medicines').fill('product Beta');
  await expect(page.locator('.catalogue-table tbody tr')).toHaveCount(1);
  await page.getByLabel('Clear search').click();
  await page.getByRole('button', { name: 'Filters', exact: true }).click();
  await page.getByLabel('Filter by company').selectOption('Fixture company A');
  await expect(page.locator('.catalogue-table tbody tr')).toHaveCount(2);
  await page.getByLabel('Filter by dosage form').selectOption('Second fixture form');
  await expect(page.getByText('No matching records', { exact: true })).toBeVisible();
  await page.getByRole('button', { name: 'Clear search & filters', exact: true }).click();
  await page.getByLabel('Sort medicines').selectOption('desc');
  await expect(page.locator('.medicine-name strong').first()).toHaveText('Fixture product Gamma');
});

test('record drawer shows source details, variants and safe clinical text', async ({ page }) => {
  const forbiddenRequests: string[] = [];
  await page.route('https://invalid.example/**', async route => { forbiddenRequests.push(route.request().url()); await route.abort(); });
  await importRows(page);
  await page.locator('.medicine-name').filter({ hasText: 'Fixture ingredient Alpha' }).click();
  const dialog = page.getByRole('dialog');
  await expect(dialog).toBeVisible();
  await expect(dialog.getByText('Original fixture overview.', { exact: true })).toBeVisible();
  expect(await page.evaluate(() => (window as Window & { __fixtureInjected?: unknown }).__fixtureInjected)).toBeUndefined();
  await expect(dialog.locator('.source-text script, .source-text img')).toHaveCount(0);
  await dialog.getByLabel('Choose a source record').selectOption('fixture-beta');
  await dialog.getByRole('tab', { name: 'Forms', exact: true }).click();
  await expect(dialog.getByRole('heading', { name: 'Second fixture form', exact: true })).toBeVisible();
  await expect(dialog.getByText('Original fixture packing', { exact: true })).toBeVisible();
  await dialog.getByRole('tab', { name: 'Dosage', exact: true }).click();
  await expect(dialog.getByText('Synthetic test note. No clinical dose is supplied.')).toBeVisible();
  await dialog.getByRole('tab', { name: /Alternatives/ }).click();
  await expect(dialog.getByRole('button', { name: /Fixture product Alpha/ })).toBeVisible();
  await dialog.getByRole('tab', { name: 'Source', exact: true }).click();
  await expect(dialog.getByText('fixture-beta', { exact: true })).toBeVisible();
  await page.keyboard.press('Escape');
  await expect(dialog).toHaveCount(0);
  expect(forbiddenRequests).toEqual([]);
});

test('generic favourites persist and can be removed from the saved page', async ({ page }) => {
  await importRows(page);
  await page.getByRole('button', { name: 'Save Fixture ingredient Alpha', exact: true }).click();
  await expect(page.getByRole('button', { name: 'Unsave Fixture ingredient Alpha', exact: true })).toBeVisible();
  await nav(page, 'Saved references');
  await expect(page.locator('.catalogue-table tbody tr')).toHaveCount(1);
  await page.reload();
  await expect(page.locator('.catalogue-table tbody tr')).toHaveCount(1);
  await page.getByRole('button', { name: 'Unsave Fixture ingredient Alpha', exact: true }).click();
  await expect(page.getByText('No saved generic references yet')).toBeVisible();
});

test('an invalid import does not replace the existing catalogue', async ({ page }) => {
  await importRows(page);
  await page.getByRole('button', { name: 'Import catalogue', exact: true }).first().click();
  await page.getByLabel('Choose medicine data file').setInputFiles({ name: 'not-medicine.json', mimeType: 'application/json', buffer: Buffer.from(JSON.stringify({ medicines: [] })) });
  await expect(page.getByRole('alert')).toContainText('no medicine records');
  await page.getByRole('button', { name: 'Cancel', exact: true }).click();
  await expect(page.locator('.stat-card').first().locator('strong')).toHaveText('3');
  await expect(page.locator('.catalogue-table tbody tr')).toHaveCount(2);
});

test('JSON export retains actual data and favourite flags without cloud credentials', async ({ page }) => {
  await importRows(page, rows.map((record, index) => index === 0 ? { ...record, originalNote: 'Preserve this additional fixture field.' } : record));
  await page.getByRole('button', { name: 'Save Fixture ingredient Alpha', exact: true }).click();
  await expect(page.getByRole('button', { name: 'Unsave Fixture ingredient Alpha', exact: true })).toBeVisible();
  await nav(page, 'Data & sync');
  await page.getByRole('button', { name: 'Export JSON', exact: true }).click();
  const downloadEvent = page.waitForEvent('download');
  await page.getByRole('button', { name: 'Download JSON', exact: true }).click();
  const download = await downloadEvent;
  const data = JSON.parse(await readFile((await download.path())!, 'utf8'));
  expect(data.medicineCount).toBe(3);
  expect(data.medicines[0].overview).toBe(rows[0].overview);
  expect(data.medicines[0].originalNote).toBe('Preserve this additional fixture field.');
  expect(data.medicines.filter((r: { isSaltFavourite: boolean }) => r.isSaltFavourite)).toHaveLength(2);
  expect(data).not.toHaveProperty('apiKey'); expect(data).not.toHaveProperty('firebase');
});

test('SQLite export works in the browser and its rows can be reimported', async ({ page }) => {
  await importRows(page);
  await nav(page, 'Data & sync');
  await page.getByRole('button', { name: 'SQLite', exact: true }).click();
  const downloadEvent = page.waitForEvent('download');
  await page.getByRole('button', { name: 'Download SQLITE', exact: true }).click();
  const download = await downloadEvent;
  const path = (await download.path())!;
  const data = await readFile(path);
  expect(data.subarray(0, 16).toString()).toBe('SQLite format 3\0');
  await expect(page.getByRole('dialog')).toHaveCount(0);
  await removeData(page);
  await nav(page, 'Medicine library');
  await page.getByRole('button', { name: 'Import catalogue', exact: true }).first().click();
  await page.getByLabel('Choose medicine data file').setInputFiles({ name: 'medicines_DB', mimeType: 'application/vnd.sqlite3', buffer: data });
  await expect(page.getByText('Ready to import', { exact: true })).toBeVisible();
  await page.getByRole('button', { name: 'Import 3 records', exact: true }).click();
  await expect(page.locator('.stat-card').first().locator('strong')).toHaveText('3');
});

test('appearance and density are real persistent preferences', async ({ page }) => {
  await nav(page, 'Preferences');
  await page.getByRole('button', { name: 'Dark workspace', exact: true }).click();
  await expect(page.locator('html')).toHaveAttribute('data-theme', 'dark');
  await page.getByRole('button', { name: /Compact More references on screen/ }).click();
  await expect(page.locator('html')).toHaveAttribute('data-density', 'compact');
  await page.reload();
  await expect(page.locator('html')).toHaveAttribute('data-theme', 'dark');
  await expect(page.locator('html')).toHaveAttribute('data-density', 'compact');
});

test('cloud requests require explicit configuration and private admin keys are rejected', async ({ page }) => {
  const vendor: string[] = [];
  page.on('request', request => { if (/googleapis\.com|firebaseio\.com/.test(request.url())) vendor.push(request.url()); });
  await nav(page, 'Data & sync');
  await expect(page.getByRole('button', { name: 'Sync catalogue', exact: true })).toBeDisabled();
  await page.getByLabel('Firebase public web configuration').fill(JSON.stringify({ type: 'service_account', private_key: 'synthetic-not-a-real-key' }));
  await page.getByRole('button', { name: 'Save config', exact: true }).click();
  await expect(page.getByRole('alert')).toContainText('Do not supply service-account keys');
  expect(vendor).toEqual([]);
});

test('pagination, keyboard search shortcut and blocked-status filter work', async ({ page }) => {
  const many = Array.from({ length: 23 }, (_, i) => fixture({ docId: `fixture-${i}`, saltName: `Fixture ingredient ${String(i).padStart(2, '0')}`, brandName: `Fixture product ${i}`, block: i === 0 ? 'Yes' : 'No' }));
  await importRows(page, many, 23);
  await expect(page.locator('.catalogue-table tbody tr')).toHaveCount(10);
  await page.getByLabel('Next page').click();
  await expect(page.locator('.table-footer')).toContainText('11–20 of 23');
  await page.getByLabel('References per page').selectOption('25');
  await expect(page.locator('.catalogue-table tbody tr')).toHaveCount(23);
  await page.keyboard.press('/');
  await expect(page.getByLabel('Search medicines')).toBeFocused();
  await page.getByLabel('Search medicines').fill('fixture-0');
  await expect(page.locator('.catalogue-table tbody tr')).toHaveCount(1);
  await page.getByLabel('Clear search').click();
  await page.getByRole('button', { name: 'Filters', exact: true }).click();
  await page.getByLabel('Filter by source status').selectOption('blocked');
  await expect(page.locator('.catalogue-table tbody tr')).toHaveCount(1);
});

test('mobile navigation, import and dialogs fit a narrow viewport', async ({ page }) => {
  await page.setViewportSize({ width: 390, height: 844 });
  await page.getByLabel('Open navigation').click();
  await page.getByRole('dialog').getByRole('button', { name: 'Data & sync', exact: true }).click();
  await expect(page.getByRole('heading', { name: 'Data & sync.' })).toBeVisible();
  expect(await page.evaluate(() => document.documentElement.scrollWidth > innerWidth)).toBe(false);
  await page.getByRole('button', { name: 'Choose a data file', exact: false }).click();
  await expect(page.getByRole('dialog')).toBeVisible();
  expect(await page.getByRole('dialog').evaluate(e => e.getBoundingClientRect().width <= innerWidth)).toBe(true);
  await page.getByLabel('Close dialog').click();
  await page.getByLabel('Open navigation').click();
  await page.getByRole('dialog').getByRole('button', { name: 'About this edition', exact: true }).click();
  await expect(page.getByRole('heading', { name: /A familiar reference/ })).toBeVisible();
  expect(await page.evaluate(() => document.documentElement.scrollWidth > innerWidth)).toBe(false);
});

test('installed production app shell and imported catalogue work after offline reload', async ({ page, context }) => {
  test.skip(process.env.PWA_TEST !== '1', 'Run against the production preview with PWA_TEST=1.');
  await page.evaluate(async () => { await navigator.serviceWorker.ready; });
  await page.reload();
  await page.waitForFunction(() => Boolean(navigator.serviceWorker.controller));
  await importRows(page);
  await context.setOffline(true);
  await page.reload();
  await expect(page.locator('.stat-card').first().locator('strong')).toHaveText('3');
  await expect(page.locator('.catalogue-table tbody tr')).toHaveCount(2);
  await expect(page.getByText('Imported catalogue browsing and favourites still work', { exact: false })).toBeVisible();
  await context.setOffline(false);
});
