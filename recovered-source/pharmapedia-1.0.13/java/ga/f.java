// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ga;
public final class f implements java.lang.Comparable {
    public final byte g;

    public synthetic f(byte p1)
    {
        this.g = p1;
        return;
    }

    public final synthetic int compareTo(Object p2)
    {
        return kotlin.jvm.internal.f.c((this.g & 255), (((ga.f) p2).g & 255));
    }

    public final boolean equals(Object p2)
    {
        if (((p2 instanceof ga.f)) && (this.g == ((ga.f) p2).g)) {
            return 1;
        } else {
            return 0;
        }
    }

    public final int hashCode()
    {
        return Byte.hashCode(this.g);
    }

    public final String toString()
    {
        return String.valueOf((this.g & 255));
    }
}
