// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kb;
public final class j implements ka.c, ma.b {
    public final ka.c g;
    public final ka.g h;

    public j(ka.c p1, ka.g p2)
    {
        this.g = p1;
        this.h = p2;
        return;
    }

    public final ma.b getCallerFrame()
    {
        int v0_0 = this.g;
        if (!(v0_0 instanceof ma.b)) {
            return 0;
        } else {
            return ((ma.b) v0_0);
        }
    }

    public final ka.g getContext()
    {
        return this.h;
    }

    public final void resumeWith(Object p2)
    {
        this.g.resumeWith(p2);
        return;
    }
}
