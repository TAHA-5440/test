// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin;
final class SynchronizedLazyImpl implements ga.e, java.io.Serializable {
    public ua.a g;
    public volatile Object h;
    public final Object i;

    public SynchronizedLazyImpl(ua.a p1)
    {
        p1.getClass();
        this.g = p1;
        this.h = ga.m.a;
        this.i = this;
        return;
    }

    private final Object writeReplace()
    {
        return new kotlin.InitializedLazyImpl(this.getValue());
    }

    public final Object getValue()
    {
        Object v0 = this.h;
        int v1_0 = ga.m.a;
        if (v0 == v1_0) {
            try {
                Object v2 = this.h;
            } catch (int v1_2) {
                throw v1_2;
            }
            if (v2 == v1_0) {
                int v1_3 = this.g;
                v1_3.getClass();
                v2 = v1_3.invoke();
                this.h = v2;
                this.g = 0;
            } else {
            }
            return v2;
        } else {
            return v0;
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
