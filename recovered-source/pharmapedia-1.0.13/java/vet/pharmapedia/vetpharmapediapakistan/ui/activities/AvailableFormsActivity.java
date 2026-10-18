// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.activities;
public final class AvailableFormsActivity extends qc.b {
    public static final synthetic int y;
    public boolean u;
    public uc.b v;
    public vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel w;
    public rc.p x;

    public AvailableFormsActivity()
    {
        this.u = 0;
        this.addOnContextAvailableListener(new vc.p(this, 1));
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
            uc.b v0_7 = ((qc.f) ((vc.d) this.a()));
            com.bumptech.glide.q v1_3 = v0_7.b;
            this.p = ((xc.g) v1_3.e.get());
            this.q = ((xc.h) v1_3.f.get());
            this.r = v1_3.a();
            this.s = ((tc.b) v1_3.i.get());
            this.t = ((com.bumptech.glide.q) v1_3.j.get());
            this.v = ((uc.b) v0_7.f.get());
        }
        return;
    }

    public final void onCreate(android.os.Bundle p14)
    {
        super.onCreate(p14);
        androidx.appcompat.widget.AppCompatImageView v14_1 = this.v;
        if (v14_1 == null) {
            kotlin.jvm.internal.f.i("binding");
            throw 0;
        } else {
            this.setContentView(v14_1.a);
            this.x = new rc.p(this.l(), this.i(), this.j(), this);
            androidx.appcompat.widget.AppCompatImageView v14_5 = this.getIntent();
            if (v14_5 != null) {
                androidx.appcompat.widget.AppCompatImageView v14_6 = v14_5.getExtras();
                if (v14_6 != null) {
                    androidx.appcompat.widget.AppCompatImageView v14_8;
                    if (android.os.Build$VERSION.SDK_INT < 33) {
                        androidx.appcompat.widget.AppCompatImageView v14_7 = v14_6.getSerializable("MedicinesModel");
                        if (!(v14_7 instanceof vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel)) {
                            v14_7 = 0;
                        }
                        v14_8 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) v14_7);
                    } else {
                        v14_8 = androidx.activity.q.i(v14_6);
                    }
                    this.w = ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) v14_8);
                }
            }
            androidx.appcompat.widget.AppCompatImageView v14_10 = this.w;
            try {
                if (v14_10 != null) {
                    rc.p v2_4 = v14_10.getAvailableForms();
                    java.util.HashMap v3_3 = new java.util.HashMap();
                    String v4_2 = v2_4.keySet().iterator();
                    while (v4_2.hasNext()) {
                        vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel v5_7 = ((String) v4_2.next());
                        java.util.ArrayList v6_4 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.AvailableFormsModel) v2_4.get(v5_7));
                        String v12 = db.i.o0(new kotlin.text.Regex("\\d+$").c(v5_7)).toString();
                        if (v6_4 != null) {
                            int v7_0 = new vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsDetailModel(v6_4.getPacking(), v6_4.getPrice(), v6_4.getWeight(), v14_10.getSaltName(), v12);
                            vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel v5_1 = ((java.util.ArrayList) v3_3.get(v12));
                            if (v5_1 == null) {
                                v5_1 = new java.util.ArrayList();
                            }
                            v5_1.add(v7_0);
                            v3_3.put(v12, v5_1);
                        }
                    }
                    androidx.appcompat.widget.AppCompatImageView v14_12 = new java.util.ArrayList();
                    rc.p v2_5 = v3_3.keySet();
                    v2_5.getClass();
                    rc.p v2_6 = v2_5.iterator();
                    while (v2_6.hasNext()) {
                        String v4_5 = ((String) v2_6.next());
                        java.util.ArrayList v6_1 = ((java.util.ArrayList) v3_3.get(v4_5));
                        if (v6_1 == null) {
                            v6_1 = new java.util.ArrayList();
                        }
                        v14_12.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel(v4_5, 0, v6_1));
                    }
                    rc.p v2_7 = this.x;
                    if (v2_7 != null) {
                        v2_7.l(v14_12);
                    }
                }
            } catch (Exception) {
            }
            androidx.appcompat.widget.AppCompatImageView v14_2 = this.v;
            if (v14_2 == null) {
                kotlin.jvm.internal.f.i("binding");
                throw 0;
            } else {
                vc.a v0_0 = v14_2.c;
                this.j();
                v0_0.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager());
                int v1_2 = this.x;
                if (v1_2 != 0) {
                    v0_0.setAdapter(v1_2);
                }
                v14_2.b.setOnClickListener(new vc.a(this, 1));
                return;
            }
        }
    }
}
