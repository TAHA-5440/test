// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ob;
public final class f extends lb.p {
    public final synthetic java.util.concurrent.atomic.AtomicReferenceArray e;

    public f(long p1, ob.f p3, int p4)
    {
        super(p1, p3, p4);
        super.e = new java.util.concurrent.atomic.AtomicReferenceArray(ob.e.f);
        return;
    }

    public final int f()
    {
        return ob.e.f;
    }

    public final void g(int p2, ka.g p3)
    {
        this.e.set(p2, ob.e.e);
        this.h();
        return;
    }

    public final String toString()
    {
        String v0_2 = new StringBuilder("SemaphoreSegment[id=");
        v0_2.append(this.c);
        v0_2.append(", hashCode=");
        v0_2.append(this.hashCode());
        v0_2.append(93);
        return v0_2.toString();
    }
}
