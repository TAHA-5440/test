// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class i implements qb.a {
    public static final ub.i a;
    public static final ub.s0 b;

    static i()
    {
        ub.i.a = new ub.i();
        ub.i.b = new ub.s0("kotlin.Byte", sb.c.f);
        return;
    }

    public final Object deserialize(tb.c p1)
    {
        p1.getClass();
        return Byte.valueOf(p1.w());
    }

    public final sb.d getDescriptor()
    {
        return ub.i.b;
    }

    public final void serialize(tb.d p1, Object p2)
    {
        p1.f(((Number) p2).byteValue());
        return;
    }
}
