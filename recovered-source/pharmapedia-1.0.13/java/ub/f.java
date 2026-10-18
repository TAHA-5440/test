// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class f implements qb.a {
    public static final ub.f a;
    public static final ub.s0 b;

    static f()
    {
        ub.f.a = new ub.f();
        ub.f.b = new ub.s0("kotlin.Boolean", sb.c.e);
        return;
    }

    public final Object deserialize(tb.c p1)
    {
        p1.getClass();
        return Boolean.valueOf(p1.c());
    }

    public final sb.d getDescriptor()
    {
        return ub.f.b;
    }

    public final void serialize(tb.d p1, Object p2)
    {
        p1.h(((Boolean) p2).booleanValue());
        return;
    }
}
