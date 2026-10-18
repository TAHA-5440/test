// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.serialization.json.internal;
final synthetic class JsonElementMarker$origin$1 extends kotlin.jvm.internal.FunctionReferenceImpl implements ua.p {

    public final Object invoke(Object p3, Object p4)
    {
        Boolean v3_4;
        int v4_2 = ((Number) p4).intValue();
        ((sb.d) p3).getClass();
        kotlinx.serialization.json.internal.a v0_1 = ((kotlinx.serialization.json.internal.a) this.receiver);
        v0_1.getClass();
        if ((((sb.d) p3).j(v4_2)) || (!((sb.d) p3).i(v4_2).c())) {
            v3_4 = 0;
        } else {
            v3_4 = 1;
        }
        v0_1.b = v3_4;
        return Boolean.valueOf(v3_4);
    }
}
