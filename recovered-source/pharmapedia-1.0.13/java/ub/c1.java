// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class c1 implements qb.a {
    public static final ub.c1 a;
    public static final ub.x b;

    static c1()
    {
        ub.c1.a = new ub.c1();
        ub.c1.b = ub.m0.a("kotlin.UByte", ub.i.a);
        return;
    }

    public final Object deserialize(tb.c p2)
    {
        p2.getClass();
        return new ga.f(p2.u(ub.c1.b).w());
    }

    public final sb.d getDescriptor()
    {
        return ub.c1.b;
    }

    public final void serialize(tb.d p2, Object p3)
    {
        p2.k(ub.c1.b).f(((ga.f) p3).g);
        return;
    }
}
