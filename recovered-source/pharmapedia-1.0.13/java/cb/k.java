// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cb;
public final class k implements java.lang.Iterable, va.a {
    public final synthetic int g;
    public final Object h;

    public synthetic k(Object p1, int p2)
    {
        this.g = p2;
        this.h = p1;
        return;
    }

    public final java.util.Iterator iterator()
    {
        switch (this.g) {
            case 0:
                return new db.b(((db.c) this.h));
            default:
                db.b v1_1 = ((Object[]) ((androidx.activity.e) this.h).h);
                v1_1.getClass();
                return new cb.b(new ga.g(v1_1));
        }
    }
}
