// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ic;
public final class b implements mc.d {
    public final javax.net.ssl.X509TrustManager a;
    public final reflect.Method b;

    public b(javax.net.ssl.X509TrustManager p1, reflect.Method p2)
    {
        p1.getClass();
        this.a = p1;
        this.b = p2;
        return;
    }

    public final java.security.cert.X509Certificate a(java.security.cert.X509Certificate p3)
    {
        try {
            int v3_4 = this.b.invoke(this.a, new Object[] {p3}));
            v3_4.getClass();
            return ((java.security.cert.TrustAnchor) v3_4).getTrustedCert();
        } catch (int v3_2) {
            throw new AssertionError("unable to get issues and signature", v3_2);
        } catch (reflect.InvocationTargetException) {
            return 0;
        }
    }

    public final boolean equals(Object p3)
    {
        if ((this == p3) || (((p3 instanceof ic.b)) && ((kotlin.jvm.internal.f.a(this.a, ((ic.b) p3).a)) && (this.b.equals(((ic.b) p3).b))))) {
            return 1;
        } else {
            return 0;
        }
    }

    public final int hashCode()
    {
        return (this.b.hashCode() + (this.a.hashCode() * 31));
    }

    public final String toString()
    {
        String v0_2 = new StringBuilder("CustomTrustRootIndex(trustManager=");
        v0_2.append(this.a);
        v0_2.append(", findByIssuerAndSignatureMethod=");
        v0_2.append(this.b);
        v0_2.append(41);
        return v0_2.toString();
    }
}
