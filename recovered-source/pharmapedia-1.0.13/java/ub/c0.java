// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class c0 implements sb.d {
    public final sb.d a;
    public final sb.d b;

    public c0(sb.d p1, sb.d p2)
    {
        p1.getClass();
        p2.getClass();
        this.a = p1;
        this.b = p2;
        return;
    }

    public final String a()
    {
        return "kotlin.collections.LinkedHashMap";
    }

    public final boolean c()
    {
        return 0;
    }

    public final int d(String p2)
    {
        p2.getClass();
        String v0_0 = db.p.R(p2);
        if (v0_0 == null) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u(p2.concat(" is not a valid map index"));
            return 0;
        } else {
            return v0_0.intValue();
        }
    }

    public final jc.g e()
    {
        return sb.h.g;
    }

    public final boolean equals(Object p3)
    {
        if ((this == p3) || (((p3 instanceof ub.c0)) && ((kotlin.jvm.internal.f.a(this.a, ((ub.c0) p3).a)) && (kotlin.jvm.internal.f.a(this.b, ((ub.c0) p3).b))))) {
            return 1;
        } else {
            return 0;
        }
    }

    public final int f()
    {
        return 2;
    }

    public final String g(int p1)
    {
        return String.valueOf(p1);
    }

    public final java.util.List getAnnotations()
    {
        return kotlin.collections.EmptyList.g;
    }

    public final java.util.List h(int p3)
    {
        if (p3 < 0) {
            oc.l.d(r1.a.h(p3, "Illegal index ", ", kotlin.collections.LinkedHashMap expects only non-negative indices"));
            return 0;
        } else {
            return kotlin.collections.EmptyList.g;
        }
    }

    public final int hashCode()
    {
        return (this.b.hashCode() + ((this.a.hashCode() + 710441009) * 31));
    }

    public final sb.d i(int p3)
    {
        if (p3 < null) {
            oc.l.d(r1.a.h(p3, "Illegal index ", ", kotlin.collections.LinkedHashMap expects only non-negative indices"));
        } else {
            String v3_5 = (p3 % 2);
            if (v3_5 == null) {
                return this.a;
            } else {
                if (v3_5 != 1) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Unreached");
                } else {
                    return this.b;
                }
            }
        }
        return 0;
    }

    public final boolean isInline()
    {
        return 0;
    }

    public final boolean j(int p3)
    {
        if (p3 < 0) {
            oc.l.d(r1.a.h(p3, "Illegal index ", ", kotlin.collections.LinkedHashMap expects only non-negative indices"));
            return 0;
        } else {
            return 0;
        }
    }

    public final String toString()
    {
        String v0_2 = new StringBuilder("kotlin.collections.LinkedHashMap(");
        v0_2.append(this.a);
        v0_2.append(", ");
        v0_2.append(this.b);
        v0_2.append(41);
        return v0_2.toString();
    }
}
