// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jc;
public final class h implements jc.n {
    public static final jc.f a;
    public static final boolean b;

    static h()
    {
        jc.h.a = new jc.f();
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", 0, jc.g.getClassLoader());
        } catch (ClassNotFoundException) {
        }
        jc.h.b = 1;
        return;
    }

    public final boolean a()
    {
        return jc.h.b;
    }

    public final boolean b(javax.net.ssl.SSLSocket p1)
    {
        return 0;
    }

    public final String c(javax.net.ssl.SSLSocket p2)
    {
        int v2_2 = ((org.bouncycastle.jsse.BCSSLSocket) p2).getApplicationProtocol();
        if ((v2_2 != 0) && (!v2_2.equals(""))) {
            return v2_2;
        } else {
            return 0;
        }
    }

    public final void d(javax.net.ssl.SSLSocket p2, String p3, java.util.List p4)
    {
        p4.getClass();
        if (this.b(p2)) {
            org.bouncycastle.jsse.BCSSLParameters v3_1 = ((org.bouncycastle.jsse.BCSSLSocket) p2).getParameters();
            String[] v0_1 = new String[0];
            v3_1.setApplicationProtocols(((String[]) n5.f.f(p4).toArray(v0_1)));
            ((org.bouncycastle.jsse.BCSSLSocket) p2).setParameters(v3_1);
        }
        return;
    }
}
