// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vc;
public final synthetic class h implements ua.a {
    public final synthetic int g;
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel h;
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.ui.activities.ContraindicationsActivity i;

    public synthetic h(vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel p1, vet.pharmapedia.vetpharmapediapakistan.ui.activities.ContraindicationsActivity p2, int p3)
    {
        this.g = p3;
        this.h = p1;
        this.i = p2;
        return;
    }

    public final Object invoke()
    {
        ga.p v1 = ga.p.a;
        int v2_1 = this.i;
        vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel v3 = this.h;
        switch (this.g) {
            case 0:
                v3.setBrandFavourite(0);
                v2_1.p().g.setImageResource(2131230840);
                return v1;
            default:
                v3.setBrandFavourite(1);
                v2_1.p().g.setImageResource(2131231274);
                return v1;
        }
    }
}
