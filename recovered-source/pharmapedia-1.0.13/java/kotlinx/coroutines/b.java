// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines;
public final class b extends gb.w0 {
    public static final synthetic java.util.concurrent.atomic.AtomicIntegerFieldUpdater l;
    private volatile synthetic int _invoked$volatile;
    public final ua.l k;

    static b()
    {
        kotlinx.coroutines.b.l = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.b, "_invoked$volatile");
        return;
    }

    public b(ua.l p1)
    {
        this.k = p1;
        this._invoked$volatile = 0;
        return;
    }

    public final boolean k()
    {
        return 1;
    }

    public final void l(Throwable p4)
    {
        if (kotlinx.coroutines.b.l.compareAndSet(this, 0, 1)) {
            ((kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1) this.k).invoke(p4);
        }
        return;
    }
}
