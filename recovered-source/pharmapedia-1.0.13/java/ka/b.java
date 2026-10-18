// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ka;
public final synthetic class b implements ua.p {
    public final synthetic ka.g[] g;
    public final synthetic kotlin.jvm.internal.Ref$IntRef h;

    public synthetic b(ka.g[] p1, kotlin.jvm.internal.Ref$IntRef p2)
    {
        this.g = p1;
        this.h = p2;
        return;
    }

    public final Object invoke(Object p3, Object p4)
    {
        ((ga.p) p3).getClass();
        ((ka.e) p4).getClass();
        ga.p v3_3 = this.h;
        int v0 = v3_3.g;
        v3_3.g = (v0 + 1);
        this.g[v0] = ((ka.e) p4);
        return ga.p.a;
    }
}
