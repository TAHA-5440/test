// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class k {
    public static final yb.k c;
    public final java.util.Set a;
    public final com.bumptech.glide.j b;

    static k()
    {
        yb.k.c = new yb.k(ha.j.Y(new java.util.ArrayList()), 0);
        return;
    }

    public k(java.util.Set p1, com.bumptech.glide.j p2)
    {
        this.a = p1;
        this.b = p2;
        return;
    }

    public final boolean equals(Object p3)
    {
        if ((!(p3 instanceof yb.k)) || ((!((yb.k) p3).a.equals(this.a)) || (!kotlin.jvm.internal.f.a(((yb.k) p3).b, this.b)))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        int v1_1;
        int v0_4 = ((this.a.hashCode() + 1517) * 41);
        int v1_0 = this.b;
        if (v1_0 == 0) {
            v1_1 = 0;
        } else {
            v1_1 = v1_0.hashCode();
        }
        return (v0_4 + v1_1);
    }
}
