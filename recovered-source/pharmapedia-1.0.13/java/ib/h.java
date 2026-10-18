// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ib;
public final class h extends lb.p {
    public final kotlinx.coroutines.channels.a e;
    public final synthetic java.util.concurrent.atomic.AtomicReferenceArray f;

    public h(long p1, ib.h p3, kotlinx.coroutines.channels.a p4, int p5)
    {
        super(p1, p3, p5);
        super.e = p4;
        super.f = new java.util.concurrent.atomic.AtomicReferenceArray((ib.b.b * 2));
        return;
    }

    public final int f()
    {
        return ib.b.b;
    }

    public final void g(int p5, ka.g p6)
    {
        int v0;
        int v6_0 = ib.b.b;
        if (p5 < v6_0) {
            v0 = 0;
        } else {
            v0 = 1;
        }
        if (v0 != 0) {
            p5 -= v6_0;
        }
        this.f.get((p5 * 2));
        do {
            int v6_1 = this.k(p5);
            kotlinx.coroutines.channels.a v2 = this.e;
            if ((!(v6_1 instanceof gb.n1)) && (!(v6_1 instanceof ib.n))) {
                if ((v6_1 != ib.b.j) && (v6_1 != ib.b.k)) {
                } else {
                    this.m(p5, 0);
                    if (v0 != 0) {
                        v2.getClass();
                        return;
                    }
                }
            } else {
                com.google.gson.internal.b v1_6;
                if (v0 == 0) {
                    v1_6 = ib.b.k;
                } else {
                    v1_6 = ib.b.j;
                }
                if (this.j(p5, v6_1, v1_6)) {
                    this.m(p5, 0);
                    this.l(p5, (v0 ^ 1));
                    if (v0 != 0) {
                        v2.getClass();
                    }
                }
            }
            return;
        } while((v6_1 != ib.b.g) && (v6_1 != ib.b.f));
        if ((v6_1 != ib.b.i) && ((v6_1 != ib.b.d) && (v6_1 != ib.b.l))) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(v6_1, "unexpected state: ");
            return;
        }
        return;
    }

    public final boolean j(int p4, Object p5, Object p6)
    {
        int v4_3 = ((p4 * 2) + 1);
        do {
            Object v1_0 = this.f;
            if (!v1_0.compareAndSet(v4_3, p5, p6)) {
            } else {
                return 1;
            }
        } while(v1_0.get(v4_3) == p5);
        return 0;
    }

    public final Object k(int p2)
    {
        return this.f.get(((p2 * 2) + 1));
    }

    public final void l(int p5, boolean p6)
    {
        if (p6 != null) {
            kotlinx.coroutines.channels.a v6_1 = this.e;
            v6_1.getClass();
            v6_1.D(((this.c * ((long) ib.b.b)) + ((long) p5)));
        }
        this.h();
        return;
    }

    public final void m(int p2, Object p3)
    {
        this.f.set((p2 * 2), p3);
        return;
    }

    public final void n(int p2, Object p3)
    {
        this.f.set(((p2 * 2) + 1), p3);
        return;
    }
}
