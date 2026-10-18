// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin;
public final class Triple implements java.io.Serializable {
    public final String g;
    public final Object h;
    public final Object i;

    public Triple(String p1, String p2, String p3)
    {
        this.g = p1;
        this.h = p2;
        this.i = p3;
        return;
    }

    public final boolean equals(Object p3)
    {
        if ((this == p3) || (((p3 instanceof kotlin.Triple)) && ((this.g.equals(((kotlin.Triple) p3).g)) && ((kotlin.jvm.internal.f.a(this.h, ((kotlin.Triple) p3).h)) && (kotlin.jvm.internal.f.a(this.i, ((kotlin.Triple) p3).i)))))) {
            return 1;
        } else {
            return 0;
        }
    }

    public final int hashCode()
    {
        Object v2_2;
        int v0_5 = (this.g.hashCode() * 31);
        int v1 = 0;
        Object v2_1 = this.h;
        if (v2_1 != null) {
            v2_2 = v2_1.hashCode();
        } else {
            v2_2 = 0;
        }
        int v0_2 = ((v0_5 + v2_2) * 31);
        Object v2_0 = this.i;
        if (v2_0 != null) {
            v1 = v2_0.hashCode();
        }
        return (v0_2 + v1);
    }

    public final String toString()
    {
        String v0_2 = new StringBuilder("(");
        v0_2.append(this.g);
        v0_2.append(", ");
        v0_2.append(this.h);
        v0_2.append(", ");
        v0_2.append(this.i);
        v0_2.append(41);
        return v0_2.toString();
    }
}
