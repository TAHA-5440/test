// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines;
final class InterruptibleKt$runInterruptible$2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements ua.p {
    public synthetic Object g;
    public final synthetic com.google.firebase.sessions.api.a h;

    public InterruptibleKt$runInterruptible$2(com.google.firebase.sessions.api.a p1, ka.c p2)
    {
        this.h = p1;
        super(2, p2);
        return;
    }

    public final ka.c create(Object p3, ka.c p4)
    {
        kotlinx.coroutines.InterruptibleKt$runInterruptible$2 v0_1 = new kotlinx.coroutines.InterruptibleKt$runInterruptible$2(this.h, p4);
        v0_1.g = p3;
        return v0_1;
    }

    public final Object invoke(Object p1, Object p2)
    {
        return ((kotlinx.coroutines.InterruptibleKt$runInterruptible$2) this.create(((gb.v) p1), ((ka.c) p2))).invokeSuspend(ga.p.a);
    }

    public final Object invokeSuspend(Object p5)
    {
        kotlin.b.b(p5);
        Throwable v5_14 = ((gb.v) this.g).M();
        java.util.concurrent.CancellationException v0_4 = this.h;
        String v1_4 = new gb.i1();
        boolean v2_1 = ((gb.u0) v5_14.Z(gb.t.h));
        if (!v2_1) {
            String v1_1 = new StringBuilder("Current context doesn\'t contain Job in it: ");
            v1_1.append(v5_14);
            throw new IllegalStateException(v1_1.toString().toString());
        } else {
            v1_4.l = kotlinx.coroutines.a.b(v2_1, 1, v1_4);
            Throwable v5_6 = gb.i1.m;
            do {
                boolean v2_3 = v5_6.get(v1_4);
                if (!v2_3) {
                } else {
                    if (v2_3 == 2) {
                        break;
                    }
                    if (v2_3 != 3) {
                        gb.i1.n(v2_3);
                        throw 0;
                    } else {
                        break;
                    }
                }
            } while(!v5_6.compareAndSet(v1_4, v2_3, 0));
            Throwable v5_12 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.a(v0_4.g);
            v1_4.m();
            return v5_12;
        }
    }
}
