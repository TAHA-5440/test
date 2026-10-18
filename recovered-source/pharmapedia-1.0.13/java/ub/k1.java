// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class k1 extends ub.r0 {
    public static final ub.k1 c;

    static k1()
    {
        ub.k1.c = new ub.k1(ub.l1.a);
        return;
    }

    public final int d(Object p1)
    {
        return ((ga.o) p1).g.length;
    }

    public final void f(tb.a p3, int p4, Object p5)
    {
        ((ub.j1) p5).getClass();
        short v3_2 = p3.v(this.b, p4).y();
        ub.p0.c(((ub.j1) p5));
        short[] v4_1 = ((ub.j1) p5).a;
        int v0_1 = ((ub.j1) p5).b;
        ((ub.j1) p5).b = (v0_1 + 1);
        v4_1[v0_1] = v3_2;
        return;
    }

    public final Object g(Object p2)
    {
        int v2_2 = ((ga.o) p2).g;
        ub.j1 v0_1 = new ub.j1();
        v0_1.a = v2_2;
        v0_1.b = v2_2.length;
        v0_1.b(10);
        return v0_1;
    }

    public final Object j()
    {
        short[] v0_1 = new short[0];
        return new ga.o(v0_1);
    }

    public final void k(tb.b p4, Object p5, int p6)
    {
        short[] v5_2 = ((ga.o) p5).g;
        p4.getClass();
        int v0 = 0;
        while (v0 < p6) {
            ((wb.i) p4).r(this.b, v0).e(v5_2[v0]);
            v0++;
        }
        return;
    }
}
