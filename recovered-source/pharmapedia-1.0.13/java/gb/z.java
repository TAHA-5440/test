// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public class z extends gb.a {
    public final synthetic int j;

    public synthetic z(ka.g p1, boolean p2, int p3)
    {
        this.j = p3;
        super(p1, p2);
        return;
    }

    public boolean A(Throwable p2)
    {
        switch (this.j) {
            case 1:
                gb.w.n(p2, this.i);
                return 1;
            default:
                return super.A(p2);
        }
    }
}
