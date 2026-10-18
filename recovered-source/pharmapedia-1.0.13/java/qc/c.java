// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package qc;
public abstract class c extends androidx.fragment.app.i0 implements c7.c {
    public a7.k g;
    public boolean h;
    public volatile a7.h i;
    public final Object j;
    public boolean k;
    public androidx.fragment.app.n0 l;
    public l.o m;
    public xc.g n;
    public tc.b o;
    public android.os.Handler p;
    public com.bumptech.glide.q q;

    public c()
    {
        this.h = 0;
        this.j = new Object();
        this.k = 0;
        return;
    }

    public final Object a()
    {
        if (this.i == null) {
            if (this.i == null) {
                this.i = new a7.h(this);
            }
        }
        return this.i.a();
    }

    public final xc.g g()
    {
        int v0_0 = this.n;
        if (v0_0 == 0) {
            kotlin.jvm.internal.f.i("internetController");
            throw 0;
        } else {
            return v0_0;
        }
    }

    public android.content.Context getContext()
    {
        if ((super.getContext() != null) || (this.h)) {
            this.k();
            return this.g;
        } else {
            return 0;
        }
    }

    public final androidx.lifecycle.f1 getDefaultViewModelProviderFactory()
    {
        androidx.lifecycle.f1 v0 = super.getDefaultViewModelProviderFactory();
        com.bumptech.glide.h.i(this, z6.b);
        com.google.common.collect.ImmutableMap v1_4 = com.google.common.collect.ImmutableMap.c();
        pc.h v2_1 = new pc.h(1);
        v0.getClass();
        return new z6.e(v1_4, v0, v2_1);
    }

    public final androidx.fragment.app.n0 h()
    {
        int v0_0 = this.l;
        if (v0_0 == 0) {
            kotlin.jvm.internal.f.i("mContext");
            throw 0;
        } else {
            return v0_0;
        }
    }

    public final tc.b i()
    {
        int v0_0 = this.o;
        if (v0_0 == 0) {
            kotlin.jvm.internal.f.i("medicinesDBRepository");
            throw 0;
        } else {
            return v0_0;
        }
    }

    public final l.o j()
    {
        int v0_0 = this.m;
        if (v0_0 == 0) {
            kotlin.jvm.internal.f.i("mySharedPreference");
            throw 0;
        } else {
            return v0_0;
        }
    }

    public final void k()
    {
        if (this.g == null) {
            this.g = new a7.k(super.getContext(), this);
            this.h = com.bumptech.glide.j.S(super.getContext());
        }
        return;
    }

    public void l()
    {
        if (!this.k) {
            this.k = 1;
            com.bumptech.glide.q v0_8 = ((qc.i) ((qc.d) this.a())).a;
            this.m = v0_8.a();
            this.n = ((xc.g) v0_8.e.get());
            v0_8.f.get();
            this.o = ((tc.b) v0_8.i.get());
            this.q = ((com.bumptech.glide.q) v0_8.j.get());
        }
        return;
    }

    public void onAttach(android.app.Activity p3)
    {
        int v3_1;
        super.onAttach(p3);
        String v0_0 = this.g;
        if ((v0_0 != null) && (a7.h.c(v0_0) != p3)) {
            v3_1 = 0;
        } else {
            v3_1 = 1;
        }
        Object[] v1_0 = new Object[0];
        com.bumptech.glide.j.C(v3_1, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", v1_0);
        this.k();
        this.l();
        return;
    }

    public void onAttach(android.content.Context p1)
    {
        super.onAttach(p1);
        this.k();
        this.l();
        return;
    }

    public final void onCreate(android.os.Bundle p3)
    {
        androidx.fragment.app.n0 v0 = this.requireActivity();
        int v1_0 = this.requireActivity();
        v1_0.getClass();
        v0.setTheme(vet.pharmapedia.vetpharmapediapakistan.utils.a.c(v1_0).a);
        super.onCreate(p3);
        androidx.fragment.app.n0 v3_1 = this.requireActivity();
        v3_1.getClass();
        this.l = v3_1;
        return;
    }

    public android.view.LayoutInflater onGetLayoutInflater(android.os.Bundle p2)
    {
        android.view.LayoutInflater v2_1 = super.onGetLayoutInflater(p2);
        return v2_1.cloneInContext(new a7.k(v2_1, this));
    }
}
