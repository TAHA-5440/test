// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package db;
public abstract class j extends com.bumptech.glide.d {

    public static String G(String p3)
    {
        return cb.i.p(new cb.g(new cb.j(p3, 1), new ac.c("    ", 3)), "\n");
    }

    public static String H(String p11)
    {
        String v0_0 = db.i.d0(p11);
        int v1_2 = new java.util.ArrayList();
        java.util.ArrayList v2_7 = v0_0.iterator();
        while (v2_7.hasNext()) {
            int v3_1 = v2_7.next();
            if (!db.i.a0(((String) v3_1))) {
                v1_2.add(v3_1);
            }
        }
        java.util.ArrayList v2_0 = new java.util.ArrayList(ha.l.y(v1_2, 10));
        int v3_3 = v1_2.size();
        String v4_3 = 0;
        java.util.ArrayList v5_0 = 0;
        while (v5_0 < v3_3) {
            String v6_5 = v1_2.get(v5_0);
            v5_0++;
            String v6_6 = ((String) v6_5);
            int v7_1 = v6_6.length();
            int v8 = 0;
            while (v8 < v7_1) {
                if (a.a.q(v6_6.charAt(v8))) {
                    v8++;
                }
                if (v8 == -1) {
                    v8 = v6_6.length();
                }
                v2_0.add(Integer.valueOf(v8));
            }
            v8 = -1;
        }
        java.util.ArrayList v2_3;
        int v1_1 = v2_0.iterator();
        if (v1_1.hasNext()) {
            v2_3 = ((Comparable) v1_1.next());
            while (v1_1.hasNext()) {
                java.util.ArrayList v5_3 = ((Comparable) v1_1.next());
                if (v2_3.compareTo(v5_3) > 0) {
                    v2_3 = v5_3;
                }
            }
        } else {
            v2_3 = 0;
        }
        int v1_3;
        java.util.ArrayList v2_4 = ((Integer) v2_3);
        if (v2_4 == null) {
            v1_3 = 0;
        } else {
            v1_3 = v2_4.intValue();
        }
        int v11_1 = p11.length();
        v0_0.size();
        java.util.ArrayList v2_6 = (v0_0.size() - 1);
        java.util.ArrayList v5_5 = new java.util.ArrayList();
        String v0_1 = v0_0.iterator();
        while (v0_1.hasNext()) {
            String v6_3 = v0_1.next();
            int v7_0 = (v4_3 + 1);
            if (v4_3 < null) {
                ha.k.x();
                throw 0;
            } else {
                String v4_6;
                String v6_4 = ((String) v6_3);
                if (((v4_3 != null) && (v4_3 != v2_6)) || (!db.i.a0(v6_4))) {
                    v6_4.getClass();
                    if (v1_3 < 0) {
                        oc.l.d(r1.a.h(v1_3, "Requested character count ", " is less than zero."));
                        return 0;
                    } else {
                        String v4_5 = v6_4.length();
                        if (v1_3 <= v4_5) {
                            v4_5 = v1_3;
                        }
                        v4_6 = v6_4.substring(v4_5);
                    }
                } else {
                    v4_6 = 0;
                }
                if (v4_6 != null) {
                    v5_5.add(v4_6);
                }
                v4_3 = v7_0;
            }
        }
        String v0_3 = new StringBuilder(v11_1);
        ha.j.H(v5_5, v0_3);
        return v0_3.toString();
    }

    public static String I(String p12)
    {
        if (db.i.a0("|")) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("marginPrefix must be non-blank string.");
            return 0;
        } else {
            java.util.Iterator v1_2 = db.i.d0(p12);
            String v12_1 = p12.length();
            v1_2.size();
            int v2_1 = (v1_2.size() - 1);
            java.util.ArrayList v3_1 = new java.util.ArrayList();
            java.util.Iterator v1_0 = v1_2.iterator();
            int v5_0 = 0;
            while (v1_0.hasNext()) {
                String v6_1 = v1_0.next();
                int v7 = (v5_0 + 1);
                String v8 = 0;
                if (v5_0 < 0) {
                    ha.k.x();
                    throw 0;
                } else {
                    String v6_2 = ((String) v6_1);
                    if (((v5_0 != 0) && (v5_0 != v2_1)) || (!db.i.a0(v6_2))) {
                        int v5_2 = v6_2.length();
                        int v9 = 0;
                        while (v9 < v5_2) {
                            if (a.a.q(v6_2.charAt(v9))) {
                                v9++;
                            }
                            if ((v9 != -1) && (db.p.P(v6_2, "|", v9, 0))) {
                                v8 = v6_2.substring(("|".length() + v9));
                            }
                            if (v8 == null) {
                                v8 = v6_2;
                            }
                        }
                        v9 = -1;
                    }
                    if (v8 != null) {
                        v3_1.add(v8);
                    }
                    v5_0 = v7;
                }
            }
            StringBuilder v0_2 = new StringBuilder(v12_1);
            ha.j.H(v3_1, v0_2);
            return v0_2.toString();
        }
    }
}
