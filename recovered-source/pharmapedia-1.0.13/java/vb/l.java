// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vb;
public final class l implements qb.a {
    public static final vb.l a;
    public static final sb.e b;

    static l()
    {
        int v3_0;
        vb.l.a = new vb.l();
        String v0_5 = new sb.d[0];
        java.util.ArrayList v1_2 = new vb.t(1);
        if (db.i.a0("kotlinx.serialization.json.JsonElement")) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Blank serial names are prohibited");
            v3_0 = 0;
        } else {
            sb.b v5 = sb.b.e;
            if (v5.equals(sb.h.e)) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("For StructureKind.CLASS please use \'buildClassSerialDescriptor\' instead");
            } else {
                sb.a v8_1 = new sb.a("kotlinx.serialization.json.JsonElement");
                v1_2.invoke(v8_1);
                v3_0 = new sb.e("kotlinx.serialization.json.JsonElement", v5, v8_1.b.size(), ha.i.S(v0_5), v8_1);
            }
        }
        vb.l.b = v3_0;
        return;
    }

    public final Object deserialize(tb.c p1)
    {
        p1.getClass();
        return com.bumptech.glide.k.b(p1).V();
    }

    public final sb.d getDescriptor()
    {
        return vb.l.b;
    }

    public final void serialize(tb.d p2, Object p3)
    {
        ((vb.j) p3).getClass();
        com.bumptech.glide.k.a(p2);
        if (!(((vb.j) p3) instanceof vb.z)) {
            if (!(((vb.j) p3) instanceof vb.v)) {
                if (!(((vb.j) p3) instanceof vb.d)) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.s();
                    return;
                } else {
                    p2.g(vb.f.a, ((vb.j) p3));
                    return;
                }
            } else {
                p2.g(vb.x.a, ((vb.j) p3));
                return;
            }
        } else {
            p2.g(vb.a0.a, ((vb.j) p3));
            return;
        }
    }
}
