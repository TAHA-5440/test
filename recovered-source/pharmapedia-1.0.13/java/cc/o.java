// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public final class o implements java.lang.Runnable {
    public final com.google.firebase.perf.network.InstrumentOkHttpEnqueueCallback g;
    public volatile java.util.concurrent.atomic.AtomicInteger h;
    public final synthetic cc.r i;

    public o(cc.r p1, com.google.firebase.perf.network.InstrumentOkHttpEnqueueCallback p2)
    {
        this.i = p1;
        this.g = p2;
        this.h = new java.util.concurrent.atomic.AtomicInteger(0);
        return;
    }

    public final void run()
    {
        int v2_0 = "OkHttp ".concat(((yb.u) this.i.h.b).h());
        cc.r v3_0 = this.i;
        Thread v4 = Thread.currentThread();
        String v5 = v4.getName();
        v4.setName(v2_0);
        try {
            v3_0.j.h();
            try {
                java.io.IOException v7_0 = v3_0.f();
                try {
                    this.g.onResponse(v3_0, v7_0);
                } catch (boolean v1_1) {
                    v7_0 = 1;
                    if (v7_0 == null) {
                        this.g.onFailure(v3_0, v1_1);
                    } else {
                        ic.e.a.i(4, "Callback failure for ".concat(cc.r.a(v3_0)), v1_1);
                    }
                    yb.q v0_4 = v3_0.g.a;
                    v0_4.getClass();
                    yb.q.i(v0_4, 0, 0, this, 3);
                    v4.setName(v5);
                    return;
                } catch (yb.q v0_1) {
                    v7_0 = 1;
                    v3_0.c();
                    if (v7_0 == null) {
                        StringBuilder v8_2 = new StringBuilder("canceled due to ");
                        v8_2.append(v0_1);
                        java.io.IOException v7_2 = new java.io.IOException(v8_2.toString());
                        v7_2.initCause(v0_1);
                        this.g.onFailure(v3_0, v7_2);
                    }
                    if (!(v0_1 instanceof InterruptedException)) {
                        throw v0_1;
                    } else {
                        Thread.currentThread().interrupt();
                        v0_4 = v3_0.g.a;
                    }
                }
                v0_4 = v3_0.g.a;
            } catch (yb.q v0_1) {
            }
        } catch (yb.q v0_10) {
            v4.setName(v5);
            throw v0_10;
        }
    }
}
