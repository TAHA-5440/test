// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final synthetic class i implements ua.a {
    public final synthetic int g;
    public final synthetic fc.p h;
    public final synthetic int i;
    public final synthetic Object j;

    public synthetic i(fc.p p1, int p2, Object p3, int p4)
    {
        this.g = p4;
        this.h = p1;
        this.i = p2;
        this.j = p3;
        return;
    }

    public synthetic i(fc.p p1, int p2, java.util.List p3, boolean p4)
    {
        this.g = 1;
        this.h = p1;
        this.i = p2;
        this.j = p3;
        return;
    }

    public final Object invoke()
    {
        switch (this.g) {
            case 0:
                ga.p v0_2 = this.h;
                Throwable v1_2 = this.i;
                v0_2.q.getClass();
                try {
                    v0_2.C.Z(v1_2, okhttp3.internal.http2.ErrorCode.n);
                } catch (java.io.IOException) {
                    return ga.p.a;
                }
                v0_2.E.remove(Integer.valueOf(v1_2));
                return ga.p.a;
            case 1:
                ga.p v0_3 = this.h;
                Throwable v1_5 = this.i;
                v0_3.q.getClass();
                try {
                    v0_3.C.Z(v1_5, okhttp3.internal.http2.ErrorCode.n);
                } catch (java.io.IOException) {
                    return ga.p.a;
                }
                v0_3.E.remove(Integer.valueOf(v1_5));
                return ga.p.a;
            default:
                ga.p v0_5 = this.h;
                try {
                    v0_5.C.Z(this.i, ((okhttp3.internal.http2.ErrorCode) this.j));
                } catch (Throwable v1_7) {
                    v0_5.d(okhttp3.internal.http2.ErrorCode.j, okhttp3.internal.http2.ErrorCode.j, v1_7);
                }
                return ga.p.a;
        }
    }
}
