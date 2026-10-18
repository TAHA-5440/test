// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package wb;
public final class c {
    public static final char[] a;
    public static final byte[] b;

    static c()
    {
        int v0_1 = new char[117];
        wb.c.a = v0_1;
        int v0_5 = new byte[126];
        wb.c.b = v0_5;
        int v0_13 = 0;
        int v1_7 = 0;
        while (v1_7 < 32) {
            v1_7++;
        }
        wb.c.a(98, 8);
        wb.c.a(116, 9);
        wb.c.a(110, 10);
        wb.c.a(102, 12);
        wb.c.a(114, 13);
        wb.c.a(47, 47);
        wb.c.a(34, 34);
        wb.c.a(92, 92);
        byte[] v8 = wb.c.b;
        while (v0_13 < 33) {
            v8[v0_13] = 127;
            v0_13++;
        }
        v8[9] = 3;
        v8[10] = 3;
        v8[13] = 3;
        v8[32] = 3;
        v8[44] = 4;
        v8[58] = 5;
        v8[123] = 6;
        v8[125] = 7;
        v8[91] = 8;
        v8[93] = 9;
        v8[34] = 1;
        v8[92] = 2;
        return;
    }

    public static void a(char p1, int p2)
    {
        if (p1 != 117) {
            wb.c.a[p1] = ((char) p2);
        }
        return;
    }
}
