// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cb;
public final class l implements java.util.Iterator, va.a {
    public final java.util.Iterator g;
    public final synthetic cb.g h;

    public l(cb.g p1)
    {
        this.h = p1;
        this.g = p1.c.iterator();
        return;
    }

    public final boolean hasNext()
    {
        return this.g.hasNext();
    }

    public final Object next()
    {
        return this.h.b.invoke(this.g.next());
    }

    public final void remove()
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
