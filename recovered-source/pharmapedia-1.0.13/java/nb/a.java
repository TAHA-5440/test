// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package nb;
public final class a extends java.lang.Thread {
    public static final synthetic java.util.concurrent.atomic.AtomicIntegerFieldUpdater o;
    public final nb.k g;
    public final kotlin.jvm.internal.Ref$ObjectRef h;
    public kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState i;
    private volatile int indexInArray;
    public long j;
    public long k;
    public int l;
    public boolean m;
    public final synthetic nb.b n;
    private volatile Object nextParkedWorker;
    private volatile synthetic int workerCtl$volatile;

    static a()
    {
        nb.a.o = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(nb.a, "workerCtl$volatile");
        return;
    }

    public a(nb.b p3, int p4)
    {
        this.n = p3;
        this.setDaemon(1);
        this.setContextClassLoader(nb.b.getClassLoader());
        this.g = new nb.k();
        this.h = new kotlin.jvm.internal.Ref$ObjectRef();
        this.i = kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.j;
        this.nextParkedWorker = nb.b.q;
        int v3_6 = ((int) System.nanoTime());
        if (v3_6 == 0) {
            v3_6 = 42;
        }
        this.l = v3_6;
        this.f(p4);
        return;
    }

    public final nb.g a(boolean p12)
    {
        nb.b v3 = this.n;
        nb.g v8 = 0;
        int v9 = 1;
        nb.k v10 = this.g;
        if (this.i != kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.g) {
            do {
                long v4 = nb.b.o.get(v3);
                if (((int) ((9223367638808264704 & v4) >> 42)) != 0) {
                } else {
                    v10.getClass();
                    do {
                        nb.g v12_1 = nb.k.b;
                        int v0_3 = ((nb.g) v12_1.get(v10));
                        if ((v0_3 == 0) || (v0_3.h != 1)) {
                            nb.g v12_3 = nb.k.d.get(v10);
                            int v0_5 = nb.k.c.get(v10);
                            while ((v12_3 != v0_5) && (nb.k.e.get(v10) != 0)) {
                                v0_5--;
                                nb.g v1_12 = v10.c(v0_5, 1);
                                if (v1_12 != null) {
                                    v8 = v1_12;
                                    break;
                                }
                            }
                        } else {
                            while (!v12_1.compareAndSet(v10, v0_3, 0)) {
                            }
                            v8 = v0_3;
                        }
                        if (v8 != null) {
                            return v8;
                        } else {
                            nb.g v12_6 = ((nb.g) v3.l.d());
                            if (v12_6 == null) {
                                v12_6 = this.i(1);
                            }
                            return v12_6;
                        }
                    } while(v12_1.get(v10) == v0_3);
                }
            } while(!nb.b.o.compareAndSet(v3, v4, (v4 - 4398046511104)));
            this.i = kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.g;
        }
        if (p12 == null) {
            nb.g v12_7 = this.e();
            if (v12_7 != null) {
                return v12_7;
            }
        } else {
            if (this.d((v3.g * 2)) != 0) {
                v9 = 0;
            }
            if (v9 != 0) {
                nb.g v12_11 = this.e();
                if (v12_11 != null) {
                    return v12_11;
                }
            }
            v10.getClass();
            nb.g v12_14 = ((nb.g) nb.k.b.getAndSet(v10, 0));
            if (v12_14 == null) {
                v12_14 = v10.b();
            }
            if (v12_14 == null) {
                if (v9 == 0) {
                    nb.g v12_15 = this.e();
                    if (v12_15 != null) {
                        return v12_15;
                    }
                }
            } else {
                return v12_14;
            }
        }
        return this.i(3);
    }

    public final int b()
    {
        return this.indexInArray;
    }

    public final Object c()
    {
        return this.nextParkedWorker;
    }

    public final int d(int p4)
    {
        int v0_0 = this.l;
        int v0_3 = (v0_0 ^ (v0_0 << 13));
        int v0_4 = (v0_3 ^ (v0_3 >> 17));
        int v0_5 = (v0_4 ^ (v0_4 << 5));
        this.l = v0_5;
        int v1_4 = (p4 - 1);
        if ((v1_4 & p4) != 0) {
            return ((v0_5 & 2147483647) % p4);
        } else {
            return (v0_5 & v1_4);
        }
    }

    public final nb.g e()
    {
        nb.e v1_0 = this.n;
        nb.e v2 = v1_0.l;
        nb.e v1_1 = v1_0.k;
        if (this.d(2) != 0) {
            nb.g v0_9 = ((nb.g) v2.d());
            if (v0_9 == null) {
                return ((nb.g) v1_1.d());
            } else {
                return v0_9;
            }
        } else {
            nb.g v0_4 = ((nb.g) v1_1.d());
            if (v0_4 == null) {
                return ((nb.g) v2.d());
            } else {
                return v0_4;
            }
        }
    }

