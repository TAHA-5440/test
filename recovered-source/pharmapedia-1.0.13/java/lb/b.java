// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lb;
public abstract class b {
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater a;
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater b;
    private volatile synthetic Object _next$volatile;
    private volatile synthetic Object _prev$volatile;

    static b()
    {
        lb.b.a = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(lb.b, Object, "_next$volatile");
        lb.b.b = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(lb.b, Object, "_prev$volatile");
        return;
    }

    public b(lb.p p1)
    {
        this._prev$volatile = p1;
        return;
    }

    public final void a()
    {
        lb.b.b.set(this, 0);
        return;
    }

    public final lb.b b()
    {
        lb.b v0_1 = lb.b.a.get(this);
        if (v0_1 != lb.a.a) {
            return ((lb.b) v0_1);
        } else {
            return 0;
        }
    }

    public abstract boolean c();

    public final void d()
    {
        if (this.b() == null) {
            return;
        }
        do {
            boolean v0_1 = lb.b.b;
            lb.b v1_2 = ((lb.b) v0_1.get(this));
            if ((v1_2 != null) && (v1_2.c())) {
                v1_2 = ((lb.b) v0_1.get(v1_2));
                while ((v1_2 == null) || (!v1_2.c())) {
                }
            }
            Object v2_0 = this.b();
            v2_0.getClass();
            while (v2_0.c()) {
                Object v3_1 = v2_0.b();
                if (v3_1 == null) {
                    break;
                }
                v2_0 = v3_1;
            }
            do {
                lb.b v4_2;
                Object v3_2 = v0_1.get(v2_0);
                if (((lb.b) v3_2) != null) {
                    v4_2 = v1_2;
                } else {
                    v4_2 = 0;
                }
                while (!v0_1.compareAndSet(v2_0, v3_2, v4_2)) {
                    if (v0_1.get(v2_0) != v3_2) {
                    }
                }
                if (v1_2 != null) {
                    lb.b.a.set(v1_2, v2_0);
                }
            } while(((v2_0.c()) && (v2_0.b() != null)) || ((v1_2 != null) && (v1_2.c())));
        } while(((!v2_0.c()) && (v2_0.b() != null)) || ((v1_2 == null) && (v1_2.c())));
        return;
    }
}
