// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package nb;
public final class d extends gb.p0 {
    public static final nb.d j;
    public nb.b i;

    static d()
    {
        nb.d v0_1 = new nb.d();
        v0_1.i = new nb.b(nb.i.c, nb.i.d, nb.i.e, nb.i.a);
        nb.d.j = v0_1;
        return;
    }

    public final void close()
    {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    public final void d0(ka.g p2, Runnable p3)
    {
        nb.b.i(this.i, p3, 6);
        return;
    }

    public final void e0(ka.g p2, Runnable p3)
    {
        nb.b.i(this.i, p3, 2);
        return;
    }

    public final gb.s g0(int p1, String p2)
    {
        lb.a.a(1);
        if (1 < nb.i.c) {
            return super.g0(1, 0);
        } else {
            return this;
        }
    }

    public final java.util.concurrent.Executor h0()
    {
        return this.i;
    }

    public final String toString()
    {
        return "Dispatchers.Default";
    }
}
