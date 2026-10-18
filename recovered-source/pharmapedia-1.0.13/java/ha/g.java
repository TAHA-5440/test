// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ha;
public final class g implements java.util.Collection, va.a {
    public final Object[] g;
    public final boolean h;

    public g(Object[] p1, boolean p2)
    {
        this.g = p1;
        this.h = p2;
        return;
    }

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

    public final boolean contains(Object p6)
    {
        Object v2_0;
        Object[] v0 = this.g;
        if (p6 != 0) {
            int v3_0 = 0;
            while (v3_0 < v0.length) {
                if (!p6.equals(v0[v3_0])) {
                    v3_0++;
                } else {
                    v2_0 = v3_0;
                }
            }
            v2_0 = -1;
        } else {
            v2_0 = 0;
            while (v2_0 < v0.length) {
                if (v0[v2_0] != null) {
                    v2_0++;
                }
            }
        }
        if (v2_0 < null) {
            return 0;
        } else {
            return 1;
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

    public final boolean isEmpty()
    {
        if (this.g.length != 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final java.util.Iterator iterator()
    {
        return new ga.g(this.g);
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

    public final int size()
    {
        return this.g.length;
    }

    public final Object[] toArray()
    {
        Object[] v0_0 = this.g;
        if ((!this.h) || (!v0_0.getClass().equals(Object[]))) {
            Object[] v0_1 = java.util.Arrays.copyOf(v0_0, v0_0.length, Object[]);
            v0_1.getClass();
            return v0_1;
        } else {
            return v0_0;
        }
    }

    public final Object[] toArray(Object[] p1)
    {
        p1.getClass();
        return kotlin.jvm.internal.f.k(this, p1);
    }
}
