// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines;
public final enum class CoroutineStart extends java.lang.Enum {
    public static final enum kotlinx.coroutines.CoroutineStart g;
    public static final enum kotlinx.coroutines.CoroutineStart h;
    public static final enum kotlinx.coroutines.CoroutineStart i;
    public static final enum kotlinx.coroutines.CoroutineStart j;
    public static final synthetic kotlinx.coroutines.CoroutineStart[] k;

    static CoroutineStart()
    {
        kotlinx.coroutines.CoroutineStart[] v0_2 = new kotlinx.coroutines.CoroutineStart("DEFAULT", 0);
        kotlinx.coroutines.CoroutineStart.g = v0_2;
        kotlinx.coroutines.CoroutineStart v1_2 = new kotlinx.coroutines.CoroutineStart("LAZY", 1);
        kotlinx.coroutines.CoroutineStart.h = v1_2;
        kotlinx.coroutines.CoroutineStart v2_1 = new kotlinx.coroutines.CoroutineStart("ATOMIC", 2);
        kotlinx.coroutines.CoroutineStart.i = v2_1;
        kotlinx.coroutines.CoroutineStart v3_2 = new kotlinx.coroutines.CoroutineStart("UNDISPATCHED", 3);
        kotlinx.coroutines.CoroutineStart.j = v3_2;
        kotlinx.coroutines.CoroutineStart[] v0_1 = new kotlinx.coroutines.CoroutineStart[] {v0_2, v1_2, v2_1, v3_2});
        kotlinx.coroutines.CoroutineStart.k = v0_1;
        kotlin.enums.a.a(v0_1);
        return;
    }

    public static kotlinx.coroutines.CoroutineStart valueOf(String p1)
    {
        return ((kotlinx.coroutines.CoroutineStart) Enum.valueOf(kotlinx.coroutines.CoroutineStart, p1));
    }

    public static kotlinx.coroutines.CoroutineStart[] values()
    {
        return ((kotlinx.coroutines.CoroutineStart[]) kotlinx.coroutines.CoroutineStart.k.clone());
    }
}
