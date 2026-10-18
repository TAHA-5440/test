// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public abstract class y {
    public static final gb.a0 a;

    static y()
    {
        try {
            gb.x v0_2 = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException) {
            v0_2 = 0;
        }
        gb.x v0_3;
        if (v0_2 == null) {
            v0_3 = 0;
        } else {
            v0_3 = Boolean.parseBoolean(v0_2);
        }
        gb.x v0_1;
        if (v0_3 != null) {
            v0_1 = lb.k.a;
            if (v0_1 == null) {
                v0_1 = gb.x.p;
            }
        } else {
            v0_1 = gb.x.p;
        }
        gb.y.a = v0_1;
        return;
    }
}
