// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package wb;
public final class i implements tb.d, tb.b {
    public final a7.j a;
    public final vb.b b;
    public final kotlinx.serialization.json.internal.WriteMode c;
    public final wb.i[] d;
    public final m.t e;
    public boolean f;
    public String g;
    public String h;

    public i(a7.j p1, vb.b p2, kotlinx.serialization.json.internal.WriteMode p3, wb.i[] p4)
    {
        p1.getClass();
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = p4;
        this.e = p2.a;
        int v1_2 = p3.ordinal();
        if (p4 != null) {
            wb.i v2_1 = p4[v1_2];
            if ((v2_1 != null) || (v2_1 != this)) {
                p4[v1_2] = this;
            }
        }
        return;
    }

    public final void a(sb.d p2)
    {
        p2.getClass();
        a7.j v2_1 = this.a;
        v2_1.getClass();
        v2_1.g = 0;
        v2_1.d(this.c.h);
        return;
    }

    public final tb.b b(sb.d p6)
    {
        p6.getClass();
        vb.b v0 = this.b;
        kotlinx.serialization.json.internal.WriteMode v1 = wb.g.h(p6, v0);
        a7.j v3 = this.a;
        v3.d(v1.g);
        v3.g = 1;
        wb.i v2_6 = this.g;
        if (v2_6 != null) {
            String v4 = this.h;
            if (v4 == null) {
                v4 = p6.a();
            }
            v3.a();
            v3.h(v2_6);
            v3.d(58);
            this.p(v4);
            this.g = 0;
            this.h = 0;
        }
        if (this.c != v1) {
            wb.i[] v6_4 = this.d;
            if (v6_4 != null) {
                wb.i v2_1 = v6_4[v1.ordinal()];
                if (v2_1 != null) {
                    return v2_1;
                }
            }
            return new wb.i(v3, v0, v1, v6_4);
        } else {
            return this;
        }
    }

    public final void c()
    {
        cc.z v0_0 = this.a;
        v0_0.getClass();
        ((cc.z) v0_0.h).r("null");
        return;
    }

    public final void d(double p4)
    {
        a7.j v1 = this.a;
        if (!this.f) {
            ((cc.z) v1.h).r(String.valueOf(p4));
        } else {
            this.p(String.valueOf(p4));
        }
        if ((Double.isInfinite(p4)) || (Double.isNaN(p4))) {
            throw wb.g.a(((cc.z) v1.h).toString(), Double.valueOf(p4));
        } else {
            return;
        }
    }

    public final void e(short p2)
    {
        if (!this.f) {
            this.a.g(p2);
            return;
        } else {
            this.p(String.valueOf(p2));
            return;
        }
    }

    public final void f(byte p2)
    {
        if (!this.f) {
            this.a.c(p2);
            return;
        } else {
            this.p(String.valueOf(p2));
            return;
        }
    }

