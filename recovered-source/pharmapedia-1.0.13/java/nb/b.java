// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package nb;
public final class b implements java.util.concurrent.Executor, java.io.Closeable {
    public static final synthetic java.util.concurrent.atomic.AtomicLongFieldUpdater n;
    public static final synthetic java.util.concurrent.atomic.AtomicLongFieldUpdater o;
    public static final synthetic java.util.concurrent.atomic.AtomicIntegerFieldUpdater p;
    public static final com.google.gson.internal.b q;
    private volatile synthetic int _isTerminated$volatile;
    private volatile synthetic long controlState$volatile;
    public final int g;
    public final int h;
    public final long i;
    public final String j;
    public final nb.e k;
    public final nb.e l;
    public final lb.n m;
    private volatile synthetic long parkedWorkersStack$volatile;

    static b()
    {
        nb.b.n = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(nb.b, "parkedWorkersStack$volatile");
        nb.b.o = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(nb.b, "controlState$volatile");
        nb.b.p = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(nb.b, "_isTerminated$volatile");
        nb.b.q = new com.google.gson.internal.b("NOT_IN_STACK", 3);
        return;
    }

    public b(int p3, int p4, long p5, String p7)
    {
        this.g = p3;
        this.h = p4;
        this.i = p5;
        this.j = p7;
        if (p3 < 1) {
            oc.l.d(r1.a.h(p3, "Core pool size ", " should be at least 1"));
            throw 0;
        } else {
            if (p4 < p3) {
                oc.l.d(r1.a.l("Max pool size ", " should be greater than or equals to core pool size ", p4, p3));
                throw 0;
            } else {
                if (p4 > 2097150) {
                    oc.l.d(r1.a.h(p4, "Max pool size ", " should not exceed maximal supported number of threads 2097150"));
                    throw 0;
                } else {
                    if (p5 <= 0) {
                        String v3_9 = new StringBuilder("Idle worker keep alive time ");
                        v3_9.append(p5);
                        v3_9.append(" must be positive");
                        throw new IllegalArgumentException(v3_9.toString().toString());
                    } else {
                        this.k = new nb.e();
                        this.l = new nb.e();
                        this.m = new lb.n(((p3 + 1) * 2));
                        this.controlState$volatile = (((long) p3) << 42);
                        this._isTerminated$volatile = 0;
                        return;
                    }
                }
            }
        }
    }

    public static synthetic void i(nb.b p1, Runnable p2, int p3)
    {
        int v3_2;
        if ((p3 & 4) == 0) {
            v3_2 = 1;
        } else {
            v3_2 = 0;
        }
        p1.h(p2, 0, v3_2);
        return;
    }

    public final void B(nb.a p8, int p9, int p10)
    {
        do {
            long v3 = nb.b.n.get(this);
            Object v0_1 = ((int) (2097151 & v3));
            java.util.concurrent.atomic.AtomicLongFieldUpdater v1_3 = ((2097152 + v3) & -2097152);
            if (v0_1 == p9) {
                if (p10 != 0) {
                    v0_1 = p10;
                } else {
                    Object v0_2 = p8.c();
                    while (v0_2 != nb.b.q) {
                        if (v0_2 != null) {
                            Object v0_3 = ((nb.a) v0_2);
                            int v5_1 = v0_3.b();
                            if (v5_1 == 0) {
                                v0_2 = v0_3.c();
                            } else {
                                v0_1 = v5_1;
                            }
                        } else {
                            v0_1 = 0;
                        }
                    }
                    v0_1 = -1;
                }
            }
        } while((v0_1 < null) || (!nb.b.n.compareAndSet(this, v3, (((long) v0_1) | v1_3))));
        return;
    }

    public final boolean L(long p4)
    {
        int v0_2 = (((int) (2097151 & p4)) - ((int) ((p4 & 4398044413952) >> 21)));
        if (v0_2 < 0) {
            v0_2 = 0;
        }
        int v5 = this.g;
        if (v0_2 < v5) {
            int v0_3 = this.d();
            if ((v0_3 == 1) && (v5 > 1)) {
                this.d();
            }
            if (v0_3 > 0) {
                return 1;
            }
        }
        return 0;
    }

    public final boolean M()
    {
        do {
            long v3 = nb.b.n.get(this);
            int v0_2 = ((nb.a) this.m.b(((int) (2097151 & v3))));
            if (v0_2 != 0) {
                boolean v1_2 = ((2097152 + v3) & -2097152);
                Object v5_1 = v0_2.c();
                while(true) {
                    int v6;
                    com.google.gson.internal.b v9 = nb.b.q;
                    if (v5_1 != v9) {
                        if (v5_1 == null) {
                            break;
                        }
                        Object v5_2 = ((nb.a) v5_1);
                        v6 = v5_2.b();
                        if (v6 == 0) {
                            v5_1 = v5_2.c();
                        }
                    } else {
                        v6 = -1;
                    }
                    if ((v6 >= 0) && (nb.b.n.compareAndSet(this, v3, (((long) v6) | v1_2)))) {
                        v0_2.g(v9);
                    }
                }
                v6 = 0;
            } else {
                v0_2 = 0;
            }
            if (v0_2 != 0) {
            } else {
                return 0;
            }
        } while(!nb.a.o.compareAndSet(v0_2, -1, 0));
        java.util.concurrent.locks.LockSupport.unpark(v0_2);
        return 1;
    }

