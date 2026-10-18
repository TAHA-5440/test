// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package db;
public final class g extends ha.d {
    public final synthetic int g;
    public final Object h;

    public g(androidx.lifecycle.j p2)
    {
        this.g = 0;
        this.h = p2;
        return;
    }

    public g(java.util.List p2)
    {
        this.g = 1;
        p2.getClass();
        this.h = p2;
        return;
    }

    public final int a()
    {
        switch (this.g) {
            case 0:
                return (((java.util.regex.Matcher) ((androidx.lifecycle.j) this.h).h).groupCount() + 1);
            default:
                return ((java.util.List) this.h).size();
        }
    }

    public bridge boolean contains(Object p2)
    {
        switch (this.g) {
            case 0:
                boolean v2_3;
                if ((p2 instanceof String)) {
                    v2_3 = super.contains(((String) p2));
                } else {
                    v2_3 = 0;
                }
                return v2_3;
            default:
                return super.contains(p2);
        }
    }

    public final Object get(int p6)
    {
        switch (this.g) {
            case 0:
                Object v6_4 = ((java.util.regex.Matcher) ((androidx.lifecycle.j) this.h).h).group(p6);
                if (v6_4 == null) {
                    v6_4 = "";
                }
                return v6_4;
            default:
                if (p6 < null) {
                    Object v6_1 = r1.a.v(p6, "Element index ", " must be in range [");
                    v6_1.append(new ab.c(0, ha.k.t(this), 1));
                    v6_1.append("].");
                    throw new IndexOutOfBoundsException(v6_1.toString());
                } else {
                    if (p6 > ha.k.t(this)) {
                    } else {
                        return ((java.util.List) this.h).get((ha.k.t(this) - p6));
                    }
                }
        }
    }

    public bridge int indexOf(Object p2)
    {
        switch (this.g) {
            case 0:
                int v2_3;
                if ((p2 instanceof String)) {
                    v2_3 = super.indexOf(((String) p2));
                } else {
                    v2_3 = -1;
                }
                return v2_3;
            default:
                return super.indexOf(p2);
        }
    }

    public java.util.Iterator iterator()
    {
        switch (this.g) {
            case 1:
                return new ha.r(this, 0);
            default:
                return super.iterator();
        }
    }

    public bridge int lastIndexOf(Object p2)
    {
        switch (this.g) {
            case 0:
                int v2_3;
                if ((p2 instanceof String)) {
                    v2_3 = super.lastIndexOf(((String) p2));
                } else {
                    v2_3 = -1;
                }
                return v2_3;
            default:
                return super.lastIndexOf(p2);
        }
    }

    public java.util.ListIterator listIterator()
    {
        switch (this.g) {
            case 1:
                return new ha.r(this, 0);
            default:
                return super.listIterator();
        }
    }

    public java.util.ListIterator listIterator(int p2)
    {
        switch (this.g) {
            case 1:
                return new ha.r(this, p2);
            default:
                return super.listIterator(p2);
        }
    }
}
