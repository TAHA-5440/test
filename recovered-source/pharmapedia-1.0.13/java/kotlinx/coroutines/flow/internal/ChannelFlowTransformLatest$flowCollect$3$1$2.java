// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow.internal;
final class ChannelFlowTransformLatest$flowCollect$3$1$2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements ua.p {
    public int g;
    public final synthetic kotlinx.coroutines.flow.internal.d h;
    public final synthetic jb.c i;
    public final synthetic Object j;

    public ChannelFlowTransformLatest$flowCollect$3$1$2(kotlinx.coroutines.flow.internal.d p1, jb.c p2, Object p3, ka.c p4)
    {
        this.h = p1;
        this.i = p2;
        this.j = p3;
        super(2, p4);
        return;
    }

    public final ka.c create(Object p4, ka.c p5)
    {
        return new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2(this.h, this.i, this.j, p5);
    }

    public final Object invoke(Object p1, Object p2)
    {
        return ((kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2) this.create(((gb.v) p1), ((ka.c) p2))).invokeSuspend(ga.p.a);
    }

    public final Object invokeSuspend(Object p4)
    {
        kotlin.coroutines.intrinsics.CoroutineSingletons v0 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        jb.c v1_0 = this.g;
        if (v1_0 == null) {
            kotlin.b.b(p4);
            ga.p v4_6 = this.h.k;
            this.g = 1;
            if (v4_6.invoke(this.i, this.j, this) == v0) {
                return v0;
            }
        } else {
            if (v1_0 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                return 0;
            } else {
                kotlin.b.b(p4);
            }
        }
        return ga.p.a;
    }
}
