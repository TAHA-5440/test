// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ec;
public final class c implements oc.b0 {
    public final oc.r g;
    public boolean h;
    public final synthetic ec.h i;

    public c(ec.h p2)
    {
        this.i = p2;
        this.g = new oc.r(((oc.x) p2.c.j).g.a());
        return;
    }

    public final void D(long p5, oc.i p7)
    {
        if (this.h) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return;
        } else {
            if (p5 != 0) {
                oc.x v0_2 = ((oc.x) this.i.c.j);
                if (v0_2.i) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
                    return;
                } else {
                    v0_2.h.q0(p5);
                    v0_2.d();
                    v0_2.G("\r\n");
                    v0_2.D(p5, p7);
                    v0_2.G("\r\n");
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final oc.f0 a()
    {
        return this.g;
    }

    public final declared_synchronized void close()
    {
        if (!this.h) {
            this.h = 1;
            ((oc.x) this.i.c.j).G("0\r\n\r\n");
            ec.h v0_1 = this.g;
            int v1_0 = v0_1.e;
            v0_1.e = oc.f0.d;
            v1_0.a();
            v1_0.b();
            this.i.d = 3;
            return;
        } else {
            return;
        }
    }

    public final declared_synchronized void flush()
    {
        if (!this.h) {
            ((oc.x) this.i.c.j).flush();
            return;
        } else {
            return;
        }
    }
}
