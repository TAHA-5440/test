// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package bc;
public final class b {
    public final bc.d a;
    public final String b;
    public boolean c;
    public bc.a d;
    public final java.util.ArrayList e;
    public boolean f;

    public b(bc.d p1, String p2)
    {
        this.a = p1;
        this.b = p2;
        this.e = new java.util.ArrayList();
        return;
    }

    public static void c(bc.b p1, String p2, ua.a p3)
    {
        p1.getClass();
        p2.getClass();
        p3.getClass();
        p1.d(new ac.i(p2, p3), 0);
        return;
    }

    public static synthetic void e(bc.b p2, bc.a p3)
    {
        p2.d(p3, 0);
        return;
    }

    public final void a()
    {
        bc.d v1 = zb.e.a;
        try {
            if (this.b()) {
                this.a.c(this);
            }
        } catch (bc.d v1_1) {
            throw v1_1;
        }
        return;
    }

    public final boolean b()
    {
        java.util.ArrayList v0_0 = this.d;
        if ((v0_0 != null) && (v0_0.b)) {
            this.f = 1;
        }
        java.util.ArrayList v0_2 = this.e;
        int v2_0 = (v0_2.size() - 1);
        int v3_0 = 0;
        while (-1 < v2_0) {
            if (((bc.a) v0_2.get(v2_0)).b) {
                int v3_2 = this.a.b;
                if (v3_2.isLoggable(java.util.logging.Level.FINE)) {
                    com.bumptech.glide.g.a(v3_2, ((bc.a) v0_2.get(v2_0)), this, "canceled");
                }
                v0_2.remove(v2_0);
                v3_0 = 1;
            }
            v2_0--;
        }
        return v3_0;
    }

    public final void d(bc.a p3, long p4)
    {
        p3.getClass();
        try {
            if (!this.c) {
                if (this.f(p3, p4, 0)) {
                    this.a.c(this);
                }
                return;
            } else {
                java.util.logging.Logger v5_1 = this.a.b;
                if (!p3.b) {
                    if (v5_1.isLoggable(java.util.logging.Level.FINE)) {
                        com.bumptech.glide.g.a(v5_1, p3, this, "schedule failed (queue is shutdown)");
                    }
                    throw new java.util.concurrent.RejectedExecutionException();
                } else {
                    if (v5_1.isLoggable(java.util.logging.Level.FINE)) {
                        com.bumptech.glide.g.a(v5_1, p3, this, "schedule canceled (queue is shutdown)");
                    }
                    return;
                }
            }
        } catch (java.util.concurrent.RejectedExecutionException v3_3) {
            throw v3_3;
        }
    }

    public final boolean f(bc.a p12, long p13, boolean p15)
    {
        int v0_1 = this.a.b;
        p12.getClass();
        long v1_1 = p12.c;
        if (v1_1 != this) {
            if (v1_1 != 0) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("task is in multiple queues");
                return 0;
            } else {
                p12.c = this;
            }
        }
        long v1_0 = System.nanoTime();
        int v3_0 = (v1_0 + p13);
        java.util.ArrayList v5 = this.e;
        boolean v6_0 = v5.indexOf(p12);
        if (v6_0 == -1) {
            p12.d = v3_0;
            if (v0_1.isLoggable(java.util.logging.Level.FINE)) {
                String v15_2;
                if (p15 == null) {
                    v15_2 = "scheduled after ".concat(com.bumptech.glide.g.h((v3_0 - v1_0)));
                } else {
                    v15_2 = "run again after ".concat(com.bumptech.glide.g.h((v3_0 - v1_0)));
                }
                com.bumptech.glide.g.a(v0_1, p12, this, v15_2);
            }
            String v15_4 = v5.size();
            int v0_2 = 0;
            int v3_5 = 0;
            while (v3_5 < v15_4) {
                long v4_0 = v5.get(v3_5);
                v3_5++;
                if ((((bc.a) v4_0).d - v1_0) <= p13) {
                    v0_2++;
                }
                if (v0_2 == -1) {
                    v0_2 = v5.size();
                }
                v5.add(v0_2, p12);
                if (v0_2 == 0) {
                    return 1;
                }
            }
            v0_2 = -1;
        } else {
            if (p12.d > v3_0) {
                v5.remove(v6_0);
            } else {
                if (v0_1.isLoggable(java.util.logging.Level.FINE)) {
                    com.bumptech.glide.g.a(v0_1, p12, this, "already scheduled");
                    return 0;
                }
            }
        }
        return 0;
    }

    public final void g()
    {
        bc.d v1 = zb.e.a;
        try {
            this.c = 1;
        } catch (bc.d v1_2) {
            throw v1_2;
        }
        if (this.b()) {
            this.a.c(this);
        }
        return;
    }

    public final String toString()
    {
        return this.b;
    }
}
