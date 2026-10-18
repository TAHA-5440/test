// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ha;
public abstract class e extends java.util.AbstractList implements java.util.List, va.b {

    public e()
    {
        return;
    }

    public abstract int a();

    public abstract Object b(int p0);

    public final bridge Object remove(int p1)
    {
        return this.b(p1);
    }

    public final bridge int size()
    {
        return this.a();
    }
}
