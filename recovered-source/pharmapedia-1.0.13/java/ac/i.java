// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ac;
public final class i extends bc.a {
    public final synthetic int e;
    public final synthetic Object f;

    public synthetic i(String p1, int p2, Object p3)
    {
        this.e = p2;
        this.f = p3;
        super(p1);
        return;
    }

    public i(String p2, ua.a p3)
    {
        this.e = 1;
        this.f = p3;
        super(p2);
        return;
    }

    public final long a()
    {
        switch (this.e) {
            case 0:
                boolean v2_0 = ((ac.k) this.f);
                try {
                    if ((v2_0.s) && (!v2_0.t)) {
                        v2_0.h0();
                        if (v2_0.M()) {
                            v2_0.f0();
                            v2_0.p = 0;
                        }
                    }
                } catch (bc.b v0_13) {
                    throw v0_13;
                }
                return -1;
            case 1:
                ((ua.a) this.f).invoke();
                return -1;
            default:
                bc.b v0_15 = ((cc.t) this.f);
                boolean v2_15 = System.nanoTime();
                java.util.Map v4 = v0_15.c;
                int v5_2 = v4.values().iterator();
                if (v5_2.hasNext()) {
                    throw r1.a.e(v5_2);
                } else {
                    int v5_4 = v0_15.f.iterator();
                    v5_4.getClass();
                    while (v5_4.hasNext()) {
                        if (v4.get(((cc.s) v5_4.next()).d.a) != null) {
                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.o();
                            boolean v2_10 = 0;
                        }
                        return v2_10;
                    }
                    int v5_0 = ((v2_15 - v0_15.b) + 1);
                    long v7_2 = v0_15.f.iterator();
                    v7_2.getClass();
                    int v8 = 0;
                    int v11_0 = 9223372036854775807;
                    cc.s v13 = 0;
                    cc.s v14 = 0;
                    int v10_0 = 0;
                    while (v7_2.hasNext()) {
                        cc.s v15_1 = ((cc.s) v7_2.next());
                        v15_1.getClass();
                        try {
                            long v18_1;
                            if (v0_15.a(v15_1, v2_15) <= 0) {
                                int v9_0 = v15_1.s;
                                if (v9_0 < v5_0) {
                                    v5_0 = v9_0;
                                    v13 = v15_1;
                                }
                                v18_1 = v2_15;
                                if (v4.get(v15_1.d.a) != null) {
                                    throw new ClassCastException();
                                } else {
                                    v8++;
                                    if (v9_0 < v11_0) {
                                        v11_0 = v9_0;
                                        v14 = v15_1;
                                    }
                                }
                            } else {
                                v10_0++;
                                v18_1 = v2_15;
                            }
                            v2_15 = v18_1;
                        } catch (bc.b v0_8) {
                            throw v0_8;
                        }
                    }
                    int v9_1;
                    v2_10 = -1;
                    if (v13 == null) {
                        if (v8 <= 5) {
                            v5_0 = -1;
                            v9_1 = 0;
                        } else {
                            v5_0 = v11_0;
                            v9_1 = v14;
                        }
                    } else {
                        v9_1 = v13;
                    }
                    if (v9_1 == 0) {
                        if (v14 == null) {
                            if (v10_0 > 0) {
                                v2_10 = v0_15.b;
                            }
                        } else {
                            v2_10 = ((v11_0 + v0_15.b) - v2_15);
                        }
                    } else {
                        try {
                            if (v9_1.r.isEmpty()) {
                                if (v9_1.s == v5_0) {
                                    v9_1.l = 1;
                                    v0_15.f.remove(v9_1);
                                    if (v4.get(v9_1.d.a) != null) {
                                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.o();
                                    } else {
                                        zb.e.c(v9_1.f);
                                        if (v0_15.f.isEmpty()) {
                                            v0_15.d.a();
                                        }
                                    }
                                } else {
                                }
                            }
                        } catch (bc.b v0_3) {
                            throw v0_3;
                        }
                        v2_10 = 0;
                    }
                    return v2_10;
                }
        }
    }
}
