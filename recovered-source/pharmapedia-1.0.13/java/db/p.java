// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package db;
public abstract class p extends db.o {

    public static boolean K(String p7, String p8, boolean p9)
    {
        p7.getClass();
        p8.getClass();
        if (p9 != 0) {
            return p7.regionMatches(1, (p7.length() - p8.length()), p8, 0, p8.length());
        } else {
            return p7.endsWith(p8);
        }
    }

    public static boolean L(String p0, String p1)
    {
        if (p0 != 0) {
            return p0.equalsIgnoreCase(p1);
        } else {
            if (p1 != null) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static final void M(String p3)
    {
        throw new NumberFormatException(r1.a.k("Invalid number format: \'", p3, 39));
    }

    public static boolean N(int p6, int p7, int p8, String p9, String p10, boolean p11)
    {
        p9.getClass();
        p10.getClass();
        if (p11) {
            return p9.regionMatches(p11, p6, p10, p7, p8);
        } else {
            return p9.regionMatches(p6, p10, p7, p8);
        }
    }

    public static String O(String p7, String p8, String p9)
    {
        p7.getClass();
        int v1_1 = db.i.V(p7, p8, 0, 0);
        if (v1_1 >= 0) {
            int v2 = p8.length();
            int v3 = 1;
            if (v2 >= 1) {
                v3 = v2;
            }
            int v5_1 = (p9.length() + (p7.length() - v2));
            if (v5_1 < 0) {
                throw new OutOfMemoryError();
            } else {
                StringBuilder v4_3 = new StringBuilder(v5_1);
                int v5_2 = 0;
                do {
                    v4_3.append(p7, v5_2, v1_1);
                    v4_3.append(p9);
                    v5_2 = (v1_1 + v2);
                    if (v1_1 >= p7.length()) {
                        break;
                    }
                    v1_1 = db.i.V(p7, p8, (v1_1 + v3), 0);
                } while(v1_1 > 0);
                v4_3.append(p7, v5_2, p7.length());
                return v4_3.toString();
            }
        } else {
            return p7;
        }
    }

    public static boolean P(String p6, String p7, int p8, boolean p9)
    {
        p6.getClass();
        if (p9) {
            return db.p.N(p8, 0, p7.length(), p6, p7, p9);
        } else {
            return p6.startsWith(p7, p8);
        }
    }

    public static boolean Q(String p6, String p7, boolean p8)
    {
        p6.getClass();
        p7.getClass();
        if (p8) {
            return db.p.N(0, 0, p7.length(), p6, p7, p8);
        } else {
            return p6.startsWith(p7);
        }
    }

    public static Integer R(String p10)
    {
        p10.getClass();
        a.a.c(10);
        int v1 = p10.length();
        if (v1 != 0) {
            int v4_0;
            int v3_0;
            int v2_1 = 0;
            int v3_1 = p10.charAt(0);
            int v5_0 = -2147483647;
            if (v3_1 >= 48) {
                v3_0 = 0;
                v4_0 = 0;
            } else {
                v4_0 = 1;
                if (v1 != 1) {
                    if (v3_1 == 43) {
                        v3_0 = 0;
                    } else {
                        if (v3_1 == 45) {
                            v5_0 = -2147483648;
                            v3_0 = 1;
                        } else {
                            return 0;
                        }
                    }
                }
            }
            int v7 = -59652323;
            while (v4_0 < v1) {
                int v8_1 = Character.digit(p10.charAt(v4_0), 10);
                if (v8_1 >= 0) {
                    if (v2_1 < v7) {
                        if (v7 != -59652323) {
                            return 0;
                        } else {
                            v7 = (v5_0 / 10);
                            if (v2_1 < v7) {
                                return 0;
                            }
                        }
                    }
                    int v2_0 = (v2_1 * 10);
                    if (v2_0 >= (v5_0 + v8_1)) {
                        v2_1 = (v2_0 - v8_1);
                        v4_0++;
                    }
                }
            }
            if (v3_0 == 0) {
                return Integer.valueOf((- v2_1));
            } else {
                return Integer.valueOf(v2_1);
            }
        }
        return 0;
    }

    public static Long S(String p19)
    {
        p19.getClass();
        a.a.c(10);
        int v2 = p19.length();
        if (v2 != 0) {
            int v5_1;
            int v3_0 = 0;
            long v4_3 = p19.charAt(0);
            long v6 = -9223372036854775807;
            if (v4_3 >= 48) {
                v5_1 = 0;
            } else {
                v5_1 = 1;
                if (v2 != 1) {
                    if (v4_3 == 43) {
                        v5_1 = 0;
                        v3_0 = 1;
                    } else {
                        if (v4_3 == 45) {
                            v6 = -9223372036854775808;
                            v3_0 = 1;
                        } else {
                            return 0;
                        }
                    }
                }
            }
            long v10_0 = 0;
            long v12_0 = -256204778801521550;
            while (v3_0 < v2) {
                long v4_1 = Character.digit(p19.charAt(v3_0), 10);
                if (v4_1 >= 0) {
                    if (v10_0 < v12_0) {
                        if (v12_0 != -256204778801521550) {
                            return 0;
                        } else {
                            v12_0 = (v6 / ((long) 10));
                            if (v10_0 < v12_0) {
                                return 0;
                            }
                        }
                    }
                    long v10_1 = (v10_0 * ((long) 10));
                    long v14_3 = ((long) v4_1);
                    if (v10_1 >= (v6 + v14_3)) {
                        v10_0 = (v10_1 - v14_3);
                        v3_0++;
                    }
                }
            }
            if (v5_1 == 0) {
                return Long.valueOf((- v10_0));
            } else {
                return Long.valueOf(v10_0);
            }
        }
        return 0;
    }
}
