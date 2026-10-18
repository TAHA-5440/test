// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public abstract class w {
    public static final com.google.gson.internal.b a;
    public static final com.google.gson.internal.b b;
    public static final com.google.gson.internal.b c;
    public static final com.google.gson.internal.b d;
    public static final com.google.gson.internal.b e;
    public static final com.google.gson.internal.b f;
    public static final com.google.gson.internal.b g;
    public static final com.google.gson.internal.b h;
    public static final gb.i0 i;
    public static final gb.i0 j;

    static synthetic w()
    {
        gb.w.a = new com.google.gson.internal.b("RESUME_TOKEN", 3);
        gb.w.b = new com.google.gson.internal.b("REMOVED_TASK", 3);
        gb.w.c = new com.google.gson.internal.b("CLOSED_EMPTY", 3);
        gb.w.d = new com.google.gson.internal.b("COMPLETING_ALREADY", 3);
        gb.w.e = new com.google.gson.internal.b("COMPLETING_WAITING_CHILDREN", 3);
        gb.w.f = new com.google.gson.internal.b("COMPLETING_RETRY", 3);
        gb.w.g = new com.google.gson.internal.b("TOO_LATE_TO_CANCEL", 3);
        gb.w.h = new com.google.gson.internal.b("SEALED", 3);
        gb.w.i = new gb.i0(0);
        gb.w.j = new gb.i0(1);
        return;
    }

    public static gb.n a()
    {
        gb.n v0_1 = new gb.n(1);
        v0_1.D(0);
        return v0_1;
    }

    public static final lb.c b(ka.g p3)
    {
        if (p3.Z(gb.t.h) == null) {
            p3 = p3.L(new gb.v0(0));
        }
        return new lb.c(p3);
    }

    public static gb.f1 c()
    {
        return new gb.f1(0);
    }

    public static gb.z d(lb.c p4, ua.p p5)
    {
        gb.z v1_2 = new gb.z(gb.w.q(p4, kotlin.coroutines.EmptyCoroutineContext.g), 1, 0);
        v1_2.a0(kotlinx.coroutines.CoroutineStart.g, v1_2, p5);
        return v1_2;
    }

    public static final void e(gb.v p1, String p2, Exception p3)
    {
        java.util.concurrent.CancellationException v0_1 = new java.util.concurrent.CancellationException(p2);
        v0_1.initCause(p3);
        gb.w.f(p1, v0_1);
        return;
    }

    public static final void f(gb.v p2, java.util.concurrent.CancellationException p3)
    {
        gb.u0 v0_2 = ((gb.u0) p2.M().Z(gb.t.h));
        if (v0_2 == null) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(p2, "Scope cannot be cancelled because it does not have a job: ");
            return;
        } else {
            v0_2.h(p3);
            return;
        }
    }

    public static final Object g(ua.p p2, ka.c p3)
    {
        return com.bumptech.glide.i.t(new lb.o(p3, p3.getContext()), new lb.o(p3, p3.getContext()), p2);
    }

    public static final Object h(long p3, ka.c p5)
    {
        if (p3 > 0) {
            gb.h v0_3 = new gb.h(1, a.a.n(p5));
            v0_3.s();
            if (p3 < 9223372036854775807) {
                gb.w.k(v0_3.k).c0(p3, v0_3);
            }
            Object v3_1 = v0_3.r();
            if (v3_1 == kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
                return v3_1;
            }
        }
        return ga.p.a;
    }

    public static final ka.g i(ka.g p3, ka.g p4, boolean p5)
    {
        com.google.firebase.firestore.pipeline.evaluation.b v5_0 = Boolean.FALSE;
        kotlin.jvm.internal.Ref$ObjectRef v0_6 = ((Boolean) p3.B(v5_0, new com.google.firebase.firestore.pipeline.evaluation.b(2))).booleanValue();
        com.google.firebase.firestore.pipeline.evaluation.b v5_3 = ((Boolean) p4.B(v5_0, new com.google.firebase.firestore.pipeline.evaluation.b(2))).booleanValue();
        if ((v0_6 != null) || (v5_3 != null)) {
            kotlin.jvm.internal.Ref$ObjectRef v0_2 = new kotlin.jvm.internal.Ref$ObjectRef();
            v0_2.g = p4;
            kotlin.coroutines.EmptyCoroutineContext v1_3 = kotlin.coroutines.EmptyCoroutineContext.g;
            ka.g v3_2 = ((ka.g) p3.B(v1_3, new com.google.firebase.firestore.pipeline.evaluation.b(3)));
            if (v5_3 != null) {
                v0_2.g = ((ka.g) v0_2.g).B(v1_3, new com.google.firebase.firestore.pipeline.evaluation.b(4));
            }
            return v3_2.L(((ka.g) v0_2.g));
        } else {
            return p3.L(p4);
        }
    }

    public static final gb.s j(java.util.concurrent.Executor p1)
    {
        gb.q0 v0_2;
        if (!(p1 instanceof gb.d0)) {
            v0_2 = 0;
        } else {
            v0_2 = ((gb.d0) p1);
        }
        if (v0_2 != null) {
            gb.q0 v0_4 = v0_2.g;
            if (v0_4 != null) {
                return v0_4;
            }
        }
        return new gb.q0(p1);
    }

    public static final gb.a0 k(ka.g p1)
    {
        gb.a0 v1_2;
        gb.a0 v1_1 = p1.Z(ka.d.g);
        if (!(v1_1 instanceof gb.a0)) {
            v1_2 = 0;
        } else {
            v1_2 = ((gb.a0) v1_1);
        }
        if (v1_2 == null) {
            v1_2 = gb.y.a;
        }
        return v1_2;
    }

    public static final String l(Object p0)
    {
        return Integer.toHexString(System.identityHashCode(p0));
    }

    public static final gb.h m(ka.c p6)
    {
        if ((p6 instanceof lb.e)) {
            gb.b v1_4 = lb.a.c;
            int v2_2 = lb.e.n;
            do {
                gb.h v3_0;
                gb.h v3_1 = v2_2.get(((lb.e) p6));
                gb.h v4_1 = 0;
                if (v3_1 != null) {
                    if (!(v3_1 instanceof gb.h)) {
                        if ((v3_1 == v1_4) || ((v3_1 instanceof Throwable))) {
                            break;
                        }
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(v3_1, "Inconsistent state ");
                        return 0;
                    }
                    while (!v2_2.compareAndSet(((lb.e) p6), v3_1, v1_4)) {
                    }
                    v3_0 = ((gb.h) v3_1);
                } else {
                    v2_2.set(((lb.e) p6), v1_4);
                    v3_0 = 0;
                }
                if (v3_0 != null) {
                    gb.h v0_2 = gb.h.m;
                    gb.b v1_0 = v0_2.get(v3_0);
                    if ((!(v1_0 instanceof gb.p)) || (((gb.p) v1_0).d == null)) {
                        gb.h.l.set(v3_0, 536870911);
                        v0_2.set(v3_0, gb.b.a);
                        v4_1 = v3_0;
                    } else {
                        v3_0.o();
                    }
                    if (v4_1 != null) {
                        return v4_1;
                    }
                }
                return new gb.h(2, p6);
            } while(v2_2.get(((lb.e) p6)) == v3_1);
        } else {
            return new gb.h(1, p6);
        }
    }

    public static final void n(Throwable p3, ka.g p4)
    {
        try {
            Throwable v0_2 = ((hb.b) p4.Z(gb.t.g));
        } catch (Throwable v0_3) {
            if (p3 != v0_3) {
                RuntimeException v1_1 = new RuntimeException("Exception while trying to handle coroutine exception", v0_3);
                com.bumptech.glide.i.d(v1_1, p3);
                p3 = v1_1;
            }
            lb.a.d(p3, p4);
            return;
        }
        if (v0_2 == null) {
            lb.a.d(p3, p4);
            return;
        } else {
            v0_2.d0(p3);
            return;
        }
    }

    public static final boolean o(gb.v p1)
    {
        int v1_4 = ((gb.u0) p1.M().Z(gb.t.h));
        if (v1_4 == 0) {
            return 1;
        } else {
            return v1_4.d();
        }
    }

    public static gb.z p(gb.v p2, ka.g p3, ua.p p4, int p5)
    {
        kotlinx.coroutines.CoroutineStart v0 = kotlinx.coroutines.CoroutineStart.j;
        if ((p5 & 1) != 0) {
            p3 = kotlin.coroutines.EmptyCoroutineContext.g;
        }
        if ((p5 & 2) != 0) {
            v0 = kotlinx.coroutines.CoroutineStart.g;
        }
        gb.z v3_2;
        ka.g v2_1 = gb.w.q(p2, p3);
        if (v0 != kotlinx.coroutines.CoroutineStart.h) {
            v3_2 = new gb.z(v2_1, 1, 1);
        } else {
            v3_2 = new gb.b1(v2_1, p4);
        }
        v3_2.a0(v0, v3_2, p4);
        return v3_2;
    }

    public static final ka.g q(gb.v p1, ka.g p2)
    {
        ka.g v1_2 = gb.w.i(p1.M(), p2, 1);
        nb.d v2_1 = gb.e0.a;
        if ((v1_2 != v2_1) && (v1_2.Z(ka.d.g) == null)) {
            v1_2 = v1_2.L(v2_1);
        }
        return v1_2;
    }

    public static final Object r(Object p1)
    {
        if ((p1 instanceof gb.q)) {
            p1 = kotlin.b.a(((gb.q) p1).a);
        }
        return p1;
    }

    public static final void s(gb.h p2, ka.c p3, boolean p4)
    {
        boolean v2_3;
        ka.g v0_2 = gb.h.m.get(p2);
        int v1_2 = p2.g(v0_2);
        if (v1_2 == 0) {
            v2_3 = p2.h(v0_2);
        } else {
            v2_3 = new kotlin.Result$Failure(v1_2);
        }
        if (!p4) {
            p3.resumeWith(v2_3);
            return;
        } else {
            int v1_1;
            p3.getClass();
            boolean v4_1 = ((lb.e) p3).k;
            Object v3_2 = ((lb.e) p3).m;
            ka.g v0_1 = v4_1.getContext();
            Object v3_3 = lb.a.l(v0_1, v3_2);
            if (v3_3 == lb.a.d) {
                v1_1 = 0;
            } else {
                v1_1 = gb.w.y(v4_1, v0_1, v3_3);
            }
            try {
                v4_1.resumeWith(v2_3);
            } catch (boolean v2_1) {
                if (v1_1 == 0) {
                    lb.a.g(v0_1, v3_3);
                } else {
                    if (v1_1.b0()) {
                    }
                }
                throw v2_1;
            }
            if ((v1_1 != 0) && (!v1_1.b0())) {
                return;
            } else {
                lb.a.g(v0_1, v3_3);
                return;
            }
        }
    }

    public static final Object t(ka.g p6, ua.p p7)
    {
        Throwable v6_1;
        long v2_2;
        int v0_0 = Thread.currentThread();
        int v1_0 = ka.d.g;
        long v2_4 = ((gb.s) p6.Z(v1_0));
        nb.d v3_2 = kotlin.coroutines.EmptyCoroutineContext.g;
        if (v2_4 != 0) {
            // Both branches of the condition point to the same code.
            // if (!(v2_4 instanceof gb.j0)) {
                v2_2 = ((gb.j0) gb.g1.a.get());
                v6_1 = gb.w.i(v3_2, p6, 1);
                nb.d v3_0 = gb.e0.a;
                if ((v6_1 != v3_0) && (v6_1.Z(v1_0) == null)) {
                    v6_1 = v6_1.L(v3_0);
                }
            // }
        } else {
            v2_2 = gb.g1.a();
            v6_1 = gb.w.i(v3_2, p6.L(v2_2), 1);
            nb.d v3_1 = gb.e0.a;
            if ((v6_1 != v3_1) && (v6_1.Z(v1_0) == null)) {
                v6_1 = v6_1.L(v3_1);
            }
        }
        int v1_4 = new gb.c(v6_1, v0_0, v2_2);
        v1_4.a0(kotlinx.coroutines.CoroutineStart.g, v1_4, p7);
        int v7_1 = v1_4.k;
        if (v7_1 != 0) {
            v7_1.j0(0);
        }
        while (!Thread.interrupted()) {
            long v2_5;
            if (v7_1 == 0) {
                v2_5 = 9223372036854775807;
            } else {
                v2_5 = v7_1.k0();
            }
            if (v1_4.F()) {
                if (v7_1 != 0) {
                    v7_1.h0(0);
                }
                int v7_3;
                Throwable v6_7 = gb.w.x(gb.a1.g.get(v1_4));
                if (!(v6_7 instanceof gb.q)) {
                    v7_3 = 0;
                } else {
                    v7_3 = ((gb.q) v6_7);
                }
                if (v7_3 != 0) {
                    throw v7_3.a;
                } else {
                    return v6_7;
                }
            } else {
                java.util.concurrent.locks.LockSupport.parkNanos(v1_4, v2_5);
            }
        }
        int v0_3 = new InterruptedException();
        v1_4.m(v0_3);
        throw v0_3;
    }

    public static synthetic Object u(ua.p p1)
    {
        return gb.w.t(kotlin.coroutines.EmptyCoroutineContext.g, p1);
    }

    public static final String v(ka.c p3)
    {
        if (!(p3 instanceof lb.e)) {
            try {
                String v1_6 = new StringBuilder();
                v1_6.append(p3);
                v1_6.append(64);
                v1_6.append(gb.w.l(p3));
                String v1_0 = v1_6.toString();
            } catch (String v1_1) {
                v1_0 = new kotlin.Result$Failure(v1_1);
            }
            if (kotlin.Result.a(v1_0) != null) {
                String v1_3 = new StringBuilder();
                v1_3.append(p3.getClass().getName());
                v1_3.append(64);
                v1_3.append(gb.w.l(p3));
                v1_0 = v1_3.toString();
            }
            return ((String) v1_0);
        } else {
            return ((lb.e) p3).toString();
        }
    }

    public static final long w(long p4)
    {
        kotlin.time.DurationUnit v2_2;
        if (p4 <= 0) {
            v2_2 = 0;
        } else {
            v2_2 = 1;
        }
        if (v2_2 != 1) {
            if (v2_2 != null) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.s();
                return 0;
            } else {
                return 0;
            }
        } else {
            long v4_1 = eb.a.f(p4, jc.g.w(999999, kotlin.time.DurationUnit.h));
            if (((((int) v4_1) & 1) != 1) || (eb.a.e(v4_1))) {
                return eb.a.g(v4_1, kotlin.time.DurationUnit.i);
            } else {
                return (v4_1 >> 1);
            }
        }
    }

    public static final Object x(Object p1)
    {
        gb.s0 v0_1;
        if (!(p1 instanceof gb.t0)) {
            v0_1 = 0;
        } else {
            v0_1 = ((gb.t0) p1);
        }
        if (v0_1 != null) {
            gb.s0 v0_3 = v0_1.a;
            if (v0_3 != null) {
                return v0_3;
            }
        }
        return p1;
    }

    public static final gb.l1 y(ka.c p2, ka.g p3, Object p4)
    {
        gb.l1 v1_0 = 0;
        if (((p2 instanceof ma.b)) && (p3.Z(gb.m1.g) != null)) {
            ma.b v2_1 = ((ma.b) p2);
            while (!(v2_1 instanceof gb.b0)) {
                v2_1 = v2_1.getCallerFrame();
                if (v2_1 == null) {
                    break;
                }
                if ((v2_1 instanceof gb.l1)) {
                    v1_0 = ((gb.l1) v2_1);
                    break;
                }
            }
            if (v1_0 != null) {
                v1_0.c0(p3, p4);
            }
        }
        return v1_0;
    }

    public static final Object z(ka.g p5, ua.p p6, ka.c p7)
    {
        Throwable v5_1;
        gb.b0 v0_0 = p7.getContext();
        if (((Boolean) p5.B(Boolean.FALSE, new com.google.firebase.firestore.pipeline.evaluation.b(2))).booleanValue()) {
            v5_1 = gb.w.i(v0_0, p5, 0);
        } else {
            v5_1 = v0_0.L(p5);
        }
        Throwable v5_6;
        kotlinx.coroutines.a.a(v5_1);
        if (v5_1 != v0_0) {
            int v1_1 = ka.d.g;
            if (!kotlin.jvm.internal.f.a(v5_1.Z(v1_1), v0_0.Z(v1_1))) {
                gb.b0 v0_4 = new gb.b0(p7, v5_1);
                try {
                    lb.a.h(ga.p.a, a.a.n(((kotlin.coroutines.jvm.internal.BaseContinuationImpl) p6).create(v0_4, v0_4)));
                    Throwable v5_4 = gb.b0.k;
                } catch (Throwable v5_5) {
                    v0_4.resumeWith(new kotlin.Result$Failure(v5_5));
                    throw v5_5;
                }
                do {
                    boolean v6_5 = v5_4.get(v0_4);
                    if (!v6_5) {
                    } else {
                        if (v6_5 != 2) {
                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Already suspended");
                            return 0;
                        } else {
                            v5_6 = gb.w.x(gb.a1.g.get(v0_4));
                            if ((v5_6 instanceof gb.q)) {
                                throw ((gb.q) v5_6).a;
                            }
                        }
                    }
                } while(!v5_4.compareAndSet(v0_4, 0, 1));
                v5_6 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
            } else {
                gb.b0 v0_6 = new gb.l1(p7, v5_1);
                Throwable v5_12 = v0_6.i;
                Object v7_1 = lb.a.l(v5_12, 0);
                try {
                    boolean v6_9 = com.bumptech.glide.i.t(v0_6, v0_6, p6);
                    lb.a.g(v5_12, v7_1);
                    v5_6 = v6_9;
                } catch (boolean v6_10) {
                    lb.a.g(v5_6, v7_1);
                    throw v6_10;
                }
            }
        } else {
            v5_6 = com.bumptech.glide.i.t(new lb.o(p7, v5_1), new lb.o(p7, v5_1), p6);
        }
        return v5_6;
    }
}
