// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ib;
public final class a implements gb.n1 {
    public Object g;
    public gb.h h;
    public final synthetic kotlinx.coroutines.channels.a i;

    public a(kotlinx.coroutines.channels.a p1)
    {
        this.i = p1;
        this.g = ib.b.p;
        return;
    }

    public final Object a(ka.c p15)
    {
        IllegalStateException v0_0 = this.g;
        com.google.gson.internal.b v2_3 = 1;
        if ((v0_0 == ib.b.p) || (v0_0 == ib.b.l)) {
            kotlinx.coroutines.channels.a v3 = this.i;
            IllegalStateException v0_1 = ((ib.h) kotlinx.coroutines.channels.a.m.get(v3));
            while (!v3.s(kotlinx.coroutines.channels.a.h.get(v3), 1)) {
                long v4_5;
                long v6_0 = kotlinx.coroutines.channels.a.i.getAndIncrement(v3);
                long v4_3 = ((long) ib.b.b);
                ib.a v8_0 = (v6_0 / v4_3);
                int v5_0 = ((int) (v6_0 % v4_3));
                if (v0_1.c == v8_0) {
                    v4_5 = v0_1;
                } else {
                    String v1_10 = v3.m(v8_0, v0_1);
                    if (v1_10 != null) {
                        v4_5 = v1_10;
                    }
                }
                IllegalStateException v0_11 = v3.B(v4_5, v5_0, v6_0, 0);
                String v1_11 = ib.b.m;
                if (v0_11 == v1_11) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("unreachable");
                    return 0;
                } else {
                    long v10_1 = ib.b.o;
                    if (v0_11 != v10_1) {
                        if (v0_11 != ib.b.n) {
                            v4_5.a();
                            this.g = v0_11;
                        } else {
                            Object v15_7 = gb.w.m(a.a.n(p15));
                            try {
                                this.h = v15_7;
                            } catch (IllegalStateException v0_8) {
                                v15_7.z();
                                throw v0_8;
                            }
                            IllegalStateException v0_12 = v3.B(v4_5, v5_0, v6_0, this);
                            if (v0_12 != v1_11) {
                                if (v0_12 != v10_1) {
                                    v4_5.a();
                                    this.g = v0_12;
                                    this.h = 0;
                                } else {
                                    if (v6_0 < v3.q()) {
                                        v4_5.a();
                                    }
                                    IllegalStateException v0_6 = ((ib.h) kotlinx.coroutines.channels.a.m.get(v3));
                                    while (!v3.s(kotlinx.coroutines.channels.a.h.get(v3), 1)) {
                                        long v4_9;
                                        long v6_1 = kotlinx.coroutines.channels.a.i.getAndIncrement(v3);
                                        long v4_7 = ((long) ib.b.b);
                                        long v10_2 = (v6_1 / v4_7);
                                        int v5_1 = ((int) (v6_1 % v4_7));
                                        if (v0_6.c == v10_2) {
                                            v4_9 = v0_6;
                                        } else {
                                            String v1_18 = v3.m(v10_2, v0_6);
                                            if (v1_18 != null) {
                                                v4_9 = v1_18;
                                            } else {
                                            }
                                        }
                                        IllegalStateException v0_19 = v3.B(v4_9, v5_1, v6_1, this);
                                        String v1_19 = v4_9;
                                        if (v0_19 != ib.b.m) {
                                            if (v0_19 != ib.b.o) {
                                                if (v0_19 == ib.b.n) {
                                                    throw new IllegalStateException("unexpected");
                                                } else {
                                                    v1_19.a();
                                                    this.g = v0_19;
                                                    this.h = 0;
                                                }
                                            } else {
                                                if (v6_1 < v3.q()) {
                                                    v1_19.a();
                                                }
                                                v0_6 = v1_19;
                                            }
                                        } else {
                                            this.b(v1_19, v5_1);
                                            return v15_7.r();
                                        }
                                    }
                                    IllegalStateException v0_7 = this.h;
                                    v0_7.getClass();
                                    this.h = 0;
                                    this.g = ib.b.l;
                                    String v1_4 = v3.n();
                                    if (v1_4 != null) {
                                        v0_7.resumeWith(new kotlin.Result$Failure(v1_4));
                                    } else {
                                        v0_7.resumeWith(Boolean.FALSE);
                                    }
                                    return v15_7.r();
                                }
                                v15_7.a(Boolean.TRUE, 0);
                            } else {
                                this.b(v4_5, v5_0);
                            }
                            return v15_7.r();
                        }
                    } else {
                        if (v6_0 < v3.q()) {
                            v4_5.a();
                        }
                        v0_1 = v4_5;
                    }
                }
            }
            this.g = ib.b.l;
            Object v15_3 = v3.n();
            if (v15_3 != null) {
                throw v15_3;
            } else {
                v2_3 = 0;
            }
        }
        return Boolean.valueOf(v2_3);
    }

    public final void b(lb.p p2, int p3)
    {
        gb.h v0 = this.h;
        if (v0 != null) {
            v0.b(p2, p3);
        }
        return;
    }
}
