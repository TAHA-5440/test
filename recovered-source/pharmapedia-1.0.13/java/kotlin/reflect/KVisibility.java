// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.reflect;
public final enum class KVisibility extends java.lang.Enum {
    public static final synthetic kotlin.reflect.KVisibility[] g;

    static KVisibility()
    {
        kotlin.reflect.KVisibility[] v0_1 = new kotlin.reflect.KVisibility[] {new kotlin.reflect.KVisibility("PUBLIC", 0), new kotlin.reflect.KVisibility("PROTECTED", 1), new kotlin.reflect.KVisibility("INTERNAL", 2), new kotlin.reflect.KVisibility("PRIVATE", 3)});
        kotlin.reflect.KVisibility.g = v0_1;
        kotlin.enums.a.a(v0_1);
        return;
    }

    public static kotlin.reflect.KVisibility valueOf(String p1)
    {
        return ((kotlin.reflect.KVisibility) Enum.valueOf(kotlin.reflect.KVisibility, p1));
    }

    public static kotlin.reflect.KVisibility[] values()
    {
        return ((kotlin.reflect.KVisibility[]) kotlin.reflect.KVisibility.g.clone());
    }
}
