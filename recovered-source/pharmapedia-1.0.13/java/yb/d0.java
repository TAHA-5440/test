// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public abstract class d0 implements java.io.Closeable {
    public static final yb.c0 g;

    static d0()
    {
        yb.c0 v0_0 = okio.ByteString.j;
        v0_0.getClass();
        oc.i v1_1 = new oc.i();
        v1_1.m0(v0_0);
        yb.d0.g = new yb.c0(((long) v0_0.g.length), v1_1);
        return;
    }

    public void close()
    {
        zb.c.a(this.i());
        return;
    }

    public abstract long d();

    public abstract yb.w h();

    public abstract oc.k i();
}
