// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.activities;
public final class MainActivity extends qc.b {
    public static final synthetic int w;
    public boolean u;
    public uc.i v;

    public MainActivity()
    {
        this.u = 0;
        this.addOnContextAvailableListener(new vc.p(this, 8));
        return;
    }

    public final void m()
    {
        vc.s v0_11 = android.view.LayoutInflater.from(this.j()).inflate(2131558466, 0, 0);
        v4.e v1_0 = 2131361921;
        com.google.android.material.button.MaterialButton v2_1 = ((com.google.android.material.button.MaterialButton) a.a.h(v0_11, 2131361921));
        if (v2_1 != null) {
            v1_0 = 2131361922;
            com.google.android.material.button.MaterialButton v4_1 = ((com.google.android.material.button.MaterialButton) a.a.h(v0_11, 2131361922));
            if (v4_1 != null) {
                v1_0 = 2131362444;
                if (((com.google.android.material.textview.MaterialTextView) a.a.h(v0_11, 2131362444)) != null) {
                    v1_0 = 2131362445;
                    if (((com.google.android.material.textview.MaterialTextView) a.a.h(v0_11, 2131362445)) != null) {
                        vc.s v0_5 = ((androidx.constraintlayout.widget.ConstraintLayout) v0_11);
                        v4.e v1_4 = new v4.e(this.j());
                        v0_5.setBackgroundResource(2131230885);
                        v1_4.setContentView(v0_5);
                        v1_4.setCancelable(0);
                        v1_4.setCanceledOnTouchOutside(0);
                        vc.s v0_6 = v1_4.getWindow();
                        if (v0_6 != null) {
                            v0_6.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(-7829368));
                        }
                        v4_1.setOnClickListener(new p5.j(10, this, v1_4));
                        v2_1.setOnClickListener(new vc.s(this, v1_4));
                        v1_4.show();
                        return;
                    }
                }
            }
        }
        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v0_11.getResources().getResourceName(v1_0)));
        return;
    }

    public final void n()
    {
        if (!this.u) {
            this.u = 1;
            uc.i v0_7 = ((qc.f) ((vc.t) this.a()));
            com.bumptech.glide.q v1_3 = v0_7.b;
            this.p = ((xc.g) v1_3.e.get());
            this.q = ((xc.h) v1_3.f.get());
            this.r = v1_3.a();
            this.s = ((tc.b) v1_3.i.get());
            this.t = ((com.bumptech.glide.q) v1_3.j.get());
            this.v = ((uc.i) v0_7.m.get());
        }
        return;
    }

    public final void onCreate(android.os.Bundle p5)
    {
        super.onCreate(p5);
        java.util.ArrayList v5_1 = this.v;
        if (v5_1 == null) {
            kotlin.jvm.internal.f.i("binding");
            throw 0;
        } else {
            this.setContentView(v5_1.a);
            com.google.firebase.messaging.FirebaseMessaging.getInstance().subscribeToTopic("allUsers");
            qc.b.g(this, 6);
            xc.f.a();
            int v2_1 = this.d();
            v2_1.getClass();
            int v3_0 = this.getLifecycle();
            v3_0.getClass();
            java.util.ArrayList v5_5 = new rc.q(v2_1, v3_0);
            int v2_2 = this.v;
            if (v2_2 == 0) {
                kotlin.jvm.internal.f.i("binding");
                throw 0;
            } else {
                v2_2.c.setAdapter(v5_5);
                com.google.firebase.database.FirebaseDatabase.getInstance().getReference().child("AppVersion").addValueEventListener(new l.o(this, 21));
                java.util.ArrayList v5_9 = this.v;
                if (v5_9 == null) {
                    kotlin.jvm.internal.f.i("binding");
                    throw 0;
                } else {
                    androidx.viewpager2.widget.ViewPager2 v0_1 = v5_9.c;
                    v0_1.setUserInputEnabled(0);
                    v5_9.b.setOnItemSelectedListener(new androidx.work.impl.b(v5_9, 20));
                    ((java.util.ArrayList) v0_1.i.b).add(new r2.c(v5_9, 2));
                    return;
                }
            }
        }
    }

    public final void onResume()
    {
        super.onResume();
        com.google.firebase.database.FirebaseDatabase.getInstance().getReference().child("AppVersion").addValueEventListener(new l.o(this, 21));
        return;
    }
}
