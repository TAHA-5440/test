// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package pc;
public abstract class n {
    public static final java.util.logging.Logger a;

    static n()
    {
        pc.n.a = java.util.logging.Logger.getLogger("okio.Okio");
        return;
    }

    public static final boolean a(AssertionError p2)
    {
        if (p2.getCause() != null) {
            int v2_1;
            int v2_3 = p2.getMessage();
            if (v2_3 == 0) {
                v2_1 = 0;
            } else {
                v2_1 = db.i.T(v2_3, "getsockname failed", 0);
            }
            if (v2_1 != 0) {
                return 1;
            }
        }
        return 0;
    }
}
