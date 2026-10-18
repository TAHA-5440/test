// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ec;
public abstract class b implements oc.d0 {
    public final yb.u g;
    public final oc.r h;
    public boolean i;
    public final synthetic ec.h j;

    public b(ec.h p1, yb.u p2)
    {
        p2.getClass();
        this.j = p1;
        this.g = p2;
        this.h = new oc.r(((oc.y) p1.c.i).g.a());
        return;
    }

    public long N(long p3, oc.i p5)
    {
        ec.h v0 = this.j;
        p5.getClass();
        try {
            return ((oc.y) v0.c.i).N(p3, p5);
        } catch (java.io.IOException v3_2) {
            v0.b.f();
            this.d(ec.h.f);
            throw v3_2;
        }
    }

    public final oc.f0 a()
    {
        return this.h;
    }

    public final void d(yb.s p6)
    {
        p6.getClass();
        yb.b v0_0 = this.j;
        yb.u v1_2 = v0_0.d;
        if (v1_2 != 6) {
            if (v1_2 != 5) {
                yb.b v0_4 = v0_0.d;
                yb.u v1_0 = new StringBuilder("state: ");
                v1_0.append(v0_4);
                throw new IllegalStateException(v1_0.toString());
            } else {
                yb.u v1_1 = this.h;
                oc.f0 v3_0 = v1_1.e;
                v1_1.e = oc.f0.d;
                v3_0.a();
                v3_0.b();
                v0_0.d = 6;
                if (p6.size() > 0) {
                    yb.b v0_2 = v0_0.a;
                    if (v0_2 != null) {
                        yb.b v0_3 = v0_2.j;
                        if (v0_3 != null) {
                            dc.f.b(v0_3, this.g, p6);
                        }
                    }
                }
            }
        }
        return;
    }
}
