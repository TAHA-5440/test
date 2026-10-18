// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.serialization.json.internal;
public final class c extends com.bumptech.glide.j implements tb.c, tb.a {
    public final vb.b a;
    public final kotlinx.serialization.json.internal.WriteMode b;
    public final e0.x c;
    public int d;
    public final m.t e;
    public final kotlinx.serialization.json.internal.a f;

    public c(vb.b p1, kotlinx.serialization.json.internal.WriteMode p2, e0.x p3, sb.d p4)
    {
        kotlinx.serialization.json.internal.a v1_2;
        p4.getClass();
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = -1;
        kotlinx.serialization.json.internal.a v1_3 = p1.a;
        this.e = v1_3;
        if (!v1_3.e) {
            v1_2 = new kotlinx.serialization.json.internal.a(p4);
        } else {
            v1_2 = 0;
        }
        this.f = v1_2;
        return;
    }

    public final double A()
    {
        e0.x v0 = this.c;
        try {
            int v3_1 = Double.parseDouble(v0.j());
            Double v1_4 = Double.isInfinite(v3_1);
        } catch (IllegalArgumentException) {
            e0.x.l(v0, r1.a.k("Failed to parse type \'double\' for input \'", v1_4, 39), 0, 6);
            throw 0;
        }
        if ((v1_4 != null) || (Double.isNaN(v3_1))) {
            wb.g.i(v0, Double.valueOf(v3_1));
            throw 0;
        } else {
            return v3_1;
        }
    }

    public final vb.j V()
    {
        return new kotlinx.serialization.json.internal.b(this.a.a, this.c).b();
    }

    public final void a(sb.d p6)
    {
        p6.getClass();
        if ((this.a.a.d) && (p6.f() == 0)) {
            while (this.q(p6) != -1) {
            }
        }
        int v6_1 = this.c;
        if (v6_1.r()) {
            wb.g.e(v6_1, "");
            throw 0;
        } else {
            v6_1.g(this.b.h);
            int v6_4 = ((dc.i) v6_1.c);
            int v0_7 = v6_4.b;
            int[] v2_1 = ((int[]) v6_4.d);
            if (v2_1[v0_7] == -2) {
                v2_1[v0_7] = -1;
                v6_4.b = (v0_7 + -1);
            }
            int v0_10 = v6_4.b;
            if (v0_10 != -1) {
                v6_4.b = (v0_10 + -1);
            }
            return;
        }
    }

    public final tb.a b(sb.d p9)
    {
        p9.getClass();
        int v0_0 = this.a;
        String v1_0 = wb.g.h(p9, v0_0);
        e0.x v2 = this.c;
        kotlinx.serialization.json.internal.c v3_13 = ((dc.i) v2.c);
        int v4_4 = (v3_13.b + 1);
        v3_13.b = v4_4;
        int[] v6_1 = ((Object[]) v3_13.c);
        if (v4_4 == v6_1.length) {
            int v7_1 = (v4_4 * 2);
            v3_13.c = java.util.Arrays.copyOf(v6_1, v7_1);
            v3_13.d = java.util.Arrays.copyOf(((int[]) v3_13.d), v7_1);
        }
        ((Object[]) v3_13.c)[v4_4] = p9;
        v2.g(v1_0.g);
        if (v2.o() == 4) {
            e0.x.l(v2, "Unexpected leading comma", 0, 6);
            throw 0;
        } else {
            kotlinx.serialization.json.internal.c v3_4 = v1_0.ordinal();
            if ((v3_4 == 1) || ((v3_4 == 2) || (v3_4 == 3))) {
                return new kotlinx.serialization.json.internal.c(v0_0, v1_0, v2, p9);
            } else {
                if ((this.b != v1_0) || (!v0_0.a.e)) {
                    return new kotlinx.serialization.json.internal.c(v0_0, v1_0, v2, p9);
                } else {
                    return this;
                }
            }
        }
    }

