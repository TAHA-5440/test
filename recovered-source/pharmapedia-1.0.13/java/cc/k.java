// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public final class k implements cc.x {
    public final cc.w a;

    public k(Throwable p3)
    {
        this.a = new cc.w(this, p3, 2);
        return;
    }

    public final boolean b()
    {
        return 0;
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
        throw new IllegalStateException("unexpected call");
    }

    public final cc.w e()
    {
        return this.a;
    }

    public final cc.w g()
    {
        return this.a;
    }
}
