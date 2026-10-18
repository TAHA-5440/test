// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vc;
public final synthetic class d0 implements android.view.View$OnClickListener {
    public final synthetic int g;
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.ui.activities.ThemesActivity h;

    public synthetic d0(vet.pharmapedia.vetpharmapediapakistan.ui.activities.ThemesActivity p1, int p2)
    {
        this.g = p2;
        this.h = p1;
        return;
    }

    public final void onClick(android.view.View p4)
    {
        vet.pharmapedia.vetpharmapediapakistan.ui.activities.ThemesActivity v1 = this.h;
        switch (this.g) {
            case 0:
                v1.p(0);
                return;
            case 1:
                ((android.content.SharedPreferences) v1.l().h).edit().putInt("SELECTED_THEME_KEY", v1.y).apply();
                v1.p(1);
                return;
            default:
                v1.p(0);
                return;
        }
    }
}
