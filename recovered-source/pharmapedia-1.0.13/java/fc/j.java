// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final synthetic class j implements ua.a {
    public final synthetic fc.p g;
    public final synthetic int h;

    public synthetic j(fc.p p1, int p2, okhttp3.internal.http2.ErrorCode p3)
    {
        this.g = p1;
        this.h = p2;
        return;
    }

    public final Object invoke()
    {
        ga.p v0_0 = this.g;
        Throwable v1_0 = this.h;
        v0_0.q.getClass();
        try {
            v0_0.E.remove(Integer.valueOf(v1_0));
            return ga.p.a;
        } catch (Throwable v1_1) {
            throw v1_1;
        }
    }
}
