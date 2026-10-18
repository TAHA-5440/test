// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin;
public abstract class b {

    public static final kotlin.Result$Failure a(Throwable p1)
    {
        p1.getClass();
        return new kotlin.Result$Failure(p1);
    }

    public static final void b(Object p1)
    {
        if ((p1 instanceof kotlin.Result$Failure)) {
            throw ((kotlin.Result$Failure) p1).g;
        } else {
            return;
        }
    }
}
