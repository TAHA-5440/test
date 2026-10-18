// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.activities;
public final class ContraindicationsActivity extends qc.b {
    public static final synthetic int F;
    public boolean A;
    public vet.pharmapedia.vetpharmapediapakistan.utils.b B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean u;
    public uc.d v;
    public vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel w;
    public boolean x;
    public boolean y;
    public boolean z;

    public ContraindicationsActivity()
    {
        this.u = 0;
        this.addOnContextAvailableListener(new vc.p(this, 3));
        return;
    }

    public final void m()
    {
        this.finish();
        return;
    }

    public final void n()
    {
        if (!this.u) {
            this.u = 1;
            uc.d v0_7 = ((qc.f) ((vc.j) this.a()));
            com.bumptech.glide.q v1_3 = v0_7.b;
            this.p = ((xc.g) v1_3.e.get());
            this.q = ((xc.h) v1_3.f.get());
            this.r = v1_3.a();
            this.s = ((tc.b) v1_3.i.get());
            this.t = ((com.bumptech.glide.q) v1_3.j.get());
            this.v = ((uc.d) v0_7.h.get());
        }
        return;
    }

    public final void onCreate(android.os.Bundle p6)
    {
        super.onCreate(p6);
        this.setContentView(this.p().a);
        boolean v6_6 = this.getIntent();
        if (v6_6) {
            boolean v6_1 = v6_6.getExtras();
            if (v6_1) {
                vc.g v1_3;
                if (android.os.Build$VERSION.SDK_INT < 33) {
                    vc.g v1_2 = v6_1.getSerializable("MedicinesModel");
                    if (!(v1_2 instanceof vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel)) {
                        v1_2 = 0;
                    }
                    v1_3 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) v1_2);
                } else {
                    v1_3 = androidx.activity.q.i(v6_1);
                }
                this.w = ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) v1_3);
                this.x = v6_1.getBoolean("brandSelected", 0);
            }
        }
        boolean v6_5 = this.p();
        vc.g v1_6 = v6_5.g;
        boolean v2_2 = this.w;
        if (v2_2) {
            v6_5.p.setText(v2_2.getOverview());
            v6_5.j.setText(v2_2.getIndications());
            v6_5.c.setText(v2_2.getContraIndications());
            int v4_3 = v6_5.m;
            if (!this.x) {
                v4_3.setText(v2_2.getSaltName());
            } else {
                v4_3.setText(v2_2.getBrandName());
            }
            if ((!v2_2.isBrandFavourite()) || (!this.x)) {
                if (!v2_2.isSaltFavourite()) {
                    v1_6.setImageResource(2131230840);
                } else {
                    v1_6.setImageResource(2131231274);
                }
            } else {
                v1_6.setImageResource(2131231274);
            }
            v1_6.setOnClickListener(new p5.j(8, this, v2_2));
            v6_5.n.setOnClickListener(new vc.g(0, v6_5, v2_2, this));
            v6_5.i.setOnClickListener(new vc.g(1, v6_5, v2_2, this));
            v6_5.b.setOnClickListener(new vc.g(2, v6_5, v2_2, this));
        }
        v6_5.h.setOnClickListener(new vc.a(this, 3));
        this.q();
        return;
    }

    public final void onPause()
    {
        super.onPause();
        gb.z v0_0 = this.B;
        if (v0_0 != null) {
            gb.z v0_1 = v0_0.i;
            if (v0_1 != null) {
                v0_1.h(0);
            }
        }
        return;
    }

    public final uc.d p()
    {
        int v0_0 = this.v;
        if (v0_0 == 0) {
            kotlin.jvm.internal.f.i("binding");
            throw 0;
        } else {
            return v0_0;
        }
    }

    public final void q()
    {
        uc.d v0_0 = this.p();
        if ((!this.i().a()) || (kotlin.jvm.internal.f.a(this.l().A(), "en"))) {
            if ((!this.i().a()) && (!kotlin.jvm.internal.f.a(this.l().A(), "en"))) {
                uc.d v0_3 = p5.k.f(v0_0.f, this.getString(2131951819));
                vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel v1_12 = v0_3.i;
                int v4_6 = this.j();
                String v5_3 = new android.util.TypedValue();
                v4_6.getTheme().resolveAttribute(2130969682, v5_3, 1);
                ((com.google.android.material.snackbar.SnackbarContentLayout) v1_12.getChildAt(0)).getActionView().setTextColor(v5_3.data);
                ((com.google.android.material.snackbar.SnackbarContentLayout) v1_12.getChildAt(0)).getMessageView().setMaxLines(10);
                v1_12.setAnimationMode(0);
                v0_3.g(new p5.j(9, v0_3, this));
                v0_3.h();
            }
        } else {
            uc.d v0_4 = this.p();
            vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel v1_16 = this.w;
            if (v1_16 != null) {
                if (this.y) {
                    v0_4.t.setVisibility(0);
                }
                int v4_16 = new vet.pharmapedia.vetpharmapediapakistan.utils.b(v1_16.getOverview(), String.valueOf(this.l().A()));
                this.B = v4_16;
                v4_16.j = new vc.f(1, v0_4, v1_16, this);
                v4_16.a();
            }
            uc.d v0_5 = this.p();
            vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel v1_17 = this.w;
            if (v1_17 != null) {
                if (this.z) {
                    v0_5.s.setVisibility(0);
                }
                vet.pharmapedia.vetpharmapediapakistan.utils.b v2_0 = new vet.pharmapedia.vetpharmapediapakistan.utils.b(v1_17.getIndications(), String.valueOf(this.l().A()));
                this.B = v2_0;
                v2_0.j = new vc.f(0, v0_5, v1_17, this);
                v2_0.a();
            }
            uc.d v0_1 = this.p();
            vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel v1_1 = this.w;
            if (v1_1 != null) {
                if (this.z) {
                    v0_1.r.setVisibility(0);
                }
                vet.pharmapedia.vetpharmapediapakistan.utils.b v2_4 = new vet.pharmapedia.vetpharmapediapakistan.utils.b(v1_1.getContraIndications(), String.valueOf(this.l().A()));
                this.B = v2_4;
                v2_4.j = new vc.f(2, v0_1, v1_1, this);
                v2_4.a();
                return;
            }
        }
        return;
    }
}
