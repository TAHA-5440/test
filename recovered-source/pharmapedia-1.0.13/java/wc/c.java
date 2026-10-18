// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package wc;
public final class c extends wc.e {
    public uc.p u;
    public rc.l v;
    public java.util.List w;
    public java.util.List x;
    public boolean y;

    public c()
    {
        kotlin.collections.EmptyList v0 = kotlin.collections.EmptyList.g;
        this.w = v0;
        this.x = v0;
        return;
    }

    public final void n()
    {
        String v0_0 = this.o();
        String v1_0 = v0_0.c;
        String v0_3 = v0_0.b;
        try {
            this.y = 0;
            String v2_9 = this.h();
            int v3_2 = new android.util.TypedValue();
            v2_9.getTheme().resolveAttribute(2130969682, v3_2, 1);
            v0_3.setBackgroundTintList(android.content.res.ColorStateList.valueOf(v3_2.data));
            v0_3.setTextColor(this.h().getColor(2131100670));
            v1_0.setTextColor(this.h().getColor(2131099683));
            v1_0.setBackgroundTintList(android.content.res.ColorStateList.valueOf(this.h().getColor(2131100670)));
            this.v = new rc.l(this.h(), 1, this.i());
            this.q(1);
            return;
        } catch (String v0_9) {
            r1.a.A("brandsButtonSelected: ", v0_9.getMessage(), "favoriteFragment");
            return;
        }
    }

    public final uc.p o()
    {
        int v0_0 = this.u;
        if (v0_0 == 0) {
            kotlin.jvm.internal.f.i("binding");
            throw 0;
        } else {
            return v0_0;
        }
    }

    public final android.view.View onCreateView(android.view.LayoutInflater p1, android.view.ViewGroup p2, android.os.Bundle p3)
    {
        p1.getClass();
        androidx.constraintlayout.widget.ConstraintLayout v1_2 = this.o().a;
        v1_2.getClass();
        return v1_2;
    }

    public final void onResume()
    {
        super.onResume();
        xc.a.d = 1;
        this.p();
        this.n();
        return;
    }

    public final void onViewCreated(android.view.View p4, android.os.Bundle p5)
    {
        p4.getClass();
        super.onViewCreated(p4, p5);
        this.v = new rc.l(this.h(), 1, this.i());
        int v4_1 = this.o();
        wc.a v5_1 = this.v;
        if (v5_1 == null) {
            kotlin.jvm.internal.f.i("favouritesAdapter");
            throw 0;
        } else {
            v4_1.e.setAdapter(v5_1);
            int v4_7 = this.i().a;
            v4_7.a.getInvalidationTracker().b(new String[] {"medicines_table"}), new tc.d(v4_7, 1)).d(this.h(), new rc.h(new wc.b(this, 1), 5));
            this.p();
            int v4_9 = this.o();
            wc.a v5_6 = v4_9.e;
            this.h();
            v5_6.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager());
            v4_9.b.setOnClickListener(new wc.a(this, 0));
            v4_9.c.setOnClickListener(new wc.a(this, 1));
            return;
        }
    }

    public final void p()
    {
        int v0_0 = this.o();
        androidx.fragment.app.n0 v1_3 = this.v;
        if (v1_3 == null) {
            kotlin.jvm.internal.f.i("favouritesAdapter");
            throw 0;
        } else {
            v0_0.e.setAdapter(v1_3);
            int v0_2 = this.i().a;
            v0_2.a.getInvalidationTracker().b(new String[] {"medicines_table"}), new tc.d(v0_2, 0)).d(this.h(), new rc.h(new wc.b(this, 0), 5));
            return;
        }
    }

    public final void q(boolean p6)
    {
        android.util.Log.d("cvv", "logIt: ".concat("AdapterCalled"));
        if (this.v != null) {
            String v0_6 = this.o();
            int v1_1 = this.v;
            if (v1_1 == 0) {
                kotlin.jvm.internal.f.i("favouritesAdapter");
                throw 0;
            } else {
                v0_6.e.setAdapter(v1_1);
                String v0_2 = this.v;
                if (p6 == null) {
                    if (v0_2 == null) {
                        kotlin.jvm.internal.f.i("favouritesAdapter");
                        throw 0;
                    } else {
                        java.util.List v6_1 = this.x;
                        int v1_3 = new java.util.HashSet();
                        java.util.ArrayList v2_2 = new java.util.ArrayList();
                        java.util.List v6_2 = v6_1.iterator();
                        while (v6_2.hasNext()) {
                            Object v3_2 = v6_2.next();
                            if (v1_3.add(db.i.o0(((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) v3_2).getSaltName()).toString())) {
                                v2_2.add(v3_2);
                            }
                        }
                        v0_2.l(ha.j.R(v2_2, new b2.b(15)));
                        return;
                    }
                } else {
                    if (v0_2 == null) {
                        kotlin.jvm.internal.f.i("favouritesAdapter");
                        throw 0;
                    } else {
                        v0_2.l(ha.j.R(this.w, new b2.b(14)));
                        return;
                    }
                }
            }
        }
        return;
    }
}
