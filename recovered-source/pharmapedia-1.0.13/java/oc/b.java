// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public abstract class b {
    public static final oc.g a;

    static b()
    {
        oc.b.a = new oc.g();
        return;
    }

    public static final boolean a(byte[] p4, int p5, byte[] p6, int p7, int p8)
    {
        p4.getClass();
        p6.getClass();
        int v1 = 0;
        while (v1 < p8) {
            if (p4[(v1 + p5)] == p6[(v1 + p7)]) {
                v1++;
            } else {
                return 0;
            }
        }
        return 1;
    }

    public static void b(long p20, oc.i p22, int p23, java.util.ArrayList p24, int p25, int p26, java.util.ArrayList p27)
    {
        int v1_0 = p23;
        java.util.ArrayList v5_1 = p24;
        int v8_2 = p27;
        if (p25 >= p26) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Failed requirement.");
            return;
        } else {
            byte v4_0 = p25;
            while (v4_0 < p26) {
                if (((okio.ByteString) p24.get(v4_0)).e() < p23) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Failed requirement.");
                    return;
                } else {
                    v4_0++;
                }
            }
            java.util.ArrayList v6_4;
            long v2_16;
            int v3_3 = ((okio.ByteString) p24.get(p25));
            byte v4_6 = ((okio.ByteString) p24.get((p26 - 1)));
            if (p23 != v3_3.e()) {
                v6_4 = p25;
                v2_16 = -1;
            } else {
                long v2_17 = (p25 + 1);
                v6_4 = v2_17;
                v2_16 = ((Number) p27.get(p25)).intValue();
                v3_3 = ((okio.ByteString) p24.get(v2_17));
            }
            if (v3_3.j(p23) == v4_6.j(p23)) {
                java.util.ArrayList v7_7 = Math.min(v3_3.e(), v4_6.e());
                int v8_0 = 0;
                int v11_0 = p23;
                while ((v11_0 < v7_7) && (v3_3.j(v11_0) == v4_6.j(v11_0))) {
                    v8_0++;
                    v11_0++;
                }
                long v14_11 = (((((p22.h / ((long) 4)) + p20) + ((long) 2)) + ((long) v8_0)) + 1);
                p22.r0((- v8_0));
                p22.r0(v2_16);
                byte v4_12 = (p23 + v8_0);
                while (v1_0 < v4_12) {
                    p22.r0((v3_3.j(v1_0) & 255));
                    v1_0++;
                }
                if ((v6_4 + 1) != p26) {
                    int v3_17 = new oc.i();
                    p22.r0((((int) ((v3_17.h / ((long) 4)) + v14_11)) * -1));
                    oc.b.b(v14_11, v3_17, v4_12, p24, v6_4, p26, p27);
                    p22.n0(v3_17);
                    return;
                } else {
                    if (v4_12 != ((okio.ByteString) p24.get(v6_4)).e()) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Check failed.");
                        return;
                    } else {
                        p22.r0(((Number) p27.get(v6_4)).intValue());
                        return;
                    }
                }
            } else {
                int v3_0 = (v6_4 + 1);
                byte v4_1 = 1;
                while (v3_0 < p26) {
                    if (((okio.ByteString) p24.get((v3_0 - 1))).j(p23) != ((okio.ByteString) p24.get(v3_0)).j(p23)) {
                        v4_1++;
                    }
                    v3_0++;
                }
                long v14_4 = ((((p22.h / ((long) 4)) + p20) + ((long) 2)) + ((long) (v4_1 * 2)));
                p22.r0(v4_1);
                p22.r0(v2_16);
                long v2_2 = v6_4;
                while (v2_2 < p26) {
                    int v3_10 = ((okio.ByteString) p24.get(v2_2)).j(p23);
                    if ((v2_2 == v6_4) || (v3_10 != ((okio.ByteString) p24.get((v2_2 - 1))).j(p23))) {
                        p22.r0((v3_10 & 255));
                    }
                    v2_2++;
                }
                byte v4_3 = new oc.i();
                java.util.ArrayList v7_0 = v6_4;
                while (v7_0 < p26) {
                    long v2_5 = ((okio.ByteString) v5_1.get(v7_0)).j(p23);
                    int v3_4 = (v7_0 + 1);
                    java.util.ArrayList v6_0 = v3_4;
                    while (v6_0 < p26) {
                        if (v2_5 == ((okio.ByteString) v5_1.get(v6_0)).j(p23)) {
                            v6_0++;
                        }
                        if ((v3_4 != v6_0) || ((p23 + 1) != ((okio.ByteString) v5_1.get(v7_0)).e())) {
                            p22.r0((((int) ((v4_3.h / ((long) 4)) + v14_4)) * -1));
                            int v9_3 = v8_2;
                            long v2_12 = v14_4;
                            int v8_1 = v6_0;
                            oc.b.b(v2_12, v4_3, (p23 + 1), p24, v7_0, v8_1, v9_3);
                            v5_1 = p24;
                        } else {
                            p22.r0(((Number) v8_2.get(v7_0)).intValue());
                            v9_3 = v8_2;
                            v2_12 = v14_4;
                            v8_1 = v6_0;
                        }
                        v14_4 = v2_12;
                        v7_0 = v8_1;
                        v8_2 = v9_3;
                    }
                    v6_0 = p26;
                }
                p22.n0(v4_3);
                return;
            }
        }
    }

    public static final void c(long p4, long p6, long p8)
    {
        if (((p6 | p8) < 0) || ((p6 > p4) || ((p4 - p6) < p8))) {
            StringBuilder v1_1 = new StringBuilder("size=");
            v1_1.append(p4);
            v1_1.append(" offset=");
            v1_1.append(p6);
            v1_1.append(" byteCount=");
            v1_1.append(p8);
            throw new ArrayIndexOutOfBoundsException(v1_1.toString());
        } else {
            return;
        }
    }

    public static final int d(int p2)
    {
        return (((p2 & 255) << 24) | ((((-16777216 & p2) >> 24) | ((16711680 & p2) >> 8)) | ((65280 & p2) << 8)));
    }

    public static final long e(long p8)
    {
        return (((p8 & 255) << 56) | ((((((((-72057594037927936 & p8) >> 56) | ((71776119061217280 & p8) >> 40)) | ((280375465082880 & p8) >> 24)) | ((1095216660480 & p8) >> 8)) | ((4278190080 & p8) << 8)) | ((16711680 & p8) << 24)) | ((65280 & p8) << 40)));
    }

    public static long f(String p12)
    {
        IllegalArgumentException v0_0 = p12.length();
        p12.getClass();
        if (v0_0 < null) {
            oc.l.d(r1.a.l("endIndex < beginIndex: ", " < ", v0_0, 0));
            return 0;
        } else {
            if (v0_0 > p12.length()) {
                IllegalArgumentException v0_2 = r1.a.v(v0_0, "endIndex > string.length: ", " > ");
                v0_2.append(p12.length());
                throw new IllegalArgumentException(v0_2.toString().toString());
            } else {
                long v2_2 = 0;
                int v4 = 0;
                while (v4 < v0_0) {
                    long v5_0 = p12.charAt(v4);
                    if (v5_0 >= 128) {
                        long v5_4;
                        if (v5_0 >= 2048) {
                            if ((v5_0 >= 55296) && (v5_0 <= 57343)) {
                                String v10;
                                int v9 = (v4 + 1);
                                if (v9 >= v0_0) {
                                    v10 = 0;
                                } else {
                                    v10 = p12.charAt(v9);
                                }
                                if ((v5_0 <= 56319) && ((v10 >= 56320) && (v10 <= 57343))) {
                                    v2_2 += ((long) 4);
                                    v4 += 2;
                                } else {
                                    v2_2++;
                                    v4 = v9;
                                }
                            } else {
                                v5_4 = 3;
                            }
                        } else {
                            v5_4 = 2;
                        }
                        v2_2 += ((long) v5_4);
                    } else {
                        v2_2++;
                    }
                    v4++;
                }
                return v2_2;
            }
        }
    }

    public static final oc.d g(java.io.InputStream p2)
    {
        p2.getClass();
        return new oc.d(p2, new oc.f0());
    }

    public static final String h(byte p3)
    {
        char[] v1_0 = pc.b.a;
        String v3_4 = v1_0[(p3 & 15)];
        char[] v1_2 = new char[2];
        v1_2[0] = v1_0[((p3 >> 4) & 15)];
        v1_2[1] = v3_4;
        return new String(v1_2);
    }

    public static final String i(int p10)
    {
        if (p10 != null) {
            int v1_1 = pc.b.a;
            char v2_2 = v1_1[((p10 >> 24) & 15)];
            char v3_0 = v1_1[((p10 >> 20) & 15)];
            char v4_2 = v1_1[((p10 >> 16) & 15)];
            char v5_2 = v1_1[((p10 >> 12) & 15)];
            char v6_2 = v1_1[((p10 >> 8) & 15)];
            char v7_2 = v1_1[((p10 >> 4) & 15)];
            String v10_2 = v1_1[(p10 & 15)];
            char[] v8 = new char[8];
            int v9 = 0;
            v8[0] = v1_1[((p10 >> 28) & 15)];
            v8[1] = v2_2;
            v8[2] = v3_0;
            v8[3] = v4_2;
            v8[4] = v5_2;
            v8[5] = v6_2;
            v8[6] = v7_2;
            v8[7] = v10_2;
            while ((v9 < 8) && (v8[v9] == 48)) {
                v9++;
            }
            a.a.b(v9, 8, 8);
            return new String(v8, v9, (8 - v9));
        } else {
            return "0";
        }
    }
}
