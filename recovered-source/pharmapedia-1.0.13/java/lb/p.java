// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lb;
public abstract class p extends lb.b implements gb.e1 {
    public static final synthetic java.util.concurrent.atomic.AtomicIntegerFieldUpdater d;
    public final long c;
    private volatile synthetic int cleanedAndPointers$volatile;

    static p()
    {
        lb.p.d = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(lb.p, "cleanedAndPointers$volatile");
        return;
    }

    public p(long p1, lb.p p3, int p4)
    {
        super(p3);
        super.c = p1;
        super.cleanedAndPointers$volatile = (p4 << 16);
        return;
    }

    public final boolean c()
    {
        if ((lb.p.d.get(this) == this.f()) && (this.b() != null)) {
            return 1;
        } else {
            return 0;
        }
    }

    public final boolean e()
    {
        if ((lb.p.d.addAndGet(this, -65536) == this.f()) && (this.b() != null)) {
            return 1;
        } else {
            return 0;
        }
    }

    public abstract int f();

    public abstract void g(int p0, ka.g p1);

    public final void h()
    {
        if (lb.p.d.incrementAndGet(this) == this.f()) {
            this.d();
        }
        return;
    }

    public final boolean i()
    {
        do {
            int v0_0 = lb.p.d;
            int v1 = v0_0.get(this);
            if ((v1 == this.f()) && (this.b() != null)) {
                return 0;
            } else {
            }
        } while(!v0_0.compareAndSet(this, v1, (65536 + v1)));
        return 1;
    }
}
