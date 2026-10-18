// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class a {
    public final yb.b a;
    public final javax.net.SocketFactory b;
    public final javax.net.ssl.SSLSocketFactory c;
    public final javax.net.ssl.HostnameVerifier d;
    public final yb.k e;
    public final yb.b f;
    public final java.net.ProxySelector g;
    public final yb.u h;
    public final java.util.List i;
    public final java.util.List j;

    public a(String p1, int p2, yb.b p3, javax.net.SocketFactory p4, javax.net.ssl.SSLSocketFactory p5, mc.c p6, yb.k p7, yb.b p8, java.util.List p9, java.util.List p10, java.net.ProxySelector p11)
    {
        int v5_1;
        p1.getClass();
        p3.getClass();
        p4.getClass();
        p8.getClass();
        p9.getClass();
        p10.getClass();
        p11.getClass();
        this.a = p3;
        this.b = p4;
        this.c = p5;
        this.d = p6;
        this.e = p7;
        this.f = p8;
        this.g = p11;
        yb.t v3_2 = new yb.t();
        if (p5 == 0) {
            v5_1 = "http";
        } else {
            v5_1 = "https";
        }
        if (!v5_1.equalsIgnoreCase("http")) {
            if (!v5_1.equalsIgnoreCase("https")) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("unexpected scheme: ".concat(v5_1));
                throw 0;
            } else {
                v3_2.a = "https";
            }
        } else {
            v3_2.a = "http";
        }
        String v4_5 = zb.b.b(nc.a.c(0, 0, 7, p1));
        if (v4_5 == null) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("unexpected host: ".concat(p1));
            throw 0;
        } else {
            v3_2.d = v4_5;
            if ((1 > p2) || (p2 >= 65536)) {
                oc.l.d(r1.a.g(p2, "unexpected port: "));
                throw 0;
            } else {
                v3_2.e = p2;
                this.h = v3_2.a();
                this.i = zb.e.i(p9);
                this.j = zb.e.i(p10);
                return;
            }
        }
    }

    public final boolean a(yb.a p3)
    {
        p3.getClass();
        if ((!kotlin.jvm.internal.f.a(this.a, p3.a)) || ((!kotlin.jvm.internal.f.a(this.f, p3.f)) || ((!kotlin.jvm.internal.f.a(this.i, p3.i)) || ((!kotlin.jvm.internal.f.a(this.j, p3.j)) || ((!kotlin.jvm.internal.f.a(this.g, p3.g)) || ((!kotlin.jvm.internal.f.a(this.c, p3.c)) || ((!kotlin.jvm.internal.f.a(this.d, p3.d)) || ((!kotlin.jvm.internal.f.a(this.e, p3.e)) || (this.h.e != p3.h.e))))))))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final boolean equals(Object p3)
    {
        if ((!(p3 instanceof yb.a)) || ((!kotlin.jvm.internal.f.a(this.h, ((yb.a) p3).h)) || (!this.a(((yb.a) p3))))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        return (java.util.Objects.hashCode(this.e) + ((java.util.Objects.hashCode(this.d) + ((java.util.Objects.hashCode(this.c) + ((this.g.hashCode() + ((this.j.hashCode() + ((this.i.hashCode() + ((this.f.hashCode() + ((this.a.hashCode() + r1.a.c(527, 31, this.h.h)) * 31)) * 31)) * int v2)) * 31)) * 961)) * v2)) * 31));
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder("Address{");
        int v1_6 = this.h;
        v0_1.append(v1_6.d);
        v0_1.append(58);
        v0_1.append(v1_6.e);
        v0_1.append(", ");
        int v1_3 = new StringBuilder("proxySelector=");
        v1_3.append(this.g);
        v0_1.append(v1_3.toString());
        v0_1.append(125);
        return v0_1.toString();
    }
}
