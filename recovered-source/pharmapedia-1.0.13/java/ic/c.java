// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ic;
public final class c extends ic.e implements ic.d {
    public static final boolean e;
    public android.content.Context c;
    public final java.util.ArrayList d;

    static c()
    {
        int v0_1;
        if (android.os.Build$VERSION.SDK_INT >= 29) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        ic.c.e = v0_1;
        return;
    }

    public c()
    {
        try {
            Object v3_7 = Class.forName("com.android.org.conscrypt".concat(".OpenSSLSocketImpl"));
            Class.forName("com.android.org.conscrypt".concat(".OpenSSLSocketFactoryImpl"));
            Class.forName("com.android.org.conscrypt".concat(".SSLParametersImpl"));
            java.util.ArrayList v0_3 = new jc.o(v3_7);
        } catch (java.util.ArrayList v0_4) {
            jc.c.a(yb.y.getName(), 5, "unable to load android socket classes", v0_4);
            v0_3 = 0;
        }
        java.util.ArrayList v1_4 = new jc.m(jc.e.e);
        int v2_5 = new jc.m(jc.k.a);
        Object v3_3 = new jc.m(jc.h.a);
        boolean v4_2 = new jc.n[4];
        int v5 = 0;
        v4_2[0] = v0_3;
        v4_2[1] = v1_4;
        v4_2[2] = v2_5;
        v4_2[3] = v3_3;
        java.util.ArrayList v0_8 = ha.i.O(v4_2);
        java.util.ArrayList v1_6 = new java.util.ArrayList();
        int v2_6 = v0_8.size();
        while (v5 < v2_6) {
            Object v3_5 = v0_8.get(v5);
            v5++;
            if (((jc.n) v3_5).a()) {
                v1_6.add(v3_5);
            }
        }
        this.d = v1_6;
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

    public final com.bumptech.glide.j c(javax.net.ssl.X509TrustManager p5)
    {
        p5.getClass();
        mc.a v0_0 = 0;
        try {
            int v1_5 = new android.net.http.X509TrustManagerExtensions(p5);
        } catch (IllegalArgumentException) {
            v1_5 = 0;
        }
        if (v1_5 != 0) {
            v0_0 = new jc.b(p5, v1_5);
        }
        if (v0_0 == null) {
            p5.getClass();
            try {
                android.os.StrictMode.noteSlowCall("buildTrustRootIndex");
                int v1_3 = p5.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[] {java.security.cert.X509Certificate}));
                v1_3.setAccessible(1);
                mc.b v2_3 = new ic.b(p5, v1_3);
            } catch (NoSuchMethodException) {
                java.security.cert.X509Certificate[] v5_1 = p5.getAcceptedIssuers();
                v2_3 = new mc.b(((java.security.cert.X509Certificate[]) java.util.Arrays.copyOf(v5_1, v5_1.length)));
            }
            return new mc.a(v2_3);
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

    public final void e(java.net.Socket p1, java.net.InetSocketAddress p2, int p3)
    {
        p2.getClass();
        try {
            p1.connect(p2, p3);
            return;
        } catch (ClassCastException v1_1) {
            if (android.os.Build$VERSION.SDK_INT != 26) {
                throw v1_1;
            } else {
                throw new java.io.IOException("Exception in connect", v1_1);
            }
        }
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

    public final boolean h(String p2)
    {
        p2.getClass();
        return android.security.NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(p2);
    }

    public final void i(int p3, String p4, Throwable p5)
    {
        if (p3 != 5) {
            android.util.Log.i("OkHttp", p4, p5);
            return;
        } else {
            android.util.Log.w("OkHttp", p4, p5);
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
