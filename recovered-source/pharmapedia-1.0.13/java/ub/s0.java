// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class s0 implements sb.d {
    public final String a;
    public final sb.c b;

    public s0(String p1, sb.c p2)
    {
        p2.getClass();
        this.a = p1;
        this.b = p2;
        return;
    }

    public final String a()
    {
        return this.a;
    }

    public final boolean c()
    {
        return 0;
    }

    public final int d(String p2)
    {
        p2.getClass();
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public final jc.g e()
    {
        return this.b;
    }

    public final boolean equals(Object p3)
    {
        if ((this != p3) && ((!(p3 instanceof ub.s0)) || ((!this.a.equals(((ub.s0) p3).a)) || (!kotlin.jvm.internal.f.a(this.b, ((ub.s0) p3).b))))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final int f()
    {
        return 0;
    }

    public final String g(int p2)
    {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public final java.util.List getAnnotations()
    {
        return kotlin.collections.EmptyList.g;
    }

    public final java.util.List h(int p2)
    {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public final int hashCode()
    {
        return ((this.b.hashCode() * 31) + this.a.hashCode());
    }

    public final sb.d i(int p2)
    {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public final boolean isInline()
    {
        return 0;
    }

    public final boolean j(int p2)
    {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public final String toString()
    {
        return r1.a.r(new StringBuilder("PrimitiveDescriptor("), this.a, 41);
    }
}
