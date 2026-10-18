// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.coroutines;
public final class EmptyCoroutineContext implements ka.g, java.io.Serializable {
    public static final kotlin.coroutines.EmptyCoroutineContext g;
    private static final long serialVersionUID;

    static EmptyCoroutineContext()
    {
        kotlin.coroutines.EmptyCoroutineContext.g = new kotlin.coroutines.EmptyCoroutineContext();
        return;
    }

    private final Object readResolve()
    {
        return kotlin.coroutines.EmptyCoroutineContext.g;
    }

    public final Object B(Object p1, ua.p p2)
    {
        return p1;
    }

    public final ka.g L(ka.g p1)
    {
        p1.getClass();
        return p1;
    }

    public final ka.e Z(ka.f p1)
    {
        p1.getClass();
        return 0;
    }

    public final int hashCode()
    {
        return 0;
    }

    public final ka.g i(ka.f p1)
    {
        p1.getClass();
        return this;
    }

    public final String toString()
    {
        return "EmptyCoroutineContext";
    }
}
