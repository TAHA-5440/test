// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final synthetic class g implements ua.a {
    public final synthetic fc.p g;
    public final synthetic int h;
    public final synthetic long i;

    public synthetic g(fc.p p1, int p2, long p3)
    {
        this.g = p1;
        this.h = p2;
        this.i = p3;
        return;
    }

    public final Object invoke()
    {
        ga.p v0_0 = this.g;
        try {
            v0_0.C.c0(this.h, this.i);
        } catch (java.io.IOException v1_1) {
            v0_0.d(okhttp3.internal.http2.ErrorCode.j, okhttp3.internal.http2.ErrorCode.j, v1_1);
        }
        return ga.p.a;
    }
}
