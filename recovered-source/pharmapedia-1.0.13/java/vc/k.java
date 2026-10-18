// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vc;
public final synthetic class k implements android.view.View$OnClickListener {
    public final synthetic int g;
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.ui.activities.DisclaimerActivity h;

    public synthetic k(vet.pharmapedia.vetpharmapediapakistan.ui.activities.DisclaimerActivity p1, int p2)
    {
        this.g = p2;
        this.h = p1;
        return;
    }

    public final void onClick(android.view.View p3)
    {
        android.app.Activity v0_0 = this.h;
        switch (this.g) {
            case 0:
                v0_0.finish();
                return;
            default:
                vet.pharmapedia.vetpharmapediapakistan.utils.a.d(v0_0.j(), "Clicked on disclaimer", "Disclaimer");
                return;
        }
    }
}