    public final void f(int p3)
    {
        String v1_0;
        String v0_1 = new StringBuilder();
        v0_1.append(this.n.j);
        v0_1.append("-worker-");
        if (p3 != 0) {
            v1_0 = String.valueOf(p3);
        } else {
            v1_0 = "TERMINATED";
        }
        v0_1.append(v1_0);
        this.setName(v0_1.toString());
        this.indexInArray = p3;
        return;
    }

    public final void g(Object p1)
    {
        this.nextParkedWorker = p1;
        return;
    }

    public final boolean h(kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState p7)
    {
        int v1_1;
        kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState v0 = this.i;
        if (v0 != kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.g) {
            v1_1 = 0;
        } else {
            v1_1 = 1;
        }
        if (v1_1 != 0) {
            nb.b.o.addAndGet(this.n, 4398046511104);
        }
        if (v0 != p7) {
            this.i = p7;
        }
        return v1_1;
    }

    public final nb.g i(int p26)
    {
        nb.b v3 = this.n;
        int v2_1 = ((int) (nb.b.o.get(v3) & 2097151));
        int v4_0 = 0;
        if (v2_1 >= 2) {
            int v6_0 = this.d(v2_1);
            int v10 = 0;
            long v11 = 9223372036854775807;
            while (v10 < v2_1) {
                v6_0++;
                if (v6_0 > v2_1) {
                    v6_0 = 1;
                }
                long v5_5 = ((nb.a) v3.m.b(v6_0));
                if ((v5_5 != 0) && (v5_5 != this)) {
                    long v18_1;
                    long v7_4;
                    long v5_1 = v5_5.g;
                    if (p26 != 3) {
                        int v9;
                        v5_1.getClass();
                        long v7_3 = nb.k.d.get(v5_1);
                        boolean v8_1 = nb.k.c.get(v5_1);
                        if (p26 != 1) {
                            v9 = 0;
                        } else {
                            v9 = 1;
                        }
                        while (v7_3 != v8_1) {
                            v18_1 = 0;
                            if ((v9 == 0) || (nb.k.e.get(v5_1) != 0)) {
                                int v13_2 = (v7_3 + 1);
                                v7_4 = v5_1.c(v7_3, v9);
                                if (v7_4 != 0) {
                                    long v5_2;
                                    long v20;
                                    long v7_0;
                                    int v13_3 = this.h;
                                    if (v7_4 == 0) {
                                        while(true) {
                                            long v7_5 = nb.k.b;
                                            nb.g v14_1 = ((nb.g) v7_5.get(v5_1));
                                            if (v14_1 != null) {
                                                boolean v8_3;
                                                v20 = -1;
                                                if (!v14_1.h) {
                                                    v8_3 = 2;
                                                } else {
                                                    v8_3 = 1;
                                                }
                                                if ((v8_3 & p26) != 0) {
                                                    nb.i.f.getClass();
                                                    long v23 = v5_1;
                                                    boolean v8_7 = (System.nanoTime() - v14_1.g);
                                                    int v4_6 = nb.i.b;
                                                    if (v8_7 >= v4_6) {
                                                        int v4_7 = v23;
                                                        do {
                                                            v5_2 = 0;
                                                            if (!v7_5.compareAndSet(v4_7, v14_1, 0)) {
                                                            } else {
                                                                v13_3.g = v14_1;
                                                                v7_0 = -1;
                                                                if (v7_0 != v20) {
                                                                    if (v7_0 > v18_1) {
                                                                        v11 = Math.min(v11, v7_0);
                                                                    }
                                                                } else {
                                                                    nb.g v1_2 = ((nb.g) v13_3.g);
                                                                    v13_3.g = v5_2;
                                                                    return v1_2;
                                                                }
                                                                v10++;
                                                                v4_0 = 0;
                                                            }
                                                        } while(v7_5.get(v4_7) == v14_1);
                                                    } else {
                                                        v7_0 = (v4_6 - v8_7);
                                                        v5_2 = 0;
                                                    }
                                                }
                                            } else {
                                                v20 = -1;
                                            }
                                            v7_0 = -2;
                                            v5_2 = v4_0;
                                        }
                                        v5_1 = v4_7;
                                        v4_0 = 0;
                                    } else {
                                        v13_3.g = v7_4;
                                        v5_2 = v4_0;
                                        v7_0 = -1;
                                        v20 = -1;
                                    }
                                } else {
                                    v7_3 = v13_2;
                                }
                            }
                            v7_4 = v4_0;
                        }
                        v18_1 = 0;
                    } else {
                        v7_4 = v5_1.b();
                        v18_1 = 0;
                    }
                }
            }
            if (v11 == 9223372036854775807) {
                v11 = 0;
            }
            this.k = v11;
            return 0;
        } else {
            return 0;
        }
    }

