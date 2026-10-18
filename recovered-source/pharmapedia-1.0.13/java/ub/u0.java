// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class u0 implements sb.d, ub.j {
    public final sb.d a;
    public final String b;
    public final java.util.Set c;

    public u0(sb.d p3)
    {
        p3.getClass();
        this.a = p3;
        String v0_2 = new StringBuilder();
        v0_2.append(p3.a());
        v0_2.append(63);
        this.b = v0_2.toString();
        this.c = ub.m0.b(p3);
        return;
    }

    public final String a()
    {
        return this.b;
    }

    public final java.util.Set b()
    {
        return this.c;
    }

    public final boolean c()
    {
        return 1;
    }

    public final int d(String p2)
    {
        p2.getClass();
        return this.a.d(p2);
    }

    public final jc.g e()
    {
        return this.a.e();
    }

    public final boolean equals(Object p4)
    {
        if (this != p4) {
            if ((p4 instanceof ub.u0)) {
                if (kotlin.jvm.internal.f.a(this.a, ((ub.u0) p4).a)) {
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

    public final int f()
    {
        return this.a.f();
    }

    public final String g(int p2)
    {
        return this.a.g(p2);
    }

    public final java.util.List getAnnotations()
    {
        return this.a.getAnnotations();
    }

    public final java.util.List h(int p2)
    {
        return this.a.h(p2);
    }

    public final int hashCode()
    {
        return (this.a.hashCode() * 31);
    }

    public final sb.d i(int p2)
    {
        return this.a.i(p2);
    }

    public final boolean isInline()
    {
        return this.a.isInline();
    }

    public final boolean j(int p2)
    {
        return this.a.j(p2);
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder();
        v0_1.append(this.a);
        v0_1.append(63);
        return v0_1.toString();
    }
}
