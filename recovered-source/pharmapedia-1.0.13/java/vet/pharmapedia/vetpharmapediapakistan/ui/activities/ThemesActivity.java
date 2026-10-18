// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.activities;
public final class ThemesActivity extends qc.b {
    public static final synthetic int z;
    public boolean u;
    public uc.n v;
    public rc.a0 w;
    public final java.util.ArrayList x;
    public int y;

    public ThemesActivity()
    {
        this.u = 0;
        this.addOnContextAvailableListener(new vc.p(this, 13));
        this.x = new java.util.ArrayList();
        return;
    }

    public final void m()
    {
        this.p(0);
        return;
    }

    public final void n()
    {
        if (!this.u) {
            this.u = 1;
            uc.n v0_7 = ((qc.f) ((vc.e0) this.a()));
            com.bumptech.glide.q v1_3 = v0_7.b;
            this.p = ((xc.g) v1_3.e.get());
            this.q = ((xc.h) v1_3.f.get());
            this.r = v1_3.a();
            this.s = ((tc.b) v1_3.i.get());
            this.t = ((com.bumptech.glide.q) v1_3.j.get());
            this.v = ((uc.n) v0_7.r.get());
        }
        return;
    }

    public final void onCreate(android.os.Bundle p5)
    {
        super.onCreate(p5);
        this.setContentView(this.q().a);
        int v5_7 = this.x;
        if (v5_7.isEmpty()) {
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099648));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099707));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099718));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099720));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099721));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099722));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099723));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099724));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099725));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099697));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099698));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099699));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099700));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099701));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099702));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099703));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099704));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099705));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099706));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099708));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099709));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099710));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099711));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099712));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099713));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099714));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099715));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099716));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099717));
            v5_7.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(2131099719));
        }
        this.w = new rc.a0(this.j(), this.l(), this);
        vc.d0 v0_19 = this.q().f;
        v0_19.setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager(this.j(), 5));
        int v1_12 = this.w;
        if (v1_12 != 0) {
            v0_19.setAdapter(v1_12);
            vc.d0 v0_20 = this.w;
            if (v0_20 == null) {
                kotlin.jvm.internal.f.i("themeAdapter");
                throw 0;
            } else {
                v0_20.l(v5_7);
            }
        }
        int v5_3 = this.q();
        v5_3.c.setOnClickListener(new vc.d0(this, 0));
        v5_3.d.setOnClickListener(new vc.d0(this, 1));
        v5_3.e.setOnClickListener(new vc.d0(this, 2));
        return;
    }

    public final void p(boolean p3)
    {
        if (p3 == 0) {
            xc.a.a = ((android.content.SharedPreferences) this.l().h).getInt("SELECTED_THEME_KEY", 0);
        } else {
            this.setResult(-1);
        }
        this.finish();
        return;
    }

    public final uc.n q()
    {
        int v0_0 = this.v;
        if (v0_0 == 0) {
            kotlin.jvm.internal.f.i("binding");
            throw 0;
        } else {
            return v0_0;
        }
    }
}
