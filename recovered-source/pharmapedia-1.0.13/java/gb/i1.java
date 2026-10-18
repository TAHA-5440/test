// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class i1 extends gb.w0 {
    public static final synthetic java.util.concurrent.atomic.AtomicIntegerFieldUpdater m;
    private volatile synthetic int _state$volatile;
    public final Thread k;
    public gb.g0 l;

    static i1()
    {
        gb.i1.m = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(gb.i1, "_state$volatile");
        return;
    }

    public i1()
    {
        this.k = Thread.currentThread();
        return;
    }

    public static void n(int p3)
    {
        StringBuilder v1_1 = new StringBuilder("Illegal state ");
        v1_1.append(p3);
        throw new IllegalStateException(v1_1.toString().toString());
    }

    public final boolean k()
    {
        return 1;
    }

    public final void l(Throwable p4)
    {
        do {
            int v4_0 = gb.i1.m;
            Thread v0_0 = v4_0.get(this);
            if (v0_0 == null) {
            } else {
                if ((v0_0 != 1) && ((v0_0 != 2) && (v0_0 != 3))) {
                    gb.i1.n(v0_0);
                    throw 0;
                } else {
                    return;
                }
            }
        } while(!v4_0.compareAndSet(this, v0_0, 2));
        this.k.interrupt();
        v4_0.set(this, 3);
        return;
    }

    public final void m()
    {
        do {
            int v0_0 = gb.i1.m;
            int v1 = v0_0.get(this);
            if (v1 == 0) {
            } else {
                if (v1 != 2) {
                    if (v1 != 3) {
                        gb.i1.n(v1);
                        throw 0;
                    } else {
                        Thread.interrupted();
                        return;
                    }
                }
            }
        } while(!v0_0.compareAndSet(this, v1, 1));
        int v0_5 = this.l;
        if (v0_5 != 0) {
            v0_5.b();
        }
        return;
    }
}
