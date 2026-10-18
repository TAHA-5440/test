// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.activities;
public final class FeedbackActivity extends qc.b {
    public static final synthetic int w;
    public boolean u;
    public uc.g v;

    public FeedbackActivity()
    {
        this.u = 0;
        this.addOnContextAvailableListener(new vc.p(this, 6));
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
            uc.g v0_7 = ((qc.f) ((vc.o) this.a()));
            com.bumptech.glide.q v1_3 = v0_7.b;
            this.p = ((xc.g) v1_3.e.get());
            this.q = ((xc.h) v1_3.f.get());
            this.r = v1_3.a();
            this.s = ((tc.b) v1_3.i.get());
            this.t = ((com.bumptech.glide.q) v1_3.j.get());
            this.v = ((uc.g) v0_7.k.get());
        }
        return;
    }

    public final void onCreate(android.os.Bundle p4)
    {
        super.onCreate(p4);
        uc.g v4_1 = this.v;
        if (v4_1 == null) {
            kotlin.jvm.internal.f.i("binding");
            throw 0;
        } else {
            this.setContentView(v4_1.a);
            uc.g v4_3 = this.v;
            if (v4_3 == null) {
                kotlin.jvm.internal.f.i("binding");
                throw 0;
            } else {
                v4_3.b.setOnClickListener(new vc.a(this, 5));
                v4_3.c.setOnClickListener(new vc.n(this, v4_3, 0));
                v4_3.d.setOnClickListener(new vc.n(this, v4_3, 1));
                return;
            }
        }
    }
}
