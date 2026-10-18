// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.fragments;
final class HomeFragment$insertDataToRoomDB$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements ua.p {
    public int g;
    public final synthetic wc.l h;
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel i;

    public HomeFragment$insertDataToRoomDB$1(wc.l p1, vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel p2, ka.c p3)
    {
        this.h = p1;
        this.i = p2;
        super(2, p3);
        return;
    }

    public final ka.c create(Object p3, ka.c p4)
    {
        return new vet.pharmapedia.vetpharmapediapakistan.ui.fragments.HomeFragment$insertDataToRoomDB$1(this.h, this.i, p4);
    }

    public final Object invoke(Object p1, Object p2)
    {
        return ((vet.pharmapedia.vetpharmapediapakistan.ui.fragments.HomeFragment$insertDataToRoomDB$1) this.create(((gb.v) p1), ((ka.c) p2))).invokeSuspend(ga.p.a);
    }

    public final Object invokeSuspend(Object p7)
    {
        kotlin.coroutines.intrinsics.CoroutineSingletons v0 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        vet.pharmapedia.vetpharmapediapakistan.ui.fragments.HomeFragment$insertDataToRoomDB$1$1 v1_0 = this.g;
        if (v1_0 == null) {
            kotlin.b.b(p7);
            vet.pharmapedia.vetpharmapediapakistan.ui.fragments.HomeFragment$insertDataToRoomDB$1$1 v1_1 = new vet.pharmapedia.vetpharmapediapakistan.ui.fragments.HomeFragment$insertDataToRoomDB$1$1(this.h, this.i, 0);
            this.g = 1;
            if (gb.w.z(lb.k.a, v1_1, this) == v0) {
                return v0;
            }
        } else {
            if (v1_0 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                return 0;
            } else {
                kotlin.b.b(p7);
            }
        }
        return ga.p.a;
    }
}
