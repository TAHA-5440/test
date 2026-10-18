// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package rc;
public final synthetic class u implements android.view.View$OnClickListener {
    public final synthetic int g;
    public final synthetic rc.w h;
    public final synthetic rc.x i;
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel j;

    public synthetic u(rc.w p1, rc.x p2, vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel p3, int p4)
    {
        this.g = p4;
        this.h = p1;
        this.i = p2;
        this.j = p3;
        return;
    }

    public final void onClick(android.view.View p15)
    {
        vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel v0 = this.j;
        android.app.Activity v1_1 = this.i;
        String v2_1 = this.h;
        switch (this.g) {
            case 0:
                xc.a.e = v2_1.b();
                android.app.Activity v1_0 = v1_1.e;
                if (!v1_1.f) {
                    int v15_3 = new android.content.Intent(v1_0, vet.pharmapedia.vetpharmapediapakistan.ui.activities.AlternativeBrandsActivity);
                    v15_3.putExtra("MedicinesModel", v0);
                    v15_3.putExtra("brandSelected", 0);
                    v1_0.startActivity(v15_3);
                } else {
                    int v15_5 = new android.content.Intent(v1_0, vet.pharmapedia.vetpharmapediapakistan.ui.activities.MedicinesMainActivity);
                    v15_5.putExtra("MedicinesModel", v0);
                    v15_5.putExtra("brandSelected", 1);
                    v1_0.startActivity(v15_5);
                }
                return;
            default:
                xc.a.e = v2_1.b();
                String v5_1 = v1_1.e;
                if (!v1_1.f) {
                    xc.a.d = 0;
                    android.app.Activity v8_0 = v1_1.e;
                    tc.b v9_0 = v1_1.g;
                    if (!v0.isSaltFavourite()) {
                        String v10_0 = v0.getSaltName();
                        String v12_0 = v5_1.getString(2131951649);
                        v12_0.getClass();
                        vet.pharmapedia.vetpharmapediapakistan.utils.a.b(v8_0, v9_0, v10_0, 1, v12_0, new rc.v(v1_1, v2_1, 3));
                    } else {
                        String v10_1 = v0.getSaltName();
                        String v12_1 = v5_1.getString(2131952025);
                        v12_1.getClass();
                        vet.pharmapedia.vetpharmapediapakistan.utils.a.b(v8_0, v9_0, v10_1, 0, v12_1, new rc.v(v1_1, v2_1, 2));
                    }
                } else {
                    xc.a.d = 1;
                    android.app.Activity v8_1 = v1_1.e;
                    tc.b v9_1 = v1_1.g;
                    if (!v0.isBrandFavourite()) {
                        String v10_2 = v0.getBrandName();
                        String v12_2 = v5_1.getString(2131951649);
                        v12_2.getClass();
                        vet.pharmapedia.vetpharmapediapakistan.utils.a.a(v8_1, v9_1, v10_2, 1, v12_2, new rc.v(v1_1, v2_1, 1));
                    } else {
                        String v10_3 = v0.getBrandName();
                        String v12_3 = v5_1.getString(2131952025);
                        v12_3.getClass();
                        vet.pharmapedia.vetpharmapediapakistan.utils.a.a(v8_1, v9_1, v10_3, 0, v12_3, new rc.v(v1_1, v2_1, 0));
                    }
                }
                return;
        }
    }
}
