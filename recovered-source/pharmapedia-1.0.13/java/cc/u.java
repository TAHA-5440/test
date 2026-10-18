// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public final class u implements cc.y {
    public final bc.d a;
    public final cc.t b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final yb.a i;
    public final a3.f j;
    public final cc.a k;
    public cc.z l;
    public cc.a0 m;
    public yb.e0 n;
    public final ha.h o;

    public u(bc.d p1, cc.t p2, int p3, int p4, int p5, int p6, boolean p7, boolean p8, yb.a p9, a3.f p10, cc.a p11)
    {
        p1.getClass();
        p2.getClass();
        p9.getClass();
        p10.getClass();
        p11.getClass();
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
        this.o = new ha.h();
        return;
    }

    public final boolean a(cc.s p5)
    {
        if ((this.o.isEmpty()) && (this.n == null)) {
            if (p5) {
                try {
                    yb.e0 v2 = 0;
                } catch (boolean v0_7) {
                    throw v0_7;
                }
                if (p5.n == 0) {
                    if (p5.l) {
                        if (zb.e.a(p5.d.a.h, this.i.h)) {
                            v2 = p5.d;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                if (v2 != null) {
                    this.n = v2;
                    return 1;
                }
            }
            boolean v5_1 = this.l;
            if ((!v5_1) || (v5_1.h >= ((java.util.ArrayList) v5_1.i).size())) {
                boolean v5_5 = this.m;
                if (v5_5) {
                    return v5_5.a();
                }
            } else {
                return 1;
            }
        }
        return 1;
    }

    public final cc.e b()
    {
        Throwable v0_0 = this.n;
        if (v0_0 == null) {
            Throwable v0_17 = this.l;
            if ((v0_17 == null) || (v0_17.h >= ((java.util.ArrayList) v0_17.i).size())) {
                Throwable v0_1 = this.m;
                if (v0_1 == null) {
                    v0_1 = new cc.a0(this.i, this.j, this.k, this.h);
                    this.m = v0_1;
                }
                if (!v0_1.a()) {
                    oc.l.g("exhausted all routes");
                    return 0;
                } else {
                    if (!v0_1.a()) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.c();
                        return 0;
                    } else {
                        StringBuilder v2_12 = new java.util.ArrayList();
                        while (v0_1.f < v0_1.e.size()) {
                            Object v3_23 = v0_1.a;
                            if (v0_1.f >= v0_1.e.size()) {
                                StringBuilder v2_14 = v3_23.h.d;
                                Throwable v0_22 = v0_1.e;
                                StringBuilder v5_3 = new StringBuilder("No route to ");
                                v5_3.append(v2_14);
                                v5_3.append("; exhausted proxy configurations: ");
                                v5_3.append(v0_22);
                                throw new java.net.SocketException(v5_3.toString());
                            } else {
                                kotlin.collections.builders.ListBuilder v9_0;
                                int v8_0;
                                StringBuilder v5_4 = v0_1.e;
                                java.util.Iterator v6_10 = v0_1.f;
                                v0_1.f = (v6_10 + 1);
                                StringBuilder v5_6 = ((java.net.Proxy) v5_4.get(v6_10));
                                java.util.Iterator v6_11 = v0_1.c;
                                boolean v7_6 = new java.util.ArrayList();
                                v0_1.g = v7_6;
                                if ((v5_6.type() != java.net.Proxy$Type.DIRECT) && (v5_6.type() != java.net.Proxy$Type.SOCKS)) {
                                    int v8_4 = v5_6.address();
                                    if (!(v8_4 instanceof java.net.InetSocketAddress)) {
                                        String v1_12 = v8_4.getClass();
                                        StringBuilder v2_17 = new StringBuilder("Proxy.address() is not an InetSocketAddress: ");
                                        v2_17.append(v1_12);
                                        throw new IllegalArgumentException(v2_17.toString().toString());
                                    } else {
                                        int v8_5 = ((java.net.InetSocketAddress) v8_4);
                                        kotlin.collections.builders.ListBuilder v9_8 = v8_5.getAddress();
                                        if (v9_8 != null) {
                                            v9_0 = v9_8.getHostAddress();
                                            v9_0.getClass();
                                        } else {
                                            v9_0 = v8_5.getHostName();
                                            v9_0.getClass();
                                        }
                                        v8_0 = v8_5.getPort();
                                    }
                                } else {
                                    int v8_1 = v3_23.h;
                                    v9_0 = v8_1.d;
                                    v8_0 = v8_1.e;
                                }
                                if ((1 > v8_0) || (v8_0 >= 65536)) {
                                    String v1_2 = new StringBuilder("No route to ");
                                    v1_2.append(v9_0);
                                    v1_2.append(58);
                                    v1_2.append(v8_0);
                                    v1_2.append("; port is out of range");
                                    throw new java.net.SocketException(v1_2.toString());
                                } else {
                                    if (v5_6.type() != java.net.Proxy$Type.SOCKS) {
                                        Object v3_1;
                                        Class vtmp41 = v9_0.getClass();
                                        if (!zb.b.a.b(v9_0)) {
                                            v6_11.getClass();
                                            v3_23.a.getClass();
                                            try {
                                                java.util.Iterator v4_4 = java.net.InetAddress.getAllByName(v9_0);
                                                v4_4.getClass();
                                                java.util.Iterator v4_5 = ha.i.S(v4_4);
                                            } catch (Throwable v0_5) {
                                                String v1_5 = new java.net.UnknownHostException("Broken system behaviour for dns lookup of ".concat(v9_0));
                                                v1_5.initCause(v0_5);
                                                throw v1_5;
                                            }
                                            if (v4_5.isEmpty()) {
                                                String v1_6 = v3_23.a;
                                                StringBuilder v2_6 = new StringBuilder();
                                                v2_6.append(v1_6);
                                                v2_6.append(" returned no addresses for ");
                                                v2_6.append(v9_0);
                                                throw new java.net.UnknownHostException(v2_6.toString());
                                            } else {
                                                v6_11.getClass();
                                                v3_1 = v4_5;
                                            }
                                        } else {
                                            v3_1 = com.bumptech.glide.e.l(java.net.InetAddress.getByName(v9_0));
                                        }
                                        if ((v0_1.d) && (v3_1.size() >= 2)) {
                                            java.util.Iterator v4_10 = new java.util.ArrayList();
                                            java.util.Iterator v6_2 = new java.util.ArrayList();
                                            kotlin.collections.builders.ListBuilder v9_1 = v3_1.iterator();
                                            while (v9_1.hasNext()) {
                                                Object v10_5 = v9_1.next();
                                                if (!(((java.net.InetAddress) v10_5) instanceof java.net.Inet6Address)) {
                                                    v6_2.add(v10_5);
                                                } else {
                                                    v4_10.add(v10_5);
                                                }
                                            }
                                            if ((!v4_10.isEmpty()) && (!v6_2.isEmpty())) {
                                                java.util.Iterator v4_11 = v4_10.iterator();
                                                java.util.Iterator v6_3 = v6_2.iterator();
                                                kotlin.collections.builders.ListBuilder v9_4 = com.bumptech.glide.e.c();
                                                while ((v4_11.hasNext()) || (v6_3.hasNext())) {
                                                    if (v4_11.hasNext()) {
                                                        v9_4.add(v4_11.next());
                                                    }
                                                    if (v6_3.hasNext()) {
                                                        v9_4.add(v6_3.next());
                                                    }
                                                }
                                                v3_1 = com.bumptech.glide.e.b(v9_4);
                                            }
                                        }
                                        Object v3_9 = v3_1.iterator();
                                        while (v3_9.hasNext()) {
                                            v7_6.add(new java.net.InetSocketAddress(((java.net.InetAddress) v3_9.next()), v8_0));
                                        }
                                    } else {
                                        v7_6.add(java.net.InetSocketAddress.createUnresolved(v9_0, v8_0));
                                    }
                                    Object v3_12 = v0_1.g.iterator();
                                    while (v3_12.hasNext()) {
                                        java.util.Iterator v6_7 = new yb.e0(v0_1.a, v5_6, ((java.net.InetSocketAddress) v3_12.next()));
                                        if (!((java.util.LinkedHashSet) v0_1.b.h).contains(v6_7)) {
                                            v2_12.add(v6_7);
                                        } else {
                                            v0_1.h.add(v6_7);
                                        }
                                    }
                                    if (!v2_12.isEmpty()) {
                                        break;
                                    }
                                }
                            }
                        }
                        if (v2_12.isEmpty()) {
                            ha.j.A(v0_1.h, v2_12);
                            v0_1.h.clear();
                        }
                        Throwable v0_11 = new cc.z(v2_12);
                        this.l = v0_11;
                        if (this.k.m()) {
                            oc.l.g("Canceled");
                            return 0;
                        } else {
                            if (v0_11.h >= v2_12.size()) {
                                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.c();
                                return 0;
                            } else {
                                String v1_9 = v0_11.h;
                                v0_11.h = (v1_9 + 1);
                                return this.c(((yb.e0) v2_12.get(v1_9)), v2_12);
                            }
                        }
                    }
                }
            } else {
                Object v3_21 = ((java.util.ArrayList) v0_17.i);
                if (v0_17.h >= v3_21.size()) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.c();
                    return 0;
                } else {
                    StringBuilder v2_11 = v0_17.h;
                    v0_17.h = (v2_11 + 1);
                    return this.c(((yb.e0) v3_21.get(v2_11)), 0);
                }
            }
        } else {
            this.n = 0;
            return this.c(v0_0, 0);
        }
    }

    public final cc.e c(yb.e0 p16, java.util.ArrayList p17)
    {
        p16.getClass();
        cc.e v0_6 = p16.a;
        if (v0_6.c != null) {
            if (v0_6.i.contains(okhttp3.Protocol.m)) {
                throw new java.net.UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS");
            }
        } else {
            if (!v0_6.j.contains(yb.o.h)) {
                throw new java.net.UnknownServiceException("CLEARTEXT communication not enabled for client");
            } else {
                cc.e v0_10 = p16.a.h.d;
                if (!ic.e.a.h(v0_10)) {
                    throw new java.net.UnknownServiceException(f0.a.d("CLEARTEXT communication to ", v0_10, " not permitted by network security policy"));
                }
            }
        }
        cc.t v2_1 = 0;
        if (p16.b.type() == java.net.Proxy$Type.HTTP) {
            cc.e v0_14 = p16.a;
            if ((v0_14.c != null) || (v0_14.i.contains(okhttp3.Protocol.m))) {
                cc.e v0_19 = new androidx.lifecycle.d1();
                bc.d v1_12 = p16.a.h;
                v1_12.getClass();
                v0_19.g = v1_12;
                v0_19.b("CONNECT", 0);
                bc.d v1_15 = p16.a;
                v0_19.a("Host", zb.e.h(v1_15.h, 1));
                v0_19.a("Proxy-Connection", "Keep-Alive");
                v0_19.a("User-Agent", "okhttp/5.2.1");
                v2_1 = new lc.a(v0_19);
                int v3_6 = new g7.c1(10, 0);
                com.bumptech.glide.j.Q("Proxy-Authenticate");
                com.bumptech.glide.j.R("OkHttp-Preemptive", "Proxy-Authenticate");
                v3_6.o("Proxy-Authenticate");
                com.bumptech.glide.j.G(v3_6, "Proxy-Authenticate", "OkHttp-Preemptive");
                v3_6.h();
                yb.d0.g.getClass();
                v1_15.f.getClass();
            }
        }
        return new cc.e(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.k, this, p16, p17, v2_1, -1, 0);
    }

    public final yb.a d()
    {
        return this.i;
    }

    public final boolean e()
    {
        return this.k.m();
    }

    public final boolean f(yb.u p4)
    {
        p4.getClass();
        String v0_1 = this.i.h;
        if ((p4.e != v0_1.e) || (!kotlin.jvm.internal.f.a(p4.d, v0_1.d))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final ha.h g()
    {
        return this.o;
    }

    public final cc.x h()
    {
        cc.v v2_6;
        cc.a v0_1 = this.k.c();
        if (v0_1 != null) {
            cc.v v2_1;
            java.net.Socket v3_5;
            java.net.Socket v3_0 = v0_1.l;
            if (v0_1.g(this.k.l())) {
                if (v3_0 == null) {
                    if (this.f(v0_1.d.a.h)) {
                        v3_5 = 0;
                        v2_1 = 0;
                        if (this.k.c() == null) {
                            if (v2_1 != null) {
                                zb.e.c(v2_1);
                            }
                            this.k.getClass();
                            this.k.getClass();
                            if (v2_1 == null) {
                                if (v3_5 == null) {
                                    v2_6 = 0;
                                } else {
                                    this.k.getClass();
                                }
                            } else {
                                this.k.getClass();
                            }
                        } else {
                            if (v2_1 != null) {
                                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Check failed.");
                                return 0;
                            } else {
                                v2_6 = new cc.v(v0_1);
                            }
                        }
                        if (v2_6 == null) {
                            cc.a v0_8 = this.i(0, 0);
                            if (v0_8 == null) {
                                if (this.o.isEmpty()) {
                                    cc.a v0_11 = this.b();
                                    cc.v v1_3 = this.i(v0_11, v0_11.k);
                                    if (v1_3 == null) {
                                        return v0_11;
                                    } else {
                                        return v1_3;
                                    }
                                } else {
                                    return ((cc.x) this.o.removeFirst());
                                }
                            } else {
                                return v0_8;
                            }
                        } else {
                            return v2_6;
                        }
                    } else {
                    }
                }
                v3_5 = 0;
                v2_1 = this.k.o();
            } else {
                v3_5 = (v3_0 ^ 1);
                v0_1.l = 1;
                v2_1 = this.k.o();
            }
        }
    }

    public final cc.v i(cc.e p11, java.util.List p12)
    {
        int v6_1;
        java.util.Iterator v0_0 = this.b;
        boolean v1_1 = this.k.l();
        yb.a v2 = this.i;
        cc.a v3 = this.k;
        if ((p11 == null) || (!p11.b())) {
            v6_1 = 0;
        } else {
            v6_1 = 1;
        }
        v0_0.getClass();
        v2.getClass();
        v3.getClass();
        java.util.Iterator v0_2 = v0_0.f.iterator();
        v0_2.getClass();
        while (v0_2.hasNext()) {
            boolean v9_3;
            int v7_1 = ((cc.s) v0_2.next());
            v7_1.getClass();
            if (v6_1 == 0) {
                if (v7_1.e(v2, p12)) {
                    v3.a(v7_1);
                    v9_3 = 1;
                } else {
                    v9_3 = 0;
                }
            } else {
                boolean v9_1;
                if (v7_1.k == null) {
                    v9_1 = 0;
                } else {
                    v9_1 = 1;
                }
                if (v9_1) {
                }
            }
            if (v9_3) {
                if (!v7_1.g(v1_1)) {
                    try {
                        v7_1.l = 1;
                        java.net.Socket v8_1 = v3.o();
                    } catch (Throwable v11_2) {
                        throw v11_2;
                    }
                    if (v8_1 != null) {
                        zb.e.c(v8_1);
                    }
                }
            }
            if (v7_1 != 0) {
                if (p11 != null) {
                    this.n = p11.j;
                    Throwable v11_3 = p11.q;
                    if (v11_3 != null) {
                        zb.e.c(v11_3);
                    }
                }
                this.k.e(v7_1);
                this.k.f(v7_1);
                return new cc.v(v7_1);
            } else {
                return 0;
            }
        }
        v7_1 = 0;
    }
}
