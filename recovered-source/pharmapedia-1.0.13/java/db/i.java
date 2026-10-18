// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package db;
public abstract class i extends db.p {

    public static boolean T(CharSequence p8, CharSequence p9, boolean p10)
    {
        p8.getClass();
        p9.getClass();
        if (!(p9 instanceof String)) {
            if (db.i.W(p8, p9, 0, p8.length(), p10, 0) >= 0) {
                return 1;
            }
        } else {
            if (db.i.Y(p8, ((String) p9), 0, p10, 2) >= 0) {
                return 1;
            }
        }
        return 0;
    }

    public static boolean U(CharSequence p2, char p3)
    {
        p2.getClass();
        if (db.i.X(p2, p3, 0, 2) < 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static final int V(CharSequence p6, String p7, int p8, boolean p9)
    {
        p6.getClass();
        p7.getClass();
        if ((!p9) && ((p6 instanceof String))) {
            return ((String) p6).indexOf(p7, p8);
        } else {
            return db.i.W(p6, p7, p8, p6.length(), p9, 0);
        }
    }

    public static final int W(CharSequence p10, CharSequence p11, int p12, int p13, boolean p14, boolean p15)
    {
        int v15_2;
        if (p15 != 0) {
            p10.getClass();
            int v15_6 = (p10.length() - 1);
            if (p12 > v15_6) {
                p12 = v15_6;
            }
            if (p13 < 0) {
                p13 = 0;
            }
            v15_2 = new ab.a(p12, p13, -1);
        } else {
            if (p12) {
                p12 = 0;
            }
            int v2_0 = p10.length();
            if (p13 > v2_0) {
                p13 = v2_0;
            }
            v15_2 = new ab.c(p12, p13, 1);
        }
        int v13_1 = v15_2.i;
        int v1_1 = v15_2.h;
        int v15_4 = v15_2.g;
        if ((!(p10 instanceof String)) || (!(p11 instanceof String))) {
            boolean v7_0 = p14;
            if (((v13_1 <= 0) || (v15_4 > v1_1)) && ((v13_1 >= 0) || (v1_1 > v15_4))) {
                return -1;
            }
            while(true) {
                boolean v9 = v7_0;
                v7_0 = v9;
                if (db.i.f0(p11, 0, p10, v15_4, p11.length(), v9)) {
                    break;
                }
                if (v15_4 != v1_1) {
                    v15_4 += v13_1;
                }
            }
            return v15_4;
        } else {
            if (((v13_1 > 0) && (v15_4 <= v1_1)) || ((v13_1 < 0) && (v1_1 <= v15_4))) {
                int v3 = v15_4;
                while(true) {
                    String v5_2 = ((String) p11);
                    if (db.p.N(0, v3, v5_2.length(), v5_2, ((String) p10), p14)) {
                        break;
                    }
                    if (v3 != v1_1) {
                        v3 += v13_1;
                    }
                }
                return v3;
            }
        }
        return -1;
    }

    public static int X(CharSequence p1, char p2, int p3, int p4)
    {
        if ((p4 & 2) != 0) {
            p3 = 0;
        }
        p1.getClass();
        if ((p1 instanceof String)) {
            return ((String) p1).indexOf(p2, p3);
        } else {
            char[] v4_3 = new char[1];
            v4_3[0] = p2;
            return db.i.Z(p1, v4_3, p3, 0);
        }
    }

    public static synthetic int Y(CharSequence p2, String p3, int p4, boolean p5, int p6)
    {
        if ((p6 & 2) != 0) {
            p4 = 0;
        }
        if ((p6 & 4) != 0) {
            p5 = 0;
        }
        return db.i.V(p2, p3, p4, p5);
    }

    public static final int Z(CharSequence p6, char[] p7, int p8, boolean p9)
    {
        p6.getClass();
        if ((p9 != 0) || ((p7.length != 1) || (!(p6 instanceof String)))) {
            if (p8 < 0) {
                p8 = 0;
            }
            int v2_1 = (p6.length() - 1);
            if (p8 <= v2_1) {
                while(true) {
                    int v0_1 = p6.charAt(p8);
                    int v4 = 0;
                    if (v4 < p7.length) {
                        break;
                    }
                    if (p8 != v2_1) {
                        p8++;
                    }
                }
                if (!a.a.g(p7[v4], v0_1, p9)) {
                    v4++;
                    while (v4 >= p7.length) {
                    }
                } else {
                    return p8;
                }
            }
            return -1;
        } else {
            int v9_1 = p7.length;
            if (v9_1 == 0) {
                throw new java.util.NoSuchElementException("Array is empty.");
            } else {
                int v7_3;
                if (v9_1 != 1) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Array has more than one element.");
                    v7_3 = 0;
                } else {
                    v7_3 = p7[0];
                }
                return ((String) p6).indexOf(v7_3, p8);
            }
        }
    }

    public static boolean a0(String p3)
    {
        p3.getClass();
        int v1 = 0;
        while (v1 < p3.length()) {
            if (a.a.q(p3.charAt(v1))) {
                v1++;
            } else {
                return 0;
            }
        }
        return 1;
    }

    public static int b0(int p0, String p1, String p2)
    {
        int v0_3;
        if ((p0 & 2) == 0) {
            v0_3 = 0;
        } else {
            p1.getClass();
            v0_3 = (p1.length() - 1);
        }
        p1.getClass();
        p2.getClass();
        return p1.lastIndexOf(p2, v0_3);
    }

    public static int c0(String p0, char p1, int p2, int p3)
    {
        if ((p3 & 2) != 0) {
            p0.getClass();
            p2 = (p0.length() - 1);
        }
        p0.getClass();
        return p0.lastIndexOf(p1, p2);
    }

    public static java.util.List d0(String p2)
    {
        db.e v0_1 = new db.e(p2);
        if (v0_1.hasNext()) {
            Object v2_6 = v0_1.next();
            if (v0_1.hasNext()) {
                java.util.ArrayList v1_1 = new java.util.ArrayList();
                v1_1.add(v2_6);
                while (v0_1.hasNext()) {
                    v1_1.add(v0_1.next());
                }
                return v1_1;
            } else {
                return com.bumptech.glide.e.l(v2_6);
            }
        } else {
            return kotlin.collections.EmptyList.g;
        }
    }

    public static String e0(int p3, String p4)
    {
        p4.getClass();
        if (p3 < null) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u(r1.a.h(p3, "Desired length ", " is less than zero."));
            return 0;
        } else {
            StringBuilder v3_2;
            if (p3 > p4.length()) {
                StringBuilder v0_2 = new StringBuilder(p3);
                StringBuilder v3_1 = (p3 - p4.length());
                int v1_1 = 1;
                if (1 <= v3_1) {
                    while(true) {
                        v0_2.append(48);
                        if (v1_1 == v3_1) {
                            break;
                        }
                        v1_1++;
                    }
                }
                v0_2.append(p4);
                v3_2 = v0_2;
            } else {
                v3_2 = p4.subSequence(0, p4.length());
            }
            return v3_2.toString();
        }
    }

