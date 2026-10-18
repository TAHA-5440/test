// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.collections;
final class EmptyMap implements java.util.Map, java.io.Serializable, va.a {
    public static final kotlin.collections.EmptyMap g = None;
    private static final long serialVersionUID = 8246714829545688274;

    static EmptyMap()
    {
        kotlin.collections.EmptyMap.g = new kotlin.collections.EmptyMap();
        return;
    }

    private final Object readResolve()
    {
        return kotlin.collections.EmptyMap.g;
    }

    public final void clear()
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean containsKey(Object p1)
    {
        return 0;
    }

    public final bridge boolean containsValue(Object p1)
    {
        return 0;
    }

    public final bridge java.util.Set entrySet()
    {
        return kotlin.collections.EmptySet.g;
    }

    public final boolean equals(Object p2)
    {
        if ((!(p2 instanceof java.util.Map)) || (!((java.util.Map) p2).isEmpty())) {
            return 0;
        } else {
            return 1;
        }
    }

    public final bridge synthetic Object get(Object p1)
    {
        return 0;
    }

    public final int hashCode()
    {
        return 0;
    }

    public final boolean isEmpty()
    {
        return 1;
    }

    public final bridge java.util.Set keySet()
    {
        return kotlin.collections.EmptySet.g;
    }

    public final bridge synthetic Object put(Object p1, Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void putAll(java.util.Map p2)
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

    public final bridge int size()
    {
        return 0;
    }

    public final String toString()
    {
        return "{}";
    }

    public final bridge java.util.Collection values()
    {
        return kotlin.collections.EmptyList.g;
    }
}
