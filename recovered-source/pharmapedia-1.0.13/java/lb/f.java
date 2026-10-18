// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lb;
public final class f extends gb.s implements gb.a0 {
    public static final synthetic java.util.concurrent.atomic.AtomicIntegerFieldUpdater o;
    public final synthetic gb.a0 i;
    public final gb.s j;
    public final int k;
    public final String l;
    public final lb.h m;
    public final Object n;
    private volatile synthetic int runningWorkers$volatile;

    static f()
    {
        lb.f.o = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(lb.f, "runningWorkers$volatile");
        return;
    }

    public f(gb.s p2, int p3, String p4)
    {
        gb.a0 v0_1;
        if (!(p2 instanceof gb.a0)) {
            v0_1 = 0;
        } else {
            v0_1 = ((gb.a0) p2);
        }
        if (v0_1 == null) {
            v0_1 = gb.y.a;
        }
        this.i = v0_1;
        this.j = p2;
        this.k = p3;
        this.l = p4;
        this.m = new lb.h();
        this.n = new Object();
        return;
    }

    public final gb.g0 M(long p2, gb.j1 p4, ka.g p5)
    {
        return this.i.M(p2, p4, p5);
    }

    public final void c0(long p2, gb.h p4)
    {
        this.i.c0(p2, p4);
        return;
    }

    public final void d0(ka.g p2, Runnable p3)
    {
        this.m.a(p3);
        if ((lb.f.o.get(this) < this.k) && (this.i0())) {
            gb.s v2_1 = this.h0();
            if (v2_1 != null) {
                this.j.d0(this, new b3.c(9, this, v2_1));
            }
        }
        return;
    }

    public final void e0(ka.g p2, Runnable p3)
    {
        this.m.a(p3);
        if ((lb.f.o.get(this) < this.k) && (this.i0())) {
            gb.s v2_1 = this.h0();
            if (v2_1 != null) {
                this.j.e0(this, new b3.c(9, this, v2_1));
            }
        }
        return;
    }

    public final gb.s g0(int p1, String p2)
    {
        lb.a.a(1);
        if (1 < this.k) {
            return super.g0(1, 0);
        } else {
            return this;
        }
    }

    public final Runnable h0()
    {
        while(true) {
            int v0_3 = ((Runnable) this.m.d());
            if (v0_3 != 0) {
                return v0_3;
            } else {
                try {
                    Throwable v1_1 = lb.f.o;
                    v1_1.decrementAndGet(this);
                } catch (Throwable v1_0) {
                    throw v1_0;
                }
                if (this.m.c() == 0) {
                    break;
                }
                v1_1.incrementAndGet(this);
            }
        }
        return 0;
    }

    public final boolean i0()
    {
        try {
            Throwable v1_0 = lb.f.o;
        } catch (Throwable v1_1) {
            throw v1_1;
        }
        if (v1_0.get(this) < this.k) {
            v1_0.incrementAndGet(this);
            return 1;
        } else {
            return 0;
        }
    }

    public final String toString()
    {
        String v0_0 = this.l;
        if (v0_0 == null) {
            String v0_2 = new StringBuilder();
            v0_2.append(this.j);
            v0_2.append(".limitedParallelism(");
            v0_2.append(this.k);
            v0_2.append(41);
            v0_0 = v0_2.toString();
        }
        return v0_0;
    }
}
