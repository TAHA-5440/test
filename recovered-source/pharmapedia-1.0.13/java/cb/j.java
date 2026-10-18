// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cb;
public final class j implements cb.h {
    public final synthetic int a;
    public final synthetic Object b;

    public synthetic j(Object p1, int p2)
    {
        this.a = p2;
        this.b = p1;
        return;
    }

    public final java.util.Iterator iterator()
    {
        switch (this.a) {
            case 0:
                return ((java.util.Iterator) this.b);
            case 1:
                return new db.e(((String) this.b));
            case 2:
                Object[] v0_8 = ((Object[]) this.b);
                v0_8.getClass();
                return new ga.g(v0_8);
            default:
                return ((Iterable) this.b).iterator();
        }
    }
}
