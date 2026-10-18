// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class g implements java.io.Closeable, java.io.Flushable {
    public final ac.k g;

    public g(java.io.File p7, long p8)
    {
        oc.u v1 = oc.o.g;
        oc.w v2 = ea.c.v(p7);
        v1.getClass();
        bc.d v5 = bc.d.l;
        v5.getClass();
        this.g = new ac.k(v1, v2, p8, v5);
        return;
    }

    public final void close()
    {
        this.g.close();
        return;
    }

    public final void d(lc.a p6)
    {
        p6.getClass();
        ac.k v0 = this.g;
        int v6_8 = com.bumptech.glide.d.v(((yb.u) p6.b));
        v6_8.getClass();
        v0.L();
        v0.d();
        ac.k.i0(v6_8);
        int v6_2 = ((ac.g) v0.o.get(v6_8));
        if (v6_2 != 0) {
            v0.g0(v6_2);
            if (v0.m <= v0.i) {
                v0.u = 0;
            }
            return;
        } else {
            return;
        }
    }

    public final void flush()
    {
        this.g.flush();
        return;
    }
}
