// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class x0 extends gb.h {
    public final gb.n o;

    public x0(gb.n p2, ka.c p3)
    {
        super(1, p3);
        super.o = p2;
        return;
    }

    public final Throwable q(gb.a1 p3)
    {
        gb.q v0_0 = this.o;
        v0_0.getClass();
        gb.q v0_2 = gb.a1.g.get(v0_0);
        if ((v0_2 instanceof gb.z0)) {
            boolean v1_0 = ((gb.z0) v0_2).b();
            if (v1_0) {
                return v1_0;
            }
        }
        if (!(v0_2 instanceof gb.q)) {
            return p3.u();
        } else {
            return ((gb.q) v0_2).a;
        }
    }

    public final String y()
    {
        return "AwaitContinuation";
    }
}
