// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public final class z {
    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public final boolean e;
    public oc.z f;
    public oc.z g;

    public z()
    {
        int v0_1 = new byte[8192];
        this.a = v0_1;
        this.e = 1;
        this.d = 0;
        return;
    }

    public z(byte[] p1, int p2, int p3, boolean p4)
    {
        p1.getClass();
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = p4;
        this.e = 0;
        return;
    }

    public final oc.z a()
    {
        int v0 = this.f;
        if (v0 == this) {
            v0 = 0;
        }
        oc.z v2_0 = this.g;
        v2_0.getClass();
        v2_0.f = this.f;
        oc.z v2_1 = this.f;
        v2_1.getClass();
        v2_1.g = this.g;
        this.f = 0;
        this.g = 0;
        return v0;
    }

    public final void b(oc.z p2)
    {
        p2.getClass();
        p2.g = this;
        p2.f = this.f;
        oc.z v0_1 = this.f;
        v0_1.getClass();
        v0_1.g = p2;
        this.f = p2;
        return;
    }

    public final oc.z c()
    {
        this.d = 1;
        return new oc.z(this.a, this.b, this.c, 1);
    }

    public final void d(oc.z p6, int p7)
    {
        p6.getClass();
        int v0_0 = p6.a;
        if (!p6.e) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("only owner can write");
            return;
        } else {
            int v1_4 = p6.c;
            int v2_3 = (v1_4 + p7);
            if (v2_3 > 8192) {
                if (p6.d) {
                    oc.l.a();
                    return;
                } else {
                    int v4_1 = p6.b;
                    if ((v2_3 - v4_1) > 8192) {
                        oc.l.a();
                        return;
                    } else {
                        ha.i.J(v0_0, 0, v0_0, v4_1, v1_4);
                        p6.c = (p6.c - p6.b);
                        p6.b = 0;
                    }
                }
            }
            int v2_2 = this.b;
            ha.i.J(this.a, p6.c, v0_0, v2_2, (v2_2 + p7));
            p6.c = (p6.c + p7);
            this.b = (this.b + p7);
            return;
        }
    }
}
