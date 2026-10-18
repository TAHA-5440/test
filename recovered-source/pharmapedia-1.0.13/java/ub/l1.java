// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class l1 implements qb.a {
    public static final ub.l1 a;
    public static final ub.x b;

    static l1()
    {
        ub.l1.a = new ub.l1();
        ub.l1.b = ub.m0.a("kotlin.UShort", ub.y0.a);
        return;
    }

    public final Object deserialize(tb.c p2)
    {
        p2.getClass();
        return new ga.n(p2.u(ub.l1.b).y());
    }

    public final sb.d getDescriptor()
    {
        return ub.l1.b;
    }

    public final void serialize(tb.d p2, Object p3)
    {
        p2.k(ub.l1.b).e(((ga.n) p3).g);
        return;
    }
}
