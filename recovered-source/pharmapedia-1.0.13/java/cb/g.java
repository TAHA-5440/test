// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cb;
public final class g implements cb.h {
    public final synthetic int a;
    public final ua.l b;
    public final cb.h c;

    public g(cb.h p2, ua.l p3)
    {
        this.a = 1;
        p3.getClass();
        this.c = p2;
        this.b = p3;
        return;
    }

    public g(cb.j p2, ua.l p3)
    {
        this.a = 0;
        p3.getClass();
        this.c = p2;
        this.b = p3;
        return;
    }

    public final java.util.Iterator iterator()
    {
        switch (this.a) {
            case 0:
                return new cb.f(this);
            default:
                return new cb.l(this);
        }
    }
}
