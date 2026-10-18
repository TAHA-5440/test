// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class s implements java.lang.Iterable, va.a {
    public static final yb.s h;
    public final String[] g;

    static s()
    {
        String[] v1_1 = new String[0];
        yb.s.h = new yb.s(v1_1);
        return;
    }

    public s(String[] p1)
    {
        p1.getClass();
        this.g = p1;
        return;
    }

    public final String a(String p5)
    {
        String[] v0 = this.g;
        v0.getClass();
        int v1_0 = (v0.length - 2);
        int v2_1 = com.bumptech.glide.e.i(v1_0, 0, -2);
        if (v2_1 <= v1_0) {
            while (!p5.equalsIgnoreCase(v0[v1_0])) {
                if (v1_0 != v2_1) {
                    v1_0 -= 2;
                }
            }
            return v0[(v1_0 + 1)];
        }
        return 0;
    }

    public final String b(int p4)
    {
        IndexOutOfBoundsException v0_3 = ((String) ha.i.P((p4 * 2), this.g));
        if (v0_3 == null) {
            StringBuilder v1_2 = new StringBuilder("name[");
            v1_2.append(p4);
            v1_2.append(93);
            throw new IndexOutOfBoundsException(v1_2.toString());
        } else {
            return v0_3;
        }
    }

    public final g7.c1 c()
    {
        g7.c1 v0_1 = new g7.c1(10, 0);
        java.util.ArrayList v1_1 = v0_1.b;
        v1_1.getClass();
        java.util.List v2_1 = this.g;
        v2_1.getClass();
        java.util.List v2_2 = java.util.Arrays.asList(v2_1);
        v2_2.getClass();
        v1_1.addAll(v2_2);
        return v0_1;
    }

    public final String e(int p4)
    {
        IndexOutOfBoundsException v0_4 = ((String) ha.i.P(((p4 * 2) + 1), this.g));
        if (v0_4 == null) {
            StringBuilder v1_0 = new StringBuilder("value[");
            v1_0.append(p4);
            v1_0.append(93);
            throw new IndexOutOfBoundsException(v1_0.toString());
        } else {
            return v0_4;
        }
    }

    public final boolean equals(Object p2)
    {
        if ((!(p2 instanceof yb.s)) || (!java.util.Arrays.equals(this.g, ((yb.s) p2).g))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final java.util.List f(String p6)
    {
        p6.getClass();
        int v0 = this.size();
        java.util.List v1 = 0;
        int v2 = 0;
        java.util.ArrayList v3_1 = 0;
        while (v2 < v0) {
            if (p6.equalsIgnoreCase(this.b(v2))) {
                if (v3_1 == null) {
                    v3_1 = new java.util.ArrayList(2);
                }
                v3_1.add(this.e(v2));
            }
            v2++;
        }
        if (v3_1 != null) {
            v1 = java.util.Collections.unmodifiableList(v3_1);
            v1.getClass();
        }
        if (v1 != null) {
            return v1;
        } else {
            return kotlin.collections.EmptyList.g;
        }
    }

    public final int hashCode()
    {
        return java.util.Arrays.hashCode(this.g);
    }

    public final java.util.Iterator iterator()
    {
        ga.g v0_0 = this.size();
        kotlin.Pair[] v1 = new kotlin.Pair[v0_0];
        int v2 = 0;
        while (v2 < v0_0) {
            v1[v2] = new kotlin.Pair(this.b(v2), this.e(v2));
            v2++;
        }
        return new ga.g(v1);
    }

    public final int size()
    {
        return (this.g.length / 2);
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder();
        int v1 = this.size();
        int v2 = 0;
        while (v2 < v1) {
            String v3_0 = this.b(v2);
            String v4 = this.e(v2);
            v0_1.append(v3_0);
            v0_1.append(": ");
            if (zb.c.k(v3_0)) {
                v4 = "\u2588\u2588";
            }
            v0_1.append(v4);
            v0_1.append("\n");
            v2++;
        }
        return v0_1.toString();
    }
}
