// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ac;
public final class a implements oc.d0 {
    public boolean g;
    public final synthetic oc.k h;
    public final synthetic d9.e i;
    public final synthetic oc.x j;

    public a(oc.k p1, d9.e p2, oc.x p3)
    {
        this.h = p1;
        this.i = p2;
        this.j = p3;
        return;
    }

    public final long N(long p10, oc.i p12)
    {
        p12.getClass();
        try {
            long v6 = this.h.N(p10, p12);
            oc.x v8 = this.j;
        } catch (java.io.IOException v0_2) {
            long v10_1 = v0_2;
            if (!this.g) {
                this.g = 1;
                this.i.b();
            }
            throw v10_1;
        }
        if (v6 != -1) {
            p12.i(v8.h, (p12.h - v6), v6);
            v8.d();
            return v6;
        } else {
            if (!this.g) {
                this.g = 1;
                v8.close();
            }
            return -1;
        }
    }

    public final oc.f0 a()
    {
        return this.h.a();
    }

    public final void close()
    {
        if (!this.g) {
            java.util.concurrent.TimeUnit.MILLISECONDS.getClass();
            try {
                d9.e v0_6 = zb.e.f(this, 100);
            } catch (java.io.IOException) {
                v0_6 = 0;
            }
            if (v0_6 == null) {
                this.g = 1;
                this.i.b();
            }
        }
        this.h.close();
        return;
    }
}
