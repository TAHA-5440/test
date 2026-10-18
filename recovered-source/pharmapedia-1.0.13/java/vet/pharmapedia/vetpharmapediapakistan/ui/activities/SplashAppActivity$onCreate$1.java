// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.activities;
final class SplashAppActivity$onCreate$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements ua.p {
    public int g;
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.ui.activities.SplashAppActivity h;

    public SplashAppActivity$onCreate$1(vet.pharmapedia.vetpharmapediapakistan.ui.activities.SplashAppActivity p1, ka.c p2)
    {
        this.h = p1;
        super(2, p2);
        return;
    }

    public final ka.c create(Object p2, ka.c p3)
    {
        return new vet.pharmapedia.vetpharmapediapakistan.ui.activities.SplashAppActivity$onCreate$1(this.h, p3);
    }

    public final Object invoke(Object p1, Object p2)
    {
        return ((vet.pharmapedia.vetpharmapediapakistan.ui.activities.SplashAppActivity$onCreate$1) this.create(((gb.v) p1), ((ka.c) p2))).invokeSuspend(ga.p.a);
    }

    public final Object invokeSuspend(Object p8)
    {
        String v0_0 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        com.google.firebase.analytics.FirebaseAnalytics v1_0 = this.g;
        ga.p v3 = ga.p.a;
        if (v1_0 == null) {
            kotlin.b.b(p8);
            long v5_0 = jc.g.v(5, kotlin.time.DurationUnit.j);
            this.g = 1;
            vet.pharmapedia.vetpharmapediapakistan.ui.activities.SplashAppActivity v8_1 = gb.w.h(gb.w.w(v5_0), this);
            if (v8_1 != v0_0) {
                v8_1 = v3;
            }
            if (v8_1 == v0_0) {
                return v0_0;
            }
        } else {
            if (v1_0 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                return 0;
            } else {
                kotlin.b.b(p8);
            }
        }
        vet.pharmapedia.vetpharmapediapakistan.ui.activities.SplashAppActivity v8_3 = this.h;
        if (!v8_3.w) {
            v8_3.w = 1;
            try {
                if (com.bumptech.glide.k.b == null) {
                    com.google.firebase.analytics.FirebaseAnalytics v1_2 = vet.pharmapedia.vetpharmapediapakistan.MyAppClass.k;
                    if (v1_2 != null) {
                        com.google.firebase.analytics.FirebaseAnalytics v1_3 = com.google.firebase.analytics.FirebaseAnalytics.getInstance(v1_2);
                        v1_3.getClass();
                        com.bumptech.glide.k.b = v1_3;
                    }
                }
            } catch (Exception) {
                v8_3.startActivity(new android.content.Intent(v8_3.j(), vet.pharmapedia.vetpharmapediapakistan.ui.activities.MainActivity));
                v8_3.finish();
            }
            com.google.firebase.analytics.FirebaseAnalytics v1_4 = com.bumptech.glide.k.b;
            if (v1_4 == null) {
                kotlin.jvm.internal.f.i("firebaseAnalytics");
                throw 0;
            } else {
                v1_4.logEvent(db.i.o0("Request_Main").toString(), new android.os.Bundle());
            }
        }
        return v3;
    }
}
