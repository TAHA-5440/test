// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public abstract class o implements java.io.Closeable {
    public static final oc.u g;

    static o()
    {
        try {
            Class.forName("java.nio.file.Files");
            pc.i v0_4 = new oc.v();
        } catch (ClassNotFoundException) {
            v0_4 = new oc.u();
        }
        oc.o.g = v0_4;
        pc.i v0_1 = System.getProperty("java.io.tmpdir");
        v0_1.getClass();
        ea.c.u(v0_1);
        ClassLoader v1_1 = pc.i.getClassLoader();
        v1_1.getClass();
        new pc.i(v1_1);
        return;
    }

    public abstract void B(oc.w p0);

    public final boolean L(oc.w p1)
    {
        p1.getClass();
        if (this.Z(p1) == null) {
            return 0;
        } else {
            return 1;
        }
    }

    public abstract java.util.List M(oc.w p0);

    public abstract oc.n Z(oc.w p0);

    public abstract oc.g c0(oc.w p0);

    public void close()
    {
        return;
    }

    public abstract oc.b0 d(oc.w p0);

    public abstract oc.b0 d0(oc.w p0);

    public abstract oc.d0 e0(oc.w p0);

    public abstract void h(oc.w p0, oc.w p1);

    public abstract void i(oc.w p0);
}
