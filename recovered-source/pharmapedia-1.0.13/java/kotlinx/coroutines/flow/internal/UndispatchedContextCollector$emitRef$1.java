// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow.internal;
final class UndispatchedContextCollector$emitRef$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements ua.p {
    public int g;
    public synthetic Object h;
    public final synthetic jb.c i;

    public UndispatchedContextCollector$emitRef$1(jb.c p1, ka.c p2)
    {
        this.i = p1;
        super(2, p2);
        return;
    }

    public final ka.c create(Object p3, ka.c p4)
    {
        kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1 v0_1 = new kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1(this.i, p4);
        v0_1.h = p3;
        return v0_1;
    }

    public final Object invoke(Object p1, Object p2)
    {
        return ((kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1) this.create(p1, ((ka.c) p2))).invokeSuspend(ga.p.a);
    }

    public final Object invokeSuspend(Object p4)
    {
        kotlin.coroutines.intrinsics.CoroutineSingletons v0 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        jb.c v1_0 = this.g;
        if (v1_0 == null) {
            kotlin.b.b(p4);
            ga.p v4_4 = this.h;
            this.g = 1;
            if (this.i.emit(v4_4, this) == v0) {
                return v0;
            }
        } else {
            if (v1_0 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                return 0;
            } else {
                kotlin.b.b(p4);
            }
        }
        return ga.p.a;
    }
}
