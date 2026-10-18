// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.serialization.json;
public final enum class ClassDiscriminatorMode extends java.lang.Enum {
    public static final enum kotlinx.serialization.json.ClassDiscriminatorMode g;
    public static final synthetic kotlinx.serialization.json.ClassDiscriminatorMode[] h;

    static ClassDiscriminatorMode()
    {
        kotlinx.serialization.json.ClassDiscriminatorMode[] v0_2 = new kotlinx.serialization.json.ClassDiscriminatorMode("NONE", 0);
        kotlinx.serialization.json.ClassDiscriminatorMode v1_2 = new kotlinx.serialization.json.ClassDiscriminatorMode("ALL_JSON_OBJECTS", 1);
        kotlinx.serialization.json.ClassDiscriminatorMode v2_0 = new kotlinx.serialization.json.ClassDiscriminatorMode("POLYMORPHIC", 2);
        kotlinx.serialization.json.ClassDiscriminatorMode.g = v2_0;
        kotlinx.serialization.json.ClassDiscriminatorMode[] v0_1 = new kotlinx.serialization.json.ClassDiscriminatorMode[] {v0_2, v1_2, v2_0});
        kotlinx.serialization.json.ClassDiscriminatorMode.h = v0_1;
        kotlin.enums.a.a(v0_1);
        return;
    }

    public static kotlinx.serialization.json.ClassDiscriminatorMode valueOf(String p1)
    {
        return ((kotlinx.serialization.json.ClassDiscriminatorMode) Enum.valueOf(kotlinx.serialization.json.ClassDiscriminatorMode, p1));
    }

    public static kotlinx.serialization.json.ClassDiscriminatorMode[] values()
    {
        return ((kotlinx.serialization.json.ClassDiscriminatorMode[]) kotlinx.serialization.json.ClassDiscriminatorMode.h.clone());
    }
}
