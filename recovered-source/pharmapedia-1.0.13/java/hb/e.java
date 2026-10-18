// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package hb;
public abstract class e {
    private static volatile android.view.Choreographer choreographer;

    static e()
    {
        try {
            hb.d v0_1 = new hb.d(hb.e.a(android.os.Looper.getMainLooper()), 0);
        } catch (hb.d v0_2) {
            v0_1 = new kotlin.Result$Failure(v0_2);
        }
        // Both branches of the condition point to the same code.
        // if (!(v0_1 instanceof kotlin.Result$Failure)) {
            return;
        // }
    }

    public static final android.os.Handler a(android.os.Looper p5)
    {
        if (android.os.Build$VERSION.SDK_INT < 28) {
            try {
                android.os.Handler v0_7 = new Class[3];
                v0_7[0] = android.os.Looper;
                v0_7[1] = android.os.Handler$Callback;
                v0_7[2] = Boolean.TYPE;
                android.os.Handler v5_3 = ((android.os.Handler) android.os.Handler.getDeclaredConstructor(v0_7).newInstance(new Object[] {p5, 0, Boolean.TRUE})));
                return v5_3;
            } catch (NoSuchMethodException) {
                return new android.os.Handler(v5_3);
            }
        } else {
            android.os.Handler v5_5 = android.os.Handler.getDeclaredMethod("createAsync", new Class[] {android.os.Looper})).invoke(0, new Object[] {p5}));
            v5_5.getClass();
            return ((android.os.Handler) v5_5);
        }
    }
}
