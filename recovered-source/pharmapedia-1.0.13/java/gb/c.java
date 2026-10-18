// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class c extends gb.a {
    public final Thread j;
    public final gb.j0 k;

    public c(ka.g p2, Thread p3, gb.j0 p4)
    {
        super(p2, 1);
        super.j = p3;
        super.k = p4;
        return;
    }

    public final void k(Object p2)
    {
        Thread v0 = this.j;
        if (!kotlin.jvm.internal.f.a(Thread.currentThread(), v0)) {
            java.util.concurrent.locks.LockSupport.unpark(v0);
        }
        return;
    }
}
