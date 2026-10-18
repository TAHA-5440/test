// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class y implements ub.w {
    public final synthetic qb.a a;

    public y(qb.a p1)
    {
        this.a = p1;
        return;
    }

    public final qb.a[] childSerializers()
    {
        qb.a[] v0_1 = new qb.a[1];
        v0_1[0] = this.a;
        return v0_1;
    }

    public final Object deserialize(tb.c p2)
    {
        p2.getClass();
        throw new IllegalStateException("unsupported");
    }

    public final sb.d getDescriptor()
    {
        throw new IllegalStateException("unsupported");
    }

    public final void serialize(tb.d p1, Object p2)
    {
        throw new IllegalStateException("unsupported");
    }

    public final qb.a[] typeParametersSerializers()
    {
        return ub.m0.b;
    }
}
