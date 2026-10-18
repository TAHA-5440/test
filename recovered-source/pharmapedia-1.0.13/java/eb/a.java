// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package eb;
public final class a implements java.lang.Comparable {
    public static final ea.c h;
    public static final long i;
    public static final long j;
    public static final long k;
    public final long g;

    static a()
    {
        eb.a.h = new ea.c(10);
        eb.a.i = jc.g.h(4611686018427387903);
        eb.a.j = jc.g.h(-4611686018427387903);
        eb.a.k = 9223372036854759646;
        return;
    }

    public synthetic a(long p1)
    {
        this.g = p1;
        return;
    }

    public static final long a(long p6, long p8)
    {
        long v2_1 = (p8 / ((long) 1000000));
        long v6_5 = jc.g.b(p6, v2_1);
        if ((-4611686018426 > v6_5) || (v6_5 >= 4611686018427)) {
            return jc.g.h(v6_5);
        } else {
            return (((v6_5 * ((long) 1000000)) + (p8 - (v2_1 * ((long) 1000000)))) << 1);
        }
    }

    public static final void b(StringBuilder p3, int p4, int p5, int p6, String p7, boolean p8)
    {
        p3.append(p4);
        if (p5 != 0) {
            p3.append(46);
            String v4_3 = db.i.e0(p6, String.valueOf(p5));
            int v6_1 = -1;
            int v5_1 = (v4_3.length() + -1);
            if (v5_1 >= 0) {
                while(true) {
                    int v0_0 = (v5_1 - 1);
                    if (v4_3.charAt(v5_1) != 48) {
                        break;
                    }
                    if (v0_0 >= 0) {
                        v5_1 = v0_0;
                    }
                }
                v6_1 = v5_1;
            }
            int v5_2 = (v6_1 + 1);
            if ((p8) || (v5_2 >= 3)) {
                p3.append(v4_3, 0, (((v6_1 + 3) / 3) * 3));
            } else {
                p3.append(v4_3, 0, v5_2);
            }
        }
        p3.append(p7);
        return;
    }

    public static int c(long p5, long p7)
    {
        int v0_0 = (p5 ^ p7);
        if ((v0_0 >= 0) && ((((int) v0_0) & 1) != 0)) {
            int v0_1 = ((((int) p5) & 1) - (((int) p7) & 1));
            if (p5 >= 0) {
                return v0_1;
            } else {
                return (- v0_1);
            }
        } else {
            return kotlin.jvm.internal.f.d(p5, p7);
        }
    }

    public static final int d(long p2)
    {
        if (!eb.a.e(p2)) {
            int v2_1;
            if ((((int) p2) & 1) != 1) {
                v2_1 = ((p2 >> 1) % ((long) 1000000000));
            } else {
                v2_1 = (((p2 >> 1) % ((long) 1000)) * ((long) 1000000));
            }
            return ((int) v2_1);
        } else {
            return 0;
        }
    }

    public static final boolean e(long p2)
    {
        if ((p2 != eb.a.i) && (p2 != eb.a.j)) {
            return 0;
        } else {
            return 1;
        }
    }

