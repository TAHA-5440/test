// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public class a1 implements gb.u0 {
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater g;
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater h;
    private volatile synthetic Object _parentHandle$volatile;
    private volatile synthetic Object _state$volatile;

    static a1()
    {
        gb.a1.g = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(gb.a1, Object, "_state$volatile");
        gb.a1.h = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(gb.a1, Object, "_parentHandle$volatile");
        return;
    }

    public a1(boolean p1)
    {
        gb.i0 v1_1;
        if (p1 == null) {
            v1_1 = gb.w.i;
        } else {
            v1_1 = gb.w.j;
        }
        this._state$volatile = v1_1;
        return;
    }

    public static gb.l N(kotlinx.coroutines.internal.a p2)
    {
        while (p2.i()) {
            boolean v0_2 = kotlinx.coroutines.internal.a.h;
            boolean v1_0 = p2.f();
            if (v1_0) {
                p2 = v1_0;
            } else {
                p2 = ((kotlinx.coroutines.internal.a) v0_2.get(p2));
                while (p2.i()) {
                    p2 = ((kotlinx.coroutines.internal.a) v0_2.get(p2));
                }
            }
        }
        do {
            p2 = p2.h();
            if (!p2.i()) {
                if (!(p2 instanceof gb.l)) {
                } else {
                    return ((gb.l) p2);
                }
            }
        } while(!(p2 instanceof gb.c1));
        return 0;
    }

    public static String U(Object p2)
    {
        if (!(p2 instanceof gb.z0)) {
            if (!(p2 instanceof gb.s0)) {
                if (!(p2 instanceof gb.q)) {
                    return "Completed";
                } else {
                    return "Cancelled";
                }
            } else {
                if (!((gb.s0) p2).d()) {
                    return "New";
                } else {
                    return "Active";
                }
            }
        } else {
            if (!((gb.z0) p2).c()) {
                if (gb.z0.h.get(((gb.z0) p2)) == 0) {
                    return "Active";
                } else {
                    return "Completing";
                }
            } else {
                return "Cancelling";
            }
        }
    }

    public boolean A(Throwable p1)
    {
        return 0;
    }

    public final Object B(Object p1, ua.p p2)
    {
        return p2.invoke(p1, this);
    }

    public void C(kotlinx.coroutines.CompletionHandlerException p1)
    {
        throw p1;
    }

    public final void D(gb.u0 p8)
    {
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater v0 = gb.a1.h;
        gb.d1 v1 = gb.d1.g;
        if (p8 == null) {
            v0.set(this, v1);
            return;
        }
        do {
            boolean v2_1 = gb.a1.g;
            gb.d1 v3_3 = ((gb.a1) p8).T(v2_1.get(((gb.a1) p8)));
        } while((v3_3 == null) || (v3_3 == 1));
        gb.d1 v3_1 = new gb.l(this);
        v3_1.j = ((gb.a1) p8);
        do {
            boolean v4_1 = v2_1.get(((gb.a1) p8));
            if (!(v4_1 instanceof gb.i0)) {
                Throwable v6_0 = 0;
                if (!(v4_1 instanceof gb.s0)) {
                    Throwable v8_2;
                    Throwable v8_1 = v2_1.get(((gb.a1) p8));
                    if (!(v8_1 instanceof gb.q)) {
                        v8_2 = 0;
                    } else {
                        v8_2 = ((gb.q) v8_1);
                    }
                    if (v8_2 != null) {
                        v6_0 = v8_2.a;
                    }
                    v3_1.l(v6_0);
                } else {
                    Object v5_4 = ((gb.s0) v4_1).e();
                    if (v5_4 != null) {
                        if (!v5_4.c(v3_1, 7)) {
                            boolean v4_5 = v5_4.c(v3_1, 3);
                            Throwable v8_4 = v2_1.get(((gb.a1) p8));
                            if (!(v8_4 instanceof gb.z0)) {
                                Throwable v8_5;
                                if (!(v8_4 instanceof gb.q)) {
                                    v8_5 = 0;
                                } else {
                                    v8_5 = ((gb.q) v8_4);
                                }
                                if (v8_5 != null) {
                                    v6_0 = v8_5.a;
                                }
                            } else {
                                v6_0 = ((gb.z0) v8_4).b();
                            }
                            v3_1.l(v6_0);
                            if (v4_5) {
                                v0.set(this, v3_1);
                                if (this.F()) {
                                    v3_1.b();
                                    v0.set(this, v1);
                                }
                                return;
                            }
                        }
                    } else {
                        ((gb.a1) p8).S(((gb.w0) v4_1));
                        break;
                    }
                }
                v3_1 = v1;
            } else {
                Object v5_6 = ((gb.i0) v4_1);
                if (!v5_6.g) {
                    ((gb.a1) p8).R(v5_6);
                    break;
                }
                while (!v2_1.compareAndSet(((gb.a1) p8), v4_1, v3_1)) {
                }
            }
        } while(v2_1.get(((gb.a1) p8)) == v4_1);
    }

    public final gb.g0 E(boolean p8, gb.w0 p9)
    {
        p9.j = this;
        do {
            boolean v0_0 = gb.a1.g;
            boolean v1_4 = v0_0.get(this);
            gb.d1 v3 = gb.d1.g;
            int v4 = 1;
            Throwable v5 = 0;
            if (!(v1_4 instanceof gb.i0)) {
                if (!(v1_4 instanceof gb.s0)) {
                    v4 = 0;
                    if (v4 == 0) {
                        if (p8 != 0) {
                            int v8_2;
                            int v8_1 = v0_0.get(this);
                            if (!(v8_1 instanceof gb.q)) {
                                v8_2 = 0;
                            } else {
                                v8_2 = ((gb.q) v8_1);
                            }
                            if (v8_2 != 0) {
                                v5 = v8_2.a;
                            }
                            p9.l(v5);
                        }
                    } else {
                        return p9;
                    }
                } else {
                    int v2_1 = ((gb.s0) v1_4);
                    gb.c1 v6_0 = v2_1.e();
                    if (v6_0 != null) {
                        boolean v1_1;
                        if (!p9.k()) {
                            v1_1 = v6_0.c(p9, 1);
                        } else {
                            int v2_2;
                            if (!(v2_1 instanceof gb.z0)) {
                                v2_2 = 0;
                            } else {
                                v2_2 = ((gb.z0) v2_1);
                            }
                            boolean v1_3;
                            if (v2_2 == 0) {
                                v1_3 = 0;
                            } else {
                                v1_3 = v2_2.b();
                            }
                            if (v1_3) {
                                if (p8 == 0) {
                                    return v3;
                                } else {
                                    p9.l(v1_3);
                                    return v3;
                                }
                            } else {
                                v1_1 = v6_0.c(p9, 5);
                            }
                        }
                        if (v1_1) {
                        }
                    } else {
                        this.S(((gb.w0) v1_4));
                    }
                }
            } else {
                int v2_5 = ((gb.i0) v1_4);
                if (!v2_5.g) {
                    this.R(v2_5);
                }
            }
            return v3;
        } while(!v0_0.compareAndSet(this, v1_4, p9));
        if (v0_0.get(this) != v1_4) {
        } else {
            while (!v0_0.compareAndSet(this, v1_4, p9)) {
            }
        }
        return v3;
    }

    public final boolean F()
    {
        return ((gb.a1.g.get(this) instanceof gb.s0) ^ 1);
    }

    public boolean G()
    {
        return (this instanceof gb.c);
    }

    public final Object H(kotlin.coroutines.jvm.internal.ContinuationImpl p5)
    {
        do {
            kotlin.coroutines.intrinsics.CoroutineSingletons v0_2 = gb.a1.g.get(this);
            ga.p v2 = ga.p.a;
            if ((v0_2 instanceof gb.s0)) {
            } else {
                kotlinx.coroutines.a.a(p5.getContext());
                return v2;
            }
        } while(this.T(v0_2) < 0);
        kotlin.coroutines.intrinsics.CoroutineSingletons v0_1 = new gb.h(1, a.a.n(p5));
        v0_1.s();
        v0_1.v(new gb.e(kotlinx.coroutines.a.b(this, 1, new gb.j(v0_1, 1)), 2));
        ga.p v5_5 = v0_1.r();
        kotlin.coroutines.intrinsics.CoroutineSingletons v0_3 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        if (v5_5 != v0_3) {
            v5_5 = v2;
        }
        if (v5_5 != v0_3) {
            return v2;
        } else {
            return v5_5;
        }
    }

    public final boolean I(Object p4)
    {
        do {
            Object v0_2 = this.V(gb.a1.g.get(this), p4);
            if (v0_2 != gb.w.d) {
                if (v0_2 != gb.w.e) {
                } else {
                    return 1;
                }
            } else {
                return 0;
            }
        } while(v0_2 == gb.w.f);
        this.k(v0_2);
        return 1;
    }

    public final Object J(Object p5)
    {
        do {
            IllegalStateException v0_4 = this.V(gb.a1.g.get(this), p5);
            if (v0_4 != gb.w.d) {
            } else {
                int v5_1;
                com.google.gson.internal.b v1_1 = new StringBuilder("Job ");
                v1_1.append(this);
                v1_1.append(" is already complete or completing, but is being completed with ");
                v1_1.append(p5);
                com.google.gson.internal.b v1_2 = v1_1.toString();
                Throwable v3 = 0;
                if (!(p5 instanceof gb.q)) {
                    v5_1 = 0;
                } else {
                    v5_1 = ((gb.q) p5);
                }
                if (v5_1 != 0) {
                    v3 = v5_1.a;
                }
                throw new IllegalStateException(v1_2, v3);
            }
        } while(v0_4 == gb.w.f);
        return v0_4;
    }

    public String K()
    {
        return this.getClass().getSimpleName();
    }

    public final ka.g L(ka.g p1)
    {
        return com.bumptech.glide.i.r(this, p1);
    }

    public final void O(gb.c1 p6, Throwable p7)
    {
        p6.c(new lb.g(4), 4);
        kotlinx.coroutines.internal.a v0_4 = kotlinx.coroutines.internal.a.g.get(p6);
        v0_4.getClass();
        kotlinx.coroutines.internal.a v0_3 = ((kotlinx.coroutines.internal.a) v0_4);
        kotlinx.coroutines.CompletionHandlerException v1_2 = 0;
        while (!v0_3.equals(p6)) {
            if (((v0_3 instanceof gb.w0)) && (((gb.w0) v0_3).k())) {
                try {
                    ((gb.w0) v0_3).l(p7);
                } catch (Throwable v2_7) {
                    if (v1_2 == null) {
                        String v3_1 = new StringBuilder("Exception in completion handler ");
                        v3_1.append(v0_3);
                        v3_1.append(" for ");
                        v3_1.append(this);
                        v1_2 = new kotlinx.coroutines.CompletionHandlerException(v3_1.toString(), v2_7);
                    } else {
                        com.bumptech.glide.i.d(v1_2, v2_7);
                    }
                }
            }
            v0_3 = v0_3.h();
        }
        if (v1_2 != null) {
            this.C(v1_2);
        }
        this.o(p7);
        return;
    }

    public void P(Object p1)
    {
        return;
    }

    public void Q()
    {
        return;
    }

    public final void R(gb.i0 p4)
    {
        gb.r0 v0_1 = new gb.c1();
        if (!p4.g) {
            v0_1 = new gb.r0(v0_1);
        }
        do {
            Object v1_4 = gb.a1.g;
        } while((!v1_4.compareAndSet(this, p4, v0_1)) && (v1_4.get(this) == p4));
        return;
    }

    public final void S(gb.w0 p4)
    {
        Object v0_1 = new gb.c1();
        p4.getClass();
        kotlinx.coroutines.internal.a.h.set(v0_1, p4);
        boolean v1_2 = kotlinx.coroutines.internal.a.g;
        v1_2.set(v0_1, p4);
        while (v1_2.get(p4) == p4) {
            while (!v1_2.compareAndSet(p4, p4, v0_1)) {
                if (v1_2.get(p4) != p4) {
                }
                Object v2_2 = p4.h();
                do {
                    Object v0_2 = gb.a1.g;
                    if (!v0_2.compareAndSet(this, p4, v2_2)) {
                    } else {
                        return;
                    }
                } while(v0_2.get(this) == p4);
                return;
            }
            v0_1.g(p4);
            break;
        }
    }

    public final int T(Object p5)
    {
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater v2 = gb.a1.g;
        if (!(p5 instanceof gb.i0)) {
            if (!(p5 instanceof gb.r0)) {
                return 0;
            }
            while (!v2.compareAndSet(this, p5, ((gb.r0) p5).g)) {
                if (v2.get(this) != p5) {
                    return -1;
                }
            }
            this.Q();
            return 1;
        } else {
            if (((gb.i0) p5).g) {
                return 0;
            }
            while (!v2.compareAndSet(this, p5, gb.w.j)) {
                if (v2.get(this) != p5) {
                    return -1;
                }
            }
            this.Q();
            return 1;
        }
        return 0;
    }

    public final Object V(Object p7, Object p8)
    {
        if ((p7 instanceof gb.s0)) {
            if (((!(p7 instanceof gb.i0)) && (!(p7 instanceof gb.w0))) || (((p7 instanceof gb.l)) || ((p8 instanceof gb.q)))) {
                gb.s0 v0_1 = this.z(((gb.s0) p7));
                if (v0_1 != null) {
                    gb.z0 v1_1;
                    int v2_0 = 0;
                    if (!(((gb.s0) p7) instanceof gb.z0)) {
                        v1_1 = 0;
                    } else {
                        v1_1 = ((gb.z0) ((gb.s0) p7));
                    }
                    if (v1_1 == null) {
                        v1_1 = new gb.z0(v0_1, 0);
                    }
                    try {
                        Object v4_1;
                        Throwable v3_0 = gb.z0.h;
                    } catch (com.google.gson.internal.b v7_7) {
                        throw v7_7;
                    }
                    if (v3_0.get(v1_1) == 0) {
                        v4_1 = 0;
                    } else {
                        v4_1 = 1;
                    }
                    if (v4_1 == null) {
                        v3_0.set(v1_1, 1);
                        if (v1_1 != ((gb.s0) p7)) {
                            Throwable v3_1 = gb.a1.g;
                            while (!v3_1.compareAndSet(this, ((gb.s0) p7), v1_1)) {
                                if (v3_1.get(this) != ((gb.s0) p7)) {
                                    return gb.w.f;
                                }
                            }
                        }
                        Throwable v3_3;
                        com.google.gson.internal.b v7_6 = v1_1.c();
                        if (!(p8 instanceof gb.q)) {
                            v3_3 = 0;
                        } else {
                            v3_3 = ((gb.q) p8);
                        }
                        if (v3_3 != null) {
                            v1_1.a(v3_3.a);
                        }
                        Throwable v3_6 = v1_1.b();
                        if (v7_6 == null) {
                            v2_0 = v3_6;
                        }
                        if (v2_0 != 0) {
                            this.O(v0_1, v2_0);
                        }
                        com.google.gson.internal.b v7_8 = gb.a1.N(v0_1);
                        if ((v7_8 == null) || (!this.W(v1_1, v7_8, p8))) {
                            v0_1.c(new lb.g(2), 2);
                            com.google.gson.internal.b v7_12 = gb.a1.N(v0_1);
                            if ((v7_12 == null) || (!this.W(v1_1, v7_12, p8))) {
                                return this.t(v1_1, p8);
                            } else {
                                return gb.w.e;
                            }
                        } else {
                            return gb.w.e;
                        }
                    } else {
                        return gb.w.d;
                    }
                } else {
                    return gb.w.f;
                }
            } else {
                int v2_2;
                gb.z0 v1_4 = gb.a1.g;
                if (!(p8 instanceof gb.s0)) {
                    v2_2 = p8;
                } else {
                    v2_2 = new gb.t0(((gb.s0) p8));
                }
                while (!v1_4.compareAndSet(this, ((gb.s0) p7), v2_2)) {
                    if (v1_4.get(this) != ((gb.s0) p7)) {
                        return gb.w.f;
                    }
                }
                this.P(p8);
                this.r(((gb.s0) p7), p8);
                return p8;
            }
        } else {
            return gb.w.d;
        }
    }

    public final boolean W(gb.z0 p4, gb.l p5, Object p6)
    {
        while (kotlinx.coroutines.a.b(p5.k, 0, new gb.y0(this, p4, p5, p6)) == gb.d1.g) {
            p5 = gb.a1.N(p5);
            if (p5 == null) {
                return 0;
            }
        }
        return 1;
    }

    public final ka.e Z(ka.f p1)
    {
        return com.bumptech.glide.i.j(this, p1);
    }

    public boolean d()
    {
        int v0_2 = gb.a1.g.get(this);
        if ((!(v0_2 instanceof gb.s0)) || (!((gb.s0) v0_2).d())) {
            return 0;
        } else {
            return 1;
        }
    }

    public final ka.f getKey()
    {
        return gb.t.h;
    }

    public void h(java.util.concurrent.CancellationException p3)
    {
        if (p3 == null) {
            p3 = new kotlinx.coroutines.JobCancellationException(this.p(), 0, this);
        }
        this.n(p3);
        return;
    }

    public final ka.g i(ka.f p1)
    {
        return com.bumptech.glide.i.n(this, p1);
    }

    public void k(Object p1)
    {
        return;
    }

    public void l(Object p1)
    {
        this.k(p1);
        return;
    }

    public final boolean m(Object p10)
    {
        Object v0_0 = gb.w.d;
        if (!this.y()) {
            if (v0_0 == gb.w.d) {
                Object v0_1 = 0;
                Throwable v1_10 = 0;
                do {
                    com.google.gson.internal.b v10_2;
                    Object v4_2 = gb.a1.g;
                    Object v5_1 = v4_2.get(this);
                    if (!(v5_1 instanceof gb.z0)) {
                        if (!(v5_1 instanceof gb.s0)) {
                            v10_2 = gb.w.g;
                        } else {
                            if (v1_10 == null) {
                                v1_10 = this.s(p10);
                            }
                            com.google.gson.internal.b v6_3 = ((gb.s0) v5_1);
                            if (!v6_3.d()) {
                                Object v4_5 = this.V(v5_1, new gb.q(0, v1_10));
                                if (v4_5 == gb.w.d) {
                                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(v5_1, "Cannot happen in ");
                                    return 0;
                                } else {
                                    if (v4_5 == gb.w.f) {
                                        break;
                                    }
                                    v0_0 = v4_5;
                                    if ((v0_0 != gb.w.d) && (v0_0 != gb.w.e)) {
                                        if (v0_0 != gb.w.g) {
                                            this.k(v0_0);
                                            return 1;
                                        } else {
                                            return 0;
                                        }
                                    }
                                    return 1;
                                }
                            } else {
                                gb.c1 v7_1 = this.z(v6_3);
                                if (v7_1 == null) {
                                    break;
                                }
                                gb.z0 v8_1 = new gb.z0(v7_1, v1_10);
                                while (!v4_2.compareAndSet(this, v6_3, v8_1)) {
                                }
                                this.O(v7_1, v1_10);
                                v10_2 = gb.w.d;
                            }
                        }
                    } else {
                        try {
                            if (gb.z0.j.get(((gb.z0) v5_1)) != gb.w.h) {
                                Object v4_11 = ((gb.z0) v5_1).c();
                                if (v1_10 == null) {
                                    v1_10 = this.s(p10);
                                }
                                ((gb.z0) v5_1).a(v1_10);
                                com.google.gson.internal.b v10_13 = ((gb.z0) v5_1).b();
                                if (v4_11 == null) {
                                    v0_1 = v10_13;
                                }
                                if (v0_1 != null) {
                                    this.O(((gb.z0) v5_1).g, v0_1);
                                }
                                v10_2 = gb.w.d;
                            } else {
                                v10_2 = gb.w.g;
                            }
                        } catch (com.google.gson.internal.b v10_8) {
                            throw v10_8;
                        }
                    }
                    v0_0 = v10_2;
                } while(v4_2.get(this) == v6_3);
            }
        } else {
            do {
                Object v0_3 = gb.a1.g.get(this);
                if (((v0_3 instanceof gb.s0)) && ((!(v0_3 instanceof gb.z0)) || (gb.z0.h.get(((gb.z0) v0_3)) == 0))) {
                    v0_0 = this.V(v0_3, new gb.q(0, this.s(p10)));
                } else {
                    v0_0 = gb.w.d;
                    break;
                }
            } while(v0_0 == gb.w.f);
            if (v0_0 != gb.w.e) {
            }
        }
        return 1;
    }

    public void n(java.util.concurrent.CancellationException p1)
    {
        this.m(p1);
        return;
    }

    public final boolean o(Throwable p4)
    {
        if (!this.G()) {
            boolean v0_1 = (p4 instanceof java.util.concurrent.CancellationException);
            gb.k v1_2 = ((gb.k) gb.a1.h.get(this));
            if ((v1_2 != null) && (v1_2 != gb.d1.g)) {
                if ((!v1_2.a(p4)) && (!v0_1)) {
                    return 0;
                }
            } else {
                return v0_1;
            }
        }
        return 1;
    }

    public String p()
    {
        return "Job was cancelled";
    }

    public boolean q(Throwable p2)
    {
        if ((!(p2 instanceof java.util.concurrent.CancellationException)) && ((!this.m(p2)) || (!this.x()))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final void r(gb.s0 p7, Object p8)
    {
        kotlinx.coroutines.internal.a v0_0 = gb.a1.h;
        kotlinx.coroutines.CompletionHandlerException v1_1 = ((gb.k) v0_0.get(this));
        if (v1_1 != null) {
            v1_1.b();
            v0_0.set(this, gb.d1.g);
        }
        Throwable v8_1;
        kotlinx.coroutines.CompletionHandlerException v1_3 = 0;
        if (!(p8 instanceof gb.q)) {
            v8_1 = 0;
        } else {
            v8_1 = ((gb.q) p8);
        }
        Throwable v8_2;
        if (v8_1 == null) {
            v8_2 = 0;
        } else {
            v8_2 = v8_1.a;
        }
        if (!(p7 instanceof gb.w0)) {
            String v7_1 = p7.e();
            if (v7_1 != null) {
                v7_1.c(new lb.g(1), 1);
                kotlinx.coroutines.internal.a v0_5 = kotlinx.coroutines.internal.a.g.get(v7_1);
                v0_5.getClass();
                kotlinx.coroutines.internal.a v0_6 = ((kotlinx.coroutines.internal.a) v0_5);
                while (!v0_6.equals(v7_1)) {
                    if ((v0_6 instanceof gb.w0)) {
                        try {
                            ((gb.w0) v0_6).l(v8_2);
                        } catch (Throwable v4_5) {
                            if (v1_3 == null) {
                                String v5_1 = new StringBuilder("Exception in completion handler ");
                                v5_1.append(v0_6);
                                v5_1.append(" for ");
                                v5_1.append(this);
                                v1_3 = new kotlinx.coroutines.CompletionHandlerException(v5_1.toString(), v4_5);
                            } else {
                                com.bumptech.glide.i.d(v1_3, v4_5);
                            }
                        }
                    }
                    v0_6 = v0_6.h();
                }
                if (v1_3 != null) {
                    this.C(v1_3);
                }
            }
        } else {
            try {
                ((gb.w0) p7).l(v8_2);
                return;
            } catch (Throwable v8_3) {
                kotlinx.coroutines.CompletionHandlerException v1_6 = new StringBuilder("Exception in completion handler ");
                v1_6.append(p7);
                v1_6.append(" for ");
                v1_6.append(this);
                this.C(new kotlinx.coroutines.CompletionHandlerException(v1_6.toString(), v8_3));
            }
        }
        return;
    }

    public final Throwable s(Object p5)
    {
        if (!(p5 instanceof Throwable)) {
            java.util.concurrent.CancellationException v1_1;
            String v0_4 = gb.a1.g.get(((gb.a1) p5));
            kotlinx.coroutines.JobCancellationException v2_1 = 0;
            if (!(v0_4 instanceof gb.z0)) {
                if (!(v0_4 instanceof gb.q)) {
                    if ((v0_4 instanceof gb.s0)) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(v0_4, "Cannot be cancelling child in this state: ");
                        return 0;
                    } else {
                        v1_1 = 0;
                    }
                } else {
                    v1_1 = ((gb.q) v0_4).a;
                }
            } else {
                v1_1 = ((gb.z0) v0_4).b();
            }
            if ((v1_1 instanceof java.util.concurrent.CancellationException)) {
                v2_1 = ((java.util.concurrent.CancellationException) v1_1);
            }
            if (v2_1 == null) {
                v2_1 = new kotlinx.coroutines.JobCancellationException("Parent job is ".concat(gb.a1.U(v0_4)), v1_1, ((gb.a1) p5));
            }
            return v2_1;
        } else {
            return ((Throwable) p5);
        }
    }

    public final Object t(gb.z0 p11, Object p12)
    {
        gb.q v0_2;
        gb.q v1_0 = 0;
        if (!(p12 instanceof gb.q)) {
            v0_2 = 0;
        } else {
            v0_2 = ((gb.q) p12);
        }
        if (v0_2 != null) {
            v1_0 = v0_2.a;
        }
        try {
            p11.c();
            gb.q v0_1 = p11.f(v1_0);
            Object v2_0 = this.w(p11, v0_1);
        } catch (gb.q v12_1) {
            throw v12_1;
        }
        if (v2_0 != null) {
            if (v0_1.size() > 1) {
                java.util.Set v5_2 = java.util.Collections.newSetFromMap(new java.util.IdentityHashMap(v0_1.size()));
                int v6_2 = v0_1.size();
                int v7 = 0;
                while (v7 < v6_2) {
                    Throwable v8_0 = v0_1.get(v7);
                    v7++;
                    Throwable v8_1 = ((Throwable) v8_0);
                    if ((v8_1 != v2_0) && ((v8_1 != v2_0) && ((!(v8_1 instanceof java.util.concurrent.CancellationException)) && (v5_2.add(v8_1))))) {
                        com.bumptech.glide.i.d(v2_0, v8_1);
                    }
                }
            } else {
            }
        }
        if ((v2_0 != null) && (v2_0 != v1_0)) {
            p12 = new gb.q(0, v2_0);
        }
        if ((v2_0 != null) && ((this.o(v2_0)) || (this.A(v2_0)))) {
            p12.getClass();
            gb.q.b.compareAndSet(((gb.q) p12), 0, 1);
        }
        gb.q v1_3;
        this.P(p12);
        gb.q v0_8 = gb.a1.g;
        if (!(p12 instanceof gb.s0)) {
            v1_3 = p12;
        } else {
            v1_3 = new gb.t0(((gb.s0) p12));
        }
        while (!v0_8.compareAndSet(this, p11, v1_3)) {
            if (v0_8.get(this) != p11) {
                break;
            }
        }
        this.r(p11, p12);
        return p12;
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder();
        String v1_4 = new StringBuilder();
        v1_4.append(this.K());
        v1_4.append(123);
        v1_4.append(gb.a1.U(gb.a1.g.get(this)));
        v1_4.append(125);
        v0_1.append(v1_4.toString());
        v0_1.append(64);
        v0_1.append(gb.w.l(this));
        return v0_1.toString();
    }

    public final java.util.concurrent.CancellationException u()
    {
        kotlinx.coroutines.JobCancellationException v0_3 = gb.a1.g.get(this);
        java.util.concurrent.CancellationException v3_1 = 0;
        if (!(v0_3 instanceof gb.z0)) {
            if ((v0_3 instanceof gb.s0)) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(this, "Job is still new or active: ");
                return 0;
            } else {
                if (!(v0_3 instanceof gb.q)) {
                    return new kotlinx.coroutines.JobCancellationException(this.getClass().getSimpleName().concat(" has completed normally"), 0, this);
                } else {
                    kotlinx.coroutines.JobCancellationException v0_6 = ((gb.q) v0_3).a;
                    if ((v0_6 instanceof java.util.concurrent.CancellationException)) {
                        v3_1 = ((java.util.concurrent.CancellationException) v0_6);
                    }
                    if (v3_1 != null) {
                        return v3_1;
                    } else {
                        return new kotlinx.coroutines.JobCancellationException(this.p(), v0_6, this);
                    }
                }
            }
        } else {
            kotlinx.coroutines.JobCancellationException v0_8 = ((gb.z0) v0_3).b();
            if (v0_8 == null) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(this, "Job is still new or active: ");
                return 0;
            } else {
                String vtmp5 = this.getClass().getSimpleName().concat(" is cancelling");
                if ((v0_8 instanceof java.util.concurrent.CancellationException)) {
                    v3_1 = ((java.util.concurrent.CancellationException) v0_8);
                }
                if (v3_1 != null) {
                    return v3_1;
                } else {
                    return new kotlinx.coroutines.JobCancellationException(vtmp5, v0_8, this);
                }
            }
        }
    }

    public final Object v()
    {
        Throwable v0_4 = gb.a1.g.get(this);
        if ((v0_4 instanceof gb.s0)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("This job has not completed yet");
            return 0;
        } else {
            if ((v0_4 instanceof gb.q)) {
                throw ((gb.q) v0_4).a;
            } else {
                return gb.w.x(v0_4);
            }
        }
    }

    public final Throwable w(gb.z0 p6, java.util.ArrayList p7)
    {
        Object v1_0 = 0;
        if (!p7.isEmpty()) {
            Throwable v6_6 = p7.size();
            int v0_1 = 0;
            int v2_0 = 0;
            while (v2_0 < v6_6) {
                Object v3_0 = p7.get(v2_0);
                v2_0++;
                if (!(((Throwable) v3_0) instanceof java.util.concurrent.CancellationException)) {
                }
                Object v3_1 = ((Throwable) v3_0);
                if (v3_1 == null) {
                    Throwable v6_2 = ((Throwable) p7.get(0));
                    if ((v6_2 instanceof kotlinx.coroutines.TimeoutCancellationException)) {
                        int v2_2 = p7.size();
                        while (v0_1 < v2_2) {
                            Object v3_2 = p7.get(v0_1);
                            v0_1++;
                            boolean v4_4 = ((Throwable) v3_2);
                            if ((v4_4 != v6_2) && ((v4_4 instanceof kotlinx.coroutines.TimeoutCancellationException))) {
                                v1_0 = v3_2;
                                break;
                            }
                        }
                        Object v1_1 = ((Throwable) v1_0);
                        if (v1_1 != null) {
                            return v1_1;
                        }
                    }
                    return v6_2;
                } else {
                    return v3_1;
                }
            }
            v3_0 = 0;
        } else {
            if (!p6.c()) {
                return 0;
            } else {
                return new kotlinx.coroutines.JobCancellationException(this.p(), 0, this);
            }
        }
    }

    public boolean x()
    {
        return 1;
    }

    public boolean y()
    {
        return (this instanceof gb.n);
    }

    public final gb.c1 z(gb.s0 p2)
    {
        String v0_0 = p2.e();
        if (v0_0 != null) {
            return v0_0;
        } else {
            if (!(p2 instanceof gb.i0)) {
                if (!(p2 instanceof gb.w0)) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(p2, "State should have list: ");
                    return 0;
                } else {
                    this.S(((gb.w0) p2));
                    return 0;
                }
            } else {
                return new gb.c1();
            }
        }
    }
}
