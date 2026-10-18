// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vb;
public final class v extends vb.j implements java.util.Map, va.a {
    public static final vb.u Companion;
    public final java.util.Map g;

    static v()
    {
        vb.v.Companion = new vb.u();
        return;
    }

    public v(java.util.Map p1)
    {
        p1.getClass();
        this.g = p1;
        return;
    }

    public final void clear()
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final bridge synthetic Object compute(Object p1, java.util.function.BiFunction p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final bridge synthetic Object computeIfAbsent(Object p1, java.util.function.Function p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final bridge synthetic Object computeIfPresent(Object p1, java.util.function.BiFunction p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean containsKey(Object p2)
    {
        if ((p2 instanceof String)) {
            return this.g.containsKey(((String) p2));
        } else {
            return 0;
        }
    }

    public final boolean containsValue(Object p2)
    {
        if ((p2 instanceof vb.j)) {
            return this.g.containsValue(((vb.j) p2));
        } else {
            return 0;
        }
    }

    public final java.util.Set entrySet()
    {
        return this.g.entrySet();
    }

    public final boolean equals(Object p2)
    {
        return kotlin.jvm.internal.f.a(this.g, p2);
    }

    public final Object get(Object p2)
    {
        if ((p2 instanceof String)) {
            return ((vb.j) this.g.get(((String) p2)));
        } else {
            return 0;
        }
    }

    public final int hashCode()
    {
        return this.g.hashCode();
    }

    public final boolean isEmpty()
    {
        return this.g.isEmpty();
    }

    public final java.util.Set keySet()
    {
        return this.g.keySet();
    }

    public final bridge synthetic Object merge(Object p1, Object p2, java.util.function.BiFunction p3)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final bridge synthetic Object put(Object p1, Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void putAll(java.util.Map p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final bridge synthetic Object putIfAbsent(Object p1, Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Object remove(Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean remove(Object p1, Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final bridge synthetic Object replace(Object p1, Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final bridge synthetic boolean replace(Object p1, Object p2, Object p3)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void replaceAll(java.util.function.BiFunction p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size()
    {
        return this.g.size();
    }

    public final String toString()
    {
        return ha.j.I(this.g.entrySet(), ",", "{", "}", new vb.t(0), 24);
    }

    public final java.util.Collection values()
    {
        return this.g.values();
    }
}
