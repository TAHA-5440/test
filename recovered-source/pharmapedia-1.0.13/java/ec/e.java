// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ec;
public final class e extends ec.b {
    public long k;
    public final synthetic ec.h l;

    public e(ec.h p1, yb.u p2, long p3)
    {
        p2.getClass();
        this.l = p1;
        super(p1, p2);
        super.k = p3;
        if (p3 == 0) {
            super.d(yb.s.h);
        }
        return;
    }

    public final long N(long p8, oc.i p10)
    {
        p10.getClass();
        if (p8 < 0) {
            oc.l.d(f0.a.b("byteCount < 0: ", p8));
            return 0;
        } else {
            if (this.i) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
                return 0;
            } else {
                long v2_1 = this.k;
                if (v2_1 != 0) {
                    java.net.ProtocolException v8_4 = super.N(Math.min(v2_1, p8), p10);
                    if (v8_4 == -1) {
                        this.l.b.f();
                        java.net.ProtocolException v8_8 = new java.net.ProtocolException("unexpected end of stream");
                        this.d(ec.h.f);
                        throw v8_8;
                    } else {
                        long v2_4 = (this.k - v8_4);
                        this.k = v2_4;
                        if (v2_4 == 0) {
                            this.d(yb.s.h);
                        }
                        return v8_4;
                    }
                } else {
                    return -1;
                }
            }
        }
    }

    public final void close()
    {
        if (!this.i) {
            if (this.k != 0) {
                java.util.concurrent.TimeUnit.MILLISECONDS.getClass();
                try {
                    yb.s v0_1 = zb.e.f(this, 100);
                } catch (java.io.IOException) {
                    v0_1 = 0;
                }
                if (v0_1 == null) {
                    this.l.b.f();
                    this.d(ec.h.f);
                }
            }
            this.i = 1;
            return;
        } else {
            return;
        }
    }
}
