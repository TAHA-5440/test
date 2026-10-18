// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public abstract class e {
    public static final fc.b[] a;
    public static final java.util.Map b;

    static e()
    {
        java.util.LinkedHashMap v1_58 = new fc.b(fc.b.i, "");
        int v3_2 = fc.b.f;
        new fc.b(v3_2, "GET");
        int v3_0 = new fc.b(v3_2, "POST");
        Integer v5_0 = fc.b.g;
        new fc.b(v5_0, "/");
        new fc.b(v5_0, "/index.html");
        fc.b v7_1 = fc.b.h;
        new fc.b(v7_1, "http");
        new fc.b(v7_1, "https");
        fc.b v9_1 = fc.b.e;
        new fc.b(v9_1, "200");
        new fc.b(v9_1, "204");
        new fc.b(v9_1, "206");
        new fc.b(v9_1, "304");
        new fc.b(v9_1, "400");
        new fc.b(v9_1, "404");
        new fc.b(v9_1, "500");
        fc.b v15 = new fc.b("accept-charset", "");
        fc.b v17 = v1_58;
        fc.b v18 = v3_0;
        java.util.Map v0_62 = new fc.b("accept-encoding", "gzip, deflate");
        new fc.b("accept-language", "");
        fc.b v19 = v0_62;
        new fc.b("accept-ranges", "");
        new fc.b("age", "");
        new fc.b("cache-control", "");
        new fc.b("content-language", "");
        new fc.b("content-range", "");
        new fc.b("date", "");
        new fc.b("expires", "");
        new fc.b("if-match", "");
        new fc.b("if-range", "");
        new fc.b("link", "");
        new fc.b("proxy-authenticate", "");
        new fc.b("referer", "");
        new fc.b("server", "");
        new fc.b("transfer-encoding", "");
        new fc.b("via", "");
        int v3 = v18;
        fc.b v16 = v19;
        v19 = new fc.b("accept", "");
        fc.b v20 = new fc.b("access-control-allow-origin", "");
        fc.b v22 = new fc.b("allow", "");
        fc.b v23 = new fc.b("authorization", "");
        fc.b v25 = new fc.b("content-disposition", "");
        fc.b v26 = new fc.b("content-encoding", "");
        fc.b v28 = new fc.b("content-length", "");
        fc.b v29 = new fc.b("content-location", "");
        fc.b v31 = new fc.b("content-type", "");
        fc.b v32 = new fc.b("cookie", "");
        fc.b v34 = new fc.b("etag", "");
        fc.b v35 = new fc.b("expect", "");
        fc.b v37 = new fc.b("from", "");
        fc.b v38 = new fc.b("host", "");
        fc.b v40 = new fc.b("if-modified-since", "");
        fc.b v41 = new fc.b("if-none-match", "");
        fc.b v43 = new fc.b("if-unmodified-since", "");
        fc.b v44 = new fc.b("last-modified", "");
        fc.b v46 = new fc.b("location", "");
        fc.b v47 = new fc.b("max-forwards", "");
        fc.b v49 = new fc.b("proxy-authorization", "");
        fc.b v50 = new fc.b("range", "");
        fc.b v52 = new fc.b("refresh", "");
        fc.b v53 = new fc.b("retry-after", "");
        fc.b v55 = new fc.b("set-cookie", "");
        fc.b v56 = new fc.b("strict-transport-security", "");
        fc.b v58 = new fc.b("user-agent", "");
        fc.b v59 = new fc.b("vary", "");
        java.util.Map v0_56 = new fc.b[] {v17, new fc.b("www-authenticate", "")});
        fc.e.a = v0_56;
        java.util.LinkedHashMap v1_59 = new java.util.LinkedHashMap(61, 1065353216);
        int v2_2 = 0;
        while (v2_2 < 61) {
            if (!v1_59.containsKey(v0_56[v2_2].a)) {
                v1_59.put(v0_56[v2_2].a, Integer.valueOf(v2_2));
            }
            v2_2++;
        }
        java.util.Map v0_57 = java.util.Collections.unmodifiableMap(v1_59);
        v0_57.getClass();
        fc.e.b = v0_57;
        return;
    }

    public static void a(okio.ByteString p4)
    {
        p4.getClass();
        String v0_1 = p4.e();
        int v1 = 0;
        while (v1 < v0_1) {
            byte v2 = p4.j(v1);
            if ((65 <= v2) && (v2 < 91)) {
                oc.l.g("PROTOCOL_ERROR response malformed: mixed case name: ".concat(p4.t()));
                return;
            } else {
                v1++;
            }
        }
        return;
    }
}