    public final boolean c()
    {
        e0.x v0 = this.c;
        String v1_0 = v0.q();
        int v2_1 = ((String) v0.f);
        if (v1_0 == v2_1.length()) {
            e0.x.l(v0, "EOF", 0, 6);
            throw 0;
        } else {
            int v3_1;
            if (v2_1.charAt(v1_0) != 34) {
                v3_1 = 0;
            } else {
                v1_0++;
                v3_1 = 1;
            }
            String v1_1 = v0.p(v1_0);
            if ((v1_1 >= v2_1.length()) || (v1_1 == -1)) {
                e0.x.l(v0, "EOF", 0, 6);
                throw 0;
            } else {
                String v1_5;
                int v10_2 = (v1_1 + 1);
                String v1_3 = (v2_1.charAt(v1_1) | 32);
                if (v1_3 == 102) {
                    v0.c(v10_2, "alse");
                    v1_5 = 0;
                } else {
                    if (v1_3 != 116) {
                        String v1_7 = new StringBuilder("Expected valid boolean literal prefix, but had \'");
                        v1_7.append(v0.j());
                        v1_7.append(39);
                        e0.x.l(v0, v1_7.toString(), 0, 6);
                        throw 0;
                    } else {
                        v0.c(v10_2, "rue");
                        v1_5 = 1;
                    }
                }
                if (v3_1 == 0) {
                    return v1_5;
                } else {
                    if (v0.b == v2_1.length()) {
                        e0.x.l(v0, "EOF", 0, 6);
                        throw 0;
                    } else {
                        if (v2_1.charAt(v0.b) != 34) {
                            e0.x.l(v0, "Expected closing quotation mark", 0, 6);
                            throw 0;
                        } else {
                            v0.b = (v0.b + 1);
                            return v1_5;
                        }
                    }
                }
            }
        }
    }

    public final char d()
    {
        int v0_0 = this.c;
        String v1_1 = v0_0.j();
        if (v1_1.length() != 1) {
            e0.x.l(v0_0, r1.a.k("Expected single char, but got \'", v1_1, 39), 0, 6);
            throw 0;
        } else {
            return v1_1.charAt(0);
        }
    }

    public final Object g(qb.a p5)
    {
        p5.getClass();
        try {
            return p5.deserialize(this);
        } catch (kotlinx.serialization.MissingFieldException v5_2) {
            kotlinx.serialization.MissingFieldException v0_3 = v5_2.getMessage();
            v0_3.getClass();
            if (!db.i.T(v0_3, "at path", 0)) {
                String v1_0 = v5_2.getMessage();
                java.util.List v2_3 = ((dc.i) this.c.c).c();
                StringBuilder v3_1 = new StringBuilder();
                v3_1.append(v1_0);
                v3_1.append(" at path: ");
                v3_1.append(v2_3);
                throw new kotlinx.serialization.MissingFieldException(v5_2.g, v3_1.toString(), v5_2);
            } else {
                throw v5_2;
            }
        }
    }

    public final int h()
    {
        int v0_0 = this.c;
        String v1_2 = v0_0.h();
        int v3_1 = ((int) v1_2);
        if (v1_2 != ((long) v3_1)) {
            int v3_3 = new StringBuilder("Failed to parse int for input \'");
            v3_3.append(v1_2);
            v3_3.append(39);
            e0.x.l(v0_0, v3_3.toString(), 0, 6);
            throw 0;
        } else {
            return v3_1;
        }
    }

    public final Object i(sb.d p5, int p6, qb.a p7, Object p8)
    {
        int[] v5_1;
        dc.i v8_2 = ((dc.i) this.c.c);
        p5.getClass();
        p7.getClass();
        if ((this.b != kotlinx.serialization.json.internal.WriteMode.k) || ((p6 & 1) != 0)) {
            v5_1 = 0;
        } else {
            v5_1 = 1;
        }
        if (v5_1 != null) {
            int v2 = v8_2.b;
            if (((int[]) v8_2.d)[v2] == -2) {
                ((Object[]) v8_2.c)[v2] = wb.h.a;
            }
        }
        Object v7_1 = this.g(p7);
        if (v5_1 != null) {
            int v0_5 = v8_2.b;
            if (((int[]) v8_2.d)[v0_5] != -2) {
                int v0_6 = (v0_5 + 1);
                v8_2.b = v0_6;
                int[] v5_6 = ((Object[]) v8_2.c);
                if (v0_6 == v5_6.length) {
                    int v0_7 = (v0_6 * 2);
                    v8_2.c = java.util.Arrays.copyOf(v5_6, v0_7);
                    v8_2.d = java.util.Arrays.copyOf(((int[]) v8_2.d), v0_7);
                }
            }
            int v0_8 = v8_2.b;
            ((Object[]) v8_2.c)[v0_8] = v7_1;
            ((int[]) v8_2.d)[v0_8] = -2;
        }
        return v7_1;
    }

