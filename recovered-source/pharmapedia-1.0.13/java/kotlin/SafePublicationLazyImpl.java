// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin;
final class SafePublicationLazyImpl implements ga.e, java.io.Serializable {
    public static final java.util.concurrent.atomic.AtomicReferenceFieldUpdater i;
    public volatile ua.a g;
    public volatile Object h;

    static SafePublicationLazyImpl()
    {
        kotlin.SafePublicationLazyImpl.i = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlin.SafePublicationLazyImpl, Object, "h");
        return;
    }

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
        Object v0_0 = this.h;
        int v1_0 = ga.m.a;
        if (v0_0 == v1_0) {
            Object v0_2 = this.g;
            if (v0_2 != null) {
                Object v0_3 = v0_2.invoke();
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater v2 = kotlin.SafePublicationLazyImpl.i;
                while (!v2.compareAndSet(this, v1_0, v0_3)) {
                    if (v2.get(this) != v1_0) {
                    }
                }
                this.g = 0;
                return v0_3;
            }
            return this.h;
        } else {
            return v0_0;
        }
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
