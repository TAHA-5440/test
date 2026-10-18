// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class q0 extends gb.p0 implements gb.a0 {
    public final java.util.concurrent.Executor i;

    public q0(java.util.concurrent.Executor p2)
    {
        this.i = p2;
        if ((p2 instanceof java.util.concurrent.ScheduledThreadPoolExecutor)) {
            ((java.util.concurrent.ScheduledThreadPoolExecutor) p2).setRemoveOnCancelPolicy(1);
        }
        return;
    }

    public final gb.g0 M(long p5, gb.j1 p7, ka.g p8)
    {
        gb.x v0_6;
        gb.x v0_0 = this.i;
        java.util.concurrent.ScheduledFuture v2 = 0;
        if (!(v0_0 instanceof java.util.concurrent.ScheduledExecutorService)) {
            v0_6 = 0;
        } else {
            v0_6 = ((java.util.concurrent.ScheduledExecutorService) v0_0);
        }
        if (v0_6 != null) {
            try {
                v2 = v0_6.schedule(p7, p5, java.util.concurrent.TimeUnit.MILLISECONDS);
            } catch (gb.x v0_1) {
                java.util.concurrent.CancellationException v1_2 = new java.util.concurrent.CancellationException("The task was rejected");
                v1_2.initCause(v0_1);
                gb.x v0_4 = ((gb.u0) p8.Z(gb.t.h));
                if (v0_4 != null) {
                    v0_4.h(v1_2);
                }
            }
        }
        if (v2 == null) {
            return gb.x.p.M(p5, p7, p8);
        } else {
            return new gb.f0(v2);
        }
    }

    public final void c0(long p6, gb.h p8)
    {
        gb.u0 v0_6;
        gb.u0 v0_0 = this.i;
        java.util.concurrent.ScheduledFuture v2 = 0;
        if (!(v0_0 instanceof java.util.concurrent.ScheduledExecutorService)) {
            v0_6 = 0;
        } else {
            v0_6 = ((java.util.concurrent.ScheduledExecutorService) v0_0);
        }
        if (v0_6 != null) {
            ka.g v3_0 = p8.k;
            try {
                v2 = v0_6.schedule(new b3.c(6, this, p8, 0), p6, java.util.concurrent.TimeUnit.MILLISECONDS);
            } catch (gb.u0 v0_1) {
                java.util.concurrent.CancellationException v1_3 = new java.util.concurrent.CancellationException("The task was rejected");
                v1_3.initCause(v0_1);
                gb.u0 v0_4 = ((gb.u0) v3_0.Z(gb.t.h));
                if (v0_4 != null) {
                    v0_4.h(v1_3);
                }
            }
        }
        if (v2 == null) {
            gb.x.p.c0(p6, p8);
            return;
        } else {
            p8.v(new gb.e(v2, 0));
            return;
        }
    }

    public final void close()
    {
        int v0_1;
        int v0_0 = this.i;
        if (!(v0_0 instanceof java.util.concurrent.ExecutorService)) {
            v0_1 = 0;
        } else {
            v0_1 = ((java.util.concurrent.ExecutorService) v0_0);
        }
        if (v0_1 != 0) {
            v0_1.shutdown();
        }
        return;
    }

    public final void d0(ka.g p4, Runnable p5)
    {
        try {
            this.i.execute(p5);
            return;
        } catch (nb.c v0_4) {
            java.util.concurrent.CancellationException v1_1 = new java.util.concurrent.CancellationException("The task was rejected");
            v1_1.initCause(v0_4);
            nb.c v0_2 = ((gb.u0) p4.Z(gb.t.h));
            if (v0_2 != null) {
                v0_2.h(v1_1);
            }
            nb.c.i.d0(p4, p5);
            return;
        }
    }

    public final boolean equals(Object p2)
    {
        if ((!(p2 instanceof gb.q0)) || (((gb.q0) p2).i != this.i)) {
            return 0;
        } else {
            return 1;
        }
    }

    public final java.util.concurrent.Executor h0()
    {
        return this.i;
    }

    public final int hashCode()
    {
        return System.identityHashCode(this.i);
    }

    public final String toString()
    {
        return this.i.toString();
    }
}
