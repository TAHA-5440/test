// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ec;
public final class g extends ec.b {
    public boolean k;

    public final long N(long p4, oc.i p6)
    {
        p6.getClass();
        if (p4 < 0) {
            oc.l.d(f0.a.b("byteCount < 0: ", p4));
        } else {
            if (this.i) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            } else {
                if (!this.k) {
                    yb.s v4_3 = super.N(p4, p6);
                    if (v4_3 != -1) {
                        return v4_3;
                    } else {
                        this.k = 1;
                        this.d(yb.s.h);
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        }
        return 0;
    }

    public final void close()
    {
        if (!this.i) {
            if (!this.k) {
                this.d(ec.h.f);
            }
            this.i = 1;
            return;
        } else {
            return;
        }
    }
}
