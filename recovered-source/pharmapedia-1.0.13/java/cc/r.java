// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public final class r implements yb.i, java.lang.Cloneable {
    public final yb.y g;
    public final lc.a h;
    public final cc.t i;
    public final cc.q j;
    public final java.util.concurrent.atomic.AtomicBoolean k;
    public Object l;
    public cc.j m;
    public cc.s n;
    public boolean o;
    public cc.i p;
    public boolean q;
    public boolean r;
    public boolean s;
    public volatile boolean t;
    public volatile cc.i u;
    public final java.util.concurrent.CopyOnWriteArrayList v;

    public r(yb.y p3, lc.a p4)
    {
        p3.getClass();
        this.g = p3;
        this.h = p4;
        this.i = ((cc.t) p3.C.h);
        p3.d.getClass();
        cc.q v4_2 = new cc.q(this);
        v4_2.g(((long) p3.w));
        this.j = v4_2;
        this.k = new java.util.concurrent.atomic.AtomicBoolean();
        this.s = 1;
        this.v = new java.util.concurrent.CopyOnWriteArrayList();
        return;
    }

    public static final String a(cc.r p2)
    {
        String v1_1;
        StringBuilder v0_1 = new StringBuilder();
        if (!p2.t) {
            v1_1 = "";
        } else {
            v1_1 = "canceled ";
        }
        v0_1.append(v1_1);
        v0_1.append("call");
        v0_1.append(" to ");
        v0_1.append(((yb.u) p2.h.b).h());
        return v0_1.toString();
    }

    public final java.io.IOException b(java.io.IOException p3)
    {
        if (this.n != null) {
            try {
                String v1_1 = this.i();
            } catch (int v3_3) {
                throw v3_3;
            }
            if (this.n != null) {
                if (v1_1 != null) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Check failed.");
                    return 0;
                }
            } else {
                if (v1_1 != null) {
                    zb.e.c(v1_1);
                }
            }
        }
        if ((!this.o) && (this.j.i())) {
            java.io.InterruptedIOException v0_5 = new java.io.InterruptedIOException("timeout");
            if (p3 != 0) {
                v0_5.initCause(p3);
            }
        } else {
            v0_5 = p3;
        }
        if (p3 != 0) {
            v0_5.getClass();
        }
        return v0_5;
    }

    public final void c()
    {
        if (!this.t) {
            this.t = 1;
            java.util.Iterator v0_3 = this.u;
            if (v0_3 != null) {
                v0_3.c.cancel();
            }
            java.util.Iterator v0_1 = this.v.iterator();
            v0_1.getClass();
            while (v0_1.hasNext()) {
                ((cc.x) v0_1.next()).cancel();
            }
            return;
        } else {
            return;
        }
    }

    public final Object clone()
    {
        return new cc.r(this.g, this.h);
    }

    public final yb.b0 d()
    {
        if (!this.k.compareAndSet(0, 1)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Already Executed");
            return 0;
        } else {
            this.j.h();
            this.l = ic.e.a.g();
            try {
            } catch (yb.b0 v2_4) {
                yb.q v3_6 = this.g.a;
                v3_6.getClass();
                yb.q.i(v3_6, 0, this, 0, 5);
                throw v2_4;
            }
            ((java.util.ArrayDeque) this.g.a.f).add(this);
            yb.b0 v2_3 = this.f();
            yb.q v3_4 = this.g.a;
            v3_4.getClass();
            yb.q.i(v3_4, 0, this, 0, 5);
            return v2_3;
        }
    }

    public final void e(boolean p4)
    {
        try {
            if (!this.s) {
                throw new IllegalStateException("released");
            } else {
                if (p4 != null) {
                    cc.i v4_1 = this.u;
                    if (v4_1 != null) {
                        v4_1.c.cancel();
                        v4_1.a.g(v4_1, 1, 1, 0);
                    }
                }
                this.p = 0;
                return;
            }
        } catch (cc.i v4_3) {
            throw v4_3;
        }
    }

    public final yb.b0 f()
    {
        int v2_1 = new java.util.ArrayList();
        ha.j.A(this.g.b, v2_1);
        v2_1.add(new ac.b(this.g));
        v2_1.add(new ac.b(this.g.j));
        v2_1.add(new ac.b(this.g.k));
        v2_1.add(cc.b.a);
        ha.j.A(this.g.c, v2_1);
        v2_1.add(dc.b.a);
        lc.a v5 = this.h;
        cc.r v1_4 = this.g;
        int v3_1 = 0;
        try {
            java.io.IOException v0_11 = new dc.g(this, v2_1, 0, 0, v5, v1_4.x, v1_4.y, v1_4.z).b(v5);
        } catch (java.io.IOException v0_14) {
            v3_1 = 1;
            java.io.IOException v0_16 = this.h(v0_14);
            v0_16.getClass();
            throw v0_16;
        } catch (java.io.IOException v0_17) {
            if (v3_1 == 0) {
                this.h(0);
            }
            throw v0_17;
        }
        if (this.t) {
            zb.c.a(v0_11);
            throw new java.io.IOException("Canceled");
        } else {
            this.h(0);
            return v0_11;
        }
    }

    public final java.io.IOException g(cc.i p3, boolean p4, boolean p5, java.io.IOException p6)
    {
        p3.getClass();
        if (p3.equals(this.u)) {
            boolean v4_1;
            Throwable v0_1 = 0;
            if (!p4) {
                if ((p5 == null) || (!this.r)) {
                    v4_1 = 0;
                } else {
                    if (p4) {
                        this.q = 0;
                    }
                    if (p5 != null) {
                        this.r = 0;
                    }
                    java.io.IOException v5_2;
                    boolean v4_2 = this.q;
                    if ((v4_2) || (this.r)) {
                        v5_2 = 0;
                    } else {
                        v5_2 = 1;
                    }
                    if ((!v4_2) && ((!this.r) && (!this.s))) {
                        v0_1 = 1;
                    }
                    v4_1 = v0_1;
                    v0_1 = v5_2;
                }
            } else {
                if (this.q) {
                } else {
                }
            }
            if (v0_1 != null) {
                this.u = 0;
                java.io.IOException v5_4 = this.n;
                if (v5_4 != null) {
                    try {
                        v5_4.o = (v5_4.o + 1);
                    } catch (Throwable v3_3) {
                        throw v3_3;
                    }
                }
            }
            if (v4_1) {
                return this.b(p6);
            }
        }
        return p6;
    }

    public final java.io.IOException h(java.io.IOException p3)
    {
        try {
            int v1 = 0;
        } catch (java.io.IOException v3_1) {
            throw v3_1;
        }
        if (this.s) {
            this.s = 0;
            if ((!this.q) && (!this.r)) {
                v1 = 1;
            }
        }
        if (v1 != 0) {
            p3 = this.b(p3);
        }
        return p3;
    }

    public final java.net.Socket i()
    {
        java.net.Socket v0_0 = this.n;
        v0_0.getClass();
        Object v1_1 = v0_0.r;
        int v2_1 = v1_1.size();
        yb.a v3_0 = 0;
        int v4_0 = 0;
        while (v4_0 < v2_1) {
            boolean v6_0 = v1_1.get(v4_0);
            v4_0++;
            if (!kotlin.jvm.internal.f.a(((ref.Reference) v6_0).get(), this)) {
                v3_0++;
            }
            if (v3_0 == -1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Check failed.");
                return 0;
            } else {
                v1_1.remove(v3_0);
                this.n = 0;
                if (v1_1.isEmpty()) {
                    v0_0.s = System.nanoTime();
                    Object v1_2 = this.i;
                    yb.a v3_2 = v1_2.f;
                    if (v0_0.l) {
                        v0_0.l = 1;
                        v3_2.remove(v0_0);
                        if (v3_2.isEmpty()) {
                            v1_2.d.a();
                        }
                        yb.a v3_6 = v0_0.d.a;
                        v3_6.getClass();
                        if (v1_2.c.get(v3_6) != null) {
                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.o();
                        } else {
                            return v0_0.f;
                        }
                    } else {
                        bc.b.e(v1_2.d, v1_2.e);
                        return 0;
                    }
                }
                return 0;
            }
        }
        v3_0 = -1;
    }
}
