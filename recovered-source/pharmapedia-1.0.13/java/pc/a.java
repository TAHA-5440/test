// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package pc;
public abstract class a {
    public static final byte[] a;
    public static final long[] b;

    static a()
    {
        long[] v0_1 = "0123456789abcdef".getBytes(db.a.a);
        v0_1.getClass();
        pc.a.a = v0_1;
        long[] v0_3 = new long[20];
        v0_3 = {nan, 4.4e-323, 4.9e-322, 4.936e-321, 4.94e-320, 4.9406e-319, 4.94065e-318, 4.940656e-317, 4.9406564e-316, 4.940656453e-315, 4.940656458e-314, 4.94065645836e-313, 4.940656458408e-312, 4.940656458412e-311, 4.9406564584124e-310, 4.94065645841246e-309, 5.431165199810527e-308, 5.620395787888204e-302, 7.832953389245684e-242, nan};
        pc.a.b = v0_3;
        return;
    }

    public static final long a(oc.i p19, okio.ByteString p20, long p21, long p23, int p25)
    {
        int v1_0 = p21;
        long v3_1 = p23;
        p20.getClass();
        oc.b.c(((long) p20.e()), ((long) 0), ((long) p25));
        if (p25 <= 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("byteCount == 0");
            return 0;
        } else {
            byte[] v7_0 = 0;
            if (p21 < 0) {
                oc.l.d(f0.a.b("fromIndex < 0: ", p21));
                return 0;
            } else {
                if (p21 > p23) {
                    long v0_19 = new StringBuilder("fromIndex > toIndex: ");
                    v0_19.append(p21);
                    v0_19.append(" > ");
                    v0_19.append(p23);
                    throw new IllegalArgumentException(v0_19.toString().toString());
                } else {
                    long v9_0 = p19.h;
                    if (p23 > v9_0) {
                        v3_1 = v9_0;
                    }
                    if (p21 != v3_1) {
                        oc.z v13_0 = p19.g;
                        if (v13_0 != null) {
                            if ((v9_0 - p21) >= p21) {
                                while(true) {
                                    long v9_5 = (((long) (v13_0.c - v13_0.b)) + v7_0);
                                    if (v9_5 > p21) {
                                        break;
                                    }
                                    v13_0 = v13_0.f;
                                    v13_0.getClass();
                                    v7_0 = v9_5;
                                }
                                int v6_11 = p20.i();
                                long v9_6 = v6_11[0];
                                long v17_1 = v7_0;
                                long v3_2 = Math.min(v3_1, ((p19.h - ((long) p25)) + 1));
                                byte[] v7_13 = v17_1;
                                while (v7_13 < v3_2) {
                                    int v1_1 = ((int) ((((long) v13_0.b) + v1_0) - v7_13));
                                    while (v1_1 < ((int) Math.min(((long) v13_0.c), ((((long) v13_0.b) + v3_2) - v7_13)))) {
                                        if ((v13_0.a[v1_1] != v9_6) || (!pc.a.b(v13_0, (v1_1 + 1), v6_11, 1, p25))) {
                                            v1_1++;
                                        } else {
                                            return (((long) (v1_1 - v13_0.b)) + v7_13);
                                        }
                                    }
                                    v7_13 += ((long) (v13_0.c - v13_0.b));
                                    v13_0 = v13_0.f;
                                    v13_0.getClass();
                                    v1_0 = v7_13;
                                }
                                return -1;
                            }
                            while (v9_0 > p21) {
                                v13_0 = v13_0.g;
                                v13_0.getClass();
                                v9_0 -= ((long) (v13_0.c - v13_0.b));
                            }
                            byte[] v7_2 = p20.i();
                            byte v8_0 = v7_2[0];
                            byte[] v20_1 = v7_2;
                            long v3_0 = Math.min(v3_1, ((p19.h - ((long) p25)) + 1));
                            while (v9_0 < v3_0) {
                                int v1_3 = ((int) ((((long) v13_0.b) + v1_0) - v9_0));
                                while (v1_3 < ((int) Math.min(((long) v13_0.c), ((((long) v13_0.b) + v3_0) - v9_0)))) {
                                    byte[] v7_5;
                                    if (v13_0.a[v1_3] != v8_0) {
                                        v7_5 = v20_1;
                                    } else {
                                        v7_5 = v20_1;
                                        if (pc.a.b(v13_0, (v1_3 + 1), v7_5, 1, p25)) {
                                            return (((long) (v1_3 - v13_0.b)) + v9_0);
                                        }
                                    }
                                    v1_3++;
                                    v20_1 = v7_5;
                                }
                                v9_0 += ((long) (v13_0.c - v13_0.b));
                                v13_0 = v13_0.f;
                                v13_0.getClass();
                                v1_0 = v9_0;
                            }
                        }
                    }
                    return -1;
                }
            }
        }
    }

    public static final boolean b(oc.z p5, int p6, byte[] p7, int p8, int p9)
    {
        int v0_0 = p5.c;
        byte[] v1_0 = p5.a;
        while (p8 < p9) {
            if (p6 == v0_0) {
                p5 = p5.f;
                p5.getClass();
                v1_0 = p5.a;
                p6 = p5.b;
                v0_0 = p5.c;
            }
            if (v1_0[p6] == p7[p8]) {
                p6++;
                p8++;
            } else {
                return 0;
            }
        }
        return 1;
    }

    public static final String c(long p6, oc.i p8)
    {
        if (p6 > 0) {
            long v3 = (p6 - 1);
            if (p8.L(v3) == 13) {
                String v6_3 = p8.h0(v3, db.a.a);
                p8.skip(2);
                return v6_3;
            }
        }
        String v6_1 = p8.h0(p6, db.a.a);
        p8.skip(1);
        return v6_1;
    }
}
