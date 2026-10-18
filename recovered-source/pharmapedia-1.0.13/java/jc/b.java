// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jc;
public final class b extends com.bumptech.glide.j {
    public final javax.net.ssl.X509TrustManager a;
    public final android.net.http.X509TrustManagerExtensions b;

    public b(javax.net.ssl.X509TrustManager p1, android.net.http.X509TrustManagerExtensions p2)
    {
        p1.getClass();
        this.a = p1;
        this.b = p2;
        return;
    }

    public final java.util.List E(String p3, java.util.List p4)
    {
        p4.getClass();
        p3.getClass();
        String v0_2 = new java.security.cert.X509Certificate[0];
        try {
            java.security.cert.CertificateException v3_1 = this.b.checkServerTrusted(((java.security.cert.X509Certificate[]) p4.toArray(v0_2)), "RSA", p3);
            v3_1.getClass();
            return v3_1;
        } catch (java.security.cert.CertificateException v3_2) {
            javax.net.ssl.SSLPeerUnverifiedException v4_2 = new javax.net.ssl.SSLPeerUnverifiedException(v3_2.getMessage());
            v4_2.initCause(v3_2);
            throw v4_2;
        }
    }

    public final boolean equals(Object p2)
    {
        if ((!(p2 instanceof jc.b)) || (((jc.b) p2).a != this.a)) {
            return 0;
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        return System.identityHashCode(this.a);
    }
}
