// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jb;
public final class l implements gb.g0 {
    public final kotlinx.coroutines.flow.e g;
    public final long h;
    public final Object i;
    public final gb.h j;

    public l(kotlinx.coroutines.flow.e p1, long p2, Object p4, gb.h p5)
    {
        this.g = p1;
        this.h = p2;
        this.i = p4;
        this.j = p5;
        return;
    }

    public final void b()
    {
        kotlinx.coroutines.flow.e v0 = this.g;
        try {
            if (this.h >= v0.j()) {
                Object[] v1_3 = v0.k;
                v1_3.getClass();
                long v2 = this.h;
                if (v1_3[(((int) v2) & (v1_3.length - 1))] == this) {
                    jb.m.a(v1_3, v2, jb.m.a);
                    v0.f();
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        } catch (Object[] v1_1) {
            throw v1_1;
        }
    }
}
