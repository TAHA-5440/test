// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package dc;
public abstract class f {

    static f()
    {
        n5.f.o("\"\\");
        n5.f.o("\t ,=");
        return;
    }

    public static final boolean a(yb.b0 p4)
    {
        if (!kotlin.jvm.internal.f.a(((String) p4.g.g), "HEAD")) {
            String v0_8 = p4.j;
            if ((((v0_8 >= 100) && (v0_8 < 200)) || ((v0_8 == 204) || (v0_8 == 304))) && (zb.e.e(p4) == -1)) {
                boolean v4_2 = p4.l.a("Transfer-Encoding");
                if (!v4_2) {
                    v4_2 = 0;
                }
                if (!"chunked".equalsIgnoreCase(v4_2)) {
                    return 0;
                }
            }
            return 1;
        }
        return 0;
    }

    public static final void b(yb.b p35, yb.u p36, yb.s p37)
    {
        p35.getClass();
        p36.getClass();
        p37.getClass();
        if (p35 != yb.b.c) {
            java.util.List v1_0 = p37.f("Set-Cookie");
            int v2 = v1_0.size();
            int v5 = 0;
            java.util.ArrayList v6_0 = 0;
            while (v5 < v2) {
                yb.p v15_1;
                yb.u v7_2 = ((String) v1_0.get(v5));
                v7_2.getClass();
                boolean v8_11 = System.currentTimeMillis();
                int v10_6 = 59;
                boolean v0_23 = zb.c.d(v7_2, 59, 0, v7_2.length());
                String v11_12 = 61;
                int v12_0 = zb.c.d(v7_2, 61, 0, v0_23);
                if (v12_0 != v0_23) {
                    String v13_1 = zb.c.h(0, v12_0, v7_2);
                    String v16 = v7_2.substring(v13_1, zb.c.i(v13_1, v12_0, v7_2));
                    if ((v16.length() != 0) && (zb.c.g(v16) == -1)) {
                        int v12_2 = zb.c.h((v12_0 + 1), v0_23, v7_2);
                        String v17 = v7_2.substring(v12_2, zb.c.i(v12_2, v0_23, v7_2));
                        if (zb.c.g(v17) == -1) {
                            boolean v0_19 = (v0_23 + 1);
                            int v12_4 = v7_2.length();
                            long v18 = 253402300799999;
                            int v22 = 0;
                            int v23 = 0;
                            int v24 = 0;
                            long v27 = 253402300799999;
                            boolean v4_0 = 0;
                            String v13_0 = 0;
                            boolean v20_1 = -1;
                            int v25 = 1;
                            int v26 = 0;
                            while(true) {
                                long v29_1 = 9223372036854775807;
                                if (v0_19 >= v12_4) {
                                    break;
                                }
                                int v10_2;
                                int v14_0 = zb.c.d(v7_2, v10_6, v0_19, v12_4);
                                yb.p v15_2 = zb.c.d(v7_2, v11_12, v0_19, v14_0);
                                boolean v0_5 = zb.c.h(v0_19, v15_2, v7_2);
                                boolean v0_6 = v7_2.substring(v0_5, zb.c.i(v0_5, v15_2, v7_2));
                                if (v15_2 >= v14_0) {
                                    v10_2 = "";
                                } else {
                                    int v10_3 = zb.c.h((v15_2 + 1), v14_0, v7_2);
                                    v10_2 = v7_2.substring(v10_3, zb.c.i(v10_3, v14_0, v7_2));
                                }
                                try {
                                    if (!v0_6.equalsIgnoreCase("expires")) {
                                        if (!v0_6.equalsIgnoreCase("max-age")) {
                                            if (!v0_6.equalsIgnoreCase("domain")) {
                                                if (!v0_6.equalsIgnoreCase("path")) {
                                                    if (!v0_6.equalsIgnoreCase("secure")) {
                                                        if (!v0_6.equalsIgnoreCase("httponly")) {
                                                            if (v0_6.equalsIgnoreCase("samesite")) {
                                                                v26 = v10_2;
                                                            }
                                                        } else {
                                                            v23 = 1;
                                                        }
                                                    } else {
                                                        v22 = 1;
                                                    }
                                                } else {
                                                    v13_0 = v10_2;
                                                }
                                            } else {
                                                if (db.p.K(v10_2, ".", 0)) {
                                                    throw new IllegalArgumentException("Failed requirement.");
                                                } else {
                                                    boolean v0_11 = zb.b.b(db.i.g0(v10_2, "."));
                                                    if (!v0_11) {
                                                        throw new IllegalArgumentException();
                                                    } else {
                                                        v4_0 = v0_11;
                                                        v25 = 0;
                                                    }
                                                }
                                            }
                                        } else {
                                            try {
                                                v20_1 = Long.parseLong(v10_2);
                                                long v29_0 = 0;
                                            } catch (boolean v0_15) {
                                                if (!new kotlin.text.Regex("-?\\d+").b(v10_2)) {
                                                    throw v0_15;
                                                } else {
                                                    if (db.p.Q(v10_2, "-", 0)) {
                                                        v29_0 = -9223372036854775808;
                                                    }
                                                    v20_1 = v29_0;
                                                    v24 = 1;
                                                }
                                            }
                                            if (v20_1 > 0) {
                                            } else {
                                                v20_1 = -9223372036854775808;
                                            }
                                        }
                                    } else {
                                        v27 = com.bumptech.glide.f.A(v10_2.length(), v10_2);
                                    }
                                    v0_19 = (v14_0 + 1);
                                    v10_6 = 59;
                                    v11_12 = 61;
                                } catch (NumberFormatException) {
                                }
                            }
                            yb.u v7_0;
                            if (v20_1 != -9223372036854775808) {
                                if (v20_1 == -1) {
                                    v7_0 = p36;
                                    v18 = v27;
                                } else {
                                    if (v20_1 <= 9223372036854775) {
                                        v29_1 = (v20_1 * ((long) 1000));
                                    }
                                    long v29_2 = (v8_11 + v29_1);
                                    if ((v29_2 >= v8_11) && (v29_2 <= 253402300799999)) {
                                        v7_0 = p36;
                                        v18 = v29_2;
                                    } else {
                                        v7_0 = p36;
                                    }
                                }
                            } else {
                                v7_0 = p36;
                                v18 = -9223372036854775808;
                            }
                            boolean v0_0 = v7_0.d;
                            if (v4_0) {
                                if ((!kotlin.jvm.internal.f.a(v0_0, v4_0)) && ((!db.p.K(v0_0, v4_0, 0)) || ((v0_0.charAt(((v0_0.length() - v4_0.length()) - 1)) != 46) || (zb.b.a.b(v0_0))))) {
                                    v15_1 = 0;
                                    if (v15_1 != null) {
                                        if (v6_0 == null) {
                                            v6_0 = new java.util.ArrayList();
                                        }
                                        v6_0.add(v15_1);
                                    }
                                    v5++;
                                }
                            } else {
                                v4_0 = v0_0;
                            }
                            if ((v0_0.length() == v4_0.length()) || (lc.b.d.a(v4_0) != null)) {
                                boolean v0_4 = "/";
                                if ((v13_0 == null) || (!db.p.Q(v13_0, "/", 0))) {
                                    boolean v8_10 = v7_0.b();
                                    int v9_3 = db.i.c0(v8_10, 47, 0, 6);
                                    if (v9_3 != 0) {
                                        v0_4 = v8_10.substring(0, v9_3);
                                    }
                                    v13_0 = v0_4;
                                }
                                v15_1 = new yb.p(v16, v17, v18, v4_0, v13_0, v22, v23, v24, v25, v26);
                            }
                        }
                    }
                }
            }
            boolean v4_1;
            if (v6_0 == null) {
                v4_1 = 0;
            } else {
                v4_1 = java.util.Collections.unmodifiableList(v6_0);
                v4_1.getClass();
            }
            if (!v4_1) {
                v4_1 = kotlin.collections.EmptyList.g;
            }
            v4_1.isEmpty();
            return;
        } else {
            return;
        }
    }
}
