// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vc;
public final synthetic class f implements ua.l {
    public final synthetic int g;
    public final synthetic uc.d h;
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.ui.activities.ContraindicationsActivity i;
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel j;

    public synthetic f(int p1, uc.d p2, vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel p3, vet.pharmapedia.vetpharmapediapakistan.ui.activities.ContraindicationsActivity p4)
    {
        this.g = p1;
        this.h = p2;
        this.i = p4;
        this.j = p3;
        return;
    }

    public final Object invoke(Object p10)
    {
        ga.p v1 = ga.p.a;
        vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel v6 = this.j;
        vet.pharmapedia.vetpharmapediapakistan.ui.activities.ContraindicationsActivity v7 = this.i;
        uc.d v8 = this.h;
        switch (this.g) {
            case 0:
                Class vtmp3 = ((String) p10).getClass();
                v8.s.setVisibility(8);
                v7.D = 1;
                android.widget.Toast v0_6 = v8.j;
                v0_6.setText(((String) p10));
                if (((String) p10).length() == 0) {
                    v0_6.setText(v6.getIndications());
                    android.app.Activity v10_6 = v7.j();
                    android.widget.Toast v0_7 = v7.getString(2131951697);
                    v0_7.getClass();
                    android.widget.Toast v0_8 = android.widget.Toast.makeText(v10_6, v0_7, 0);
                    yc.d.a(v0_8.getView(), new yc.c(v10_6));
                    new yc.d(v10_6, v0_8).show();
                }
                return v1;
            case 1:
                Class vtmp5 = ((String) p10).getClass();
                v8.t.setVisibility(8);
                android.widget.Toast v0_2 = v8.p;
                v0_2.setText(((String) p10));
                v7.C = 1;
                if (((String) p10).length() == 0) {
                    v0_2.setText(v6.getOverview());
                    android.app.Activity v10_3 = v7.j();
                    android.widget.Toast v0_3 = v7.getString(2131951697);
                    v0_3.getClass();
                    android.widget.Toast v0_4 = android.widget.Toast.makeText(v10_3, v0_3, 0);
                    yc.d.a(v0_4.getView(), new yc.c(v10_3));
                    new yc.d(v10_3, v0_4).show();
                }
                return v1;
            default:
                Class vtmp1 = ((String) p10).getClass();
                v8.r.setVisibility(8);
                v7.E = 1;
                android.widget.Toast v0_10 = v8.c;
                v0_10.setText(((String) p10));
                if (((String) p10).length() == 0) {
                    v0_10.setText(v6.getContraIndications());
                    android.app.Activity v10_9 = v7.j();
                    android.widget.Toast v0_11 = v7.getString(2131951697);
                    v0_11.getClass();
                    android.widget.Toast v0_12 = android.widget.Toast.makeText(v10_9, v0_11, 0);
                    yc.d.a(v0_12.getView(), new yc.c(v10_9));
                    new yc.d(v10_9, v0_12).show();
                }
                return v1;
        }
    }
}
