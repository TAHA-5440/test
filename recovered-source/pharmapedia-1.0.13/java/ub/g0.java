// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class g0 extends ub.r0 {
    public static final ub.g0 c;

    static g0()
    {
        ub.g0.c = new ub.g0(ub.h0.a);
        return;
    }

    public final int d(Object p1)
    {
        ((long[]) p1).getClass();
        return ((long[]) p1).length;
    }

    public final void f(tb.a p4, int p5, Object p6)
    {
        ((ub.f0) p6).getClass();
        long v4_1 = p4.x(this.b, p5);
        ub.p0.c(((ub.f0) p6));
        long[] v0_1 = ((ub.f0) p6).a;
        int v1 = ((ub.f0) p6).b;
        ((ub.f0) p6).b = (v1 + 1);
        v0_1[v1] = v4_1;
        return;
    }

    public final Object g(Object p2)
    {
        ((long[]) p2).getClass();
        ub.f0 v0_1 = new ub.f0();
        v0_1.a = ((long[]) p2);
        v0_1.b = ((long[]) p2).length;
        v0_1.b(10);
        return v0_1;
    }

    public final Object j()
    {
        long[] v0_1 = new long[0];
        return v0_1;
    }

    public final void k(tb.b p6, Object p7, int p8)
    {
        p6.getClass();
        ((long[]) p7).getClass();
        int v0 = 0;
        while (v0 < p8) {
            ((wb.i) p6).s(this.b, v0, ((long[]) p7)[v0]);
            v0++;
        }
        return;
    }
}
