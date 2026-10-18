// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public final class n implements cc.y, cc.j {
    public final cc.u a;

    public synthetic n(cc.u p1)
    {
        this.a = p1;
        return;
    }

    public boolean a(cc.s p2)
    {
        return this.a.a(p2);
    }

    public cc.s b()
    {
        java.io.IOException v1 = 0;
        do {
            boolean v2_0 = this.a;
            if (v2_0.k.m()) {
                oc.l.g("Canceled");
                return 0;
            } else {
                ha.h v3_0 = v2_0.h();
                if (!v3_0.b()) {
                    cc.x v5_2;
                    Throwable v4_1 = v3_0.e();
                    if ((v4_1.b != null) || (v4_1.c != null)) {
                        v5_2 = 0;
                    } else {
                        v5_2 = 1;
                    }
                    if (v5_2 != null) {
                        v4_1 = v3_0.g();
                    }
                    cc.x v5_3 = v4_1.b;
                    Throwable v4_2 = v4_1.c;
                    if (v4_2 != null) {
                        throw v4_2;
                    } else {
                        if (v5_3 != null) {
                            v2_0.o.addFirst(v5_3);
                        }
                    }
                }
                return v3_0.d();
            }
        } while(!v2_0.a(0));
        throw v1;
    }

    public cc.y c()
    {
        return this.a;
    }

    public yb.a d()
    {
        return this.a.i;
    }

    public boolean e()
    {
        return this.a.k.m();
    }

    public boolean f(yb.u p2)
    {
        p2.getClass();
        return this.a.f(p2);
    }

    public ha.h g()
    {
        return this.a.o;
    }

    public cc.x h()
    {
        return this.a.b();
    }
}
