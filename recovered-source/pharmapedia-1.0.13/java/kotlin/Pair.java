// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin;
public final class Pair implements java.io.Serializable {
    public final Object g;
    public final Object h;

    public Pair(Object p1, Object p2)
    {
        this.g = p1;
        this.h = p2;
        return;
    }

    public final boolean equals(Object p5)
    {
        if (this != p5) {
            if ((p5 instanceof kotlin.Pair)) {
                if (kotlin.jvm.internal.f.a(this.g, ((kotlin.Pair) p5).g)) {
                    if (kotlin.jvm.internal.f.a(this.h, ((kotlin.Pair) p5).h)) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
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
        int v1_2;
        int v0 = 0;
        int v1_0 = this.g;
        if (v1_0 != 0) {
            v1_2 = v1_0.hashCode();
        } else {
            v1_2 = 0;
        }
        int v1_3 = (v1_2 * 31);
        Object v2 = this.h;
        if (v2 != null) {
            v0 = v2.hashCode();
        }
        return (v1_3 + v0);
    }

    public final String toString()
    {
        String v0_2 = new StringBuilder("(");
        v0_2.append(this.g);
        v0_2.append(", ");
        v0_2.append(this.h);
        v0_2.append(41);
        return v0_2.toString();
    }
}
