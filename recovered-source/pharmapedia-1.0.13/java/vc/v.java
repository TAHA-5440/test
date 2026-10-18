// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vc;
public final synthetic class v implements ua.a {
    public final synthetic int g;
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel h;
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.ui.activities.MedicinesMainActivity i;

    public synthetic v(int p1, vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel p2, vet.pharmapedia.vetpharmapediapakistan.ui.activities.MedicinesMainActivity p3)
    {
        this.g = p1;
        this.h = p2;
        this.i = p3;
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
                v2_1.p().b.setImageResource(2131230840);
                return v1;
            default:
                v3.setBrandFavourite(1);
                v2_1.p().b.setImageResource(2131231274);
                return v1;
        }
    }
}
