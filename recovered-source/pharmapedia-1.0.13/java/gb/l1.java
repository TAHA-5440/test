// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class l1 extends lb.o {
    public final ThreadLocal k;
    private volatile boolean threadLocalIsSet;

    public l1(ka.c p3, ka.g p4)
    {
        ka.d v0_2;
        ka.d v0_0 = gb.m1.g;
        if (p4.Z(v0_0) != null) {
            v0_2 = p4;
        } else {
            v0_2 = p4.L(v0_0);
        }
        super(p3, v0_2);
        super.k = new ThreadLocal();
        if (!(p3.getContext().Z(ka.d.g) instanceof gb.s)) {
            Object v3_5 = lb.a.l(p4, 0);
            lb.a.g(p4, v3_5);
            super.c0(p4, v3_5);
        }
        return;
    }

    public final boolean b0()
    {
        if ((!this.threadLocalIsSet) || (this.k.get() != null)) {
            int v0_4 = 0;
        } else {
            v0_4 = 1;
        }
        this.k.remove();
        return (v0_4 ^ 1);
    }

    public final void c0(ka.g p3, Object p4)
    {
        this.threadLocalIsSet = 1;
        this.k.set(new kotlin.Pair(p3, p4));
        return;
    }

    public final void l(Object p6)
    {
        if (this.threadLocalIsSet) {
            boolean v0_7 = ((kotlin.Pair) this.k.get());
            if (v0_7) {
                lb.a.g(((ka.g) v0_7.g), v0_7.h);
            }
            this.k.remove();
        }
        boolean v6_1 = gb.w.r(p6);
        boolean v0_2 = this.j;
        ka.g v1_0 = v0_2.getContext();
        gb.l1 v2 = 0;
        Object v3 = lb.a.l(v1_0, 0);
        if (v3 != lb.a.d) {
            v2 = gb.w.y(v0_2, v1_0, v3);
        }
        try {
            this.j.resumeWith(v6_1);
        } catch (boolean v6_2) {
            if (v2 == null) {
                lb.a.g(v1_0, v3);
            } else {
                if (v2.b0()) {
                }
            }
            throw v6_2;
        }
        if ((v2 != null) && (!v2.b0())) {
            return;
        } else {
            lb.a.g(v1_0, v3);
            return;
        }
    }
}
