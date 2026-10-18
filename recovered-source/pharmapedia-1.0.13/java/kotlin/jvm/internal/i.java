// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.jvm.internal;
public final class i {

    public static String a(kotlin.jvm.internal.e p1)
    {
        String v1_2 = p1.getClass().getGenericInterfaces()[0].toString();
        if (v1_2.startsWith("kotlin.jvm.functions.")) {
            v1_2 = v1_2.substring(21);
        }
        return v1_2;
    }
}
