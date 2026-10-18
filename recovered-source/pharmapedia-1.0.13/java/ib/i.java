// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ib;
public final class i extends kotlinx.coroutines.channels.a {
    public final kotlinx.coroutines.channels.BufferOverflow q;

    public i(int p2, kotlinx.coroutines.channels.BufferOverflow p3)
    {
        super(p2);
        super.q = p3;
        if (p3 == kotlinx.coroutines.channels.BufferOverflow.g) {
            androidx.fragment.app.a.t(kotlin.jvm.internal.h.a(kotlinx.coroutines.channels.a).c(), "This implementation does not support suspension for senders, use ", " instead");
            throw 0;
        } else {
            if (p2 < 1) {
                oc.l.d(r1.a.h(p2, "Buffered channel capacity must be at least 1, but ", " was specified"));
                throw 0;
            } else {
                return;
            }
        }
    }

    public final Object E(Object p16, boolean p17)
    {
        ga.p v8 = ga.p.a;
        if (this.q != kotlinx.coroutines.channels.BufferOverflow.i) {
            int v6_0 = ib.b.d;
            long v1_1 = ((ib.h) kotlinx.coroutines.channels.a.l.get(this));
            do {
                ib.e v2_1 = kotlinx.coroutines.channels.a.h.getAndIncrement(this);
                long v4_1 = (1152921504606846975 & v2_1);
                boolean v7_1 = this.s(v2_1, 0);
                int v9 = ib.b.b;
                long v10 = ((long) v9);
                ib.e v2_2 = (v4_1 / v10);
                int v12_1 = ((int) (v4_1 % v10));
                if (v1_1.c != v2_2) {
                    ib.e v2_3 = kotlinx.coroutines.channels.a.a(this, v2_2, v1_1);
                    if (v2_3 != null) {
                        v1_1 = v2_3;
                    } else {
                        if (!v7_1) {
                            break;
                        }
                        return new ib.e(this.p());
                    }
                }
                ib.e v2_4 = v12_1;
                int v12_2 = kotlinx.coroutines.channels.a.e(this, v1_1, v2_4, p16, v4_1, v6_0, v7_1);
                if (v12_2 == 0) {
                    v1_1.a();
                    return v8;
                } else {
                    if (v12_2 != 1) {
                        if (v12_2 == 2) {
                            if (!v7_1) {
                                int v6_1;
                                if (!(v6_0 instanceof gb.n1)) {
                                    v6_1 = 0;
                                } else {
                                    v6_1 = ((gb.n1) v6_0);
                                }
                                if (v6_1 != 0) {
                                    v6_1.b(v1_1, (v2_4 + v9));
                                }
                                this.k(((v1_1.c * v10) + ((long) v2_4)));
                            } else {
                                v1_1.h();
                                return new ib.e(this.p());
                            }
                        } else {
                            if (v12_2 == 3) {
                                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("unexpected");
                                return 0;
                            } else {
                                if (v12_2 == 4) {
                                    if (v4_1 < kotlinx.coroutines.channels.a.i.get(this)) {
                                        v1_1.a();
                                    }
                                    return new ib.e(this.p());
                                } else {
                                }
                            }
                        }
                    }
                    return v8;
                }
            } while(v12_2 == 5);
        } else {
            long v1_10 = super.g(p16);
            if (((v1_10 instanceof ib.f)) && (!(v1_10 instanceof ib.e))) {
                return v8;
            } else {
                return v1_10;
            }
        }
    }

    public final Object b(Object p1, ka.c p2)
    {
        if ((this.E(p1, 1) instanceof ib.e)) {
            throw this.p();
        } else {
            return ga.p.a;
        }
    }

    public final Object g(Object p2)
    {
        return this.E(p2, 0);
    }

    public final boolean u()
    {
        if (this.q != kotlinx.coroutines.channels.BufferOverflow.h) {
            return 0;
        } else {
            return 1;
        }
    }
}
