// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public abstract class m0 {
    public static final sb.d[] a;
    public static final qb.a[] b;

    static synthetic m0()
    {
        qb.a[] v0_1 = new sb.d[0];
        ub.m0.a = v0_1;
        qb.a[] v0_3 = new qb.a[0];
        ub.m0.b = v0_3;
        return;
    }

    public static final ub.x a(String p2, qb.a p3)
    {
        return new ub.x(p2, new ub.y(p3));
    }

    public static final java.util.Set b(sb.d p4)
    {
        p4.getClass();
        if (!(p4 instanceof ub.j)) {
            java.util.HashSet v0_2 = new java.util.HashSet(p4.f());
            int v1_1 = p4.f();
            int v2 = 0;
            while (v2 < v1_1) {
                v0_2.add(p4.g(v2));
                v2++;
            }
            return v0_2;
        } else {
            return ((ub.j) p4).b();
        }
    }

    public static final sb.d[] c(java.util.List p1)
    {
        if ((p1 == null) || (p1.isEmpty())) {
            p1 = 0;
        }
        if (p1 != null) {
            sb.d[] v0_2 = new sb.d[0];
            sb.d[] v1_1 = ((sb.d[]) p1.toArray(v0_2));
            if (v1_1 != null) {
                return v1_1;
            }
        }
        return ub.m0.a;
    }

    public static final int d(sb.d p7, sb.d[] p8)
    {
        p8.getClass();
        int v0_7 = ((p7.a().hashCode() * 31) + java.util.Arrays.hashCode(p8));
        int v8_1 = p7.f();
        int v2_0 = 1;
        while(true) {
            int v4_0;
            int v3 = 0;
            if (v8_1 <= 0) {
                v4_0 = 0;
            } else {
                v4_0 = 1;
            }
            if (v4_0 == 0) {
                break;
            }
            int v5_3 = (v8_1 - 1);
            int v2_1 = (v2_0 * 31);
            int v8_7 = p7.i((p7.f() - v8_1)).a();
            if (v8_7 != 0) {
                v3 = v8_7.hashCode();
            }
            v2_0 = (v2_1 + v3);
            v8_1 = v5_3;
        }
        int v8_2 = p7.f();
        int v4_1 = 1;
        while(true) {
            int v5_0;
            if (v8_2 <= 0) {
                v5_0 = 0;
            } else {
                v5_0 = 1;
            }
            if (v5_0 == 0) {
                break;
            }
            int v8_5;
            int v6 = (v8_2 - 1);
            int v4_2 = (v4_1 * 31);
            int v8_4 = p7.i((p7.f() - v8_2)).e();
            if (v8_4 == 0) {
                v8_5 = 0;
            } else {
                v8_5 = v8_4.hashCode();
            }
            v4_1 = (v4_2 + v8_5);
            v8_2 = v6;
        }
        return ((((v0_7 * 31) + v2_0) * 31) + v4_1);
    }

    public static final void e(int p2, int p3, sb.d p4)
    {
        p4.getClass();
        java.util.ArrayList v0_1 = new java.util.ArrayList();
        int v2_2 = ((~ p2) & p3);
        int v3_2 = 0;
        while (v3_2 < 32) {
            if ((v2_2 & 1) != 0) {
                v0_1.add(p4.g(v3_2));
            }
            v2_2 >>= 1;
            v3_2++;
        }
        throw new kotlinx.serialization.MissingFieldException(v0_1, p4.a());
    }
}
