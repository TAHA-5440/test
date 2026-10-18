// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vb;
public abstract class b {
    public static final vb.a d;
    public final m.t a;
    public final c0.g b;
    public final l.o c;

    static b()
    {
        vb.b.d = new vb.a(new m.t(0, 1, "    ", "type", 1, kotlinx.serialization.json.ClassDiscriminatorMode.g), xb.a.a);
        return;
    }

    public b(m.t p1, c0.g p2)
    {
        this.a = p1;
        this.b = p2;
        this.c = new l.o(25);
        return;
    }

    public final Object a(String p5, qb.a p6)
    {
        p6.getClass();
        p5.getClass();
        e0.x v0_1 = new e0.x(p5);
        Object vtmp4 = new kotlinx.serialization.json.internal.c(this, kotlinx.serialization.json.internal.WriteMode.i, v0_1, p6.getDescriptor()).g(p6);
        if (v0_1.e() != 10) {
            int v6_3 = new StringBuilder("Expected EOF after parsing, but had ");
            v6_3.append(p5.charAt((v0_1.b - 1)));
            v6_3.append(" instead");
            e0.x.l(v0_1, v6_3.toString(), 0, 6);
            throw 0;
        } else {
            return vtmp4;
        }
    }

    public final String b(qb.a p6, Object p7)
    {
        p6.getClass();
        cc.z v0_1 = new cc.z(8, 0);
        wb.i v1_4 = wb.b.c;
        try {
            kotlinx.serialization.json.internal.WriteMode v2_0;
            kotlinx.serialization.json.internal.WriteMode v2_4 = v1_4.a;
            a7.j v4_1 = 0;
        } catch (Throwable v6_1) {
            throw v6_1;
        }
        if (!v2_4.isEmpty()) {
            v2_0 = v2_4.removeLast();
        } else {
            v2_0 = 0;
        }
        kotlinx.serialization.json.internal.WriteMode v2_1 = ((char[]) v2_0);
        if (v2_1 != null) {
            v1_4.b = (v1_4.b - v2_1.length);
            v4_1 = v2_1;
        }
        if (v4_1 == null) {
            v4_1 = new char[128];
        }
        v0_1.i = v4_1;
        try {
            wb.i[] v3_5 = new wb.i[((ha.a) kotlinx.serialization.json.internal.WriteMode.n).a()];
            new wb.i(new a7.j(v0_1), this, kotlinx.serialization.json.internal.WriteMode.i, v3_5).g(p6, p7);
            Throwable v6_2 = v0_1.toString();
            v0_1.m();
            return v6_2;
        } catch (Throwable v6_3) {
            v0_1.m();
            throw v6_3;
        }
    }
}
