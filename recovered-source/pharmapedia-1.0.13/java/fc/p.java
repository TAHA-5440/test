// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final class p implements java.io.Closeable {
    public static final fc.c0 F;
    public long A;
    public final androidx.lifecycle.j B;
    public final fc.y C;
    public final fc.o D;
    public final java.util.LinkedHashSet E;
    public final fc.l g;
    public final java.util.LinkedHashMap h;
    public final String i;
    public int j;
    public int k;
    public boolean l;
    public final bc.d m;
    public final bc.b n;
    public final bc.b o;
    public final bc.b p;
    public final fc.b0 q;
    public long r;
    public long s;
    public long t;
    public long u;
    public final fc.a v;
    public final fc.c0 w;
    public fc.c0 x;
    public final gc.a y;
    public long z;

    static p()
    {
        fc.c0 v0_1 = new fc.c0();
        v0_1.b(4, 65535);
        v0_1.b(5, 16384);
        fc.p.F = v0_1;
        return;
    }

    public p(androidx.lifecycle.d1 p5)
    {
        this.g = ((fc.l) p5.j);
        this.h = new java.util.LinkedHashMap();
        fc.o v0_20 = ((String) p5.i);
        if (v0_20 == null) {
            kotlin.jvm.internal.f.i("connectionName");
            throw 0;
        } else {
            this.i = v0_20;
            this.k = 3;
            fc.o v0_3 = ((bc.d) p5.g);
            this.m = v0_3;
            this.n = v0_3.d();
            this.o = v0_3.d();
            this.p = v0_3.d();
            this.q = fc.b0.a;
            this.v = ((fc.a) p5.k);
            fc.o v0_10 = new fc.c0();
            v0_10.b(4, 16777216);
            this.w = v0_10;
            fc.o v0_12 = fc.p.F;
            this.x = v0_12;
            this.y = new gc.a(0);
            this.A = ((long) v0_12.a());
            String v5_3 = ((androidx.lifecycle.j) p5.h);
            if (v5_3 == null) {
                kotlin.jvm.internal.f.i("socket");
                throw 0;
            } else {
                this.B = v5_3;
                this.C = new fc.y(((oc.x) v5_3.j));
                this.D = new fc.o(this, new fc.t(((oc.y) v5_3.i)));
                this.E = new java.util.LinkedHashSet();
                return;
            }
        }
    }

    public final void B(okhttp3.internal.http2.ErrorCode p5)
    {
        try {
            try {
                if (!this.l) {
                    this.l = 1;
                    this.C.B(this.j, p5, zb.c.a);
                    return;
                } else {
                    return;
                }
            } catch (Throwable v5_2) {
                throw v5_2;
            }
        } catch (Throwable v5_1) {
            throw v5_1;
        }
    }

    public final void L(long p7)
    {
        gc.a.c(this.y, p7, 0, 2);
        long v3_1 = this.y.b();
        if (v3_1 >= ((long) (this.w.a() / 2))) {
            this.c0(0, v3_1);
            gc.a.c(this.y, 0, v3_1, 1);
        }
        gc.a v8 = this.y;
        this.v.getClass();
        v8.getClass();
        return;
    }

    public final void M(int p9, boolean p10, oc.i p11, long p12)
    {
        if (p12 == 0) {
            this.C.h(p10, p9, p11, 0);
            return;
        }
        while (p12 > 0) {
            while(true) {
                fc.y v4_7 = this.z;
                long v6_2 = this.A;
                if (v4_7 < v6_2) {
                    break;
                }
                if (!this.h.containsKey(Integer.valueOf(p9))) {
                    throw new java.io.IOException("stream closed");
                } else {
                    this.wait();
                }
            }
            int v5_1;
            int v2_2 = Math.min(((int) Math.min(p12, (v6_2 - v4_7))), this.C.i);
            long v6_1 = ((long) v2_2);
            this.z = (this.z + v6_1);
            p12 -= v6_1;
            if ((p10 == null) || (p12 != 0)) {
                v5_1 = 0;
            } else {
                v5_1 = 1;
            }
            this.C.h(v5_1, p9, p11, v2_2);
        }
        return;
    }

    public final void Z(int p4, okhttp3.internal.http2.ErrorCode p5)
    {
        String v0_1 = new StringBuilder();
        v0_1.append(this.i);
        v0_1.append(91);
        v0_1.append(p4);
        v0_1.append("] writeSynReset");
        bc.b.c(this.n, v0_1.toString(), new fc.i(this, p4, p5, 2));
        return;
    }

    public final void c0(int p3, long p4)
    {
        String v0_1 = new StringBuilder();
        v0_1.append(this.i);
        v0_1.append(91);
        v0_1.append(p3);
        v0_1.append("] windowUpdate");
        bc.b.c(this.n, v0_1.toString(), new fc.g(this, p3, p4));
        return;
    }

    public final void close()
    {
        this.d(okhttp3.internal.http2.ErrorCode.i, okhttp3.internal.http2.ErrorCode.n, 0);
        return;
    }

    public final void d(okhttp3.internal.http2.ErrorCode p4, okhttp3.internal.http2.ErrorCode p5, java.io.IOException p6)
    {
        this.B(p4);
        try {
            int v0 = 0;
        } catch (bc.b v4_16) {
            throw v4_16;
        }
        if (this.h.isEmpty()) {
            bc.b v4_3 = 0;
        } else {
            int v1_0 = new fc.x[0];
            v4_3 = this.h.values().toArray(v1_0);
            this.h.clear();
        }
        bc.b v4_4 = ((fc.x[]) v4_3);
        if (v4_4 != null) {
            int v1_2 = v4_4.length;
        }
        this.C.close();
        try {
            ((java.net.Socket) ((c0.g) this.B.h).h).close();
        } catch (java.io.IOException) {
        }
        this.n.g();
        this.o.g();
        this.p.g();
        return;
    }

    public final fc.x h(int p2)
    {
        try {
            return ((fc.x) this.h.get(Integer.valueOf(p2)));
        } catch (Throwable v2_4) {
            throw v2_4;
        }
    }

    public final fc.x i(int p2)
    {
        try {
            Throwable v2_3 = ((fc.x) this.h.remove(Integer.valueOf(p2)));
            this.notifyAll();
            return v2_3;
        } catch (Throwable v2_4) {
            throw v2_4;
        }
    }
}
