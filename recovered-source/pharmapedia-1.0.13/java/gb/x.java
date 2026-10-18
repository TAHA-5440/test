// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class x extends gb.o0 implements java.lang.Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final gb.x p;
    public static final long q;

    static x()
    {
        long v0_1 = new gb.x();
        gb.x.p = v0_1;
        v0_1.j0(0);
        try {
            long v0_2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException) {
            v0_2 = Long.valueOf(v0_2);
        }
        gb.x.q = java.util.concurrent.TimeUnit.MILLISECONDS.toNanos(v0_2.longValue());
        return;
    }

    public final gb.g0 M(long p3, gb.j1 p5, ka.g p6)
    {
        long v0_0 = 0;
        if (p3 > 0) {
            if (p3 < 9223372036854) {
                v0_0 = (1000000 * p3);
            } else {
                v0_0 = 9223372036854775807;
            }
        }
        if (v0_0 >= 4611686018427387903) {
            return gb.d1.g;
        } else {
            gb.d1 v3_3 = System.nanoTime();
            gb.l0 v6_2 = new gb.l0((v0_0 + v3_3), p5);
            this.s0(v3_3, v6_2);
            return v6_2;
        }
    }

    public final void m0(Runnable p3)
    {
        if (gb.x.debugStatus == 4) {
            throw new java.util.concurrent.RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        } else {
            super.m0(p3);
            return;
        }
    }

    public final Thread p0()
    {
        Thread v0_0 = gb.x._thread;
        if (v0_0 != null) {
            return v0_0;
        } else {
            Thread v0_1 = gb.x._thread;
            if (v0_1 == null) {
                v0_1 = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                gb.x._thread = v0_1;
                v0_1.setContextClassLoader(gb.x.p.getClass().getClassLoader());
                v0_1.setDaemon(1);
                v0_1.start();
            }
            return v0_1;
        }
    }

    public final void r0(long p1, gb.m0 p3)
    {
        throw new java.util.concurrent.RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final void run()
    {
        gb.g1.a.set(this);
        try {
        } catch (boolean v0_14) {
            gb.x._thread = 0;
            this.t0();
            if (!this.q0()) {
                this.p0();
            }
            throw v0_14;
        }
        boolean v0_1;
        boolean v0_8 = gb.x.debugStatus;
        if ((v0_8 != 2) && (v0_8 != 3)) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        if (!v0_1) {
            gb.x.debugStatus = 1;
            this.notifyAll();
            long v9_0 = 9223372036854775807;
            while(true) {
                Thread.interrupted();
                long v11 = this.k0();
                if (v11 != 9223372036854775807) {
                    v9_0 = 9223372036854775807;
                } else {
                    long v15_0 = System.nanoTime();
                    if (v9_0 == 9223372036854775807) {
                        v9_0 = (gb.x.q + v15_0);
                    }
                    long v15_1 = (v9_0 - v15_0);
                    if (v15_1 <= 0) {
                        break;
                    }
                    if (v11 > v15_1) {
                        v11 = v15_1;
                    }
                }
                if (v11 > 0) {
                    boolean v0_10;
                    boolean v0_9 = gb.x.debugStatus;
                    if ((v0_9 != 2) && (v0_9 != 3)) {
                        v0_10 = 0;
                    } else {
                        v0_10 = 1;
                    }
                    if (!v0_10) {
                        java.util.concurrent.locks.LockSupport.parkNanos(this, v11);
                    } else {
                        gb.x._thread = 0;
                        this.t0();
                        if (!this.q0()) {
                            this.p0();
                        }
                    }
                }
            }
            gb.x._thread = 0;
            this.t0();
            if (this.q0()) {
                return;
            } else {
                this.p0();
                return;
            }
        } else {
            gb.x._thread = 0;
            this.t0();
            if (!this.q0()) {
                this.p0();
                return;
            }
        }
        return;
    }

    public final void shutdown()
    {
        gb.x.debugStatus = 4;
        super.shutdown();
        return;
    }

    public final declared_synchronized void t0()
    {
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater v0_3;
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater v0_0 = gb.x.debugStatus;
        if ((v0_0 != 2) && (v0_0 != 3)) {
            v0_3 = 0;
        } else {
            v0_3 = 1;
        }
        if (v0_3 != null) {
            gb.x.debugStatus = 3;
            gb.o0.m.set(this, 0);
            gb.o0.n.set(this, 0);
            this.notifyAll();
            return;
        } else {
            return;
        }
    }

    public final String toString()
    {
        return "DefaultExecutor";
    }
}
