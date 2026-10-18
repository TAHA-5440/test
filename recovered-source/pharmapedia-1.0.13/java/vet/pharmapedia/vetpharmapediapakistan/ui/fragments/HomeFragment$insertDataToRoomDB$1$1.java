// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.fragments;
final class HomeFragment$insertDataToRoomDB$1$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements ua.p {
    public int g;
    public final synthetic wc.l h;
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel i;

    public HomeFragment$insertDataToRoomDB$1$1(wc.l p1, vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel p2, ka.c p3)
    {
        this.h = p1;
        this.i = p2;
        super(2, p3);
        return;
    }

    public final ka.c create(Object p3, ka.c p4)
    {
        return new vet.pharmapedia.vetpharmapediapakistan.ui.fragments.HomeFragment$insertDataToRoomDB$1$1(this.h, this.i, p4);
    }

    public final Object invoke(Object p1, Object p2)
    {
        return ((vet.pharmapedia.vetpharmapediapakistan.ui.fragments.HomeFragment$insertDataToRoomDB$1$1) this.create(((gb.v) p1), ((ka.c) p2))).invokeSuspend(ga.p.a);
    }

    public final Object invokeSuspend(Object p9)
    {
        String v0_0 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel v1_0 = this.g;
        ga.p v3 = ga.p.a;
        try {
            if (v1_0 == null) {
                kotlin.b.b(p9);
                String v9_10 = this.h.i();
                vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel v1_1 = this.i;
                this.g = 1;
                String v9_1 = v9_10.a;
                String v9_3 = androidx.room.util.a.c(v9_1.a, this, new ac.d(5, v9_1, v1_1), 0, 1);
                if (v9_3 != v0_0) {
                    v9_3 = v3;
                } else {
                }
                if (v9_3 == v0_0) {
                    return v0_0;
                }
            } else {
                if (v1_0 != 1) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                    return 0;
                } else {
                    kotlin.b.b(p9);
                }
            }
        } catch (String v9_6) {
            r1.a.A("insertDataToRoomDB: ", v9_6.getMessage(), "myMedicinesData");
            return v3;
        }
        android.util.Log.d("myMedicinesData", "insertDataToRoomDB: Data Inserted");
        return v3;
    }
}
