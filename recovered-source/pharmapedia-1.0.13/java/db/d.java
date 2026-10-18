// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package db;
public abstract class d {
    public static final int[] a;
    public static final long[] b;

    static d()
    {
        long[] v1_0 = new int[256];
        int v2 = 0;
        char v3_5 = 0;
        while (v3_5 < 256) {
            v1_0[v3_5] = ("0123456789abcdef".charAt((v3_5 & 15)) | ("0123456789abcdef".charAt((v3_5 >> 4)) << 8));
            v3_5++;
        }
        db.d.a = v1_0;
        long[] v1_3 = new int[256];
        char v3_8 = 0;
        while (v3_8 < 256) {
            v1_3[v3_8] = ("0123456789ABCDEF".charAt((v3_8 & 15)) | ("0123456789ABCDEF".charAt((v3_8 >> 4)) << 8));
            v3_8++;
        }
        long[] v1_1 = new int[256];
        char v3_0 = 0;
        while (v3_0 < 256) {
            v1_1[v3_0] = -1;
            v3_0++;
        }
        char v3_1 = 0;
        long v6_0 = 0;
        while (v3_1 < "0123456789abcdef".length()) {
            long v8_2 = (v6_0 + 1);
            v1_1["0123456789abcdef".charAt(v3_1)] = v6_0;
            v3_1++;
            v6_0 = v8_2;
        }
        char v3_2 = 0;
        long v6_1 = 0;
        while (v3_2 < "0123456789ABCDEF".length()) {
            long v8_1 = (v6_1 + 1);
            v1_1["0123456789ABCDEF".charAt(v3_2)] = v6_1;
            v3_2++;
            v6_1 = v8_1;
        }
        long[] v1_2 = new long[256];
        char v3_3 = 0;
        while (v3_3 < 256) {
            v1_2[v3_3] = -1;
            v3_3++;
        }
        int v0_1 = 0;
        char v3_4 = 0;
        while (v0_1 < "0123456789abcdef".length()) {
            int v7_2 = (v3_4 + 1);
            v1_2["0123456789abcdef".charAt(v0_1)] = ((long) v3_4);
            v0_1++;
            v3_4 = v7_2;
        }
        int v0_2 = 0;
        while (v2 < "0123456789ABCDEF".length()) {
            int v4_1 = (v0_2 + 1);
            v1_2["0123456789ABCDEF".charAt(v2)] = ((long) v0_2);
            v2++;
            v0_2 = v4_1;
        }
        db.d.b = v1_2;
        return;
    }
}
