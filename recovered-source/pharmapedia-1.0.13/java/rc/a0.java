// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package rc;
public final class a0 extends w1.e0 {
    public final android.app.Activity e;
    public final vet.pharmapedia.vetpharmapediapakistan.ui.activities.ThemesActivity f;
    public int g;

    public a0(android.app.Activity p3, l.o p4, vet.pharmapedia.vetpharmapediapakistan.ui.activities.ThemesActivity p5)
    {
        super(new rc.c(9));
        super.e = p3;
        super.f = p5;
        super.g = ((android.content.SharedPreferences) p4.h).getInt("SELECTED_THEME_KEY", 0);
        return;
    }

    public final void e(w1.h1 p5, int p6)
    {
        com.google.android.material.imageview.ShapeableImageView v0_4 = this.k(p6);
        v0_4.getClass();
        jb.e v1 = ((rc.z) p5).u;
        int v5_5 = ((rc.z) p5).v;
        ((com.google.android.material.imageview.ShapeableImageView) v1.i).setBackgroundColor(v5_5.e.getColor(((vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel) v0_4).getSelectedTheme()));
        com.google.android.material.imageview.ShapeableImageView v0_3 = ((com.google.android.material.imageview.ShapeableImageView) v1.i);
        if (p6 != v5_5.g) {
            v0_3.setImageResource(0);
            return;
        } else {
            v0_3.setImageResource(2131231275);
            return;
        }
    }

    public final w1.h1 f(android.view.ViewGroup p5)
    {
        int v5_6 = android.view.LayoutInflater.from(p5.getContext()).inflate(2131558552, p5, 0);
        com.google.android.material.imageview.ShapeableImageView v2_1 = ((com.google.android.material.imageview.ShapeableImageView) a.a.h(v5_6, 2131362417));
        if (v2_1 == null) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v5_6.getResources().getResourceName(2131362417)));
            return 0;
        } else {
            return new rc.z(this, new jb.e(13, ((androidx.constraintlayout.widget.ConstraintLayout) v5_6), v2_1));
        }
    }
}
