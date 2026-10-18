// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ga;
public final class o implements java.util.Collection, va.a {
    public final short[] g;

    public synthetic o(short[] p1)
    {
        this.g = p1;
        return;
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

    public final boolean contains(Object p6)
    {
        if ((p6 instanceof ga.n)) {
            short[] v0_1 = this.g;
            int v3 = 0;
            while (v3 < v0_1.length) {
                if (((ga.n) p6).g != v0_1[v3]) {
                    v3++;
                }
                if (v3 < 0) {
                    return 0;
                } else {
                    return 1;
                }
            }
            v3 = -1;
        } else {
            return 0;
        }
    }

    public final boolean containsAll(java.util.Collection p8)
    {
        p8.getClass();
        if (!p8.isEmpty()) {
            java.util.Iterator v8_1 = p8.iterator();
            while (v8_1.hasNext()) {
                int v0_0 = v8_1.next();
                if ((v0_0 instanceof ga.n)) {
                    short[] v2_1 = this.g;
                    int v5 = 0;
                    while (v5 < v2_1.length) {
                        if (((ga.n) v0_0).g != v2_1[v5]) {
                            v5++;
                        }
                        int v0_4;
                        if (v5 < 0) {
                            v0_4 = 0;
                        } else {
                            v0_4 = 1;
                        }
                        if (v0_4 != 0) {
                        }
                    }
                    v5 = -1;
                }
                return 0;
            }
        }
        return 1;
    }

    public final boolean equals(Object p2)
    {
        if (((p2 instanceof ga.o)) && (this.g.equals(((ga.o) p2).g))) {
            return 1;
        } else {
            return 0;
        }
    }

    public final int hashCode()
    {
        return java.util.Arrays.hashCode(this.g);
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
        return new ga.g(this.g, 3);
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
        return kotlin.jvm.internal.f.j(this);
    }

    public final Object[] toArray(Object[] p1)
    {
        p1.getClass();
        return kotlin.jvm.internal.f.k(this, p1);
    }

    public final String toString()
    {
        String v0_2 = new StringBuilder("UShortArray(storage=");
        v0_2.append(java.util.Arrays.toString(this.g));
        v0_2.append(41);
        return v0_2.toString();
    }
}
