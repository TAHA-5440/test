// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jc;
public abstract class g {
    public static boolean b = True;
    public static reflect.Field c;
    public static boolean d;
    public final synthetic int a;

    public synthetic g(int p1)
    {
        this.a = p1;
        return;
    }

    public static kotlinx.coroutines.channels.a a(int p1, kotlinx.coroutines.channels.BufferOverflow p2, int p3)
    {
        if ((p3 & 2) != 0) {
            p2 = kotlinx.coroutines.channels.BufferOverflow.g;
        }
        if (p1 == -2) {
            if (p2 != kotlinx.coroutines.channels.BufferOverflow.g) {
                return new ib.i(1, p2);
            } else {
                ib.d.a.getClass();
                return new kotlinx.coroutines.channels.a(ib.c.b);
            }
        } else {
            if (p1 == -1) {
                if (p2 != kotlinx.coroutines.channels.BufferOverflow.g) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("CONFLATED capacity cannot be used with non-default onBufferOverflow");
                    return 0;
                } else {
                    return new ib.i(1, kotlinx.coroutines.channels.BufferOverflow.h);
                }
            } else {
                if (p1 == null) {
                    if (p2 != kotlinx.coroutines.channels.BufferOverflow.g) {
                        return new ib.i(1, p2);
                    } else {
                        return new kotlinx.coroutines.channels.a(0);
                    }
                } else {
                    if (p1 == 2147483647) {
                        return new kotlinx.coroutines.channels.a(2147483647);
                    } else {
                        if (p2 != kotlinx.coroutines.channels.BufferOverflow.g) {
                            return new ib.i(p1, p2);
                        } else {
                            return new kotlinx.coroutines.channels.a(p1);
                        }
                    }
                }
            }
        }
    }

    public static final long b(long p7, long p9)
    {
        if ((p7 != 4611686018427387903) && (p7 != -4611686018427387903)) {
            if ((p9 != 4611686018427387903) && (p9 != -4611686018427387903)) {
                return com.bumptech.glide.d.e((p7 + p9), -4611686018427387903, 4611686018427387903);
            } else {
                return p9;
            }
        } else {
            if ((-4611686018427387903 >= p9) || (p9 >= 4611686018427387903)) {
                if ((p9 ^ p7) < 0) {
                    return 9223372036854759646;
                } else {
                    return p7;
                }
            } else {
                return p7;
            }
        }
    }

    public static void c(Object p2, Object p3)
    {
        if (p2 == null) {
            StringBuilder v0_3 = new StringBuilder("null key in entry: null=");
            v0_3.append(p3);
            throw new NullPointerException(v0_3.toString());
        } else {
            if (p3 == null) {
                StringBuilder v0_1 = new StringBuilder("null value in entry: ");
                v0_1.append(p2);
                v0_1.append("=null");
                throw new NullPointerException(v0_1.toString());
            } else {
                return;
            }
        }
    }

    public static void d(int p2, String p3)
    {
        if (p2 < null) {
            StringBuilder v1_1 = new StringBuilder();
            v1_1.append(p3);
            v1_1.append(" cannot be negative but was: ");
            v1_1.append(p2);
            throw new IllegalArgumentException(v1_1.toString());
        } else {
            return;
        }
    }

    public static final int e(e2.c p10, String p11)
    {
        p10.getClass();
        int v0_2 = p10.getColumnCount();
        int v2_0 = 0;
        while (v2_0 < v0_2) {
            if (!p11.equals(p10.getColumnName(v2_0))) {
                v2_0++;
            }
            if (v2_0 < 0) {
                int v0_1 = r1.a.k("`", p11, 96);
                String v4_1 = p10.getColumnCount();
                String v5_0 = 0;
                while (v5_0 < v4_1) {
                    if (!v0_1.equals(p10.getColumnName(v5_0))) {
                        v5_0++;
                    }
                    if (v5_0 < null) {
                        if ((android.os.Build$VERSION.SDK_INT <= 25) && (p11.length() != 0)) {
                            int v0_5 = p10.getColumnCount();
                            String v5_1 = ".".concat(p11);
                            String v4_4 = r1.a.k(".", p11, 96);
                            int v6_2 = 0;
                            while (v6_2 < v0_5) {
                                boolean v7_0 = p10.getColumnName(v6_2);
                                if ((v7_0.length() < (p11.length() + 2)) || ((!db.p.K(v7_0, v5_1, 0)) && ((v7_0.charAt(0) != 96) || (!db.p.K(v7_0, v4_4, 0))))) {
                                    v6_2++;
                                } else {
                                    return v6_2;
                                }
                            }
                        }
                        return -1;
                    } else {
                        return v5_0;
                    }
                }
                v5_0 = -1;
            } else {
                return v2_0;
            }
        }
        v2_0 = -1;
    }

    public static g6.f0 f(int p1)
    {
        if (p1 == null) {
            return new n5.l();
        } else {
            if (p1 == 1) {
                return new n5.e();
            } else {
                return new n5.l();
            }
        }
    }

    public static void g(java.io.File p1)
    {
        p1.getClass();
        String v0_2 = p1.getCanonicalFile().getParentFile();
        if (v0_2 != null) {
            v0_2.mkdirs();
            if (!v0_2.isDirectory()) {
                oc.l.f(p1, "Unable to create parent directories of ");
                return;
            }
        }
        return;
    }

    public static final long h(long p3)
    {
        long v3_2 = ((p3 << 1) + 1);
        eb.a.h.getClass();
        return v3_2;
    }

    public static final int i(e2.c p7, String p8)
    {
        p7.getClass();
        String v0_1 = jc.g.e(p7, p8);
        if (v0_1 < null) {
            String v0_2 = p7.getColumnCount();
            int v1_2 = new java.util.ArrayList(v0_2);
            String v2_2 = 0;
            while (v2_2 < v0_2) {
                v1_2.add(p7.getColumnName(v2_2));
                v2_2++;
            }
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.e(93, "Column \'", p8, "\' does not exist. Available columns: [", ha.j.I(v1_2, 0, 0, 0, 0, 63));
            return 0;
        } else {
            return v0_1;
        }
    }

    public static float j(String[] p2, int p3)
    {
        String v2_3 = Float.parseFloat(p2[p3]);
        if ((v2_3 < 0) || (v2_3 > 1065353216)) {
            StringBuilder v0_1 = new StringBuilder("Motion easing control point value must be between 0 and 1; instead got: ");
            v0_1.append(v2_3);
            throw new IllegalArgumentException(v0_1.toString());
        } else {
            return v2_3;
        }
    }

    public static boolean m(String p1, String p2)
    {
        if ((!p1.startsWith(p2.concat("("))) || (!p1.endsWith(")"))) {
            return 0;
        } else {
            return 1;
        }
    }

    public static long n(String p26)
    {
        if (p26.length() == 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("The string is empty");
            return 0;
        } else {
            boolean v4_4;
            int v8;
            boolean v4_0 = p26.charAt(0);
            int v5_0 = 1;
            int v6_3 = 45;
            int v7_2 = 43;
            if (v4_0 == 43) {
                v8 = 0;
                v4_4 = 1;
            } else {
                if (v4_0 == 45) {
                    v4_4 = 1;
                } else {
                    v4_4 = 0;
                }
                v8 = v4_4;
            }
            if (p26.length() <= v4_4) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("No components");
                return 0;
            } else {
                if (p26.charAt(v4_4) != 80) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("");
                    return 0;
                } else {
                    boolean v4_3 = (v4_4 + 1);
                    if (v4_3 == p26.length()) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("");
                        return 0;
                    } else {
                        int v10_1 = 0;
                        kotlin.time.DurationUnit v1_8 = 0;
                        int v12 = 0;
                        long v14_3 = 0;
                        while (v4_3 < p26.length()) {
                            String v2_30 = p26.charAt(v4_3);
                            if (v2_30 != 84) {
                                int v5_1;
                                int v9_3;
                                int v3_25 = eb.c.e;
                                int v18_1 = v5_0;
                                if (!v3_25.b) {
                                    v5_1 = v4_3;
                                    v9_3 = v18_1;
                                } else {
                                    int v5_6 = p26.charAt(v4_3);
                                    if (v5_6 == v7_2) {
                                        v5_1 = (v4_3 + 1);
                                    } else {
                                        if (v5_6 == v6_3) {
                                            v5_1 = (v4_3 + 1);
                                            v9_3 = -1;
                                        }
                                    }
                                }
                                while ((v5_1 < p26.length()) && (p26.charAt(v5_1) == 48)) {
                                    v5_1++;
                                }
                                long v20_0 = 0;
                                while (v5_1 < p26.length()) {
                                    int v6_1 = p26.charAt(v5_1);
                                    int v23_0 = v4_3;
                                    if ((48 > v6_1) || (v6_1 >= 58)) {
                                        boolean v4_2 = v8;
                                        if (v5_1 != p26.length()) {
                                            if ((v2_30 == 43) || (v2_30 == 45)) {
                                                String v2_0 = v18_1;
                                            } else {
                                                v2_0 = 0;
                                            }
                                            if (v5_1 != (v23_0 + v2_0)) {
                                                int v7_1 = v20_0;
                                                int v23_1;
                                                if (p26.charAt(v5_1) != 46) {
                                                    v23_1 = v4_2;
                                                } else {
                                                    String v2_6 = (v5_1 + 1);
                                                    int v3_4 = Math.min((v5_1 + 7), p26.length());
                                                    int v5_3 = v2_6;
                                                    long v14_0 = 0;
                                                    while (v5_3 < v3_4) {
                                                        int v15_0 = p26.charAt(v5_3);
                                                        if ((48 > v15_0) || (v15_0 >= 58)) {
                                                            break;
                                                        }
                                                        v14_0 = ((v15_0 - 48) + ((v14_0 << 3) + (v14_0 << 1)));
                                                        v5_3++;
                                                    }
                                                    int v6_13 = 0;
                                                    while (v6_13 < (6 - (v5_3 - v2_6))) {
                                                        v14_0 = ((v14_0 << 1) + (v14_0 << 3));
                                                        v6_13++;
                                                    }
                                                    int v3_8 = Math.min((v5_3 + 9), p26.length());
                                                    int v6_15 = v5_3;
                                                    int v15_1 = 0;
                                                    while (v6_15 < v3_8) {
                                                        long v21_0 = v3_8;
                                                        int v3_9 = p26.charAt(v6_15);
                                                        v23_1 = v4_2;
                                                        if ((48 <= v3_9) && (v3_9 < 58)) {
                                                            v15_1 = ((v3_9 - 48) + ((v15_1 << 3) + (v15_1 << 1)));
                                                            v6_15++;
                                                            v3_8 = v21_0;
                                                            v4_2 = v23_1;
                                                        }
                                                        boolean v4_7 = 0;
                                                        while (v4_7 < (9 - (v6_15 - v5_3))) {
                                                            v15_1 = ((v15_1 << 1) + (v15_1 << 3));
                                                            v4_7++;
                                                        }
                                                        v5_1 = v6_15;
                                                        while (v5_1 < p26.length()) {
                                                            int v3_13 = p26.charAt(v5_1);
                                                            if ((48 > v3_13) || (v3_13 >= 58)) {
                                                                break;
                                                            }
                                                            v5_1++;
                                                        }
                                                        if ((v5_1 == v2_6) || ((v5_1 == p26.length()) || (p26.charAt(v5_1) != 83))) {
                                                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("");
                                                            return 0;
                                                        } else {
                                                            String v2_16;
                                                            long v21_2;
                                                            long v14_2 = ((long) v9_3);
                                                            boolean v4_10 = kotlin.time.DurationUnit.j;
                                                            switch (v4_10.ordinal()) {
                                                                case 0:
                                                                    v21_2 = 4382569440205035030;
                                                                    String v2_14 = (((double) ((((long) 1000000000) * ((long) v14_0)) + ((long) v15_1))) * v21_2);
                                                                    if (Double.isNaN(v2_14)) {
                                                                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Cannot round NaN value.");
                                                                        v2_16 = 0;
                                                                    } else {
                                                                        v2_16 = Math.round(v2_14);
                                                                    }
                                                                case 1:
                                                                    v21_2 = 4427486594234968593;
                                                                    break;
                                                                case 2:
                                                                    v21_2 = 4472406533629990549;
                                                                    break;
                                                                case 3:
                                                                    v21_2 = 4517329193108106637;
                                                                    break;
                                                                case 4:
                                                                    v21_2 = 4543979261917470057;
                                                                    break;
                                                                case 5:
                                                                    v21_2 = 4570447457359481746;
                                                                    break;
                                                                case 6:
                                                                    v21_2 = 4590890196788041902;
                                                                    break;
                                                                default:
                                                                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(v4_10, "Unknown unit: ");
                                                            }
                                                            v14_3 = (v2_16 * v14_2);
                                                        }
                                                    }
                                                    v23_1 = v4_2;
                                                }
                                                String v2_20;
                                                String v2_19 = p26.charAt(v5_1);
                                                if (v2_19 == 68) {
                                                    v2_20 = kotlin.time.DurationUnit.m;
                                                } else {
                                                    if (v2_19 == 72) {
                                                        v2_20 = kotlin.time.DurationUnit.l;
                                                    } else {
                                                        if (v2_19 == 77) {
                                                            v2_20 = kotlin.time.DurationUnit.k;
                                                        } else {
                                                            if (v2_19 == 83) {
                                                                v2_20 = kotlin.time.DurationUnit.j;
                                                            } else {
                                                                v2_20 = 0;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (v2_20 == null) {
                                                    String v0_2 = p26.charAt(v5_1);
                                                    kotlin.time.DurationUnit v1_2 = new StringBuilder("Unknown duration unit short name: ");
                                                    v1_2.append(v0_2);
                                                    throw new IllegalArgumentException(v1_2.toString());
                                                } else {
                                                    if ((v1_8 != null) && (v1_8.compareTo(v2_20) <= 0)) {
                                                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Unexpected order of duration components");
                                                        return 0;
                                                    } else {
                                                        if (v2_20 != kotlin.time.DurationUnit.m) {
                                                            if (v10_1 == 0) {
                                                                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("");
                                                                return 0;
                                                            } else {
                                                                int v3_20 = jc.g.b(v12, (t6.a.d(v7_1, v2_20) * ((long) v9_3)));
                                                                if (v3_20 == 9223372036854759646) {
                                                                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("");
                                                                    return 0;
                                                                } else {
                                                                    v12 = v3_20;
                                                                }
                                                            }
                                                        } else {
                                                            if (v10_1 != 0) {
                                                                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("");
                                                                return 0;
                                                            } else {
                                                                v12 = (t6.a.d(v7_1, v2_20) * ((long) v9_3));
                                                            }
                                                        }
                                                        v4_3 = (v5_1 + 1);
                                                        v1_8 = v2_20;
                                                        v5_0 = v18_1;
                                                        v8 = v23_1;
                                                        v6_3 = 45;
                                                        v7_2 = 43;
                                                    }
                                                }
                                            }
                                        }
                                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("");
                                        return 0;
                                    } else {
                                        int v6_4 = (v6_1 - 48);
                                        v4_2 = v8;
                                        int v7_4 = v20_0 cmp v3_25.c;
                                        if ((v7_4 <= 0) && ((v7_4 != 0) || (((long) v6_4) <= v3_25.d))) {
                                            v20_0 = (((v20_0 << 3) + (v20_0 << v18_1)) + ((long) v6_4));
                                            v5_1++;
                                            v8 = v4_2;
                                            v4_3 = v23_0;
                                        }
                                        while (v5_1 < p26.length()) {
                                            int v6_7 = p26.charAt(v5_1);
                                            if ((48 > v6_7) || (v6_7 >= 58)) {
                                                break;
                                            }
                                            v5_1++;
                                        }
                                        if (v5_1 != p26.length()) {
                                            if ((v2_30 == 43) || (v2_30 == 45)) {
                                                String v2_2 = v18_1;
                                            } else {
                                                v2_2 = 0;
                                            }
                                            if (v5_1 != (v23_0 + v2_2)) {
                                                v7_1 = v3_25.a;
                                                int v6 = 43;
                                            }
                                        }
                                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("");
                                        return 0;
                                    }
                                }
                                v23_0 = v4_3;
                            } else {
                                if (v10_1 == 0) {
                                    v4_3++;
                                    if (v4_3 != p26.length()) {
                                        v10_1 = v5_0;
                                    }
                                }
                                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("");
                                return 0;
                            }
                        }
                        int v18_0 = v5_0;
                        int v23_2 = v8;
                        String v0_8 = eb.a.f(jc.g.w(v12, kotlin.time.DurationUnit.i), jc.g.w(v14_3, kotlin.time.DurationUnit.h));
                        if (v23_2 == 0) {
                            return v0_8;
                        } else {
                            if (v0_8 != eb.a.k) {
                                return (((- (v0_8 >> v18_0)) << v18_0) + ((long) (((int) v0_8) & 1)));
                            } else {
                                return v0_8;
                            }
                        }
                    }
                }
            }
        }
    }

    public static int o(android.content.Context p1, int p2, int p3)
    {
        int v1_2 = com.bumptech.glide.f.C(p1.getTheme(), p2);
        if ((v1_2 == 0) || (v1_2.type != 16)) {
            return p3;
        } else {
            return v1_2.data;
        }
    }

    public static android.animation.TimeInterpolator p(android.content.Context p5, int p6, android.animation.TimeInterpolator p7)
    {
        i0.e[] v0_1 = new android.util.TypedValue();
        if (p5.getTheme().resolveAttribute(p6, v0_1, 1)) {
            if (v0_1.type != 3) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
                return 0;
            } else {
                RuntimeException v6_2 = String.valueOf(v0_1.string);
                if ((!jc.g.m(v6_2, "cubic-bezier")) && (!jc.g.m(v6_2, "path"))) {
                    return android.view.animation.AnimationUtils.loadInterpolator(p5, v0_1.resourceId);
                } else {
                    if (!jc.g.m(v6_2, "cubic-bezier")) {
                        if (!jc.g.m(v6_2, "path")) {
                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Invalid motion easing type: ".concat(v6_2));
                            return 0;
                        } else {
                            int v5_11 = v6_2.substring(5, (v6_2.length() - 1));
                            String v7_3 = new android.graphics.Path();
                            try {
                                i0.e.b(com.bumptech.glide.i.g(v5_11), v7_3);
                                return new android.view.animation.PathInterpolator(v7_3);
                            } catch (RuntimeException v6_6) {
                                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.l("Error in parsing ".concat(v5_11), v6_6);
                                return 0;
                            }
                        }
                    } else {
                        int v5_17 = v6_2.substring(13, (v6_2.length() - 1)).split(",");
                        if (v5_17.length != 4) {
                            androidx.fragment.app.a.c(v5_17.length, "Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: ");
                            return 0;
                        } else {
                            return new android.view.animation.PathInterpolator(jc.g.j(v5_17, 0), jc.g.j(v5_17, 1), jc.g.j(v5_17, 2), jc.g.j(v5_17, 3));
                        }
                    }
                }
            }
        } else {
            return p7;
        }
    }

    public static d1.g q(android.content.Context p7)
    {
        android.content.res.TypedArray v7_1;
        IllegalArgumentException v0_9 = com.bumptech.glide.f.C(p7.getTheme(), 2130969560);
        double v2_5 = o4.a.p;
        if (v0_9 != null) {
            v7_1 = p7.obtainStyledAttributes(v0_9.resourceId, v2_5);
        } else {
            v7_1 = p7.obtainStyledAttributes(0, v2_5, 0, 2132017491);
        }
        IllegalArgumentException v0_3 = new d1.g();
        float v3_2 = v7_1.getFloat(1, 1);
        if (v3_2 == 1) {
            throw new IllegalArgumentException("A MaterialSpring style must have stiffness value.");
        } else {
            float v4_1 = v7_1.getFloat(0, 1);
            if (v4_1 == 1) {
                throw new IllegalArgumentException("A MaterialSpring style must have a damping value.");
            } else {
                if (v3_2 <= 0) {
                    throw new IllegalArgumentException("Spring stiffness constant must be positive.");
                } else {
                    v0_3.a = Math.sqrt(((double) v3_2));
                    v0_3.c = 0;
                    if (v4_1 < 0) {
                        throw new IllegalArgumentException("Damping ratio must be non-negative");
                    } else {
                        v0_3.b = ((double) v4_1);
                        v0_3.c = 0;
                        v7_1.recycle();
                        return v0_3;
                    }
                }
            }
        }
    }

    public static final android.content.Context r(android.content.Context p4)
    {
        java.util.Locale v0_1;
        java.util.Locale v0_0 = xc.a.c;
        boolean v1_3 = v0_0.hashCode();
        if (v1_3 == -1416016784) {
            if (v0_0.equals("mni-Mtei")) {
                v0_1 = new java.util.Locale("mni");
            } else {
                v0_1 = new java.util.Locale(v0_0);
            }
        } else {
            if (v1_3 == 3355) {
                if (v0_0.equals("id")) {
                    v0_1 = new java.util.Locale("in");
                }
            } else {
                if (v1_3 == 3405) {
                    if (v0_0.equals("jw")) {
                        v0_1 = new java.util.Locale("in");
                    }
                } else {
                    if (v1_3 == 3856) {
                        if (v0_0.equals("yi")) {
                            v0_1 = new java.util.Locale("ji");
                        }
                    } else {
                        if (v1_3 == 115813226) {
                            if (v0_0.equals("zh-CN")) {
                                v0_1 = java.util.Locale.SIMPLIFIED_CHINESE;
                            }
                        } else {
                            if ((v1_3 == 115813762) && (v0_0.equals("zh-TW"))) {
                                v0_1 = java.util.Locale.TRADITIONAL_CHINESE;
                            }
                        }
                    }
                }
            }
        }
        java.util.Locale.setDefault(v0_1);
        boolean v1_17 = p4.getResources().getConfiguration();
        v1_17.setLocale(v0_1);
        v1_17.setLayoutDirection(v0_1);
        android.content.Context v4_1 = p4.createConfigurationContext(v1_17);
        v4_1.getClass();
        return v4_1;
    }

    public static void s(android.view.View p2, n5.j p3)
    {
        float v0_1 = p3.h.b;
        if ((v0_1 != 0) && (v0_1.a)) {
            n5.h v2_2 = p2.getParent();
            float v0_2 = 0;
            while ((v2_2 instanceof android.view.View)) {
                v0_2 += ((android.view.View) v2_2).getElevation();
                v2_2 = v2_2.getParent();
            }
            n5.h v2_1 = p3.h;
            if (v2_1.l != v0_2) {
                v2_1.l = v0_2;
                p3.v();
            }
        }
        return;
    }

    public static final long v(int p2, kotlin.time.DurationUnit p3)
    {
        if (p3.compareTo(kotlin.time.DurationUnit.j) > 0) {
            return jc.g.w(((long) p2), p3);
        } else {
            return (java.util.concurrent.TimeUnit.NANOSECONDS.convert(((long) p2), p3.g) << 1);
        }
    }

    public static final long w(long p7, kotlin.time.DurationUnit p9)
    {
        long v0_0 = p9.g;
        long v3_1 = java.util.concurrent.TimeUnit.NANOSECONDS;
        long v1_4 = v0_0.convert(4611686018426999999, v3_1);
        if (((- v1_4) > p7) || (p7 > v1_4)) {
            if (p9.compareTo(kotlin.time.DurationUnit.i) < 0) {
                return jc.g.h(com.bumptech.glide.d.e(java.util.concurrent.TimeUnit.MILLISECONDS.convert(p7, v0_0), -4611686018427387903, 4611686018427387903));
            } else {
                long v0_2 = ((long) Long.signum(p7));
                if (p7 < -9223372036854775807) {
                    p7 = -9223372036854775807;
                }
                return jc.g.h((t6.a.d(Math.abs(p7), p9) * v0_2));
            }
        } else {
            return (v3_1.convert(p7, v0_0) << 1);
        }
    }

    public int hashCode()
    {
        switch (this.a) {
            case 9:
                return this.toString().hashCode();
            default:
                return super.hashCode();
        }
    }

    public float k(android.view.View p2)
    {
        if (jc.g.b) {
            try {
                p2 = l2.e0.a(p2);
                return p2;
            } catch (NoSuchMethodError) {
                jc.g.b = 0;
            }
        }
        return p2.getAlpha();
    }

    public abstract float l(Object p0);

    public void t(android.view.View p2, float p3)
    {
        if (jc.g.b) {
            try {
                l2.e0.b(p2, p3);
                return;
            } catch (NoSuchMethodError) {
                jc.g.b = 0;
            }
        }
        p2.setAlpha(p3);
        return;
    }

    public String toString()
    {
        switch (this.a) {
            case 9:
                String v0_4 = kotlin.jvm.internal.h.a(this.getClass()).c();
                v0_4.getClass();
                return v0_4;
            default:
                return super.toString();
        }
    }

    public abstract void u(n5.j p0, float p1);
}
