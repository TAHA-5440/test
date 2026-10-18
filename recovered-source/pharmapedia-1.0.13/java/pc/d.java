// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package pc;
public final class d implements oc.b0 {
    public final java.io.OutputStream g;
    public final pc.j h;
    public final synthetic c0.g i;

    public d(c0.g p2)
    {
        this.i = p2;
        java.net.Socket v2_2 = ((java.net.Socket) p2.h);
        this.g = v2_2.getOutputStream();
        this.h = new pc.j(v2_2);
        return;
    }

    public final void D(long p7, oc.i p9)
    {
        oc.b.c(p9.h, 0, p7);
        while (p7 > 0) {
            oc.z v1_3 = this.h;
            v1_3.f();
            Throwable v0_1 = p9.g;
            v0_1.getClass();
            int v2_5 = ((int) Math.min(p7, ((long) (v0_1.c - v0_1.b))));
            v1_3.h();
            try {
                this.g.write(v0_1.a, v0_1.b, v2_5);
            } catch (Throwable v0_2) {
                java.io.IOException v7_1 = v0_2;
                if (v1_3.i()) {
                    v7_1 = v1_3.k(v7_1);
                } else {
                }
                throw v7_1;
            } catch (Throwable v0_3) {
                java.io.IOException v7_2 = v0_3;
                v1_3.i();
                throw v7_2;
            }
            if (v1_3.i()) {
                throw v1_3.k(0);
            } else {
                oc.z v1_1 = (v0_1.b + v2_5);
                v0_1.b = v1_1;
                int v2_6 = ((long) v2_5);
                p7 -= v2_6;
                p9.h = (p9.h - v2_6);
                if (v1_1 == v0_1.c) {
                    p9.g = v0_1.a();
                    oc.a0.a(v0_1);
                }
            }
        }
        return;
    }

    public final oc.f0 a()
    {
        return this.h;
    }

    public final void close()
    {
        java.io.IOException v0_0 = this.g;
        boolean v1_0 = this.i;
        pc.j v2 = this.h;
        v2.h();
        try {
            boolean v3_4 = ((java.util.concurrent.atomic.AtomicInteger) v1_0.i);
            boolean v1_3 = ((java.net.Socket) v1_0.h);
            v3_4.getClass();
        } catch (java.io.IOException v0_4) {
            if (v2.i()) {
                v0_4 = v2.k(v0_4);
            } else {
            }
            throw v0_4;
        } catch (java.io.IOException v0_5) {
            v2.i();
            throw v0_5;
        }
        do {
            boolean v3_0;
            int v4_0 = v3_4.get();
            if ((v4_0 & 1) == 0) {
                int v5_1 = (v4_0 | 1);
            } else {
                v3_0 = 0;
            }
            if (!v3_0) {
                v2.i();
                return;
            } else {
                if (v3_0 == 3) {
                    v1_3.close();
                } else {
                    if (!v1_3.isClosed()) {
                        if (!v1_3.isOutputShutdown()) {
                            v0_0.flush();
                            v1_3.shutdownOutput();
                            if (v2.i()) {
                                throw v2.k(0);
                            } else {
                                return;
                            }
                        } else {
                        }
                    }
                    v2.i();
                    return;
                }
            }
        } while(!v3_4.compareAndSet(v4_0, v5_1));
        v3_0 = v5_1;
    }

    public final void flush()
    {
        java.io.IOException v0_0 = this.h;
        v0_0.h();
        try {
            this.g.flush();
        } catch (java.io.IOException v1_0) {
            if (v0_0.i()) {
                v1_0 = v0_0.k(v1_0);
            } else {
            }
            throw v1_0;
        } catch (java.io.IOException v1_1) {
            v0_0.i();
            throw v1_1;
        }
        if (v0_0.i()) {
            throw v0_0.k(0);
        } else {
            return;
        }
    }

    public final String toString()
    {
        String v0_2 = new StringBuilder("sink(");
        v0_2.append(((java.net.Socket) this.i.h));
        v0_2.append(41);
        return v0_2.toString();
    }
}
