// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.activities;
public final class DosageDetailActivity extends qc.b {
    public static final synthetic int z;
    public boolean u;
    public uc.f v;
    public vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel w;
    public rc.i x;
    public final java.util.ArrayList y;

    public DosageDetailActivity()
    {
        this.u = 0;
        this.addOnContextAvailableListener(new vc.p(this, 5));
        this.y = new java.util.ArrayList();
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
            uc.f v0_7 = ((qc.f) ((vc.m) this.a()));
            com.bumptech.glide.q v1_3 = v0_7.b;
            this.p = ((xc.g) v1_3.e.get());
            this.q = ((xc.h) v1_3.f.get());
            this.r = v1_3.a();
            this.s = ((tc.b) v1_3.i.get());
            this.t = ((com.bumptech.glide.q) v1_3.j.get());
            this.v = ((uc.f) v0_7.j.get());
        }
        return;
    }

    public final void onCreate(android.os.Bundle p13)
    {
        super.onCreate(p13);
        androidx.appcompat.widget.AppCompatImageView v13_1 = this.v;
        if (v13_1 == null) {
            kotlin.jvm.internal.f.i("binding");
            throw 0;
        } else {
            this.setContentView(v13_1.a);
            this.x = new rc.i(this.l(), this.i(), this.j(), this);
            androidx.appcompat.widget.AppCompatImageView v13_3 = this.getIntent();
            if (v13_3 != null) {
                androidx.appcompat.widget.AppCompatImageView v13_4 = v13_3.getExtras();
                if (v13_4 != null) {
                    androidx.appcompat.widget.AppCompatImageView v13_6;
                    if (android.os.Build$VERSION.SDK_INT < 33) {
                        androidx.appcompat.widget.AppCompatImageView v13_5 = v13_4.getSerializable("MedicinesModel");
                        if (!(v13_5 instanceof vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel)) {
                            v13_5 = 0;
                        }
                        v13_6 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) v13_5);
                    } else {
                        v13_6 = androidx.activity.q.i(v13_4);
                    }
                    this.w = ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) v13_6);
                }
            }
            androidx.appcompat.widget.AppCompatImageView v13_8 = this.w;
            if (v13_8 != null) {
                androidx.appcompat.widget.AppCompatImageView v13_9 = v13_8.getDosageDetail();
                rc.i v3_3 = v13_9.keySet().iterator();
                while(true) {
                    java.util.ArrayList v5 = this.y;
                    if (!v3_3.hasNext()) {
                        break;
                    }
                    String v7_1 = ((String) v3_3.next());
                    String v8_1 = ((String) v13_9.get(v7_1));
                    v8_1.getClass();
                    v5.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel(v7_1, v8_1, 0, 4, 0));
                }
                androidx.appcompat.widget.AppCompatImageView v13_10 = this.x;
                if (v13_10 == null) {
                    kotlin.jvm.internal.f.i("dosageDetailAdapter");
                    throw 0;
                } else {
                    v13_10.l(v5);
                }
            }
            androidx.appcompat.widget.AppCompatImageView v13_11 = this.v;
            if (v13_11 == null) {
                kotlin.jvm.internal.f.i("binding");
                throw 0;
            } else {
                vc.a v0_1 = v13_11.c;
                this.j();
                v0_1.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager());
                rc.i v3_6 = this.x;
                if (v3_6 == null) {
                    kotlin.jvm.internal.f.i("dosageDetailAdapter");
                    throw 0;
                } else {
                    v0_1.setAdapter(v3_6);
                    v13_11.b.setOnClickListener(new vc.a(this, 4));
                    return;
                }
            }
        }
    }

    public final void onDestroy()
    {
        super.onDestroy();
        xc.a.b.j(Boolean.TRUE);
        return;
    }
}
