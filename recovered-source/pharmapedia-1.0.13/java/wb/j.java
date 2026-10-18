// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package wb;
public abstract class j {
    public static final java.util.Set a;

    static j()
    {
        java.util.Set v0_1 = new sb.d[4];
        v0_1[0] = ub.f1.b;
        v0_1[1] = ub.i1.b;
        v0_1[2] = ub.c1.b;
        v0_1[3] = ub.l1.b;
        wb.j.a = com.bumptech.glide.g.t(v0_1);
        return;
    }

    public static final boolean a(sb.d p1)
    {
        p1.getClass();
        if ((!p1.isInline()) || (!wb.j.a.contains(p1))) {
            return 0;
        } else {
            return 1;
        }
    }
}
