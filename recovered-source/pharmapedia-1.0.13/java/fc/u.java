// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final class u implements oc.b0 {
    public final boolean g;
    public final oc.i h;
    public boolean i;
    public final synthetic fc.x j;

    public u(fc.x p1, boolean p2)
    {
        this.j = p1;
        this.g = p2;
        this.h = new oc.i();
        return;
    }

    public final void D(long p4, oc.i p6)
    {
        oc.i v0 = this.h;
        v0.D(p4, p6);
        while (v0.h >= 16384) {
            this.d(0);
        }
        return;
    }

    public final oc.f0 a()
    {
        return this.j.q;
    }

    public final void close()
    {
        try {
            if (!this.i) {
                Throwable v0_0;
                if (this.j.f() != null) {
                    v0_0 = 0;
                } else {
                    v0_0 = 1;
                }
                fc.x v1_1 = this.j;
                if (!v1_1.o.g) {
                    if (this.h.h <= 0) {
                        if (v0_0 == null) {
                            fc.x v1_2 = this.j;
                            try {
                                this.i = 1;
                                v1_2.notifyAll();
                                this.j.h.C.flush();
                                this.j.a();
                                return;
                            } catch (Throwable v0_9) {
                                throw v0_9;
                            }
                        } else {
                            v1_1.h.M(v1_1.g, 1, 0, 0);
                        }
                    }
                    while (this.h.h > 0) {
                        this.d(1);
                    }
                }
            } else {
                return;
            }
        } catch (Throwable v0_11) {
            throw v0_11;
        }
    }

    public final void d(boolean p13)
    {
        fc.x v1 = this.j;
        try {
            v1.q.h();
            try {
                while ((v1.j >= v1.k) && ((!this.g) && ((!this.i) && (v1.f() == null)))) {
                    v1.wait();
                }
            } catch (fc.w v0_8) {
                Throwable v13_13 = v0_8;
                v1.q.k();
                throw v13_13;
            }
            Throwable v13_3;
            v1.q.k();
            v1.b();
            long v10 = Math.min((v1.k - v1.j), this.h.h);
            v1.j = (v1.j + v10);
            if ((p13 == null) || (v10 != this.h.h)) {
                v13_3 = 0;
            } else {
                v13_3 = 1;
            }
            int v8 = v13_3;
            this.j.q.h();
            try {
                Throwable v13_6 = this.j;
                v13_6.h.M(v13_6.g, v8, this.h, v10);
                this.j.q.k();
                return;
            } catch (fc.w v0_4) {
                Throwable v13_9 = v0_4;
                this.j.q.k();
                throw v13_9;
            }
        } catch (fc.w v0_10) {
            throw v0_10;
        }
    }

    public final void flush()
    {
        try {
            this.j.b();
        } catch (Throwable v1) {
            throw v1;
        }
        while (this.h.h > 0) {
            this.d(0);
            this.j.h.C.flush();
        }
        return;
    }
}
