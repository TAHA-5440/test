// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package okhttp3;
public final enum class TlsVersion extends java.lang.Enum {
    public static final yb.b h;
    public static final enum okhttp3.TlsVersion i;
    public static final enum okhttp3.TlsVersion j;
    public static final enum okhttp3.TlsVersion k;
    public static final enum okhttp3.TlsVersion l;
    public static final enum okhttp3.TlsVersion m;
    public static final synthetic okhttp3.TlsVersion[] n;
    public final String g;

    static TlsVersion()
    {
        yb.b v0_4 = new okhttp3.TlsVersion("TLS_1_3", 0, "TLSv1.3");
        okhttp3.TlsVersion.i = v0_4;
        okhttp3.TlsVersion v1_1 = new okhttp3.TlsVersion("TLS_1_2", 1, "TLSv1.2");
        okhttp3.TlsVersion.j = v1_1;
        okhttp3.TlsVersion v2_1 = new okhttp3.TlsVersion("TLS_1_1", 2, "TLSv1.1");
        okhttp3.TlsVersion.k = v2_1;
        okhttp3.TlsVersion v3_2 = new okhttp3.TlsVersion("TLS_1_0", 3, "TLSv1");
        okhttp3.TlsVersion.l = v3_2;
        okhttp3.TlsVersion v4_3 = new okhttp3.TlsVersion("SSL_3_0", 4, "SSLv3");
        okhttp3.TlsVersion.m = v4_3;
        yb.b v0_1 = new okhttp3.TlsVersion[] {v0_4, v1_1, v2_1, v3_2, v4_3});
        okhttp3.TlsVersion.n = v0_1;
        kotlin.enums.a.a(v0_1);
        okhttp3.TlsVersion.h = new yb.b();
        return;
    }

    public TlsVersion(String p1, int p2, String p3)
    {
        super(p1, p2);
        super.g = p3;
        return;
    }

    public static okhttp3.TlsVersion valueOf(String p1)
    {
        return ((okhttp3.TlsVersion) Enum.valueOf(okhttp3.TlsVersion, p1));
    }

    public static okhttp3.TlsVersion[] values()
    {
        return ((okhttp3.TlsVersion[]) okhttp3.TlsVersion.n.clone());
    }
}
