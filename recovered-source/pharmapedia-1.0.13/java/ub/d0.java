// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class d0 extends ub.a {
    public final qb.a a;
    public final ub.c0 b;

    public d0(qb.a p3)
    {
        Class vtmp1 = p3.getClass();
        this.a = p3;
        this.b = new ub.c0(ub.z0.b, p3.getDescriptor());
        return;
    }

    public final Object a()
    {
        return new java.util.LinkedHashMap();
    }

    public final int b(Object p1)
    {
        ((java.util.LinkedHashMap) p1).getClass();
        return (((java.util.LinkedHashMap) p1).size() * 2);
    }

    public final java.util.Iterator c(Object p1)
    {
        ((java.util.Map) p1).getClass();
        return ((java.util.Map) p1).entrySet().iterator();
    }

    public final int d(Object p1)
    {
        ((java.util.Map) p1).getClass();
        return ((java.util.Map) p1).size();
    }

    public final void f(tb.a p6, int p7, Object p8)
    {
        ((java.util.Map) p8).getClass();
        ub.c0 v1 = this.b;
        Object v0_1 = p6.i(v1, p7, ub.z0.a, 0);
        int v3 = p6.q(v1);
        if (v3 != (p7 + 1)) {
            oc.l.d(r1.a.l("Value must follow key in a map, index for key: ", ", returned index for value: ", p7, v3));
        } else {
            Object v6_3;
            qb.a v4_0 = this.a;
            if ((!((java.util.Map) p8).containsKey(v0_1)) || ((v4_0.getDescriptor().e() instanceof sb.c))) {
                v6_3 = p6.i(v1, v3, v4_0, 0);
            } else {
                v6_3 = p6.i(v1, v3, v4_0, kotlin.collections.a.H(((java.util.Map) p8), v0_1));
            }
            ((java.util.Map) p8).put(v0_1, v6_3);
        }
        return;
    }

    public final Object g(Object p1)
    {
        throw 0;
    }

    public final sb.d getDescriptor()
    {
        return this.b;
    }

    public final Object h(Object p1)
    {
        ((java.util.LinkedHashMap) p1).getClass();
        return ((java.util.LinkedHashMap) p1);
    }

    public final void serialize(tb.d p8, Object p9)
    {
        this.d(p9);
        ub.c0 v0 = this.b;
        v0.getClass();
        tb.b v8_2 = ((wb.i) p8).b(v0);
        java.util.Iterator v9_1 = this.c(p9);
        int v1 = 0;
        while (v9_1.hasNext()) {
            Object v2_2 = ((java.util.Map$Entry) v9_1.next());
            qb.a v3_0 = v2_2.getKey();
            Object v2_3 = v2_2.getValue();
            int v4 = (v1 + 1);
            wb.i v6_1 = ((wb.i) v8_2);
            v6_1.t(v0, v1, ub.z0.a, v3_0);
            v1 += 2;
            v6_1.t(v0, v4, this.a, v2_3);
        }
        v8_2.a(v0);
        return;
    }
}
