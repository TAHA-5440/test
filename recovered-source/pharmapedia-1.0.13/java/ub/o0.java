// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public class o0 implements sb.d, ub.j {
    public final String a;
    public final ub.w b;
    public final int c;
    public int d;
    public final String[] e;
    public final java.util.List[] f;
    public final boolean[] g;
    public Object h;
    public final Object i;
    public final Object j;
    public final Object k;

    public o0(String p2, ub.w p3, int p4)
    {
        this.a = p2;
        this.b = p3;
        this.c = p4;
        this.d = -1;
        ga.e v2_7 = new String[p4];
        ub.n0 v3_10 = 0;
        while (v3_10 < p4) {
            v2_7[v3_10] = "[UNINITIALIZED]";
            v3_10++;
        }
        this.e = v2_7;
        ga.e v2_1 = this.c;
        ub.n0 v3_1 = new java.util.List[v2_1];
        this.f = v3_1;
        ga.e v2_2 = new boolean[v2_1];
        this.g = v2_2;
        this.h = kotlin.collections.a.G();
        ga.e v2_4 = kotlin.LazyThreadSafetyMode.g;
        this.i = kotlin.a.a(v2_4, new ub.n0(this, 0));
        this.j = kotlin.a.a(v2_4, new ub.n0(this, 1));
        this.k = kotlin.a.a(v2_4, new ub.n0(this, 2));
        return;
    }

    public final String a()
    {
        return this.a;
    }

    public final java.util.Set b()
    {
        return this.h.keySet();
    }

    public final boolean c()
    {
        return 0;
    }

    public final int d(String p2)
    {
        p2.getClass();
        int v2_2 = ((Integer) this.h.get(p2));
        if (v2_2 == 0) {
            return -3;
        } else {
            return v2_2.intValue();
        }
    }

    public final jc.g e()
    {
        return sb.h.e;
    }

    public boolean equals(Object p6)
    {
        if (this != p6) {
            if (((p6 instanceof ub.o0)) && ((this.a.equals(((sb.d) p6).a())) && (java.util.Arrays.equals(((sb.d[]) this.j.getValue()), ((sb.d[]) ((ub.o0) p6).j.getValue()))))) {
                int v2_4 = this.c;
                if (v2_4 == ((sb.d) p6).f()) {
                    int v6_7 = 0;
                    while (v6_7 < v2_4) {
                        if ((kotlin.jvm.internal.f.a(this.i(v6_7).a(), ((sb.d) p6).i(v6_7).a())) && (kotlin.jvm.internal.f.a(this.i(v6_7).e(), ((sb.d) p6).i(v6_7).e()))) {
                            v6_7++;
                        }
                    }
                    return 1;
                }
            }
            return 0;
        }
        return 1;
    }

    public final int f()
    {
        return this.c;
    }

    public final String g(int p2)
    {
        return this.e[p2];
    }

    public final java.util.List getAnnotations()
    {
        return kotlin.collections.EmptyList.g;
    }

    public final java.util.List h(int p2)
    {
        kotlin.collections.EmptyList v2_1 = this.f[p2];
        if (v2_1 == null) {
            v2_1 = kotlin.collections.EmptyList.g;
        }
        return v2_1;
    }

    public int hashCode()
    {
        return ((Number) this.k.getValue()).intValue();
    }

    public final sb.d i(int p2)
    {
        return ((qb.a[]) this.i.getValue())[p2].getDescriptor();
    }

    public boolean isInline()
    {
        return 0;
    }

    public final boolean j(int p2)
    {
        return this.g[p2];
    }

    public final void k(String p5, boolean p6)
    {
        int v0_1 = (this.d + 1);
        this.d = v0_1;
        String[] v1 = this.e;
        v1[v0_1] = p5;
        this.g[v0_1] = p6;
        this.f[v0_1] = 0;
        if (v0_1 == (this.c - 1)) {
            java.util.HashMap v5_4 = new java.util.HashMap();
            int v6_1 = v1.length;
            int v0_2 = 0;
            while (v0_2 < v6_1) {
                v5_4.put(v1[v0_2], Integer.valueOf(v0_2));
                v0_2++;
            }
            this.h = v5_4;
        }
        return;
    }

    public final String toString()
    {
        return ha.j.I(com.bumptech.glide.d.C(0, this.c), ", ", this.a.concat("("), ")", new ac.c(this, 9), 24);
    }
}
