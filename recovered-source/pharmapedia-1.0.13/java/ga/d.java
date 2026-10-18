// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ga;
public final class d implements java.lang.Comparable {
    public static final ga.d h;
    public final int g;

    static d()
    {
        ga.d.h = new ga.d();
        return;
    }

    public d()
    {
        this.g = 132106;
        return;
    }

    public final int compareTo(Object p2)
    {
        ((ga.d) p2).getClass();
        return (this.g - ((ga.d) p2).g);
    }

    public final boolean equals(Object p4)
    {
        if (this != p4) {
            int v4_1;
            if (!(p4 instanceof ga.d)) {
                v4_1 = 0;
            } else {
                v4_1 = ((ga.d) p4);
            }
            if (v4_1 != 0) {
                if (this.g != v4_1.g) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        return this.g;
    }

    public final String toString()
    {
        return "2.4.10";
    }
}
