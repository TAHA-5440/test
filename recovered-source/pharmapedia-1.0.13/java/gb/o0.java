// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public abstract class o0 extends gb.j0 implements gb.a0 {
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater m;
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater n;
    public static final synthetic java.util.concurrent.atomic.AtomicIntegerFieldUpdater o;
    private volatile synthetic Object _delayed$volatile;
    private volatile synthetic int _isCompleted$volatile;
    private volatile synthetic Object _queue$volatile;

    static o0()
    {
        gb.o0.m = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(gb.o0, Object, "_queue$volatile");
        gb.o0.n = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(gb.o0, Object, "_delayed$volatile");
        gb.o0.o = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(gb.o0, "_isCompleted$volatile");
        return;
    }

    public o0()
    {
        this._isCompleted$volatile = 0;
        return;
    }

    public gb.g0 M(long p2, gb.j1 p4, ka.g p5)
    {
        return gb.y.a.M(p2, p4, p5);
    }

    public final void c0(long p4, gb.h p6)
    {
        long v0_0 = 0;
        if (p4 > 0) {
            if (p4 < 9223372036854) {
                v0_0 = (1000000 * p4);
            } else {
                v0_0 = 9223372036854775807;
            }
        }
        if (v0_0 < 4611686018427387903) {
            gb.e v4_2 = System.nanoTime();
            gb.k0 v2_2 = new gb.k0(this, (v0_0 + v4_2), p6);
            this.s0(v4_2, v2_2);
            p6.v(new gb.e(v2_2, 2));
        }
        return;
    }

    public final void d0(ka.g p1, Runnable p2)
    {
        this.m0(p2);
        return;
    }

    public final long k0()
    {
        long v0_0 = gb.w.c;
        Throwable v1_0 = gb.o0.m;
        if (!this.l0()) {
            this.n0();
            while(true) {
                Runnable v7_1;
                long v2_7 = v1_0.get(this);
                long v5_2 = 0;
                if (v2_7 != 0) {
                    if ((v2_7 instanceof lb.j)) {
                        break;
                    }
                    if (v2_7 == v0_0) {
                        v7_1 = 0;
                        if (v7_1 == null) {
                            int v8_1;
                            long v2_1 = this.k;
                            if ((v2_1 != 0) && (!v2_1.isEmpty())) {
                                v8_1 = 0;
                            } else {
                                v8_1 = 9223372036854775807;
                            }
                            if (v8_1 != 0) {
                                Throwable v1_1 = v1_0.get(this);
                                if (v1_1 == null) {
                                    long v0_8 = ((gb.n0) gb.o0.n.get(this));
                                    if (v0_8 != 0) {
                                        try {
                                            Throwable v1_3 = v0_8.a;
                                        } catch (Throwable v1_4) {
                                            throw v1_4;
                                        }
                                        if (v1_3 != null) {
                                            v5_2 = v1_3[0];
                                        }
                                        if (v5_2 != 0) {
                                            long v0_10 = (v5_2.g - System.nanoTime());
                                            if (v0_10 >= 0) {
                                                return v0_10;
                                            } else {
                                                return 0;
                                            }
                                        }
                                    }
                                } else {
                                    if (!(v1_1 instanceof lb.j)) {
                                        if (v1_1 != v0_0) {
                                            return 0;
                                        }
                                    } else {
                                        long v0_2 = lb.j.f.get(((lb.j) v1_1));
                                        if (((int) (1073741823 & v0_2)) != ((int) ((v0_2 & 1152921503533105152) >> 30))) {
                                            return 0;
                                        }
                                    }
                                }
                                return 9223372036854775807;
                            }
                        } else {
                            v7_1.run();
                            return 0;
                        }
                        return 0;
                    }
                    while (!v1_0.compareAndSet(this, v2_7, 0)) {
                        if (v1_0.get(this) != v2_7) {
                        }
                    }
                    v7_1 = ((Runnable) v2_7);
                }
            }
            Object v6_4 = ((lb.j) v2_7);
            Runnable v7_2 = v6_4.d();
            if (v7_2 == lb.j.g) {
                Object v6_5 = v6_4.c();
                while (!v1_0.compareAndSet(this, v2_7, v6_5)) {
                    if (v1_0.get(this) != v2_7) {
                        break;
                    }
                }
            } else {
                v7_1 = ((Runnable) v7_2);
            }
        }
        return 0;
    }

    public void m0(Runnable p2)
    {
        this.n0();
        if (!this.o0(p2)) {
            gb.x.p.m0(p2);
            return;
        } else {
            Thread v2_1 = this.p0();
            if (Thread.currentThread() != v2_1) {
                java.util.concurrent.locks.LockSupport.unpark(v2_1);
            }
            return;
        }
    }

    public final void n0()
    {
        gb.n0 v0_2 = ((gb.n0) gb.o0.n.get(this));
        if (v0_2 != null) {
            if (lb.u.b.get(v0_2) != 0) {
                Throwable v1_0 = System.nanoTime();
                do {
                    int v3_1;
                    int v3_0 = v0_2.a;
                    gb.m0 v4 = 0;
                    if (v3_0 == 0) {
                        v3_1 = 0;
                    } else {
                        v3_1 = v3_0[0];
                    }
                    if (v3_1 != 0) {
                        int v3_2;
                        if ((v1_0 - v3_1.g) < 0) {
                            v3_2 = 0;
                        } else {
                            v3_2 = this.o0(v3_1);
                        }
                        if (v3_2 != 0) {
                            v4 = v0_2.b(0);
                        }
                    }
                } while(v4 != null);
            } else {
                return;
            }
        }
        return;
    }

    public final boolean o0(Runnable p7)
    {
        do {
            int v0_0 = gb.o0.m;
            Object v1_0 = v0_0.get(this);
            if (gb.o0.o.get(this) == 0) {
                if (v1_0 != null) {
                    if (!(v1_0 instanceof lb.j)) {
                        if (v1_0 != gb.w.c) {
                            lb.j v3_1 = new lb.j(8, 1);
                            v3_1.a(((Runnable) v1_0));
                            v3_1.a(p7);
                            while (!v0_0.compareAndSet(this, v1_0, v3_1)) {
                                if (v0_0.get(this) != v1_0) {
                                }
                            }
                            return 1;
                        }
                    } else {
                        Object v4_8 = ((lb.j) v1_0);
                        int v5 = v4_8.a(p7);
                        if (v5 == 0) {
                            return 1;
                        } else {
                            if (v5 == 1) {
                                lb.j v3_2 = v4_8.c();
                                while (!v0_0.compareAndSet(this, v1_0, v3_2)) {
                                    if (v0_0.get(this) != v1_0) {
                                        break;
                                    }
                                }
                            } else {
                                if (v5 != 2) {
                                }
                            }
                        }
                    }
                    return 0;
                } else {
                }
                return 1;
            } else {
                return 0;
            }
        } while(!v0_0.compareAndSet(this, 0, p7));
        if (v0_0.get(this) != null) {
        } else {
            while (!v0_0.compareAndSet(this, 0, p7)) {
            }
        }
        return 1;
    }

    public abstract Thread p0();

    public final boolean q0()
    {
        int v0_8;
        int v0_0 = this.k;
        if (v0_0 == 0) {
            v0_8 = 1;
        } else {
            v0_8 = v0_0.isEmpty();
        }
        if (v0_8 != 0) {
            int v0_2 = ((gb.n0) gb.o0.n.get(this));
            if (v0_2 != 0) {
                int v0_4;
                if (lb.u.b.get(v0_2) != 0) {
                    v0_4 = 0;
                } else {
                    v0_4 = 1;
                }
                if (v0_4 == 0) {
                    return 0;
                }
            }
            int v0_6 = gb.o0.m.get(this);
            if (v0_6 != 0) {
                if (!(v0_6 instanceof lb.j)) {
                    if (v0_6 != gb.w.c) {
                        return 0;
                    }
                } else {
                    com.google.gson.internal.b v3_4 = lb.j.f.get(((lb.j) v0_6));
                    if (((int) (1073741823 & v3_4)) != ((int) ((v3_4 & 1152921503533105152) >> 30))) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            }
            return 1;
        }
        return 0;
    }

    public void r0(long p2, gb.m0 p4)
    {
        gb.x.p.s0(p2, p4);
        return;
    }

    public final void s0(long p6, gb.m0 p8)
    {
        gb.n0 v1_5;
        int v0_0 = gb.o0.n;
        Throwable v2 = 0;
        if (gb.o0.o.get(this) == 0) {
            gb.n0 v1_4 = ((gb.n0) v0_0.get(this));
            if (v1_4 == null) {
                gb.n0 v4_1 = new gb.n0();
                v4_1.c = p6;
                while (!v0_0.compareAndSet(this, 0, v4_1)) {
                    if (v0_0.get(this) != null) {
                        break;
                    }
                }
                gb.n0 v1_3 = v0_0.get(this);
                v1_3.getClass();
                v1_4 = ((gb.n0) v1_3);
            }
            v1_5 = p8.c(p6, v1_4, this);
        } else {
            v1_5 = 1;
        }
        if (v1_5 == null) {
            Thread v6_2 = ((gb.n0) v0_0.get(this));
            if (v6_2 != null) {
                try {
                    Throwable v7_0 = v6_2.a;
                } catch (Throwable v7_1) {
                    throw v7_1;
                }
                if (v7_0 != null) {
                    v2 = v7_0[0];
                }
            }
            if (v2 == p8) {
                Thread v6_3 = this.p0();
                if (Thread.currentThread() != v6_3) {
                    java.util.concurrent.locks.LockSupport.unpark(v6_3);
                }
            }
        } else {
            if (v1_5 == 1) {
                this.r0(p6, p8);
                return;
            } else {
                if (v1_5 != 2) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("unexpected result");
                    return;
                }
            }
        }
        return;
    }

    public void shutdown()
    {
        gb.g1.a.set(0);
        gb.o0.o.set(this, 1);
        gb.n0 v0_6 = gb.w.c;
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater v3 = gb.o0.m;
        do {
            Throwable v4_8 = v3.get(this);
            if (v4_8 != null) {
                if (!(v4_8 instanceof lb.j)) {
                    if (v4_8 != v0_6) {
                        lb.j v5_2 = new lb.j(8, 1);
                        v5_2.a(((Runnable) v4_8));
                        while (!v3.compareAndSet(this, v4_8, v5_2)) {
                            if (v3.get(this) != v4_8) {
                            }
                        }
                    }
                } else {
                    ((lb.j) v4_8).b();
                }
            } else {
                while (!v3.compareAndSet(this, 0, v0_6)) {
                }
            }
            while (this.k0() <= 0) {
            }
            long v2_2 = System.nanoTime();
            while(true) {
                gb.n0 v0_5 = ((gb.n0) gb.o0.n.get(this));
                if (v0_5 == null) {
                    break;
                }
                try {
                    Throwable v4_6;
                    if (lb.u.b.get(v0_5) <= 0) {
                        v4_6 = 0;
                    } else {
                        v4_6 = v0_5.b(0);
                    }
                    if (v4_6 == null) {
                        break;
                    }
                    this.r0(v2_2, v4_6);
                } catch (Throwable v1_1) {
                    throw v1_1;
                }
            }
            return;
        } while(v3.get(this) == null);
    }
}
