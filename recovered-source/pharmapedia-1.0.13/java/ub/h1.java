// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class h1 extends ub.r0 {
    public static final ub.h1 c;

    static h1()
    {
        ub.h1.c = new ub.h1(ub.i1.a);
        return;
    }

    public final int d(Object p1)
    {
        return ((ga.l) p1).g.length;
    }

    public final void f(tb.a p4, int p5, Object p6)
    {
        ((ub.g1) p6).getClass();
        long v4_2 = p4.v(this.b, p5).m();
        ub.p0.c(((ub.g1) p6));
        long[] v0_1 = ((ub.g1) p6).a;
        int v1 = ((ub.g1) p6).b;
        ((ub.g1) p6).b = (v1 + 1);
        v0_1[v1] = v4_2;
        return;
    }

    public final Object g(Object p2)
    {
        int v2_2 = ((ga.l) p2).g;
        ub.g1 v0_1 = new ub.g1();
        v0_1.a = v2_2;
        v0_1.b = v2_2.length;
        v0_1.b(10);
        return v0_1;
    }

    public final Object j()
    {
        long[] v0_1 = new long[0];
        return new ga.l(v0_1);
    }

    public final void k(tb.b p5, Object p6, int p7)
    {
        long[] v6_2 = ((ga.l) p6).g;
        p5.getClass();
        int v0 = 0;
        while (v0 < p7) {
            ((wb.i) p5).r(this.b, v0).m(v6_2[v0]);
            v0++;
        }
        return;
    }
}
