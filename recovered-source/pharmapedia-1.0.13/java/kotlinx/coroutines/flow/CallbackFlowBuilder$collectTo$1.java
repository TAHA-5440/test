// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow;
final class CallbackFlowBuilder$collectTo$1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    public ib.l g;
    public synthetic Object h;
    public final synthetic kotlinx.coroutines.flow.b i;
    public int j;

    public CallbackFlowBuilder$collectTo$1(kotlinx.coroutines.flow.b p1, kotlin.coroutines.jvm.internal.ContinuationImpl p2)
    {
        this.i = p1;
        super(p2);
        return;
    }

    public final Object invokeSuspend(Object p2)
    {
        this.h = p2;
        this.j = (this.j | -2147483648);
        return this.i.a(0, this);
    }
}
