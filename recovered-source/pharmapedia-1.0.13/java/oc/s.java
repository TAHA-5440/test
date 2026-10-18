// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public final class s implements oc.d0 {
    public byte g;
    public final oc.y h;
    public final java.util.zip.Inflater i;
    public final oc.t j;
    public final java.util.zip.CRC32 k;

    public s(oc.k p3)
    {
        p3.getClass();
        oc.y v0_1 = new oc.y(p3);
        this.h = v0_1;
        java.util.zip.CRC32 v3_4 = new java.util.zip.Inflater(1);
        this.i = v3_4;
        this.j = new oc.t(v0_1, v3_4);
        this.k = new java.util.zip.CRC32();
        return;
    }

    public static void d(int p2, int p3, String p4)
    {
        if (p3 != p2) {
            StringBuilder v4_1 = f0.a.g(p4, ": actual 0x");
            v4_1.append(db.i.e0(8, oc.b.i(p3)));
            v4_1.append(" != expected 0x");
            v4_1.append(db.i.e0(8, oc.b.i(p2)));
            throw new java.io.IOException(v4_1.toString());
        } else {
            return;
        }
    }

    public final long N(long p24, oc.i p26)
    {
        oc.s v0_0 = this;
        p26.getClass();
        String v3_4 = p24 cmp 0;
        if (v3_4 < null) {
            oc.l.d(f0.a.b("byteCount < 0: ", p24));
        } else {
            if (v3_4 != null) {
                java.util.zip.CRC32 v9 = this.k;
                oc.y v11 = this.h;
                if (this.g == 0) {
                    int v20;
                    v11.W(10);
                    short v1_14 = v11.h;
                    byte v19 = v1_14.L(3);
                    if (((v19 >> 1) & 1) != 1) {
                        v20 = 0;
                    } else {
                        v20 = 1;
                    }
                    if (v20 != 0) {
                        this.h(v1_14, 0, 10);
                    }
                    oc.s.d(8075, v11.readShort(), "ID1ID2");
                    v11.skip(8);
                    if (((v19 >> 2) & 1) == 1) {
                        v11.W(2);
                        if (v20 != 0) {
                            this.h(v1_14, 0, 2);
                        }
                        long v4_3 = ((long) (v1_14.g0() & 65535));
                        v11.W(v4_3);
                        if (v20 != 0) {
                            this.h(v1_14, 0, v4_3);
                        }
                        v11.skip(v4_3);
                    }
                    if (((v19 >> 3) & 1) == 1) {
                        long v12_3 = v11.h(0, 0, 9223372036854775807);
                        if (v12_3 == -1) {
                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
                            return 0;
                        } else {
                            if (v20 != 0) {
                                this.h(v1_14, 0, (v12_3 + 1));
                            }
                            v11.skip((v12_3 + 1));
                        }
                    }
                    if (((v19 >> 4) & 1) != 1) {
                        v0_0 = this;
                    } else {
                        long v12_6 = v11.h(0, 0, 9223372036854775807);
                        if (v12_6 == -1) {
                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
                            return 0;
                        } else {
                            if (v20 == 0) {
                                v0_0 = this;
                            } else {
                                v0_0 = this;
                                this.h(v1_14, 0, (v12_6 + 1));
                            }
                            v11.skip((v12_6 + 1));
                        }
                    }
                    if (v20 != 0) {
                        oc.s.d(v11.M(), ((short) ((int) v9.getValue())), "FHCRC");
                        v9.reset();
                    }
                    v0_0.g = 1;
                }
                if (v0_0.g == 1) {
                    short v2_3 = p26.h;
                    long v4_0 = v0_0.j.N(p24, p26);
                    if (v4_0 == -1) {
                        v0_0.g = 2;
                    } else {
                        v0_0.h(p26, v2_3, v4_0);
                        return v4_0;
                    }
                }
                if (v0_0.g == 2) {
                    oc.s.d(v11.B(), ((int) v9.getValue()), "CRC");
                    oc.s.d(v11.B(), ((int) v0_0.i.getBytesWritten()), "ISIZE");
                    v0_0.g = 3;
                    if (!v11.d()) {
                        oc.l.g("gzip finished without exhausting source");
                        return 0;
                    }
                }
                return -1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    public final oc.f0 a()
    {
        return this.h.g.a();
    }

    public final void close()
    {
        this.j.close();
        return;
    }

    public final void h(oc.i p5, long p6, long p8)
    {
        oc.z v5_1 = p5.g;
        v5_1.getClass();
        while(true) {
            long v0_0 = v5_1.c;
            int v1 = v5_1.b;
            if (p6 < ((long) (v0_0 - v1))) {
                break;
            }
            p6 -= ((long) (v0_0 - v1));
            v5_1 = v5_1.f;
            v5_1.getClass();
        }
        while (p8 > 0) {
            long v6_1 = ((int) (((long) v5_1.b) + p6));
            int v7_2 = ((int) Math.min(((long) (v5_1.c - v6_1)), p8));
            this.k.update(v5_1.a, v6_1, v7_2);
            p8 -= ((long) v7_2);
            v5_1 = v5_1.f;
            v5_1.getClass();
            p6 = 0;
        }
        return;
    }
}
