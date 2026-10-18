// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.sync;
public final class a extends kotlinx.coroutines.sync.b implements ob.a {
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater n;
    private volatile synthetic Object owner$volatile;

    static a()
    {
        kotlinx.coroutines.sync.a.n = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.sync.a, Object, "owner$volatile");
        return;
    }

    public a()
    {
        super(1);
        super.owner$volatile = ob.c.a;
        return;
    }

    public final boolean c()
    {
        do {
            int v0_0 = kotlinx.coroutines.sync.b.m;
            int v1_2 = v0_0.get(this);
            int v2_0 = this.g;
            if (v1_2 <= v2_0) {
                if (v1_2 > 0) {
                    if (!v0_0.compareAndSet(this, v1_2, (v1_2 - 1))) {
                        break;
                    }
                    kotlinx.coroutines.sync.a.n.set(this, 0);
                    return 1;
                } else {
                    return 0;
                }
            }
            do {
                int v1_1 = v0_0.get(this);
            } while((v1_1 > v2_0) && (!v0_0.compareAndSet(this, v1_1, v2_0)));
        } while((v1_1 <= v2_0) && (!v0_0.compareAndSet(this, v1_1, v2_0)));
    }

    public final boolean d()
    {
        if (Math.max(kotlinx.coroutines.sync.b.m.get(this), 0) != 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final void h(Object p5)
    {
        while (this.d()) {
            IllegalStateException v0_5 = kotlinx.coroutines.sync.a.n;
            String v1_1 = v0_5.get(this);
            String v2_1 = ob.c.a;
            if (v1_1 != v2_1) {
                if ((v1_1 != p5) && (p5 != null)) {
                    IllegalStateException v0_2 = new StringBuilder("This mutex is locked by ");
                    v0_2.append(v1_1);
                    v0_2.append(", but ");
                    v0_2.append(p5);
                    v0_2.append(" is expected");
                    throw new IllegalStateException(v0_2.toString().toString());
                }
                while (!v0_5.compareAndSet(this, v1_1, v2_1)) {
                    if (v0_5.get(this) != v1_1) {
                    }
                }
                this.b();
                return;
            }
        }
        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("This mutex is not locked");
        return;
    }

    public final Object i(kotlin.coroutines.jvm.internal.ContinuationImpl p7)
    {
        ga.p v1 = ga.p.a;
        if (!this.c()) {
            ga.p v7_3 = gb.w.m(a.a.n(p7));
            try {
                kotlin.coroutines.intrinsics.CoroutineSingletons v0_5 = new ob.b(this, v7_3);
            } catch (kotlin.coroutines.intrinsics.CoroutineSingletons v0_2) {
                v7_3.z();
                throw v0_2;
            }
            do {
                boolean v2_1 = kotlinx.coroutines.sync.b.m.getAndDecrement(this);
                if (v2_1 <= this.g) {
                    if (v2_1) {
                    } else {
                        gb.g v3_1 = v0_5.h;
                        kotlinx.coroutines.sync.a.n.set(v3_1, 0);
                        boolean v2_4 = v0_5.g;
                        v2_4.A(v1, v2_4.i, new gb.g(new ac.c(v3_1, v0_5), 0));
                        break;
                    }
                }
            } while(!this.a(v0_5));
            ga.p v7_1 = v7_3.r();
            kotlin.coroutines.intrinsics.CoroutineSingletons v0_3 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
            if (v7_1 != v0_3) {
                v7_1 = v1;
            }
            if (v7_1 == v0_3) {
                return v7_1;
            }
        }
        return v1;
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder("Mutex@");
        v0_1.append(gb.w.l(this));
        v0_1.append("[isLocked=");
        v0_1.append(this.d());
        v0_1.append(",owner=");
        v0_1.append(kotlinx.coroutines.sync.a.n.get(this));
        v0_1.append(93);
        return v0_1.toString();
    }
}
