// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class a0 {
    public lc.a a;
    public okhttp3.Protocol b;
    public int c;
    public String d;
    public yb.r e;
    public g7.c1 f;
    public yb.d0 g;
    public oc.c0 h;
    public yb.b0 i;
    public yb.b0 j;
    public yb.b0 k;
    public long l;
    public long m;
    public cc.i n;
    public yb.f0 o;

    public a0()
    {
        this.c = -1;
        this.g = yb.d0.g;
        this.o = yb.f0.a;
        this.f = new g7.c1(10, 0);
        return;
    }

    public static void b(String p1, yb.b0 p2)
    {
        if (p2 != null) {
            if (p2.o != null) {
                oc.l.d(p1.concat(".networkResponse != null"));
            } else {
                if (p2.p != null) {
                    oc.l.d(p1.concat(".cacheResponse != null"));
                    return;
                } else {
                    if (p2.q != null) {
                        oc.l.d(p1.concat(".priorResponse != null"));
                        return;
                    }
                }
            }
        }
        return;
    }

    public final yb.b0 a()
    {
        int v5 = this.c;
        if (v5 < 0) {
            oc.l.k(this.c, "code < 0: ");
            return 0;
        } else {
            int v2_3 = this.a;
            if (v2_3 == 0) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("request == null");
                return 0;
            } else {
                okhttp3.Protocol v3 = this.b;
                if (v3 == null) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("protocol == null");
                    return 0;
                } else {
                    String v4 = this.d;
                    if (v4 == null) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("message == null");
                        return 0;
                    } else {
                        return new yb.b0(v2_3, v3, v4, v5, this.e, this.f.h(), this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
                    }
                }
            }
        }
    }
}
