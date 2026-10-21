import { SPECIES, SPECIES_ICON } from '../data/species';
import type { SpeciesId } from '../types';
import { Chip } from './ui';

interface Props {
  value: SpeciesId;
  onChange: (s: SpeciesId) => void;
  showProxyNote?: boolean;
  compact?: boolean;
}

export default function SpeciesPicker({ value, onChange, showProxyNote = true, compact = false }: Props) {
  void showProxyNote;
  return (
    <div>
      <div className="chip-row">
        {SPECIES.map((s) => (
          <Chip key={s.id} selected={s.id === value} onClick={() => onChange(s.id)} className={compact ? 'small' : ''}>
            {SPECIES_ICON[s.id]}{' '}
            {s.label}
          </Chip>
        ))}
      </div>

    </div>
  );
}

export function WeightField({
  value,
  onChange,
  label = 'Body weight',
  min = 0.01,
  max = 900,
}: {
  value: number;
  onChange: (n: number) => void;
  label?: string;
  min?: number;
  max?: number;
}) {
  return (
    <div className="field">
      <label className="label" htmlFor="weight-input">
        {label} (kg)
      </label>
      <div className="input-group">
        <input
          id="weight-input"
          className="input"
          type="number"
          inputMode="decimal"
          min={min}
          max={max}
          step="0.01"
          value={Number.isFinite(value) ? value : ''}
          onChange={(e) => {
            const v = Number.parseFloat(e.target.value);
            onChange(Number.isFinite(v) ? v : 0);
          }}
          style={{ maxWidth: '150px' }}
        />
        <input
          className="range"
          type="range"
          min={min}
          max={Math.min(max, 200)}
          step="0.5"
          value={Math.min(value, 200)}
          onChange={(e) => {
            const v = Number.parseFloat(e.target.value);
            onChange(Number.isFinite(v) ? v : 0);
          }}
          aria-label={`${label} slider`}
        />
      </div>
    </div>
  );
}
