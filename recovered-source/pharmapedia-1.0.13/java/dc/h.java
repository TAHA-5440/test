// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package dc;
public final class h extends yb.d0 {
    public final String h;
    public final long i;
    public final oc.y j;

    public h(String p1, long p2, oc.y p4)
    {
        this.h = p1;
        this.i = p2;
        this.j = p4;
        return;
    }

    public final long d()
    {
        return this.i;
    }

    public final yb.w h()
    {
        yb.w v0 = 0;
        String v1 = this.h;
        try {
            if (v1 != null) {
                v0 = com.bumptech.glide.h.j(v1);
            }
        } catch (IllegalArgumentException) {
        }
        return v0;
    }

    public final oc.k i()
    {
        return this.j;
    }
}
