// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package hb;
public final class b extends ka.a implements ka.e {
    private volatile Object _preHandler;

    public b()
    {
        super(gb.t.g);
        super._preHandler = super;
        return;
    }

    public final void d0(Throwable p4)
    {
        Thread v0_0 = android.os.Build$VERSION.SDK_INT;
        if ((26 <= v0_0) && (v0_0 < 28)) {
            Thread v0_1;
            Thread v0_4 = this._preHandler;
            Thread$UncaughtExceptionHandler v1_3 = 0;
            if (v0_4 == this) {
                try {
                    v0_1 = Thread.getDeclaredMethod("getUncaughtExceptionPreHandler", 0);
                } catch (Throwable) {
                    v0_1 = 0;
                    this._preHandler = v0_1;
                }
                if ((!reflect.Modifier.isPublic(v0_1.getModifiers())) || (!reflect.Modifier.isStatic(v0_1.getModifiers()))) {
                }
            } else {
                v0_1 = ((reflect.Method) v0_4);
            }
            Thread v0_2;
            if (v0_1 == null) {
                v0_2 = 0;
            } else {
                v0_2 = v0_1.invoke(0, 0);
            }
            if ((v0_2 instanceof Thread$UncaughtExceptionHandler)) {
                v1_3 = ((Thread$UncaughtExceptionHandler) v0_2);
            }
            if (v1_3 != null) {
                v1_3.uncaughtException(Thread.currentThread(), p4);
            }
        }
        return;
    }
}
