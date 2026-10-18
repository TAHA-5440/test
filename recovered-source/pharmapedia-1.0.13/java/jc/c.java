// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jc;
public abstract class c {
    public static final java.util.concurrent.CopyOnWriteArraySet a;
    public static final java.util.Map b;

    static c()
    {
        String v2_0;
        jc.c.a = new java.util.concurrent.CopyOnWriteArraySet();
        java.util.Map v0_4 = new java.util.LinkedHashMap();
        String v2_5 = yb.y.getPackage();
        if (v2_5 == null) {
            v2_0 = 0;
        } else {
            v2_0 = v2_5.getName();
        }
        if (v2_0 != null) {
            v0_4.put(v2_0, "OkHttp");
        }
        v0_4.put(yb.y.getName(), "okhttp.OkHttpClient");
        v0_4.put(fc.f.getName(), "okhttp.Http2");
        v0_4.put(bc.d.getName(), "okhttp.TaskRunner");
        v0_4.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        jc.c.b = kotlin.collections.a.N(v0_4);
        return;
    }

    public static void a(String p4, int p5, String p6, Throwable p7)
    {
        String v0_2 = ((String) jc.c.b.get(p4));
        if (v0_2 == null) {
            v0_2 = db.i.m0(23, p4);
        }
        if (android.util.Log.isLoggable(v0_2, p5)) {
            if (p7 != 0) {
                int v1_1 = new StringBuilder();
                v1_1.append(p6);
                v1_1.append(10);
                v1_1.append(android.util.Log.getStackTraceString(p7));
                p6 = v1_1.toString();
            }
            int v7_1 = p6.length();
            int v1_2 = 0;
            while (v1_2 < v7_1) {
                int v2_1 = db.i.X(p6, 10, v1_2, 4);
                if (v2_1 == -1) {
                    v2_1 = v7_1;
                }
                while(true) {
                    int v3_2 = Math.min(v2_1, (v1_2 + 4000));
                    android.util.Log.println(p5, v0_2, p6.substring(v1_2, v3_2));
                    if (v3_2 >= v2_1) {
                        break;
                    }
                    v1_2 = v3_2;
                }
                v1_2 = (v3_2 + 1);
            }
        }
        return;
    }
}
