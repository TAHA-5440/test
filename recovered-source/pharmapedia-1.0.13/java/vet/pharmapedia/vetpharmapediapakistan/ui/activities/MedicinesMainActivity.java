// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.activities;
public final class MedicinesMainActivity extends qc.b {
    public static final synthetic int A;
    public boolean u;
    public uc.j v;
    public rc.d w;
    public final java.util.ArrayList x;
    public vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel y;
    public boolean z;

    public MedicinesMainActivity()
    {
        this.u = 0;
        this.addOnContextAvailableListener(new vc.p(this, 9));
        this.x = new java.util.ArrayList();
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
            uc.j v0_7 = ((qc.f) ((vc.x) this.a()));
            com.bumptech.glide.q v1_3 = v0_7.b;
            this.p = ((xc.g) v1_3.e.get());
            this.q = ((xc.h) v1_3.f.get());
            this.r = v1_3.a();
            this.s = ((tc.b) v1_3.i.get());
            this.t = ((com.bumptech.glide.q) v1_3.j.get());
            this.v = ((uc.j) v0_7.n.get());
        }
        return;
    }

    public final void onCreate(android.os.Bundle p17)
    {
        super.onCreate(p17);
        this.setContentView(this.p().a);
        androidx.recyclerview.widget.GridLayoutManager v1_20 = this.getIntent();
        if (v1_20 != null) {
            androidx.recyclerview.widget.GridLayoutManager v1_1 = v1_20.getExtras();
            if (v1_1 != null) {
                vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel v4_4;
                if (android.os.Build$VERSION.SDK_INT < 33) {
                    vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel v4_3 = v1_1.getSerializable("MedicinesModel");
                    if (!(v4_3 instanceof vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel)) {
                        v4_3 = 0;
                    }
                    v4_4 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) v4_3);
                } else {
                    v4_4 = androidx.activity.q.i(v1_1);
                }
                this.y = ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) v4_4);
                this.z = v1_1.getBoolean("brandSelected", 0);
            }
        }
        this.w = new rc.d(this);
        vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel v4_8 = this.getString(2131951667);
        v4_8.getClass();
        vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel v4_9 = this.x;
        v4_9.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel(v4_8, 2131230844));
        boolean v5_5 = this.getString(2131951999);
        v5_5.getClass();
        v4_9.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel(v5_5, 2131231264));
        boolean v5_7 = this.getString(2131952015);
        v5_7.getClass();
        v4_9.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel(v5_7, 2131231268));
        boolean v5_9 = this.getString(2131951752);
        v5_9.getClass();
        v4_9.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel(v5_9, 2131230898));
        boolean v5_11 = this.getString(2131951998);
        v5_11.getClass();
        v4_9.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel(v5_11, 2131231263));
        boolean v5_13 = this.getString(2131951814);
        v5_13.getClass();
        v4_9.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel(v5_13, 2131231124));
        boolean v5_15 = this.getString(2131951735);
        v5_15.getClass();
        v4_9.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel(v5_15, 2131230883));
        boolean v5_17 = this.getString(2131951653);
        v5_17.getClass();
        v4_9.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel(v5_17, 2131230841));
        androidx.recyclerview.widget.GridLayoutManager v1_28 = this.w;
        if (v1_28 == null) {
            kotlin.jvm.internal.f.i("medicinesMainItemsAdapter");
            throw 0;
        } else {
            int v17_2;
            v1_28.l(v4_9);
            androidx.recyclerview.widget.GridLayoutManager v1_0 = this.p();
            vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel v4_0 = v1_0.j;
            int v6_0 = v1_0.h;
            boolean v7_0 = v1_0.f;
            androidx.appcompat.widget.AppCompatImageView v8 = v1_0.b;
            androidx.appcompat.widget.AppCompatTextView v9 = v1_0.g;
            androidx.appcompat.widget.AppCompatTextView v10 = v1_0.e;
            vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel v11 = this.y;
            if (v11 == null) {
                v17_2 = 0;
            } else {
                String v13_0 = v1_0.i;
                if (!this.z) {
                    v13_0.setText(v11.getSaltName());
                } else {
                    v13_0.setText(v11.getBrandName());
                }
                v17_2 = 0;
                if ((v11.getCompanyName().length() != 0) && ((!kotlin.jvm.internal.f.a(v11.getCompanyName(), "")) && ((!kotlin.jvm.internal.f.a(v11.getCompanyName(), "null")) && (!kotlin.jvm.internal.f.a(v11.getCompanyName(), "Null"))))) {
                    v10.setText(v11.getCompanyName());
                    v10.setVisibility(0);
                    v7_0.setVisibility(0);
                } else {
                    v10.setVisibility(8);
                    v7_0.setVisibility(8);
                }
                if ((v11.getCountryName().length() != 0) && ((!kotlin.jvm.internal.f.a(v11.getCountryName(), "")) && ((!kotlin.jvm.internal.f.a(v11.getCountryName(), "null")) && (!kotlin.jvm.internal.f.a(v11.getCountryName(), "Null"))))) {
                    v9.setText(v11.getCountryName());
                    v9.setVisibility(0);
                    v6_0.setVisibility(0);
                } else {
                    v9.setVisibility(8);
                    v6_0.setVisibility(8);
                }
                if ((!v11.isBrandFavourite()) || (!this.z)) {
                    if (!v11.isSaltFavourite()) {
                        v8.setImageResource(2131230840);
                    } else {
                        v8.setImageResource(2131231274);
                    }
                } else {
                    v8.setImageResource(2131231274);
                }
                v8.setOnClickListener(new vc.u(0, v11, this));
                v1_0.d.setOnClickListener(new vc.u(1, v11, this));
            }
            v1_0.c.setOnClickListener(new vc.a(this, 7));
            androidx.recyclerview.widget.GridLayoutManager v1_3 = this.w;
            if (v1_3 == null) {
                kotlin.jvm.internal.f.i("medicinesMainItemsAdapter");
                throw v17_2;
            } else {
                v4_0.setAdapter(v1_3);
                v4_0.setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager(this.j(), 2));
                return;
            }
        }
    }

    public final uc.j p()
    {
        int v0_0 = this.v;
        if (v0_0 == 0) {
            kotlin.jvm.internal.f.i("binding");
            throw 0;
        } else {
            return v0_0;
        }
    }
}
