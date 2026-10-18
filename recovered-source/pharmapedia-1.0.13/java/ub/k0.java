// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class k0 implements qb.a {
    public final qb.a a;
    public final ub.u0 b;

    public k0(qb.a p2)
    {
        p2.getClass();
        this.a = p2;
        this.b = new ub.u0(p2.getDescriptor());
        return;
    }

    public final Object deserialize(tb.c p2)
    {
        p2.getClass();
        if (!p2.p()) {
            return 0;
        } else {
            return p2.g(this.a);
        }
    }

    public final boolean equals(Object p5)
    {
        if (this != p5) {
            if ((p5) && (ub.k0 == p5.getClass())) {
                if (kotlin.jvm.internal.f.a(this.a, ((ub.k0) p5).a)) {
                    return 1;
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

    public final sb.d getDescriptor()
    {
        return this.b;
    }

    public final int hashCode()
    {
        return this.a.hashCode();
    }

    public final void serialize(tb.d p2, Object p3)
    {
        if (p3 == null) {
            p2.c();
            return;
        } else {
            p2.g(this.a, p3);
            return;
        }
    }
}
