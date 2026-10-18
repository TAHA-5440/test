// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package rc;
public final class s extends w1.e0 {
    public final l.o e;
    public final com.bumptech.glide.q f;
    public final android.app.Activity g;
    public final vet.pharmapedia.vetpharmapediapakistan.ui.activities.LanguageActivity h;

    public s(l.o p3, com.bumptech.glide.q p4, android.app.Activity p5, vet.pharmapedia.vetpharmapediapakistan.ui.activities.LanguageActivity p6)
    {
        super(new rc.c(5));
        super.e = p3;
        super.f = p4;
        super.g = p5;
        super.h = p6;
        return;
    }

    public final void e(w1.h1 p6, int p7)
    {
        vet.pharmapedia.vetpharmapediapakistan.database.models.LanguagesModel v7_2 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.LanguagesModel) this.k(p7));
        if (v7_2 != null) {
            rc.s v0 = ((rc.r) p6).v;
            android.view.View v1_3 = ((rc.r) p6).u;
            ((android.widget.RadioButton) v1_3.k).setChecked(kotlin.jvm.internal.f.a(v7_2.getTranslationAbbr(), v0.e.A()));
            ((androidx.appcompat.widget.AppCompatTextView) v1_3.j).setText(v7_2.getName(v0.g));
            v0.f.j(Integer.valueOf(v7_2.getFlag())).y(((com.google.android.material.imageview.ShapeableImageView) v1_3.i));
            ((rc.r) p6).a.setOnClickListener(new rc.a(((rc.r) p6), v0, v7_2, 2));
        }
        return;
    }

    public final w1.h1 f(android.view.ViewGroup p10)
    {
        int v10_5 = android.view.LayoutInflater.from(p10.getContext()).inflate(2131558473, p10, 0);
        int v1_0 = 2131362117;
        com.google.android.material.imageview.ShapeableImageView v5_1 = ((com.google.android.material.imageview.ShapeableImageView) a.a.h(v10_5, 2131362117));
        if (v5_1 != null) {
            v1_0 = 2131362118;
            androidx.appcompat.widget.AppCompatTextView v6_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v10_5, 2131362118));
            if (v6_1 != null) {
                v1_0 = 2131362119;
                android.widget.RadioButton v7_1 = ((android.widget.RadioButton) a.a.h(v10_5, 2131362119));
                if (v7_1 != null) {
                    return new rc.r(this, new c0.g(((com.google.android.material.card.MaterialCardView) v10_5), v5_1, v6_1, v7_1, 14));
                }
            }
        }
        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v10_5.getResources().getResourceName(v1_0)));
        return 0;
    }
}
