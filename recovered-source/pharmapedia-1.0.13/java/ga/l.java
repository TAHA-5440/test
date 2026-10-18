// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ga;
public final class l implements java.util.Collection, va.a {
    public final long[] g;

    public synthetic l(long[] p1)
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

    public final boolean contains(Object p8)
    {
        if ((p8 instanceof ga.k)) {
            int v8_3 = this.g;
            int v4 = 0;
            while (v4 < v8_3.length) {
                if (((ga.k) p8).g != v8_3[v4]) {
                    v4++;
                }
                if (v4 < 0) {
                    return 0;
                } else {
                    return 1;
                }
            }
            v4 = -1;
        } else {
            return 0;
        }
    }

    public final boolean containsAll(java.util.Collection p10)
    {
        p10.getClass();
        if (!p10.isEmpty()) {
            java.util.Iterator v10_1 = p10.iterator();
            while (v10_1.hasNext()) {
                int v0_0 = v10_1.next();
                if ((v0_0 instanceof ga.k)) {
                    int v0_2 = this.g;
                    int v6 = 0;
                    while (v6 < v0_2.length) {
                        if (((ga.k) v0_0).g != v0_2[v6]) {
                            v6++;
                        }
                        int v0_4;
                        if (v6 < 0) {
                            v0_4 = 0;
                        } else {
                            v0_4 = 1;
                        }
                        if (v0_4 != 0) {
                        }
                    }
                    v6 = -1;
                }
                return 0;
            }
        }
        return 1;
    }

    public final boolean equals(Object p2)
    {
        if (((p2 instanceof ga.l)) && (this.g.equals(((ga.l) p2).g))) {
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
        return new ga.g(this.g, 2);
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
        String v0_2 = new StringBuilder("ULongArray(storage=");
        v0_2.append(java.util.Arrays.toString(this.g));
        v0_2.append(41);
        return v0_2.toString();
    }
}
