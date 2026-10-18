// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ib;
public final class k extends gb.a implements ib.l, ib.d {
    public final kotlinx.coroutines.channels.a j;

    public k(ka.g p2, kotlinx.coroutines.channels.a p3)
    {
        super(p2, 1);
        super.j = p3;
        return;
    }

    public final void X(boolean p3, Throwable p4)
    {
        if ((!this.j.i(0, p4)) && (p3 == null)) {
            gb.w.n(p4, this.i);
        }
        return;
    }

    public final void Y(Object p3)
    {
        this.j.i(0, 0);
        return;
    }

    public final Object b(Object p2, ka.c p3)
    {
        return this.j.b(p2, p3);
    }

    public final void b0(ib.j p6)
    {
        Throwable v0_0 = this.j;
        v0_0.getClass();
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater v1 = kotlinx.coroutines.channels.a.p;
        while (!v1.compareAndSet(v0_0, 0, p6)) {
            if (v1.get(v0_0) != null) {
            }
            do {
                Object v2_0 = v1.get(v0_0);
                com.google.gson.internal.b v3 = ib.b.q;
                if (v2_0 != v3) {
                    if (v2_0 != ib.b.r) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(v2_0, "Another handler is already registered: ");
                        return;
                    } else {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Another handler was already registered and successfully invoked");
                        return;
                    }
                }
                while (!v1.compareAndSet(v0_0, v3, ib.b.r)) {
                }
                p6.invoke(v0_0.n());
                return;
            } while(v1.get(v0_0) == v3);
        }
        return;
    }

    public final Object c(ka.c p2)
    {
        return this.j.c(p2);
    }

    public final Object g(Object p2)
    {
        return this.j.g(p2);
    }

    public final void h(java.util.concurrent.CancellationException p3)
    {
        String v0_2 = gb.a1.g.get(this);
        if ((!(v0_2 instanceof gb.q)) && ((!(v0_2 instanceof gb.z0)) || (!((gb.z0) v0_2).c()))) {
            if (p3 == null) {
                p3 = new kotlinx.coroutines.JobCancellationException(this.p(), 0, this);
            }
            this.n(p3);
        }
        return;
    }

    public final void n(java.util.concurrent.CancellationException p3)
    {
        this.j.i(1, p3);
        this.m(p3);
        return;
    }
}
