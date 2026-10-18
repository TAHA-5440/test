// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow.internal;
public final class SafeCollector extends kotlin.coroutines.jvm.internal.ContinuationImpl implements jb.c {
    public final jb.c g;
    public final ka.g h;
    public final int i;
    public ka.g j;
    public ka.c k;

    public SafeCollector(jb.c p3, ka.g p4)
    {
        super(kb.g.g, kotlin.coroutines.EmptyCoroutineContext.g);
        super.g = p3;
        super.h = p4;
        super.i = ((Number) p4.B(Integer.valueOf(0), new com.google.firebase.firestore.pipeline.evaluation.b(7))).intValue();
        return;
    }

    public final Object b(ka.c p5, Object p6)
    {
        String v0_0 = p5.getContext();
        kotlinx.coroutines.a.a(v0_0);
        String v1_4 = this.j;
        if (v1_4 != v0_0) {
            if ((v1_4 instanceof kb.e)) {
                String v1_11 = ((kb.e) v1_4);
                String v0_1 = new StringBuilder("\n            Flow exception transparency is violated:\n                Previous \'emit\' call has thrown exception ");
                v0_1.append(v1_11.h);
                v0_1.append(", but then emission attempt of value \'");
                v0_1.append(p6);
                v0_1.append("\' has been detected.\n                Emissions from \'catch\' blocks are prohibited in order to avoid unspecified behaviour, \'Flow.catch\' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
                throw new IllegalStateException(db.j.H(v0_1.toString()).toString());
            } else {
                if (((Number) v0_0.B(Integer.valueOf(0), new db.q(this, 2))).intValue() != this.i) {
                    String v6_6 = new StringBuilder("Flow invariant is violated:\n\t\tFlow was collected in ");
                    v6_6.append(this.h);
                    v6_6.append(",\n\t\tbut emission happened in ");
                    v6_6.append(v0_0);
                    v6_6.append(".\n\t\tPlease refer to \'flow\' documentation or use \'flowOn\' instead");
                    throw new IllegalStateException(v6_6.toString().toString());
                } else {
                    this.j = v0_0;
                }
            }
        }
        this.k = p5;
        String v0_3 = this.g;
        v0_3.getClass();
        IllegalStateException v5_5 = kotlinx.coroutines.flow.internal.e.a.invoke(v0_3, p6, this);
        if (!kotlin.jvm.internal.f.a(v5_5, kotlin.coroutines.intrinsics.CoroutineSingletons.g)) {
            this.k = 0;
        }
        return v5_5;
    }

    public final Object emit(Object p2, ka.c p3)
    {
        try {
            ga.p v2_1 = this.b(p3, p2);
            ka.g v3_1 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        } catch (ga.p v2_3) {
            this.j = new kb.e(v2_3, v3_1.getContext());
            throw v2_3;
        }
        if (v2_1 != v3_1) {
            return ga.p.a;
        } else {
            return v2_1;
        }
    }

    public final ma.b getCallerFrame()
    {
        int v0_0 = this.k;
        if (!(v0_0 instanceof ma.b)) {
            return 0;
        } else {
            return ((ma.b) v0_0);
        }
    }

    public final ka.g getContext()
    {
        kotlin.coroutines.EmptyCoroutineContext v0 = this.j;
        if (v0 == null) {
            v0 = kotlin.coroutines.EmptyCoroutineContext.g;
        }
        return v0;
    }

    public final StackTraceElement getStackTraceElement()
    {
        return 0;
    }

    public final Object invokeSuspend(Object p4)
    {
        ka.c v0_0 = kotlin.Result.a(p4);
        if (v0_0 != null) {
            this.j = new kb.e(v0_0, this.getContext());
        }
        ka.c v0_1 = this.k;
        if (v0_1 != null) {
            v0_1.resumeWith(p4);
        }
        return kotlin.coroutines.intrinsics.CoroutineSingletons.g;
    }
}
