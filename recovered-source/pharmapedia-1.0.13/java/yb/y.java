// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class y {
    public static final java.util.List D;
    public static final java.util.List E;
    public final a3.f A;
    public final bc.d B;
    public final y2.k C;
    public final yb.q a;
    public final java.util.List b;
    public final java.util.List c;
    public final oc.l d;
    public final boolean e;
    public final boolean f;
    public final yb.b g;
    public final boolean h;
    public final boolean i;
    public final yb.b j;
    public final yb.g k;
    public final yb.b l;
    public final java.net.ProxySelector m;
    public final yb.b n;
    public final javax.net.SocketFactory o;
    public final javax.net.ssl.SSLSocketFactory p;
    public final javax.net.ssl.X509TrustManager q;
    public final java.util.List r;
    public final java.util.List s;
    public final mc.c t;
    public final yb.k u;
    public final com.bumptech.glide.j v;
    public final int w;
    public final int x;
    public final int y;
    public final int z;

    static y()
    {
        yb.y.D = zb.e.j(new okhttp3.Protocol[] {okhttp3.Protocol.l, okhttp3.Protocol.j}));
        yb.y.E = zb.e.j(new yb.o[] {yb.o.g, yb.o.h}));
        return;
    }

    public y(yb.x p10)
    {
        this.a = p10.a;
        this.b = zb.e.i(p10.c);
        this.c = zb.e.i(p10.d);
        this.d = p10.e;
        boolean v6 = p10.f;
        this.e = v6;
        boolean v7 = p10.g;
        this.f = v7;
        this.g = p10.h;
        this.h = p10.i;
        this.i = p10.j;
        this.j = p10.k;
        this.k = p10.l;
        this.l = p10.m;
        yb.k v0_22 = java.net.ProxySelector.getDefault();
        if (v0_22 == null) {
            v0_22 = kc.a.a;
        }
        this.m = v0_22;
        this.n = p10.n;
        this.o = p10.o;
        yb.k v0_25 = p10.p;
        this.r = v0_25;
        this.s = p10.q;
        this.t = p10.r;
        this.w = p10.t;
        boolean v4_8 = p10.u;
        this.x = v4_8;
        yb.k v2_6 = p10.v;
        this.y = v2_6;
        String v3_5 = p10.w;
        this.z = v3_5;
        a3.f v8_1 = new a3.f(9);
        this.A = v8_1;
        this.B = bc.d.l;
        String v1_8 = p10.b;
        if (v1_8 == null) {
            v1_8 = new y2.k(v2_6, v3_5, v4_8, v2_6, v6, v7, v8_1);
            p10.b = v1_8;
        }
        this.C = v1_8;
        if ((v0_25 == null) || (!v0_25.isEmpty())) {
            yb.k v0_28 = v0_25.iterator();
            while (v0_28.hasNext()) {
                if (((yb.o) v0_28.next()).a) {
                    ic.e.a.getClass();
                    yb.k v0_31 = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
                    v0_31.init(0);
                    yb.k v0_32 = v0_31.getTrustManagers();
                    v0_32.getClass();
                    if (v0_32.length == 1) {
                        boolean v4_9 = v0_32[0];
                        if ((v4_9 instanceof javax.net.ssl.X509TrustManager)) {
                            boolean v4_0 = ((javax.net.ssl.X509TrustManager) v4_9);
                            this.q = v4_0;
                            yb.k v0_5 = ic.e.a;
                            v0_5.getClass();
                            try {
                                yb.k v0_6 = v0_5.k();
                                String v3_0 = new javax.net.ssl.TrustManager[1];
                                v3_0[0] = v4_0;
                                v0_6.init(0, v3_0, 0);
                                yb.k v0_7 = v0_6.getSocketFactory();
                                v0_7.getClass();
                                this.p = v0_7;
                                yb.k v0_9 = ic.e.a.c(v4_0);
                                this.v = v0_9;
                                String v10_3 = p10.s;
                                v10_3.getClass();
                            } catch (yb.k v0_10) {
                                String v10_4 = v0_10;
                                String v1_1 = new StringBuilder("No System TLS: ");
                                v1_1.append(v10_4);
                                throw new AssertionError(v1_1.toString(), v10_4);
                            }
                            if (!kotlin.jvm.internal.f.a(v10_3.b, v0_9)) {
                                v10_3 = new yb.k(v10_3.a, v0_9);
                            }
                            this.u = v10_3;
                            String v10_7 = this.q;
                            yb.k v0_13 = this.v;
                            yb.k v2_5 = this.p;
                            String v3_1 = this.c;
                            boolean v4_1 = this.b;
                            v4_1.getClass();
                            if (v4_1.contains(0)) {
                                oc.l.o(v4_1, "Null interceptor: ");
                                throw 0;
                            } else {
                                v3_1.getClass();
                                if (v3_1.contains(0)) {
                                    oc.l.o(v3_1, "Null network interceptor: ");
                                    throw 0;
                                } else {
                                    String v3_2 = this.r;
                                    if ((v3_2 == null) || (!v3_2.isEmpty())) {
                                        String v3_3 = v3_2.iterator();
                                        while (v3_3.hasNext()) {
                                            if (((yb.o) v3_3.next()).a) {
                                                if (v2_5 == null) {
                                                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("sslSocketFactory == null");
                                                    throw 0;
                                                } else {
                                                    if (v0_13 == null) {
                                                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("certificateChainCleaner == null");
                                                        throw 0;
                                                    } else {
                                                        if (v10_7 == null) {
                                                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("x509TrustManager == null");
                                                            throw 0;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (v2_5 != null) {
                                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Check failed.");
                                            throw 0;
                                        } else {
                                            if (v0_13 != null) {
                                                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Check failed.");
                                                throw 0;
                                            } else {
                                                if (v10_7 != null) {
                                                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Check failed.");
                                                    throw 0;
                                                } else {
                                                    if (!kotlin.jvm.internal.f.a(this.u, yb.k.c)) {
                                                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Check failed.");
                                                        throw 0;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                        }
                    }
                    String v10_15 = java.util.Arrays.toString(v0_32);
                    v10_15.getClass();
                    throw new IllegalStateException("Unexpected default trust managers: ".concat(v10_15).toString());
                }
            }
            this.p = 0;
            this.v = 0;
            this.q = 0;
            this.u = yb.k.c;
        }
    }
}
