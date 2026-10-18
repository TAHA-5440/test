// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class e1 extends ub.r0 {
    public static final ub.e1 c;

    static e1()
    {
        ub.e1.c = new ub.e1(ub.f1.a);
        return;
    }

    public final int d(Object p1)
    {
        return ((ga.j) p1).g.length;
    }

    public final void f(tb.a p3, int p4, Object p5)
    {
        ((ub.d1) p5).getClass();
        int v3_2 = p3.v(this.b, p4).h();
        ub.p0.c(((ub.d1) p5));
        int[] v4_1 = ((ub.d1) p5).a;
        int v0_1 = ((ub.d1) p5).b;
        ((ub.d1) p5).b = (v0_1 + 1);
        v4_1[v0_1] = v3_2;
        return;
    }

    public final Object g(Object p2)
    {
        int v2_2 = ((ga.j) p2).g;
        ub.d1 v0_1 = new ub.d1();
        v0_1.a = v2_2;
        v0_1.b = v2_2.length;
        v0_1.b(10);
        return v0_1;
    }

    public final Object j()
    {
        int[] v0_1 = new int[0];
        return new ga.j(v0_1);
    }

    public final void k(tb.b p4, Object p5, int p6)
    {
        int[] v5_2 = ((ga.j) p5).g;
        p4.getClass();
        int v0 = 0;
        while (v0 < p6) {
            ((wb.i) p4).r(this.b, v0).l(v5_2[v0]);
            v0++;
        }
        return;
    }
}
