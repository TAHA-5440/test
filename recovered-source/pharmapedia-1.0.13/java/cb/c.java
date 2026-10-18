// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cb;
public final class c implements cb.h, cb.d {
    public final cb.h a;
    public final int b;

    public c(cb.h p2, int p3)
    {
        p2.getClass();
        this.a = p2;
        this.b = p3;
        if (p3 < 0) {
            oc.l.b(p3, 46, "count must be non-negative, but was ");
            throw 0;
        } else {
            return;
        }
    }

    public final cb.h a(int p3)
    {
        cb.c v0_1 = (this.b + p3);
        if (v0_1 >= null) {
            return new cb.c(this.a, v0_1);
        } else {
            return new cb.c(this, p3);
        }
    }

    public final java.util.Iterator iterator()
    {
        return new cb.b(this);
    }
}
