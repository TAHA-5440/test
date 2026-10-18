// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class p extends ub.r0 {
    public static final ub.p c;

    static p()
    {
        ub.p.c = new ub.p(ub.q.a);
        return;
    }

    public final int d(Object p1)
    {
        ((double[]) p1).getClass();
        return ((double[]) p1).length;
    }

    public final void f(tb.a p4, int p5, Object p6)
    {
        ((ub.o) p6).getClass();
        double v4_1 = p4.f(this.b, p5);
        ub.p0.c(((ub.o) p6));
        double[] v0_1 = ((ub.o) p6).a;
        int v1 = ((ub.o) p6).b;
        ((ub.o) p6).b = (v1 + 1);
        v0_1[v1] = v4_1;
        return;
    }

    public final Object g(Object p2)
    {
        ((double[]) p2).getClass();
        ub.o v0_1 = new ub.o();
        v0_1.a = ((double[]) p2);
        v0_1.b = ((double[]) p2).length;
        v0_1.b(10);
        return v0_1;
    }

    public final Object j()
    {
        double[] v0_1 = new double[0];
        return v0_1;
    }

    public final void k(tb.b p6, Object p7, int p8)
    {
        p6.getClass();
        ((double[]) p7).getClass();
        int v0 = 0;
        while (v0 < p8) {
            double v1 = ((double[]) p7)[v0];
            ub.q0 v4 = this.b;
            v4.getClass();
            ((wb.i) p6).q(v4, v0);
            ((wb.i) p6).d(v1);
            v0++;
        }
        return;
    }
}
