// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow;
final class SharedFlowImpl$collect$1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    public kotlinx.coroutines.flow.e g;
    public jb.c h;
    public jb.n i;
    public gb.u0 j;
    public synthetic Object k;
    public final synthetic kotlinx.coroutines.flow.e l;
    public int m;

    public SharedFlowImpl$collect$1(kotlinx.coroutines.flow.e p1, ka.c p2)
    {
        this.l = p1;
        super(p2);
        return;
    }

    public final Object invokeSuspend(Object p2)
    {
        this.k = p2;
        this.m = (this.m | -2147483648);
        kotlinx.coroutines.flow.e.g(this.l, 0, this);
        return kotlin.coroutines.intrinsics.CoroutineSingletons.g;
    }
}
