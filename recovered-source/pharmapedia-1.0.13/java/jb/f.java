// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jb;
public final class f implements jb.c {
    public final synthetic ua.p g;
    public final synthetic jb.c h;

    public f(ua.p p1, jb.c p2)
    {
        this.g = p1;
        this.h = p2;
        return;
    }

    public final Object emit(Object p8, ka.c p9)
    {
        kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1 v0_2;
        if (!(p9 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1)) {
            v0_2 = new kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1(this, p9);
        } else {
            v0_2 = ((kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1) p9);
            kotlin.coroutines.intrinsics.CoroutineSingletons v1_2 = ((kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1) p9).i;
            if ((v1_2 & -2147483648) == 0) {
            } else {
                ((kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1) p9).i = (v1_2 - -2147483648);
            }
        }
        jb.c v2_1;
        ga.p v8_1;
        kotlinx.coroutines.flow.internal.AbortFlowException v9_4;
        kotlinx.coroutines.flow.internal.AbortFlowException v9_1 = v0_2.h;
        kotlin.coroutines.intrinsics.CoroutineSingletons v1_1 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        jb.c v2_0 = v0_2.i;
        int v4 = 1;
        if (v2_0 == null) {
            kotlin.b.b(v9_1);
            v0_2.g = this;
            v0_2.k = p8;
            v0_2.i = 1;
            kotlinx.coroutines.flow.internal.AbortFlowException v9_3 = this.g.invoke(p8, v0_2);
            if (v9_3 != v1_1) {
                v2_1 = v9_3;
                v9_4 = p8;
                v8_1 = this;
                if (!((Boolean) v2_1).booleanValue()) {
                    v4 = 0;
                } else {
                    jb.c v2_5 = v8_1.h;
                    v0_2.g = v8_1;
                    v0_2.k = 0;
                    v0_2.i = 2;
                    if (v2_5.emit(v9_4, v0_2) == v1_1) {
                        return v1_1;
                    }
                }
            }
        } else {
            if (v2_0 == 1) {
                ga.p v8_2 = v0_2.k;
                jb.c v2_2 = v0_2.g;
                kotlin.b.b(v9_1);
                v9_4 = v8_2;
                v8_1 = v2_2;
                v2_1 = v9_1;
            } else {
                if (v2_0 != 2) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                    return 0;
                } else {
                    v8_1 = v0_2.g;
                    kotlin.b.b(v9_1);
                }
            }
        }
        if (v4 == 0) {
            throw new kotlinx.coroutines.flow.internal.AbortFlowException(v8_1);
        } else {
            return ga.p.a;
        }
    }
}
