// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package okio;
public final class SegmentedByteString extends okio.ByteString {
    public final transient byte[][] k;
    public final transient int[] l;

    public SegmentedByteString(byte[][] p2, int[] p3)
    {
        super(okio.ByteString.j.g);
        super.k = p2;
        super.l = p3;
        return;
    }

    private final Object writeReplace()
    {
        return this.v();
    }

    public final String a()
    {
        throw 0;
    }

    public final void c(int p12, byte[] p13, int p14, int p15)
    {
        p13.getClass();
        oc.b.c(((long) this.e()), ((long) p12), ((long) p15));
        oc.b.c(((long) p13.length), ((long) p14), ((long) p15));
        int v15_1 = (p15 + p12);
        int v0_0 = pc.b.g(this, p12);
        while (p12 < v15_1) {
            int v2_1;
            byte[] v1_0 = this.l;
            if (v0_0 != 0) {
                v2_1 = v1_0[(v0_0 - 1)];
            } else {
                v2_1 = 0;
            }
            int v4_0 = this.k;
            byte[] v1_1 = v1_0[(v4_0.length + v0_0)];
            int v3_4 = (Math.min(v15_1, ((v1_0[v0_0] - v2_1) + v2_1)) - p12);
            int v2_3 = ((p12 - v2_1) + v1_1);
            ha.i.J(v4_0[v0_0], p14, p13, v2_3, (v2_3 + v3_4));
            p14 += v3_4;
            p12 += v3_4;
            v0_0++;
        }
        return;
    }

    public final okio.ByteString d(String p8)
    {
        byte[] v8_1 = java.security.MessageDigest.getInstance(p8);
        okio.ByteString v0_1 = this.k;
        int v1 = v0_1.length;
        int v2 = 0;
        int v3_1 = 0;
        while (v2 < v1) {
            int v5_0 = this.l;
            int v5_1 = v5_0[v2];
            v8_1.update(v0_1[v2], v5_0[(v1 + v2)], (v5_1 - v3_1));
            v2++;
            v3_1 = v5_1;
        }
        byte[] v8_2 = v8_1.digest();
        v8_2.getClass();
        return new okio.ByteString(v8_2);
    }

    public final int e()
    {
        return this.l[(this.k.length - 1)];
    }

