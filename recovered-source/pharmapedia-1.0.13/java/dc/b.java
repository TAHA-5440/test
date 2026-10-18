// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package dc;
public final class b implements yb.v {
    public static final dc.b a;

    static b()
    {
        dc.b.a = new dc.b();
        return;
    }

    public final yb.b0 a(dc.g p17)
    {
        dc.h v9_8;
        StringBuilder v2_2 = p17.d;
        v2_2.getClass();
        long v3_4 = v2_2.c;
        int v4_7 = v2_2.a;
        int v5_10 = p17.e;
        String v0_24 = ((yb.z) v5_10.d);
        int v6_0 = ((yb.s) v5_10.c);
        long v7_0 = System.currentTimeMillis();
        if ((!com.bumptech.glide.f.B(((String) v5_10.g))) || (v0_24 == null)) {
            v9_8 = 0;
        } else {
            v9_8 = 1;
        }
        oc.y v13_3 = "upgrade".equalsIgnoreCase(v6_0.a("Connection"));
        try {
            int v6_4;
            v3_4.d(v5_10);
        } catch (String v0_16) {
            v2_2.d(v0_16);
            throw v0_16;
        }
        if (v13_3 != null) {
            v6_4 = 0;
        } else {
            if (v9_8 == null) {
                v4_7.g(v2_2, 1, 0, 0);
            } else {
                if (!"100-continue".equalsIgnoreCase(v6_0.a("Expect"))) {
                    v6_4 = 0;
                } else {
                    v3_4.g();
                    v6_4 = v2_2.c(1);
                }
                if (v6_4 != 0) {
                    String v0_21;
                    v4_7.g(v2_2, 1, 0, 0);
                    if (v2_2.b().k == null) {
                        v0_21 = 0;
                    } else {
                        v0_21 = 1;
                    }
                    if (v0_21 == null) {
                        v3_4.i().f();
                    }
                } else {
                    v0_24.getClass();
                    v0_24.getClass();
                    dc.h v9_15 = v0_24.a();
                    dc.h v9_17 = new oc.x(new cc.g(v2_2, v3_4.j(v5_10, v9_15), v9_15));
                    v0_24.c(v9_17);
                    v9_17.close();
                }
            }
        }
        try {
            v3_4.a();
            java.io.IOException v11_4 = 0;
        } catch (String v0_25) {
            v2_2.d(v0_25);
            throw v0_25;
        }
        if (v6_4 == 0) {
            v6_4 = v2_2.c(0);
            v6_4.getClass();
        }
        v6_4.a = v5_10;
        v6_4.e = v2_2.b().g;
        v6_4.l = v7_0;
        v6_4.m = System.currentTimeMillis();
        String v0_3 = v6_4.a();
        int v6_1 = v0_3.j;
        while(true) {
            dc.h v9_1 = v0_3.l;
            cc.h v10_0 = v0_3.m;
            if ((v6_1 != 100) && ((102 > v6_1) || (v6_1 >= 200))) {
                break;
            }
            String v0_14 = v2_2.c(0);
            v0_14.getClass();
            v0_14.a = v5_10;
            v0_14.e = v2_2.b().g;
            v0_14.l = v7_0;
            v0_14.m = System.currentTimeMillis();
            v0_3 = v0_14.a();
            v6_1 = v0_3.j;
        }
        int v5_1;
        if (v6_1 != 101) {
            v5_1 = 0;
        } else {
            v5_1 = 1;
        }
        if (v5_1 != 0) {
            long v7_3;
            if (v2_2.b().k == null) {
                v7_3 = 0;
            } else {
                v7_3 = 1;
            }
            if (v7_3 != 0) {
                throw new java.net.ProtocolException("Unexpected 101 code on HTTP/2 connection");
            } else {
            }
        }
        int v5_4;
        if (v5_1 == 0) {
            v5_4 = 0;
        } else {
            int v5_2 = v9_1.a("Connection");
            if (v5_2 == 0) {
                v5_2 = 0;
            }
            if (!"upgrade".equalsIgnoreCase(v5_2)) {
            } else {
                v5_4 = 1;
            }
        }
        if ((v13_3 == null) || (v5_4 == 0)) {
            int v5_5;
            if (v13_3 == null) {
                v5_5 = 0;
            } else {
                v5_5 = 0;
                v4_7.g(v2_2, 1, 0, 0);
            }
            int v4_1 = v9_1.a("Content-Type");
            if (v4_1 == 0) {
                v4_1 = v5_5;
            }
            long v7_5 = v3_4.c(v0_3);
            dc.h v9_7 = new dc.h(v4_1, v7_5, new oc.y(new cc.h(v2_2, v3_4.f(v0_3), v7_5)));
            String v0_7 = v0_3.h();
            v0_7.g = v9_7;
            v0_7.o = new dc.a();
            String v0_8 = v0_7.a();
        } else {
            String v0_9 = v0_3.h();
            v0_9.g = new zb.a(v10_0.h(), v10_0.d());
            v2_2.d = 1;
            if (v4_7.o) {
                throw new IllegalStateException("Check failed.");
            } else {
                v4_7.o = 1;
                v4_7.j.i();
                int v4_3 = v3_4.i();
                v4_3.getClass();
                int v4_4 = ((cc.s) v4_3);
                v4_4.f.setSoTimeout(0);
                v4_4.f();
                v0_9.h = new a0.i(v2_2);
                v0_8 = v0_9.a();
                v5_5 = 0;
            }
        }
        StringBuilder v2_3 = v0_8.g;
        v2_3.getClass();
        if ("close".equalsIgnoreCase(((yb.s) v2_3.c).a("Connection"))) {
            v3_4.i().f();
        } else {
            dc.a v15_3;
            StringBuilder v2_9 = v0_8.l.a("Connection");
            if (v2_9 != null) {
                v15_3 = v2_9;
            } else {
                v15_3 = v5_5;
            }
            if ("close".equalsIgnoreCase(v15_3)) {
            }
        }
        if (((v6_1 == 204) || (v6_1 == 205)) && (v0_8.m.d() > 0)) {
            StringBuilder v2_11 = new StringBuilder();
            v2_11.append("HTTP ");
            v2_11.append(v6_1);
            v2_11.append(" had non-zero Content-Length: ");
            v2_11.append(v0_8.m.d());
            throw new java.net.ProtocolException(v2_11.toString());
        } else {
            return v0_8;
        }
    }
}
