// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ka;
public final class h implements ka.c, ma.b {
    public static final java.util.concurrent.atomic.AtomicReferenceFieldUpdater h;
    public final ka.c g;
    private volatile Object result;

    static h()
    {
        ka.h.h = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(ka.h, Object, "result");
        return;
    }

    public h(ka.c p2)
    {
        this.g = p2;
        this.result = kotlin.coroutines.intrinsics.CoroutineSingletons.h;
        return;
    }

    public final Object b()
    {
        Object v0_0 = this.result;
        boolean v1_0 = kotlin.coroutines.intrinsics.CoroutineSingletons.h;
        if (v0_0 == v1_0) {
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater v2 = ka.h.h;
            while (!v2.compareAndSet(this, v1_0, kotlin.coroutines.intrinsics.CoroutineSingletons.g)) {
                if (v2.get(this) != v1_0) {
                    v0_0 = this.result;
                }
            }
            return kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        }
        if (v0_0 != kotlin.coroutines.intrinsics.CoroutineSingletons.i) {
            if ((v0_0 instanceof kotlin.Result$Failure)) {
                throw ((kotlin.Result$Failure) v0_0).g;
            } else {
                return v0_0;
            }
        } else {
            return kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        }
    }

    public final ma.b getCallerFrame()
    {
        int v0_0 = this.g;
        if (!(v0_0 instanceof ma.b)) {
            return 0;
        } else {
            return ((ma.b) v0_0);
        }
    }

    public final ka.g getContext()
    {
        return this.g.getContext();
    }

    public final void resumeWith(Object p5)
    {
        do {
            ka.c v0_0 = this.result;
            kotlin.coroutines.intrinsics.CoroutineSingletons v1_0 = kotlin.coroutines.intrinsics.CoroutineSingletons.h;
            if (v0_0 != v1_0) {
                kotlin.coroutines.intrinsics.CoroutineSingletons v1_1 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
                if (v0_0 != v1_1) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Already resumed");
                    return;
                } else {
                    ka.c v0_4 = ka.h.h;
                    while (!v0_4.compareAndSet(this, v1_1, kotlin.coroutines.intrinsics.CoroutineSingletons.i)) {
                        if (v0_4.get(this) != v1_1) {
                        }
                    }
                    this.g.resumeWith(p5);
                    return;
                }
            } else {
                kotlin.coroutines.intrinsics.CoroutineSingletons v2_0 = ka.h.h;
                while (!v2_0.compareAndSet(this, v1_0, p5)) {
                }
                return;
            }
        } while(v2_0.get(this) == v1_0);
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder("SafeContinuation for ");
        v0_1.append(this.g);
        return v0_1.toString();
    }
}
