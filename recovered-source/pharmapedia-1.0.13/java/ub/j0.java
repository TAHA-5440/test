// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class j0 implements qb.a {
    public static final ub.j0 a;
    public static final ub.i0 b;

    static j0()
    {
        ub.j0.a = new ub.j0();
        ub.j0.b = ub.i0.a;
        return;
    }

    public final Object deserialize(tb.c p2)
    {
        p2.getClass();
        throw new kotlinx.serialization.SerializationException("\'kotlin.Nothing\' does not have instances");
    }

    public final sb.d getDescriptor()
    {
        return ub.j0.b;
    }

    public final void serialize(tb.d p1, Object p2)
    {
        ((Void) p2).getClass();
        throw new kotlinx.serialization.SerializationException("\'kotlin.Nothing\' cannot be serialized");
    }
}
