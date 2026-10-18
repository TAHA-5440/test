// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class m1 implements qb.a {
    public static final ub.m1 b;
    public final synthetic ub.l0 a;

    static m1()
    {
        ub.m1.b = new ub.m1();
        return;
    }

    public m1()
    {
        this.a = new ub.l0();
        return;
    }

    public final Object deserialize(tb.c p2)
    {
        p2.getClass();
        this.a.deserialize(p2);
        return ga.p.a;
    }

    public final sb.d getDescriptor()
    {
        return this.a.getDescriptor();
    }

    public final void serialize(tb.d p2, Object p3)
    {
        ((ga.p) p3).getClass();
        this.a.serialize(p2, ((ga.p) p3));
        return;
    }
}
