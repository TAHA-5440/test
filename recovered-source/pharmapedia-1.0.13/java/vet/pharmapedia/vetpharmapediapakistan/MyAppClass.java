// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan;
public class MyAppClass extends android.app.Application implements c7.c {
    public static android.content.Context k;
    public boolean g;
    public final a7.h h;
    public l.o i;
    public boolean j;

    public MyAppClass()
    {
        this.g = 0;
        this.h = new a7.h(new l.o(this, 7));
        return;
    }

    public final Object a()
    {
        return this.h.a();
    }

    public void attachBaseContext(android.content.Context p1)
    {
        if (p1 != null) {
            super.attachBaseContext(jc.g.r(p1));
            return;
        } else {
            super.attachBaseContext(p1);
            return;
        }
    }

    public final void b()
    {
        if (!this.g) {
            this.g = 1;
            this.i = ((qc.j) ((qc.m) this.h.a())).a();
        }
        super.onCreate();
        return;
    }

    public final void onCreate()
    {
        this.b();
        vet.pharmapedia.vetpharmapediapakistan.MyAppClass.k = this.getApplicationContext();
        android.app.NotificationManager v0_11 = this.i;
        if (v0_11 == null) {
            kotlin.jvm.internal.f.i("mySharedPreference");
            throw 0;
        } else {
            xc.a.a = ((android.content.SharedPreferences) v0_11.h).getInt("SELECTED_THEME_KEY", 0);
            android.app.NotificationManager v0_3 = this.i;
            if (v0_3 == null) {
                kotlin.jvm.internal.f.i("mySharedPreference");
                throw 0;
            } else {
                xc.a.c = String.valueOf(v0_3.A());
                if (android.os.Build$VERSION.SDK_INT >= 26) {
                    android.app.NotificationManager v0_9 = this.getApplicationContext().getSystemService("notification");
                    v0_9.getClass();
                    android.app.NotificationManager v0_10 = ((android.app.NotificationManager) v0_9);
                    p6.a.m();
                    android.app.NotificationChannel v1_3 = this.getString(2131951658);
                    StringBuilder v3_2 = new StringBuilder();
                    v3_2.append(v1_3);
                    v3_2.append("Vet. Pharmapedia Pakistan");
                    android.app.NotificationChannel v1_6 = p6.a.e(v3_2.toString());
                    p6.a.x(v1_6);
                    androidx.work.impl.background.systemjob.b.q(v0_10, v1_6);
                }
                try {
                    com.onesignal.OneSignal.getDebug().setLogLevel(com.onesignal.debug.LogLevel.VERBOSE);
                    android.app.NotificationManager v0_14 = this.getString(2131951995);
                    v0_14.getClass();
                    com.onesignal.OneSignal.initWithContext(this, v0_14);
                    gb.w.p(gb.w.b(nb.c.i), 0, new vet.pharmapedia.vetpharmapediapakistan.MyAppClass$setUpOneSignalNotification$1(2, 0), 3);
                    com.onesignal.OneSignal.getNotifications().addClickListener(new qc.l(this));
                } catch (Exception) {
                }
                return;
            }
        }
    }
}
