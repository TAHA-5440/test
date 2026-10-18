// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cb;
public abstract class i extends com.bumptech.glide.k {

    public static String p(cb.h p5, String p6)
    {
        p5.getClass();
        StringBuilder v0_1 = new StringBuilder();
        v0_1.append("");
        String v5_2 = p5.iterator();
        int v2 = 0;
        while (v5_2.hasNext()) {
            Object v3_0 = v5_2.next();
            v2++;
            if (v2 > 1) {
                v0_1.append(p6);
            }
            com.bumptech.glide.d.a(v0_1, v3_0, 0);
        }
        v0_1.append("");
        return v0_1.toString();
    }

    public static java.util.List q(cb.h p2)
    {
        java.util.List v2_1 = p2.iterator();
        if (v2_1.hasNext()) {
            Object v0_3 = v2_1.next();
            if (v2_1.hasNext()) {
                java.util.ArrayList v1_1 = new java.util.ArrayList();
                v1_1.add(v0_3);
                while (v2_1.hasNext()) {
                    v1_1.add(v2_1.next());
                }
                return v1_1;
            } else {
                return com.bumptech.glide.e.l(v0_3);
            }
        } else {
            return kotlin.collections.EmptyList.g;
        }
    }
}
