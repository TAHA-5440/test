// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class e {
    public static final String k;
    public static final String l;
    public final yb.u a;
    public final yb.s b;
    public final String c;
    public final okhttp3.Protocol d;
    public final int e;
    public final String f;
    public final yb.s g;
    public final yb.r h;
    public final long i;
    public final long j;

    static e()
    {
        ic.e.a.getClass();
        yb.e.k = "OkHttp-Sent-Millis";
        ic.e.a.getClass();
        yb.e.l = "OkHttp-Received-Millis";
        return;
    }

    public e(oc.d0 p12)
    {
        p12.getClass();
        okhttp3.TlsVersion v1_6 = new oc.y(p12);
        java.util.List v4_6 = v1_6.y(9223372036854775807);
        try {
            int v6_0 = new yb.t();
            v6_0.c(0, v4_6);
            int v6_4 = v6_0.a();
        } catch (IllegalArgumentException) {
            v6_4 = 0;
        }
        if (v6_4 == 0) {
            okhttp3.TlsVersion v1_4 = new java.io.IOException("Cache corruption for ".concat(v4_6));
            ic.e.a.i(5, "cache corruption", v1_4);
            throw v1_4;
        } else {
            this.a = v6_4;
            this.c = v1_6.y(9223372036854775807);
            int v6_5 = 0;
            String v0_8 = new g7.c1(10, 0);
            String v7_1 = com.bumptech.glide.d.y(v1_6);
            String v8_0 = 0;
            while (v8_0 < v7_1) {
                v0_8.b(v1_6.y(9223372036854775807));
                v8_0++;
            }
            this.b = v0_8.h();
            String v0_11 = com.bumptech.glide.g.r(v1_6.y(9223372036854775807));
            this.d = ((okhttp3.Protocol) v0_11.c);
            this.e = v0_11.b;
            this.f = ((String) v0_11.d);
            String v0_15 = new g7.c1(10, 0);
            java.util.List v4_4 = com.bumptech.glide.d.y(v1_6);
            while (v6_5 < v4_4) {
                v0_15.b(v1_6.y(9223372036854775807));
                v6_5++;
            }
            int v6_7;
            java.util.List v4_5 = yb.e.k;
            int v6_6 = v0_15.i(v4_5);
            String v7_5 = yb.e.l;
            String v8_1 = v0_15.i(v7_5);
            v0_15.o(v4_5);
            v0_15.o(v7_5);
            long v9_1 = 0;
            if (v6_6 == 0) {
                v6_7 = 0;
            } else {
                v6_7 = Long.parseLong(v6_6);
            }
            this.i = v6_7;
            if (v8_1 != null) {
                v9_1 = Long.parseLong(v8_1);
            }
            this.j = v9_1;
            this.g = v0_15.h();
            if (!this.a.f()) {
                this.h = 0;
            } else {
                String v0_19 = v1_6.y(9223372036854775807);
                if (v0_19.length() > 0) {
                    java.util.List v2_4 = new StringBuilder();
                    v2_4.append("expected \"\" but was \"");
                    v2_4.append(v0_19);
                    v2_4.append(34);
                    throw new java.io.IOException(v2_4.toString());
                } else {
                    okhttp3.TlsVersion v1_0;
                    String v0_2 = yb.m.b.d(v1_6.y(9223372036854775807));
                    java.util.List v4_1 = yb.e.a(v1_6);
                    androidx.activity.e v5_0 = yb.e.a(v1_6);
                    if (v1_6.d()) {
                        v1_0 = okhttp3.TlsVersion.m;
                    } else {
                        okhttp3.TlsVersion v1_1 = v1_6.y(9223372036854775807);
                        okhttp3.TlsVersion.h.getClass();
                        v1_0 = yb.b.c(v1_1);
                    }
                    this.h = new yb.r(v1_0, v0_2, zb.e.i(v5_0), new androidx.activity.e(zb.e.i(v4_1), 14));
                }
            }
            p12.close();
            return;
        }
    }

    public e(yb.b0 p11)
    {
        yb.s v1_2;
        long v0_0 = p11.g;
        this.a = ((yb.u) v0_0.b);
        yb.s v1_4 = p11.o;
        v1_4.getClass();
        yb.s v1_7 = ((yb.s) v1_4.g.c);
        yb.s v2 = p11.l;
        String[] v3_0 = com.bumptech.glide.d.F(v2);
        if (!v3_0.isEmpty()) {
            java.util.ArrayList v4_2 = new java.util.ArrayList(20);
            int v5_1 = v1_7.size();
            int v7 = 0;
            while (v7 < v5_1) {
                String v8_0 = v1_7.b(v7);
                if (v3_0.contains(v8_0)) {
                    String v9_1 = v1_7.e(v7);
                    com.bumptech.glide.j.Q(v8_0);
                    com.bumptech.glide.j.R(v9_1, v8_0);
                    v4_2.add(v8_0);
                    v4_2.add(db.i.o0(v9_1).toString());
                }
                v7++;
            }
            String[] v3_1 = new String[0];
            v1_2 = new yb.s(((String[]) v4_2.toArray(v3_1)));
        } else {
            v1_2 = yb.s.h;
        }
        this.b = v1_2;
        this.c = ((String) v0_0.g);
        this.d = p11.h;
        this.e = p11.j;
        this.f = p11.i;
        this.g = v2;
        this.h = p11.k;
        this.i = p11.r;
        this.j = p11.s;
        return;
    }

    public static java.util.List a(oc.y p8)
    {
        String v0_0 = com.bumptech.glide.d.y(p8);
        if (v0_0 != -1) {
            try {
                java.security.cert.CertificateFactory v1_2 = java.security.cert.CertificateFactory.getInstance("X.509");
                java.util.ArrayList v2_1 = new java.util.ArrayList(v0_0);
                int v4 = 0;
            } catch (java.io.IOException v8_3) {
                oc.l.g(v8_3.getMessage());
                return 0;
            }
            while (v4 < v0_0) {
                java.security.cert.Certificate v5_1 = p8.y(9223372036854775807);
                oc.i v6_1 = new oc.i();
                java.security.cert.Certificate v5_2 = n5.f.l(v5_1);
                if (v5_2 == null) {
                    throw new java.io.IOException("Corrupt certificate in cache entry");
                } else {
                    v6_1.m0(v5_2);
                    v2_1.add(v1_2.generateCertificate(new oc.h(v6_1, 0)));
                    v4++;
                }
            }
            return v2_1;
        } else {
            return kotlin.collections.EmptyList.g;
        }
    }

    public static void b(oc.x p3, java.util.List p4)
    {
        try {
            p3.Y(((long) p4.size()));
            p3.writeByte(10);
            java.util.Iterator v4_1 = p4.iterator();
        } catch (String v3_1) {
            oc.l.g(v3_1.getMessage());
            return;
        }
        while (v4_1.hasNext()) {
            String v1_2 = ((java.security.cert.Certificate) v4_1.next()).getEncoded();
            Class vtmp9 = v1_2.getClass();
            p3.G(n5.f.u(v1_2).a());
            p3.writeByte(10);
        }
        return;
    }

    public final void c(ac.e p12)
    {
        String v0_0 = this.a;
        yb.r v1 = this.h;
        long v2_0 = this.g;
        int v3_1 = this.b;
        int v4 = 0;
        oc.x v5_1 = new oc.x(p12.i(0));
        v5_1.G(v0_0.h);
        v5_1.writeByte(10);
        v5_1.G(this.c);
        v5_1.writeByte(10);
        v5_1.Y(((long) v3_1.size()));
        v5_1.writeByte(10);
        String v6_3 = v3_1.size();
        String v7_0 = 0;
        while (v7_0 < v6_3) {
            v5_1.G(v3_1.b(v7_0));
            v5_1.G(": ");
            v5_1.G(v3_1.e(v7_0));
            v5_1.writeByte(10);
            v7_0++;
        }
        int v3_0 = this.d;
        String v6_4 = this.e;
        String v7_1 = this.f;
        v3_0.getClass();
        v7_1.getClass();
        StringBuilder v9_1 = new StringBuilder();
        if (v3_0 != okhttp3.Protocol.i) {
            v9_1.append("HTTP/1.1");
        } else {
            v9_1.append("HTTP/1.0");
        }
        v9_1.append(32);
        v9_1.append(v6_4);
        v9_1.append(32);
        v9_1.append(v7_1);
        v5_1.G(v9_1.toString());
        v5_1.writeByte(10);
        v5_1.Y(((long) (v2_0.size() + 2)));
        v5_1.writeByte(10);
        int v3_8 = v2_0.size();
        while (v4 < v3_8) {
            v5_1.G(v2_0.b(v4));
            v5_1.G(": ");
            v5_1.G(v2_0.e(v4));
            v5_1.writeByte(10);
            v4++;
        }
        v5_1.G(yb.e.k);
        v5_1.G(": ");
        v5_1.Y(this.i);
        v5_1.writeByte(10);
        v5_1.G(yb.e.l);
        v5_1.G(": ");
        v5_1.Y(this.j);
        v5_1.writeByte(10);
        if (v0_0.f()) {
            v5_1.writeByte(10);
            v1.getClass();
            v5_1.G(v1.b.a);
            v5_1.writeByte(10);
            yb.e.b(v5_1, v1.a());
            yb.e.b(v5_1, v1.c);
            v5_1.G(v1.a.g);
            v5_1.writeByte(10);
        }
        v5_1.close();
        return;
    }
}
