// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines;
public abstract class a {

    public static final void a(ka.g p1)
    {
        java.util.concurrent.CancellationException v1_3 = ((gb.u0) p1.Z(gb.t.h));
        if ((v1_3 != null) && (!v1_3.d())) {
            throw ((gb.a1) v1_3).u();
        } else {
            return;
        }
    }

    public static final gb.g0 b(gb.u0 p8, boolean p9, gb.w0 p10)
    {
        if (!(p8 instanceof gb.a1)) {
            gb.h0 v10_2;
            int v0_2 = p10.k();
            kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1 v1_0 = new kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1(1, p10, gb.w0, "invoke", "invoke(Ljava/lang/Throwable;)V", 0);
            if (v0_2 == 0) {
                v10_2 = new gb.h0(v1_0, 1);
            } else {
                v10_2 = new kotlinx.coroutines.b(v1_0);
            }
            return ((gb.a1) p8).E(p9, v10_2);
        } else {
            return ((gb.a1) p8).E(p9, p10);
        }
    }

    public static Object c(com.google.firebase.sessions.api.a p2, ka.c p3)
    {
        return gb.w.z(kotlin.coroutines.EmptyCoroutineContext.g, new kotlinx.coroutines.InterruptibleKt$runInterruptible$2(p2, 0), p3);
    }

    public static final Object d(gb.j1 p4, ua.p p5)
    {
        kotlinx.coroutines.a.b(p4, 1, new gb.h0(gb.w.k(p4.j.getContext()).M(p4.k, p4, p4.i), 0));
        gb.q v5_1;
        if ((p5 instanceof kotlin.coroutines.jvm.internal.BaseContinuationImpl)) {
            kotlin.jvm.internal.j.c(2, p5);
            v5_1 = p5.invoke(p4, p4);
        } else {
            v5_1 = a.a.w(p5, p4, p4);
        }
        Object v0_7 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        if (v5_1 != v0_7) {
            gb.u0 v1_2 = p4.J(v5_1);
            if (v1_2 != gb.w.e) {
                if (!(v1_2 instanceof gb.q)) {
                    v5_1 = gb.w.x(v1_2);
                } else {
                    Object v0_9 = ((gb.q) v1_2).a;
                    if ((!(v0_9 instanceof kotlinx.coroutines.TimeoutCancellationException)) || (((kotlinx.coroutines.TimeoutCancellationException) v0_9).g != p4)) {
                        throw v0_9;
                    } else {
                        if ((v5_1 instanceof gb.q)) {
                            throw ((gb.q) v5_1).a;
                        }
                    }
                }
                v0_7 = v5_1;
            }
        }
        return v0_7;
    }

    public static final Object e(long p2, ua.p p4, kotlin.coroutines.jvm.internal.ContinuationImpl p5)
    {
        if (p2 <= 0) {
            throw new kotlinx.coroutines.TimeoutCancellationException("Timed out immediately", 0);
        } else {
            return kotlinx.coroutines.a.d(new gb.j1(p2, p5), p4);
        }
    }

    public static final Object f(long p6, ua.p p8, ka.c p9)
    {
        kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 v0_2;
        if (!(p9 instanceof kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1)) {
            v0_2 = new kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1(p9);
        } else {
            v0_2 = ((kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1) p9);
            kotlin.coroutines.intrinsics.CoroutineSingletons v1_2 = ((kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1) p9).i;
            if ((v1_2 & -2147483648) == 0) {
            } else {
                ((kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1) p9).i = (v1_2 - -2147483648);
            }
        }
        kotlin.jvm.internal.Ref$ObjectRef v9_1 = v0_2.h;
        kotlin.coroutines.intrinsics.CoroutineSingletons v1_1 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        gb.j1 v2_0 = v0_2.i;
        if (v2_0 == null) {
            kotlin.b.b(v9_1);
            if (p6 > 0) {
                kotlin.jvm.internal.Ref$ObjectRef v9_4 = new kotlin.jvm.internal.Ref$ObjectRef();
                try {
                    v0_2.g = v9_4;
                    v0_2.i = 1;
                    gb.j1 v2_2 = new gb.j1(p6, v0_2);
                    v9_4.g = v2_2;
                    Object v6_1 = kotlinx.coroutines.a.d(v2_2, p8);
                } catch (kotlinx.coroutines.TimeoutCancellationException v7) {
                    Object v6_2 = v9_4;
                    if (v7.g != v6_2.g) {
                        throw v7;
                    }
                }
                if (v6_1 != v1_1) {
                    return v6_1;
                } else {
                    return v1_1;
                }
            }
        } else {
            if (v2_0 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                return 0;
            } else {
                v6_2 = v0_2.g;
                try {
                    kotlin.b.b(v9_1);
                    return v9_1;
                } catch (kotlinx.coroutines.TimeoutCancellationException v7) {
                }
            }
        }
        return 0;
    }
}
