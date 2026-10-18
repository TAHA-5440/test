// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public abstract class r0 extends ub.n {
    public final ub.q0 b;

    public r0(qb.a p2)
    {
        p2.getClass();
        super(p2);
        super.b = new ub.q0(p2.getDescriptor());
        return;
    }

    public final Object a()
    {
        return ((ub.p0) this.g(this.j()));
    }

    public final int b(Object p1)
    {
        ((ub.p0) p1).getClass();
        return ((ub.p0) p1).d();
    }

    public final java.util.Iterator c(Object p2)
    {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead");
    }

    public final Object deserialize(tb.c p1)
    {
        p1.getClass();
        return this.e(p1);
    }

    public final sb.d getDescriptor()
    {
        return this.b;
    }

    public final Object h(Object p1)
    {
        ((ub.p0) p1).getClass();
        return ((ub.p0) p1).a();
    }

    public final void i(int p1, Object p2, Object p3)
    {
        ((ub.p0) p2).getClass();
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead");
    }

    public abstract Object j();

    public abstract void k(tb.b p0, Object p1, int p2);

    public final void serialize(tb.d p3, Object p4)
    {
        int v0 = this.d(p4);
        ub.q0 v1 = this.b;
        v1.getClass();
        tb.b v3_2 = ((wb.i) p3).b(v1);
        this.k(v3_2, p4, v0);
        v3_2.a(v1);
        return;
    }
}
