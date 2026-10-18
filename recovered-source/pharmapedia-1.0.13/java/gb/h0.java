// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class h0 extends gb.w0 {
    public final synthetic int k;
    public final Object l;

    public synthetic h0(Object p1, int p2)
    {
        this.k = p2;
        this.l = p1;
        return;
    }

    public final boolean k()
    {
        switch (this.k) {
            case 0:
                return 0;
            case 1:
                return 0;
            default:
                return 0;
        }
    }

    public final void l(Throwable p3)
    {
        switch (this.k) {
            case 0:
                ((gb.g0) this.l).b();
                return;
            case 1:
                ((ua.l) this.l).invoke(p3);
                return;
            default:
                Object v3_2 = gb.a1.g.get(this.j());
                gb.x0 v1_1 = ((gb.x0) this.l);
                if (!(v3_2 instanceof gb.q)) {
                    v1_1.resumeWith(gb.w.x(v3_2));
                } else {
                    v1_1.resumeWith(kotlin.b.a(((gb.q) v3_2).a));
                }
                return;
        }
    }
}
