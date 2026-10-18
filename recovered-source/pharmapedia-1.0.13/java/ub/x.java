// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class x extends ub.o0 {
    public final boolean l;

    public x(String p2, ub.y p3)
    {
        super(p2, p3, 1);
        super.l = 1;
        return;
    }

    public final boolean equals(Object p6)
    {
        if (this != p6) {
            if (((p6 instanceof ub.x)) && ((this.a.equals(((sb.d) p6).a())) && ((((ub.x) p6).l) && (java.util.Arrays.equals(((sb.d[]) this.j.getValue()), ((sb.d[]) ((ub.x) p6).j.getValue())))))) {
                int v2_5 = this.c;
                if (v2_5 == ((sb.d) p6).f()) {
                    int v6_7 = 0;
                    while (v6_7 < v2_5) {
                        if ((kotlin.jvm.internal.f.a(this.i(v6_7).a(), ((sb.d) p6).i(v6_7).a())) && (kotlin.jvm.internal.f.a(this.i(v6_7).e(), ((sb.d) p6).i(v6_7).e()))) {
                            v6_7++;
                        }
                    }
                    return 1;
                }
            }
            return 0;
        }
        return 1;
    }

    public final int hashCode()
    {
        return (super.hashCode() * 31);
    }

    public final boolean isInline()
    {
        return this.l;
    }
}
