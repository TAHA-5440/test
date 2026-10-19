import fs from 'node:fs/promises';
import path from 'node:path';

const packages = ['react', 'react-dom', 'lucide-react', '@radix-ui/react-dialog', 'idb', 'papaparse', 'sql.js', 'dompurify', 'firebase', '@fontsource/manrope', '@fontsource/dm-sans', 'workbox-window'];
const destination = path.resolve('dist/licenses');
await fs.mkdir(destination, { recursive: true });
const rows = [];
for (const name of packages) {
  const directory = path.resolve('node_modules', name);
  const metadata = JSON.parse(await fs.readFile(path.join(directory, 'package.json'), 'utf8'));
  rows.push(`| ${name} | ${metadata.version} | ${typeof metadata.license === 'string' ? metadata.license : JSON.stringify(metadata.license)} |`);
  for (const file of await fs.readdir(directory)) {
    if (/^(license|licence|ofl|notice)([.\-_].*)?$/i.test(file)) {
      const source = path.join(directory, file);
      if ((await fs.stat(source)).isFile()) await fs.copyFile(source, path.join(destination, `${name.replaceAll('/', '__')}-${file}`));
    }
  }
}
await fs.writeFile('dist/THIRD_PARTY_NOTICES.md', '# Web runtime notices\n\nDirect browser dependencies and the PWA window helper. Original notices available in installed packages are copied into licenses/. This is not a new licence grant or an exhaustive legal audit of transitive dependencies.\n\n| Package | Version | Declared licence |\n| --- | --- | --- |\n' + rows.join('\n') + '\n');
console.log('Web runtime/font licence notices copied into dist/.');
