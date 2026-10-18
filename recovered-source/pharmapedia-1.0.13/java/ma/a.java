// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ma;
public final class a implements ka.c {
    public static final ma.a g;

    static a()
    {
        ma.a.g = new ma.a();
        return;
    }

    public final ka.g getContext()
    {
        throw new IllegalStateException("This continuation is already complete");
    }

    public final void resumeWith(Object p2)
    {
        throw new IllegalStateException("This continuation is already complete");
    }

    public final String toString()
    {
        return "This continuation is already complete";
    }
}