    public final String j()
    {
        return this.c.i();
    }

    public final long m()
    {
        return this.c.h();
    }

    public final boolean p()
    {
        e0.x v1_1;
        e0.x v1_0 = this.f;
        if (v1_0 == null) {
            v1_1 = 0;
        } else {
            v1_1 = v1_0.b;
        }
        if (v1_1 == null) {
            e0.x v1_2 = this.c;
            int v2_0 = v1_2.p(v1_2.q());
            byte v3_1 = ((String) v1_2.f);
            int v4_1 = (v3_1.length() - v2_0);
            int v6 = 0;
            if ((v4_1 >= 4) && (v2_0 != -1)) {
                int v8_1 = 0;
                while (v8_1 < 4) {
                    if ("null".charAt(v8_1) == v3_1.charAt((v2_0 + v8_1))) {
                        v8_1++;
                    }
                }
                if ((v4_1 <= 4) || (wb.g.d(v3_1.charAt((v2_0 + 4))) != 0)) {
                    v6 = 1;
                    v1_2.b = (v2_0 + 4);
                }
            }
            if (v6 == 0) {
                return 1;
            }
        }
        return 0;
    }

    public final int q(sb.d p21)
    {
        String v2_0 = this.c;
        int v3_4 = ((dc.i) v2_0.c);
        int v4_10 = ((String) v2_0.f);
        p21.getClass();
        String v5_2 = this.b;
        byte v6_0 = v5_2.ordinal();
        int v9_0 = 0;
        int v10_4 = 58;
        long v11_6 = 0;
        int v12_1 = 1;
        int v13_8 = -1;
        if (v6_0 == 0) {
            byte v6_6 = v2_0.r();
            while(true) {
                int v18 = v9_0;
                int v9_5 = this.f;
                if (!v2_0.b()) {
                    break;
                }
                int v19_1;
                byte v6_19 = v2_0.d();
                v2_0.g(v10_4);
                p21.getClass();
                wb.h v14_2 = this.a;
                v14_2.getClass();
                v6_19.getClass();
                wb.g.g(p21, v14_2);
                int v10_0 = p21.d(v6_19);
                if ((v10_0 == -3) && (v14_2.a.f)) {
                    long v11_3;
                    int v10_1 = v14_2.c;
                    int v13_4 = new fc.n(3, p21, v14_2);
                    v10_1.getClass();
                    int v10_3 = ((java.util.concurrent.ConcurrentHashMap) v10_1.h);
                    long v11_2 = ((java.util.Map) v10_3.get(p21));
                    wb.h v14_0 = wb.g.a;
                    int v19_0 = 0;
                    if (v11_2 == 0) {
                        v11_3 = 0;
                    } else {
                        v11_3 = v11_2.get(v14_0);
                    }
                    if (v11_3 != 0) {
                        v19_0 = v11_3;
                    }
                    long v11_4;
                    if (v19_0 == 0) {
                        v11_4 = v13_4.invoke();
                        int v13_5 = v10_3.get(p21);
                        if (v13_5 != 0) {
                            v19_1 = v12_1;
                        } else {
                            v19_1 = v12_1;
                            v13_5 = new java.util.concurrent.ConcurrentHashMap(2);
                            v10_3.put(p21, v13_5);
                        }
                        ((java.util.Map) v13_5).put(v14_0, v11_4);
                    } else {
                        v11_4 = v19_0;
                        v19_1 = v12_1;
                    }
                    int v10_6 = ((Integer) ((java.util.Map) v11_4).get(v6_19));
                    if (v10_6 == 0) {
                        v10_0 = -3;
                    } else {
                        v10_0 = v10_6.intValue();
                    }
                } else {
                    v19_1 = v12_1;
                }
                if (v10_0 == -3) {
                    if (!this.e.d) {
                        v2_0.k(db.i.b0(6, v4_10.subSequence(0, v2_0.b).toString(), v6_19), r1.a.k("Encountered an unknown key \'", v6_19, 39), "Use \'ignoreUnknownKeys = true\' in \'Json {}\' builder to ignore unknown keys.");
                        throw v18;
                    } else {
                        long v11_8;
                        int v9_4 = new java.util.ArrayList();
                        byte v6_1 = v2_0.o();
                        if ((v6_1 == 8) || (v6_1 == 6)) {
                            while(true) {
                                byte v6_2 = v2_0.o();
                                v11_8 = v19_1;
                                if (v6_2 != v11_8) {
                                    if ((v6_2 != 8) && (v6_2 != 6)) {
                                        if (v6_2 != 9) {
                                            if (v6_2 != 7) {
                                                if (v6_2 == 10) {
                                                    break;
                                                }
                                            } else {
                                                if (((Number) ha.j.J(v9_4)).byteValue() != 6) {
                                                    String v1_6 = v2_0.b;
                                                    String v2_2 = new StringBuilder("found } instead of ] at path: ");
                                                    v2_2.append(v3_4);
                                                    throw wb.g.b(v1_6, v4_10, v2_2.toString());
                                                } else {
                                                    ha.j.N(v9_4);
                                                }
                                            }
                                        } else {
                                            if (((Number) ha.j.J(v9_4)).byteValue() != 8) {
                                                String v1_8 = v2_0.b;
                                                String v2_5 = new StringBuilder("found ] instead of } at path: ");
                                                v2_5.append(v3_4);
                                                throw wb.g.b(v1_8, v4_10, v2_5.toString());
                                            } else {
                                                ha.j.N(v9_4);
                                            }
                                        }
                                    } else {
                                        v9_4.add(Byte.valueOf(v6_2));
                                    }
                                    v2_0.e();
                                    if (v9_4.size() == 0) {
                                        v6_6 = v2_0.r();
                                        v12_1 = v11_8;
                                        v9_0 = v18;
                                        v10_4 = 58;
                                        v11_6 = 0;
                                    }
                                } else {
                                    v2_0.d();
                                }
                                v19_1 = v11_8;
                            }
                            e0.x.l(v2_0, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, 6);
                            throw v18;
                        } else {
                            v2_0.j();
                            v11_8 = v19_1;
                        }
                    }
                } else {
                    if (v9_5 != 0) {
                        String v1_10 = v9_5.a;
                        if (v10_0 >= 64) {
                            String v2_8 = ((v10_0 >> 6) - 1);
                            String v1_11 = v1_10.d;
                            v1_11[v2_8] = (v1_11[v2_8] | (1 << (v10_0 & 63)));
                        } else {
                            v1_10.c = (v1_10.c | (1 << v10_0));
                        }
                    }
                    v13_8 = v10_0;
                }
            }
            int v10_9 = v11_6;
            if (v6_6 != 0) {
                wb.g.e(v2_0, "object");
                throw v18;
            } else {
                if (v9_5 != 0) {
                    String v1_25 = v9_5.a;
                    String v2_10 = v1_25.b;
                    int v4_8 = v1_25.a;
                    byte v6_17 = v4_8.f();
                    do {
                        int v7_1 = v1_25.c;
                        long v11_9 = -1;
                        if (v7_1 == -1) {
                            if (v6_17 > 64) {
                                String v1_26 = v1_25.d;
                                byte v6_18 = v1_26.length;
                                while (v10_9 < v6_18) {
                                    int v7_2 = (v10_9 + 1);
                                    int v8_3 = (v7_2 * 64);
                                    int v13_9 = v1_26[v10_9];
                                    while (v13_9 != v11_9) {
                                        int v9_8 = Long.numberOfTrailingZeros((~ v13_9));
                                        v13_9 |= (1 << v9_8);
                                        int v9_9 = (v9_8 + v8_3);
                                        if (!((Boolean) ((kotlinx.serialization.json.internal.JsonElementMarker$origin$1) v2_10).invoke(v4_8, Integer.valueOf(v9_9))).booleanValue()) {
                                            v11_9 = -1;
                                        } else {
                                            v1_26[v10_9] = v13_9;
                                            v13_8 = v9_9;
                                        }
                                        if (v5_2 != kotlinx.serialization.json.internal.WriteMode.k) {
                                            ((int[]) v3_4.d)[v3_4.b] = v13_8;
                                        }
                                        return v13_8;
                                    }
                                    v1_26[v10_9] = v13_9;
                                    v10_9 = v7_2;
                                    v11_9 = -1;
                                }
                            }
                        } else {
                            int v7_4 = Long.numberOfTrailingZeros((~ v7_1));
                            v1_25.c = (v1_25.c | (1 << v7_4));
                        }
                    } while(!((Boolean) ((kotlinx.serialization.json.internal.JsonElementMarker$origin$1) v2_10).invoke(v4_8, Integer.valueOf(v7_4))).booleanValue());
                    v13_8 = v7_4;
                }
                v13_8 = -1;
            }
        } else {
            if (v6_0 == 2) {
                int v4_4;
                String v1_13 = this.d;
                if ((v1_13 % 2) == 0) {
                    v4_4 = 0;
                } else {
                    v4_4 = 1;
                }
                if (v4_4 == 0) {
                    v2_0.g(58);
                } else {
                    if (v1_13 != -1) {
                        v11_6 = v2_0.r();
                    }
                }
                if (!v2_0.b()) {
                    if (v11_6 != 0) {
                        wb.g.e(v2_0, "object");
                        throw 0;
                    }
                } else {
                    if (v4_4 != 0) {
                        int v4_5 = v2_0.b;
                        if (this.d != -1) {
                            if (v11_6 == 0) {
                                e0.x.l(v2_0, "Expected comma after the key-value pair", v4_5, 4);
                                throw 0;
                            }
                        } else {
                            if (v11_6 != 0) {
                                e0.x.l(v2_0, "Unexpected leading comma", v4_5, 4);
                                throw 0;
                            }
                        }
                    }
                    v13_8 = (this.d + 1);
                    this.d = v13_8;
                }
            } else {
                String v1_19 = v2_0.r();
                if (!v2_0.b()) {
                    if (v1_19 != null) {
                        wb.g.e(v2_0, "array");
                        throw 0;
                    }
                } else {
                    int v4_7 = this.d;
                    if ((v4_7 != -1) && (v1_19 == null)) {
                        e0.x.l(v2_0, "Expected end of the array or comma", 0, 6);
                        throw 0;
                    } else {
                        v13_8 = (v4_7 + 1);
                        this.d = v13_8;
                    }
                }
            }
        }
    }

