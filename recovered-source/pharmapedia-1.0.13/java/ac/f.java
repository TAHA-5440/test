// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ac;
public final class f extends oc.q {
    public boolean h;
    public final synthetic ac.k i;
    public final synthetic ac.g j;

    public f(oc.d0 p1, ac.k p2, ac.g p3)
    {
        this.i = p2;
        this.j = p3;
        super(p1);
        return;
    }

    public final void close()
    {
        super.close();
        if (this.h) {
            return;
        } else {
            this.h = 1;
            ac.k v0_2 = this.i;
            Throwable v1_1 = this.j;
            try {
                boolean v2_2 = (v1_1.h - 1);
                v1_1.h = v2_2;
            } catch (Throwable v1_0) {
                throw v1_0;
            }
            if ((!v2_2) && (v1_1.f)) {
                v0_2.g0(v1_1);
            }
            return;
        }
    }
}
