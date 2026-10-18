// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.utils;
final class Constants$Companion$addOrRemoveBrandsFavourite$1$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements ua.p {
    public final synthetic android.app.Activity g;
    public final synthetic ua.a h;
    public final synthetic String i;

    public Constants$Companion$addOrRemoveBrandsFavourite$1$1(android.app.Activity p1, ua.a p2, String p3, ka.c p4)
    {
        this.g = p1;
        this.h = p2;
        this.i = p3;
        super(2, p4);
        return;
    }

    public final ka.c create(Object p4, ka.c p5)
    {
        return new vet.pharmapedia.vetpharmapediapakistan.utils.Constants$Companion$addOrRemoveBrandsFavourite$1$1(this.g, this.h, this.i, p5);
    }

    public final Object invoke(Object p1, Object p2)
    {
        ga.p v2_2 = ga.p.a;
        ((vet.pharmapedia.vetpharmapediapakistan.utils.Constants$Companion$addOrRemoveBrandsFavourite$1$1) this.create(((gb.v) p1), ((ka.c) p2))).invokeSuspend(v2_2);
        return v2_2;
    }

    public final Object invokeSuspend(Object p6)
    {
        String v1_0 = this.g;
        kotlin.b.b(p6);
        try {
            v1_0.runOnUiThread(new xc.b(this.h, v1_0, this.i, 0));
            android.util.Log.d("myMedicinesData", "insertDataToRoomDB: Data Updated");
        } catch (ga.p v6_2) {
            v1_0.runOnUiThread(new e0.a(v1_0, 1));
            r1.a.A("insertDataToRoomDB: ", v6_2.getMessage(), "myMedicinesData");
        }
        return ga.p.a;
    }
}
