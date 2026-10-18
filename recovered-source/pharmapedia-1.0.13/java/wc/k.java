// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package wc;
public final class k implements android.text.TextWatcher {
    public final synthetic wc.l g;
    public final synthetic uc.q h;

    public k(wc.l p1, uc.q p2)
    {
        this.g = p1;
        this.h = p2;
        return;
    }

    public final void afterTextChanged(android.text.Editable p10)
    {
        rc.x v0_0 = this.g;
        try {
            java.util.ArrayList v2_2;
            java.util.HashSet v3_0 = v0_0.w;
        } catch (Exception) {
            rc.x v0_2 = this.h;
            java.util.ArrayList v2_4 = v0_2.b;
            if (db.i.o0(String.valueOf(p10)).toString().length() != 0) {
                v2_4.setVisibility(0);
            } else {
                v2_4.setVisibility(8);
                v0_2.d.Z(0);
            }
            return;
        }
        if (!v0_0.C) {
            v2_2 = new java.util.ArrayList();
            java.util.HashSet v3_5 = v3_0.iterator();
            while (v3_5.hasNext()) {
                int v5_1 = v3_5.next();
                if (db.i.T(((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) v5_1).getSaltName(), db.i.o0(String.valueOf(p10)).toString(), 1)) {
                    v2_2.add(v5_1);
                }
            }
        } else {
            v2_2 = new java.util.ArrayList();
            java.util.HashSet v3_1 = v3_0.iterator();
            while (v3_1.hasNext()) {
                int v5_5 = v3_1.next();
                if (db.i.T(((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) v5_5).getBrandName(), db.i.o0(String.valueOf(p10)).toString(), 1)) {
                    v2_2.add(v5_5);
                }
            }
        }
        rc.x v0_1 = v0_0.v;
        if (!v0_0.C) {
            if (v0_1 == null) {
                kotlin.jvm.internal.f.i("saltsAndBrandsAdapter");
                throw 0;
            } else {
                java.util.HashSet v3_4 = new java.util.HashSet();
                java.util.ArrayList v4_3 = new java.util.ArrayList();
                int v5_4 = v2_2.size();
                int v6_4 = 0;
                while (v6_4 < v5_4) {
                    Object v7_3 = v2_2.get(v6_4);
                    v6_4++;
                    if (v3_4.add(db.i.o0(((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) v7_3).getSaltName()).toString())) {
                        v4_3.add(v7_3);
                    }
                }
                v0_1.l(v4_3);
            }
        } else {
            if (v0_1 == null) {
                kotlin.jvm.internal.f.i("saltsAndBrandsAdapter");
                throw 0;
            } else {
                v0_1.l(v2_2);
            }
        }
    }

    public final void beforeTextChanged(CharSequence p1, int p2, int p3, int p4)
    {
        return;
    }

    public final void onTextChanged(CharSequence p1, int p2, int p3, int p4)
    {
        return;
    }
}
