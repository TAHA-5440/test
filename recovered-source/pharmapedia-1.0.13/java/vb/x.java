// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vb;
public final class x implements qb.a {
    public static final vb.x a;
    public static final vb.w b;

    static x()
    {
        vb.x.a = new vb.x();
        vb.x.b = vb.w.b;
        return;
    }

    public final Object deserialize(tb.c p4)
    {
        p4.getClass();
        com.bumptech.glide.k.b(p4);
        return new vb.v(((java.util.Map) new ub.d0(vb.l.a).e(p4)));
    }

    public final sb.d getDescriptor()
    {
        return vb.x.b;
    }

    public final void serialize(tb.d p3, Object p4)
    {
        ((vb.v) p4).getClass();
        com.bumptech.glide.k.a(p3);
        new ub.d0(vb.l.a).serialize(p3, ((vb.v) p4));
        return;
    }
}
