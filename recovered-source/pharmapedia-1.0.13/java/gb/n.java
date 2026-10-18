// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class n extends gb.a1 implements gb.m {

    public final Object X(ka.c p4)
    {
        do {
            Object v4_5;
            kotlin.coroutines.intrinsics.CoroutineSingletons v0_2 = gb.a1.g.get(this);
            if ((v0_2 instanceof gb.s0)) {
            } else {
                if ((v0_2 instanceof gb.q)) {
                    throw ((gb.q) v0_2).a;
                } else {
                    v4_5 = gb.w.x(v0_2);
                }
            }
            return v4_5;
        } while(this.T(v0_2) < 0);
        kotlin.coroutines.intrinsics.CoroutineSingletons v0_1 = new gb.x0(this, a.a.n(p4));
        v0_1.s();
        v0_1.v(new gb.e(kotlinx.coroutines.a.b(this, 1, new gb.h0(v0_1, 2)), 2));
        v4_5 = v0_1.r();
        return v4_5;
    }
}
