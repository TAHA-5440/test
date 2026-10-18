// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jc;
public abstract class j {

    public static boolean a()
    {
        int v0_0 = org.conscrypt.Conscrypt.version();
        if (v0_0 != 0) {
            if (v0_0.major() == 2) {
                if (v0_0.minor() == 1) {
                    if (v0_0.patch() < 0) {
                        return 0;
                    }
                } else {
                    if (v0_0.minor() <= 1) {
                        return 0;
                    }
                }
            } else {
                if (v0_0.major() <= 2) {
                    return 0;
                }
            }
            return 1;
        }
        return 0;
    }
}
