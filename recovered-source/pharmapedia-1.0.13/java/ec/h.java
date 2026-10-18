// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ec;
public final class h implements dc.e {
    public static final yb.s f;
    public final yb.y a;
    public final dc.d b;
    public final androidx.lifecycle.j c;
    public int d;
    public final ec.a e;

    static h()
    {
        yb.s v0_10 = ((String[]) java.util.Arrays.copyOf(new String[] {"OkHttp-Response-Body", "Truncated"}), 2));
        if ((v0_10.length % 2) != 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Expected alternating header names and values");
            return;
        } else {
            String[] v2_3 = ((String[]) java.util.Arrays.copyOf(v0_10, v0_10.length));
            String v3_0 = v2_3.length;
            int v4 = 0;
            int v5 = 0;
            while (v5 < v3_0) {
                if (v2_3[v5] == null) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Headers cannot be null");
                    return;
                } else {
                    v2_3[v5] = db.i.o0(v0_10[v5]).toString();
                    v5++;
                }
            }
            yb.s v0_4 = com.bumptech.glide.e.i(0, (v2_3.length - 1), 2);
            if (v0_4 >= null) {
                while(true) {
                    String v1_1 = v2_3[v4];
                    String v3_2 = v2_3[(v4 + 1)];
                    com.bumptech.glide.j.Q(v1_1);
                    com.bumptech.glide.j.R(v3_2, v1_1);
                    if (v4 == v0_4) {
                        break;
                    }
                    v4 += 2;
                }
            }
            ec.h.f = new yb.s(v2_3);
            return;
        }
    }

    public h(yb.y p1, dc.d p2, androidx.lifecycle.j p3)
    {
        p3.getClass();
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.e = new ec.a(((oc.y) p3.i));
        return;
    }

    public final void a()
    {
        ((oc.x) this.c.j).flush();
        return;
    }

    public final boolean b()
    {
        if (this.d != 6) {
            return 0;
        } else {
            return 1;
        }
    }

    public final long c(yb.b0 p3)
    {
        if (dc.f.a(p3)) {
            long v0_6 = p3.l.a("Transfer-Encoding");
            if (v0_6 == 0) {
                v0_6 = 0;
            }
            if (!"chunked".equalsIgnoreCase(v0_6)) {
                return zb.e.e(p3);
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }

    public final void cancel()
    {
        this.b.cancel();
        return;
    }

    public final void d(lc.a p5)
    {
        String v0_7 = this.b.h().b.type();
        v0_7.getClass();
        StringBuilder v1_1 = new StringBuilder();
        v1_1.append(((String) p5.g));
        v1_1.append(32);
        String v2_3 = ((yb.u) p5.b);
        if ((v2_3.f()) || (v0_7 != java.net.Proxy$Type.HTTP)) {
            String v0_2 = v2_3.b();
            String v2_4 = v2_3.d();
            if (v2_4 != null) {
                StringBuilder v3_3 = new StringBuilder();
                v3_3.append(v0_2);
                v3_3.append(63);
                v3_3.append(v2_4);
                v0_2 = v3_3.toString();
            }
            v1_1.append(v0_2);
        } else {
            v1_1.append(v2_3);
        }
        v1_1.append(" HTTP/1.1");
        this.l(((yb.s) p5.c), v1_1.toString());
        return;
    }

    public final yb.a0 e(boolean p11)
    {
        int v0_0 = this.e;
        java.io.IOException v1_0 = this.d;
        if ((v1_0 != null) && ((v1_0 != 1) && ((v1_0 != 2) && (v1_0 != 3)))) {
            oc.l.k(this.d, "state: ");
            return 0;
        } else {
            java.io.IOException v1_3 = ((oc.k) v0_0.c).y(v0_0.b);
            v0_0.b = (v0_0.b - ((long) v1_3.length()));
            java.io.IOException v1_4 = com.bumptech.glide.g.r(v1_3);
            int v3_3 = v1_4.b;
            yb.a0 v4_1 = new yb.a0();
            v4_1.b = ((okhttp3.Protocol) v1_4.c);
            v4_1.c = v3_3;
            v4_1.d = ((String) v1_4.d);
            java.io.IOException v1_8 = new g7.c1(10, 0);
            while(true) {
                String v5_7 = ((oc.k) v0_0.c).y(v0_0.b);
                v0_0.b = (v0_0.b - ((long) v5_7.length()));
                if (v5_7.length() == 0) {
                    break;
                }
                v1_8.b(v5_7);
            }
            v4_1.f = v1_8.h().c();
            if ((p11 == 0) || (v3_3 != 100)) {
                if (v3_3 != 100) {
                    if ((102 > v3_3) || (v3_3 >= 200)) {
                        this.d = 4;
                        return v4_1;
                    } else {
                        this.d = 3;
                        return v4_1;
                    }
                } else {
                    this.d = 3;
                    return v4_1;
                }
            } else {
                return 0;
            }
        }
    }

    public final oc.d0 f(yb.b0 p10)
    {
        ec.g v0_0 = p10.g;
        if (dc.f.a(p10)) {
            boolean v1_3 = p10.l.a("Transfer-Encoding");
            if (!v1_3) {
                v1_3 = 0;
            }
            if (!"chunked".equalsIgnoreCase(v1_3)) {
                long v5 = zb.e.e(p10);
                if (v5 == -1) {
                    int v10_3 = ((yb.u) v0_0.b);
                    if (this.d != 4) {
                        oc.l.k(this.d, "state: ");
                        return 0;
                    } else {
                        this.d = 5;
                        this.b.f();
                        v10_3.getClass();
                        return new ec.g(this, v10_3);
                    }
                } else {
                    return this.k(((yb.u) v0_0.b), v5);
                }
            } else {
                int v10_10 = ((yb.u) v0_0.b);
                if (this.d != 4) {
                    oc.l.k(this.d, "state: ");
                    return 0;
                } else {
                    this.d = 5;
                    return new ec.d(this, v10_10);
                }
            }
        } else {
            return this.k(((yb.u) v0_0.b), 0);
        }
    }

    public final void g()
    {
        ((oc.x) this.c.j).flush();
        return;
    }

    public final oc.c0 h()
    {
        return this.c;
    }

    public final dc.d i()
    {
        return this.b;
    }

    public final oc.b0 j(lc.a p6, long p7)
    {
        if (!"chunked".equalsIgnoreCase(((yb.s) p6.c).a("Transfer-Encoding"))) {
            if (p7 == -1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Cannot stream a request body without chunked encoding or a known content length!");
                return 0;
            } else {
                if (this.d != 1) {
                    oc.l.k(this.d, "state: ");
                    return 0;
                } else {
                    this.d = 2;
                    return new ec.f(this);
                }
            }
        } else {
            if (this.d != 1) {
                oc.l.k(this.d, "state: ");
                return 0;
            } else {
                this.d = 2;
                return new ec.c(this);
            }
        }
    }

    public final ec.e k(yb.u p3, long p4)
    {
        if (this.d != 4) {
            oc.l.k(this.d, "state: ");
            return 0;
        } else {
            this.d = 5;
            return new ec.e(this, p3, p4);
        }
    }

    public final void l(yb.s p6, String p7)
    {
        p6.getClass();
        if (this.d != 0) {
            oc.l.k(this.d, "state: ");
            return;
        } else {
            androidx.lifecycle.j v0_1 = this.c;
            int v1_2 = ((oc.x) v0_1.j);
            v1_2.G(p7);
            v1_2.G("\r\n");
            int v1_0 = p6.size();
            int v2 = 0;
            while(true) {
                oc.x v3_1 = ((oc.x) v0_1.j);
                if (v2 >= v1_0) {
                    break;
                }
                v3_1.G(p6.b(v2));
                v3_1.G(": ");
                v3_1.G(p6.e(v2));
                v3_1.G("\r\n");
                v2++;
            }
            v3_1.G("\r\n");
            this.d = 1;
            return;
        }
    }
}
