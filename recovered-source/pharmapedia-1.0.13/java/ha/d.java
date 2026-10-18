// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ha;
public abstract class d extends ha.a implements java.util.List {

    public d()
    {
        return;
    }

    public final void add(int p1, Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean addAll(int p1, java.util.Collection p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean equals(Object p6)
    {
        if (p6 != this) {
            if ((p6 instanceof java.util.List)) {
                if (this.size() == ((java.util.Collection) p6).size()) {
                    java.util.Iterator v6_1 = ((java.util.Collection) p6).iterator();
                    java.util.Iterator v1_0 = this.iterator();
                    while (v1_0.hasNext()) {
                        if (!kotlin.jvm.internal.f.a(v1_0.next(), v6_1.next())) {
                        }
                    }
                    return 1;
                }
                return 0;
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        java.util.Iterator v0 = this.iterator();
        int v1_0 = 1;
        while (v0.hasNext()) {
            int v2_0;
            int v2_2 = v0.next();
            int v1_1 = (v1_0 * 31);
            if (v2_2 == 0) {
                v2_0 = 0;
            } else {
                v2_0 = v2_2.hashCode();
            }
            v1_0 = (v1_1 + v2_0);
        }
        return v1_0;
    }

    public int indexOf(Object p4)
    {
        java.util.Iterator v0 = this.iterator();
        int v1 = 0;
        while (v0.hasNext()) {
            if (!kotlin.jvm.internal.f.a(v0.next(), p4)) {
                v1++;
            } else {
                return v1;
            }
        }
        return -1;
    }

    public java.util.Iterator iterator()
    {
        return new ga.g(this, 4);
    }

    public int lastIndexOf(Object p3)
    {
        java.util.ListIterator v0_1 = this.listIterator(this.size());
        while (v0_1.hasPrevious()) {
            if (kotlin.jvm.internal.f.a(v0_1.previous(), p3)) {
                return v0_1.nextIndex();
            }
        }
        return -1;
    }

    public java.util.ListIterator listIterator()
    {
        return new ha.b(this, 0);
    }

    public java.util.ListIterator listIterator(int p2)
    {
        return new ha.b(this, p2);
    }

    public final Object remove(int p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Object set(int p1, Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public java.util.List subList(int p2, int p3)
    {
        return new ha.c(this, p2, p3);
    }
}
