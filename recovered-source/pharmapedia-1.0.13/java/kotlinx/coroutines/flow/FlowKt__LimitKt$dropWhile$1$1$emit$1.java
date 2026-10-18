// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow;
final class FlowKt__LimitKt$dropWhile$1$1$emit$1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    public kotlinx.coroutines.flow.d g;
    public Object h;
    public synthetic Object i;
    public final synthetic kotlinx.coroutines.flow.d j;
    public int k;

    public FlowKt__LimitKt$dropWhile$1$1$emit$1(kotlinx.coroutines.flow.d p1, ka.c p2)
    {
        this.j = p1;
        super(p2);
        return;
    }

    public final Object invokeSuspend(Object p2)
    {
        this.i = p2;
        this.k = (this.k | -2147483648);
        return this.j.emit(0, this);
    }
}
