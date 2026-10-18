// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class h0 implements qb.a {
    public static final ub.h0 a;
    public static final ub.s0 b;

    static h0()
    {
        ub.h0.a = new ub.h0();
        ub.h0.b = new ub.s0("kotlin.Long", sb.c.k);
        return;
    }

    public final Object deserialize(tb.c p3)
    {
        p3.getClass();
        return Long.valueOf(p3.m());
    }

    public final sb.d getDescriptor()
    {
        return ub.h0.b;
    }

    public final void serialize(tb.d p3, Object p4)
    {
        p3.m(((Number) p4).longValue());
        return;
    }
}
