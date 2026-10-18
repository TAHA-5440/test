// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vb;
public final class d extends vb.j implements java.util.List, va.a {
    public static final vb.c Companion;
    public final java.util.List g;

    static d()
    {
        vb.d.Companion = new vb.c();
        return;
    }

    public d(java.util.List p1)
    {
        p1.getClass();
        this.g = p1;
        return;
    }

    public final bridge synthetic void add(int p1, Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final bridge synthetic boolean add(Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean addAll(int p1, java.util.Collection p2)
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

    public final boolean contains(Object p2)
    {
        if ((p2 instanceof vb.j)) {
            return this.g.contains(((vb.j) p2));
        } else {
            return 0;
        }
    }

    public final boolean containsAll(java.util.Collection p2)
    {
        p2.getClass();
        return this.g.containsAll(p2);
    }

    public final boolean equals(Object p2)
    {
        return kotlin.jvm.internal.f.a(this.g, p2);
    }

    public final Object get(int p2)
    {
        return ((vb.j) this.g.get(p2));
    }

    public final int hashCode()
    {
        return this.g.hashCode();
    }

    public final int indexOf(Object p2)
    {
        if ((p2 instanceof vb.j)) {
            return this.g.indexOf(((vb.j) p2));
        } else {
            return -1;
        }
    }

    public final boolean isEmpty()
    {
        return this.g.isEmpty();
    }

    public final java.util.Iterator iterator()
    {
        return this.g.iterator();
    }

    public final int lastIndexOf(Object p2)
    {
        if ((p2 instanceof vb.j)) {
            return this.g.lastIndexOf(((vb.j) p2));
        } else {
            return -1;
        }
    }

    public final java.util.ListIterator listIterator()
    {
        return this.g.listIterator();
    }

    public final java.util.ListIterator listIterator(int p2)
    {
        return this.g.listIterator(p2);
    }

    public final bridge synthetic Object remove(int p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean remove(Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean removeAll(java.util.Collection p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void replaceAll(java.util.function.UnaryOperator p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean retainAll(java.util.Collection p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final bridge synthetic Object set(int p1, Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size()
    {
        return this.g.size();
    }

    public final void sort(java.util.Comparator p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final java.util.List subList(int p2, int p3)
    {
        return this.g.subList(p2, p3);
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
        return ha.j.I(this.g, ",", "[", "]", 0, 56);
    }
}