    public final void close()
    {
        if (nb.b.p.compareAndSet(this, 0, 1)) {
            java.util.concurrent.atomic.AtomicLongFieldUpdater v0_1;
            java.util.concurrent.atomic.AtomicLongFieldUpdater v0_4 = Thread.currentThread();
            if (!(v0_4 instanceof nb.a)) {
                v0_1 = 0;
            } else {
                v0_1 = ((nb.a) v0_4);
            }
            if ((v0_1 == null) || (!v0_1.n.equals(this))) {
                v0_1 = 0;
            }
            try {
                Thread$UncaughtExceptionHandler v4_3 = ((int) (nb.b.o.get(this) & 2097151));
            } catch (java.util.concurrent.atomic.AtomicLongFieldUpdater v0_2) {
                throw v0_2;
            }
            if (1 <= v4_3) {
                long v1_3 = 1;
                while(true) {
                    nb.k v5_1 = this.m.b(v1_3);
                    v5_1.getClass();
                    nb.k v5_2 = ((nb.a) v5_1);
                    if (v5_2 != v0_1) {
                        while (v5_2.getState() != Thread$State.TERMINATED) {
                            java.util.concurrent.locks.LockSupport.unpark(v5_2);
                            v5_2.join(10000);
                        }
                        nb.k v5_3 = v5_2.g;
                        nb.e v6_2 = this.l;
                        v5_3.getClass();
                        nb.g v7_3 = ((nb.g) nb.k.b.getAndSet(v5_3, 0));
                        if (v7_3 != null) {
                            v6_2.a(v7_3);
                        }
                        while(true) {
                            nb.g v7_4 = v5_3.b();
                            if (v7_4 == null) {
                                break;
                            }
                            v6_2.a(v7_4);
                        }
                    }
                    if (v1_3 != v4_3) {
                        v1_3++;
                    }
                }
            }
            this.l.b();
            this.k.b();
            while(true) {
                long v1_6;
                if (v0_1 == null) {
                    v1_6 = ((nb.g) this.k.d());
                    if (v1_6 == 0) {
                        v1_6 = ((nb.g) this.l.d());
                        if (v1_6 == 0) {
                            break;
                        }
                    }
                } else {
                    v1_6 = v0_1.a(1);
                    if (v1_6 == 0) {
                    }
                }
                try {
                    v1_6.run();
                } catch (long v1_11) {
                    Thread v3_0 = Thread.currentThread();
                    v3_0.getUncaughtExceptionHandler().uncaughtException(v3_0, v1_11);
                }
            }
            if (v0_1 != null) {
                v0_1.h(kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.k);
            }
            nb.b.n.set(this, 0);
            nb.b.o.set(this, 0);
            return;
        } else {
            return;
        }
    }

