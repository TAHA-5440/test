// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lb;
public abstract class q {
    public static final synthetic int a;

    static q()
    {
        String v0_10 = new Exception().getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(a.a.getSimpleName()), "_", v0_10.getFileName(), v0_10.getLineNumber());
        try {
            String v0_4 = kotlin.coroutines.jvm.internal.BaseContinuationImpl.getCanonicalName();
        } catch (String v0_5) {
            v0_4 = new kotlin.Result$Failure(v0_5);
        }
        // Both branches of the condition point to the same code.
        // if (kotlin.Result.a(v0_4) != null) {
            try {
                String v0_7 = lb.q.getCanonicalName();
            } catch (String v0_8) {
                v0_7 = new kotlin.Result$Failure(v0_8);
            }
            // Both branches of the condition point to the same code.
            // if (kotlin.Result.a(v0_7) != null) {
                return;
            // }
        // }
    }
}
