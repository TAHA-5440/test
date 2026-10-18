// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public final class c implements oc.b0 {
    public final synthetic int g;
    public final Object h;
    public final Object i;

    public c(java.io.OutputStream p2, oc.f0 p3)
    {
        this.g = 1;
        p2.getClass();
        this.h = p2;
        this.i = p3;
        return;
    }

    public c(pc.j p2, oc.c p3)
    {
        this.g = 0;
        this.h = p2;
        this.i = p3;
        return;
    }

    public final void D(long p12, oc.i p14)
    {
        switch (this.g) {
            case 0:
                oc.b.c(p14.h, 0, p12);
                java.io.IOException v12_5 = p12;
                while(true) {
                    Throwable v0_1 = 0;
                    if (v12_5 <= 0) {
                        break;
                    }
                    oc.z v2_0 = p14.g;
                    v2_0.getClass();
                    while (v0_1 < 65536) {
                        v0_1 += ((long) (v2_0.c - v2_0.b));
                        if (v0_1 < v12_5) {
                            v2_0 = v2_0.f;
                            v2_0.getClass();
                        } else {
                            v0_1 = v12_5;
                            break;
                        }
                    }
                    oc.z v2_2 = ((pc.j) this.h);
                    boolean v3_7 = ((oc.c) this.i);
                    v2_2.h();
                    try {
                        v3_7.D(v0_1, p14);
                    } catch (Throwable v0_2) {
                        java.io.IOException v12_1 = v0_2;
                        if (v2_2.i()) {
                            v12_1 = v2_2.k(v12_1);
                        } else {
                        }
                        throw v12_1;
                    } catch (Throwable v0_3) {
                        java.io.IOException v12_2 = v0_3;
                        v2_2.i();
                        throw v12_2;
                    }
                    if (v2_2.i()) {
                        throw v2_2.k(0);
                    } else {
                        v12_5 -= v0_1;
                    }
                }
                return;
            default:
                oc.b.c(p14.h, 0, p12);
                while (p12 > 0) {
                    ((oc.f0) this.i).f();
                    Throwable v0_8 = p14.g;
                    v0_8.getClass();
                    oc.z v1_5 = ((int) Math.min(p12, ((long) (v0_8.c - v0_8.b))));
                    ((java.io.OutputStream) this.h).write(v0_8.a, v0_8.b, v1_5);
                    oc.z v2_7 = (v0_8.b + v1_5);
                    v0_8.b = v2_7;
                    boolean v3_11 = ((long) v1_5);
                    p12 -= v3_11;
                    p14.h = (p14.h - v3_11);
                    if (v2_7 == v0_8.c) {
                        p14.g = v0_8.a();
                        oc.a0.a(v0_8);
                    }
                }
                return;
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
                java.io.IOException v1_4 = ((oc.c) this.i);
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
                ((java.io.OutputStream) this.h).close();
                return;
        }
    }

    public final void flush()
    {
        switch (this.g) {
            case 0:
                java.io.IOException v0_5 = ((pc.j) this.h);
                java.io.IOException v1_4 = ((oc.c) this.i);
                v0_5.h();
                try {
                    v1_4.flush();
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
                ((java.io.OutputStream) this.h).flush();
                return;
        }
    }

    public final String toString()
    {
        switch (this.g) {
            case 0:
                String v0_6 = new StringBuilder("AsyncTimeout.sink(");
                v0_6.append(((oc.c) this.i));
                v0_6.append(41);
                return v0_6.toString();
            default:
                String v0_3 = new StringBuilder("sink(");
                v0_3.append(((java.io.OutputStream) this.h));
                v0_3.append(41);
                return v0_3.toString();
        }
    }
}
