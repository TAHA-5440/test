// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public class h extends gb.c0 implements gb.f, ma.b, gb.n1 {
    public static final synthetic java.util.concurrent.atomic.AtomicIntegerFieldUpdater l;
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater m;
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater n;
    private volatile synthetic int _decisionAndIndex$volatile;
    private volatile synthetic Object _parentHandle$volatile;
    private volatile synthetic Object _state$volatile;
    public final ka.c j;
    public final ka.g k;

    static h()
    {
        gb.h.l = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(gb.h, "_decisionAndIndex$volatile");
        gb.h.m = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(gb.h, Object, "_state$volatile");
        gb.h.n = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(gb.h, Object, "_parentHandle$volatile");
        return;
    }

    public h(int p1, ka.c p2)
    {
        super(p1);
        super.j = p2;
        super.k = p2.getContext();
        super._decisionAndIndex$volatile = 536870911;
        super._state$volatile = gb.b.a;
        return;
    }

    public static Object C(gb.e1 p6, Object p7, int p8, ua.q p9)
    {
        if (!(p7 instanceof gb.q)) {
            if ((p8 != 1) && (p8 != 2)) {
                return p7;
            } else {
                if ((p9 != null) || ((p6 instanceof gb.e))) {
                    int v6_1;
                    if (!(p6 instanceof gb.e)) {
                        v6_1 = 0;
                    } else {
                        v6_1 = ((gb.e) p6);
                    }
                    return new gb.p(p7, v6_1, p9, 0, 16);
                } else {
                    return p7;
                }
            }
        } else {
            return p7;
        }
    }

    public static void x(gb.e1 p3, Object p4)
    {
        StringBuilder v1_1 = new StringBuilder("It\'s prohibited to register multiple handlers, tried to register ");
        v1_1.append(p3);
        v1_1.append(", already has ");
        v1_1.append(p4);
        throw new IllegalStateException(v1_1.toString().toString());
    }

    public final void A(Object p5, int p6, ua.q p7)
    {
        do {
            int v0_0 = gb.h.m;
            gb.i v1_0 = v0_0.get(this);
            if (!(v1_0 instanceof gb.e1)) {
                if ((v1_0 instanceof gb.i)) {
                    gb.i v1_1 = ((gb.i) v1_0);
                    if (gb.i.c.compareAndSet(v1_1, 0, 1)) {
                        if (p7 != null) {
                            this.m(p7, v1_1.a, p5);
                        }
                        return;
                    }
                }
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(p5, "Already resumed, but proposed with update ");
                return;
            } else {
                int v2_3 = gb.h.C(((gb.e1) v1_0), p5, p6, p7);
                while (!v0_0.compareAndSet(this, v1_0, v2_3)) {
                }
                if (!this.w()) {
                    this.o();
                }
                this.p(p6);
                return;
            }
        } while(v0_0.get(this) == v1_0);
    }

    public final void B(gb.s p4)
    {
        ga.p v0_2;
        ga.p v0_0 = this.j;
        if (!(v0_0 instanceof lb.e)) {
            v0_2 = 0;
        } else {
            v0_2 = ((lb.e) v0_0);
        }
        ga.p v0_3;
        if (v0_2 == null) {
            v0_3 = 0;
        } else {
            v0_3 = v0_2.j;
        }
        int v4_1;
        if (v0_3 != p4) {
            v4_1 = this.i;
        } else {
            v4_1 = 4;
        }
        this.A(ga.p.a, v4_1, 0);
        return;
    }

    public final void a(Object p2, ua.q p3)
    {
        this.A(p2, this.i, p3);
        return;
    }

    public final void b(lb.p p5, int p6)
    {
        do {
            boolean v0_0 = gb.h.l;
            int v1 = v0_0.get(this);
            if ((v1 & 536870911) != 536870911) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("invokeOnCancellation should be called at most once");
                return;
            } else {
            }
        } while(!v0_0.compareAndSet(this, v1, (((v1 >> 29) << 29) + p6)));
        this.v(p5);
        return;
    }

    public final void c(java.util.concurrent.CancellationException p8)
    {
        while(true) {
            ua.q v0_0 = gb.h.m;
            Object v2 = v0_0.get(this);
            if ((v2 instanceof gb.e1)) {
                break;
            }
            if (!(v2 instanceof gb.q)) {
                String v5;
                if (!(v2 instanceof gb.p)) {
                    v5 = p8;
                    Object v1_2 = new gb.p(v2, 0, 0, p8, 14);
                    while (!v0_0.compareAndSet(this, v2, v1_2)) {
                        if (v0_0.get(this) != v2) {
                        }
                    }
                    return;
                } else {
                    Object v1_4 = ((gb.p) v2);
                    if (v1_4.e != null) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Must be called at most once");
                        return;
                    } else {
                        gb.p v3_3 = gb.p.a(v1_4, 0, p8, 15);
                        while (!v0_0.compareAndSet(this, v2, v3_3)) {
                            if (v0_0.get(this) != v2) {
                                v5 = p8;
                            }
                        }
                        ua.q v0_1 = v1_4.b;
                        if (v0_1 != null) {
                            this.l(v0_1, p8);
                        }
                        ua.q v0_2 = v1_4.c;
                        if (v0_2 == null) {
                            return;
                        } else {
                            this.m(v0_2, p8, v1_4.a);
                            return;
                        }
                    }
                }
                p8 = v5;
            }
            return;
        }
        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Not completed");
        return;
    }

    public final ka.c d()
    {
        return this.j;
    }

    public final boolean e(Throwable p7)
    {
        do {
            boolean v0_0 = gb.h.m;
            lb.p v1_0 = v0_0.get(this);
            Object v3_0 = 0;
            if ((v1_0 instanceof gb.e1)) {
                if (((v1_0 instanceof gb.e)) || ((v1_0 instanceof lb.p))) {
                    v3_0 = 1;
                }
                boolean v2_0 = new gb.i(this, p7, v3_0);
                while (!v0_0.compareAndSet(this, v1_0, v2_0)) {
                }
                boolean v0_2 = ((gb.e1) v1_0);
                if (!(v0_2 instanceof gb.e)) {
                    if ((v0_2 instanceof lb.p)) {
                        this.n(((lb.p) v1_0), p7);
                    }
                } else {
                    this.l(((gb.e) v1_0), p7);
                }
                if (!this.w()) {
                    this.o();
                }
                this.p(this.i);
                return 1;
            } else {
                return 0;
            }
        } while(v0_0.get(this) == v1_0);
    }

    public final com.google.gson.internal.b f(Object p6, ua.q p7)
    {
        do {
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater v1 = gb.h.m;
            Object v2 = v1.get(this);
            if (!(v2 instanceof gb.e1)) {
                return 0;
            } else {
                Object v3_0 = gb.h.C(((gb.e1) v2), p6, this.i, p7);
                while (!v1.compareAndSet(this, v2, v3_0)) {
                }
                if (!this.w()) {
                    this.o();
                }
                return gb.w.a;
            }
        } while(v1.get(this) == v2);
    }

    public final Throwable g(Object p1)
    {
        int v1_1 = super.g(p1);
        if (v1_1 == 0) {
            return 0;
        } else {
            return v1_1;
        }
    }

    public final ma.b getCallerFrame()
    {
        int v0_0 = this.j;
        if (!(v0_0 instanceof ma.b)) {
            return 0;
        } else {
            return ((ma.b) v0_0);
        }
    }

    public final ka.g getContext()
    {
        return this.k;
    }

    public final Object h(Object p2)
    {
        if ((p2 instanceof gb.p)) {
            p2 = ((gb.p) p2).a;
        }
        return p2;
    }

    public final void j(Object p1)
    {
        this.p(this.i);
        return;
    }

    public final Object k()
    {
        return gb.h.m.get(this);
    }

    public final void l(gb.e p3, Throwable p4)
    {
        try {
            switch (p3.a) {
                case 0:
                    ((java.util.concurrent.ScheduledFuture) p3.b).cancel(0);
                    break;
                case 1:
                    ((ua.l) p3.b).invoke(p4);
                    break;
                default:
                    ((gb.g0) p3.b).b();
            }
        } catch (ua.l v3_2) {
            String v0_2 = new StringBuilder("Exception in invokeOnCancellation handler for ");
            v0_2.append(this);
            gb.w.n(new kotlinx.coroutines.CompletionHandlerException(v0_2.toString(), v3_2), this.k);
            return;
        }
        return;
    }

    public final void m(ua.q p3, Throwable p4, Object p5)
    {
        ka.g v0 = this.k;
        try {
            p3.invoke(p4, p5, v0);
            return;
        } catch (Throwable v3_1) {
            String v5_3 = new StringBuilder("Exception in resume onCancellation handler for ");
            v5_3.append(this);
            gb.w.n(new kotlinx.coroutines.CompletionHandlerException(v5_3.toString(), v3_1), v0);
            return;
        }
    }

    public final void n(lb.p p4, Throwable p5)
    {
        p5 = this.k;
        kotlinx.coroutines.CompletionHandlerException v0_4 = (gb.h.l.get(this) & 536870911);
        if (v0_4 == 536870911) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("The index for Segment.onCancellation(..) is broken");
            return;
        } else {
            try {
                p4.g(v0_4, p5);
                return;
            } catch (Throwable v4_1) {
                String v1_1 = new StringBuilder("Exception in invokeOnCancellation handler for ");
                v1_1.append(this);
                gb.w.n(new kotlinx.coroutines.CompletionHandlerException(v1_1.toString(), v4_1), p5);
                return;
            }
        }
    }

    public final void o()
    {
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater v0 = gb.h.n;
        gb.d1 v1_1 = ((gb.g0) v0.get(this));
        if (v1_1 != null) {
            v1_1.b();
            v0.set(this, gb.d1.g);
            return;
        } else {
            return;
        }
    }

    public final void p(int p7)
    {
        do {
            boolean v0_0 = gb.h.l;
            Throwable v1_1 = v0_0.get(this);
            boolean v2_1 = (v1_1 >> 29);
            if (!v2_1) {
            } else {
                if (v2_1 != 1) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Already resumed");
                    return;
                } else {
                    Throwable v1_2;
                    boolean v2_0 = 0;
                    if (p7 != 4) {
                        v1_2 = 0;
                    } else {
                        v1_2 = 1;
                    }
                    ka.c v3_0 = this.j;
                    if ((v1_2 == null) && ((v3_0 instanceof lb.e))) {
                        if ((p7 != 1) && (p7 != 2)) {
                            gb.j0 v7_2 = 0;
                        } else {
                            v7_2 = 1;
                        }
                        int v5 = this.i;
                        if ((v5 == 1) || (v5 == 2)) {
                            v2_0 = 1;
                        }
                        if (v7_2 == v2_0) {
                            gb.j0 v7_4 = ((lb.e) v3_0);
                            Throwable v1_3 = v7_4.j;
                            gb.j0 v7_6 = v7_4.k.getContext();
                            if (!v1_3.f0(v7_6)) {
                                gb.j0 v7_7 = gb.g1.a();
                                if (v7_7.i < 4294967296) {
                                    v7_7.j0(1);
                                    try {
                                        gb.w.s(this, v3_0, 1);
                                    } catch (Throwable v1_6) {
                                        try {
                                            this.i(v1_6);
                                        } catch (Throwable v1_7) {
                                            v7_7.h0(1);
                                            throw v1_7;
                                        }
                                        v7_7.h0(1);
                                        return;
                                    }
                                    while (v7_7.l0()) {
                                    }
                                } else {
                                    v7_7.i0(this);
                                    return;
                                }
                            } else {
                                v1_3.d0(v7_6, this);
                                return;
                            }
                        }
                    }
                    gb.w.s(this, v3_0, v1_2);
                    return;
                }
            }
            return;
        } while(!v0_0.compareAndSet(this, v1_1, (1073741824 + (536870911 & v1_1))));
    }

    public Throwable q(gb.a1 p1)
    {
        return p1.u();
    }

    public final Object r()
    {
        java.util.concurrent.CancellationException v0_0 = this.w();
        do {
            gb.a1 v1_4 = gb.h.l;
            boolean v2_1 = v1_4.get(this);
            int v3_1 = (v2_1 >> 29);
            if (v3_1 == 0) {
            } else {
                if (v3_1 != 2) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Already suspended");
                    return 0;
                } else {
                    if (v0_0 != null) {
                        this.z();
                    }
                    java.util.concurrent.CancellationException v0_5 = gb.h.m.get(this);
                    if ((v0_5 instanceof gb.q)) {
                        throw ((gb.q) v0_5).a;
                    } else {
                        boolean v2_2 = this.i;
                        if ((v2_2 == 1) || (v2_2 == 2)) {
                            gb.a1 v1_8 = ((gb.u0) this.k.Z(gb.t.h));
                            if ((v1_8 != null) && (!v1_8.d())) {
                                java.util.concurrent.CancellationException v0_8 = ((gb.a1) v1_8).u();
                                this.c(v0_8);
                                throw v0_8;
                            }
                        }
                        return this.h(v0_5);
                    }
                }
            }
        } while(!v1_4.compareAndSet(this, v2_1, (536870912 + (536870911 & v2_1))));
        if (((gb.g0) gb.h.n.get(this)) == null) {
            this.t();
        }
        if (v0_0 != null) {
            this.z();
        }
        return kotlin.coroutines.intrinsics.CoroutineSingletons.g;
    }

    public final void resumeWith(Object p3)
    {
        int v0_0 = kotlin.Result.a(p3);
        if (v0_0 != 0) {
            p3 = new gb.q(0, v0_0);
        }
        this.A(p3, this.i, 0);
        return;
    }

    public final void s()
    {
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater v0_0 = this.t();
        if ((v0_0 != null) && (!(gb.h.m.get(this) instanceof gb.e1))) {
            v0_0.b();
            gb.h.n.set(this, gb.d1.g);
        }
        return;
    }

    public final gb.g0 t()
    {
        gb.g0 v0_3 = ((gb.u0) this.k.Z(gb.t.h));
        if (v0_3 != null) {
            gb.g0 v0_1 = kotlinx.coroutines.a.b(v0_3, 1, new gb.j(this, 0));
            do {
                Object v2_0 = gb.h.n;
            } while((!v2_0.compareAndSet(this, 0, v0_1)) && (v2_0.get(this) == null));
            return v0_1;
        } else {
            return 0;
        }
    }

    public final String toString()
    {
        String v1_4;
        String v0_1 = new StringBuilder();
        v0_1.append(this.y());
        v0_1.append(40);
        v0_1.append(gb.w.v(this.j));
        v0_1.append("){");
        String v1_2 = gb.h.m.get(this);
        if (!(v1_2 instanceof gb.e1)) {
            if (!(v1_2 instanceof gb.i)) {
                v1_4 = "Completed";
            } else {
                v1_4 = "Cancelled";
            }
        } else {
            v1_4 = "Active";
        }
        v0_1.append(v1_4);
        v0_1.append("}@");
        v0_1.append(gb.w.l(this));
        return v0_1.toString();
    }

    public final void u(ua.l p3)
    {
        this.v(new gb.e(p3, 1));
        return;
    }

    public final void v(gb.e1 p8)
    {
        do {
            Throwable v0_0 = gb.h.m;
            Object v2 = v0_0.get(this);
            if (!(v2 instanceof gb.b)) {
                if (((v2 instanceof gb.e)) || ((v2 instanceof lb.p))) {
                    gb.h.x(p8, v2);
                    throw 0;
                } else {
                    if (!(v2 instanceof gb.q)) {
                        if (!(v2 instanceof gb.p)) {
                            if (!(p8 instanceof lb.p)) {
                                gb.p v1_4 = new gb.p(v2, ((gb.e) p8), 0, 0, 28);
                                while (!v0_0.compareAndSet(this, v2, v1_4)) {
                                    if (v0_0.get(this) != v2) {
                                    }
                                }
                            }
                        } else {
                            gb.p v1_7 = ((gb.p) v2);
                            if (v1_7.b != null) {
                                gb.h.x(p8, v2);
                                throw 0;
                            } else {
                                if (!(p8 instanceof lb.p)) {
                                    int v5_1 = v1_7.e;
                                    if (v5_1 == 0) {
                                        gb.p v1_8 = gb.p.a(v1_7, ((gb.e) p8), 0, 29);
                                        while (!v0_0.compareAndSet(this, v2, v1_8)) {
                                            if (v0_0.get(this) != v2) {
                                            }
                                        }
                                    } else {
                                        this.l(((gb.e) p8), v5_1);
                                        return;
                                    }
                                }
                            }
                        }
                    } else {
                        Throwable v0_2 = ((gb.q) v2);
                        if (!gb.q.b.compareAndSet(v0_2, 0, 1)) {
                            gb.h.x(p8, v2);
                            throw 0;
                        } else {
                            if ((v2 instanceof gb.i)) {
                                Throwable v0_3 = v0_2.a;
                                if (!(p8 instanceof gb.e)) {
                                    this.n(((lb.p) p8), v0_3);
                                    return;
                                } else {
                                    this.l(((gb.e) p8), v0_3);
                                    return;
                                }
                            }
                        }
                    }
                }
            } else {
                while (!v0_0.compareAndSet(this, v2, p8)) {
                }
            }
            return;
        } while(v0_0.get(this) == v2);
    }

    public final boolean w()
    {
        if ((this.i != 2) || (lb.e.n.get(((lb.e) this.j)) == null)) {
            return 0;
        } else {
            return 1;
        }
    }

    public String y()
    {
        return "CancellableContinuation";
    }

    public final void z()
    {
        String v0_3;
        String v0_0 = this.j;
        Throwable v2_0 = 0;
        if (!(v0_0 instanceof lb.e)) {
            v0_3 = 0;
        } else {
            v0_3 = ((lb.e) v0_0);
        }
        if (v0_3 != null) {
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater v1_1 = lb.e.n;
            do {
                Object v3_2 = v1_1.get(v0_3);
                Object v4_0 = lb.a.c;
                if (v3_2 != v4_0) {
                    if (!(v3_2 instanceof Throwable)) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(v3_2, "Inconsistent state ");
                        return;
                    }
                    while (!v1_1.compareAndSet(v0_3, v3_2, 0)) {
                        if (v1_1.get(v0_3) != v3_2) {
                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Failed requirement.");
                            return;
                        }
                    }
                    v2_0 = ((Throwable) v3_2);
                } else {
                    while (!v1_1.compareAndSet(v0_3, v4_0, this)) {
                    }
                }
                if (v2_0 != null) {
                    this.o();
                    this.e(v2_0);
                    return;
                }
            } while(v1_1.get(v0_3) == v4_0);
        }
        return;
    }
}
