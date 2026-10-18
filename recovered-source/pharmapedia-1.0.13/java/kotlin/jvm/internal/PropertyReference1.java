// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.jvm.internal;
public abstract class PropertyReference1 extends kotlin.jvm.internal.PropertyReference implements bb.j {

    public bb.b computeReflected()
    {
        kotlin.jvm.internal.h.a.getClass();
        return this;
    }

    public Object getDelegate(Object p2)
    {
        return ((bb.j) this.getReflected()).getDelegate(p2);
    }

    public bridge synthetic bb.h getGetter()
    {
        this.getGetter();
        return 0;
    }

    public bb.i getGetter()
    {
        ((bb.j) this.getReflected()).getGetter();
        return 0;
    }

    public Object invoke(Object p1)
    {
        return this.get(p1);
    }
}
