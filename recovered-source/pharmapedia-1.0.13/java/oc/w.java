// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public final class w implements java.lang.Comparable {
    public static final String h;
    public final okio.ByteString g;

    static w()
    {
        String v0 = java.io.File.separator;
        v0.getClass();
        oc.w.h = v0;
        return;
    }

    public w(okio.ByteString p1)
    {
        p1.getClass();
        this.g = p1;
        return;
    }

    public final java.util.ArrayList a()
    {
        java.util.ArrayList v0_1 = new java.util.ArrayList();
        int v1_0 = pc.c.a(this);
        okio.ByteString v4 = this.g;
        if (v1_0 != -1) {
            if ((v1_0 < v4.e()) && (v4.j(v1_0) == 92)) {
                v1_0++;
            }
        } else {
            v1_0 = 0;
        }
        byte v2_1 = v4.e();
        int v5_0 = v1_0;
        while (v1_0 < v2_1) {
            if ((v4.j(v1_0) == 47) || (v4.j(v1_0) == 92)) {
                v0_1.add(v4.p(v5_0, v1_0));
                v5_0 = (v1_0 + 1);
            }
            v1_0++;
        }
        if (v5_0 < v4.e()) {
            v0_1.add(v4.p(v5_0, v4.e()));
        }
        return v0_1;
    }

    public final oc.w b()
    {
        oc.w v0_0 = pc.c.d;
        okio.ByteString v1_0 = this.g;
        if (!kotlin.jvm.internal.f.a(v1_0, v0_0)) {
            int v2_2 = pc.c.a;
            if (!kotlin.jvm.internal.f.a(v1_0, v2_2)) {
                Character v3_3 = pc.c.b;
                if (!kotlin.jvm.internal.f.a(v1_0, v3_3)) {
                    boolean v4_1 = pc.c.e;
                    v1_0.getClass();
                    v4_1.getClass();
                    int v6_0 = v4_1.g;
                    if ((!v1_0.m((v1_0.e() - v6_0.length), v4_1, v6_0.length)) || ((v1_0.e() != 2) && ((!v1_0.m((v1_0.e() - 3), v2_2, 1)) && (!v1_0.m((v1_0.e() - 3), v3_3, 1))))) {
                        int v2_1 = okio.ByteString.l(v1_0, v2_2);
                        if (v2_1 == -1) {
                            v2_1 = okio.ByteString.l(v1_0, v3_3);
                        }
                        if ((v2_1 != 2) || (this.e() == null)) {
                            if (v2_1 == 1) {
                                v3_3.getClass();
                                if (v1_0.m(0, v3_3, v3_3.e())) {
                                    return 0;
                                }
                            }
                            if ((v2_1 != -1) || (this.e() == null)) {
                                if (v2_1 != -1) {
                                    if (v2_1 != 0) {
                                        return new oc.w(okio.ByteString.q(v1_0, 0, v2_1, 1));
                                    } else {
                                        return new oc.w(okio.ByteString.q(v1_0, 0, 1, 1));
                                    }
                                } else {
                                    return new oc.w(v0_0);
                                }
                            } else {
                                if (v1_0.e() != 2) {
                                    return new oc.w(okio.ByteString.q(v1_0, 0, 2, 1));
                                }
                            }
                        } else {
                            if (v1_0.e() != 3) {
                                return new oc.w(okio.ByteString.q(v1_0, 0, 3, 1));
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public final oc.w c(oc.w p12)
    {
        java.util.ArrayList v6_0;
        p12.getClass();
        oc.i v0_0 = p12.g;
        String v1_5 = pc.c.a(this);
        int v2_2 = this.g;
        okio.ByteString v3_4 = 0;
        if (v1_5 != -1) {
            v6_0 = new oc.w(v2_2.p(0, v1_5));
        } else {
            v6_0 = 0;
        }
        String v1_1 = pc.c.a(p12);
        if (v1_1 != -1) {
            v3_4 = new oc.w(v0_0.p(0, v1_1));
        }
        if (!kotlin.jvm.internal.f.a(v6_0, v3_4)) {
            oc.i v0_2 = new StringBuilder("Paths of different roots cannot be relative to each other: ");
            v0_2.append(this);
            v0_2.append(" and ");
            v0_2.append(p12);
            throw new IllegalArgumentException(v0_2.toString().toString());
        } else {
            String v1_6 = this.a();
            java.util.ArrayList v6_1 = p12.a();
            okio.ByteString v7_1 = Math.min(v1_6.size(), v6_1.size());
            int v8_0 = 0;
            while ((v8_0 < v7_1) && (kotlin.jvm.internal.f.a(v1_6.get(v8_0), v6_1.get(v8_0)))) {
                v8_0++;
            }
            if ((v8_0 != v7_1) || (v2_2.e() != v0_0.e())) {
                if (v6_1.subList(v8_0, v6_1.size()).indexOf(pc.c.e) != -1) {
                    oc.i v0_6 = new StringBuilder("Impossible relative path to resolve: ");
                    v0_6.append(this);
                    v0_6.append(" and ");
                    v0_6.append(p12);
                    throw new IllegalArgumentException(v0_6.toString().toString());
                } else {
                    if (!kotlin.jvm.internal.f.a(v0_0, pc.c.d)) {
                        oc.i v0_11 = new oc.i();
                        oc.w v12_8 = pc.c.c(p12);
                        if (v12_8 == null) {
                            v12_8 = pc.c.c(this);
                            if (v12_8 == null) {
                                v12_8 = pc.c.f(oc.w.h);
                            }
                        }
                        int v2_0 = v6_1.size();
                        okio.ByteString v3_0 = v8_0;
                        while (v3_0 < v2_0) {
                            v0_11.m0(pc.c.e);
                            v0_11.m0(v12_8);
                            v3_0++;
                        }
                        int v2_1 = v1_6.size();
                        while (v8_0 < v2_1) {
                            v0_11.m0(((okio.ByteString) v1_6.get(v8_0)));
                            v0_11.m0(v12_8);
                            v8_0++;
                        }
                        return pc.c.d(v0_11, 0);
                    } else {
                        return this;
                    }
                }
            } else {
                return ea.c.u(".");
            }
        }
    }

    public final int compareTo(Object p2)
    {
        ((oc.w) p2).getClass();
        return this.g.b(((oc.w) p2).g);
    }

    public final oc.w d(String p2)
    {
        p2.getClass();
        oc.w v0_1 = new oc.i();
        v0_1.w0(p2);
        return pc.c.b(this, pc.c.d(v0_1, 0), 0);
    }

    public final Character e()
    {
        int v1_0 = this.g;
        if ((okio.ByteString.h(v1_0, pc.c.a) == -1) && ((v1_0.e() >= 2) && (v1_0.j(1) == 58))) {
            Character v0_5 = ((char) v1_0.j(0));
            if (((97 <= v0_5) && (v0_5 < 123)) || ((65 <= v0_5) && (v0_5 < 91))) {
                return Character.valueOf(v0_5);
            }
        }
        return 0;
    }

    public final boolean equals(Object p2)
    {
        if ((!(p2 instanceof oc.w)) || (!kotlin.jvm.internal.f.a(((oc.w) p2).g, this.g))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        return this.g.hashCode();
    }

    public final java.io.File toFile()
    {
        return new java.io.File(this.g.t());
    }

    public final String toString()
    {
        return this.g.t();
    }
}
