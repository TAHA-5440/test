// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lc;
public final class b {
    public static final okio.ByteString b;
    public static final java.util.List c;
    public static final lc.b d;
    public final lc.a a;

    static b()
    {
        lc.b v0_4 = new byte[1];
        v0_4[0] = 42;
        lc.b.b = n5.f.t(v0_4);
        lc.b.c = com.bumptech.glide.e.l("*");
        lc.b.d = new lc.b(new lc.a(0));
        return;
    }

    public b(lc.a p1)
    {
        this.a = p1;
        return;
    }

    public static java.util.List b(String p4)
    {
        int v1_0 = new char[1];
        int v2 = 0;
        v1_0[0] = 46;
        java.util.List v4_1 = db.i.k0(p4, v1_0);
        if (kotlin.jvm.internal.f.a(ha.j.J(v4_1), "")) {
            int v1_3 = (v4_1.size() - 1);
            if (v1_3 >= 0) {
                v2 = v1_3;
            }
            v4_1 = ha.j.S(v2, v4_1);
        }
        return v4_1;
    }

    public final String a(String p14)
    {
        int v0_0 = java.net.IDN.toUnicode(p14);
        v0_0.getClass();
        int v0_4 = lc.b.b(v0_0);
        cb.c v1_9 = this.a;
        int v2_26 = ((java.util.concurrent.atomic.AtomicBoolean) v1_9.b);
        if ((v2_26.get()) || (!v2_26.compareAndSet(0, 1))) {
            try {
                ((java.util.concurrent.CountDownLatch) v1_9.c).await();
            } catch (InterruptedException) {
                Thread.currentThread().interrupt();
            }
        } else {
            int v2_16 = 0;
            try {
                while(true) {
                    v1_9.g();
                    Thread.interrupted();
                    v2_16 = 1;
                }
            } catch (java.io.InterruptedIOException) {
            } catch (char v3_4) {
                v1_9.f = v3_4;
                if (v2_16 != 0) {
                    Thread.currentThread().interrupt();
                }
            } catch (cb.c v14_10) {
                if (v2_16 != 0) {
                    Thread.currentThread().interrupt();
                }
                throw v14_10;
            }
            if (v2_16 != 0) {
            }
        }
        if (((okio.ByteString) v1_9.d) == null) {
            int v0_6 = new StringBuilder("Unable to load ");
            v0_6.append(((String) v1_9.g));
            v0_6.append(" resource.");
            cb.c v14_12 = new IllegalStateException(v0_6.toString());
            v14_12.initCause(((java.io.IOException) v1_9.f));
            throw v14_12;
        } else {
            int v2_24 = v0_4.size();
            char v3_5 = new okio.ByteString[v2_24];
            int v6_3 = 0;
            while (v6_3 < v2_24) {
                v3_5[v6_3] = n5.f.o(((String) v0_4.get(v6_3)));
                v6_3++;
            }
            int v6_4 = 0;
            while (v6_4 < v2_24) {
                String v9_2 = ((okio.ByteString) v1_9.d);
                if (v9_2 == null) {
                    kotlin.jvm.internal.f.i("bytes");
                    throw 0;
                } else {
                    String v9_0 = ea.c.r(v9_2, v3_5, v6_4);
                    if (v9_0 == null) {
                        v6_4++;
                    }
                }
                String v12_0;
                if (v2_24 <= 1) {
                    v12_0 = 0;
                } else {
                    int v6_6 = ((okio.ByteString[]) v3_5.clone());
                    int v10_1 = (v6_6.length - 1);
                    int v11 = 0;
                    while (v11 < v10_1) {
                        v6_6[v11] = lc.b.b;
                        String v12_3 = ((okio.ByteString) v1_9.d);
                        if (v12_3 == null) {
                            kotlin.jvm.internal.f.i("bytes");
                            throw 0;
                        } else {
                            v12_0 = ea.c.r(v12_3, v6_6, v11);
                            if (v12_0 == null) {
                                v11++;
                            }
                        }
                    }
                }
                String v7_0;
                if (v12_0 == null) {
                    v7_0 = 0;
                } else {
                    int v2_27 = (v2_24 - 1);
                    int v6_0 = 0;
                    while (v6_0 < v2_27) {
                        String v7_2 = ((okio.ByteString) v1_9.e);
                        if (v7_2 == null) {
                            kotlin.jvm.internal.f.i("exceptionBytes");
                            throw 0;
                        } else {
                            v7_0 = ea.c.r(v7_2, v3_5, v6_0);
                            if (v7_0 == null) {
                                v6_0++;
                            }
                        }
                    }
                }
                cb.c v1_2;
                if (v7_0 == null) {
                    if ((v9_0 != null) || (v12_0 != null)) {
                        char v3_0;
                        int v2_0 = kotlin.collections.EmptyList.g;
                        if (v9_0 == null) {
                            v3_0 = v2_0;
                        } else {
                            char v3_1 = new char[1];
                            v3_1[0] = 46;
                            v3_0 = db.i.k0(v9_0, v3_1);
                        }
                        if (v12_0 != null) {
                            int v2_1 = new char[1];
                            v2_1[0] = 46;
                            v2_0 = db.i.k0(v12_0, v2_1);
                        }
                        if (v3_0.size() <= v2_0.size()) {
                            v1_2 = v2_0;
                        } else {
                            v1_2 = v3_0;
                        }
                    } else {
                        v1_2 = lc.b.c;
                    }
                } else {
                    int v2_3 = "!".concat(v7_0);
                    char v3_2 = new char[1];
                    v3_2[0] = 46;
                    v1_2 = db.i.k0(v2_3, v3_2);
                }
                if ((v0_4.size() != v1_2.size()) || (((String) v1_2.get(0)).charAt(0) == 33)) {
                    int v0_1;
                    cb.c v1_4;
                    if (((String) v1_2.get(0)).charAt(0) != 33) {
                        v0_1 = v0_4.size();
                        v1_4 = (v1_2.size() + 1);
                    } else {
                        v0_1 = v0_4.size();
                        v1_4 = v1_2.size();
                    }
                    int v0_2 = (v0_1 - v1_4);
                    cb.c v1_6 = new cb.j(lc.b.b(p14), 3);
                    if (v0_2 < 0) {
                        oc.l.d(r1.a.h(v0_2, "Requested element count ", " is less than zero."));
                        return 0;
                    } else {
                        if (v0_2 != 0) {
                            if (!(v1_6 instanceof cb.d)) {
                                v1_6 = new cb.c(v1_6, v0_2);
                            } else {
                                v1_6 = ((cb.d) v1_6).a(v0_2);
                            }
                        }
                        return cb.i.p(v1_6, ".");
                    }
                } else {
                    return 0;
                }
            }
            v9_0 = 0;
        }
    }
}
