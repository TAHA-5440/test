// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vb;
public final class f implements qb.a {
    public static final vb.f a;
    public static final vb.e b;

    static f()
    {
        vb.f.a = new vb.f();
        vb.f.b = vb.e.b;
        return;
    }

    public final Object deserialize(tb.c p3)
    {
        p3.getClass();
        com.bumptech.glide.k.b(p3);
        return new vb.d(((java.util.List) new ub.c().e(p3)));
    }

    public final sb.d getDescriptor()
    {
        return vb.f.b;
    }

    public final void serialize(tb.d p7, Object p8)
    {
        ((vb.d) p8).getClass();
        com.bumptech.glide.k.a(p7);
        int v2_1 = vb.l.b;
        v2_1.getClass();
        ub.b v1_1 = new ub.b(v2_1);
        int v2_0 = ((vb.d) p8).size();
        ((wb.i) p7).getClass();
        tb.b v7_2 = ((wb.i) p7).b(v1_1);
        java.util.Iterator v8_2 = ((vb.d) p8).iterator();
        int v3 = 0;
        while (v3 < v2_0) {
            ((wb.i) v7_2).t(v1_1, v3, vb.l.a, v8_2.next());
            v3++;
        }
        v7_2.a(v1_1);
        return;
    }
}
