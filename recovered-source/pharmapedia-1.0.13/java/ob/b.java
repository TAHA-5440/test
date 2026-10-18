// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ob;
public final class b implements gb.f, gb.n1 {
    public final gb.h g;
    public final synthetic kotlinx.coroutines.sync.a h;

    public b(kotlinx.coroutines.sync.a p1, gb.h p2)
    {
        this.h = p1;
        this.g = p2;
        return;
    }

    public final void a(Object p4, ua.q p5)
    {
        int v0_0 = this.h;
        kotlinx.coroutines.sync.a.n.set(v0_0, 0);
        gb.h v5_1 = this.g;
        v5_1.A(ga.p.a, v5_1.i, new gb.g(new ac.c(v0_0, this), 0));
        return;
    }

    public final void b(lb.p p2, int p3)
    {
        this.g.b(p2, p3);
        return;
    }

    public final boolean e(Throwable p2)
    {
        return this.g.e(p2);
    }

    public final com.google.gson.internal.b f(Object p3, ua.q p4)
    {
        kotlinx.coroutines.sync.a v0 = this.h;
        com.google.gson.internal.b v3_2 = this.g.f(((ga.p) p3), new gb.g(v0, this));
        if (v3_2 != null) {
            kotlinx.coroutines.sync.a.n.set(v0, 0);
        }
        return v3_2;
    }

    public final ka.g getContext()
    {
        return this.g.k;
    }

    public final void j(Object p2)
    {
        this.g.j(p2);
        return;
    }

    public final void resumeWith(Object p2)
    {
        this.g.resumeWith(p2);
        return;
    }
}
