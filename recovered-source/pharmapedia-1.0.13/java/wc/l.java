// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package wc;
public final class l extends wc.f {
    public final java.util.ArrayList A;
    public final java.util.ArrayList B;
    public boolean C;
    public uc.q u;
    public rc.x v;
    public java.util.List w;
    public android.app.Dialog x;
    public android.animation.ValueAnimator y;
    public lc.a z;

    public l()
    {
        this.w = kotlin.collections.EmptyList.g;
        this.A = new java.util.ArrayList();
        this.B = new java.util.ArrayList();
        this.C = 1;
        return;
    }

    public final uc.q n()
    {
        int v0_0 = this.u;
        if (v0_0 == 0) {
            kotlin.jvm.internal.f.i("binding");
            throw 0;
        } else {
            return v0_0;
        }
    }

    public final void o(boolean p6)
    {
        try {
            if (this.v != null) {
                rc.x v0_2 = this.n();
                int v1_3 = this.v;
                if (v1_3 == 0) {
                    kotlin.jvm.internal.f.i("saltsAndBrandsAdapter");
                    throw 0;
                } else {
                    v0_2.d.setAdapter(v1_3);
                    rc.x v0_1 = this.v;
                    if (p6 == null) {
                        if (v0_1 == null) {
                            kotlin.jvm.internal.f.i("saltsAndBrandsAdapter");
                            throw 0;
                        } else {
                            java.util.List v6_1 = this.w;
                            int v1_1 = new java.util.HashSet();
                            java.util.ArrayList v2_1 = new java.util.ArrayList();
                            java.util.List v6_2 = v6_1.iterator();
                            while (v6_2.hasNext()) {
                                Object v3_1 = v6_2.next();
                                if (v1_1.add(db.i.o0(((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) v3_1).getSaltName()).toString())) {
                                    v2_1.add(v3_1);
                                }
                            }
                            v0_1.l(ha.j.R(v2_1, new b2.b(17)));
                        }
                    } else {
                        if (v0_1 == null) {
                            kotlin.jvm.internal.f.i("saltsAndBrandsAdapter");
                            throw 0;
                        } else {
                            v0_1.l(ha.j.R(this.w, new b2.b(16)));
                        }
                    }
                }
            }
        } catch (Exception) {
            return;
        }
        this.n().d.Z(xc.a.e);
        xc.a.e = 0;
        this.n().c.setVisibility(8);
        return;
    }

    public final android.view.View onCreateView(android.view.LayoutInflater p1, android.view.ViewGroup p2, android.os.Bundle p3)
    {
        p1.getClass();
        androidx.constraintlayout.widget.ConstraintLayout v1_2 = this.n().a;
        v1_2.getClass();
        return v1_2;
    }

    public final void onDestroy()
    {
        super.onDestroy();
        xc.a.b.j(Boolean.TRUE);
        return;
    }

