// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class d extends yb.d0 {
    public final ac.h h;
    public final String i;
    public final String j;
    public final oc.y k;

    public d(ac.h p1, String p2, String p3)
    {
        this.h = p1;
        this.i = p2;
        this.j = p3;
        this.k = new oc.y(new yb.c(((oc.d0) p1.i.get(1)), this));
        return;
    }

    public final long d()
    {
        long v0 = -1;
        String v2 = this.j;
        try {
            if (v2 != null) {
                v0 = Long.parseLong(v2);
            }
        } catch (NumberFormatException) {
        }
        return v0;
    }

    public final yb.w h()
    {
        yb.w v0 = 0;
        String v1 = this.i;
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
        return this.k;
    }
}
