// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package nb;
public final class j extends gb.s {
    public static final nb.j i;

    static j()
    {
        nb.j.i = new nb.j();
        return;
    }

    public final void d0(ka.g p3, Runnable p4)
    {
        nb.d.j.i.h(p4, 1, 0);
        return;
    }

    public final void e0(ka.g p2, Runnable p3)
    {
        nb.d.j.i.h(p3, 1, 1);
        return;
    }

    public final gb.s g0(int p2, String p3)
    {
        lb.a.a(p2);
        if (p2 < nb.i.d) {
            return super.g0(p2, p3);
        } else {
            if (p3 == null) {
                return this;
            } else {
                return new lb.l(this, p3);
            }
        }
    }

    public final String toString()
    {
        return "Dispatchers.IO";
    }
}
