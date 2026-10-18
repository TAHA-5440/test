// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public abstract class n extends ub.a {
    public final qb.a a;

    public n(qb.a p1)
    {
        this.a = p1;
        return;
    }

    public void f(tb.a p4, int p5, Object p6)
    {
        this.i(p5, p6, p4.i(this.getDescriptor(), p5, this.a, 0));
        return;
    }

    public abstract void i(int p0, Object p1, Object p2);

    public void serialize(tb.d p8, Object p9)
    {
        int v0 = this.d(p9);
        sb.d v1 = this.getDescriptor();
        v1.getClass();
        tb.b v8_2 = ((wb.i) p8).b(v1);
        java.util.Iterator v9_1 = this.c(p9);
        int v2 = 0;
        while (v2 < v0) {
            ((wb.i) v8_2).t(this.getDescriptor(), v2, this.a, v9_1.next());
            v2++;
        }
        v8_2.a(v1);
        return;
    }
}
