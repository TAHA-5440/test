// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public final class v implements cc.x {
    public final cc.s a;

    public v(cc.s p1)
    {
        this.a = p1;
        return;
    }

    public final boolean b()
    {
        return 1;
    }

    public final cc.x c()
    {
        throw new IllegalStateException("unexpected retry");
    }

    public final void cancel()
    {
        throw new IllegalStateException("unexpected cancel");
    }

    public final cc.s d()
    {
        return this.a;
    }

    public final cc.w e()
    {
        throw new IllegalStateException("already connected");
    }

    public final cc.w g()
    {
        throw new IllegalStateException("already connected");
    }
}
