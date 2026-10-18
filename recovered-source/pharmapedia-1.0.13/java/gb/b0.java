// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class b0 extends lb.o {
    public static final synthetic java.util.concurrent.atomic.AtomicIntegerFieldUpdater k;
    private volatile synthetic int _decision$volatile;

    static b0()
    {
        gb.b0.k = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(gb.b0, "_decision$volatile");
        return;
    }

    public final void k(Object p1)
    {
        this.l(p1);
        return;
    }

    public final void l(Object p4)
    {
        do {
            ka.c v0_0 = gb.b0.k;
            int v1_0 = v0_0.get(this);
            if (v1_0 == 0) {
            } else {
                if (v1_0 != 1) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Already resumed");
                    return;
                } else {
                    lb.a.h(gb.w.r(p4), a.a.n(this.j));
                    return;
                }
            }
        } while(!v0_0.compareAndSet(this, 0, 2));
        return;
    }
}
