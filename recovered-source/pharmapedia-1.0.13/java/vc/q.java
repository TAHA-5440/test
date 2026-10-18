// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vc;
public final class q implements android.text.TextWatcher {
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.ui.activities.LanguageActivity g;

    public q(vet.pharmapedia.vetpharmapediapakistan.ui.activities.LanguageActivity p1)
    {
        this.g = p1;
        return;
    }

    public final void afterTextChanged(android.text.Editable p9)
    {
        java.util.ArrayList v0 = xc.i.a;
        if (v0.size() == 0) {
            g6.f0.y();
        }
        java.util.ArrayList v1_2 = new java.util.ArrayList();
        int v2 = v0.size();
        int v3 = 0;
        do {
            boolean v4_0 = this.g;
            if (v3 >= v2) {
                rc.s v9_1 = v4_0.w;
                if (v9_1 != null) {
                    v9_1.l(v1_2);
                }
                return;
            } else {
                Object v5 = v0.get(v3);
                v3++;
            }
        } while(!db.i.T(((vet.pharmapedia.vetpharmapediapakistan.database.models.LanguagesModel) v5).getName(v4_0.j()), db.i.o0(String.valueOf(p9)).toString(), 1));
        v1_2.add(v5);
    }

    public final void beforeTextChanged(CharSequence p1, int p2, int p3, int p4)
    {
        return;
    }

    public final void onTextChanged(CharSequence p1, int p2, int p3, int p4)
    {
        return;
    }
}
