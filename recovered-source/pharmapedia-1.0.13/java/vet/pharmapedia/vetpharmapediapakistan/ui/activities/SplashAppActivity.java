// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.activities;
public final class SplashAppActivity extends qc.b {
    public boolean u;
    public uc.m v;
    public boolean w;

    public SplashAppActivity()
    {
        this.u = 0;
        this.addOnContextAvailableListener(new vc.p(this, 12));
        return;
    }

    public final void m()
    {
        return;
    }

    public final void n()
    {
        if (!this.u) {
            this.u = 1;
            uc.m v0_7 = ((qc.f) ((vc.c0) this.a()));
            com.bumptech.glide.q v1_3 = v0_7.b;
            this.p = ((xc.g) v1_3.e.get());
            this.q = ((xc.h) v1_3.f.get());
            this.r = v1_3.a();
            this.s = ((tc.b) v1_3.i.get());
            this.t = ((com.bumptech.glide.q) v1_3.j.get());
            this.v = ((uc.m) v0_7.q.get());
        }
        return;
    }

    public final void onCreate(android.os.Bundle p5)
    {
        super.onCreate(p5);
        com.google.firebase.crashlytics.FirebaseCrashlytics v5_1 = this.v;
        if (v5_1 == null) {
            kotlin.jvm.internal.f.i("binding");
            throw 0;
        } else {
            this.setContentView(v5_1.a);
            try {
                if (com.bumptech.glide.k.b == null) {
                    com.google.firebase.analytics.FirebaseAnalytics v2_1 = vet.pharmapedia.vetpharmapediapakistan.MyAppClass.k;
                    if (v2_1 != null) {
                        com.google.firebase.analytics.FirebaseAnalytics v2_2 = com.google.firebase.analytics.FirebaseAnalytics.getInstance(v2_1);
                        v2_2.getClass();
                        com.bumptech.glide.k.b = v2_2;
                    }
                }
            } catch (Exception) {
                qc.b.g(this, 3);
                gb.w.p(androidx.lifecycle.w.e(this), 0, new vet.pharmapedia.vetpharmapediapakistan.ui.activities.SplashAppActivity$onCreate$1(this, 0), 3);
                com.google.firebase.crashlytics.FirebaseCrashlytics v5_6 = this.v;
                if (v5_6 == null) {
                    kotlin.jvm.internal.f.i("binding");
                    throw 0;
                } else {
                    int v0_1 = this.t;
                    if (v0_1 == 0) {
                        kotlin.jvm.internal.f.i("glide");
                        throw 0;
                    } else {
                        v0_1.j(Integer.valueOf(2131231281)).y(v5_6.b);
                        g6.f0.y();
                        try {
                            com.google.firebase.crashlytics.FirebaseCrashlytics v5_9 = vet.pharmapedia.vetpharmapediapakistan.MyAppClass.k;
                            v5_9.getClass();
                            com.google.firebase.crashlytics.FirebaseCrashlytics v5_10 = ((vet.pharmapedia.vetpharmapediapakistan.MyAppClass) v5_9);
                        } catch (Exception) {
                            return;
                        }
                        if (!v5_10.j) {
                            v5_10.j = 1;
                            com.google.firebase.FirebaseApp.initializeApp(v5_10);
                            com.google.firebase.messaging.FirebaseMessaging.getInstance().subscribeToTopic(v5_10.getPackageName());
                            com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(1);
                        }
                        xc.f.a();
                        return;
                    }
                }
            }
            com.google.firebase.analytics.FirebaseAnalytics v2_3 = com.bumptech.glide.k.b;
            if (v2_3 == null) {
                kotlin.jvm.internal.f.i("firebaseAnalytics");
                throw 0;
            } else {
                v2_3.logEvent(db.i.o0("Splash_Screen").toString(), new android.os.Bundle());
            }
        }
    }
}
