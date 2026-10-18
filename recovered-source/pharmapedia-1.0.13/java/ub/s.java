// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class s {
    public static final long[] e;
    public final sb.d a;
    public final ua.p b;
    public long c;
    public final long[] d;

    static s()
    {
        long[] v0_1 = new long[0];
        ub.s.e = v0_1;
        return;
    }

    public s(sb.d p5, ua.p p6)
    {
        p5.getClass();
        this.a = p5;
        this.b = p6;
        long[] v5_2 = p5.f();
        long v2_1 = 0;
        if (v5_2 > 64) {
            this.c = 0;
            int v6_2 = ((v5_2 - 1) >> 6);
            long[] v3 = new long[v6_2];
            if ((v5_2 & 63) != 0) {
                v3[(v6_2 - 1)] = (-1 << v5_2);
            }
            this.d = v3;
            return;
        } else {
            if (v5_2 != 64) {
                v2_1 = (-1 << v5_2);
            }
            this.c = v2_1;
            this.d = ub.s.e;
            return;
        }
    }
}
