// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public abstract class a extends gb.a1 implements ka.c, gb.v {
    public final ka.g i;

    public a(ka.g p1, boolean p2)
    {
        super(p2);
        super.D(((gb.u0) p1.Z(gb.t.h)));
        super.i = p1.L(super);
        return;
    }

    public final void C(kotlinx.coroutines.CompletionHandlerException p2)
    {
        gb.w.n(p2, this.i);
        return;
    }

    public final ka.g M()
    {
        return this.i;
    }

    public final void P(Object p3)
    {
        if (!(p3 instanceof gb.q)) {
            this.Y(p3);
            return;
        } else {
            int v3_1;
            if (gb.q.b.get(((gb.q) p3)) == 0) {
                v3_1 = 0;
            } else {
                v3_1 = 1;
            }
            this.X(v3_1, ((gb.q) p3).a);
            return;
        }
    }

    public void X(boolean p1, Throwable p2)
    {
        return;
    }

    public void Y(Object p1)
    {
        return;
    }

    public final void a0(kotlinx.coroutines.CoroutineStart p3, gb.a p4, ua.p p5)
    {
        kotlin.coroutines.intrinsics.CoroutineSingletons v3_1 = p3.ordinal();
        Object v0_0 = ga.p.a;
        if (v3_1 == null) {
            try {
                lb.a.h(v0_0, a.a.n(((kotlin.coroutines.jvm.internal.BaseContinuationImpl) p5).create(p4, this)));
                return;
            } catch (kotlin.coroutines.intrinsics.CoroutineSingletons v3_2) {
                this.resumeWith(new kotlin.Result$Failure(v3_2));
                throw v3_2;
            }
        } else {
            if (v3_1 != 1) {
                if (v3_1 == 2) {
                    a.a.n(((kotlin.coroutines.jvm.internal.BaseContinuationImpl) p5).create(p4, this)).resumeWith(v0_0);
                } else {
                    if (v3_1 != 3) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.s();
                        return;
                    } else {
                        try {
                            kotlin.coroutines.intrinsics.CoroutineSingletons v3_5 = this.i;
                            Object v0_3 = lb.a.l(v3_5, 0);
                            try {
                                kotlin.jvm.internal.j.c(2, p5);
                                Throwable v4_3 = p5.invoke(p4, this);
                            } catch (Throwable v4_4) {
                                lb.a.g(v3_5, v0_3);
                                throw v4_4;
                            }
                            lb.a.g(v3_5, v0_3);
                            if (v4_3 != kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
                                this.resumeWith(v4_3);
                                return;
                            }
                        } catch (kotlin.coroutines.intrinsics.CoroutineSingletons v3_7) {
                            this.resumeWith(new kotlin.Result$Failure(v3_7));
                            return;
                        }
                    }
                }
            }
            return;
        }
    }

    public final ka.g getContext()
    {
        return this.i;
    }

    public final String p()
    {
        return this.getClass().getSimpleName().concat(" was cancelled");
    }

    public final void resumeWith(Object p3)
    {
        com.google.gson.internal.b v0_0 = kotlin.Result.a(p3);
        if (v0_0 != null) {
            p3 = new gb.q(0, v0_0);
        }
        Object v3_2 = this.J(p3);
        if (v3_2 != gb.w.e) {
            this.l(v3_2);
            return;
        } else {
            return;
        }
    }
}
