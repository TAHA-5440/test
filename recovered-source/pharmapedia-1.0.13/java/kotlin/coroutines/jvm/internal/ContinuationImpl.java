// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.coroutines.jvm.internal;
public abstract class ContinuationImpl extends kotlin.coroutines.jvm.internal.BaseContinuationImpl {
    private final ka.g _context;
    private transient ka.c intercepted;

    public ContinuationImpl(ka.c p2)
    {
        int v0;
        if (p2 == null) {
            v0 = 0;
        } else {
            v0 = p2.getContext();
        }
        this(p2, v0);
        return;
    }

    public ContinuationImpl(ka.c p1, ka.g p2)
    {
        super(p1);
        super._context = p2;
        return;
    }

    public ka.g getContext()
    {
        ka.g v0 = this._context;
        v0.getClass();
        return v0;
    }

    public final ka.c intercepted()
    {
        gb.s v0_0 = this.intercepted;
        if (v0_0 != null) {
            return v0_0;
        } else {
            kotlin.coroutines.jvm.internal.ContinuationImpl v1_0;
            gb.s v0_3 = ((gb.s) this.getContext().Z(ka.d.g));
            if (v0_3 == null) {
                v1_0 = this;
            } else {
                v1_0 = new lb.e(v0_3, this);
            }
            this.intercepted = v1_0;
            return v1_0;
        }
    }

    public void releaseIntercepted()
    {
        int v0_0 = this.intercepted;
        if ((v0_0 != 0) && (v0_0 != this)) {
            this.getContext().Z(ka.d.g).getClass();
            int v0_1 = ((lb.e) v0_0);
            boolean v1_0 = lb.e.n;
            while (v1_0.get(v0_1) == lb.a.c) {
            }
            int v0_3;
            int v0_2 = v1_0.get(v0_1);
            if (!(v0_2 instanceof gb.h)) {
                v0_3 = 0;
            } else {
                v0_3 = ((gb.h) v0_2);
            }
            if (v0_3 != 0) {
                v0_3.o();
            }
        }
        this.intercepted = ma.a.g;
        return;
    }
}