    public static final boolean f0(CharSequence p4, int p5, CharSequence p6, int p7, int p8, boolean p9)
    {
        p4.getClass();
        p6.getClass();
        if ((p7 >= 0) && ((p5 >= 0) && ((p5 <= (p4.length() - p8)) && (p7 <= (p6.length() - p8))))) {
            int v1_2 = 0;
            while (v1_2 < p8) {
                if (a.a.g(p4.charAt((p5 + v1_2)), p6.charAt((p7 + v1_2)), p9)) {
                    v1_2++;
                } else {
                    return 0;
                }
            }
            return 1;
        } else {
            return 0;
        }
    }

    public static String g0(String p1, String p2)
    {
        if (db.p.Q(p1, p2, 0)) {
            p1 = p1.substring(p2.length());
        }
        return p1;
    }

    public static final void h0(int p1)
    {
        if (p1 < null) {
            oc.l.d(r1.a.g(p1, "Limit must be non-negative, but was "));
            return;
        } else {
            return;
        }
    }

    public static final java.util.List i0(int p8, CharSequence p9, String p10)
    {
        db.i.h0(p8);
        int v1_1 = db.i.V(p9, p10, 0, 0);
        if ((v1_1 != -1) && (p8 != 1)) {
            int v4;
            if (p8 <= null) {
                v4 = 0;
            } else {
                v4 = 1;
            }
            int v6_0 = 10;
            if ((v4 != 0) && (p8 <= 10)) {
                v6_0 = p8;
            }
            java.util.ArrayList v5_1 = new java.util.ArrayList(v6_0);
            int v6_1 = 0;
            do {
                v5_1.add(p9.subSequence(v6_1, v1_1).toString());
                v6_1 = (p10.length() + v1_1);
                if ((v4 != 0) && (v5_1.size() == (p8 - 1))) {
                    break;
                }
                v1_1 = db.i.V(p9, p10, v6_1, 0);
            } while(v1_1 != -1);
            v5_1.add(p9.subSequence(v6_1, p9.length()).toString());
            return v5_1;
        } else {
            return com.bumptech.glide.e.l(p9.toString());
        }
    }

