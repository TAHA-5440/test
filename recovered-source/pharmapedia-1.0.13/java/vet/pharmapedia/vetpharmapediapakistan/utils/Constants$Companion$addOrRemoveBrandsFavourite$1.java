// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.utils;
final class Constants$Companion$addOrRemoveBrandsFavourite$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements ua.p {
    public int g;
    public final synthetic tc.b h;
    public final synthetic String i;
    public final synthetic int j;
    public final synthetic android.app.Activity k;
    public final synthetic ua.a l;
    public final synthetic String m;

    public Constants$Companion$addOrRemoveBrandsFavourite$1(tc.b p1, String p2, int p3, android.app.Activity p4, ua.a p5, String p6, ka.c p7)
    {
        this.h = p1;
        this.i = p2;
        this.j = p3;
        this.k = p4;
        this.l = p5;
        this.m = p6;
        super(2, p7);
        return;
    }

    public final ka.c create(Object p9, ka.c p10)
    {
        return new vet.pharmapedia.vetpharmapediapakistan.utils.Constants$Companion$addOrRemoveBrandsFavourite$1(this.h, this.i, this.j, this.k, this.l, this.m, p10);
    }

    public final Object invoke(Object p1, Object p2)
    {
        return ((vet.pharmapedia.vetpharmapediapakistan.utils.Constants$Companion$addOrRemoveBrandsFavourite$1) this.create(((gb.v) p1), ((ka.c) p2))).invokeSuspend(ga.p.a);
    }

    public final Object invokeSuspend(Object p9)
    {
        kotlin.coroutines.intrinsics.CoroutineSingletons v0 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        vet.pharmapedia.vetpharmapediapakistan.utils.Constants$Companion$addOrRemoveBrandsFavourite$1$1 v1_0 = this.g;
        ga.p v3 = ga.p.a;
        if (v1_0 == null) {
            kotlin.b.b(p9);
            this.g = 1;
            Object v9_3 = androidx.room.util.a.c(this.h.a.a, this, new tc.c(this.j, this.i, 1), 0, 1);
            if (v9_3 != v0) {
                v9_3 = v3;
            }
            if (v9_3 != v0) {
                vet.pharmapedia.vetpharmapediapakistan.utils.Constants$Companion$addOrRemoveBrandsFavourite$1$1 v1_4 = new vet.pharmapedia.vetpharmapediapakistan.utils.Constants$Companion$addOrRemoveBrandsFavourite$1$1(this.k, this.l, this.m, 0);
                this.g = 2;
                if (gb.w.z(lb.k.a, v1_4, this) != v0) {
                    return v3;
                }
            }
        } else {
            if (v1_0 == 1) {
                kotlin.b.b(p9);
            } else {
                if (v1_0 != 2) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                    return 0;
                } else {
                    kotlin.b.b(p9);
                    return v3;
                }
            }
        }
        return v0;
    }
}
