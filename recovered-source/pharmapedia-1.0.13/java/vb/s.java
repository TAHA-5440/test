// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vb;
public final class s implements qb.a {
    public static final vb.s a;
    public static final sb.e b;

    static s()
    {
        vb.s.a = new vb.s();
        String v0_4 = new sb.d[0];
        if (db.i.a0("kotlinx.serialization.json.JsonNull")) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Blank serial names are prohibited");
            return;
        } else {
            sb.g v3 = sb.g.e;
            if (v3.equals(sb.h.e)) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("For StructureKind.CLASS please use \'buildClassSerialDescriptor\' instead");
                return;
            } else {
                sb.a v6_1 = new sb.a("kotlinx.serialization.json.JsonNull");
                vb.s.b = new sb.e("kotlinx.serialization.json.JsonNull", v3, v6_1.b.size(), ha.i.S(v0_4), v6_1);
                return;
            }
        }
    }

    public final Object deserialize(tb.c p2)
    {
        p2.getClass();
        com.bumptech.glide.k.b(p2);
        if (p2.p()) {
            throw new kotlinx.serialization.json.internal.JsonDecodingException("Expected \'null\' literal");
        } else {
            return vb.r.INSTANCE;
        }
    }

    public final sb.d getDescriptor()
    {
        return vb.s.b;
    }

    public final void serialize(tb.d p1, Object p2)
    {
        ((vb.r) p2).getClass();
        com.bumptech.glide.k.a(p1);
        p1.c();
        return;
    }
}
