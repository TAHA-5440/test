// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow.internal;
final class ChannelFlowOperator$collectWithContextUndispatched$2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements ua.p {
    public int g;
    public synthetic Object h;
    public final synthetic kotlinx.coroutines.flow.internal.b i;

    public ChannelFlowOperator$collectWithContextUndispatched$2(kotlinx.coroutines.flow.internal.b p1, ka.c p2)
    {
        this.i = p1;
        super(2, p2);
        return;
    }

    public final ka.c create(Object p3, ka.c p4)
    {
        kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2 v0_1 = new kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2(this.i, p4);
        v0_1.h = p3;
        return v0_1;
    }

    public final Object invoke(Object p1, Object p2)
    {
        return ((kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2) this.create(((jb.c) p1), ((ka.c) p2))).invokeSuspend(ga.p.a);
    }

    public final Object invokeSuspend(Object p4)
    {
        kotlin.coroutines.intrinsics.CoroutineSingletons v0 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        kotlinx.coroutines.flow.internal.b v1_0 = this.g;
        if (v1_0 == null) {
            kotlin.b.b(p4);
            ga.p v4_6 = ((jb.c) this.h);
            this.g = 1;
            if (this.i.c(v4_6, this) == v0) {
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