    public static final long f(long p9, long p11)
    {
        int v0_1 = (((int) p9) & 1);
        if (v0_1 != (((int) p11) & 1)) {
            if (v0_1 != 1) {
                return eb.a.a((p11 >> 1), (p9 >> 1));
            } else {
                return eb.a.a((p9 >> 1), (p11 >> 1));
            }
        } else {
            if (v0_1 != 0) {
                long v3_0 = jc.g.b((p9 >> 1), (p11 >> 1));
                if (v3_0 == 9223372036854759646) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Summing infinite durations of different signs yields an undefined result.");
                    return 0;
                } else {
                    if ((v3_0 != 4611686018427387903) && (v3_0 != -4611686018427387903)) {
                        if ((-4611686018426 > v3_0) || (v3_0 >= 4611686018427)) {
                            return jc.g.h(com.bumptech.glide.d.e(v3_0, -4611686018427387903, 4611686018427387903));
                        } else {
                            return ((v3_0 * ((long) 1000000)) << 1);
                        }
                    } else {
                        return jc.g.h(v3_0);
                    }
                }
            } else {
                long v9_23 = ((p9 >> 1) + (p11 >> 1));
                if ((-4611686018426999999 > v9_23) || (v9_23 >= 4611686018427000000)) {
                    return jc.g.h((v9_23 / ((long) 1000000)));
                } else {
                    return (v9_23 << 1);
                }
            }
        }
    }

    public static final long g(long p3, kotlin.time.DurationUnit p5)
    {
        if (p3 != eb.a.i) {
            if (p3 != eb.a.j) {
                long v3_1;
                if ((((int) p3) & 1) != 0) {
                    v3_1 = kotlin.time.DurationUnit.i;
                } else {
                    v3_1 = kotlin.time.DurationUnit.h;
                }
                return p5.g.convert((p3 >> 1), v3_1.g);
            } else {
                return -9223372036854775808;
            }
        } else {
            return 9223372036854775807;
        }
    }

    public final int compareTo(Object p5)
    {
        return eb.a.c(this.g, ((eb.a) p5).g);
    }

    public final boolean equals(Object p5)
    {
        if (((p5 instanceof eb.a)) && (this.g == ((eb.a) p5).g)) {
            return 1;
        } else {
            return 0;
        }
    }

    public final int hashCode()
    {
        return Long.hashCode(this.g);
    }

    public final String toString()
    {
        String v1_0 = this.g;
        int v5_1 = v1_0 cmp 0;
        if (v5_1 != 0) {
            if (v1_0 != eb.a.i) {
                if (v1_0 != eb.a.j) {
                    int v8;
                    int v6_0 = 0;
                    if (v5_1 >= 0) {
                        v8 = 0;
                    } else {
                        v8 = 1;
                    }
                    StringBuilder v9_1 = new StringBuilder();
                    if (v8 != 0) {
                        v9_1.append(45);
                    }
                    if (v5_1 < 0) {
                        v1_0 = (((long) (((int) v1_0) & 1)) + ((- (v1_0 >> 1)) << 1));
                    }
                    int v5_6;
                    int v10_7 = eb.a.g(v1_0, kotlin.time.DurationUnit.m);
                    if (!eb.a.e(v1_0)) {
                        v5_6 = ((int) (eb.a.g(v1_0, kotlin.time.DurationUnit.l) % ((long) 24)));
                    } else {
                        v5_6 = 0;
                    }
                    int v3_4;
                    int v16;
                    if (!eb.a.e(v1_0)) {
                        v16 = 0;
                        v3_4 = ((int) (eb.a.g(v1_0, kotlin.time.DurationUnit.k) % ((long) 60)));
                    } else {
                        v16 = 0;
                        v3_4 = 0;
                    }
                    int v4_2;
                    if (!eb.a.e(v1_0)) {
                        v4_2 = ((int) (eb.a.g(v1_0, kotlin.time.DurationUnit.j) % ((long) 60)));
                    } else {
                        v4_2 = 0;
                    }
                    int v2_4;
                    String v1_11 = eb.a.d(v1_0);
                    if (v10_7 == v16) {
                        v2_4 = 0;
                    } else {
                        v2_4 = 1;
                    }
                    int v12_8;
                    if (v5_6 == 0) {
                        v12_8 = 0;
                    } else {
                        v12_8 = 1;
                    }
                    String v13_4;
                    if (v3_4 == 0) {
                        v13_4 = 0;
                    } else {
                        v13_4 = 1;
                    }
                    if ((v4_2 == 0) && (v1_11 == null)) {
                        int v14_8 = 0;
                    } else {
                        v14_8 = 1;
                    }
                    if (v2_4 != 0) {
                        v9_1.append(v10_7);
                        v9_1.append(100);
                        v6_0 = 1;
                    }
                    if ((v12_8 != 0) || ((v2_4 != 0) && ((v13_4 != null) || (v14_8 != 0)))) {
                        int v11_3 = (v6_0 + 1);
                        if (v6_0 > 0) {
                            v9_1.append(32);
                        }
                        v9_1.append(v5_6);
                        v9_1.append(104);
                        v6_0 = v11_3;
                    }
                    if ((v13_4 != null) || ((v14_8 != 0) && ((v12_8 != 0) || (v2_4 != 0)))) {
                        int v5_0 = (v6_0 + 1);
                        if (v6_0 > 0) {
                            v9_1.append(32);
                        }
                        v9_1.append(v3_4);
                        v9_1.append(109);
                        v6_0 = v5_0;
                    }
                    if (v14_8 != 0) {
                        int v3_1 = (v6_0 + 1);
                        if (v6_0 > 0) {
                            v9_1.append(32);
                        }
                        if ((v4_2 == 0) && ((v2_4 == 0) && ((v12_8 == 0) && (v13_4 == null)))) {
                            if (v1_11 < 1000000) {
                                if (v1_11 < 1000) {
                                    v9_1.append(v1_11);
                                    v9_1.append("ns");
                                } else {
                                    eb.a.b(v9_1, (v1_11 / 1000), (v1_11 % 1000), 3, "us", 0);
                                }
                            } else {
                                eb.a.b(v9_1, (v1_11 / 1000000), (v1_11 % 1000000), 6, "ms", 0);
                            }
                        } else {
                            eb.a.b(v9_1, v4_2, v1_11, 9, "s", 0);
                        }
                        v6_0 = v3_1;
                    }
                    if ((v8 != 0) && (v6_0 > 1)) {
                        v9_1.insert(1, 40).append(41);
                    }
                    return v9_1.toString();
                } else {
                    return "-Infinity";
                }
            } else {
                return "Infinity";
            }
        } else {
            return "0s";
        }
    }
}
