// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package wc;
public final class n extends wc.g {
    public uc.r u;
    public rc.d v;
    public final java.util.ArrayList w;
    public final f.c x;

    public n()
    {
        this.w = new java.util.ArrayList();
        f.c v0_1 = this.registerForActivityResult(new androidx.fragment.app.c1(2), new androidx.work.impl.b(this, 22));
        v0_1.getClass();
        this.x = v0_1;
        return;
    }

    public final android.view.View onCreateView(android.view.LayoutInflater p1, android.view.ViewGroup p2, android.os.Bundle p3)
    {
        p1.getClass();
        int v1_1 = this.u;
        if (v1_1 == 0) {
            kotlin.jvm.internal.f.i("binding");
            throw 0;
        } else {
            int v1_4 = v1_1.a;
            v1_4.getClass();
            return v1_4;
        }
    }

    public final void onViewCreated(android.view.View p4, android.os.Bundle p5)
    {
        p4.getClass();
        super.onViewCreated(p4, p5);
        String v4_2 = this.w;
        if (v4_2.isEmpty()) {
            int v0_16 = this.getString(2131951836);
            v0_16.getClass();
            rc.d v1_6 = this.getString(2131951708);
            v1_6.getClass();
            v4_2.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel(2131231128, v0_16, v1_6));
            int v0_4 = this.getString(2131951710);
            v0_4.getClass();
            rc.d v1_8 = this.getString(2131951707);
            v1_8.getClass();
            v4_2.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel(2131231284, v0_4, v1_8));
            int v0_6 = this.getString(2131951746);
            v0_6.getClass();
            rc.d v1_10 = this.getString(2131952024);
            v1_10.getClass();
            v4_2.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel(2131230897, v0_6, v1_10));
            int v0_8 = this.getString(2131952016);
            v0_8.getClass();
            rc.d v1_12 = this.getString(2131952023);
            v1_12.getClass();
            v4_2.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel(2131231269, v0_8, v1_12));
            int v0_10 = this.getString(2131951776);
            v0_10.getClass();
            rc.d v1_14 = this.getString(2131951791);
            v1_14.getClass();
            v4_2.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel(2131230900, v0_10, v1_14));
            int v0_12 = this.getString(2131951733);
            v0_12.getClass();
            rc.d v1_16 = this.getString(2131951734);
            v1_16.getClass();
            v4_2.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel(2131230882, v0_12, v1_16));
            int v0_15 = this.getString(2131952020);
            v0_15.getClass();
            rc.d v1_18 = this.getString(2131952021);
            v1_18.getClass();
            v4_2.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel(2131231271, v0_15, v1_18));
            int v0_18 = this.getString(2131952047);
            v0_18.getClass();
            rc.d v1_20 = this.getString(2131952048);
            v1_20.getClass();
            v4_2.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel(2131231280, v0_18, v1_20));
            int v0_1 = this.getString(2131952085);
            v0_1.getClass();
            rc.d v1_1 = this.getString(2131951660);
            v1_1.getClass();
            v4_2.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel(2131231290, v0_1, v1_1));
        }
        this.v = new rc.d(this);
        rc.d v5_6 = this.u;
        if (v5_6 == null) {
            kotlin.jvm.internal.f.i("binding");
            throw 0;
        } else {
            rc.d v5_7 = v5_6.b;
            this.h();
            v5_7.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager());
            rc.d v1_5 = this.v;
            if (v1_5 == null) {
                kotlin.jvm.internal.f.i("settingsAdapter");
                throw 0;
            } else {
                v5_7.setAdapter(v1_5);
                rc.d v5_8 = this.v;
                if (v5_8 == null) {
                    kotlin.jvm.internal.f.i("settingsAdapter");
                    throw 0;
                } else {
                    v5_8.l(v4_2);
                    return;
                }
            }
        }
    }
}
