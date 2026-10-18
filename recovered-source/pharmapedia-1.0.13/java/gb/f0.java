// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class f0 implements gb.g0 {
    public final java.util.concurrent.ScheduledFuture g;

    public f0(java.util.concurrent.ScheduledFuture p1)
    {
        this.g = p1;
        return;
    }

    public final void b()
    {
        this.g.cancel(0);
        return;
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder("DisposableFutureHandle[");
        v0_1.append(this.g);
        v0_1.append(93);
        return v0_1.toString();
    }
}
