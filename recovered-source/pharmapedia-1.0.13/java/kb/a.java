// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kb;
public abstract class a {
    public kb.c[] g;
    public int h;
    public int i;

    public final kb.c a()
    {
        int v0_0 = this.g;
        if (v0_0 != 0) {
            if (this.h >= v0_0.length) {
                int v0_4 = java.util.Arrays.copyOf(v0_0, (v0_0.length * 2));
                this.g = ((kb.c[]) v0_4);
                v0_0 = ((kb.c[]) v0_4);
            }
        } else {
            v0_0 = this.c();
            this.g = v0_0;
        }
        int v1_1 = this.i;
        do {
            kb.c v2_0 = v0_0[v1_1];
            if (v2_0 == null) {
                v2_0 = this.b();
                v0_0[v1_1] = v2_0;
            }
            v1_1++;
            if (v1_1 >= v0_0.length) {
                v1_1 = 0;
            }
        } while(!v2_0.a(this));
        this.i = v1_1;
        this.h = (this.h + 1);
        return v2_0;
    }

    public abstract kb.c b();

    public abstract kb.c[] c();

    public final void d(kb.c p5)
    {
        int v0_1 = (this.h - 1);
        this.h = v0_1;
        int v1 = 0;
        if (v0_1 == 0) {
            this.i = 0;
        }
        p5.getClass();
        ka.c[] v5_1 = p5.b(this);
        int v0_2 = v5_1.length;
        while (v1 < v0_2) {
            ka.c v2 = v5_1[v1];
            if (v2 != null) {
                v2.resumeWith(ga.p.a);
            }
            v1++;
        }
        return;
    }
}
