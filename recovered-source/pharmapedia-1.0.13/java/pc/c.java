// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package pc;
public abstract class c {
    public static final okio.ByteString a;
    public static final okio.ByteString b;
    public static final okio.ByteString c;
    public static final okio.ByteString d;
    public static final okio.ByteString e;

    static c()
    {
        pc.c.a = n5.f.o("/");
        pc.c.b = n5.f.o("\\");
        pc.c.c = n5.f.o("/\\");
        pc.c.d = n5.f.o(".");
        pc.c.e = n5.f.o("..");
        return;
    }

    public static final int a(oc.w p6)
    {
        int v6_1 = p6.g;
        if (v6_1.e() != 0) {
            if (v6_1.j(0) != 47) {
                if (v6_1.j(0) != 92) {
                    if ((v6_1.e() <= 2) || ((v6_1.j(1) != 58) || (v6_1.j(2) != 92))) {
                        return -1;
                    } else {
                        int v6_3 = ((char) v6_1.j(0));
                        if (((97 > v6_3) || (v6_3 >= 123)) && ((65 > v6_3) || (v6_3 >= 91))) {
                            return -1;
                        } else {
                            return 3;
                        }
                    }
                } else {
                    if ((v6_1.e() > 2) && (v6_1.j(1) == 92)) {
                        int v0_7 = pc.c.b;
                        v0_7.getClass();
                        int v0_10 = v6_1.g(2, v0_7.i());
                        if (v0_10 != -1) {
                            return v0_10;
                        } else {
                            return v6_1.e();
                        }
                    }
                }
            }
            return 1;
        }
        return -1;
    }

    public static final oc.w b(oc.w p6, oc.w p7, boolean p8)
    {
        p7.getClass();
        if ((pc.c.a(p7) == -1) && (p7.e() == null)) {
            okio.ByteString v0_0 = pc.c.c(p6);
            if (v0_0 == null) {
                v0_0 = pc.c.c(p7);
                if (v0_0 == null) {
                    v0_0 = pc.c.f(oc.w.h);
                }
            }
            oc.i v1_1 = new oc.i();
            v1_1.m0(p6.g);
            if (v1_1.h > 0) {
                v1_1.m0(v0_0);
            }
            v1_1.m0(p7.g);
            return pc.c.d(v1_1, p8);
        } else {
            return p7;
        }
    }

    public static final okio.ByteString c(oc.w p3)
    {
        okio.ByteString v1 = pc.c.a;
        if (okio.ByteString.h(p3.g, v1) == -1) {
            okio.ByteString v0_2 = pc.c.b;
            if (okio.ByteString.h(p3.g, v0_2) == -1) {
                return 0;
            } else {
                return v0_2;
            }
        } else {
            return v1;
        }
    }

    public static final oc.w d(oc.i p17, boolean p18)
    {
        okio.ByteString v1_2 = new oc.i();
        long v2_1 = 0;
        java.util.ArrayList v4_0 = 0;
        while(true) {
            int v5_7 = pc.c.a;
            v5_7.getClass();
            if (!p17.c0(0, v5_7, v5_7.e())) {
                int v5_5 = pc.c.b;
                v5_5.getClass();
                if (!p17.c0(0, v5_5, v5_5.e())) {
                    break;
                }
            }
            long v3_1 = p17.readByte();
            if (v2_1 == 0) {
                v2_1 = pc.c.e(v3_1);
            }
            v4_0++;
        }
        if ((v4_0 < 2) || (!kotlin.jvm.internal.f.a(v2_1, v5_5))) {
            int v6_4 = 0;
        } else {
            v6_4 = 1;
        }
        long v15_1;
        okio.ByteString v12 = pc.c.c;
        if (v6_4 == 0) {
            if (v4_0 <= null) {
                boolean v13_3 = p17.Z(v12);
                if (v2_1 == 0) {
                    if (v13_3 != -1) {
                        v2_1 = pc.c.e(p17.L(v13_3));
                    } else {
                        v2_1 = pc.c.f(oc.w.h);
                    }
                }
                if ((kotlin.jvm.internal.f.a(v2_1, v5_5)) && (p17.h >= 2)) {
                    v15_1 = -1;
                    if (p17.L(1) == 58) {
                        int v5_11 = ((char) p17.L(0));
                        if (((97 <= v5_11) && (v5_11 < 123)) || ((65 <= v5_11) && (v5_11 < 91))) {
                            if (v13_3 != 2) {
                                v1_2.D(2, p17);
                            } else {
                                v1_2.D(3, p17);
                            }
                        }
                    }
                } else {
                    v15_1 = -1;
                }
            } else {
                v2_1.getClass();
                v1_2.m0(v2_1);
            }
        } else {
            v2_1.getClass();
            v1_2.m0(v2_1);
            v1_2.m0(v2_1);
        }
        long v3_6;
        if (v1_2.h <= 0) {
            v3_6 = 0;
        } else {
            v3_6 = 1;
        }
        java.util.ArrayList v4_4 = new java.util.ArrayList();
        while(true) {
            boolean v10_14 = pc.c.d;
            if (p17.B()) {
                break;
            }
            int v5_4;
            boolean v13_0 = p17.Z(v12);
            if (v13_0 != v15_1) {
                v5_4 = p17.j(v13_0);
                p17.readByte();
            } else {
                v5_4 = p17.j(p17.h);
            }
            okio.ByteString v11 = pc.c.e;
            if (!kotlin.jvm.internal.f.a(v5_4, v11)) {
                if ((!kotlin.jvm.internal.f.a(v5_4, v10_14)) && (!kotlin.jvm.internal.f.a(v5_4, okio.ByteString.j))) {
                    v4_4.add(v5_4);
                }
            } else {
                if ((v3_6 == 0) || (!v4_4.isEmpty())) {
                    if ((p18) && ((v3_6 != 0) || ((!v4_4.isEmpty()) && (!kotlin.jvm.internal.f.a(ha.j.J(v4_4), v11))))) {
                        if ((v6_4 == 0) || (v4_4.size() != 1)) {
                            ha.j.O(v4_4);
                        }
                    } else {
                        v4_4.add(v5_4);
                    }
                }
            }
        }
        oc.w v0_2 = v4_4.size();
        long v3_0 = 0;
        while (v3_0 < v0_2) {
            if (v3_0 > 0) {
                v1_2.m0(v2_1);
            }
            v1_2.m0(((okio.ByteString) v4_4.get(v3_0)));
            v3_0++;
        }
        if (v1_2.h == 0) {
            v1_2.m0(v10_14);
        }
        return new oc.w(v1_2.j(v1_2.h));
    }

    public static final okio.ByteString e(byte p1)
    {
        if (p1 == 47) {
            return pc.c.a;
        } else {
            if (p1 != 92) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u(r1.a.g(p1, "not a directory separator: "));
                return 0;
            } else {
                return pc.c.b;
            }
        }
    }

    public static final okio.ByteString f(String p1)
    {
        if (!kotlin.jvm.internal.f.a(p1, "/")) {
            if (!kotlin.jvm.internal.f.a(p1, "\\")) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u(r1.a.j("not a directory separator: ", p1));
                return 0;
            } else {
                return pc.c.b;
            }
        } else {
            return pc.c.a;
        }
    }
}
