// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class d0 implements java.util.concurrent.Executor {
    public final gb.s g;

    public d0(gb.s p1)
    {
        this.g = p1;
        return;
    }

    public final void execute(Runnable p4)
    {
        gb.s v0 = this.g;
        kotlin.coroutines.EmptyCoroutineContext v1 = kotlin.coroutines.EmptyCoroutineContext.g;
        if (!v0.f0(v1)) {
            p4.run();
            return;
        } else {
            v0.d0(v1, p4);
            return;
        }
    }

    public final String toString()
    {
        return this.g.toString();
    }
}
