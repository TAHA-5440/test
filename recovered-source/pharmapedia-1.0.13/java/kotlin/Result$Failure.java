// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin;
public final class Result$Failure implements java.io.Serializable {
    public final Throwable g;

    public Result$Failure(Throwable p1)
    {
        p1.getClass();
        this.g = p1;
        return;
    }

    public final boolean equals(Object p2)
    {
        if ((!(p2 instanceof kotlin.Result$Failure)) || (!kotlin.jvm.internal.f.a(this.g, ((kotlin.Result$Failure) p2).g))) {
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
        String v0_1 = new StringBuilder("Failure(");
        v0_1.append(this.g);
        v0_1.append(41);
        return v0_1.toString();
    }
}
