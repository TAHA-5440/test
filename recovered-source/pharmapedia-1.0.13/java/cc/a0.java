// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public final class a0 {
    public final yb.a a;
    public final a3.f b;
    public final cc.a c;
    public final boolean d;
    public final java.util.List e;
    public int f;
    public Object g;
    public final java.util.ArrayList h;

    public a0(yb.a p1, a3.f p2, cc.a p3, boolean p4)
    {
        java.util.List v1_3;
        p1.getClass();
        p2.getClass();
        p3.getClass();
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = p4;
        yb.u v2_4 = kotlin.collections.EmptyList.g;
        this.e = v2_4;
        this.g = v2_4;
        this.h = new java.util.ArrayList();
        yb.u v2_3 = p1.h;
        p3.getClass();
        v2_3.getClass();
        boolean v3_1 = v2_3.i();
        if (v3_1.getHost() != null) {
            java.util.List v1_2 = p1.g.select(v3_1);
            if ((v1_2 != null) && (!v1_2.isEmpty())) {
                v1_3 = zb.e.i(v1_2);
            } else {
                v1_3 = zb.e.j(new java.net.Proxy[] {java.net.Proxy.NO_PROXY}));
            }
        } else {
            v1_3 = zb.e.j(new java.net.Proxy[] {java.net.Proxy.NO_PROXY}));
        }
        this.e = v1_3;
        this.f = 0;
        v2_3.getClass();
        return;
    }

    public final boolean a()
    {
        if ((this.f >= this.e.size()) && (this.h.isEmpty())) {
            return 0;
        } else {
            return 1;
        }
    }
}
