// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package zb;
public final class a extends yb.d0 implements oc.d0 {
    public final yb.w h;
    public final long i;

    public a(yb.w p1, long p2)
    {
        this.h = p1;
        this.i = p2;
        return;
    }

    public final long N(long p1, oc.i p3)
    {
        p3.getClass();
        throw new IllegalStateException("Unreadable ResponseBody! These Response objects have bodies that are stripped:\n * Response.cacheResponse\n * Response.networkResponse\n * Response.priorResponse\n * EventSourceListener\n * WebSocketListener\n(It is safe to call contentType() and contentLength() on these response bodies.)");
    }

    public final oc.f0 a()
    {
        return oc.f0.d;
    }

    public final void close()
    {
        return;
    }

    public final long d()
    {
        return this.i;
    }

    public final yb.w h()
    {
        return this.h;
    }

    public final oc.k i()
    {
        return new oc.y(this);
    }
}
