// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.activities;
public final class LanguageActivity extends qc.b {
    public static final synthetic int x;
    public boolean u;
    public uc.h v;
    public rc.s w;

    public LanguageActivity()
    {
        this.u = 0;
        this.addOnContextAvailableListener(new vc.p(this, 7));
        return;
    }

    public final void m()
    {
        this.finish();
        return;
    }

    public final void n()
    {
        if (!this.u) {
            this.u = 1;
            uc.h v0_7 = ((qc.f) ((vc.r) this.a()));
            com.bumptech.glide.q v1_3 = v0_7.b;
            this.p = ((xc.g) v1_3.e.get());
            this.q = ((xc.h) v1_3.f.get());
            this.r = v1_3.a();
            this.s = ((tc.b) v1_3.i.get());
            this.t = ((com.bumptech.glide.q) v1_3.j.get());
            this.v = ((uc.h) v0_7.l.get());
        }
        return;
    }

    public final void onCreate(android.os.Bundle p6)
    {
        super.onCreate(p6);
        String v6_1 = this.v;
        if (v6_1 == null) {
            kotlin.jvm.internal.f.i("binding");
            throw 0;
        } else {
            this.setContentView(v6_1.a);
            vc.q v2_0 = this.l();
            int v3_0 = this.t;
            if (v3_0 == 0) {
                kotlin.jvm.internal.f.i("glide");
                throw 0;
            } else {
                this.w = new rc.s(v2_0, v3_0, this.j(), this);
                String v6_4 = this.v;
                if (v6_4 == null) {
                    kotlin.jvm.internal.f.i("binding");
                    throw 0;
                } else {
                    v6_4.b.setOnClickListener(new vc.a(this, 6));
                    v6_4.d.addTextChangedListener(new vc.q(this));
                    String v6_5 = v6_4.c;
                    this.j();
                    v6_5.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager());
                    java.util.ArrayList v0_5 = this.w;
                    if (v0_5 == null) {
                        return;
                    } else {
                        v6_5.setAdapter(v0_5);
                        String v6_6 = this.w;
                        if (v6_6 == null) {
                            kotlin.jvm.internal.f.i("languagesAdapter");
                            throw 0;
                        } else {
                            java.util.ArrayList v0_6 = xc.i.a;
                            if (v0_6.size() == 0) {
                                g6.f0.y();
                            }
                            v6_6.l(v0_6);
                            return;
                        }
                    }
                }
            }
        }
    }
}
