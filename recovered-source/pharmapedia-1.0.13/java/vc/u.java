// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vc;
public final synthetic class u implements android.view.View$OnClickListener {
    public final synthetic int g;
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.ui.activities.MedicinesMainActivity h;
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel i;

    public synthetic u(int p1, vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel p2, vet.pharmapedia.vetpharmapediapakistan.ui.activities.MedicinesMainActivity p3)
    {
        this.g = p1;
        this.h = p3;
        this.i = p2;
        return;
    }

    public final void onClick(android.view.View p15)
    {
        android.app.Activity v0_0 = this.i;
        tc.b v1_2 = this.h;
        switch (this.g) {
            case 0:
                if (!v1_2.z) {
                    boolean v15_1 = v0_0;
                    int v6_0 = v1_2;
                    if (!v15_1.isSaltFavourite()) {
                        android.app.Activity v0_4 = v6_0.j();
                        tc.b v1_1 = v6_0.k();
                        String v2_0 = v15_1.getSaltName();
                        String v4_0 = v6_0.getString(2131951649);
                        v4_0.getClass();
                        vet.pharmapedia.vetpharmapediapakistan.utils.a.b(v0_4, v1_1, v2_0, 1, v4_0, new vc.w(v6_0, 1));
                    } else {
                        android.app.Activity v8_0 = v6_0.j();
                        tc.b v9_0 = v6_0.k();
                        String v10_0 = v15_1.getSaltName();
                        String v12 = v6_0.getString(2131952025);
                        v12.getClass();
                        vet.pharmapedia.vetpharmapediapakistan.utils.a.b(v8_0, v9_0, v10_0, 0, v12, new vc.w(v6_0, 0));
                    }
                } else {
                    if (!v0_0.isBrandFavourite()) {
                        boolean v15_5 = v0_0;
                        android.app.Activity v0_5 = v1_2.j();
                        int v6_1 = v1_2;
                        tc.b v1_3 = v6_1.k();
                        String v2_2 = v15_5.getBrandName();
                        String v4_1 = v6_1.getString(2131951649);
                        v4_1.getClass();
                        vet.pharmapedia.vetpharmapediapakistan.utils.a.a(v0_5, v1_3, v2_2, 1, v4_1, new vc.v(1, v15_5, v6_1));
                    } else {
                        int v6_2 = v1_2.j();
                        int v7_2 = v1_2.k();
                        android.app.Activity v8_1 = v0_0.getBrandName();
                        String v10_1 = v1_2.getString(2131952025);
                        v10_1.getClass();
                        vet.pharmapedia.vetpharmapediapakistan.utils.a.a(v6_2, v7_2, v8_1, 0, v10_1, new vc.v(0, v0_0, v1_2));
                    }
                }
                return;
            default:
                boolean v15_8 = new b5.b(v1_2.j());
                vc.w v5_6 = ((i.c) v15_8.i);
                v5_6.d = v1_2.getString(2131952030);
                v5_6.f = v0_0.getSaltName();
                v5_6.i = 0;
                android.app.Activity v0_8 = v1_2.getString(2131951749);
                int v3_4 = new vc.b(1);
                v5_6.g = v0_8;
                v5_6.h = v3_4;
                boolean v15_9 = v15_8.b();
                v15_9.show();
                v15_9.l.g.setTextColor(v1_2.j().getColor(2131099648));
                return;
        }
    }
}
