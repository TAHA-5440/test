// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ib;
public final class e extends ib.f {
    public final Throwable a;

    public e(Throwable p1)
    {
        this.a = p1;
        return;
    }

    public final boolean equals(Object p2)
    {
        if ((!(p2 instanceof ib.e)) || (!kotlin.jvm.internal.f.a(this.a, ((ib.e) p2).a))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        int v0_0 = this.a;
        if (v0_0 == 0) {
            return 0;
        } else {
            return v0_0.hashCode();
        }
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder("Closed(");
        v0_1.append(this.a);
        v0_1.append(41);
        return v0_1.toString();
    }
}
