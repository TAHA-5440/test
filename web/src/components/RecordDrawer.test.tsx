import { render, screen } from '@testing-library/react';
import { describe, expect, it } from 'vitest';
import { SourceText } from './RecordDrawer';

describe('untrusted source clinical text', () => {
  it('keeps simple formatting without executing scripts or loading remote images', () => {
    const { container } = render(<SourceText text={'<p>Original <strong>source</strong> text.</p><script>window.injected=true</script><img src="https://invalid.example/not-loaded" onerror="alert(1)"><iframe src="https://invalid.example"></iframe>'} />);
    expect(screen.getByText('source')).toHaveProperty('tagName', 'STRONG');
    expect(container.querySelectorAll('script,img,iframe')).toHaveLength(0);
    expect(container.textContent).toContain('Original source text.');
  });
  it('preserves plain-text inequalities and literal unit markers', () => {
    const text = 'Original source threshold: <5 kg; literal <unit> marker.';
    const { container } = render(<SourceText text={text} />);
    expect(container.textContent).toBe(text);
  });
  it('does not manufacture missing clinical information', () => {
    render(<SourceText text="" />);
    expect(screen.getByText('No information supplied in this record.')).toBeInTheDocument();
  });
});
