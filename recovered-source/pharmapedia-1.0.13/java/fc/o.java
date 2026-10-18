// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final class o implements ua.a {
    public final fc.t g;
    public final synthetic fc.p h;

    public o(fc.p p1, fc.t p2)
    {
        this.h = p1;
        this.g = p2;
        return;
    }

    public final Object invoke()
    {
        ga.p v0_0 = this.h;
        fc.t v1 = this.g;
        okhttp3.internal.http2.ErrorCode v2 = okhttp3.internal.http2.ErrorCode.k;
        java.io.IOException v4 = 0;
        try {
            if (!v1.d(1, this)) {
                throw new java.io.IOException("Required SETTINGS preface not received");
            } else {
                try {
                    while (v1.d(0, this)) {
                    }
                } catch (Throwable v5_0) {
                    okhttp3.internal.http2.ErrorCode v3_4 = v2;
                    v0_0.d(v3_4, v2, v4);
                    zb.c.a(v1);
                    throw v5_0;
                }
                v3_4 = okhttp3.internal.http2.ErrorCode.i;
                try {
                    v2 = okhttp3.internal.http2.ErrorCode.n;
                    v0_0.d(v3_4, v2, 0);
                } catch (java.io.IOException v4) {
                    v2 = okhttp3.internal.http2.ErrorCode.j;
                    v0_0.d(v2, v2, v4);
                }
            }
        } catch (okhttp3.internal.http2.ErrorCode v3_5) {
            v4 = v3_5;
            v3_4 = v2;
        } catch (okhttp3.internal.http2.ErrorCode v3_1) {
            v5_0 = v3_1;
        } catch (Throwable v5_0) {
        }
        zb.c.a(v1);
        return ga.p.a;
    }
}
