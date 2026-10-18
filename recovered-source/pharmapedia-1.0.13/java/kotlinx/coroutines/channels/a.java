// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.channels;
public class a implements ib.d {
    public static final synthetic java.util.concurrent.atomic.AtomicLongFieldUpdater h;
    public static final synthetic java.util.concurrent.atomic.AtomicLongFieldUpdater i;
    public static final synthetic java.util.concurrent.atomic.AtomicLongFieldUpdater j;
    public static final synthetic java.util.concurrent.atomic.AtomicLongFieldUpdater k;
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater l;
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater m;
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater n;
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater o;
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater p;
    private volatile synthetic Object _closeCause$volatile;
    private volatile synthetic long bufferEnd$volatile;
    private volatile synthetic Object bufferEndSegment$volatile;
    private volatile synthetic Object closeHandler$volatile;
    private volatile synthetic long completedExpandBuffersAndPauseFlag$volatile;
    public final int g;
    private volatile synthetic Object receiveSegment$volatile;
    private volatile synthetic long receivers$volatile;
    private volatile synthetic Object sendSegment$volatile;
    private volatile synthetic long sendersAndCloseStatus$volatile;

    static a()
    {
        kotlinx.coroutines.channels.a.h = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.channels.a, "sendersAndCloseStatus$volatile");
        kotlinx.coroutines.channels.a.i = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.channels.a, "receivers$volatile");
        kotlinx.coroutines.channels.a.j = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.channels.a, "bufferEnd$volatile");
        kotlinx.coroutines.channels.a.k = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.channels.a, "completedExpandBuffersAndPauseFlag$volatile");
        kotlinx.coroutines.channels.a.l = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.channels.a, Object, "sendSegment$volatile");
        kotlinx.coroutines.channels.a.m = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.channels.a, Object, "receiveSegment$volatile");
        kotlinx.coroutines.channels.a.n = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.channels.a, Object, "bufferEndSegment$volatile");
        kotlinx.coroutines.channels.a.o = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.channels.a, Object, "_closeCause$volatile");
        kotlinx.coroutines.channels.a.p = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.channels.a, Object, "closeHandler$volatile");
        return;
    }

    public a(int p9)
    {
        this.g = p9;
        if (p9 < null) {
            oc.l.d(r1.a.h(p9, "Invalid channel capacity: ", ", should be >=0"));
            throw 0;
        } else {
            long v0_0;
            if (p9 == null) {
                v0_0 = 0;
            } else {
                if (p9 == 2147483647) {
                    v0_0 = 9223372036854775807;
                } else {
                    v0_0 = ((long) p9);
                }
            }
            this.bufferEnd$volatile = v0_0;
            this.completedExpandBuffersAndPauseFlag$volatile = kotlinx.coroutines.channels.a.j.get(this);
            ib.h v2_1 = new ib.h(0, 0, this, 3);
            this.sendSegment$volatile = v2_1;
            this.receiveSegment$volatile = v2_1;
            if (this.v()) {
                v2_1 = ib.b.a;
                v2_1.getClass();
            }
            this.bufferEndSegment$volatile = v2_1;
            this._closeCause$volatile = ib.b.s;
            return;
        }
    }

    public static boolean A(Object p3)
    {
        if (!(p3 instanceof gb.f)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(p3, "Unexpected waiter: ");
            return 0;
        } else {
            String v0_1 = ((gb.f) p3).f(ga.p.a, 0);
            if (v0_1 == null) {
                return 0;
            } else {
                ((gb.f) p3).j(v0_1);
                return 1;
            }
        }
    }

    public static final ib.h a(kotlinx.coroutines.channels.a p11, long p12, ib.h p14)
    {
        do {
            Object v1 = lb.a.b(p14, p12, kotlinx.coroutines.channels.BufferedChannelKt$createSegmentFunction$1.g);
            if (!lb.a.e(v1)) {
                int v2_2 = lb.a.c(v1);
                while(true) {
                    boolean v3_2 = kotlinx.coroutines.channels.a.l;
                    long v4_1 = ((lb.p) v3_2.get(p11));
                    if (v4_1.c < v2_2.c) {
                    }
                    v2_2.d();
                }
            }
            boolean v3_1 = kotlinx.coroutines.channels.a.i;
            if (!lb.a.e(v1)) {
                ib.h v14_2 = ((ib.h) lb.a.c(v1));
                long v0_3 = v14_2.c;
                if (v0_3 <= p12) {
                    return v14_2;
                } else {
                    long v12_4 = (((long) ib.b.b) * v0_3);
                    while(true) {
                        long v6_2;
                        long v7_1 = kotlinx.coroutines.channels.a.h.get(p11);
                        long v4_4 = (1152921504606846975 & v7_1);
                        if (v4_4 >= v12_4) {
                            break;
                        }
                        v6_2 = p11;
                        if (!kotlinx.coroutines.channels.a.h.compareAndSet(p11, v7_1, ((((long) ((int) (v7_1 >> 60))) << 60) + v4_4))) {
                        }
                        if ((v0_3 * ((long) ib.b.b)) < v3_1.get(v6_2)) {
                            v14_2.a();
                        }
                    }
                    v6_2 = p11;
                }
            } else {
                p11.t();
                if ((p14.c * ((long) ib.b.b)) < v3_1.get(p11)) {
                    p14.a();
                    return 0;
                }
            }
            return 0;
        } while(v2_2.i());
        while (!v3_2.compareAndSet(p11, v4_1, v2_2)) {
            if (v3_2.get(p11) != v4_1) {
                if (v2_2.e()) {
                }
            }
        }
        if (v4_1.e()) {
            v4_1.d();
        }
    }

    public static final void d(kotlinx.coroutines.channels.a p0, Object p1, gb.h p2)
    {
        p2.resumeWith(new kotlin.Result$Failure(p0.p()));
        return;
    }

    public static final int e(kotlinx.coroutines.channels.a p4, ib.h p5, int p6, Object p7, long p8, Object p10, boolean p11)
    {
        p5.m(p6, p7);
        if (!p11) {
            boolean v0_1 = p5.k(p6);
            if (v0_1) {
                if ((v0_1 instanceof gb.n1)) {
                    p5.m(p6, 0);
                    if (!p4.z(v0_1, p7)) {
                        int v4_2 = ib.b.k;
                        if (p5.f.getAndSet(((p6 * 2) + 1), v4_2) != v4_2) {
                            p5.l(p6, 1);
                        }
                        return 5;
                    } else {
                        p5.n(p6, ib.b.i);
                        return 0;
                    }
                }
            } else {
                if (!p4.f(p8)) {
                    if (p10 != null) {
                        if (p5.j(p6, 0, p10)) {
                            return 2;
                        }
                    } else {
                        return 3;
                    }
                } else {
                    if (p5.j(p6, 0, ib.b.d)) {
                        return 1;
                    }
                }
            }
            return p4.C(p5, p6, p7, p8, p10, p11);
        } else {
            return p4.C(p5, p6, p7, p8, p10, p11);
        }
    }

    public static void r(kotlinx.coroutines.channels.a p7)
    {
        java.util.concurrent.atomic.AtomicLongFieldUpdater v0 = kotlinx.coroutines.channels.a.k;
        if ((v0.addAndGet(p7, 1) & 4611686018427387904) != 0) {
            while ((v0.get(p7) & 4611686018427387904) != 0) {
            }
        }
        return;
    }

    public final Object B(ib.h p9, int p10, long p11, Object p13)
    {
        java.util.concurrent.atomic.AtomicReferenceArray v0 = p9.f;
        gb.n1 v1_2 = p9.k(p10);
        java.util.concurrent.atomic.AtomicLongFieldUpdater v5 = kotlinx.coroutines.channels.a.h;
        if (v1_2 != null) {
            if ((v1_2 == ib.b.d) && (p9.j(p10, v1_2, ib.b.i))) {
                this.l();
                Object v11_2 = v0.get((p10 * 2));
                p9.m(p10, 0);
                return v11_2;
            }
        } else {
            if (p11 >= (v5.get(this) & 1152921504606846975)) {
                if (p13 != null) {
                    if (p9.j(p10, v1_2, p13)) {
                        this.l();
                        return ib.b.m;
                    }
                } else {
                    return ib.b.n;
                }
            }
        }
        do {
            gb.n1 v1_4 = p9.k(p10);
            if ((v1_4 != null) && (v1_4 != ib.b.e)) {
                if (v1_4 != ib.b.d) {
                    com.google.gson.internal.b v6_5 = ib.b.j;
                    if (v1_4 != v6_5) {
                        if (v1_4 != ib.b.h) {
                            if (v1_4 != ib.b.l) {
                            } else {
                                this.l();
                                return ib.b.o;
                            }
                        } else {
                            return ib.b.o;
                        }
                    } else {
                        return ib.b.o;
                    }
                } else {
                    if (p9.j(p10, v1_4, ib.b.i)) {
                        this.l();
                        Object v11_8 = v0.get((p10 * 2));
                        p9.m(p10, 0);
                        return v11_8;
                    }
                }
            } else {
                if (p11 >= (v5.get(this) & 1152921504606846975)) {
                    if (p13 != null) {
                        if (p9.j(p10, v1_4, p13)) {
                            this.l();
                            return ib.b.m;
                        }
                    } else {
                        return ib.b.n;
                    }
                } else {
                    if (p9.j(p10, v1_4, ib.b.h)) {
                        this.l();
                        return ib.b.o;
                    }
                }
            }
        } while((v1_4 == ib.b.g) || (!p9.j(p10, v1_4, ib.b.f)));
        Object v11_3 = (v1_4 instanceof ib.n);
        if (v11_3 != null) {
            v1_4 = ((ib.n) v1_4).a;
        }
        if (!kotlinx.coroutines.channels.a.A(v1_4)) {
            p9.n(p10, v6_5);
            p9.h();
            if (v11_3 != null) {
                this.l();
            }
            return ib.b.o;
        } else {
            p9.n(p10, ib.b.i);
            this.l();
            Object v11_6 = v0.get((p10 * 2));
            p9.m(p10, 0);
            return v11_6;
        }
    }

    public final int C(ib.h p6, int p7, Object p8, long p9, Object p11, boolean p12)
    {
        do {
            gb.n1 v0_0 = p6.k(p7);
            if (v0_0 != null) {
                if (v0_0 != ib.b.e) {
                    com.google.gson.internal.b v9_1 = ib.b.k;
                    if (v0_0 != v9_1) {
                        if (v0_0 != ib.b.h) {
                            if (v0_0 != ib.b.l) {
                                p6.m(p7, 0);
                                if ((v0_0 instanceof ib.n)) {
                                    v0_0 = ((ib.n) v0_0).a;
                                }
                                if (!this.z(v0_0, p8)) {
                                    if (p6.f.getAndSet(((p7 * 2) + 1), v9_1) != v9_1) {
                                        p6.l(p7, 1);
                                    }
                                    return 5;
                                } else {
                                    p6.n(p7, ib.b.i);
                                    return 0;
                                }
                            } else {
                                p6.m(p7, 0);
                                this.t();
                                return 4;
                            }
                        } else {
                            p6.m(p7, 0);
                            return 5;
                        }
                    } else {
                        p6.m(p7, 0);
                        return 5;
                    }
                } else {
                    if (p6.j(p7, v0_0, ib.b.d)) {
                    }
                }
            } else {
                if ((!this.f(p9)) || (p12)) {
                    if (!p12) {
                        if (p11 != 0) {
                        } else {
                            return 3;
                        }
                    } else {
                        if (p6.j(p7, 0, ib.b.j)) {
                            p6.h();
                            return 4;
                        }
                    }
                } else {
                    if (p6.j(p7, 0, ib.b.d)) {
                    }
                }
            }
            return 1;
        } while(!p6.j(p7, 0, p11));
        return 2;
    }

    public final void D(long p19)
    {
        kotlinx.coroutines.channels.a v1 = this;
        if (!this.v()) {
            while(true) {
                java.util.concurrent.atomic.AtomicLongFieldUpdater v6 = kotlinx.coroutines.channels.a.j;
                if (v6.get(v1) > p19) {
                    break;
                }
                v1 = this;
            }
            boolean v2_0 = 0;
            while(true) {
                long v3_0 = kotlinx.coroutines.channels.a.k;
                if (v2_0 >= ib.b.c) {
                    break;
                }
                long v4_6 = v6.get(v1);
                if ((v4_6 != (4611686018427387903 & v3_0.get(v1))) || (v4_6 != v6.get(v1))) {
                    v2_0++;
                }
            }
            long v0_1 = v3_0;
            while(true) {
                boolean v2_1 = v0_1.get(v1);
                if (v0_1.compareAndSet(v1, v2_1, ((v2_1 & 4611686018427387903) + 4611686018427387904))) {
                    break;
                }
                v1 = this;
            }
            while(true) {
                int v14_2;
                long v4_2 = v6.get(v1);
                boolean v2_4 = v0_1.get(v1);
                long v12 = (v2_4 & 4611686018427387903);
                if ((v2_4 & 4611686018427387904) == 0) {
                    v14_2 = 0;
                } else {
                    v14_2 = 1;
                }
                if ((v4_2 == v12) && (v4_2 == v6.get(v1))) {
                    break;
                }
                if (v14_2 != 0) {
                    v1 = this;
                } else {
                    v1 = this;
                    v0_1.compareAndSet(this, v2_4, (4611686018427387904 + v12));
                }
            }
            while(true) {
                boolean v2_5 = v0_1.get(v1);
                if (v0_1.compareAndSet(v1, v2_5, (v2_5 & 4611686018427387903))) {
                    break;
                }
                v1 = this;
            }
        }
        return;
    }

    public Object b(Object p24, ka.c p25)
    {
        String v1_0 = this;
        String v0_0 = kotlinx.coroutines.channels.a.l;
        int v2_5 = ((ib.h) v0_0.get(this));
        do {
            java.util.concurrent.atomic.AtomicLongFieldUpdater v9_1 = kotlinx.coroutines.channels.a.h;
            String v3_7 = v9_1.getAndIncrement(this);
            long v5_0 = (v3_7 & 1152921504606846975);
            long v8_4 = this.s(v3_7, 0);
            String v13_1 = ib.b.b;
            String v3_3 = ((long) v13_1);
            int v14_3 = (v5_0 / v3_3);
            String v3_5 = ((int) (v5_0 % v3_3));
            ga.p v10_1 = ga.p.a;
            if (v2_5.c == v14_3) {
                gb.h v7_1 = kotlinx.coroutines.channels.a.e(this, v2_5, v3_5, p24, v5_0, 0, v8_4);
                if (v7_1 == null) {
                    v2_5.a();
                    return v10_1;
                } else {
                    if (v7_1 != 1) {
                        if (v7_1 == 2) {
                            String v4 = this;
                            if (v8_4 != 0) {
                                v2_5.h();
                                String v0_13 = this.x(p24, p25);
                                if (v0_13 == kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
                                    return v0_13;
                                }
                            }
                        } else {
                            java.util.concurrent.atomic.AtomicLongFieldUpdater v15 = kotlinx.coroutines.channels.a.i;
                            if (v7_1 == 3) {
                                gb.h v7_3 = gb.w.m(a.a.n(p25));
                                String v4_1 = p24;
                                long v8_9 = kotlinx.coroutines.channels.a.e(this, v2_5, v3_5, p24, v5_0, v7_3, 0);
                                if (v8_9 == 0) {
                                    v2_5.a();
                                    v7_3.resumeWith(v10_1);
                                } else {
                                    if (v8_9 == 1) {
                                        v7_3.resumeWith(v10_1);
                                    } else {
                                        if (v8_9 == 2) {
                                            v7_3.b(v2_5, (v3_5 + v13_1));
                                        } else {
                                            String v4_0;
                                            String v3_2;
                                            if (v8_9 == 4) {
                                                v3_2 = p24;
                                                v4_0 = this;
                                                if (v5_0 < v15.get(this)) {
                                                    v2_5.a();
                                                }
                                            } else {
                                                String v13_2 = "unexpected";
                                                if (v8_9 != 5) {
                                                    throw new IllegalStateException("unexpected");
                                                } else {
                                                    v2_5.a();
                                                    String v0_7 = ((ib.h) v0_0.get(this));
                                                    while(true) {
                                                        String v0_1;
                                                        String v3_1;
                                                        int v2_0;
                                                        long v8_3;
                                                        int v2_7 = v9_1.getAndIncrement(v1_0);
                                                        long v5_1 = (v2_7 & 1152921504606846975);
                                                        int v2_8 = v1_0.s(v2_7, 0);
                                                        String v3_0 = ib.b.b;
                                                        java.util.concurrent.atomic.AtomicLongFieldUpdater v18 = v9_1;
                                                        long v8_0 = ((long) v3_0);
                                                        String v20 = v13_2;
                                                        long v12_1 = (v5_1 / v8_0);
                                                        long v8_2 = ((int) (v5_1 % v8_0));
                                                        java.util.concurrent.atomic.AtomicLongFieldUpdater v21 = v15;
                                                        if (v0_7.c == v12_1) {
                                                            v2_0 = v0_7;
                                                            v0_1 = v3_0;
                                                            v3_1 = v8_2;
                                                            v8_3 = v2_8;
                                                        } else {
                                                            long v12_3 = kotlinx.coroutines.channels.a.a(v1_0, v12_1, v0_7);
                                                            if (v12_3 != 0) {
                                                                v0_1 = v3_0;
                                                                v3_1 = v8_2;
                                                                v8_3 = v2_8;
                                                                v2_0 = v12_3;
                                                            } else {
                                                                if (v2_8 != 0) {
                                                                    break;
                                                                }
                                                                v9_1 = v18;
                                                                v13_2 = v20;
                                                                v15 = v21;
                                                                int v14 = 2;
                                                            }
                                                        }
                                                        String v13_0 = kotlinx.coroutines.channels.a.e(v1_0, v2_0, v3_1, v4_1, v5_1, v7_3, v8_3);
                                                        v4_0 = v1_0;
                                                        String v1_1 = v2_0;
                                                        v3_2 = v4_1;
                                                        if (v13_0 == null) {
                                                            v1_1.a();
                                                        } else {
                                                            if (v13_0 == 1) {
                                                            } else {
                                                                if (v13_0 == 2) {
                                                                    if (v8_3 == 0) {
                                                                        v7_3.b(v1_1, (v3_1 + v0_1));
                                                                        String v0_9 = v7_3.r();
                                                                        String v1_3 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
                                                                        if (v0_9 != v1_3) {
                                                                            v0_9 = v10_1;
                                                                        }
                                                                        if (v0_9 == v1_3) {
                                                                            return v0_9;
                                                                        }
                                                                        return v10_1;
                                                                    } else {
                                                                        v1_1.h();
                                                                    }
                                                                } else {
                                                                    if (v13_0 == 3) {
                                                                        throw new IllegalStateException(v20);
                                                                    } else {
                                                                        if (v13_0 == 4) {
                                                                            if (v5_1 < v21.get(v4_0)) {
                                                                                v1_1.a();
                                                                            }
                                                                        } else {
                                                                            if (v13_0 == 5) {
                                                                                v1_1.a();
                                                                            }
                                                                            v0_7 = v1_1;
                                                                            v1_0 = v4_0;
                                                                            v9_1 = v18;
                                                                            v13_2 = v20;
                                                                            v15 = v21;
                                                                            v4_1 = v3_2;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    kotlinx.coroutines.channels.a.d(v1_0, v4_1, v7_3);
                                                }
                                            }
                                            kotlinx.coroutines.channels.a.d(v4_0, v3_2, v7_3);
                                        }
                                    }
                                }
                            } else {
                                if (v7_1 == 4) {
                                    if (v5_0 < v15.get(this)) {
                                        v2_5.a();
                                    }
                                    String v0_11 = this.x(p24, p25);
                                    if (v0_11 == kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
                                        return v0_11;
                                    }
                                } else {
                                }
                            }
                        }
                    }
                }
            } else {
                String v4_3 = kotlinx.coroutines.channels.a.a(this, v14_3, v2_5);
                if (v4_3 != null) {
                    v2_5 = v4_3;
                } else {
                    if (v8_4 == 0) {
                        break;
                    }
                    String v0_12 = this.x(p24, p25);
                    if (v0_12 == kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
                        return v0_12;
                    }
                }
            }
            return v10_1;
        } while(v7_1 == 5);
    }

    public final Object c(ka.c p17)
    {
        kotlinx.coroutines.channels.a v1_0 = this;
        IllegalStateException v0_0 = kotlinx.coroutines.channels.a.m;
        Throwable v2_3 = ((ib.h) v0_0.get(this));
        do {
            java.util.concurrent.atomic.AtomicLongFieldUpdater v7 = kotlinx.coroutines.channels.a.h;
            int v8_0 = 1;
            if (v1_0.s(v7.get(v1_0), 1)) {
                throw this.o();
            } else {
                java.util.concurrent.atomic.AtomicLongFieldUpdater v9 = kotlinx.coroutines.channels.a.i;
                long v4_0 = v9.getAndIncrement(v1_0);
                com.google.gson.internal.b v10_0 = ((long) ib.b.b);
                String v12_0 = (v4_0 / v10_0);
                int v3_2 = ((int) (v4_0 % v10_0));
                if (v2_3.c != v12_0) {
                    gb.h v6_2 = v1_0.m(v12_0, v2_3);
                }
                gb.h v6_4 = v1_0.B(v2_3, v3_2, v4_0, 0);
                com.google.gson.internal.b v10_3 = ib.b.m;
                if (v6_4 == v10_3) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("unexpected");
                    return 0;
                } else {
                    long v13_0 = ib.b.o;
                    if (v6_4 != v13_0) {
                        if (v6_4 != ib.b.n) {
                            v2_3.a();
                            return v6_4;
                        } else {
                            gb.h v6_5 = gb.w.m(a.a.n(p17));
                            kotlinx.coroutines.channels.a v1_1 = this;
                            Object v14 = this.B(v2_3, v3_2, v4_0, v6_5);
                            if (v14 != v10_3) {
                                if (v14 != v13_0) {
                                    v2_3.a();
                                    v6_5.a(v14, 0);
                                } else {
                                    if (v4_0 < this.q()) {
                                        v2_3.a();
                                    }
                                    IllegalStateException v0_2 = ((ib.h) v0_0.get(this));
                                    while (!v1_1.s(v7.get(v1_1), v8_0)) {
                                        Throwable v2_10;
                                        long v4_1 = v9.getAndIncrement(v1_1);
                                        Throwable v2_7 = ((long) ib.b.b);
                                        long v13_2 = (v4_1 / v2_7);
                                        int v3_5 = ((int) (v4_1 % v2_7));
                                        java.util.concurrent.atomic.AtomicLongFieldUpdater v15 = v9;
                                        if (v0_2.c == v13_2) {
                                            v2_10 = v0_2;
                                        } else {
                                            v2_10 = v1_1.m(v13_2, v0_2);
                                            if (v2_10 == null) {
                                                v9 = v15;
                                                v8_0 = 1;
                                            }
                                        }
                                        IllegalStateException v0_8 = v1_1.B(v2_10, v3_5, v4_1, v6_5);
                                        if (v0_8 != ib.b.m) {
                                            if (v0_8 != ib.b.o) {
                                                if (v0_8 == ib.b.n) {
                                                    throw new IllegalStateException("unexpected");
                                                } else {
                                                    v2_10.a();
                                                    v6_5.a(v0_8, 0);
                                                }
                                            } else {
                                                if (v4_1 < this.q()) {
                                                    v2_10.a();
                                                }
                                                v8_0 = 1;
                                                v1_1 = this;
                                                v0_2 = v2_10;
                                                v9 = v15;
                                            }
                                        } else {
                                            v6_5.b(v2_10, v3_5);
                                        }
                                    }
                                    v6_5.resumeWith(new kotlin.Result$Failure(v1_1.o()));
                                }
                            } else {
                                v6_5.b(v2_3, v3_2);
                            }
                            return v6_5.r();
                        }
                    } else {
                        if (v4_0 < this.q()) {
                            v2_3.a();
                        }
                        v1_0 = this;
                        break;
                    }
                }
            }
        } while(v6_2 != null);
    }

    public final boolean f(long p5)
    {
        if ((p5 >= kotlinx.coroutines.channels.a.j.get(this)) && (p5 >= (kotlinx.coroutines.channels.a.i.get(this) + ((long) this.g)))) {
            return 0;
        } else {
            return 1;
        }
    }

    public Object g(Object p16)
    {
        Throwable v1_1;
        java.util.concurrent.atomic.AtomicLongFieldUpdater v8 = kotlinx.coroutines.channels.a.h;
        Throwable v1_4 = v8.get(this);
        int v9_0 = 0;
        long v11_1 = 1152921504606846975;
        if (!this.s(v1_4, 0)) {
            v1_1 = (this.f((v1_4 & 1152921504606846975)) ^ 1);
        } else {
            v1_1 = 0;
        }
        ib.f v13 = ib.g.b;
        if (v1_1 == null) {
            int v6_0 = ib.b.j;
            Throwable v1_5 = ((ib.h) kotlinx.coroutines.channels.a.l.get(this));
            while(true) {
                int v2_0 = v8.getAndIncrement(this);
                long v4 = (v2_0 & v11_1);
                boolean v7 = this.s(v2_0, v9_0);
                int v14 = ib.b.b;
                int v2_1 = ((long) v14);
                long v11_0 = (v4 / v2_1);
                int v2_3 = ((int) (v4 % v2_1));
                if (v1_5.c == v11_0) {
                    int v9_2 = kotlinx.coroutines.channels.a.e(this, v1_5, v2_3, p16, v4, v6_0, v7);
                    boolean v3_3 = ga.p.a;
                    if (v9_2 == 0) {
                        break;
                    }
                    if (v9_2 == 1) {
                        return v3_3;
                    } else {
                        if (v9_2 == 2) {
                            if (!v7) {
                                int v6_1;
                                if (!(v6_0 instanceof gb.n1)) {
                                    v6_1 = 0;
                                } else {
                                    v6_1 = ((gb.n1) v6_0);
                                }
                                if (v6_1 != 0) {
                                    v6_1.b(v1_5, (v2_3 + v14));
                                }
                                v1_5.h();
                                return v13;
                            } else {
                                v1_5.h();
                                return new ib.e(this.p());
                            }
                        } else {
                            if (v9_2 == 3) {
                                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("unexpected");
                                return 0;
                            } else {
                                if (v9_2 == 4) {
                                    if (v4 < kotlinx.coroutines.channels.a.i.get(this)) {
                                        v1_5.a();
                                    }
                                    return new ib.e(this.p());
                                } else {
                                    if (v9_2 == 5) {
                                        v1_5.a();
                                    }
                                    v9_0 = 0;
                                }
                            }
                        }
                    }
                } else {
                    boolean v3_1 = kotlinx.coroutines.channels.a.a(this, v11_0, v1_5);
                    if (v3_1) {
                        v1_5 = v3_1;
                    } else {
                        if (!v7) {
                            v9_0 = 0;
                        } else {
                            return new ib.e(this.p());
                        }
                    }
                }
                v11_1 = 1152921504606846975;
            }
            v1_5.a();
            return v3_3;
        } else {
            return v13;
        }
    }

    public final void h(java.util.concurrent.CancellationException p2)
    {
        if (p2 == null) {
            p2 = new java.util.concurrent.CancellationException("Channel was cancelled");
        }
        this.i(1, p2);
        return;
    }

    public final boolean i(boolean p13, Throwable p14)
    {
        kotlinx.coroutines.channels.a v4_0;
        java.util.concurrent.atomic.AtomicLongFieldUpdater v3 = kotlinx.coroutines.channels.a.h;
        if (p13 == null) {
            v4_0 = this;
        } else {
            do {
                long v5_4 = v3.get(this);
                if (((int) (v5_4 >> 60)) != 0) {
                } else {
                    v4_0 = this;
                }
            } while(!v3.compareAndSet(this, v5_4, ((v5_4 & 1152921504606846975) + (((long) 1) << 60))));
        }
        long v5_1 = ib.b.s;
        do {
            int v10_2;
            Object v6_0 = kotlinx.coroutines.channels.a.o;
            if (!v6_0.compareAndSet(this, v5_1, p14)) {
            } else {
                v10_2 = 1;
            }
            if (p13 == null) {
                do {
                    long v7_4;
                    Throwable v13_3;
                    long v5_2 = v3.get(this);
                    Throwable v13_2 = ((int) (v5_2 >> 60));
                    if (v13_2 == null) {
                        v13_3 = (v5_2 & 1152921504606846975);
                        v7_4 = ((long) 2);
                    } else {
                        if (v13_2 != 1) {
                            break;
                        }
                        v13_3 = (v5_2 & 1152921504606846975);
                        v7_4 = ((long) 3);
                    }
                } while(!v3.compareAndSet(v4_0, v5_2, ((v7_4 << 60) + v13_3)));
            } else {
                do {
                    long v5_3 = v3.get(this);
                } while(!v3.compareAndSet(v4_0, v5_3, ((((long) 3) << 60) + (v5_3 & 1152921504606846975))));
            }
            this.t();
            if (v10_2 != 0) {
                do {
                    com.google.gson.internal.b v0_1;
                    Throwable v13_7 = kotlinx.coroutines.channels.a.p;
                    ua.l v14_2 = v13_7.get(this);
                    if (v14_2 != null) {
                        v0_1 = ib.b.r;
                    } else {
                        v0_1 = ib.b.q;
                    }
                    while (!v13_7.compareAndSet(this, v14_2, v0_1)) {
                        if (v13_7.get(this) != v14_2) {
                        }
                    }
                } while(v14_2 != null);
                kotlin.jvm.internal.j.c(1, v14_2);
                ((ua.l) v14_2).invoke(this.n());
                return v10_2;
            }
            return v10_2;
        } while(v6_0.get(this) == v5_1);
        v10_2 = 0;
    }

    public final ib.h j(long p13)
    {
        boolean v0_1 = kotlinx.coroutines.channels.a.n.get(this);
        long v1_10 = ((ib.h) kotlinx.coroutines.channels.a.l.get(this));
        if (v1_10.c > ((ib.h) v0_1).c) {
            v0_1 = v1_10;
        }
        long v1_2 = ((ib.h) kotlinx.coroutines.channels.a.m.get(this));
        if (v1_2.c > ((ib.h) v0_1).c) {
            v0_1 = v1_2;
        }
        boolean v0_2 = ((lb.b) v0_1);
        do {
            v0_2.getClass();
            long v1_3 = lb.b.a;
            Object v2_3 = v1_3.get(v0_2);
            int v3_0 = lb.a.a;
            Object v4_3 = 0;
            if (v2_3 != v3_0) {
                Object v2_4 = ((lb.b) v2_3);
                if (v2_4 != null) {
                    v0_2 = v2_4;
                    break;
                }
                while (!v1_3.compareAndSet(v0_2, 0, v3_0)) {
                }
            }
            boolean v0_3 = ((ib.h) v0_2);
            if (this.u()) {
                long v1_6 = v0_3;
                while(true) {
                    int v5_2 = (ib.b.b - 1);
                    long v8_3;
                    if (-1 >= v5_2) {
                        v1_6 = ((ib.h) ((lb.b) lb.b.b.get(v1_6)));
                        if (v1_6 == 0) {
                            v8_3 = -1;
                        }
                    } else {
                        v8_3 = ((v1_6.c * ((long) ib.b.b)) + ((long) v5_2));
                        if (v8_3 < kotlinx.coroutines.channels.a.i.get(this)) {
                        }
                        do {
                            boolean v10_6 = v1_6.k(v5_2);
                            if ((v10_6) && (v10_6 != ib.b.e)) {
                                if (v10_6 == ib.b.d) {
                                    if (v8_3 != -1) {
                                        this.k(v8_3);
                                    }
                                    long v1_12 = v0_3;
                                    while (v1_12 != 0) {
                                        int v5_0 = (ib.b.b - 1);
                                        while (-1 < v5_0) {
                                            if (((v1_12.c * ((long) ib.b.b)) + ((long) v5_0)) < p13) {
                                                if (v4_3 != null) {
                                                    if ((v4_3 instanceof java.util.ArrayList)) {
                                                        Object v4_1 = ((java.util.ArrayList) v4_3);
                                                        int v13_3 = (v4_1.size() - 1);
                                                        while (-1 < v13_3) {
                                                            this.y(((gb.n1) v4_1.get(v13_3)), 1);
                                                            v13_3--;
                                                        }
                                                    } else {
                                                        this.y(((gb.n1) v4_3), 1);
                                                        return v0_3;
                                                    }
                                                }
                                                return v0_3;
                                            }
                                            do {
                                                gb.n1 v6_3 = v1_12.k(v5_0);
                                                if ((v6_3 != null) && (v6_3 != ib.b.e)) {
                                                    if (!(v6_3 instanceof ib.n)) {
                                                        if ((v6_3 instanceof gb.n1)) {
                                                        }
                                                    } else {
                                                        if (v1_12.j(v5_0, v6_3, ib.b.l)) {
                                                            v4_3 = lb.a.f(v4_3, ((ib.n) v6_3).a);
                                                            v1_12.l(v5_0, 1);
                                                        }
                                                    }
                                                } else {
                                                    if (v1_12.j(v5_0, v6_3, ib.b.l)) {
                                                        v1_12.h();
                                                    }
                                                }
                                                v5_0--;
                                            } while(!v1_12.j(v5_0, v6_3, ib.b.l));
                                            v4_3 = lb.a.f(v4_3, v6_3);
                                            v1_12.l(v5_0, 1);
                                        }
                                        v1_12 = ((ib.h) ((lb.b) lb.b.b.get(v1_12)));
                                    }
                                }
                            } else {
                            }
                            v5_2--;
                            while (-1 < v5_2) {
                            }
                        } while(!v1_6.j(v5_2, v10_6, ib.b.l));
                        v1_6.h();
                    }
                }
            }
        } while(v1_3.get(v0_2) == null);
    }

    public final void k(long p10)
    {
        ib.h v0_2 = ((ib.h) kotlinx.coroutines.channels.a.m.get(this));
        do {
            com.google.gson.internal.b v1_3 = kotlinx.coroutines.channels.a.i;
            ib.h v3_1 = v1_3.get(this);
            if (p10 >= Math.max((((long) this.g) + v3_1), kotlinx.coroutines.channels.a.j.get(this))) {
                if (!v1_3.compareAndSet(this, v3_1, (1 + v3_1))) {
                    break;
                }
                long v5_3 = ((long) ib.b.b);
                int v7_1 = (v3_1 / v5_3);
                com.google.gson.internal.b v1_2 = ((int) (v3_1 % v5_3));
                if (v0_2.c != v7_1) {
                    long v5_7 = this.m(v7_1, v0_2);
                }
                long v5_8 = v3_1;
                ib.h v3_0 = v0_2;
                if (this.B(v3_0, v1_2, v5_8, 0) != ib.b.o) {
                    v3_0.a();
                } else {
                    if (v5_8 < this.q()) {
                        v3_0.a();
                    }
                }
                v0_2 = v3_0;
                break;
            } else {
                return;
            }
        } while(v5_7 != 0);
    }

    public final void l()
    {
        if (!this.v()) {
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater v6 = kotlinx.coroutines.channels.a.n;
            boolean v7 = ((ib.h) v6.get(this));
            while(true) {
                long v8 = kotlinx.coroutines.channels.a.j.getAndIncrement(this);
                long v2_2 = (v8 / ((long) ib.b.b));
                if (this.q() <= v8) {
                    break;
                }
                if (v7.c != v2_2) {
                    do {
                        long v4_4 = lb.a.b(v7, v2_2, kotlinx.coroutines.channels.BufferedChannelKt$createSegmentFunction$1.g);
                        if (!lb.a.e(v4_4)) {
                            gb.n1 v5_3 = lb.a.c(v4_4);
                            while(true) {
                                boolean v10_3 = ((lb.p) v6.get(this));
                                if (v10_3.c < v5_3.c) {
                                }
                                v5_3.d();
                            }
                        }
                        boolean v10_5 = 0;
                        if (!lb.a.e(v4_4)) {
                            String v0_12 = ((ib.h) lb.a.c(v4_4));
                            long v4_5 = v0_12.c;
                            if (v4_5 <= v2_2) {
                                v10_5 = v0_12;
                            } else {
                                long v4_6 = (v4_5 * ((long) ib.b.b));
                                if (!kotlinx.coroutines.channels.a.j.compareAndSet(this, (1 + v8), v4_6)) {
                                    kotlinx.coroutines.channels.a.r(this);
                                } else {
                                    String v0_17 = kotlinx.coroutines.channels.a.k;
                                    if ((v0_17.addAndGet(this, (v4_6 - v8)) & 4611686018427387904) == 0) {
                                        if (v10_5) {
                                            v7 = v10_5;
                                        }
                                        String v0_20 = ((int) (v8 % ((long) ib.b.b)));
                                        long v2_22 = v7.k(v0_20);
                                        long v4_0 = kotlinx.coroutines.channels.a.i;
                                        if ((!(v2_22 instanceof gb.n1)) || ((v8 < v4_0.get(this)) || (!v7.j(v0_20, v2_22, ib.b.g)))) {
                                            do {
                                                long v2_0 = v7.k(v0_20);
                                                if (!(v2_0 instanceof gb.n1)) {
                                                    if (v2_0 != ib.b.j) {
                                                        if (v2_0 != 0) {
                                                            if ((v2_0 != ib.b.d) && ((v2_0 != ib.b.h) && ((v2_0 != ib.b.i) && ((v2_0 != ib.b.k) && (v2_0 != ib.b.l))))) {
                                                            }
                                                        } else {
                                                            if (v7.j(v0_20, v2_0, ib.b.e)) {
                                                            }
                                                        }
                                                    } else {
                                                        kotlinx.coroutines.channels.a.r(this);
                                                    }
                                                } else {
                                                    if (v8 >= v4_0.get(this)) {
                                                        if (v7.j(v0_20, v2_0, ib.b.g)) {
                                                            if (!kotlinx.coroutines.channels.a.A(v2_0)) {
                                                                v7.n(v0_20, ib.b.j);
                                                                v7.h();
                                                            } else {
                                                                v7.n(v0_20, ib.b.d);
                                                            }
                                                        }
                                                    } else {
                                                        if (v7.j(v0_20, v2_0, new ib.n(((gb.n1) v2_0)))) {
                                                        }
                                                    }
                                                }
                                            } while(v2_0 != ib.b.f);
                                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(v2_0, "Unexpected cell state: ");
                                            return;
                                        } else {
                                            if (!kotlinx.coroutines.channels.a.A(v2_22)) {
                                                v7.n(v0_20, ib.b.j);
                                                v7.h();
                                            } else {
                                                v7.n(v0_20, ib.b.d);
                                            }
                                        }
                                        kotlinx.coroutines.channels.a.r(this);
                                        return;
                                    }
                                    while ((v0_17.get(this) & 4611686018427387904) != 0) {
                                    }
                                }
                            }
                        } else {
                            this.t();
                            this.w(v2_2, v7);
                            kotlinx.coroutines.channels.a.r(this);
                        }
                    } while(v5_3.i());
                    while (!v6.compareAndSet(this, v10_3, v5_3)) {
                        if (v6.get(this) != v10_3) {
                            if (v5_3.e()) {
                            }
                        }
                    }
                    if (v10_3.e()) {
                        v10_3.d();
                    }
                }
            }
            if ((v7.c < v2_2) && (v7.b() != null)) {
                this.w(v2_2, v7);
            }
            kotlinx.coroutines.channels.a.r(this);
            return;
        } else {
            return;
        }
    }

    public final ib.h m(long p10, ib.h p12)
    {
        do {
            Object v1 = lb.a.b(p12, p10, kotlinx.coroutines.channels.BufferedChannelKt$createSegmentFunction$1.g);
            if (!lb.a.e(v1)) {
                int v2_2 = lb.a.c(v1);
                do {
                    boolean v3_10 = kotlinx.coroutines.channels.a.m;
                    kotlinx.coroutines.channels.a v4_1 = ((lb.p) v3_10.get(this));
                    if (v4_1.c < v2_2.c) {
                        if (!v2_2.i()) {
                        }
                        while (!v3_10.compareAndSet(this, v4_1, v2_2)) {
                            if (v3_10.get(this) != v4_1) {
                            }
                        }
                        if (v4_1.e()) {
                            v4_1.d();
                        }
                    }
                } while(!v2_2.e());
                v2_2.d();
            }
            if (!lb.a.e(v1)) {
                ib.h v12_2 = ((ib.h) lb.a.c(v1));
                long v0_6 = v12_2.c;
                if ((!this.v()) && (p10 <= (kotlinx.coroutines.channels.a.j.get(this) / ((long) ib.b.b)))) {
                    while(true) {
                        boolean v3_6 = kotlinx.coroutines.channels.a.n;
                        kotlinx.coroutines.channels.a v4_3 = ((lb.p) v3_6.get(this));
                        if ((v4_3.c >= v0_6) || (!v12_2.i())) {
                            if (v0_6 <= p10) {
                                return v12_2;
                            } else {
                                long v7_1 = (v0_6 * ((long) ib.b.b));
                                do {
                                    Object v5_12 = kotlinx.coroutines.channels.a.i.get(this);
                                } while((v5_12 < v7_1) && (!kotlinx.coroutines.channels.a.i.compareAndSet(this, v5_12, v7_1)));
                                if ((v0_6 * ((long) ib.b.b)) < this.q()) {
                                    v12_2.a();
                                }
                            }
                            return 0;
                        }
                        while (!v3_6.compareAndSet(this, v4_3, v12_2)) {
                            if (v3_6.get(this) != v4_3) {
                                if (v12_2.e()) {
                                    v12_2.d();
                                }
                            }
                        }
                        if (v4_3.e()) {
                            v4_3.d();
                        }
                    }
                }
            } else {
                this.t();
                if ((p12.c * ((long) ib.b.b)) < this.q()) {
                    p12.a();
                    return 0;
                }
            }
            return 0;
        } while(!v2_2.i());
    }

    public final Throwable n()
    {
        return ((Throwable) kotlinx.coroutines.channels.a.o.get(this));
    }

    public final Throwable o()
    {
        kotlinx.coroutines.channels.ClosedReceiveChannelException v0_0 = this.n();
        if (v0_0 == null) {
            v0_0 = new kotlinx.coroutines.channels.ClosedReceiveChannelException("Channel was closed");
        }
        return v0_0;
    }

    public final Throwable p()
    {
        kotlinx.coroutines.channels.ClosedSendChannelException v0_0 = this.n();
        if (v0_0 == null) {
            v0_0 = new kotlinx.coroutines.channels.ClosedSendChannelException("Channel was closed");
        }
        return v0_0;
    }

    public final long q()
    {
        return (kotlinx.coroutines.channels.a.h.get(this) & 1152921504606846975);
    }

    public final boolean s(long p14, boolean p16)
    {
        long v0_6 = ((int) (p14 >> 60));
        if ((v0_6 != 0) && (v0_6 != 1)) {
            java.util.concurrent.atomic.AtomicLongFieldUpdater v4 = kotlinx.coroutines.channels.a.i;
            if (v0_6 == 2) {
                this.j((1152921504606846975 & p14));
                if (!p16) {
                    return 1;
                }
                while(true) {
                    long v0_2 = kotlinx.coroutines.channels.a.m;
                    gb.n1 v3_3 = ((ib.h) v0_2.get(this));
                    int v7_0 = v4.get(this);
                    if (this.q() > v7_0) {
                        Object v5_7 = ((long) ib.b.b);
                        long v9_0 = (v7_0 / v5_7);
                        if (v3_3.c != v9_0) {
                            v3_3 = this.m(v9_0, v3_3);
                            if (v3_3 == null) {
                                break;
                            }
                        }
                        v3_3.a();
                        long v0_7 = ((int) (v7_0 % v5_7));
                        do {
                            Object v5_9 = v3_3.k(v0_7);
                            if ((v5_9 != null) && (v5_9 != ib.b.e)) {
                                if ((v5_9 == ib.b.d) || ((v5_9 != ib.b.j) && ((v5_9 != ib.b.l) && ((v5_9 != ib.b.i) && ((v5_9 != ib.b.h) && ((v5_9 == ib.b.g) || ((v5_9 != ib.b.f) && (v7_0 == v4.get(this))))))))) {
                                    return 0;
                                }
                            } else {
                            }
                            kotlinx.coroutines.channels.a.i.compareAndSet(this, v7_0, (v7_0 + 1));
                        } while(!v3_3.j(v0_7, v5_9, ib.b.h));
                        this.l();
                    }
                }
                if (((ib.h) v0_2.get(this)).c < v9_0) {
                    return 1;
                }
            } else {
                if (v0_6 != 3) {
                    throw new IllegalStateException(r1.a.g(v0_6, "unexpected close status: ").toString());
                } else {
                    long v0_21 = this.j((1152921504606846975 & p14));
                    Object v5_1 = 0;
                    while(true) {
                        int v6_0 = (ib.b.b - 1);
                        if (-1 >= v6_0) {
                            break;
                        }
                        long v8_2 = ((v0_21.c * ((long) ib.b.b)) + ((long) v6_0));
                        do {
                            boolean v10_3 = v0_21.k(v6_0);
                            if (v10_3 != ib.b.i) {
                                if (v10_3 != ib.b.d) {
                                    if ((v10_3 != ib.b.e) && (v10_3)) {
                                        if ((!(v10_3 instanceof gb.n1)) && (!(v10_3 instanceof ib.n))) {
                                            gb.n1 v11_5 = ib.b.g;
                                            if ((v10_3 != v11_5) && (v10_3 != ib.b.f)) {
                                                if (v10_3 != v11_5) {
                                                }
                                            } else {
                                                if (v5_1 == null) {
                                                    return 1;
                                                } else {
                                                    if ((v5_1 instanceof java.util.ArrayList)) {
                                                        Object v5_2 = ((java.util.ArrayList) v5_1);
                                                        long v0_5 = (v5_2.size() - 1);
                                                        while (-1 < v0_5) {
                                                            this.y(((gb.n1) v5_2.get(v0_5)), 0);
                                                            v0_5--;
                                                        }
                                                        return 1;
                                                    } else {
                                                        this.y(((gb.n1) v5_1), 0);
                                                        return 1;
                                                    }
                                                }
                                            }
                                        } else {
                                            if (v8_2 < v4.get(this)) {
                                            } else {
                                                gb.n1 v11_10;
                                                if (!(v10_3 instanceof ib.n)) {
                                                    v11_10 = ((gb.n1) v10_3);
                                                } else {
                                                    v11_10 = ((ib.n) v10_3).a;
                                                }
                                            }
                                        }
                                    } else {
                                        if (v0_21.j(v6_0, v10_3, ib.b.l)) {
                                            v0_21.h();
                                        }
                                    }
                                } else {
                                    if (v8_2 < v4.get(this)) {
                                    } else {
                                        if (v0_21.j(v6_0, v10_3, ib.b.l)) {
                                            v0_21.m(v6_0, 0);
                                            v0_21.h();
                                        }
                                    }
                                }
                                v6_0--;
                                while (-1 < v6_0) {
                                }
                                v0_21 = ((ib.h) ((lb.b) lb.b.b.get(v0_21)));
                                if (v0_21 == 0) {
                                }
                            }
                        } while(!v0_21.j(v6_0, v10_3, ib.b.l));
                        v5_1 = lb.a.f(v5_1, v11_10);
                        v0_21.m(v6_0, 0);
                        v0_21.h();
                    }
                }
            }
            return 1;
        }
        return 0;
    }

    public final boolean t()
    {
        return this.s(kotlinx.coroutines.channels.a.h.get(this), 0);
    }

    public final String toString()
    {
        String v1_4 = new StringBuilder();
        String v2_22 = ((int) (kotlinx.coroutines.channels.a.h.get(this) >> 60));
        if (v2_22 == 2) {
            v1_4.append("closed,");
        } else {
            if (v2_22 == 3) {
                v1_4.append("cancelled,");
            }
        }
        String v2_12 = new StringBuilder("capacity=");
        v2_12.append(this.g);
        v2_12.append(44);
        v1_4.append(v2_12.toString());
        v1_4.append("data=[");
        String v2_15 = new ib.h[3];
        int v6_7 = 0;
        v2_15[0] = kotlinx.coroutines.channels.a.m.get(this);
        String v7_23 = 1;
        v2_15[1] = kotlinx.coroutines.channels.a.l.get(this);
        v2_15[2] = kotlinx.coroutines.channels.a.n.get(this);
        String v2_17 = ha.k.u(v2_15);
        ib.h v3_7 = new java.util.ArrayList();
        String v2_18 = v2_17.iterator();
        while (v2_18.hasNext()) {
            int v4_2 = v2_18.next();
            if (((ib.h) v4_2) != ib.b.a) {
                v3_7.add(v4_2);
            }
        }
        String v2_20 = v3_7.iterator();
        if (!v2_20.hasNext()) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.c();
            return 0;
        } else {
            ib.h v3_9 = v2_20.next();
            if (v2_20.hasNext()) {
                StringBuilder v8_8 = ((ib.h) v3_9).c;
                do {
                    int v4_8 = v2_20.next();
                    long v10_2 = ((ib.h) v4_8).c;
                    if (v8_8 > v10_2) {
                        v3_9 = v4_8;
                        v8_8 = v10_2;
                    }
                } while(v2_20.hasNext());
            }
            ib.h v3_10 = ((ib.h) v3_9);
            long v10_3 = kotlinx.coroutines.channels.a.i.get(this);
            long v12_1 = this.q();
            while(true) {
                int v4_1 = v6_7;
                if (v4_1 < ib.b.b) {
                    break;
                }
                v3_10 = ((ib.h) v3_10.b());
                if (v3_10 != null) {
                    v6_7 = 0;
                }
                if (v1_4.length() == 0) {
                    throw new java.util.NoSuchElementException("Char sequence is empty.");
                } else {
                    if (v1_4.charAt((v1_4.length() - 1)) == 44) {
                        v1_4.deleteCharAt((v1_4.length() - 1)).getClass();
                    }
                    v1_4.append("]");
                    return v1_4.toString();
                }
            }
            StringBuilder v8_1 = ((v3_10.c * ((long) ib.b.b)) + ((long) v4_1));
            long v14_2 = v8_1 cmp v12_1;
            if ((v14_2 < 0) || (v8_1 < v10_3)) {
                String v7_19;
                Object v15_1 = v3_10.k(v4_1);
                int v16_0 = v7_23;
                int v6_1 = v3_10.f.get((v4_1 * 2));
                if (!(v15_1 instanceof gb.f)) {
                    if (!(v15_1 instanceof ib.n)) {
                        if ((!kotlin.jvm.internal.f.a(v15_1, ib.b.f)) && (!kotlin.jvm.internal.f.a(v15_1, ib.b.g))) {
                            if ((v15_1 != null) && ((!v15_1.equals(ib.b.e)) && ((!v15_1.equals(ib.b.i)) && ((!v15_1.equals(ib.b.h)) && ((!v15_1.equals(ib.b.k)) && ((!v15_1.equals(ib.b.j)) && (!v15_1.equals(ib.b.l)))))))) {
                                v7_19 = v15_1.toString();
                                if (v6_1 == 0) {
                                    int v6_3 = new StringBuilder();
                                    v6_3.append(v7_19);
                                    v6_3.append(44);
                                    v1_4.append(v6_3.toString());
                                } else {
                                    StringBuilder v8_5 = new StringBuilder("(");
                                    v8_5.append(v7_19);
                                    v8_5.append(44);
                                    v8_5.append(v6_1);
                                    v8_5.append("),");
                                    v1_4.append(v8_5.toString());
                                }
                            }
                        } else {
                            v7_19 = "resuming_sender";
                        }
                    } else {
                        String v7_21 = new StringBuilder("EB(");
                        v7_21.append(v15_1);
                        v7_21.append(41);
                        v7_19 = v7_21.toString();
                    }
                } else {
                    String v7_22 = v8_1 cmp v10_3;
                    if ((v7_22 >= null) || (v14_2 < 0)) {
                        if ((v14_2 >= 0) || (v7_22 < null)) {
                            v7_19 = "cont";
                        } else {
                            v7_19 = "send";
                        }
                    } else {
                        v7_19 = "receive";
                    }
                }
                v4_1++;
                v7_23 = v16_0;
                while (v4_1 >= ib.b.b) {
                }
            }
        }
    }

    public boolean u()
    {
        return 0;
    }

    public final boolean v()
    {
        int v0_2 = kotlinx.coroutines.channels.a.j.get(this);
        if ((v0_2 != 0) && (v0_2 != 9223372036854775807)) {
            return 0;
        } else {
            return 1;
        }
    }

    public final void w(long p5, ib.h p7)
    {
        while (p7.c < p5) {
            Object v0_8 = ((ib.h) p7.b());
            if (v0_8 == null) {
                break;
            }
            p7 = v0_8;
        }
        do {
            if (p7.c()) {
                boolean v5_2 = ((ib.h) p7.b());
                if (v5_2) {
                    p7 = v5_2;
                }
            }
            do {
                boolean v5_3 = kotlinx.coroutines.channels.a.n;
                lb.p v6_1 = ((lb.p) v5_3.get(this));
                if (v6_1.c < p7.c) {
                    if (!p7.i()) {
                    }
                    while (!v5_3.compareAndSet(this, v6_1, p7)) {
                        if (v5_3.get(this) != v6_1) {
                        }
                    }
                    if (v6_1.e()) {
                        v6_1.d();
                    }
                }
                return;
            } while(!p7.e());
            p7.d();
        } while(v6_1.c < p7.c);
    }

    public final Object x(Object p2, ka.c p3)
    {
        ga.p v2_3 = new gb.h(1, a.a.n(p3));
        v2_3.s();
        v2_3.resumeWith(new kotlin.Result$Failure(this.p()));
        ga.p v2_1 = v2_3.r();
        if (v2_1 != kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
            return ga.p.a;
        } else {
            return v2_1;
        }
    }

    public final void y(gb.n1 p2, boolean p3)
    {
        if (!(p2 instanceof gb.f)) {
            if (!(p2 instanceof ib.a)) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(p2, "Unexpected waiter: ");
                return;
            } else {
                String v3_4 = ((ib.a) p2).h;
                v3_4.getClass();
                ((ib.a) p2).h = 0;
                ((ib.a) p2).g = ib.b.l;
                Boolean v2_2 = ((ib.a) p2).i.n();
                if (v2_2 != null) {
                    v3_4.resumeWith(new kotlin.Result$Failure(v2_2));
                    return;
                } else {
                    v3_4.resumeWith(Boolean.FALSE);
                    return;
                }
            }
        } else {
            String v3_2;
            if (p3 == null) {
                v3_2 = this.p();
            } else {
                v3_2 = this.o();
            }
            ((ka.c) p2).resumeWith(new kotlin.Result$Failure(v3_2));
            return;
        }
    }

    public final boolean z(Object p5, Object p6)
    {
        if (!(p5 instanceof ib.a)) {
            if (!(p5 instanceof gb.f)) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(p5, "Unexpected receiver type: ");
                return 0;
            } else {
                String v6_1 = ((gb.f) p5).f(p6, 0);
                if (v6_1 == null) {
                    return 0;
                } else {
                    ((gb.f) p5).j(v6_1);
                    return 1;
                }
            }
        } else {
            ib.h v0_1 = ((ib.a) p5).h;
            v0_1.getClass();
            ((ib.a) p5).h = 0;
            ((ib.a) p5).g = p6;
            gb.f v5_4 = v0_1.f(Boolean.TRUE, 0);
            if (v5_4 == null) {
                return 0;
            } else {
                v0_1.j(v5_4);
                return 1;
            }
        }
    }
}
