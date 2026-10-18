// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final class v implements oc.d0 {
    public final long g;
    public boolean h;
    public final oc.i i;
    public final oc.i j;
    public boolean k;
    public final synthetic fc.x l;

    public v(fc.x p1, long p2, boolean p4)
    {
        this.l = p1;
        this.g = p2;
        this.h = p4;
        this.i = new oc.i();
        this.j = new oc.i();
        return;
    }

    public final long N(long p26, oc.i p28)
    {
        p28.getClass();
        long v4_4 = 0;
        if (p26 < 0) {
            oc.l.d(f0.a.b("byteCount < 0: ", p26));
            return 0;
        }
        while(true) {
            fc.x v6 = this.l;
            int v7_1;
            v6.h.getClass();
            java.io.InterruptedIOException v0_2 = v6.o;
            int v8_0 = 1;
            if (v0_2.i) {
                v7_1 = 1;
            } else {
                if (!v0_2.g) {
                    v7_1 = 0;
                } else {
                }
            }
            if (v7_1 != 0) {
                v6.p.h();
            }
            if ((v6.f() == null) || (this.h)) {
                java.io.InterruptedIOException v0_7 = 0;
            } else {
                v0_7 = v6.s;
                if (v0_7 == null) {
                    long v10_0 = v6.f();
                    v10_0.getClass();
                    v0_7 = new okhttp3.internal.http2.StreamResetException(v10_0);
                }
            }
            if (this.k) {
                throw new java.io.IOException("stream closed");
            } else {
                long v17;
                long v10_2 = this.j;
                long v11_0 = v10_2.h;
                if (v11_0 <= v4_4) {
                    if ((this.h) || (v0_7 != null)) {
                        v8_0 = 0;
                    } else {
                        v6.wait();
                    }
                    v17 = -1;
                } else {
                    v17 = v10_2.N(Math.min(p26, v11_0), p28);
                    gc.a.c(v6.i, v17, 0, 2);
                    long v10_3 = v6.i.b();
                    if ((v0_7 == null) && (v10_3 >= ((long) (v6.h.w.a() / 2)))) {
                        v6.h.c0(v6.g, v10_3);
                        gc.a.c(v6.i, 0, v10_3, 1);
                    }
                    v8_0 = 0;
                }
                if (v7_1 != 0) {
                    v6.p.k();
                }
                this.l.h.v.getClass();
                if (v8_0 == 0) {
                    break;
                }
                v4_4 = 0;
            }
        }
        if (v17 == -1) {
            if (v0_7 != null) {
                throw v0_7;
            } else {
                return -1;
            }
        } else {
            return v17;
        }
    }

    public final oc.f0 a()
    {
        return this.l.p;
    }

    public final void close()
    {
        fc.x v0_0 = this.l;
        try {
            this.k = 1;
            java.util.TimeZone v1_2 = this.j;
            long v2 = v1_2.h;
            v1_2.d();
            v0_0.notifyAll();
        } catch (java.util.TimeZone v1_1) {
            throw v1_1;
        }
        if (v2 > 0) {
            this.l.h.L(v2);
        }
        this.l.a();
        return;
    }
}
