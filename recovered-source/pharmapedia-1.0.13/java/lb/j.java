// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lb;
public final class j {
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater e;
    public static final synthetic java.util.concurrent.atomic.AtomicLongFieldUpdater f;
    public static final com.google.gson.internal.b g;
    private volatile synthetic Object _next$volatile;
    private volatile synthetic long _state$volatile;
    public final int a;
    public final boolean b;
    public final int c;
    public final synthetic java.util.concurrent.atomic.AtomicReferenceArray d;

    static j()
    {
        lb.j.e = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(lb.j, Object, "_next$volatile");
        lb.j.f = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(lb.j, "_state$volatile");
        lb.j.g = new com.google.gson.internal.b("REMOVE_FROZEN", 3);
        return;
    }

    public j(int p3, boolean p4)
    {
        this.a = p3;
        this.b = p4;
        int v4_1 = (p3 - 1);
        this.c = v4_1;
        this.d = new java.util.concurrent.atomic.AtomicReferenceArray(p3);
        if (v4_1 > 1073741823) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Check failed.");
            throw 0;
        } else {
            if ((p3 & v4_1) != 0) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Check failed.");
                throw 0;
            } else {
                return;
            }
        }
    }

    public final int a(Object p15)
    {
        do {
            int v0_0 = lb.j.f;
            int v3_0 = v0_0.get(this);
            if ((3458764513820540928 & v3_0) == 0) {
                int v1_0 = ((int) (1073741823 & v3_0));
                int v9_0 = ((int) ((1152921503533105152 & v3_0) >> 30));
                int v10 = this.c;
                if (((v9_0 + 2) & v10) != (v1_0 & v10)) {
                    java.util.concurrent.atomic.AtomicReferenceArray v11 = this.d;
                    if ((this.b) || (v11.get((v9_0 & v10)) == null)) {
                        if (!lb.j.f.compareAndSet(this, v3_0, ((-1152921503533105153 & v3_0) | (((long) ((v9_0 + 1) & 1073741823)) << 30)))) {
                            break;
                        }
                        v11.set((v9_0 & v10), p15);
                        int v1_9 = this;
                        while ((v0_0.get(v1_9) & 1152921504606846976) != 0) {
                            v1_9 = v1_9.c();
                            java.util.concurrent.atomic.AtomicReferenceArray v2_5 = v1_9.d;
                            int v3_2 = (v1_9.c & v9_0);
                            int v4_1 = v2_5.get(v3_2);
                            if ((!(v4_1 instanceof lb.i)) || (((lb.i) v4_1).a != v9_0)) {
                                v1_9 = 0;
                            } else {
                                v2_5.set(v3_2, p15);
                            }
                            if (v1_9 == 0) {
                                break;
                            }
                        }
                        return 0;
                    } else {
                        java.util.concurrent.atomic.AtomicReferenceArray v2_6 = this.a;
                    }
                }
            } else {
                if ((2305843009213693952 & v3_0) != 0) {
                    return 2;
                }
            }
            return 1;
        } while((v2_6 >= 1024) && (((v9_0 - v1_0) & 1073741823) <= (v2_6 >> 1)));
    }

    public final boolean b()
    {
        do {
            boolean v0_0 = lb.j.f;
            long v2 = v0_0.get(this);
            if ((v2 & 2305843009213693952) == 0) {
                if ((1152921504606846976 & v2) == 0) {
                } else {
                    return 0;
                }
            } else {
                return 1;
            }
        } while(!v0_0.compareAndSet(this, v2, (2305843009213693952 | v2)));
        return 1;
    }

    public final lb.j c()
    {
        do {
            lb.j v1_0;
            java.util.concurrent.atomic.AtomicLongFieldUpdater v0 = lb.j.f;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater v2_1 = v0.get(this);
            if ((v2_1 & 1152921504606846976) == 0) {
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater v4_2 = (1152921504606846976 | v2_1);
                v1_0 = this;
            } else {
                v1_0 = this;
            }
            do {
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater v4_0 = lb.j.e;
                lb.j v5_1 = ((lb.j) v4_0.get(this));
                if (v5_1 == null) {
                    lb.j v5_3 = new lb.j((v1_0.a * 2), v1_0.b);
                    Object v6_4 = ((int) (1073741823 & v2_1));
                    int v7_4 = ((int) ((1152921503533105152 & v2_1) >> 30));
                    while(true) {
                        lb.i v8_0 = v1_0.c;
                        int v9_1 = (v6_4 & v8_0);
                        if (v9_1 == (v8_0 & v7_4)) {
                            break;
                        }
                        lb.i v8_3 = v1_0.d.get(v9_1);
                        if (v8_3 == null) {
                            v8_3 = new lb.i(v6_4);
                        }
                        v5_3.d.set((v5_3.c & v6_4), v8_3);
                        v6_4++;
                    }
                    v0.set(v5_3, (-1152921504606846977 & v2_1));
                    while (!v4_0.compareAndSet(this, 0, v5_3)) {
                    }
                } else {
                    return v5_1;
                }
            } while(v4_0.get(this) == null);
        } while(!v0.compareAndSet(this, v2_1, v4_2));
    }

    public final Object d()
    {
        int v1_0 = this;
        do {
            java.util.concurrent.atomic.AtomicLongFieldUpdater v6 = lb.j.f;
            int v2_0 = v6.get(v1_0);
            if ((v2_0 & 1152921504606846976) == 0) {
                int v0_0 = ((int) (v2_0 & 1073741823));
                boolean v5_0 = v1_0.c;
                int v13_1 = (v0_0 & v5_0);
                if ((((int) ((1152921503533105152 & v2_0) >> 30)) & v5_0) != v13_1) {
                    java.util.concurrent.atomic.AtomicReferenceArray v15 = v1_0.d;
                    long v4_6 = v15.get(v13_1);
                    boolean v5_1 = v1_0.b;
                    if (v4_6 != 0) {
                        if (!(v4_6 instanceof lb.i)) {
                            long v7_3 = ((long) ((v0_0 + 1) & 1073741823));
                            Object v18_2 = v4_6;
                            if (!lb.j.f.compareAndSet(v1_0, v2_0, ((v2_0 & -1073741824) | v7_3))) {
                                v1_0 = this;
                            } else {
                                v15.set(v13_1, 0);
                                return v18_2;
                            }
                        }
                    } else {
                        if (v5_1) {
                        }
                    }
                }
                return 0;
            } else {
                return lb.j.g;
            }
        } while(!v5_1);
        while(true) {
            long v24 = v6.get(v1_0);
            if ((v24 & 1152921504606846976) == 0) {
                lb.j v23 = v1_0;
                int v2_5 = v23;
                if (!lb.j.f.compareAndSet(v23, v24, ((v24 & -1073741824) | v7_3))) {
                    v1_0 = v2_5;
                } else {
                    v2_5.d.set((((int) (v24 & 1073741823)) & v2_5.c), 0);
                    v1_0 = 0;
                }
            } else {
                v1_0 = v1_0.c();
            }
            if (v1_0 == 0) {
                break;
            }
        }
        return v18_2;
    }
}