    public final boolean equals(Object p4)
    {
        if ((p4 != this) && ((!(p4 instanceof okio.ByteString)) || ((((okio.ByteString) p4).e() != this.e()) || (!this.m(0, ((okio.ByteString) p4), this.e()))))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final String f()
    {
        return this.v().f();
    }

    public final int g(int p2, byte[] p3)
    {
        p3.getClass();
        return this.v().g(p2, p3);
    }

    public final int hashCode()
    {
        byte[][] v0_0 = this.h;
        if (v0_0 == null) {
            byte[][] v0_1 = this.k;
            int v1 = v0_1.length;
            int v2 = 0;
            int v4_1 = 1;
            int v3_2 = 0;
            while (v2 < v1) {
                int v6_0 = this.l;
                int v5_1 = v6_0[(v1 + v2)];
                int v6_1 = v6_0[v2];
                int v3_1 = ((v6_1 - v3_2) + v5_1);
                while (v5_1 < v3_1) {
                    v4_1 = ((v4_1 * 31) + v0_1[v2][v5_1]);
                    v5_1++;
                }
                v2++;
                v3_2 = v6_1;
            }
            this.h = v4_1;
            return v4_1;
        } else {
            return v0_0;
        }
    }

    public final byte[] i()
    {
        return this.s();
    }

    public final byte j(int p10)
    {
        int v3_1;
        byte[] v0_0 = this.k;
        int v2_1 = this.l;
        oc.b.c(((long) v2_1[(v0_0.length - 1)]), ((long) p10), 1);
        int v1_1 = pc.b.g(this, p10);
        if (v1_1 != 0) {
            v3_1 = v2_1[(v1_1 - 1)];
        } else {
            v3_1 = 0;
        }
        return v0_0[v1_1][((p10 - v3_1) + v2_1[(v0_0.length + v1_1)])];
    }

    public final int k(byte[] p2)
    {
        p2.getClass();
        return this.v().k(p2);
    }

    public final boolean m(int p9, okio.ByteString p10, int p11)
    {
        p10.getClass();
        if ((p9 >= 0) && (p9 <= (this.e() - p11))) {
            int v11_1 = (p11 + p9);
            int v1_0 = pc.b.g(this, p9);
            int v2 = 0;
            while (p9 < v11_1) {
                int v4_1;
                boolean v3_0 = this.l;
                if (v1_0 != 0) {
                    v4_1 = v3_0[(v1_0 - 1)];
                } else {
                    v4_1 = 0;
                }
                byte[][] v6 = this.k;
                boolean v3_1 = v3_0[(v6.length + v1_0)];
                int v5_4 = (Math.min(v11_1, ((v3_0[v1_0] - v4_1) + v4_1)) - p9);
                if (p10.n(v2, v6[v1_0], ((p9 - v4_1) + v3_1), v5_4)) {
                    v2 += v5_4;
                    p9 += v5_4;
                    v1_0++;
                }
            }
            return 1;
        }
        return 0;
    }

    public final boolean n(int p8, byte[] p9, int p10, int p11)
    {
        p9.getClass();
        if ((p8 >= 0) && ((p8 <= (this.e() - p11)) && ((p10 >= 0) && (p10 <= (p9.length - p11))))) {
            int v11_1 = (p11 + p8);
            int v1_0 = pc.b.g(this, p8);
            while (p8 < v11_1) {
                int v3_1;
                boolean v2_0 = this.l;
                if (v1_0 != 0) {
                    v3_1 = v2_0[(v1_0 - 1)];
                } else {
                    v3_1 = 0;
                }
                byte[][] v5 = this.k;
                boolean v2_1 = v2_0[(v5.length + v1_0)];
                int v4_4 = (Math.min(v11_1, ((v2_0[v1_0] - v3_1) + v3_1)) - p8);
                if (oc.b.a(v5[v1_0], ((p8 - v3_1) + v2_1), p9, p10, v4_4)) {
                    p10 += v4_4;
                    p8 += v4_4;
                    v1_0++;
                } else {
                    return 0;
                }
            }
            return 1;
        } else {
            return 0;
        }
    }

    public final String o(java.nio.charset.Charset p2)
    {
        p2.getClass();
        return this.v().o(p2);
    }

    public final okio.ByteString p(int p12, int p13)
    {
        if (p13 == -1234567890) {
            p13 = this.e();
        }
        if (p12 < null) {
            oc.l.d(r1.a.h(p12, "beginIndex=", " < 0"));
            return 0;
        } else {
            if (p13 > this.e()) {
                okio.SegmentedByteString v12_3 = r1.a.v(p13, "endIndex=", " > length(");
                v12_3.append(this.e());
                v12_3.append(41);
                throw new IllegalArgumentException(v12_3.toString().toString());
            } else {
                int v0_2 = (p13 - p12);
                if (v0_2 < 0) {
                    oc.l.d(r1.a.l("endIndex=", " < beginIndex=", p13, p12));
                    return 0;
                } else {
                    if ((p12 != null) || (p13 != this.e())) {
                        if (p12 != p13) {
                            int v1_2 = pc.b.g(this, p12);
                            int v13_6 = pc.b.g(this, (p13 - 1));
                            byte[][] v3 = this.k;
                            byte[][] v2_2 = ((byte[][]) ha.i.M(v3, v1_2, (v13_6 + 1)));
                            int[] v4_2 = new int[(v2_2.length * 2)];
                            int v5 = 0;
                            int[] v6 = this.l;
                            if (v1_2 <= v13_6) {
                                int v8 = v1_2;
                                int v7_0 = 0;
                                while(true) {
                                    v4_2[v7_0] = Math.min((v6[v8] - p12), v0_2);
                                    int v9_3 = (v7_0 + 1);
                                    v4_2[(v7_0 + v2_2.length)] = v6[(v3.length + v8)];
                                    if (v8 == v13_6) {
                                        break;
                                    }
                                    v8++;
                                    v7_0 = v9_3;
                                }
                            }
                            if (v1_2 != 0) {
                                v5 = v6[(v1_2 - 1)];
                            }
                            int v13_8 = v2_2.length;
                            v4_2[v13_8] = ((p12 - v5) + v4_2[v13_8]);
                            return new okio.SegmentedByteString(v2_2, v4_2);
                        } else {
                            return okio.ByteString.j;
                        }
                    } else {
                        return this;
                    }
                }
            }
        }
    }

    public final okio.ByteString r()
    {
        return this.v().r();
    }

    public final byte[] s()
    {
        byte[] v0_1 = new byte[this.e()];
        byte[][] v1 = this.k;
        int v2 = v1.length;
        int v3 = 0;
        int v4_1 = 0;
        int v5 = 0;
        while (v3 < v2) {
            int v7_0 = this.l;
            int v6_1 = v7_0[(v2 + v3)];
            int v7_1 = v7_0[v3];
            int v4_0 = (v7_1 - v4_1);
            ha.i.J(v1[v3], v5, v0_1, v6_1, (v6_1 + v4_0));
            v5 += v4_0;
            v3++;
            v4_1 = v7_1;
        }
        return v0_1;
    }

    public final String toString()
    {
        return this.v().toString();
    }

    public final void u(oc.i p10, int p11)
    {
        int v1 = pc.b.g(this, 0);
        int v2_0 = 0;
        while (v2_0 < p11) {
            int v4_1;
            oc.z v3_0 = this.l;
            if (v1 != 0) {
                v4_1 = v3_0[(v1 - 1)];
            } else {
                v4_1 = 0;
            }
            oc.z v6_0 = this.k;
            oc.z v3_1 = v3_0[(v6_0.length + v1)];
            int v5_4 = (Math.min(p11, ((v3_0[v1] - v4_1) + v4_1)) - v2_0);
            int v4_3 = ((v2_0 - v4_1) + v3_1);
            oc.z v6_2 = new oc.z(v6_0[v1], v4_3, (v4_3 + v5_4), 1);
            oc.z v3_3 = p10.g;
            if (v3_3 != null) {
                oc.z v3_4 = v3_3.g;
                v3_4.getClass();
                v3_4.b(v6_2);
            } else {
                v6_2.g = v6_2;
                v6_2.f = v6_2;
                p10.g = v6_2;
            }
            v2_0 += v5_4;
            v1++;
        }
        p10.h = (p10.h + ((long) p11));
        return;
    }

    public final okio.ByteString v()
    {
        return new okio.ByteString(this.s());
    }
}
