// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public final class i {
    public final cc.r a;
    public final cc.j b;
    public final dc.e c;
    public boolean d;
    public boolean e;

    public i(cc.r p1, cc.j p2, dc.e p3)
    {
        p2.getClass();
        this.a = p1;
        this.b = p2;
        this.c = p3;
        return;
    }

    public static java.io.IOException a(cc.i p3, java.io.IOException p4, int p5)
    {
        int v0_1;
        int v1 = 1;
        if ((p5 & 2) == 0) {
            v0_1 = 1;
        } else {
            v0_1 = 0;
        }
        if ((p5 & 4) != 0) {
            v1 = 0;
        }
        p3.getClass();
        cc.r v5_1 = p3.a;
        if (p4 != null) {
            p3.d(p4);
        }
        return v5_1.g(p3, v1, v0_1, p4);
    }

    public final cc.s b()
    {
        int v0_3;
        int v0_2 = this.c.i();
        if (!(v0_2 instanceof cc.s)) {
            v0_3 = 0;
        } else {
            v0_3 = ((cc.s) v0_2);
        }
        if (v0_3 == 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("no connection for CONNECT tunnels");
            return 0;
        } else {
            return v0_3;
        }
    }

    public final yb.a0 c(boolean p2)
    {
        try {
            java.io.IOException v2_1 = this.c.e(p2);
        } catch (java.io.IOException v2_2) {
            this.d(v2_2);
            throw v2_2;
        }
        if (v2_1 == null) {
            return v2_1;
        } else {
            v2_1.n = this;
            return v2_1;
        }
    }

    public final void d(java.io.IOException p3)
    {
        this.e = 1;
        this.c.i().a(this.a, p3);
        return;
    }
}
