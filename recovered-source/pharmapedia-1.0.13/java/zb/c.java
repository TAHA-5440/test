// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package zb;
public abstract class c {
    public static final byte[] a;

    static c()
    {
        String v0_0 = 0;
        IllegalArgumentException v1_0 = new byte[0];
        zb.c.a = v1_0;
        IllegalArgumentException v1_6 = new okio.ByteString[] {n5.f.m("efbbbf"), n5.f.m("feff"), n5.f.m("fffe0000"), n5.f.m("fffe"), n5.f.m("0000feff")});
        java.util.ArrayList v6_1 = new java.util.ArrayList(new ha.g(v1_6, 0));
        ha.n.z(v6_1);
        oc.i v2_5 = v6_1.size();
        java.util.ArrayList v9_1 = new java.util.ArrayList(v2_5);
        long v3_4 = 0;
        while (v3_4 < v2_5) {
            v9_1.add(Integer.valueOf(-1));
            v3_4++;
        }
        oc.i v2_2 = 0;
        long v3_3 = 0;
        while (v2_2 < 5) {
            oc.i v4_0 = v1_6[v2_2];
            int v5_1 = (v3_3 + 1);
            Number v7_5 = v6_1.size();
            int v8_3 = v6_1.size();
            if (v7_5 < null) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u(r1.a.h(v7_5, "fromIndex (0) is greater than toIndex (", ")."));
                return;
            } else {
                if (v7_5 > v8_3) {
                    IllegalArgumentException v1_4 = new StringBuilder("toIndex (");
                    v1_4.append(v7_5);
                    v1_4.append(") is greater than size (");
                    v1_4.append(v8_3);
                    v1_4.append(").");
                    throw new IndexOutOfBoundsException(v1_4.toString());
                } else {
                    Number v7_6 = (v7_5 - 1);
                    int v8_4 = 0;
                    while (v8_4 <= v7_6) {
                        int v10_1 = ((v8_4 + v7_6) >> 1);
                        int v11_2 = com.bumptech.glide.d.f(((Comparable) v6_1.get(v10_1)), v4_0);
                        if (v11_2 >= 0) {
                            if (v11_2 > 0) {
                                v7_6 = (v10_1 - 1);
                            }
                        } else {
                            v8_4 = (v10_1 + 1);
                        }
                        v9_1.set(v10_1, Integer.valueOf(v3_3));
                        v2_2++;
                        v3_3 = v5_1;
                    }
                    v10_1 = (- (v8_4 + 1));
                }
            }
        }
        if (((okio.ByteString) v6_1.get(0)).e() <= 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("the empty byte string is not a supported option");
            return;
        } else {
            oc.i v2_9 = 0;
            while (v2_9 < v6_1.size()) {
                long v3_8 = ((okio.ByteString) v6_1.get(v2_9));
                oc.i v4_7 = (v2_9 + 1);
                int v5_0 = v4_7;
                while (v5_0 < v6_1.size()) {
                    Number v7_10 = ((okio.ByteString) v6_1.get(v5_0));
                    v7_10.getClass();
                    v3_8.getClass();
                    if (!v7_10.m(0, v3_8, v3_8.e())) {
                        break;
                    }
                    if (v7_10.e() == v3_8.e()) {
                        String v0_10 = new StringBuilder("duplicate option: ");
                        v0_10.append(v7_10);
                        throw new IllegalArgumentException(v0_10.toString().toString());
                    } else {
                        if (((Number) v9_1.get(v5_0)).intValue() <= ((Number) v9_1.get(v2_9)).intValue()) {
                            v5_0++;
                        } else {
                            v6_1.remove(v5_0);
                            ((Number) v9_1.remove(v5_0)).intValue();
                        }
                    }
                }
                v2_9 = v4_7;
            }
            oc.i v4_6 = new oc.i();
            oc.b.b(0, v4_6, 0, v6_1, 0, v6_1.size(), v9_1);
            oc.i v2_13 = ((int) (v4_6.h / ((long) 4)));
            long v3_6 = new int[v2_13];
            while (v0_0 < v2_13) {
                v3_6[v0_0] = v4_6.readInt();
                v0_0++;
            }
            java.util.Arrays.copyOf(v1_6, 5);
            return;
        }
    }

    public static final void a(java.io.Closeable p0)
    {
        p0.getClass();
        try {
            p0.close();
        } catch (RuntimeException v0_1) {
            throw v0_1;
        } catch (Exception) {
        }
        return;
    }

    public static final void b(oc.o p5, oc.w p6)
    {
        p5.getClass();
        try {
            java.util.Iterator v6_2 = p5.M(p6).iterator();
            String v0 = 0;
        } catch (java.io.FileNotFoundException) {
            return;
        }
        while (v6_2.hasNext()) {
            String v1_1 = ((oc.w) v6_2.next());
            v1_1.getClass();
            java.io.FileNotFoundException v2_0 = p5.Z(v1_1);
            if (v2_0 == null) {
                StringBuilder v3_1 = new StringBuilder("no such file: ");
                v3_1.append(v1_1);
                throw new java.io.FileNotFoundException(v3_1.toString());
            } else {
                if (v2_0.c) {
                    zb.c.b(p5, v1_1);
                }
                p5.B(v1_1);
            }
        }
        if (v0 != null) {
            throw v0;
        } else {
            return;
        }
    }

    public static final void c(ac.j p0, oc.w p1)
    {
        p0.getClass();
        p1.getClass();
        try {
            p0.h.B(p1);
        } catch (java.io.FileNotFoundException) {
        }
        return;
    }

    public static final int d(String p1, char p2, int p3, int p4)
    {
        p1.getClass();
        while (p3 < p4) {
            if (p1.charAt(p3) != p2) {
                p3++;
            } else {
                return p3;
            }
        }
        return p4;
    }

    public static final int e(String p1, String p2, int p3, int p4)
    {
        p1.getClass();
        while (p3 < p4) {
            if (!db.i.U(p2, p1.charAt(p3))) {
                p3++;
            } else {
                return p3;
            }
        }
        return p4;
    }

    public static final boolean f(String[] p7, String[] p8, java.util.Comparator p9)
    {
        p7.getClass();
        if ((p7.length != 0) && ((p8 != null) && (p8.length != 0))) {
            int v2 = 0;
            while (v2 < p7.length) {
                int v5 = 0;
                while (v5 < p8.length) {
                    if (p9.compare(p7[v2], p8[v5]) != 0) {
                        v5++;
                    } else {
                        return 1;
                    }
                }
                v2++;
            }
        }
        return 0;
    }

    public static final int g(String p4)
    {
        int v0 = p4.length();
        int v1 = 0;
        while (v1 < v0) {
            int v2_1 = p4.charAt(v1);
            if ((kotlin.jvm.internal.f.c(v2_1, 31) > 0) && (kotlin.jvm.internal.f.c(v2_1, 127) < 0)) {
                v1++;
            } else {
                return v1;
            }
        }
        return -1;
    }

    public static final int h(int p2, int p3, String p4)
    {
        p4.getClass();
        while (p2 < p3) {
            char v0 = p4.charAt(p2);
            if ((v0 == 9) || ((v0 == 10) || ((v0 == 12) || ((v0 == 13) || (v0 == 32))))) {
                p2++;
            } else {
                return p2;
            }
        }
        return p3;
    }

    public static final int i(int p2, int p3, String p4)
    {
        p4.getClass();
        int v3_1 = (p3 - 1);
        if (p2 <= v3_1) {
            while(true) {
                char v0 = p4.charAt(v3_1);
                if ((v0 != 9) && ((v0 != 10) && ((v0 != 12) && ((v0 != 13) && (v0 != 32))))) {
                    break;
                }
                if (v3_1 != p2) {
                    v3_1--;
                }
            }
            return (v3_1 + 1);
        }
        return p2;
    }

    public static final String[] j(String[] p8, String[] p9, java.util.Comparator p10)
    {
        p8.getClass();
        p9.getClass();
        java.util.ArrayList v0_1 = new java.util.ArrayList();
        int v1 = p8.length;
        int v3 = 0;
        while (v3 < v1) {
            String v4 = p8[v3];
            int v6 = 0;
            while (v6 < p9.length) {
                if (p10.compare(v4, p9[v6]) != 0) {
                    v6++;
                } else {
                    v0_1.add(v4);
                    break;
                }
            }
            v3++;
        }
        String[] v8_3 = new String[0];
        return ((String[]) v0_1.toArray(v8_3));
    }

    public static final boolean k(String p1)
    {
        p1.getClass();
        if ((!p1.equalsIgnoreCase("Authorization")) && ((!p1.equalsIgnoreCase("Cookie")) && ((!p1.equalsIgnoreCase("Proxy-Authorization")) && (!p1.equalsIgnoreCase("Set-Cookie"))))) {
            return 0;
        } else {
            return 1;
        }
    }

    public static final int l(char p2)
    {
        if ((48 > p2) || (p2 >= 58)) {
            if ((97 > p2) || (p2 >= 103)) {
                if ((65 > p2) || (p2 >= 71)) {
                    return -1;
                } else {
                    return (p2 - 55);
                }
            } else {
                return (p2 - 87);
            }
        } else {
            return (p2 - 48);
        }
    }

    public static final int m(oc.k p2)
    {
        p2.getClass();
        return ((p2.readByte() & 255) | (((p2.readByte() & 255) << 16) | ((p2.readByte() & 255) << 8)));
    }

    public static final int n(int p2, String p3)
    {
        try {
            if (p3 != null) {
                p2 = Long.parseLong(p3);
                if (p2 <= 2147483647) {
                    if (p2 >= 0) {
                        p2 = ((int) p2);
                    } else {
                        return 0;
                    }
                } else {
                    return 2147483647;
                }
            }
        } catch (NumberFormatException) {
        }
        return p2;
    }
}
