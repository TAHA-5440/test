// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ga;
public final class k implements java.lang.Comparable {
    public final long g;

    public synthetic k(long p1)
    {
        this.g = p1;
        return;
    }

    public final int compareTo(Object p7)
    {
        return kotlin.jvm.internal.f.d((this.g ^ -9223372036854775808), (((ga.k) p7).g ^ -9223372036854775808));
    }

    public final boolean equals(Object p5)
    {
        if (((p5 instanceof ga.k)) && (this.g == ((ga.k) p5).g)) {
            return 1;
        } else {
            return 0;
        }
    }

    public final int hashCode()
    {
        return Long.hashCode(this.g);
    }

    public final String toString()
    {
        long v2_0 = this.g;
        if (v2_0 < 0) {
            long v4_0 = (((v2_0 >> 1) / ((long) 10)) << 1);
            long v2_1 = (v2_0 - (v4_0 * ((long) 10)));
            if (v2_1 >= ((long) 10)) {
                v2_1 -= ((long) 10);
                v4_0++;
            }
            a.a.c(10);
            String v0_2 = Long.toString(v4_0, 10);
            v0_2.getClass();
            a.a.c(10);
            String v1_0 = Long.toString(v2_1, 10);
            v1_0.getClass();
            return v0_2.concat(v1_0);
        } else {
            a.a.c(10);
            String v0_5 = Long.toString(v2_0, 10);
            v0_5.getClass();
            return v0_5;
        }
    }
}
