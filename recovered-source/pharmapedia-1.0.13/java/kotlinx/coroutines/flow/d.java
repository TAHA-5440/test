// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow;
public final class d implements jb.c {
    public final synthetic kotlin.jvm.internal.Ref$BooleanRef g;
    public final synthetic jb.c h;
    public final synthetic ua.p i;

    public d(kotlin.jvm.internal.Ref$BooleanRef p1, jb.c p2, ua.p p3)
    {
        this.g = p1;
        this.h = p2;
        this.i = p3;
        return;
    }

    public final Object emit(Object p8, ka.c p9)
    {
        kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 v0_2;
        if (!(p9 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1)) {
            v0_2 = new kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1(this, p9);
        } else {
            v0_2 = ((kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1) p9);
            kotlin.coroutines.intrinsics.CoroutineSingletons v1_2 = ((kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1) p9).k;
            if ((v1_2 & -2147483648) == 0) {
            } else {
                ((kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1) p9).k = (v1_2 - -2147483648);
            }
        }
        int v2_1;
        jb.c v9_1 = v0_2.i;
        kotlin.coroutines.intrinsics.CoroutineSingletons v1_1 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        int v2_0 = v0_2.k;
        ga.p v5 = ga.p.a;
        if (v2_0 == 0) {
            kotlin.b.b(v9_1);
            if (!this.g.g) {
                v0_2.g = this;
                v0_2.h = p8;
                v0_2.k = 2;
                v9_1 = this.i.invoke(p8, v0_2);
                if (v9_1 != v1_1) {
                    v2_1 = this;
                    if (!((Boolean) v9_1).booleanValue()) {
                        v2_1.g.g = 1;
                        jb.c v9_9 = v2_1.h;
                        v0_2.g = 0;
                        v0_2.h = 0;
                        v0_2.k = 3;
                        if (v9_9.emit(p8, v0_2) == v1_1) {
                            return v1_1;
                        }
                    }
                }
            } else {
                v0_2.k = 1;
                if (this.h.emit(p8, v0_2) == v1_1) {
                    return v1_1;
                }
            }
        } else {
            if (v2_0 == 1) {
                kotlin.b.b(v9_1);
                return v5;
            } else {
                if (v2_0 == 2) {
                    p8 = v0_2.h;
                    v2_1 = v0_2.g;
                    kotlin.b.b(v9_1);
                } else {
                    if (v2_0 != 3) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                        return 0;
                    } else {
                        kotlin.b.b(v9_1);
                        return v5;
                    }
                }
            }
        }
        return v5;
    }
}
