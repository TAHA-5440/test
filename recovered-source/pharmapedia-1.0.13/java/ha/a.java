// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ha;
public abstract class a implements java.util.Collection, va.a {

    public abstract int a();

    public final boolean add(Object p2)
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

    public boolean contains(Object p4)
    {
        if (!this.isEmpty()) {
            java.util.Iterator v0_1 = this.iterator();
            while (v0_1.hasNext()) {
                if (kotlin.jvm.internal.f.a(v0_1.next(), p4)) {
                    return 1;
                }
            }
            return 0;
        } else {
            return 0;
        }
    }

    public final boolean containsAll(java.util.Collection p3)
    {
        p3.getClass();
        if (!p3.isEmpty()) {
            int v3_2 = p3.iterator();
            while (v3_2.hasNext()) {
                if (!this.contains(v3_2.next())) {
                    return 0;
                }
            }
            return 1;
        } else {
            return 1;
        }
    }

    public boolean isEmpty()
    {
        if (this.a() != 0) {
            return 0;
        } else {
            return 1;
        }
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
        return this.a();
    }

    public Object[] toArray()
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
        return ha.j.I(this, ", ", "[", "]", new ac.c(this, 4), 24);
    }
}
