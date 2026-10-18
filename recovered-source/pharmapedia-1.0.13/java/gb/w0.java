// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public abstract class w0 extends kotlinx.coroutines.internal.a implements gb.g0, gb.s0 {
    public gb.a1 j;

    public final void b()
    {
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater v0_0 = this.j();
        do {
            kotlinx.coroutines.internal.a v1_1 = gb.a1.g;
            kotlinx.coroutines.internal.a v2_3 = v1_1.get(v0_0);
            if (!(v2_3 instanceof gb.w0)) {
                if ((!(v2_3 instanceof gb.s0)) || (((gb.s0) v2_3).e() == null)) {
                    return;
                }
                do {
                    java.util.concurrent.atomic.AtomicReferenceFieldUpdater v0_2 = kotlinx.coroutines.internal.a.g;
                    kotlinx.coroutines.internal.a v1_0 = v0_2.get(this);
                    if (!(v1_0 instanceof lb.m)) {
                        if (v1_0 != this) {
                            v1_0.getClass();
                            kotlinx.coroutines.internal.a v2_2 = ((kotlinx.coroutines.internal.a) v1_0);
                            Object v3_0 = kotlinx.coroutines.internal.a.i;
                            lb.m v4_1 = ((lb.m) v3_0.get(v2_2));
                            if (v4_1 == null) {
                                v4_1 = new lb.m(v2_2);
                                v3_0.set(v2_2, v4_1);
                            }
                            while (!v0_2.compareAndSet(this, v1_0, v4_1)) {
                            }
                            v2_2.f();
                            return;
                        } else {
                            return;
                        }
                    }
                } while(v0_2.get(this) == v1_0);
            } else {
                if (v2_3 != this) {
                    return;
                }
            }
            return;
        } while(!v1_1.compareAndSet(v0_0, v2_3, gb.w.j));
        if (v1_1.get(v0_0) != v2_3) {
        } else {
            while (!v1_1.compareAndSet(v0_0, v2_3, gb.w.j)) {
            }
        }
        return;
    }

    public final boolean d()
    {
        return 1;
    }

    public final gb.c1 e()
    {
        return 0;
    }

    public gb.u0 getParent()
    {
        return this.j();
    }

    public final gb.a1 j()
    {
        int v0_0 = this.j;
        if (v0_0 == 0) {
            kotlin.jvm.internal.f.i("job");
            throw 0;
        } else {
            return v0_0;
        }
    }

    public abstract boolean k();

    public abstract void l(Throwable p0);

    public final String toString()
    {
        String v0_1 = new StringBuilder();
        v0_1.append(this.getClass().getSimpleName());
        v0_1.append(64);
        v0_1.append(gb.w.l(this));
        v0_1.append("[job@");
        v0_1.append(gb.w.l(this.j()));
        v0_1.append(93);
        return v0_1.toString();
    }
}
