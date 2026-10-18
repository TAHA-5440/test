// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.collections;
public abstract class a extends com.bumptech.glide.f {

    public static java.util.Map G()
    {
        return kotlin.collections.EmptyMap.g;
    }

    public static Object H(java.util.Map p2, Object p3)
    {
        p2.getClass();
        StringBuilder v0_1 = p2.get(p3);
        if ((v0_1 == null) && (!p2.containsKey(p3))) {
            StringBuilder v0_0 = new StringBuilder("Key ");
            v0_0.append(p3);
            v0_0.append(" is missing in the map.");
            throw new java.util.NoSuchElementException(v0_0.toString());
        } else {
            return v0_1;
        }
    }

    public static int I(int p1)
    {
        if (p1 >= 0) {
            if (p1 >= 3) {
                if (p1 >= 1073741824) {
                    return 2147483647;
                } else {
                    return ((int) ((((float) p1) / 1061158912) + 1065353216));
                }
            } else {
                return (p1 + 1);
            }
        } else {
            return p1;
        }
    }

    public static java.util.Map J(kotlin.Pair p1)
    {
        p1.getClass();
        java.util.Map v1_2 = java.util.Collections.singletonMap(p1.g, p1.h);
        v1_2.getClass();
        return v1_2;
    }

    public static varargs java.util.Map K(kotlin.Pair[] p5)
    {
        if (p5.length <= 0) {
            return kotlin.collections.EmptyMap.g;
        } else {
            java.util.LinkedHashMap v0_2 = new java.util.LinkedHashMap(kotlin.collections.a.I(p5.length));
            int v1_2 = p5.length;
            int v2 = 0;
            while (v2 < v1_2) {
                Object v3_0 = p5[v2];
                v0_2.put(v3_0.g, v3_0.h);
                v2++;
            }
            return v0_2;
        }
    }

    public static java.util.Map L(java.util.Map p1, kotlin.Pair p2)
    {
        if (!p1.isEmpty()) {
            java.util.LinkedHashMap v0_2 = new java.util.LinkedHashMap(p1);
            v0_2.put(p2.g, p2.h);
            return v0_2;
        } else {
            return kotlin.collections.a.J(p2);
        }
    }

    public static java.util.Map M(java.util.ArrayList p5)
    {
        java.util.LinkedHashMap v0_0 = p5.size();
        if (v0_0 == null) {
            return kotlin.collections.EmptyMap.g;
        } else {
            int v1 = 0;
            if (v0_0 == 1) {
                return kotlin.collections.a.J(((kotlin.Pair) p5.get(0)));
            } else {
                java.util.LinkedHashMap v0_2 = new java.util.LinkedHashMap(kotlin.collections.a.I(p5.size()));
                int v2_2 = p5.size();
                while (v1 < v2_2) {
                    Object v3_0 = p5.get(v1);
                    v1++;
                    Object v3_1 = ((kotlin.Pair) v3_0);
                    v0_2.put(v3_1.g, v3_1.h);
                }
                return v0_2;
            }
        }
    }

    public static java.util.Map N(java.util.Map p2)
    {
        p2.getClass();
        Object v0_1 = p2.size();
        if (v0_1 == null) {
            return kotlin.collections.EmptyMap.g;
        } else {
            if (v0_1 == 1) {
                java.util.Map v2_3 = ((java.util.Map$Entry) p2.entrySet().iterator().next());
                java.util.Map v2_5 = java.util.Collections.singletonMap(v2_3.getKey(), v2_3.getValue());
                v2_5.getClass();
                return v2_5;
            } else {
                return new java.util.LinkedHashMap(p2);
            }
        }
    }

    public static java.util.LinkedHashMap O(java.util.Map p1)
    {
        p1.getClass();
        return new java.util.LinkedHashMap(p1);
    }
}
