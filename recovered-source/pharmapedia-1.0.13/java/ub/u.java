// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class u extends ub.r0 {
    public static final ub.u c;

    static u()
    {
        ub.u.c = new ub.u(ub.v.a);
        return;
    }

    public final int d(Object p1)
    {
        ((float[]) p1).getClass();
        return ((float[]) p1).length;
    }

    public final void f(tb.a p3, int p4, Object p5)
    {
        ((ub.t) p5).getClass();
        float v3_1 = p3.n(this.b, p4);
        ub.p0.c(((ub.t) p5));
        float[] v4_1 = ((ub.t) p5).a;
        int v0_1 = ((ub.t) p5).b;
        ((ub.t) p5).b = (v0_1 + 1);
        v4_1[v0_1] = v3_1;
        return;
    }

    public final Object g(Object p2)
    {
        ((float[]) p2).getClass();
        ub.t v0_1 = new ub.t();
        v0_1.a = ((float[]) p2);
        v0_1.b = ((float[]) p2).length;
        v0_1.b(10);
        return v0_1;
    }

    public final Object j()
    {
        float[] v0_1 = new float[0];
        return v0_1;
    }

    public final void k(tb.b p5, Object p6, int p7)
    {
        p5.getClass();
        ((float[]) p6).getClass();
        int v0 = 0;
        while (v0 < p7) {
            float v1 = ((float[]) p6)[v0];
            ub.q0 v3 = this.b;
            v3.getClass();
            ((wb.i) p5).q(v3, v0);
            ((wb.i) p5).i(v1);
            v0++;
        }
        return;
    }
}
