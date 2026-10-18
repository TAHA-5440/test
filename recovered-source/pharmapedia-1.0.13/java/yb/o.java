// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class o {
    public static final java.util.List e;
    public static final java.util.List f;
    public static final yb.o g;
    public static final yb.o h;
    public final boolean a;
    public final boolean b;
    public final String[] c;
    public final String[] d;

    static o()
    {
        yb.o v0_0 = yb.m.r;
        yb.m v9_1 = ha.k.u(new yb.m[] {v0_0, yb.m.p}));
        yb.o.e = v9_1;
        yb.m v11 = yb.m.k;
        yb.m v13 = yb.m.i;
        yb.m v15 = yb.m.g;
        yb.o v0_1 = v9_1;
        yb.m v8 = yb.m.q;
        okhttp3.TlsVersion v6 = yb.m.m;
        int v5 = yb.m.n;
        int v3 = yb.m.t;
        i7.a v2 = yb.m.s;
        int v1_3 = ha.k.u(new yb.m[] {v0_0, yb.m.e}));
        yb.o.f = v1_3;
        i7.a v2_2 = new i7.a();
        okhttp3.TlsVersion v4_1 = new yb.m[0];
        yb.o v0_3 = ((yb.m[]) v0_1.toArray(v4_1));
        v2_2.c(((yb.m[]) java.util.Arrays.copyOf(v0_3, v0_3.length)));
        yb.o v0_6 = okhttp3.TlsVersion.i;
        okhttp3.TlsVersion v4_3 = okhttp3.TlsVersion.j;
        v2_2.e(new okhttp3.TlsVersion[] {v0_6, v4_3}));
        v2_2.d = 1;
        v2_2.a();
        i7.a v2_4 = new i7.a();
        okhttp3.TlsVersion v6_0 = new yb.m[0];
        okhttp3.TlsVersion v6_3 = ((yb.m[]) v1_3.toArray(v6_0));
        v2_4.c(((yb.m[]) java.util.Arrays.copyOf(v6_3, v6_3.length)));
        v2_4.e(new okhttp3.TlsVersion[] {v0_6, v4_3}));
        v2_4.d = 1;
        yb.o.g = v2_4.a();
        i7.a v2_7 = new i7.a();
        okhttp3.TlsVersion v6_7 = new yb.m[0];
        int v1_5 = ((yb.m[]) v1_3.toArray(v6_7));
        v2_7.c(((yb.m[]) java.util.Arrays.copyOf(v1_5, v1_5.length)));
        v2_7.e(new okhttp3.TlsVersion[] {v0_6, v4_3, okhttp3.TlsVersion.k, okhttp3.TlsVersion.l}));
        v2_7.d = 1;
        v2_7.a();
        yb.o.h = new yb.o(0, 0, 0, 0);
        return;
    }

    public o(boolean p1, boolean p2, String[] p3, String[] p4)
    {
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = p4;
        return;
    }

    public final void a(javax.net.ssl.SSLSocket p10, boolean p11)
    {
        String[] v0_0 = p10.getEnabledCipherSuites();
        v0_0.getClass();
        String[] v1_1 = this.c;
        if (v1_1 != null) {
            v0_0 = zb.c.j(v1_1, v0_0, yb.m.c);
        }
        String[] v1_0;
        String[] v1_4 = this.d;
        if (v1_4 == null) {
            v1_0 = p10.getEnabledProtocols();
        } else {
            yb.o v2_0 = p10.getEnabledProtocols();
            v2_0.getClass();
            v1_0 = zb.c.j(v2_0, v1_4, ja.a.h);
        }
        yb.o v2_1 = p10.getSupportedCipherSuites();
        v2_1.getClass();
        int v5 = 0;
        while (v5 < v2_1.length) {
            if (yb.m.c.compare(v2_1[v5], "TLS_FALLBACK_SCSV") != 0) {
                v5++;
            }
            if ((p11 != null) && (v5 != -1)) {
                String[] v11_1 = v2_1[v5];
                v11_1.getClass();
                v0_0.getClass();
                v0_0 = ((String[]) java.util.Arrays.copyOf(v0_0, (v0_0.length + 1)));
                v0_0[(v0_0.length - 1)] = v11_1;
            }
            String[] v11_4 = ((String[]) java.util.Arrays.copyOf(v0_0, v0_0.length));
            String[] v0_2 = this.a;
            if (v0_2 == null) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("no cipher suites for cleartext connections");
                return;
            } else {
                if (v11_4.length == 0) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("At least one cipher suite is required");
                    return;
                } else {
                    String[] v1_3 = ((String[]) java.util.Arrays.copyOf(v1_0, v1_0.length));
                    if (v0_2 == null) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("no TLS versions for cleartext connections");
                        return;
                    } else {
                        if (v1_3.length == 0) {
                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("At least one TLS version is required");
                            return;
                        } else {
                            yb.o v2_13 = new yb.o(v0_2, this.b, ((String[]) java.util.Arrays.copyOf(v11_4, v11_4.length)), ((String[]) java.util.Arrays.copyOf(v1_3, v1_3.length)));
                            if (v2_13.c() != null) {
                                p10.setEnabledProtocols(v2_13.d);
                            }
                            if (v2_13.b() != null) {
                                p10.setEnabledCipherSuites(v2_13.c);
                            }
                            return;
                        }
                    }
                }
            }
        }
        v5 = -1;
    }

    public final java.util.ArrayList b()
    {
        int v0_0 = this.c;
        if (v0_0 == 0) {
            return 0;
        } else {
            java.util.ArrayList v1_1 = new java.util.ArrayList(v0_0.length);
            int v2_1 = v0_0.length;
            int v3 = 0;
            while (v3 < v2_1) {
                v1_1.add(yb.m.b.d(v0_0[v3]));
                v3++;
            }
            return v1_1;
        }
    }

    public final java.util.ArrayList c()
    {
        int v0_0 = this.d;
        if (v0_0 == 0) {
            return 0;
        } else {
            java.util.ArrayList v1_1 = new java.util.ArrayList(v0_0.length);
            int v2_1 = v0_0.length;
            int v3 = 0;
            while (v3 < v2_1) {
                okhttp3.TlsVersion v4_0 = v0_0[v3];
                okhttp3.TlsVersion.h.getClass();
                v1_1.add(yb.b.c(v4_0));
                v3++;
            }
            return v1_1;
        }
    }

    public final boolean equals(Object p3)
    {
        if ((p3 instanceof yb.o)) {
            if (p3 != this) {
                String[] v1_1 = this.a;
                if ((v1_1 != ((yb.o) p3).a) || ((v1_1 != null) && ((!java.util.Arrays.equals(this.c, ((yb.o) p3).c)) || ((!java.util.Arrays.equals(this.d, ((yb.o) p3).d)) || (this.b != ((yb.o) p3).b))))) {
                    return 0;
                }
            }
            return 1;
        }
        return 0;
    }

    public final int hashCode()
    {
        if (!this.a) {
            return 17;
        } else {
            String[] v1_2;
            int v0_1 = 0;
            String[] v1_1 = this.c;
            if (v1_1 == null) {
                v1_2 = 0;
            } else {
                v1_2 = java.util.Arrays.hashCode(v1_1);
            }
            int v2_2 = ((527 + v1_2) * 31);
            String[] v1_0 = this.d;
            if (v1_0 != null) {
                v0_1 = java.util.Arrays.hashCode(v1_0);
            }
            return (((v2_2 + v0_1) * 31) + (this.b ^ 1));
        }
    }

    public final String toString()
    {
        if (this.a) {
            String v0_4 = new StringBuilder("ConnectionSpec(cipherSuites=");
            v0_4.append(java.util.Objects.toString(this.b(), "[all enabled]"));
            v0_4.append(", tlsVersions=");
            v0_4.append(java.util.Objects.toString(this.c(), "[all enabled]"));
            v0_4.append(", supportsTlsExtensions=");
            v0_4.append(this.b);
            v0_4.append(41);
            return v0_4.toString();
        } else {
            return "ConnectionSpec()";
        }
    }
}
