// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lb;
public final class l extends gb.s implements gb.a0 {
    public final synthetic gb.a0 i;
    public final gb.s j;
    public final String k;

    public l(gb.s p2, String p3)
    {
        gb.a0 v0_1;
        if (!(p2 instanceof gb.a0)) {
            v0_1 = 0;
        } else {
            v0_1 = ((gb.a0) p2);
        }
        if (v0_1 == null) {
            v0_1 = gb.y.a;
        }
        this.i = v0_1;
        this.j = p2;
        this.k = p3;
        return;
    }

    public final gb.g0 M(long p2, gb.j1 p4, ka.g p5)
    {
        return this.i.M(p2, p4, p5);
    }

    public final void c0(long p2, gb.h p4)
    {
        this.i.c0(p2, p4);
        return;
    }

    public final void d0(ka.g p2, Runnable p3)
    {
        this.j.d0(p2, p3);
        return;
    }

    public final void e0(ka.g p2, Runnable p3)
    {
        this.j.e0(p2, p3);
        return;
    }

    public final boolean f0(ka.g p2)
    {
        return this.j.f0(p2);
    }

    public final String toString()
    {
        return this.k;
    }
}
