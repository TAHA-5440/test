// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class t {
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public final java.util.ArrayList f;
    public java.util.ArrayList g;
    public String h;

    public t()
    {
        this.b = "";
        this.c = "";
        this.e = -1;
        this.f = ha.k.v(new String[] {""}));
        return;
    }

    public static java.util.ArrayList d(String p6)
    {
        java.util.ArrayList v0_1 = new java.util.ArrayList();
        int v1_0 = 0;
        while (v1_0 <= p6.length()) {
            int v2_0 = db.i.X(p6, 38, v1_0, 4);
            if (v2_0 == -1) {
                v2_0 = p6.length();
            }
            int v3_0 = db.i.X(p6, 61, v1_0, 4);
            if ((v3_0 != -1) && (v3_0 <= v2_0)) {
                v0_1.add(p6.substring(v1_0, v3_0));
                v0_1.add(p6.substring((v3_0 + 1), v2_0));
            } else {
                v0_1.add(p6.substring(v1_0, v2_0));
                v0_1.add(0);
            }
            v1_0 = (v2_0 + 1);
        }
        return v0_1;
    }

    public final yb.u a()
    {
        String v1 = this.a;
        if (v1 == null) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("scheme == null");
            return 0;
        } else {
            yb.u v0_0 = nc.a.c(0, 0, 7, this.b);
            String v3_0 = nc.a.c(0, 0, 7, this.c);
            String v4_2 = this.d;
            if (v4_2 == null) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("host == null");
                return 0;
            } else {
                int v5_1 = this.b();
                String v8_0 = this.f;
                java.util.ArrayList v6_2 = new java.util.ArrayList(ha.l.y(v8_0, 10));
                String v10_1 = v8_0.size();
                int v11_0 = 0;
                while (v11_0 < v10_1) {
                    int v12_1 = v8_0.get(v11_0);
                    v11_0++;
                    v6_2.add(nc.a.c(0, 0, 7, ((String) v12_1)));
                }
                int v11_1;
                String v8_1 = this.g;
                String v10_2 = 0;
                if (v8_1 == null) {
                    v11_1 = 0;
                } else {
                    v11_1 = new java.util.ArrayList(ha.l.y(v8_1, 10));
                    String v9_2 = v8_1.size();
                    int v12_0 = 0;
                    while (v12_0 < v9_2) {
                        String v13_2;
                        String v13_0 = v8_1.get(v12_0);
                        v12_0++;
                        String v13_1 = ((String) v13_0);
                        if (v13_1 == null) {
                            v13_2 = 0;
                        } else {
                            v13_2 = nc.a.c(0, 0, 3, v13_1);
                        }
                        v11_1.add(v13_2);
                    }
                }
                String v8_2 = this.h;
                if (v8_2 != null) {
                    v10_2 = nc.a.c(0, 0, 7, v8_2);
                }
                return new yb.u(v1, v0_0, v3_0, v4_2, v5_1, v6_2, v11_1, v10_2, this.toString());
            }
        }
    }

    public final int b()
    {
        boolean v0_0 = this.e;
        int v1 = -1;
        if (v0_0 == -1) {
            boolean v0_2 = this.a;
            v0_2.getClass();
            if (!v0_2.equals("http")) {
                if (v0_2.equals("https")) {
                    v1 = 443;
                }
            } else {
                v1 = 80;
            }
            return v1;
        } else {
            return v0_0;
        }
    }

    public final void c(yb.u p18, String p19)
    {
        int v6_5;
        p19.getClass();
        int v3_3 = zb.c.h(0, p19.length(), p19);
        int v5_1 = zb.c.i(v3_3, p19.length(), p19);
        int v10_8 = -1;
        if ((v5_1 - v3_3) >= 2) {
            int v6_3 = p19.charAt(v3_3);
            if (((kotlin.jvm.internal.f.c(v6_3, 97) >= 0) && (kotlin.jvm.internal.f.c(v6_3, 122) <= 0)) || ((kotlin.jvm.internal.f.c(v6_3, 65) >= 0) && (kotlin.jvm.internal.f.c(v6_3, 90) <= 0))) {
                v6_5 = (v3_3 + 1);
                while (v6_5 < v5_1) {
                    char v13_5 = p19.charAt(v6_5);
                    if (((97 > v13_5) || (v13_5 >= 123)) && (((65 > v13_5) || (v13_5 >= 91)) && (((48 > v13_5) || (v13_5 >= 58)) && ((v13_5 != 43) && ((v13_5 != 45) && (v13_5 != 46)))))) {
                        if (v13_5 != 58) {
                            break;
                        }
                    } else {
                        v6_5++;
                    }
                }
                v6_5 = -1;
            }
        }
        int v14_1 = 1;
        if (v6_5 == -1) {
            if (p18 == null) {
                String v1_21;
                if (p19.length() <= 6) {
                    v1_21 = p19;
                } else {
                    v1_21 = db.i.m0(6, p19).concat("...");
                }
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Expected URL scheme \'http\' or \'https\' but no scheme was found for ".concat(v1_21));
                return;
            } else {
                this.a = p18.a;
            }
        } else {
            if (!db.p.P(p19, "https:", v3_3, 1)) {
                if (!db.p.P(p19, "http:", v3_3, 1)) {
                    oc.l.n(p19.substring(0, v6_5), "Expected URL scheme \'http\' or \'https\' but was \'");
                    return;
                } else {
                    this.a = "http";
                    v3_3 += 5;
                }
            } else {
                this.a = "https";
                v3_3 += 6;
            }
        }
        int v6_0 = v3_3;
        String v15_0 = 0;
        while(true) {
            int v16 = v14_1;
            if (v6_0 >= v5_1) {
                break;
            }
            int v8_0 = p19.charAt(v6_0);
            if ((v8_0 != 47) && (v8_0 != 92)) {
                break;
            }
            v15_0++;
            v6_0++;
            v14_1 = v16;
        }
        java.util.ArrayList v9_0 = this.f;
        int v7_1 = 35;
        if ((v15_0 < 2) && ((p18 != null) && (kotlin.jvm.internal.f.a(p18.a, this.a)))) {
            this.b = p18.e();
            this.c = p18.a();
            this.d = p18.d;
            this.e = p18.e;
            v9_0.clear();
            v9_0.addAll(p18.c());
            if ((v3_3 == v5_1) || (p19.charAt(v3_3) == 35)) {
                String v1_2;
                String v1_1 = p18.d();
                if (v1_1 == null) {
                    v1_2 = 0;
                } else {
                    v1_2 = yb.t.d(nc.a.a(v1_1, 0, 0, " \"\'<>#", 83));
                }
                this.g = v1_2;
            }
        } else {
            int v3_0 = (v3_3 + v15_0);
            String v1_4 = 0;
            int v11_2 = 0;
            do {
                String v15_1;
                int v14_4 = zb.c.e(p19, "@/\\?#", v3_0, v5_1);
                if (v14_4 == v5_1) {
                    v15_1 = v10_8;
                } else {
                    v15_1 = p19.charAt(v14_4);
                }
                if ((v15_1 == v10_8) || ((v15_1 == v7_1) || ((v15_1 == 47) || ((v15_1 == 92) || (v15_1 == 63))))) {
                    String v1_5 = v3_0;
                    while (v1_5 < v14_4) {
                        String v4_3 = p19.charAt(v1_5);
                        if (v4_3 != 58) {
                            if (v4_3 == 91) {
                                do {
                                    v1_5++;
                                } while((v1_5 < v14_4) && (p19.charAt(v1_5) != 93));
                            }
                            v1_5++;
                        }
                        String v4_4 = (v1_5 + 1);
                        if (v4_4 >= v14_4) {
                            String v4_9;
                            this.d = zb.b.b(nc.a.c(v3_0, v1_5, 4, p19));
                            String v4_7 = this.a;
                            v4_7.getClass();
                            if (!v4_7.equals("http")) {
                                if (!v4_7.equals("https")) {
                                    v4_9 = -1;
                                } else {
                                    v4_9 = 443;
                                }
                            } else {
                                v4_9 = 80;
                            }
                            this.e = v4_9;
                        } else {
                            this.d = zb.b.b(nc.a.c(v3_0, v1_5, 4, p19));
                            try {
                                int v7_10 = Integer.parseInt(nc.a.a(p19, v4_4, v14_4, "", 120));
                            } catch (NumberFormatException) {
                                v7_10 = -1;
                                this.e = v7_10;
                                if (v7_10 == -1) {
                                    String v1_6 = p19.substring(v4_4, v14_4);
                                    IllegalArgumentException v2_2 = new StringBuilder("Invalid URL port: \"");
                                    v2_2.append(v1_6);
                                    v2_2.append(34);
                                    throw new IllegalArgumentException(v2_2.toString().toString());
                                }
                            }
                            if ((v16 > v7_10) || (v7_10 >= 65536)) {
                            }
                        }
                        if (this.d == null) {
                            String v1_9 = p19.substring(v3_0, v1_5);
                            IllegalArgumentException v2_6 = new StringBuilder("Invalid URL host: \"");
                            v2_6.append(v1_9);
                            v2_6.append(34);
                            throw new IllegalArgumentException(v2_6.toString().toString());
                        } else {
                            v3_3 = v14_4;
                        }
                    }
                    v1_5 = v14_4;
                } else {
                }
            } while(v15_1 == 64);
        }
        String v1_13 = zb.c.e(p19, "?#", v3_3, v5_1);
        if (v3_3 != v1_13) {
            String v4_11 = p19.charAt(v3_3);
            if ((v4_11 == 47) || (v4_11 == 92)) {
                v9_0.clear();
                v9_0.add("");
                v3_3++;
            } else {
                v9_0.set((v9_0.size() - 1), "");
            }
            while (v3_3 < v1_13) {
                int v11_8;
                String v4_15 = zb.c.e(p19, "/\\", v3_3, v1_13);
                if (v4_15 >= v1_13) {
                    v11_8 = 0;
                } else {
                    v11_8 = 1;
                }
                int v3_4 = nc.a.a(p19, v3_3, v4_15, " \"<>^`{}|/\\?#", 112);
                if ((!v3_4.equals(".")) && (!v3_4.equalsIgnoreCase("%2e"))) {
                    if ((!v3_4.equals("..")) && ((!v3_4.equalsIgnoreCase("%2e.")) && ((!v3_4.equalsIgnoreCase(".%2e")) && (!v3_4.equalsIgnoreCase("%2e%2e"))))) {
                        if (((CharSequence) v9_0.get((v9_0.size() - 1))).length() != 0) {
                            v9_0.add(v3_4);
                        } else {
                            v9_0.set((v9_0.size() - 1), v3_4);
                        }
                        if (v11_8 != 0) {
                            v9_0.add("");
                        }
                    } else {
                        if ((((String) v9_0.remove((v9_0.size() - 1))).length() != 0) || (v9_0.isEmpty())) {
                            v9_0.add("");
                        } else {
                            v9_0.set((v9_0.size() - 1), "");
                        }
                    }
                }
                if (v11_8 == 0) {
                    v3_3 = v4_15;
                } else {
                    v3_3 = (v4_15 + 1);
                }
            }
        }
        if ((v1_13 < v5_1) && (p19.charAt(v1_13) == 63)) {
            String v4_17 = zb.c.d(p19, 35, v1_13, v5_1);
            this.g = yb.t.d(nc.a.a(p19, (v1_13 + 1), v4_17, " \"\'<>#", 80));
            v1_13 = v4_17;
        }
        if ((v1_13 < v5_1) && (p19.charAt(v1_13) == 35)) {
            this.h = nc.a.a(p19, (v1_13 + 1), v5_1, "", 48);
        }
        return;
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder();
        String v1_4 = this.a;
        if (v1_4 == null) {
            v0_1.append("//");
        } else {
            v0_1.append(v1_4);
            v0_1.append("://");
        }
        if ((this.b.length() > 0) || (this.c.length() > 0)) {
            v0_1.append(this.b);
            if (this.c.length() > 0) {
                v0_1.append(58);
                v0_1.append(this.c);
            }
            v0_1.append(64);
        }
        String v1_9 = this.d;
        if (v1_9 != null) {
            if (!db.i.U(v1_9, 58)) {
                v0_1.append(this.d);
            } else {
                v0_1.append(91);
                v0_1.append(this.d);
                v0_1.append(93);
            }
        }
        int v3_0 = -1;
        if ((this.e != -1) || (this.a != null)) {
            String v1_18 = this.b();
            String v4_0 = this.a;
            if (v4_0 != null) {
                if (!v4_0.equals("http")) {
                    if (v4_0.equals("https")) {
                        v3_0 = 443;
                    }
                } else {
                    v3_0 = 80;
                }
                if (v1_18 == v3_0) {
                    String v1_19 = this.f;
                    int v2_1 = v1_19.size();
                    int v3_1 = 0;
                    while (v3_1 < v2_1) {
                        v0_1.append(47);
                        v0_1.append(((String) v1_19.get(v3_1)));
                        v3_1++;
                    }
                    if (this.g != null) {
                        v0_1.append(63);
                        String v1_23 = this.g;
                        v1_23.getClass();
                        yb.b.b(v1_23, v0_1);
                    }
                    if (this.h != null) {
                        v0_1.append(35);
                        v0_1.append(this.h);
                    }
                    return v0_1.toString();
                }
            }
            v0_1.append(58);
            v0_1.append(v1_18);
        }
    }
}
