// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package pc;
public final class e implements oc.d0 {
    public final java.io.InputStream g;
    public final pc.j h;
    public final synthetic c0.g i;

    public e(c0.g p2)
    {
        this.i = p2;
        java.net.Socket v2_2 = ((java.net.Socket) p2.h);
        this.g = v2_2.getInputStream();
        this.h = new pc.j(v2_2);
        return;
    }

    public final long N(long p5, oc.i p7)
    {
        p7.getClass();
        byte[] v2_3 = p5 cmp 0;
        if (v2_3 != null) {
            if (v2_3 < null) {
                oc.l.d(f0.a.b("byteCount < 0: ", p5));
                return 0;
            } else {
                long v0_1 = this.h;
                v0_1.f();
                oc.z v1_1 = p7.l0(1);
                long v5_2 = ((int) Math.min(p5, ((long) (8192 - v1_1.c))));
                try {
                    v0_1.h();
                    try {
                        long v5_3 = this.g.read(v1_1.a, v1_1.c, v5_2);
                    } catch (long v5_4) {
                        if (v0_1.i()) {
                            v5_4 = v0_1.k(v5_4);
                        } else {
                        }
                        throw v5_4;
                    } catch (long v5_5) {
                        v0_1.i();
                        throw v5_5;
                    }
                    if (v0_1.i()) {
                        throw v0_1.k(0);
                    } else {
                        if (v5_3 != -1) {
                            v1_1.c = (v1_1.c + v5_3);
                            long v5_9 = ((long) v5_3);
                            p7.h = (p7.h + v5_9);
                            return v5_9;
                        } else {
                            if (v1_1.b == v1_1.c) {
                                p7.g = v1_1.a();
                                oc.a0.a(v1_1);
                            }
                            return -1;
                        }
                    }
                } catch (long v5_8) {
                    if (!pc.n.a(v5_8)) {
                        throw v5_8;
                    } else {
                        throw new java.io.IOException(v5_8);
                    }
                }
            }
        } else {
            return 0;
        }
    }

    public final oc.f0 a()
    {
        return this.h;
    }

    public final void close()
    {
        java.io.InputStream v0_0 = this.i;
        pc.j v1 = this.h;
        v1.h();
        try {
            boolean v2_5 = ((java.util.concurrent.atomic.AtomicInteger) v0_0.i);
            java.io.InputStream v0_8 = ((java.net.Socket) v0_0.h);
            v2_5.getClass();
        } catch (java.io.InputStream v0_2) {
            if (v1.i()) {
                v0_2 = v1.k(v0_2);
            } else {
            }
            throw v0_2;
        } catch (java.io.InputStream v0_3) {
            v1.i();
            throw v0_3;
        }
        do {
            boolean v2_0;
            int v3_2 = v2_5.get();
            if ((v3_2 & 2) == 0) {
                int v4_1 = (v3_2 | 2);
            } else {
                v2_0 = 0;
            }
            if (!v2_0) {
                v1.i();
                return;
            } else {
                if (v2_0 == 3) {
                    v0_8.close();
                } else {
                    if ((!v0_8.isClosed()) && (!v0_8.isInputShutdown())) {
                        v0_8.shutdownInput();
                    } else {
                        v1.i();
                        return;
                    }
                }
                if (v1.i()) {
                    throw v1.k(0);
                } else {
                    return;
                }
            }
        } while(!v2_5.compareAndSet(v3_2, v4_1));
        v2_0 = v4_1;
    }

    public final String toString()
    {
        String v0_2 = new StringBuilder("source(");
        v0_2.append(((java.net.Socket) this.i.h));
        v0_2.append(41);
        return v0_2.toString();
    }
}
