// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class b0 implements qb.a {
    public static final ub.b0 a;
    public static final ub.s0 b;

    static b0()
    {
        ub.b0.a = new ub.b0();
        ub.b0.b = new ub.s0("kotlin.Int", sb.c.j);
        return;
    }

    public final Object deserialize(tb.c p1)
    {
        p1.getClass();
        return Integer.valueOf(p1.h());
    }

    public final sb.d getDescriptor()
    {
        return ub.b0.b;
    }

    public final void serialize(tb.d p1, Object p2)
    {
        p1.l(((Number) p2).intValue());
        return;
    }
}
