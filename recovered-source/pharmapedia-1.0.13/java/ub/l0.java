// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class l0 implements qb.a {
    public final Object a;

    public l0()
    {
        this.a = kotlin.a.a(kotlin.LazyThreadSafetyMode.g, new androidx.room.i(this, 9));
        return;
    }

    public final Object deserialize(tb.c p4)
    {
        p4.getClass();
        String v0_2 = this.getDescriptor();
        kotlinx.serialization.SerializationException v4_4 = p4.b(v0_2);
        int v1_1 = v4_4.q(this.getDescriptor());
        if (v1_1 != -1) {
            throw new kotlinx.serialization.SerializationException(r1.a.g(v1_1, "Unexpected index "));
        } else {
            v4_4.a(v0_2);
            return ga.p.a;
        }
    }

    public final sb.d getDescriptor()
    {
        return ((sb.d) this.a.getValue());
    }

    public final void serialize(tb.d p1, Object p2)
    {
        p2.getClass();
        p1.b(this.getDescriptor()).a(this.getDescriptor());
        return;
    }
}
