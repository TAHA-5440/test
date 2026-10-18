// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jc;
public final class k implements jc.n {
    public static final jc.i a;
    public static final boolean b;

    static k()
    {
        jc.k.a = new jc.i();
        int v0_2 = 0;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", 0, jc.j.getClassLoader());
        } catch (ClassNotFoundException) {
            jc.k.b = v0_2;
            return;
        }
        if ((!org.conscrypt.Conscrypt.isAvailable()) || (!jc.j.a())) {
            jc.k.b = v0_2;
            return;
        } else {
            v0_2 = 1;
            jc.k.b = v0_2;
            return;
        }
    }

    public final boolean a()
    {
        return jc.k.b;
    }

    public final boolean b(javax.net.ssl.SSLSocket p1)
    {
        return org.conscrypt.Conscrypt.isConscrypt(p1);
    }

    public final String c(javax.net.ssl.SSLSocket p2)
    {
        if (!this.b(p2)) {
            return 0;
        } else {
            return org.conscrypt.Conscrypt.getApplicationProtocol(p2);
        }
    }

    public final void d(javax.net.ssl.SSLSocket p1, String p2, java.util.List p3)
    {
        p3.getClass();
        if (this.b(p1)) {
            org.conscrypt.Conscrypt.setUseSessionTickets(p1, 1);
            String[] v3_1 = new String[0];
            org.conscrypt.Conscrypt.setApplicationProtocols(p1, ((String[]) n5.f.f(p3).toArray(v3_1)));
        }
        return;
    }
}
