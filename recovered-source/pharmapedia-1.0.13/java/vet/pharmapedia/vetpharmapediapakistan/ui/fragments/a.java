// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.fragments;
public final synthetic class a implements ua.l {
    public final synthetic wc.l g;

    public synthetic a(wc.l p1)
    {
        this.g = p1;
        return;
    }

    public final Object invoke(Object p10)
    {
        ((com.google.firebase.firestore.QuerySnapshot) p10).getClass();
        int v4 = ((com.google.firebase.firestore.QuerySnapshot) p10).size();
        kotlin.jvm.internal.Ref$IntRef v3_1 = new kotlin.jvm.internal.Ref$IntRef();
        if (((com.google.firebase.firestore.QuerySnapshot) p10).size() <= 0) {
            android.util.Log.d("myMedicinesData", "readMedicinesData: no data");
        } else {
            long v7;
            int v2_0 = this.g;
            String v10_2 = v2_0.j();
            vet.pharmapedia.vetpharmapediapakistan.ui.fragments.HomeFragment$readLatestMedicinesDataFromFirebase$1$1 v0_0 = ((com.google.firebase.firestore.QuerySnapshot) p10).getDocuments();
            v0_0.getClass();
            vet.pharmapedia.vetpharmapediapakistan.ui.fragments.HomeFragment$readLatestMedicinesDataFromFirebase$1$1 v0_4 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) ((com.google.firebase.firestore.DocumentSnapshot) ha.j.E(v0_0)).toObject(vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel));
            if (v0_4 == null) {
                v7 = 0;
            } else {
                v7 = v0_4.getTimeStamp();
            }
            ((android.content.SharedPreferences) v10_2.h).edit().putLong("KEY_LAST_FETCHED", v7).apply();
            gb.w.p(gb.w.b(nb.c.i), 0, new vet.pharmapedia.vetpharmapediapakistan.ui.fragments.HomeFragment$readLatestMedicinesDataFromFirebase$1$1(((com.google.firebase.firestore.QuerySnapshot) p10), v2_0, v3_1, v4, 0), 3);
            android.util.Log.d("myMedicinesData", "readMedicinesData:read Done Done Done Done");
        }
        return ga.p.a;
    }
}
