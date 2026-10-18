// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ib;
public final class g {
    public static final ib.f b;
    public final Object a;

    static g()
    {
        ib.g.b = new ib.f();
        return;
    }

    public synthetic g(Object p1)
    {
        this.a = p1;
        return;
    }

    public final boolean equals(Object p2)
    {
        if (((p2 instanceof ib.g)) && (this.a.equals(((ib.g) p2).a))) {
            return 1;
        } else {
            return 0;
        }
    }

    public final int hashCode()
    {
        return this.a.hashCode();
    }

    public final String toString()
    {
        String v0_0 = this.a;
        if (!(v0_0 instanceof ib.e)) {
            StringBuilder v1_2 = new StringBuilder("Value(");
            v1_2.append(v0_0);
            v1_2.append(41);
            return v1_2.toString();
        } else {
            return ((ib.e) v0_0).toString();
        }
    }
}
