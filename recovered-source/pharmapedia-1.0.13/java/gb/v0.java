// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public class v0 extends gb.a1 implements gb.o {
    public final boolean i;

    public v0(gb.u0 p6)
    {
        gb.a1 v1_0;
        int v0 = 1;
        super(1);
        super.D(p6);
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater v6_1 = gb.a1.h;
        gb.a1 v1_6 = ((gb.k) v6_1.get(super));
        if (!(v1_6 instanceof gb.l)) {
            v1_0 = 0;
        } else {
            v1_0 = ((gb.l) v1_6);
        }
        if (v1_0 == null) {
            v0 = 0;
        } else {
            gb.a1 v1_1 = v1_0.j();
            while (!v1_1.x()) {
                gb.a1 v1_4;
                gb.a1 v1_3 = ((gb.k) v6_1.get(v1_1));
                if (!(v1_3 instanceof gb.l)) {
                    v1_4 = 0;
                } else {
                    v1_4 = ((gb.l) v1_3);
                }
                if (v1_4 == null) {
                } else {
                    v1_1 = v1_4.j();
                }
            }
        }
        super.i = v0;
        return;
    }

    public final boolean x()
    {
        return this.i;
    }

    public final boolean y()
    {
        return 1;
    }
}
