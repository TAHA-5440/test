// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class y0 extends gb.w0 {
    public final gb.a1 k;
    public final gb.z0 l;
    public final gb.l m;
    public final Object n;

    public y0(gb.a1 p1, gb.z0 p2, gb.l p3, Object p4)
    {
        this.k = p1;
        this.l = p2;
        this.m = p3;
        this.n = p4;
        return;
    }

    public final boolean k()
    {
        return 0;
    }

    public final void l(Throwable p7)
    {
        Object v7_0 = this.m;
        gb.c1 v0_1 = gb.a1.N(v7_0);
        gb.a1 v1 = this.k;
        gb.z0 v2 = this.l;
        Object v3 = this.n;
        if ((v0_1 == null) || (!v1.W(v2, v0_1, v3))) {
            v2.g.c(new lb.g(2), 2);
            Object v7_1 = gb.a1.N(v7_0);
            if ((v7_1 == null) || (!v1.W(v2, v7_1, v3))) {
                v1.k(v1.t(v2, v3));
                return;
            }
        }
        return;
    }
}
