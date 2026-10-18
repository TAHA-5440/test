// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package hb;
public final synthetic class c implements gb.g0 {
    public final synthetic int g;
    public final synthetic Object h;
    public final synthetic Object i;

    public synthetic c(int p1, Object p2, Object p3)
    {
        this.g = p1;
        this.h = p2;
        this.i = p3;
        return;
    }

    public final void b()
    {
        switch (this.g) {
            case 0:
                ((hb.d) this.h).i.removeCallbacks(((gb.j1) this.i));
                return;
            default:
                Throwable v0_1 = ((String) this.h);
                try {
                    java.util.LinkedHashMap v3 = y0.i.c;
                    y0.i v4_1 = ((y0.i) v3.get(v0_1));
                } catch (Throwable v0_3) {
                    throw v0_3;
                }
                if (v4_1 != null) {
                    v4_1.a.remove(((ua.l) this.i));
                    if (v4_1.a.isEmpty()) {
                        v3.remove(v0_1);
                        v4_1.stopWatching();
                    }
                }
                return;
        }
    }
}
