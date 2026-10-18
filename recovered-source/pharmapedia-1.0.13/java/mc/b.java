// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package mc;
public final class b implements mc.d {
    public final java.util.LinkedHashMap a;

    public varargs b(java.security.cert.X509Certificate[] p7)
    {
        java.util.LinkedHashMap v0_1 = new java.util.LinkedHashMap();
        int v1 = p7.length;
        int v2 = 0;
        while (v2 < v1) {
            java.security.cert.X509Certificate v3 = p7[v2];
            javax.security.auth.x500.X500Principal v4 = v3.getSubjectX500Principal();
            java.util.Set v5_0 = v0_1.get(v4);
            if (v5_0 == null) {
                v5_0 = new java.util.LinkedHashSet();
                v0_1.put(v4, v5_0);
            }
            ((java.util.Set) v5_0).add(v3);
            v2++;
        }
        this.a = v0_1;
        return;
    }

    public final java.security.cert.X509Certificate a(java.security.cert.X509Certificate p5)
    {
        java.util.Iterator v0_2 = ((java.util.Set) this.a.get(p5.getIssuerX500Principal()));
        Object v1_1 = 0;
        if (v0_2 != null) {
            java.util.Iterator v0_3 = v0_2.iterator();
            while (v0_3.hasNext()) {
                Object v2_1 = v0_3.next();
                p5.verify(((java.security.cert.X509Certificate) v2_1).getPublicKey());
                v1_1 = v2_1;
                break;
            }
            return ((java.security.cert.X509Certificate) v1_1);
        } else {
            return 0;
        }
    }

    public final boolean equals(Object p2)
    {
        if ((p2 != this) && ((!(p2 instanceof mc.b)) || (!kotlin.jvm.internal.f.a(((mc.b) p2).a, this.a)))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        return this.a.hashCode();
    }
}
