// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ic;
public final class a extends ic.e implements ic.d {
    public static final boolean e;
    public android.content.Context c;
    public final java.util.ArrayList d;

    static a()
    {
        int v0_1;
        if (android.os.Build$VERSION.SDK_INT < 29) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        ic.a.e = v0_1;
        return;
    }

    public a()
    {
        java.util.ArrayList v0_5;
        if (android.os.Build$VERSION.SDK_INT < 29) {
            v0_5 = 0;
        } else {
            v0_5 = new jc.a();
        }
        java.util.ArrayList v1_4 = new jc.m(jc.e.e);
        int v2_1 = new jc.m(jc.k.a);
        Object v3_2 = new jc.m(jc.h.a);
        boolean v4_2 = new jc.n[4];
        int v5 = 0;
        v4_2[0] = v0_5;
        v4_2[1] = v1_4;
        v4_2[2] = v2_1;
        v4_2[3] = v3_2;
        java.util.ArrayList v0_4 = ha.i.O(v4_2);
        java.util.ArrayList v1_2 = new java.util.ArrayList();
        int v2_2 = v0_4.size();
        while (v5 < v2_2) {
            Object v3_3 = v0_4.get(v5);
            v5++;
            if (((jc.n) v3_3).a()) {
                v1_2.add(v3_3);
            }
        }
        this.d = v1_2;
        return;
    }

    public final void a(android.content.Context p1)
    {
        this.c = p1;
        return;
    }

    public final android.content.Context b()
    {
        return this.c;
    }

    public final com.bumptech.glide.j c(javax.net.ssl.X509TrustManager p4)
    {
        p4.getClass();
        mc.a v0_0 = 0;
        try {
            mc.b v1_4 = new android.net.http.X509TrustManagerExtensions(p4);
        } catch (IllegalArgumentException) {
            v1_4 = 0;
        }
        if (v1_4 != null) {
            v0_0 = new jc.b(p4, v1_4);
        }
        if (v0_0 == null) {
            p4.getClass();
            android.os.StrictMode.noteSlowCall("buildTrustRootIndex");
            java.security.cert.X509Certificate[] v4_1 = p4.getAcceptedIssuers();
            return new mc.a(new mc.b(((java.security.cert.X509Certificate[]) java.util.Arrays.copyOf(v4_1, v4_1.length))));
        } else {
            return v0_0;
        }
    }

    public final void d(javax.net.ssl.SSLSocket p6, String p7, java.util.List p8)
    {
        p8.getClass();
        java.util.ArrayList v0 = this.d;
        int v1 = v0.size();
        int v2 = 0;
        while (v2 < v1) {
            jc.n v3_1 = v0.get(v2);
            v2++;
            if (((jc.n) v3_1).b(p6)) {
            }
            jc.n v3_0 = ((jc.n) v3_1);
            if (v3_0 != null) {
                v3_0.d(p6, p7, p8);
            }
            return;
        }
        v3_1 = 0;
    }

    public final String f(javax.net.ssl.SSLSocket p7)
    {
        java.util.ArrayList v0 = this.d;
        int v1 = v0.size();
        int v2 = 0;
        while (v2 < v1) {
            jc.n v4_1 = v0.get(v2);
            v2++;
            if (((jc.n) v4_1).b(p7)) {
            }
            jc.n v4_0 = ((jc.n) v4_1);
            if (v4_0 == null) {
                return 0;
            } else {
                return v4_0.c(p7);
            }
        }
        v4_1 = 0;
    }

    public final Object g()
    {
        if (android.os.Build$VERSION.SDK_INT < 30) {
            return super.g();
        } else {
            Object v0_2 = androidx.work.impl.utils.a.i();
            androidx.work.impl.utils.a.s(v0_2);
            return v0_2;
        }
    }

    public final boolean h(String p2)
    {
        p2.getClass();
        return android.security.NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(p2);
    }

    public final void i(int p3, String p4, Throwable p5)
    {
        if (p3 != 5) {
            int vtmp2 = android.util.Log.i("OkHttp", p4, p5);
            return;
        } else {
            int vtmp1 = android.util.Log.w("OkHttp", p4, p5);
            return;
        }
    }

    public final void j(Object p3, String p4)
    {
        if (android.os.Build$VERSION.SDK_INT < 30) {
            super.j(p3, p4);
            return;
        } else {
            p3.getClass();
            androidx.work.impl.utils.a.z(androidx.work.impl.utils.a.j(p3));
            return;
        }
    }

    public final javax.net.ssl.SSLContext k()
    {
        android.os.StrictMode.noteSlowCall("newSSLContext");
        javax.net.ssl.SSLContext v0_2 = javax.net.ssl.SSLContext.getInstance("TLS");
        v0_2.getClass();
        return v0_2;
    }
}
