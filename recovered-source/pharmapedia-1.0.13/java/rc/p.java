// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package rc;
public final class p extends w1.e0 {
    public final l.o e;
    public final xc.g f;
    public final android.app.Activity g;
    public final vet.pharmapedia.vetpharmapediapakistan.ui.activities.AvailableFormsActivity h;
    public rc.n i;
    public vet.pharmapedia.vetpharmapediapakistan.utils.b j;

    public p(l.o p3, xc.g p4, android.app.Activity p5, vet.pharmapedia.vetpharmapediapakistan.ui.activities.AvailableFormsActivity p6)
    {
        super(new rc.c(4));
        super.e = p3;
        super.f = p4;
        super.g = p5;
        super.h = p6;
        return;
    }

    public final void e(w1.h1 p5, int p6)
    {
        this.i = new rc.n(new rc.c(3));
        vet.pharmapedia.vetpharmapediapakistan.ui.activities.AvailableFormsActivity v6_3 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel) this.k(p6));
        ac.c v0_1 = ((rc.o) p5).u;
        rc.h v1_0 = ((rc.o) p5).v;
        if (v6_3 != null) {
            ((androidx.recyclerview.widget.RecyclerView) v0_1.c).setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager());
            p5.j v2_2 = v1_0.i;
            if (v2_2 != null) {
                ((androidx.recyclerview.widget.RecyclerView) v0_1.c).setAdapter(v2_2);
                p5.j v2_3 = v1_0.i;
                if (v2_3 == null) {
                    kotlin.jvm.internal.f.i("formsChildAdapter");
                    throw 0;
                } else {
                    v2_3.l(v6_3.getList());
                }
            }
            ((androidx.appcompat.widget.AppCompatTextView) v0_1.d).setText(v6_3.getFormName());
            ((rc.o) p5).a.setOnClickListener(new p5.j(3, v6_3, v0_1));
            v1_0.m(v0_1, v6_3);
        }
        xc.a.b.d(v1_0.h, new rc.h(new ac.c(v1_0, 7), 1));
        return;
    }

    public final w1.h1 f(android.view.ViewGroup p12)
    {
        int v12_5 = android.view.LayoutInflater.from(p12.getContext()).inflate(2131558443, p12, 0);
        int v1_0 = 2131361894;
        androidx.recyclerview.widget.RecyclerView v5_1 = ((androidx.recyclerview.widget.RecyclerView) a.a.h(v12_5, 2131361894));
        if (v5_1 != null) {
            v1_0 = 2131361895;
            if (a.a.h(v12_5, 2131361895) != null) {
                v1_0 = 2131361896;
                androidx.appcompat.widget.AppCompatTextView v6_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v12_5, 2131361896));
                if (v6_1 != null) {
                    v1_0 = 2131361897;
                    androidx.constraintlayout.widget.Group v7_1 = ((androidx.constraintlayout.widget.Group) a.a.h(v12_5, 2131361897));
                    if (v7_1 != null) {
                        v1_0 = 2131362001;
                        if (((androidx.appcompat.widget.AppCompatImageView) a.a.h(v12_5, 2131362001)) != null) {
                            v1_0 = 2131362004;
                            androidx.appcompat.widget.AppCompatImageView v8_1 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v12_5, 2131362004));
                            if (v8_1 != null) {
                                v1_0 = 2131362269;
                                android.widget.ProgressBar v9_1 = ((android.widget.ProgressBar) a.a.h(v12_5, 2131362269));
                                if (v9_1 != null) {
                                    return new rc.o(this, new lc.a(((androidx.constraintlayout.widget.ConstraintLayout) v12_5), v5_1, v6_1, v7_1, v8_1, v9_1, 2));
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

    public final void m(lc.a p11, vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel p12)
    {
        p5.h v0_0 = this.f;
        rc.e v4_1 = this.e;
        if ((!v0_0.a()) || (kotlin.jvm.internal.f.a(v4_1.A(), "en"))) {
            if ((!v0_0.a()) && (!kotlin.jvm.internal.f.a(v4_1.A(), "en"))) {
                android.widget.TextView v1_2 = this.g;
                p5.k v5 = p5.k.f(v1_2.findViewById(16908290), v1_2.getString(2131951819));
                p5.h v0_6 = v5.i;
                int v3_3 = new android.util.TypedValue();
                v1_2.getTheme().resolveAttribute(2130969682, v3_3, 1);
                ((com.google.android.material.snackbar.SnackbarContentLayout) v0_6.getChildAt(0)).getActionView().setTextColor(v3_3.data);
                ((com.google.android.material.snackbar.SnackbarContentLayout) v0_6.getChildAt(0)).getMessageView().setMaxLines(10);
                v0_6.setAnimationMode(0);
                v5.g(new rc.e(v5, this, p11, p12, 1));
                v5.h();
            }
            return;
        } else {
            try {
                ((android.widget.ProgressBar) p11.g).setVisibility(0);
                android.widget.TextView v1_8 = p12.getFormName();
                v1_8.getClass();
                p5.h v0_10 = new vet.pharmapedia.vetpharmapediapakistan.utils.b(v1_8, String.valueOf(v4_1.A()));
                this.j = v0_10;
                v0_10.j = new rc.f(p11, p12, this, 2);
                v0_10.a();
                return;
            } catch (Exception) {
                ((androidx.appcompat.widget.AppCompatTextView) p11.d).setText(p12.getFormName());
                return;
            }
        }
    }
}
