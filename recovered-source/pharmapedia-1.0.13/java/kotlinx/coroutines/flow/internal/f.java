// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow.internal;
public final class f implements jb.c {
    public final ka.g g;
    public final Object h;
    public final ua.p i;

    public f(jb.c p2, ka.g p3)
    {
        this.g = p3;
        this.h = lb.a.k(p3);
        this.i = new kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1(p2, 0);
        return;
    }

    public final Object emit(Object p4, ka.c p5)
    {
        ga.p v4_1 = kb.b.a(this.g, p4, this.h, this.i, p5);
        if (v4_1 != kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
            return ga.p.a;
        } else {
            return v4_1;
        }
    }
}
