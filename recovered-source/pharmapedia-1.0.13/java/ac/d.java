// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ac;
public final synthetic class d implements ua.l {
    public final synthetic int g;
    public final synthetic Object h;
    public final synthetic Object i;

    public synthetic d(int p1, Object p2, Object p3)
    {
        this.g = p1;
        this.h = p2;
        this.i = p3;
        return;
    }

    public final Object invoke(Object p36)
    {
        switch (this.g) {
            case 0:
                int v3_8 = ((ac.e) this.i);
                ((java.io.IOException) p36).getClass();
                try {
                    v3_8.g();
                    return ga.p.a;
                } catch (Throwable v0_10) {
                    throw v0_10;
                }
            case 1:
                ((androidx.lifecycle.i0) this.h).j(((p.a) this.i).apply(p36));
                return ga.p.a;
            case 2:
                return com.google.firebase.firestore.pipeline.Field.a(((com.google.firebase.firestore.pipeline.Field) this.h), ((com.google.firebase.firestore.pipeline.evaluation.EvaluationContext) this.i), ((com.google.firebase.firestore.model.MutableDocument) this));
            case 3:
                ((hb.d) this.h).i.removeCallbacks(((b3.c) this.i));
                return ga.p.a;
            case 4:
                int v3_13 = ((String) this.h);
                ((e2.a) p36).getClass();
                Throwable v2_0 = ((e2.a) p36).b0("SELECT * FROM medicines_table WHERE saltName = ?");
                try {
                    v2_0.x(1, v3_13);
                    int v3_11 = jc.g.i(v2_0, "docId");
                    int v5_0 = jc.g.i(v2_0, "timeStamp");
                    int v6_2 = jc.g.i(v2_0, "saltName");
                    int v7_2 = jc.g.i(v2_0, "brandName");
                    int v8_1 = jc.g.i(v2_0, "contraIndications");
                    int v9_1 = jc.g.i(v2_0, "overview");
                    int v10_1 = jc.g.i(v2_0, "indications");
                    int v11_1 = jc.g.i(v2_0, "companyName");
                    int v12_1 = jc.g.i(v2_0, "countryName");
                    int v13_1 = jc.g.i(v2_0, "isBrandFavourite");
                    int v14_1 = jc.g.i(v2_0, "isSaltFavourite");
                    int v15_1 = jc.g.i(v2_0, "block");
                    Throwable v0_17 = jc.g.i(v2_0, "availableForms");
                    int v16 = jc.g.i(v2_0, "dosageDetail");
                    java.util.ArrayList v1_4 = new java.util.ArrayList();
                } catch (Throwable v0_19) {
                    v2_0.close();
                    throw v0_19;
                }
                while (v2_0.V()) {
                    int v29;
                    String v19 = v2_0.K(v3_11);
                    long v20 = v2_0.getLong(v5_0);
                    String v22 = v2_0.K(v6_2);
                    String v23 = v2_0.K(v7_2);
                    String v24 = v2_0.K(v8_1);
                    String v25 = v2_0.K(v9_1);
                    String v26 = v2_0.K(v10_1);
                    String v27 = v2_0.K(v11_1);
                    String v28 = v2_0.K(v12_1);
                    int v17_1 = v5_0;
                    int v34 = v6_2;
                    if (((int) v2_0.getLong(v13_1)) == 0) {
                        v29 = 0;
                    } else {
                        v29 = 1;
                    }
                    int v5_4 = v7_2;
                    int v30;
                    if (((int) v2_0.getLong(v14_1)) == 0) {
                        v30 = 0;
                    } else {
                        v30 = 1;
                    }
                    int v6_1 = v16;
                    v1_4.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel(v19, v20, v22, v23, v24, v25, v26, v27, v28, v29, v30, v2_0.K(v15_1), pc.h.d(v2_0.K(v0_17)), q0.v.n(v2_0.K(v6_1))));
                    v7_2 = v5_4;
                    v16 = v6_1;
                    v5_0 = v17_1;
                    v6_2 = v34;
                }
                v2_0.close();
                return v1_4;
            default:
                Throwable v2_9 = ((tc.e) this.h);
                int v3_10 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) this.i);
                ((e2.a) p36).getClass();
                Throwable v2_10 = v2_9.b;
                tc.e v4_1 = ((e2.a) p36).b0("INSERT OR REPLACE INTO `medicines_table` (`docId`,`timeStamp`,`saltName`,`brandName`,`contraIndications`,`overview`,`indications`,`companyName`,`countryName`,`isBrandFavourite`,`isSaltFavourite`,`block`,`availableForms`,`dosageDetail`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                try {
                    v2_10.m(v4_1, v3_10);
                    v4_1.V();
                    com.bumptech.glide.j.F(v4_1, 0);
                    return ga.p.a;
                } catch (Throwable v0_14) {
                    Throwable v2_11 = v0_14;
                    try {
                        throw v2_11;
                    } catch (Throwable v0_15) {
                        com.bumptech.glide.j.F(v4_1, v2_11);
                        throw v0_15;
                    }
                }
        }
    }
}
