// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vc;
public final synthetic class a implements android.view.View$OnClickListener {
    public final synthetic int g;
    public final synthetic Object h;

    public synthetic a(Object p1, int p2)
    {
        this.g = p2;
        this.h = p1;
        return;
    }

    public final void onClick(android.view.View p4)
    {
        String v0_0 = this.h;
        switch (this.g) {
            case 0:
                ((vet.pharmapedia.vetpharmapediapakistan.ui.activities.AlternativeBrandsActivity) v0_0).finish();
                return;
            case 1:
                ((vet.pharmapedia.vetpharmapediapakistan.ui.activities.AvailableFormsActivity) v0_0).finish();
                return;
            case 2:
                ((vet.pharmapedia.vetpharmapediapakistan.ui.activities.ContactActivity) v0_0).finish();
                return;
            case 3:
                ((vet.pharmapedia.vetpharmapediapakistan.ui.activities.ContraindicationsActivity) v0_0).finish();
                return;
            case 4:
                ((vet.pharmapedia.vetpharmapediapakistan.ui.activities.DosageDetailActivity) v0_0).finish();
                return;
            case 5:
                ((vet.pharmapedia.vetpharmapediapakistan.ui.activities.FeedbackActivity) v0_0).finish();
                return;
            case 6:
                ((vet.pharmapedia.vetpharmapediapakistan.ui.activities.LanguageActivity) v0_0).finish();
                return;
            case 7:
                ((vet.pharmapedia.vetpharmapediapakistan.ui.activities.MedicinesMainActivity) v0_0).finish();
                return;
            case 8:
                String v0_1 = ((vet.pharmapedia.vetpharmapediapakistan.ui.activities.NotificationsActivity) v0_0);
                android.net.Uri v4_1 = v0_1.z;
                try {
                    if (v4_1 != null) {
                        v0_1.startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(v4_1)));
                    }
                } catch (Exception) {
                }
                return;
            case 9:
                ((vet.pharmapedia.vetpharmapediapakistan.ui.activities.PrivacyActivity) v0_0).finish();
                return;
            case 10:
                ((uc.q) v0_0).e.setText("");
                return;
            default:
                ((wc.l) v0_0).p();
                return;
        }
    }
}
