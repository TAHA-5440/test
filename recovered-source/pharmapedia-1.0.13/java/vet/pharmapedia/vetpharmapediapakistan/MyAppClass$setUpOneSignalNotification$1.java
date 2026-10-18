// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan;
final class MyAppClass$setUpOneSignalNotification$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements ua.p {
    public int g;

    public final ka.c create(Object p2, ka.c p3)
    {
        return new vet.pharmapedia.vetpharmapediapakistan.MyAppClass$setUpOneSignalNotification$1(2, p3);
    }

    public final Object invoke(Object p1, Object p2)
    {
        return ((vet.pharmapedia.vetpharmapediapakistan.MyAppClass$setUpOneSignalNotification$1) this.create(((gb.v) p1), ((ka.c) p2))).invokeSuspend(ga.p.a);
    }

    public final Object invokeSuspend(Object p4)
    {
        kotlin.coroutines.intrinsics.CoroutineSingletons v0 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        int v1 = this.g;
        if (v1 == 0) {
            kotlin.b.b(p4);
            ga.p v4_4 = com.onesignal.OneSignal.getNotifications();
            this.g = 1;
            if (v4_4.requestPermission(1, this) == v0) {
                return v0;
            }
        } else {
            if (v1 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                return 0;
            } else {
                kotlin.b.b(p4);
            }
        }
        return ga.p.a;
    }
}
