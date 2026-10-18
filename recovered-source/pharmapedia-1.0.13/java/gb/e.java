// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class e implements gb.e1 {
    public final synthetic int a;
    public final Object b;

    public synthetic e(Object p1, int p2)
    {
        this.a = p2;
        this.b = p1;
        return;
    }

    public final String toString()
    {
        switch (this.a) {
            case 0:
                String v0_4 = new StringBuilder("CancelFutureOnCancel[");
                v0_4.append(((java.util.concurrent.ScheduledFuture) this.b));
                v0_4.append(93);
                return v0_4.toString();
            case 1:
                String v0_8 = new StringBuilder("CancelHandler.UserSupplied[");
                v0_8.append(((ua.l) this.b).getClass().getSimpleName());
                v0_8.append(64);
                v0_8.append(gb.w.l(this));
                v0_8.append(93);
                return v0_8.toString();
            default:
                String v0_7 = new StringBuilder("DisposeOnCancel[");
                v0_7.append(((gb.g0) this.b));
                v0_7.append(93);
                return v0_7.toString();
        }
    }
}