    public final tb.c u(sb.d p3)
    {
        p3.getClass();
        if (!wb.j.a(p3)) {
            return this;
        } else {
            return new wb.f(this.c, this.a);
        }
    }

    public final byte w()
    {
        int v0_0 = this.c;
        String v1_2 = v0_0.h();
        int v3_3 = ((byte) ((int) v1_2));
        if (v1_2 != ((long) v3_3)) {
            int v3_0 = new StringBuilder("Failed to parse byte for input \'");
            v3_0.append(v1_2);
            v3_0.append(39);
            e0.x.l(v0_0, v3_0.toString(), 0, 6);
            throw 0;
        } else {
            return v3_3;
        }
    }

    public final short y()
    {
        int v0_0 = this.c;
        String v1_2 = v0_0.h();
        int v3_3 = ((short) ((int) v1_2));
        if (v1_2 != ((long) v3_3)) {
            int v3_0 = new StringBuilder("Failed to parse short for input \'");
            v3_0.append(v1_2);
            v3_0.append(39);
            e0.x.l(v0_0, v3_0.toString(), 0, 6);
            throw 0;
        } else {
            return v3_3;
        }
    }

    public final float z()
    {
        e0.x v0 = this.c;
        try {
            Float v1_3 = Float.parseFloat(v0.j());
        } catch (IllegalArgumentException) {
            e0.x.l(v0, r1.a.k("Failed to parse type \'float\' for input \'", v1_3, 39), 0, 6);
            throw 0;
        }
        if ((Float.isInfinite(v1_3)) || (Float.isNaN(v1_3))) {
            wb.g.i(v0, Float.valueOf(v1_3));
            throw 0;
        } else {
            return v1_3;
        }
    }
}
