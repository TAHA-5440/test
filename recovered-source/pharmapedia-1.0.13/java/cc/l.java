// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public final class l extends bc.a {
    public final synthetic cc.x e;
    public final synthetic cc.m f;

    public l(String p1, cc.x p2, cc.m p3)
    {
        this.e = p2;
        this.f = p3;
        super(p1);
        return;
    }

    public final long a()
    {
        long v0_0 = this.e;
        try {
            cc.w v1_0 = v0_0.e();
        } catch (cc.w v1_1) {
            v1_0 = new cc.w(v0_0, v1_1, 2);
        }
        cc.m v2_2 = this.f;
        if (v2_2.d.contains(v0_0)) {
            v2_2.e.put(v1_0);
        }
        return -1;
    }
}