    public static java.util.List j0(CharSequence p4, String[] p5, int p6)
    {
        java.util.ArrayList v6_5;
        if ((p6 & 4) == 0) {
            v6_5 = 2;
        } else {
            v6_5 = 0;
        }
        p4.getClass();
        if (p5.length == 1) {
            String v0_13 = p5[0];
            if (v0_13.length() > 0) {
                return db.i.i0(v6_5, p4, v0_13);
            }
        }
        db.i.h0(v6_5);
        java.util.Iterator v5_1 = java.util.Arrays.asList(p5);
        v5_1.getClass();
        java.util.Iterator v5_3 = new cb.k(new db.c(p4, v6_5, new db.q(v5_1, 0)), 0);
        java.util.ArrayList v6_4 = new java.util.ArrayList(ha.l.y(v5_3, 10));
        java.util.Iterator v5_4 = v5_3.iterator();
        while(true) {
            String v0_6 = ((db.b) v5_4);
            if (!v0_6.hasNext()) {
                break;
            }
            String v0_8 = ((ab.c) v0_6.next());
            v0_8.getClass();
            v6_4.add(p4.subSequence(v0_8.g, (v0_8.h + 1)).toString());
        }
        return v6_4;
    }

    public static java.util.List k0(String p5, char[] p6)
    {
        if (p6.length != 1) {
            db.i.h0(0);
            java.util.Iterator v6_2 = new cb.k(new db.c(p5, 0, new db.q(p6, 1)), 0);
            java.util.ArrayList v0_2 = new java.util.ArrayList(ha.l.y(v6_2, 10));
            java.util.Iterator v6_3 = v6_2.iterator();
            while(true) {
                String v1_5 = ((db.b) v6_3);
                if (!v1_5.hasNext()) {
                    break;
                }
                String v1_7 = ((ab.c) v1_5.next());
                v1_7.getClass();
                v0_2.add(p5.subSequence(v1_7.g, (v1_7.h + 1)).toString());
            }
            return v0_2;
        } else {
            return db.i.i0(0, p5, String.valueOf(p6[0]));
        }
    }

    public static String l0(String p2, String p3, String p4)
    {
        int v0_1 = db.i.Y(p2, p3, 0, 0, 6);
        if (v0_1 != -1) {
            return p2.substring((p3.length() + v0_1), p2.length());
        } else {
            return p4;
        }
    }

    public static String m0(int p1, String p2)
    {
        p2.getClass();
        if (p1 < null) {
            oc.l.d(r1.a.h(p1, "Requested character count ", " is less than zero."));
            return 0;
        } else {
            int v0_0 = p2.length();
            if (p1 > v0_0) {
                p1 = v0_0;
            }
            return p2.substring(0, p1);
        }
    }

    public static String n0(String p2)
    {
        p2.getClass();
        int v0_0 = p2.length();
        int v1 = 8;
        if (8 > v0_0) {
            v1 = v0_0;
        }
        return p2.substring((v0_0 - v1));
    }

    public static CharSequence o0(String p5)
    {
        p5.getClass();
        int v0_0 = (p5.length() - 1);
        int v2 = 0;
        int v3 = 0;
        while (v2 <= v0_0) {
            boolean v4_0;
            if (v3 != 0) {
                v4_0 = v0_0;
            } else {
                v4_0 = v2;
            }
            boolean v4_2 = a.a.q(p5.charAt(v4_0));
            if (v3 != 0) {
                if (!v4_2) {
                    break;
                }
                v0_0--;
            } else {
                if (v4_2) {
                    v2++;
                } else {
                    v3 = 1;
                }
            }
        }
        return p5.subSequence(v2, (v0_0 + 1));
    }
}
