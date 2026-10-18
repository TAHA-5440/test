// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.sync;
public class b {
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater i;
    public static final synthetic java.util.concurrent.atomic.AtomicLongFieldUpdater j;
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater k;
    public static final synthetic java.util.concurrent.atomic.AtomicLongFieldUpdater l;
    public static final synthetic java.util.concurrent.atomic.AtomicIntegerFieldUpdater m;
    private volatile synthetic int _availablePermits$volatile;
    private volatile synthetic long deqIdx$volatile;
    private volatile synthetic long enqIdx$volatile;
    public final int g;
    public final gb.g h;
    private volatile synthetic Object head$volatile;
    private volatile synthetic Object tail$volatile;

    static b()
    {
        kotlinx.coroutines.sync.b.i = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.sync.b, Object, "head$volatile");
        kotlinx.coroutines.sync.b.j = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.sync.b, "deqIdx$volatile");
        kotlinx.coroutines.sync.b.k = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.sync.b, Object, "tail$volatile");
        kotlinx.coroutines.sync.b.l = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.sync.b, "enqIdx$volatile");
        kotlinx.coroutines.sync.b.m = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.sync.b, "_availablePermits$volatile");
        return;
    }

    public b(int p6)
    {
        this.g = p6;
        if (p6 <= 0) {
            oc.l.d(r1.a.g(p6, "Semaphore should have at least 1 permit, but had "));
            throw 0;
        } else {
            if (p6 < 0) {
                oc.l.d(r1.a.g(p6, "The number of acquired permits should be in 0.."));
                throw 0;
            } else {
                String v0_2 = new ob.f(0, 0, 2);
                this.head$volatile = v0_2;
                this.tail$volatile = v0_2;
                this._availablePermits$volatile = p6;
                this.h = new gb.g(this, 2);
                return;
            }
        }
    }

    public final boolean a(gb.n1 p15)
    {
        Object v0_0 = kotlinx.coroutines.sync.b.k;
        gb.g v1_1 = ((ob.f) v0_0.get(this));
        int v2_3 = kotlinx.coroutines.sync.b.l.getAndIncrement(this);
        com.google.gson.internal.b v5_0 = (v2_3 / ((long) ob.e.f));
        do {
            Object v7 = lb.a.b(v1_1, v5_0, kotlinx.coroutines.sync.SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1.g);
            if (!lb.a.e(v7)) {
                lb.p v8_1 = lb.a.c(v7);
                do {
                    boolean v9_1 = ((lb.p) v0_0.get(this));
                    if (v9_1.c >= v8_1.c) {
                        break;
                    }
                    if (!v8_1.i()) {
                    }
                    while (!v0_0.compareAndSet(this, v9_1, v8_1)) {
                        if (v0_0.get(this) != v9_1) {
                            if (v8_1.e()) {
                                v8_1.d();
                            }
                        }
                    }
                } while(!v9_1.e());
            }
            Object v0_3 = ((ob.f) lb.a.c(v7));
            gb.g v1_2 = v0_3.e;
            int v2_2 = ((int) (v2_3 % ((long) ob.e.f)));
            while (!v1_2.compareAndSet(v2_2, 0, p15)) {
                if (v1_2.get(v2_2) != null) {
                    com.google.gson.internal.b v3_3 = ob.e.b;
                    while (!v1_2.compareAndSet(v2_2, v3_3, ob.e.c)) {
                        if (v1_2.get(v2_2) != v3_3) {
                            return 0;
                        }
                    }
                    ((gb.f) p15).a(ga.p.a, this.h);
                    return 1;
                }
            }
            p15.b(v0_3, v2_2);
            return 1;
        } while(!v8_1.i());
    }

    public final void b()
    {
        do {
            String v0_0 = kotlinx.coroutines.sync.b.m;
            gb.g v1_4 = v0_0.getAndIncrement(this);
            Object v2_4 = this.g;
            if (v1_4 < v2_4) {
                if (v1_4 >= null) {
                    break;
                }
                String v0_3 = kotlinx.coroutines.sync.b.i;
                gb.g v1_6 = ((ob.f) v0_3.get(this));
                Object v2_3 = kotlinx.coroutines.sync.b.j.getAndIncrement(this);
                int v4_3 = (v2_3 / ((long) ob.e.f));
                do {
                    com.google.gson.internal.b v7_1 = lb.a.b(v1_6, v4_3, kotlinx.coroutines.sync.SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1.g);
                    if (!lb.a.e(v7_1)) {
                        lb.p v8_1 = lb.a.c(v7_1);
                        do {
                            boolean v9_1 = ((lb.p) v0_3.get(this));
                            if (v9_1.c < v8_1.c) {
                                if (!v8_1.i()) {
                                }
                                while (!v0_3.compareAndSet(this, v9_1, v8_1)) {
                                    if (v0_3.get(this) != v9_1) {
                                    }
                                }
                                if (v9_1.e()) {
                                    v9_1.d();
                                }
                            }
                        } while(!v8_1.e());
                        v8_1.d();
                    }
                    String v0_6 = ((ob.f) lb.a.c(v7_1));
                    gb.g v1_8 = v0_6.e;
                    v0_6.a();
                    int v4_0 = 0;
                    if (v0_6.c <= v4_3) {
                        String v0_9 = ((int) (v2_3 % ((long) ob.e.f)));
                        Object v2_7 = v1_8.getAndSet(v0_9, ob.e.b);
                        if (v2_7 != null) {
                            if (v2_7 != ob.e.e) {
                                if (!(v2_7 instanceof gb.f)) {
                                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(v2_7, "unexpected: ");
                                    return;
                                } else {
                                    Object v2_8 = ((gb.f) v2_7);
                                    String v0_14 = v2_8.f(ga.p.a, this.h);
                                    if (v0_14 == null) {
                                        if (v4_0 != 0) {
                                        }
                                        return;
                                    } else {
                                        v2_8.j(v0_14);
                                    }
                                }
                            }
                        } else {
                            int v5_1 = 0;
                            while (v5_1 < ob.e.a) {
                                if (v1_8.get(v0_9) != ob.e.c) {
                                    v5_1++;
                                }
                            }
                            int v5_0 = ob.e.b;
                            while (!v1_8.compareAndSet(v0_9, v5_0, ob.e.d)) {
                                if (v1_8.get(v0_9) != v5_0) {
                                }
                                v4_0 ^= 1;
                            }
                            v4_0 = 1;
                        }
                        v4_0 = 1;
                    }
                } while(!v8_1.i());
            }
            do {
                gb.g v1_7 = v0_0.get(this);
            } while((v1_7 <= v2_4) || (v0_0.compareAndSet(this, v1_7, v2_4)));
            gb.g v1_1 = new StringBuilder("The number of released permits cannot be greater than ");
            v1_1.append(v2_4);
            throw new IllegalStateException(v1_1.toString().toString());
        } while(v4_0 != 0);
        return;
    }
}
