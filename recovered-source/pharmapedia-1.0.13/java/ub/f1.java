// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class f1 implements qb.a {
    public static final ub.f1 a;
    public static final ub.x b;

    static f1()
    {
        ub.f1.a = new ub.f1();
        ub.f1.b = ub.m0.a("kotlin.UInt", ub.b0.a);
        return;
    }

    public final Object deserialize(tb.c p2)
    {
        p2.getClass();
        return new ga.i(p2.u(ub.f1.b).h());
    }

    public final sb.d getDescriptor()
    {
        return ub.f1.b;
    }

    public final void serialize(tb.d p2, Object p3)
    {
        p2.k(ub.f1.b).l(((ga.i) p3).g);
        return;
    }
}
