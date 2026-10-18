// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vc;
public final class a0 extends android.webkit.WebViewClient {
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.ui.activities.PrivacyActivity a;

    public a0(vet.pharmapedia.vetpharmapediapakistan.ui.activities.PrivacyActivity p1)
    {
        this.a = p1;
        return;
    }

    public final void onPageFinished(android.webkit.WebView p1, String p2)
    {
        super.onPageFinished(p1, p2);
        this.a.p().c.setVisibility(8);
        return;
    }

    public final void onReceivedError(android.webkit.WebView p2, android.webkit.WebResourceRequest p3, android.webkit.WebResourceError p4)
    {
        p2.getClass();
        p3.getClass();
        p4.getClass();
        super.onReceivedError(p2, p3, p4);
        android.widget.Toast v2_2 = this.a;
        android.app.Activity v3_1 = v2_2.j();
        android.widget.Toast v2_3 = v2_2.getString(2131951732);
        v2_3.getClass();
        android.widget.Toast v2_1 = android.widget.Toast.makeText(v3_1, v2_3, 0);
        yc.d.a(v2_1.getView(), new yc.c(v3_1));
        new yc.d(v3_1, v2_1).show();
        return;
    }

    public final boolean shouldOverrideUrlLoading(android.webkit.WebView p1, android.webkit.WebResourceRequest p2)
    {
        return 1;
    }
}
