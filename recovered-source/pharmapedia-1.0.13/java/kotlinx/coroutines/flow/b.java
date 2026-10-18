// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow;
public final class b extends jb.a {
    public final kotlin.coroutines.jvm.internal.SuspendLambda k;

    public b(ua.p p1, ka.g p2, int p3, kotlinx.coroutines.channels.BufferOverflow p4)
    {
        super(p1, p2, p3, p4);
        super.k = ((kotlin.coroutines.jvm.internal.SuspendLambda) p1);
        return;
    }

    public final Object a(ib.l p5, ka.c p6)
    {
        kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1 v0_1;
        if (!(p6 instanceof kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1)) {
            v0_1 = new kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1(this, ((kotlin.coroutines.jvm.internal.ContinuationImpl) p6));
        } else {
            v0_1 = ((kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1) p6);
            kotlin.coroutines.intrinsics.CoroutineSingletons v1_2 = ((kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1) p6).j;
            if ((v1_2 & -2147483648) == 0) {
            } else {
                ((kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1) p6).j = (v1_2 - -2147483648);
            }
        }
        Object v6_1 = v0_1.h;
        kotlin.coroutines.intrinsics.CoroutineSingletons v1_1 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        int v2_0 = v0_1.j;
        if (v2_0 == 0) {
            kotlin.b.b(v6_1);
            v0_1.g = p5;
            v0_1.j = 1;
            if (super.a(p5, v0_1) != v1_1) {
                if (!((ib.k) p5).j.t()) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("\'awaitClose { yourCallbackOrListener.cancel() }\' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
                } else {
                    return ga.p.a;
                }
            } else {
                return v1_1;
            }
        } else {
            if (v2_0 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
            } else {
                p5 = v0_1.g;
                kotlin.b.b(v6_1);
            }
        }
        return 0;
    }

    public final kotlinx.coroutines.flow.internal.a b(ka.g p3, int p4, kotlinx.coroutines.channels.BufferOverflow p5)
    {
        return new kotlinx.coroutines.flow.b(this.k, p3, p4, p5);
    }
}
