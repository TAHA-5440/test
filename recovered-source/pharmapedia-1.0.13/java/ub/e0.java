// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public abstract class e0 implements sb.d {
    public final sb.d a;

    public e0(sb.d p1)
    {
        this.a = p1;
        return;
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
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u(p2.concat(" is not a valid list index"));
            return 0;
        } else {
            return v0_0.intValue();
        }
    }

    public final jc.g e()
    {
        return sb.h.f;
    }

    public final boolean equals(Object p3)
    {
        if ((this != p3) && ((!(p3 instanceof ub.e0)) || ((!kotlin.jvm.internal.f.a(this.a, ((ub.e0) p3).a)) || (!kotlin.jvm.internal.f.a(this.a(), ((ub.e0) p3).a()))))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final int f()
    {
        return 1;
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
        if (p3 < null) {
            String v3_4 = r1.a.v(p3, "Illegal index ", ", ");
            v3_4.append(this.a());
            v3_4.append(" expects only non-negative indices");
            throw new IllegalArgumentException(v3_4.toString().toString());
        } else {
            return kotlin.collections.EmptyList.g;
        }
    }

    public final int hashCode()
    {
        return (this.a().hashCode() + (this.a.hashCode() * 31));
    }

    public final sb.d i(int p3)
    {
        if (p3 < null) {
            String v3_4 = r1.a.v(p3, "Illegal index ", ", ");
            v3_4.append(this.a());
            v3_4.append(" expects only non-negative indices");
            throw new IllegalArgumentException(v3_4.toString().toString());
        } else {
            return this.a;
        }
    }

    public final boolean isInline()
    {
        return 0;
    }

    public final boolean j(int p3)
    {
        if (p3 < null) {
            String v3_4 = r1.a.v(p3, "Illegal index ", ", ");
            v3_4.append(this.a());
            v3_4.append(" expects only non-negative indices");
            throw new IllegalArgumentException(v3_4.toString().toString());
        } else {
            return 0;
        }
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder();
        v0_1.append(this.a());
        v0_1.append(40);
        v0_1.append(this.a);
        v0_1.append(41);
        return v0_1.toString();
    }
}
