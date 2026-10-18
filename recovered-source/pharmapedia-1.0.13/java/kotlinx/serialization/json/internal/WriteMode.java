// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.serialization.json.internal;
public final enum class WriteMode extends java.lang.Enum {
    public static final enum kotlinx.serialization.json.internal.WriteMode i;
    public static final enum kotlinx.serialization.json.internal.WriteMode j;
    public static final enum kotlinx.serialization.json.internal.WriteMode k;
    public static final enum kotlinx.serialization.json.internal.WriteMode l;
    public static final synthetic kotlinx.serialization.json.internal.WriteMode[] m;
    public static final synthetic na.a n;
    public final char g;
    public final char h;

    static WriteMode()
    {
        na.a v0_3 = new kotlinx.serialization.json.internal.WriteMode("OBJ", 0, 123, 125);
        kotlinx.serialization.json.internal.WriteMode.i = v0_3;
        kotlinx.serialization.json.internal.WriteMode v1_1 = new kotlinx.serialization.json.internal.WriteMode("LIST", 1, 91, 93);
        kotlinx.serialization.json.internal.WriteMode.j = v1_1;
        kotlinx.serialization.json.internal.WriteMode v2_1 = new kotlinx.serialization.json.internal.WriteMode("MAP", 2, 123, 125);
        kotlinx.serialization.json.internal.WriteMode.k = v2_1;
        kotlinx.serialization.json.internal.WriteMode v3_1 = new kotlinx.serialization.json.internal.WriteMode("POLY_OBJ", 3, 91, 93);
        kotlinx.serialization.json.internal.WriteMode.l = v3_1;
        na.a v0_1 = new kotlinx.serialization.json.internal.WriteMode[] {v0_3, v1_1, v2_1, v3_1});
        kotlinx.serialization.json.internal.WriteMode.m = v0_1;
        kotlinx.serialization.json.internal.WriteMode.n = kotlin.enums.a.a(v0_1);
        return;
    }

    public WriteMode(String p1, int p2, char p3, char p4)
    {
        super(p1, p2);
        super.g = p3;
        super.h = p4;
        return;
    }

    public static kotlinx.serialization.json.internal.WriteMode valueOf(String p1)
    {
        return ((kotlinx.serialization.json.internal.WriteMode) Enum.valueOf(kotlinx.serialization.json.internal.WriteMode, p1));
    }

    public static kotlinx.serialization.json.internal.WriteMode[] values()
    {
        return ((kotlinx.serialization.json.internal.WriteMode[]) kotlinx.serialization.json.internal.WriteMode.m.clone());
    }
}
