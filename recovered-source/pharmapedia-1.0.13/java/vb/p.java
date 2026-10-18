// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vb;
public final class p implements qb.a {
    public static final vb.p a;
    public static final ub.s0 b;

    static p()
    {
        vb.p.a = new vb.p();
        if (db.i.a0("kotlinx.serialization.json.JsonLiteral")) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Blank serial names are prohibited");
            return;
        } else {
            ub.s0 v2_3 = ((ia.e) ub.t0.a.values()).iterator();
            while (((f1.c) v2_3).hasNext()) {
                qb.a v3_6 = ((qb.a) ((ia.b) v2_3).next());
                if ("kotlinx.serialization.json.JsonLiteral".equals(v3_6.getDescriptor().a())) {
                    String v0_4 = new StringBuilder("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name kotlinx.serialization.json.JsonLiteral there already exists ");
                    v0_4.append(kotlin.jvm.internal.h.a(v3_6.getClass()).c());
                    v0_4.append(".\n                Please refer to SerialDescriptor documentation for additional information.\n            ");
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u(db.j.H(v0_4.toString()));
                    return;
                }
            }
            vb.p.b = new ub.s0("kotlinx.serialization.json.JsonLiteral", sb.c.m);
            return;
        }
    }

    public final Object deserialize(tb.c p3)
    {
        p3.getClass();
        kotlinx.serialization.json.internal.JsonDecodingException v3_5 = com.bumptech.glide.k.b(p3).V();
        if (!(v3_5 instanceof vb.o)) {
            String v0_3 = new StringBuilder("Unexpected JSON element, expected JsonLiteral, had ");
            v0_3.append(kotlin.jvm.internal.h.a(v3_5.getClass()));
            throw wb.g.b(-1, v3_5.toString(), v0_3.toString());
        } else {
            return ((vb.o) v3_5);
        }
    }

    public final sb.d getDescriptor()
    {
        return vb.p.b;
    }

    public final void serialize(tb.d p4, Object p5)
    {
        ((vb.o) p5).getClass();
        double v0_0 = ((vb.o) p5).h;
        com.bumptech.glide.k.a(p4);
        if (!((vb.o) p5).g) {
            boolean v5_7 = db.p.S(v0_0);
            if (!v5_7) {
                boolean v5_2 = com.bumptech.glide.e.r(v0_0);
                if (!v5_2) {
                    boolean v5_3 = 0;
                    try {
                        if (!db.o.J(v0_0)) {
                            boolean v1_1 = 0;
                        } else {
                            v1_1 = Double.valueOf(Double.parseDouble(v0_0));
                        }
                    } catch (NumberFormatException) {
                    }
                    if (!v1_1) {
                        if (!v0_0.equals("true")) {
                            if (v0_0.equals("false")) {
                                v5_3 = Boolean.FALSE;
                            }
                        } else {
                            v5_3 = Boolean.TRUE;
                        }
                        if (!v5_3) {
                            p4.p(v0_0);
                        } else {
                            p4.h(v5_3.booleanValue());
                        }
                    } else {
                        p4.d(v1_1.doubleValue());
                    }
                    return;
                } else {
                    p4.k(ub.i1.b).m(v5_2.g);
                    return;
                }
            } else {
                p4.m(v5_7.longValue());
                return;
            }
        } else {
            p4.p(v0_0);
            return;
        }
    }
}
