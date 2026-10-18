// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final class y implements java.io.Closeable {
    public static final java.util.logging.Logger l;
    public final oc.j g;
    public final oc.i h;
    public int i;
    public boolean j;
    public final fc.d k;

    static y()
    {
        fc.y.l = java.util.logging.Logger.getLogger(fc.f.getName());
        return;
    }

    public y(oc.x p2)
    {
        p2.getClass();
        this.g = p2;
        oc.i v2_2 = new oc.i();
        this.h = v2_2;
        this.i = 16384;
        this.k = new fc.d(v2_2);
        return;
    }

    public final void B(int p4, okhttp3.internal.http2.ErrorCode p5, byte[] p6)
    {
        try {
            if (this.j) {
                throw new java.io.IOException("closed");
            } else {
                if (p5.g == -1) {
                    throw new IllegalArgumentException("errorCode.httpCode == -1");
                } else {
                    this.i(0, (p6.length + 8), 7, 0);
                    this.g.writeInt(p4);
                    this.g.writeInt(p5.g);
                    if (p6.length != 0) {
                        this.g.write(p6);
                    } else {
                    }
                    this.g.flush();
                    return;
                }
            }
        } catch (oc.j v4_5) {
            throw v4_5;
        }
    }

    public final void L(boolean p9, int p10, java.util.ArrayList p11)
    {
        try {
            if (this.j) {
                throw new java.io.IOException("closed");
            } else {
                long v6_0;
                this.k.d(p11);
                long v0_3 = this.h.h;
                int v2_1 = Math.min(((long) this.i), v0_3);
                oc.i v11_2 = v0_3 cmp v2_1;
                if (v11_2 != null) {
                    v6_0 = 0;
                } else {
                    v6_0 = 4;
                }
                if (p9 != null) {
                    v6_0 |= 1;
                }
                this.i(p10, ((int) v2_1), 1, v6_0);
                this.g.D(v2_1, this.h);
                if (v11_2 > null) {
                    long v0_1 = (v0_3 - v2_1);
                    while (v0_1 > 0) {
                        oc.i v11_4;
                        long v6_3 = Math.min(((long) this.i), v0_1);
                        v0_1 -= v6_3;
                        if (v0_1 != 0) {
                            v11_4 = 0;
                        } else {
                            v11_4 = 4;
                        }
                        this.i(p10, ((int) v6_3), 9, v11_4);
                        this.g.D(v6_3, this.h);
                    }
                }
                return;
            }
        } catch (oc.j v9_8) {
            throw v9_8;
        }
    }

    public final void M(int p4, boolean p5, int p6)
    {
        try {
            if (this.j) {
                throw new java.io.IOException("closed");
            } else {
                this.i(0, 8, 6, p5);
                this.g.writeInt(p4);
                this.g.writeInt(p6);
                this.g.flush();
                return;
            }
        } catch (java.io.IOException v4_5) {
            throw v4_5;
        }
    }

    public final void Z(int p4, okhttp3.internal.http2.ErrorCode p5)
    {
        try {
            if (this.j) {
                throw new java.io.IOException("closed");
            } else {
                if (p5.g == -1) {
                    throw new IllegalArgumentException("Failed requirement.");
                } else {
                    this.i(p4, 4, 3, 0);
                    this.g.writeInt(p5.g);
                    this.g.flush();
                    return;
                }
            }
        } catch (String v4_1) {
            throw v4_1;
        }
    }

    public final void c0(int p5, long p6)
    {
        if (this.j) {
            throw new java.io.IOException("closed");
        } else {
            if ((p6 == 0) || (p6 > 2147483647)) {
                oc.j v5_2 = new StringBuilder("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: ");
                v5_2.append(p6);
                throw new IllegalArgumentException(v5_2.toString().toString());
            } else {
                int v0_1 = fc.y.l;
                if (v0_1.isLoggable(java.util.logging.Level.FINE)) {
                    v0_1.fine(fc.f.c(0, p5, 4, p6));
                }
                this.i(p5, 4, 8, 0);
                this.g.writeInt(((int) p6));
                this.g.flush();
                return;
            }
        }
    }

    public final void close()
    {
        try {
            this.j = 1;
            this.g.close();
            return;
        } catch (Throwable v0_2) {
            throw v0_2;
        }
    }

    public final void d(fc.c0 p6)
    {
        p6.getClass();
        if (this.j) {
            throw new java.io.IOException("closed");
        } else {
            fc.d v0_2 = this.i;
            int v1_7 = p6.a;
            if ((v1_7 & 32) != 0) {
                v0_2 = p6.b[5];
            }
            fc.d v0_4;
            this.i = v0_2;
            int v2_1 = -1;
            if ((v1_7 & 2) == 0) {
                v0_4 = -1;
            } else {
                v0_4 = p6.b[1];
            }
            if (v0_4 != -1) {
                fc.d v0_6 = this.k;
                if ((v1_7 & 2) != 0) {
                    v2_1 = p6.b[1];
                }
                v0_6.getClass();
                int v6_4 = Math.min(v2_1, 16384);
                int v1_1 = v0_6.d;
                if (v1_1 != v6_4) {
                    if (v6_4 < v1_1) {
                        v0_6.b = Math.min(v0_6.b, v6_4);
                    }
                    v0_6.c = 1;
                    v0_6.d = v6_4;
                    int v1_4 = v0_6.h;
                    if (v6_4 < v1_4) {
                        if (v6_4 != 0) {
                            v0_6.a((v1_4 - v6_4));
                        } else {
                            int v6_5 = v0_6.e;
                            ha.i.N(v6_5, 0, v6_5.length);
                            v0_6.f = (v0_6.e.length - 1);
                            v0_6.g = 0;
                            v0_6.h = 0;
                        }
                    }
                } else {
                }
            }
            this.i(0, 0, 4, 1);
            this.g.flush();
            return;
        }
    }

    public final void flush()
    {
        try {
            if (this.j) {
                throw new java.io.IOException("closed");
            } else {
                this.g.flush();
                return;
            }
        } catch (java.io.IOException v0_3) {
            throw v0_3;
        }
    }

    public final void h(boolean p3, int p4, oc.i p5, int p6)
    {
        try {
            if (this.j) {
                throw new java.io.IOException("closed");
            } else {
                this.i(p4, p6, 0, p3);
                if (p6 > 0) {
                    oc.j v3_4 = this.g;
                    p5.getClass();
                    v3_4.D(((long) p6), p5);
                }
                return;
            }
        } catch (oc.j v3_1) {
            throw v3_1;
        }
    }

    public final void i(int p3, int p4, int p5, int p6)
    {
        if (p5 != 8) {
            int v1_0 = fc.y.l;
            if (v1_0.isLoggable(java.util.logging.Level.FINE)) {
                v1_0.fine(fc.f.b(0, p3, p4, p5, p6));
            }
        }
        if (p4 > this.i) {
            String v3_1 = this.i;
            StringBuilder v5_2 = new StringBuilder("FRAME_SIZE_ERROR length > ");
            v5_2.append(v3_1);
            v5_2.append(": ");
            v5_2.append(p4);
            throw new IllegalArgumentException(v5_2.toString().toString());
        } else {
            if ((-2147483648 & p3) != 0) {
                oc.l.d(r1.a.g(p3, "reserved bit set: "));
                return;
            } else {
                oc.j v0_5 = this.g;
                v0_5.getClass();
                v0_5.writeByte(((p4 >> 16) & 255));
                v0_5.writeByte(((p4 >> 8) & 255));
                v0_5.writeByte((p4 & 255));
                v0_5.writeByte((p5 & 255));
                v0_5.writeByte((p6 & 255));
                v0_5.writeInt((p3 & 2147483647));
                return;
            }
        }
    }
}
