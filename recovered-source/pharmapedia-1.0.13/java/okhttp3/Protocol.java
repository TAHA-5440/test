// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package okhttp3;
public final enum class Protocol extends java.lang.Enum {
    public static final yb.b h;
    public static final enum okhttp3.Protocol i;
    public static final enum okhttp3.Protocol j;
    public static final enum okhttp3.Protocol k;
    public static final enum okhttp3.Protocol l;
    public static final enum okhttp3.Protocol m;
    public static final enum okhttp3.Protocol n;
    public static final enum okhttp3.Protocol o;
    public static final synthetic okhttp3.Protocol[] p;
    public final String g;

    static Protocol()
    {
        yb.b v0_1 = new okhttp3.Protocol("HTTP_1_0", 0, "http/1.0");
        okhttp3.Protocol.i = v0_1;
        okhttp3.Protocol.j = new okhttp3.Protocol("HTTP_1_1", 1, "http/1.1");
        okhttp3.Protocol.k = new okhttp3.Protocol("SPDY_3", 2, "spdy/3.1");
        okhttp3.Protocol.l = new okhttp3.Protocol("HTTP_2", 3, "h2");
        okhttp3.Protocol.m = new okhttp3.Protocol("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
        okhttp3.Protocol.n = new okhttp3.Protocol("QUIC", 5, "quic");
        okhttp3.Protocol v6_4 = new okhttp3.Protocol("HTTP_3", 6, "h3");
        okhttp3.Protocol.o = v6_4;
        yb.b v0_2 = new okhttp3.Protocol[] {v0_1, v6_4});
        okhttp3.Protocol.p = v0_2;
        kotlin.enums.a.a(v0_2);
        okhttp3.Protocol.h = new yb.b();
        return;
    }

    public Protocol(String p1, int p2, String p3)
    {
        super(p1, p2);
        super.g = p3;
        return;
    }

    public static okhttp3.Protocol valueOf(String p1)
    {
        return ((okhttp3.Protocol) Enum.valueOf(okhttp3.Protocol, p1));
    }

    public static okhttp3.Protocol[] values()
    {
        return ((okhttp3.Protocol[]) okhttp3.Protocol.p.clone());
    }

    public final String toString()
    {
        return this.g;
    }
}