    public final void g(qb.a p5, Object p6)
    {
        String v0_3;
        p5.getClass();
        String v0_1 = this.b.a;
        String v1_10 = ((kotlinx.serialization.json.ClassDiscriminatorMode) v0_1.c).ordinal();
        if (v1_10 == null) {
            v0_3 = 0;
        } else {
            if (v1_10 == 1) {
                String v1_1 = p5.getDescriptor().e();
                if ((!kotlin.jvm.internal.f.a(v1_1, sb.h.e)) && (!kotlin.jvm.internal.f.a(v1_1, sb.h.h))) {
                } else {
                    String v1_3 = p5.getDescriptor();
                    v1_3.getClass();
                    String v1_5 = v1_3.getAnnotations().iterator();
                    while (v1_5.hasNext()) {
                        vb.h v2_5 = ((otation.Annotation) v1_5.next());
                        if ((v2_5 instanceof vb.h)) {
                            v0_3 = ((vb.h) v2_5).discriminator();
                        }
                    }
                    v0_3 = ((String) v0_1.b);
                }
            } else {
                if (v1_10 != 2) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.s();
                    return;
                }
            }
        }
        if (v0_3 != null) {
            String v1_9 = p5.getDescriptor().a();
            this.g = v0_3;
            this.h = v1_9;
        }
        p5.serialize(this, p6);
        return;
    }

    public final void h(boolean p2)
    {
        if (!this.f) {
            ((cc.z) this.a.h).r(String.valueOf(p2));
            return;
        } else {
            this.p(String.valueOf(p2));
            return;
        }
    }

    public final void i(float p4)
    {
        a7.j v1 = this.a;
        if (!this.f) {
            ((cc.z) v1.h).r(String.valueOf(p4));
        } else {
            this.p(String.valueOf(p4));
        }
        if ((Float.isInfinite(p4)) || (Float.isNaN(p4))) {
            throw wb.g.a(((cc.z) v1.h).toString(), Float.valueOf(p4));
        } else {
            return;
        }
    }

    public final void j(char p1)
    {
        this.p(String.valueOf(p1));
        return;
    }

    public final tb.d k(sb.d p6)
    {
        p6.getClass();
        kotlinx.serialization.json.internal.WriteMode v2 = this.c;
        vb.b v3 = this.b;
        wb.d v4_1 = this.a;
        if (!wb.j.a(p6)) {
            if ((!p6.isInline()) || (!p6.equals(vb.k.a))) {
                if (this.g != null) {
                    this.h = p6.a();
                }
                return this;
            } else {
                if (!(v4_1 instanceof wb.d)) {
                    v4_1 = new wb.d(((cc.z) v4_1.h), this.f);
                }
                return new wb.i(v4_1, v3, v2, 0);
            }
        } else {
            if (!(v4_1 instanceof wb.e)) {
                v4_1 = new wb.e(((cc.z) v4_1.h), this.f);
            }
            return new wb.i(v4_1, v3, v2, 0);
        }
    }

    public final void l(int p2)
    {
        if (!this.f) {
            this.a.e(p2);
            return;
        } else {
            this.p(String.valueOf(p2));
            return;
        }
    }

    public final void m(long p2)
    {
        if (!this.f) {
            this.a.f(p2);
            return;
        } else {
            this.p(String.valueOf(p2));
            return;
        }
    }

    public final void n(sb.d p2, int p3, qb.a p4, Object p5)
    {
        p2.getClass();
        p4.getClass();
        if ((p5 == null) && (!this.e.e)) {
            return;
        } else {
            p2.getClass();
            p4.getClass();
            this.q(p2, p3);
            if (!p4.getDescriptor().c()) {
                if (p5 != null) {
                    this.g(p4, p5);
                } else {
                    this.c();
                }
            } else {
                this.g(p4, p5);
            }
            return;
        }
    }

    public final boolean o(sb.d p1)
    {
        return 0;
    }

    public final void p(String p2)
    {
        p2.getClass();
        this.a.h(p2);
        return;
    }

    public final void q(sb.d p8, int p9)
    {
        p8.getClass();
        vb.b v0_1 = this.c.ordinal();
        a7.j v2 = this.a;
        int v3 = 1;
        if (v0_1 == 1) {
            if (!v2.g) {
                v2.d(44);
            }
            v2.a();
            return;
        } else {
            if (v0_1 == 2) {
                if (v2.g) {
                    this.f = 1;
                    v2.a();
                    return;
                } else {
                    if ((p9 % 2) != 0) {
                        v2.d(58);
                        v2.j();
                        v3 = 0;
                    } else {
                        v2.d(44);
                        v2.a();
                    }
                    this.f = v3;
                    return;
                }
            } else {
                if (v0_1 == 3) {
                    if (p9 == 0) {
                        this.f = 1;
                    }
                    if (p9 == 1) {
                        v2.d(44);
                        v2.j();
                        this.f = 0;
                    }
                    return;
                } else {
                    if (!v2.g) {
                        v2.d(44);
                    }
                    v2.a();
                    wb.g.g(p8, this.b);
                    this.p(p8.g(p9));
                    v2.d(58);
                    v2.j();
                    return;
                }
            }
        }
    }

    public final tb.d r(ub.q0 p1, int p2)
    {
        p1.getClass();
        this.q(p1, p2);
        return this.k(p1.i(p2));
    }

    public final void s(sb.d p1, int p2, long p3)
    {
        p1.getClass();
        this.q(p1, p2);
        this.m(p3);
        return;
    }

    public final void t(sb.d p1, int p2, qb.a p3, Object p4)
    {
        p1.getClass();
        p3.getClass();
        this.q(p1, p2);
        this.g(p3, p4);
        return;
    }
}
