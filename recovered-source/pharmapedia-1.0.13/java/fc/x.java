// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final class x implements oc.c0 {
    public final int g;
    public final fc.p h;
    public final gc.a i;
    public long j;
    public long k;
    public final java.util.ArrayDeque l;
    public boolean m;
    public final fc.v n;
    public final fc.u o;
    public final fc.w p;
    public final fc.w q;
    public okhttp3.internal.http2.ErrorCode r;
    public java.io.IOException s;

    public x(int p4, fc.p p5, boolean p6, boolean p7, yb.s p8)
    {
        p5.getClass();
        this.g = p4;
        this.h = p5;
        this.i = new gc.a(p4);
        this.k = ((long) p5.x.a());
        int v4_2 = new java.util.ArrayDeque();
        this.l = v4_2;
        this.n = new fc.v(this, ((long) p5.w.a()), p7);
        this.o = new fc.u(this, p6);
        this.p = new fc.w(this);
        this.q = new fc.w(this);
        if (p8 == null) {
            if (!this.g()) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("remotely-initiated streams should have headers");
                throw 0;
            } else {
                return;
            }
        } else {
            if (this.g()) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("locally-initiated streams shouldn\'t have headers yet");
                throw 0;
            } else {
                v4_2.add(p8);
                return;
            }
        }
    }

    public final void a()
    {
        fc.p v0_1;
        fc.p v0_0 = this.n;
        if ((v0_0.h) || (!v0_0.k)) {
            v0_1 = 0;
        } else {
            fc.p v0_6 = this.o;
            if (!v0_6.g) {
                if (!v0_6.i) {
                } else {
                }
            }
            v0_1 = 1;
        }
        int v1_0 = this.h();
        if (v0_1 == null) {
            if (v1_0 == 0) {
                this.h.i(this.g);
            }
            return;
        } else {
            this.c(okhttp3.internal.http2.ErrorCode.n, 0);
            return;
        }
    }

    public final void b()
    {
        okhttp3.internal.http2.StreamResetException v0_0 = this.o;
        if (v0_0.i) {
            oc.l.g("stream closed");
            return;
        } else {
            if (v0_0.g) {
                oc.l.g("stream finished");
                return;
            } else {
                if (this.f() == null) {
                    return;
                } else {
                    okhttp3.internal.http2.StreamResetException v0_2 = this.s;
                    if (v0_2 == null) {
                        okhttp3.internal.http2.ErrorCode v1_1 = this.f();
                        v1_1.getClass();
                        v0_2 = new okhttp3.internal.http2.StreamResetException(v1_1);
                    }
                    throw v0_2;
                }
            }
        }
    }

    public final void c(okhttp3.internal.http2.ErrorCode p2, java.io.IOException p3)
    {
        if (this.d(p2, p3)) {
            fc.y v3_2 = this.h;
            v3_2.getClass();
            v3_2.C.Z(this.g, p2);
            return;
        } else {
            return;
        }
    }

    public final boolean d(okhttp3.internal.http2.ErrorCode p3, java.io.IOException p4)
    {
        try {
            if (this.f() == null) {
                this.r = p3;
                this.s = p4;
                this.notifyAll();
                if ((!this.n.h) || (!this.o.g)) {
                    this.h.i(this.g);
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } catch (int v3_1) {
            throw v3_1;
        }
    }

    public final void e(okhttp3.internal.http2.ErrorCode p3)
    {
        if (this.d(p3, 0)) {
            this.h.Z(this.g, p3);
            return;
        } else {
            return;
        }
    }

    public final okhttp3.internal.http2.ErrorCode f()
    {
        try {
            return this.r;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    public final boolean g()
    {
        int v0_2;
        if ((this.g & 1) != 1) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        this.h.getClass();
        if (1 != v0_2) {
            return 0;
        } else {
            return 1;
        }
    }

    public final oc.d0 getSource()
    {
        return this.n;
    }

    public final boolean h()
    {
        if (this.f() == null) {
            boolean v0_5 = this.n;
            if (v0_5.h) {
                boolean v0_7 = this.o;
                if (((v0_7.g) || (v0_7.i)) && (this.m)) {
                    return 0;
                }
            } else {
                if (v0_5.k) {
                }
            }
            return 1;
        } else {
            return 0;
        }
    }

    public final void i(yb.s p3, boolean p4)
    {
        p3.getClass();
        if ((!this.m) || (p3.a(":status") != null)) {
            this.m = 1;
            this.l.add(p3);
        } else {
            if (p3.a(":method") == null) {
                this.n.getClass();
            } else {
            }
        }
        if (p4 != 0) {
            this.n.h = 1;
        }
        fc.p v3_4 = this.h();
        this.notifyAll();
        if (v3_4 == null) {
            this.h.i(this.g);
        }
        return;
    }

    public final oc.b0 m()
    {
        return this.o;
    }
}
