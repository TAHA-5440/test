// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package wc;
public abstract class f extends qc.c {
    public a7.k r;
    public boolean s;
    public boolean t;

    public f()
    {
        this.s = 0;
        this.t = 0;
        return;
    }

    public final android.content.Context getContext()
    {
        if ((super.getContext() != null) || (this.s)) {
            this.m();
            return this.r;
        } else {
            return 0;
        }
    }

    public final void l()
    {
        if (!this.t) {
            this.t = 1;
            uc.q v0_7 = ((qc.i) ((wc.m) this.a()));
            com.bumptech.glide.q v2_0 = v0_7.a;
            ((wc.l) this).m = v2_0.a();
            ((wc.l) this).n = ((xc.g) v2_0.e.get());
            v2_0.f.get();
            ((wc.l) this).o = ((tc.b) v2_0.i.get());
            ((wc.l) this).q = ((com.bumptech.glide.q) v2_0.j.get());
            ((wc.l) this).u = ((uc.q) v0_7.d.get());
        }
        return;
    }

    public final void m()
    {
        if (this.r == null) {
            this.r = new a7.k(super.getContext(), this);
            this.s = com.bumptech.glide.j.S(super.getContext());
        }
        return;
    }

    public final void onAttach(android.app.Activity p3)
    {
        int v3_1;
        super.onAttach(p3);
        String v0_0 = this.r;
        if ((v0_0 != null) && (a7.h.c(v0_0) != p3)) {
            v3_1 = 0;
        } else {
            v3_1 = 1;
        }
        Object[] v1_0 = new Object[0];
        com.bumptech.glide.j.C(v3_1, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", v1_0);
        this.m();
        this.l();
        return;
    }

    public final void onAttach(android.content.Context p1)
    {
        super.onAttach(p1);
        this.m();
        this.l();
        return;
    }

    public final android.view.LayoutInflater onGetLayoutInflater(android.os.Bundle p2)
    {
        android.view.LayoutInflater v2_1 = super.onGetLayoutInflater(p2);
        return v2_1.cloneInContext(new a7.k(v2_1, this));
    }
}
