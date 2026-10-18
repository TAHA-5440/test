// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final synthetic class g implements ua.q {
    public final synthetic int g;
    public final synthetic Object h;

    public synthetic g(Object p1, int p2)
    {
        this.g = p2;
        this.h = p1;
        return;
    }

    public synthetic g(kotlinx.coroutines.sync.a p1, ob.b p2)
    {
        this.g = 1;
        this.h = p1;
        return;
    }

    public final Object invoke(Object p2, Object p3, Object p4)
    {
        switch (this.g) {
            case 0:
                Object vtmp1 = ((ac.c) this.h).invoke(((Throwable) p2));
                break;
            case 1:
                kotlinx.coroutines.sync.a v0_4 = ((kotlinx.coroutines.sync.a) this.h);
                p3 = ((ga.p) p3);
                kotlinx.coroutines.sync.a.n.set(v0_4, 0);
                v0_4.h(0);
                break;
            default:
                p3 = ((ga.p) p3);
                ((kotlinx.coroutines.sync.b) this.h).b();
        }
        return ga.p.a;
    }
}
