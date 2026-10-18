// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jc;
public final class a implements jc.n {

    public final boolean a()
    {
        if (android.os.Build$VERSION.SDK_INT < 29) {
            return 0;
        } else {
            return 1;
        }
    }

    public final boolean b(javax.net.ssl.SSLSocket p1)
    {
        return androidx.activity.v.v(p1);
    }

    public final String c(javax.net.ssl.SSLSocket p2)
    {
        try {
            int v2_1 = androidx.activity.v.h(p2);
        } catch (UnsupportedOperationException) {
            return 0;
        }
        if ((v2_1 != 0) && (!v2_1.equals(""))) {
            return v2_1;
        } else {
            return 0;
        }
    }

    public final void d(javax.net.ssl.SSLSocket p2, String p3, java.util.List p4)
    {
        p4.getClass();
        try {
            androidx.activity.v.r(p2);
            java.io.IOException v3_2 = p2.getSSLParameters();
            String[] v0_1 = new String[0];
            androidx.activity.v.q(v3_2, ((String[]) n5.f.f(p4).toArray(v0_1)));
            p2.setSSLParameters(v3_2);
            return;
        } catch (IllegalArgumentException v2_1) {
            throw new java.io.IOException("Android internal error", v2_1);
        }
    }
}
