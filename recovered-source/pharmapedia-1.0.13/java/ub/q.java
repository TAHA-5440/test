// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class q implements qb.a {
    public static final ub.q a;
    public static final ub.s0 b;

    static q()
    {
        ub.q.a = new ub.q();
        ub.q.b = new ub.s0("kotlin.Double", sb.c.h);
        return;
    }

    public final Object deserialize(tb.c p3)
    {
        p3.getClass();
        return Double.valueOf(p3.A());
    }

    public final sb.d getDescriptor()
    {
        return ub.q.b;
    }

    public final void serialize(tb.d p3, Object p4)
    {
        p3.d(((Number) p4).doubleValue());
        return;
    }
}
