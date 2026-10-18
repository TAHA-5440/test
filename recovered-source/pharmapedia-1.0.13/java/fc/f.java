// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public abstract class f {
    public static final okio.ByteString a;
    public static final String[] b;
    public static final String[] c;
    public static final String[] d;

    static f()
    {
        fc.f.a = n5.f.o("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        String v3 = "PRIORITY";
        int v5 = "SETTINGS";
        String[] v7 = "PING";
        fc.f.b = new String[] {"DATA", "CONTINUATION"});
        int v0_3 = new String[64];
        fc.f.c = v0_3;
        String[] v1_0 = new String[256];
        int v2 = 0;
        String v3_0 = 0;
        while (v3_0 < 256) {
            int v5_3 = Integer.toBinaryString(v3_0);
            v5_3.getClass();
            String v4_0 = zb.e.d("%8s", new Object[] {v5_3})).replace(32, 48);
            v4_0.getClass();
            v1_0[v3_0] = v4_0;
            v3_0++;
        }
        fc.f.d = v1_0;
        int v0_5 = fc.f.c;
        v0_5[0] = "";
        v0_5[1] = "END_STREAM";
        String[] v1_3 = new int[] {1});
        v0_5[8] = "PADDED";
        String v3_3 = v1_3[0];
        v0_5[(v3_3 | 8)] = r1.a.n(v0_5[v3_3], "|PADDED", new StringBuilder());
        v0_5[4] = "END_HEADERS";
        v0_5[32] = "PRIORITY";
        v0_5[36] = "END_HEADERS|PRIORITY";
        String v3_9 = 0;
        while (v3_9 < 3) {
            String v4_3 = new int[] {4, 32, 36})[v3_9];
            String v6_4 = v1_3[0];
            String[] v7_3 = fc.f.c;
            int v9_0 = (v6_4 | v4_3);
            StringBuilder v10_2 = new StringBuilder();
            v10_2.append(v7_3[v6_4]);
            v10_2.append(124);
            v10_2.append(v7_3[v4_3]);
            v7_3[v9_0] = v10_2.toString();
            int v9_1 = (v9_0 | 8);
            StringBuilder v10_5 = new StringBuilder();
            v10_5.append(v7_3[v6_4]);
            v10_5.append(124);
            v7_3[v9_1] = r1.a.n(v7_3[v4_3], "|PADDED", v10_5);
            v3_9++;
        }
        while (v2 < fc.f.c.length) {
            String[] v1_4 = fc.f.c;
            if (v1_4[v2] == null) {
                v1_4[v2] = fc.f.d[v2];
            }
            v2++;
        }
        return;
    }

    public static String a(int p2)
    {
        String v0_0 = fc.f.b;
        if (p2 >= v0_0.length) {
            return zb.e.d("0x%02x", new Object[] {Integer.valueOf(p2)}));
        } else {
            return v0_0[p2];
        }
    }

    public static String b(boolean p4, int p5, int p6, int p7, int p8)
    {
        String v7_2;
        String v0 = fc.f.a(p7);
        if (p8 != null) {
            int v2_2 = fc.f.d;
            if ((p7 != 2) && (p7 != 3)) {
                if ((p7 == 4) || (p7 == 6)) {
                    if (p8 != 1) {
                        v7_2 = v2_2[p8];
                        String v4_1;
                        if (p4 == null) {
                            v4_1 = ">>";
                        } else {
                            v4_1 = "<<";
                        }
                        return zb.e.d("%s 0x%08x %5d %-13s %s", new Object[] {v4_1, Integer.valueOf(p5), Integer.valueOf(p6), v0, v7_2}));
                    } else {
                        v7_2 = "ACK";
                    }
                } else {
                    if ((p7 != 7) && (p7 != 8)) {
                        String v1_4;
                        String v1_3 = fc.f.c;
                        if (p8 >= v1_3.length) {
                            v1_4 = v2_2[p8];
                        } else {
                            v1_4 = v1_3[p8];
                            v1_4.getClass();
                        }
                        if ((p7 != 5) || ((p8 & 4) == 0)) {
                            if ((p7 != null) || ((p8 & 32) == 0)) {
                                v7_2 = v1_4;
                            } else {
                                v7_2 = db.p.O(v1_4, "PRIORITY", "COMPRESSED");
                            }
                        } else {
                            v7_2 = db.p.O(v1_4, "HEADERS", "PUSH_PROMISE");
                        }
                    }
                }
            }
            v7_2 = v2_2[p8];
        } else {
            v7_2 = "";
        }
    }

    public static String c(boolean p1, int p2, int p3, long p4)
    {
        String v1_3;
        String v0_1 = fc.f.a(8);
        if (p1 == null) {
            v1_3 = ">>";
        } else {
            v1_3 = "<<";
        }
        return zb.e.d("%s 0x%08x %5d %-13s %d", new Object[] {v1_3, Integer.valueOf(p2), Integer.valueOf(p3), v0_1, Long.valueOf(p4)}));
    }
}
