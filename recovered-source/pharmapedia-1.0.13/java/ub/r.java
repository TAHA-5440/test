// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class r implements qb.a {
    public static final ub.r a;
    public static final ub.s0 b;

    static r()
    {
        ub.r.a = new ub.r();
        ub.r.b = new ub.s0("kotlin.time.Duration", sb.c.m);
        return;
    }

    public final Object deserialize(tb.c p5)
    {
        p5.getClass();
        eb.a v5_4 = p5.j();
        v5_4.getClass();
        try {
            int v2_0;
            String v0_2 = jc.g.n(v5_4);
        } catch (String v0_1) {
            throw new IllegalArgumentException(f0.a.d("Invalid ISO duration string format: \'", v5_4, "\'."), v0_1);
        }
        if (v0_2 != eb.a.k) {
            v2_0 = 0;
        } else {
            v2_0 = 1;
        }
        if (v2_0 != 0) {
            throw new IllegalStateException("invariant failed");
        } else {
            return new eb.a(v0_2);
        }
    }

    public final sb.d getDescriptor()
    {
        return ub.r.b;
    }

    public final void serialize(tb.d p18, Object p19)
    {
        String v0_2 = ((eb.a) p19).g;
        StringBuilder v3_1 = new StringBuilder();
        int v2_6 = v0_2 cmp 0;
        if (v2_6 < 0) {
            v3_1.append(45);
        }
        String v7_0;
        v3_1.append("PT");
        int v6_1 = 1;
        if (v2_6 >= 0) {
            v7_0 = v0_2;
        } else {
            v7_0 = (((- (v0_2 >> 1)) << 1) + ((long) (((int) v0_2) & 1)));
        }
        long v15;
        int v2_5;
        long v9_1 = eb.a.g(v7_0, kotlin.time.DurationUnit.l);
        if (!eb.a.e(v7_0)) {
            v15 = 0;
            v2_5 = ((int) (eb.a.g(v7_0, kotlin.time.DurationUnit.k) % ((long) 60)));
        } else {
            v15 = 0;
            v2_5 = 0;
        }
        int v4_5;
        if (!eb.a.e(v7_0)) {
            v4_5 = ((int) (eb.a.g(v7_0, kotlin.time.DurationUnit.j) % ((long) 60)));
        } else {
            v4_5 = 0;
        }
        int v5 = eb.a.d(v7_0);
        if (eb.a.e(v0_2)) {
            v9_1 = 9999999999999;
        }
        String v0_5;
        if (v9_1 == v15) {
            v0_5 = 0;
        } else {
            v0_5 = 1;
        }
        if ((v4_5 == 0) && (v5 == 0)) {
            tb.d v1_0 = 0;
        } else {
            v1_0 = 1;
        }
        if ((v2_5 == 0) && ((v1_0 == null) || (v0_5 == null))) {
            v6_1 = 0;
        }
        if (v0_5 != null) {
            v3_1.append(v9_1);
            v3_1.append(72);
        }
        if (v6_1 != 0) {
            v3_1.append(v2_5);
            v3_1.append(77);
        }
        if ((v1_0 != null) || ((v0_5 == null) && (v6_1 == 0))) {
            eb.a.b(v3_1, v4_5, v5, 9, "S", 1);
        }
        p18.p(v3_1.toString());
        return;
    }
}
