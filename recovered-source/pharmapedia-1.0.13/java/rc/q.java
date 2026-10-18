// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package rc;
public final class q extends w1.k0 {
    public final androidx.lifecycle.p d;
    public final androidx.fragment.app.i1 e;
    public final t.g f;
    public final t.g g;
    public final t.g h;
    public r2.e i;
    public boolean j;
    public boolean k;

    public q(androidx.fragment.app.i1 p2, androidx.lifecycle.p p3)
    {
        this.f = new t.g();
        this.g = new t.g();
        this.h = new t.g();
        this.j = 0;
        this.k = 0;
        this.e = p2;
        this.d = p3;
        if (this.a.a()) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            throw 0;
        } else {
            this.b = 1;
            return;
        }
    }

    public static void k(android.view.View p2, android.widget.FrameLayout p3)
    {
        if (p3.getChildCount() > 1) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Design assumption violated.");
            return;
        } else {
            if (p2.getParent() != p3) {
                if (p3.getChildCount() > 0) {
                    p3.removeAllViews();
                }
                if (p2.getParent() != null) {
                    ((android.view.ViewGroup) p2.getParent()).removeView(p2);
                }
                p3.addView(p2);
                return;
            } else {
                return;
            }
        }
    }

    public static boolean l(long p2)
    {
        if ((p2 < 0) || (p2 >= ((long) 3))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final int a()
    {
        return 3;
    }

    public final long b(int p3)
    {
        return ((long) p3);
    }

    public final void d(androidx.recyclerview.widget.RecyclerView p4)
    {
        if (this.i != null) {
            oc.l.a();
            return;
        } else {
            androidx.lifecycle.p v0_3 = new r2.e(this);
            this.i = v0_3;
            c2.b v4_8 = r2.e.a(p4);
            v0_3.d = v4_8;
            int v1_1 = new r2.c(v0_3, 0);
            v0_3.a = v1_1;
            ((java.util.ArrayList) v4_8.i.b).add(v1_1);
            c2.b v4_5 = new r2.d(v0_3, 0);
            v0_3.b = v4_5;
            this.a.registerObserver(v4_5);
            c2.b v4_7 = new c2.b(v0_3, 2);
            v0_3.c = v4_7;
            this.d.a(v4_7);
            return;
        }
    }

    public final void e(w1.h1 p9, int p10)
    {
        long v0_0 = ((r2.f) p9).e;
        android.widget.FrameLayout v2_1 = ((android.widget.FrameLayout) ((r2.f) p9).a);
        t.g v3_2 = v2_1.getId();
        androidx.fragment.app.h0 v4_6 = this.n(v3_2);
        t.g v5 = this.h;
        if ((v4_6 != null) && (v4_6.longValue() != v0_0)) {
            this.p(v4_6.longValue());
            v5.f(v4_6.longValue());
        }
        v5.e(v0_0, Integer.valueOf(v3_2));
        t.g v3_1 = this.f;
        if (v3_1.c(((long) p10)) < 0) {
            wc.n v10_2;
            if (p10 == null) {
                v10_2 = new wc.l();
            } else {
                if (p10 == 1) {
                    v10_2 = new wc.c();
                } else {
                    if (p10 == 2) {
                        v10_2 = new wc.n();
                    } else {
                        v10_2 = new androidx.fragment.app.i0();
                    }
                }
            }
            v10_2.setInitialSavedState(((androidx.fragment.app.h0) this.g.b(((long) p10))));
            v3_1.e(((long) p10), v10_2);
        }
        if (v2_1.isAttachedToWindow()) {
            if (v2_1.getParent() != null) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Design assumption violated.");
                return;
            } else {
                v2_1.addOnLayoutChangeListener(new r2.a(this, v2_1, ((r2.f) p9)));
            }
        }
        this.m();
        return;
    }

    public final w1.h1 f(android.view.ViewGroup p3)
    {
        android.widget.FrameLayout v0_1 = new android.widget.FrameLayout(p3.getContext());
        v0_1.setLayoutParams(new android.view.ViewGroup$LayoutParams(-1, -1));
        v0_1.setId(android.view.View.generateViewId());
        v0_1.setSaveEnabled(0);
        return new r2.f(v0_1);
    }

    public final void g(androidx.recyclerview.widget.RecyclerView p4)
    {
        r2.e v0 = this.i;
        v0.getClass();
        ((java.util.ArrayList) r2.e.a(p4).i.b).remove(v0.a);
        int v4_7 = v0.f;
        v4_7.a.unregisterObserver(v0.b);
        v4_7.d.b(v0.c);
        v0.d = 0;
        this.i = 0;
        return;
    }

    public final bridge synthetic boolean h(w1.h1 p1)
    {
        return 1;
    }

    public final void i(w1.h1 p1)
    {
        this.o(((r2.f) p1));
        this.m();
        return;
    }

    public final void j(w1.h1 p4)
    {
        Long v4_5 = this.n(((android.widget.FrameLayout) ((r2.f) p4).a).getId());
        if (v4_5 != null) {
            this.p(v4_5.longValue());
            this.h.f(v4_5.longValue());
        }
        return;
    }

    public final void m()
    {
        if ((this.k) && (!this.e.L())) {
            int v1_2 = 0;
            Long v0_7 = new t.f(0);
            android.view.ViewParent v2_9 = 0;
            while(true) {
                long v3_0 = this.f;
                t.g v5 = this.h;
                if (v2_9 >= v3_0.g()) {
                    break;
                }
                long v3_1 = v3_0.d(v2_9);
                if (!rc.q.l(v3_1)) {
                    v0_7.add(Long.valueOf(v3_1));
                    v5.f(v3_1);
                }
                v2_9++;
            }
            if (!this.j) {
                this.k = 0;
                while (v1_2 < v3_0.g()) {
                    long v6_0 = v3_0.d(v1_2);
                    if (v5.c(v6_0) < 0) {
                        android.view.ViewParent v2_5 = ((androidx.fragment.app.i0) v3_0.b(v6_0));
                        if (v2_5 != null) {
                            android.view.ViewParent v2_6 = v2_5.getView();
                            if ((v2_6 != null) && (v2_6.getParent() != null)) {
                                v1_2++;
                            }
                        }
                        v0_7.add(Long.valueOf(v6_0));
                    }
                }
            }
            int v1_1 = new t.a(v0_7);
            while (v1_1.hasNext()) {
                this.p(((Long) v1_1.next()).longValue());
            }
        }
        return;
    }

    public final Long n(int p5)
    {
        Long v0 = 0;
        int v1 = 0;
        while(true) {
            long v2_1 = this.h;
            if (v1 >= v2_1.g()) {
                break;
            }
            if (((Integer) v2_1.h(v1)).intValue() == p5) {
                if (v0 != null) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                    return 0;
                } else {
                    v0 = Long.valueOf(v2_1.d(v1));
                }
            }
            v1++;
        }
        return v0;
    }

    public final void o(r2.f p8)
    {
        androidx.lifecycle.g v0_4 = ((androidx.fragment.app.i0) this.f.b(p8.e));
        if (v0_4 == null) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Design assumption violated.");
            return;
        } else {
            StringBuilder v2_0 = ((android.widget.FrameLayout) p8.a);
            String v3_0 = v0_4.getView();
            if ((!v0_4.isAdded()) && (v3_0 != null)) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Design assumption violated.");
                return;
            } else {
                long v5_0 = this.e;
                if ((!v0_4.isAdded()) || (v3_0 != null)) {
                    if ((!v0_4.isAdded()) || (v3_0.getParent() == null)) {
                        if (!v0_4.isAdded()) {
                            if (v5_0.L()) {
                                if (!v5_0.G) {
                                    this.d.a(new androidx.lifecycle.g(this, p8));
                                    return;
                                }
                            } else {
                                ((java.util.concurrent.CopyOnWriteArrayList) v5_0.l.a).add(new androidx.fragment.app.v0(new r2.b(this, v0_4, v2_0), 0));
                                androidx.fragment.app.b v1_10 = new androidx.fragment.app.b(v5_0);
                                StringBuilder v2_5 = new StringBuilder("f");
                                v2_5.append(p8.e);
                                v1_10.c(0, v0_4, v2_5.toString());
                                v1_10.h(v0_4, androidx.lifecycle.Lifecycle$State.j);
                                if (v1_10.g) {
                                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("This transaction is already being added to the back stack");
                                    return;
                                } else {
                                    v1_10.p.y(v1_10, 0);
                                    this.i.b(0);
                                    return;
                                }
                            }
                        } else {
                            rc.q.k(v3_0, v2_0);
                            return;
                        }
                    } else {
                        if (v3_0.getParent() != v2_0) {
                            rc.q.k(v3_0, v2_0);
                            return;
                        }
                    }
                    return;
                } else {
                    ((java.util.concurrent.CopyOnWriteArrayList) v5_0.l.a).add(new androidx.fragment.app.v0(new r2.b(this, v0_4, v2_0), 0));
                    return;
                }
            }
        }
    }

    public final void p(long p6)
    {
        t.g v0 = this.f;
        androidx.fragment.app.h1 v1_1 = ((androidx.fragment.app.i0) v0.b(p6));
        if (v1_1 != null) {
            if (v1_1.getView() != null) {
                int v2_0 = v1_1.getView().getParent();
                if (v2_0 != 0) {
                    ((android.widget.FrameLayout) v2_0).removeAllViews();
                }
            }
            androidx.fragment.app.b v3_0 = this.g;
            if (!rc.q.l(p6)) {
                v3_0.f(p6);
            }
            if (v1_1.isAdded()) {
                int v2_4 = this.e;
                if (!v2_4.L()) {
                    if ((v1_1.isAdded()) && (rc.q.l(p6))) {
                        v3_0.e(p6, v2_4.W(v1_1));
                    }
                    androidx.fragment.app.b v3_2 = new androidx.fragment.app.b(v2_4);
                    v3_2.g(v1_1);
                    if (v3_2.g) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("This transaction is already being added to the back stack");
                        return;
                    } else {
                        v3_2.p.y(v3_2, 0);
                        v0.f(p6);
                        return;
                    }
                } else {
                    this.k = 1;
                    return;
                }
            } else {
                v0.f(p6);
                return;
            }
        } else {
            return;
        }
    }
}
