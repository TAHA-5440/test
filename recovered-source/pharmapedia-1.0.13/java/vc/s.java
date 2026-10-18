// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vc;
public final synthetic class s implements android.view.View$OnClickListener {
    public final synthetic int g;
    public final synthetic v4.e h;

    public synthetic s(v4.e p2)
    {
        this.g = 1;
        this.h = p2;
        return;
    }

    public synthetic s(vet.pharmapedia.vetpharmapediapakistan.ui.activities.MainActivity p1, v4.e p2)
    {
        this.g = 0;
        this.h = p2;
        return;
    }

    public final void onClick(android.view.View p4)
    {
        v4.e v0 = this.h;
        switch (this.g) {
            case 0:
                if (com.bumptech.glide.k.b == null) {
                    com.google.firebase.analytics.FirebaseAnalytics v1_3 = vet.pharmapedia.vetpharmapediapakistan.MyAppClass.k;
                }
                com.google.firebase.analytics.FirebaseAnalytics v1_1 = com.bumptech.glide.k.b;
                break;
            default:
                v0.dismiss();
                return;
        }
    }
}
