// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package rc;
public final synthetic class f implements ua.l {
    public final synthetic int g;
    public final synthetic Object h;
    public final synthetic java.io.Serializable i;
    public final synthetic w1.e0 j;

    public synthetic f(Object p1, java.io.Serializable p2, w1.e0 p3, int p4)
    {
        this.g = p4;
        this.h = p1;
        this.i = p2;
        this.j = p3;
        return;
    }

    public final Object invoke(Object p9)
    {
        ga.p v1 = ga.p.a;
        rc.i v5_2 = this.j;
        vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel v6_2 = this.i;
        lc.a v7_1 = ((lc.a) this.h);
        switch (this.g) {
            case 0:
                vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel v6_1 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel) v6_2);
                rc.i v5_1 = ((rc.i) v5_2);
                ((String) p9).getClass();
                ((androidx.appcompat.widget.AppCompatTextView) v7_1.c).setText(((String) p9));
                ((android.widget.ProgressBar) v7_1.g).setVisibility(8);
                if (((String) p9).length() == 0) {
                    ((androidx.appcompat.widget.AppCompatTextView) v7_1.c).setText(v6_1.getAnimalName());
                    android.app.Activity v9_10 = v5_1.g;
                    android.widget.Toast v0_14 = v9_10.getString(2131951697);
                    v0_14.getClass();
                    android.widget.Toast v0_15 = android.widget.Toast.makeText(v9_10, v0_14, 0);
                    yc.d.a(v0_15.getView(), new yc.c(v9_10));
                    new yc.d(v9_10, v0_15).show();
                }
                return v1;
            case 1:
                vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel v6_0 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel) v6_2);
                rc.i v5_0 = ((rc.i) v5_2);
                ((String) p9).getClass();
                ((androidx.appcompat.widget.AppCompatTextView) v7_1.d).setText(((String) p9));
                ((android.widget.ProgressBar) v7_1.g).setVisibility(8);
                if (((String) p9).length() == 0) {
                    ((androidx.appcompat.widget.AppCompatTextView) v7_1.d).setText(v6_0.getDosageDetail());
                    android.app.Activity v9_5 = v5_0.g;
                    android.widget.Toast v0_7 = v9_5.getString(2131951697);
                    v0_7.getClass();
                    android.widget.Toast v0_8 = android.widget.Toast.makeText(v9_5, v0_7, 0);
                    yc.d.a(v0_8.getView(), new yc.c(v9_5));
                    new yc.d(v9_5, v0_8).show();
                }
                return v1;
            default:
                vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel v6_3 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel) v6_2);
                rc.i v5_3 = ((rc.p) v5_2);
                ((String) p9).getClass();
                ((androidx.appcompat.widget.AppCompatTextView) v7_1.d).setText(((String) p9));
                ((android.widget.ProgressBar) v7_1.g).setVisibility(8);
                if (((String) p9).length() == 0) {
                    ((androidx.appcompat.widget.AppCompatTextView) v7_1.d).setText(v6_3.getFormName());
                    android.app.Activity v9_15 = v5_3.g;
                    android.widget.Toast v0_21 = v9_15.getString(2131951697);
                    v0_21.getClass();
                    android.widget.Toast v0_1 = android.widget.Toast.makeText(v9_15, v0_21, 0);
                    yc.d.a(v0_1.getView(), new yc.c(v9_15));
                    new yc.d(v9_15, v0_1).show();
                }
                return v1;
        }
    }
}