    public final int d()
    {
        String v1_7;
        if (nb.b.p.get(this) == 0) {
            v1_7 = 0;
        } else {
            v1_7 = 1;
        }
        if (v1_7 == null) {
            String v1_1 = nb.b.o;
            int v4_0 = v1_1.get(this);
            long v8_1 = ((int) (v4_0 & 2097151));
            int v4_4 = (v8_1 - ((int) ((v4_0 & 4398044413952) >> 21)));
            if (v4_4 < 0) {
                v4_4 = 0;
            }
            if (v4_4 < this.g) {
                if (v8_1 < this.h) {
                    int v3_1 = (((int) (v1_1.get(this) & 2097151)) + 1);
                    if ((v3_1 <= 0) || (this.m.b(v3_1) != null)) {
                        throw new IllegalArgumentException("Failed requirement.");
                    } else {
                        nb.a v5_5 = new nb.a(this, v3_1);
                        this.m.c(v3_1, v5_5);
                        if (v3_1 != ((int) (2097151 & v1_1.incrementAndGet(this)))) {
                            throw new IllegalArgumentException("Failed requirement.");
                        } else {
                            int v4_5 = (v4_4 + 1);
                            v5_5.start();
                            return v4_5;
                        }
                    }
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }

    public final void execute(Runnable p2)
    {
        nb.b.i(this, p2, 6);
        return;
    }

    public final void h(Runnable p9, boolean p10, boolean p11)
    {
        boolean v9_3;
        nb.i.f.getClass();
        String v0_2 = System.nanoTime();
        if (!(p9 instanceof nb.g)) {
            v9_3 = new nb.h(p9, v0_2, p10);
        } else {
            v9_3 = ((nb.g) p9);
            ((nb.g) p9).g = v0_2;
            ((nb.g) p9).h = p10;
        }
        long v1_0;
        String v10_1 = v9_3.h;
        String v0_1 = nb.b.o;
        if (v10_1 == null) {
            v1_0 = 0;
        } else {
            v1_0 = v0_1.addAndGet(this, 2097152);
        }
        int v3_1;
        int v3_0 = Thread.currentThread();
        if (!(v3_0 instanceof nb.a)) {
            v3_1 = 0;
        } else {
            v3_1 = ((nb.a) v3_0);
        }
        if ((v3_1 == 0) || (!v3_1.n.equals(this))) {
            v3_1 = 0;
        }
        int v4_3 = 1;
        if (v3_1 != 0) {
            nb.k v6_0 = v3_1.i;
            if ((v6_0 != kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.k) && ((v9_3.h) || (v6_0 != kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.h))) {
                v3_1.m = 1;
                nb.k v6_1 = v3_1.g;
                if (p11 == null) {
                    v6_1.getClass();
                    boolean v9_2 = ((nb.g) nb.k.b.getAndSet(v6_1, v9_3));
                    if (v9_2) {
                        v9_3 = v6_1.a(v9_2);
                    } else {
                        v9_3 = 0;
                    }
                } else {
                    v9_3 = v6_1.a(v9_3);
                }
            }
        }
        if (v9_3) {
            boolean v9_4;
            if (!v9_3.h) {
                v9_4 = this.k.a(v9_3);
            } else {
                v9_4 = this.l.a(v9_3);
            }
            if (!v9_4) {
                throw new java.util.concurrent.RejectedExecutionException(r1.a.n(this.j, " was terminated", new StringBuilder()));
            }
        }
        if ((p11 == null) || (v3_1 == 0)) {
            v4_3 = 0;
        }
        if (v10_1 == null) {
            if ((v4_3 == 0) && ((!this.M()) && (!this.L(v0_1.get(this))))) {
                this.M();
                return;
            }
        } else {
            if ((v4_3 == 0) && ((!this.M()) && (!this.L(v1_0)))) {
                this.M();
                return;
            }
        }
        return;
    }

    public final String toString()
    {
        int v0_1 = new java.util.ArrayList();
        long v1_2 = this.m;
        int v2_0 = v1_2.a();
        int v3_0 = 0;
        int v5_0 = 0;
        int v6 = 0;
        int v7 = 0;
        int v8 = 0;
        int v9_0 = 1;
        while (v9_0 < v2_0) {
            String v10_15 = ((nb.a) v1_2.b(v9_0));
            if (v10_15 != null) {
                int v12_2;
                int v11_8 = v10_15.g;
                v11_8.getClass();
                if (nb.k.b.get(v11_8) == null) {
                    v12_2 = (nb.k.c.get(v11_8) - nb.k.d.get(v11_8));
                } else {
                    v12_2 = ((nb.k.c.get(v11_8) - nb.k.d.get(v11_8)) + 1);
                }
                String v10_1 = v10_15.i.ordinal();
                if (v10_1 == null) {
                    v3_0++;
                    String v10_3 = new StringBuilder();
                    v10_3.append(v12_2);
                    v10_3.append(99);
                    v0_1.add(v10_3.toString());
                } else {
                    if (v10_1 == 1) {
                        v5_0++;
                        String v10_6 = new StringBuilder();
                        v10_6.append(v12_2);
                        v10_6.append(98);
                        v0_1.add(v10_6.toString());
                    } else {
                        if (v10_1 == 2) {
                            v6++;
                        } else {
                            if (v10_1 == 3) {
                                v7++;
                                if (v12_2 > 0) {
                                    String v10_9 = new StringBuilder();
                                    v10_9.append(v12_2);
                                    v10_9.append(100);
                                    v0_1.add(v10_9.toString());
                                }
                            } else {
                                if (v10_1 != 4) {
                                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.s();
                                    return 0;
                                } else {
                                    v8++;
                                }
                            }
                        }
                    }
                }
            }
            v9_0++;
        }
        long v1_1 = nb.b.o.get(this);
        StringBuilder v4_1 = new StringBuilder();
        v4_1.append(this.j);
        v4_1.append(64);
        v4_1.append(gb.w.l(this));
        v4_1.append("[Pool Size {core = ");
        int v9_5 = this.g;
        v4_1.append(v9_5);
        v4_1.append(", max = ");
        v4_1.append(this.h);
        v4_1.append("}, Worker States {CPU = ");
        v4_1.append(v3_0);
        v4_1.append(", blocking = ");
        v4_1.append(v5_0);
        v4_1.append(", parked = ");
        v4_1.append(v6);
        v4_1.append(", dormant = ");
        v4_1.append(v7);
        v4_1.append(", terminated = ");
        v4_1.append(v8);
        v4_1.append("}, running workers queues = ");
        v4_1.append(v0_1);
        v4_1.append(", global CPU queue size = ");
        v4_1.append(this.k.c());
        v4_1.append(", global blocking queue size = ");
        v4_1.append(this.l.c());
        v4_1.append(", Control State {created workers= ");
        v4_1.append(((int) (2097151 & v1_1)));
        v4_1.append(", blocking tasks = ");
        v4_1.append(((int) ((4398044413952 & v1_1) >> 21)));
        v4_1.append(", CPUs acquired = ");
        v4_1.append((v9_5 - ((int) ((v1_1 & 9223367638808264704) >> 42))));
        v4_1.append("}]");
        return v4_1.toString();
    }
}
