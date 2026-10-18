// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final class c0 {
    public int a;
    public final int[] b;

    public c0()
    {
        int[] v0_1 = new int[10];
        this.b = v0_1;
        return;
    }

    public final int a()
    {
        if ((this.a & 16) == 0) {
            return 65535;
        } else {
            return this.b[4];
        }
    }

    public final void b(int p4, int p5)
    {
        if (p4 >= 0) {
            int[] v0 = this.b;
            if (p4 < v0.length) {
                this.a = ((1 << p4) | this.a);
                v0[p4] = p5;
            }
        }
        return;
    }
}
