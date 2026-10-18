// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lb;
public final class e extends gb.c0 implements ma.b, ka.c {
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater n;
    private volatile synthetic Object _reusableCancellableContinuation$volatile;
    public final gb.s j;
    public final kotlin.coroutines.jvm.internal.ContinuationImpl k;
    public Object l;
    public final Object m;

    static e()
    {
        lb.e.n = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(lb.e, Object, "_reusableCancellableContinuation$volatile");
        return;
    }

    public e(gb.s p2, kotlin.coroutines.jvm.internal.ContinuationImpl p3)
    {
        super(-1);
        super.j = p2;
        super.k = p3;
        super.l = lb.a.b;
        super.m = lb.a.k(p3.getContext());
        return;
    }

    public final ka.c d()
    {
        return this;
    }

    public final ma.b getCallerFrame()
    {
        return this.k;
    }

    public final ka.g getContext()
    {
        return this.k.getContext();
    }

    public final Object k()
    {
        Object v0 = this.l;
        this.l = lb.a.b;
        return v0;
    }

    public final void resumeWith(Object p9)
    {
        ka.g v2_2;
        kotlin.coroutines.jvm.internal.ContinuationImpl v0_0 = kotlin.Result.a(p9);
        if (v0_0 != null) {
            v2_2 = new gb.q(0, v0_0);
        } else {
            v2_2 = p9;
        }
        kotlin.coroutines.jvm.internal.ContinuationImpl v0_1 = this.k;
        Object v4_0 = this.j;
        if (!v4_0.f0(v0_1.getContext())) {
            gb.j0 v3_1 = gb.g1.a();
            if (v3_1.i < 4294967296) {
                v3_1.j0(1);
                try {
                    ka.g v2_0 = v0_1.getContext();
                    Object v4_4 = lb.a.l(v2_0, this.m);
                    try {
                        v0_1.resumeWith(p9);
                    } catch (boolean v9_1) {
                        lb.a.g(v2_0, v4_4);
                        throw v9_1;
                    }
                    lb.a.g(v2_0, v4_4);
                    while (v3_1.l0()) {
                    }
                    v3_1.h0(1);
                    return;
                } catch (boolean v9_2) {
                    try {
                        this.i(v9_2);
                    } catch (boolean v9_3) {
                        v3_1.h0(1);
                        throw v9_3;
                    }
                }
            } else {
                this.l = v2_2;
                this.i = 0;
                v3_1.i0(this);
                return;
            }
        } else {
            this.l = v2_2;
            this.i = 0;
            v4_0.d0(v0_1.getContext(), this);
            return;
        }
    }

    public final String toString()
    {
        String v0_2 = new StringBuilder("DispatchedContinuation[");
        v0_2.append(this.j);
        v0_2.append(", ");
        v0_2.append(gb.w.v(this.k));
        v0_2.append(93);
        return v0_2.toString();
    }
}
