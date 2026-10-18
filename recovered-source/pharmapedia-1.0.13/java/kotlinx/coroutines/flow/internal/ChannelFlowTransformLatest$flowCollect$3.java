// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow.internal;
final class ChannelFlowTransformLatest$flowCollect$3 extends kotlin.coroutines.jvm.internal.SuspendLambda implements ua.p {
    public int g;
    public synthetic Object h;
    public final synthetic kotlinx.coroutines.flow.internal.d i;
    public final synthetic jb.c j;

    public ChannelFlowTransformLatest$flowCollect$3(kotlinx.coroutines.flow.internal.d p1, jb.c p2, ka.c p3)
    {
        this.i = p1;
        this.j = p2;
        super(2, p3);
        return;
    }

    public final ka.c create(Object p4, ka.c p5)
    {
        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3 v0_1 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3(this.i, this.j, p5);
        v0_1.h = p4;
        return v0_1;
    }

    public final Object invoke(Object p1, Object p2)
    {
        return ((kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3) this.create(((gb.v) p1), ((ka.c) p2))).invokeSuspend(ga.p.a);
    }

    public final Object invokeSuspend(Object p8)
    {
        kotlin.coroutines.intrinsics.CoroutineSingletons v0 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        kotlin.jvm.internal.Ref$ObjectRef v1_0 = this.g;
        if (v1_0 == null) {
            kotlin.b.b(p8);
            kotlinx.coroutines.flow.internal.d v3 = this.i;
            jb.b v4 = v3.j;
            kotlinx.coroutines.flow.internal.c v5_1 = new kotlinx.coroutines.flow.internal.c(new kotlin.jvm.internal.Ref$ObjectRef(), ((gb.v) this.h), v3, this.j);
            this.g = 1;
            if (v4.collect(v5_1, this) == v0) {
                return v0;
            }
        } else {
            if (v1_0 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                return 0;
            } else {
                kotlin.b.b(p8);
            }
        }
        return ga.p.a;
    }
}
