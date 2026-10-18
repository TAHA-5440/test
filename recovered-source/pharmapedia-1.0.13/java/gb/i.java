// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class i extends gb.q {
    public static final synthetic java.util.concurrent.atomic.AtomicIntegerFieldUpdater c;
    private volatile synthetic int _resumed$volatile;

    static i()
    {
        gb.i.c = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(gb.i, "_resumed$volatile");
        return;
    }

    public i(gb.h p3, Throwable p4, boolean p5)
    {
        if (p4 == null) {
            StringBuilder v0_1 = new StringBuilder("Continuation ");
            v0_1.append(p3);
            v0_1.append(" was cancelled normally");
            p4 = new java.util.concurrent.CancellationException(v0_1.toString());
        }
        super(p5, p4);
        super._resumed$volatile = 0;
        return;
    }
}
