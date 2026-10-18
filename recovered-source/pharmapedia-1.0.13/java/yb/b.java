// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class b implements yb.f0 {
    public static final yb.b b;
    public static final yb.b c;
    public static final yb.b d;

    static synthetic b()
    {
        yb.b.b = new yb.b();
        yb.b.c = new yb.b();
        yb.b.d = new yb.b();
        return;
    }

    public static final yb.m a(yb.b p1, String p2)
    {
        yb.m v1_1 = new yb.m(p2);
        yb.m.d.put(p2, v1_1);
        return v1_1;
    }

    public static final void b(java.util.List p6, StringBuilder p7)
    {
        int v0_3 = com.bumptech.glide.d.A(com.bumptech.glide.d.C(0, p6.size()), 2);
        int v1_1 = v0_3.g;
        int v2 = v0_3.h;
        int v0_1 = v0_3.i;
        if (((v0_1 > 0) && (v1_1 <= v2)) || ((v0_1 < 0) && (v2 <= v1_1))) {
            while(true) {
                int v3_1 = ((String) p6.get(v1_1));
                String v4_2 = ((String) p6.get((v1_1 + 1)));
                if (v1_1 > 0) {
                    p7.append(38);
                }
                p7.append(v3_1);
                if (v4_2 != null) {
                    p7.append(61);
                    p7.append(v4_2);
                }
                if (v1_1 == v2) {
                    break;
                }
                v1_1 += v0_1;
            }
        }
        return;
    }

    public static okhttp3.TlsVersion c(String p2)
    {
        p2.getClass();
        boolean v0_2 = p2.hashCode();
        if (v0_2 == 79201641) {
            if (p2.equals("SSLv3")) {
                return okhttp3.TlsVersion.m;
            }
        } else {
            if (v0_2 == 79923350) {
                if (p2.equals("TLSv1")) {
                    return okhttp3.TlsVersion.l;
                }
            } else {
                switch (v0_2) {
                    case -503070503:
                        if (p2.equals("TLSv1.1")) {
                            return okhttp3.TlsVersion.k;
                        }
                    case -503070502:
                        if (p2.equals("TLSv1.2")) {
                            return okhttp3.TlsVersion.j;
                        }
                    case -503070501:
                        if (p2.equals("TLSv1.3")) {
                            return okhttp3.TlsVersion.i;
                        }
                    default:
                }
            }
        }
        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Unexpected TLS version: ".concat(p2));
        return 0;
    }

    public static okhttp3.Protocol e(String p3)
    {
        if (!p3.equals("http/1.0")) {
            if (!p3.equals("http/1.1")) {
                if (!p3.equals("h2_prior_knowledge")) {
                    if (!p3.equals("h2")) {
                        if (!p3.equals("spdy/3.1")) {
                            if (!p3.equals("quic")) {
                                if (!db.p.Q(p3, "h3", 0)) {
                                    oc.l.g("Unexpected protocol: ".concat(p3));
                                    return 0;
                                } else {
                                    return okhttp3.Protocol.o;
                                }
                            } else {
                                return okhttp3.Protocol.n;
                            }
                        } else {
                            return okhttp3.Protocol.k;
                        }
                    } else {
                        return okhttp3.Protocol.l;
                    }
                } else {
                    return okhttp3.Protocol.m;
                }
            } else {
                return okhttp3.Protocol.j;
            }
        } else {
            return okhttp3.Protocol.i;
        }
    }

    public declared_synchronized yb.m d(String p7)
    {
        p7.getClass();
        java.util.LinkedHashMap v0 = yb.m.d;
        yb.m v1_4 = ((yb.m) v0.get(p7));
        if (v1_4 == null) {
            yb.m v1_1;
            if (!db.p.Q(p7, "TLS_", 0)) {
                if (!db.p.Q(p7, "SSL_", 0)) {
                    v1_1 = p7;
                } else {
                    v1_1 = "TLS_".concat(p7.substring(4));
                }
            } else {
                v1_1 = "SSL_".concat(p7.substring(4));
            }
            v1_4 = ((yb.m) v0.get(v1_1));
            if (v1_4 == null) {
                v1_4 = new yb.m(p7);
            }
            v0.put(p7, v1_4);
        }
        return v1_4;
    }
}
