// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow;
public final class FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    public synthetic Object g;
    public int h;
    public final synthetic a0.i i;
    public a0.i j;
    public jb.c k;
    public kotlinx.coroutines.flow.internal.SafeCollector l;

    public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1(a0.i p1, ka.c p2)
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
