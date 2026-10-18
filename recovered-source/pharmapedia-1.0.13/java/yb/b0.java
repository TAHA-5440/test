// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class b0 implements java.io.Closeable {
    public final lc.a g;
    public final okhttp3.Protocol h;
    public final String i;
    public final int j;
    public final yb.r k;
    public final yb.s l;
    public final yb.d0 m;
    public final oc.c0 n;
    public final yb.b0 o;
    public final yb.b0 p;
    public final yb.b0 q;
    public final long r;
    public final long s;
    public final cc.i t;
    public final yb.f0 u;
    public yb.h v;
    public final boolean w;

    public b0(lc.a p1, okhttp3.Protocol p2, String p3, int p4, yb.r p5, yb.s p6, yb.d0 p7, oc.c0 p8, yb.b0 p9, yb.b0 p10, yb.b0 p11, long p12, long p14, cc.i p16, yb.f0 p17)
    {
        p1.getClass();
        p2.getClass();
        p3.getClass();
        p7.getClass();
        p17.getClass();
        this.g = p1;
        this.h = p2;
        this.i = p3;
        this.j = p4;
        this.k = p5;
        this.l = p6;
        this.m = p7;
        this.n = p8;
        this.o = p9;
        this.p = p10;
        this.q = p11;
        this.r = p12;
        this.s = p14;
        this.t = p16;
        this.u = p17;
        int v2_1 = 0;
        if ((200 <= p4) && (p4 < 300)) {
            v2_1 = 1;
        }
        this.w = v2_1;
        return;
    }

    public final void close()
    {
        this.m.close();
        return;
    }

    public final yb.h d()
    {
        yb.h v0_0 = this.v;
        if (v0_0 == null) {
            v0_0 = com.bumptech.glide.e.m(this.l);
            this.v = v0_0;
        }
        return v0_0;
    }

    public final yb.a0 h()
    {
        yb.a0 v0_1 = new yb.a0();
        v0_1.c = -1;
        v0_1.g = yb.d0.g;
        v0_1.o = yb.f0.a;
        v0_1.a = this.g;
        v0_1.b = this.h;
        v0_1.c = this.j;
        v0_1.d = this.i;
        v0_1.e = this.k;
        v0_1.f = this.l.c();
        v0_1.g = this.m;
        v0_1.h = this.n;
        v0_1.i = this.o;
        v0_1.j = this.p;
        v0_1.k = this.q;
        v0_1.l = this.r;
        v0_1.m = this.s;
        v0_1.n = this.t;
        v0_1.o = this.u;
        return v0_1;
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder("Response{protocol=");
        v0_1.append(this.h);
        v0_1.append(", code=");
        v0_1.append(this.j);
        v0_1.append(", message=");
        v0_1.append(this.i);
        v0_1.append(", url=");
        v0_1.append(((yb.u) this.g.b));
        v0_1.append(125);
        return v0_1.toString();
    }
}
