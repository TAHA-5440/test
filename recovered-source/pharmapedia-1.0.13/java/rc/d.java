// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package rc;
public final class d extends w1.e0 {
    public final synthetic int e;
    public final Object f;

    public d(android.app.Activity p3)
    {
        this.e = 0;
        super(new rc.c(0));
        super.f = p3;
        return;
    }

    public d(vet.pharmapedia.vetpharmapediapakistan.ui.activities.MedicinesMainActivity p3)
    {
        this.e = 1;
        super(new rc.c(6));
        super.f = p3;
        return;
    }

    public d(wc.n p3)
    {
        this.e = 2;
        super(new rc.c(8));
        super.f = p3;
        return;
    }

    public final void e(w1.h1 p9, int p10)
    {
        switch (this.e) {
            case 0:
                android.view.View v10_4 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel) this.k(p10));
                if (v10_4 != null) {
                    rc.d v0_1 = ((rc.b) p9).v;
                    int v2_2 = ((rc.b) p9).u;
                    int v2_3 = v2_2.b;
                    v2_2.c.setText(v10_4.getName());
                    v2_3.setImageResource(v10_4.getIcon());
                    v2_3.setOnClickListener(new rc.a(((rc.b) p9), v10_4, v0_1, 0));
                }
                return;
            case 1:
                android.view.View v10_8 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel) this.k(p10));
                if (v10_8 != null) {
                    rc.d v0_3 = ((rc.t) p9).v;
                    p5.j v1_6 = ((rc.t) p9).u;
                    v1_6.c.setText(v10_8.getItemName());
                    v1_6.b.setImageResource(v10_8.getItemIcon());
                    ((rc.t) p9).a.setOnClickListener(new p5.j(4, v0_3, ((rc.t) p9)));
                }
                return;
            default:
                android.view.View v10_6 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel) this.k(p10));
                rc.d v0_2 = ((rc.y) p9).a;
                if (v10_6 != null) {
                    int v2_4 = ((rc.y) p9).v;
                    String v3_5 = ((rc.y) p9).u;
                    androidx.appcompat.widget.AppCompatTextView v5_1 = ((androidx.appcompat.widget.AppCompatTextView) v3_5.c);
                    ((androidx.appcompat.widget.AppCompatTextView) v3_5.f).setText(v10_6.getHeading());
                    ((androidx.appcompat.widget.AppCompatTextView) v3_5.e).setText(v10_6.getDescription());
                    ((androidx.appcompat.widget.AppCompatImageView) v3_5.g).setImageResource(v10_6.getIcon());
                    v5_1.setText("1.0.13");
                    String v3_7 = ((androidx.appcompat.widget.AppCompatImageView) v3_5.d);
                    if (!kotlin.jvm.internal.f.a(v10_6.getHeading(), v0_2.getContext().getString(2131952085))) {
                        v3_7.setVisibility(0);
                        v5_1.setVisibility(8);
                    } else {
                        v3_7.setVisibility(8);
                        v5_1.setVisibility(0);
                    }
                    v0_2.setOnClickListener(new p5.j(((rc.y) p9), v2_4, v10_6));
                }
                return;
        }
    }

    public final w1.h1 f(android.view.ViewGroup p12)
    {
        rc.t v1_0 = 0;
        switch (this.e) {
            case 0:
                androidx.constraintlayout.widget.ConstraintLayout v12_9 = android.view.LayoutInflater.from(p12.getContext()).inflate(2131558447, p12, 0);
                lc.a v3_4 = 2131362109;
                androidx.appcompat.widget.AppCompatImageView v4_5 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v12_9, 2131362109));
                if (v4_5 == null) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v12_9.getResources().getResourceName(v3_4)));
                } else {
                    v3_4 = 2131362443;
                    androidx.appcompat.widget.AppCompatTextView v5_5 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v12_9, 2131362443));
                    if (v5_5 == null) {
                    } else {
                        v1_0 = new rc.b(this, new uc.o(((androidx.constraintlayout.widget.ConstraintLayout) v12_9), v4_5, v5_5));
                    }
                }
                return v1_0;
            case 1:
                androidx.constraintlayout.widget.ConstraintLayout v12_4 = android.view.LayoutInflater.from(p12.getContext()).inflate(2131558499, p12, 0);
                lc.a v3_2 = 2131362104;
                androidx.appcompat.widget.AppCompatImageView v4_1 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v12_4, 2131362104));
                if (v4_1 == null) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v12_4.getResources().getResourceName(v3_2)));
                } else {
                    v3_2 = 2131362105;
                    androidx.appcompat.widget.AppCompatTextView v5_2 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v12_4, 2131362105));
                    if (v5_2 == null) {
                    } else {
                        v1_0 = new rc.t(this, new uc.o(((androidx.constraintlayout.widget.ConstraintLayout) v12_4), v4_1, v5_2));
                    }
                }
                return v1_0;
            default:
                androidx.constraintlayout.widget.ConstraintLayout v12_14 = android.view.LayoutInflater.from(p12.getContext()).inflate(2131558546, p12, 0);
                lc.a v3_5 = 2131362337;
                androidx.appcompat.widget.AppCompatTextView v5_8 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v12_14, 2131362337));
                if (v5_8 == null) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v12_14.getResources().getResourceName(v3_5)));
                } else {
                    v3_5 = 2131362338;
                    androidx.appcompat.widget.AppCompatImageView v6_1 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v12_14, 2131362338));
                    if (v6_1 == null) {
                    } else {
                        v3_5 = 2131362339;
                        androidx.appcompat.widget.AppCompatTextView v7_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v12_14, 2131362339));
                        if (v7_1 == null) {
                        } else {
                            v3_5 = 2131362340;
                            androidx.appcompat.widget.AppCompatTextView v8_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v12_14, 2131362340));
                            if (v8_1 == null) {
                            } else {
                                v3_5 = 2131362341;
                                androidx.appcompat.widget.AppCompatImageView v9_0 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v12_14, 2131362341));
                                if (v9_0 == null) {
                                } else {
                                    v1_0 = new rc.y(this, new lc.a(((com.google.android.material.card.MaterialCardView) v12_14), v5_8, v6_1, v7_1, v8_1, v9_0, 5));
                                }
                            }
                        }
                    }
                }
                return v1_0;
        }
    }
}
