// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lb;
public class u {
    public static final synthetic java.util.concurrent.atomic.AtomicIntegerFieldUpdater b;
    private volatile synthetic int _size$volatile;
    public gb.m0[] a;

    static u()
    {
        lb.u.b = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(lb.u, "_size$volatile");
        return;
    }

    public final void a(gb.m0 p5)
    {
        p5.d(((gb.n0) this));
        gb.m0[] v0_3 = this.a;
        java.util.concurrent.atomic.AtomicIntegerFieldUpdater v1 = lb.u.b;
        if (v0_3 != null) {
            if (v1.get(this) >= v0_3.length) {
                v0_3 = ((gb.m0[]) java.util.Arrays.copyOf(v0_3, (v1.get(this) * 2)));
                this.a = v0_3;
            }
        } else {
            v0_3 = new gb.m0[4];
            this.a = v0_3;
        }
        int v2_2 = v1.get(this);
        v1.set(this, (v2_2 + 1));
        v0_3[v2_2] = p5;
        p5.h = v2_2;
        this.c(v2_2);
        return;
    }

    public final gb.m0 b(int p9)
    {
        gb.m0[] v0 = this.a;
        v0.getClass();
        int v1_0 = lb.u.b;
        v1_0.set(this, (v1_0.get(this) + -1));
        if (p9 < v1_0.get(this)) {
            this.d(p9, v1_0.get(this));
            int v2_2 = ((p9 - 1) / 2);
            if (p9 > 0) {
                int v4_0 = v0[p9];
                v4_0.getClass();
                gb.m0 v5_0 = v0[v2_2];
                v5_0.getClass();
                if (v4_0.compareTo(v5_0) < 0) {
                    this.d(p9, v2_2);
                    this.c(v2_2);
                    int v9_2 = v0[v1_0.get(this)];
                    v9_2.getClass();
                    v9_2.d(0);
                    v9_2.h = -1;
                    v0[v1_0.get(this)] = 0;
                    return v9_2;
                }
            }
            while(true) {
                int v2_3 = (p9 * 2);
                int v4_2 = (v2_3 + 1);
                if (v4_2 >= v1_0.get(this)) {
                    break;
                }
                gb.m0 v5_2 = this.a;
                v5_2.getClass();
                int v2_4 = (v2_3 + 2);
                if (v2_4 >= v1_0.get(this)) {
                    v2_4 = v4_2;
                } else {
                    int v6_1 = v5_2[v2_4];
                    v6_1.getClass();
                    gb.m0 v7 = v5_2[v4_2];
                    v7.getClass();
                    if (v6_1.compareTo(v7) >= 0) {
                    }
                }
                int v4_3 = v5_2[p9];
                v4_3.getClass();
                gb.m0 v5_3 = v5_2[v2_4];
                v5_3.getClass();
                if (v4_3.compareTo(v5_3) <= 0) {
                    break;
                }
                this.d(p9, v2_4);
                p9 = v2_4;
            }
        }
        v9_2 = v0[v1_0.get(this)];
        v9_2.getClass();
        v9_2.d(0);
        v9_2.h = -1;
        v0[v1_0.get(this)] = 0;
        return v9_2;
    }

    public final void c(int p4)
    {
        while (p4 > 0) {
            int v0_0 = this.a;
            v0_0.getClass();
            int v1_1 = ((p4 - 1) / 2);
            gb.m0 v2 = v0_0[v1_1];
            v2.getClass();
            int v0_2 = v0_0[p4];
            v0_2.getClass();
            if (v2.compareTo(v0_2) <= 0) {
                break;
            }
            this.d(p4, v1_1);
            p4 = v1_1;
        }
        return;
    }

    public final void d(int p4, int p5)
    {
        gb.m0[] v0 = this.a;
        v0.getClass();
        gb.m0 v1 = v0[p5];
        v1.getClass();
        gb.m0 v2 = v0[p4];
        v2.getClass();
        v0[p4] = v1;
        v0[p5] = v2;
        v1.h = p4;
        v2.h = p5;
        return;
    }
}
