// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package wb;
public abstract class k {
    public static final String[] a;
    public static final byte[] b;

    static k()
    {
        int v1_0 = new String[93];
        int v2 = 0;
        String v3_5 = 0;
        while (v3_5 < 32) {
            String v4_2 = wb.k.b((v3_5 >> 12));
            int v5_1 = wb.k.b((v3_5 >> 8));
            int v6_2 = wb.k.b((v3_5 >> 4));
            int v7_1 = wb.k.b(v3_5);
            int v8_2 = new StringBuilder("\\u");
            v8_2.append(v4_2);
            v8_2.append(v5_1);
            v8_2.append(v6_2);
            v8_2.append(v7_1);
            v1_0[v3_5] = v8_2.toString();
            v3_5++;
        }
        v1_0[34] = "\\\"";
        v1_0[92] = "\\\\";
        v1_0[9] = "\\t";
        v1_0[8] = "\\b";
        v1_0[10] = "\\n";
        v1_0[13] = "\\r";
        v1_0[12] = "\\f";
        wb.k.a = v1_0;
        byte[] v0_1 = new byte[93];
        while (v2 < 32) {
            v0_1[v2] = 1;
            v2++;
        }
        v0_1[34] = 34;
        v0_1[92] = 92;
        v0_1[9] = 116;
        v0_1[8] = 98;
        v0_1[10] = 110;
        v0_1[13] = 114;
        v0_1[12] = 102;
        wb.k.b = v0_1;
        return;
    }

    public static final void a(String p7, StringBuilder p8)
    {
        p7.getClass();
        p8.append(34);
        int v1_1 = p7.length();
        int v2 = 0;
        int v3_1 = 0;
        while (v2 < v1_1) {
            char v4 = p7.charAt(v2);
            String[] v5 = wb.k.a;
            if ((v4 < v5.length) && (v5[v4] != null)) {
                p8.append(p7, v3_1, v2);
                p8.append(v5[v4]);
                v3_1 = (v2 + 1);
            }
            v2++;
        }
        if (v3_1 == 0) {
            p8.append(p7);
        } else {
            p8.append(p7, v3_1, p7.length());
        }
        p8.append(34);
        return;
    }

    public static final char b(int p1)
    {
        char v1_2;
        char v1_1 = (p1 & 15);
        if (v1_1 >= 10) {
            v1_2 = (v1_1 + 87);
        } else {
            v1_2 = (v1_1 + 48);
        }
        return ((char) v1_2);
    }
}
