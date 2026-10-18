// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public final class s extends fc.l implements dc.d {
    public final bc.d b;
    public final cc.t c;
    public final yb.e0 d;
    public final java.net.Socket e;
    public final java.net.Socket f;
    public final yb.r g;
    public final okhttp3.Protocol h;
    public final androidx.lifecycle.j i;
    public final cc.f j;
    public fc.p k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public int q;
    public final java.util.ArrayList r;
    public long s;

    public s(bc.d p1, cc.t p2, yb.e0 p3, java.net.Socket p4, java.net.Socket p5, yb.r p6, okhttp3.Protocol p7, androidx.lifecycle.j p8, cc.f p9)
    {
        p1.getClass();
        p2.getClass();
        p3.getClass();
        p4.getClass();
        p5.getClass();
        p7.getClass();
        p8.getClass();
        this.b = p1;
        this.c = p2;
        this.d = p3;
        this.e = p4;
        this.f = p5;
        this.g = p6;
        this.h = p7;
        this.i = p8;
        this.j = p9;
        this.q = 1;
        this.r = new java.util.ArrayList();
        this.s = 9223372036854775807;
        return;
    }

    public static void d(yb.y p3, yb.e0 p4, java.io.IOException p5)
    {
        p3.getClass();
        p4.getClass();
        p5.getClass();
        if (p4.b.type() != java.net.Proxy$Type.DIRECT) {
            java.net.URI v0_4 = p4.a;
            v0_4.g.connectFailed(v0_4.h.i(), p4.b.address(), p5);
        }
        ((java.util.LinkedHashSet) p3.A.h).add(p4);
        return;
    }

    public final void a(cc.r p4, java.io.IOException p5)
    {
        if (!(p5 instanceof okhttp3.internal.http2.StreamResetException)) {
            yb.e0 v0_8;
            if (this.k == null) {
                v0_8 = 0;
            } else {
                v0_8 = 1;
            }
            if ((v0_8 == null) || ((p5 instanceof okhttp3.internal.http2.ConnectionShutdownException))) {
                this.l = 1;
                if (this.o == 0) {
                    if (p5 != null) {
                        cc.s.d(p4.g, this.d, p5);
                    }
                    this.n = (this.n + 1);
                }
            }
        } else {
            if (((okhttp3.internal.http2.StreamResetException) p5).g != okhttp3.internal.http2.ErrorCode.m) {
                if ((((okhttp3.internal.http2.StreamResetException) p5).g != okhttp3.internal.http2.ErrorCode.n) || (!p4.t)) {
                    this.l = 1;
                    this.n = (this.n + 1);
                }
            } else {
                int v4_8 = (this.p + 1);
                this.p = v4_8;
                if (v4_8 > 1) {
                    this.l = 1;
                    this.n = (this.n + 1);
                }
            }
        }
        return;
    }

    public final void b(fc.p p2, fc.c0 p3)
    {
        p3.getClass();
        bc.b v3_4;
        ac.i v2_0 = this.q;
        if ((p3.a & 8) == 0) {
            v3_4 = 2147483647;
        } else {
            v3_4 = p3.b[3];
        }
        this.q = v3_4;
        if (v3_4 >= v2_0) {
            if (v3_4 > v2_0) {
                ac.i v2_1 = this.c;
                bc.b.e(v2_1.d, v2_1.e);
            }
        } else {
            ac.i v2_3 = this.c;
            bc.b v3_3 = this.d.a;
            v2_3.getClass();
            v3_3.getClass();
            if (v2_3.c.get(v3_3) != null) {
                throw new ClassCastException();
            } else {
            }
        }
        return;
    }

    public final void c(fc.x p3)
    {
        p3.c(okhttp3.internal.http2.ErrorCode.m, 0);
        return;
    }

    public final void cancel()
    {
        zb.e.c(this.e);
        return;
    }

    public final boolean e(yb.a p9, java.util.List p10)
    {
        p9.getClass();
        yb.r v0_0 = p9.h;
        try {
            if ((this.r.size() < this.q) && (!this.l)) {
                boolean v1_0 = this.d;
                yb.a v4 = v1_0.a;
                if (v1_0.a.a(p9)) {
                    String v5 = v0_0.d;
                    if (!kotlin.jvm.internal.f.a(v0_0.d, v4.h.d)) {
                        if ((this.k != null) && ((p10) && (!p10.isEmpty()))) {
                            boolean v10_1 = p10.iterator();
                            while (v10_1.hasNext()) {
                                boolean v2_8 = ((yb.e0) v10_1.next());
                                java.net.Proxy$Type v7 = java.net.Proxy$Type.DIRECT;
                                if ((v2_8.b.type() == v7) && ((v1_0.b.type() == v7) && (kotlin.jvm.internal.f.a(v1_0.c, v2_8.c)))) {
                                    if (p9.d != mc.c.a) {
                                        break;
                                    }
                                    boolean v10_3 = v4.h;
                                    if (v0_0.e != v10_3.e) {
                                        break;
                                    }
                                    yb.r v0_2 = this.g;
                                    if (!kotlin.jvm.internal.f.a(v5, v10_3.d)) {
                                        if ((this.m) || (v0_2 == null)) {
                                            break;
                                        }
                                        boolean v10_7 = v0_2.a();
                                        if (v10_7.isEmpty()) {
                                            break;
                                        }
                                        boolean v10_8 = v10_7.get(0);
                                        v10_8.getClass();
                                        if (!mc.c.b(v5, ((java.security.cert.X509Certificate) v10_8))) {
                                            break;
                                        }
                                    }
                                    int v9_1 = p9.e;
                                    v9_1.getClass();
                                    v0_2.getClass();
                                    boolean v10_11 = v0_2.a();
                                    v5.getClass();
                                    v10_11.getClass();
                                    int v9_3 = v9_1.a.iterator();
                                    if (v9_3.hasNext()) {
                                        r1.a.z(v9_3.next());
                                        throw 0;
                                    }
                                }
                            }
                        } else {
                        }
                    }
                    return 1;
                }
            }
        } catch (javax.net.ssl.SSLPeerUnverifiedException) {
        }
        return 0;
    }

    public final void f()
    {
        try {
            this.l = 1;
            return;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    public final boolean g(boolean p10)
    {
        Throwable v0_0 = System.nanoTime();
        int v3 = 0;
        if ((!this.e.isClosed()) && ((!this.f.isClosed()) && ((!this.f.isInputShutdown()) && (!this.f.isOutputShutdown())))) {
            fc.p v2_5 = this.k;
            if (v2_5 == null) {
                try {
                    if (((v0_0 - this.s) < 10000000000) || (p10 == null)) {
                        return 1;
                    } else {
                        java.net.Socket v10_2 = this.f;
                        Throwable v0_5 = ((oc.y) this.i.i);
                        v10_2.getClass();
                        v0_5.getClass();
                        try {
                            int v1 = v10_2.getSoTimeout();
                        } catch (java.net.SocketTimeoutException) {
                            v3 = 1;
                            return v3;
                        } catch (java.io.IOException) {
                            return v3;
                        }
                        v10_2.setSoTimeout(1);
                        Throwable v0_7 = (v0_5.d() ^ 1);
                        v10_2.setSoTimeout(v1);
                        return v0_7;
                    }
                } catch (java.net.Socket v10_1) {
                    throw v10_1;
                }
            } else {
                try {
                    if (!v2_5.l) {
                        if ((v2_5.t >= v2_5.s) || (v0_0 < v2_5.u)) {
                            return 1;
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }
                } catch (java.net.Socket v10_5) {
                    throw v10_5;
                }
            }
        } else {
            return 0;
        }
    }

    public final yb.e0 h()
    {
        return this.d;
    }

    public final void i()
    {
        this.s = System.nanoTime();
        fc.o v0_4 = this.h;
        if ((v0_4 != okhttp3.Protocol.l) && (v0_4 != okhttp3.Protocol.m)) {
            return;
        } else {
            String v2_8;
            this.f.setSoTimeout(0);
            int v3_2 = this.b;
            v3_2.getClass();
            String v2_6 = new androidx.lifecycle.d1();
            v2_6.g = v3_2;
            v2_6.j = fc.l.a;
            v2_6.k = fc.a.a;
            int v3_5 = this.i;
            int v4_5 = this.d.a.h.d;
            v3_5.getClass();
            v4_5.getClass();
            v2_6.h = v3_5;
            int v3_7 = new StringBuilder();
            v3_7.append(zb.e.b);
            v3_7.append(32);
            v3_7.append(v4_5);
            v2_6.i = v3_7.toString();
            v2_6.j = this;
            v2_6.k = fc.a.a;
            fc.o v0_6 = new fc.p(v2_6);
            this.k = v0_6;
            String v2_7 = fc.p.F;
            if ((v2_7.a & 8) == 0) {
                v2_8 = 2147483647;
            } else {
                v2_8 = v2_7.b[3];
            }
            this.q = v2_8;
            String v2_10 = v0_6.C;
            if (v2_10.j) {
                throw new java.io.IOException("closed");
            } else {
                int v4_7 = fc.y.l;
                if (v4_7.isLoggable(java.util.logging.Level.FINE)) {
                    oc.j v5_10 = new StringBuilder(">> CONNECTION ");
                    v5_10.append(fc.f.a.f());
                    oc.j v5_11 = new Object[0];
                    v4_7.fine(zb.e.d(v5_10.toString(), v5_11));
                }
                v2_10.g.R(fc.f.a);
                v2_10.g.flush();
                String v2_11 = v0_6.C;
                int v3_19 = v0_6.w;
                v2_11.getClass();
                v3_19.getClass();
                if (v2_11.j) {
                    throw new java.io.IOException("closed");
                } else {
                    v2_11.i(0, (Integer.bitCount(v3_19.a) * 6), 4, 0);
                    int v4_0 = 0;
                    while (v4_0 < 10) {
                        oc.j v5_2 = 1;
                        if (((1 << v4_0) & v3_19.a) == 0) {
                            v5_2 = 0;
                        } else {
                        }
                        if (v5_2 != null) {
                            v2_11.g.writeShort(v4_0);
                            v2_11.g.writeInt(v3_19.b[v4_0]);
                        }
                        v4_0++;
                    }
                    v2_11.g.flush();
                    String v2_1 = v0_6.w.a();
                    if (v2_1 != 65535) {
                        v0_6.C.c0(0, ((long) (v2_1 - 65535)));
                    }
                    bc.b.c(v0_6.m.d(), v0_6.i, v0_6.D);
                    return;
                }
            }
        }
    }

    public final String toString()
    {
        int v1_4;
        String v0_1 = new StringBuilder("Connection{");
        int v1_6 = this.d;
        v0_1.append(v1_6.a.h.d);
        v0_1.append(58);
        v0_1.append(v1_6.a.h.e);
        v0_1.append(", proxy=");
        v0_1.append(v1_6.b);
        v0_1.append(" hostAddress=");
        v0_1.append(v1_6.c);
        v0_1.append(" cipherSuite=");
        int v1_3 = this.g;
        if (v1_3 == 0) {
            v1_4 = "none";
        } else {
            v1_4 = v1_3.b;
        }
        v0_1.append(v1_4);
        v0_1.append(" protocol=");
        v0_1.append(this.h);
        v0_1.append(125);
        return v0_1.toString();
    }
}
