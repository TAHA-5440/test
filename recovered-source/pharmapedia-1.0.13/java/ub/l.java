// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class l extends ub.r0 {
    public static final ub.l c;

    static l()
    {
        ub.l.c = new ub.l(ub.m.a);
        return;
    }

    public final int d(Object p1)
    {
        ((char[]) p1).getClass();
        return ((char[]) p1).length;
    }

    public final void f(tb.a p3, int p4, Object p5)
    {
        ((ub.k) p5).getClass();
        char v3_1 = p3.t(this.b, p4);
        ub.p0.c(((ub.k) p5));
        char[] v4_1 = ((ub.k) p5).a;
        int v0_1 = ((ub.k) p5).b;
        ((ub.k) p5).b = (v0_1 + 1);
        v4_1[v0_1] = v3_1;
        return;
    }

    public final Object g(Object p2)
    {
        ((char[]) p2).getClass();
        ub.k v0_1 = new ub.k();
        v0_1.a = ((char[]) p2);
        v0_1.b = ((char[]) p2).length;
        v0_1.b(10);
        return v0_1;
    }

    public final Object j()
    {
        char[] v0_1 = new char[0];
        return v0_1;
    }

    public final void k(tb.b p5, Object p6, int p7)
    {
        p5.getClass();
        ((char[]) p6).getClass();
        int v0 = 0;
        while (v0 < p7) {
            char v1 = ((char[]) p6)[v0];
            ub.q0 v3 = this.b;
            v3.getClass();
            ((wb.i) p5).q(v3, v0);
            ((wb.i) p5).j(v1);
            v0++;
        }
        return;
    }
}
