// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ac;
public final class b implements yb.v {
    public final synthetic int a;
    public final Object b;

    public b(yb.b p2)
    {
        this.a = 1;
        p2.getClass();
        this.b = p2;
        return;
    }

    public b(yb.g p2)
    {
        this.a = 0;
        this.b = p2;
        return;
    }

    public b(yb.y p2)
    {
        this.a = 2;
        p2.getClass();
        this.b = p2;
        return;
    }

    public static int d(yb.b0 p1, int p2)
    {
        int v1_5 = p1.l.a("Retry-After");
        if (v1_5 == 0) {
            v1_5 = 0;
        }
        if (v1_5 != 0) {
            if (!new kotlin.text.Regex("\\d+").b(v1_5)) {
                return 2147483647;
            } else {
                int v1_3 = Integer.valueOf(v1_5);
                v1_3.getClass();
                return v1_3.intValue();
            }
        } else {
            return p2;
        }
    }

    public final yb.b0 a(dc.g p45)
    {
        switch (this.a) {
            case 0:
                d9.e v15_0;
                yb.b0 v0_14 = ((yb.g) this.b);
                if (v0_14 == null) {
                    v15_0 = 0;
                } else {
                    a0.i v3_3 = p45.e;
                    String v4_7 = ((yb.u) v3_3.b);
                    try {
                        yb.b0 v0_16 = v0_14.g.B(com.bumptech.glide.d.v(v4_7));
                    } catch (java.io.IOException) {
                        yb.b0 v0_22 = 0;
                        v15_0 = v0_22;
                    }
                    if (v0_16 != null) {
                        try {
                            int v13_3;
                            String v5_8 = new yb.e(((oc.d0) v0_16.i.get(0)));
                            g7.c1 v6_3 = v5_8.c;
                            StringBuilder v7_0 = v5_8.b;
                            int v8_2 = v5_8.a;
                            String v9_2 = v5_8.g;
                            long v10_3 = v9_2.a("Content-Type");
                            String v11_4 = v9_2.a("Content-Length");
                            v8_2.getClass();
                            v7_0.getClass();
                            v6_3.getClass();
                            int v14_2 = new androidx.lifecycle.d1();
                            v14_2.g = v8_2;
                            v14_2.i = v7_0.c();
                        } catch (java.io.IOException) {
                            zb.c.a(v0_16);
                        }
                        if (v6_3.equals("\u0000")) {
                            v13_3 = "GET";
                        } else {
                            v13_3 = v6_3;
                        }
                        v14_2.b(v13_3, 0);
                        int v12_2 = new lc.a(v14_2);
                        new java.util.ArrayList(20);
                        int v13_5 = v5_8.d;
                        v13_5.getClass();
                        int v14_4 = v5_8.e;
                        d9.e v15_4 = v5_8.f;
                        v15_4.getClass();
                        String v9_3 = v9_2.c();
                        yb.b0 v0_17 = v5_8.h;
                        long v33_0 = new yb.d(v0_16, v10_3, v11_4);
                        long v38_0 = v5_8.i;
                        String v9_6 = v5_8.j;
                        if (v14_4 < 0) {
                            throw new IllegalStateException(r1.a.g(v14_4, "code < 0: ").toString());
                        } else {
                            yb.s v32_0 = v9_3.h();
                            v0_22 = new yb.b0(v12_2, v13_5, v15_4, v14_4, v0_17, v32_0, v33_0, 0, 0, 0, 0, v38_0, v9_6, 0, yb.f0.a);
                            if ((v8_2.equals(v4_7)) && (v6_3.equals(((String) v3_3.g)))) {
                                String v4_14 = com.bumptech.glide.d.F(v32_0);
                                if (!v4_14.isEmpty()) {
                                    String v4_15 = v4_14.iterator();
                                    while (v4_15.hasNext()) {
                                        String v5_12 = ((String) v4_15.next());
                                        if (!v7_0.f(v5_12).equals(((yb.s) v3_3.c).f(v5_12))) {
                                        }
                                    }
                                }
                            }
                            zb.c.a(v0_22.m);
                        }
                    }
                }
                boolean v19_0;
                long v10_5;
                int v14_7;
                yb.a v21_0;
                StringBuilder v7_1;
                int v18_2;
                boolean v20_0;
                a3.f v22_0;
                int v8_5;
                a0.i v3_6 = System.currentTimeMillis();
                yb.b0 v0_24 = p45.e;
                if (v15_0 == null) {
                    v7_1 = -1;
                    v8_5 = 0;
                    v10_5 = 0;
                    v14_7 = 0;
                    v18_2 = 0;
                    v19_0 = 0;
                    v20_0 = 0;
                    v21_0 = 0;
                    v22_0 = 0;
                } else {
                    v8_5 = v15_0.r;
                    v10_5 = v15_0.s;
                    int v12_3 = v15_0.l;
                    int v13_6 = v12_3.size();
                    g7.c1 v6_5 = 0;
                    v7_1 = -1;
                    v14_7 = 0;
                    v18_2 = 0;
                    v19_0 = 0;
                    v20_0 = 0;
                    v21_0 = 0;
                    v22_0 = 0;
                    while (v6_5 < v13_6) {
                        String v5_44 = v12_3.b(v6_5);
                        yb.b0 v28_4 = v3_6;
                        a0.i v3_60 = v12_3.e(v6_5);
                        if (!v5_44.equalsIgnoreCase("Date")) {
                            if (!v5_44.equalsIgnoreCase("Expires")) {
                                if (!v5_44.equalsIgnoreCase("Last-Modified")) {
                                    if (!v5_44.equalsIgnoreCase("ETag")) {
                                        if (v5_44.equalsIgnoreCase("Age")) {
                                            v7_1 = zb.c.n(-1, v3_60);
                                        }
                                    } else {
                                        v20_0 = v3_60;
                                    }
                                } else {
                                    v21_0 = v3_60;
                                    v18_2 = dc.c.a(v3_60);
                                }
                            } else {
                                v14_7 = dc.c.a(v3_60);
                            }
                        } else {
                            v22_0 = v3_60;
                            v19_0 = dc.c.a(v3_60);
                        }
                        v6_5++;
                        v3_6 = v28_4;
                    }
                }
                a0.i v3_18;
                yb.b0 v28_1 = v3_6;
                String v5_15 = java.util.concurrent.TimeUnit.SECONDS;
                if (v15_0 != null) {
                    g7.c1 v6_8 = ((yb.s) v0_24.c);
                    if ((!((yb.u) v0_24.b).f()) || (v15_0.k != null)) {
                        if (com.bumptech.glide.f.x(v15_0, v0_24)) {
                            int v12_6 = ((yb.h) v0_24.f);
                            if (v12_6 == 0) {
                                v12_6 = com.bumptech.glide.e.m(((yb.s) v0_24.c));
                                v0_24.f = v12_6;
                            }
                            if ((!v12_6.a) && ((v6_8.a("If-Modified-Since") == null) && (v6_8.a("If-None-Match") == null))) {
                                long v31_1;
                                long v33_1;
                                a0.i v3_8;
                                String[] v34_1;
                                int v13_15 = v15_0.d();
                                if (!v19_0) {
                                    v33_1 = "If-None-Match";
                                    v34_1 = "If-Modified-Since";
                                    v31_1 = v8_5;
                                    v3_8 = 0;
                                } else {
                                    v33_1 = "If-None-Match";
                                    v34_1 = "If-Modified-Since";
                                    v31_1 = v8_5;
                                    v3_8 = Math.max(0, (v10_5 - v19_0.getTime()));
                                }
                                if (v7_1 != -1) {
                                    v3_8 = Math.max(v3_8, v5_15.toMillis(((long) v7_1)));
                                }
                                g7.c1 v6_21;
                                long v26_3;
                                String v9_7 = v6_8;
                                a0.i v3_12 = ((v3_8 + Math.max(0, (v10_5 - v31_1))) + Math.max(0, (v28_1 - v10_5)));
                                g7.c1 v6_12 = v15_0.d().c;
                                if (v6_12 == -1) {
                                    if (v14_7 == 0) {
                                        if (v18_2 == 0) {
                                            v26_3 = 0;
                                        } else {
                                            g7.c1 v6_17;
                                            g7.c1 v6_16 = ((yb.u) v15_0.g.b).f;
                                            if (v6_16 != null) {
                                                StringBuilder v7_7 = new StringBuilder();
                                                yb.b.b(v6_16, v7_7);
                                                v6_17 = v7_7.toString();
                                            } else {
                                                v6_17 = 0;
                                            }
                                            if (v6_17 != null) {
                                            } else {
                                                if (v19_0) {
                                                    v31_1 = v19_0.getTime();
                                                }
                                                long v31_3 = (v31_1 - v18_2.getTime());
                                                v26_3 = 0;
                                                if (v31_3 > 0) {
                                                    v6_21 = (v31_3 / ((long) 10));
                                                    int v8_11 = v12_6.c;
                                                    if (v8_11 != -1) {
                                                        v6_21 = Math.min(v6_21, v5_15.toMillis(((long) v8_11)));
                                                    }
                                                    long v10_10;
                                                    int v8_12 = v12_6.i;
                                                    if (v8_12 == -1) {
                                                        v10_10 = v26_3;
                                                    } else {
                                                        v10_10 = v5_15.toMillis(((long) v8_12));
                                                    }
                                                    yb.b0 v28_2;
                                                    a0.i v3_13;
                                                    if (v13_15.g) {
                                                        v28_2 = v3_12;
                                                        v3_13 = v26_3;
                                                    } else {
                                                        int v8_14 = v12_6.h;
                                                        if (v8_14 == -1) {
                                                        } else {
                                                            v28_2 = v3_12;
                                                            v3_13 = v5_15.toMillis(((long) v8_14));
                                                        }
                                                    }
                                                    if (!v13_15.a) {
                                                        long v10_12 = (v28_2 + v10_10);
                                                        if (v10_12 < (v3_13 + v6_21)) {
                                                            a0.i v3_22 = v15_0.h();
                                                            if (v10_12 >= v6_21) {
                                                                g7.c1 v6_26 = v3_22.f;
                                                                v6_26.getClass();
                                                                com.bumptech.glide.j.Q("Warning");
                                                                com.bumptech.glide.j.R("110 HttpURLConnection \"Response is stale\"", "Warning");
                                                                com.bumptech.glide.j.G(v6_26, "Warning", "110 HttpURLConnection \"Response is stale\"");
                                                            }
                                                            if ((v28_2 > 86400000) && ((v15_0.d().c == -1) && (v14_7 == 0))) {
                                                                g7.c1 v6_27 = v3_22.f;
                                                                v6_27.getClass();
                                                                com.bumptech.glide.j.Q("Warning");
                                                                com.bumptech.glide.j.R("113 HttpURLConnection \"Heuristic expiration\"", "Warning");
                                                                com.bumptech.glide.j.G(v6_27, "Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                                                            }
                                                            v3_18 = new a0.i(3, 0, v3_22.a());
                                                            int v12_14;
                                                            if (((lc.a) v3_18.h) == null) {
                                                                v12_14 = 0;
                                                            } else {
                                                                String v4_34 = ((yb.h) v0_24.f);
                                                                if (v4_34 == null) {
                                                                    v4_34 = com.bumptech.glide.e.m(((yb.s) v0_24.c));
                                                                    v0_24.f = v4_34;
                                                                }
                                                                if (!v4_34.j) {
                                                                } else {
                                                                    v12_14 = 0;
                                                                    v3_18 = new a0.i(3, 0, 0);
                                                                }
                                                            }
                                                            yb.b0 v0_28 = ((lc.a) v3_18.h);
                                                            a0.i v3_30 = ((yb.b0) v3_18.i);
                                                            // Both branches of the condition point to the same code.
                                                            // if (((yb.g) this.b) == null) {
                                                                if ((v15_0 != null) && (v3_30 == null)) {
                                                                    zb.c.a(v15_0.m);
                                                                }
                                                                if ((v0_28 != null) || (v3_30 != null)) {
                                                                    if (v0_28 != null) {
                                                                        try {
                                                                            yb.b0 v0_38;
                                                                            yb.a0 v2_12 = p45.b(v0_28);
                                                                        } catch (yb.b0 v0_29) {
                                                                            if (v15_0 != null) {
                                                                                zb.c.a(v15_0.m);
                                                                            }
                                                                            throw v0_29;
                                                                        }
                                                                        try {
                                                                            if (v3_30 == null) {
                                                                                d9.e v15_5;
                                                                                String v4_42 = v2_12.h();
                                                                                if (v3_30 == null) {
                                                                                    v15_5 = v12_14;
                                                                                } else {
                                                                                    v15_5 = com.bumptech.glide.i.u(v3_30);
                                                                                }
                                                                                yb.a0.b("cacheResponse", v15_5);
                                                                                v4_42.j = v15_5;
                                                                                yb.a0 v2_14 = com.bumptech.glide.i.u(v2_12);
                                                                                yb.a0.b("networkResponse", v2_14);
                                                                                v4_42.i = v2_14;
                                                                                yb.a0 v2_15 = v4_42.a();
                                                                                try {
                                                                                    if (((yb.g) this.b) != null) {
                                                                                        if ((!dc.f.a(v2_15)) || (!com.bumptech.glide.f.x(v2_15, v0_28))) {
                                                                                            if (com.bumptech.glide.f.w(((String) v0_28.g))) {
                                                                                                ((yb.g) this.b).d(v0_28);
                                                                                            }
                                                                                        } else {
                                                                                            a0.i v3_43 = ((yb.g) this.b);
                                                                                            String v4_43 = v2_15.h();
                                                                                            v4_43.a = v0_28;
                                                                                            yb.b0 v0_30 = v4_43.a();
                                                                                            v3_43.getClass();
                                                                                            String v4_44 = v0_30.g;
                                                                                            String v5_23 = ((String) v4_44.g);
                                                                                            try {
                                                                                                if (!com.bumptech.glide.f.w(v5_23)) {
                                                                                                    if ((v5_23.equals("GET")) && (!com.bumptech.glide.d.F(v0_30.l).contains("*"))) {
                                                                                                        String v5_29 = new yb.e(v0_30);
                                                                                                        try {
                                                                                                            d9.e v15_6 = v3_43.g.i(com.bumptech.glide.d.v(((yb.u) v4_44.b)), -1);
                                                                                                        } catch (java.io.IOException) {
                                                                                                            d9.e v15_7 = v12_14;
                                                                                                            if (v15_7 == null) {
                                                                                                                v15_7 = v12_14;
                                                                                                            } else {
                                                                                                                v15_7.a();
                                                                                                            }
                                                                                                        } catch (java.io.IOException) {
                                                                                                        }
                                                                                                        if (v15_6 != null) {
                                                                                                            v5_29.c(v15_6);
                                                                                                            yb.b0 v0_33 = new d9.e();
                                                                                                            v0_33.e = v3_43;
                                                                                                            v0_33.b = v15_6;
                                                                                                            String v4_48 = v15_6.i(1);
                                                                                                            v0_33.c = v4_48;
                                                                                                            v0_33.d = new yb.f(v3_43, v0_33, v4_48);
                                                                                                            v15_7 = v0_33;
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    v3_43.d(v4_44);
                                                                                                }
                                                                                            } catch (java.io.IOException) {
                                                                                            }
                                                                                            if (v15_7 != null) {
                                                                                                int v8_16;
                                                                                                yb.b0 v0_35 = ((yb.f) v15_7.d);
                                                                                                a0.i v3_45 = v2_15.m.i();
                                                                                                v0_35.getClass();
                                                                                                yb.b0 v0_37 = new ac.a(v3_45, v15_7, new oc.x(v0_35));
                                                                                                a0.i v3_47 = v2_15.l.a("Content-Type");
                                                                                                if (v3_47 != null) {
                                                                                                    v8_16 = v3_47;
                                                                                                } else {
                                                                                                    v8_16 = v12_14;
                                                                                                }
                                                                                                a0.i v3_49 = v2_15.m.d();
                                                                                                yb.a0 v2_16 = v2_15.h();
                                                                                                v2_16.g = new dc.h(v8_16, v3_49, new oc.y(v0_37));
                                                                                                v0_38 = v2_16.a();
                                                                                                long v26_5 = v0_38;
                                                                                                return v26_5;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                } catch (java.io.IOException) {
                                                                                }
                                                                                v26_5 = v2_15;
                                                                                return v26_5;
                                                                            } else {
                                                                                if (v2_12.j != 304) {
                                                                                    zb.c.a(v3_30.m);
                                                                                } else {
                                                                                    yb.b0 v0_39 = v3_30.h();
                                                                                    String v4_52 = v3_30.l;
                                                                                    String v5_35 = v2_12.l;
                                                                                    g7.c1 v6_36 = new java.util.ArrayList(20);
                                                                                    StringBuilder v7_8 = v4_52.size();
                                                                                    int v8_17 = 0;
                                                                                    while (v8_17 < v7_8) {
                                                                                        String v9_19 = v4_52.b(v8_17);
                                                                                        long v10_15 = v4_52.e(v8_17);
                                                                                        if (((!"Warning".equalsIgnoreCase(v9_19)) || (!db.p.Q(v10_15, "1", 0))) && (("Content-Length".equalsIgnoreCase(v9_19)) || (("Content-Encoding".equalsIgnoreCase(v9_19)) || (("Content-Type".equalsIgnoreCase(v9_19)) || ((!com.bumptech.glide.e.k(v9_19)) || (v5_35.a(v9_19) == null)))))) {
                                                                                            v6_36.add(v9_19);
                                                                                            v6_36.add(db.i.o0(v10_15).toString());
                                                                                        }
                                                                                        v8_17++;
                                                                                    }
                                                                                    String v4_53 = v5_35.size();
                                                                                    StringBuilder v7_9 = 0;
                                                                                    while (v7_9 < v4_53) {
                                                                                        int v8_19 = v5_35.b(v7_9);
                                                                                        if ((!"Content-Length".equalsIgnoreCase(v8_19)) && ((!"Content-Encoding".equalsIgnoreCase(v8_19)) && ((!"Content-Type".equalsIgnoreCase(v8_19)) && (com.bumptech.glide.e.k(v8_19))))) {
                                                                                            String v9_18 = v5_35.e(v7_9);
                                                                                            v6_36.add(v8_19);
                                                                                            v6_36.add(db.i.o0(v9_18).toString());
                                                                                        }
                                                                                        v7_9++;
                                                                                    }
                                                                                    String v5_36 = new String[0];
                                                                                    v0_39.f = new yb.s(((String[]) v6_36.toArray(v5_36))).c();
                                                                                    v0_39.l = v2_12.r;
                                                                                    v0_39.m = v2_12.s;
                                                                                    String v4_59 = com.bumptech.glide.i.u(v3_30);
                                                                                    yb.a0.b("cacheResponse", v4_59);
                                                                                    v0_39.j = v4_59;
                                                                                    String v4_60 = com.bumptech.glide.i.u(v2_12);
                                                                                    yb.a0.b("networkResponse", v4_60);
                                                                                    v0_39.i = v4_60;
                                                                                    v0_38 = v0_39.a();
                                                                                    v2_12.m.close();
                                                                                    ((yb.g) this.b).getClass();
                                                                                    ((yb.g) this.b).getClass();
                                                                                    yb.a0 v2_23 = new yb.e(v0_38);
                                                                                    a0.i v3_51 = v3_30.m;
                                                                                    v3_51.getClass();
                                                                                    a0.i v3_53 = ((yb.d) v3_51).h;
                                                                                    try {
                                                                                        int v8_18 = v3_53.j.i(v3_53.g, v3_53.h);
                                                                                    } catch (java.io.IOException) {
                                                                                        v8_18 = v12_14;
                                                                                        if (v8_18 != 0) {
                                                                                            v8_18.a();
                                                                                        }
                                                                                    } catch (java.io.IOException) {
                                                                                    }
                                                                                    if (v8_18 != 0) {
                                                                                        v2_23.c(v8_18);
                                                                                        v8_18.f();
                                                                                    }
                                                                                }
                                                                            }
                                                                        } catch (java.io.IOException) {
                                                                        }
                                                                    } else {
                                                                        v3_30.getClass();
                                                                        yb.b0 v0_40 = v3_30.h();
                                                                        yb.a0 v2_25 = com.bumptech.glide.i.u(v3_30);
                                                                        yb.a0.b("cacheResponse", v2_25);
                                                                        v0_40.j = v2_25;
                                                                        v26_5 = v0_40.a();
                                                                    }
                                                                } else {
                                                                    String v4_63 = new String[0];
                                                                    v26_5 = new yb.b0(p45.e, okhttp3.Protocol.j, "Unsatisfiable Request (only-if-cached)", 504, 0, new yb.s(((String[]) new java.util.ArrayList(20).toArray(v4_63))), yb.d0.g, 0, 0, 0, 0, -1, System.currentTimeMillis(), 0, yb.f0.a);
                                                                }
                                                                return v26_5;
                                                            // }
                                                        }
                                                    }
                                                    a0.i v3_19;
                                                    String v4_17;
                                                    if (!v20_0) {
                                                        if (v18_2 == 0) {
                                                            if (!v19_0) {
                                                                v3_18 = new a0.i(3, v0_24, 0);
                                                            } else {
                                                                v4_17 = v22_0;
                                                            }
                                                        } else {
                                                            v4_17 = v21_0;
                                                        }
                                                        v3_19 = v34_1;
                                                    } else {
                                                        v4_17 = v20_0;
                                                        v3_19 = v33_1;
                                                    }
                                                    String v5_17 = v9_7.c();
                                                    v4_17.getClass();
                                                    com.bumptech.glide.j.G(v5_17, v3_19, v4_17);
                                                    a0.i v3_20 = v0_24.f();
                                                    v3_20.i = v5_17.h().c();
                                                    v3_18 = new a0.i(3, new lc.a(v3_20), v15_0);
                                                }
                                            }
                                        }
                                        v6_21 = v26_3;
                                    } else {
                                        if (v19_0) {
                                            v10_5 = v19_0.getTime();
                                        }
                                        v6_21 = (v14_7.getTime() - v10_5);
                                        if (v6_21 <= 0) {
                                            v6_21 = 0;
                                            v26_3 = 0;
                                        }
                                    }
                                } else {
                                    v6_21 = v5_15.toMillis(((long) v6_12));
                                }
                            } else {
                                v3_18 = new a0.i(3, v0_24, 0);
                            }
                        } else {
                            v3_18 = new a0.i(3, v0_24, 0);
                        }
                    } else {
                        v3_18 = new a0.i(3, v0_24, 0);
                    }
                } else {
                    v3_18 = new a0.i(3, v0_24, 0);
                }
            case 1:
                g7.c1 v6_37 = ((yb.b) this.b);
                int v14_0 = p45.e;
                d9.e v15_2 = v14_0.f();
                a0.i v3_5 = ((yb.u) v14_0.b);
                String v4_9 = ((yb.s) v14_0.c);
                int v14_6 = ((yb.z) v14_0.d);
                if (v14_6 != 0) {
                    int v18_1 = v14_6;
                    int v14_8 = v18_1.b();
                    if (v14_8 != 0) {
                        v15_2.a("Content-Type", v14_8.a);
                    }
                    int v18_3 = v18_1.a();
                    if (v18_3 == -1) {
                        v15_2.a("Transfer-Encoding", "chunked");
                        ((g7.c1) v15_2.i).o("Content-Length");
                    } else {
                        v15_2.a("Content-Length", String.valueOf(v18_3));
                        ((g7.c1) v15_2.i).o("Transfer-Encoding");
                    }
                }
                if (v4_9.a("Host") == null) {
                    v15_2.a("Host", zb.e.h(v3_5, 0));
                }
                if (v4_9.a("Connection") == null) {
                    v15_2.a("Connection", "Keep-Alive");
                }
                if ((v4_9.a("Accept-Encoding") != null) || (v4_9.a("Range") != null)) {
                    int v25 = 0;
                } else {
                    v15_2.a("Accept-Encoding", "gzip");
                    v25 = 1;
                }
                v6_37.getClass();
                v3_5.getClass();
                if (v4_9.a("User-Agent") == null) {
                    v15_2.a("User-Agent", "okhttp/5.2.1");
                }
                a0.i v3_56 = new lc.a(v15_2);
                yb.a0 v2_24 = p45.b(v3_56);
                String v4_62 = v2_24.l;
                dc.f.b(v6_37, ((yb.u) v3_56.b), v4_62);
                String v5_45 = v2_24.h();
                v5_45.a = v3_56;
                if (v25 != 0) {
                    a0.i v3_62 = v4_62.a("Content-Encoding");
                    if (v3_62 == null) {
                        v3_62 = 0;
                    }
                    if (("gzip".equalsIgnoreCase(v3_62)) && (dc.f.a(v2_24))) {
                        yb.a0 v2_30 = v2_24.m;
                        if (v2_30 != null) {
                            int v8_1;
                            a0.i v3_1 = new oc.s(v2_30.i());
                            yb.a0 v2_6 = v4_62.c();
                            v2_6.o("Content-Encoding");
                            v2_6.o("Content-Length");
                            v5_45.f = v2_6.h().c();
                            yb.b0 v0_9 = v4_62.a("Content-Type");
                            if (v0_9 != null) {
                                v8_1 = v0_9;
                            } else {
                                v8_1 = 0;
                            }
                            v5_45.g = new dc.h(v8_1, -1, new oc.y(v3_1));
                        }
                    }
                }
                return v5_45.a();
            default:
                a0.i v3_63 = p45.a;
                String v9_1 = kotlin.collections.EmptyList.g;
                long v10_0 = 0;
                String v11_0 = 0;
                String v4_4 = p45.e;
                while(true) {
                    yb.b0 v0_0 = 1;
                    int v8_0;
                    if (v3_63.p != null) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Check failed.");
                        v8_0 = 0;
                    } else {
                        if (v3_63.r) {
                            break;
                        }
                        if (v3_63.q) {
                            throw new IllegalStateException("Check failed.");
                        } else {
                            if (v0_0 != null) {
                                long v31_5;
                                yb.s v32_2;
                                long v33_3;
                                yb.b0 v0_51 = v3_63.g;
                                int v13_23 = v0_51.B;
                                int v14_18 = v3_63.i;
                                d9.e v15_8 = v0_51.y;
                                int v12_18 = v0_51.z;
                                int v8_23 = p45.f;
                                StringBuilder v7_11 = p45.g;
                                g7.c1 v6_39 = v0_51.f;
                                boolean v19_1 = v0_51.e;
                                String v5_48 = ((yb.u) v4_4.b);
                                v5_48.getClass();
                                boolean v20_1 = v6_39;
                                if (!v5_48.f()) {
                                    v31_5 = 0;
                                    v32_2 = 0;
                                    v33_3 = 0;
                                } else {
                                    g7.c1 v6_40 = v0_51.p;
                                    if (v6_40 == null) {
                                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("CLEARTEXT-only client");
                                    } else {
                                        v33_3 = v0_51.u;
                                        v31_5 = v6_40;
                                        v32_2 = v0_51.t;
                                    }
                                }
                                String v5_61;
                                yb.a v21_1 = new yb.a;
                                v21_1(v5_48.d, v5_48.e, v0_51.l, v0_51.o, v31_5, v32_2, v33_3, v0_51.n, v0_51.s, v0_51.r, v0_51.m);
                                int v12_20 = new cc.u(v13_23, v14_18, v15_8, v12_18, v8_23, v7_11, v19_1, v20_1, v21_1, v3_63.g.A, new cc.a(v3_63, v3_63.i.a, p45));
                                yb.b0 v0_56 = v3_63.g;
                                if (!v0_56.f) {
                                    v5_61 = new cc.n(v12_20);
                                } else {
                                    v5_61 = new cc.m(v12_20, v0_56.B);
                                }
                                v3_63.m = v5_61;
                            }
                            if (v3_63.t) {
                                throw new java.io.IOException("Canceled");
                            } else {
                                String v4_3;
                                yb.b0 v0_1 = p45.b(v4_4).h();
                                v0_1.a = v4_4;
                                if (v10_0 == 0) {
                                    v4_3 = 0;
                                } else {
                                    v4_3 = com.bumptech.glide.i.u(v10_0);
                                }
                                v0_1.k = v4_3;
                                v10_0 = v0_1.a();
                                v4_4 = this.b(v10_0, v3_63.p);
                                if (v4_4 != null) {
                                    zb.c.a(v10_0.m);
                                    v11_0++;
                                    if (v11_0 > 20) {
                                        yb.a0 v2_4 = new StringBuilder();
                                        v2_4.append("Too many follow-up requests: ");
                                        v2_4.append(v11_0);
                                        throw new java.net.ProtocolException(v2_4.toString());
                                    } else {
                                        v3_63.e(1);
                                    }
                                } else {
                                    v3_63.e(0);
                                    v8_0 = v10_0;
                                }
                            }
                        }
                    }
                    return v8_0;
                }
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
        }
    }

    public lc.a b(yb.b0 p12, cc.i p13)
    {
        androidx.lifecycle.d1 v1_2;
        yb.z v0_0 = 0;
        if (p13 == null) {
            v1_2 = 0;
        } else {
            v1_2 = p13.b().d;
        }
        int v2_9 = p12.j;
        String v3_2 = ((String) p12.g.g);
        int v4 = 0;
        if ((v2_9 == 307) || (v2_9 == 308)) {
            androidx.lifecycle.d1 v1_18 = ((yb.y) this.b);
            if (v1_18.h) {
                int v2_1 = p12.l.a("Location");
                if (v2_1 == 0) {
                    v2_1 = 0;
                }
                lc.a v8_1 = p12.g;
                if (v2_1 != 0) {
                    boolean v9_1 = ((yb.u) v8_1.b);
                    v9_1.getClass();
                    try {
                        String v10_1 = new yb.t();
                        v10_1.c(v9_1, v2_1);
                    } catch (IllegalArgumentException) {
                        v10_1 = 0;
                    }
                    int v2_2;
                    if (v10_1 == null) {
                        v2_2 = 0;
                    } else {
                        v2_2 = v10_1.a();
                    }
                    if ((v2_2 != 0) && ((kotlin.jvm.internal.f.a(v2_2.a, ((yb.u) v8_1.b).a)) || (v1_18.i))) {
                        androidx.lifecycle.d1 v1_1 = v8_1.f();
                        if (com.bumptech.glide.f.B(v3_2)) {
                            String v12_1 = p12.j;
                            if ((v3_2.equals("PROPFIND")) || ((v12_1 == 308) || (v12_1 == 307))) {
                                v4 = 1;
                            }
                            if ((v3_2.equals("PROPFIND")) || ((v12_1 == 308) || (v12_1 == 307))) {
                                if (v4 != 0) {
                                    v0_0 = ((yb.z) v8_1.d);
                                }
                                v1_1.b(v3_2, v0_0);
                            } else {
                                v1_1.b("GET", 0);
                            }
                            if (v4 == 0) {
                                ((g7.c1) v1_1.i).o("Transfer-Encoding");
                                ((g7.c1) v1_1.i).o("Content-Length");
                                ((g7.c1) v1_1.i).o("Content-Type");
                            }
                        }
                        if (!zb.e.a(((yb.u) v8_1.b), v2_2)) {
                            ((g7.c1) v1_1.i).o("Authorization");
                        }
                        v1_1.g = v2_2;
                        return new lc.a(v1_1);
                    }
                }
            }
        } else {
            if (v2_9 == 401) {
                ((yb.y) this.b).g.getClass();
                return 0;
            } else {
                if (v2_9 == 421) {
                    if ((p13 != null) && (!kotlin.jvm.internal.f.a(p13.b.c().d().h.d, p13.c.i().h().a.h.d))) {
                        try {
                            p13.b().m = 1;
                            return p12.g;
                        } catch (String v12_17) {
                            throw v12_17;
                        }
                    }
                } else {
                    if (v2_9 == 503) {
                        androidx.lifecycle.d1 v1_10 = p12.q;
                        if (((v1_10 == null) || (v1_10.j != 503)) && (ac.b.d(p12, 2147483647) == 0)) {
                            return p12.g;
                        }
                    } else {
                        if (v2_9 == 407) {
                            v1_2.getClass();
                            if (v1_2.b.type() != java.net.Proxy$Type.HTTP) {
                                throw new java.net.ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                            } else {
                                ((yb.y) this.b).n.getClass();
                                return 0;
                            }
                        } else {
                            if (v2_9 == 408) {
                                if (((yb.y) this.b).e) {
                                    androidx.lifecycle.d1 v1_15 = p12.q;
                                    if (((v1_15 == null) || (v1_15.j != 408)) && (ac.b.d(p12, 0) <= 0)) {
                                        return p12.g;
                                    }
                                }
                            } else {
                                switch (v2_9) {
                                    default:
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public boolean c(java.io.IOException p2, cc.r p3, lc.a p4)
    {
        int v4_0 = (p2 instanceof okhttp3.internal.http2.ConnectionShutdownException);
        if (((((yb.y) this.b).e) && ((v4_0 != 0) || (!(p2 instanceof java.io.FileNotFoundException)))) && (!(p2 instanceof java.net.ProtocolException))) {
            if (!(p2 instanceof java.io.InterruptedIOException)) {
                if ((((p2 instanceof javax.net.ssl.SSLHandshakeException)) && ((p2.getCause() instanceof java.security.cert.CertificateException))) || ((p2 instanceof javax.net.ssl.SSLPeerUnverifiedException))) {
                    return 0;
                }
            } else {
                if ((!(p2 instanceof java.net.SocketTimeoutException)) || (v4_0 == 0)) {
                    return 0;
                }
            }
            boolean v2_3 = p3.u;
            if ((v2_3) && (v2_3.e == 1)) {
                int v3_2;
                boolean v2_5 = p3.m;
                v2_5.getClass();
                boolean v2_6 = v2_5.c();
                int v3_1 = p3.u;
                if (v3_1 == 0) {
                    v3_2 = 0;
                } else {
                    v3_2 = v3_1.b();
                }
                if (v2_6.a(v3_2)) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
