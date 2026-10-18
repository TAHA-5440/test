// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package dc;
public final class g {
    public final cc.r a;
    public final java.util.ArrayList b;
    public final int c;
    public final cc.i d;
    public final lc.a e;
    public final int f;
    public final int g;
    public final int h;
    public int i;

    public g(cc.r p1, java.util.ArrayList p2, int p3, cc.i p4, lc.a p5, int p6, int p7, int p8)
    {
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = p4;
        this.e = p5;
        this.f = p6;
        this.g = p7;
        this.h = p8;
        return;
    }

    public static dc.g a(dc.g p9, int p10, cc.i p11, lc.a p12, int p13)
    {
        if ((p13 & 1) != 0) {
            p10 = p9.c;
        }
        if ((p13 & 2) != 0) {
            p11 = p9.d;
        }
        if ((p13 & 4) != 0) {
            p12 = p9.e;
        }
        int v6 = p9.f;
        int v7 = p9.g;
        int v8 = p9.h;
        p12.getClass();
        return new dc.g(p9.a, p9.b, p10, p11, p12, v6, v7, v8);
    }

    public final yb.b0 b(lc.a p10)
    {
        p10.getClass();
        int v0_0 = this.b;
        int v2_2 = this.c;
        if (v2_2 >= v0_0.size()) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Check failed.");
        } else {
            this.i = (this.i + 1);
            cc.i v4 = this.d;
            if (v4 != null) {
                if (!v4.b.c().f(((yb.u) p10.b))) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.i(v0_0.get((v2_2 - 1)), "network interceptor ", " must retain the same host and port");
                    return 0;
                } else {
                    if (this.i != 1) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.i(v0_0.get((v2_2 - 1)), "network interceptor ", " must call proceed() exactly once");
                        return 0;
                    }
                }
            }
            int v6_4 = (v2_2 + 1);
            int v10_3 = dc.g.a(this, v6_4, 0, p10, 58);
            int v2_4 = ((yb.v) v0_0.get(v2_2));
            yb.b0 v7_3 = v2_4.a(v10_3);
            if (v7_3 == null) {
                int v0_3 = new StringBuilder("interceptor ");
                v0_3.append(v2_4);
                v0_3.append(" returned null");
                throw new NullPointerException(v0_3.toString());
            } else {
                if ((v4 != null) && ((v6_4 < v0_0.size()) && (v10_3.i != 1))) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.i(v2_4, "network interceptor ", " must call proceed() exactly once");
                } else {
                    return v7_3;
                }
            }
        }
        return 0;
    }
}
