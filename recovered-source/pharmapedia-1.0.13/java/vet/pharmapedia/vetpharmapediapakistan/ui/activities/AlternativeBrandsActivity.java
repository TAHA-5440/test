// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.activities;
public final class AlternativeBrandsActivity extends qc.b {
    public static final synthetic int A;
    public boolean u;
    public uc.a v;
    public rc.x w;
    public vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel x;
    public boolean y;
    public java.util.List z;

    public AlternativeBrandsActivity()
    {
        this.u = 0;
        this.addOnContextAvailableListener(new vc.p(this, 0));
        this.z = kotlin.collections.EmptyList.g;
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
            uc.a v0_7 = ((qc.f) ((vc.c) this.a()));
            com.bumptech.glide.q v1_3 = v0_7.b;
            this.p = ((xc.g) v1_3.e.get());
            this.q = ((xc.h) v1_3.f.get());
            this.r = v1_3.a();
            this.s = ((tc.b) v1_3.i.get());
            this.t = ((com.bumptech.glide.q) v1_3.j.get());
            this.v = ((uc.a) v0_7.e.get());
        }
        return;
    }

    public final void onCreate(android.os.Bundle p10)
    {
        super.onCreate(p10);
        this.setContentView(this.p().a);
        androidx.appcompat.widget.AppCompatImageView v10_9 = this.getIntent();
        if (v10_9 != null) {
            androidx.appcompat.widget.AppCompatImageView v10_2 = v10_9.getExtras();
            if (v10_2 != null) {
                int v2_4;
                if (android.os.Build$VERSION.SDK_INT < 33) {
                    int v2_3 = v10_2.getSerializable("MedicinesModel");
                    if (!(v2_3 instanceof vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel)) {
                        v2_3 = 0;
                    }
                    v2_4 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) v2_3);
                } else {
                    v2_4 = androidx.activity.q.i(v10_2);
                }
                this.x = ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) v2_4);
                this.y = v10_2.getBoolean("brandSelected", 0);
            }
        }
        this.w = new rc.x(this.j(), 1, this.k(), this.l(), this.i(), this);
        androidx.appcompat.widget.AppCompatImageView v10_6 = this.x;
        if (v10_6 != null) {
            int v2_9 = this.p();
            int v3_3 = this.w;
            if (v3_3 == 0) {
                kotlin.jvm.internal.f.i("saltsAndBrandsAdapter");
                throw 0;
            } else {
                v2_9.f.setAdapter(v3_3);
                p5.j v1_2 = this.k();
                androidx.appcompat.widget.AppCompatImageView v10_8 = v10_6.getSaltName();
                v10_8.getClass();
                p5.j v1_3 = v1_2.a;
                v1_3.getClass();
                v1_3.a.getInvalidationTracker().b(new String[] {"medicines_table"}), new ac.d(4, v10_8, v1_3)).d(this, new rc.h(new ac.c(this, 10), 3));
            }
        }
        androidx.appcompat.widget.AppCompatImageView v10_11 = this.p();
        if (!this.y) {
            v10_11.d.setText(this.getString(2131951666));
        }
        p5.j v1_9 = v10_11.f;
        this.j();
        v1_9.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager());
        v10_11.b.setOnClickListener(new vc.a(this, 0));
        vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel v0_1 = this.x;
        if (v0_1 != null) {
            v10_11.c.setOnClickListener(new p5.j(7, this, v0_1));
        }
        return;
    }

    public final uc.a p()
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
