// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.collections;
public final class EmptySet implements java.util.Set, java.io.Serializable, va.a {
    public static final kotlin.collections.EmptySet g = None;
    private static final long serialVersionUID = 3406603774387020532;

    static EmptySet()
    {
        kotlin.collections.EmptySet.g = new kotlin.collections.EmptySet();
        return;
    }

    private final Object readResolve()
    {
        return kotlin.collections.EmptySet.g;
    }

    public final bridge synthetic boolean add(Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean addAll(java.util.Collection p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void clear()
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final bridge boolean contains(Object p1)
    {
        return 0;
    }

    public final boolean containsAll(java.util.Collection p1)
    {
        p1.getClass();
        return p1.isEmpty();
    }

    public final boolean equals(Object p2)
    {
        if ((!(p2 instanceof java.util.Set)) || (!((java.util.Set) p2).isEmpty())) {
            return 0;
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        return 0;
    }

    public final boolean isEmpty()
    {
        return 1;
    }

    public final java.util.Iterator iterator()
    {
        return ha.o.g;
    }

    public final boolean remove(Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean removeAll(java.util.Collection p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean retainAll(java.util.Collection p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final bridge int size()
    {
        return 0;
    }

    public final Object[] toArray()
    {
        return kotlin.jvm.internal.f.j(this);
    }

    public final Object[] toArray(Object[] p1)
    {
        p1.getClass();
        return kotlin.jvm.internal.f.k(this, p1);
    }

    public final String toString()
    {
        return "[]";
    }
}
