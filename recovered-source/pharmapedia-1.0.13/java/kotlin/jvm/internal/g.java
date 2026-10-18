// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.jvm.internal;
public final class g implements kotlin.jvm.internal.a {
    public final Class g;

    public g(Class p1)
    {
        p1.getClass();
        this.g = p1;
        return;
    }

    public final Class a()
    {
        return this.g;
    }

    public final boolean equals(Object p2)
    {
        if ((!(p2 instanceof kotlin.jvm.internal.g)) || (!kotlin.jvm.internal.f.a(this.g, ((kotlin.jvm.internal.g) p2).g))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        return this.g.hashCode();
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder();
        v0_1.append(this.g.toString());
        v0_1.append(" (Kotlin reflection is not available)");
        return v0_1.toString();
    }
}
