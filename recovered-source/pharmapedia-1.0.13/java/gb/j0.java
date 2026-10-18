// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public abstract class j0 extends gb.s {
    public static final synthetic int l;
    public long i;
    public boolean j;
    public ha.h k;

    public final gb.s g0(int p1, String p2)
    {
        lb.a.a(1);
        return this;
    }

    public final void h0(boolean p5)
    {
        long v2_0;
        if (!p5) {
            v2_0 = 1;
        } else {
            v2_0 = 4294967296;
        }
        long v0_1 = (this.i - v2_0);
        this.i = v0_1;
        if ((v0_1 <= 0) && (this.j)) {
            this.shutdown();
        }
        return;
    }

    public final void i0(gb.c0 p2)
    {
        ha.h v0_0 = this.k;
        if (v0_0 == null) {
            v0_0 = new ha.h();
            this.k = v0_0;
        }
        v0_0.addLast(p2);
        return;
    }

    public final void j0(boolean p5)
    {
        long v2_0;
        if (p5 == 0) {
            v2_0 = 1;
        } else {
            v2_0 = 4294967296;
        }
        this.i = (v2_0 + this.i);
        if (p5 == 0) {
            this.j = 1;
        }
        return;
    }

    public abstract long k0();

    public final boolean l0()
    {
        int v0_0 = this.k;
        if (v0_0 != 0) {
            int v0_2;
            if (!v0_0.isEmpty()) {
                v0_2 = v0_0.removeFirst();
            } else {
                v0_2 = 0;
            }
            int v0_3 = ((gb.c0) v0_2);
            if (v0_3 != 0) {
                v0_3.run();
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public abstract void shutdown();
}
