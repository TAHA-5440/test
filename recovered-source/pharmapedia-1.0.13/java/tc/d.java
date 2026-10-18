// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package tc;
public final synthetic class d implements ua.l {
    public final synthetic int g;
    public final synthetic tc.e h;

    public synthetic d(tc.e p1, int p2)
    {
        this.g = p2;
        this.h = p1;
        return;
    }

    public final Object invoke(Object p35)
    {
        switch (this.g) {
            case 0:
                ((e2.a) p35).getClass();
                e2.c v2_2 = ((e2.a) p35).b0("SELECT * FROM medicines_table WHERE isBrandFavourite=1");
                try {
                    int v3_4 = jc.g.i(v2_2, "docId");
                    int v4_4 = jc.g.i(v2_2, "timeStamp");
                    int v5_4 = jc.g.i(v2_2, "saltName");
                    int v6_1 = jc.g.i(v2_2, "brandName");
                    int v7_1 = jc.g.i(v2_2, "contraIndications");
                    int v8_1 = jc.g.i(v2_2, "overview");
                    int v9_1 = jc.g.i(v2_2, "indications");
                    int v10_1 = jc.g.i(v2_2, "companyName");
                    int v11_1 = jc.g.i(v2_2, "countryName");
                    int v12_1 = jc.g.i(v2_2, "isBrandFavourite");
                    int v13_1 = jc.g.i(v2_2, "isSaltFavourite");
                    int v14_1 = jc.g.i(v2_2, "block");
                    int v15_1 = jc.g.i(v2_2, "availableForms");
                    int v35_2 = jc.g.i(v2_2, "dosageDetail");
                    java.util.ArrayList v1_4 = new java.util.ArrayList();
                } catch (Throwable v0_2) {
                    v2_2.close();
                    throw v0_2;
                }
                while (v2_2.V()) {
                    int v28_0;
                    String v18_0 = v2_2.K(v3_4);
                    long v19_0 = v2_2.getLong(v4_4);
                    String v21_0 = v2_2.K(v5_4);
                    String v22_0 = v2_2.K(v6_1);
                    String v23_0 = v2_2.K(v7_1);
                    String v24_0 = v2_2.K(v8_1);
                    String v25_0 = v2_2.K(v9_1);
                    String v26_0 = v2_2.K(v10_1);
                    String v27_0 = v2_2.K(v11_1);
                    int v16_1 = v3_4;
                    int v33_0 = v4_4;
                    if (((int) v2_2.getLong(v12_1)) == 0) {
                        v28_0 = 0;
                    } else {
                        v28_0 = 1;
                    }
                    int v3_7 = v5_4;
                    int v29_0;
                    if (((int) v2_2.getLong(v13_1)) == 0) {
                        v29_0 = 0;
                    } else {
                        v29_0 = 1;
                    }
                    int v4_9 = v35_2;
                    v1_4.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel(v18_0, v19_0, v21_0, v22_0, v23_0, v24_0, v25_0, v26_0, v27_0, v28_0, v29_0, v2_2.K(v14_1), pc.h.d(v2_2.K(v15_1)), q0.v.n(v2_2.K(v4_9))));
                    v5_4 = v3_7;
                    v35_2 = v4_9;
                    v3_4 = v16_1;
                    v4_4 = v33_0;
                }
                v2_2.close();
                return v1_4;
            case 1:
                ((e2.a) p35).getClass();
                e2.c v2_8 = ((e2.a) p35).b0("SELECT * FROM medicines_table WHERE isSaltFavourite=1");
                try {
                    int v3_1 = jc.g.i(v2_8, "docId");
                    int v4_2 = jc.g.i(v2_8, "timeStamp");
                    int v5_2 = jc.g.i(v2_8, "saltName");
                    int v6_3 = jc.g.i(v2_8, "brandName");
                    int v7_3 = jc.g.i(v2_8, "contraIndications");
                    int v8_5 = jc.g.i(v2_8, "overview");
                    int v9_5 = jc.g.i(v2_8, "indications");
                    int v10_5 = jc.g.i(v2_8, "companyName");
                    int v11_5 = jc.g.i(v2_8, "countryName");
                    int v12_5 = jc.g.i(v2_8, "isBrandFavourite");
                    int v13_5 = jc.g.i(v2_8, "isSaltFavourite");
                    int v14_5 = jc.g.i(v2_8, "block");
                    int v15_5 = jc.g.i(v2_8, "availableForms");
                    int v35_1 = jc.g.i(v2_8, "dosageDetail");
                    java.util.ArrayList v1_12 = new java.util.ArrayList();
                } catch (Throwable v0_6) {
                    v2_8.close();
                    throw v0_6;
                }
                while (v2_8.V()) {
                    int v28_2;
                    String v18_2 = v2_8.K(v3_1);
                    long v19_2 = v2_8.getLong(v4_2);
                    String v21_2 = v2_8.K(v5_2);
                    String v22_2 = v2_8.K(v6_3);
                    String v23_2 = v2_8.K(v7_3);
                    String v24_2 = v2_8.K(v8_5);
                    String v25_2 = v2_8.K(v9_5);
                    String v26_2 = v2_8.K(v10_5);
                    String v27_2 = v2_8.K(v11_5);
                    int v16_5 = v3_1;
                    int v33_2 = v4_2;
                    if (((int) v2_8.getLong(v12_5)) == 0) {
                        v28_2 = 0;
                    } else {
                        v28_2 = 1;
                    }
                    int v3_17 = v5_2;
                    int v29_2;
                    if (((int) v2_8.getLong(v13_5)) == 0) {
                        v29_2 = 0;
                    } else {
                        v29_2 = 1;
                    }
                    int v4_1 = v35_1;
                    v1_12.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel(v18_2, v19_2, v21_2, v22_2, v23_2, v24_2, v25_2, v26_2, v27_2, v28_2, v29_2, v2_8.K(v14_5), pc.h.d(v2_8.K(v15_5)), q0.v.n(v2_8.K(v4_1))));
                    v5_2 = v3_17;
                    v35_1 = v4_1;
                    v3_1 = v16_5;
                    v4_2 = v33_2;
                }
                v2_8.close();
                return v1_12;
            default:
                ((e2.a) p35).getClass();
                e2.c v2_5 = ((e2.a) p35).b0("SELECT * FROM medicines_table");
                try {
                    int v3_10 = jc.g.i(v2_5, "docId");
                    int v4_11 = jc.g.i(v2_5, "timeStamp");
                    int v5_9 = jc.g.i(v2_5, "saltName");
                    int v6_5 = jc.g.i(v2_5, "brandName");
                    int v7_5 = jc.g.i(v2_5, "contraIndications");
                    int v8_4 = jc.g.i(v2_5, "overview");
                    int v9_3 = jc.g.i(v2_5, "indications");
                    int v10_3 = jc.g.i(v2_5, "companyName");
                    int v11_3 = jc.g.i(v2_5, "countryName");
                    int v12_3 = jc.g.i(v2_5, "isBrandFavourite");
                    int v13_3 = jc.g.i(v2_5, "isSaltFavourite");
                    int v14_3 = jc.g.i(v2_5, "block");
                    int v15_3 = jc.g.i(v2_5, "availableForms");
                    int v35_3 = jc.g.i(v2_5, "dosageDetail");
                    java.util.ArrayList v1_8 = new java.util.ArrayList();
                } catch (Throwable v0_5) {
                    v2_5.close();
                    throw v0_5;
                }
                while (v2_5.V()) {
                    int v28_1;
                    String v18_1 = v2_5.K(v3_10);
                    long v19_1 = v2_5.getLong(v4_11);
                    String v21_1 = v2_5.K(v5_9);
                    String v22_1 = v2_5.K(v6_5);
                    String v23_1 = v2_5.K(v7_5);
                    String v24_1 = v2_5.K(v8_4);
                    String v25_1 = v2_5.K(v9_3);
                    String v26_1 = v2_5.K(v10_3);
                    String v27_1 = v2_5.K(v11_3);
                    int v16_3 = v3_10;
                    int v33_1 = v4_11;
                    if (((int) v2_5.getLong(v12_3)) == 0) {
                        v28_1 = 0;
                    } else {
                        v28_1 = 1;
                    }
                    int v3_13 = v5_9;
                    int v29_1;
                    if (((int) v2_5.getLong(v13_3)) == 0) {
                        v29_1 = 0;
                    } else {
                        v29_1 = 1;
                    }
                    int v4_15 = v35_3;
                    v1_8.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel(v18_1, v19_1, v21_1, v22_1, v23_1, v24_1, v25_1, v26_1, v27_1, v28_1, v29_1, v2_5.K(v14_3), pc.h.d(v2_5.K(v15_3)), q0.v.n(v2_5.K(v4_15))));
                    v5_9 = v3_13;
                    v35_3 = v4_15;
                    v3_10 = v16_3;
                    v4_11 = v33_1;
                }
                v2_5.close();
                return v1_8;
        }
    }
}
