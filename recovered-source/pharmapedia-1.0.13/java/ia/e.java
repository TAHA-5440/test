// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ia;
public final class e extends java.util.AbstractCollection implements java.util.Collection, va.b {
    public final kotlin.collections.builders.MapBuilder g;

    public e(kotlin.collections.builders.MapBuilder p1)
    {
        this.g = p1;
        return;
    }

    public final boolean add(Object p1)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(java.util.Collection p1)
    {
        p1.getClass();
        throw new UnsupportedOperationException();
    }

    public final void clear()
    {
        this.g.clear();
        return;
    }

    public final boolean contains(Object p2)
    {
        return this.g.containsValue(p2);
    }

    public final boolean isEmpty()
    {
        return this.g.isEmpty();
    }

    public final java.util.Iterator iterator()
    {
        kotlin.collections.builders.MapBuilder v0 = this.g;
        v0.getClass();
        return new ia.b(v0, 2);
    }

    public final boolean remove(Object p2)
    {
        kotlin.collections.builders.MapBuilder v0 = this.g;
        v0.c();
        int v2_1 = v0.h(p2);
        if (v2_1 >= 0) {
            v0.k(v2_1);
            return 1;
        } else {
            return 0;
        }
    }

    public final boolean removeAll(java.util.Collection p2)
    {
        p2.getClass();
        this.g.c();
        return super.removeAll(p2);
    }

    public final boolean retainAll(java.util.Collection p2)
    {
        p2.getClass();
        this.g.c();
        return super.retainAll(p2);
    }

    public final int size()
    {
        return this.g.o;
    }
}
