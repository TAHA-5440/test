// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class z0 implements qb.a {
    public static final ub.z0 a;
    public static final ub.s0 b;

    static z0()
    {
        ub.z0.a = new ub.z0();
        ub.z0.b = new ub.s0("kotlin.String", sb.c.m);
        return;
    }

    public final Object deserialize(tb.c p1)
    {
        p1.getClass();
        return p1.j();
    }

    public final sb.d getDescriptor()
    {
        return ub.z0.b;
    }

    public final void serialize(tb.d p1, Object p2)
    {
        ((String) p2).getClass();
        p1.p(((String) p2));
        return;
    }
}
