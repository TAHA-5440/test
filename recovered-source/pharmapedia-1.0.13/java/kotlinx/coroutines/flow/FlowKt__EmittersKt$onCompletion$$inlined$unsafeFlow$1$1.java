// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow;
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    public synthetic Object g;
    public int h;
    public final synthetic jb.d i;
    public Object j;
    public jb.c k;

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1(jb.d p1, ka.c p2)
    {
        this.i = p1;
        super(p2);
        return;
    }

    public final Object invokeSuspend(Object p2)
    {
        this.g = p2;
        this.h = (this.h | -2147483648);
        return this.i.collect(0, this);
    }
}
