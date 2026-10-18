// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package mc;
public final class a extends com.bumptech.glide.j {
    public final mc.d a;

    public a(mc.d p1)
    {
        p1.getClass();
        this.a = p1;
        return;
    }

    public static boolean V(java.security.cert.X509Certificate p2, java.security.cert.X509Certificate p3, int p4)
    {
        try {
            if ((kotlin.jvm.internal.f.a(p2.getIssuerDN(), p3.getSubjectDN())) && (p3.getBasicConstraints() >= p4)) {
                p2.verify(p3.getPublicKey());
                return 1;
            } else {
                return 0;
            }
        } catch (java.security.GeneralSecurityException) {
            return 0;
        }
    }

    public final java.util.List E(String p8, java.util.List p9)
    {
        p9.getClass();
        p8.getClass();
        javax.net.ssl.SSLPeerUnverifiedException v8_4 = new java.util.ArrayDeque(p9);
        String v9_6 = new java.util.ArrayList();
        int v0_4 = v8_4.removeFirst();
        v0_4.getClass();
        v9_6.add(v0_4);
        int v0_0 = 0;
        int v1_0 = 0;
        while (v0_0 < 9) {
            java.security.cert.X509Certificate v2_3 = v9_6.get((v9_6.size() - 1));
            v2_3.getClass();
            java.security.cert.X509Certificate v2_4 = ((java.security.cert.X509Certificate) v2_3);
            java.util.Iterator v4_1 = this.a.a(v2_4);
            if (v4_1 == null) {
                java.util.Iterator v4_2 = v8_4.iterator();
                v4_2.getClass();
                while (v4_2.hasNext()) {
                    java.security.cert.X509Certificate v5_1 = v4_2.next();
                    v5_1.getClass();
                    java.security.cert.X509Certificate v5_2 = ((java.security.cert.X509Certificate) v5_1);
                    if (mc.a.V(v2_4, v5_2, (v9_6.size() - 1))) {
                        v4_2.remove();
                        v9_6.add(v5_2);
                        v0_0++;
                    }
                }
                if (v1_0 == 0) {
                    String v9_4 = new StringBuilder("Failed to find a trusted cert that signed ");
                    v9_4.append(v2_4);
                    throw new javax.net.ssl.SSLPeerUnverifiedException(v9_4.toString());
                }
            } else {
                if ((v9_6.size() > 1) || (!v2_4.equals(v4_1))) {
                    v9_6.add(v4_1);
                }
                if (!mc.a.V(v4_1, v4_1, (v9_6.size() - 2))) {
                    v1_0 = 1;
                }
            }
            return v9_6;
        }
        int v0_2 = new StringBuilder("Certificate chain too long: ");
        v0_2.append(v9_6);
        throw new javax.net.ssl.SSLPeerUnverifiedException(v0_2.toString());
    }

    public final boolean equals(Object p3)
    {
        if (p3 != this) {
            if ((!(p3 instanceof mc.a)) || (!kotlin.jvm.internal.f.a(((mc.a) p3).a, this.a))) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        return this.a.hashCode();
    }
}
