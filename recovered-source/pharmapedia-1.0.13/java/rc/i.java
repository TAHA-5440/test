// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package rc;
public final class i extends w1.e0 {
    public final l.o e;
    public final xc.g f;
    public final android.app.Activity g;
    public final vet.pharmapedia.vetpharmapediapakistan.ui.activities.DosageDetailActivity h;
    public vet.pharmapedia.vetpharmapediapakistan.utils.b i;

    public i(l.o p3, xc.g p4, android.app.Activity p5, vet.pharmapedia.vetpharmapediapakistan.ui.activities.DosageDetailActivity p6)
    {
        super(new rc.c(1));
        super.e = p3;
        super.f = p4;
        super.g = p5;
        super.h = p6;
        return;
    }

    public final void e(w1.h1 p5, int p6)
    {
        vet.pharmapedia.vetpharmapediapakistan.ui.activities.DosageDetailActivity v6_3 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel) this.k(p6));
        ac.c v0_2 = ((rc.g) p5).u;
        rc.h v1_2 = ((rc.g) p5).v;
        if (v6_3 != null) {
            ((androidx.appcompat.widget.AppCompatTextView) v0_2.c).setText(v6_3.getAnimalName());
            ((androidx.appcompat.widget.AppCompatTextView) v0_2.d).setText(v6_3.getDosageDetail());
            ((rc.g) p5).a.setOnClickListener(new p5.j(v1_2, v6_3, v0_2));
            v1_2.m(v0_2, v6_3);
        }
        xc.a.b.d(v1_2.h, new rc.h(new ac.c(v1_2, 6), 0));
        return;
    }

    public final w1.h1 f(android.view.ViewGroup p12)
    {
        int v12_5 = android.view.LayoutInflater.from(p12.getContext()).inflate(2131558464, p12, 0);
        int v1_0 = 2131362000;
        androidx.appcompat.widget.AppCompatTextView v5_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v12_5, 2131362000));
        if (v5_1 != null) {
            v1_0 = 2131362001;
            if (((androidx.appcompat.widget.AppCompatImageView) a.a.h(v12_5, 2131362001)) != null) {
                v1_0 = 2131362002;
                androidx.appcompat.widget.AppCompatTextView v6_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v12_5, 2131362002));
                if (v6_1 != null) {
                    v1_0 = 2131362003;
                    if (a.a.h(v12_5, 2131362003) != null) {
                        v1_0 = 2131362004;
                        androidx.appcompat.widget.AppCompatImageView v7_1 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v12_5, 2131362004));
                        if (v7_1 != null) {
                            v1_0 = 2131362005;
                            androidx.constraintlayout.widget.Group v8_1 = ((androidx.constraintlayout.widget.Group) a.a.h(v12_5, 2131362005));
                            if (v8_1 != null) {
                                v1_0 = 2131362268;
                                android.widget.ProgressBar v9_1 = ((android.widget.ProgressBar) a.a.h(v12_5, 2131362268));
                                if (v9_1 != null) {
                                    return new rc.g(this, new lc.a(((androidx.constraintlayout.widget.ConstraintLayout) v12_5), v5_1, v6_1, v7_1, v8_1, v9_1, 3));
                                }
                            }
                        }
                    }
                }
            }
        }
        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v12_5.getResources().getResourceName(v1_0)));
        return 0;
    }

    public final void m(lc.a p12, vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel p13)
    {
        p5.h v0_0 = this.f;
        rc.e v5_3 = this.e;
        if ((!v0_0.a()) || (kotlin.jvm.internal.f.a(v5_3.A(), "en"))) {
            if ((!v0_0.a()) && (!kotlin.jvm.internal.f.a(v5_3.A(), "en"))) {
                android.widget.TextView v1_2 = this.g;
                p5.k v6 = p5.k.f(v1_2.findViewById(16908290), v1_2.getString(2131951819));
                p5.h v0_6 = v6.i;
                android.util.TypedValue v4_3 = new android.util.TypedValue();
                v1_2.getTheme().resolveAttribute(2130969682, v4_3, 1);
                ((com.google.android.material.snackbar.SnackbarContentLayout) v0_6.getChildAt(0)).getActionView().setTextColor(v4_3.data);
                ((com.google.android.material.snackbar.SnackbarContentLayout) v0_6.getChildAt(0)).getMessageView().setMaxLines(10);
                v0_6.setAnimationMode(0);
                v6.g(new rc.e(v6, this, p12, p13, 0));
                v6.h();
            }
        } else {
            try {
                ((android.widget.ProgressBar) p12.g).setVisibility(0);
                p5.h v0_10 = new vet.pharmapedia.vetpharmapediapakistan.utils.b(p13.getDosageDetail(), String.valueOf(v5_3.A()));
                this.i = v0_10;
                v0_10.j = new rc.f(p12, p13, this, 1);
                v0_10.a();
                try {
                    ((android.widget.ProgressBar) p12.g).setVisibility(0);
                    p5.h v0_16 = new vet.pharmapedia.vetpharmapediapakistan.utils.b(p13.getAnimalName(), String.valueOf(v5_3.A()));
                    this.i = v0_16;
                    v0_16.j = new rc.f(p12, p13, this, 0);
                    v0_16.a();
                } catch (Exception) {
                    ((androidx.appcompat.widget.AppCompatTextView) p12.c).setText(p13.getAnimalName());
                }
            } catch (Exception) {
                ((androidx.appcompat.widget.AppCompatTextView) p12.d).setText(p13.getDosageDetail());
            }
        }
        return;
    }
}
