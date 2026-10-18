// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.collections;
public final class EmptyList implements java.util.List, java.io.Serializable, java.util.RandomAccess, va.a {
    public static final kotlin.collections.EmptyList g = None;
    private static final long serialVersionUID = 11056275309201481778;

    static EmptyList()
    {
        kotlin.collections.EmptyList.g = new kotlin.collections.EmptyList();
        return;
    }

    private final Object readResolve()
    {
        return kotlin.collections.EmptyList.g;
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
        if ((!(p2 instanceof java.util.List)) || (!((java.util.List) p2).isEmpty())) {
            return 0;
        } else {
            return 1;
        }
    }

    public final Object get(int p4)
    {
        StringBuilder v1_1 = new StringBuilder("Empty list doesn\'t contain element at index ");
        v1_1.append(p4);
        v1_1.append(46);
        throw new IndexOutOfBoundsException(v1_1.toString());
    }

    public final int hashCode()
    {
        return 1;
    }

    public final bridge int indexOf(Object p1)
    {
        return -1;
    }

    public final boolean isEmpty()
    {
        return 1;
    }

    public final java.util.Iterator iterator()
    {
        return ha.o.g;
    }

    public final bridge int lastIndexOf(Object p1)
    {
        return -1;
    }

    public final java.util.ListIterator listIterator()
    {
        return ha.o.g;
    }

    public final java.util.ListIterator listIterator(int p2)
    {
        if (p2 != 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.g(p2, "Index: "));
            return 0;
        } else {
            return ha.o.g;
        }
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

    public final boolean retainAll(java.util.Collection p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final bridge synthetic Object set(int p1, Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final bridge int size()
    {
        return 0;
    }

    public final java.util.List subList(int p3, int p4)
    {
        if ((p3 != 0) || (p4 != 0)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("fromIndex: ", ", toIndex: ", p3, p4));
            return 0;
        } else {
            return this;
        }
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
