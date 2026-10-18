// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package pc;
public final class g extends oc.q {
    public final long h;
    public final boolean i;
    public long j;

    public g(oc.d0 p1, long p2, boolean p4)
    {
        super(p1);
        super.h = p2;
        super.i = p4;
        return;
    }

    public final long N(long p10, oc.i p12)
    {
        p12.getClass();
        oc.i v0_0 = this.j;
        long v2 = this.h;
        if (v0_0 <= v2) {
            if (this.i) {
                oc.i v0_7 = (v2 - v0_0);
                if (v0_7 != 0) {
                    p10 = Math.min(p10, v0_7);
                } else {
                    return -1;
                }
            }
        } else {
            p10 = 0;
        }
        long v10_1 = this.g.N(p10, p12);
        oc.i v0_2 = v10_1 cmp -1;
        if (v0_2 != null) {
            this.j = (this.j + v10_1);
        }
        long v4_3 = this.j;
        String v1_0 = v4_3 cmp v2;
        if (((v1_0 >= null) || (v0_2 != null)) && (v1_0 <= null)) {
            return v10_1;
        } else {
            if ((v10_1 > 0) && (v1_0 > null)) {
                long v10_4 = (p12.h - (v4_3 - v2));
                oc.i v0_4 = new oc.i();
                v0_4.n0(p12);
                p12.D(v10_4, v0_4);
                v0_4.d();
            }
            String v11_0 = this.j;
            oc.i v0_6 = new StringBuilder("expected ");
            v0_6.append(v2);
            v0_6.append(" bytes but got ");
            v0_6.append(v11_0);
            throw new java.io.IOException(v0_6.toString());
        }
    }
}
