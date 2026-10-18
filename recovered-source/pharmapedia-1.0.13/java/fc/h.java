// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final synthetic class h implements ua.a {
    public final synthetic fc.p g;
    public final synthetic int h;
    public final synthetic oc.i i;
    public final synthetic int j;

    public synthetic h(fc.p p1, int p2, oc.i p3, int p4, boolean p5)
    {
        this.g = p1;
        this.h = p2;
        this.i = p3;
        this.j = p4;
        return;
    }

    public final Object invoke()
    {
        ga.p v0_0 = this.g;
        Throwable v1_0 = this.h;
        java.util.LinkedHashSet v2_1 = this.i;
        okhttp3.internal.http2.ErrorCode v3_0 = this.j;
        try {
            v0_0.q.getClass();
            v2_1.skip(((long) v3_0));
            v0_0.C.Z(v1_0, okhttp3.internal.http2.ErrorCode.n);
        } catch (java.io.IOException) {
            return ga.p.a;
        }
        v0_0.E.remove(Integer.valueOf(v1_0));
        return ga.p.a;
    }
}
