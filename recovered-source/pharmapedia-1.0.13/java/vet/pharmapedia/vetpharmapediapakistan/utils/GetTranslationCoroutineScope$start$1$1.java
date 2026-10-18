// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.utils;
final class GetTranslationCoroutineScope$start$1$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements ua.p {
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.utils.b g;
    public final synthetic kotlin.jvm.internal.Ref$ObjectRef h;

    public GetTranslationCoroutineScope$start$1$1(vet.pharmapedia.vetpharmapediapakistan.utils.b p1, kotlin.jvm.internal.Ref$ObjectRef p2, ka.c p3)
    {
        this.g = p1;
        this.h = p2;
        super(2, p3);
        return;
    }

    public final ka.c create(Object p3, ka.c p4)
    {
        return new vet.pharmapedia.vetpharmapediapakistan.utils.GetTranslationCoroutineScope$start$1$1(this.g, this.h, p4);
    }

    public final Object invoke(Object p1, Object p2)
    {
        ga.p v2_2 = ga.p.a;
        ((vet.pharmapedia.vetpharmapediapakistan.utils.GetTranslationCoroutineScope$start$1$1) this.create(((gb.v) p1), ((ka.c) p2))).invokeSuspend(v2_2);
        return v2_2;
    }

    public final Object invokeSuspend(Object p2)
    {
        kotlin.b.b(p2);
        ga.p v2_2 = this.g.j;
        if (v2_2 != null) {
            v2_2.invoke(this.h.g);
        }
        return ga.p.a;
    }
}
