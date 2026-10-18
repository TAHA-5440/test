// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow.internal;
public final class d extends kotlinx.coroutines.flow.internal.b {
    public final ua.q k;

    public d(ua.q p1, jb.b p2, ka.g p3, int p4, kotlinx.coroutines.channels.BufferOverflow p5)
    {
        super(p2, p3, p4, p5);
        super.k = p1;
        return;
    }

    public final kotlinx.coroutines.flow.internal.a b(ka.g p7, int p8, kotlinx.coroutines.channels.BufferOverflow p9)
    {
        return new kotlinx.coroutines.flow.internal.d(this.k, this.j, p7, p8, p9);
    }

    public final Object c(jb.c p3, ka.c p4)
    {
        ga.p v3_1 = gb.w.g(new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3(this, p3, 0), p4);
        if (v3_1 != kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
            return ga.p.a;
        } else {
            return v3_1;
        }
    }
}
