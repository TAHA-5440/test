import * as Dialog from '@radix-ui/react-dialog';
import { X } from 'lucide-react';
import type { ReactNode } from 'react';

export function Modal({ open, onClose, title, description, children, wide = false, drawer = false }: {
  open: boolean; onClose: () => void; title: string; description?: string; children: ReactNode; wide?: boolean; drawer?: boolean;
}) {
  return <Dialog.Root open={open} onOpenChange={value => { if (!value) onClose(); }}>
    <Dialog.Portal><Dialog.Overlay className="modal-overlay" />
      <Dialog.Content className={drawer ? 'drawer' : `modal${wide ? ' modal-wide' : ''}`} aria-describedby={description ? undefined : ''}>
        <div className="dialog-heading"><div><Dialog.Title>{title}</Dialog.Title>{description && <Dialog.Description>{description}</Dialog.Description>}</div>
          <Dialog.Close className="icon-button" aria-label="Close dialog"><X size={19} /></Dialog.Close>
        </div>
        {children}
      </Dialog.Content>
    </Dialog.Portal>
  </Dialog.Root>;
}
