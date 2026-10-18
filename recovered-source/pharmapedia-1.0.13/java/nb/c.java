// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package nb;
public final class c extends gb.p0 implements java.util.concurrent.Executor {
    public static final nb.c i;
    public static final gb.s j;

    static c()
    {
        nb.c.i = new nb.c();
        int v1_1 = lb.r.a;
        if (64 >= v1_1) {
            v1_1 = 64;
        }
        nb.c.j = nb.j.i.g0(lb.a.j(v1_1, 12, "kotlinx.coroutines.io.parallelism"), 0);
        return;
    }

    public final void close()
    {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    public final void d0(ka.g p2, Runnable p3)
    {
        nb.c.j.d0(p2, p3);
        return;
    }

    public final void e0(ka.g p2, Runnable p3)
    {
        nb.c.j.e0(p2, p3);
        return;
    }

    public final void execute(Runnable p2)
    {
        this.d0(kotlin.coroutines.EmptyCoroutineContext.g, p2);
        return;
    }

    public final gb.s g0(int p2, String p3)
    {
        return nb.j.i.g0(1, 0);
    }

    public final java.util.concurrent.Executor h0()
    {
        return this;
    }

    public final String toString()
    {
        return "Dispatchers.IO";
    }
}
