// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class a0 extends ub.r0 {
    public static final ub.a0 c;

    static a0()
    {
        ub.a0.c = new ub.a0(ub.b0.a);
        return;
    }

    public final int d(Object p1)
    {
        ((int[]) p1).getClass();
        return ((int[]) p1).length;
    }

    public final void f(tb.a p3, int p4, Object p5)
    {
        ((ub.z) p5).getClass();
        int v3_1 = p3.e(this.b, p4);
        ub.p0.c(((ub.z) p5));
        int[] v4_1 = ((ub.z) p5).a;
        int v0_1 = ((ub.z) p5).b;
        ((ub.z) p5).b = (v0_1 + 1);
        v4_1[v0_1] = v3_1;
        return;
    }

    public final Object g(Object p2)
    {
        ((int[]) p2).getClass();
        ub.z v0_1 = new ub.z();
        v0_1.a = ((int[]) p2);
        v0_1.b = ((int[]) p2).length;
        v0_1.b(10);
        return v0_1;
    }

    public final Object j()
    {
        int[] v0_1 = new int[0];
        return v0_1;
    }

    public final void k(tb.b p5, Object p6, int p7)
    {
        p5.getClass();
        ((int[]) p6).getClass();
        int v0 = 0;
        while (v0 < p7) {
            int v1 = ((int[]) p6)[v0];
            ub.q0 v3 = this.b;
            v3.getClass();
            ((wb.i) p5).q(v3, v0);
            ((wb.i) p5).l(v1);
            v0++;
        }
        return;
    }
}
