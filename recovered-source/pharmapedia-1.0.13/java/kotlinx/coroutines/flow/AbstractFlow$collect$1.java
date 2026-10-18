// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow;
final class AbstractFlow$collect$1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    public kotlinx.coroutines.flow.internal.SafeCollector g;
    public synthetic Object h;
    public final synthetic kotlinx.coroutines.flow.a i;
    public int j;

    public AbstractFlow$collect$1(kotlinx.coroutines.flow.a p1, ka.c p2)
    {
        this.i = p1;
        super(p2);
        return;
    }

    public final Object invokeSuspend(Object p2)
    {
        this.h = p2;
        this.j = (this.j | -2147483648);
        return this.i.collect(0, this);
    }
}
