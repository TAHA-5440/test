// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lb;
public abstract class a {
    public static final com.google.gson.internal.b a;
    public static final com.google.gson.internal.b b;
    public static final com.google.gson.internal.b c;
    public static final com.google.gson.internal.b d;
    public static final com.google.firebase.firestore.pipeline.evaluation.b e;
    public static final com.google.firebase.firestore.pipeline.evaluation.b f;
    public static final com.google.firebase.firestore.pipeline.evaluation.b g;

    static synthetic a()
    {
        lb.a.a = new com.google.gson.internal.b("CLOSED", 3);
        lb.a.b = new com.google.gson.internal.b("UNDEFINED", 3);
        lb.a.c = new com.google.gson.internal.b("REUSABLE_CLAIMED", 3);
        lb.a.d = new com.google.gson.internal.b("NO_THREAD_ELEMENTS", 3);
        lb.a.e = new com.google.firebase.firestore.pipeline.evaluation.b(8);
        lb.a.f = new com.google.firebase.firestore.pipeline.evaluation.b(9);
        lb.a.g = new com.google.firebase.firestore.pipeline.evaluation.b(10);
        return;
    }

    public static final void a(int p1)
    {
        if (p1 < 1) {
            oc.l.d(r1.a.g(p1, "Expected positive parallelism level, but got "));
            return;
        } else {
            return;
        }
    }

    public static final Object b(lb.p p5, long p6, ua.p p8)
    {
        while ((p5.c < p6) || (p5.c())) {
            boolean v0_4 = lb.b.a;
            lb.p v1_6 = v0_4.get(p5);
            Object v2_0 = lb.a.a;
            if (v1_6 != v2_0) {
                lb.p v1_1 = ((lb.p) ((lb.b) v1_6));
                if (v1_1 == null) {
                    v1_1 = ((lb.p) p8.invoke(Long.valueOf((p5.c + 1)), p5));
                    while (!v0_4.compareAndSet(p5, 0, v1_1)) {
                        if (v0_4.get(p5) != null) {
                        }
                    }
                    if (p5.c()) {
                        p5.d();
                    }
                }
                p5 = v1_1;
            } else {
                return v2_0;
            }
        }
        return p5;
    }

