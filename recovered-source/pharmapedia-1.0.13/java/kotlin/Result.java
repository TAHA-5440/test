// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin;
public abstract class Result implements java.io.Serializable {

    public static final Throwable a(Object p1)
    {
        if (!(p1 instanceof kotlin.Result$Failure)) {
            return 0;
        } else {
            return ((kotlin.Result$Failure) p1).g;
        }
    }
}
