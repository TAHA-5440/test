// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class b1 extends ub.r0 {
    public static final ub.b1 c;

    static b1()
    {
        ub.b1.c = new ub.b1(ub.c1.a);
        return;
    }

    public final int d(Object p1)
    {
        return ((ga.h) p1).g.length;
    }

    public final void f(tb.a p3, int p4, Object p5)
    {
        ((ub.a1) p5).getClass();
        byte v3_2 = p3.v(this.b, p4).w();
        ub.p0.c(((ub.a1) p5));
        byte[] v4_1 = ((ub.a1) p5).a;
        int v0_1 = ((ub.a1) p5).b;
        ((ub.a1) p5).b = (v0_1 + 1);
        v4_1[v0_1] = v3_2;
        return;
    }

    public final Object g(Object p2)
    {
        int v2_2 = ((ga.h) p2).g;
        ub.a1 v0_1 = new ub.a1();
        v0_1.a = v2_2;
        v0_1.b = v2_2.length;
        v0_1.b(10);
        return v0_1;
    }

    public final Object j()
    {
        byte[] v0_1 = new byte[0];
        return new ga.h(v0_1);
    }

    public final void k(tb.b p4, Object p5, int p6)
    {
        byte[] v5_2 = ((ga.h) p5).g;
        p4.getClass();
        int v0 = 0;
        while (v0 < p6) {
            ((wb.i) p4).r(this.b, v0).f(v5_2[v0]);
            v0++;
        }
        return;
    }
}
