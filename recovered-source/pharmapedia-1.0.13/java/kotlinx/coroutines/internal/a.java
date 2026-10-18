// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.internal;
public class a {
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater g;
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater h;
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater i;
    private volatile synthetic Object _next$volatile;
    private volatile synthetic Object _prev$volatile;
    private volatile synthetic Object _removedRef$volatile;

    static a()
    {
        kotlinx.coroutines.internal.a.g = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.a, Object, "_next$volatile");
        kotlinx.coroutines.internal.a.h = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.a, Object, "_prev$volatile");
        kotlinx.coroutines.internal.a.i = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.a, Object, "_removedRef$volatile");
        return;
    }

    public a()
    {
        this._next$volatile = this;
        this._prev$volatile = this;
        return;
    }

    public final boolean c(kotlinx.coroutines.internal.a p5, int p6)
    {
        do {
            kotlinx.coroutines.internal.a v0_0 = this.f();
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater v1_1 = kotlinx.coroutines.internal.a.h;
            if (v0_0 == null) {
                v0_0 = ((kotlinx.coroutines.internal.a) v1_1.get(this));
                while (v0_0.i()) {
                    v0_0 = ((kotlinx.coroutines.internal.a) v1_1.get(v0_0));
                }
            }
            if (!(v0_0 instanceof lb.g)) {
                v1_1.set(p5, v0_0);
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater v1_0 = kotlinx.coroutines.internal.a.g;
                v1_0.set(p5, this);
                while (!v1_0.compareAndSet(v0_0, this, p5)) {
                }
                p5.g(this);
                return 1;
            } else {
                if (((((lb.g) v0_0).j & p6) != 0) || (!v0_0.c(p5, p6))) {
                    return 0;
                } else {
                    return 1;
                }
            }
        } while(v1_0.get(v0_0) == this);
    }

    public final kotlinx.coroutines.internal.a f()
    {
        do {
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater v0 = kotlinx.coroutines.internal.a.h;
            kotlinx.coroutines.internal.a v1_1 = ((kotlinx.coroutines.internal.a) v0.get(this));
            kotlinx.coroutines.internal.a v3_0 = v1_1;
            kotlinx.coroutines.internal.a v4_2 = 0;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater v5 = kotlinx.coroutines.internal.a.g;
            kotlinx.coroutines.internal.a v6_2 = v5.get(v3_0);
            if (v6_2 != this) {
                if (!this.i()) {
                    if (!(v6_2 instanceof lb.m)) {
                        v6_2.getClass();
                        v4_2 = v3_0;
                        v3_0 = ((kotlinx.coroutines.internal.a) v6_2);
                        while(true) {
                            v3_0 = ((kotlinx.coroutines.internal.a) v0.get(v3_0));
                        }
                    } else {
                        if (v4_2 == null) {
                        }
                    }
                } else {
                    return 0;
                }
            } else {
                if (v1_1 != v3_0) {
                }
                return v3_0;
            }
            while (!v5.compareAndSet(v4_2, v3_0, ((lb.m) v6_2).a)) {
                if (v5.get(v4_2) != v3_0) {
                }
            }
            v3_0 = v4_2;
            do {
            } while(v5.get(v4_2) != v3_0);
        } while(!v0.compareAndSet(this, v1_1, v3_0));
        if (v0.get(this) != v1_1) {
        } else {
            while (!v0.compareAndSet(this, v1_1, v3_0)) {
            }
        }
        return v3_0;
    }

    public final void g(kotlinx.coroutines.internal.a p4)
    {
        do {
            boolean v0_0 = kotlinx.coroutines.internal.a.h;
            kotlinx.coroutines.internal.a v1_1 = ((kotlinx.coroutines.internal.a) v0_0.get(p4));
            if (kotlinx.coroutines.internal.a.g.get(this) != p4) {
                break;
            }
            while (!v0_0.compareAndSet(p4, v1_1, this)) {
                if (v0_0.get(p4) != v1_1) {
                }
                return;
            }
        } while(!this.i());
        return;
    }

    public final kotlinx.coroutines.internal.a h()
    {
        int v1_1;
        kotlinx.coroutines.internal.a v0_3 = kotlinx.coroutines.internal.a.g.get(this);
        if (!(v0_3 instanceof lb.m)) {
            v1_1 = 0;
        } else {
            v1_1 = ((lb.m) v0_3);
        }
        if (v1_1 == 0) {
            v0_3.getClass();
            return ((kotlinx.coroutines.internal.a) v0_3);
        } else {
            return v1_1.a;
        }
    }

    public boolean i()
    {
        return (kotlinx.coroutines.internal.a.g.get(this) instanceof lb.m);
    }

    public String toString()
    {
        String v0_1 = new StringBuilder();
        v0_1.append(new kotlinx.coroutines.internal.LockFreeLinkedListNode$toString$1(this, gb.w, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1));
        v0_1.append(64);
        v0_1.append(gb.w.l(this));
        return v0_1.toString();
    }
}
