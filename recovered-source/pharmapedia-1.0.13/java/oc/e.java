// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public class e extends oc.f0 {
    public static final cc.z h;
    public static oc.e i;
    public static final java.util.concurrent.locks.ReentrantLock j;
    public static final java.util.concurrent.locks.Condition k;
    public static final long l;
    public static final long m;
    public int e;
    public int f;
    public long g;

    static e()
    {
        long v0_4 = new cc.z(6, 0);
        oc.e[] v1_2 = new oc.e[8];
        v0_4.i = v1_2;
        oc.e.h = v0_4;
        long v0_6 = new java.util.concurrent.locks.ReentrantLock();
        oc.e.j = v0_6;
        long v0_1 = v0_6.newCondition();
        v0_1.getClass();
        oc.e.k = v0_1;
        oc.e.l = 60000;
        oc.e.m = java.util.concurrent.TimeUnit.MILLISECONDS.toNanos(60000);
        return;
    }

    public e()
    {
        this.f = -1;
        return;
    }

    public final void h()
    {
        String v0_0 = this.c;
        boolean v2 = this.a;
        if ((v0_0 != 0) || (v2)) {
            java.util.concurrent.locks.ReentrantLock v3_2 = oc.e.j;
            v3_2.lock();
            try {
                if (this.e != 0) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                } else {
                    this.e = 1;
                    ea.c.s(this, v0_0, v2);
                    v3_2.unlock();
                    return;
                }
            } catch (String v0_2) {
                v3_2.unlock();
                throw v0_2;
            }
        } else {
            return;
        }
    }

    public final boolean i()
    {
        java.util.concurrent.locks.ReentrantLock v0 = oc.e.j;
        v0.lock();
        try {
            cc.z v1_1 = this.e;
            int v2 = 0;
            this.e = 0;
        } catch (cc.z v1_2) {
            v0.unlock();
            throw v1_2;
        }
        if (v1_1 != 1) {
            if (v1_1 == 2) {
                v2 = 1;
            }
            v0.unlock();
            return v2;
        } else {
            oc.e.h.n(this);
            v0.unlock();
            return 0;
        }
    }

    public void j()
    {
        return;
    }
}
