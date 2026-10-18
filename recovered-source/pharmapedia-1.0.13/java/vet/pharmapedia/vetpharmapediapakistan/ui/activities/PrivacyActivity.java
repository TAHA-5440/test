// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.activities;
public final class PrivacyActivity extends qc.b {
    public static final synthetic int x;
    public boolean u;
    public uc.l v;
    public final String w;

    public PrivacyActivity()
    {
        this.u = 0;
        this.addOnContextAvailableListener(new vc.p(this, 11));
        this.w = "https://pages.flycricket.io/vet-pharmapedia-paki/privacy.html";
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
            uc.l v0_7 = ((qc.f) ((vc.b0) this.a()));
            com.bumptech.glide.q v1_3 = v0_7.b;
            this.p = ((xc.g) v1_3.e.get());
            this.q = ((xc.h) v1_3.f.get());
            this.r = v1_3.a();
            this.s = ((tc.b) v1_3.i.get());
            this.t = ((com.bumptech.glide.q) v1_3.j.get());
            this.v = ((uc.l) v0_7.p.get());
        }
        return;
    }

    public final void onCreate(android.os.Bundle p4)
    {
        super.onCreate(p4);
        this.setContentView(this.p().a);
        this.q();
        this.p().b.setOnClickListener(new vc.a(this, 9));
        int v4_1 = this.q;
        if (v4_1 == 0) {
            kotlin.jvm.internal.f.i("internetObserver");
            throw 0;
        } else {
            v4_1.d(this, new rc.h(new ac.c(this, 11), 4));
            return;
        }
    }

    public final uc.l p()
    {
        int v0_0 = this.v;
        if (v0_0 == 0) {
            kotlin.jvm.internal.f.i("binding");
            throw 0;
        } else {
            return v0_0;
        }
    }

    public final void q()
    {
        android.webkit.WebView v0_0 = this.p();
        vc.a0 v1_0 = v0_0.e;
        android.widget.ProgressBar v2 = v0_0.c;
        android.webkit.WebView v0_3 = v0_0.d;
        if (!this.i().a()) {
            v0_3.setVisibility(0);
            v2.setVisibility(8);
            v1_0.setVisibility(8);
            return;
        } else {
            v0_3.setVisibility(8);
            v2.setVisibility(0);
            v1_0.setVisibility(0);
            android.webkit.WebView v0_2 = this.p().e;
            v0_2.loadUrl(this.w);
            v0_2.setWebViewClient(new vc.a0(this));
            return;
        }
    }
}
