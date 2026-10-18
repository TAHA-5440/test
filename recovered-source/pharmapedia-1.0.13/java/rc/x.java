// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package rc;
public final class x extends w1.e0 {
    public final android.app.Activity e;
    public final boolean f;
    public final tc.b g;
    public final androidx.lifecycle.v h;

    public x(android.app.Activity p1, boolean p2, tc.b p3, l.o p4, xc.g p5, androidx.lifecycle.v p6)
    {
        p6.getClass();
        super(new rc.c(7));
        super.e = p1;
        super.f = p2;
        super.g = p3;
        super.h = p6;
        return;
    }

    public final void e(w1.h1 p7, int p8)
    {
        androidx.lifecycle.v v8_2 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) this.k(p8));
        if (v8_2 != null) {
            rc.h v0_0 = ((rc.w) p7).v;
            androidx.room.w0 v1_8 = v0_0.f;
            rc.u v2_2 = ((rc.w) p7).u;
            if ((!v8_2.isBrandFavourite()) || (v1_8 == null)) {
                if ((!v8_2.isSaltFavourite()) || (v1_8 != null)) {
                    v2_2.b.setImageResource(2131230840);
                } else {
                    v2_2.b.setImageResource(2131231274);
                }
            } else {
                v2_2.b.setImageResource(2131231274);
            }
            if (v1_8 == null) {
                v2_2.c.setText(v8_2.getSaltName());
            } else {
                v2_2.c.setText(v8_2.getBrandName());
            }
            if ((((rc.w) p7).b() % 2) != 0) {
                androidx.room.w0 v1_4 = v2_2.a;
                v1_4.setBackgroundColor(v1_4.getContext().getColor(2131100670));
            } else {
                androidx.room.w0 v1_5 = v2_2.a;
                v1_5.setBackgroundColor(v1_5.getContext().getColor(2131099789));
            }
            v2_2.c.setOnClickListener(new rc.u(((rc.w) p7), v0_0, v8_2, 0));
            v2_2.b.setOnClickListener(new rc.u(((rc.w) p7), v0_0, v8_2, 1));
            xc.a.b.d(v0_0.h, new rc.h(new androidx.room.w0(v0_0), 2));
        }
        return;
    }

    public final w1.h1 f(android.view.ViewGroup p3)
    {
        return new rc.w(this, uc.o.a(android.view.LayoutInflater.from(p3.getContext()), p3));
    }
}
