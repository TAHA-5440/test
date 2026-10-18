// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public final class e implements cc.x, dc.d {
    public final bc.d a;
    public final cc.t b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final cc.a h;
    public final cc.u i;
    public final yb.e0 j;
    public final java.util.List k;
    public final lc.a l;
    public final int m;
    public final boolean n;
    public volatile boolean o;
    public java.net.Socket p;
    public java.net.Socket q;
    public yb.r r;
    public okhttp3.Protocol s;
    public androidx.lifecycle.j t;
    public cc.s u;

    public e(bc.d p1, cc.t p2, int p3, int p4, int p5, int p6, boolean p7, cc.a p8, cc.u p9, yb.e0 p10, java.util.List p11, lc.a p12, int p13, boolean p14)
    {
        p1.getClass();
        p2.getClass();
        p8.getClass();
        p10.getClass();
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = p4;
        this.e = p5;
        this.f = p6;
        this.g = p7;
        this.h = p8;
        this.i = p9;
        this.j = p10;
        this.k = p11;
        this.l = p12;
        this.m = p13;
        this.n = p14;
        return;
    }

    public final void a(cc.r p1, java.io.IOException p2)
    {
        return;
    }

    public final boolean b()
    {
        if (this.s == null) {
            return 0;
        } else {
            return 1;
        }
    }

    public final cc.x c()
    {
        return new cc.e(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n);
    }

    public final void cancel()
    {
        this.o = 1;
        java.net.Socket v0_1 = this.p;
        if (v0_1 != null) {
            zb.e.c(v0_1);
        }
        return;
    }

    public final cc.s d()
    {
        cc.s v0_0 = this.h;
        Throwable v1_0 = this.j;
        v0_0.getClass();
        v1_0.getClass();
        ((java.util.LinkedHashSet) v0_0.a.g.A.h).remove(v1_0);
        cc.s v0_1 = this.u;
        v0_1.getClass();
        bc.b v2_0 = this.j;
        this.h.getClass();
        v0_1.getClass();
        v2_0.getClass();
        Throwable v1_3 = this.i.i(this, this.k);
        if (v1_3 == null) {
            try {
                Throwable v1_5 = this.b;
                v1_5.getClass();
                v1_5.f.add(v0_1);
                bc.b.e(v1_5.d, v1_5.e);
                this.h.a(v0_1);
                this.h.e(v0_1);
                this.h.f(v0_1);
                return v0_1;
            } catch (Throwable v1_10) {
                throw v1_10;
            }
        } else {
            return v1_3.a;
        }
    }

    public final cc.w e()
    {
        cc.w v0_0 = this.j;
        if (this.p != null) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("TCP already connected");
            return 0;
        } else {
            java.net.Socket v1_3 = this.h;
            v1_3.b(this);
            try {
                v1_3.getClass();
                v0_0.getClass();
                v0_0.c.getClass();
                this.i();
                java.io.IOException v3_2 = new cc.w(this, 0, 6);
                v1_3.p(this);
                return v3_2;
            } catch (java.io.IOException v3_3) {
                v0_0.a.getClass();
                if (v0_0.b.type() != java.net.Proxy$Type.DIRECT) {
                    int v4_4 = v0_0.a;
                    v4_4.g.connectFailed(v4_4.h.i(), v0_0.b.address(), v3_3);
                }
                v1_3.d(v0_0, v3_3);
                cc.w v0_4 = new cc.w(this, v3_3, 2);
                v1_3.p(this);
                if (1 == 0) {
                    java.net.Socket v1_2 = this.p;
                    if (v1_2 != null) {
                        zb.e.c(v1_2);
                    }
                }
                return v0_4;
            } catch (cc.w v0_2) {
                v1_3.p(this);
                if (1 == 0) {
                    java.net.Socket v1_1 = this.p;
                    if (v1_1 != null) {
                        zb.e.c(v1_1);
                    }
                }
                throw v0_2;
            }
        }
    }

    public final void f()
    {
        return;
    }

    public final cc.w g()
    {
        java.net.Socket v6 = this.p;
        if (v6 == null) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("TCP not connected");
        } else {
            if (this.b()) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("already connected");
            } else {
                yb.e0 v12 = this.j;
                int v2_6 = v12.a;
                Throwable v0_9 = v12.a.j;
                cc.a v13 = this.h;
                v13.b(this);
                int v14 = 0;
                cc.e v15 = 0;
                try {
                    if (this.l == null) {
                        cc.e v16;
                        if (v2_6.c == null) {
                            this.q = v6;
                            int v2_14 = okhttp3.Protocol.m;
                            if (!v2_6.i.contains(v2_14)) {
                                v2_14 = okhttp3.Protocol.j;
                            } else {
                            }
                            this.s = v2_14;
                            v16 = 0;
                        } else {
                            cc.e v3_3 = this.t;
                            if (v3_3 == null) {
                                kotlin.jvm.internal.f.i("socket");
                                throw 0;
                            } else {
                                if (((oc.y) v3_3.i).h.B()) {
                                    cc.e v3_8 = this.t;
                                    if (v3_8 == null) {
                                        kotlin.jvm.internal.f.i("socket");
                                        throw 0;
                                    } else {
                                        if (((oc.x) v3_8.j).h.B()) {
                                            v13.getClass();
                                            int v2_16 = v2_6.h;
                                            int v2_18 = v2_6.c.createSocket(v6, v2_16.d, v2_16.e, 1);
                                            v2_18.getClass();
                                            int v2_19 = ((javax.net.ssl.SSLSocket) v2_18);
                                            cc.e v3_14 = this.m(v0_9, v2_19);
                                            yb.o v7_3 = ((yb.o) v0_9.get(v3_14.m));
                                            cc.e v8_0 = v3_14.l(v0_9, v2_19);
                                            try {
                                                v7_3.a(v2_19, v3_14.n);
                                                this.j(v2_19, v7_3);
                                                v13.getClass();
                                                v16 = v8_0;
                                            } catch (Throwable v0_4) {
                                                v13.d(v12, v0_4);
                                                if (this.g) {
                                                    if (!(v0_4 instanceof java.net.ProtocolException)) {
                                                        if (!(v0_4 instanceof java.io.InterruptedIOException)) {
                                                            if ((v0_4 instanceof javax.net.ssl.SSLHandshakeException)) {
                                                                if ((v0_4.getCause() instanceof java.security.cert.CertificateException)) {
                                                                    int v2_13 = new cc.w(this, v15, v0_4);
                                                                    v13.p(this);
                                                                    if (v14 == 0) {
                                                                        Throwable v0_10 = this.q;
                                                                        if (v0_10 != null) {
                                                                            zb.e.c(v0_10);
                                                                        }
                                                                        zb.e.c(v6);
                                                                    }
                                                                    return v2_13;
                                                                }
                                                            }
                                                            if (!(v0_4 instanceof javax.net.ssl.SSLPeerUnverifiedException)) {
                                                                if ((v0_4 instanceof javax.net.ssl.SSLException)) {
                                                                    v15 = v8_0;
                                                                }
                                                            } else {
                                                            }
                                                        } else {
                                                        }
                                                    } else {
                                                    }
                                                }
                                            }
                                            try {
                                                cc.e v3_15 = this.a;
                                                cc.t v4_2 = this.b;
                                                yb.e0 v5_1 = this.j;
                                                yb.o v7_5 = this.q;
                                                v7_5.getClass();
                                                cc.e v8_2 = this.r;
                                                okhttp3.Protocol v9_0 = this.s;
                                                v9_0.getClass();
                                                androidx.lifecycle.j v10_0 = this.t;
                                            } catch (Throwable v0_4) {
                                                v8_0 = v16;
                                            }
                                            if (v10_0 == null) {
                                                kotlin.jvm.internal.f.i("socket");
                                                throw 0;
                                            } else {
                                                int v2_0 = new cc.s(v3_15, v4_2, v5_1, v6, v7_5, v8_2, v9_0, v10_0, this.b.a);
                                                this.u = v2_0;
                                                v2_0.i();
                                                v13.getClass();
                                                v12.getClass();
                                                v12.c.getClass();
                                                try {
                                                    Throwable v0_6 = new cc.w(this, 0, 6);
                                                    v13.p(this);
                                                    return v0_6;
                                                } catch (Throwable v0_4) {
                                                    v8_0 = v16;
                                                    v14 = 1;
                                                } catch (Throwable v0_7) {
                                                    v14 = 1;
                                                    v13.p(this);
                                                    if (v14 == 0) {
                                                        int v2_11 = this.q;
                                                        if (v2_11 != 0) {
                                                            zb.e.c(v2_11);
                                                        }
                                                        zb.e.c(v6);
                                                    }
                                                    throw v0_7;
                                                }
                                            }
                                        }
                                    }
                                }
                                throw new java.io.IOException("TLS tunnel buffered too many bytes!");
                            }
                        }
                    } else {
                        cc.e v3_1 = this.k();
                        if (v3_1.c == null) {
                        } else {
                            v13.p(this);
                            Throwable v0_11 = this.q;
                            if (v0_11 != null) {
                                zb.e.c(v0_11);
                            }
                            zb.e.c(v6);
                            return v3_1;
                        }
                    }
                } catch (Throwable v0_4) {
                    v8_0 = 0;
                } catch (Throwable v0_7) {
                }
            }
        }
        return 0;
    }

    public final yb.e0 h()
    {
        return this.j;
    }

    public final void i()
    {
        NullPointerException v0_14;
        NullPointerException v0_8 = this.j.b.type();
        if (v0_8 != null) {
            v0_14 = cc.d.a[v0_8.ordinal()];
        } else {
            v0_14 = -1;
        }
        if ((v0_14 == 1) || (v0_14 == 2)) {
            NullPointerException v0_5 = this.j.a.b.createSocket();
            v0_5.getClass();
        } else {
            v0_5 = new java.net.Socket(this.j.b);
        }
        this.p = v0_5;
        if (this.o) {
            oc.l.g("canceled");
            return;
        } else {
            v0_5.setSoTimeout(this.f);
            try {
                ic.e.a.e(v0_5, this.j.c, this.e);
                try {
                    this.t = new androidx.lifecycle.j(new c0.g(v0_5));
                    return;
                } catch (NullPointerException v0_12) {
                    if (kotlin.jvm.internal.f.a(v0_12.getMessage(), "throw with null exception")) {
                        throw new java.io.IOException(v0_12);
                    } else {
                        return;
                    }
                }
            } catch (NullPointerException v0_9) {
                String v2_3 = new StringBuilder("Failed to connect to ");
                v2_3.append(this.j.c);
                java.io.IOException v1_8 = new java.net.ConnectException(v2_3.toString());
                v1_8.initCause(v0_9);
                throw v1_8;
            }
            this.t = new androidx.lifecycle.j(new c0.g(v0_5));
            return;
        }
    }

    public final void j(javax.net.ssl.SSLSocket p9, yb.o p10)
    {
        String v2_8 = this.j.a;
        if (p10.b) {
            ic.e.a.d(p9, v2_8.h.d, v2_8.i);
        }
        p9.startHandshake();
        StringBuilder v3_0 = p9.getSession();
        v3_0.getClass();
        String v4_1 = com.bumptech.glide.g.i(v3_0);
        yb.m v5_1 = v2_8.d;
        v5_1.getClass();
        if (v5_1.verify(v2_8.h.d, v3_0)) {
            androidx.lifecycle.j v0_3 = v2_8.e;
            v0_3.getClass();
            this.r = new yb.r(v4_1.a, v4_1.b, v4_1.c, new cc.c(v0_3, v4_1, v2_8));
            v2_8.h.d.getClass();
            androidx.lifecycle.j v0_5 = v0_3.a.iterator();
            String v2_9 = 0;
            if (v0_5.hasNext()) {
                r1.a.z(v0_5.next());
                throw 0;
            } else {
                if (p10.b) {
                    v2_9 = ic.e.a.f(p9);
                }
                okhttp3.Protocol v10_12;
                this.q = p9;
                this.t = new androidx.lifecycle.j(new c0.g(p9));
                if (v2_9 == null) {
                    v10_12 = okhttp3.Protocol.j;
                } else {
                    okhttp3.Protocol.h.getClass();
                    v10_12 = yb.b.e(v2_9);
                }
                this.s = v10_12;
                ic.e.a.getClass();
                return;
            }
        } else {
            okhttp3.Protocol v10_14 = v4_1.a();
            if (v10_14.isEmpty()) {
                StringBuilder v1_17 = new StringBuilder("Hostname ");
                v1_17.append(v2_8.h.d);
                v1_17.append(" not verified (no certificates)");
                throw new javax.net.ssl.SSLPeerUnverifiedException(v1_17.toString());
            } else {
                okhttp3.Protocol v10_17 = v10_14.get(0);
                v10_17.getClass();
                okhttp3.Protocol v10_18 = ((java.security.cert.X509Certificate) v10_17);
                StringBuilder v3_7 = new StringBuilder("\n            |Hostname ");
                v3_7.append(v2_8.h.d);
                v3_7.append(" not verified:\n            |    certificate: ");
                StringBuilder v1_3 = new StringBuilder("sha256/");
                String v2_2 = v10_18.getPublicKey().getEncoded();
                v2_2.getClass();
                v1_3.append(n5.f.u(v2_2).d("SHA-256").a());
                v3_7.append(v1_3.toString());
                v3_7.append("\n            |    DN: ");
                v3_7.append(v10_18.getSubjectDN().getName());
                v3_7.append("\n            |    subjectAltNames: ");
                v3_7.append(ha.j.K(mc.c.a(v10_18, 2), mc.c.a(v10_18, 7)));
                v3_7.append("\n            ");
                throw new javax.net.ssl.SSLPeerUnverifiedException(db.j.I(v3_7.toString()));
            }
        }
    }

    public final cc.w k()
    {
        int v0_0 = this.l;
        v0_0.getClass();
        int v1_0 = this.j;
        int v2_4 = v1_0.a.h;
        int v3_3 = new StringBuilder("CONNECT ");
        v3_3.append(zb.e.h(v2_4, 1));
        v3_3.append(" HTTP/1.1");
        int v2_2 = v3_3.toString();
        long v4_0 = this.t;
        if (v4_0 == 0) {
            kotlin.jvm.internal.f.i("socket");
            throw 0;
        } else {
            int v3_1 = new ec.h(0, this, v4_0);
            long v4_1 = this.t;
            if (v4_1 == 0) {
                kotlin.jvm.internal.f.i("socket");
                throw 0;
            } else {
                ((oc.y) v4_1.i).g.a().g(((long) this.c));
                long v4_6 = this.t;
                if (v4_6 == 0) {
                    kotlin.jvm.internal.f.i("socket");
                    throw 0;
                } else {
                    ((oc.x) v4_6.j).g.a().g(((long) this.d));
                    v3_1.l(((yb.s) v0_0.c), v2_2);
                    v3_1.a();
                    int v2_6 = v3_1.e(0);
                    v2_6.getClass();
                    v2_6.a = v0_0;
                    int v0_1 = v2_6.a();
                    int v2_7 = v0_1.j;
                    long v4_14 = zb.e.e(v0_1);
                    if (v4_14 != -1) {
                        int v0_5 = v3_1.k(((yb.u) v0_1.g.b), v4_14);
                        zb.e.f(v0_5, 2147483647);
                        v0_5.close();
                    }
                    if (v2_7 == 200) {
                        return new cc.w(this, 0, 6);
                    } else {
                        if (v2_7 != 407) {
                            oc.l.g(r1.a.g(v2_7, "Unexpected response code for CONNECT: "));
                            return 0;
                        } else {
                            v1_0.a.f.getClass();
                            oc.l.g("Failed to authenticate with proxy");
                            return 0;
                        }
                    }
                }
            }
        }
    }

    public final cc.e l(java.util.List p20, javax.net.ssl.SSLSocket p21)
    {
        p20.getClass();
        lc.a v1_0 = this.m;
        int v2 = (v1_0 + 1);
        int v3_1 = p20.size();
        while (v2 < v3_1) {
            bc.d v5_1 = ((yb.o) p20.get(v2));
            v5_1.getClass();
            if (v5_1.a) {
                cc.t v6_1 = v5_1.d;
                if ((v6_1 == null) || (zb.c.f(v6_1, p21.getEnabledProtocols(), ja.a.h))) {
                    bc.d v5_2 = v5_1.c;
                    if ((v5_2 == null) || (zb.c.f(v5_2, p21.getEnabledCipherSuites(), yb.m.c))) {
                        lc.a v1_1;
                        if (v1_0 == -1) {
                            v1_1 = 0;
                        } else {
                            v1_1 = 1;
                        }
                        return new cc.e(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, v2, v1_1);
                    }
                }
            }
            v2++;
        }
        return 0;
    }

    public final cc.e m(java.util.List p4, javax.net.ssl.SSLSocket p5)
    {
        p4.getClass();
        if (this.m == -1) {
            java.net.UnknownServiceException v0_2 = this.l(p4, p5);
            if (v0_2 == null) {
                StringBuilder v1_0 = new StringBuilder("Unable to find acceptable protocols. isFallback=");
                v1_0.append(this.n);
                v1_0.append(", modes=");
                v1_0.append(p4);
                String v4_1 = p5.getEnabledProtocols();
                v4_1.getClass();
                String v4_2 = java.util.Arrays.toString(v4_1);
                v4_2.getClass();
                v1_0.append(", supported protocols=");
                v1_0.append(v4_2);
                throw new java.net.UnknownServiceException(v1_0.toString());
            } else {
                return v0_2;
            }
        } else {
            return this;
        }
    }
}
