// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ec;
public final class f implements oc.b0 {
    public final oc.r g;
    public boolean h;
    public final synthetic ec.h i;

    public f(ec.h p2)
    {
        this.i = p2;
        this.g = new oc.r(((oc.x) p2.c.j).g.a());
        return;
    }

    public final void D(long p6, oc.i p8)
    {
        if (this.h) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return;
        } else {
            oc.x v0_5 = p8.h;
            if ((p6 < 0) || ((0 > v0_5) || (v0_5 < p6))) {
                String v7_1 = new StringBuilder("length=");
                v7_1.append(v0_5);
                v7_1.append(", offset=0, count=0");
                throw new ArrayIndexOutOfBoundsException(v7_1.toString());
            } else {
                ((oc.x) this.i.c.j).D(p6, p8);
                return;
            }
        }
    }

    public final oc.f0 a()
    {
        return this.g;
    }

    public final void close()
    {
        if (!this.h) {
            this.h = 1;
            int v0_3 = this.g;
            ec.h v1_1 = v0_3.e;
            v0_3.e = oc.f0.d;
            v1_1.a();
            v1_1.b();
            this.i.d = 3;
            return;
        } else {
            return;
        }
    }

    public final void flush()
    {
        if (!this.h) {
            ((oc.x) this.i.c.j).flush();
            return;
        } else {
            return;
        }
    }
}
