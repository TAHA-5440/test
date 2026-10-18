// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class i1 implements qb.a {
    public static final ub.i1 a;
    public static final ub.x b;

    static i1()
    {
        ub.i1.a = new ub.i1();
        ub.i1.b = ub.m0.a("kotlin.ULong", ub.h0.a);
        return;
    }

    public final Object deserialize(tb.c p3)
    {
        p3.getClass();
        return new ga.k(p3.u(ub.i1.b).m());
    }

    public final sb.d getDescriptor()
    {
        return ub.i1.b;
    }

    public final void serialize(tb.d p3, Object p4)
    {
        p3.k(ub.i1.b).m(((ga.k) p4).g);
        return;
    }
}
