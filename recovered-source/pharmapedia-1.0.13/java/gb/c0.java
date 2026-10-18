// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public abstract class c0 extends nb.g {
    public int i;

    public c0(int p4)
    {
        super(0, 0);
        super.i = p4;
        return;
    }

    public void c(java.util.concurrent.CancellationException p1)
    {
        return;
    }

    public abstract ka.c d();

    public Throwable g(Object p3)
    {
        Throwable v3_1;
        if (!(p3 instanceof gb.q)) {
            v3_1 = 0;
        } else {
            v3_1 = ((gb.q) p3);
        }
        if (v3_1 == null) {
            return 0;
        } else {
            return v3_1.a;
        }
    }

    public Object h(Object p1)
    {
        return p1;
    }

    public final void i(Throwable p4)
    {
        String v1_1 = new StringBuilder("Fatal exception in coroutines machinery for ");
        v1_1.append(this);
        v1_1.append(". Please read KDoc to \'handleFatalException\' method and report this incident to maintainers");
        gb.w.n(new kotlinx.coroutines.CoroutinesInternalError(v1_1.toString(), p4), this.d().getContext());
        return;
    }

    public abstract Object k();

    public final void run()
    {
        try {
            boolean v3_1;
            Throwable v0_0 = this.d();
            v0_0.getClass();
            Throwable v0_1 = ((lb.e) v0_0);
            boolean v1_0 = v0_1.k;
            Throwable v0_2 = v0_1.m;
            ka.g v2 = v1_0.getContext();
            Throwable v0_4 = lb.a.l(v2, v0_2);
            Object v4_0 = 0;
        } catch (Throwable v0_3) {
            this.i(v0_3);
            return;
        }
        if (v0_4 == lb.a.d) {
            v3_1 = 0;
        } else {
            v3_1 = gb.w.y(v1_0, v2, v0_4);
        }
        kotlin.Result$Failure v5_0 = v1_0.getContext();
        Object v6 = this.k();
        Throwable v7 = this.g(v6);
        if (v7 == null) {
            int v8 = this.i;
            int v9 = 1;
            if (v8 != 1) {
                if (v8 != 2) {
                    v9 = 0;
                } else {
                }
            }
            if (v9 != 0) {
                v4_0 = ((gb.u0) v5_0.Z(gb.t.h));
            }
        }
        if ((v4_0 == null) || (v4_0.d())) {
            if (v7 == null) {
                v1_0.resumeWith(this.h(v6));
            } else {
                v1_0.resumeWith(new kotlin.Result$Failure(v7));
            }
        } else {
            Object v4_7 = ((gb.a1) v4_0).u();
            this.c(v4_7);
            v1_0.resumeWith(new kotlin.Result$Failure(v4_7));
        }
        if (v3_1) {
            if (!v3_1.b0()) {
                return;
            } else {
            }
        }
        lb.a.g(v2, v0_4);
        return;
    }
}
