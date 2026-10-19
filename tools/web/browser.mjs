// Browser binaries and Linux dependencies are bundled by this npm package;
// no blocked external browser-download host or global system install is needed.
import chromiumBinary from '@sparticuz/chromium';
import { createRequire } from 'node:module';
import { dirname, resolve } from 'node:path';
import { pathToFileURL } from 'node:url';

export async function browserLaunchOptions() {
  if (process.env.CHROMIUM_EXECUTABLE_PATH) return { executablePath: process.env.CHROMIUM_EXECUTABLE_PATH, headless: true };
  if (process.platform !== 'linux') return { headless: true }; // Use a normal installed Playwright browser on other OSes.
  const require = createRequire(import.meta.url);
  const buildDirectory = dirname(require.resolve('@sparticuz/chromium'));
  const { inflate } = await import(pathToFileURL(resolve(buildDirectory, 'lambdafs.js')).href);
  const linuxLibraries = await inflate(resolve(buildDirectory, '../bin/al2023.tar.br'));
  const executablePath = await chromiumBinary.executablePath();
  return {
    executablePath,
    headless: true,
    // Keep web security/CORS enabled. These flags affect this isolated test
    // browser only, not the app or the user's ordinary browser.
    args: ['--no-sandbox', '--no-zygote', '--disable-dev-shm-usage', '--disable-gpu', '--use-gl=angle', '--use-angle=swiftshader', '--enable-unsafe-swiftshader'],
    env: { ...process.env, LD_LIBRARY_PATH: `${linuxLibraries}/lib${process.env.LD_LIBRARY_PATH ? ':' + process.env.LD_LIBRARY_PATH : ''}`, FONTCONFIG_PATH: '/tmp/fonts' },
  };
}
