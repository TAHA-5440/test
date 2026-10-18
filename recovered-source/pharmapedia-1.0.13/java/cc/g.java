// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public final class g extends oc.p {
    public final long h;
    public boolean i;
    public long j;
    public boolean k;
    public boolean l;
    public final synthetic cc.i m;

    public g(cc.i p1, oc.b0 p2, long p3)
    {
        p2.getClass();
        this.m = p1;
        super(p2);
        super.h = p3;
        super.k = p1.d;
        return;
    }

    public final void D(long p5, oc.i p7)
    {
        if (this.l) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return;
        } else {
            long v2 = this.h;
            if ((v2 != -1) && ((this.j + p5) > v2)) {
                long v0_4 = (this.j + p5);
                java.io.IOException v5_2 = new StringBuilder("expected ");
                v5_2.append(v2);
                v5_2.append(" bytes but received ");
                v5_2.append(v0_4);
                throw new java.net.ProtocolException(v5_2.toString());
            } else {
                if (this.k) {
                    this.k = 0;
                    this.m.getClass();
                }
                this.g.D(p5, p7);
                this.j = (this.j + p5);
                return;
            }
        }
    }

    public final void close()
    {
        if (!this.l) {
            this.l = 1;
            long v2 = this.h;
            if ((v2 != -1) && (this.j != v2)) {
                throw new java.net.ProtocolException("unexpected end of stream");
            } else {
                try {
                    super.close();
                    this.d(0);
                    return;
                } catch (java.io.IOException v0_4) {
                    java.io.IOException v0_6 = this.d(v0_4);
                    v0_6.getClass();
                    throw v0_6;
                }
            }
        } else {
            return;
        }
    }

    public final java.io.IOException d(java.io.IOException p3)
    {
        if (!this.i) {
            this.i = 1;
            return cc.i.a(this.m, p3, 2);
        } else {
            return p3;
        }
    }

    public final void flush()
    {
        try {
            super.flush();
            return;
        } catch (java.io.IOException v0_0) {
            java.io.IOException v0_1 = this.d(v0_0);
            v0_1.getClass();
            throw v0_1;
        }
    }
}
