// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow;
public final class f extends kb.a implements jb.i, jb.b, kb.f {
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater k;
    private volatile synthetic Object _state$volatile;
    public int j;

    static f()
    {
        kotlinx.coroutines.flow.f.k = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.flow.f, Object, "_state$volatile");
        return;
    }

    public f(Object p1)
    {
        this._state$volatile = p1;
        return;
    }

    public final kb.c b()
    {
        return new jb.p();
    }

    public final kb.c[] c()
    {
        jb.p[] v0_1 = new jb.p[2];
        return v0_1;
    }

    public final Object collect(jb.c p18, ka.c p19)
    {
        kotlinx.coroutines.flow.StateFlowImpl$collect$1 v1_1;
        kotlinx.coroutines.flow.f v2_0;
        if (!(p19 instanceof kotlinx.coroutines.flow.StateFlowImpl$collect$1)) {
            v2_0 = this;
            v1_1 = new kotlinx.coroutines.flow.StateFlowImpl$collect$1(this, p19);
        } else {
            v1_1 = ((kotlinx.coroutines.flow.StateFlowImpl$collect$1) p19);
            kotlinx.coroutines.flow.f v2_2 = ((kotlinx.coroutines.flow.StateFlowImpl$collect$1) p19).n;
            if ((v2_2 & -2147483648) == 0) {
            } else {
                ((kotlinx.coroutines.flow.StateFlowImpl$collect$1) p19).n = (v2_2 - -2147483648);
                v2_0 = this;
            }
        }
        kotlinx.coroutines.flow.f v12;
        Object v4_3;
        jb.p v10;
        Object v4_2;
        gb.a1 v9_1;
        Object v0_8;
        jb.c v11;
        Object v0_2 = v1_1.l;
        kotlin.coroutines.intrinsics.CoroutineSingletons v3_0 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        Object v4_1 = v1_1.n;
        try {
            if (v4_1 == null) {
                kotlin.b.b(v0_2);
                v4_2 = p18;
                v10 = ((jb.p) v2_0.a());
                v12 = v2_0;
                v9_1 = ((gb.u0) v1_1.getContext().Z(gb.t.h));
                v11 = v4_2;
                v0_8 = 0;
                v4_3 = kotlinx.coroutines.flow.f.k.get(v12);
                if (v9_1 != null) {
                    if (!v9_1.d()) {
                        throw ((gb.a1) v9_1).u();
                    } else {
                    }
                }
                if ((v0_8 != null) && (v0_8.equals(v4_3))) {
                    kotlin.coroutines.intrinsics.CoroutineSingletons v13_3 = jb.m.b;
                    Object v4_8 = v10.a.getAndSet(v13_3);
                    v4_8.getClass();
                    if (v4_8 != jb.m.c) {
                        v1_1.g = v12;
                        v1_1.h = v11;
                        v1_1.i = v10;
                        v1_1.j = v9_1;
                        v1_1.k = v0_8;
                        v1_1.n = 3;
                        Object v4_0 = ga.p.a;
                        gb.h v14_1 = new gb.h(1, a.a.n(v1_1));
                        v14_1.s();
                        java.util.concurrent.atomic.AtomicReference v15_1 = v10.a;
                        while (!v15_1.compareAndSet(v13_3, v14_1)) {
                            if (v15_1.get() != v13_3) {
                                v14_1.resumeWith(v4_0);
                            }
                            Object v5_1 = v14_1.r();
                            if (v5_1 == kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
                                v4_0 = v5_1;
                            }
                            if (v4_0 == v3_0) {
                            }
                        }
                    } else {
                    }
                } else {
                    Object v0_13;
                    if (v4_3 != kb.b.b) {
                        v0_13 = v4_3;
                    } else {
                        v0_13 = 0;
                    }
                    v1_1.g = v12;
                    v1_1.h = v11;
                    v1_1.i = v10;
                    v1_1.j = v9_1;
                    v1_1.k = v4_3;
                    v1_1.n = 2;
                    if (v11.emit(v0_13, v1_1) != v3_0) {
                        v0_8 = v4_3;
                    } else {
                    }
                }
            } else {
                if (v4_1 == 1) {
                    v10 = v1_1.i;
                    v4_2 = v1_1.h;
                    v12 = v1_1.g;
                    kotlin.b.b(v0_2);
                } else {
                    if (v4_1 == 2) {
                        v4_3 = v1_1.k;
                        v9_1 = v1_1.j;
                        v10 = v1_1.i;
                        v11 = v1_1.h;
                        v12 = v1_1.g;
                        kotlin.b.b(v0_2);
                    } else {
                        if (v4_1 != 3) {
                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                            return 0;
                        } else {
                            Object v4_4 = v1_1.k;
                            v9_1 = v1_1.j;
                            v10 = v1_1.i;
                            v11 = v1_1.h;
                            v12 = v1_1.g;
                            kotlin.b.b(v0_2);
                            v0_8 = v4_4;
                        }
                    }
                }
            }
        } catch (Object v0_1) {
            v12.d(v10);
            throw v0_1;
        }
        return v3_0;
    }

    public final Object e()
    {
        Object v1_1 = kotlinx.coroutines.flow.f.k.get(this);
        if (v1_1 != kb.b.b) {
            return v1_1;
        } else {
            return 0;
        }
    }

    public final Object emit(Object p1, ka.c p2)
    {
        this.f(p1);
        return ga.p.a;
    }

    public final void f(Object p2)
    {
        if (p2 == null) {
            p2 = kb.b.b;
        }
        this.g(0, p2);
        return;
    }

    public final boolean g(Object p10, Object p11)
    {
        try {
            int v0_0 = kotlinx.coroutines.flow.f.k;
            int v1_1 = v0_0.get(this);
        } catch (int v10_3) {
            throw v10_3;
        }
        if ((p10 == 0) || (kotlin.jvm.internal.f.a(v1_1, p10))) {
            if (!kotlin.jvm.internal.f.a(v1_1, p11)) {
                v0_0.set(this, p11);
                int v10_1 = this.j;
                if ((v10_1 & 1) != 0) {
                    this.j = (v10_1 + 2);
                    return 1;
                } else {
                    int v10_4 = (v10_1 + 1);
                    this.j = v10_4;
                    kb.c[] v11_2 = this.g;
                    while(true) {
                        kb.c[] v11_3 = ((jb.p[]) v11_2);
                        if (v11_3 != null) {
                            break;
                        }
                        try {
                            kb.c[] v11_4 = this.j;
                        } catch (int v10_6) {
                            throw v10_6;
                        }
                        if (v11_4 != v10_4) {
                            v11_2 = this.g;
                            v10_4 = v11_4;
                        } else {
                            this.j = (v10_4 + 1);
                            return 1;
                        }
                    }
                    int v0_1 = v11_3.length;
                    int v3 = 0;
                    while (v3 < v0_1) {
                        ga.p v4_0 = v11_3[v3];
                        if (v4_0 != null) {
                            ga.p v4_1 = v4_0.a;
                            do {
                                gb.h v5_0 = v4_1.get();
                                if (v5_0 != null) {
                                    Object v6_0 = jb.m.c;
                                    if (v5_0 != v6_0) {
                                        Object v7_0 = jb.m.b;
                                        if (v5_0 != v7_0) {
                                            while (!v4_1.compareAndSet(v5_0, v7_0)) {
                                                if (v4_1.get() != v5_0) {
                                                }
                                            }
                                            ((gb.h) v5_0).resumeWith(ga.p.a);
                                            v3++;
                                        }
                                    }
                                }
                            } while(!v4_1.compareAndSet(v5_0, v6_0));
                            if (v4_1.get() != v5_0) {
                            } else {
                                while (!v4_1.compareAndSet(v5_0, v6_0)) {
                                }
                            }
                        }
                    }
                }
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }

    public final jb.b p(ka.g p2, int p3, kotlinx.coroutines.channels.BufferOverflow p4)
    {
        if (((((p3 < 0) || (p3 >= 2)) && (p3 != -2)) || (p4 != kotlinx.coroutines.channels.BufferOverflow.h)) && (((p3 != 0) && (p3 != -3)) || (p4 != kotlinx.coroutines.channels.BufferOverflow.g))) {
            return new kb.d(this, p2, p3, p4);
        } else {
            return this;
        }
    }
}
