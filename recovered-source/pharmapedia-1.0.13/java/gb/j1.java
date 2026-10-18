// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class j1 extends lb.o implements java.lang.Runnable {
    public final long k;

    public j1(long p2, kotlin.coroutines.jvm.internal.ContinuationImpl p4)
    {
        super(p4, p4.getContext());
        super.k = p2;
        return;
    }

    public final String K()
    {
        String v0_1 = new StringBuilder();
        v0_1.append(super.K());
        v0_1.append("(timeMillis=");
        v0_1.append(this.k);
        v0_1.append(41);
        return v0_1.toString();
    }

    public final void run()
    {
        gb.w.k(this.i);
        String v0_3 = new StringBuilder("Timed out waiting for ");
        v0_3.append(this.k);
        v0_3.append(" ms");
        this.m(new kotlinx.coroutines.TimeoutCancellationException(v0_3.toString(), this));
        return;
    }
}
