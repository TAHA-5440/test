// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.internal;
public final class DiagnosticCoroutineContextException extends java.lang.RuntimeException {
    public final transient ka.g g;

    public DiagnosticCoroutineContextException(ka.g p1)
    {
        this.g = p1;
        return;
    }

    public final Throwable fillInStackTrace()
    {
        StackTraceElement[] v0_1 = new StackTraceElement[0];
        this.setStackTrace(v0_1);
        return this;
    }

    public final String getLocalizedMessage()
    {
        return this.g.toString();
    }
}
