// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ec;
public final class d extends ec.b {
    public long k;
    public boolean l;
    public final synthetic ec.h m;

    public d(ec.h p1, yb.u p2)
    {
        p2.getClass();
        this.m = p1;
        super(p1, p2);
        super.k = -1;
        super.l = 1;
        return;
    }

    public final long N(long p17, oc.i p19)
    {
        NumberFormatException v0_8 = this.m;
        yb.s v4_9 = v0_8.c;
        p19.getClass();
        if (p17 < 0) {
            oc.l.d(f0.a.b("byteCount < 0: ", p17));
            return 0;
        } else {
            if (this.i) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
                return 0;
            } else {
                if (this.l) {
                    long v10_3 = this.k;
                    if ((v10_3 == 0) || (v10_3 == -1)) {
                        if (v10_3 != -1) {
                            ((oc.y) v4_9.i).y(9223372036854775807);
                        }
                        try {
                            int v7_11 = ((oc.y) v4_9.i);
                            long v10_5 = v7_11.h;
                            v7_11.W(1);
                            long v12_2 = 0;
                        } catch (NumberFormatException v0_2) {
                            throw new java.net.ProtocolException(v0_2.getMessage());
                        }
                        while(true) {
                            int v13 = (v12_2 + 1);
                            if (v7_11.c0(((long) v13))) {
                                byte v14_3 = v10_5.L(((long) v12_2));
                                if (((v14_3 < 48) || (v14_3 > 57)) && ((v14_3 < 97) || (v14_3 > 102))) {
                                    if (v14_3 >= 65) {
                                        if (v14_3 > 70) {
                                            break;
                                        }
                                        v12_2 = v13;
                                    }
                                    if (v12_2 == 0) {
                                        a.a.c(16);
                                        String v2_11 = Integer.toString(v14_3, 16);
                                        v2_11.getClass();
                                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(v2_11));
                                    } else {
                                        this.k = v10_5.f0();
                                        yb.s v4_14 = db.i.o0(((oc.y) v4_9.i).y(9223372036854775807)).toString();
                                        if ((this.k < 0) || ((v4_14.length() > 0) && (!db.p.Q(v4_14, ";", 0)))) {
                                            String v2_14 = new StringBuilder();
                                            v2_14.append("expected chunk size and optional extensions but was \"");
                                            v2_14.append(this.k);
                                            v2_14.append(v4_14);
                                            v2_14.append(34);
                                            throw new java.net.ProtocolException(v2_14.toString());
                                        } else {
                                            if (this.k == 0) {
                                                this.l = 0;
                                                yb.s v4_1 = v0_8.e;
                                                v4_1.getClass();
                                                g7.c1 v5_2 = new g7.c1(10, 0);
                                                while(true) {
                                                    String v6_3 = ((oc.k) v4_1.c).y(v4_1.b);
                                                    v4_1.b = (v4_1.b - ((long) v6_3.length()));
                                                    if (v6_3.length() == 0) {
                                                        break;
                                                    }
                                                    v5_2.b(v6_3);
                                                }
                                                this.d(v5_2.h());
                                            }
                                            if (this.l) {
                                                String v2_6 = super.N(Math.min(p17, this.k), p19);
                                                if (v2_6 == -1) {
                                                    v0_8.b.f();
                                                    NumberFormatException v0_6 = new java.net.ProtocolException("unexpected end of stream");
                                                    this.d(ec.h.f);
                                                    throw v0_6;
                                                } else {
                                                    this.k = (this.k - v2_6);
                                                    return v2_6;
                                                }
                                            } else {
                                                return -1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return -1;
            }
        }
    }

    public final void close()
    {
        if (!this.i) {
            if (this.l) {
                java.util.concurrent.TimeUnit.MILLISECONDS.getClass();
                try {
                    yb.s v0_1 = zb.e.f(this, 100);
                } catch (java.io.IOException) {
                    v0_1 = 0;
                }
                if (v0_1 == null) {
                    this.m.b.f();
                    this.d(ec.h.f);
                }
            }
            this.i = 1;
            return;
        } else {
            return;
        }
    }
}