    public static final lb.p c(Object p1)
    {
        if (p1 == lb.a.a) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Does not contain segment");
            return 0;
        } else {
            return ((lb.p) p1);
        }
    }

    public static final void d(Throwable p4, ka.g p5)
    {
        Thread$UncaughtExceptionHandler v0_2 = lb.d.a.iterator();
        while (v0_2.hasNext()) {
            try {
                ((hb.b) v0_2.next()).d0(p4);
            } catch (kotlinx.coroutines.internal.ExceptionSuccessfullyProcessed) {
                return;
            } catch (Thread v1_2) {
                if (p4 != v1_2) {
                    RuntimeException v2_1 = new RuntimeException("Exception while trying to handle coroutine exception", v1_2);
                    com.bumptech.glide.i.d(v2_1, p4);
                } else {
                    v2_1 = p4;
                }
                Thread v1_3 = Thread.currentThread();
                v1_3.getUncaughtExceptionHandler().uncaughtException(v1_3, v2_1);
            }
        }
        try {
            com.bumptech.glide.i.d(p4, new kotlinx.coroutines.internal.DiagnosticCoroutineContextException(p5));
        } catch (Throwable) {
        }
        Thread v5_1 = Thread.currentThread();
        v5_1.getUncaughtExceptionHandler().uncaughtException(v5_1, p4);
        return;
    }

    public static final boolean e(Object p1)
    {
        if (p1 != lb.a.a) {
            return 0;
        } else {
            return 1;
        }
    }

    public static final Object f(Object p2, Object p3)
    {
        if (p2 != null) {
            if (!(p2 instanceof java.util.ArrayList)) {
                java.util.ArrayList v0_3 = new java.util.ArrayList(4);
                v0_3.add(p2);
                v0_3.add(p3);
                return v0_3;
            } else {
                ((java.util.ArrayList) p2).add(p3);
                return p2;
            }
        } else {
            return p3;
        }
    }

    public static final void g(ka.g p4, Object p5)
    {
        if (p5 != lb.a.d) {
            if (!(p5 instanceof lb.v)) {
                ThreadLocal v4_3 = p4.B(0, lb.a.f);
                v4_3.getClass();
                ((lb.s) v4_3).h.set(p5);
                return;
            } else {
                ThreadLocal v4_2 = ((lb.v) p5).c;
                int v0_2 = (v4_2.length - 1);
                if (v0_2 < 0) {
                    return;
                }
                while(true) {
                    int v1_0 = (v0_2 - 1);
                    ThreadLocal v2_0 = v4_2[v0_2];
                    v2_0.getClass();
                    v2_0.h.set(((lb.v) p5).b[v0_2]);
                    if (v1_0 < 0) {
                        break;
                    }
                    v0_2 = v1_0;
                }
            }
        }
        return;
    }

    public static final void h(Object p9, ka.c p10)
    {
        if (!(p10 instanceof lb.e)) {
            p10.resumeWith(p9);
            return;
        } else {
            ka.g v3_1;
            gb.j0 v0_2 = ((lb.e) p10).j;
            boolean v1_1 = ((lb.e) p10).k;
            gb.a1 v2_9 = kotlin.Result.a(p9);
            if (v2_9 != null) {
                v3_1 = new gb.q(0, v2_9);
            } else {
                v3_1 = p9;
            }
            if (!v0_2.f0(v1_1.getContext())) {
                gb.j0 v0_1 = gb.g1.a();
                if (v0_1.i < 4294967296) {
                    v0_1.j0(1);
                    gb.a1 v2_5 = ((gb.u0) v1_1.getContext().Z(gb.t.h));
                    if ((v2_5 == null) || (v2_5.d())) {
                        int v5_2;
                        gb.a1 v2_6 = ((lb.e) p10).m;
                        ka.g v3_4 = v1_1.getContext();
                        gb.a1 v2_7 = lb.a.l(v3_4, v2_6);
                        if (v2_7 == lb.a.d) {
                            v5_2 = 0;
                        } else {
                            v5_2 = gb.w.y(v1_1, v3_4, v2_7);
                        }
                        try {
                            v1_1.resumeWith(p9);
                        } catch (boolean v9_1) {
                            if (v5_2 == 0) {
                                lb.a.g(v3_4, v2_7);
                            } else {
                                if (v5_2.b0()) {
                                }
                            }
                            throw v9_1;
                        }
                        if ((v5_2 == 0) || (v5_2.b0())) {
                            lb.a.g(v3_4, v2_7);
                        }
                    } else {
                        ((lb.e) p10).resumeWith(new kotlin.Result$Failure(((gb.a1) v2_5).u()));
                    }
                    while (v0_1.l0()) {
                    }
                    v0_1.h0(1);
                } else {
                    ((lb.e) p10).l = v3_1;
                    ((lb.e) p10).i = 1;
                    v0_1.i0(((lb.e) p10));
                }
                return;
            } else {
                ((lb.e) p10).l = v3_1;
                ((lb.e) p10).i = 1;
                v0_2.d0(v1_1.getContext(), ((lb.e) p10));
                return;
            }
        }
    }

    public static final long i(long p4, long p6, long p8, String p10)
    {
        try {
            StringBuilder v0_0 = System.getProperty(p10);
        } catch (SecurityException) {
            v0_0 = 0;
        }
        if (v0_0 != null) {
            IllegalStateException v4_7 = db.p.S(v0_0);
            if (v4_7 == null) {
                String v6_2 = new StringBuilder("System property \'");
                v6_2.append(p10);
                v6_2.append("\' has unrecognized value \'");
                v6_2.append(v0_0);
                v6_2.append(39);
                throw new IllegalStateException(v6_2.toString().toString());
            } else {
                long v2 = v4_7.longValue();
                if ((p6 > v2) || (v2 > p8)) {
                    StringBuilder v0_2 = new StringBuilder("System property \'");
                    v0_2.append(p10);
                    v0_2.append("\' should be in range ");
                    v0_2.append(p6);
                    v0_2.append("..");
                    v0_2.append(p8);
                    v0_2.append(", but is \'");
                    v0_2.append(v2);
                    v0_2.append(39);
                    throw new IllegalStateException(v0_2.toString().toString());
                } else {
                    return v2;
                }
            }
        } else {
            return p4;
        }
    }

    public static int j(int p7, int p8, String p9)
    {
        int v8_2;
        if ((p8 & 8) == 0) {
            v8_2 = 2097150;
        } else {
            v8_2 = 2147483647;
        }
        return ((int) lb.a.i(((long) p7), ((long) 1), ((long) v8_2), p9));
    }

    public static final Object k(ka.g p2)
    {
        Object v2_1 = p2.B(Integer.valueOf(0), lb.a.e);
        v2_1.getClass();
        return v2_1;
    }

    public static final Object l(ka.g p1, Object p2)
    {
        if (p2 == null) {
            p2 = lb.a.k(p1);
        }
        if (p2 != Integer.valueOf(0)) {
            if (!(p2 instanceof Integer)) {
                ThreadLocal v1_1 = ((lb.s) p2).h;
                Object v0_0 = v1_1.get();
                v1_1.set(((lb.s) p2).g);
                return v0_0;
            } else {
                return p1.B(new lb.v(((Number) p2).intValue(), p1), lb.a.g);
            }
        } else {
            return lb.a.d;
        }
    }
}
