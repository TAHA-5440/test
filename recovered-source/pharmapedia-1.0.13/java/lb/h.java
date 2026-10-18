// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lb;
public class h {
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater a;
    private volatile synthetic Object _cur$volatile;

    static h()
    {
        lb.h.a = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(lb.h, Object, "_cur$volatile");
        return;
    }

    public h()
    {
        this._cur$volatile = new lb.j(8, 0);
        return;
    }

    public final boolean a(Runnable p5)
    {
        do {
            int v0_0 = lb.h.a;
            lb.j v1_1 = ((lb.j) v0_0.get(this));
            lb.j v2_1 = v1_1.a(p5);
            if (v2_1 == null) {
                return 1;
            } else {
                if (v2_1 == 1) {
                    lb.j v2_0 = v1_1.c();
                    while (!v0_0.compareAndSet(this, v1_1, v2_0)) {
                    }
                } else {
                    if (v2_1 != 2) {
                        break;
                    }
                    return 0;
                }
            }
        } while(v0_0.get(this) == v1_1);
    }

    public final void b()
    {
        do {
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater v0 = lb.h.a;
            lb.j v1_1 = ((lb.j) v0.get(this));
            if (!v1_1.b()) {
                lb.j v2_1 = v1_1.c();
            } else {
                return;
            }
        } while(!v0.compareAndSet(this, v1_1, v2_1));
        if (v0.get(this) != v1_1) {
        }
    }

    public final int c()
    {
        int v0_7 = ((lb.j) lb.h.a.get(this));
        v0_7.getClass();
        int v0_8 = lb.j.f.get(v0_7);
        return ((((int) ((v0_8 & 1152921503533105152) >> 30)) - ((int) (1073741823 & v0_8))) & 1073741823);
    }

    public final Object d()
    {
        do {
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater v0 = lb.h.a;
            lb.j v1_1 = ((lb.j) v0.get(this));
            lb.j v2_0 = v1_1.d();
            if (v2_0 == lb.j.g) {
                lb.j v2_1 = v1_1.c();
                while (!v0.compareAndSet(this, v1_1, v2_1)) {
                }
            } else {
                return v2_0;
            }
        } while(v0.get(this) == v1_1);
    }
}
