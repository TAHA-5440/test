// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package nc;
public abstract class a {
    public static final char[] a;

    static a()
    {
        char[] v0_1 = new char[16];
        v0_1 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        nc.a.a = v0_1;
        return;
    }

    public static String a(String p17, int p18, int p19, String p20, int p21)
    {
        oc.i v2_3;
        int v3 = 0;
        if ((p21 & 1) == 0) {
            v2_3 = p18;
        } else {
            v2_3 = 0;
        }
        int v4_0;
        if ((p21 & 2) == 0) {
            v4_0 = p19;
        } else {
            v4_0 = p17.length();
        }
        int v5_1;
        if ((p21 & 8) == 0) {
            v5_1 = 1;
        } else {
            v5_1 = 0;
        }
        int v7_1;
        if ((p21 & 16) == 0) {
            v7_1 = 1;
        } else {
            v7_1 = 0;
        }
        int v8_1;
        if ((p21 & 32) == 0) {
            v8_1 = 1;
        } else {
            v8_1 = 0;
        }
        if ((p21 & 64) == 0) {
            v3 = 1;
        }
        p17.getClass();
        int v6_1 = v2_3;
        while (v6_1 < v4_0) {
            int v9_1 = p17.codePointAt(v6_1);
            int v10_7 = 32;
            if (((v9_1 >= 32) && ((v9_1 != 127) && ((v9_1 < 128) || (v3 != 0)))) && (((!db.i.U(p20, ((char) v9_1))) && ((v9_1 != 37) || ((v5_1 != 0) && ((v7_1 == 0) || (nc.a.b(v6_1, v4_0, p17)))))) && ((v9_1 != 43) || (v8_1 == 0)))) {
                v6_1 += Character.charCount(v9_1);
            } else {
                int v9_4 = new oc.i();
                v9_4.v0(v2_3, v6_1, p17);
                oc.i v2_1 = 0;
                while (v6_1 < v4_0) {
                    boolean v15_3 = p17.codePointAt(v6_1);
                    if ((v5_1 == 0) || ((v15_3 != 9) && ((v15_3 != 10) && ((v15_3 != 12) && (v15_3 != 13))))) {
                        boolean v13_3 = "+";
                        if ((v15_3 != v10_7) || (p20 != " !\"#$&\'()+,/:;<=>?@[\\]^`{|}~")) {
                            if ((v15_3 != 43) || (v8_1 == 0)) {
                                if (((v15_3 >= v10_7) && ((v15_3 != 127) && ((v15_3 < 128) || (v3 != 0)))) && ((!db.i.U(p20, ((char) v15_3))) && ((v15_3 != 37) || ((v5_1 != 0) && ((v7_1 == 0) || (nc.a.b(v6_1, v4_0, p17))))))) {
                                    v9_4.x0(v15_3);
                                } else {
                                    if (v2_1 == null) {
                                        v2_1 = new oc.i();
                                    }
                                    v2_1.x0(v15_3);
                                    while (!v2_1.B()) {
                                        boolean v13_2 = v2_1.readByte();
                                        int v10_0 = (v13_2 & 255);
                                        v9_4.o0(37);
                                        char[] v16 = nc.a.a;
                                        v9_4.o0(v16[((v10_0 >> 4) & 15)]);
                                        v9_4.o0(v16[(v13_2 & 15)]);
                                        int v11 = 128;
                                    }
                                }
                            } else {
                                if (v5_1 == 0) {
                                    v13_3 = "%2B";
                                }
                                v9_4.w0(v13_3);
                            }
                        } else {
                            v9_4.w0("+");
                        }
                    }
                    v6_1 += Character.charCount(v15_3);
                    v10_7 = 32;
                }
                return v9_4.i0();
            }
        }
        return p17.substring(v2_3, v4_0);
    }

    public static final boolean b(int p2, int p3, String p4)
    {
        p4.getClass();
        int v0 = (p2 + 2);
        if ((v0 >= p3) || ((p4.charAt(p2) != 37) || ((zb.c.l(p4.charAt((p2 + 1))) == -1) || (zb.c.l(p4.charAt(v0)) == -1)))) {
            return 0;
        } else {
            return 1;
        }
    }

    public static String c(int p8, int p9, int p10, String p11)
    {
        int v1 = 0;
        if ((p10 & 1) != 0) {
            p8 = 0;
        }
        if ((p10 & 2) != 0) {
            p9 = p11.length();
        }
        if ((p10 & 4) == 0) {
            v1 = 1;
        }
        p11.getClass();
        int v10_1 = p8;
        while (v10_1 < p9) {
            oc.i v0_1 = p11.charAt(v10_1);
            if ((v0_1 != 37) && ((v0_1 != 43) || (v1 == 0))) {
                v10_1++;
            } else {
                oc.i v0_3 = new oc.i();
                v0_3.v0(p8, v10_1, p11);
                while (v10_1 < p9) {
                    int v8_3 = p11.codePointAt(v10_1);
                    if (v8_3 != 37) {
                        if ((v8_3 == 43) && (v1 != 0)) {
                            v0_3.o0(32);
                            v10_1++;
                        }
                    } else {
                        int v4 = (v10_1 + 2);
                        if (v4 >= p9) {
                        } else {
                            int v5_2 = zb.c.l(p11.charAt((v10_1 + 1)));
                            int v6_1 = zb.c.l(p11.charAt(v4));
                            if ((v5_2 != -1) && (v6_1 != -1)) {
                                v0_3.o0(((v5_2 << 4) + v6_1));
                                v10_1 = (Character.charCount(v8_3) + v4);
                            }
                        }
                    }
                    v0_3.x0(v8_3);
                    v10_1 += Character.charCount(v8_3);
                }
                return v0_3.i0();
            }
        }
        return p11.substring(p8, p9);
    }
}
