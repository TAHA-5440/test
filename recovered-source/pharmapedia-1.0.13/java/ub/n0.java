// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final synthetic class n0 implements ua.a {
    public final synthetic int g;
    public final synthetic ub.o0 h;

    public synthetic n0(ub.o0 p1, int p2)
    {
        this.g = p2;
        this.h = p1;
        return;
    }

    public final Object invoke()
    {
        switch (this.g) {
            case 0:
                sb.d[] v0_5 = this.h.b.childSerializers();
                if (v0_5 == null) {
                    v0_5 = ub.m0.b;
                }
                return v0_5;
            case 1:
                int v1_0;
                sb.d[] v0_10 = this.h.b.typeParametersSerializers();
                if (v0_10 == null) {
                    v1_0 = 0;
                } else {
                    v1_0 = new java.util.ArrayList(v0_10.length);
                    int v2_0 = v0_10.length;
                    int v3 = 0;
                    while (v3 < v2_0) {
                        v1_0.add(v0_10[v3].getDescriptor());
                        v3++;
                    }
                }
                return ub.m0.c(v1_0);
            default:
                sb.d[] v0_6 = this.h;
                return Integer.valueOf(ub.m0.d(v0_6, ((sb.d[]) v0_6.j.getValue())));
        }
    }
}
