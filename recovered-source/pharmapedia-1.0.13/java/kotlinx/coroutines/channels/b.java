// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.channels;
public abstract class b {

    public static final Object a(ib.l p4, ua.a p5, kotlin.coroutines.jvm.internal.ContinuationImpl p6)
    {
        ib.j v0_2;
        if (!(p6 instanceof kotlinx.coroutines.channels.ProduceKt$awaitClose$1)) {
            v0_2 = new kotlinx.coroutines.channels.ProduceKt$awaitClose$1(p6);
        } else {
            v0_2 = ((kotlinx.coroutines.channels.ProduceKt$awaitClose$1) p6);
            kotlin.coroutines.intrinsics.CoroutineSingletons v1_2 = ((kotlinx.coroutines.channels.ProduceKt$awaitClose$1) p6).i;
            if ((v1_2 & -2147483648) == 0) {
            } else {
                ((kotlinx.coroutines.channels.ProduceKt$awaitClose$1) p6).i = (v1_2 - -2147483648);
            }
        }
        gb.h v6_1 = v0_2.h;
        kotlin.coroutines.intrinsics.CoroutineSingletons v1_1 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        gb.t v2_0 = v0_2.i;
        try {
            if (v2_0 == null) {
                kotlin.b.b(v6_1);
                if (v0_2.getContext().Z(gb.t.h) != p4) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("awaitClose() can only be invoked from the producer context");
                    return 0;
                } else {
                    v0_2.g = p5;
                    v0_2.i = 1;
                    gb.h v6_5 = new gb.h(1, a.a.n(v0_2));
                    v6_5.s();
                    ((ib.k) p4).b0(new ib.j(v6_5));
                    if (v6_5.r() == v1_1) {
                        return v1_1;
                    }
                }
            } else {
                if (v2_0 != 1) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                    return 0;
                } else {
                    p5 = v0_2.g;
                    kotlin.b.b(v6_1);
                }
            }
        } catch (ga.p v4_7) {
            p5.invoke();
            throw v4_7;
        }
        p5.invoke();
        return ga.p.a;
    }

    public static final void b(ib.m p2, Object p3)
    {
        if ((p2.g(p3) instanceof ib.f)) {
            gb.w.t(kotlin.coroutines.EmptyCoroutineContext.g, new kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2(p2, p3, 0));
            return;
        } else {
            return;
        }
    }
}
