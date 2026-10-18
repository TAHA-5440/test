// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.serialization.json.internal;
final class JsonTreeReader$readDeepRecursive$1 extends kotlin.coroutines.jvm.internal.RestrictedSuspendLambda implements ua.q {
    public int h;
    public synthetic ga.b i;
    public final synthetic kotlinx.serialization.json.internal.b j;

    public JsonTreeReader$readDeepRecursive$1(kotlinx.serialization.json.internal.b p1, ka.c p2)
    {
        this.j = p1;
        super(p2);
        return;
    }

    public final Object invoke(Object p2, Object p3, Object p4)
    {
        kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1 v3_2 = new kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1(this.j, ((ka.c) p4));
        v3_2.i = ((ga.b) p2);
        return v3_2.invokeSuspend(ga.p.a);
    }

    public final Object invokeSuspend(Object p8)
    {
        kotlinx.serialization.json.internal.b v0 = this.j;
        e0.x v1 = v0.a;
        kotlin.coroutines.intrinsics.CoroutineSingletons v2 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        byte v3_0 = this.h;
        if (v3_0 == 0) {
            kotlin.b.b(p8);
            int v8_10 = this.i;
            byte v3_1 = v1.o();
            if (v3_1 != 1) {
                if (v3_1 != 0) {
                    if (v3_1 != 6) {
                        if (v3_1 != 8) {
                            e0.x.l(v1, "Can\'t begin reading element, unexpected token", 0, 6);
                            throw 0;
                        } else {
                            return v0.c();
                        }
                    } else {
                        this.h = 1;
                        p8 = kotlinx.serialization.json.internal.b.a(v0, v8_10, this);
                        if (p8 == v2) {
                            return v2;
                        }
                    }
                } else {
                    return v0.d(0);
                }
            } else {
                return v0.d(1);
            }
        } else {
            if (v3_0 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                return 0;
            } else {
                kotlin.b.b(p8);
            }
        }
        return ((vb.j) p8);
    }
}
