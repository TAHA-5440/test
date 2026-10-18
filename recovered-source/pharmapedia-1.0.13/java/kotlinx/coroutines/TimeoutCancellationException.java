// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines;
public final class TimeoutCancellationException extends java.util.concurrent.CancellationException {
    public final transient gb.u0 g;

    public TimeoutCancellationException(String p1, gb.j1 p2)
    {
        super(p1);
        super.g = p2;
        return;
    }
}
