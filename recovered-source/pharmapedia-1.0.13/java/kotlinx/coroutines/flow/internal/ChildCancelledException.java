// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow.internal;
public final class ChildCancelledException extends java.util.concurrent.CancellationException {

    public final Throwable fillInStackTrace()
    {
        StackTraceElement[] v0_1 = new StackTraceElement[0];
        this.setStackTrace(v0_1);
        return this;
    }
}
