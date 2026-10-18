// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class r {
    public final okhttp3.TlsVersion a;
    public final yb.m b;
    public final java.util.List c;
    public final ga.e d;

    public r(okhttp3.TlsVersion p1, yb.m p2, java.util.List p3, ua.a p4)
    {
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = kotlin.a.b(new androidx.activity.e(p4, 13));
        return;
    }

    public final java.util.List a()
    {
        return ((java.util.List) this.d.getValue());
    }

    public final boolean equals(Object p3)
    {
        if ((!(p3 instanceof yb.r)) || ((((yb.r) p3).a != this.a) || ((!((yb.r) p3).b.equals(this.b)) || ((!kotlin.jvm.internal.f.a(((yb.r) p3).a(), this.a())) || (!((yb.r) p3).c.equals(this.c)))))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        return (this.c.hashCode() + ((this.a().hashCode() + ((this.b.hashCode() + ((this.a.hashCode() + 527) * 31)) * 31)) * 31));
    }

    public final String toString()
    {
        String v0_0 = this.a();
        StringBuilder v1_3 = new java.util.ArrayList(ha.l.y(v0_0, 10));
        String v0_7 = v0_0.iterator();
        while (v0_7.hasNext()) {
            String v3_16;
            String v3_15 = ((java.security.cert.Certificate) v0_7.next());
            if (!(v3_15 instanceof java.security.cert.X509Certificate)) {
                v3_16 = v3_15.getType();
                v3_16.getClass();
            } else {
                v3_16 = ((java.security.cert.X509Certificate) v3_15).getSubjectDN().toString();
            }
            v1_3.add(v3_16);
        }
        String v0_1 = v1_3.toString();
        StringBuilder v1_1 = new StringBuilder("Handshake{tlsVersion=");
        v1_1.append(this.a);
        v1_1.append(" cipherSuite=");
        v1_1.append(this.b);
        v1_1.append(" peerCertificates=");
        v1_1.append(v0_1);
        v1_1.append(" localCertificates=");
        String v3_6 = this.c;
        String v0_4 = new java.util.ArrayList(ha.l.y(v3_6, 10));
        java.util.Iterator v2_2 = v3_6.iterator();
        while (v2_2.hasNext()) {
            String v3_11;
            String v3_9 = ((java.security.cert.Certificate) v2_2.next());
            if (!(v3_9 instanceof java.security.cert.X509Certificate)) {
                v3_11 = v3_9.getType();
                v3_11.getClass();
            } else {
                v3_11 = ((java.security.cert.X509Certificate) v3_9).getSubjectDN().toString();
            }
            v0_4.add(v3_11);
        }
        v1_1.append(v0_4);
        v1_1.append(125);
        return v1_1.toString();
    }
}
