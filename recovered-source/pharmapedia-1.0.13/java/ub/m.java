// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class m implements qb.a {
    public static final ub.m a;
    public static final ub.s0 b;

    static m()
    {
        ub.m.a = new ub.m();
        ub.m.b = new ub.s0("kotlin.Char", sb.c.g);
        return;
    }

    public final Object deserialize(tb.c p1)
    {
        p1.getClass();
        return Character.valueOf(p1.d());
    }

    public final sb.d getDescriptor()
    {
        return ub.m.b;
    }

    public final void serialize(tb.d p1, Object p2)
    {
        p1.j(((Character) p2).charValue());
        return;
    }
}
