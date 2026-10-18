// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public abstract class q implements oc.d0 {
    public final oc.d0 g;

    public q(oc.d0 p1)
    {
        p1.getClass();
        this.g = p1;
        return;
    }

    public long N(long p2, oc.i p4)
    {
        p4.getClass();
        return this.g.N(p2, p4);
    }

    public final oc.f0 a()
    {
        return this.g.a();
    }

    public void close()
    {
        this.g.close();
        return;
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder();
        v0_1.append(this.getClass().getSimpleName());
        v0_1.append(40);
        v0_1.append(this.g);
        v0_1.append(41);
        return v0_1.toString();
    }
}
