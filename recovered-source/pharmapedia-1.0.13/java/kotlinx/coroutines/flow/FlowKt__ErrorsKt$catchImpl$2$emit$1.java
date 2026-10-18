// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow;
final class FlowKt__ErrorsKt$catchImpl$2$emit$1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    public kotlinx.coroutines.flow.c g;
    public synthetic Object h;
    public final synthetic kotlinx.coroutines.flow.c i;
    public int j;

    public FlowKt__ErrorsKt$catchImpl$2$emit$1(kotlinx.coroutines.flow.c p1, ka.c p2)
    {
        this.i = p1;
        super(p2);
        return;
    }

    public final Object invokeSuspend(Object p2)
    {
        this.h = p2;
        this.j = (this.j | -2147483648);
        return this.i.emit(0, this);
    }
}
