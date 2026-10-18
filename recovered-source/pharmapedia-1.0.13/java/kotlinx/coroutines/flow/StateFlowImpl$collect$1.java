// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow;
final class StateFlowImpl$collect$1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    public kotlinx.coroutines.flow.f g;
    public jb.c h;
    public jb.p i;
    public gb.u0 j;
    public Object k;
    public synthetic Object l;
    public final synthetic kotlinx.coroutines.flow.f m;
    public int n;

    public StateFlowImpl$collect$1(kotlinx.coroutines.flow.f p1, ka.c p2)
    {
        this.m = p1;
        super(p2);
        return;
    }

    public final Object invokeSuspend(Object p2)
    {
        this.l = p2;
        this.n = (this.n | -2147483648);
        this.m.collect(0, this);
        return kotlin.coroutines.intrinsics.CoroutineSingletons.g;
    }
}
