// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin;
public final class InitializedLazyImpl implements ga.e, java.io.Serializable {
    public final Object g;

    public InitializedLazyImpl(Object p1)
    {
        this.g = p1;
        return;
    }

    public final Object getValue()
    {
        return this.g;
    }

    public final boolean isInitialized()
    {
        return 1;
    }

    public final String toString()
    {
        return String.valueOf(this.g);
    }
}
