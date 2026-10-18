// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package hb;
public final class d extends gb.s implements gb.a0 {
    public final android.os.Handler i;
    public final boolean j;
    public final hb.d k;

    public d(android.os.Handler p2, boolean p3)
    {
        hb.d v3_2;
        this.i = p2;
        this.j = p3;
        if (p3 == null) {
            v3_2 = new hb.d(p2, 1);
        } else {
            v3_2 = this;
        }
        this.k = v3_2;
        return;
    }

    public final gb.g0 M(long p4, gb.j1 p6, ka.g p7)
    {
        if (p4 > 4611686018427387903) {
            p4 = 4611686018427387903;
        }
        if (!this.i.postDelayed(p6, p4)) {
            this.h0(p7, p6);
            return gb.d1.g;
        } else {
            return new hb.c(0, this, p6);
        }
    }

    public final void c0(long p5, gb.h p7)
    {
        b3.c v0_1 = new b3.c(7, p7, this, 0);
        if (p5 > 4611686018427387903) {
            p5 = 4611686018427387903;
        }
        if (!this.i.postDelayed(v0_1, p5)) {
            this.h0(p7.k, v0_1);
            return;
        } else {
            p7.u(new ac.d(3, this, v0_1));
            return;
        }
    }

    public final void d0(ka.g p2, Runnable p3)
    {
        if (!this.i.post(p3)) {
            this.h0(p2, p3);
        }
        return;
    }

    public final boolean equals(Object p3)
    {
        if ((!(p3 instanceof hb.d)) || ((((hb.d) p3).i != this.i) || (((hb.d) p3).j != this.j))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final boolean f0(ka.g p2)
    {
        if ((this.j) && (kotlin.jvm.internal.f.a(android.os.Looper.myLooper(), this.i.getLooper()))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final gb.s g0(int p1, String p2)
    {
        lb.a.a(1);
        return this;
    }

    public final void h0(ka.g p4, Runnable p5)
    {
        gb.u0 v1_4 = new StringBuilder("The task was rejected, the handler underlying the dispatcher \'");
        v1_4.append(this);
        v1_4.append("\' was closed");
        nb.c v0_2 = new java.util.concurrent.CancellationException(v1_4.toString());
        gb.u0 v1_3 = ((gb.u0) p4.Z(gb.t.h));
        if (v1_3 != null) {
            v1_3.h(v0_2);
        }
        nb.c.i.d0(p4, p5);
        return;
    }

    public final int hashCode()
    {
        int v1_1;
        int vtmp1 = System.identityHashCode(this.i);
        if (!this.j) {
            v1_1 = 1237;
        } else {
            v1_1 = 1231;
        }
        return (vtmp1 ^ v1_1);
    }

    public final String toString()
    {
        String v0_2;
        String v0_0 = lb.k.a;
        if (this != v0_0) {
            try {
                String v0_3 = v0_0.k;
            } catch (UnsupportedOperationException) {
                v0_3 = 0;
            }
            if (this != v0_3) {
                v0_2 = 0;
            } else {
                v0_2 = "Dispatchers.Main.immediate";
            }
        } else {
            v0_2 = "Dispatchers.Main";
        }
        if (v0_2 == null) {
            v0_2 = this.i.toString();
            if (this.j) {
                v0_2 = f0.a.c(v0_2, ".immediate");
            }
        }
        return v0_2;
    }
}
