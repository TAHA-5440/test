// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package rc;
public final class n extends w1.e0 {

    public final void e(w1.h1 p3, int p4)
    {
        String v4_2 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsDetailModel) this.k(p4));
        if (v4_2 != null) {
            m.m2 v0 = ((rc.m) p3).u;
            if (((rc.m) p3).b() != 0) {
                ((androidx.appcompat.widget.AppCompatTextView) v0.c).setVisibility(8);
                ((androidx.appcompat.widget.AppCompatTextView) v0.e).setVisibility(8);
                v0.a.setVisibility(4);
            } else {
                ((androidx.appcompat.widget.AppCompatTextView) v0.c).setVisibility(0);
                ((androidx.appcompat.widget.AppCompatTextView) v0.e).setVisibility(0);
                v0.a.setVisibility(0);
            }
            ((androidx.appcompat.widget.AppCompatTextView) v0.g).setText(v4_2.getWeight());
            ((androidx.appcompat.widget.AppCompatTextView) v0.d).setText(v4_2.getPacking());
            ((androidx.appcompat.widget.AppCompatTextView) v0.f).setText(v4_2.getPrice());
        }
        return;
    }

    public final w1.h1 f(android.view.ViewGroup p12)
    {
        int v12_5 = android.view.LayoutInflater.from(p12.getContext()).inflate(2131558442, p12, 0);
        int v1_0 = 2131362051;
        androidx.appcompat.widget.AppCompatTextView v5_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v12_5, 2131362051));
        if (v5_1 != null) {
            v1_0 = 2131362052;
            androidx.appcompat.widget.AppCompatTextView v6_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v12_5, 2131362052));
            if (v6_1 != null) {
                v1_0 = 2131362053;
                androidx.appcompat.widget.AppCompatTextView v7_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v12_5, 2131362053));
                if (v7_1 != null) {
                    v1_0 = 2131362054;
                    androidx.appcompat.widget.AppCompatTextView v8_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v12_5, 2131362054));
                    if (v8_1 != null) {
                        v1_0 = 2131362055;
                        android.view.View v9 = a.a.h(v12_5, 2131362055);
                        if (v9 != null) {
                            v1_0 = 2131362056;
                            androidx.appcompat.widget.AppCompatTextView v10_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v12_5, 2131362056));
                            if (v10_1 != null) {
                                return new rc.m(new m.m2(((androidx.constraintlayout.widget.ConstraintLayout) v12_5), v5_1, v6_1, v7_1, v8_1, v9, v10_1));
                            }
                        }
                    }
                }
            }
        }
        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v12_5.getResources().getResourceName(v1_0)));
        return 0;
    }
}
