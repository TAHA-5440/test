// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lb;
public class o extends gb.a implements ma.b {
    public final ka.c j;

    public o(ka.c p2, ka.g p3)
    {
        super(p3, 1);
        super.j = p2;
        return;
    }

    public final boolean G()
    {
        return 1;
    }

    public final ma.b getCallerFrame()
    {
        int v0_0 = this.j;
        if (!(v0_0 instanceof ma.b)) {
            return 0;
        } else {
            return ((ma.b) v0_0);
        }
    }

    public void k(Object p2)
    {
        lb.a.h(gb.w.r(p2), a.a.n(this.j));
        return;
    }

    public void l(Object p2)
    {
        this.j.resumeWith(gb.w.r(p2));
        return;
    }
}
