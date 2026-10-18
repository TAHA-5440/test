// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public final class d implements oc.d0 {
    public final synthetic int g;
    public final Object h;
    public final Object i;

    public d(java.io.InputStream p2, oc.f0 p3)
    {
        this.g = 1;
        p2.getClass();
        this.h = p2;
        this.i = p3;
        return;
    }

    public d(pc.j p2, oc.d p3)
    {
        this.g = 0;
        this.h = p2;
        this.i = p3;
        return;
    }

    public final long N(long p4, oc.i p6)
    {
        long v0_0 = this.g;
        p6.getClass();
        switch (v0_0) {
            case 0:
                long v0_5 = ((pc.j) this.h);
                byte[] v1_5 = ((oc.d) this.i);
                v0_5.h();
                try {
                    java.io.IOException v4_13 = v1_5.N(p4, p6);
                } catch (java.io.IOException v4_1) {
                    if (v0_5.i()) {
                        v4_1 = v0_5.k(v4_1);
                    } else {
                    }
                    throw v4_1;
                } catch (java.io.IOException v4_2) {
                    v0_5.i();
                    throw v4_2;
                }
                if (v0_5.i()) {
                    throw v0_5.k(0);
                } else {
                    return v4_13;
                }
            default:
                long v0_1 = 0;
                int v2_0 = p4 cmp 0;
                if (v2_0 != 0) {
                    if (v2_0 < 0) {
                        oc.l.d(f0.a.b("byteCount < 0: ", p4));
                        v0_1 = 0;
                    } else {
                        ((oc.f0) this.i).f();
                        long v0_7 = p6.l0(1);
                        java.io.IOException v4_8 = ((java.io.InputStream) this.h).read(v0_7.a, v0_7.c, ((int) Math.min(p4, ((long) (8192 - v0_7.c)))));
                        if (v4_8 != -1) {
                            v0_7.c = (v0_7.c + v4_8);
                            java.io.IOException v4_9 = ((long) v4_8);
                            p6.h = (p6.h + v4_9);
                            v0_1 = v4_9;
                        } else {
                            if (v0_7.b == v0_7.c) {
                                p6.g = v0_7.a();
                                oc.a0.a(v0_7);
                            }
                            v0_1 = -1;
                        }
                    }
                }
                return v0_1;
        }
    }

    public final oc.f0 a()
    {
        switch (this.g) {
            case 0:
                return ((pc.j) this.h);
            default:
                return ((oc.f0) this.i);
        }
    }

    public final void close()
    {
        switch (this.g) {
            case 0:
                java.io.IOException v0_5 = ((pc.j) this.h);
                java.io.IOException v1_4 = ((oc.d) this.i);
                v0_5.h();
                try {
                    v1_4.close();
                } catch (java.io.IOException v1_0) {
                    if (v0_5.i()) {
                        v1_0 = v0_5.k(v1_0);
                    } else {
                    }
                    throw v1_0;
                } catch (java.io.IOException v1_1) {
                    v0_5.i();
                    throw v1_1;
                }
                if (v0_5.i()) {
                    throw v0_5.k(0);
                } else {
                    return;
                }
            default:
                ((java.io.InputStream) this.h).close();
                return;
        }
    }

    public final String toString()
    {
        switch (this.g) {
            case 0:
                String v0_6 = new StringBuilder("AsyncTimeout.source(");
                v0_6.append(((oc.d) this.i));
                v0_6.append(41);
                return v0_6.toString();
            default:
                String v0_3 = new StringBuilder("source(");
                v0_3.append(((java.io.InputStream) this.h));
                v0_3.append(41);
                return v0_3.toString();
        }
    }
}
