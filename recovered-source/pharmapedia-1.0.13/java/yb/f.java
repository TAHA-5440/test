// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class f extends oc.p {
    public final synthetic yb.g h;
    public final synthetic d9.e i;

    public f(yb.g p1, d9.e p2, oc.b0 p3)
    {
        this.h = p1;
        this.i = p2;
        super(p3);
        return;
    }

    public final void close()
    {
        Throwable v1_0 = this.i;
        try {
            if (!v1_0.a) {
                v1_0.a = 1;
                super.close();
                ((ac.e) this.i.b).f();
                return;
            } else {
                return;
            }
        } catch (Throwable v1_1) {
            throw v1_1;
        }
    }
}
