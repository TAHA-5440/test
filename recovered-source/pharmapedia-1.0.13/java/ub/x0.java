// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class x0 extends ub.r0 {
    public static final ub.x0 c;

    static x0()
    {
        ub.x0.c = new ub.x0(ub.y0.a);
        return;
    }

    public final int d(Object p1)
    {
        ((short[]) p1).getClass();
        return ((short[]) p1).length;
    }

    public final void f(tb.a p3, int p4, Object p5)
    {
        ((ub.w0) p5).getClass();
        short v3_1 = p3.o(this.b, p4);
        ub.p0.c(((ub.w0) p5));
        short[] v4_1 = ((ub.w0) p5).a;
        int v0_1 = ((ub.w0) p5).b;
        ((ub.w0) p5).b = (v0_1 + 1);
        v4_1[v0_1] = v3_1;
        return;
    }

    public final Object g(Object p2)
    {
        ((short[]) p2).getClass();
        ub.w0 v0_1 = new ub.w0();
        v0_1.a = ((short[]) p2);
        v0_1.b = ((short[]) p2).length;
        v0_1.b(10);
        return v0_1;
    }

    public final Object j()
    {
        short[] v0_1 = new short[0];
        return v0_1;
    }

    public final void k(tb.b p5, Object p6, int p7)
    {
        p5.getClass();
        ((short[]) p6).getClass();
        int v0 = 0;
        while (v0 < p7) {
            short v1 = ((short[]) p6)[v0];
            ub.q0 v3 = this.b;
            v3.getClass();
            ((wb.i) p5).q(v3, v0);
            ((wb.i) p5).e(v1);
            v0++;
        }
        return;
    }
}
