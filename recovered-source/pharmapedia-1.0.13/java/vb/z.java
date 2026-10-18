// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vb;
public abstract class z extends vb.j {
    public static final vb.y Companion;

    static z()
    {
        vb.z.Companion = new vb.y();
        return;
    }

    public abstract String a();

    public abstract boolean b();

    public String toString()
    {
        return this.a();
    }
}
