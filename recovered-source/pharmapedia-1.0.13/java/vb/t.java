// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vb;
public final synthetic class t implements ua.l {
    public final synthetic int g;

    public synthetic t(int p1)
    {
        this.g = p1;
        return;
    }

    public final Object invoke(Object p3)
    {
        switch (this.g) {
            case 0:
                ((java.util.Map$Entry) p3).getClass();
                int v0_18 = ((String) ((java.util.Map$Entry) p3).getKey());
                String v3_6 = ((vb.j) ((java.util.Map$Entry) p3).getValue());
                StringBuilder v1_1 = new StringBuilder();
                wb.k.a(v0_18, v1_1);
                v1_1.append(58);
                v1_1.append(v3_6);
                return v1_1.toString();
            default:
                ((sb.a) p3).getClass();
                sb.a.a(((sb.a) p3), "JsonPrimitive", new vb.m(new androidx.room.i(10)));
                sb.a.a(((sb.a) p3), "JsonNull", new vb.m(new androidx.room.i(11)));
                sb.a.a(((sb.a) p3), "JsonLiteral", new vb.m(new androidx.room.i(12)));
                sb.a.a(((sb.a) p3), "JsonObject", new vb.m(new androidx.room.i(13)));
                sb.a.a(((sb.a) p3), "JsonArray", new vb.m(new androidx.room.i(14)));
                return ga.p.a;
        }
    }
}
