import { describe, expect, it } from 'vitest';
import { cloudError, parseConnection } from './cloud';
const publicConfig = { apiKey: 'synthetic-' + 'x'.repeat(30), projectId: 'fixture-project', authDomain: 'fixture-project.firebaseapp.com' };
describe('explicit authorised cloud configuration', () => {
  it('accepts public client configuration, keeping only allowed fields', () => {
    const config = parseConnection(JSON.stringify({ ...publicConfig, unused: 'not-saved' }), 'NewMedicinesData');
    expect(config.projectId).toBe('fixture-project'); expect(config).not.toHaveProperty('unused');
  });
  it('rejects private service-account credentials', () => {
    expect(() => parseConnection(JSON.stringify({ type: 'service_account', private_key: 'synthetic-not-a-real-key' }), 'NewMedicinesData')).toThrow(/Never|Do not supply/);
  });
  it('refuses placeholders and local/emulator domains', () => {
    expect(() => parseConnection(JSON.stringify({ ...publicConfig, apiKey: 'YOUR_PUBLIC_WEB_API_KEY' }), 'NewMedicinesData')).toThrow(/placeholder/);
    expect(() => parseConnection(JSON.stringify({ ...publicConfig, authDomain: 'localhost' }), 'NewMedicinesData')).toThrow(/not a local/);
    expect(() => parseConnection(JSON.stringify(publicConfig), '../other')).toThrow(/single collection/);
  });
  it('surfaces access-control denials rather than attempting a bypass', () => {
    expect(cloudError({ code: 'permission-denied' })).toMatch(/does not bypass/);
    expect(cloudError({ code: 'auth/unauthorized-domain' })).toMatch(/authorised domain/);
  });
});
