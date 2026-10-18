// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class y0 implements qb.a {
    public static final ub.y0 a;
    public static final ub.s0 b;

    static y0()
    {
        ub.y0.a = new ub.y0();
        ub.y0.b = new ub.s0("kotlin.Short", sb.c.l);
        return;
    }

    public final Object deserialize(tb.c p1)
    {
        p1.getClass();
        return Short.valueOf(p1.y());
    }

    public final sb.d getDescriptor()
    {
        return ub.y0.b;
    }

    public final void serialize(tb.d p1, Object p2)
    {
        p1.e(((Number) p2).shortValue());
        return;
    }
}
