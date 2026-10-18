// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package rc;
public final class l extends w1.e0 {
    public final androidx.fragment.app.n0 e;
    public final boolean f;
    public final tc.b g;

    public l(androidx.fragment.app.n0 p3, boolean p4, tc.b p5)
    {
        super(new rc.c(2));
        super.e = p3;
        super.f = p4;
        super.g = p5;
        return;
    }

    public final void e(w1.h1 p7, int p8)
    {
        vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel v8_2 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) this.k(p8));
        if (v8_2 != null) {
            rc.l v0 = ((rc.k) p7).v;
            androidx.appcompat.widget.AppCompatImageView v1_8 = v0.f;
            rc.a v2_2 = ((rc.k) p7).u;
            if ((!v8_2.isBrandFavourite()) || (v1_8 == null)) {
                if ((!v8_2.isSaltFavourite()) || (v1_8 != null)) {
                    v2_2.b.setImageResource(2131230840);
                } else {
                    v2_2.b.setImageResource(2131231274);
                }
            } else {
                v2_2.b.setImageResource(2131231274);
            }
            int v3_4 = v0.e;
            if ((v1_8 == null) || (!v8_2.isBrandFavourite())) {
                if ((v1_8 != null) || (!v8_2.isSaltFavourite())) {
                    androidx.appcompat.widget.AppCompatImageView v1_1 = v2_2.a;
                    v1_1.getClass();
                    v1_1.setVisibility(8);
                } else {
                    v2_2.c.setText(v8_2.getSaltName());
                }
            } else {
                v2_2.c.setText(v8_2.getBrandName());
            }
            if ((((rc.k) p7).b() % 2) != 0) {
                v2_2.a.setBackgroundColor(v3_4.getColor(2131100670));
            } else {
                v2_2.a.setBackgroundColor(v3_4.getColor(2131099789));
            }
            v2_2.c.setOnClickListener(new p5.j(2, v0, v8_2));
            v2_2.b.setOnClickListener(new rc.a(v0, v8_2, ((rc.k) p7), 1));
        }
        return;
    }

    public final w1.h1 f(android.view.ViewGroup p3)
    {
        return new rc.k(this, uc.o.a(android.view.LayoutInflater.from(p3.getContext()), p3));
    }
}
