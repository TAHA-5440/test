// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final class t implements java.io.Closeable {
    public static final java.util.logging.Logger j;
    public final oc.k g;
    public final fc.s h;
    public final fc.c i;

    static t()
    {
        java.util.logging.Logger v0_2 = java.util.logging.Logger.getLogger(fc.f.getName());
        v0_2.getClass();
        fc.t.j = v0_2;
        return;
    }

    public t(oc.y p2)
    {
        p2.getClass();
        this.g = p2;
        fc.s v0_1 = new fc.s(p2);
        this.h = v0_1;
        this.i = new fc.c(v0_1);
        return;
    }

    public final void B(fc.o p10, int p11, int p12, int p13)
    {
        if (p13 == null) {
            oc.l.g("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
            return;
        } else {
            int v7;
            int v2 = 1;
            if ((p12 & 1) == 0) {
                v7 = 0;
            } else {
                v7 = 1;
            }
            int v0_1;
            if ((p12 & 8) == 0) {
                v0_1 = 0;
            } else {
                v0_1 = (this.g.readByte() & 255);
            }
            if ((p12 & 32) != 0) {
                fc.x v3_1 = this.g;
                v3_1.readInt();
                v3_1.readByte();
                p11 -= 5;
            }
            bc.b v11_2 = this.i(fc.r.a(p11, p12, v0_1), v0_1, p12, p13);
            fc.p v5 = p10.h;
            if ((p13 == null) || ((p13 & 1) != 0)) {
                v2 = 0;
            }
            if (v2 == 0) {
                try {
                    fc.n v12_1 = v5.h(p13);
                } catch (int v0_7) {
                    throw v0_7;
                }
                if (v12_1 != null) {
                    v12_1.i(zb.e.g(v11_2), v7);
                    return;
                } else {
                    if (!v5.l) {
                        if (p13 > v5.j) {
                            if ((p13 % 2) != (v5.k % 2)) {
                                fc.x v3_3 = new fc.x(p13, v5, 0, v7, zb.e.g(v11_2));
                                v5.j = p13;
                                v5.h.put(Integer.valueOf(p13), v3_3);
                                bc.b v11_5 = v5.m.d();
                                fc.n v12_7 = new StringBuilder();
                                v12_7.append(v5.i);
                                v12_7.append(91);
                                v12_7.append(p13);
                                v12_7.append("] onStream");
                                bc.b.c(v11_5, v12_7.toString(), new fc.n(0, v5, v3_3));
                                return;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } else {
                fc.n v12_10 = v5.o;
                int v0_9 = new StringBuilder();
                v0_9.append(v5.i);
                v0_9.append(91);
                v0_9.append(p13);
                v0_9.append("] onHeaders");
                bc.b.c(v12_10, v0_9.toString(), new fc.i(v5, p13, v11_2, v7));
                return;
            }
        }
    }

    public final void L(fc.o p5, int p6, int p7, int p8)
    {
        if (p8 == null) {
            oc.l.g("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
            return;
        } else {
            fc.i v0_1;
            if ((p7 & 8) == 0) {
                v0_1 = 0;
            } else {
                v0_1 = (this.g.readByte() & 255);
            }
            int v2_2 = (this.g.readInt() & 2147483647);
            okhttp3.internal.http2.ErrorCode v6_3 = this.i(fc.r.a((p6 - 4), p7, v0_1), v0_1, p7, p8);
            fc.p v5_2 = p5.h;
            try {
                if (!v5_2.E.contains(Integer.valueOf(v2_2))) {
                    v5_2.E.add(Integer.valueOf(v2_2));
                    bc.b v7_4 = v5_2.o;
                    String v8_4 = new StringBuilder();
                    v8_4.append(v5_2.i);
                    v8_4.append(91);
                    v8_4.append(v2_2);
                    v8_4.append("] onRequest");
                    bc.b.c(v7_4, v8_4.toString(), new fc.i(v5_2, v2_2, v6_3, 0));
                    return;
                } else {
                    v5_2.Z(v2_2, okhttp3.internal.http2.ErrorCode.j);
                    return;
                }
            } catch (okhttp3.internal.http2.ErrorCode v6_4) {
                throw v6_4;
            }
        }
    }

    public final void close()
    {
        this.g.close();
        return;
    }

    public final boolean d(boolean p14, fc.o p15)
    {
        int v0_0 = 0;
        try {
            this.g.W(9);
            fc.x[] v1_21 = zb.c.m(this.g);
        } catch (java.io.EOFException) {
            return 0;
        }
        if (v1_21 > 16384) {
            oc.l.g(r1.a.g(v1_21, "FRAME_SIZE_ERROR: "));
            return 0;
        } else {
            int v3_7 = (this.g.readByte() & 255);
            fc.p v4_7 = this.g.readByte();
            okhttp3.internal.http2.ErrorCode v5_2 = (v4_7 & 255);
            int v6_2 = this.g.readInt();
            int v7_2 = (2147483647 & v6_2);
            if (v3_7 != 8) {
                long v10_0 = fc.t.j;
                if (v10_0.isLoggable(java.util.logging.Level.FINE)) {
                    v10_0.fine(fc.f.b(1, v7_2, v1_21, v3_7, v5_2));
                }
            }
            if ((p14 != null) && (v3_7 != 4)) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.t(fc.f.a(v3_7), "Expected a SETTINGS frame but was ");
                return 0;
            } else {
                Throwable v14_6 = 0;
                switch (v3_7) {
                    case 0:
                        this.h(p15, v1_21, v5_2, v7_2);
                        return 1;
                    case 1:
                        this.B(p15, v1_21, v5_2, v7_2);
                        return 1;
                    case 2:
                        if (v1_21 != 5) {
                            oc.l.g(r1.a.h(v1_21, "TYPE_PRIORITY length: ", " != 5"));
                            return 0;
                        } else {
                            if (v7_2 == 0) {
                                oc.l.g("TYPE_PRIORITY streamId == 0");
                                return 0;
                            } else {
                                Throwable v14_45 = this.g;
                                v14_45.readInt();
                                v14_45.readByte();
                                return 1;
                            }
                        }
                    case 3:
                        if (v1_21 != 4) {
                            oc.l.g(r1.a.h(v1_21, "TYPE_RST_STREAM length: ", " != 4"));
                            return 0;
                        } else {
                            if (v7_2 == 0) {
                                oc.l.g("TYPE_RST_STREAM streamId == 0");
                                return 0;
                            } else {
                                fc.x[] v1_16 = this.g.readInt();
                                okhttp3.internal.http2.ErrorCode.h.getClass();
                                fc.j v2_10 = okhttp3.internal.http2.ErrorCode.values();
                                fc.p v4_11 = 0;
                                while (v4_11 < v2_10.length) {
                                    okhttp3.internal.http2.ErrorCode v5_4 = v2_10[v4_11];
                                    if (v5_4.g != v1_16) {
                                        v4_11++;
                                    } else {
                                        v14_6 = v5_4;
                                        break;
                                    }
                                }
                                if (v14_6 == null) {
                                    oc.l.g(r1.a.g(v1_16, "TYPE_RST_STREAM unexpected error code: "));
                                    return 0;
                                } else {
                                    Throwable v15_5 = p15.h;
                                    if ((v7_2 == 0) || ((v6_2 & 1) != 0)) {
                                        Throwable v15_6 = v15_5.i(v7_2);
                                        if (v15_6 == null) {
                                        } else {
                                            try {
                                                if (v15_6.f() == null) {
                                                    v15_6.r = v14_6;
                                                    v15_6.notifyAll();
                                                }
                                            } catch (Throwable v14_41) {
                                                throw v14_41;
                                            }
                                            return 1;
                                        }
                                    } else {
                                        int v0_8 = v15_5.o;
                                        fc.x[] v1_18 = new StringBuilder();
                                        v1_18.append(v15_5.i);
                                        v1_18.append(91);
                                        v1_18.append(v7_2);
                                        v1_18.append("] onReset");
                                        bc.b.c(v0_8, v1_18.toString(), new fc.j(v15_5, v7_2, v14_6));
                                        return 1;
                                    }
                                }
                            }
                        }
                    case 4:
                        Throwable v14_24 = this.g;
                        if (v7_2 != 0) {
                            oc.l.g("TYPE_SETTINGS streamId != 0");
                            return 0;
                        } else {
                            if ((v4_7 & 1) == 0) {
                                if ((v1_21 % 6) != 0) {
                                    oc.l.g(r1.a.g(v1_21, "TYPE_SETTINGS length % 6 != 0: "));
                                    return 0;
                                } else {
                                    int v3_16 = new fc.c0();
                                    fc.x[] v1_9 = com.bumptech.glide.d.A(com.bumptech.glide.d.C(0, v1_21), 6);
                                    fc.p v4_10 = v1_9.g;
                                    okhttp3.internal.http2.ErrorCode v5_3 = v1_9.h;
                                    fc.x[] v1_10 = v1_9.i;
                                    if (((v1_10 > null) && (v4_10 <= v5_3)) || ((v1_10 < null) && (v5_3 <= v4_10))) {
                                        while(true) {
                                            int v6_4 = (v14_24.readShort() & 65535);
                                            int v7_4 = v14_24.readInt();
                                            if (v6_4 == 2) {
                                                if ((v7_4 != 0) && (v7_4 != 1)) {
                                                    break;
                                                }
                                            } else {
                                                if (v6_4 == 4) {
                                                    if (v7_4 < 0) {
                                                        oc.l.g("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                                        return 0;
                                                    }
                                                } else {
                                                    if ((v6_4 == 5) && ((v7_4 < 16384) || (v7_4 > 16777215))) {
                                                        oc.l.g(r1.a.g(v7_4, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
                                                        return 0;
                                                    }
                                                }
                                            }
                                            v3_16.b(v6_4, v7_4);
                                            if (v4_10 != v5_3) {
                                                v4_10 += v1_10;
                                            }
                                        }
                                        oc.l.g("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                                        return 0;
                                    }
                                    Throwable v14_32 = p15.h;
                                    bc.b.c(v14_32.n, r1.a.n(v14_32.i, " applyAndAckSettings", new StringBuilder()), new fc.n(1, p15, v3_16));
                                    return 1;
                                }
                            } else {
                                if (v1_21 != null) {
                                    oc.l.g("FRAME_SIZE_ERROR ack frame should be empty!");
                                    return 0;
                                } else {
                                }
                            }
                        }
                    case 5:
                        this.L(p15, v1_21, v5_2, v7_2);
                        return 1;
                    case 6:
                        if (v1_21 != 8) {
                            oc.l.g(r1.a.g(v1_21, "TYPE_PING length != 8: "));
                            return 0;
                        } else {
                            if (v7_2 != 0) {
                                oc.l.g("TYPE_PING streamId != 0");
                                return 0;
                            } else {
                                Throwable v14_18 = this.g.readInt();
                                fc.x[] v1_7 = this.g.readInt();
                                if ((v4_7 & 1) != 0) {
                                    v0_0 = 1;
                                }
                                fc.j v2_4 = p15.h;
                                if (v0_0 == 0) {
                                    bc.b.c(v2_4.n, r1.a.n(p15.h.i, " ping", new StringBuilder()), new fc.m(p15.h, v14_18, v1_7));
                                    return 1;
                                } else {
                                    if (v14_18 == 1) {
                                        v2_4.r = (v2_4.r + 1);
                                    } else {
                                        if (v14_18 == 2) {
                                            v2_4.t = (v2_4.t + 1);
                                        } else {
                                            if (v14_18 == 3) {
                                                v2_4.notifyAll();
                                            }
                                        }
                                    }
                                    return 1;
                                }
                            }
                        }
                    case 7:
                        if (v1_21 < 8) {
                            oc.l.g(r1.a.g(v1_21, "TYPE_GOAWAY length < 8: "));
                            return 0;
                        } else {
                            if (v7_2 != 0) {
                                oc.l.g("TYPE_GOAWAY streamId != 0");
                                return 0;
                            } else {
                                fc.j v2_1 = this.g.readInt();
                                int v3_1 = this.g.readInt();
                                fc.x[] v1_1 = (v1_21 - 8);
                                okhttp3.internal.http2.ErrorCode.h.getClass();
                                fc.p v4_1 = okhttp3.internal.http2.ErrorCode.values();
                                int v6_0 = 0;
                                while (v6_0 < v4_1.length) {
                                    int v7_0 = v4_1[v6_0];
                                    if (v7_0.g != v3_1) {
                                        v6_0++;
                                    } else {
                                        v14_6 = v7_0;
                                        break;
                                    }
                                }
                                if (v14_6 == null) {
                                    oc.l.g(r1.a.g(v3_1, "TYPE_GOAWAY unexpected error code: "));
                                    return 0;
                                } else {
                                    Throwable v14_9 = okio.ByteString.j;
                                    if (v1_1 > null) {
                                        v14_9 = this.g.j(((long) v1_1));
                                    }
                                    v14_9.getClass();
                                    v14_9.e();
                                    Throwable v14_11 = p15.h;
                                    try {
                                        int v3_4 = new fc.x[0];
                                        fc.x[] v1_4 = v14_11.h.values().toArray(v3_4);
                                        v14_11.l = 1;
                                        fc.x[] v1_5 = ((fc.x[]) v1_4);
                                        Throwable v14_12 = v1_5.length;
                                    } catch (Throwable v15_1) {
                                        throw v15_1;
                                    }
                                    while (v0_0 < v14_12) {
                                        int v3_6 = v1_5[v0_0];
                                        if ((v3_6.g > v2_1) && (v3_6.g())) {
                                            try {
                                                if (v3_6.f() == null) {
                                                    v3_6.r = okhttp3.internal.http2.ErrorCode.m;
                                                    v3_6.notifyAll();
                                                }
                                                p15.h.i(v3_6.g);
                                            } catch (Throwable v14_13) {
                                                throw v14_13;
                                            }
                                        }
                                        v0_0++;
                                    }
                                }
                            }
                        }
                    case 8:
                        if (v1_21 != 4) {
                            int v0_11 = new StringBuilder("TYPE_WINDOW_UPDATE length !=4: ");
                            v0_11.append(v1_21);
                            throw new java.io.IOException(v0_11.toString());
                        } else {
                            fc.j v2_17 = (2147483647 & ((long) this.g.readInt()));
                            Throwable v14_52 = v2_17 cmp 0;
                            if (v14_52 == null) {
                                throw new java.io.IOException("windowSizeIncrement was 0");
                            } else {
                                int v0_13 = fc.t.j;
                                if (v0_13.isLoggable(java.util.logging.Level.FINE)) {
                                    v0_13.fine(fc.f.c(1, v7_2, v1_21, v2_17));
                                }
                                Throwable v15_13 = p15.h;
                                if (v7_2 != 0) {
                                    Throwable v15_14 = v15_13.h(v7_2);
                                    if (v15_14 == null) {
                                    } else {
                                        try {
                                            v15_14.k = (v15_14.k + v2_17);
                                        } catch (Throwable v14_57) {
                                            throw v14_57;
                                        }
                                        if (v14_52 > null) {
                                            v15_14.notifyAll();
                                        }
                                        return 1;
                                    }
                                } else {
                                    try {
                                        v15_13.A = (v15_13.A + v2_17);
                                        v15_13.notifyAll();
                                        return 1;
                                    } catch (Throwable v14_1) {
                                        throw v14_1;
                                    }
                                }
                            }
                        }
                    default:
                        this.g.skip(((long) v1_21));
                        return 1;
                }
                return 1;
            }
        }
    }

    public final void h(fc.o p17, int p18, int p19, int p20)
    {
        if (p20 == 0) {
            oc.l.g("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
            return;
        } else {
            oc.i v7_0;
            if ((p19 & 1) == 0) {
                v7_0 = 0;
            } else {
                v7_0 = 1;
            }
            if ((p19 & 32) != 0) {
                oc.l.g("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
                return;
            } else {
                int v8;
                if ((p19 & 8) == 0) {
                    v8 = 0;
                } else {
                    v8 = (this.g.readByte() & 255);
                }
                long v10_3;
                fc.x v2_5 = fc.r.a(p18, p19, v8);
                fc.p v3_9 = this.g;
                v3_9.getClass();
                fc.x v9_0 = p17.h;
                if ((p20 == 0) || ((p20 & 1) != 0)) {
                    v10_3 = 0;
                } else {
                    v10_3 = 1;
                }
                if (v10_3 == 0) {
                    fc.x v9_1 = v9_0.h(p20);
                    if (v9_1 != null) {
                        Throwable v0_7 = v9_1.n;
                        long v10_4 = ((long) v2_5);
                        v0_7.getClass();
                        long v12 = v10_4;
                        while (v12 > 0) {
                            try {
                                int v6_7;
                                int v19_1 = v7_0;
                            } catch (Throwable v0_12) {
                                throw v0_12;
                            }
                            if ((v0_7.j.h + v12) <= v0_7.g) {
                                v6_7 = 0;
                            } else {
                                v6_7 = 1;
                            }
                            if (v6_7 == 0) {
                                if (!v0_7.h) {
                                    int v6_8 = v3_9.N(v12, v0_7.i);
                                    if (v6_8 == -1) {
                                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
                                        return;
                                    } else {
                                        v12 -= v6_8;
                                        fc.x v2_11 = v0_7.l;
                                        if (!v0_7.k) {
                                            int v6_11;
                                            oc.i v4_4 = v0_7.j;
                                            if (v4_4.h != 0) {
                                                v6_11 = 0;
                                            } else {
                                                v6_11 = 1;
                                            }
                                            v4_4.n0(v0_7.i);
                                            if (v6_11 != 0) {
                                                v2_11.notifyAll();
                                            }
                                        } else {
                                            v0_7.i.d();
                                        }
                                        v7_0 = v19_1;
                                    }
                                } else {
                                    v3_9.skip(v12);
                                }
                            } else {
                                v3_9.skip(v12);
                                v0_7.l.e(okhttp3.internal.http2.ErrorCode.l);
                            }
                            if (v19_1 != 0) {
                                v9_1.i(yb.s.h, 1);
                            }
                        }
                        v19_1 = v7_0;
                        v0_7.l.h.L(v10_4);
                        v0_7.l.h.v.getClass();
                    } else {
                        p17.h.Z(p20, okhttp3.internal.http2.ErrorCode.j);
                        oc.i v4_0 = ((long) v2_5);
                        p17.h.L(v4_0);
                        v3_9.skip(v4_0);
                    }
                } else {
                    int v5_3 = new oc.i();
                    long v10_0 = ((long) v2_5);
                    v3_9.W(v10_0);
                    v3_9.N(v10_0, v5_3);
                    Throwable v0_4 = v9_0.o;
                    fc.p v3_2 = new StringBuilder();
                    v3_2.append(v9_0.i);
                    v3_2.append(91);
                    v3_2.append(p20);
                    v3_2.append("] onData");
                    bc.b.c(v0_4, v3_2.toString(), new fc.h(v9_0, p20, v5_3, v2_5, v7_0));
                }
                this.g.skip(((long) v8));
                return;
            }
        }
    }

    public final java.util.List i(int p5, int p6, int p7, int p8)
    {
        int v0_0 = this.h;
        v0_0.k = p5;
        v0_0.h = p5;
        v0_0.l = p6;
        v0_0.i = p7;
        v0_0.j = p8;
        int v5_5 = this.i;
        String v6_2 = v5_5.c;
        java.util.ArrayList v7_1 = v5_5.b;
        while (!v6_2.d()) {
            int v8_6 = v6_2.readByte();
            int v0_5 = (v8_6 & 255);
            if (v0_5 == 128) {
                oc.l.g("index == 0");
                return 0;
            } else {
                if ((v8_6 & 128) != 128) {
                    if (v0_5 != 64) {
                        if ((v8_6 & 64) != 64) {
                            if ((v8_6 & 32) != 32) {
                                if ((v0_5 != 16) && (v0_5 != 0)) {
                                    v7_1.add(new fc.b(v5_5.b((v5_5.e(v0_5, 15) - 1)), v5_5.d()));
                                } else {
                                    int v8_13 = v5_5.d();
                                    fc.e.a(v8_13);
                                    v7_1.add(new fc.b(v8_13, v5_5.d()));
                                }
                            } else {
                                int v8_15 = v5_5.e(v0_5, 31);
                                v5_5.a = v8_15;
                                if ((v8_15 < 0) || (v8_15 > 4096)) {
                                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.d(v5_5.a, "Invalid dynamic table size update ");
                                    return 0;
                                } else {
                                    int v0_9 = v5_5.g;
                                    if (v8_15 < v0_9) {
                                        if (v8_15 != 0) {
                                            v5_5.a((v0_9 - v8_15));
                                        } else {
                                            int v8_16 = v5_5.d;
                                            ha.i.N(v8_16, 0, v8_16.length);
                                            v5_5.e = (v5_5.d.length - 1);
                                            v5_5.f = 0;
                                            v5_5.g = 0;
                                        }
                                    }
                                }
                            }
                        } else {
                            v5_5.c(new fc.b(v5_5.b((v5_5.e(v0_5, 63) - 1)), v5_5.d()));
                        }
                    } else {
                        int v8_24 = v5_5.d();
                        fc.e.a(v8_24);
                        v5_5.c(new fc.b(v8_24, v5_5.d()));
                    }
                } else {
                    int v8_3 = v5_5.e(v0_5, 127);
                    int v0_2 = (v8_3 - 1);
                    if (v0_2 >= 0) {
                        int v2_0 = fc.e.a;
                        if (v0_2 <= (v2_0.length - 1)) {
                            v7_1.add(v2_0[v0_2]);
                        }
                    }
                    int v2_5 = ((v5_5.e + 1) + (v0_2 - fc.e.a.length));
                    if (v2_5 >= 0) {
                        int v0_4 = v5_5.d;
                        if (v2_5 < v0_4.length) {
                            int v8_4 = v0_4[v2_5];
                            v8_4.getClass();
                            v7_1.add(v8_4);
                        }
                    }
                    oc.l.g(r1.a.g(v8_3, "Header index too large "));
                    return 0;
                }
            }
        }
        int v5_3 = ha.j.U(v7_1);
        v7_1.clear();
        return v5_3;
    }
}
