// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class e extends ub.r0 {
    public static final ub.e c;

    static e()
    {
        ub.e.c = new ub.e(ub.f.a);
        return;
    }

    public final int d(Object p1)
    {
        ((boolean[]) p1).getClass();
        return ((boolean[]) p1).length;
    }

    public final void f(tb.a p3, int p4, Object p5)
    {
        ((ub.d) p5).getClass();
        boolean v3_1 = p3.s(this.b, p4);
        ub.p0.c(((ub.d) p5));
        boolean[] v4_1 = ((ub.d) p5).a;
        int v0_1 = ((ub.d) p5).b;
        ((ub.d) p5).b = (v0_1 + 1);
        v4_1[v0_1] = v3_1;
        return;
    }

    public final Object g(Object p2)
    {
        ((boolean[]) p2).getClass();
        ub.d v0_1 = new ub.d();
        v0_1.a = ((boolean[]) p2);
        v0_1.b = ((boolean[]) p2).length;
        v0_1.b(10);
        return v0_1;
    }

    public final Object j()
    {
        boolean[] v0_1 = new boolean[0];
        return v0_1;
    }

    public final void k(tb.b p5, Object p6, int p7)
    {
        p5.getClass();
        ((boolean[]) p6).getClass();
        int v0 = 0;
        while (v0 < p7) {
            boolean v1 = ((boolean[]) p6)[v0];
            ub.q0 v3 = this.b;
            v3.getClass();
            ((wb.i) p5).q(v3, v0);
            ((wb.i) p5).h(v1);
            v0++;
        }
        return;
    }
}
