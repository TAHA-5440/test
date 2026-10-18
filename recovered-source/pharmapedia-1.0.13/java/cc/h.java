// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public final class h extends oc.q {
    public final long h;
    public long i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final synthetic cc.i m;

    public h(cc.i p1, oc.d0 p2, long p3)
    {
        p2.getClass();
        this.m = p1;
        super(p2);
        super.h = p3;
        super.j = 1;
        if (p3 == 0) {
            super.d(0);
        }
        return;
    }

    public final long N(long p10, oc.i p12)
    {
        p12.getClass();
        if (this.l) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return 0;
        } else {
            java.net.ProtocolException v10_1 = this.g.N(p10, p12);
            cc.i v1_0 = this.m;
            if (this.j) {
                this.j = 0;
                v1_0.getClass();
            }
            if (v10_1 != -1) {
                long v5_1 = (this.i + v10_1);
                long v7 = this.h;
                if ((v7 != -1) && (v5_1 > v7)) {
                    String v11_1 = new StringBuilder("expected ");
                    v11_1.append(v7);
                    v11_1.append(" bytes but received ");
                    v11_1.append(v5_1);
                    throw new java.net.ProtocolException(v11_1.toString());
                } else {
                    this.i = v5_1;
                    if (v1_0.c.b()) {
                        this.d(0);
                    }
                    return v10_1;
                }
            } else {
                this.d(0);
                return -1;
            }
        }
    }

    public final void close()
    {
        if (!this.l) {
            this.l = 1;
            try {
                super.close();
                this.d(0);
                return;
            } catch (java.io.IOException v0_4) {
                java.io.IOException v0_1 = this.d(v0_4);
                v0_1.getClass();
                throw v0_1;
            }
        } else {
            return;
        }
    }

    public final java.io.IOException d(java.io.IOException p3)
    {
        if (!this.k) {
            this.k = 1;
            cc.i v0_2 = this.m;
            if ((p3 == null) && (this.j)) {
                this.j = 0;
                v0_2.getClass();
            }
            return cc.i.a(v0_2, p3, 4);
        } else {
            return p3;
        }
    }
}
