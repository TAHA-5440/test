// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ga;
public final class n implements java.lang.Comparable {
    public final short g;

    public synthetic n(short p1)
    {
        this.g = p1;
        return;
    }

    public final synthetic int compareTo(Object p3)
    {
        return kotlin.jvm.internal.f.c((this.g & 65535), (((ga.n) p3).g & 65535));
    }

    public final boolean equals(Object p2)
    {
        if (((p2 instanceof ga.n)) && (this.g == ((ga.n) p2).g)) {
            return 1;
        } else {
            return 0;
        }
    }

    public final int hashCode()
    {
        return Short.hashCode(this.g);
    }

    public final String toString()
    {
        return String.valueOf((this.g & 65535));
    }
}
