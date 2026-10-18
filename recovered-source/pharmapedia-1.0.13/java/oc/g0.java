// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public final class g0 extends oc.o {
    public static final oc.w k;
    public final oc.w h;
    public final oc.o i;
    public final java.util.LinkedHashMap j;

    static g0()
    {
        oc.g0.k = ea.c.u("/");
        return;
    }

    public g0(oc.w p1, oc.o p2, java.util.LinkedHashMap p3)
    {
        this.h = p1;
        this.i = p2;
        this.j = p3;
        return;
    }

    public final void B(oc.w p2)
    {
        p2.getClass();
        throw new java.io.IOException("zip file systems are read-only");
    }

    public final java.util.List M(oc.w p3)
    {
        String v0_0 = oc.g0.k;
        v0_0.getClass();
        String v0_4 = ((pc.k) this.j.get(pc.c.b(v0_0, p3, 1)));
        if (v0_4 == null) {
            oc.l.f(p3, "not a directory: ");
            return 0;
        } else {
            return ha.j.U(v0_4.q);
        }
    }

    public final oc.n Z(oc.w p27)
    {
        p27.getClass();
        int v0_4 = oc.g0.k;
        v0_4.getClass();
        int v0_1 = ((pc.k) this.j.get(pc.c.b(v0_4, p27, 1)));
        if (v0_1 != 0) {
            Throwable v4_0 = v0_1.h;
            if (v4_0 != -1) {
                boolean v6_3 = this.i.c0(this.h);
                try {
                    oc.y v5_1 = new oc.y(v6_3.d(v4_0));
                } catch (int v0_8) {
                    Throwable v4_5 = v0_8;
                    if (v6_3) {
                        try {
                            v6_3.close();
                        } catch (int v0_9) {
                            com.bumptech.glide.i.d(v4_5, v0_9);
                        }
                    }
                    v0_1 = 0;
                    if (v4_5 != null) {
                        throw v4_5;
                    }
                }
                try {
                    Throwable v4_3 = pc.b.f(v5_1, v0_1);
                    v4_3.getClass();
                    try {
                        v5_1.close();
                        int v0_7 = 0;
                    } catch (int v0_7) {
                    }
                    if (v0_7 != 0) {
                        throw v0_7;
                    } else {
                        try {
                            v6_3.close();
                            int v0_10 = 0;
                        } catch (int v0_10) {
                        }
                        v4_5 = v0_10;
                        v0_1 = v4_3;
                    }
                } catch (int v0_5) {
                    Throwable v4_4 = v0_5;
                    try {
                        v5_1.close();
                    } catch (int v0_6) {
                        com.bumptech.glide.i.d(v4_4, v0_6);
                    }
                    v0_7 = v4_4;
                    v4_3 = 0;
                }
            }
            Long v8;
            boolean v6_4 = v0_1.b;
            oc.y v5_2 = (v6_4 ^ 1);
            if (!v6_4) {
                v8 = Long.valueOf(v0_1.f);
            } else {
                v8 = 0;
            }
            int v2_2;
            int v7_4 = v0_1.m;
            if (v7_4 == 0) {
                int v2_1 = v0_1.p;
                if (v2_1 == 0) {
                    v2_2 = 0;
                } else {
                    v2_2 = Long.valueOf((((long) v2_1.intValue()) * 1000));
                }
            } else {
                v2_2 = Long.valueOf(((v7_4.longValue() / ((long) 10000)) - 11644473600000));
            }
            Long v3_5;
            int v10_3;
            long v16;
            Long v3_11 = v0_1.k;
            if (v3_11 == null) {
                v16 = 11644473600000;
                Long v3_12 = v0_1.n;
                if (v3_12 == null) {
                    Long v3_13 = v0_1.j;
                    if (v3_13 != -1) {
                        int v10_4 = v0_1.i;
                        if (v3_13 != -1) {
                            int v9_0 = (((v10_4 >> 9) & 127) + 1980);
                            long v14_1 = ((v10_4 >> 5) & 15);
                            int v21 = (v10_4 & 31);
                            int v22 = ((v3_13 >> 11) & 31);
                            int v23 = ((v3_13 >> 5) & 63);
                            int v24 = ((v3_13 & 31) << 1);
                            Long v3_2 = new java.util.GregorianCalendar();
                            v3_2.set(14, 0);
                            java.util.GregorianCalendar v18 = v3_2;
                            v18.set(v9_0, (v14_1 - 1), v21, v22, v23, v24);
                            v3_5 = Long.valueOf(v18.getTime().getTime());
                            v10_3 = v3_5;
                            int v11_0;
                            Long v3_8;
                            Long v3_7 = v0_1.l;
                            if (v3_7 == null) {
                                int v0_2 = v0_1.o;
                                if (v0_2 == 0) {
                                    v11_0 = 0;
                                } else {
                                    v3_8 = Long.valueOf((((long) v0_2.intValue()) * 1000));
                                    v11_0 = v3_8;
                                }
                            } else {
                                v3_8 = Long.valueOf(((v3_7.longValue() / ((long) 10000)) - v16));
                            }
                            return new oc.n(v5_2, v6_4, 0, v8, v2_2, v10_3, v11_0);
                        }
                    }
                    v10_3 = 0;
                } else {
                    v3_5 = Long.valueOf((((long) v3_12.intValue()) * 1000));
                }
            } else {
                v16 = 11644473600000;
                v3_5 = Long.valueOf(((v3_11.longValue() / ((long) 10000)) - 11644473600000));
            }
        } else {
            return 0;
        }
    }

    public final oc.g c0(oc.w p2)
    {
        throw new UnsupportedOperationException("not implemented yet!");
    }

    public final oc.b0 d(oc.w p2)
    {
        p2.getClass();
        throw new java.io.IOException("zip file systems are read-only");
    }

    public final oc.b0 d0(oc.w p2)
    {
        p2.getClass();
        throw new java.io.IOException("zip file systems are read-only");
    }

    public final oc.d0 e0(oc.w p10)
    {
        p10.getClass();
        pc.g v0_0 = oc.g0.k;
        v0_0.getClass();
        pc.g v0_8 = ((pc.k) this.j.get(pc.c.b(v0_0, p10, 1)));
        if (v0_8 == null) {
            oc.l.l(p10, "no such file: ");
            return 0;
        } else {
            long v2_0 = v0_8.f;
            pc.g v10_3 = this.i.c0(this.h);
            try {
                int v6_1 = new oc.y(v10_3.d(v0_8.h));
            } catch (Throwable v5_2) {
                if (v10_3 != null) {
                    try {
                        v10_3.close();
                    } catch (pc.g v10_4) {
                        com.bumptech.glide.i.d(v5_2, v10_4);
                    }
                }
                v6_1 = 0;
                pc.g v10_5 = v5_2;
                if (v10_5 != null) {
                    throw v10_5;
                } else {
                    pc.g v10_9;
                    v6_1.getClass();
                    pc.b.f(v6_1, 0);
                    if (v0_8.g != 0) {
                        v10_9 = new pc.g(new oc.t(new oc.y(new pc.g(v6_1, v0_8.e, 1)), new java.util.zip.Inflater(1)), v2_0, 0);
                    } else {
                        v10_9 = new pc.g(v6_1, v2_0, 1);
                    }
                    return v10_9;
                }
            }
            try {
                v10_3.close();
                v10_5 = 0;
            } catch (pc.g v10_5) {
            }
        }
    }

    public final void h(oc.w p1, oc.w p2)
    {
        p1.getClass();
        p2.getClass();
        throw new java.io.IOException("zip file systems are read-only");
    }

    public final void i(oc.w p2)
    {
        p2.getClass();
        throw new java.io.IOException("zip file systems are read-only");
    }
}
