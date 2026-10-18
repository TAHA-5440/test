// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ac;
public final class k implements java.io.Closeable, java.io.Flushable {
    public static final String A;
    public static final String B;
    public static final String C;
    public static final String D;
    public static final kotlin.text.Regex z;
    public final oc.w g;
    public final ac.j h;
    public final long i;
    public final oc.w j;
    public final oc.w k;
    public final oc.w l;
    public long m;
    public oc.x n;
    public final java.util.LinkedHashMap o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public long w;
    public final bc.b x;
    public final ac.i y;

    static k()
    {
        ac.k.z = new kotlin.text.Regex("[a-z0-9_-]{1,120}");
        ac.k.A = "CLEAN";
        ac.k.B = "DIRTY";
        ac.k.C = "REMOVE";
        ac.k.D = "READ";
        return;
    }

    public k(oc.o p4, oc.w p5, long p6, bc.d p8)
    {
        p4.getClass();
        p8.getClass();
        this.g = p5;
        this.h = new ac.j(p4);
        this.i = p6;
        this.o = new java.util.LinkedHashMap(0, 1061158912, 1);
        this.x = p8.d();
        this.y = new ac.i(r1.a.n(zb.e.b, " Cache", new StringBuilder()), 0, this);
        if (p6 <= 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("maxSize <= 0");
            throw 0;
        } else {
            this.j = p5.d("journal");
            this.k = p5.d("journal.tmp");
            this.l = p5.d("journal.bkp");
            return;
        }
    }

    public static void i0(String p2)
    {
        if (!ac.k.z.b(p2)) {
            oc.l.d(r1.a.k("keys must match regex [a-z0-9_-]{1,120}: \"", p2, 34));
            return;
        } else {
            return;
        }
    }

