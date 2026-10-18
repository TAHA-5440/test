// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package nb;
public final class k {
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater b;
    public static final synthetic java.util.concurrent.atomic.AtomicIntegerFieldUpdater c;
    public static final synthetic java.util.concurrent.atomic.AtomicIntegerFieldUpdater d;
    public static final synthetic java.util.concurrent.atomic.AtomicIntegerFieldUpdater e;
    public final java.util.concurrent.atomic.AtomicReferenceArray a;
    private volatile synthetic int blockingTasksInBuffer$volatile;
    private volatile synthetic int consumerIndex$volatile;
    private volatile synthetic Object lastScheduledTask$volatile;
    private volatile synthetic int producerIndex$volatile;

    static k()
    {
        nb.k.b = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(nb.k, Object, "lastScheduledTask$volatile");
        nb.k.c = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(nb.k, "producerIndex$volatile");
        nb.k.d = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(nb.k, "consumerIndex$volatile");
        nb.k.e = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(nb.k, "blockingTasksInBuffer$volatile");
        return;
    }

    public k()
    {
        this.a = new java.util.concurrent.atomic.AtomicReferenceArray(128);
        return;
    }

    public final nb.g a(nb.g p5)
    {
        java.util.concurrent.atomic.AtomicIntegerFieldUpdater v0 = nb.k.c;
        if ((v0.get(this) - nb.k.d.get(this)) != 127) {
            if (p5.h) {
                nb.k.e.incrementAndGet(this);
            }
            int v1_2 = (v0.get(this) & 127);
            while(true) {
                java.util.concurrent.atomic.AtomicReferenceArray v2_0 = this.a;
                if (v2_0.get(v1_2) == null) {
                    break;
                }
                Thread.yield();
            }
            v2_0.lazySet(v1_2, p5);
            v0.incrementAndGet(this);
            return 0;
        } else {
            return p5;
        }
    }

    public final nb.g b()
    {
        do {
            nb.g v0_0 = nb.k.d;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater v1_1 = v0_0.get(this);
            if ((v1_1 - nb.k.c.get(this)) != 0) {
                if (v0_0.compareAndSet(this, v1_1, (v1_1 + 1))) {
                    nb.g v0_4 = ((nb.g) this.a.getAndSet((v1_1 & 127), 0));
                }
            } else {
                return 0;
            }
        } while(v0_4 != null);
        if (v0_4.h) {
            nb.k.e.decrementAndGet(this);
        }
        return v0_4;
    }

    public final nb.g c(int p5, boolean p6)
    {
        java.util.concurrent.atomic.AtomicIntegerFieldUpdater v5_1 = (p5 & 127);
        java.util.concurrent.atomic.AtomicReferenceArray v0 = this.a;
        nb.g v1_1 = ((nb.g) v0.get(v5_1));
        if ((v1_1 != null) && (v1_1.h == p6)) {
            while (!v0.compareAndSet(v5_1, v1_1, 0)) {
                if (v0.get(v5_1) != v1_1) {
                }
            }
            if (p6) {
                nb.k.e.decrementAndGet(this);
            }
            return v1_1;
        }
        return 0;
    }
}
