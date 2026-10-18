// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public abstract class p implements oc.b0 {
    public final oc.b0 g;

    public p(oc.b0 p1)
    {
        p1.getClass();
        this.g = p1;
        return;
    }

    public void D(long p2, oc.i p4)
    {
        this.g.D(p2, p4);
        return;
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

    public void flush()
    {
        this.g.flush();
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
