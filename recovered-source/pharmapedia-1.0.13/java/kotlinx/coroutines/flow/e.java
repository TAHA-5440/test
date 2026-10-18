// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow;
public class e extends kb.a implements jb.b, jb.c, kb.f {
    public final int j;
    public Object[] k;
    public long l;
    public long m;
    public int n;
    public int o;

    public e(int p2)
    {
        this.j = p2;
        return;
    }

    public static void g(kotlinx.coroutines.flow.e p8, jb.c p9, ka.c p10)
    {
        kotlinx.coroutines.flow.SharedFlowImpl$collect$1 v0_2;
        if (!(p10 instanceof kotlinx.coroutines.flow.SharedFlowImpl$collect$1)) {
            v0_2 = new kotlinx.coroutines.flow.SharedFlowImpl$collect$1(p8, p10);
        } else {
            v0_2 = ((kotlinx.coroutines.flow.SharedFlowImpl$collect$1) p10);
            kotlin.coroutines.intrinsics.CoroutineSingletons v1_2 = ((kotlinx.coroutines.flow.SharedFlowImpl$collect$1) p10).m;
            if ((v1_2 & -2147483648) == 0) {
            } else {
                ((kotlinx.coroutines.flow.SharedFlowImpl$collect$1) p10).m = (v1_2 - -2147483648);
            }
        }
        java.util.concurrent.CancellationException v8_4;
        jb.n v9_1;
        Throwable v2_5;
        Throwable v2_4;
        Object v10_4;
        jb.c v5_0;
        Object v10_1 = v0_2.k;
        kotlin.coroutines.intrinsics.CoroutineSingletons v1_1 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        Throwable v2_0 = v0_2.m;
        try {
            if (v2_0 == null) {
                kotlin.b.b(v10_1);
                v10_4 = p9;
                v9_1 = ((jb.n) p8.a());
                try {
                    v2_4 = ((gb.u0) v0_2.getContext().Z(gb.t.h));
                } catch (Object v10_5) {
                    v5_0 = p8;
                    java.util.concurrent.CancellationException v8_3 = v10_5;
                }
                v5_0 = p8;
                v8_4 = v2_4;
                v2_5 = v10_4;
                do {
                    Object v10_6 = v5_0.n(v9_1);
                    if (v10_6 != jb.m.a) {
                        if (v8_4 != null) {
                            if (!v8_4.d()) {
                                throw ((gb.a1) v8_4).u();
                            } else {
                            }
                        }
                        v0_2.g = v5_0;
                        v0_2.h = v2_5;
                        v0_2.i = v9_1;
                        v0_2.j = v8_4;
                        v0_2.m = 3;
                        if (v2_5.emit(v10_6, v0_2) == v1_1) {
                        }
                    } else {
                        v0_2.g = v5_0;
                        v0_2.h = v2_5;
                        v0_2.i = v9_1;
                        v0_2.j = v8_4;
                        v0_2.m = 2;
                    }
                    return;
                } while(v5_0.e(v9_1, v0_2) != v1_1);
                return;
            } else {
                if (v2_0 == 1) {
                    v9_1 = v0_2.i;
                    java.util.concurrent.CancellationException v8_2 = v0_2.h;
                    Throwable v2_1 = v0_2.g;
                    try {
                        kotlin.b.b(v10_1);
                        v10_4 = v8_2;
                        p8 = v2_1;
                    } catch (java.util.concurrent.CancellationException v8_3) {
                        v5_0 = v2_1;
                    }
                } else {
                    if (v2_0 == 2) {
                        v8_4 = v0_2.j;
                        v9_1 = v0_2.i;
                        v2_5 = v0_2.h;
                        v5_0 = v0_2.g;
                        kotlin.b.b(v10_1);
                    } else {
                        if (v2_0 != 3) {
                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                            return;
                        } else {
                            v8_4 = v0_2.j;
                            v9_1 = v0_2.i;
                            v2_5 = v0_2.h;
                            v5_0 = v0_2.g;
                            kotlin.b.b(v10_1);
                            v10_4 = v2_5;
                            v2_4 = v8_4;
                            p8 = v5_0;
                        }
                    }
                }
            }
        } catch (java.util.concurrent.CancellationException v8_3) {
        }
        v5_0.d(v9_1);
        throw v8_3;
    }

    public final kb.c b()
    {
        jb.n v0_1 = new jb.n();
        v0_1.a = -1;
        return v0_1;
    }

    public final kb.c[] c()
    {
        jb.n[] v0_1 = new jb.n[2];
        return v0_1;
    }

