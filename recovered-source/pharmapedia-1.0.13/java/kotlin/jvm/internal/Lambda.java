// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.jvm.internal;
public abstract class Lambda implements kotlin.jvm.internal.e, java.io.Serializable {
    private final int arity;

    public Lambda(int p1)
    {
        this.arity = p1;
        return;
    }

    public int getArity()
    {
        return this.arity;
    }

    public String toString()
    {
        kotlin.jvm.internal.h.a.getClass();
        return kotlin.jvm.internal.i.a(this);
    }
}