    public final void run()
    {
        while(true) {
            Throwable v0_2 = 0;
            if (nb.b.p.get(this.n) == 0) {
                java.util.concurrent.atomic.AtomicLongFieldUpdater v4_5 = kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.k;
                if (this.i != v4_5) {
                    lb.n v3_4 = this.a(this.m);
                    if (v3_4 == null) {
                        this.m = 0;
                        if (this.k == 0) {
                            int v9_3 = nb.b.q;
                            if (this.nextParkedWorker == v9_3) {
                                lb.n v3_11 = this.n;
                                if (this.nextParkedWorker != v9_3) {
                                    while (nb.b.p.get(this.n) == 0) {
                                    }
                                    this.h(kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.k);
                                    return;
                                }
                                while(true) {
                                    long v19 = nb.b.n.get(v3_11);
                                    long v8_2 = ((v19 + 2097152) & -2097152);
                                    lb.n v10_0 = this.indexInArray;
                                    this.nextParkedWorker = v3_11.m.b(((int) (v19 & 2097151)));
                                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater v18 = v3_11;
                                    if (nb.b.n.compareAndSet(v18, v19, (v8_2 | ((long) v10_0)))) {
                                        break;
                                    }
                                    v3_11 = v18;
                                }
                            } else {
                                nb.a.o.set(this, -1);
                                while (this.nextParkedWorker != nb.b.q) {
                                    lb.n v3_16 = nb.a.o;
                                    if (v3_16.get(this) != -1) {
                                        break;
                                    }
                                    int v9_4 = nb.b.p;
                                    if (v9_4.get(this.n) != 0) {
                                        break;
                                    }
                                    kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState v12 = kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.k;
                                    if (this.i == v12) {
                                        break;
                                    }
                                    long v15_1;
                                    this.h(kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.i);
                                    Thread.interrupted();
                                    if (this.j != 0) {
                                        v15_1 = 2097151;
                                    } else {
                                        v15_1 = 2097151;
                                        this.j = (System.nanoTime() + this.n.i);
                                    }
                                    java.util.concurrent.locks.LockSupport.parkNanos(this.n.i);
                                    if ((System.nanoTime() - this.j) >= 0) {
                                        this.j = 0;
                                        int v6_11 = this.n;
                                        int v9_6;
                                        if (v9_4.get(v6_11) == 0) {
                                            v9_6 = 0;
                                        } else {
                                            v9_6 = 1;
                                        }
                                        if (v9_6 == 0) {
                                            int v9_0 = nb.b.o;
                                            if ((((int) (v9_0.get(v6_11) & v15_1)) > v6_11.g) && (v3_16.compareAndSet(this, -1, 1))) {
                                                lb.n v3_2 = this.indexInArray;
                                                this.f(0);
                                                v6_11.B(this, v3_2, 0);
                                                int v9_1 = ((int) (v9_0.getAndDecrement(v6_11) & v15_1));
                                                if (v9_1 != v3_2) {
                                                    nb.a v11_2 = v6_11.m.b(v9_1);
                                                    v11_2.getClass();
                                                    nb.a v11_3 = ((nb.a) v11_2);
                                                    v6_11.m.c(v3_2, v11_3);
                                                    v11_3.f(v3_2);
                                                    v6_11.B(v11_3, v9_1, v3_2);
                                                }
                                                v6_11.m.c(v9_1, 0);
                                                this.i = v12;
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            if (v0_2 != null) {
                                break;
                            }
                            v0_2 = 1;
                        }
                    } else {
                        this.k = 0;
                        int v9_2 = this.n;
                        this.j = 0;
                        if (this.i == kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.i) {
                            this.i = kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.h;
                        }
                        if (!v3_4.h) {
                            try {
                                v3_4.run();
                            } catch (Throwable v0_6) {
                                lb.n v3_6 = Thread.currentThread();
                                v3_6.getUncaughtExceptionHandler().uncaughtException(v3_6, v0_6);
                            }
                        } else {
                            if ((this.h(kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.h)) && ((!v9_2.M()) && (!v9_2.L(nb.b.o.get(v9_2))))) {
                                v9_2.M();
                            }
                            try {
                                v3_4.run();
                            } catch (Throwable v0_12) {
                                lb.n v3_7 = Thread.currentThread();
                                v3_7.getUncaughtExceptionHandler().uncaughtException(v3_7, v0_12);
                            }
                            nb.b.o.addAndGet(v9_2, -2097152);
                            if (this.i != v4_5) {
                                this.i = kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.j;
                            }
                        }
                    }
                }
            }
            this.h(kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.k);
            return;
        }
        this.h(kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.i);
        Thread.interrupted();
        java.util.concurrent.locks.LockSupport.parkNanos(this.k);
        this.k = 0;
    }
}
