// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.channels;
final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements ua.p {
    public int g;
    public synthetic Object h;
    public final synthetic ib.m i;
    public final synthetic Object j;

    public ChannelsKt__ChannelsKt$trySendBlocking$2(ib.m p1, Object p2, ka.c p3)
    {
        this.i = p1;
        this.j = p2;
        super(2, p3);
        return;
    }

    public final ka.c create(Object p4, ka.c p5)
    {
        kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2 v0_1 = new kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2(this.i, this.j, p5);
        v0_1.h = p4;
        return v0_1;
    }

    public final Object invoke(Object p1, Object p2)
    {
        return ((kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2) this.create(((gb.v) p1), ((ka.c) p2))).invokeSuspend(ga.p.a);
    }

    public final Object invokeSuspend(Object p5)
    {
        kotlin.Result$Failure v0_0 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        Object v1_0 = this.g;
        ib.e v2_0 = ga.p.a;
        try {
            if (v1_0 == null) {
                kotlin.b.b(p5);
                ib.g v5_10 = this.i;
                Object v1_1 = this.j;
                this.g = 1;
                if (v5_10.b(v1_1, this) != v0_0) {
                    kotlin.Result$Failure v0_2 = v2_0;
                } else {
                    return v0_0;
                }
            } else {
                if (v1_0 != 1) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                    return 0;
                } else {
                    kotlin.b.b(p5);
                }
            }
        } catch (ib.g v5_4) {
            v0_2 = new kotlin.Result$Failure(v5_4);
        }
        if ((v0_2 instanceof kotlin.Result$Failure)) {
            v2_0 = new ib.e(kotlin.Result.a(v0_2));
        }
        return new ib.g(v2_0);
    }
}
