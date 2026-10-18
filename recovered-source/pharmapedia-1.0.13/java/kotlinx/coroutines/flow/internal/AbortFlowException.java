// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow.internal;
public final class AbortFlowException extends java.util.concurrent.CancellationException {
    public final transient Object g;

    public AbortFlowException(jb.c p2)
    {
        super("Flow was aborted, no more elements needed");
        super.g = p2;
        return;
    }

    public final Throwable fillInStackTrace()
    {
        StackTraceElement[] v0_1 = new StackTraceElement[0];
        this.setStackTrace(v0_1);
        return this;
    }
}
