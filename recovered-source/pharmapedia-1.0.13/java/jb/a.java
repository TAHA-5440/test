// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jb;
public class a extends kotlinx.coroutines.flow.internal.a {
    public final kotlin.coroutines.jvm.internal.SuspendLambda j;

    public a(ua.p p1, ka.g p2, int p3, kotlinx.coroutines.channels.BufferOverflow p4)
    {
        super(p2, p3, p4);
        super.j = ((kotlin.coroutines.jvm.internal.SuspendLambda) p1);
        return;
    }

    public Object a(ib.l p2, ka.c p3)
    {
        ga.p v2_1 = this.j.invoke(p2, p3);
        if (v2_1 != kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
            return ga.p.a;
        } else {
            return v2_1;
        }
    }

    public kotlinx.coroutines.flow.internal.a b(ka.g p3, int p4, kotlinx.coroutines.channels.BufferOverflow p5)
    {
        return new jb.a(this.j, p3, p4, p5);
    }

    public final String toString()
    {
        String v0_2 = new StringBuilder("block[");
        v0_2.append(this.j);
        v0_2.append("] -> ");
        v0_2.append(super.toString());
        return v0_2.toString();
    }
}