    public final void onViewCreated(android.view.View p12, android.os.Bundle p13)
    {
        p12.getClass();
        super.onViewCreated(p12, p13);
        this.x = new android.app.Dialog(this.h());
        com.google.android.gms.tasks.Task v12_8 = android.view.LayoutInflater.from(this.h()).inflate(2131558541, 0, 0);
        wc.i v13_12 = 2131361875;
        androidx.fragment.app.n0 v5_1 = ((android.widget.ProgressBar) a.a.h(v12_8, 2131361875));
        if (v5_1 != null) {
            v13_12 = 2131361927;
            int v6_1 = ((com.google.android.material.button.MaterialButton) a.a.h(v12_8, 2131361927));
            if (v6_1 != 0) {
                v13_12 = 2131362285;
                tc.b v7_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v12_8, 2131362285));
                if (v7_1 != null) {
                    v13_12 = 2131362440;
                    l.o v8_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v12_8, 2131362440));
                    if (v8_1 != null) {
                        v13_12 = 2131362441;
                        xc.g v9_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v12_8, 2131362441));
                        if (v9_1 != null) {
                            this.z = new lc.a(((com.google.android.material.card.MaterialCardView) v12_8), v5_1, v6_1, v7_1, v8_1, v9_1, 4);
                            this.v = new rc.x(this.h(), 1, this.i(), this.j(), this.g(), this);
                            try {
                                com.google.android.gms.tasks.Task v12_15 = this.n();
                                wc.i v13_15 = this.v;
                            } catch (Exception) {
                                com.google.android.gms.tasks.Task v12_2 = this.n();
                                wc.i v13_1 = v12_2.d;
                                this.h();
                                v13_1.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager());
                                v12_2.b.setOnClickListener(new vc.a(v12_2, 10));
                                v12_2.g.setOnClickListener(new p5.j(11, this, v12_2));
                                v12_2.e.addTextChangedListener(new wc.k(this, v12_2));
                                com.google.android.gms.tasks.Task v12_3 = v12_2.f;
                                try {
                                    if (!xc.a.f) {
                                        v12_3.setVisibility(8);
                                    } else {
                                        v12_3.setVisibility(0);
                                        com.google.firebase.firestore.FirebaseFirestore.getInstance().collection("SliderPics").whereEqualTo("canShow", Boolean.TRUE).get().addOnSuccessListener(new com.google.firebase.firestore.core.e(new wc.i(this, 0), 3)).getClass();
                                    }
                                } catch (Exception) {
                                }
                                this.p();
                                return;
                            }
                            if (v13_15 == null) {
                                kotlin.jvm.internal.f.i("saltsAndBrandsAdapter");
                                throw 0;
                            } else {
                                v12_15.d.setAdapter(v13_15);
                                com.google.android.gms.tasks.Task v12_20 = this.i().a;
                                v12_20.a.getInvalidationTracker().b(new String[] {"medicines_table"}), new tc.d(v12_20, 2)).d(this.h(), new rc.h(new wc.i(this, 1), 6));
                            }
                        }
                    }
                }
            }
        }
        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v12_8.getResources().getResourceName(v13_12)));
        return;
    }

    public final void p()
    {
        try {
            if ((!((android.content.SharedPreferences) this.j().h).getBoolean("IS_DATA_FETCHED_KEY", 0)) && (this.g().a())) {
                this.q(80000, 1, "");
            }
        } catch (Exception) {
            return;
        }
        com.google.firebase.firestore.FirebaseFirestore.getInstance().collection("NewMedicinesData").whereGreaterThan("timeStamp", Long.valueOf(((android.content.SharedPreferences) this.j().h).getLong("KEY_LAST_FETCHED", 0))).orderBy("timeStamp", com.google.firebase.firestore.Query$Direction.DESCENDING).get(com.google.firebase.firestore.Source.SERVER).addOnSuccessListener(new com.google.firebase.firestore.core.e(new vet.pharmapedia.vetpharmapediapakistan.ui.fragments.a(this), 2)).addOnFailureListener(new com.google.firebase.appcheck.internal.c(this, 3)).getClass();
        return;
    }

    public final void q(long p7, boolean p9, String p10)
    {
        try {
            String v0_0 = this.x;
        } catch (Exception) {
            return;
        }
        if (v0_0 == null) {
            kotlin.jvm.internal.f.i("progressDialog");
            throw 0;
        } else {
            long v3_5 = this.z;
            if (v3_5 == 0) {
                kotlin.jvm.internal.f.i("progressBinding");
                throw 0;
            } else {
                v0_0.setContentView(((com.google.android.material.card.MaterialCardView) v3_5.b));
                String v0_1 = this.x;
                if (v0_1 == null) {
                    kotlin.jvm.internal.f.i("progressDialog");
                    throw 0;
                } else {
                    v0_1.setCancelable(0);
                    String v0_2 = this.x;
                    if (v0_2 == null) {
                        kotlin.jvm.internal.f.i("progressDialog");
                        throw 0;
                    } else {
                        String v0_3 = v0_2.getWindow();
                        if (v0_3 != null) {
                            v0_3.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
                        }
                        if (p9 == 0) {
                            String v7_4 = this.z;
                            if (v7_4 == null) {
                                kotlin.jvm.internal.f.i("progressBinding");
                                throw 0;
                            } else {
                                String v8_1 = ((com.google.android.material.button.MaterialButton) v7_4.d);
                                int v9_6 = ((androidx.appcompat.widget.AppCompatTextView) v7_4.f);
                                String v4_0 = this.y;
                                if (v4_0 != null) {
                                    v4_0.cancel();
                                }
                                ((android.widget.ProgressBar) v7_4.c).setProgress(2);
                                ((androidx.appcompat.widget.AppCompatTextView) v7_4.e).setText("0%");
                                String v7_6 = ((androidx.appcompat.widget.AppCompatTextView) v7_4.g);
                                if (!this.g().a()) {
                                    v7_6.setText(this.getString(2131951989));
                                    v9_6.setText(this.getString(2131951659));
                                } else {
                                    v7_6.setText(this.getString(2131952057));
                                    v9_6.setText(p10);
                                    v8_1.setVisibility(0);
                                    v8_1.setOnClickListener(new vc.a(this, 11));
                                }
                            }
                        } else {
                            if (this.g().a()) {
                                int v9_10 = this.z;
                                if (v9_10 == 0) {
                                    kotlin.jvm.internal.f.i("progressBinding");
                                    throw 0;
                                } else {
                                    ((android.widget.ProgressBar) v9_10.c).setMax(98);
                                    androidx.activity.d v10_6 = new float[2];
                                    v10_6 = {0, 1120141312};
                                    androidx.activity.d v10_7 = android.animation.ValueAnimator.ofFloat(v10_6);
                                    this.y = v10_7;
                                    if (v10_7 != null) {
                                        v10_7.setDuration((((long) 5000) + p7));
                                        v10_7.addUpdateListener(new wc.h(this, v9_10));
                                        v10_7.start();
                                    }
                                    if (this.p == null) {
                                        this.p = new android.os.Handler(android.os.Looper.getMainLooper());
                                    }
                                    int v9_4 = this.p;
                                    if (v9_4 == 0) {
                                        kotlin.jvm.internal.f.i("baseHandler");
                                        throw 0;
                                    } else {
                                        v9_4.postDelayed(new androidx.activity.d(this, 22), (p7 + ((long) 5000)));
                                    }
                                }
                            } else {
                                return;
                            }
                        }
                        String v7_3 = this.x;
                        if (v7_3 == null) {
                            kotlin.jvm.internal.f.i("progressDialog");
                            throw 0;
                        } else {
                            v7_3.show();
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void r(boolean p10)
    {
        this.C = p10;
        if (!p10) {
            this.n().e.setHint(this.getString(2131952035));
            this.n().g.setText(this.getString(2131951788));
        } else {
            this.n().e.setHint(this.getString(2131952034));
            this.n().g.setText(this.getString(2131951687));
        }
        this.v = new rc.x(this.h(), p10, this.i(), this.j(), this.g(), this);
        this.o(p10);
        return;
    }
}
