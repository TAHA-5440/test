// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package bc;
public final class d {
    public static final java.util.logging.Logger k;
    public static final bc.d l;
    public final a3.f a;
    public final java.util.logging.Logger b;
    public int c;
    public boolean d;
    public long e;
    public int f;
    public int g;
    public final java.util.ArrayList h;
    public final java.util.ArrayList i;
    public final bc.c j;

    static d()
    {
        bc.d v0_3 = java.util.logging.Logger.getLogger(bc.d.getName());
        v0_3.getClass();
        bc.d.k = v0_3;
        bc.d.l = new bc.d(new a3.f(new zb.d(r1.a.n(zb.e.b, " TaskRunner", new StringBuilder()), 1)));
        return;
    }

    public d(a3.f p2)
    {
        int v0_0 = bc.d.k;
        v0_0.getClass();
        this.a = p2;
        this.b = v0_0;
        this.c = 10000;
        this.h = new java.util.ArrayList();
        this.i = new java.util.ArrayList();
        this.j = new bc.c(this, 0);
        return;
    }

    public static final void a(bc.d p4, bc.a p5, long p6, boolean p8)
    {
        bc.b v0 = p5.c;
        v0.getClass();
        if (v0.d != p5) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Check failed.");
            return;
        } else {
            int v1_3 = v0.f;
            v0.f = 0;
            v0.d = 0;
            p4.h.remove(v0);
            if ((p6 != -1) && ((v1_3 == 0) && (!v0.c))) {
                v0.f(p5, p6, 1);
            }
            if (!v0.e.isEmpty()) {
                p4.i.add(v0);
                if (!p8) {
                    p4.e();
                }
            }
            return;
        }
    }

    public final bc.a b()
    {
        while(true) {
            int v15;
            Throwable v0_1 = this.i;
            if (!v0_1.isEmpty()) {
                bc.b v4_0 = System.nanoTime();
                int v2_12 = v0_1.size();
                long v7_0 = 9223372036854775807;
                int v10 = 0;
                long v9_0 = 0;
                while (v10 < v2_12) {
                    bc.a v14_0 = v0_1.get(v10);
                    v10++;
                    bc.a v14_4 = ((bc.a) ((bc.b) v14_0).e.get(0));
                    long v16 = v4_0;
                    v15 = 0;
                    boolean v3_2 = Math.max(0, (v14_4.d - v16));
                    if (v3_2 <= 0) {
                        if (v9_0 == 0) {
                            v9_0 = v14_4;
                        } else {
                            int v2_1 = 1;
                            boolean v3_3 = this.h;
                            if (v9_0 == 0) {
                                if (!this.d) {
                                    this.d = 1;
                                    this.e = (v16 + v7_0);
                                    try {
                                        int v2_4 = v7_0 cmp 0;
                                    } catch (Throwable v0_2) {
                                        this.d = 0;
                                        throw v0_2;
                                    }
                                    if (v2_4 <= 0) {
                                        this.d = 0;
                                    } else {
                                        long v9_1 = (v7_0 / 1000000);
                                        if ((v9_1 <= 0) && (v2_4 <= 0)) {
                                        } else {
                                            this.wait(v9_1, ((int) (v7_0 - (1000000 * v9_1))));
                                        }
                                    }
                                } else {
                                    if (v7_0 < (this.e - v16)) {
                                        this.notify();
                                    }
                                }
                            } else {
                                v9_0.d = -1;
                                bc.b v4_9 = v9_0.c;
                                v4_9.getClass();
                                v4_9.e.remove(v9_0);
                                v0_1.remove(v4_9);
                                v4_9.d = v9_0;
                                v3_3.add(v4_9);
                                if ((v2_1 != 0) || ((!this.d) && (!v0_1.isEmpty()))) {
                                    this.e();
                                }
                                return v9_0;
                            }
                            return v15;
                        }
                    } else {
                        v7_0 = Math.min(v3_2, v7_0);
                    }
                    v4_0 = v16;
                }
                v16 = v4_0;
                v15 = 0;
                v2_1 = 0;
            } else {
                v15 = 0;
            }
            return v15;
        }
    }

    public final void c(bc.b p3)
    {
        p3.getClass();
        if (p3.d == null) {
            java.util.ArrayList v1 = this.i;
            if (p3.e.isEmpty()) {
                v1.remove(p3);
            } else {
                Class vtmp3 = v1.getClass();
                if (!v1.contains(p3)) {
                    v1.add(p3);
                }
            }
        }
        if (!this.d) {
            this.e();
            return;
        } else {
            this.notify();
            return;
        }
    }

    public final bc.b d()
    {
        try {
            Throwable v0_0 = this.c;
            this.c = (v0_0 + 1);
            return new bc.b(this, r1.a.g(v0_0, "Q"));
        } catch (Throwable v0_2) {
            throw v0_2;
        }
    }

    public final void e()
    {
        bc.c v0_0 = this.f;
        if (v0_0 <= this.g) {
            this.f = (v0_0 + 1);
            bc.c v0_2 = this.j;
            v0_2.getClass();
            ((java.util.concurrent.ThreadPoolExecutor) this.a.h).execute(v0_2);
            return;
        } else {
            return;
        }
    }
}