    public final Object collect(jb.c p1, ka.c p2)
    {
        kotlinx.coroutines.flow.e.g(this, p1, p2);
        return kotlin.coroutines.intrinsics.CoroutineSingletons.g;
    }

    public final Object e(jb.n p6, ka.c p7)
    {
        gb.h v0_1 = new gb.h(1, a.a.n(p7));
        v0_1.s();
        if (this.m(p6) >= 0) {
            v0_1.resumeWith(ga.p.a);
        } else {
            p6.b = v0_1;
        }
        ga.p v6_3 = v0_1.r();
        if (v6_3 != kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
            return ga.p.a;
        } else {
            return v6_3;
        }
    }

    public final Object emit(Object p11, ka.c p12)
    {
        ka.c v0_0 = kb.b.a;
        try {
            ga.p v1_0;
            int v2 = 0;
        } catch (ka.c v0_5) {
            ga.p v11_1 = v0_5;
            throw v11_1;
        }
        if (!this.l(p11)) {
            v1_0 = 0;
        } else {
            try {
                v0_0 = this.i(v0_0);
                v1_0 = 1;
            } catch (ka.c v0_1) {
                v11_1 = v0_1;
            }
        }
        jb.l v4_0 = v0_0.length;
        kotlinx.coroutines.flow.e v5_0 = 0;
        while (v5_0 < v4_0) {
            long v6_2 = v0_0[v5_0];
            if (v6_2 != 0) {
                v6_2.resumeWith(ga.p.a);
            }
            v5_0++;
        }
        if (v1_0 == null) {
            gb.h v9_1 = new gb.h(1, a.a.n(p12));
            v9_1.s();
            kotlin.coroutines.intrinsics.CoroutineSingletons v12_2 = kb.b.a;
            try {
                kotlin.coroutines.intrinsics.CoroutineSingletons v12_3;
                ga.p v11_6;
                if (!this.l(p11)) {
                    try {
                        jb.l v4_2 = new jb.l(this, (this.j() + ((long) (this.n + this.o))), p11, v9_1);
                        this.h(v4_2);
                        this.o = (this.o + 1);
                    } catch (ka.c v0_4) {
                        ga.p v11_5 = v0_4;
                        throw v11_5;
                    }
                    if (this.j == 0) {
                        v12_2 = this.i(v12_2);
                    }
                    v11_6 = v12_2;
                    v12_3 = v4_2;
                } else {
                    try {
                        v9_1.resumeWith(ga.p.a);
                        v11_6 = this.i(v12_2);
                        v12_3 = 0;
                    } catch (ka.c v0_6) {
                        v11_5 = v0_6;
                    }
                }
            } catch (ka.c v0_4) {
            }
            if (v12_3 != null) {
                v9_1.v(new gb.e(v12_3, 2));
            }
            kotlin.coroutines.intrinsics.CoroutineSingletons v12_4 = v11_6.length;
            while (v2 < v12_4) {
                ka.c v0_9 = v11_6[v2];
                if (v0_9 != null) {
                    v0_9.resumeWith(ga.p.a);
                }
                v2++;
            }
            ga.p v11_8 = v9_1.r();
            kotlin.coroutines.intrinsics.CoroutineSingletons v12_5 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
            if (v11_8 != v12_5) {
                v11_8 = ga.p.a;
            }
            if (v11_8 != v12_5) {
                return ga.p.a;
            } else {
                return v11_8;
            }
        } else {
            return ga.p.a;
        }
    }

    public final void f()
    {
        if ((this.j != 0) || (this.o > 1)) {
            Object[] v0_2 = this.k;
            v0_2.getClass();
            while (this.o > 0) {
                int v5_0 = this.o;
                if (v0_2[(((int) ((this.j() + ((long) (this.n + v5_0))) - 1)) & (v0_2.length - 1))] != jb.m.a) {
                    break;
                }
                this.o = (v5_0 - 1);
                jb.m.a(v0_2, (this.j() + ((long) (this.n + this.o))), 0);
            }
        }
        return;
    }

    public final void h(Object p7)
    {
        int v0_1 = (this.n + this.o);
        Object[] v1_1 = this.k;
        if (v1_1 != null) {
            if (v0_1 >= v1_1.length) {
                v1_1 = this.k(v1_1, v0_1, (v1_1.length * 2));
            }
        } else {
            v1_1 = this.k(0, 0, 2);
        }
        jb.m.a(v1_1, (this.j() + ((long) v0_1)), p7);
        return;
    }

