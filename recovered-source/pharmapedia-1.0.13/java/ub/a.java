// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public abstract class a implements qb.a {

    public abstract Object a();

    public abstract int b(Object p0);

    public abstract java.util.Iterator c(Object p0);

    public abstract int d(Object p0);

    public Object deserialize(tb.c p1)
    {
        p1.getClass();
        return this.e(p1);
    }

    public final Object e(tb.c p5)
    {
        p5.getClass();
        Object v0 = this.a();
        sb.d v1_1 = this.b(v0);
        Object v5_2 = p5.b(this.getDescriptor());
        while(true) {
            int v2_1 = v5_2.q(this.getDescriptor());
            if (v2_1 == -1) {
                break;
            }
            this.f(v5_2, (v2_1 + v1_1), v0);
        }
        v5_2.a(this.getDescriptor());
        return this.h(v0);
    }

    public abstract void f(tb.a p0, int p1, Object p2);

    public abstract Object g(Object p0);

    public abstract Object h(Object p0);
}
