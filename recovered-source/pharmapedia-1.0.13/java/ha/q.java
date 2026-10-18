// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ha;
public abstract class q extends kotlin.collections.a {

    public static java.util.List P(java.util.Map p4)
    {
        p4.getClass();
        kotlin.Pair v1_3 = kotlin.collections.EmptyList.g;
        if (p4.size() != 0) {
            Object v0_3 = p4.entrySet().iterator();
            if (v0_3.hasNext()) {
                kotlin.Pair v1_1 = ((java.util.Map$Entry) v0_3.next());
                if (v0_3.hasNext()) {
                    java.util.ArrayList v2_3 = new java.util.ArrayList(p4.size());
                    v2_3.add(new kotlin.Pair(v1_1.getKey(), v1_1.getValue()));
                    do {
                        boolean v4_5 = ((java.util.Map$Entry) v0_3.next());
                        v2_3.add(new kotlin.Pair(v4_5.getKey(), v4_5.getValue()));
                    } while(v0_3.hasNext());
                    return v2_3;
                } else {
                    return com.bumptech.glide.e.l(new kotlin.Pair(v1_1.getKey(), v1_1.getValue()));
                }
            } else {
                return v1_3;
            }
        } else {
            return v1_3;
        }
    }
}
