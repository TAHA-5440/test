// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package pc;
public abstract class b {
    public static final char[] a;

    static b()
    {
        char[] v0_1 = new char[16];
        v0_1 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
        pc.b.a = v0_1;
        return;
    }

    public static final int a(char p2)
    {
        if ((48 > p2) || (p2 >= 58)) {
            if ((97 > p2) || (p2 >= 103)) {
                if ((65 > p2) || (p2 >= 71)) {
                    oc.l.c(p2, "Unexpected hex digit: ");
                    return 0;
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

    public static final java.util.LinkedHashMap b(java.util.ArrayList p22)
    {
        pc.k v2_3 = ea.c.u("/");
        java.util.Iterator v0_3 = new kotlin.Pair[] {new kotlin.Pair(v2_3, new pc.k(v2_3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 65532))});
        java.util.LinkedHashMap v1_2 = new java.util.LinkedHashMap(kotlin.collections.a.I(1));
        java.util.Iterator v0_4 = v0_3[0];
        v1_2.put(v0_4.g, v0_4.h);
        java.util.Iterator v0_9 = ha.j.R(p22, new b2.b(8)).iterator();
        while (v0_9.hasNext()) {
            pc.k v2_9 = ((pc.k) v0_9.next());
            if (((pc.k) v1_2.put(v2_9.a, v2_9)) == null) {
            }
            while(true) {
                pc.k v2_10 = v2_9.a;
                java.util.ArrayList v4_0 = v2_10.b();
                if (v4_0 == null) {
                    break;
                }
                pc.k v3_4 = ((pc.k) v1_2.get(v4_0));
                if (v3_4 == null) {
                    pc.k v3_7 = new pc.k(v4_0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 65532);
                    v1_2.put(v4_0, v3_7);
                    v3_7.q.add(v2_10);
                    v2_9 = v3_7;
                } else {
                    v3_4.q.add(v2_10);
                    break;
                }
            }
        }
        return v1_2;
    }

    public static final String c(int p1)
    {
        a.a.c(16);
        String v1_1 = Integer.toString(p1, 16);
        v1_1.getClass();
        return "0x".concat(v1_1);
    }

    public static final pc.k d(oc.y p31)
    {
        String v0_11 = p31.B();
        if (v0_11 != 33639248) {
            long v1_8 = pc.b.c(33639248);
            String v0_27 = pc.b.c(v0_11);
            long v3_1 = new StringBuilder("bad zip: expected ");
            v3_1.append(v1_8);
            v3_1.append(" but was ");
            v3_1.append(v0_27);
            throw new java.io.IOException(v3_1.toString());
        } else {
            p31.skip(4);
            String v0_13 = p31.M();
            if ((v0_13 & 1) != 0) {
                oc.l.g("unsupported zip: general purpose bit flag=".concat(pc.b.c((v0_13 & 65535))));
                return 0;
            } else {
                int v22 = (p31.M() & 65535);
                int v26 = (p31.M() & 65535);
                int v25 = (p31.M() & 65535);
                long v16 = (((long) p31.B()) & 4294967295);
                kotlin.jvm.internal.Ref$LongRef v6_2 = new kotlin.jvm.internal.Ref$LongRef();
                v6_2.g = (((long) p31.B()) & 4294967295);
                kotlin.jvm.internal.Ref$LongRef v4_2 = new kotlin.jvm.internal.Ref$LongRef();
                v4_2.g = (((long) p31.B()) & 4294967295);
                String v0_24 = (p31.M() & 65535);
                pc.k v12_2 = (p31.M() & 65535);
                oc.w v13_1 = (p31.M() & 65535);
                p31.skip(8);
                Object v7_11 = new kotlin.jvm.internal.Ref$LongRef();
                v7_11.g = (((long) p31.B()) & 4294967295);
                boolean v14_1 = p31.Z(((long) v0_24));
                if (db.i.U(v14_1, 0)) {
                    oc.l.g("bad zip: filename contains 0x00");
                    return 0;
                } else {
                    kotlin.jvm.internal.Ref$ObjectRef v8_0;
                    if (v4_2.g != 4294967295) {
                        v8_0 = 0;
                    } else {
                        v8_0 = ((long) 8);
                    }
                    if (v6_2.g == 4294967295) {
                        v8_0 += ((long) 8);
                    }
                    if (v7_11.g == 4294967295) {
                        v8_0 += ((long) 8);
                    }
                    oc.w v2_3 = v8_0;
                    kotlin.jvm.internal.Ref$ObjectRef v8_2 = new kotlin.jvm.internal.Ref$ObjectRef();
                    kotlin.jvm.internal.Ref$ObjectRef v9_1 = new kotlin.jvm.internal.Ref$ObjectRef();
                    kotlin.jvm.internal.Ref$ObjectRef v10_1 = new kotlin.jvm.internal.Ref$ObjectRef();
                    long v1_1 = new kotlin.jvm.internal.Ref$BooleanRef();
                    pc.b.e(p31, v12_2, new pc.m(v1_1, v2_3, v4_2, p31, v6_2, v7_11, v8_2, v9_1, v10_1));
                    if ((v2_3 > 0) && (!v1_1.g)) {
                        oc.l.g("bad zip: zip64 extra required but absent");
                        return 0;
                    } else {
                        return new pc.k(ea.c.u("/").d(v14_1), db.p.K(v14_1, "/", 0), p31.Z(((long) v13_1)), v16, v6_2.g, v4_2.g, v22, v7_11.g, v25, v26, ((Long) v8_2.g), ((Long) v9_1.g), ((Long) v10_1.g), 57344);
                    }
                }
            }
        }
    }

    public static final void e(oc.y p11, int p12, ua.p p13)
    {
        oc.i v0 = p11.h;
        long v1_0 = ((long) p12);
        while (v1_0 != 0) {
            if (v1_0 < 4) {
                oc.l.g("bad zip: truncated header in extra field");
                break;
            } else {
                int v12_2 = (p11.M() & 65535);
                long v5_3 = (((long) p11.M()) & 65535);
                long v1_1 = (v1_0 - ((long) 4));
                if (v1_1 < v5_3) {
                    oc.l.g("bad zip: truncated value in extra field");
                    return;
                } else {
                    p11.W(v5_3);
                    long v7_4 = v0.h;
                    p13.invoke(Integer.valueOf(v12_2), Long.valueOf(v5_3));
                    long v9_3 = ((v0.h + v5_3) - v7_4);
                    long v3_1 = v9_3 cmp 0;
                    if (v3_1 < 0) {
                        oc.l.g(r1.a.g(v12_2, "unsupported zip: too many bytes processed for "));
                        return;
                    } else {
                        if (v3_1 > 0) {
                            v0.skip(v9_3);
                        }
                        v1_0 = (v1_1 - v5_3);
                    }
                }
            }
        }
        return;
    }

    public static final pc.k f(oc.y p27, pc.k p28)
    {
        long v2_4 = p27.B();
        if (v2_4 != 67324752) {
            Long v1_4 = pc.b.c(67324752);
            long v2_0 = pc.b.c(v2_4);
            kotlin.jvm.internal.Ref$ObjectRef v3_1 = new StringBuilder("bad zip: expected ");
            v3_1.append(v1_4);
            v3_1.append(" but was ");
            v3_1.append(v2_0);
            throw new java.io.IOException(v3_1.toString());
        } else {
            p27.skip(2);
            long v2_2 = p27.M();
            if ((v2_2 & 1) != 0) {
                oc.l.g("unsupported zip: general purpose bit flag=".concat(pc.b.c((v2_2 & 65535))));
            } else {
                p27.skip(18);
                int v4_4 = (((long) p27.M()) & 65535);
                long v2_7 = (p27.M() & 65535);
                p27.skip(v4_4);
                if (p28 != null) {
                    kotlin.jvm.internal.Ref$ObjectRef v3_5 = new kotlin.jvm.internal.Ref$ObjectRef();
                    int v4_6 = new kotlin.jvm.internal.Ref$ObjectRef();
                    int v5_1 = new kotlin.jvm.internal.Ref$ObjectRef();
                    pc.b.e(p27, v2_7, new pc.l(p27, v3_5, v4_6, v5_1));
                    return new pc.k(p28.a, p28.b, p28.c, p28.d, p28.e, p28.f, p28.g, p28.h, p28.i, p28.j, p28.k, p28.l, p28.m, ((Integer) v3_5.g), ((Integer) v4_6.g), ((Integer) v5_1.g));
                } else {
                    p27.skip(((long) v2_7));
                }
            }
            return 0;
        }
    }

    public static final int g(okio.SegmentedByteString p4, int p5)
    {
        int[] v0 = p4.l;
        int v5_1 = (p5 + 1);
        int v4_4 = p4.k.length;
        v0.getClass();
        int v4_2 = (v4_4 - 1);
        int v1 = 0;
        while (v1 <= v4_2) {
            int v2_1 = ((v1 + v4_2) >> 1);
            int v3 = v0[v2_1];
            if (v3 >= v5_1) {
                if (v3 > v5_1) {
                    v4_2 = (v2_1 - 1);
                }
            } else {
                v1 = (v2_1 + 1);
            }
            if (v2_1 < 0) {
                return (~ v2_1);
            } else {
                return v2_1;
            }
        }
        v2_1 = ((- v1) - 1);
    }
}