    public final ka.c[] i(ka.c[] p11)
    {
        int v0_0 = p11.length;
        if (this.h != 0) {
            kb.c[] v1_1 = this.g;
            if (v1_1 != null) {
                int v2 = v1_1.length;
                int v3 = 0;
                while (v3 < v2) {
                    jb.n v4_0 = v1_1[v3];
                    if (v4_0 != null) {
                        jb.n v4_1 = ((jb.n) v4_0);
                        gb.h v5 = v4_1.b;
                        if ((v5 != null) && (this.m(v4_1) >= 0)) {
                            if (v0_0 >= p11.length) {
                                p11 = java.util.Arrays.copyOf(p11, Math.max(2, (p11.length * 2)));
                            }
                            int v7_1 = (v0_0 + 1);
                            ((ka.c[]) p11)[v0_0] = v5;
                            v4_1.b = 0;
                            v0_0 = v7_1;
                        }
                    }
                    v3++;
                }
            }
        }
        return ((ka.c[]) p11);
    }

    public final long j()
    {
        return Math.min(this.m, this.l);
    }

    public final Object[] k(Object[] p8, int p9, int p10)
    {
        if (p10 <= null) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Buffer size overflow");
            return 0;
        } else {
            Object[] v10_1 = new Object[p10];
            this.k = v10_1;
            if (p8 != 0) {
                long v0 = this.j();
                int v2 = 0;
                while (v2 < p9) {
                    long v3_1 = (((long) v2) + v0);
                    jb.m.a(v10_1, v3_1, p8[(((int) v3_1) & (p8.length - 1))]);
                    v2++;
                }
            }
            return v10_1;
        }
    }

    public final boolean l(Object p15)
    {
        if (this.h != 0) {
            int v2 = 0;
            int v3_3 = this.j;
            if ((this.n < v3_3) || (this.m > this.l)) {
                this.h(p15);
                kb.c[] v1_2 = (this.n + 1);
                this.n = v1_2;
                if (v1_2 > v3_3) {
                    kb.c[] v1_3 = this.k;
                    v1_3.getClass();
                    jb.m.a(v1_3, this.j(), 0);
                    this.n = (this.n - 1);
                    long v6_2 = (this.j() + 1);
                    if (this.l < v6_2) {
                        this.l = v6_2;
                    }
                    if (this.m < v6_2) {
                        if (this.h != 0) {
                            kb.c[] v1_10 = this.g;
                            if (v1_10 != null) {
                                int v3_1 = v1_10.length;
                                while (v2 < v3_1) {
                                    jb.n v8_0 = v1_10[v2];
                                    if (v8_0 != null) {
                                        jb.n v8_1 = ((jb.n) v8_0);
                                        long v10_6 = v8_1.a;
                                        if ((v10_6 >= 0) && (v10_6 < v6_2)) {
                                            v8_1.a = v6_2;
                                        }
                                    }
                                    v2++;
                                }
                            }
                        }
                        this.m = v6_2;
                    }
                }
                long v6_4 = this.l;
                if (((int) ((this.j() + ((long) this.n)) - v6_4)) > 0) {
                    this.o((v6_4 + 1), this.m, (this.j() + ((long) this.n)), ((this.j() + ((long) this.n)) + ((long) this.o)));
                }
            } else {
                return 0;
            }
        }
        return 1;
    }

    public final long m(jb.n p7)
    {
        long v0 = p7.a;
        if ((v0 >= (this.j() + ((long) this.n))) && ((this.j > 0) || ((v0 > this.j()) || (this.o == 0)))) {
            v0 = -1;
        }
        return v0;
    }

    public final Object n(jb.n p9)
    {
        ka.c[] v0_0 = kb.b.a;
        Object v9_2;
        long v1_1 = this.m(p9);
        if (v1_1 >= 0) {
            ka.c v3_3 = p9.a;
            ka.c[] v0_3 = this.k;
            v0_3.getClass();
            ka.c[] v0_1 = v0_3[(((int) v1_1) & (v0_3.length - 1))];
            if ((v0_1 instanceof jb.l)) {
                v0_1 = ((jb.l) v0_1).i;
            }
            p9.a = (v1_1 + 1);
            v0_0 = this.q(v3_3);
            v9_2 = v0_1;
        } else {
            v9_2 = jb.m.a;
        }
        long v1_2 = v0_0.length;
        int v2 = 0;
        while (v2 < v1_2) {
            ka.c v3_1 = v0_0[v2];
            if (v3_1 != null) {
                v3_1.resumeWith(ga.p.a);
            }
            v2++;
        }
        return v9_2;
    }

    public final void o(long p7, long p9, long p11, long p13)
    {
        long v0 = Math.min(p9, p7);
        long v2 = this.j();
        while (v2 < v0) {
            long v4_0 = this.k;
            v4_0.getClass();
            jb.m.a(v4_0, v2, 0);
            v2++;
        }
        this.l = p7;
        this.m = p9;
        this.n = ((int) (p11 - v0));
        this.o = ((int) (p13 - p11));
        return;
    }

    public final jb.b p(ka.g p2, int p3, kotlinx.coroutines.channels.BufferOverflow p4)
    {
        if (((p3 != 0) && (p3 != -3)) || (p4 != kotlinx.coroutines.channels.BufferOverflow.g)) {
            return new kb.d(this, p2, p3, p4);
        } else {
            return this;
        }
    }

    public final ka.c[] q(long p23)
    {
        ka.c[] v1_0 = jb.m.a;
        Object v2_2 = kb.b.a;
        if (p23 <= this.m) {
            long v3_0 = this.j();
            long v5_0 = (((long) this.n) + v3_0);
            int v7_2 = this.j;
            if ((v7_2 == 0) && (this.o > 0)) {
                v5_0++;
            }
            if (this.h != 0) {
                ka.c v10_2 = this.g;
                if (v10_2 != null) {
                    int v13 = 0;
                    while (v13 < v10_2.length) {
                        long v14_0 = v10_2[v13];
                        if (v14_0 != 0) {
                            long v14_2 = ((jb.n) v14_0).a;
                            if ((v14_2 >= 0) && (v14_2 < v5_0)) {
                                v5_0 = v14_2;
                            }
                        }
                        v13++;
                    }
                }
            }
            if (v5_0 > this.m) {
                int v23_1;
                long v12_0 = (this.j() + ((long) this.n));
                long v14_4 = this.o;
                if (this.h <= 0) {
                    v23_1 = 1;
                } else {
                    v23_1 = 1;
                    v14_4 = Math.min(v14_4, (v7_2 - ((int) (v12_0 - v5_0))));
                }
                ka.c v10_6;
                long v20;
                long v8_6 = (((long) this.o) + v12_0);
                if (v14_4 <= 0) {
                    v20 = v3_0;
                    v10_6 = v2_2;
                } else {
                    Object v2_1 = new ka.c[v14_4];
                    ka.c v10_7 = this.k;
                    v10_7.getClass();
                    int v18 = v12_0;
                    int v15 = 0;
                    while (v12_0 < v8_6) {
                        ka.c v17 = v2_1;
                        Object v2_6 = v10_7[((v10_7.length - 1) & ((int) v12_0))];
                        if (v2_6 == v1_0) {
                            v20 = v3_0;
                        } else {
                            v2_6.getClass();
                            Object v2_7 = ((jb.l) v2_6);
                            int v11_3 = (v15 + 1);
                            v20 = v3_0;
                            v17[v15] = v2_7.j;
                            jb.m.a(v10_7, v12_0, v1_0);
                            long v3_5 = v18;
                            jb.m.a(v10_7, v3_5, v2_7.i);
                            Object v2_9 = (v3_5 + v23_1);
                            if (v11_3 >= v14_4) {
                                v12_0 = v2_9;
                                v10_6 = v17;
                                long v3_7;
                                if (this.h != 0) {
                                    v3_7 = v5_0;
                                } else {
                                    v3_7 = v12_0;
                                }
                                long v5_1 = Math.max(this.l, (v12_0 - ((long) Math.min(0, ((int) (v12_0 - v20))))));
                                if ((v7_2 == 0) && (v5_1 < v8_6)) {
                                    Object v2_14 = this.k;
                                    v2_14.getClass();
                                    if (kotlin.jvm.internal.f.a(v2_14[(((int) v5_1) & (v2_14.length - 1))], v1_0)) {
                                        v12_0 += v23_1;
                                        v5_1 += v23_1;
                                    }
                                }
                                this.o(v5_1, v3_7, v12_0, v8_6);
                                this.f();
                                if (v10_6.length != 0) {
                                    return this.i(v10_6);
                                } else {
                                    return v10_6;
                                }
                                return v2_2;
                            } else {
                                v18 = v2_9;
                                v15 = v11_3;
                            }
                        }
                        v12_0 += v23_1;
                        v2_1 = v17;
                        v3_0 = v20;
                    }
                    v17 = v2_1;
                    v20 = v3_0;
                    v12_0 = v18;
                }
            }
        }
        return v2_2;
    }
}
