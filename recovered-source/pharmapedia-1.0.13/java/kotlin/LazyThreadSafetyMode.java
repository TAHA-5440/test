// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin;
public final enum class LazyThreadSafetyMode extends java.lang.Enum {
    public static final enum kotlin.LazyThreadSafetyMode g;
    public static final enum kotlin.LazyThreadSafetyMode h;
    public static final synthetic kotlin.LazyThreadSafetyMode[] i;

    static LazyThreadSafetyMode()
    {
        kotlin.LazyThreadSafetyMode[] v0_2 = new kotlin.LazyThreadSafetyMode("SYNCHRONIZED", 0);
        kotlin.LazyThreadSafetyMode v1_2 = new kotlin.LazyThreadSafetyMode("PUBLICATION", 1);
        kotlin.LazyThreadSafetyMode.g = v1_2;
        kotlin.LazyThreadSafetyMode v2_0 = new kotlin.LazyThreadSafetyMode("NONE", 2);
        kotlin.LazyThreadSafetyMode.h = v2_0;
        kotlin.LazyThreadSafetyMode[] v0_1 = new kotlin.LazyThreadSafetyMode[] {v0_2, v1_2, v2_0});
        kotlin.LazyThreadSafetyMode.i = v0_1;
        kotlin.enums.a.a(v0_1);
        return;
    }

    public static kotlin.LazyThreadSafetyMode valueOf(String p1)
    {
        return ((kotlin.LazyThreadSafetyMode) Enum.valueOf(kotlin.LazyThreadSafetyMode, p1));
    }

    public static kotlin.LazyThreadSafetyMode[] values()
    {
        return ((kotlin.LazyThreadSafetyMode[]) kotlin.LazyThreadSafetyMode.i.clone());
    }
}
