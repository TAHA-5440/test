// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.coroutines.jvm.internal;
public abstract class SuspendLambda extends kotlin.coroutines.jvm.internal.ContinuationImpl implements kotlin.jvm.internal.e {
    private final int arity;

    public SuspendLambda(int p1, ka.c p2)
    {
        super(p2);
        super.arity = p1;
        return;
    }

    public int getArity()
    {
        return this.arity;
    }

    public String toString()
    {
        if (this.getCompletion() != null) {
            return super.toString();
        } else {
            kotlin.jvm.internal.h.a.getClass();
            return kotlin.jvm.internal.i.a(this);
        }
    }
}
