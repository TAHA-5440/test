// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kb;
public final class d extends kotlinx.coroutines.flow.internal.b {

    public final kotlinx.coroutines.flow.internal.a b(ka.g p3, int p4, kotlinx.coroutines.channels.BufferOverflow p5)
    {
        return new kb.d(this.j, p3, p4, p5);
    }

    public final Object c(jb.c p2, ka.c p3)
    {
        ga.p v2_1 = this.j.collect(p2, p3);
        if (v2_1 != kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
            return ga.p.a;
        } else {
            return v2_1;
        }
    }
}