    public final declared_synchronized ac.h B(String p4)
    {
        p4.getClass();
        this.L();
        this.d();
        ac.k.i0(p4);
        ac.h v0_3 = ((ac.g) this.o.get(p4));
        if (v0_3 != null) {
            ac.h v0_0 = v0_3.a();
            if (v0_0 != null) {
                this.p = (this.p + 1);
                ac.i v1_2 = this.n;
                v1_2.getClass();
                v1_2.G(ac.k.D);
                v1_2.writeByte(32);
                v1_2.G(p4);
                v1_2.writeByte(10);
                if (this.M()) {
                    bc.b.e(this.x, this.y);
                }
                return v0_0;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public final declared_synchronized void L()
    {
        if (!this.s) {
            if (this.h.L(this.l)) {
                ic.e v2_1 = this.h;
                int v3_0 = this.l;
                if (!this.h.L(this.j)) {
                    v2_1.h(v3_0, this.j);
                } else {
                    v2_1.getClass();
                    v3_0.getClass();
                    v2_1.B(v3_0);
                }
            }
            oc.w v1_3 = this.h;
            ic.e v2_2 = this.l;
            Class vtmp3 = v1_3.getClass();
            v2_2.getClass();
            int v3_1 = v1_3.d0(v2_2);
            try {
                v1_3.h.B(v2_2);
                try {
                    if (v3_1 != 0) {
                        v3_1.close();
                    }
                } catch (Throwable) {
                }
                oc.w v1_6 = 1;
                this.r = v1_6;
                if (this.h.L(this.j)) {
                    try {
                        this.d0();
                        this.c0();
                        this.s = 1;
                        return;
                    } catch (oc.w v1_9) {
                        int v3_5 = new StringBuilder("DiskLruCache ");
                        v3_5.append(this.g);
                        v3_5.append(" is corrupt: ");
                        v3_5.append(v1_9.getMessage());
                        v3_5.append(", removing");
                        ic.e.a.i(5, v3_5.toString(), v1_9);
                        this.close();
                        zb.c.b(this.h, this.g);
                        this.t = 0;
                    }
                }
                this.f0();
                this.s = 1;
                return;
            } catch (java.io.IOException) {
                if (v3_1 == 0) {
                    int v3_3 = 0;
                } else {
                    try {
                        v3_1.close();
                    } catch (int v3_3) {
                    }
                }
                Throwable v6_1 = v3_3;
                if (v6_1 != null) {
                    throw v6_1;
                } else {
                    v1_3.h.B(v2_2);
                    v1_6 = 0;
                }
            } catch (Throwable v6_1) {
                if (v3_1 == 0) {
                } else {
                    try {
                        v3_1.close();
                    } catch (int v3_2) {
                        com.bumptech.glide.i.d(v6_1, v3_2);
                    }
                }
            }
        } else {
            return;
        }
    }

    public final boolean M()
    {
        int v0_0 = this.p;
        if ((v0_0 < 2000) || (v0_0 < this.o.size())) {
            return 0;
        } else {
            return 1;
        }
    }

    public final oc.x Z()
    {
        oc.x v0_0 = this.h;
        v0_0.getClass();
        ac.l v1_1 = this.j;
        v1_1.getClass();
        return new oc.x(new ac.l(v0_0.h.d(v1_1), new ac.c(this, 0)));
    }

    public final void c0()
    {
        ac.j v1 = this.h;
        zb.c.c(v1, this.k);
        java.util.Iterator v0_3 = this.o.values().iterator();
        while (v0_3.hasNext()) {
            ac.g v2_0 = v0_3.next();
            v2_0.getClass();
            ac.g v2_1 = ((ac.g) v2_0);
            int v5 = 0;
            if (v2_1.g != null) {
                v2_1.g = 0;
                while (v5 < 2) {
                    zb.c.c(v1, ((oc.w) v2_1.c.get(v5)));
                    zb.c.c(v1, ((oc.w) v2_1.d.get(v5)));
                    v5++;
                }
                v0_3.remove();
            }
            while (v5 < 2) {
                this.m = (this.m + v2_1.b[v5]);
                v5++;
            }
        }
        return;
    }

    public final declared_synchronized void close()
    {
        if (this.s) {
            if (!this.t) {
                int v0_8 = this.o.values();
                v0_8.getClass();
                int v2 = 0;
                int v3_0 = new ac.g[0];
                int v0_2 = ((ac.g[]) v0_8.toArray(v3_0));
                int v3_1 = v0_2.length;
                while (v2 < v3_1) {
                    ac.e v4_0 = v0_2[v2];
                    v4_0.getClass();
                    ac.e v4_1 = v4_0.g;
                    if (v4_1 != null) {
                        v4_1.g();
                    }
                    v2++;
                }
                this.h0();
                int v0_3 = this.n;
                if (v0_3 != 0) {
                    zb.c.a(v0_3);
                }
                this.n = 0;
                this.t = 1;
                return;
            } else {
            }
        }
        this.t = 1;
        return;
    }

    public final declared_synchronized void d()
    {
        try {
            if (this.t) {
                throw new IllegalStateException("cache is closed");
            } else {
                return;
            }
        } catch (String v0_2) {
            throw v0_2;
        }
    }

    public final void d0()
    {
        String v2_2 = this.h.e0(this.j);
        v2_2.getClass();
        oc.y v3_2 = new oc.y(v2_2);
        try {
            String v2_0 = v3_2.y(9223372036854775807);
            String v6 = v3_2.y(9223372036854775807);
            int v7_0 = v3_2.y(9223372036854775807);
            String v8 = v3_2.y(9223372036854775807);
            String v9 = v3_2.y(9223372036854775807);
        } catch (Throwable v0_8) {
            try {
                v3_2.close();
            } catch (int v1_4) {
                com.bumptech.glide.i.d(v0_8, v1_4);
            }
            if (v0_8 != null) {
                throw v0_8;
            } else {
                return;
            }
        }
        if ((!"libcore.io.DiskLruCache".equals(v2_0)) || ((!"1".equals(v6)) || ((!kotlin.jvm.internal.f.a(String.valueOf(201105), v7_0)) || ((!kotlin.jvm.internal.f.a(String.valueOf(2), v8)) || (v9.length() > 0))))) {
            StringBuilder v5_1 = new StringBuilder("unexpected journal header: [");
            v5_1.append(v2_0);
            v5_1.append(", ");
            v5_1.append(v6);
            v5_1.append(", ");
            v5_1.append(v8);
            v5_1.append(", ");
            v5_1.append(v9);
            v5_1.append(93);
            throw new java.io.IOException(v5_1.toString());
        } else {
            Throwable v0_3 = 0;
            while(true) {
                this.e0(v3_2.y(9223372036854775807));
                v0_3++;
            }
        }
    }

    public final void e0(String p11)
    {
        int v2 = 0;
        boolean v0_1 = db.i.X(p11, 32, 0, 6);
        if (v0_1 == -1) {
            oc.l.g("unexpected journal line: ".concat(p11));
            return;
        } else {
            int v5_1;
            int v5_0 = (v0_1 + 1);
            int v6_1 = db.i.X(p11, 32, v5_0, 4);
            int v7_0 = this.o;
            if (v6_1 != -1) {
                v5_1 = p11.substring(v5_0, v6_1);
            } else {
                v5_1 = p11.substring(v5_0);
                ac.g v8_0 = ac.k.C;
                if ((v0_1 == v8_0.length()) && (db.p.Q(p11, v8_0, 0))) {
                    v7_0.remove(v5_1);
                    return;
                }
            }
            ac.g v8_3 = ((ac.g) v7_0.get(v5_1));
            if (v8_3 == null) {
                v8_3 = new ac.g(this, v5_1);
                v7_0.put(v5_1, v8_3);
            }
            if (v6_1 == -1) {
                if (v6_1 == -1) {
                    long[] v1_1 = ac.k.B;
                    if ((v0_1 == v1_1.length()) && (db.p.Q(p11, v1_1, 0))) {
                        v8_3.g = new ac.e(this, v8_3);
                        return;
                    }
                }
                if (v6_1 == -1) {
                    long[] v1_3 = ac.k.D;
                    if ((v0_1 == v1_3.length()) && (db.p.Q(p11, v1_3, 0))) {
                        return;
                    }
                }
                oc.l.g("unexpected journal line: ".concat(p11));
                return;
            } else {
                int v5_2 = ac.k.A;
                if ((v0_1 != v5_2.length()) || (!db.p.Q(p11, v5_2, 0))) {
                } else {
                    ac.e v11_4 = p11.substring((v6_1 + 1));
                    long v4_2 = new char[1];
                    v4_2[0] = 32;
                    ac.e v11_5 = db.i.k0(v11_4, v4_2);
                    v8_3.e = 1;
                    v8_3.g = 0;
                    boolean v0_5 = v11_5.size();
                    v8_3.j.getClass();
                    if (v0_5 != 2) {
                        oc.l.f(v11_5, "unexpected journal line: ");
                        return;
                    } else {
                        try {
                            boolean v0_6 = v11_5.size();
                        } catch (NumberFormatException) {
                            oc.l.f(v11_5, "unexpected journal line: ");
                            return;
                        }
                        while (v2 < v0_6) {
                            v8_3.b[v2] = Long.parseLong(((String) v11_5.get(v2)));
                            v2++;
                        }
                    }
                }
            }
            return;
        }
    }

    public final declared_synchronized void f0()
    {
        int v0_0 = this.n;
        if (v0_0 != 0) {
            v0_0.close();
        }
        int v0_3 = this.h.d0(this.k);
        v0_3.getClass();
        oc.x v1_10 = new oc.x(v0_3);
        v1_10.G("libcore.io.DiskLruCache");
        v1_10.writeByte(10);
        v1_10.G("1");
        v1_10.writeByte(10);
        v1_10.Y(((long) 201105));
        v1_10.writeByte(10);
        v1_10.Y(((long) 2));
        v1_10.writeByte(10);
        v1_10.writeByte(10);
        oc.w v3_7 = this.o.values().iterator();
        while (v3_7.hasNext()) {
            long[] v4_1 = v3_7.next();
            v4_1.getClass();
            long[] v4_2 = ((ac.g) v4_1);
            if (v4_2.g == null) {
                v1_10.G(ac.k.A);
                v1_10.writeByte(32);
                v1_10.G(v4_2.a);
                long[] v4_3 = v4_2.b;
                int v5_3 = v4_3.length;
                int v7 = 0;
                while (v7 < v5_3) {
                    long v8 = v4_3[v7];
                    v1_10.writeByte(32);
                    v1_10.Y(v8);
                    v7++;
                }
                v1_10.writeByte(10);
            } else {
                v1_10.G(ac.k.B);
                v1_10.writeByte(32);
                v1_10.G(v4_2.a);
                v1_10.writeByte(10);
            }
        }
        try {
            v1_10.close();
            oc.x v1_0 = 0;
        } catch (oc.x v1_0) {
        }
        if (v1_0 != null) {
            throw v1_0;
        } else {
            oc.w v2_4 = this.h;
            if (!this.h.L(this.j)) {
                v2_4.h(this.k, this.j);
            } else {
                v2_4.h(this.j, this.l);
                this.h.h(this.k, this.j);
                zb.c.c(this.h, this.l);
            }
            oc.x v1_11 = this.n;
            if (v1_11 != null) {
                zb.c.a(v1_11);
            }
            this.n = this.Z();
            this.q = 0;
            this.v = 0;
            return;
        }
    }

    public final declared_synchronized void flush()
    {
        if (this.s) {
            this.d();
            this.h0();
            oc.x v0_1 = this.n;
            v0_1.getClass();
            v0_1.flush();
            return;
        } else {
            return;
        }
    }

    public final void g0(ac.g p11)
    {
        ac.i v0_0 = p11.a;
        if (!this.r) {
            if (p11.h > 0) {
                String v1_7 = this.n;
                if (v1_7 != null) {
                    v1_7.G(ac.k.B);
                    v1_7.writeByte(32);
                    v1_7.G(v0_0);
                    v1_7.writeByte(10);
                    v1_7.flush();
                }
            }
            if ((p11.h > 0) || (p11.g != null)) {
                p11.f = 1;
                return;
            }
        }
        String v1_3 = p11.g;
        if (v1_3 != null) {
            v1_3.g();
        }
        String v1_4 = 0;
        while (v1_4 < 2) {
            zb.c.c(this.h, ((oc.w) p11.c.get(v1_4)));
            long[] v7 = p11.b;
            this.m = (this.m - v7[v1_4]);
            v7[v1_4] = 0;
            v1_4++;
        }
        this.p = (this.p + 1);
        bc.b v11_3 = this.n;
        if (v11_3 != null) {
            v11_3.G(ac.k.C);
            v11_3.writeByte(32);
            v11_3.G(v0_0);
            v11_3.writeByte(10);
        }
        this.o.remove(v0_0);
        if (this.M()) {
            bc.b.e(this.x, this.y);
        }
        return;
    }

    public final declared_synchronized void h(ac.e p10, boolean p11)
    {
        try {
            long v0_1 = ((ac.g) p10.c);
        } catch (bc.b v10_6) {
            throw v10_6;
        }
        if (!kotlin.jvm.internal.f.a(v0_1.g, p10)) {
            throw new IllegalStateException("Check failed.");
        } else {
            int v2 = 0;
            if ((p11 != null) && (!v0_1.e)) {
                long v3_5 = 0;
                while (v3_5 < 2) {
                    oc.w v4_1 = ((boolean[]) p10.d);
                    v4_1.getClass();
                    if (v4_1[v3_5] == null) {
                        p10.a();
                        ac.i v11_5 = new StringBuilder();
                        v11_5.append("Newly created entry didn\'t create value for index ");
                        v11_5.append(v3_5);
                        throw new IllegalStateException(v11_5.toString());
                    } else {
                        if (this.h.L(((oc.w) v0_1.d.get(v3_5)))) {
                            v3_5++;
                        } else {
                            p10.a();
                            return;
                        }
                    }
                }
            }
            bc.b v10_3 = 0;
            while (v10_3 < 2) {
                long v3_12 = ((oc.w) v0_1.d.get(v10_3));
                if ((p11 == null) || (v0_1.f)) {
                    zb.c.c(this.h, v3_12);
                } else {
                    if (this.h.L(v3_12)) {
                        oc.w v4_12 = ((oc.w) v0_1.c.get(v10_3));
                        this.h.h(v3_12, v4_12);
                        long v5_5 = v0_1.b[v10_3];
                        long v3_14 = this.h;
                        v3_14.getClass();
                        long v3_0 = v3_14.Z(v4_12);
                        if (v3_0 == 0) {
                            ac.i v11_2 = new StringBuilder("no such file: ");
                            v11_2.append(v4_12);
                            throw new java.io.FileNotFoundException(v11_2.toString());
                        } else {
                            long v3_3;
                            long v3_2 = ((Long) v3_0.e);
                            if (v3_2 == 0) {
                                v3_3 = 0;
                            } else {
                                v3_3 = v3_2.longValue();
                            }
                            v0_1.b[v10_3] = v3_3;
                            this.m = ((this.m - v5_5) + v3_3);
                        }
                    }
                }
                v10_3++;
            }
            v0_1.g = 0;
            if (!v0_1.f) {
                this.p = (this.p + 1);
                bc.b v10_11 = this.n;
                v10_11.getClass();
                if (v0_1.e) {
                    v0_1.e = 1;
                    v10_11.G(ac.k.A);
                    v10_11.writeByte(32);
                    v10_11.G(v0_1.a);
                    long v1_7 = v0_1.b;
                    long v3_7 = v1_7.length;
                    while (v2 < v3_7) {
                        String v6 = v1_7[v2];
                        v10_11.writeByte(32);
                        v10_11.Y(v6);
                        v2++;
                    }
                    v10_11.writeByte(10);
                    if (p11 != null) {
                        long v1_8 = this.w;
                        this.w = (1 + v1_8);
                        v0_1.i = v1_8;
                    }
                } else {
                    if (p11 == null) {
                        this.o.remove(v0_1.a);
                        v10_11.G(ac.k.C);
                        v10_11.writeByte(32);
                        v10_11.G(v0_1.a);
                        v10_11.writeByte(10);
                    } else {
                    }
                }
                v10_11.flush();
                if ((this.m > this.i) || (this.M())) {
                    bc.b.e(this.x, this.y);
                }
                return;
            } else {
                this.g0(v0_1);
                return;
            }
        }
    }

    public final void h0()
    {
        while (this.m > this.i) {
            int v0_1 = this.o.values().iterator();
            while (v0_1.hasNext()) {
                ac.g v1_1 = v0_1.next();
                v1_1.getClass();
                ac.g v1_2 = ((ac.g) v1_1);
                if (!v1_2.f) {
                    this.g0(v1_2);
                }
            }
            return;
        }
        this.u = 0;
        return;
    }

    public final declared_synchronized ac.e i(String p6, long p7)
    {
        p6.getClass();
        this.L();
        this.d();
        ac.k.i0(p6);
        ac.g v0_2 = ((ac.g) this.o.get(p6));
        if ((p7 == -1) || ((v0_2 != null) && (v0_2.i == p7))) {
            java.util.LinkedHashMap v7_2;
            if (v0_2 == null) {
                v7_2 = 0;
            } else {
                v7_2 = v0_2.g;
            }
            if (v7_2 == null) {
                if ((v0_2 == null) || (v0_2.h == 0)) {
                    if (!this.u) {
                        if (!this.v) {
                            java.util.LinkedHashMap v7_6 = this.n;
                            v7_6.getClass();
                            v7_6.G(ac.k.B);
                            v7_6.writeByte(32);
                            v7_6.G(p6);
                            v7_6.writeByte(10);
                            v7_6.flush();
                            if (!this.q) {
                                if (v0_2 == null) {
                                    v0_2 = new ac.g(this, p6);
                                    this.o.put(p6, v0_2);
                                }
                                ac.e v6_2 = new ac.e(this, v0_2);
                                v0_2.g = v6_2;
                                return v6_2;
                            } else {
                                return 0;
                            }
                        } else {
                        }
                    }
                    bc.b.e(this.x, this.y);
                    return 0;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
