// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ac;
public final class h implements java.io.Closeable {
    public final String g;
    public final long h;
    public final java.util.ArrayList i;
    public final synthetic ac.k j;

    public h(ac.k p1, String p2, long p3, java.util.ArrayList p5, long[] p6)
    {
        p2.getClass();
        p6.getClass();
        this.j = p1;
        this.g = p2;
        this.h = p3;
        this.i = p5;
        return;
    }

    public final void close()
    {
        java.util.ArrayList v0 = this.i;
        int v1 = v0.size();
        int v2 = 0;
        while (v2 < v1) {
            oc.d0 v3_0 = v0.get(v2);
            v2++;
            zb.c.a(((oc.d0) v3_0));
        }
        return;
    }
}
