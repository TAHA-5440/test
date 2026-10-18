// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public abstract class a0 {
    public static final oc.z a;
    public static final int b;
    public static final java.util.concurrent.atomic.AtomicReference[] c;

    static a0()
    {
        int v1 = 0;
        java.util.concurrent.atomic.AtomicReference[] v2_1 = new byte[0];
        oc.a0.a = new oc.z(v2_1, 0, 0, 0);
        int v0_2 = Integer.highestOneBit(((Runtime.getRuntime().availableProcessors() * 2) - 1));
        oc.a0.b = v0_2;
        java.util.concurrent.atomic.AtomicReference[] v2_0 = new java.util.concurrent.atomic.AtomicReference[v0_2];
        while (v1 < v0_2) {
            v2_0[v1] = new java.util.concurrent.atomic.AtomicReference();
            v1++;
        }
        oc.a0.c = v2_0;
        return;
    }

    public static final void a(oc.z p6)
    {
        p6.getClass();
        if ((p6.f != null) || (p6.g != null)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Failed requirement.");
            return;
        } else {
            if (!p6.d) {
                java.util.concurrent.atomic.AtomicReference v0_5 = oc.a0.c[((int) (Thread.currentThread().getId() & (((long) oc.a0.b) - 1)))];
                int v1_1 = oc.a0.a;
                oc.z v2_4 = ((oc.z) v0_5.getAndSet(v1_1));
                if (v2_4 != v1_1) {
                    int v3_0;
                    if (v2_4 == null) {
                        v3_0 = 0;
                    } else {
                        v3_0 = v2_4.c;
                    }
                    if (v3_0 < 65536) {
                        p6.f = v2_4;
                        p6.b = 0;
                        p6.c = (v3_0 + 8192);
                        v0_5.set(p6);
                        return;
                    } else {
                        v0_5.set(v2_4);
                        return;
                    }
                }
            }
            return;
        }
    }

    public static final oc.z b()
    {
        int v0_1 = oc.a0.c[((int) (Thread.currentThread().getId() & (((long) oc.a0.b) - 1)))];
        int v1_1 = oc.a0.a;
        oc.z v2_1 = ((oc.z) v0_1.getAndSet(v1_1));
        if (v2_1 != v1_1) {
            if (v2_1 != null) {
                v0_1.set(v2_1.f);
                v2_1.f = 0;
                v2_1.c = 0;
                return v2_1;
            } else {
                v0_1.set(0);
                return new oc.z();
            }
        } else {
            return new oc.z();
        }
    }
}
