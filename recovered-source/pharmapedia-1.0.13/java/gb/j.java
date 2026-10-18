// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class j extends gb.w0 {
    public final synthetic int k;
    public final gb.h l;

    public synthetic j(gb.h p1, int p2)
    {
        this.k = p2;
        this.l = p1;
        return;
    }

    public final boolean k()
    {
        switch (this.k) {
            case 0:
                return 1;
            default:
                return 0;
        }
    }

    public final void l(Throwable p7)
    {
        switch (this.k) {
            case 0:
                gb.h v0_0 = this.l;
                boolean v7_4 = v0_0.q(this.j());
                if (v0_0.w()) {
                    lb.e v1_1 = ((lb.e) v0_0.j);
                    java.util.concurrent.atomic.AtomicReferenceFieldUpdater v2 = lb.e.n;
                    do {
                        Object v3_0 = v2.get(v1_1);
                        Object v4_0 = lb.a.c;
                        if (!kotlin.jvm.internal.f.a(v3_0, v4_0)) {
                            if ((v3_0 instanceof Throwable)) {
                                return;
                            }
                            while (!v2.compareAndSet(v1_1, v3_0, 0)) {
                                if (v2.get(v1_1) != v3_0) {
                                }
                            }
                            v0_0.e(v7_4);
                            if (v0_0.w()) {
                                return;
                            } else {
                                v0_0.o();
                                return;
                            }
                        }
                    } while(!v2.compareAndSet(v1_1, v4_0, v7_4));
                    if (v2.get(v1_1) != v4_0) {
                    } else {
                        while (!v2.compareAndSet(v1_1, v4_0, v7_4)) {
                        }
                    }
                }
                return;
            default:
                this.l.resumeWith(ga.p.a);
                return;
        }
    }
}
