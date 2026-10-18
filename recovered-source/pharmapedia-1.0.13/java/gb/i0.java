// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class i0 implements gb.s0 {
    public final boolean g;

    public i0(boolean p1)
    {
        this.g = p1;
        return;
    }

    public final boolean d()
    {
        return this.g;
    }

    public final gb.c1 e()
    {
        return 0;
    }

    public final String toString()
    {
        String v1_2;
        String v0_1 = new StringBuilder("Empty{");
        if (!this.g) {
            v1_2 = "New";
        } else {
            v1_2 = "Active";
        }
        return r1.a.r(v0_1, v1_2, 125);
    }
}
