// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class w0 extends ub.p0 {
    public short[] a;
    public int b;

    public final Object a()
    {
        return java.util.Arrays.copyOf(this.a, this.b);
    }

    public final void b(int p3)
    {
        short[] v0 = this.a;
        if (v0.length < p3) {
            int v1_2 = (v0.length * 2);
            if (p3 < v1_2) {
                p3 = v1_2;
            }
            this.a = java.util.Arrays.copyOf(v0, p3);
        }
        return;
    }

    public final int d()
    {
        return this.b;
    }
}
