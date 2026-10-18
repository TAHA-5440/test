// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class l implements java.util.Comparator {

    public final int compare(Object p5, Object p6)
    {
        ((String) p5).getClass();
        ((String) p6).getClass();
        int v0_1 = Math.min(((String) p5).length(), ((String) p6).length());
        int v1_0 = 4;
        while (v1_0 < v0_1) {
            char v2 = ((String) p5).charAt(v1_0);
            char v3 = ((String) p6).charAt(v1_0);
            if (v2 == v3) {
                v1_0++;
            } else {
                if (kotlin.jvm.internal.f.c(v2, v3) < 0) {
                    return -1;
                }
            }
            return 1;
        }
        int v5_2 = ((String) p5).length();
        int v6_2 = ((String) p6).length();
        if (v5_2 == v6_2) {
            return 0;
        } else {
            if (v5_2 < v6_2) {
                return -1;
            }
        }
        return 1;
    }
}
