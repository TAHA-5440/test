// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public final class b implements yb.v {
    public static final cc.b a;

    static b()
    {
        cc.b.a = new cc.b();
        return;
    }

    public final yb.b0 a(dc.g p10)
    {
        dc.g v0_0 = p10.a;
        if (!v0_0.s) {
            throw new IllegalStateException("released");
        } else {
            if (v0_0.r) {
                throw new IllegalStateException("Check failed.");
            } else {
                if (v0_0.q) {
                    throw new IllegalStateException("Check failed.");
                } else {
                    ec.h v4_6;
                    int v1_4 = v0_0.m;
                    v1_4.getClass();
                    cc.i v2_0 = v1_4.b();
                    int v3_0 = v0_0.g;
                    v2_0.getClass();
                    v3_0.getClass();
                    ec.h v4_0 = p10.g;
                    androidx.lifecycle.j v5 = v2_0.i;
                    long v6_0 = v2_0.k;
                    if (v6_0 == 0) {
                        v2_0.f.setSoTimeout(v4_0);
                        ((oc.y) v5.i).g.a().g(((long) v4_0));
                        ((oc.x) v5.j).g.a().g(((long) p10.h));
                        v4_6 = new ec.h(v3_0, v2_0, v5);
                    } else {
                        v4_6 = new fc.q(v3_0, v2_0, p10, v6_0);
                    }
                    cc.i v2_2 = new cc.i(v0_0, v1_4, v4_6);
                    v0_0.p = v2_2;
                    v0_0.u = v2_2;
                    try {
                        v0_0.q = 1;
                        v0_0.r = 1;
                    } catch (int v10_6) {
                        throw v10_6;
                    }
                    if (v0_0.t) {
                        oc.l.g("Canceled");
                        return 0;
                    } else {
                        return dc.g.a(p10, 0, v2_2, 0, 61).b(p10.e);
                    }
                }
            }
        }
    }
}
