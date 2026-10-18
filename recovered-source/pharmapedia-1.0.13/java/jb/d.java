// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jb;
public final class d implements jb.b {
    public final synthetic l.o g;
    public final synthetic ua.q h;

    public d(l.o p1, ua.q p2)
    {
        this.g = p1;
        this.h = p2;
        return;
    }

    public final Object collect(jb.c p9, ka.c p10)
    {
        kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 v0_2;
        if (!(p10 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1)) {
            v0_2 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1(this, p10);
        } else {
            v0_2 = ((kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1) p10);
            kotlin.coroutines.intrinsics.CoroutineSingletons v1_2 = ((kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1) p10).h;
            if ((v1_2 & -2147483648) == 0) {
            } else {
                ((kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1) p10).h = (v1_2 - -2147483648);
            }
        }
        Throwable v9_5;
        ua.q v2_1;
        Throwable v10_1 = v0_2.g;
        kotlin.coroutines.intrinsics.CoroutineSingletons v1_1 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        ua.q v2_0 = v0_2.h;
        if (v2_0 == null) {
            kotlin.b.b(v10_1);
            try {
                Throwable v10_2 = this.g;
                v0_2.j = this;
                v0_2.k = p9;
                v0_2.h = 1;
            } catch (Throwable v9_1) {
                v2_1 = this;
                Throwable v10_5 = new jb.q(v9_1);
                ua.q v2_3 = v2_1.h;
                v0_2.j = v9_1;
                v0_2.k = 0;
                v0_2.h = 2;
                if (kotlinx.coroutines.flow.a.a(v10_5, v2_3, v9_1, v0_2) != v1_1) {
                    throw v9_1;
                } else {
                    return v1_1;
                }
            }
            if (v10_2.collect(p9, v0_2) != v1_1) {
                v2_1 = this;
                Throwable v10_8 = new kotlinx.coroutines.flow.internal.SafeCollector(p9, v0_2.getContext());
                try {
                    Throwable v9_2 = v2_1.h;
                    v0_2.j = v10_8;
                    v0_2.k = 0;
                    v0_2.h = 3;
                } catch (Throwable v9_4) {
                    Throwable v10_9 = v9_4;
                    v9_5 = v10_8;
                    v9_5.releaseIntercepted();
                    throw v10_9;
                }
                if (v9_2.invoke(v10_8, 0, v0_2) != v1_1) {
                    v9_5 = v10_8;
                }
            }
        } else {
            if (v2_0 == 1) {
                p9 = v0_2.k;
                v2_1 = ((jb.d) v0_2.j);
                try {
                    kotlin.b.b(v10_1);
                } catch (Throwable v9_1) {
                }
            } else {
                if (v2_0 == 2) {
                    v9_1 = ((Throwable) v0_2.j);
                    kotlin.b.b(v10_1);
                } else {
                    if (v2_0 != 3) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                        return 0;
                    } else {
                        v9_5 = ((kotlinx.coroutines.flow.internal.SafeCollector) v0_2.j);
                        try {
                            kotlin.b.b(v10_1);
                        } catch (Throwable v10_9) {
                        }
                    }
                }
            }
        }
        v9_5.releaseIntercepted();
        return ga.p.a;
    }
}
