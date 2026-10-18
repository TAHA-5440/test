// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final class q implements dc.e {
    public static final java.util.List g;
    public static final java.util.List h;
    public final cc.s a;
    public final dc.g b;
    public final fc.p c;
    public volatile fc.x d;
    public final okhttp3.Protocol e;
    public volatile boolean f;

    static q()
    {
        String v2 = "keep-alive";
        String v4 = "te";
        String v6 = "encoding";
        String v8 = ":method";
        fc.q.g = zb.e.j(new String[] {"connection", ":authority"}));
        String v3 = "keep-alive";
        String v5 = "te";
        fc.q.h = zb.e.j(new String[] {"connection", "upgrade"}));
        return;
    }

    public q(yb.y p1, cc.s p2, dc.g p3, fc.p p4)
    {
        p1.getClass();
        p4.getClass();
        this.a = p2;
        this.b = p3;
        this.c = p4;
        okhttp3.Protocol v2_1 = okhttp3.Protocol.m;
        if (!p1.s.contains(v2_1)) {
            v2_1 = okhttp3.Protocol.l;
        }
        this.e = v2_1;
        return;
    }

    public final void a()
    {
        fc.u v0_0 = this.d;
        v0_0.getClass();
        v0_0.o.close();
        return;
    }

    public final boolean b()
    {
        fc.x v0 = this.d;
        if (v0 != null) {
            try {
                int v2_1;
                int v2_2 = v0.n;
            } catch (Throwable v1_1) {
                throw v1_1;
            }
            if ((!v2_2.h) || (!v2_2.j.B())) {
                v2_1 = 0;
            } else {
                v2_1 = 1;
            }
            if (v2_1 == 1) {
                return 1;
            }
        }
        return 0;
    }

    public final long c(yb.b0 p3)
    {
        if (dc.f.a(p3)) {
            return zb.e.e(p3);
        } else {
            return 0;
        }
    }

    public final void cancel()
    {
        this.f = 1;
        fc.x v0_1 = this.d;
        if (v0_1 != null) {
            v0_1.e(okhttp3.internal.http2.ErrorCode.n);
        }
        return;
    }

    public final void d(lc.a p15)
    {
        if (this.d == null) {
            long v0_11;
            int v1 = 0;
            if (((yb.z) p15.d) == null) {
                v0_11 = 0;
            } else {
                v0_11 = 1;
            }
            int v3_0 = ((yb.s) p15.c);
            java.util.ArrayList v4_1 = new java.util.ArrayList((v3_0.size() + 4));
            v4_1.add(new fc.b(fc.b.f, ((String) p15.g)));
            String v15_9 = ((yb.u) p15.b);
            v15_9.getClass();
            int v7_11 = v15_9.b();
            String v8_2 = v15_9.d();
            if (v8_2 != null) {
                int v9_1 = new StringBuilder();
                v9_1.append(v7_11);
                v9_1.append(63);
                v9_1.append(v8_2);
                v7_11 = v9_1.toString();
            }
            v4_1.add(new fc.b(fc.b.g, v7_11));
            int v5_8 = v3_0.a("Host");
            if (v5_8 != 0) {
                v4_1.add(new fc.b(fc.b.i, v5_8));
            }
            v4_1.add(new fc.b(fc.b.h, v15_9.a));
            String v15_11 = v3_0.size();
            int v5_2 = 0;
            while (v5_2 < v15_11) {
                fc.x v6_0 = v3_0.b(v5_2);
                int v7_0 = java.util.Locale.US;
                v7_0.getClass();
                fc.x v6_1 = v6_0.toLowerCase(v7_0);
                v6_1.getClass();
                if ((!fc.q.g.contains(v6_1)) || ((v6_1.equals("te")) && (v3_0.e(v5_2).equals("trailers")))) {
                    v4_1.add(new fc.b(v6_1, v3_0.e(v5_2)));
                }
                v5_2++;
            }
            String v8_3 = this.c;
            v8_3.getClass();
            int v9_2 = (v0_11 ^ 1);
            try {
            } catch (long v0_1) {
                throw v0_1;
            }
            if (v8_3.k > 1073741823) {
                v8_3.B(okhttp3.internal.http2.ErrorCode.m);
            }
            if (v8_3.l) {
                throw new okhttp3.internal.http2.ConnectionShutdownException();
            } else {
                int v7_14 = v8_3.k;
                v8_3.k = (v7_14 + 2);
                fc.x v6_8 = new fc.x(v7_14, v8_3, v9_2, 0, 0);
                if ((v0_11 == 0) || ((v8_3.z >= v8_3.A) || (v6_8.j >= v6_8.k))) {
                    v1 = 1;
                }
                if (v6_8.h()) {
                    v8_3.h.put(Integer.valueOf(v7_14), v6_8);
                }
                v8_3.C.L(v9_2, v7_14, v4_1);
                if (v1 != 0) {
                    v8_3.C.flush();
                }
                this.d = v6_8;
                long v0_2 = this.d;
                if (this.f) {
                    v0_2.getClass();
                    v0_2.e(okhttp3.internal.http2.ErrorCode.n);
                    oc.l.g("Canceled");
                    return;
                } else {
                    v0_2.getClass();
                    v0_2.p.g(((long) this.b.g));
                    String v15_6 = this.d;
                    v15_6.getClass();
                    v15_6.q.g(((long) this.b.h));
                    return;
                }
            }
        } else {
            return;
        }
    }

    public final yb.a0 e(boolean p12)
    {
        int v0_0 = this.d;
        if (v0_0 == 0) {
            oc.l.g("stream wasn\'t created");
            return 0;
        }
        try {
            do {
                String[] v2_0 = 0;
            } while(v2_0 == null);
            v0_0.p.k();
        } catch (int v12_5) {
            throw v12_5;
        }
        if ((!v0_0.l.isEmpty()) || (v0_0.f() != null)) {
            if (v0_0.l.isEmpty()) {
                int v12_6 = v0_0.s;
                if (v12_6 == 0) {
                    fc.w v1_6 = v0_0.f();
                    v1_6.getClass();
                    v12_6 = new okhttp3.internal.http2.StreamResetException(v1_6);
                } else {
                }
                throw v12_6;
            } else {
                fc.w v1_8 = v0_0.l.removeFirst();
                v1_8.getClass();
                fc.w v1_9 = ((yb.s) v1_8);
                int v0_1 = this.e;
                v0_1.getClass();
                yb.s v3_3 = new java.util.ArrayList(20);
                boolean v4_1 = v1_9.size();
                int v6 = 0;
                dc.i v7_0 = 0;
                while (v6 < v4_1) {
                    String v8_0 = v1_9.b(v6);
                    String v9 = v1_9.e(v6);
                    if (!v8_0.equals(":status")) {
                        if (!fc.q.h.contains(v8_0)) {
                            v3_3.add(v8_0);
                            v3_3.add(db.i.o0(v9).toString());
                        }
                    } else {
                        v7_0 = com.bumptech.glide.g.r("HTTP/1.1 ".concat(v9));
                    }
                    v6++;
                }
                if (v7_0 == null) {
                    throw new java.net.ProtocolException("Expected \':status\' header not present");
                } else {
                    fc.w v1_11 = new yb.a0();
                    v1_11.b = v0_1;
                    v1_11.c = v7_0.b;
                    v1_11.d = ((String) v7_0.d);
                    String[] v2_1 = new String[0];
                    v1_11.f = new yb.s(((String[]) v3_3.toArray(v2_1))).c();
                    if ((p12 == 0) || (v1_11.c != 100)) {
                        return v1_11;
                    } else {
                        return 0;
                    }
                }
            }
        } else {
            if (p12 != 0) {
                v2_0 = 1;
            } else {
                yb.s v3_1;
                v0_0.h.getClass();
                yb.s v3_5 = v0_0.o;
                if (v3_5.i) {
                    v3_1 = 1;
                } else {
                    if (!v3_5.g) {
                        v3_1 = 0;
                    } else {
                    }
                }
                if (v3_1 != null) {
                }
            }
            if (v2_0 != null) {
                v0_0.p.h();
            }
            try {
                v0_0.wait();
            } catch (int v12_4) {
                if (v2_0 != null) {
                    v0_0.p.k();
                }
                throw v12_4;
            }
            if (v2_0 != null) {
            }
        }
    }

    public final oc.d0 f(yb.b0 p1)
    {
        fc.v v1_0 = this.d;
        v1_0.getClass();
        return v1_0.n;
    }

    public final void g()
    {
        this.c.C.flush();
        return;
    }

    public final oc.c0 h()
    {
        fc.x v0 = this.d;
        v0.getClass();
        return v0;
    }

    public final dc.d i()
    {
        return this.a;
    }

    public final oc.b0 j(lc.a p1, long p2)
    {
        fc.u v1_0 = this.d;
        v1_0.getClass();
        return v1_0.o;
    }
}
