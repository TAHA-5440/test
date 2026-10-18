// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final class w extends oc.e {
    public final synthetic fc.x n;

    public w(fc.x p1)
    {
        this.n = p1;
        return;
    }

    public final void j()
    {
        this.n.e(okhttp3.internal.http2.ErrorCode.n);
        fc.p v0_2 = this.n.h;
        try {
            androidx.activity.e v3_6 = v0_2.s;
        } catch (bc.b v1_4) {
            throw v1_4;
        }
        if (v0_2.t >= v3_6) {
            v0_2.s = (v3_6 + 1);
            v0_2.u = (System.nanoTime() + ((long) 1000000000));
            bc.b.c(v0_2.n, r1.a.n(v0_2.i, " ping", new StringBuilder()), new androidx.activity.e(v0_2, 4));
            return;
        } else {
            return;
        }
    }

    public final void k()
    {
        if (this.i()) {
            throw new java.net.SocketTimeoutException("timeout");
        } else {
            return;
        }
    }
}
