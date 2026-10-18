// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow.internal;
public final class c implements jb.c {
    public final synthetic kotlin.jvm.internal.Ref$ObjectRef g;
    public final synthetic gb.v h;
    public final synthetic kotlinx.coroutines.flow.internal.d i;
    public final synthetic jb.c j;

    public c(kotlin.jvm.internal.Ref$ObjectRef p1, gb.v p2, kotlinx.coroutines.flow.internal.d p3, jb.c p4)
    {
        this.g = p1;
        this.h = p2;
        this.i = p3;
        this.j = p4;
        return;
    }

    public final Object emit(Object p7, ka.c p8)
    {
        jb.c v0_2;
        if (!(p8 instanceof kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1)) {
            v0_2 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1(this, p8);
        } else {
            v0_2 = ((kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1) p8);
            gb.v v1_2 = ((kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1) p8).k;
            if ((v1_2 & -2147483648) == 0) {
            } else {
                ((kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1) p8).k = (v1_2 - -2147483648);
            }
        }
        jb.c v0_3;
        kotlin.jvm.internal.Ref$ObjectRef v8_1 = v0_2.i;
        gb.v v1_1 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2 v2_0 = v0_2.k;
        if (v2_0 == null) {
            kotlin.b.b(v8_1);
            kotlin.jvm.internal.Ref$ObjectRef v8_4 = ((gb.u0) this.g.g);
            if (v8_4 != null) {
                v8_4.h(new kotlinx.coroutines.flow.internal.ChildCancelledException("Child of the scoped flow was cancelled"));
                v0_2.g = this;
                v0_2.h = p7;
                v0_2.k = 1;
                if (((gb.a1) v8_4).H(v0_2) == v1_1) {
                    return v1_1;
                }
            }
            v0_3 = this;
        } else {
            if (v2_0 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                return 0;
            } else {
                p7 = v0_2.h;
                v0_3 = v0_2.g;
                kotlin.b.b(v8_1);
            }
        }
        v0_3.g.g = gb.w.p(v0_3.h, 0, new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2(v0_3.i, v0_3.j, p7, 0), 1);
        return ga.p.a;
    }
}
