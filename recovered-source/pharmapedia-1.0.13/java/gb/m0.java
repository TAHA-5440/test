// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public abstract class m0 implements java.lang.Runnable, java.lang.Comparable, gb.g0 {
    private volatile Object _heap;
    public long g;
    public int h;

    public m0(long p1)
    {
        this.g = p1;
        this.h = -1;
        return;
    }

    public final void b()
    {
        int v0_0 = this._heap;
        Throwable v1_0 = gb.w.b;
        if (v0_0 != v1_0) {
            int v0_2;
            lb.u v3_1 = 0;
            if (!(v0_0 instanceof gb.n0)) {
                v0_2 = 0;
            } else {
                v0_2 = ((gb.n0) v0_0);
            }
            if (v0_2 != 0) {
                int v2_2 = this._heap;
                if ((v2_2 instanceof lb.u)) {
                    v3_1 = ((lb.u) v2_2);
                }
                if (v3_1 != null) {
                    v0_2.b(this.h);
                } else {
                }
            }
            this._heap = v1_0;
            return;
        } else {
            return;
        }
    }

    public final int c(long p9, gb.n0 p11, gb.o0 p12)
    {
        try {
            if (this._heap != gb.w.b) {
                int v0_2;
                int v0_1 = p11.a;
                if (v0_1 == 0) {
                    v0_2 = 0;
                } else {
                    v0_2 = v0_1[0];
                }
                long v12_2;
                if (gb.o0.o.get(p12) == 0) {
                    v12_2 = 0;
                } else {
                    v12_2 = 1;
                }
                if (v12_2 == 0) {
                    if (v0_2 != 0) {
                        long v4_0 = v0_2.g;
                        if ((v4_0 - p9) < 0) {
                            p9 = v4_0;
                        } else {
                        }
                        if ((p9 - p11.c) > 0) {
                            p11.c = p9;
                        }
                    } else {
                        p11.c = p9;
                    }
                    long v4_3 = p11.c;
                    if ((this.g - v4_3) < 0) {
                        this.g = v4_3;
                    }
                    p11.a(this);
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 2;
            }
        } catch (long v9_5) {
            throw v9_5;
        }
    }

    public final int compareTo(Object p5)
    {
        int v5_4 = (this.g - ((gb.m0) p5).g) cmp 0;
        if (v5_4 <= 0) {
            if (v5_4 >= 0) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return 1;
        }
    }

    public final void d(gb.n0 p3)
    {
        if (this._heap == gb.w.b) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Failed requirement.");
            return;
        } else {
            this._heap = p3;
            return;
        }
    }

    public String toString()
    {
        String v0_1 = new StringBuilder("Delayed[nanos=");
        v0_1.append(this.g);
        v0_1.append(93);
        return v0_1.toString();
    }
}
