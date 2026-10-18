// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ha;
public final class r implements java.util.ListIterator, va.a {
    public final java.util.ListIterator g;
    public final synthetic db.g h;

    public r(db.g p5, int p6)
    {
        this.h = p5;
        if ((p6 < null) || (p6 > p5.a())) {
            StringBuilder v6_1 = r1.a.v(p6, "Position index ", " must be in range [");
            v6_1.append(new ab.c(0, p5.a(), 1));
            v6_1.append("].");
            throw new IndexOutOfBoundsException(v6_1.toString());
        } else {
            this.g = ((java.util.List) p5.h).listIterator((p5.a() - p6));
            return;
        }
    }

    public final void add(Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean hasNext()
    {
        return this.g.hasPrevious();
    }

    public final boolean hasPrevious()
    {
        return this.g.hasNext();
    }

    public final Object next()
    {
        return this.g.previous();
    }

    public final int nextIndex()
    {
        return ((this.h.size() - 1) - this.g.previousIndex());
    }

    public final Object previous()
    {
        return this.g.next();
    }

    public final int previousIndex()
    {
        return ((this.h.size() - 1) - this.g.nextIndex());
    }

    public final void remove()
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void set(Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
