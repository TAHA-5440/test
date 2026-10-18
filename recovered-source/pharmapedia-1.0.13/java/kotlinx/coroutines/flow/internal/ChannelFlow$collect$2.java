// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow.internal;
final class ChannelFlow$collect$2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements ua.p {
    public int g;
    public synthetic Object h;
    public final synthetic jb.c i;
    public final synthetic kotlinx.coroutines.flow.internal.a j;

    public ChannelFlow$collect$2(jb.c p1, kotlinx.coroutines.flow.internal.a p2, ka.c p3)
    {
        this.i = p1;
        this.j = p2;
        super(2, p3);
        return;
    }

    public final ka.c create(Object p4, ka.c p5)
    {
        kotlinx.coroutines.flow.internal.ChannelFlow$collect$2 v0_1 = new kotlinx.coroutines.flow.internal.ChannelFlow$collect$2(this.i, this.j, p5);
        v0_1.h = p4;
        return v0_1;
    }

    public final Object invoke(Object p1, Object p2)
    {
        return ((kotlinx.coroutines.flow.internal.ChannelFlow$collect$2) this.create(((gb.v) p1), ((ka.c) p2))).invokeSuspend(ga.p.a);
    }

    public final Object invokeSuspend(Object p11)
    {
        kotlin.coroutines.intrinsics.CoroutineSingletons v0 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        kotlinx.coroutines.channels.a v1_0 = this.g;
        ga.p v2 = ga.p.a;
        if (v1_0 == null) {
            kotlin.b.b(p11);
            ga.p v11_7 = ((gb.v) this.h);
            kotlinx.coroutines.channels.a v1_3 = this.j;
            ib.k v4_2 = v1_3.g;
            int v5 = v1_3.h;
            if (v5 == -3) {
                v5 = -2;
            }
            kotlinx.coroutines.channels.BufferOverflow v6_1 = v1_3.i;
            kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1 v8_1 = new kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1(v1_3, 0);
            ib.k v4_1 = new ib.k(gb.w.q(v11_7, v4_2), jc.g.a(v5, v6_1, 4));
            v4_1.a0(kotlinx.coroutines.CoroutineStart.i, v4_1, v8_1);
            this.g = 1;
            ga.p v11_3 = kotlinx.coroutines.flow.a.f(this.i, v4_1, 1, this);
            if (v11_3 != v0) {
                v11_3 = v2;
            }
            if (v11_3 != v0) {
                return v2;
            } else {
                return v0;
            }
        } else {
            if (v1_0 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                return 0;
            } else {
                kotlin.b.b(p11);
                return v2;
            }
        }
    }
}
