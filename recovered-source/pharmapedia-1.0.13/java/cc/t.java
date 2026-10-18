// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public final class t {
    public final cc.f a;
    public final long b;
    public volatile java.util.Map c;
    public final bc.b d;
    public final ac.i e;
    public final java.util.concurrent.ConcurrentLinkedQueue f;

    static t()
    {
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(cc.t, java.util.Map, "c");
        return;
    }

    public t(bc.d p1, java.util.concurrent.TimeUnit p2, cc.f p3, yb.n p4)
    {
        this.a = p3;
        this.b = p2.toNanos(5);
        this.c = kotlin.collections.a.G();
        this.d = p1.d();
        this.e = new ac.i(r1.a.n(zb.e.b, " ConnectionPool connection closer", new StringBuilder()), 2, this);
        this.f = new java.util.concurrent.ConcurrentLinkedQueue();
        return;
    }

    public final int a(cc.s p7, long p8)
    {
        java.util.ArrayList v0 = p7.r;
        long v2_0 = 0;
        while (v2_0 < v0.size()) {
            boolean v3_1 = ((ref.Reference) v0.get(v2_0));
            if (v3_1.get() == null) {
                boolean v3_2 = ((cc.p) v3_1);
                String v4_2 = new StringBuilder("A connection to ");
                v4_2.append(p7.d.a.h);
                v4_2.append(" was leaked. Did you forget to close a response body?");
                ic.e.a.j(v3_2.a, v4_2.toString());
                v0.remove(v2_0);
                if (v0.isEmpty()) {
                    p7.s = (p8 - this.b);
                    return 0;
                }
            } else {
                v2_0++;
            }
        }
        return v0.size();
    }
}
