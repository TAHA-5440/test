// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public final class y implements oc.k {
    public final oc.d0 g;
    public final oc.i h;
    public boolean i;

    public y(oc.d0 p1)
    {
        p1.getClass();
        this.g = p1;
        this.h = new oc.i();
        return;
    }

    public final int B()
    {
        this.W(4);
        return oc.b.d(this.h.readInt());
    }

    public final long L()
    {
        long v1_3;
        this.W(8);
        long v1_1 = this.h;
        if (v1_1.h < 8) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
            v1_3 = 0;
        } else {
            long v1_2;
            long v2_0 = v1_1.g;
            v2_0.getClass();
            oc.z v3_0 = v2_0.b;
            long v6_0 = v2_0.c;
            if (((long) (v6_0 - v3_0)) >= 8) {
                long v7_3 = v2_0.a;
                long v12 = 255;
                oc.z v3_1 = (v3_0 + 8);
                long v4_10 = (((((((((((long) v7_3[(v3_0 + 1)]) & v12) << 48) | ((((long) v7_3[v3_0]) & 255) << 56)) | ((((long) v7_3[(v3_0 + 2)]) & 255) << 40)) | ((((long) v7_3[(v3_0 + 3)]) & v12) << 32)) | ((((long) v7_3[(v3_0 + 4)]) & 255) << 24)) | ((((long) v7_3[(v3_0 + 5)]) & 255) << 16)) | ((((long) v7_3[(v3_0 + 6)]) & 255) << 8)) | (((long) v7_3[(v3_0 + 7)]) & v12));
                v1_1.h = (v1_1.h - 8);
                if (v3_1 != v6_0) {
                    v2_0.b = v3_1;
                } else {
                    v1_1.g = v2_0.a();
                    oc.a0.a(v2_0);
                }
                v1_2 = v4_10;
            } else {
                v1_2 = (((((long) v1_1.readInt()) & 4294967295) << 32) | (4294967295 & ((long) v1_1.readInt())));
            }
            v1_3 = oc.b.e(v1_2);
        }
        return v1_3;
    }

    public final short M()
    {
        this.W(2);
        return this.h.g0();
    }

    public final long N(long p7, oc.i p9)
    {
        p9.getClass();
        long v2 = p7 cmp 0;
        if (v2 < 0) {
            oc.l.d(f0.a.b("byteCount < 0: ", p7));
            return 0;
        } else {
            if (this.i) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
                return 0;
            } else {
                oc.i v3_1 = this.h;
                if (v3_1.h == 0) {
                    if (v2 != 0) {
                        if (this.g.N(8192, v3_1) == -1) {
                            return -1;
                        }
                    } else {
                        return 0;
                    }
                }
                return v3_1.N(Math.min(p7, v3_1.h), p9);
            }
        }
    }

    public final void W(long p1)
    {
        if (!this.c0(p1)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
            return;
        } else {
            return;
        }
    }

    public final String Z(long p3)
    {
        this.W(p3);
        return this.h.h0(p3, db.a.a);
    }

    public final oc.f0 a()
    {
        return this.g.a();
    }

    public final boolean c0(long p5)
    {
        if (p5 < 0) {
            oc.l.d(f0.a.b("byteCount < 0: ", p5));
        } else {
            if (this.i) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
                return 0;
            }
            do {
                long v0_2 = this.h;
                if (v0_2.h >= p5) {
                    return 1;
                } else {
                }
            } while(this.g.N(8192, v0_2) != -1);
            return 0;
        }
        return 0;
    }

    public final void close()
    {
        if (!this.i) {
            this.i = 1;
            this.g.close();
            this.h.d();
        }
        return;
    }

    public final boolean d()
    {
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return 0;
        } else {
            int v0_7 = this.h;
            if ((!v0_7.B()) || (this.g.N(8192, v0_7) != -1)) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public final long h(byte p10, long p11, long p13)
    {
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
        } else {
            if (0 > p13) {
                oc.l.d(f0.a.b("fromIndex=0 toIndex=", p13));
            } else {
                long v3 = 0;
                while (v3 < p13) {
                    oc.i v1 = this.h;
                    long v10_4 = v1.M(p10, v3, p13);
                    if (v10_4 == -1) {
                        long v10_5 = v1.h;
                        if ((v10_5 >= p13) || (this.g.N(8192, v1) == -1)) {
                            break;
                        }
                        v3 = Math.max(v3, v10_5);
                    } else {
                        return v10_4;
                    }
                }
                return -1;
            }
        }
        return 0;
    }

    public final boolean i(long p23, okio.ByteString p25)
    {
        p25.getClass();
        int v7 = p25.e();
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
        } else {
            int v20;
            int v8_1 = 0;
            if ((v7 >= 0) && ((p23 >= 0) && (v7 <= p25.e()))) {
                int v21;
                if (v7 != 0) {
                    long v10_0 = 1;
                    okio.ByteString v5_0 = (p23 + 1);
                    long v16_0 = ((long) v7);
                    oc.b.c(((long) p25.e()), ((long) 0), v16_0);
                    long v12_1 = v16_0;
                    if (this.i) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
                        return 0;
                    } else {
                        long v3_2 = p23;
                        while(true) {
                            long v1_5 = this.h;
                            int v14_1 = pc.a.a(v1_5, p25, v3_2, v5_0, v7);
                            if (v14_1 == -1) {
                                int v14_2 = v1_5.h;
                                v20 = v8_1;
                                v21 = 1;
                                int v8_0 = ((v14_2 - v12_1) + v10_0);
                                if (v8_0 >= v5_0) {
                                    break;
                                }
                                okio.ByteString v23_1;
                                if (v14_2 >= v5_0) {
                                    oc.d0 v2_5 = ((int) Math.max(v10_0, ((v14_2 - v5_0) + v10_0)));
                                    int v14_11 = (((int) Math.min(v12_1, ((v1_5.h - v3_2) + v10_0))) - 1);
                                    if (v2_5 > v14_11) {
                                        break;
                                    }
                                    while(true) {
                                        v23_1 = v5_0;
                                        if (v1_5.c0((v1_5.h - ((long) v14_11)), p25, v14_11)) {
                                            break;
                                        }
                                        if (v14_11 == v2_5) {
                                            v14_1 = -1;
                                            if (v14_1 == -1) {
                                                return v20;
                                            }
                                            return v21;
                                        } else {
                                            v14_11--;
                                            v5_0 = v23_1;
                                        }
                                    }
                                } else {
                                    v23_1 = v5_0;
                                }
                                if (this.g.N(8192, v1_5) == -1) {
                                    break;
                                }
                                v3_2 = Math.max(v3_2, v8_0);
                                v5_0 = v23_1;
                                v8_1 = v20;
                                v10_0 = 1;
                            } else {
                                v20 = v8_1;
                                v21 = 1;
                            }
                        }
                    }
                } else {
                    v21 = 1;
                }
                return v21;
            } else {
                v20 = 0;
            }
            return v20;
        }
        return 0;
    }

    public final boolean isOpen()
    {
        return (this.i ^ 1);
    }

    public final okio.ByteString j(long p2)
    {
        this.W(p2);
        return this.h.j(p2);
    }

    public final int read(java.nio.ByteBuffer p6)
    {
        p6.getClass();
        oc.i v0 = this.h;
        if ((v0.h != 0) || (this.g.N(8192, v0) != -1)) {
            return v0.read(p6);
        } else {
            return -1;
        }
    }

    public final byte readByte()
    {
        this.W(1);
        return this.h.readByte();
    }

    public final int readInt()
    {
        this.W(4);
        return this.h.readInt();
    }

    public final short readShort()
    {
        this.W(2);
        return this.h.readShort();
    }

    public final void skip(long p6)
    {
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return;
        }
        while (p6 > 0) {
            oc.i v2_1 = this.h;
            if ((v2_1.h == 0) && (this.g.N(8192, v2_1) == -1)) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
                return;
            } else {
                long v0_6 = Math.min(p6, v2_1.h);
                v2_1.skip(v0_6);
                p6 -= v0_6;
            }
        }
        return;
    }

    public final byte[] t()
    {
        oc.i v1 = this.h;
        v1.n0(this.g);
        return v1.d0(v1.h);
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder("buffer(");
        v0_1.append(this.g);
        v0_1.append(41);
        return v0_1.toString();
    }

    public final String y(long p19)
    {
        if (p19 < 0) {
            oc.l.d(f0.a.b("limit < 0: ", p19));
            return 0;
        } else {
            String v4_0;
            if (p19 != 9223372036854775807) {
                v4_0 = (p19 + 1);
            } else {
                v4_0 = 9223372036854775807;
            }
            String v1_1 = this.h(10, 0, v4_0);
            oc.i v12_1 = this.h;
            if (v1_1 == -1) {
                if ((v4_0 >= 9223372036854775807) || ((!this.c0(v4_0)) || ((v12_1.L((v4_0 - 1)) != 13) || ((!this.c0((v4_0 + 1))) || (v12_1.L(v4_0) != 10))))) {
                    oc.i v13_1 = new oc.i();
                    v12_1.i(v13_1, 0, Math.min(((long) 32), v12_1.h));
                    int v2_4 = Math.min(v12_1.h, p19);
                    String v4_3 = v13_1.j(v13_1.h).f();
                    StringBuilder v5_1 = new StringBuilder("\\n not found: limit=");
                    v5_1.append(v2_4);
                    v5_1.append(" content=");
                    v5_1.append(v4_3);
                    v5_1.append(8230);
                    throw new java.io.EOFException(v5_1.toString());
                } else {
                    return pc.a.c(v4_0, v12_1);
                }
            } else {
                return pc.a.c(v1_1, v12_1);
            }
        }
    }
}
