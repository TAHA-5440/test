// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.coroutines.jvm.internal;
public abstract class RestrictedSuspendLambda extends kotlin.coroutines.jvm.internal.RestrictedContinuationImpl implements kotlin.jvm.internal.e {
    public final int g;

    public RestrictedSuspendLambda(ka.c p1)
    {
        super(p1);
        super.g = 3;
        return;
    }

    public final int getArity()
    {
        return this.g;
    }

    public final String toString()
    {
        if (this.getCompletion() != null) {
            return super.toString();
        } else {
            kotlin.jvm.internal.h.a.getClass();
            return kotlin.jvm.internal.i.a(this);
        }
    }
}
