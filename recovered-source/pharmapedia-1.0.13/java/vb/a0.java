// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vb;
public final class a0 implements qb.a {
    public static final vb.a0 a;
    public static final sb.e b;

    static a0()
    {
        vb.a0.a = new vb.a0();
        sb.c v3 = sb.c.m;
        String v0_5 = new sb.d[0];
        if (db.i.a0("kotlinx.serialization.json.JsonPrimitive")) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Blank serial names are prohibited");
            return;
        } else {
            if (v3.equals(sb.h.e)) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("For StructureKind.CLASS please use \'buildClassSerialDescriptor\' instead");
                return;
            } else {
                sb.a v6_1 = new sb.a("kotlinx.serialization.json.JsonPrimitive");
                vb.a0.b = new sb.e("kotlinx.serialization.json.JsonPrimitive", v3, v6_1.b.size(), ha.i.S(v0_5), v6_1);
                return;
            }
        }
    }

    public final Object deserialize(tb.c p3)
    {
        p3.getClass();
        kotlinx.serialization.json.internal.JsonDecodingException v3_5 = com.bumptech.glide.k.b(p3).V();
        if (!(v3_5 instanceof vb.z)) {
            String v0_3 = new StringBuilder("Unexpected JSON element, expected JsonPrimitive, had ");
            v0_3.append(kotlin.jvm.internal.h.a(v3_5.getClass()));
            throw wb.g.b(-1, v3_5.toString(), v0_3.toString());
        } else {
            return ((vb.z) v3_5);
        }
    }

    public final sb.d getDescriptor()
    {
        return vb.a0.b;
    }

    public final void serialize(tb.d p2, Object p3)
    {
        ((vb.z) p3).getClass();
        com.bumptech.glide.k.a(p2);
        if (!(((vb.z) p3) instanceof vb.r)) {
            p2.g(vb.p.a, ((vb.o) ((vb.z) p3)));
            return;
        } else {
            p2.g(vb.s.a, vb.r.INSTANCE);
            return;
        }
    }
}
