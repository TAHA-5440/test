// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow;
public final class c implements jb.c {
    public final synthetic jb.c g;
    public final synthetic kotlin.jvm.internal.Ref$ObjectRef h;

    public c(jb.c p1, kotlin.jvm.internal.Ref$ObjectRef p2)
    {
        this.g = p1;
        this.h = p2;
        return;
    }

    public final Object emit(Object p5, ka.c p6)
    {
        kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1 v0_2;
        if (!(p6 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1)) {
            v0_2 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1(this, p6);
        } else {
            v0_2 = ((kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1) p6);
            kotlin.coroutines.intrinsics.CoroutineSingletons v1_2 = ((kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1) p6).j;
            if ((v1_2 & -2147483648) == 0) {
            } else {
                ((kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1) p6).j = (v1_2 - -2147483648);
            }
        }
        Throwable v6_1 = v0_2.h;
        kotlin.coroutines.intrinsics.CoroutineSingletons v1_1 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        int v2_0 = v0_2.j;
        if (v2_0 == 0) {
            kotlin.b.b(v6_1);
            try {
                Throwable v6_2 = this.g;
                v0_2.g = this;
                v0_2.j = 1;
            } catch (Throwable v6_3) {
                kotlin.jvm.internal.Ref$ObjectRef v5_2 = this;
                v5_2.h.g = v6_3;
                throw v6_3;
            }
            if (v6_2.emit(p5, v0_2) == v1_1) {
                return v1_1;
            }
        } else {
            if (v2_0 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                return 0;
            } else {
                v5_2 = v0_2.g;
                try {
                    kotlin.b.b(v6_1);
                } catch (Throwable v6_3) {
                }
            }
        }
        return ga.p.a;
    }
}
