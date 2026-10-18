// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package sb;
public final class e implements sb.d, ub.j {
    public final String a;
    public final jc.g b;
    public final int c;
    public final java.util.HashSet d;
    public final String[] e;
    public final sb.d[] f;
    public final java.util.List[] g;
    public final boolean[] h;
    public final java.util.Map i;
    public final sb.d[] j;
    public final ga.e k;

    public e(String p4, jc.g p5, int p6, java.util.List p7, sb.a p8)
    {
        this.a = p4;
        this.b = p5;
        this.c = p6;
        ga.e v4_9 = p8.b;
        v4_9.getClass();
        int v5_1 = new java.util.HashSet(kotlin.collections.a.I(ha.l.y(v4_9, 12)));
        ha.j.T(v4_9, v5_1);
        this.d = v5_1;
        int v5_2 = 0;
        Integer v6_2 = new String[0];
        this.e = ((String[]) v4_9.toArray(v6_2));
        this.f = ub.m0.c(p8.d);
        Integer v6_3 = new java.util.List[0];
        this.g = ((java.util.List[]) p8.e.toArray(v6_3));
        ga.e v4_8 = p8.f;
        v4_8.getClass();
        Integer v6_5 = new boolean[v4_8.size()];
        Object v8_1 = v4_8.size();
        kotlin.Pair v0_0 = 0;
        while (v0_0 < v8_1) {
            boolean v1_0 = v4_8.get(v0_0);
            v0_0++;
            int v2 = (v5_2 + 1);
            v6_5[v5_2] = ((Boolean) v1_0).booleanValue();
            v5_2 = v2;
        }
        this.h = v6_5;
        ga.e v4_10 = this.e;
        v4_10.getClass();
        int v5_4 = new cb.k(new androidx.activity.e(v4_10, 6), 1);
        ga.e v4_13 = new java.util.ArrayList(ha.l.y(v5_4, 10));
        int v5_5 = v5_4.iterator();
        while(true) {
            Integer v6_11 = ((cb.b) v5_5);
            if (!v6_11.h.hasNext()) {
                break;
            }
            Integer v6_14 = ((ha.p) v6_11.next());
            v4_13.add(new kotlin.Pair(v6_14.b, Integer.valueOf(v6_14.a)));
        }
        this.i = kotlin.collections.a.M(v4_13);
        this.j = ub.m0.c(p7);
        this.k = kotlin.a.b(new androidx.activity.e(this, 9));
        return;
    }

    public final String a()
    {
        return this.a;
    }

    public final java.util.Set b()
    {
        return this.d;
    }

    public final boolean c()
    {
        return 0;
    }

    public final int d(String p2)
    {
        p2.getClass();
        int v2_2 = ((Integer) this.i.get(p2));
        if (v2_2 == 0) {
            return -3;
        } else {
            return v2_2.intValue();
        }
    }

    public final jc.g e()
    {
        return this.b;
    }

    public final boolean equals(Object p7)
    {
        if (this != p7) {
            if (((p7 instanceof sb.e)) && ((this.a.equals(((sb.d) p7).a())) && (java.util.Arrays.equals(this.j, ((sb.e) p7).j)))) {
                int v2_2 = this.c;
                if (v2_2 == ((sb.d) p7).f()) {
                    int v7_5 = 0;
                    while (v7_5 < v2_2) {
                        boolean v3_0 = this.f;
                        if ((kotlin.jvm.internal.f.a(v3_0[v7_5].a(), ((sb.d) p7).i(v7_5).a())) && (kotlin.jvm.internal.f.a(v3_0[v7_5].e(), ((sb.d) p7).i(v7_5).e()))) {
                            v7_5++;
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
        return this.g[p2];
    }

    public final int hashCode()
    {
        return ((Number) this.k.getValue()).intValue();
    }

    public final sb.d i(int p2)
    {
        return this.f[p2];
    }

    public final boolean isInline()
    {
        return 0;
    }

    public final boolean j(int p2)
    {
        return this.h[p2];
    }

    public final String toString()
    {
        return ha.j.I(com.bumptech.glide.d.C(0, this.c), ", ", this.a.concat("("), ")", new ac.c(this, 8), 24);
    }
}
