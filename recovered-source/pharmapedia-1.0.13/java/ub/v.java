// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class v implements qb.a {
    public static final ub.v a;
    public static final ub.s0 b;

    static v()
    {
        ub.v.a = new ub.v();
        ub.v.b = new ub.s0("kotlin.Float", sb.c.i);
        return;
    }

    public final Object deserialize(tb.c p1)
    {
        p1.getClass();
        return Float.valueOf(p1.z());
    }

    public final sb.d getDescriptor()
    {
        return ub.v.b;
    }

    public final void serialize(tb.d p1, Object p2)
    {
        p1.i(((Number) p2).floatValue());
        return;
    }
}
