// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow.internal;
public abstract class b extends kotlinx.coroutines.flow.internal.a {
    public final jb.b j;

    public b(jb.b p1, ka.g p2, int p3, kotlinx.coroutines.channels.BufferOverflow p4)
    {
        super(p2, p3, p4);
        super.j = p1;
        return;
    }

    public final Object a(ib.l p2, ka.c p3)
    {
        ga.p v2_1 = this.c(new kb.i(p2), p3);
        if (v2_1 != kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
            return ga.p.a;
        } else {
            return v2_1;
        }
    }

    public abstract Object c(jb.c p0, ka.c p1);

    public final Object collect(jb.c p5, ka.c p6)
    {
        if (this.h != -3) {
            kotlinx.coroutines.flow.internal.f v5_1 = super.collect(p5, p6);
            if (v5_1 == kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
                return v5_1;
            }
        } else {
            ka.g v1_5;
            kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2 v0_4 = p6.getContext();
            ka.e v3_2 = this.g;
            if (((Boolean) v3_2.B(Boolean.FALSE, new com.google.firebase.firestore.pipeline.evaluation.b(2))).booleanValue()) {
                v1_5 = gb.w.i(v0_4, v3_2, 0);
            } else {
                v1_5 = v0_4.L(v3_2);
            }
            if (!kotlin.jvm.internal.f.a(v1_5, v0_4)) {
                kotlinx.coroutines.flow.internal.f v2_1 = ka.d.g;
                if (!kotlin.jvm.internal.f.a(v1_5.Z(v2_1), v0_4.Z(v2_1))) {
                } else {
                    kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2 v0_3 = p6.getContext();
                    if ((!(p5 instanceof kb.i)) && (!(p5 instanceof kb.h))) {
                        p5 = new kotlinx.coroutines.flow.internal.f(p5, v0_3);
                    }
                    kotlinx.coroutines.flow.internal.f v5_2 = kb.b.a(v1_5, p5, lb.a.k(v1_5), new kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2(this, 0), p6);
                    if (v5_2 == kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
                        return v5_2;
                    }
                }
            } else {
                kotlinx.coroutines.flow.internal.f v5_3 = this.c(p5, p6);
                if (v5_3 == kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
                    return v5_3;
                }
            }
        }
        return ga.p.a;
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder();
        v0_1.append(this.j);
        v0_1.append(" -> ");
        v0_1.append(super.toString());
        return v0_1.toString();
    }
}
