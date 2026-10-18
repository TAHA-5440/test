// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class u extends ka.a {
    public static final gb.t i;
    public final String h;

    static u()
    {
        gb.u.i = new gb.t();
        return;
    }

    public u()
    {
        super(gb.u.i);
        super.h = "Room Invalidation Tracker Refresh";
        return;
    }

    public final boolean equals(Object p4)
    {
        if (this != p4) {
            if ((p4 instanceof gb.u)) {
                if (kotlin.jvm.internal.f.a(this.h, ((gb.u) p4).h)) {
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

    public final int hashCode()
    {
        return this.h.hashCode();
    }

    public final String toString()
    {
        return r1.a.r(new StringBuilder("CoroutineName("), this.h, 41);
    }
}
