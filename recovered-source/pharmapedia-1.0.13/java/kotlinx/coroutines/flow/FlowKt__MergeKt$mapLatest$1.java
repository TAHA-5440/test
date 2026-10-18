// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow;
final class FlowKt__MergeKt$mapLatest$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements ua.q {
    public int g;
    public synthetic jb.c h;
    public synthetic Object i;
    public final synthetic ua.p j;

    public FlowKt__MergeKt$mapLatest$1(ua.p p1, ka.c p2)
    {
        this.j = p1;
        super(3, p2);
        return;
    }

    public final Object invoke(Object p3, Object p4, Object p5)
    {
        kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1 v0_1 = new kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1(this.j, ((ka.c) p5));
        v0_1.h = ((jb.c) p3);
        v0_1.i = p4;
        return v0_1.invokeSuspend(ga.p.a);
    }

    public final Object invokeSuspend(Object p5)
    {
        jb.c v1_1;
        kotlin.coroutines.intrinsics.CoroutineSingletons v0 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        jb.c v1_0 = this.g;
        if (v1_0 == null) {
            kotlin.b.b(p5);
            v1_1 = this.h;
            ga.p v5_5 = this.i;
            this.h = v1_1;
            this.g = 1;
            p5 = this.j.invoke(v5_5, this);
            if (p5 != v0) {
                this.h = 0;
                this.g = 2;
                if (v1_1.emit(p5, this) == v0) {
                    return v0;
                }
            }
        } else {
            if (v1_0 == 1) {
                v1_1 = this.h;
                kotlin.b.b(p5);
            } else {
                if (v1_0 != 2) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                    return 0;
                } else {
                    kotlin.b.b(p5);
                }
            }
        }
        return ga.p.a;
    }
}
