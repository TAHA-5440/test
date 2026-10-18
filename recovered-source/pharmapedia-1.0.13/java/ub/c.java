// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class c extends ub.n {
    public final ub.b b;

    public c()
    {
        super(vb.l.a);
        sb.e v1 = vb.l.b;
        v1.getClass();
        super.b = new ub.b(v1);
        return;
    }

    public final Object a()
    {
        return new java.util.ArrayList();
    }

    public final int b(Object p1)
    {
        ((java.util.ArrayList) p1).getClass();
        return ((java.util.ArrayList) p1).size();
    }

    public final java.util.Iterator c(Object p1)
    {
        ((java.util.Collection) p1).getClass();
        return ((java.util.Collection) p1).iterator();
    }

    public final int d(Object p1)
    {
        ((java.util.Collection) p1).getClass();
        return ((java.util.Collection) p1).size();
    }

    public final Object g(Object p1)
    {
        throw 0;
    }

    public final sb.d getDescriptor()
    {
        return this.b;
    }

    public final Object h(Object p1)
    {
        ((java.util.ArrayList) p1).getClass();
        return ((java.util.ArrayList) p1);
    }

    public final void i(int p1, Object p2, Object p3)
    {
        ((java.util.ArrayList) p2).getClass();
        ((java.util.ArrayList) p2).add(p1, p3);
        return;
    }
}
