// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.fragments;
final class HomeFragment$readLatestMedicinesDataFromFirebase$1$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements ua.p {
    public final synthetic com.google.firebase.firestore.QuerySnapshot g;
    public final synthetic wc.l h;
    public final synthetic kotlin.jvm.internal.Ref$IntRef i;
    public final synthetic int j;

    public HomeFragment$readLatestMedicinesDataFromFirebase$1$1(com.google.firebase.firestore.QuerySnapshot p1, wc.l p2, kotlin.jvm.internal.Ref$IntRef p3, int p4, ka.c p5)
    {
        this.g = p1;
        this.h = p2;
        this.i = p3;
        this.j = p4;
        super(2, p5);
        return;
    }

    public final ka.c create(Object p7, ka.c p8)
    {
        return new vet.pharmapedia.vetpharmapediapakistan.ui.fragments.HomeFragment$readLatestMedicinesDataFromFirebase$1$1(this.g, this.h, this.i, this.j, p8);
    }

    public final Object invoke(Object p1, Object p2)
    {
        ga.p v2_2 = ga.p.a;
        ((vet.pharmapedia.vetpharmapediapakistan.ui.fragments.HomeFragment$readLatestMedicinesDataFromFirebase$1$1) this.create(((gb.v) p1), ((ka.c) p2))).invokeSuspend(v2_2);
        return v2_2;
    }

    public final Object invokeSuspend(Object p8)
    {
        kotlin.b.b(p8);
        ga.p v8_8 = this.g.iterator();
        v8_8.getClass();
        do {
            String v3_0 = this.h;
            if (!v8_8.hasNext()) {
                ((android.content.SharedPreferences) v3_0.j().h).edit().putBoolean("IS_DATA_FETCHED_KEY", 1).apply();
                return ga.p.a;
            } else {
                java.util.Iterator v0_1 = ((com.google.firebase.firestore.QueryDocumentSnapshot) v8_8.next());
                if (!((android.content.SharedPreferences) v3_0.j().h).getBoolean("IS_DATA_FETCHED_KEY", 0)) {
                    v3_0.h().runOnUiThread(new u1.a(this.i, this.j, 1, v3_0));
                }
                java.util.Map v1_0 = v0_1.getId();
                String v2_3 = new StringBuilder("readMedicinesData: docId: ");
                v2_3.append(v1_0);
                android.util.Log.d("myMedicinesData", v2_3.toString());
                java.util.Map v1_3 = v0_1.toObject(vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel);
                v1_3.getClass();
                java.util.Map v1_4 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) v1_3);
                java.util.Iterator v0_2 = v0_1.getId();
                v0_2.getClass();
                v1_4.setDocId(v0_2);
                gb.w.p(gb.w.b(nb.c.i), 0, new vet.pharmapedia.vetpharmapediapakistan.ui.fragments.HomeFragment$insertDataToRoomDB$1(v3_0, v1_4, 0), 3);
                java.util.Iterator v0_6 = v1_4.getAvailableForms();
                java.util.Map v1_5 = v1_4.getDosageDetail();
                String v3_4 = v0_6.keySet().iterator();
                while (v3_4.hasNext()) {
                    String v4_3 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.AvailableFormsModel) v0_6.get(((String) v3_4.next())));
                    v4_3.getClass();
                    r1.a.A("readMedicinesData:Forms data ", v4_3.getPacking(), "myMedicinesData");
                }
                java.util.Iterator v0_8 = v1_5.keySet().iterator();
            }
        } while(!v0_8.hasNext());
        String v3_7 = ((String) v0_8.next());
        String v4_15 = ((String) v1_5.get(v3_7));
        StringBuilder v5_5 = new StringBuilder("readMedicinesData: dosage data: ");
        v5_5.append(v3_7);
        v5_5.append(" - ");
        v5_5.append(v4_15);
        android.util.Log.d("myMedicinesData", v5_5.toString());
        while (v0_8.hasNext()) {
        }
    }
}
