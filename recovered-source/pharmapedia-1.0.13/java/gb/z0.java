// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class z0 implements gb.s0 {
    public static final synthetic java.util.concurrent.atomic.AtomicIntegerFieldUpdater h;
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater i;
    public static final synthetic java.util.concurrent.atomic.AtomicReferenceFieldUpdater j;
    private volatile synthetic Object _exceptionsHolder$volatile;
    private volatile synthetic int _isCompleting$volatile;
    private volatile synthetic Object _rootCause$volatile;
    public final gb.c1 g;

    static z0()
    {
        gb.z0.h = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(gb.z0, "_isCompleting$volatile");
        gb.z0.i = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(gb.z0, Object, "_rootCause$volatile");
        gb.z0.j = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(gb.z0, Object, "_exceptionsHolder$volatile");
        return;
    }

    public z0(gb.c1 p1, Throwable p2)
    {
        this.g = p1;
        this._isCompleting$volatile = 0;
        this._rootCause$volatile = p2;
        return;
    }

    public final void a(Throwable p5)
    {
        boolean v0_0 = this.b();
        if (v0_0) {
            if (p5 != v0_0) {
                boolean v0_3 = gb.z0.j;
                java.util.ArrayList v1_1 = v0_3.get(this);
                if (v1_1 != null) {
                    if (!(v1_1 instanceof Throwable)) {
                        if (!(v1_1 instanceof java.util.ArrayList)) {
                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(v1_1, "State is ");
                            return;
                        } else {
                            ((java.util.ArrayList) v1_1).add(p5);
                            return;
                        }
                    } else {
                        if (p5 != v1_1) {
                            java.util.ArrayList v2_1 = new java.util.ArrayList(4);
                            v2_1.add(v1_1);
                            v2_1.add(p5);
                            v0_3.set(this, v2_1);
                            return;
                        }
                    }
                } else {
                    v0_3.set(this, p5);
                    return;
                }
            }
            return;
        } else {
            gb.z0.i.set(this, p5);
            return;
        }
    }

    public final Throwable b()
    {
        return ((Throwable) gb.z0.i.get(this));
    }

    public final boolean c()
    {
        if (this.b() == null) {
            return 0;
        } else {
            return 1;
        }
    }

    public final boolean d()
    {
        if (this.b() != null) {
            return 0;
        } else {
            return 1;
        }
    }

    public final gb.c1 e()
    {
        return this.g;
    }

    public final java.util.ArrayList f(Throwable p5)
    {
        java.util.ArrayList v1_0;
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater v0 = gb.z0.j;
        java.util.ArrayList v1_2 = v0.get(this);
        if (v1_2 != null) {
            if (!(v1_2 instanceof Throwable)) {
                if (!(v1_2 instanceof java.util.ArrayList)) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.q(v1_2, "State is ");
                    return 0;
                } else {
                    v1_0 = ((java.util.ArrayList) v1_2);
                }
            } else {
                int v3_1 = new java.util.ArrayList(4);
                v3_1.add(v1_2);
                v1_0 = v3_1;
            }
        } else {
            v1_0 = new java.util.ArrayList(4);
        }
        boolean v2_0 = this.b();
        if (v2_0) {
            v1_0.add(0, v2_0);
        }
        if ((p5 != null) && (!p5.equals(v2_0))) {
            v1_0.add(p5);
        }
        v0.set(this, gb.w.h);
        return v1_0;
    }

    public final String toString()
    {
        int v1_2;
        String v0_1 = new StringBuilder("Finishing[cancelling=");
        v0_1.append(this.c());
        v0_1.append(", completing=");
        if (gb.z0.h.get(this) == 0) {
            v1_2 = 0;
        } else {
            v1_2 = 1;
        }
        v0_1.append(v1_2);
        v0_1.append(", rootCause=");
        v0_1.append(this.b());
        v0_1.append(", exceptions=");
        v0_1.append(gb.z0.j.get(this));
        v0_1.append(", list=");
        v0_1.append(this.g);
        v0_1.append(93);
        return v0_1.toString();
    }
}
