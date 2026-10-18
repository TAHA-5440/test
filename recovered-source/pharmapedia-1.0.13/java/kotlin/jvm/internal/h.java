// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.jvm.internal;
public abstract class h {
    public static final kotlin.jvm.internal.i a;

    static h()
    {
        try {
            kotlin.jvm.internal.i v0_0 = ((kotlin.jvm.internal.i) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance());
        } catch (IllegalAccessException) {
        }
        if (v0_0 == null) {
            v0_0 = new kotlin.jvm.internal.i();
        }
        kotlin.jvm.internal.h.a = v0_0;
        return;
    }

    public static kotlin.jvm.internal.b a(Class p1)
    {
        kotlin.jvm.internal.h.a.getClass();
        return new kotlin.jvm.internal.b(p1);
    }
}
