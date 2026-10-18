// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public final class i implements oc.k, oc.j, java.lang.Cloneable, java.nio.channels.ByteChannel {
    public oc.z g;
    public long h;

    public final boolean B()
    {
        if (this.h != 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final void D(long p9, oc.i p11)
    {
        p11.getClass();
        if (p11 == this) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("source == this");
            return;
        } else {
            oc.b.c(p11.h, 0, p9);
            while (p9 > 0) {
                oc.z v0_1 = p11.g;
                v0_1.getClass();
                oc.z v0_10 = v0_1.c;
                oc.z v1_4 = p11.g;
                v1_4.getClass();
                oc.z v1_1 = 0;
                if (p9 < ((long) (v0_10 - v1_4.b))) {
                    oc.z v0_15;
                    oc.z v0_14 = this.g;
                    if (v0_14 == null) {
                        v0_15 = 0;
                    } else {
                        v0_15 = v0_14.g;
                    }
                    if ((v0_15 != null) && (v0_15.e)) {
                        int v4_1;
                        if (!v0_15.d) {
                            v4_1 = v0_15.b;
                        } else {
                            v4_1 = 0;
                        }
                        if (((((long) v0_15.c) + p9) - ((long) v4_1)) <= 8192) {
                            oc.z v1_3 = p11.g;
                            v1_3.getClass();
                            v1_3.d(v0_15, ((int) p9));
                            p11.h = (p11.h - p9);
                            this.h = (this.h + p9);
                            return;
                        }
                    }
                    oc.z v0_16 = p11.g;
                    v0_16.getClass();
                    if ((((int) p9) <= 0) || (((int) p9) > (v0_16.c - v0_16.b))) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("byteCount out of range");
                        return;
                    } else {
                        oc.z v3_3;
                        if (((int) p9) < 1024) {
                            v3_3 = oc.a0.b();
                            int v6_2 = v0_16.b;
                            ha.i.J(v0_16.a, 0, v3_3.a, v6_2, (v6_2 + ((int) p9)));
                        } else {
                            v3_3 = v0_16.c();
                        }
                        v3_3.c = (v3_3.b + ((int) p9));
                        v0_16.b = (v0_16.b + ((int) p9));
                        oc.z v0_18 = v0_16.g;
                        v0_18.getClass();
                        v0_18.b(v3_3);
                        p11.g = v3_3;
                    }
                }
                oc.z v0_19 = p11.g;
                v0_19.getClass();
                int v2_11 = ((long) (v0_19.c - v0_19.b));
                p11.g = v0_19.a();
                int v4_12 = this.g;
                if (v4_12 != 0) {
                    int v4_13 = v4_12.g;
                    v4_13.getClass();
                    v4_13.b(v0_19);
                    int v4_14 = v0_19.g;
                    if (v4_14 == v0_19) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("cannot compact");
                        break;
                    } else {
                        v4_14.getClass();
                        if (v4_14.e) {
                            int v4_17 = (v0_19.c - v0_19.b);
                            byte[] v5_5 = v0_19.g;
                            v5_5.getClass();
                            byte[] v5_1 = (8192 - v5_5.c);
                            int v6_0 = v0_19.g;
                            v6_0.getClass();
                            if (!v6_0.d) {
                                oc.z v1_0 = v0_19.g;
                                v1_0.getClass();
                                v1_1 = v1_0.b;
                            }
                            if (v4_17 <= (v5_1 + v1_1)) {
                                oc.z v1_2 = v0_19.g;
                                v1_2.getClass();
                                v0_19.d(v1_2, v4_17);
                                v0_19.a();
                                oc.a0.a(v0_19);
                            }
                        }
                    }
                } else {
                    this.g = v0_19;
                    v0_19.g = v0_19;
                    v0_19.f = v0_19;
                }
                p11.h = (p11.h - v2_11);
                this.h = (this.h + v2_11);
                p9 -= v2_11;
            }
            return;
        }
    }

    public final bridge synthetic oc.j G(String p1)
    {
        this.w0(p1);
        return this;
    }

    public final byte L(long p8)
    {
        oc.b.c(this.h, p8, 1);
        byte v8_3 = this.g;
        v8_3.getClass();
        long v0_2 = this.h;
        if ((v0_2 - p8) >= p8) {
            long v0_1 = 0;
            while(true) {
                long v4_1 = v8_3.b;
                long v5_1 = (((long) (v8_3.c - v4_1)) + v0_1);
                if (v5_1 > p8) {
                    break;
                }
                v8_3 = v8_3.f;
                v8_3.getClass();
                v0_1 = v5_1;
            }
            return v8_3.a[((int) ((((long) v4_1) + p8) - v0_1))];
        }
        while (v0_2 > p8) {
            v8_3 = v8_3.g;
            v8_3.getClass();
            v0_2 -= ((long) (v8_3.c - v8_3.b));
        }
        return v8_3.a[((int) ((((long) v8_3.b) + p8) - v0_2))];
    }

    public final long M(byte p10, long p11, long p13)
    {
        long v0_0 = 0;
        if ((0 > p11) || (p11 > p13)) {
            long v0_5 = this.h;
            long v10_11 = new StringBuilder("size=");
            v10_11.append(v0_5);
            v10_11.append(" fromIndex=");
            v10_11.append(p11);
            v10_11.append(" toIndex=");
            v10_11.append(p13);
            throw new IllegalArgumentException(v10_11.toString().toString());
        } else {
            long v2_1 = this.h;
            if (p13 > v2_1) {
                p13 = v2_1;
            }
            if (p11 != p13) {
                oc.z v4_0 = this.g;
                if (v4_0 != null) {
                    if ((v2_1 - p11) >= p11) {
                        while(true) {
                            long v2_6 = (((long) (v4_0.c - v4_0.b)) + v0_0);
                            if (v2_6 > p11) {
                                break;
                            }
                            v4_0 = v4_0.f;
                            v4_0.getClass();
                            v0_0 = v2_6;
                        }
                        while (v0_0 < p13) {
                            long v2_8 = v4_0.a;
                            long v5_4 = Math.min(((long) v4_0.c), ((((long) v4_0.b) + p13) - v0_0));
                            int v11_8 = ((int) ((((long) v4_0.b) + p11) - v0_0));
                            while (v11_8 < ((int) v5_4)) {
                                if (v2_8[v11_8] != p10) {
                                    v11_8++;
                                } else {
                                    return (((long) (v11_8 - v4_0.b)) + v0_0);
                                }
                            }
                            v0_0 += ((long) (v4_0.c - v4_0.b));
                            v4_0 = v4_0.f;
                            v4_0.getClass();
                            p11 = v0_0;
                        }
                        return -1;
                    }
                    while (v2_1 > p11) {
                        v4_0 = v4_0.g;
                        v4_0.getClass();
                        v2_1 -= ((long) (v4_0.c - v4_0.b));
                    }
                    while (v2_1 < p13) {
                        long v0_8 = v4_0.a;
                        long v5_10 = Math.min(((long) v4_0.c), ((((long) v4_0.b) + p13) - v2_1));
                        int v11_3 = ((int) ((((long) v4_0.b) + p11) - v2_1));
                        while (v11_3 < ((int) v5_10)) {
                            if (v0_8[v11_3] != p10) {
                                v11_3++;
                            } else {
                                return (((long) (v11_3 - v4_0.b)) + v2_1);
                            }
                        }
                        v2_1 += ((long) (v4_0.c - v4_0.b));
                        v4_0 = v4_0.f;
                        v4_0.getClass();
                        p11 = v2_1;
                    }
                }
            }
            return -1;
        }
    }

    public final long N(long p5, oc.i p7)
    {
        p7.getClass();
        if (p5 < 0) {
            oc.l.d(f0.a.b("byteCount < 0: ", p5));
            return 0;
        } else {
            long v2_0 = this.h;
            if (v2_0 != 0) {
                if (p5 > v2_0) {
                    p5 = v2_0;
                }
                p7.D(p5, this);
                return p5;
            } else {
                return -1;
            }
        }
    }

    public final bridge synthetic oc.j R(okio.ByteString p1)
    {
        this.m0(p1);
        return this;
    }

    public final void W(long p3)
    {
        if (this.h < p3) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
            return;
        } else {
            return;
        }
    }

    public final bridge synthetic oc.j Y(long p1)
    {
        this.p0(p1);
        return this;
    }

    public final long Z(okio.ByteString p12)
    {
        p12.getClass();
        oc.z v0_0 = this.g;
        if (v0_0 != null) {
            int v12_1;
            int v3_3;
            long v1 = this.h;
            int v3_2 = 0;
            if (v1 >= 0) {
                v1 = 0;
                while(true) {
                    int v9_3 = (((long) (v0_0.c - v0_0.b)) + v1);
                    if (v9_3 > 0) {
                        break;
                    }
                    v0_0 = v0_0.f;
                    v0_0.getClass();
                    v1 = v9_3;
                }
                if (p12.e() != 2) {
                    int v12_3 = p12.i();
                    while (v1 < this.h) {
                        v3_3 = ((int) ((((long) v0_0.b) + v3_2) - v1));
                        while (v3_3 < v0_0.c) {
                            int v9_6 = 0;
                            while (v9_6 < v12_3.length) {
                                if (v0_0.a[v3_3] != v12_3[v9_6]) {
                                    v9_6++;
                                } else {
                                    v12_1 = v0_0.b;
                                }
                            }
                            v3_3++;
                        }
                        v3_2 = (((long) (v0_0.c - v0_0.b)) + v1);
                        v0_0 = v0_0.f;
                        v0_0.getClass();
                        v1 = v3_2;
                    }
                    return -1;
                } else {
                    byte[] v5_11 = p12.j(0);
                    int v12_4 = p12.j(1);
                    while (v1 < this.h) {
                        v3_3 = ((int) ((((long) v0_0.b) + v3_2) - v1));
                        while (v3_3 < v0_0.c) {
                            byte v7_10 = v0_0.a[v3_3];
                            if ((v7_10 != v5_11) && (v7_10 != v12_4)) {
                                v3_3++;
                            } else {
                                v12_1 = v0_0.b;
                            }
                        }
                        v3_2 = (((long) (v0_0.c - v0_0.b)) + v1);
                        v0_0 = v0_0.f;
                        v0_0.getClass();
                        v1 = v3_2;
                    }
                    return -1;
                }
            } else {
                while (v1 > 0) {
                    v0_0 = v0_0.g;
                    v0_0.getClass();
                    v1 -= ((long) (v0_0.c - v0_0.b));
                }
                if (p12.e() != 2) {
                    int v12_5 = p12.i();
                    while (v1 < this.h) {
                        v3_3 = ((int) ((((long) v0_0.b) + v3_2) - v1));
                        while (v3_3 < v0_0.c) {
                            int v9_0 = 0;
                            while (v9_0 < v12_5.length) {
                                if (v0_0.a[v3_3] != v12_5[v9_0]) {
                                    v9_0++;
                                }
                            }
                            v3_3++;
                        }
                        v3_2 = (((long) (v0_0.c - v0_0.b)) + v1);
                        v0_0 = v0_0.f;
                        v0_0.getClass();
                        v1 = v3_2;
                    }
                    return -1;
                } else {
                    byte[] v5_1 = p12.j(0);
                    int v12_2 = p12.j(1);
                    while (v1 < this.h) {
                        v3_3 = ((int) ((((long) v0_0.b) + v3_2) - v1));
                        while (v3_3 < v0_0.c) {
                            byte v7_4 = v0_0.a[v3_3];
                            if ((v7_4 != v5_1) && (v7_4 != v12_2)) {
                                v3_3++;
                            }
                        }
                        v3_2 = (((long) (v0_0.c - v0_0.b)) + v1);
                        v0_0 = v0_0.f;
                        v0_0.getClass();
                        v1 = v3_2;
                    }
                    return -1;
                }
            }
            return (((long) (v3_3 - v12_1)) + v1);
        }
        return -1;
    }

    public final oc.f0 a()
    {
        return oc.f0.d;
    }

    public final boolean c0(long p10, okio.ByteString p12, int p13)
    {
        p12.getClass();
        if ((p13 < 0) || ((p10 < 0) || (((((long) p13) + p10) > this.h) || ((p13 > p12.e()) || ((p13 != 0) && (pc.a.a(this, p12, p10, (p10 + 1), p13) == -1)))))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final Object clone()
    {
        oc.i v0_1 = new oc.i();
        if (this.h != 0) {
            long v1_3 = this.g;
            v1_3.getClass();
            oc.z v2 = v1_3.c();
            v0_1.g = v2;
            v2.g = v2;
            v2.f = v2;
            oc.z v3_0 = v1_3.f;
            while (v3_0 != v1_3) {
                oc.z v4 = v2.g;
                v4.getClass();
                v3_0.getClass();
                v4.b(v3_0.c());
                v3_0 = v3_0.f;
            }
            v0_1.h = this.h;
            return v0_1;
        } else {
            return v0_1;
        }
    }

    public final void close()
    {
        return;
    }

    public final void d()
    {
        this.skip(this.h);
        return;
    }

    public final byte[] d0(long p4)
    {
        if ((p4 < 0) || (p4 > 2147483647)) {
            oc.l.d(f0.a.b("byteCount: ", p4));
        } else {
            if (this.h < p4) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
            } else {
                byte[] v5 = new byte[((int) p4)];
                int v0_4 = 0;
                while (v0_4 < ((int) p4)) {
                    int v1_1 = this.read(v5, v0_4, (((int) p4) - v0_4));
                    if (v1_1 == -1) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
                    } else {
                        v0_4 += v1_1;
                    }
                }
                return v5;
            }
        }
        return 0;
    }

    public final long e0()
    {
        String v3_1 = 0;
        if (this.h == 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
        } else {
            String v1_8 = 0;
            NumberFormatException v2_4 = 0;
            long v8_1 = 0;
            long v6 = -7;
            long v5_0 = 0;
            while(true) {
                oc.z v10 = this.g;
                v10.getClass();
                int v12 = v10.b;
                int v13 = v10.c;
                oc.z v17;
                if (v12 >= v13) {
                    v17 = v3_1;
                } else {
                    byte v15 = v10.a[v12];
                    if ((v15 < 48) || (v15 > 57)) {
                        v17 = v3_1;
                        if ((v15 != 45) || (v1_8 != null)) {
                            v5_0 = 1;
                            if (v12 != v13) {
                                v10.b = v12;
                            } else {
                                this.g = v10.a();
                                oc.a0.a(v10);
                            }
                            if ((v5_0 == 0) && (this.g != null)) {
                                v3_1 = v17;
                            } else {
                                int v14_2;
                                String v3_6 = (this.h - ((long) v1_8));
                                this.h = v3_6;
                                if (v2_4 == null) {
                                    v14_2 = 1;
                                } else {
                                    v14_2 = 2;
                                }
                                if (v1_8 >= v14_2) {
                                    if (v2_4 == null) {
                                        return (- v8_1);
                                    } else {
                                        return v8_1;
                                    }
                                } else {
                                    if (v3_6 == v17) {
                                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
                                    } else {
                                        String v1_7;
                                        if (v2_4 == null) {
                                            v1_7 = "Expected a digit or \'-\'";
                                        } else {
                                            v1_7 = "Expected a digit";
                                        }
                                        String v1_9 = f0.a.g(v1_7, " but was 0x");
                                        v1_9.append(oc.b.h(this.L(v17)));
                                        throw new NumberFormatException(v1_9.toString());
                                    }
                                }
                            }
                            return 0;
                        } else {
                            v6--;
                            v2_4 = 1;
                        }
                    } else {
                        int v14_3 = (48 - v15);
                        long v16_1 = v8_1 cmp -922337203685477580;
                        if (v16_1 < 0) {
                            break;
                        }
                        v17 = v3_1;
                        if ((v16_1 == 0) && (((long) v14_3) < v6)) {
                            break;
                        }
                        v8_1 = ((v8_1 * 10) + ((long) v14_3));
                    }
                    v12++;
                    v1_8++;
                    v3_1 = v17;
                    while (v12 < v13) {
                    }
                }
            }
            String v1_12 = new oc.i();
            v1_12.p0(v8_1);
            v1_12.o0(v15);
            if (v2_4 == null) {
                v1_12.readByte();
            }
            throw new NumberFormatException("Number too large: ".concat(v1_12.i0()));
        }
        return 0;
    }

    public final boolean equals(Object p19)
    {
        if (this != p19) {
            if ((p19 instanceof oc.i)) {
                int v5_3 = this.h;
                if (v5_3 == ((oc.i) p19).h) {
                    if (v5_3 != 0) {
                        oc.z v3_2 = this.g;
                        v3_2.getClass();
                        oc.z v1_1 = ((oc.i) p19).g;
                        v1_1.getClass();
                        int v5_0 = v3_2.b;
                        int v6_0 = v1_1.b;
                        long v9 = 0;
                        while (v9 < this.h) {
                            long v11_5 = ((long) Math.min((v3_2.c - v5_0), (v1_1.c - v6_0)));
                            int v13_0 = 0;
                            while (v13_0 < v11_5) {
                                if (v3_2.a[v5_0] == v1_1.a[v6_0]) {
                                    v13_0++;
                                    v5_0++;
                                    v6_0++;
                                } else {
                                    return 0;
                                }
                            }
                            if (v5_0 == v3_2.c) {
                                v3_2 = v3_2.f;
                                v3_2.getClass();
                                v5_0 = v3_2.b;
                            }
                            if (v6_0 == v1_1.c) {
                                v1_1 = v1_1.f;
                                v1_1.getClass();
                                v6_0 = v1_1.b;
                            }
                            v9 += v11_5;
                        }
                        return 1;
                    } else {
                        return 1;
                    }
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

    public final long f0()
    {
        if (this.h == 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
            return 0;
        } else {
            NumberFormatException v0_9 = 0;
            String v1_2 = 0;
            long v4_1 = 0;
            do {
                long v6_0 = this.g;
                v6_0.getClass();
                int v8 = v6_0.b;
                int v9 = v6_0.c;
                if (v8 < v9) {
                    int v11_6;
                    long v10_0 = v6_0.a[v8];
                    if ((v10_0 < 48) || (v10_0 > 57)) {
                        if ((v10_0 < 97) || (v10_0 > 102)) {
                            if ((v10_0 < 65) || (v10_0 > 70)) {
                                if (v0_9 == null) {
                                    throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(oc.b.h(v10_0)));
                                } else {
                                    v1_2 = 1;
                                    if (v8 != v9) {
                                        v6_0.b = v8;
                                    } else {
                                        this.g = v6_0.a();
                                        oc.a0.a(v6_0);
                                    }
                                }
                            } else {
                                v11_6 = (v10_0 - 55);
                            }
                        } else {
                            v11_6 = (v10_0 - 87);
                        }
                    } else {
                        v11_6 = (v10_0 - 48);
                    }
                    if ((-1152921504606846976 & v4_1) != 0) {
                        NumberFormatException v0_6 = new oc.i();
                        v0_6.q0(v4_1);
                        v0_6.o0(v10_0);
                        throw new NumberFormatException("Number too large: ".concat(v0_6.i0()));
                    } else {
                        v4_1 = ((v4_1 << 4) | ((long) v11_6));
                        v8++;
                        v0_9++;
                        while (v8 >= v9) {
                        }
                    }
                }
            } while((v1_2 == null) && (this.g != null));
            this.h = (this.h - ((long) v0_9));
            return v4_1;
        }
    }

    public final void flush()
    {
        return;
    }

    public final short g0()
    {
        short v0_0 = this.readShort();
        return ((short) (((v0_0 & 255) << 8) | ((65280 & v0_0) >> 8)));
    }

    public final long h()
    {
        long v0 = this.h;
        if (v0 != 0) {
            long v2_3 = this.g;
            v2_3.getClass();
            long v2_4 = v2_3.g;
            v2_4.getClass();
            int v3_1 = v2_4.c;
            if ((v3_1 < 8192) && (v2_4.e)) {
                v0 -= ((long) (v3_1 - v2_4.b));
            }
            return v0;
        } else {
            return 0;
        }
    }

    public final String h0(long p7, java.nio.charset.Charset p9)
    {
        p9.getClass();
        String v0_2 = p7 cmp 0;
        if ((v0_2 < null) || (p7 > 2147483647)) {
            oc.l.d(f0.a.b("byteCount: ", p7));
        } else {
            if (this.h < p7) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
            } else {
                if (v0_2 != null) {
                    String v0_1 = this.g;
                    v0_1.getClass();
                    int v1_2 = v0_1.b;
                    if ((((long) v1_2) + p7) <= ((long) v0_1.c)) {
                        String v2_4 = new String(v0_1.a, v1_2, ((int) p7), p9);
                        int v9_2 = (v0_1.b + ((int) p7));
                        v0_1.b = v9_2;
                        this.h = (this.h - p7);
                        if (v9_2 == v0_1.c) {
                            this.g = v0_1.a();
                            oc.a0.a(v0_1);
                        }
                        return v2_4;
                    } else {
                        return new String(this.d0(p7), p9);
                    }
                } else {
                    return "";
                }
            }
        }
        return 0;
    }

    public final int hashCode()
    {
        oc.z v0_0 = this.g;
        if (v0_0 != null) {
            int v1_1 = 1;
            do {
                oc.z v2_0 = v0_0.b;
                if (v2_0 >= v0_0.c) {
                    v0_0 = v0_0.f;
                    v0_0.getClass();
                } else {
                    v1_1 = ((v1_1 * 31) + v0_0.a[v2_0]);
                    v2_0++;
                    while (v2_0 < v0_0.c) {
                    }
                }
            } while(v0_0 != this.g);
            return v1_1;
        } else {
            return 0;
        }
    }

    public final void i(oc.i p7, long p8, long p10)
    {
        p7.getClass();
        long v2_0 = p8;
        oc.b.c(this.h, p8, p10);
        if (p10 != 0) {
            p7.h = (p7.h + p10);
            long v10_1 = this.g;
            while(true) {
                v10_1.getClass();
                oc.z v0_2 = ((long) (v10_1.c - v10_1.b));
                if (v2_0 < v0_2) {
                    break;
                }
                v2_0 -= v0_2;
                v10_1 = v10_1.f;
            }
            oc.z v0_3 = v10_1;
            long v10_2 = p10;
            while (v10_2 > 0) {
                v0_3.getClass();
                long v1_1 = v0_3.c();
                int v4_1 = (v1_1.b + ((int) v2_0));
                v1_1.b = v4_1;
                v1_1.c = Math.min((v4_1 + ((int) v10_2)), v1_1.c);
                long v2_5 = p7.g;
                if (v2_5 != 0) {
                    long v2_6 = v2_5.g;
                    v2_6.getClass();
                    v2_6.b(v1_1);
                } else {
                    v1_1.g = v1_1;
                    v1_1.f = v1_1;
                    p7.g = v1_1;
                }
                v10_2 -= ((long) (v1_1.c - v1_1.b));
                v0_3 = v0_3.f;
                v2_0 = 0;
            }
        }
        return;
    }

    public final String i0()
    {
        return this.h0(this.h, db.a.a);
    }

    public final boolean isOpen()
    {
        return 1;
    }

    public final okio.ByteString j(long p3)
    {
        if ((p3 < 0) || (p3 > 2147483647)) {
            oc.l.d(f0.a.b("byteCount: ", p3));
        } else {
            if (this.h < p3) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
            } else {
                if (p3 < 4096) {
                    return new okio.ByteString(this.d0(p3));
                } else {
                    okio.ByteString v0_9 = this.k0(((int) p3));
                    this.skip(p3);
                    return v0_9;
                }
            }
        }
        return 0;
    }

    public final okio.ByteString j0()
    {
        String v0_0 = this.h;
        if (v0_0 > 2147483647) {
            String v0_5 = this.h;
            StringBuilder v2_3 = new StringBuilder("size > Int.MAX_VALUE: ");
            v2_3.append(v0_5);
            throw new IllegalStateException(v2_3.toString().toString());
        } else {
            return this.k0(((int) v0_0));
        }
    }

    public final okio.ByteString k0(int p9)
    {
        if (p9 != null) {
            oc.b.c(this.h, 0, ((long) p9));
            oc.z v0_2 = this.g;
            int v1 = 0;
            int v2_3 = 0;
            int v3 = 0;
            while (v2_3 < p9) {
                v0_2.getClass();
                int v4_3 = v0_2.c;
                oc.z v5_1 = v0_2.b;
                if (v4_3 == v5_1) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.g("s.limit == s.pos");
                    return 0;
                } else {
                    v2_3 += (v4_3 - v5_1);
                    v3++;
                    v0_2 = v0_2.f;
                }
            }
            oc.z v0_1 = new byte[][v3];
            int v2_1 = new int[(v3 * 2)];
            oc.z v5_0 = this.g;
            int v4_1 = 0;
            while (v1 < p9) {
                v5_0.getClass();
                v0_1[v4_1] = v5_0.a;
                v1 += (v5_0.c - v5_0.b);
                v2_1[v4_1] = Math.min(v1, p9);
                v2_1[(v4_1 + v3)] = v5_0.b;
                v5_0.d = 1;
                v4_1++;
                v5_0 = v5_0.f;
            }
            return new okio.SegmentedByteString(v0_1, v2_1);
        } else {
            return okio.ByteString.j;
        }
    }

    public final oc.z l0(int p4)
    {
        if ((p4 < 1) || (p4 > 8192)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("unexpected capacity");
            return 0;
        } else {
            oc.z v1_1 = this.g;
            if (v1_1 != null) {
                oc.z v1_0 = v1_1.g;
                v1_0.getClass();
                if (((v1_0.c + p4) <= 8192) && (v1_0.e)) {
                    return v1_0;
                } else {
                    oc.z v4_2 = oc.a0.b();
                    v1_0.b(v4_2);
                    return v4_2;
                }
            } else {
                oc.z v4_3 = oc.a0.b();
                this.g = v4_3;
                v4_3.g = v4_3;
                v4_3.f = v4_3;
                return v4_3;
            }
        }
    }

    public final void m0(okio.ByteString p2)
    {
        p2.getClass();
        p2.u(this, p2.e());
        return;
    }

    public final long n0(oc.d0 p7)
    {
        p7.getClass();
        long v0 = 0;
        while(true) {
            long v2_1 = p7.N(8192, this);
            if (v2_1 == -1) {
                break;
            }
            v0 += v2_1;
        }
        return v0;
    }

    public final void o0(int p5)
    {
        long v0_2 = this.l0(1);
        byte[] v1 = v0_2.a;
        long v2_1 = v0_2.c;
        v0_2.c = (v2_1 + 1);
        v1[v2_1] = ((byte) p5);
        this.h = (this.h + 1);
        return;
    }

    public final void p0(long p13)
    {
        int v2_0 = p13 cmp 0;
        if (v2_0 != 0) {
            int v2_1;
            oc.z v3_0 = 0;
            if (v2_0 >= 0) {
                v2_1 = 0;
            } else {
                p13 = (- p13);
                if (p13 >= 0) {
                    v2_1 = 1;
                } else {
                    this.w0("-9223372036854775808");
                    return;
                }
            }
            int v5_3 = (((64 - Long.numberOfLeadingZeros(p13)) * 10) >> 5);
            if (p13 > pc.a.b[v5_3]) {
                v3_0 = 1;
            }
            int v5_4 = (v5_3 + v3_0);
            if (v2_1 != 0) {
                v5_4++;
            }
            oc.z v3_1 = this.l0(v5_4);
            byte[] v4_0 = v3_1.a;
            int v7_3 = (v3_1.c + v5_4);
            while (p13 != 0) {
                v7_3--;
                v4_0[v7_3] = pc.a.a[((int) (p13 % ((long) 10)))];
                p13 /= ((long) 10);
            }
            if (v2_1 != 0) {
                v4_0[(v7_3 - 1)] = 45;
            }
            v3_1.c = (v3_1.c + v5_4);
            this.h = (this.h + ((long) v5_4));
            return;
        } else {
            this.o0(48);
            return;
        }
    }

    public final void q0(long p13)
    {
        if (p13 != 0) {
            int v1_18 = ((p13 >> 1) | p13);
            int v1_19 = (v1_18 | (v1_18 >> 2));
            int v1_0 = (v1_19 | (v1_19 >> 4));
            int v1_1 = (v1_0 | (v1_0 >> 8));
            int v1_2 = (v1_1 | (v1_1 >> 16));
            int v1_3 = (v1_2 | (v1_2 >> 32));
            int v1_4 = (v1_3 - ((v1_3 >> 1) & 6148914691236517205));
            long v8_5 = (((v1_4 >> 2) & 3689348814741910323) + (v1_4 & 3689348814741910323));
            int v1_8 = (((v8_5 >> 4) + v8_5) & 1085102592571150095);
            int v1_9 = (v1_8 + (v1_8 >> 8));
            int v1_10 = (v1_9 + (v1_9 >> 16));
            int v1_17 = ((int) ((((v1_10 & 63) + ((v1_10 >> 32) & 63)) + ((long) 3)) / ((long) 4)));
            oc.z v2 = this.l0(v1_17);
            int v5_4 = v2.c;
            int v6_3 = ((v5_4 + v1_17) - 1);
            while (v6_3 >= v5_4) {
                v2.a[v6_3] = pc.a.a[((int) (15 & p13))];
                p13 >>= 4;
                v6_3--;
            }
            v2.c = (v2.c + v1_17);
            this.h = (this.h + ((long) v1_17));
            return;
        } else {
            this.o0(48);
            return;
        }
    }

    public final bridge synthetic oc.j r(long p1)
    {
        this.s0(p1);
        return this;
    }

    public final void r0(int p8)
    {
        oc.z v1 = this.l0(4);
        long v2_1 = v1.a;
        int v3_1 = v1.c;
        int v4_1 = (v3_1 + 1);
        v2_1[v3_1] = ((byte) ((p8 >> 24) & 255));
        int v5_0 = (v3_1 + 2);
        v2_1[v4_1] = ((byte) ((p8 >> 16) & 255));
        int v4_0 = (v3_1 + 3);
        v2_1[v5_0] = ((byte) ((p8 >> 8) & 255));
        int v3_0 = (v3_1 + 4);
        v2_1[v4_0] = ((byte) (p8 & 255));
        v1.c = v3_0;
        this.h = (this.h + 4);
        return;
    }

    public final int read(java.nio.ByteBuffer p7)
    {
        p7.getClass();
        oc.z v0 = this.g;
        if (v0 != null) {
            int v1_1 = Math.min(p7.remaining(), (v0.c - v0.b));
            p7.put(v0.a, v0.b, v1_1);
            oc.z v7_2 = (v0.b + v1_1);
            v0.b = v7_2;
            this.h = (this.h - ((long) v1_1));
            if (v7_2 == v0.c) {
                this.g = v0.a();
                oc.a0.a(v0);
            }
            return v1_1;
        } else {
            return -1;
        }
    }

    public final int read(byte[] p8, int p9, int p10)
    {
        p8.getClass();
        oc.b.c(((long) p8.length), ((long) p9), ((long) p10));
        oc.z v0_1 = this.g;
        if (v0_1 != null) {
            int v10_1 = Math.min(p10, (v0_1.c - v0_1.b));
            int v2_0 = v0_1.b;
            ha.i.J(v0_1.a, p9, p8, v2_0, (v2_0 + v10_1));
            oc.z v8_2 = (v0_1.b + v10_1);
            v0_1.b = v8_2;
            this.h = (this.h - ((long) v10_1));
            if (v8_2 == v0_1.c) {
                this.g = v0_1.a();
                oc.a0.a(v0_1);
            }
            return v10_1;
        } else {
            return -1;
        }
    }

    public final byte readByte()
    {
        if (this.h == 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
            return 0;
        } else {
            int v0_3 = this.g;
            v0_3.getClass();
            byte v1_1 = v0_3.b;
            oc.z v2_1 = v0_3.c;
            int v4 = (v1_1 + 1);
            byte v1_0 = v0_3.a[v1_1];
            this.h = (this.h - 1);
            if (v4 != v2_1) {
                v0_3.b = v4;
                return v1_0;
            } else {
                this.g = v0_3.a();
                oc.a0.a(v0_3);
                return v1_0;
            }
        }
    }

    public final int readInt()
    {
        if (this.h < 4) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
            return 0;
        } else {
            int v0_9 = this.g;
            v0_9.getClass();
            oc.z v1_10 = v0_9.b;
            int v4 = v0_9.c;
            if (((long) (v4 - v1_10)) >= 4) {
                int v5_3 = v0_9.a;
                oc.z v1_0 = (v1_10 + 4);
                int v5_6 = ((v5_3[(v1_10 + 3)] & 255) | ((((v5_3[(v1_10 + 1)] & 255) << 16) | ((v5_3[v1_10] & 255) << 24)) | ((v5_3[(v1_10 + 2)] & 255) << 8)));
                this.h = (this.h - 4);
                if (v1_0 != v4) {
                    v0_9.b = v1_0;
                    return v5_6;
                } else {
                    this.g = v0_9.a();
                    oc.a0.a(v0_9);
                    return v5_6;
                }
            } else {
                return (((((this.readByte() & 255) << 24) | ((this.readByte() & 255) << 16)) | ((this.readByte() & 255) << 8)) | (this.readByte() & 255));
            }
        }
    }

    public final short readShort()
    {
        if (this.h < 2) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
            return 0;
        } else {
            short v0_9 = this.g;
            v0_9.getClass();
            oc.z v1_4 = v0_9.b;
            int v4 = v0_9.c;
            if ((v4 - v1_4) >= 2) {
                int v5_1 = v0_9.a;
                oc.z v1_0 = (v1_4 + 2);
                int v5_4 = ((v5_1[(v1_4 + 1)] & 255) | ((v5_1[v1_4] & 255) << 8));
                this.h = (this.h - 2);
                if (v1_0 != v4) {
                    v0_9.b = v1_0;
                } else {
                    this.g = v0_9.a();
                    oc.a0.a(v0_9);
                }
                return ((short) v5_4);
            } else {
                return ((short) (((this.readByte() & 255) << 8) | (this.readByte() & 255)));
            }
        }
    }

    public final void s0(long p12)
    {
        long v12_1 = oc.b.e(p12);
        oc.z v1 = this.l0(8);
        byte[] v2 = v1.a;
        int v3_1 = v1.c;
        int v4_3 = (v3_1 + 1);
        v2[v3_1] = ((byte) ((int) ((v12_1 >> 56) & 255)));
        int v5_3 = (v3_1 + 2);
        v2[v4_3] = ((byte) ((int) ((v12_1 >> 48) & 255)));
        int v4_0 = (v3_1 + 3);
        v2[v5_3] = ((byte) ((int) ((v12_1 >> 40) & 255)));
        int v5_4 = (v3_1 + 4);
        v2[v4_0] = ((byte) ((int) ((v12_1 >> 32) & 255)));
        int v4_1 = (v3_1 + 5);
        v2[v5_4] = ((byte) ((int) ((v12_1 >> 24) & 255)));
        int v5_5 = (v3_1 + 6);
        v2[v4_1] = ((byte) ((int) ((v12_1 >> 16) & 255)));
        int v4_2 = (v3_1 + 7);
        v2[v5_5] = ((byte) ((int) ((v12_1 >> 8) & 255)));
        int v3_0 = (v3_1 + 8);
        v2[v4_2] = ((byte) ((int) (v12_1 & 255)));
        v1.c = v3_0;
        this.h = (this.h + 8);
        return;
    }

    public final void skip(long p7)
    {
        while (p7 > 0) {
            oc.z v0_2 = this.g;
            if (v0_2 == null) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
                break;
            } else {
                oc.z v1_2 = ((int) Math.min(p7, ((long) (v0_2.c - v0_2.b))));
                long v4 = ((long) v1_2);
                this.h = (this.h - v4);
                p7 -= v4;
                int v2_3 = (v0_2.b + v1_2);
                v0_2.b = v2_3;
                if (v2_3 == v0_2.c) {
                    this.g = v0_2.a();
                    oc.a0.a(v0_2);
                }
            }
        }
        return;
    }

    public final byte[] t()
    {
        return this.d0(this.h);
    }

    public final void t0(int p7)
    {
        oc.z v1 = this.l0(2);
        long v2_1 = v1.a;
        int v3_1 = v1.c;
        int v4 = (v3_1 + 1);
        v2_1[v3_1] = ((byte) ((p7 >> 8) & 255));
        int v3_0 = (v3_1 + 2);
        v2_1[v4] = ((byte) (p7 & 255));
        v1.c = v3_0;
        this.h = (this.h + 2);
        return;
    }

    public final String toString()
    {
        return this.j0().toString();
    }

    public final void u0(java.io.OutputStream p8, long p9)
    {
        p8.getClass();
        oc.b.c(this.h, 0, p9);
        oc.z v0_1 = this.g;
        long v9_1 = p9;
        while (v9_1 > 0) {
            v0_1.getClass();
            oc.z v1_4 = ((int) Math.min(v9_1, ((long) (v0_1.c - v0_1.b))));
            p8.write(v0_1.a, v0_1.b, v1_4);
            int v2_4 = (v0_1.b + v1_4);
            v0_1.b = v2_4;
            long v5 = ((long) v1_4);
            this.h = (this.h - v5);
            v9_1 -= v5;
            if (v2_4 == v0_1.c) {
                oc.z v1_6 = v0_1.a();
                this.g = v1_6;
                oc.a0.a(v0_1);
                v0_1 = v1_6;
            }
        }
        return;
    }

    public final oc.j v(int p1)
    {
        this.r0(oc.b.d(p1));
        return this;
    }

    public final void v0(int p10, int p11, String p12)
    {
        p12.getClass();
        if (p10 < 0) {
            oc.l.d(r1.a.g(p10, "beginIndex < 0: "));
            return;
        } else {
            if (p11 < p10) {
                oc.l.d(r1.a.l("endIndex < beginIndex: ", " < ", p11, p10));
                return;
            } else {
                if (p11 > p12.length()) {
                    int v10_5 = r1.a.v(p11, "endIndex > string.length: ", " > ");
                    v10_5.append(p12.length());
                    throw new IllegalArgumentException(v10_5.toString().toString());
                }
                while (p10 < p11) {
                    long v0_19 = p12.charAt(p10);
                    if (v0_19 >= 128) {
                        if (v0_19 >= 2048) {
                            if ((v0_19 >= 55296) && (v0_19 <= 57343)) {
                                oc.z v4_5;
                                long v2_9 = (p10 + 1);
                                if (v2_9 >= p11) {
                                    v4_5 = 0;
                                } else {
                                    v4_5 = p12.charAt(v2_9);
                                }
                                if ((v0_19 > 56319) || ((56320 > v4_5) || (v4_5 >= 57344))) {
                                    this.o0(63);
                                    p10 = v2_9;
                                } else {
                                    long v0_23 = ((((v0_19 & 1023) << 10) | (v4_5 & 1023)) + 65536);
                                    oc.z v4_6 = this.l0(4);
                                    byte[] v5_7 = v4_6.a;
                                    int v6_7 = v4_6.c;
                                    v5_7[v6_7] = ((byte) ((v0_23 >> 18) | 240));
                                    v5_7[(v6_7 + 1)] = ((byte) (((v0_23 >> 12) & 63) | 128));
                                    v5_7[(v6_7 + 2)] = ((byte) (((v0_23 >> 6) & 63) | 128));
                                    v5_7[(v6_7 + 3)] = ((byte) ((v0_23 & 63) | 128));
                                    v4_6.c = (v6_7 + 4);
                                    this.h = (this.h + 4);
                                    p10 += 2;
                                }
                            } else {
                                oc.z v4_7 = this.l0(3);
                                byte[] v5_8 = v4_7.a;
                                int v6_0 = v4_7.c;
                                v5_8[v6_0] = ((byte) ((v0_19 >> 12) | 224));
                                v5_8[(v6_0 + 1)] = ((byte) ((63 & (v0_19 >> 6)) | 128));
                                v5_8[(v6_0 + 2)] = ((byte) ((v0_19 & 63) | 128));
                                v4_7.c = (v6_0 + 3);
                                this.h = (this.h + 3);
                            }
                        } else {
                            int v3_4 = this.l0(2);
                            oc.z v4_0 = v3_4.a;
                            byte[] v5_0 = v3_4.c;
                            v4_0[v5_0] = ((byte) ((v0_19 >> 6) | 192));
                            v4_0[(v5_0 + 1)] = ((byte) ((v0_19 & 63) | 128));
                            v3_4.c = (v5_0 + 2);
                            this.h = (this.h + 2);
                        }
                        p10++;
                    } else {
                        long v2_4 = this.l0(1);
                        int v3_5 = v2_4.a;
                        oc.z v4_2 = (v2_4.c - p10);
                        byte[] v5_3 = Math.min(p11, (8192 - v4_2));
                        int v6_6 = (p10 + 1);
                        v3_5[(p10 + v4_2)] = ((byte) v0_19);
                        while(true) {
                            p10 = v6_6;
                            if (p10 >= v5_3) {
                                break;
                            }
                            long v0_12 = p12.charAt(p10);
                            if (v0_12 >= 128) {
                                break;
                            }
                            v6_6 = (p10 + 1);
                            v3_5[(p10 + v4_2)] = ((byte) v0_12);
                        }
                        long v0_13 = v2_4.c;
                        oc.z v4_4 = ((v4_2 + p10) - v0_13);
                        v2_4.c = (v0_13 + v4_4);
                        this.h = (this.h + ((long) v4_4));
                    }
                }
                return;
            }
        }
    }

    public final void w0(String p3)
    {
        p3.getClass();
        this.v0(0, p3.length(), p3);
        return;
    }

    public final int write(java.nio.ByteBuffer p7)
    {
        p7.getClass();
        int v0 = p7.remaining();
        long v1_0 = v0;
        while (v1_0 > 0) {
            oc.z v2_1 = this.l0(1);
            long v3_2 = Math.min(v1_0, (8192 - v2_1.c));
            p7.get(v2_1.a, v2_1.c, v3_2);
            v1_0 -= v3_2;
            v2_1.c = (v2_1.c + v3_2);
        }
        this.h = (this.h + ((long) v0));
        return v0;
    }

    public final oc.j write(byte[] p3)
    {
        p3.getClass();
        this.write(p3, 0, p3.length);
        return this;
    }

    public final void write(byte[] p8, int p9, int p10)
    {
        p8.getClass();
        oc.b.c(((long) p8.length), ((long) p9), ((long) p10));
        int v10_1 = (p10 + p9);
        while (p9 < v10_1) {
            oc.z v0_2 = this.l0(1);
            int v1_1 = Math.min((v10_1 - p9), (8192 - v0_2.c));
            int v4 = (p9 + v1_1);
            ha.i.J(p8, v0_2.c, v0_2.a, p9, v4);
            v0_2.c = (v0_2.c + v1_1);
            p9 = v4;
        }
        this.h = (this.h + ((long) p10));
        return;
    }

    public final bridge synthetic oc.j writeByte(int p1)
    {
        this.o0(p1);
        return this;
    }

    public final bridge synthetic oc.j writeInt(int p1)
    {
        this.r0(p1);
        return this;
    }

    public final bridge synthetic oc.j writeShort(int p1)
    {
        this.t0(p1);
        return this;
    }

    public final void x0(int p9)
    {
        if (p9 >= 128) {
            if (p9 >= 2048) {
                if ((55296 > p9) || (p9 >= 57344)) {
                    if (p9 >= 65536) {
                        if (p9 > 1114111) {
                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Unexpected code point: 0x".concat(oc.b.i(p9)));
                            return;
                        } else {
                            oc.z v3_0 = this.l0(4);
                            byte[] v4_0 = v3_0.a;
                            int v5_0 = v3_0.c;
                            v4_0[v5_0] = ((byte) ((p9 >> 18) | 240));
                            v4_0[(v5_0 + 1)] = ((byte) (((p9 >> 12) & 63) | 128));
                            v4_0[(v5_0 + 2)] = ((byte) (((p9 >> 6) & 63) | 128));
                            v4_0[(v5_0 + 3)] = ((byte) ((p9 & 63) | 128));
                            v3_0.c = (v5_0 + 4);
                            this.h = (this.h + 4);
                            return;
                        }
                    } else {
                        oc.z v3_1 = this.l0(3);
                        byte[] v4_1 = v3_1.a;
                        int v5_2 = v3_1.c;
                        v4_1[v5_2] = ((byte) ((p9 >> 12) | 224));
                        v4_1[(v5_2 + 1)] = ((byte) (((p9 >> 6) & 63) | 128));
                        v4_1[(v5_2 + 2)] = ((byte) ((p9 & 63) | 128));
                        v3_1.c = (v5_2 + 3);
                        this.h = (this.h + 3);
                        return;
                    }
                } else {
                    this.o0(63);
                    return;
                }
            } else {
                oc.z v3_2 = this.l0(2);
                byte[] v4_2 = v3_2.a;
                int v5_4 = v3_2.c;
                v4_2[v5_4] = ((byte) ((p9 >> 6) | 192));
                v4_2[(v5_4 + 1)] = ((byte) ((p9 & 63) | 128));
                v3_2.c = (v5_4 + 2);
                this.h = (this.h + 2);
                return;
            }
        } else {
            this.o0(p9);
            return;
        }
    }

    public final String y(long p12)
    {
        if (p12 < 0) {
            oc.l.d(f0.a.b("limit < 0: ", p12));
            return 0;
        } else {
            oc.i v0_2 = 9223372036854775807;
            if (p12 != 9223372036854775807) {
                v0_2 = (p12 + 1);
            }
            long v4_0 = v0_2;
            String v1_1 = this.M(10, 0, v4_0);
            if (v1_1 == -1) {
                if ((v4_0 >= this.h) || ((this.L((v4_0 - 1)) != 13) || (this.L(v4_0) != 10))) {
                    String v1_9 = new oc.i();
                    this.i(v1_9, 0, Math.min(((long) 32), this.h));
                    String v3_2 = Math.min(this.h, p12);
                    String v1_12 = v1_9.j(v1_9.h).f();
                    StringBuilder v5_2 = new StringBuilder("\\n not found: limit=");
                    v5_2.append(v3_2);
                    v5_2.append(" content=");
                    v5_2.append(v1_12);
                    v5_2.append(8230);
                    throw new java.io.EOFException(v5_2.toString());
                } else {
                    return pc.a.c(v4_0, this);
                }
            } else {
                return pc.a.c(v1_1, this);
            }
        }
    }
}
