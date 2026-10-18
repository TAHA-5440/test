// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin;
public final class UnsafeLazyImpl implements ga.e, java.io.Serializable {
    public ua.a g;
    public Object h;

    private final void readObject(java.io.ObjectInputStream p2)
    {
        throw new java.io.InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace()
    {
        return new kotlin.InitializedLazyImpl(this.getValue());
    }

    public final Object getValue()
    {
        if (this.h == ga.m.a) {
            Object v0_2 = this.g;
            v0_2.getClass();
            this.h = v0_2.invoke();
            this.g = 0;
        }
        return this.h;
    }

    public final boolean isInitialized()
    {
        if (this.h == ga.m.a) {
            return 0;
        } else {
            return 1;
        }
    }

    public final String toString()
    {
        if (!this.isInitialized()) {
            return "Lazy value not initialized yet.";
        } else {
            return String.valueOf(this.getValue());
        }
    }
}
