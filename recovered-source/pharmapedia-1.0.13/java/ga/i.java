// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ga;
public final class i implements java.lang.Comparable {
    public final int g;

    public synthetic i(int p1)
    {
        this.g = p1;
        return;
    }

    public final int compareTo(Object p3)
    {
        return kotlin.jvm.internal.f.c((this.g ^ -2147483648), (((ga.i) p3).g ^ -2147483648));
    }

    public final boolean equals(Object p2)
    {
        if (((p2 instanceof ga.i)) && (this.g == ((ga.i) p2).g)) {
            return 1;
        } else {
            return 0;
        }
    }

    public final int hashCode()
    {
        return Integer.hashCode(this.g);
    }

    public final String toString()
    {
        return String.valueOf((((long) this.g) & 4294967295));
    }
}
