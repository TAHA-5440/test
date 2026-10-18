// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package dc;
public abstract class c {
    public static final a8.d a;
    public static final String[] b;
    public static final java.text.DateFormat[] c;

    static c()
    {
        dc.c.a = new a8.d(1);
        String v4 = "EEE MMM d HH:mm:ss yyyy";
        String v6 = "EEE, dd-MMM-yyyy HH-mm-ss z";
        String v8 = "EEE dd-MMM-yyyy HH:mm:ss z";
        String v10 = "EEE dd-MMM-yyyy HH-mm-ss z";
        String v12 = "EEE dd MMM yy HH:mm:ss z";
        String v14 = "EEE,dd-MMM-yyyy HH:mm:ss z";
        java.text.DateFormat[] v0_2 = new String[] {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE MMM d yyyy HH:mm:ss z"});
        dc.c.b = v0_2;
        java.text.DateFormat[] v0_4 = new java.text.DateFormat[v0_2.length];
        dc.c.c = v0_4;
        return;
    }

    public static final java.util.Date a(String p10)
    {
        if (p10.length() != 0) {
            java.text.ParsePosition v0_2 = new java.text.ParsePosition(0);
            String[] v3_1 = ((java.text.DateFormat) dc.c.a.get()).parse(p10, v0_2);
            if (v0_2.getIndex() != p10.length()) {
                int v5_1 = 0;
                while (v5_1 < dc.c.b.length) {
                    java.util.Date v6_0 = dc.c.c;
                    int v7_0 = v6_0[v5_1];
                    if (v7_0 == 0) {
                        v7_0 = new java.text.SimpleDateFormat(dc.c.b[v5_1], java.util.Locale.US);
                        v7_0.setTimeZone(zb.e.a);
                        v6_0[v5_1] = v7_0;
                    }
                    v0_2.setIndex(0);
                    java.util.Date v6_1 = v7_0.parse(p10, v0_2);
                    if (v0_2.getIndex() == 0) {
                        v5_1++;
                    } else {
                        return v6_1;
                    }
                }
                return 0;
            } else {
                return v3_1;
            }
        } else {
            return 0;
        }
    }
}
