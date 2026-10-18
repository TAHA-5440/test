// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.activities;
public final class DisclaimerActivity extends qc.b {
    public static final synthetic int w;
    public boolean u;
    public uc.e v;

    public DisclaimerActivity()
    {
        this.u = 0;
        this.addOnContextAvailableListener(new vc.p(this, 4));
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
            uc.e v0_7 = ((qc.f) ((vc.l) this.a()));
            com.bumptech.glide.q v1_3 = v0_7.b;
            this.p = ((xc.g) v1_3.e.get());
            this.q = ((xc.h) v1_3.f.get());
            this.r = v1_3.a();
            this.s = ((tc.b) v1_3.i.get());
            this.t = ((com.bumptech.glide.q) v1_3.j.get());
            this.v = ((uc.e) v0_7.i.get());
        }
        return;
    }

    public final void onCreate(android.os.Bundle p4)
    {
        super.onCreate(p4);
        androidx.appcompat.widget.AppCompatTextView v4_1 = this.v;
        if (v4_1 == null) {
            kotlin.jvm.internal.f.i("binding");
            throw 0;
        } else {
            this.setContentView(v4_1.a);
            androidx.appcompat.widget.AppCompatTextView v4_4 = this.v;
            if (v4_4 == null) {
                kotlin.jvm.internal.f.i("binding");
                throw 0;
            } else {
                v4_4.b.setOnClickListener(new vc.k(this, 0));
                v4_4.c.setOnClickListener(new vc.k(this, 1));
                return;
            }
        }
    }
}
