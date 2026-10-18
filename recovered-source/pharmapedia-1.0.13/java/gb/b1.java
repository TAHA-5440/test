// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class b1 extends gb.z {
    public final ka.c k;

    public b1(ka.g p3, ua.p p4)
    {
        super(p3, 0, 1);
        super.k = ((kotlin.coroutines.jvm.internal.BaseContinuationImpl) p4).create(super, super);
        return;
    }

    public final void Q()
    {
        try {
            lb.a.h(ga.p.a, a.a.n(this.k));
            return;
        } catch (Throwable v0_2) {
            this.resumeWith(new kotlin.Result$Failure(v0_2));
            throw v0_2;
        }
    }
}
